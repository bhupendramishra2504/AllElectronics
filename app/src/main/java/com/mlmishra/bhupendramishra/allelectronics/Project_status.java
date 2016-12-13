package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseException;
import com.firebase.client.FirebaseError;
import java.util.Map;
import android.app.Activity;

public class Project_status extends Activity {
        private String userlogged;
        private Button signed_user;
        private TextView showdata;
        private Firebase mFirebaseRef;
        private String data="";
        String separator = System.getProperty("line.separator");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_status);
        signed_user=(Button)findViewById(R.id.psuser);
        showdata=(TextView)findViewById(R.id.showdata);
        Intent i = getIntent();
        userlogged= i.getStringExtra("user");
        signed_user.setText("Signed in as : " + userlogged);
        mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));
        mFirebaseRef.child("users").child(userlogged).child("projects").addListenerForSingleValueEvent(new ValueEventListener() {
            //PopupMenu popup = new PopupMenu(Add_user.this, seluser);
            int pos = 0;

            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot child : snapshot.getChildren()) {
                    if (child.getKey() != null) {

                        Map<String, Object> map = (Map<String, Object>) child.getValue();
                        data="Title : "+child.getKey().toString()+separator+"Description : "+map.get("Description").toString()+separator+"Project payment type : "+map.get("payment").toString()+separator+"Project Status : "+ map.get("status").toString() +separator+"submitted on : "+map.get("submitted on").toString()+separator+separator+data;




                    }
                }
                showdata.setText(data);

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


                PopupMenu popup = new PopupMenu(Project_status.this, signed_user);


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
                            Intent intent = new Intent(Project_status.this, Start_activity.class);
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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_project_status, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Project_status.this,Main_menu.class);
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
