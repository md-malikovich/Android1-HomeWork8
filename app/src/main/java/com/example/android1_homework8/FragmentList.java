package com.example.android1_homework8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class FragmentList extends Fragment {

    //List<Element> elements;

    public FragmentList() {
        //elements = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        /*Button add = v.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(); // TODO: для открытия AddFragment()
            }
        });

        final Button element = v.findViewById(R.id.element);
        element.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (elements.isEmpty()) {
                    return;
                } else {
                    showElement(elements.get(0));
                }
                Log.d("ololo", "showElement(elements.get(0))");
            }
        });*/

        return v;
    }

    /*public void add() { // TODO: открывает FragmentAdd
        MainActivity activity = (MainActivity) getActivity();
        activity.showAddFragment();
    }

    public void saveElement(Element element) { // TODO: сохр element в FragmentList
        elements.add(element);
        // adapter.notifyDataSetChanged();
        Log.d("ololo", "adapter.addSomeText(element.text);");
    }

    public void showElement(Element element) {
        MainActivity activity = (MainActivity) getActivity();
        activity.showShowFragment(element);
    }*/
}
