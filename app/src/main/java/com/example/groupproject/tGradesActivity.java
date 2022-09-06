package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class tGradesActivity extends AppCompatActivity {
    private Button buttonSubmitAssmntDetails, buttonNewAssmnt;
    private EditText studentName, apt1, apt2, apt3, apt4, apt5;
    private List<String> grades = new ArrayList<>();

    GpaCalculator gpaCalculator;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tgrades);

        db = new DatabaseHelper(tGradesActivity.this);
        gpaCalculator = new GpaCalculator();

        buttonSubmitAssmntDetails = findViewById(R.id.submitbtn_grades);
        buttonNewAssmnt = findViewById(R.id.newnbtn_grades);

        buttonSubmitAssmntDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                studentName = findViewById(R.id.student_name_grades);
                apt1 = findViewById(R.id.apt1);
                apt2 = findViewById(R.id.apt2);
                apt3 = findViewById(R.id.apt3);
                apt4 = findViewById(R.id.apt4);
                apt5 = findViewById(R.id.apt5);

                String student = studentName.getText().toString();
                String apt1_db = apt1.getText().toString();
                String apt2_db = apt2.getText().toString();
                String apt3_db = apt3.getText().toString();
                String apt4_db = apt4.getText().toString();
                String apt5_db = apt5.getText().toString();


                if (student.isEmpty() || apt1_db.isEmpty() || apt2_db.isEmpty() || apt3_db.isEmpty() || apt4_db.isEmpty() || apt5_db.isEmpty()) {
                    Toast.makeText(tGradesActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Double gpa = 0.0;
                    grades.clear();
                    grades.add(apt1.getText().toString());
                    grades.add(apt2.getText().toString());
                    grades.add(apt3.getText().toString());
                    grades.add(apt4.getText().toString());
                    grades.add(apt5.getText().toString());

                    Log.e("grades",grades.toString());

                    gpa = gpaCalculator.getPointList(grades);
                    Log.e("Teacher gpa",gpa.toString());

                    db.insertgrades(student, apt1_db, apt2_db, apt3_db, apt4_db, apt5_db,gpa);
                    Toast.makeText(tGradesActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                    studentName.setText(null);
                    apt1.setText(null);
                    apt2.setText(null);
                    apt3.setText(null);
                    apt4.setText(null);
                    apt5.setText(null);
                }
            }
        });
    }
}