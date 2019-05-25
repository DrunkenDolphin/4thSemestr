package com.example.laba2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Lala extends PagerAdapter
{
    private Context Context;
    private LayoutInflater inflater;

    public Lala(Context Context)
    {
        this.Context = Context;
        this.inflater = LayoutInflater.from(Context);
    }
    @Override
    public int getCount() {
        return List.getSize();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public Object Item(@NonNull ViewGroup container, int position)
    {
        View view = inflater.inflate(R.layout.pager_layout, container, false);
        ImageView iv_pager = view.findViewById(R.id.ImageViewPager);
        TextView tv_pager = view.findViewById(R.id.textViewPager);

        if(List.get(position).getHelpText() != null)
        {
            tv_pager.setText(List.get(position).getHelpText());
        }
        else
        {
            tv_pager.setText("Error");
        }

        Picasso.get()
                .load(List.get(position).getGraphic())
                .placeholder(R.drawable.image_failed)
                .into(iv_pager);
        container.addView(view);

        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
        View view = (View) object;
        container.removeView(view);
    }
}

