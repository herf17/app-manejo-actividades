package com.example.inge;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.inge.viewmodel.AgregarActividadViewModel;

import java.util.Calendar;

public class SelectorHoraFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    AgregarActividadViewModel agregarActividadViewModel;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        agregarActividadViewModel = new ViewModelProvider(requireActivity()).get(AgregarActividadViewModel.class);
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);


        return new TimePickerDialog(getActivity(), this,hour,minutes,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        agregarActividadViewModel.setHora(i+":"+i1);
    }
}
