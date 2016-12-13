package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.app.Activity;

public class Sata_activity extends Activity {
    TextView tv1,tv2,tv3,tv4;
    String separator = System.getProperty("line.separator");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_sata_activity);

        tv1=(TextView)findViewById(R.id.satatv4);
        tv2=(TextView)findViewById(R.id.satatv2);
        tv3=(TextView)findViewById(R.id.satatv3);

        tv1.setText(separator + separator + "Serial ATA (SATA, is a computer bus technology designed for transfer of data to and from a hard disk. It is the successor to the legacy Advanced Technology Attachment standard (ATA, also known as IDE). This older technology was retroactively renamed Parallel ATA (PATA) to distinguish it from Serial ATA. This interface uses 7-pin cables for the data connection, and transmits the data serially rather than in parallel. In addition, Serial ATA should give users the ability to hot swap hard drives. "+separator);
        tv2.setText(separator+"DATA CONNECTOR PINOUT");
        tv3.setText(separator+"POWER CONNECTOR PINOUT");

    }

    @Override
    public void onBackPressed() {

        // your code.
        Intent intent = new Intent(Sata_activity.this, Connector_List.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sata_activity, menu);
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
