package com.example.naveed.swipetabs;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity{

    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager= (ViewPager) findViewById(R.id.pager);
        myAdapter adapter = new myAdapter(getSupportFragmentManager());

        // Add Fragments to adapter one by one
        adapter.addFragment(new fragment_Location(), "Location");
        adapter.addFragment(new fragment_Call(), "Call");
        adapter.addFragment(new fragment_Messaging(), "Message");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }


}

class  myAdapter extends FragmentPagerAdapter{


    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();


    public myAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;

        if(i==0){
            fragment= new fragment_Messaging();
        }
        if(i==1){
            fragment= new fragment_Call();
        }
        if(i==2){
            fragment= new fragment_Location();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}