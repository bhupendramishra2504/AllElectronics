package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.app.Activity;

public class Rs232_activity extends Activity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13;
    String separator = System.getProperty("line.separator");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getSupportActionBar().hide();
        setContentView(R.layout.activity_rs232_activity);
        tv1=(TextView)findViewById(R.id.rptv1);
        tv2=(TextView)findViewById(R.id.rstv2);
        tv3=(TextView)findViewById(R.id.rstv3);
        tv4 =(TextView)findViewById(R.id.rstv4);
        tv5=(TextView)findViewById(R.id.rstv5);
        tv6=(TextView)findViewById(R.id.rstv6);
        tv7=(TextView)findViewById(R.id.rstv7);
        tv8=(TextView)findViewById(R.id.rstv8);
        tv9=(TextView)findViewById(R.id.rstv9);
        tv10=(TextView)findViewById(R.id.rstv10);
        tv11=(TextView)findViewById(R.id.rstv11);
        tv12=(TextView)findViewById(R.id.rstv12);
        tv13=(TextView)findViewById(R.id.rstv13);

        tv2.setText("The RS232 connector was originally developed to use 25 pins. In this DB25 connector pinout provisions were made for a secondary serial RS232 communication channel."+separator+separator);
        tv3.setText("RS232 DB9 pinout"+separator+separator);
        tv4.setText("RS232 DB25 pinout"+separator+separator);
        tv5.setText("DEC MMJ pinout"+separator+separator);
        tv6.setText("RS232 DB25 to DB9 converter"+separator+separator+ "The original pinout for RS232 was developed for a 25 pins sub D connector. Since the introduction of the smaller serial port on the IBM-AT, 9 pins RS232 connectors are commonly used. In mixed applications, a 9 to 25 pins converter can be used to connect connectors of different sizes. As most of the computers are equipped with the DB9 serial port version, all wiring examples on this website will use that connector as a default. If you want to use the example with a DB25, simply replace the pin numbers of the connector according to the conversion table below."+separator+separator);
        tv7.setText("RS232 serial loopback test plugs"+separator+separator+ "The following RS232 connectors can be used to test a serial port on your computer. The data and handshake lines have been linked. In this way all data will be sent back immediately. The PC controls its own handshaking. The first test plug can be used to check the function of the RS232 serial port with standard terminal software."+separator+separator+ "RS232 loopback test plug for terminal emulation software"+separator);
        tv8.setText("RS232 loopback test plug for Norton Diagnostics and CheckIt"+separator);
        tv9.setText("RS232 null modem cables"+separator);
        tv10.setText("Simple RS232 null modem without handshaking"+separator);
        tv11.setText("RS232 null modem with loop back handshaking"+separator);
        tv12.setText("RS232 null modem with partial handshaking"+separator);
        tv13.setText("RS232 null modem with full handshaking"+separator);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rs232_activity, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

        // your code.
        Intent intent = new Intent(Rs232_activity.this, Connector_List.class);
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
