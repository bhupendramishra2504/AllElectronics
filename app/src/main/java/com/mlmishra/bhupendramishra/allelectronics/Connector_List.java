package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.app.Activity;

public class Connector_List extends Activity {


    private ListView lv;
    private ArrayAdapter<String> madapter;
    private String[] c_list;
    EditText connectorSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_connector__list);
        lv=(ListView)findViewById(R.id.connector_list);

        Integer[] imgid={
                R.drawable.connector,
                R.drawable.rs232,
                R.drawable.parallel,
                R.drawable.video,
                R.drawable.eth1,
                R.drawable.hdmiicon,
                R.drawable.sdcard,
                R.drawable.sata,
                R.drawable.jack1,
                R.drawable.fw,
                R.drawable.il,
                R.drawable.rca
        };





        //sbanner.setScalingEnabled(false);


        //int[] colors = {0, 0x99CCFF0, 0}; // red for the example
        //lv.setDivider(new GradientDrawable(Orientation.RIGHT_LEFT, colors));
        //lv.setDivider(new GradientDrawable(Color.BLUE));
        //lv.setDividerHeight(3);
        //  gestureDetector = new GestureDetector(new SwipeGestureDetector());

        c_list = getResources().getStringArray(R.array.connector_list);
        //View mainview = findViewById(R.id.rl21);
        // Binding resources Array to ListAdapter
        CustomAdapter adapter=new CustomAdapter(this, c_list, imgid);
        //madapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.label123, adobe_products);
        //madapter.notifyDataSetChanged();
        lv.setAdapter(adapter);
        //lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label123, adobe_products));
        lv.invalidateViews();
        //madapter = new ArrayAdapter<String>(this, R.layout.list_item2, R.id.label3, disp_data);
        //madapter.notifyDataSetChanged();
        //lv.setAdapter(madapter);
        registerForContextMenu(lv);

        //setContentView(R.layout.activity_table_content);
        //ListView lv = getListView();

        // listening to single list item on click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // selected item

                String product = c_list[position];

                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getApplicationContext(), Connector_list_result_activity.class);
                // sending data to new activity
                i.putExtra("product", product);
                startActivity(i);
                finish();


            }
        });






    }


    @Override
    public void onBackPressed() {

        // your code.
        Intent intent = new Intent(Connector_List.this, Table_content.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_connector__list, menu);
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
