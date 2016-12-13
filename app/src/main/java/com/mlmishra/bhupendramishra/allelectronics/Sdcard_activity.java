package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.app.Activity;

public class Sdcard_activity extends Activity {
    TextView tv1,tv2,tv3,tv4;
    String separator = System.getProperty("line.separator");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_sdcard_activity);
        tv1=(TextView)findViewById(R.id.sdtv2);


        tv1.setText(separator + separator + "The microSD Card is a type of Removable NAND-type small flash memory card format which was introduced in 2003." +separator+
                "microSD measures 11mm x 15mm and is 1mm thick." +separator+separator+
                "Two pinout tables are provided for microSD below; one table provides the pin out for SD Mode, and one table shows the SPI mode." +separator +separator+"It is available in 4 speed grades: Class 2-2MB/s, Class 4-4MB/s and class 6 cards-6MB/s and class 10 cards -10MB/s"+separator+separator+"");


    }

    @Override
    public void onBackPressed() {

        // your code.
        Intent intent = new Intent(Sdcard_activity.this, Connector_List.class);
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sdcard_activity, menu);
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
