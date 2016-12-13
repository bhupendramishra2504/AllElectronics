package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.Activity;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;
import android.util.Log;
import android.text.method.ScrollingMovementMethod;
import android.content.DialogInterface.OnClickListener;

import java.io.File;

public class Start_activity extends Activity {
    private Button menu_show,aboutus,library,search,submit_pro;
    private EditText edittext;
    private Context context;
    private ActionBarActivity mActivity;
    private TextView textview1;//,textview1,textview2,textview4,menu_activity;
    private boolean bdatasheet,bcircuit,bgis,bcircuit1,bcircuit2,ebc1;
    private ImageButton button,button2;
    private String versionName;
    private int versionCode;
    private Button login;
    private TextView offers,alert;
    String separator = System.getProperty("line.separator");
    private boolean loggedin=false;
    private String username="";
    private String[] news_feed=new String[10];
    private int counter=0;
    private boolean loading=false;
    private Timer timer = new Timer();
    private TimerTask timerTask;
    private int c;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_activity);
        button = (ImageButton) findViewById(R.id.button);
        button2 = (ImageButton) findViewById(R.id.button2);

        menu_show = (Button) findViewById(R.id.smenu1);

        aboutus = (Button) findViewById(R.id.saboutus);
        login=(Button)findViewById(R.id.login);

        submit_pro=(Button)findViewById(R.id.ssubmitpro);


        library = (Button) findViewById(R.id.slibrary);


        search=(Button)findViewById(R.id.ssearch);


        edittext = (EditText) findViewById(R.id.editText);
        textview1=(TextView)findViewById(R.id.version);

        alert=(TextView)findViewById(R.id.alert);

        offers=(TextView)findViewById(R.id.offer);
        offers.setMovementMethod(new ScrollingMovementMethod());
        offers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Start_activity.this);
                builder.setMessage(offers.getText().toString())
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //do things
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        SharedPreferences editor = getSharedPreferences("Allelectronics", MODE_PRIVATE);
        username = editor.getString("email", null);
        String password1 =editor.getString("password", null);
        boolean remember=editor.getBoolean("remember", false);
        if(remember)
        {
            if(username != null && password1 != null)
            {
                loggedin=true;
                login.setText(username);
            }
        }

        Intent i = getIntent();
        if(i!=null && i.getStringExtra("user")!=null) {
            username = i.getStringExtra("user");
            if (!username.equals(null) && !username.equals("")) {
                login.setText(username);
                loggedin = true;
            }
        }

        //textview4.setTextColor(Color.BLUE);
        try {
            versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            versionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;

        }
        catch(PackageManager.NameNotFoundException we)
        {
            versionName="1.1";
            versionCode=1;
        }



        textview1.setText("AllElectronics v"+versionName+" ("+String.valueOf(versionCode)+") ");

        if(loggedin)
        {
            library.setVisibility(View.VISIBLE);
            menu_show.setVisibility(View.VISIBLE);
            submit_pro.setVisibility(View.VISIBLE);
            alert.setVisibility(View.GONE);
        }
        else
        {
            library.setVisibility(View.VISIBLE);
            menu_show.setVisibility(View.VISIBLE);
            submit_pro.setVisibility(View.VISIBLE);
            alert.setVisibility(View.GONE);
        }

        load_offers();
        /*Timer t = new Timer(false);
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        textview.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }, 15000);*/
        // String fontPath = "fonts/Futura.ttf";
        //  Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);

        // Applying font
        // textview2.setTypeface(tf);
        //textview1.setText( Html.fromHtml("<a href=\"http://www.idearb.co.in\">IDEARB [?]</a>"));
        // textview1. setMovementMethod(LinkMovementMethod.getInstance());
        context = this;



        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if(!loggedin) {
                    Intent intent = new Intent(context, Login_activity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    new AlertDialog.Builder(context)
                            .setTitle("Logout")
                            .setMessage("Are you sure, you want to logout")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                    SharedPreferences.Editor editor = getSharedPreferences("Allelectronics", MODE_PRIVATE).edit();
                                    editor.putString("email", "");
                                    editor.putString("password", "");
                                    editor.putBoolean("remember", false);
                                    editor.commit();
                                    loggedin=false;
                                    login.setText("Login/Signup");
                                    library.setVisibility(View.GONE);
                                    menu_show.setVisibility(View.GONE);
                                    submit_pro.setVisibility(View.GONE);

                                    alert.setVisibility(View.VISIBLE);

                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }

        });

        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, Search_text.class);
                startActivity(intent);
            }

        });


        menu_show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, Table_content.class);
                startActivity(intent);


            }

        });



        aboutus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent i = new Intent(getApplicationContext(), List_click_result.class);
                // sending data to new activity
                i.putExtra("product", "ABOUT US");
                startActivity(i);
                //finish();

            }

        });

        library.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent i = new Intent(getApplicationContext(), List_click_result.class);
                // sending data to new activity
                i.putExtra("product", "LIBRARY");
                startActivity(i);
                finish();


            }

        });

        submit_pro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                Intent i = new Intent(getApplicationContext(), Main_menu.class);
                // sending data to new activity
                i.putExtra("user", username);
                startActivity(i);
               finish();


            }

        });










    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_activity, menu);
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


    private void load_offers()
    {
        final Firebase viewtourref = Global.fbref.child("offers");

        offers.setText("News Feed Loading ..."+separator+"Please Wait....");
        viewtourref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot child : snapshot.getChildren()) {
                    if (child.getKey() != null && counter <= 9) {

                        // offers.setText("Offer Zone " + separator + child.getValue().toString());
                        news_feed[counter] = child.getValue().toString();
                        counter++;
                        Log.d("counter", String.valueOf(counter));
                    } else {


                    }
                }
                c = 0;
                loading = true;
                handler = new Handler();

                final Runnable updateTask = new Runnable() {
                    @Override
                    public void run() {
                        offers.setText(news_feed[c]);
                        c++;
                        if (c >= counter) {
                            c = 0;
                        }
                        handler.postDelayed(this, 3000);

                    }
                };

                handler.postDelayed(updateTask, 3000);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });




    }

}
