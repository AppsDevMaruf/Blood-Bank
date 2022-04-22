package com.marufalam.bloodbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
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
    private final String[] bloodGroupList = {"A+", "A-", "AB+", "AB-", "B+", "B-", "O+", "O-"};
    private EditText nameEdit, numberEdit;
    private RadioGroup radioGp;
    private Button saveButton;
    private Spinner spinner;
    private AppCompatCheckBox ckAge, ckHeight, ckWeight, ckAntibiotic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEdit = findViewById(R.id.nameEt);
        numberEdit = findViewById(R.id.numberEt);
        radioGp = findViewById(R.id.radioGP);
        saveButton = findViewById(R.id.saveBtn);
        spinner = findViewById(R.id.spinner);
        //checkBox
        ckAge = findViewById(R.id.ckAge);
        ckHeight = findViewById(R.id.ckHealth);
        ckWeight = findViewById(R.id.ckWeight);
        ckAntibiotic = findViewById(R.id.ckAntibiotic);


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
                        , android.R.layout.simple_dropdown_item_1line
                        , bloodGroupList);
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
                } else {

               //////////////////////////////


                    StringBuilder result=new StringBuilder();
                    result.append("Selected Items:");
                    if(ckAge.isChecked()){
                        result.append("\nYou are aged 18+");

                    }
                    if(ckHeight.isChecked()){
                        result.append("\nYou are fit and healthy");

                    }
                    if(ckWeight.isChecked()){
                        result.append("\nYou weigh more than 45kg");

                    }
                    if(ckAntibiotic.isChecked()){
                        result.append("\nYou are taking antibiotics");

                    }
                    //Displaying the message on the toast
                    Toast.makeText(MainActivity.this, name + "\n" + gender + "\n" + number + "\n" + bloodGroup + "\n"+result.toString(), Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("gender",gender);
                    intent.putExtra("number",number);
                    intent.putExtra("bloodGroup",bloodGroup);
                    intent.putExtra("ckBox",result.toString());
                    startActivity(intent);
                }

                    ///////////////////


            }
        });

        /*public void onCheckboxClicked (View view){
            // Is the view now checked?
            boolean checked = ((CheckBox) view).isChecked();

            // Check which checkbox was clicked
            switch (view.getId()) {
                case R.id.checkbox_meat:
                    if (checked)
                    // Put some meat on the sandwich
            else
                    // Remove the meat
                    break;
                case R.id.checkbox_cheese:
                    if (checked)
                    // Cheese me
            else
                    // I'm lactose intolerant
                    break;
                // TODO: Veggie sandwich
            }
        }*/
    }




}