package com.example.practice_3_mirea_task4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    Button button_check_dogs;
    Button button_check_cats;

    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button_check_dogs = (Button) getActivity().findViewById(R.id.button_check_dogs);
        button_check_cats = (Button) getActivity().findViewById(R.id.button_check_cats);

        button_check_dogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_main_container_view,
                                FirstFragment.class, null, "firstFragment")
                        .commit();
            }
        });

        button_check_cats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragment_main_container_view,
                                SecondFragment.class, null, "secondFragment")
                        .commit();
            }
        });
    }
}
