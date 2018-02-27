package com.example.fondn.tryfragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class One extends Fragment {

    CommunicatorInterface communicatorInterface;
    Button button;
    EditText editText;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        communicatorInterface = (CommunicatorInterface) getActivity();


        button = (Button)  getActivity().findViewById(R.id.oneButtonID);
        editText = (EditText) getActivity().findViewById(R.id.editTextOneID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                communicatorInterface.respond(text);
                Toast.makeText(getActivity(), "wow", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        return view;
    }


}
