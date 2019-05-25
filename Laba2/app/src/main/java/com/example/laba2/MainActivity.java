package com.example.laba2;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RecyclerView itemsList;
    private ClickList ClickList;
    private ViewPager itemsPager;
    private Lala Lala;
    private static boolean isPagePressed = false;
    private static int Position;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsList = findViewById(R.id.rv_list);
        itemsPager = findViewById(R.id.viewPager);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        itemsList.setLayoutManager(layoutManager);

        itemsList.setHasFixedSize(true);

        ClickList = new ClickList(this);
        itemsList.setAdapter(ClickList);

        Lala = new Lala(this);
        itemsPager.setAdapter(Lala);

        if(isPagePressed) {
            itemsPager.setCurrentItem(Position);
            itemsPager.setVisibility(View.VISIBLE);
            itemsList.setVisibility(View.GONE); }

        itemsPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int i, float a, int b)
            {}

            @Override
            public void onPageSelected(int i)
            {}

            @Override
            public void onPageScrollStateChanged(int i)
            {}
        });

        ClickList.setOnClickListener(new ClickList.ClickListener()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                Position = position;
                itemsPager.setCurrentItem(position);
                itemsList.setVisibility(View.GONE);
                itemsPager.setVisibility(View.VISIBLE);
                setTitle(List.get(position).getName());
                isPagePressed = true;
            }
        });

    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    @Override
    public void onBackPressed()
    {
        if(!itemsList.isShown()) {
            itemsList.setVisibility(View.VISIBLE);
            itemsPager.setVisibility(View.GONE);
            isPagePressed = false;
        }
        else
        {
            finish();
        }
    }
}

