package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;


public class Connector_list_result_activity extends Activity {

    private String product1;

    private String separator = System.getProperty("line.separator");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_connector_list_result_activity);
        Intent i = getIntent();
        // getting attached intent data
        product1= i.getStringExtra("product");
        if(product1.equalsIgnoreCase("USB"))
        {
            Intent intent = new Intent(Connector_list_result_activity.this, Usb_activity.class);
            startActivity(intent);
            finish();

        }
        else if(product1.equalsIgnoreCase("RS232"))
        {
            Intent intent = new Intent(Connector_list_result_activity.this, Rs232_activity.class);
            startActivity(intent);
            finish();

        }
        else if(product1.equalsIgnoreCase("PARALLEL"))
        {
            Intent intent = new Intent(Connector_list_result_activity.this, Lpt_activity.class);
            startActivity(intent);
            finish();

        }

        else if(product1.equalsIgnoreCase("VIDEO PORT"))
        {
            Intent intent = new Intent(Connector_list_result_activity.this, Vga_activity.class);
            startActivity(intent);
            finish();

        }

        else if(product1.equalsIgnoreCase("ETHERNET"))
        {
            Intent intent = new Intent(Connector_list_result_activity.this, Ethernet_activity.class);
            startActivity(intent);
            finish();

        }
        else if(product1.equalsIgnoreCase("HDMI"))
        {
            Intent intent = new Intent(Connector_list_result_activity.this, Hdmi_activity.class);
            startActivity(intent);
            finish();

        }

        else if(product1.equalsIgnoreCase("SD-CARD"))
        {
            Intent intent = new Intent(Connector_list_result_activity.this, Sdcard_activity.class);
            startActivity(intent);
            finish();

        }

        else if(product1.equalsIgnoreCase("SATA HARD DISK"))
        {
            Intent intent = new Intent(Connector_list_result_activity.this, Sata_activity.class);
            startActivity(intent);
            finish();

        }

        else if(product1.equalsIgnoreCase("JACK CONNECTOR"))
        {
            Intent intent = new Intent(Connector_list_result_activity.this, Jack_activity.class);
            startActivity(intent);
            finish();

        }

        else if(product1.equalsIgnoreCase("FIREWIRE CONNECTOR"))
        {
            Intent intent = new Intent(Connector_list_result_activity.this, Firewire_activity.class);
            startActivity(intent);
            finish();

        }

        else if(product1.equalsIgnoreCase("IPHONE LIGHTNING PIN CONNECTOR"))
        {
            Intent intent = new Intent(Connector_list_result_activity.this, Iphonelightning.class);
            startActivity(intent);
            finish();

        }

        else if(product1.equalsIgnoreCase("RCA CONNECTOR"))
        {
            Intent intent = new Intent(Connector_list_result_activity.this, Rca_activity.class);
            startActivity(intent);
            finish();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_connector_list_result_activity, menu);
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
