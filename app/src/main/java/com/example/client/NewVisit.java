package com.example.client;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NewVisit extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    Button submit;
    Button cancel;
    View v;
    int from_date, to_date, till_date;
    private String text;
    Context context;
    //  Button b_pick;
    TextView tv_fromdate, tv_todate, listClient;
    EditText clientName;
    private LinearLayout parentLinearLayout;
    int day, month, year, hour, minute;
    int dayfinal, monthfinal, yearfinal, hourfinal, minutefinal;
    int checktextbox;
    String[] val;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String TAG ="NewVisit";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_visit);
        parentLinearLayout = (LinearLayout) findViewById(R.id.parent_linear_layout);
        context = getApplicationContext();
        //  listClient = (TextView) findViewById(R.id.listClient);
        //  b_pick = (Button) findViewById(R.id.b_date);
        tv_fromdate = (TextView) findViewById(R.id.tv_fromdate);
        tv_todate = (TextView) findViewById(R.id.tv_todate);
        tv_fromdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(NewVisit.this, NewVisit.this, year, month, day);
                datePickerDialog.show();
                checktextbox = 1;
            }
        });

        val = getResources().getStringArray(R.array.date);
        Log.d("value of log is ", "array value is " + val[1]);
        Toast.makeText(this, "All done", Toast.LENGTH_SHORT).show();

        clientName = (EditText) findViewById(R.id.clientName);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                loadData();
                updateViews();
                //  SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
                //  SharedPreferences sharedPref = context.getPreferences(Context.MODE_PRIVATE);
                //   sharedPref.Editor editor = sharedPref.edit();
                Toast.makeText(context, "Name of client is " + clientName.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addSpinnerValue() {
        List<Integer> spinnerArray = new ArrayList<>();
        Log.d("value of log is ", "array value is " + val[1]);
        till_date = from_date;
        int i = 0;
        for (; to_date >= till_date; till_date++) {
            spinnerArray.add(till_date);
            val[i++] = Integer.valueOf(till_date).toString();
            Log.d(TAG, "converted value is" + (Integer.valueOf(till_date).toString()));
            //  val[i]=(toString())till_date;
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.s_start);
        sItems.setAdapter(adapter);

        //  Integer[] myarray = new Integer[(to_date - from_date)];
        Log.d(TAG, "array value is " + val[1]);
    }

    public void onAddField(View v) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
    }

    public void onDelete(View v) {
        parentLinearLayout.removeView((View) v.getParent());
    }

    public void adClient(View v) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View addrow = inflater.inflate(R.layout.addname, null);
        int temp = parentLinearLayout.getChildCount();
        Log.d(TAG, "count is " + parentLinearLayout.getChildCount());
        parentLinearLayout.addView(addrow, parentLinearLayout.getChildCount() - (temp - 1));
//        parentLinearLayout.addView(addrow,parentLinearLayout.getBottom());
        Log.d(TAG, "Bottom is " + parentLinearLayout.getBottom());

    }

    public void datepicker(View v) {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(NewVisit.this, NewVisit.this, year, month, day);
        datePickerDialog.show();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        yearfinal = year;
        monthfinal = month + 1;
        dayfinal = dayOfMonth;

        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(NewVisit.this, NewVisit.this, hour, minute, false);
        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        hourfinal = hourOfDay;
        minutefinal = minute;

        if (checktextbox == 1) {
            tv_fromdate.setText(dayfinal + "/" + monthfinal + "/" + yearfinal + " :: " + hourfinal + ":" + minutefinal);
            from_date = dayfinal;
            Log.d(TAG, "From hour is" + dayfinal);
        } else {
            tv_todate.setText(dayfinal + "/" + monthfinal + "/" + yearfinal + " :: " + hourfinal + ":" + minutefinal);
            to_date = dayfinal;
            addSpinnerValue();
            Log.d(TAG, "To hour is" + dayfinal);
        }
        checktextbox = 0;
        Log.d( TAG, "hour gap is" + (to_date - from_date));
    }

   /*
        public void onAddField(View v) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View rowView = inflater.inflate(R.layout.field, null);
            // Add the new row before the add field button.
            linearLayout.addView(rowView, linearLayout.getChildCount() - 1);
        }
*/

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, clientName.getText().toString());
        // editor.putBoolean(SWITCH1, switch1.isChecked());
        editor.apply();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
    }

    public void updateViews() {
        // listClient.setText(text);
    }
}
