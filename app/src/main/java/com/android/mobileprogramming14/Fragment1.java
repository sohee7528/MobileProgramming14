package com.android.mobileprogramming14;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment1 extends Fragment {

    EditText edtInput;
    Button btnInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_1, container, false);

        edtInput = rootView.findViewById(R.id.edtInput);
        btnInput = rootView.findViewById(R.id.btnInput);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = edtInput.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("key",temp);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

                Fragment2 fragment2 = new Fragment2();
                fragment2.setArguments(bundle);
                ft.replace(R.id.rootlayout, fragment2);
                ft.commit();
            }
        });

        return rootView;
    }
}