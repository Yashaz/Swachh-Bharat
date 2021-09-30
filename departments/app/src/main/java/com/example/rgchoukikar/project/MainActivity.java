package com.example.rgchoukikar.project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button3);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button);


    }

    public void onClick(View v) {

        //View.OnClickListener listener = new View.OnClickListener() {

        //public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button3:
                Toast.makeText(MainActivity.this, "loginAdmin clicked",
                        Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(MainActivity.this,Admin.class);
                startActivity(intent1);
                break;

            case R.id.button2:
                Toast.makeText(MainActivity.this,"login clicked",
                        Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(MainActivity.this,NormalLogin.class);
                startActivity(intent2);
                break;


            case R.id.button:
                Toast.makeText(MainActivity.this,"register clicked",
                        Toast.LENGTH_LONG).show();
                Intent intent3 = new Intent(MainActivity.this,Register.class);
                startActivity(intent3);
                break;



            //Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            //startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);




        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
