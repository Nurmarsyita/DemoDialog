package com.example.demodialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1, btnDemo2, btnDemo3, btnExercise1, btnDemo4, btnDemo5;
    TextView tvDemo2, tvDemo3, tvExer3, tvDemo4, tvDemo5;
    int num1, num2, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        btnExercise1 = findViewById(R.id.buttonExercise3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);

        tvDemo2 = findViewById(R.id.textViewDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        tvExer3 = findViewById(R.id.textViewExer3);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        tvDemo5 = findViewById(R.id.textViewDemo5);

// DEMO 1
        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                // Set the dialog details
                /*
                // Set the title displayed in the Dialog
                myBuilder.setTitle("Demo 1-Simple Dialog");
                // Set the message to display
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                // Set a listener to be invoked when the positive of the dialog is pressed
                myBuilder.setPositiveButton("Close", null);
                 */

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Dismiss", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

// DEMO 2
        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below");
                myBuilder.setCancelable(false);

                // Configure the 'positive' button
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                            tvDemo2.setText("You have selected Positive.");
                    }
                });

                // Configure the 'negative' button
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        tvDemo2.setText("You have selected Negative.");
                    }
                });

                // Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

// DEMO 3
//        btnDemo3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // Inflate the input.xml layout file
//                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                View viewDialog = inflater.inflate(R.layout.input, null);
//
//                // Obtain the UI component in the input.xml layout
//                // It needs to be defined as "final", so that it can used in the onClick() method later
//                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);
//
//                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
//                myBuilder.setView(viewDialog);
//                myBuilder.setTitle("Demo 3 - Text Input Dialog");
//
//                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        String message = etInput.getText().toString();
//                        tvDemo3.setText(message);
//                    }
//                });
//
//                myBuilder.setNegativeButton("CANCEL", null);
//                AlertDialog myDialoog = myBuilder.create();
//                myDialoog.show();
//
//            }
//        });

// EXERCISE 1
        btnExercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput1 = viewDialog.findViewById(R.id.editTextNum1);
                final EditText etInput2 = viewDialog.findViewById(R.id.editTextNum2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        num1 = Integer.parseInt(etInput1.getText().toString());
                        num2 = Integer.parseInt(etInput2.getText().toString());
                        sum = num1 + num2;

                        // Set text to the TextView
                        tvExer3.setText("The sum is " + Integer.toString(sum));

                    }
                });

                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialoog = myBuilder.create();
                myDialoog.show();
            }
        });

// DEMO 4
        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {

                    public void onDateSet (DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog
//                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
//                        myDateListener, 2014, 11, 31);
//                myDateDialog.show();

                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, year, month, day);

                myDateDialog.show();
            }
        });

// DEMO 5
        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create the Listener to set the date
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                // Create the Date Picker Dialog to show the current date when it first appears
                Calendar now = Calendar.getInstance();
                int hourOfDay = now.get(Calendar.HOUR_OF_DAY);  // Current Hour
                int minute = now.get(Calendar.MINUTE);  // Current Minute
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, hourOfDay, minute, false);

                //create the Time Picker Dialog
//                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
//                        myTimeListener, 20, 00, false);
                myTimeDialog.show();
            }
        });

    }
}