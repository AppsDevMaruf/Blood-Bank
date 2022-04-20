package com.marufalam.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String gender = "Male";
    private String bloodGroup;
    private String[] bloodGroupList = {"A+", "A-", "AB+", "AB-", "B+", "B-", "O+", "O-"};
    EditText nameEdit, numberEdit;
    RadioGroup radioGp;
    Button saveButton;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEdit = findViewById(R.id.nameEt);
        numberEdit = findViewById(R.id.numberEt);
        radioGp = findViewById(R.id.radioGP);
        saveButton = findViewById(R.id.saveBtn);
        spinner = findViewById(R.id.spinner);


        //RadioGroup buttons
        radioGp.setOnCheckedChangeListener((radioGroup, i) -> {
            final RadioButton rb = radioGroup.findViewById(i);
            gender = rb.getText().toString();
            Toast.makeText(this, gender, Toast.LENGTH_SHORT).show();
        });

        // create adapter for dropdown List
        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        getApplicationContext()
                        ,android.R.layout.simple_dropdown_item_1line
                        ,bloodGroupList);
        spinner.setAdapter(adapter);

        //select onItem Selected spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

              bloodGroup = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, bloodGroup, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //saveButton
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEdit.getText().toString().trim();
                String number = numberEdit.getText().toString().trim();
                if (name.equalsIgnoreCase("")) {
                    nameEdit.setError("This field can not be blank");
                }
                if (number.equalsIgnoreCase("")) {
                    numberEdit.setError("This field can not be blank");
                }
                else {
                    Toast.makeText(MainActivity.this, name+"\n"+gender+"\n"+number+"\n"+bloodGroup+" ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}