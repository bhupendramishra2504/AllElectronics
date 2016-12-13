package com.mlmishra.bhupendramishra.allelectronics;

import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MotionEvent;
import android.content.DialogInterface;
import android.net.Uri;
import android.content.ActivityNotFoundException;

public class List_click_result extends Activity{
    private WebView webView;
    private String url,url1;
    private String product1;

    String separator = System.getProperty("line.separator");
    private String message,versionName;
    int versionCode;
    private String disclaimer="The information contained in this App is for general information purposes only. The information is provided by respective sites and while we endeavour to keep the information up to date and correct, we make no representations or warranties of any kind, express or implied, about the completeness, accuracy, reliability, suitability or availability with respect to the App or the information, products, services, or related graphics contained on the App for any purpose. Any reliance you place on such information is therefore strictly at your own risk.\n" +
            "In no event will we be liable for any loss or damage including without limitation, indirect or consequential loss or damage, or any loss or damage whatsoever arising from loss of data or profits arising out of, or in connection with, the use of this App.\n" +
            "Through this App you are able to link to other websites which are not under the control of AllElectonics. We have no control over the nature, content and availability of those sites. The inclusion of any links does not necessarily imply a recommendation or endorse the views expressed within them.\n" +
            "Every effort is made to keep the App up and running smoothly. However, AllElectronics takes no responsibility for, and will not be liable for, the website being temporarily unavailable due to technical issues beyond our control.";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview1);
        webView = (WebView) findViewById(R.id.webView11);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        Intent i = getIntent();
        // getting attached intent data
        product1= i.getStringExtra("product");
        Global.library_back_pressed_activity(product1);
        // displaying selected product name
        if(product1.equalsIgnoreCase("My Library"))
        {
            Intent intent = new Intent(List_click_result.this, Saved_Pages.class);
            startActivity(intent);
            finish();

        }

        else if(product1.equalsIgnoreCase("Library"))
        {
            Intent intent = new Intent(List_click_result.this, Saved_Pages.class);
            startActivity(intent);
            finish();

        }



        else if(product1.equalsIgnoreCase("ABOUT US"))
        {

            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            AlertDialog alert;
            builder.setTitle("ABOUT US");
            try {
                versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
                versionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;

            }
            catch(PackageManager.NameNotFoundException we)
            {
                versionName="1.1";
                versionCode=1;
            }
            message="AllElectronics v"+versionName+"("+versionCode+")"+separator+separator+"Created By :"+separator+"Bhupendra Mishra"+separator+"Rakesh Dalal"+separator+separator+"Visit us as :"+separator+"www.Idearb.co.in"+separator+separator+"Write us :"+separator+"bhupendramishr@gmail.com"+separator+"rakdlprb@gmail.com"+separator+separator+"Contact Us : "+separator+"+91-9406903375"+separator+"+91-9406903685"+separator+separator+"Please share your views and suggestions, your suggestions are valuable for us";


            builder.setMessage(message+separator+separator+"DisClaimer"+separator+disclaimer);
            builder.setCancelable(false);

       builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Intent intent = new Intent(List_click_result.this, Search_text.class);
               // startActivity(intent);
                finish();
            }
        });
            alert=builder.create();

            alert.show();


        }




        else if(product1.equalsIgnoreCase("ELECTRONICS CALCULATOR"))
        {
            Intent intent = new Intent(List_click_result.this, Calculator.class);
            startActivity(intent);
            finish();
        }

        else if(product1.equalsIgnoreCase("MICROCONTROLLER PROGRAMMING")) {
            Intent intent = new Intent(List_click_result.this, Controller_program.class);
            startActivity(intent);
            finish();
        }
        else if(product1.equalsIgnoreCase("PLC PROGRAMMING"))
        {
            Intent intent = new Intent(List_click_result.this, Ladder_program.class);
            startActivity(intent);
            finish();
        }
        else if(product1.equalsIgnoreCase("NEURAL NETWORK"))
        {
            Intent intent = new Intent(List_click_result.this, MATLAB_Script.class);
            startActivity(intent);
            finish();
        }

        else if(product1.equalsIgnoreCase("VHDL CODES"))
        {
            Intent intent = new Intent(List_click_result.this, VHDL_codes.class);
            startActivity(intent);
            finish();
        }


        else if(product1.equalsIgnoreCase("LIKE OUR FACEBOOK PAGE"))
        {
            webView.loadUrl("https://www.facebook.com/AllElectronics4android");

        }

        else if(product1.equalsIgnoreCase("RASPBERRY PI CODES")) {
            Intent intent = new Intent(List_click_result.this, Raspberry_code.class);
            startActivity(intent);
            finish();
        }

        else if(product1.equalsIgnoreCase("CONNECTORS INFO")) {
            Intent intent = new Intent(List_click_result.this,Connector_List.class);
            startActivity(intent);
            finish();
        }

        else if(product1.equalsIgnoreCase("BLUETOOTH TERMINAL")) {
            Intent intent = new Intent(List_click_result.this,BluetoothTerminal.class);
            startActivity(intent);
            finish();
        }


        else if(product1.equalsIgnoreCase("RATE THE APP")) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            //Try Google play
            intent.setData(Uri.parse("market://details?id=com.mlmishra.bhupendramishra.allelectronics"));
            if (!MyStartActivity(intent)) {
                //Market (Google play) app seems not installed, let's try to open a webbrowser
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?[Id]"));
                if (!MyStartActivity(intent)) {
                    //Well if this also fails, we have run out of options, inform the user.
                    Toast.makeText(this, "Could not open Android market, please install the market app.", Toast.LENGTH_SHORT).show();
                    webView.loadUrl("https://play.google.com/store/apps/details?id=com.mlmishra.bhupendramishra.allelectronics&hl=en");
                }
            }
        }

        else {

            Intent intent = new Intent(List_click_result.this, Start_activity.class);
            startActivity(intent);
            finish();

        }

    }

    @Override
    public void onBackPressed() {
        // your code.
        if (product1.equalsIgnoreCase("HELP") && Global.first_help) {
            Global.first_help = false;
            Intent intent = new Intent(List_click_result.this, Search_text.class);
            startActivity(intent);
            finish();
        } else if (product1.equalsIgnoreCase("LIKE OUR FACEBOOK PAGE")) {
            Intent intent = new Intent(List_click_result.this, Search_text.class);
            startActivity(intent);
            finish();
        } else if (product1.equalsIgnoreCase("RATE THE APP")) {
            //Intent intent = new Intent(List_click_result.this, Search_text.class);
            //startActivity(intent);
            finish();
        }

        else if (product1.equalsIgnoreCase("DISCLAIMER")) {
            //Intent intent = new Intent(List_click_result.this, Search_text.class);
            //startActivity(intent);
            finish();
        }
        else if (product1.equalsIgnoreCase("SUBMIT YOUR QUERY")) {
            Intent intent = new Intent(List_click_result.this, Search_text.class);
            startActivity(intent);
            finish();
        }


        else {

            Intent intent = new Intent(List_click_result.this, Table_content.class);
            startActivity(intent);
            finish();
        }


    }

    private boolean MyStartActivity(Intent aIntent) {
        try
        {
            startActivity(aIntent);
            return true;
        }
        catch (ActivityNotFoundException e)
        {
            return false;
        }
    }

}