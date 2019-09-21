package com.example.android1_homework8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentAdd extends Fragment {

    public FragmentAdd() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add, container, false);
        final Button save = v.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        return v;
    }

    public void save() { // TODO: сохранение element
        Element element = new Element(); // TODO: создаем element
        element.text = "Random text"; // TODO: заполняем поле text
        MainActivity activity = (MainActivity) getActivity();
        activity.saveElement(element); // TODO: вызываем метод saveElement и отправляем в него element
    }
}
