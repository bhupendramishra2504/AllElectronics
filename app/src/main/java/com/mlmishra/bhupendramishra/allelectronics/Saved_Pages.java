package com.mlmishra.bhupendramishra.allelectronics;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.app.ListActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import java.io.File;
import android.view.MenuInflater;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Toast;
import android.widget.EditText;
import android.text.InputType;
import android.app.Activity;
import android.text.TextWatcher;
import android.text.Editable;

public class Saved_Pages extends Activity {

    private ArrayAdapter<String> madapter;
    private static final int rename = Menu.FIRST;
    private static final int delete = Menu.FIRST + 1;
    private String[] disp_data;
    private ListView lv;
    private int menu_called = 0;
    private String rename_file;
    private EditText inputSearch;
    private TextView data_folder;

    //public void setdata(String[] data) {
    //    madapter = new ArrayAdapter<String>(this, R.layout.list_item2, R.id.list2, disp_data);
    //}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Global.string_length();

        setContentView(R.layout.activity_saved__pages);
        lv = (ListView) findViewById(R.id.list_view11);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        data_folder=(TextView)findViewById(R.id.ltv);
        data_folder.setText("Data folder : "+ Environment.getExternalStorageDirectory()+"/AllElectronics/");
        disp_data = Global.Display_data();
        madapter = new ArrayAdapter<String>(this, R.layout.list_item2, R.id.label3, disp_data);
        madapter.notifyDataSetChanged();
        lv.setAdapter(madapter);
        registerForContextMenu(lv);

        lv.invalidateViews();
        // listening to single list item on click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // selected item

                String product = ((TextView) view).getText().toString();

                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getApplicationContext(), Saved_page_webview.class);
                // sending data to new activity
                i.putExtra("product", product);
                startActivity(i);


            }
        });

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                Saved_Pages.this.madapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_ladder; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_saved__pages, menu);
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
        if(Global.activity_id==1) {
            Intent intent = new Intent(Saved_Pages.this, Start_activity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Intent intent = new Intent(Saved_Pages.this, Table_content.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("Menu");
        menu.add(0, rename, Menu.NONE, "Rename");
        menu.add(0, delete, Menu.NONE, "Delete");

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
        final String key = ((TextView) info.targetView).getText().toString();
        //Toast.makeText(Saved_Pages.this,key,Toast.LENGTH_LONG).show();
        //Toast.makeText(Saved_Pages.this,item.getItemId(),Toast.LENGTH_LONG).show();
        switch (item.getItemId()) {
            case rename:
                //editNote(info.id);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Title");

// Set up the input
                final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

// Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rename_file = input.getText().toString();
                        Global.rename_file(key, rename_file);
                        Toast.makeText(Saved_Pages.this, "Item Renamed", Toast.LENGTH_LONG).show();
                        //Saved_Pages.this.setListAdapter(madapter);
                        disp_data = Global.Display_data();
                        //madapter.clear();
                        //madapter.addAll(disp_data);

                        madapter.notifyDataSetChanged();
                        lv.invalidateViews();
                        lv.refreshDrawableState();
                        Intent intent = new Intent(Saved_Pages.this, Saved_Pages.class);
                        startActivity(intent);
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();


                //madapter = new ArrayAdapter<String>(this, R.layout.activity_saved__pages, R.id.list2, disp_data);
                //this.setListAdapter(madapter);
               // lv = getListView();

                return true;
            case delete:


                Global.Delete_data(key);
                Toast.makeText(Saved_Pages.this, "Item Deleted From your Library", Toast.LENGTH_LONG).show();
                disp_data = Global.Display_data();
               madapter = new ArrayAdapter<String>(this, R.layout.list_item2, R.id.label3, disp_data);
               lv.setAdapter(madapter);
                madapter.notifyDataSetChanged();
                lv.invalidateViews();
                lv.refreshDrawableState();


                return true;
            default:

                return super.onContextItemSelected(item);


        }


    }
}

