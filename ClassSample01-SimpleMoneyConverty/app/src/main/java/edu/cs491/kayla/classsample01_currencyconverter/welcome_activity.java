package edu.cs491.kayla.classsample01_currencyconverter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// Important: "welcome_activity" does not follow standards for class naming
public class welcome_activity extends ActionBarActivity implements View.OnClickListener {

    public static final String USERNAME = "USERNAME";
    private static final int REQUEST_CODE = 231;
    Button explicitIntentBtn, implicitIntentBtn;
    EditText userNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_activity);


        // Defining our UI in variables
        explicitIntentBtn = (Button) findViewById(R.id.buttonExplicit);
        implicitIntentBtn = (Button) findViewById(R.id.buttonImplicit);
        userNameText = (EditText) findViewById(R.id.userNameText);


        // Setting this class to the onclicklistener
        explicitIntentBtn.setOnClickListener(this);
        implicitIntentBtn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        // Release any handlers, there are none for this activity`
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome_activity, menu);
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
            case R.id.buttonExplicit:
                if (userNameText.getText().length() > 0) {
                    // Getting the username
                    String username = userNameText.getText().toString();

                    // Explicit intent
                    Intent myIntent = new Intent(this, MainActivity.class);

                    // Bundle allows you to transfer information between activities
                    // to add a bundle, you use the "putExtra" method in the Intent class
                    myIntent.putExtra(USERNAME, username);

                    // Starting the new Activity
                    startActivityForResult(myIntent, REQUEST_CODE);
//                    startActivity(myIntent); // Basic start activity
                } else {
                    // Not added in class example but it should be there... otherwise the user may
                    // not know what is going on :v Then again the user is probably only me <.<
                    ((TextView) findViewById(R.id.helloworldmsg)).setText("Invalid name");
                }
                break;
            case R.id.buttonImplicit:
                // Explicit intent to open the web browser and display a URL
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/"));
                //Basic way to start an activity
                startActivity(myIntent);
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            Toast.makeText(this, "Call Back Function Invoked", Toast.LENGTH_LONG);

        }
    }
}
