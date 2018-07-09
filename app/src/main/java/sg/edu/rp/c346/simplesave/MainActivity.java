package sg.edu.rp.c346.simplesave;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onPause() {
        super.onPause();

        //step 1a obtain an instance of the sharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //step 1b obtain an instance of the SharedPreference editor for update
        SharedPreferences.Editor prefEdit = prefs.edit();

        //step 1c add the key-value pair: key: greeting, value:hello
        prefEdit.putString("greeting","Hello!");

        //step 1d call commit() method to save the changes into the sharedPreference
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //String msg="No greeting!";

        //step 2a obtain an instance of the SharedPreference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        //step 2b retrieve the saved data with the key "greeting" from the SharedPreferences object
        String msg = prefs.getString("greeting"," No greetings!");

        Toast toast = Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
