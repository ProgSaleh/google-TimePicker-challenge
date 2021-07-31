package com.example.android.pickerfortime;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Current time is the default time.
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY); // extracted hour from the Calendar instance.
        int minute = c.get(Calendar.MINUTE); // extracted minute from the Calendar instance.

        // return new TimePickerDialog with the new configured info.
        return new TimePickerDialog(getActivity(), this, hour, minute, true);
    }


    @Override
    public void onTimeSet(TimePicker picker, int hour, int minute) {
        MainActivity activity = (MainActivity) getActivity();
        assert activity != null;
        activity.processTimePickerResult(hour, minute);
    }
}
