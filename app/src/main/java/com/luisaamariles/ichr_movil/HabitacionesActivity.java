package com.luisaamariles.ichr_movil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.widget.FrameLayout;

/**
 * Created by Luisa Maria Amariles on 22/10/2016.
 */
public class HabitacionesActivity extends MainActivity {
    private ViewPager mViewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.contenedorFrame);
        getLayoutInflater().inflate(R.layout.habitaciones, contentFrameLayout);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(pagerAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
            }
        };

        ActionBar.Tab tab = actionBar.newTab().setText("SUITE").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("JUNIOR").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("SUPERIOR").setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("ESPECIAL").setTabListener(tabListener);
        actionBar.addTab(tab);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }
        });

    }

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new SuiteFragment();
                case 1:
                    return new JuniorFragment();
                case 2:
                    return new SuperiorFragment();
                case 3:
                    return new EspecialFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

}
