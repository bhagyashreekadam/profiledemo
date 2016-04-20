package com.example.synerzip.profiledemo1;

/**
 * Created by synerzip on 13/4/16.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import layout.TabFragment1;
import layout.TabFragment2;
import layout.TabFragment3;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    int pos;
    private String tabTitles[] = new String[] { "Tab1", "Tab2", "Tab3" };

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
pos=position;
        switch (position) {
            case 0:
                TabFragment1 tab1 = new TabFragment1();
                tab1.newInstance("Tab 1");
                return tab1;
            case 1:
                TabFragment2 tab2 = new TabFragment2();
                tab2.newInstance("Tab 2");
                return tab2;
            case 2:
                TabFragment3 tab3 = new TabFragment3();
                tab3.newInstance("Tab 3");
                return tab3;
            case 3:
            default:
            tab1 = new TabFragment1();

                tab1.newInstance("Tab 1");
                return tab1;

        }

    }



    @Override
    public int getCount() {
        return 4;
    }


}
