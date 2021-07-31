package com.example.android.pickerfortime;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Putting the fragment in the layout using @{getSupportFragmentManager()} .
     * This method does not add this frag. to the back stack!!
     */
    public void showTimePickerDialog(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.time_picker));
    }

    /**
     * Format the picked time to be in the form hour:minute
     *
     * @param hour   picked hour by the user(in 24 format)
     * @param minute picked minute by the user.
     */
    public void processTimePickerResult(int hour, int minute) {
        StringBuilder fullTime = new StringBuilder();
        fullTime.append(hour)
                .append(getString(R.string.time_formatter))
                .append(minute);
        Toast.makeText(this,
                getString(R.string.time_toast) + " " + fullTime,
                Toast.LENGTH_LONG).show();

    } // processTimePickerResult()
}