package com.mlmishra.bhupendramishra.allelectronics;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.Activity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Map;
import java.util.HashMap;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.DataSnapshot;
import android.content.DialogInterface;

public class Signup_activity extends Activity {

    EditText username,email,password,confirm_password;
    Button signup;
    boolean tcaccepted;
    private ProgressDialog mAuthProgressDialog;
    private Firebase mFirebaseRef;
    String separator = System.getProperty("line.separator");
    int offer_counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activity);

        username=(EditText)findViewById(R.id.suser1);
        email=(EditText)findViewById(R.id.suser);
        password=(EditText)findViewById(R.id.spassword);
        confirm_password=(EditText)findViewById(R.id.sconfirmpassword);
        signup=(Button)findViewById(R.id.ssignup);

        mAuthProgressDialog = new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Loading");
        mAuthProgressDialog.setMessage("Authenticating with AllElectronics Server...");
        mAuthProgressDialog.setCancelable(false);

        mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));
        signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

               tcaccepted=((CheckBox) findViewById(R.id.tc)).isChecked();



                if (email.getText().toString().equals("") | password.getText().toString().equals("") | !tcaccepted) {
                    Toast.makeText(Signup_activity.this, "Invalid username/password/accept T&C", Toast.LENGTH_LONG).show();
                } else {
                    if (password.getText().toString().equals(confirm_password.getText().toString())) {

                        signup();

                    } else {
                        Toast.makeText(Signup_activity.this, "Password dosent matches", Toast.LENGTH_LONG).show();
                    }
                }


            }

        });







}

    public void signup() {
        mAuthProgressDialog.show();
        mFirebaseRef.createUser(username.getText().toString()+"@allelectronics.com", password.getText().toString(), new ResultHandler());
    }


    private class ResultHandler implements Firebase.ResultHandler {

        //private final String provider;

        public ResultHandler() {

        }

        @Override
        public void onSuccess() {
            mAuthProgressDialog.hide();
            add_user_data();

        }

        @Override
        public void onError(FirebaseError firebaseError) {
            mAuthProgressDialog.hide();
            showErrorDialog(firebaseError.toString());
        }
    }

    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Username Alreasy Exists")
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signup_activity, menu);
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

    public void add_user_data()
    {

        Firebase user_data = mFirebaseRef.child("users").child(String.valueOf(username.getText().toString()));

        Map<String, Object> user_password = new HashMap<String, Object>();
        user_password.put("password", password.getText().toString());
        user_data.updateChildren(user_password);

        Map<String, Object> user_email = new HashMap<String, Object>();
        user_email.put("email", email.getText().toString());
        user_data.updateChildren(user_email);

        Map<String, Object> user_list = new HashMap<String, Object>();
        user_list.put(username.getText().toString(),password.getText().toString());
        mFirebaseRef.child("userlist").updateChildren(user_list);

        check_offer();

    }

    public void check_offer()
    {
        Firebase u_ref = mFirebaseRef.child("offer_counter");
        u_ref.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot snapshot) {

               offer_counter=Integer.parseInt(snapshot.getValue().toString());
                offer_counter++;
                if(offer_counter<=100)
                {


                    Firebase ref1=mFirebaseRef.child("users").child(username.getText().toString()).child("offers");
                    ref1.setValue("1");
                    new AlertDialog.Builder(Signup_activity.this)
                            .setTitle("Congratulations")
                            .setMessage("You have got free offer for 1 project:-" + separator + "Submit your project after login" + separator + "We will review it and if project valuation is less thsn 20,000 INR we will approve it and timeline of project will be added in Approved Project option")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    mFirebaseRef.child("offer_counter").setValue(String.valueOf(offer_counter));
                                    Toast.makeText(Signup_activity.this, "USER CREATED SUCCESSFULLY", Toast.LENGTH_LONG).show();
                                    mAuthProgressDialog.dismiss();
                                    Intent intent = new Intent(Signup_activity.this, Login_activity.class);
                                    startActivity(intent);
                                    finish();
                                    // continue with delete
                                }
                            })
                            .show();


                }
                else
                {
                    Firebase ref1=mFirebaseRef.child("users").child(username.getText().toString()).child("offers");
                    mFirebaseRef.child("offer_counter").setValue(String.valueOf(offer_counter));
                    ref1.setValue("0");
                    Toast.makeText(Signup_activity.this, "USER CREATED SUCCESSFULLY", Toast.LENGTH_LONG).show();
                    mAuthProgressDialog.dismiss();
                    Intent intent = new Intent(Signup_activity.this, Login_activity.class);
                    startActivity(intent);
                    finish();
                }


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                // System.out.println("The read failed: ");
            }


        });

    }
}
