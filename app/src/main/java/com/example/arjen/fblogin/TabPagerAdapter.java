package com.example.arjen.fblogin;

/**
 * Created by Arjen on 3/8/2016.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                //Fragement for Movie Tab
                return new EventsFragment();
            case 1:
                //Fragment for Music Tab
                return new MyEventsFragment();
            case 2:
                //Fragment for video Tab
                return new AccountFragment();
        }
        return null;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 3; //No of Tabs you can give your number of tabs
    }


}