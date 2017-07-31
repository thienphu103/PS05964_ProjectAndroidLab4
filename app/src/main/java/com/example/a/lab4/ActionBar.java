package com.example.a.lab4;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.NumberPicker;

public class ActionBar extends AppCompatActivity {
    NumberPicker np,np1,np2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar.this.setTitle("Action Bar");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.memu_action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings1) {
            CustomDialogSet();
        }
        if (id == R.id.action_settings) {
            CustomDialogAbout();
        }

        return super.onOptionsItemSelected(item);
    }

    public void CustomDialogSet() {
        final Dialog dialog = new Dialog(ActionBar.this);

        dialog.setTitle("Custom Dialog");
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.setting);
        np= (NumberPicker) dialog.findViewById(R.id.numberPicker1);
        np.setMinValue(1);
        np.setMaxValue(12);
        np1= (NumberPicker) dialog.findViewById(R.id.numberPicker2);
        np1.setMinValue(1);
        np1.setMaxValue(59);
        np2= (NumberPicker) dialog.findViewById(R.id.numberPicker3);
        final String[] arrayString= new String[]{"AM","FM"};
        np2.setMinValue(0);
        np2.setMaxValue(arrayString.length-1);
        np2.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                return arrayString[value];
            }
        });
        dialog.show();




    }
    public void CustomDialogAbout() {
        final Dialog dialog = new Dialog(ActionBar.this);
        dialog.setTitle("Custom Dialog");
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.about);
        dialog.show();
    }

    }

