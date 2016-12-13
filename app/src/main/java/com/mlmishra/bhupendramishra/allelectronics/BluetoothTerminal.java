package com.mlmishra.bhupendramishra.allelectronics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import android.bluetooth.BluetoothDevice;
import android.app.Activity;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.UUID;
import android.bluetooth.BluetoothSocket;
import android.widget.Toast;

import java.io.InputStream;
import java.io.OutputStream;
import android.os.Handler;
import android.widget.ProgressBar;

public class BluetoothTerminal extends AppCompatActivity {
    BluetoothAdapter mBluetoothAdapter;
    TextView status,rx_tv;
    private ArrayAdapter<String> madapter;
    private ListView lv;
    ArrayList<String> devices=new ArrayList<String>();
    String separator = System.getProperty("line.separator");
    BluetoothDevice mmDevice,pairedDevices;
    Button send,rx;
    EditText send_et;
    InputStream mmInputStream;
    OutputStream mmOutputStream;
    ProgressBar spinner;
    BluetoothSocket mmSocket;
    final  UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); //Standard SerialPortService ID
    String data="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_terminal);
        status=(TextView)findViewById(R.id.status);
        rx_tv=(TextView)findViewById(R.id.rx_tv);
        send=(Button)findViewById(R.id.send);
        rx=(Button)findViewById(R.id.rx);
        send_et=(EditText)findViewById(R.id.send_et);
        status.append("Status : "+separator);
        lv = (ListView) findViewById(R.id.device_list);
        madapter = new ArrayAdapter<String>(this, R.layout.bt_list,R.id.bt_list_tv, devices);
        rx_tv.setText("No Data Rx");
        spinner = (ProgressBar)findViewById(R.id.aprogressBar);
        spinner.setVisibility(View.GONE);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(!mBluetoothAdapter.isEnabled())
        {
            status.append("Turning on bluetooth....."+separator);
            Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluetooth, 0);
        }
        else
        {
            status.append("Bluetooth is turned ON....."+separator);
        }

        getDevices();
        lv.setAdapter(madapter);
        registerForContextMenu(lv);
        lv.invalidateViews();

        send.setEnabled(false);
        send_et.setEnabled(false);
        rx.setEnabled(false);
        rx_tv.setEnabled(false);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                lv.setVisibility(View.GONE);
                String product = ((TextView) view).getText().toString();
                Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

                for (BluetoothDevice device : pairedDevices) {
                    if (device.getName().equalsIgnoreCase(product)) {
                        Global.Bluetooth_device_name=product;

                        mmDevice = device;
                        //config_bluetooth();
                        //spinner.setVisibility(View.GONE);
                        try {
                            mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
                        }
                        catch(IOException io)
                        {
                            status.append("Communication can not be created "+separator);
                        }

                        switchUI();
                        send.setEnabled(true);
                        send_et.setEnabled(true);
                        rx.setEnabled(true);
                        rx_tv.setEnabled(true);

                    }
                }
                status.append("Bluetooth Device Selected : " + product + separator);

            }
        });
        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                send_data(send_et.getText().toString());
                //lv.setVisibility(View.VISIBLE);
                //Toast.makeText(MainActivity.this, "Data send through bluetooth", Toast.LENGTH_LONG).show();


            }


        });

        rx.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                // recieve_data();
                switchUI();
                //rx_tv.append(data+separator);
                //Toast.makeText(MainActivity.this,"Data send through bluetooth", Toast.LENGTH_LONG).show();


            }



        });




    }

    @Override
    public void onBackPressed() {

        // your code.
        if(mmSocket!=null) {
            try {
                mmSocket.close();
                Toast.makeText(BluetoothTerminal.this, "Active Connection Closed", Toast.LENGTH_LONG).show();
            } catch (IOException io) {
                Toast.makeText(BluetoothTerminal.this, "Active Connection cannot be Closed", Toast.LENGTH_LONG).show();
            }
            Intent intent = new Intent(BluetoothTerminal.this, Table_content.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Intent intent = new Intent(BluetoothTerminal.this, Table_content.class);
            startActivity(intent);
            finish();
        }
    }



    private void config_bluetooth()
    {
        //spinner.setVisibility(View.VISIBLE);
        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); //Standard SerialPortService ID
        try {
            // mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);

            if(!mmSocket.isConnected()) {
                mmSocket.connect();
            }

            mmOutputStream = mmSocket.getOutputStream();
            mmInputStream = mmSocket.getInputStream();
            // spinner.setVisibility(View.GONE);

        }
        catch(IOException io)
        {
            Toast.makeText(BluetoothTerminal.this,"Error Connecting Socket: "+io.getMessage(), Toast.LENGTH_LONG).show();
            // spinner.setVisibility(View.GONE);
        }

    }


    private void recieve_data()
    {



        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); //Standard SerialPortService ID

        try {
            if (!mmSocket.isConnected()) {
                status.append("Socket connecting : please wait " + separator);
                mmSocket.connect();

            } else {
                status.append("Socket already connected " + separator);
            }
            if (mmSocket.isConnected()) {
                status.append("Socket connected " + separator);


                mmOutputStream = mmSocket.getOutputStream();
                mmInputStream = mmSocket.getInputStream();
                final int bytesAvailable = mmInputStream.available();
                final byte[] packetBytes = new byte[bytesAvailable];



                int readBufferPosition = 0;
                byte[] readBuffer = new byte[8];
                try {
                    if (bytesAvailable > 0) {
                        mmInputStream.read(packetBytes);
                    }

                    while (!Thread.currentThread().isInterrupted()) {

                        for (int i = 0; i < bytesAvailable; i++) {
                            byte b = packetBytes[i];
                            if (b != 0) {
                                byte[] encodedBytes = new byte[readBufferPosition];
                                System.arraycopy(readBuffer, 0, encodedBytes, 0, encodedBytes.length);
                                data = new String(encodedBytes, "US-ASCII");
                                readBufferPosition = 0;
                                Toast.makeText(BluetoothTerminal.this,"data_recieved : "+data,Toast.LENGTH_LONG).show();
                                // rx_tv.setText(data);

                                //The variable data now contains our full command
                            } else {
                                readBuffer[readBufferPosition++] = b;
                            }
                        }
                    }

                    rx_tv.setText(data);
                } catch (IOException io) {

                }




            }
            else
            {
                status.append("Socket Connection failed while recieving data");
            }
        }
        catch(IOException io)
        {
            status.append("Error in recieving : "+io.getMessage()+separator);
        }


    }

    private void send_data(final String data)
    {
        status.append("Please wait while data is transmitting" + separator);



        try {
            //spinner.setVisibility(View.VISIBLE);
            //mmSocket = mmDevice.createRfcommSocketToServiceRecord(uuid);
            if(!mmSocket.isConnected()) {
                status.append("Socket not connected : connecting socket"+separator);
                mmSocket.connect();
            }

            if(mmSocket.isConnected()) {
                mmOutputStream = mmSocket.getOutputStream();
                mmOutputStream.write(data.getBytes());

                status.append("Data sent :" + data + separator);
            }
            else
            {
                status.append("Socket not connected" + data + separator);
            }

        } catch (IOException io) {

            Toast.makeText(BluetoothTerminal.this, "Error Connecting Socket: " + io.getMessage(), Toast.LENGTH_LONG).show();
            status.append("Error Connecting Socket: " + io.getMessage() + separator);


        }
        spinner.setVisibility(View.GONE);





    }


    private class MessagePoster implements Runnable {
        private TextView textView;
        private String message;
        public MessagePoster(TextView textView, String message) {
            this.textView = textView;
            this.message = message;
        }
        public void run() {
            textView.append(message);
        }
    }


    private class BluetoothSocketListener implements Runnable {
        private BluetoothSocket socket;
        private TextView textView;
        private Handler handler;
        public BluetoothSocketListener(BluetoothSocket socket,
                                       Handler handler, TextView textView) {
            this.socket = socket;
            this.textView = textView;
            this.handler = handler;
        }

        public void run() {
            int bufferSize = 1024;
            String message = "";
            byte[] buffer = new byte[bufferSize];



            try {
                if (!mmSocket.isConnected()) {
                    //status.append("Socket connecting : please wait " + separator);
                    mmSocket.connect();

                }
                mmInputStream = mmSocket.getInputStream();
                int bytesRead=0;

                while (true) {
                    message = "";
                    bytesRead = mmInputStream.read(buffer);
                    if (bytesRead !=-1) {
                        while ((bytesRead==bufferSize)&&(buffer[bufferSize-1] != 0)) {
                            message = message + new String(buffer, 0, bytesRead);
                            bytesRead = mmInputStream.read(buffer);
                        }
                        message = message + new String(buffer, 0, bytesRead);
                        handler.post(new MessagePoster(textView, message));
                        mmSocket.getInputStream();
                    }
                }
            } catch (IOException e) {
                // Log.d("BLUETOOTH_COMMS", e.getMessage());
                message = message + e.getMessage();
                handler.post(new MessagePoster(textView, message));
            }
        }
    }

    private Handler handler = new Handler();
    private void switchUI() {



        BluetoothSocketListener bsl = new BluetoothSocketListener(mmSocket,
                handler, rx_tv);
        Thread messageListener = new Thread(bsl);
        messageListener.start();
    }



    private void getDevices()
    {

        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        if(pairedDevices.size() > 0)
        {
            for(BluetoothDevice device : pairedDevices)
            {
                devices.add(device.getName());
            }
            madapter.notifyDataSetChanged();
        }
        else
        {
            devices.add("No paired Device");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bluetooth_terminal, menu);
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
