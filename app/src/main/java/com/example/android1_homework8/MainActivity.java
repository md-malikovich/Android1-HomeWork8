package com.example.android1_homework8;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    FragmentList fragmentList; // для сохранения FragmentList в памяти
    Fragment tempFragment; // хранит Фрагмент ктр на экране, НО не ListFragment
    FragmentRecycler fragmentRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //showListFragment(); // Фрагмент открывается сразу при запуске
        showRecyclerFragment();
    }

    public void showRecyclerFragment() { // показывает ListFragment через метод showFragment()
        if (fragmentRecycler == null) { //  проверка на наличие fragmentList
            fragmentRecycler = new FragmentRecycler();
        }
        showFragment(fragmentRecycler, tempFragment); // показывает Ф и скрывает текущий Фрагмент (Add / Show)
        tempFragment = null; // обнуляем после скрытия
    }

    /*
        public void showListFragment() { // показывает ListFragment через метод showFragment()
        if (fragmentList == null) { //  проверка на наличие fragmentList
            fragmentList = new FragmentList();
        }
        showFragment(fragmentList, tempFragment); // показывает Ф и скрывает текущий Фрагмент (Add / Show)
        tempFragment = null; // обнуляем после скрытия
    }
     */

    public void showAddFragment() { // показывает AddFragment через метод showFragment()
        FragmentAdd fragmentAdd = new FragmentAdd();
        tempFragment = fragmentAdd;
        //showFragment(fragmentAdd, fragmentList); // скрываем fragmentList при открытии fragmentAdd
        showFragment(fragmentAdd, fragmentRecycler); // скрываем fragmentList при открытии fragmentAdd
    }

    public void showShowFragment(Element element) { // показывает ShowFragment  через метод showFragment() и будет принимать element
        FragmentShow fragmentShow = new FragmentShow();
        tempFragment = fragmentShow;
        //showFragment(fragmentShow, fragmentList); // скрываем fragmentList при открытии fragmentShow
        showFragment(fragmentShow, fragmentRecycler); // скрываем fragmentList при открытии fragmentShow
        fragmentShow.showElement(element); // вызываем метод, ктр принимает element и показывает его
    }

    public void saveElement(Element element) { // сохраняет element и будет принимать параметр
        //fragmentList.saveElement(element);
        //showListFragment();
        fragmentRecycler.saveElement(element);
        showRecyclerFragment();
    }

    public void showFragment(Fragment fragment, @Nullable Fragment fragmentToHide) { // показывает Фрагменты + параметр для сокрытия Фрагмента
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(fragmentToHide != null) {
            transaction.hide(fragmentToHide); // для скрытия Фрагмента для показа другого Фрагмента
        }
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if(tempFragment != null) {
            //showListFragment();
            showRecyclerFragment();
        } else {
            super.onBackPressed();
        }
    }

    /*public void showRecyclerFragment() {
        FragmentRecycler fragmentRecycler = new FragmentRecycler();
        showFragment(fragmentRecycler, null); // показывает Ф и скрывает текущий Фрагмент (Add / Show)
        //tempFragment = null; // обнуляем после скрытия
    }*/
}