package com.example.pupil.myfirstproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.pupil.myfirstproject.adapters.MyFragmentPagerAdapter;
import com.example.pupil.myfirstproject.ui.fragments.GreenFragment;
import com.example.pupil.myfirstproject.ui.fragments.MainFragment;
import com.example.pupil.myfirstproject.ui.fragments.PurpleFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.container);
        Fragment mainFragment = new MainFragment();
        Fragment purpleFragment = new PurpleFragment();
        Fragment greenFragment = new GreenFragment();
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(mainFragment);
        fragments.add(greenFragment);
        fragments.add(purpleFragment);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        adapter.setList(fragments);
        viewPager.setAdapter(adapter);
        //FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //fragmentTransaction.replace(container.getId(),mainFragment,"MAIN_FRAGMENT");
        // fragmentTransaction.commit();
    }
}
