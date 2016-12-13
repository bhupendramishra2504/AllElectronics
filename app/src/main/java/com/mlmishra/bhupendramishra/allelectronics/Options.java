package com.mlmishra.bhupendramishra.allelectronics;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.preference.PreferenceActivity;
import android.app.Activity;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.widget.Toast;
import android.preference.Preference;
import android.preference.CheckBoxPreference;
import java.util.ArrayList;


public class Options extends PreferenceActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_options);
        this.addPreferencesFromResource(R.xml.prefrences);

        final CheckBoxPreference checkboxPref1 = (CheckBoxPreference) getPreferenceManager().findPreference("datasheet");
        final CheckBoxPreference checkboxPref2 = (CheckBoxPreference) getPreferenceManager().findPreference("circuit");
        final CheckBoxPreference checkboxPref3 = (CheckBoxPreference) getPreferenceManager().findPreference("gis");
        final CheckBoxPreference checkboxPref4 = (CheckBoxPreference) getPreferenceManager().findPreference("circuit1");
        final CheckBoxPreference checkboxPref5 = (CheckBoxPreference) getPreferenceManager().findPreference("circuit2");
        final CheckBoxPreference checkboxPref6 = (CheckBoxPreference) getPreferenceManager().findPreference("ebc1");
        checkboxPref1.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean chkval=(Boolean)newValue;
                if(chkval)
                    checkboxPref2.setChecked(false);
                    checkboxPref3.setChecked(false);
                    checkboxPref4.setChecked(false);
                    checkboxPref5.setChecked(false);
                    checkboxPref6.setChecked(false);
                return true;
            }
        });
        checkboxPref2.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean chkval=(Boolean)newValue;
                if(chkval)
                    checkboxPref1.setChecked(false);
                    checkboxPref3.setChecked(false);
                    checkboxPref4.setChecked(false);
                    checkboxPref5.setChecked(false);
                    checkboxPref6.setChecked(false);
                return true;
            }
        });

        checkboxPref3.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean chkval=(Boolean)newValue;
                if(chkval)
                    checkboxPref1.setChecked(false);
                    checkboxPref2.setChecked(false);
                    checkboxPref4.setChecked(false);
                    checkboxPref5.setChecked(false);
                    checkboxPref6.setChecked(false);
                return true;
            }
        });

        checkboxPref4.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean chkval=(Boolean)newValue;
                if(chkval)
                    checkboxPref1.setChecked(false);
                checkboxPref2.setChecked(false);
                checkboxPref3.setChecked(false);
                checkboxPref5.setChecked(false);
                checkboxPref6.setChecked(false);
                return true;
            }
        });

        checkboxPref5.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean chkval=(Boolean)newValue;
                if(chkval)
                    checkboxPref1.setChecked(false);
                checkboxPref2.setChecked(false);
                checkboxPref3.setChecked(false);
                checkboxPref4.setChecked(false);
                checkboxPref6.setChecked(false);
                return true;
            }
        });
        checkboxPref6.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                boolean chkval=(Boolean)newValue;
                if(chkval)
                    checkboxPref1.setChecked(false);
                checkboxPref2.setChecked(false);
                checkboxPref3.setChecked(false);
                checkboxPref4.setChecked(false);
                checkboxPref5.setChecked(false);
                return true;
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu_ladder; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_options, menu);
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
