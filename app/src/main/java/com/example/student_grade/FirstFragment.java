package com.example.student_grade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    TextView textSubject1, textSubject2, textSubject3;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        textSubject1  = (TextView) view.findViewById(R.id.textviewSubject1);
        textSubject2  = (TextView) view.findViewById(R.id.textviewSubject2);
        textSubject3  = (TextView) view.findViewById(R.id.textviewSubject3);

        textSubject1.setText(MainActivity.sub1);
        textSubject2.setText(MainActivity.sub2);
        textSubject3.setText(MainActivity.sub3);
    }
}