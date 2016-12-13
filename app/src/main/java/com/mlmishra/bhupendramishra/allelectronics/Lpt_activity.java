package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.app.Activity;

public class Lpt_activity extends Activity {
    String separator = System.getProperty("line.separator");
    TextView tv1,tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getSupportActionBar().hide();
        setContentView(R.layout.activity_lpt_activity);
        tv1=(TextView)findViewById(R.id.lpttv1);
        tv2=(TextView)findViewById(R.id.lpttv2);
        tv3=(TextView)findViewById(R.id.lpttv3);
        tv4=(TextView)findViewById(R.id.lpttv4);


        tv1.setText("PARALLEL PORT CONNECTOR PINOUT"+separator);
        tv2.setText(separator+"Interlink and Windows 95/98/ME DCC parallel cable"+separator+separator+ "The following parellel cable can be used with file transfer and network programs like LapLink and InterLink. The cable uses the parallel port which makes it possible to achieve higher throughput than with a serial connection at the same low costs. The cable is amongst others compatible with the following software." +separator+ "Laplink from Travelling software" +separator+ "MS-DOS v 6.xx InterLink" +separator+ "Windows 95, 98 and ME direct cable connection"+separator + "Norton Commander" +separator+ "Norton Ghost"+separator+separator + "Because the parallel port on a computer was mainly designed to connect printers with one-way communication, a trick is used to achieve full two way data transfer between both sides. Five error and status message inputs are redefined as data inputs. Instead of reading full bytes, the communication software reads these five bits and combines multiple groups of data back to bytes. The sender and receiver have to use the same protocol to convert bytes to groups of 5 bits and vice versa."+separator);
        tv3.setText(separator+separator+"Norton test plug"+separator);
        tv4.setText(separator+separator+"CheckIt test plug"+separator);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lpt_activity, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

        // your code.
        Intent intent = new Intent(Lpt_activity.this, Connector_List.class);
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
