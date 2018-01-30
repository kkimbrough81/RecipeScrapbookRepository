package csc.recipescrapbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CaptureRecipe extends AppCompatActivity {
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);
        byte[] byteArray = getIntent().getByteArrayExtra("data");
        bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView imgView = (ImageView)findViewById(R.id.image);
        imgView.setImageBitmap(bmp);



    }


}
