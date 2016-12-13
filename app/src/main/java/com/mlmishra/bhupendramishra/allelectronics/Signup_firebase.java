package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.util.Log;
import com.firebase.client.Firebase;
import com.firebase.client.AuthData;
import android.app.ProgressDialog;
import com.firebase.client.Firebase.AuthResultHandler;
import com.firebase.client.FirebaseError;
import android.app.AlertDialog;
import java.util.Map;
import com.firebase.client.Firebase.ResultHandler;
import android.content.SharedPreferences;
import android.app.Activity;

public class Signup_firebase extends Activity {

    EditText username,email,password,confirm_password;
    String s_user,s_email,s_password,s_cpassword;
    Button signup;

    /* A dialog that is presented until the Firebase authentication finished. */
    private ProgressDialog mAuthProgressDialog;

    /* A reference to the Firebase */
    private Firebase mFirebaseRef;

    /* Data from the authenticated user */
    private AuthData mAuthData;

    /* Listener for Firebase session changes */
    private Firebase.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getSupportActionBar().hide();
        setContentView(R.layout.activity_signup_firebase);
        username=(EditText)findViewById(R.id.user);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        confirm_password=(EditText)findViewById(R.id.cpassword);
        signup=(Button)findViewById(R.id.signup);

        mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));

        /* Setup the progress dialog that is displayed later when authenticating with Firebase */

        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Loading");
        mAuthProgressDialog.setMessage("Authenticating with AllElectronics Server...");
        mAuthProgressDialog.setCancelable(false);




    signup.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            s_user = username.getText().toString();
            s_email = email.getText().toString();
            s_password = password.getText().toString();
            s_cpassword = confirm_password.getText().toString();
            Log.d("username", s_user);



            if (s_user.equals("")) {
                Toast.makeText(Signup_firebase.this, "Invalid username", Toast.LENGTH_LONG).show();
            } else {
                if (s_password.equals(s_cpassword)) {

                    signup();

                } else {
                    Toast.makeText(Signup_firebase.this, "Password dosent matches", Toast.LENGTH_LONG).show();
                }
            }


        }

    });


    }







    public void signup() {
        mAuthProgressDialog.show();
        mFirebaseRef.createUser(s_email, s_password, new ResultHandler());
    }




    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signup_firebase, menu);
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



    private class ResultHandler implements Firebase.ResultHandler {

        //private final String provider;

        public ResultHandler() {

        }

        @Override
        public void onSuccess() {
            mAuthProgressDialog.hide();
            SharedPreferences.Editor editor = getSharedPreferences("ChatPrefs", MODE_PRIVATE).edit();
            editor.putString("name", s_user);
            editor.putString("email", s_email);
            editor.putString("password", s_password);
            editor.commit();
            Toast.makeText(Signup_firebase.this, "USER CREATED SUCCESSFULLY", Toast.LENGTH_LONG).show();
            //Intent intent = new Intent(Signup_firebase.this, Chat_activity.class);
            //startActivity(intent);
            //finish();
        }

        @Override
        public void onError(FirebaseError firebaseError) {
            mAuthProgressDialog.hide();
            showErrorDialog(firebaseError.toString());
        }
    }

}
