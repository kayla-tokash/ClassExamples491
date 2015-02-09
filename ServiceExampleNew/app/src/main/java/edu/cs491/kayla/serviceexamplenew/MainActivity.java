package edu.cs491.kayla.serviceexamplenew;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button myButtonSS, myButtonBS;

    MyService serviceObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButtonSS = (Button) findViewById(R.id.myButtonSS);
        myButtonBS = (Button) findViewById(R.id.myButtonBS);


        myButtonBS.setOnClickListener(this);
        myButtonSS.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.myBinder binder = (MyService.myBinder) service;
            serviceObj = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.myButtonSS:
                Intent myIntent = new Intent(this, MyIntentService.class);
                startService(myIntent);
                break;
            case R.id.myButtonBS:
                Intent myIntent2 = new Intent(this, MyService.class);
                bindService(myIntent2, myConnection, Context.BIND_AUTO_CREATE);
                break;
        }
    }
}
