package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.app.Activity;

public class Vga_activity extends Activity {
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_vga_activity);
        tv1=(TextView)findViewById(R.id.vgatv1);
        tv2=(TextView)findViewById(R.id.vgatv2);
        tv1.setText("Video Graphics Array, VGA is a popular display standard developed by IBM and introduced in 1987. VGA provides 640 x 480 resolution color display screens with a refresh rate of 60Hz and 16 colors displayed at a time.");
        tv2.setText("VGA Pin functions");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vga_activity, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

        // your code.
        Intent intent = new Intent(Vga_activity.this, Connector_List.class);
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
