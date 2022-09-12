package com.example.practice12sep

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;


class MainActivity : AppCompatActivity() {
    private var mPickDateButton: Button? = null
    private var mShowSelectedDateText: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // now register the text view and the button with
        // their appropriate IDs
        mPickDateButton = findViewById(R.id.pick_date_button)
        mShowSelectedDateText = findViewById(R.id.show_selected_date)

        // now create instance of the material date picker
        // builder make sure to add the "datePicker" which
        // is normal material date picker which is the first
        // type of the date picker in material design date
        // picker
        val materialDateBuilder: MaterialDatePicker.Builder<*> =
            MaterialDatePicker.Builder.datePicker()
        // now define the properties of the
        // materialDateBuilder that is title text as SELECT A DATE

        materialDateBuilder.setTitleText("SELECT A DATE")

        // now create the instance of the material date
        // picker
        val materialDatePicker = materialDateBuilder.build()

        // handle select date button which opens the
        // material design date picker
        mPickDateButton!!.setOnClickListener(
            object : View.OnClickListener {
                override fun onClick(v: View?) {
                    // getSupportFragmentManager() to
                    // interact with the fragments
                    // associated with the material design
                    // date picker tag is to get any error
                    // in logcat
                    materialDatePicker.show(supportFragmentManager, "MATERIAL_DATE_PICKER")
                }
            })

        // now handle the positive button click from the
        // material design date picker
        materialDatePicker.addOnPositiveButtonClickListener {
            // if the user clicks on the positive
            // button that is ok button update the
            // selected date
            mShowSelectedDateText!!.setText("Selected Date is : " + materialDatePicker.headerText)
            // in the above statement, getHeaderText
            // is the selected date preview from the
            // dialog
        }
    }
}
// This code is written by Ujjwal Kumar Bhardwaj
