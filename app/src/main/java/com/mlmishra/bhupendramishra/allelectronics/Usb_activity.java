package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.app.Activity;

public class Usb_activity extends Activity {

    TextView tv1,tv2,tv3,tv4;
    String separator = System.getProperty("line.separator");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_usb_activity);
        tv1=(TextView)findViewById(R.id.usbtv1);
        tv2=(TextView)findViewById(R.id.usbtv2);
        tv3=(TextView)findViewById(R.id.usbtv3);
        tv1.setText("USB Connector Pinouts");
        tv2.setText("USB is a serial bus. It uses 4 shielded wires: two for power (+5v & GND) and two for differential data signals (labelled as D+ and D- in pinout)." +separator+ "In a USB data cable Data+ and Data- signals are transmitted on a twisted pair with no termination needed. Half-duplex differential signalling is used to reduce the effects of electromagnetic noise on longer lines." +separator+"D+ and D- operate together they are not separate simplex connections."+separator+separator+"A USB device must indicate its speed by pulling either the D+ or D- line high to 3.3 volts."+separator +"These pull up resistors at the device end will also be used by the host or hub to detect the presence of a device connected to its port. Without a pull up resistor, USB assumes there is nothing connected to the bus. Pinout for the various connectors are shown below");
        tv3.setText("USB Micro-B Connector" +"The Micro-B connector is becomming more and more popular on small devices. Here is the pinout shown from the end of the plug");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_usb_activity, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

        // your code.
        Intent intent = new Intent(Usb_activity.this, Connector_List.class);
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
