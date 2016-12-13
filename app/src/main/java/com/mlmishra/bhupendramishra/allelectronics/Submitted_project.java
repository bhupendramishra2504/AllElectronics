package com.mlmishra.bhupendramishra.allelectronics;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.widget.PopupMenu;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;
import java.util.HashMap;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.CheckBox;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Submitted_project extends Activity {
    private String userlogged;
    private Button signed_user,submit;
    private Firebase mFirebaseRef;
    private EditText title,desc;
    private int offer_counter;
    private CheckBox offer_available;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submitted_project);
        signed_user=(Button)findViewById(R.id.spsigned);
        submit=(Button)findViewById(R.id.spsubmit);
        title=(EditText)findViewById(R.id.sptitle);
        desc=(EditText)findViewById(R.id.spdesc);

        offer_available=(CheckBox)findViewById(R.id.offer);

        mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));
        Intent i = getIntent();
        userlogged= i.getStringExtra("user");
        signed_user.setText("Signed in as : " + userlogged);
        Firebase u_ref = mFirebaseRef.child("users").child(userlogged).child("offers");
        u_ref.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot snapshot) {

                offer_counter = Integer.parseInt(snapshot.getValue().toString());
                if (offer_counter == 1) {

                    offer_available.setVisibility(View.VISIBLE);

                } else {
                    offer_available.setVisibility(View.INVISIBLE);
                }


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                // System.out.println("The read failed: ");
            }


        });
        signed_user.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu


                PopupMenu popup = new PopupMenu(Submitted_project.this, signed_user);


                popup.getMenu().add("CHANGE PASSWORD");
                popup.getMenu().add("SEE PROFILE");
                popup.getMenu().add("LOGOUT");


                popup.getMenuInflater().inflate(R.menu.menu_main_menu, popup.getMenu());
                //popup.setOutsideTouchable(true);
                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        //s_report = (String) item.getTitle();
                        if (item.getTitle().toString().equalsIgnoreCase("logout")) {
                            Intent intent = new Intent(Submitted_project.this, Login_activity.class);
                            //intent.putExtra("user", email.getText().toString());
                            startActivity(intent);
                            finish();
                        }

                        return true;
                    }
                });

                popup.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                Firebase ref=mFirebaseRef.child("users").child(userlogged).child("projects").child(title.getText().toString());

                Map<String, Object> project_title = new HashMap<String, Object>();
                project_title.put("Description", desc.getText().toString());
                ref.updateChildren(project_title);


                Calendar c = Calendar.getInstance();
                System.out.println("Current time => " + c.getTime());

                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");
                String formattedDate = df.format(c.getTime());

                if(offer_available.isChecked()) {
                    Map<String, Object> project_payment = new HashMap<String, Object>();
                    project_payment.put("payment", "free");
                    ref.updateChildren(project_payment);
                }
                else
                {
                    Map<String, Object> project_payment = new HashMap<String, Object>();
                    project_payment.put("payment", "Paid");
                    ref.updateChildren(project_payment);
                }

                Map<String, Object> project_status = new HashMap<String, Object>();
                project_status.put("status", "Send for Approval");
                ref.updateChildren(project_status);

                Map<String, Object> project_date = new HashMap<String, Object>();
                project_date.put("submitted on", formattedDate);
                ref.updateChildren(project_date);

                if(offer_available.isChecked())
                {
                    Firebase ref1=mFirebaseRef.child("users").child(userlogged).child("offers");
                    ref1.setValue("0");

                }
                Toast.makeText(Submitted_project.this,"Project Submitted successfully for approval, once its accpeted the timeline is provided in Approved Projects Section", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Submitted_project.this, Start_activity.class);
                intent.putExtra("user", userlogged);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_submitted_project, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Submitted_project.this,Main_menu.class);
        intent.putExtra("user", userlogged);
        startActivity(intent);
        finish();

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
