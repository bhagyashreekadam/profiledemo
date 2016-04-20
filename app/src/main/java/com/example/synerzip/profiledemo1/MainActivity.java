package com.example.synerzip.profiledemo1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import layout.TabFragment1;
import layout.TabFragment2;
import layout.TabFragment3;


public class MainActivity extends FragmentActivity {

    TextView text;
    CircleImageView next;
    CircleImageView prev;
    ViewPager viewPager;
    ViewPager viewPager1;
    int pos=0;
    String fragString;
    String fragString1;
    int tabno=0;
    boolean prevButtonTapped;
    boolean nextButtonTapped;
    boolean swiped;
    int currentItem;
    int currentPage;
    int positionForMF1;
    int positionForMF2;
    int positionForMF3;
    int positionForMF4;
    int numberOfMainFrags=4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       prev=(CircleImageView)findViewById(R.id.prevButton);
       next=(CircleImageView)findViewById(R.id.nextButton);
         prev.setVisibility(View.GONE);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager1 = (ViewPager) findViewById(R.id.main_pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                currentPage = position;
                if (position!=3) {
                    viewPager.setCurrentItem(position);
                    TabLayout.Tab tab = tabLayout.getTabAt(position);
                    tab.select();
                    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
                }

                if(pos==0)
                {
                    positionForMF1=viewPager.getCurrentItem();
                }else if(pos==1)
                {
                    positionForMF2=viewPager.getCurrentItem();
                }else if(pos==2)
                {
                    positionForMF3=viewPager.getCurrentItem();
                }else if(pos==3){
                    positionForMF4=viewPager.getCurrentItem();
                }
            }
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {

                    if (currentPage == 3){
                        viewPager.setCurrentItem(0,false);
                        TabLayout.Tab tab = tabLayout.getTabAt(currentPage);
                        tab.select();
                        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
                    }


                }
        });
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabno=tab.getPosition();
                viewPager.setCurrentItem(tab.getPosition());
                goToFragment(tabno);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        final PagerAdapter1 adapter1 = new PagerAdapter1(getSupportFragmentManager(),numberOfMainFrags);
        viewPager1.setAdapter(adapter1);
        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                swiped=true;
                if(nextButtonTapped)
                {
                    swiped=false;
                    nextButtonTapped=false;
                    prevButtonTapped=false;
                }
                else if(prevButtonTapped)
                {
                    swiped=false;
                    nextButtonTapped=false;
                    prevButtonTapped=false;
                }
                    int t;
                    pos = position;
                    Log.d("sdgsdgsdgsgd", "Selected page position: " + position);
                    t = viewPager.getCurrentItem();
                    goToFragment1(pos);
                    goToFragment(t);
        }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

  public void a1ButtonClicked(View view)
    {
        swiped=false;
        nextButtonTapped=true;
        prevButtonTapped=false;
           goToFragment(tabno);
           goToFragment1(pos);
    }


    public void prevButtonClicked(View view)
    {
          swiped=false;
          nextButtonTapped=false;
          prevButtonTapped=true;
            goToFragment(tabno);
            goToFragment1(pos);
    }

    public void goToFragment(int k) {

        int bottomFragNumber=k+1;
        int topFragNumber=pos+1;

                fragString = "frag " + bottomFragNumber + " MF" + topFragNumber;

            switch (k) {
                case 0:
                    TabFragment1 fragment = TabFragment1.newInstance(fragString);
                    replaceFragment(fragment);
                    break;

                case 1:
                    TabFragment2 fragment2 = TabFragment2.newInstance(fragString);
                    replaceFragment(fragment2);
                    break;

                case 2:
                    TabFragment3 fragment3 = TabFragment3.newInstance(fragString);
                    replaceFragment(fragment3);
                    break;
            }
    }

    public void replaceFragment(Fragment fragment) {
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().detach(fragment).replace(R.id.fragLayout, fragment).commit();
        } catch (Exception e) {
            Log.d("TAGG", e.toString());
        }
    }


    public void goToFragment1(int k1) {

            fragString1 ="Main Frag" + k1;

            currentItem=viewPager1.getCurrentItem();

            switch (k1) {

                case 0:
                        prev.setVisibility(View.GONE);
                        next.setVisibility(View.VISIBLE);
                        next.setImageResource(R.mipmap.two);

                     viewPager.setCurrentItem(positionForMF1);
                    if (nextButtonTapped && !prevButtonTapped)
                    {
                        viewPager1.setCurrentItem(++currentItem);
                    }
                    else if (prevButtonTapped && !nextButtonTapped)
                    {
                        viewPager1.setCurrentItem(--currentItem);
                    }else if(swiped) {
                        viewPager1.setCurrentItem(currentItem);
                    }
                        break;
                case 1:
                    prev.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                    prev.setImageResource(R.mipmap.one);
                    next.setImageResource(R.mipmap.three);
                    viewPager.setCurrentItem(positionForMF2);
                    if (nextButtonTapped && !prevButtonTapped)
                       {
                           viewPager1.setCurrentItem(++currentItem);
                       }
                    else if (prevButtonTapped && !nextButtonTapped)
                    {
                        viewPager1.setCurrentItem(--currentItem);
                    }else if(swiped){
                           viewPager1.setCurrentItem(currentItem);
                       }
                        break;

                case 2:
                    prev.setVisibility(View.VISIBLE);
                    next.setVisibility(View.VISIBLE);
                    prev.setImageResource(R.mipmap.two);
                    next.setImageResource(R.mipmap.four);

                    viewPager.setCurrentItem(positionForMF3);
                    if (nextButtonTapped && !prevButtonTapped)
                    {
                        viewPager1.setCurrentItem(++currentItem);
                    }
                    else if (prevButtonTapped && !nextButtonTapped)
                    {
                        viewPager1.setCurrentItem(--currentItem);
                    }
                    else if(swiped){
                        viewPager1.setCurrentItem(currentItem);

                    }
                    break;

                case 3:
                    prev.setVisibility(View.VISIBLE);
                    next.setVisibility(View.GONE);
                    prev.setImageResource(R.mipmap.three);
                    next.setImageResource(R.mipmap.add);
                    viewPager.setCurrentItem(positionForMF4);

                    if (nextButtonTapped && !prevButtonTapped)
                    {
                        viewPager1.setCurrentItem(++currentItem);
                    }
                    else if (prevButtonTapped && !nextButtonTapped)
                    {
                        viewPager1.setCurrentItem(--currentItem);
                    }
                    else if(swiped){
                        viewPager1.setCurrentItem(currentItem);
                    }
                    break;
            }
    }
}



