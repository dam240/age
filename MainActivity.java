package com.example.administrator.ios;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;
private FragmentTabHost tb;
private RadioGroup rg;
    private ViewPager mViewPager;
    private tab ta;
    private tab1 t2;
    private tab2 t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          tb= (FragmentTabHost) findViewById(android.R.id.tabhost);
        rg= (RadioGroup) findViewById(R.id.gr);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        toolbar.setTitle("app");
        toolbar.setLogo(R.mipmap.ic_nav_weixin_c);
          ta=new tab();
        t2=new tab1();
        t3=new tab2();
        tb.setup(this,getSupportFragmentManager(),R.id.go);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        TabHost.TabSpec h=tb.newTabSpec(0+"").setIndicator(0+"");
        TabHost.TabSpec h1=tb.newTabSpec(1+"").setIndicator(1+"");
        TabHost.TabSpec h2=tb.newTabSpec(2+"").setIndicator(2+"");


        tb.addTab(h, tab.class, null);
        tb.addTab(h1, tab1.class, null);

        tb.addTab(h2, tab2.class, null);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
 rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
     @Override
     public void onCheckedChanged(RadioGroup group, int checkedId) {

         switch (checkedId){

             case R.id.r1:
                 tb.setCurrentTab(0);
                 mViewPager.setCurrentItem(0);
                 break;

             case R.id.r2:
                 tb.setCurrentTab(1);
                 mViewPager.setCurrentItem(1);
                 break;
             case R.id.r3:
                 tb.setCurrentTab(2);
                 mViewPager.setCurrentItem(2);
                 break;

         }

     }

 });

 tb.setCurrentTab(1);


mViewPager.setCurrentItem(1);

mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {


        switch (position){
            case 0:
                rg.check(R.id.r1);
                break;
            case 1:
                rg.check(R.id.r2);
                break;
            case 2:
                rg.check(R.id.r3);
                break;

        }

        Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_LONG).show();

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

             if(position==0){
                 return  ta;

             }else  if(position==1){

                 return  t2;
             }

            return t3;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
