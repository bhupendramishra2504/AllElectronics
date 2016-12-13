package com.mlmishra.bhupendramishra.allelectronics;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;
import android.app.Activity;


public class Calculator extends Activity {
    Button button1,result,save;
    ImageView imageview;
    TextView help_text,ctv1,ctv2,ctv3,ctv4,ctv5,ctv6,ctv7,ctv8;
    EditText cet1,cet2,cet3,cet4,cet5,cet6;
    String filename,write_data;
    boolean cb1,cb2,cb3,cb4,cb5,cvb1,cvb2;
    private int mode=0;
    CheckBox ccb1,ccb2,ccb3,ccb4,ccb5,ccb6;
    private int count=0;
    String separator = System.getProperty("line.separator");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_calculator);
        ctv1=(TextView)findViewById(R.id.ctv1);
        ctv2=(TextView)findViewById(R.id.ctv2);
        ctv3=(TextView)findViewById(R.id.ctv3);
        ctv4=(TextView)findViewById(R.id.ctv4);
        ctv5=(TextView)findViewById(R.id.ctv5);
        ctv6=(TextView)findViewById(R.id.ctv6);
        ctv7=(TextView)findViewById(R.id.ctv7);
        ctv8=(TextView)findViewById(R.id.ctv8);

        cet1=(EditText)findViewById(R.id.cet1);
        cet2=(EditText)findViewById(R.id.cet2);
        cet3=(EditText)findViewById(R.id.cet3);
        cet4=(EditText)findViewById(R.id.cet4);
        cet5=(EditText)findViewById(R.id.cet5);
        cet6=(EditText)findViewById(R.id.cet6);

        ccb1=(CheckBox) findViewById(R.id.ccb1);
        ccb2=(CheckBox) findViewById(R.id.ccb2);
        ccb3=(CheckBox) findViewById(R.id.ccb3);
        ccb4=(CheckBox) findViewById(R.id.ccb4);
        ccb5=(CheckBox) findViewById(R.id.ccb5);
        ccb6=(CheckBox) findViewById(R.id.ccb6);

        allinvisible();

        button1 = (Button) findViewById(R.id.cb1);
        result = (Button) findViewById(R.id.cb2);
        save = (Button) findViewById(R.id.cb3);

        imageview=(ImageView)findViewById(R.id.cimageview);

        help_text=(TextView)findViewById(R.id.ctv);
        help_text.setText("ELECTRONICS CALCULATOR");
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Calculator.this, button1);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_calculator, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(Ladder_program.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();

                        button1.setText(item.getTitle());
                        switch (item.getItemId()) {
                            case R.id.rseries:
                                allinvisible();
                                ctv6.setText("");
                                ctv7.setText("");
                                ctv1.setVisibility(View.VISIBLE);
                                ctv1.setText("R1 (in ohms)");

                                ctv2.setVisibility(View.VISIBLE);
                                ctv2.setText("R2 (in ohms)");

                                ctv3.setVisibility(View.VISIBLE);
                                ctv3.setText("R3 (in ohms)");

                                ctv6.setVisibility(View.VISIBLE);
                                ctv7.setVisibility(View.VISIBLE);

                                cet1.setVisibility(View.VISIBLE);
                                cet2.setVisibility(View.VISIBLE);
                                cet3.setVisibility(View.VISIBLE);
                                mode = 1;
                                imageview.setImageResource(R.drawable.rseries);
                                return true;

                            case R.id.rparallel:
                                allinvisible();
                                ctv6.setText("");
                                ctv7.setText("");
                                ctv1.setVisibility(View.VISIBLE);
                                ctv1.setText("R1 (in ohms)");

                                ctv2.setVisibility(View.VISIBLE);
                                ctv2.setText("R2 (in ohms)");

                                ctv3.setVisibility(View.VISIBLE);
                                ctv3.setText("R3 (in ohms)");

                                ctv6.setVisibility(View.VISIBLE);
                                ctv7.setVisibility(View.VISIBLE);

                                cet1.setVisibility(View.VISIBLE);
                                cet2.setVisibility(View.VISIBLE);
                                cet3.setVisibility(View.VISIBLE);
                                mode = 2;
                                imageview.setImageResource(R.drawable.rparallel);
                                return true;

                            case R.id.cparallel:
                                allinvisible();
                                ctv6.setText("");
                                ctv7.setText("");
                                ctv1.setVisibility(View.VISIBLE);
                                ctv1.setText("C1 (in \u00B5f)");

                                ctv2.setVisibility(View.VISIBLE);
                                ctv2.setText("C2 (in \u00B5f)");

                                ctv3.setVisibility(View.VISIBLE);
                                ctv3.setText("C3 (in \u00B5f)");

                                ctv6.setVisibility(View.VISIBLE);
                                ctv7.setVisibility(View.VISIBLE);

                                cet1.setVisibility(View.VISIBLE);
                                cet2.setVisibility(View.VISIBLE);
                                cet3.setVisibility(View.VISIBLE);
                                mode = 4;
                                imageview.setImageResource(R.drawable.cparallel);
                                return true;

                            case R.id.cseries:
                                allinvisible();
                                ctv6.setText("");
                                ctv7.setText("");
                                ctv1.setVisibility(View.VISIBLE);
                                ctv1.setText("C1 (in µf)");

                                ctv2.setVisibility(View.VISIBLE);
                                ctv2.setText("C2 (in µf)");

                                ctv3.setVisibility(View.VISIBLE);
                                ctv3.setText("C3 (in µf)");

                                ctv6.setVisibility(View.VISIBLE);
                                ctv7.setVisibility(View.VISIBLE);

                                cet1.setVisibility(View.VISIBLE);
                                cet2.setVisibility(View.VISIBLE);
                                cet3.setVisibility(View.VISIBLE);
                                mode = 3;
                                imageview.setImageResource(R.drawable.cseries);
                                return true;

                            case R.id.ohm:
                                allinvisible();
                                ctv6.setText("");
                                ctv7.setText("");
                                ctv1.setVisibility(View.VISIBLE);
                                ctv1.setText("Voltage (in V)");

                                ctv2.setVisibility(View.VISIBLE);
                                ctv2.setText("Current (in A)");

                                ctv3.setVisibility(View.VISIBLE);
                                ctv3.setText("Resistance (in \u2126)");

                                ctv6.setVisibility(View.VISIBLE);
                                ctv7.setVisibility(View.VISIBLE);


                                ccb1.setVisibility(View.VISIBLE);
                                ccb2.setVisibility(View.VISIBLE);
                                ccb3.setVisibility(View.VISIBLE);

                                mode = 5;
                                count = 0;
                                imageview.setImageResource(R.drawable.ohm);
                                return true;

                            case R.id.vdivider:
                                allinvisible();
                                ctv6.setText("");
                                ctv7.setText("");
                                ctv1.setVisibility(View.VISIBLE);
                                ctv1.setText("Vin (in V)");

                                ctv2.setVisibility(View.VISIBLE);
                                ctv2.setText("Vout (in V)");

                                ctv3.setVisibility(View.VISIBLE);
                                ctv3.setText("R1 (in \u2126)");

                                ctv4.setVisibility(View.VISIBLE);
                                ctv4.setText("R2 (in \u2126)");

                                ctv6.setVisibility(View.VISIBLE);
                                ctv7.setVisibility(View.VISIBLE);

                                cet3.setVisibility(View.VISIBLE);
                                cet4.setVisibility(View.VISIBLE);

                                ccb1.setVisibility(View.VISIBLE);
                                ccb2.setVisibility(View.VISIBLE);

                                mode = 6;
                                imageview.setImageResource(R.drawable.vdivider);
                                return true;

                            case R.id.ledcal:
                                allinvisible();
                                ctv6.setText("");
                                ctv7.setText("");
                                ctv1.setVisibility(View.VISIBLE);
                                ctv1.setText("Vin (in V)");

                                ctv2.setVisibility(View.VISIBLE);
                                ctv2.setText("Vled (in V)");


                                ctv3.setVisibility(View.VISIBLE);
                                ctv3.setText("Current through LED (in mA)");

                                ctv4.setVisibility(View.VISIBLE);
                                ctv4.setText("Number of LED's");




                                ctv6.setVisibility(View.VISIBLE);
                                ctv7.setVisibility(View.VISIBLE);

                                cet1.setVisibility(View.VISIBLE);
                                cet2.setVisibility(View.VISIBLE);
                                cet3.setVisibility(View.VISIBLE);
                                cet4.setVisibility(View.VISIBLE);

                                mode = 7;
                                imageview.setImageResource(R.drawable.ledcal);
                                return true;


                            case R.id.rdiode:
                                allinvisible();
                                ctv6.setText("");
                                ctv7.setText("");
                                ctv1.setVisibility(View.VISIBLE);
                                ctv1.setText("Vin (in V)");

                                ctv2.setVisibility(View.VISIBLE);
                                ctv2.setText("Resistance (R1) (in \u2126)");


                                ctv6.setVisibility(View.VISIBLE);
                                ctv7.setVisibility(View.VISIBLE);

                                cet1.setVisibility(View.VISIBLE);
                                cet2.setVisibility(View.VISIBLE);


                                mode = 8;
                                imageview.setImageResource(R.drawable.diode);
                                return true;

                            case R.id.transistor:
                                allinvisible();
                                ctv6.setText("");
                                ctv7.setText("");
                                ctv1.setVisibility(View.VISIBLE);
                                ctv1.setText("Vin (in mV)(p-p sinusodial sig)");

                                ctv2.setVisibility(View.VISIBLE);
                                ctv2.setText("Vcc  (in V)");

                                ctv3.setVisibility(View.VISIBLE);
                                ctv3.setText("Resistance (R1) (in k\u2126)");

                                ctv4.setVisibility(View.VISIBLE);
                                ctv4.setText("Resistance (R2) (in k\u2126)");

                                ctv5.setVisibility(View.VISIBLE);
                                ctv5.setText("Resistance (Rc) (in k\u2126)");

                                ctv8.setVisibility(View.VISIBLE);
                                ctv8.setText("Resistance (Re) (in k\u2126)");




                                ctv6.setVisibility(View.VISIBLE);
                                ctv7.setVisibility(View.VISIBLE);

                                cet1.setVisibility(View.VISIBLE);
                                cet2.setVisibility(View.VISIBLE);
                                cet3.setVisibility(View.VISIBLE);
                                cet4.setVisibility(View.VISIBLE);
                                cet5.setVisibility(View.VISIBLE);
                                cet6.setVisibility(View.VISIBLE);


                                mode = 9;
                                imageview.setImageResource(R.drawable.transistor);
                                return true;


                            case R.id.opampinv:
                                allinvisible();
                                ctv6.setText("");
                                ctv7.setText("");
                                ctv1.setVisibility(View.VISIBLE);
                                ctv1.setText("Vin (in mV)(p-p sinusodial sig)");

                                ctv2.setVisibility(View.VISIBLE);
                                ctv2.setText("Resistance (R1) (in kΩ)");

                                ctv3.setVisibility(View.VISIBLE);
                                ctv3.setText("Resistance (Rf) (in kΩ)");



                                ctv6.setVisibility(View.VISIBLE);
                                ctv7.setVisibility(View.VISIBLE);

                                cet1.setVisibility(View.VISIBLE);
                                cet2.setVisibility(View.VISIBLE);
                                cet3.setVisibility(View.VISIBLE);


                                mode = 10;
                                imageview.setImageResource(R.drawable.opampinv);
                                return true;

                            case R.id.opampninv:
                                allinvisible();
                                ctv6.setText("");
                                ctv7.setText("");
                                ctv1.setVisibility(View.VISIBLE);
                                ctv1.setText("Vin (in mV)(p-p sinusodial sig)");

                                ctv2.setVisibility(View.VISIBLE);
                                ctv2.setText("Resistance (R1) (in kΩ)");

                                ctv3.setVisibility(View.VISIBLE);
                                ctv3.setText("Resistance (Rf) (in kΩ)");



                                ctv6.setVisibility(View.VISIBLE);
                                ctv7.setVisibility(View.VISIBLE);

                                cet1.setVisibility(View.VISIBLE);
                                cet2.setVisibility(View.VISIBLE);
                                cet3.setVisibility(View.VISIBLE);


                                mode = 11;
                                imageview.setImageResource(R.drawable.opampninv);
                                return true;


                            case R.id.opamplpf:
                                allinvisible();
                                ctv6.setText("");
                                ctv7.setText("");
                                ctv1.setVisibility(View.VISIBLE);
                                ctv1.setText("Vin (in mV)(p-p sinusodial sig)");

                                ctv2.setVisibility(View.VISIBLE);
                                ctv2.setText("Resistance (R3) (in kΩ)");

                                ctv3.setVisibility(View.VISIBLE);
                                ctv3.setText("Capacitance (C1) (in µF)");

                                ctv4.setVisibility(View.VISIBLE);
                                ctv4.setText("Resistance (R1) (in kΩ)");

                                ctv5.setVisibility(View.VISIBLE);
                                ctv5.setText("Resistance (R2) (in kΩ)");

                                ctv8.setVisibility(View.VISIBLE);
                                ctv8.setText("FREQ I/p SIGNAL (R2) (in Hz)");



                                ctv6.setVisibility(View.VISIBLE);
                                ctv7.setVisibility(View.VISIBLE);

                                cet1.setVisibility(View.VISIBLE);
                                cet2.setVisibility(View.VISIBLE);
                                cet3.setVisibility(View.VISIBLE);
                                cet4.setVisibility(View.VISIBLE);
                                cet5.setVisibility(View.VISIBLE);
                                cet6.setVisibility(View.VISIBLE);



                                mode = 12;
                                imageview.setImageResource(R.drawable.opamplpf);
                                return true;




                        }
                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });

        ccb1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Perform action on clicks, depending on whether it's now checked
                if (mode == 5)
                {
                    if (!(cb2 && cb3)) {
                        if (((CheckBox) v).isChecked()) {
                            cb1 = true;
                            cet1.setVisibility(View.VISIBLE);
                        } else {
                            cb1 = false;
                            cet1.setVisibility(View.INVISIBLE);
                        }
                    }


                if (cb2 && cb3) {
                    ccb1.setChecked(false);

                }
            }
                else if(mode==6)
                {
                    if (!cvb2) {
                        if (((CheckBox) v).isChecked()) {
                            cvb1 = true;
                            cet1.setVisibility(View.VISIBLE);
                            ccb2.setChecked(false);
                        } else {
                            cvb1 = false;
                            cet1.setVisibility(View.INVISIBLE);

                        }
                    }
                    if(cvb2)
                        ccb1.setChecked(false);



                }
        }
        });

        ccb2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Perform action on clicks, depending on whether it's now checked
                if (mode == 5) {
                    if (!(cb1 && cb3)) {
                        if (((CheckBox) v).isChecked()) {
                            cb2 = true;
                            cet2.setVisibility(View.VISIBLE);
                        } else {
                            cb2 = false;
                            cet2.setVisibility(View.INVISIBLE);
                        }
                    }


                    if (cb1 && cb3) {
                        ccb2.setChecked(false);

                    }
                }
                else if(mode==6)
                {

                    if (!cvb1) {
                        if (((CheckBox) v).isChecked()) {
                            cvb2 = true;
                            cet2.setVisibility(View.VISIBLE);
                            ccb1.setChecked(false);
                        } else {
                            cvb2 = false;
                            cet2.setVisibility(View.INVISIBLE);

                        }
                    }
                    if(cvb1)
                        ccb2.setChecked(false);


                }
            }
        });

        ccb3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Perform action on clicks, depending on whether it's now checked
                if (mode == 5) {
                    if (!(cb1 && cb2)) {
                        if (((CheckBox) v).isChecked()) {
                            cb3 = true;
                            cet3.setVisibility(View.VISIBLE);
                        } else {
                            cb3 = false;
                            cet3.setVisibility(View.INVISIBLE);
                        }
                    } else {
                        ccb3.setChecked(false);

                    }
                }
            }
        });

        result.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ctv6.setText("");
                ctv7.setText("");

                if (mode == 1) {

                    float r1 = 0, r2 = 0, r3 = 0, r4;
                    if (!cet1.getText().toString().equals("")) {
                        r1 = Float.parseFloat(cet1.getText().toString());
                    }
                    if (!cet2.getText().toString().equals("")) {
                        r2 = Float.parseFloat(cet2.getText().toString());
                    }
                    if (!cet3.getText().toString().equals("")) {
                        r3 = Float.parseFloat(cet3.getText().toString());
                    }
                    r4 = r1 + r2 + r3;
                    ctv6.setText("Results : " + String.valueOf(r4));
                    ctv7.setText("Calculation : " + separator + separator + "REQUIVALENT = R1+R2+R3" + separator + "REQUIVALENT = " + String.valueOf(r1) + "+" + String.valueOf(r2) + "+" + String.valueOf(r3) + separator + "REQUIVALENT = " + String.valueOf(r4) + "ohms");

                } else if (mode == 2) {

                    float r1 = 0, r2 = 0, r3 = 0, r4;
                    if (!cet1.getText().toString().equals("")) {
                        r1 = Float.parseFloat(cet1.getText().toString());
                    }
                    if (!cet2.getText().toString().equals("")) {
                        r2 = Float.parseFloat(cet2.getText().toString());
                    }
                    if (!cet3.getText().toString().equals("")) {
                        r3 = Float.parseFloat(cet3.getText().toString());
                    }
                    Log.d("value of R1", String.valueOf(r1));
                    Log.d("value of R2", String.valueOf(r2));
                    Log.d("value of R3", String.valueOf(r3));
                    if (r1 != 0.0 && r2 != 0.0 && r3 != 0.0) {
                        r4 = r1 * r2 * r3 / (r1 * r2 + r1 * r3 + r3 * r2);
                        ctv6.setText("Results : " + String.valueOf(r4));
                        ctv7.setText("Calculation : " + separator + separator + "1/REQUIVALENT = 1/R1+1/R2+1/R3" + separator + "1/Requivalent=(R2*R3+R1*R3+R1*R2)/R1*R2*R3" + separator + "Requivalent=R1*R2*R3/(R2*R3+R1*R3+R1*R2)" + separator + "REQUIVALENT = " + String.valueOf(r4) + "ohms");
                    } else if (r1 == 0.0) {
                        r4 = r2 * r3 / (r2 + r3);
                        ctv6.setText("Results : " + String.valueOf(r4));
                        ctv7.setText("Calculation : " + separator + separator + "1/REQUIVALENT = 1/R2+1/R3" + separator + "1/Requivalent=(R2+R3)/R2*R3" + separator + "Requivalent=R2*R3/(R2+R3)" + separator + "REQUIVALENT = " + String.valueOf(r4) + "ohms");

                    } else if (r2 == 0.0) {
                        r4 = r1 * r3 / (r1 + r3);
                        ctv6.setText("Results : " + String.valueOf(r4));
                        ctv7.setText("Calculation : " + separator + separator + "1/REQUIVALENT = 1/R1+1/R3" + separator + "1/Requivalent=(R1+R3)/R1*R3" + separator + "Requivalent=R1*R3/(R1+R3)" + separator + "REQUIVALENT = " + String.valueOf(r4) + "ohms");

                    } else if (r3 == 0.0) {
                        r4 = r2 * r1 / (r2 + r1);
                        ctv6.setText("Results : " + String.valueOf(r4));
                        ctv7.setText("Calculation : " + separator + separator + "1/REQUIVALENT = 1/R2+1/R1" + separator + "1/Requivalent=(R2+R1)/R2*R1" + separator + "Requivalent=R2*R1/(R2+R1)" + separator + "REQUIVALENT = " + String.valueOf(r4) + "ohms");

                    } else if (r3 == 0.0 && r1 == 0.0 && r2 == 0.0) {
                        Toast.makeText(Calculator.this, "Invalid inputs", Toast.LENGTH_LONG).show();
                    }


                } else if (mode == 3) {

                    float c1 = 0, c2 = 0, c3 = 0, c4;
                    if (!cet1.getText().toString().equals("")) {
                        c1 = Float.parseFloat(cet1.getText().toString());
                    }
                    if (!cet2.getText().toString().equals("")) {
                        c2 = Float.parseFloat(cet2.getText().toString());
                    }
                    if (!cet3.getText().toString().equals("")) {
                        c3 = Float.parseFloat(cet3.getText().toString());
                    }
                    Log.d("value of C1", String.valueOf(c1));
                    Log.d("value of C2", String.valueOf(c2));
                    Log.d("value of C3", String.valueOf(c3));
                    if (c1 != 0.0 && c2 != 0.0 && c3 != 0.0) {
                        c4 = c1 * c2 * c3 / (c1 * c2 + c1 * c3 + c3 * c2);
                        ctv6.setText("Results : " + String.valueOf(c4));
                        ctv7.setText("Calculation : " + separator + separator + "1/Cequivalent = 1/C1+1/C2+1/C3" + separator + "1/Cequivalent=(C2*C3+C1*C3+C1*C2)/C1*C2*C3" + separator + "Cequivalent=C1*C2*C3/(C2*C3+C1*C3+C1*C2)" + separator + "Cequivalent = " + String.valueOf(c4) + " \u00B5f");
                    } else if (c1 == 0.0) {
                        c4 = c2 * c3 / (c2 + c3);
                        ctv6.setText("Results : " + String.valueOf(c4));
                        ctv7.setText("Calculation : " + separator + separator + "1/Cequivalent = 1/C2+1/C3" + separator + "1/Cequivalent=(C2+C3)/C2*C3" + separator + "Cequivalent=C2*C3/(C2+C3)" + separator + "Cequivalent = " + String.valueOf(c4) + "\u00B5f");

                    } else if (c2 == 0.0) {
                        c4 = c1 * c3 / (c1 + c3);
                        ctv6.setText("Results : " + String.valueOf(c4));
                        ctv7.setText("Calculation : " + separator + separator + "1/CEQUIVALENT = 1/C1+1/C3" + separator + "1/Cequivalent=(C1+C3)/C1*C3" + separator + "Requivalent=C1*C3/(C1+C3)" + separator + "CEQUIVALENT = " + String.valueOf(c4) + "µf");

                    } else if (c3 == 0.0) {
                        c4 = c2 * c1 / (c2 + c1);
                        ctv6.setText("Results : " + String.valueOf(c4));
                        ctv7.setText("Calculation : " + separator + separator + "1/CEQUIVALENT = 1/C2+1/C1" + separator + "1/Cequivalent=(C2+C1)/C2*C1" + separator + "Cequivalent=C2*C1/(C2+C1)" + separator + "CEQUIVALENT = " + String.valueOf(c4) + "µf");

                    } else if (c3 == 0.0 && c1 == 0.0 && c2 == 0.0) {
                        Toast.makeText(Calculator.this, "Invalid inputs", Toast.LENGTH_LONG).show();
                    }
                } else if (mode == 4) {

                    float c1 = 0, c2 = 0, c3 = 0, c4;
                    if (!cet1.getText().toString().equals("")) {
                        c1 = Float.parseFloat(cet1.getText().toString());
                    }
                    if (!cet2.getText().toString().equals("")) {
                        c2 = Float.parseFloat(cet2.getText().toString());
                    }
                    if (!cet3.getText().toString().equals("")) {
                        c3 = Float.parseFloat(cet3.getText().toString());
                    }
                    c4 = c1 + c2 + c3;
                    ctv6.setText("Results : " + String.valueOf(c4));
                    ctv7.setText("Calculation : " + separator + separator + "REQUIVALENT = C1+C2+C3" + separator + "REQUIVALENT = " + String.valueOf(c1) + "+" + String.valueOf(c2) + "+" + String.valueOf(c3) + separator + "REQUIVALENT = " + String.valueOf(c4) + "ohms");

                } else if (mode == 5) {


                    float v1 = 0, r1 = 0, i1 = 0, result;
                    if (cb1 && cb2) {
                        if (!cet1.getText().toString().equals("") && !cet2.getText().toString().equals("")) {
                            v1 = Float.parseFloat(cet1.getText().toString());
                            i1 = Float.parseFloat(cet2.getText().toString());
                            r1 = v1 / i1;
                            ctv6.setText("Results : " + String.valueOf(r1) + "\u2126");
                            ctv7.setText("Calculation : " + separator + separator + "Given Values" + separator + "Voltage (V1) = " + String.valueOf(v1) + "V" + separator + "Current (I1) = " + String.valueOf(i1) + "A" + separator + separator + "Resistance (R1)= Voltage (V1)/Current (I1)" + separator + separator + "Resistance (R1) = " + String.valueOf(r1) + "Ω");


                        } else
                            Toast.makeText(Calculator.this, "Invalid inputs", Toast.LENGTH_LONG).show();

                    } else if (cb2 && cb3) {
                        if (!cet2.getText().toString().equals("") && !cet3.getText().toString().equals("")) {
                            i1 = Float.parseFloat(cet2.getText().toString());
                            r1 = Float.parseFloat(cet3.getText().toString());
                            v1 = i1 * r1;
                            ctv6.setText("Results : " + String.valueOf(v1) + "V");
                            ctv7.setText("Calculation : " + separator + separator + "Given Values" + separator + "Current (I1) = " + String.valueOf(i1) + "A" + separator + "Resistance (R1) = " + String.valueOf(i1) + "\u2126" + separator + separator + "Voltage (V1)= Resistance (R1)*Current (I1)" + separator + separator + "Voltage (V1) = " + String.valueOf(v1) + "V");


                        } else
                            Toast.makeText(Calculator.this, "Invalid inputs", Toast.LENGTH_LONG).show();


                    } else if (cb3 && cb1) {
                        if (!cet1.getText().toString().equals("") && !cet3.getText().toString().equals("")) {
                            v1 = Float.parseFloat(cet1.getText().toString());
                            r1 = Float.parseFloat(cet3.getText().toString());
                            i1 = v1 / r1;
                            ctv6.setText("Results : " + String.valueOf(i1) + "A");
                            ctv7.setText("Calculation : " + separator + separator + "Given Values" + separator + "Voltage (V1) = " + String.valueOf(v1) + "V" + separator + "Resistance (R1) = " + String.valueOf(i1) + "\u2126" + separator + separator + "Current (I1)= Voltage (V1)/Resitance (R1)" + separator + separator + "Current (I1) = " + String.valueOf(v1) + "A");


                        } else
                            Toast.makeText(Calculator.this, "Invalid inputs", Toast.LENGTH_LONG).show();

                    }


                } else if (mode == 6) {


                    float vin = 0, vout = 0, r1 = 0, r2 = 0, i;
                    if (cvb1) {
                        if (!cet1.getText().toString().equals("") && !cet3.getText().toString().equals("") && !cet4.getText().toString().equals("")) {
                            vin = Float.parseFloat(cet1.getText().toString());
                            r1 = Float.parseFloat(cet3.getText().toString());
                            r2 = Float.parseFloat(cet4.getText().toString());

                            i = vin / (r1 + r2);
                            vout = i * r2;
                            ctv6.setText("Results : " + separator + "Current : " + String.valueOf(i) + "A" + separator + "Vout : " + String.valueOf(vout) + "v");
                            ctv7.setText("Calculation : " + separator + separator + "Given Values" + separator + "Vin (V1) = " + String.valueOf(vin) + "V" + separator + "R1  = " + String.valueOf(r1) + "\u2126" + separator + "R2  = " + String.valueOf(r2) + "\u2126" + separator + separator + "I= Vin/(R1+R2)" + separator + separator + "Vout =I*R2 " + separator + separator + "Vout = " + String.valueOf(vout) + "v" + separator + separator + "I= " + String.valueOf(i));


                        } else
                            Toast.makeText(Calculator.this, "Invalid inputs", Toast.LENGTH_LONG).show();

                    } else {
                        if (!cet2.getText().toString().equals("") && !cet3.getText().toString().equals("") && !cet4.getText().toString().equals("")) {
                            vout = Float.parseFloat(cet2.getText().toString());
                            r1 = Float.parseFloat(cet3.getText().toString());
                            r2 = Float.parseFloat(cet4.getText().toString());

                            i = vout / (r2);
                            vin = i * (r1 + r2);
                            ctv6.setText("Results : " + separator + "Current : " + String.valueOf(i) + "A" + separator + "Vin : " + String.valueOf(vin) + "v");
                            ctv7.setText("Calculation : " + separator + separator + "Given Values" + separator + "Vout  = " + String.valueOf(vout) + "V" + separator + "R1  = " + String.valueOf(r1) + "\u2126" + separator + "R2  = " + String.valueOf(r2) + "\u2126" + separator + separator + "I= Vout/R2" + separator + separator + "Vin =I*(R1+R2) " + separator + separator + "Vin = " + String.valueOf(vin) + "v" + separator + separator + "I= " + String.valueOf(i) + "A");


                        } else
                            Toast.makeText(Calculator.this, "Invalid inputs", Toast.LENGTH_LONG).show();

                    }


                } else if (mode == 7) {


                    float vin = 0, vled = 0, iled = 0, r, rled;
                    int num_led;

                    if (!cet1.getText().toString().equals("") && !cet2.getText().toString().equals("") && !cet3.getText().toString().equals("") && !cet4.getText().toString().equals("")) {
                        vin = Float.parseFloat(cet1.getText().toString());
                        vled = Float.parseFloat(cet2.getText().toString());
                        iled = Float.parseFloat(cet3.getText().toString());
                        num_led = Integer.parseInt(cet4.getText().toString());

                        rled = vled * num_led / iled;
                        r = (vin - num_led*vled)*1000 / iled;

                        if(r>0) {
                            ctv6.setText("Results : " + separator + "Resistance required is : " + String.valueOf(r) + " \u2126");
                            ctv7.setText("Calculation : " + separator + separator + "Given Values" + separator + "Vin (V1) = " + String.valueOf(vin) + "V" + separator + "Voltage of LED  = " + String.valueOf(vled) + "v" + separator + "Current flowing through led I(in mA)  = " + String.valueOf(iled) + " mA" + separator + separator + "R= (Vin-num_led*vled)*1000/I" + separator + separator + "R1 = " + String.valueOf(r) + " \u2126");
                        }
                        else
                            Toast.makeText(Calculator.this, "Circuit not possible check number of led's field", Toast.LENGTH_LONG).show();

                    }
                    else
                        Toast.makeText(Calculator.this, "Invalid inputs", Toast.LENGTH_LONG).show();

                }

                else if (mode == 8) {


                    float vin = 0, r = 0, i = 0;


                    if (!cet1.getText().toString().equals("") && !cet2.getText().toString().equals("")) {
                        vin = Float.parseFloat(cet1.getText().toString());
                        r = Float.parseFloat(cet2.getText().toString());
                        i=(float)((vin-0.7)/r);

                            ctv6.setText("Results : " + separator + "Current flowed is : " + String.valueOf(i) + "A");
                            ctv7.setText("Calculation : " + separator + separator + "Given Values" + separator + "Vin (V1) = " + String.valueOf(vin) + "V" + separator + "Resistance (R1)  = " + String.valueOf(r) + " \u2126" + separator + "Current flowing through circuit is (I) = (vin-0.7)/R1"  + separator + separator + "I= " +  String.valueOf(i) + " A");

                    }
                    else
                        Toast.makeText(Calculator.this, "Invalid inputs", Toast.LENGTH_LONG).show();

                }

                else if (mode == 9) {


                    float vin = 0, vcc = 0, r1 = 0,r2=0,rc=0,re=0,i1=0,ie=0,ic=0,ibac,icac,vout,vout1,icsat,a;
                    double vbe=0.7,vb,rpi=25;
                    int b=100;


                    if (!cet1.getText().toString().equals("") && !cet2.getText().toString().equals("") && !cet3.getText().toString().equals("") && !cet4.getText().toString().equals("") && !cet5.getText().toString().equals("") && !cet6.getText().toString().equals("")) {
                        vin = Float.parseFloat(cet1.getText().toString());
                        vcc = Float.parseFloat(cet2.getText().toString());
                        r1 = Float.parseFloat(cet3.getText().toString());
                        r2 = Float.parseFloat(cet4.getText().toString());
                        rc = Float.parseFloat(cet5.getText().toString());
                        re = Float.parseFloat(cet6.getText().toString());
                        String vout_unit="mV";

                        i1=vcc/(r1+r2);
                        vb=i1*r2;
                        ie=(float)((vb-vbe)/re);
                        ic=b*ie/(b+1);

                        icsat=(float)((vcc-0.2)/(rc+re));

                        ibac=(float)(vin/re);
                        icac=ibac;
                        vout=icac*rc;
                        vout1=vout;
                        Log.d("vout",String.valueOf(vout));
                        if(vout>1000) {
                            vout = vout / 1000;
                            vout_unit="V";
                        }

                        if(vout1>vcc*1000)
                            Toast.makeText(Calculator.this,"Signal Saturated not amplified fully",Toast.LENGTH_LONG).show();
                        else {
                            a=vout1/vin;
                            ctv6.setText("Results : " + separator + "Amplified Signal is : " + String.valueOf(vout) + vout_unit +"peak to peak AC Signal"+separator+"Voltage gain=Vout/Vin"+separator+"Voltage Gain (A)="+String.valueOf(a));
                            ctv7.setText("Calculation : " + separator + separator + "Given Values" + separator + "Vin (V1) = " + String.valueOf(vin) + " mV (peak to peak sinusodial signal)" + separator + "Vcc  = " + String.valueOf(vcc) + "v (Biasing Voltage)" + separator + "R1 (Biasing resistance =" + String.valueOf(r1)+" k\u2126"+ separator+"R2 (Biasing resistance =" + String.valueOf(r2)+" k\u2126"+separator+ "Rc (Collector) resistance =" + String.valueOf(rc)+" k\u2126"+ separator+"Re (Emitter resistance =" + String.valueOf(re)+" k\u2126"+ separator+"Assumed value of \u03B2 = 100"+separator + separator + "DC Analysis" + separator+"In DC Analysis all AC sources are removed and all capacitors are open circuited"+separator+separator+"Bias Voltage (Vb) = Vcc*R2/(R1+R2)"+separator+"Vb= "+String.valueOf(vb)+"v"+separator+"Emitter Current (Ie) =(Vb-Vbe)/Re"+separator+"Ie= "+String.valueOf(ie)+"mA"+separator+"Collector Current (Ic)= \u03B2*Ie/(\u03B2+1)"+separator+"Ic="+String.valueOf(ic)+"mA"+separator+separator+"AC ANALYSIS"+separator+separator+"For AC analysis all DC Sources should be grounded and all Capacitances should be Short circuited"+separator+separator+"Emitter AC Current (Ibac) = Vin/(r\u03c0+re)"+separator+"Ieac= "+String.valueOf(ibac)+"mA"+separator+"Collector AC current (Icac)=\u03B2*Ieac/(\u03B2+1)"+separator+"Vout=Icac*Rc"+separator+"vout= "+String.valueOf(vout)+vout_unit+separator+"Voltage Gain = Vout/Vin"+separator+"Voltage gain (A) = "+String.valueOf(a));
                        }

                    }
                    else
                        Toast.makeText(Calculator.this, "Invalid inputs", Toast.LENGTH_LONG).show();

                }

                else if(mode==10)
                {
                    float vin = 0, r1 = 0, rf = 0, vout=0,g=0;
                    String unit="mV";

                    if (!cet1.getText().toString().equals("") && !cet2.getText().toString().equals("") && !cet3.getText().toString().equals("")) {
                        vin = Float.parseFloat(cet1.getText().toString());
                        r1 = Float.parseFloat(cet2.getText().toString());
                        rf = Float.parseFloat(cet3.getText().toString());

                        vout=-rf*vin/r1;
                        g=vout/vin;

                        if(vout>5000)
                        {
                            vout=5000;
                        }

                        if(vout>=1000)
                        {
                            vout=vout/1000;
                            unit="V";
                        }




                        ctv6.setText("Results : " + separator + "Output Volatge  is : " + String.valueOf(vout) + unit);
                        ctv7.setText("Calculation : " + separator + separator + "Given Values" + separator + "Vin (V1) = " + String.valueOf(vin) + "mV" + separator + "Resistance (R1)  = " + String.valueOf(r1) + " k\u2126" + separator +"Resistance (Rf)  = " + String.valueOf(rf) + " k\u2126"+separator+ "Output Voltage (Vout) = -Vin*Rf/R1"+separator+"Assuming supply voltage be 5V then Peak-to-peak output voltage cannot be greater than 5V, hence if -vin*Rf/R1 is greater than 5v then output will be clipped to 5V" + separator + separator + "Vout= " +  String.valueOf(vout) + unit+separator+"Voltage Gain (G)=vout/vin"+separator+"G="+String.valueOf(g));

                    }
                    else
                        Toast.makeText(Calculator.this, "Invalid inputs", Toast.LENGTH_LONG).show();

                }

                else if(mode==11)
                {
                    float vin = 0, r1 = 0, rf = 0, vout=0,g=0;
                    String unit="mV";

                    if (!cet1.getText().toString().equals("") && !cet2.getText().toString().equals("") && !cet3.getText().toString().equals("")) {
                        vin = Float.parseFloat(cet1.getText().toString());
                        r1 = Float.parseFloat(cet2.getText().toString());
                        rf = Float.parseFloat(cet3.getText().toString());

                        vout=vin*(1+rf/r1);
                        g=vout/vin;

                        if(vout>5000)
                        {
                            vout=5000;
                        }

                        if(vout>=1000)
                        {
                            vout=vout/1000;
                            unit="V";
                        }




                        ctv6.setText("Results : " + separator + "Output Volatge  is : " + String.valueOf(vout) + unit);
                        ctv7.setText("Calculation : " + separator + separator + "Given Values" + separator + "Vin (V1) = " + String.valueOf(vin) + "mV" + separator + "Resistance (R1)  = " + String.valueOf(r1) + " k\u2126" + separator +"Resistance (Rf)  = " + String.valueOf(rf) + " k\u2126"+separator+ "Output Voltage (Vout) = -Vin*Rf/R1"+separator+"Assuming supply voltage be 5V then Peak-to-peak output voltage cannot be greater than 5V, hence if vin*(1+Rf/R1) is greater than 5v then output will be clipped to 5V" + separator + separator + "Vout= " +  String.valueOf(vout) + unit+separator+"Voltage Gain (G)=vout/vin"+separator+"G="+String.valueOf(g));

                    }
                    else
                        Toast.makeText(Calculator.this, "Invalid inputs", Toast.LENGTH_LONG).show();

                }


                else if(mode==12)
                {
                    float vin = 0, r1 = 0, r2 = 0,c1=0,r3=0, vout=0,g=0,Avdc=0,fc=0,f=50;
                    String unit="mV";

                    if (!cet1.getText().toString().equals("") && !cet2.getText().toString().equals("") && !cet3.getText().toString().equals("") && !cet4.getText().toString().equals("") && !cet5.getText().toString().equals("")) {
                        vin = Float.parseFloat(cet1.getText().toString());
                        r3 = Float.parseFloat(cet2.getText().toString());
                        c1 = Float.parseFloat(cet3.getText().toString());
                        r1 = Float.parseFloat(cet4.getText().toString());
                        r2 = Float.parseFloat(cet5.getText().toString());
                        f = Float.parseFloat(cet6.getText().toString());

                        Avdc=(1+r2/r1);
                        fc=(float)(1000/(6.28*r3*c1));
                        vout=Avdc*vin/(float)(Math.sqrt((1+Math.pow(f/fc,2))));

                        g=vout/vin;

                        if(vout>5000)
                        {
                            vout=5000;
                        }

                        if(vout>=1000)
                        {
                            vout=vout/1000;
                            unit="V";
                        }




                        ctv6.setText("Results : " + separator + "Output Volatge  is : " + String.valueOf(vout) + unit);
                        ctv7.setText("Calculation : " + separator + separator + "Given Values" + separator + "Vin (V1) = " + String.valueOf(vin) + "mV" + separator + "Resistance (R1)  = " + String.valueOf(r1) + " k\u2126" + separator +"Resistance (R2)  = " + String.valueOf(r2) + " k\u2126"+separator+"Resistance (R3)  = " + String.valueOf(r3) + " k\u2126"+separator+"CAPACITOR (C1) = "+String.valueOf(c1)+"µF"+separator+"Input Signal Frequency (F1) = "+String.valueOf(f)+"kHz"+separator+"CUTOFF FREQUENCY (fc) = 1/2\u03C0R3C1"+separator+"fc="+String.valueOf(fc)+"Hz"+separator+ "DC GAIN  = (1+R2/R1)"+separator+"Assuming supply voltage be 5V then Peak-to-peak output voltage cannot be greater than 5V, hence if vin*(1+Rf/R1) is greater than 5v then output will be clipped to 5V" +separator+"Vout=Avdc*vin/sqrt(1+(f/fc)^2) where fc=1/2*pi*R3*C1"+ separator + separator + "Vout= " +  String.valueOf(vout) + unit+separator);
                    }
                    else
                        Toast.makeText(Calculator.this, "Invalid inputs", Toast.LENGTH_LONG).show();

                }

            }
        });


        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Calculator.this);
                builder.setTitle("Enter Filename");

                final EditText input = new EditText(Calculator.this);

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        filename = input.getText().toString();
                        write_data = ctv7.getText().toString();
                        Global.write_file1(filename, write_data, Calculator.this);
                        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        mgr.hideSoftInputFromWindow(input.getWindowToken(), 0);
                        Toast.makeText(Calculator.this, "Calculations saved in your library, same can be found in storge media also", Toast.LENGTH_LONG).show();

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

    public void allinvisible()
    {
        ctv1.setVisibility(View.INVISIBLE);
        ctv2.setVisibility(View.INVISIBLE);
        ctv3.setVisibility(View.INVISIBLE);
        ctv4.setVisibility(View.INVISIBLE);
        ctv5.setVisibility(View.INVISIBLE);
        ctv6.setVisibility(View.INVISIBLE);
        ctv7.setVisibility(View.INVISIBLE);
        ctv8.setVisibility(View.INVISIBLE);

        cet1.setVisibility(View.INVISIBLE);
        cet2.setVisibility(View.INVISIBLE);
        cet3.setVisibility(View.INVISIBLE);
        cet4.setVisibility(View.INVISIBLE);
        cet5.setVisibility(View.INVISIBLE);
        cet6.setVisibility(View.INVISIBLE);

        ccb1.setVisibility(View.INVISIBLE);
        ccb2.setVisibility(View.INVISIBLE);
        ccb3.setVisibility(View.INVISIBLE);
        ccb4.setVisibility(View.INVISIBLE);
        ccb5.setVisibility(View.INVISIBLE);
        ccb6.setVisibility(View.INVISIBLE);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
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
