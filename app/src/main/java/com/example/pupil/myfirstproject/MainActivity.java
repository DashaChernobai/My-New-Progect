package com.example.pupil.myfirstproject;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.pupil.myfirstproject.adapters.MyFragmentPagerAdapter;
import com.example.pupil.myfirstproject.ui.fragments.BaseFragment;
import com.example.pupil.myfirstproject.ui.fragments.GreenFragment;
import com.example.pupil.myfirstproject.ui.fragments.MainFragment;
import com.example.pupil.myfirstproject.ui.fragments.OrangeFragment;
import com.example.pupil.myfirstproject.ui.fragments.PurpleFragment;
import com.example.pupil.myfirstproject.ui.fragments.RedFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;//связывает страницы с кнопками внизу

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.container);
        tabLayout = findViewById(R.id.tabLayout);//назначение id
        Fragment mainFragment = new MainFragment();
        Fragment purpleFragment = new PurpleFragment();
        Fragment greenFragment = new GreenFragment();
        Fragment redFragment = new RedFragment();
        Fragment orangeFragment = new OrangeFragment();

        ArrayList<BaseFragment> fragments = new ArrayList<BaseFragment>();
        fragments.add((BaseFragment) mainFragment);
        fragments.add((BaseFragment) greenFragment);
        fragments.add((BaseFragment) purpleFragment);
        fragments.add((BaseFragment) redFragment);
        fragments.add((BaseFragment) orangeFragment);

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        adapter.setList(fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 2) {
                    Toast.makeText(getBaseContext(), "Position " + tab.getPosition(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 2) {
                    Toast.makeText(getBaseContext(), "Position" + tab.getPosition(), Toast.LENGTH_SHORT).show();
                }
            }
        });


        //FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //fragmentTransaction.replace(container.getId(),mainFragment,"MAIN_FRAGMENT");
        // fragmentTransaction.commit();
    }
}
