package com.mlmishra.bhupendramishra.allelectronics;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ListActivity;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.Color;



public class Table_content extends Activity {
    private GestureDetector gestureDetector;
    private ListView lv;
    private ArrayAdapter<String> madapter;
    private String[] adobe_products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_table_content);
        lv=(ListView)findViewById(R.id.list_view12);
        Integer[] imgid={
                R.drawable.lib,
                R.drawable.calculator,
                R.drawable.mc,
                R.drawable.plc1,
                R.drawable.mneural,
                R.drawable.vhdl,
                R.drawable.rp1,
                R.drawable.bt,
                R.drawable.connector,
                R.drawable.blogi,
                };





        //sbanner.setScalingEnabled(false);


        //int[] colors = {0, 0x99CCFF0, 0}; // red for the example
        //lv.setDivider(new GradientDrawable(Orientation.RIGHT_LEFT, colors));
        //lv.setDivider(new GradientDrawable(Color.BLUE));
        //lv.setDividerHeight(3);
        gestureDetector = new GestureDetector(new SwipeGestureDetector());

        adobe_products = getResources().getStringArray(R.array.adobe_products);
        //View mainview = findViewById(R.id.rl21);
        // Binding resources Array to ListAdapter
        CustomAdapter adapter=new CustomAdapter(this, adobe_products, imgid);
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
        lv.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // selected item

                String product = adobe_products[position];

                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getApplicationContext(), List_click_result.class);
                // sending data to new activity
                i.putExtra("product", product);
                startActivity(i);
                finish();



            }
        });

        lv.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (gestureDetector.onTouchEvent(event)) {
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_ladder; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_table_content, menu);
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

    @Override
    public void onBackPressed() {

        // your code.
        //Intent intent = new Intent(Table_content.this, Search_text.class);
        //startActivity(intent);
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (gestureDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    private void onLeftSwipe() {
        // Do something
        //Intent intent = new Intent(Search_text.this, Table_content.class);
        //startActivity(intent);
    }

    private void onRightSwipe() {

        finish();
    }


    private class SwipeGestureDetector
            extends SimpleOnGestureListener {
        // Swipe properties, you can change it to make the swipe
        // longer or shorter and speed
        private static final int SWIPE_MIN_DISTANCE = 120;
        private static final int SWIPE_MAX_OFF_PATH = 200;
        private static final int SWIPE_THRESHOLD_VELOCITY = 200;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2,
                               float velocityX, float velocityY) {
            try {
                float diffAbs = Math.abs(e1.getY() - e2.getY());
                float diff = e1.getX() - e2.getX();

                if (diffAbs > SWIPE_MAX_OFF_PATH)
                    return false;

                // Left swipe
                if (diff > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    Table_content.this.onLeftSwipe();

                    // Right swipe
                } else if (-diff > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    Table_content.this.onRightSwipe();
                }
            } catch (Exception e) {

            }
            return false;
        }
    }
}
