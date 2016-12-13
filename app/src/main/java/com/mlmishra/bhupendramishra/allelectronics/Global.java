package com.mlmishra.bhupendramishra.allelectronics;
import java.io.FileWriter;
import android.os.Environment;
import android.widget.Toast;
import android.content.Context;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.io.InputStreamReader;



import java.io.File;
import java.util.Random;
import android.app.Activity;
import com.firebase.client.Firebase;

/**
 * Created by bhupendramishra on 12/07/15.
 */

    public class Global {

        public static String search_item=new String();
        public static String url_search=new String();
        public static int data_length;
        public static boolean first_time;
        public static boolean first_help;
        public static int activity_id;
        public static  Firebase fbref = new Firebase("https://allelectronics.firebaseio.com");
        public static String Bluetooth_device_name;


    public static void get_text(String s)

    {
        search_item=s;
    }

    public static void write_file(String data)
    {
        FileWriter f;
        String separator = System.getProperty("line.separator");
        try {
            f = new FileWriter(Environment.getExternalStorageDirectory()+"/AllElectronics/"+"data.bhu",true);
            f.write(data+separator);
            f.flush();
            f.close();
            }
        catch(Exception e)
        {

        }
    }

    public static void delete_file(Context context)
    {
        File file = new File(Environment.getExternalStorageDirectory()+"/AllElectronics/"+"data.bhu");
        boolean deleted = file.delete();
        if(deleted)
            Toast.makeText(context,"Data Deleted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context,"Data not Deleted",Toast.LENGTH_LONG).show();


    }

    public static void string_length()
    {
        String readString;
        int i=0;
        try{
            File f = new File(Environment.getExternalStorageDirectory()+"/AllElectronics/"+"data.bhu");
            BufferedReader buf = new BufferedReader(new FileReader(f));

            while((readString = buf.readLine())!= null){
                i++;
            }
            buf.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        data_length=i;
    }

    public static void Delete_data(String file)
    {

        String readString;
        try{
            File f = new File(Environment.getExternalStorageDirectory()+"/AllElectronics/"+"data.bhu");
            File f1 = new File(Environment.getExternalStorageDirectory()+"/AllElectronics/"+"datatmp.bhu");
            File f2=new File(Environment.getExternalStorageDirectory()+"/AllElectronics/"+file);
            BufferedReader buf = new BufferedReader(new FileReader(f));
            PrintWriter pw = new PrintWriter(new FileWriter(f1));
            while((readString = buf.readLine())!= null){

                if(!file.equalsIgnoreCase(readString))
                {
                    pw.println(readString);
                    pw.flush();
                }


            }
            pw.close();
            buf.close();
            f.delete();
            f1.renameTo(f);
            f2.delete();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }


    }


    public static String read_file_to_string(Activity activity,String file)
    {


        String separator = System.getProperty("line.separator");
        String readString,readString1=separator;


        try{

            BufferedReader buf = new BufferedReader(new InputStreamReader(activity.getAssets().open(file)));

            while((readString = buf.readLine())!= null){

                readString1=readString1+separator+readString;

            }

            buf.close();




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return readString1;
    }




    public static String[] Display_data()
    {

        String readString;
        int i=0;

        int j=data_length;
        String[] data=new String[j];
        try{
            File f = new File(Environment.getExternalStorageDirectory()+"/AllElectronics/"+"data.bhu");
            BufferedReader buf = new BufferedReader(new FileReader(f));

            while((readString = buf.readLine())!= null){
                data[i]=readString;
                i++;
            }
            buf.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return data;
    }

    public static void rename_file(String file,String rename_file)
    {

        String readString;
        String[] fn = file.split("\\.");
        try{
            File f = new File(Environment.getExternalStorageDirectory()+"/AllElectronics/"+"data.bhu");
            File f1 = new File(Environment.getExternalStorageDirectory()+"/AllElectronics/"+"datatmp.bhu");
            File f3 = new File(Environment.getExternalStorageDirectory()+"/AllElectronics/"+rename_file+"."+fn[1]);
            File f2=new File(Environment.getExternalStorageDirectory()+"/AllElectronics/"+file);
            BufferedReader buf = new BufferedReader(new FileReader(f));
            PrintWriter pw = new PrintWriter(new FileWriter(f1));
            while((readString = buf.readLine())!= null){

                if(!file.equalsIgnoreCase(readString))
                {
                    pw.println(readString);
                    pw.flush();
                }
                else
                {

                    pw.println(rename_file+"."+fn[1]);
                    pw.flush();
                }


            }
            pw.close();
            buf.close();
            f.delete();
            f1.renameTo(f);
            f2.renameTo(f3);
            f2.delete();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }


    }

    public static void write_file1(String file,String data,Context context)
    {

        Random rand=new Random();
        PrintWriter pw;
        try {

            File f = new File(Environment.getExternalStorageDirectory() + "/AllElectronics/" + file + ".txt");
            if(f.exists())
            {
                file=file+"_"+rand.nextInt(80);
                f = new File(Environment.getExternalStorageDirectory() + "/AllElectronics/" + file + ".txt");
                Toast.makeText(context,"File Already exists, filename is renamed, you can also rename it later on",Toast.LENGTH_LONG).show();
            }
            pw = new PrintWriter(new FileWriter(f));

            pw.print(data);
            pw.flush();


            pw.close();
        }

         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        Global.write_file(file+".txt");
    }

    public static void library_back_pressed_activity(String product)
    {

        if(product.equalsIgnoreCase("library"))
            activity_id=1;
        else
            activity_id=2;

    }
}


