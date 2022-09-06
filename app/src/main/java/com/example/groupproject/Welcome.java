package com.example.groupproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class Welcome extends Fragment {
    View view;
    private Button cntbtn,LogOut,tgrades, tassignments, listView;
    private EditText teachertext, textview3, textView2, nametext, textview1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.welcome,container,false);

        tgrades = view.findViewById(R.id.button_tGrades);
        tassignments = view.findViewById(R.id.button_tassign);
        LogOut = view.findViewById(R.id.logoutbtn_welcome);
        listView = view.findViewById(R.id.listview);

        tgrades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), tGradesActivity.class);
                startActivity(intent);
            }
        });

        tassignments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), tAssigmentsActivity.class);
                startActivity(intent);
            }
        });

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                builder.setTitle("Confirmation PopUp!").setMessage("You sure, that you want to logout?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i = new Intent(getActivity(),MainActivity.class);
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

                Intent myIntent = getActivity().getIntent();
                String string = myIntent.getStringExtra("message");
            }
        });

        return view;


    }
}
