package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.app.Activity;

public class Ethernet_activity extends Activity {

    private TextView tv1,tv2;
    String separator = System.getProperty("line.separator");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_ethernet_activity);
        tv1=(TextView)findViewById(R.id.ethtv2);
        tv2=(TextView)findViewById(R.id.ethtv3);
        tv1.setText(separator+separator+"RJ-45 PINOUT DIAGRAM (TO BE USED WITH SWITCH/HUB)"+separator);
        tv2.setText(separator+separator+"CROSS ETHERNET CABLE CONNECTION (FOR PEER TO PEER CONNECTION)"+separator);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ethernet_activity, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

        // your code.
        Intent intent = new Intent(Ethernet_activity.this, Connector_List.class);
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
