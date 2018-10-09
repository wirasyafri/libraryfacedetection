package com.ti4e.wira.platform04library;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ImageView myImageView = (ImageView) findViewById(R.id.imgview);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inMutable=true;
                Bitmap myBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.jacksparrow,options
                );
//                FaceDetector faceDetector = new FaceDetector.Builder(getApplicationContext()).setTrackingEnabled(false).build();
//                if(!faceDetector.isOperational()){
//                    new AlertDialog.Builder(v.getContext()).setMessage("gabisa mroses").show();
//                    return;
//                }
//                Frame frame = new Frame.Builder().setBitmap((myBitmap)).build();
//                SparseArray<Face> faces = faceDetector.detect(frame);
//
//                Paint myRectPain = new Paint();
//                myRectPain.setStrokeWidth(10);
//                myRectPain.setColor(Color.RED);
//                myRectPain.setStyle(Paint.Style.STROKE);

                Emojifier emotik = new Emojifier();
                Bitmap tempBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.jacksparrow,options);
//                Canvas tempCanvas = new Canvas(tempBitmap);
//                tempCanvas.drawBitmap(myBitmap, 0, 0, null);
//                for (int i=0;i<faces.size();i++){
//                    Face thisFace = faces.valueAt(i);
//                    float x1 = thisFace.getPosition().x;
//                    float y1 = thisFace.getPosition().y;
//                    float x2 =x1+ thisFace.getWidth();
//                    float y2 =y1+ thisFace.getHeight();
//                    tempCanvas.drawRoundRect(new RectF(x1,y1,x2,y2),2,2,myRectPain);
//                }
//                myImageView.setImageDrawable(new BitmapDrawable(getResources(),tempBitmap));
                myImageView.setImageBitmap(emotik.detectFaces(getApplicationContext(),tempBitmap));
            }
        });
    }
}
