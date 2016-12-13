package com.mlmishra.bhupendramishra.allelectronics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.widget.Toast;
import android.app.Activity;
import android.widget.Button;
import android.view.View;
import android.widget.PopupMenu;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;



public class Ladder_program extends Activity {
    Button button1;
    ImageView imageview;
    TextView help_text;
    String separator = System.getProperty("line.separator");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ladder_program);
        imageview = (ImageView) findViewById(R.id.lpimageview);
        button1 = (Button) findViewById(R.id.buttonp3);
        help_text=(TextView)findViewById(R.id.ltv1);
        help_text.setText("Programmable logic controllers (PLCs) have been an integral part of factory automation and industrial process control for decades. PLCs control a wide array of applications from simple lighting functions to environmental systems to chemical processing plants. These systems perform many functions, providing a variety of analog and digital input and output interfaces; signal processing; data conversion; and various communication protocols. All of the PLC's components and functions are centered around the controller, which is programmed for a specific task."+separator+separator+"The basic PLC module must be sufficiently flexible and configurable to meet the diverse needs of different factories and applications. Input stimuli (either analog or digital) are received from machines, sensors, or process events in the form of voltage or current. The PLC must accurately interpret and convert the stimulus for the CPU which, in turn, defines a set of instructions to the output systems that control actuators on the factory floor or in another industrial environment.");

        button1.setOnClickListener(new OnClickListener() {

           @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Ladder_program.this, button1);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_ladder, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        //Toast.makeText(Ladder_program.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();

                        button1.setText(item.getTitle());
                        switch(item.getItemId())
                        {
                            case R.id.noexmaple:
                               imageview.setImageResource(R.drawable.noexample);
                                help_text.setText("The Symbol shown above is for Normally Open (NO CONTACT). This contact is normally open until some action is performed either by the user or through some sensor. When no action is performed then power will not flow from this switch. Action can be performed by human like clicking a 'PUSH BUTTON' or can be automatic like temparature sensor senses a rise in temparature and automatically closes the contact");
                                return true;
                            case R.id.ncexample:
                                imageview.setImageResource(R.drawable.ncexample);
                                help_text.setText("The Symbol shown above is for Normally Closed (NC CONTACT). This contact is normally closed until some action is performed either by the user or through some sensor. When no action is performed then power is flowing from this switch. Action can be performed by human like clicking a 'PUSH BUTTON' or can be automatic like temparature sensor senses a rise in temparatureand automatically open the contact");
                                return true;
                            case R.id.andexample:
                                imageview.setImageResource(R.drawable.andexample);
                                help_text.setText("The above realizes the function: 'O' = 'A' AND 'B'.This circuit shows two NO switches 'A' and 'B'. When the normally open contacts of both switches close, electricity is able to flow to the Output 'O'.");
                                return true;
                            case R.id.andexample2:
                                imageview.setImageResource(R.drawable.andexample2);
                                help_text.setText("The above realizes the function: 'O' = 'A' AND 'B' AND 'C'.This circuit shows three NO switches 'A' , 'B' and 'C'. When the normally open contacts of all switches close, electricity is able to flow to the Output 'O'.");
                                return true;
                            case R.id.orexample:
                                imageview.setImageResource(R.drawable.orexample);
                                help_text.setText("The above realizes the function: 'O' = 'A' OR 'B'.This circuit shows two NO switches 'A' , 'B'. When the normally open contacts of any switche closes, electricity is able to flow to the Output 'O'.");
                                return true;

                            case R.id.orexample2:
                                imageview.setImageResource(R.drawable.orexample2);
                                help_text.setText("The above realizes the function: 'O' = 'A' OR 'B' OR 'C'.This circuit shows three NO switches 'A' , 'B' and 'C'. When the normally open contacts of any switche closes, electricity is able to flow to the Output 'O'.");
                                return true;
                            case R.id.coil:
                                imageview.setImageResource(R.drawable.coil);
                                help_text.setText("This is an output instruction in PLC Ladder Programming. To make Coil/Output 'Logically High' power must be flow through this coil. In ladder programming a 'Logic' is made from set of 'NO' 'NC' contacts to make a desired interlock for this coil ");
                                return true;
                            case R.id.resetcoil:
                                imageview.setImageResource(R.drawable.resetcoil);
                                help_text.setText("This is an output instruction in PLC Ladder Programming. This Instruction will withdraw power from the coil i.e. no power could flow from the coil. 'please note : This instruction must be used with 'SET COIL' instruction  ");
                                return true;
                            case R.id.setcoil:
                                imageview.setImageResource(R.drawable.setcoil);
                                help_text.setText("This is an output instruction in PLC Ladder Programming. This Instruction will enable power to retain in the coil i.e. Once it get activated through the user logic power will continue to flow in the coil even the logic become false. It is more explained in the next Chapters . 'please note : This instruction must be used with 'RESET COIL' instruction  ");
                                return true;

                            case R.id.logic:
                                imageview.setImageResource(R.drawable.andexample);
                                help_text.setText("To interpret this diagram imagine that the power is on the vertical line on the left hand side, we call this the hot rail. On the right hand side is the neutral rail. In the figure If the inputs are opened or closed in the right combination the power can flow from the hot rail, through the inputs, to power the outputs, and finally to the neutral rail.");
                                return true;

                            case R.id.scan:
                                imageview.setImageResource(R.drawable.scan);
                                help_text.setText("Order of PLC Processor Scan" +separator+separator+"1. Read Physical Inputs"+separator + "2. Scan ladder logic program"+ separator+"Write the physical outputs"+separator+separator+"Scan Time"+separator+separator+ "1. Time to complete above cycle"+separator+"Order of 1-200 milliseconds");
                                return true;






                        }
                        return true;
                    }
                });

                popup.show();//showing popup menu
           }
        });//closing the setOnClickListener method
}


    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Ladder_program.this, Table_content.class);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_ladder, menu);
        return true;
        // Inflate the menu_ladder; this adds items to the action bar if it is present.


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

       return true;
    }



}
