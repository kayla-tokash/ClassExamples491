package edu.cs491.kayla.classsample01_currencyconverter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    static final double EURO_TO_DOLLAR_CONVERSION_FACTOR = 1.13;

    EditText inputEuros, inputDollars;
    Button btnConvert;

    TextView helloText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting the bundle
        Intent myIntent = getIntent();
        String username = myIntent.getStringExtra(welcome_activity.USERNAME);

        // Using the textview to display the username
        helloText = (TextView) findViewById(R.id.usernameTextview);
        helloText.setText(username);

        // Defining other UI as variables
        inputEuros     = (EditText) findViewById(R.id.inputEuros);
        inputDollars   = (EditText) findViewById(R.id.inputDollars);
        btnConvert     = (Button) findViewById(R.id.btnConvert);


        // Not so recommended way of defining a button action
//        btnConvert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (inputEuros.length() > 0) {
//                    double valueEuro = new Double(inputEuros.getText().toString());
//                    double valueDollar = valueEuro * EURO_TO_DOLLAR_CONVERSION_FACTOR;
//                    inputDollars.setText("" + valueDollar);
//                }
//            }
//        });
        btnConvert.setOnClickListener(this);

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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnConvert:
                if (inputEuros.getText().length() > 0) {
                    double valueEuro = new Double(inputEuros.getText().toString());
                    double valueDollar = valueEuro * EURO_TO_DOLLAR_CONVERSION_FACTOR;
                    inputDollars.setText("" + valueDollar);
                }
                break;
        }
    }
}
