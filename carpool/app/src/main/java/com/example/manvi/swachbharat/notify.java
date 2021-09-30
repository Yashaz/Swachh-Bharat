package com.example.manvi.swachbharat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class notify extends AppCompatActivity {


    private EditText  no_of_pass,start,dest;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        start = (EditText)findViewById(R.id.textview2);
        dest = (EditText)findViewById(R.id.textview3);
        no_of_pass = (EditText)findViewById(R.id.textview4);
        btn= (Button)findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG: ASYNCTASK", "MESSAGE: http://10.50.1.205/carpool.php?name=" + name.getText().toString() + "&contact=" + contact.getText().toString() + "&start=" + start.getText().toString() + "&dest" + dest.getText().toString());
                new DataTask().execute("http://10.50.1.205/carpool.php?name=" + name.getText().toString() + "&contact=" + contact.getText().toString() + "&start=" + start.getText().toString() + "&dest=" +dest.getText().toString() + "");

            }
        });
    }

}
