package com.example.yan.orderingapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity  {


    private BottomNavigationBar bar;

    private Fragment currentFragment = null;
    private Item1Fragment mFragment1 = new Item1Fragment();
    private Item2Fragment mFragment2 = new Item2Fragment();
    private Item3Fragment mFragment3 = new Item3Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = (BottomNavigationBar) findViewById(R.id.main_bar);
//        bar.setFab(mFloatingActionButton);
        bar.setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);
        bar.setAutoHideEnabled(true);
        bar.addItem(new BottomNavigationItem(R.drawable.item1).setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.item2).setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.item3).setActiveColorResource(R.color.blue))
                .setFirstSelectedPosition(0)
                .initialise();
        bar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:

                        switchFragment(mFragment1);
                        break;
                    case 1:
                        switchFragment(mFragment2);
                        break;
                    case 2:
                        switchFragment(mFragment3);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void switchFragment(Fragment targetfragment) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetfragment.isAdded()) {
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.main_fragment, targetfragment)
                    .commit();
        } else {
            transaction.hide(currentFragment)
                    .show(targetfragment)
                    .commit();
        }
        currentFragment = targetfragment;
    }
}
