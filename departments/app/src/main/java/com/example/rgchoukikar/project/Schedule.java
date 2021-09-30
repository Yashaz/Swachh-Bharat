package com.example.rgchoukikar.project;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
public class Schedule extends ActionBarActivity {

    public Integer[] array = new Integer[]{1, 2, 3, 4,7,8};
    public Integer[] deptarr = new Integer[6];
    public Integer[] montharr = new Integer[6];

    public EditText dept1 ;
    public  EditText dept2 ;
    public EditText dept3 ;
    public  EditText dept4 ;
    public EditText dept5 ;
    public EditText dept6 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        dept1 = (EditText)findViewById(R.id.editText);
        dept2 = (EditText)findViewById(R.id.editText2);
        dept3 = (EditText)findViewById(R.id.editText3);
        dept4 = (EditText)findViewById(R.id.editText4);
        dept5 = (EditText)findViewById(R.id.editText5);
        dept6 = (EditText)findViewById(R.id.editText6);


        schedulelist();
    }



    public void schedulelist() {
        int i, j;
        // Random random = new Random(System.nanoTime());

        //new Random(System.nanoTime());

        //int randomInt = random.nextInt(1000000000);
        /*for (i=0;i<100;i++){
            array[i] = random.nextInt(100000) + 1;

        }*/

        //it = 1 cs =2 eee=3 ece=4 mt=5 cv=6


        String month = null;
        Collections.shuffle(Arrays.asList(array));
        for (i = 0; i < array.length; i++) {
            montharr[i] = array[i];
            if (montharr[i] == 1) {
                month = "Jan";
            }
            if (montharr[i] == 2) {
                month = "Feb";
            }
            if (montharr[i] == 3) {
                month = "Mar";
            }
            if (montharr[i] == 4) {
                month = "Apr";
            }
            if (montharr[i] == 7) {
                month = "July";
            }
            if (montharr[i] == 8) {
                month = "Aug";
            }

            switch (i + 1) {
                case 1:
                    dept1.setText(month, TextView.BufferType.EDITABLE);
                    break;
                case 2:
                    dept2.setText(month, TextView.BufferType.EDITABLE);
                    break;
                case 3:
                    dept3.setText(month, TextView.BufferType.EDITABLE);
                    break;
                case 4:
                    dept4.setText(month, TextView.BufferType.EDITABLE);
                    break;
                case 5:
                    dept5.setText(month, TextView.BufferType.EDITABLE);
                    break;
                case 6:
                    dept6.setText(month, TextView.BufferType.EDITABLE);
                    break;
            }

        }
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_schedule, menu);
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
