package com.example.aaron.budgeapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;
import com.google.firebase.ml.vision.text.RecognizedLanguage;

import java.util.List;

public class TextRecognitionActivity extends AppCompatActivity {

    private final int TEXT_RECO_REQ_CODE=100;
    private ImageView imageView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_recognition);

        imageView = findViewById(R.id.imgResult);
        textView = findViewById(R.id.tvResult);
    }


    public void textReco(View view){

        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,TEXT_RECO_REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TEXT_RECO_REQ_CODE){

            if(resultCode == RESULT_OK){
                Bitmap photo = (Bitmap)data.getExtras().get("data");
                textRecognization(photo);
                imageView.setImageBitmap(photo);


            }else if (resultCode==RESULT_CANCELED){
                Toast.makeText( this, "Operation Cancelled by User", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(  this, "Failed to Capture Image", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void textRecognization(Bitmap photo){
        final FirebaseVisionImage image = FirebaseVisionImage.fromBitmap(photo);

        FirebaseVisionTextRecognizer textRecognizer = FirebaseVision.getInstance()
                .getOnDeviceTextRecognizer();

        textRecognizer.processImage(image)
                .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                    //@Override
                    public void onSuccess(FirebaseVisionText result) {

                        String resultText = result.getText();

                        Toast.makeText(TextRecognitionActivity.this, "Recognized text is: "+ resultText, Toast.LENGTH_SHORT).show();

                        for (FirebaseVisionText.TextBlock block: result.getTextBlocks()) {
                            String blockText = block.getText();
                            Float blockConfidence = block.getConfidence();
                            List<RecognizedLanguage> blockLanguages = block.getRecognizedLanguages();
                            Point[] blockCornerPoints = block.getCornerPoints();
                            Rect blockFrame = block.getBoundingBox();
                            for (FirebaseVisionText.Line line: block.getLines()) {
                                String lineText = line.getText();
                                Float lineConfidence = line.getConfidence();
                                List<RecognizedLanguage> lineLanguages = line.getRecognizedLanguages();
                                Point[] lineCornerPoints = line.getCornerPoints();
                                Rect lineFrame = line.getBoundingBox();
                                for (FirebaseVisionText.Element element: line.getElements()) {

                                    Toast.makeText(TextRecognitionActivity.this, "Element: "+ element.getText(), Toast.LENGTH_SHORT).show();

                                    String elementText = element.getText();
                                    Float elementConfidence = element.getConfidence();
                                    List<RecognizedLanguage> elementLanguages = element.getRecognizedLanguages();
                                    Point[] elementCornerPoints = element.getCornerPoints();
                                    Rect elementFrame = element.getBoundingBox();



                                }
                            }

                        }
                        textView.setText(resultText);



                    }
                })
                .addOnFailureListener(
                        new OnFailureListener() {
                            //@Override
                            public void onFailure(@NonNull Exception e) {

                                Toast.makeText(TextRecognitionActivity.this, "Failed to Recognize Text from Image", Toast.LENGTH_SHORT).show();
                            }
                        });
    }



}
