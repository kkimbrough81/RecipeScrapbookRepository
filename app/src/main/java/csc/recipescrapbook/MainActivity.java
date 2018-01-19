package csc.recipescrapbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void viewRecipes(View view) {
        Intent intent = new Intent(this, ViewRecipes.class);
        startActivity(intent);
    }

    public void captureRecipe(View view)
    {
        Intent intent = new Intent(this, CaptureRecipe.class);
        startActivity(intent);
    }
}