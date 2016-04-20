package com.example.synerzip.profiledemo1;

/**
 * Created by synerzip on 14/4/16.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import layout.TopFragment1;
import layout.TopFragment2;
import layout.TopFragment3;
import layout.TopFragment4;

public class PagerAdapter1 extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter1(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TopFragment1 tab1 = new TopFragment1();

                tab1.newInstance("Top 1");
                return tab1;
            case 1:
                TopFragment2 tab2 = new TopFragment2();
                tab2.newInstance("Top 2");
                return tab2;
            case 2:
                TopFragment3 tab3 = new TopFragment3();
                tab3.newInstance("Top 3");
                return tab3;
            case 3:
                TopFragment4 tab4 = new TopFragment4();
                tab4.newInstance("Top 4");
                return tab4;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
