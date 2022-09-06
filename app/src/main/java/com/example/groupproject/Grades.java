package com.example.groupproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Grades extends AppCompatActivity {

    private Button LogOut,Profile,Assign;
    private TextView textView7,textView17,textView26,textView27,textView28,textView29,textView30;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);
        LogOut = findViewById(R.id.LogOut);
        Profile = findViewById(R.id.Profile);
        Assign = findViewById(R.id.Assign);
        db = new DatabaseHelper(this);

        textView7 = findViewById(R.id.textView7);
        textView17 = findViewById(R.id.textView17);
        textView26 = findViewById(R.id.textView26);
        textView27 = findViewById(R.id.textView27);
        textView28 = findViewById(R.id.textView28);
        textView29 = findViewById(R.id.textView29);
        textView30 = findViewById(R.id.textView30);
        String username=userhelper.username;

        Log.e("username",username);

        // Get values from database
        Cursor res = db.getgrades(username);
        Log.e("res",res.getCount()+"");
        Log.e("Database",db.getgrades(username).getCount()+"");
        if (res.getCount() == 0) {

            Toast.makeText(Grades.this, "No Entries Exist", Toast.LENGTH_SHORT);
            return;
        }

            while (res.moveToNext()) {

                Log.e("Column 1",res.getString(0)+"");

                textView17.setText(res.getString(1));
                textView26.setText(res.getString(2));
                textView27.setText(res.getString(3));
                textView28.setText(res.getString(4));
                textView29.setText(res.getString(5));
                textView30.setText(res.getString(5));
                textView7.setText(res.getString(7));
            }




        Assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent1=new Intent(getApplicationContext(),Assignments.class);
                startActivity(myIntent1);

            }
        });

        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent2=new Intent(getApplicationContext(),WelcomePage.class);
                startActivity(myIntent2);

            }
        });

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Grades.this);
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