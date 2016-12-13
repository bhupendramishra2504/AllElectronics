package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import com.firebase.client.AuthData;
import android.widget.Toast;
import android.content.SharedPreferences;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import android.app.ProgressDialog;
import android.app.AlertDialog;

public class Login_activity extends Activity {
    Button login,signup;
    EditText email,password;
    CheckBox cb;
    boolean remember;
    private ProgressDialog mAuthProgressDialog;
    Firebase mFirebaseRef;
    private AuthData mAuthData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        signup=(Button)findViewById(R.id.lsignup);
        login = (Button) findViewById(R.id.llogin);
        email=(EditText)findViewById(R.id.lemail);
        password=(EditText)findViewById(R.id.lpassword);



        cb=(CheckBox)findViewById(R.id.remember);
        mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));
        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Connecting with server");
        mAuthProgressDialog.setMessage("Authenticating with AllElectronics...");
        mAuthProgressDialog.setCancelable(false);
        restore_previous_state();

        signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(Login_activity.this, Signup_activity.class);
                startActivity(intent);
            }

        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginWithPassword();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_activity, menu);
        return true;
    }


    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private class AuthResultHandler implements Firebase.AuthResultHandler {

        private final String provider;

        public AuthResultHandler(String provider) {
            this.provider = provider;
        }

        @Override
        public void onAuthenticated(AuthData authData) {
            mAuthProgressDialog.hide();
            mAuthProgressDialog.dismiss();
            //Log.i(TAG, provider + " auth successful");
            setAuthenticatedUser(authData);

            remember = ((CheckBox) findViewById(R.id.remember)).isChecked();
            save_username_password(remember);

            Toast.makeText(Login_activity.this,"Signed in successfully as : "+email.getText().toString(), Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Login_activity.this,Start_activity.class);
            intent.putExtra("user", email.getText().toString());
            startActivity(intent);
            finish();

        }

        @Override
        public void onAuthenticationError(FirebaseError firebaseError) {
            mAuthProgressDialog.hide();
            showErrorDialog(firebaseError.toString());
        }
    }

    public void loginWithPassword() {
        if(email.getText().toString()!=null && password.getText().toString()!=null) {
            mAuthProgressDialog.show();
            mFirebaseRef.authWithPassword(email.getText().toString()+"@allelectronics.com", password.getText().toString(), new AuthResultHandler("password"));
        }
        else
            Toast.makeText(Login_activity.this,"Invalid username or password",Toast.LENGTH_LONG).show();
    }

    private void setAuthenticatedUser(AuthData authData) {
        if (authData != null) {
            /* Hide all the login buttons */
        }


        this.mAuthData = authData;
        /* invalidate options menu to hide/show the logout button */
        //supportInvalidateOptionsMenu();
    }


    private void save_username_password(boolean check)
    {
        if(check)
        {
            SharedPreferences.Editor editor = getSharedPreferences("Allelectronics", MODE_PRIVATE).edit();
            editor.putString("email", email.getText().toString());
            editor.putString("password", password.getText().toString());
            editor.putBoolean("remember", true);
            editor.commit();
        }
        else
        {
            SharedPreferences.Editor editor = getSharedPreferences("Allelectronics", MODE_PRIVATE).edit();
            editor.putString("email", "");
            editor.putString("password", "");
            editor.putBoolean("remember",false);
            editor.commit();
        }
    }

    private void restore_previous_state()
    {
        SharedPreferences prefs = getSharedPreferences("Allelectronics", MODE_PRIVATE);
        String username = prefs.getString("email", null);
        String password1 =prefs.getString("password", null);
        boolean remember=prefs.getBoolean("remember",false);
        if(remember)
        {
            if(username != null && password1 != null)
            {
                email.setText(username);
                password.setText(password1);
                ((CheckBox) findViewById(R.id.remember)).setChecked(true);

            }
        }
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
