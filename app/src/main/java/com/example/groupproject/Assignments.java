package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.content.Intent;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Assignments extends AppCompatActivity {
    private Button LogOut,Profile,Marks, ViewAssigments;
    private ListView listView;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignments);


        LogOut = findViewById(R.id.LogOut);
        Profile = findViewById(R.id.Profile);
        Marks = findViewById(R.id.Marks_student);
        listView =findViewById(R.id.listview);

        ViewAssigments = findViewById(R.id.view_assignments_student);
        DB=new DatabaseHelper(this);

        ViewAssigments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=DB.getAssignmentData();
                if (res.getCount()==0){
                    Toast.makeText(Assignments.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Title: "+res.getString(0)+"\n");
                    buffer.append("Subject : "+res.getString(1)+"\n");
                    buffer.append("Description : "+res.getString(2)+"\n");

                }

                AlertDialog.Builder builder=new
                        AlertDialog.Builder(Assignments.this);
                builder.setCancelable(true);
                builder.setTitle("Assignments");
                builder.setMessage(buffer.toString());
                builder.show();
            }
            });





        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent1=new Intent(getApplicationContext(),WelcomePage.class);
                startActivity(myIntent1);

            }
        });

        Marks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent2=new Intent(getApplicationContext(),Grades.class);
                startActivity(myIntent2);

            }
        });

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Assignments.this);
                builder.setTitle("Confirmation PopUp!").setMessage("You sure, that you want to logout?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder.create();
                alert11.show();

                Intent myIntent = getIntent();
                String string = myIntent.getStringExtra("message");
            }
        });
    }
}