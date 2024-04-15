package com.example.tabhostanimal;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecDog = tabHost.newTabSpec("DOG").setIndicator("강아지");
        tabSpecDog.setContent(R.id.dogimg);
        tabHost.addTab(tabSpecDog);

        TabHost.TabSpec tabSpecCat = tabHost.newTabSpec("CAT").setIndicator("고양이");
        tabSpecCat.setContent(R.id.catimg);
        tabHost.addTab(tabSpecCat);

        TabHost.TabSpec tabSpecRab = tabHost.newTabSpec("RABBIT").setIndicator("토끼");
        tabSpecRab.setContent(R.id.rabimg);
        tabHost.addTab(tabSpecRab);

        TabHost.TabSpec tabSpecHor = tabHost.newTabSpec("HORSE").setIndicator("말");
        tabSpecHor.setContent(R.id.horimg);
        tabHost.addTab(tabSpecHor);

        tabHost.setCurrentTab(0);
    }
}