package com.mlmishra.bhupendramishra.allelectronics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Application;

import com.firebase.client.Firebase;

public class Allelectronics extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        //Firebase.getDefaultConfig().setPersistenceEnabled(true);

    }
    }

