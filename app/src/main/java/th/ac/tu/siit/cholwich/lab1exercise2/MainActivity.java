package th.ac.tu.siit.cholwich.lab1exercise2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void convert(View v){
        EditText input = (EditText)findViewById(R.id.etInput);
        TextView output = (TextView)findViewById(R.id.tvOutput);
        double T1s = Double.parseDouble(input.getText().toString());


        //input.setText(Integer.toString());
        RadioGroup rgFrom = (RadioGroup)findViewById(R.id.rgFrom);
        int selFrom = rgFrom.getCheckedRadioButtonId();
        RadioGroup rgTo = (RadioGroup)findViewById(R.id.rgTo);
        int selTo = rgTo.getCheckedRadioButtonId();

        if (selFrom == R.id.rbFrmC) { //The user wants to convert from Celsius.
           if (selTo == R.id.rbToF) {
               output.setText(Double.toString(T1s*1.8+32));
           }
           else if (selTo == R.id.rbToK) {
               output.setText(Double.toString(T1s+273.15));
           }
        }
        if (selFrom == R.id.rbFrmF) { //The user wants to convert from Celsius.
            if (selTo == R.id.rbToC) {
                output.setText(Double.toString((T1s-32)/1.8));
            }
            else if (selTo == R.id.rbToK) {
                output.setText(Double.toString(((T1s-32)/1.8)+273.15));
            }
        }
        if (selFrom == R.id.rbFrmK) { //The user wants to convert from Celsius.
            if (selTo == R.id.rbToC) {
                output.setText(Double.toString(T1s-273.15));
            }
            else if (selTo == R.id.rbToF) {
                output.setText(Double.toString(((T1s-273.15)*1.8)+32));
            }
        }

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
