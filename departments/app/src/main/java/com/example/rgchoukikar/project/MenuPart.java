package com.example.rgchoukikar.project;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MenuPart extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_part);
        Button button = (Button)findViewById(R.id.button4);
        Button button2 = (Button)findViewById(R.id.button5);
        Button button3 = (Button)findViewById(R.id.button6);
        Button button4 = (Button)findViewById(R.id.button7);
        Button button5 = (Button)findViewById(R.id.button8);

    }

    public void onClick1(View v) {

        //View.OnClickListener listener = new View.OnClickListener() {

        //public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button4:
                Toast.makeText(MenuPart.this, "loginAdmin clicked",
                        Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(MenuPart.this,List.class);
                startActivity(intent1);
                break;

            case R.id.button5:
                Toast.makeText(MenuPart.this,"login clicked",
                        Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(MenuPart.this,Schedule.class);
                startActivity(intent2);
                break;


            //Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            //startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);




        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_part, menu);
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
