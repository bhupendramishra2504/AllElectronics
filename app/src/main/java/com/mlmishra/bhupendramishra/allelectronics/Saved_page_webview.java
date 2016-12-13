package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.net.Uri;
import android.content.ComponentName;
import android.app.Activity;


public class Saved_page_webview extends Activity {
    private WebView webView;
    private String url;
    private String product1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getSupportActionBar().hide();
        setContentView(R.layout.activity_saved_page_activity);
        webView = (WebView) findViewById(R.id.webView3);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        Intent i = getIntent();
        // getting attached intent data
        product1= i.getStringExtra("product");
        url = "file://"+Environment.getExternalStorageDirectory()+"/AllElectronics/"+product1;
        Toast.makeText(Saved_page_webview.this,url,Toast.LENGTH_LONG).show();
        //Intent intent = new Intent(Intent.ACTION_VIEW);
        //intent.setData(Uri.parse(url));
        //intent.setComponent(new ComponentName("com.android.browser","com.android.browser.BrowserActivity"));
        //startActivity(intent);
        webView.loadUrl(url);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_ladder; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_saved_page_activity, menu);
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
