package com.mlmishra.bhupendramishra.allelectronics;

import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;
import android.content.Context;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.TextView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Window;
import android.view.WindowManager;
import android.graphics.Color;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;

import java.io.File;
import android.graphics.Typeface;
import java.util.Timer;
import java.util.TimerTask;
import com.firebase.client.Firebase;
import android.app.Activity;
import android.widget.ImageButton;
import com.firebase.client.ValueEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;




public class Search_text extends Activity {

    private GestureDetector gestureDetector;
    private Button menu_show,fb,rate,aboutus,library,disclaimer,query,blog;
    private EditText edittext;
    private Context context;
    private ActionBarActivity mActivity;
    private TextView textview1;//,textview1,textview2,textview4,menu_activity;
    private boolean bdatasheet,bcircuit,bgis,bcircuit1,bcircuit2,ebc1;
    private ImageButton button,button2;
    private String versionName;
    private int versionCode;
    private Button login;
    private TextView offers;
    String separator = System.getProperty("line.separator");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //getSupportActionBar().hide();
        this.setContentView(R.layout.activity_search);

        button = (ImageButton) findViewById(R.id.button);
        button2 = (ImageButton) findViewById(R.id.button2);



        edittext = (EditText) findViewById(R.id.editText);
        textview1=(TextView)findViewById(R.id.version);


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
        View mainview = findViewById(R.id.search_layout);
        displayUserSettings();
        File folder = new File(Environment.getExternalStorageDirectory() + "/AllElectronics");
        boolean success = true;
        if (!folder.exists()) {
                success = folder.mkdir();

        }
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Global.search_item = edittext.getText().toString();

                Global.search_item.replace(" ", "+");
                if (bdatasheet) {

                    Global.url_search = "http://m.alldatasheet.com/view_datasheet.jsp?Searchword=" + edittext.getText().toString();


                } else if (bcircuit) {

                    Global.url_search = "http://circuitscout.com/search.jsp?query=" + edittext.getText().toString() + "&pd=0";

                } else if (bgis) {

                    Global.url_search = "http://www.google.com/images?q=" + edittext.getText().toString().replace(" ", "+");

                } else if (bcircuit1) {

                    Global.url_search = "http://www.circuit-finder.com/search/" + edittext.getText().toString().replace(" ", "-");

                } else if (bcircuit2) {

                    Global.url_search = "http://electronicsforu.com/newelectronics/lab/search_lab.asp?words=" + edittext.getText().toString().replace(" ", "+");

                } else if (ebc1) {

                    Global.url_search = "http://www.allaboutcircuits.com/search?q=" + edittext.getText().toString().replace(" ", "+");

                }
                Intent intent = new Intent(context, WebViewActivity.class);
                startActivity(intent);
                //finish();
            }

        });


        button2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, Options.class);
                startActivityForResult(intent, 1);

            }

        });




    }
















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu_ladder; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }


    private void load_offers()
    {
        final Firebase viewtourref = Global.fbref.child("offers");

        offers.setText("Offer Zone"+separator+"Please Wait.... Offers loading ....");
        viewtourref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {

                if (snapshot.getValue() != null) {
                    offers.setText("Offer Zone "+separator+snapshot.getValue().toString());
                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });



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



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (gestureDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        //callbackManager.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1)
        {
            displayUserSettings();
        }

    }
    private void displayUserSettings()
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        bdatasheet = sp.getBoolean("datasheet", false);
        bcircuit = sp.getBoolean("circuit", false);
        bgis=sp.getBoolean("gis",false);
        bcircuit1=sp.getBoolean("circuit1",false);
        bcircuit2=sp.getBoolean("circuit2",false);
        ebc1=sp.getBoolean("ebc1",false);
        if(bdatasheet)
        {

            Toast.makeText(this,"Search from AllDatasheet.com is Active",Toast.LENGTH_SHORT).show();

        }
        if(bcircuit)
        {

            Toast.makeText(this,"Search from CircuitScout.com is Active",Toast.LENGTH_SHORT).show();

        }
        if(bgis)
        {

            Toast.makeText(this,"Search from Google.com is Active",Toast.LENGTH_SHORT).show();

        }
        if(bcircuit1)
        {

            Toast.makeText(this,"Search from circuitfinder.com is Active",Toast.LENGTH_SHORT).show();

        }
        if(bcircuit2)
        {

            Toast.makeText(this,"Search from electronicsforu.com is Active",Toast.LENGTH_SHORT).show();

        }
        if(ebc1)
        {

            Toast.makeText(this,"Search from allaboutelectronics.com is Active",Toast.LENGTH_SHORT).show();

        }








    }












}
