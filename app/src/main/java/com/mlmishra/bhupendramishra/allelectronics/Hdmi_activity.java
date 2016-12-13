package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.app.Activity;

public class Hdmi_activity extends Activity {

    TextView tv1,tv2;
    String separator = System.getProperty("line.separator");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_hdmi_activity);
        tv1=(TextView)findViewById(R.id.hdmitv1);
        tv2=(TextView)findViewById(R.id.hdmitv2);
        tv2.setText(separator + separator + "Pins 1 through 9 carry the three TMDS data channels (Transition Minimized Differential Signaling – the technology that allows DVI and HDMI to send high-speed digital data), three pins per channel. TMDS data includes both video and audio information, and each channel has three separate lines for + values, - values, and a ground or data shield." +
                separator +separator+
                "Pins 10 through 12 carry data for the TMDS clock channel, which helps keep the signals in synchronization. As with the TMDS data channels, there are separate lines for + values, - values, and a data shield." +
                separator +separator+
                "Pin 13 is carries the CEC (Consumer Electronics Control) channel, used for sending command and control data between connected devices." +
                separator +separator+
                "Pin 14 is reserved for future use." +
                separator +separator+
                "Pins 15 and 16 are dedicated to the DDC (Display Data Channel), used for communicating EDID (Extended Display Identification Channel) information between devices." +
                separator +separator+
                "Pin 17 is a data shield for the CEC and DDC channels." +
                separator +separator+
                "Pin 18 carries a low-voltage (+5V) power supply." +
                separator +separator+
                "Pin 19 is the Hot Plug Detect, dedicated to monitoring power up/down and plug/unplug events." + separator);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hdmi_activity, menu);
        return true;
    }


    @Override
    public void onBackPressed() {

        // your code.
        Intent intent = new Intent(Hdmi_activity.this, Connector_List.class);
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
