package com.mlmishra.bhupendramishra.allelectronics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.PopupMenu;


public class Main_menu extends Activity {
    private Button signed_user,submit_project,project_status;
    private String userlogged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        signed_user=(Button)findViewById(R.id.mmuser);
        submit_project=(Button)findViewById(R.id.mmsubmitpro);
        project_status=(Button)findViewById(R.id.mmps);

        Intent i = getIntent();
        userlogged= i.getStringExtra("user");
        signed_user.setText("Signed in as : " + userlogged);


        signed_user.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu


                PopupMenu popup = new PopupMenu(Main_menu.this, signed_user);


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
                            Intent intent = new Intent(Main_menu.this, Login_activity.class);
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

        submit_project.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu

                Intent intent = new Intent(Main_menu.this, Submitted_project.class);
                intent.putExtra("user", userlogged);
                startActivity(intent);
                finish();

            }
        });


        project_status.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu

                Intent intent = new Intent(Main_menu.this, Project_status.class);
                intent.putExtra("user", userlogged);
                startActivity(intent);
                finish();

            }
        });




    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Main_menu.this,Start_activity.class);
        intent.putExtra("user", userlogged);
        startActivity(intent);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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
