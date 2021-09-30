  package com.example.manvi.swachbharat;

import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


 public class MainActivity extends AppCompatActivity {


    private EditText  name,contact,start,dest;
     private Button btn;
    private TextView carpool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        name = (EditText)findViewById(R.id.textview1);
        contact = (EditText)findViewById(R.id.textview2);
          start = (EditText)findViewById(R.id.textview3);
        dest = (EditText)findViewById(R.id.textview4);
        btn= (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG: ASYNCTASK", "MESSAGE: http://10.50.1.205/carpool.php?name=" + name.getText().toString() + "&contact=" + contact.getText().toString() + "&start=" + start.getText().toString() + "&dest" + dest.getText().toString());
                new DataTask().execute("http://10.50.1.205/carpool.php?name=" + name.getText().toString() + "&contact=" + contact.getText().toString() + "&start=" + start.getText().toString() + "&dest=" +dest.getText().toString() + "");

             }
        });

        register();

    }



     private void register() {
         if (checkPlayServices()) {
             gcm = GoogleCloudMessaging.getInstance(this);
             try {
                 regId = getRegistrationId(context);
             } catch (Exception e) {
                 e.printStackTrace();
             }

             if (regId.isEmpty()) {
                 registerInBackground();
             } else {
                 toastUser("Registration ID already exists: " + regId);
             }
         } else {
             Log.e(TAG, "No valid Google Play Services APK found.");
         }
     }

     private boolean checkPlayServices() {
         int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
         if (resultCode != ConnectionResult.SUCCESS) {
             if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                 GooglePlayServicesUtil.getErrorDialog(resultCode, this, PLAY_SERVICES_RESOLUTION_REQUEST).show();
             } else {
                 Log.e(TAG, "This device is not supported.");
                 finish();
             }
             return false;
         }
         return true;
     }

     private String getRegistrationId(Context context) throws Exception {
         final SharedPreferences prefs =
                 getSharedPreferences(MainActivity.class.getSimpleName(), Context.MODE_PRIVATE);
         String registrationId = prefs.getString(PROPERTY_REG_ID, "");
         if (registrationId.isEmpty()) {
             return "";
         }

         return registrationId;
     }

     private void registerInBackground() {
         new AsyncTask() {
             @Override
             protected String doInBackground(Object[] params) {
                 String msg;
                 try {
                     if (gcm == null) {
                         gcm = GoogleCloudMessaging.getInstance(context);
                     }
                     regId = gcm.register(SENDER_ID);
                     msg = "Device registered, registration ID: " + regId;

                     sendRegistrationId(regId);

                     storeRegistrationId(context, regId);
                     Log.i(TAG, msg);
                 } catch (Exception ex) {
                     msg = "Error :" + ex.getMessage();
                     Log.e(TAG, msg);
                 }
                 return msg;
             }
         }.execute();
     }

     private void storeRegistrationId(Context context, String regId) throws Exception {
         final SharedPreferences prefs =
                 getSharedPreferences(MainActivity.class.getSimpleName(), Context.MODE_PRIVATE);
         SharedPreferences.Editor editor = prefs.edit();
         editor.putString(PROPERTY_REG_ID, regId);
         editor.apply();



         class DataTask extends AsyncTask<String, Void, List<String>> {

        private ProgressDialog dialog;

        public DataTask() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("CarPool");
             dialog.setMessage("Your car pool proposal is being created...");
            dialog.setCancelable(false);
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected List<String> doInBackground(String... params) {
            // Long Running Operation

            try {
                URL webURL = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) webURL
                        .openConnection();

                // Setting parameters on Connection Object
                connection.setRequestMethod("GET");

                connection.setDoInput(true);

                // connection to server
                connection.connect();

                int responseCode = connection.getResponseCode();

                if (responseCode == HttpURLConnection.HTTP_OK) {


                    Log.d("TAG: ASYNCTASK", "MESSAGE: OK ");


                }

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return null;
        }

        private List<String> parseJSON(String data) throws JSONException {

            List<String> users = new ArrayList<String>();


            JSONArray contactsArray = new JSONArray(data);
            for (int i = 0; i < contactsArray.length(); i++) {
                JSONObject userJsonObject = contactsArray.getJSONObject(i);
                users.add(userJsonObject.getString("ctrycode"));
            }


            return users;
        }

        private String convertInputStreamToString(InputStream inputStream)
                throws IOException {

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    inputStream));
            StringBuilder builder = new StringBuilder();
            String line = new String();

            while ((line = reader.readLine()) != null) {
                builder = builder.append(line);
            }

            String output = builder.toString();
            return output;
        }

        @Override
        protected void onPostExecute(List<String> result) {

            super.onPostExecute(result);
            // Update UI
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            // simpleListView.setAdapter(new ArrayAdapter<String>(
            // MainActivity.this, android.R.layout.simple_list_item_1,
            // result));

            // simpleListView.setAdapter(new CustomAdapter(MainActivity.this,
            //       result));

            Toast.makeText(MainActivity.this,"Your carpool proposal has been created",Toast.LENGTH_LONG).show();
            createNotification(56, R.mipmap.ic_launcher, "New CarPool Proposal","Someone has proposed a new carPool");


        }

    }

     private void createNotification(int nId, int iconRes, String title, String body) {
         NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                 this).setSmallIcon(iconRes)
                 .setContentTitle(title)
                 .setContentText(body);

         NotificationManager mNotificationManager =
                 (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
         // mId allows you to update the notification later on.
         mNotificationManager.notify(nId, mBuilder.build());
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
