package com.mlmishra.bhupendramishra.allelectronics;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class VHDL_codes extends Activity {
    Button button1,save;
    ImageView imageview,imageview1,imageview2,imageview3;
    TextView help_text;
    String separator = System.getProperty("line.separator");
    String filename,write_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getSupportActionBar().hide();
        setContentView(R.layout.activity_vhdl_codes);
        imageview = (ImageView) findViewById(R.id.vimageview);
        imageview1 = (ImageView) findViewById(R.id.vimageview1);
        imageview2 = (ImageView) findViewById(R.id.vimageview2);
        imageview3 = (ImageView) findViewById(R.id.vimageview3);
        button1 = (Button) findViewById(R.id.vbuttonp3);
        save = (Button) findViewById(R.id.vb1);
        help_text=(TextView)findViewById(R.id.vtv1);
        imageview.setImageResource(R.drawable.vhdl);
        help_text.setText(Global.read_file_to_string(VHDL_codes.this, "introduction.txt"));
        imageview1.setImageResource(0);
        imageview2.setImageResource(0);
        imageview3.setImageResource(0);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(VHDL_codes.this, button1);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_vhdl_codes, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(Ladder_program.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();

                        button1.setText(item.getTitle());
                        switch (item.getItemId()) {
                            case R.id.introduction:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "introduction.txt"));
                                imageview1.setImageResource(0);
                                imageview2.setImageResource(0);
                                imageview3.setImageResource(0);
                                return true;
                            case R.id.orgate:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "ORgate.txt"));
                                imageview1.setImageResource(R.drawable.vorgate);
                                imageview2.setImageResource(0);
                                imageview3.setImageResource(0);
                                return true;
                            case R.id.andgate:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "andgate.txt"));
                                imageview1.setImageResource(R.drawable.andgate);
                                imageview2.setImageResource(0);
                                imageview3.setImageResource(0);
                                return true;
                            case R.id.xorgate:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "xorgate.txt"));
                                imageview1.setImageResource(R.drawable.vxorgate);
                                imageview2.setImageResource(0);
                                imageview3.setImageResource(0);
                                return true;
                            case R.id.combinational:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "combinationallogic.txt") + separator + separator + "TEST BENCH" + separator + separator + Global.read_file_to_string(VHDL_codes.this, "combinationallogictb.txt"));
                                imageview1.setImageResource(R.drawable.csimulation);
                                imageview2.setImageResource(R.drawable.cshematic);
                                imageview3.setImageResource(R.drawable.comb_sim);
                                return true;

                            case R.id.multiplexer:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "multiplexer.txt") + separator + separator + "TEST BENCH" + separator + separator + Global.read_file_to_string(VHDL_codes.this, "multiplexertb.txt"));
                                imageview1.setImageResource(R.drawable.vmux1);
                                imageview2.setImageResource(R.drawable.vmux2);
                                imageview3.setImageResource(R.drawable.vmux3);
                                return true;
                            case R.id.decoder:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "decoder.txt") + separator + separator + "TEST BENCH" + separator + separator + Global.read_file_to_string(VHDL_codes.this, "decodertb.txt"));
                                imageview1.setImageResource(R.drawable.vdecoder1);
                                imageview2.setImageResource(R.drawable.vdecoder2);
                                imageview3.setImageResource(R.drawable.vdecoder3);
                                return true;
                            case R.id.adder:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "adder.txt") + separator + separator + "TEST BENCH" + separator + separator + Global.read_file_to_string(VHDL_codes.this, "addertb.txt"));
                                imageview1.setImageResource(R.drawable.adder1);
                                imageview2.setImageResource(R.drawable.adder2);
                                imageview3.setImageResource(R.drawable.adder3);
                                return true;
                            case R.id.comparator:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "comparator.txt") + separator + separator + "TEST BENCH" + separator + separator + Global.read_file_to_string(VHDL_codes.this, "comparatortb.txt"));
                                imageview1.setImageResource(R.drawable.comparator1);
                                imageview2.setImageResource(R.drawable.comparator2);
                                imageview3.setImageResource(R.drawable.comparator3);
                                return true;

                            case R.id.alu:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "alu.txt") + separator + separator + "TEST BENCH" + separator + separator + Global.read_file_to_string(VHDL_codes.this, "alutb.txt"));
                                imageview1.setImageResource(R.drawable.alu1);
                                imageview2.setImageResource(R.drawable.alu2);
                                imageview3.setImageResource(R.drawable.alu3);
                                return true;

                            case R.id.multiplier:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "multiplier.txt") + separator + separator + "TEST BENCH" + separator + separator + Global.read_file_to_string(VHDL_codes.this, "multipliertb.txt"));
                                imageview1.setImageResource(R.drawable.multiplier1);
                                imageview2.setImageResource(R.drawable.multiplier2);
                                imageview3.setImageResource(R.drawable.multiplier3);
                                return true;

                            case R.id.jkflipflop:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "jkflipflop.txt"));
                                imageview1.setImageResource(R.drawable.jkff1);
                                imageview2.setImageResource(R.drawable.jkff2);
                                imageview3.setImageResource(0);
                                return true;

                            case R.id.rammodule:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "rammodule.txt"));
                                imageview1.setImageResource(R.drawable.ram1);
                                imageview2.setImageResource(R.drawable.ram2);
                                imageview3.setImageResource(R.drawable.ram3);
                                return true;

                            case R.id.rommodule:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "rommodule.txt"));
                                imageview1.setImageResource(R.drawable.rom1);
                                imageview2.setImageResource(R.drawable.rom2);
                                imageview3.setImageResource(R.drawable.rom3);
                                return true;

                            case R.id.fir:
                                imageview.setImageResource(R.drawable.vhdl);
                                help_text.setText(Global.read_file_to_string(VHDL_codes.this, "fir.txt"));
                                imageview1.setImageResource(R.drawable.fir1);
                                imageview2.setImageResource(R.drawable.fir3);
                                imageview3.setImageResource(R.drawable.fir4);
                                return true;


                        }
                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(VHDL_codes.this);
                builder.setTitle("Enter Filename");

                final EditText input = new EditText(VHDL_codes.this);

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        filename = input.getText().toString();
                        write_data = help_text.getText().toString();
                        Global.write_file1(filename, write_data, VHDL_codes.this);
                        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        mgr.hideSoftInputFromWindow(input.getWindowToken(), 0);
                        Toast.makeText(VHDL_codes.this, "VHDL Codes saved in your library, same can be found in storge media also", Toast.LENGTH_LONG).show();

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        mgr.hideSoftInputFromWindow(input.getWindowToken(), 0);
                    }
                });

                builder.show();

            }
        });

    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(VHDL_codes.this, Table_content.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vhdl_codes, menu);
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
