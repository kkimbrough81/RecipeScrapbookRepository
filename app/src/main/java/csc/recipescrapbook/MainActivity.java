package csc.recipescrapbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void viewRecipes(View view) {
        Intent intent = new Intent(this, ViewRecipes.class);
        startActivity(intent);
    }
    //recieving data from camera
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            ImageView imgView = (ImageView)findViewById(R.id.imageView);
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            ByteArrayOutputStream bStream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, bStream);
            byte[] byteArray = bStream.toByteArray();


            Intent intent = new Intent(this, CaptureRecipe.class);
            intent.putExtra("data", byteArray);
            startActivity(intent);
            finish();
        }

    }

    public void captureRecipe(View view)
    {
        Intent takePictureIntent = new Intent((MediaStore.ACTION_IMAGE_CAPTURE));

        if(takePictureIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}