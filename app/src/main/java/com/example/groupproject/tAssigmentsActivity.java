package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.groupproject.R;

import java.util.ArrayList;
import java.util.List;

public class tAssigmentsActivity extends AppCompatActivity {
    View view;
    private Button buttonSubmitAssmntDetails, buttonNewAssmnt;
    private EditText assmntTitle, subjectName, assmntDescription;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tassigments);

        db = new DatabaseHelper(tAssigmentsActivity.this);
        buttonSubmitAssmntDetails = findViewById(R.id.buttonSubmitAssmntDetails);
        buttonNewAssmnt = findViewById(R.id.btnNewAssmnt);

        //List<String> values = new ArrayList<String>();

        buttonSubmitAssmntDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                assmntTitle = findViewById(R.id.assmntTitle);
                subjectName = findViewById(R.id.subjectName);
                assmntDescription = findViewById(R.id.assmntDescription);

                String title = assmntTitle.getText().toString();
                String subject = subjectName.getText().toString();
                String description = assmntDescription.getText().toString();

                if (title.isEmpty() || subject.isEmpty() || description.isEmpty()) {
                    Toast.makeText(tAssigmentsActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    db.insertAssignmentDetails(title, description, subject);
                    Toast.makeText(tAssigmentsActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }


            }
        });
        buttonNewAssmnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                assmntTitle.setText(null);
//                assmntDescription.setText(null);
//                subjectName.setText(null);

                Toast.makeText(tAssigmentsActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), tAssigmentsActivity.class);
            }
        });


    }




}