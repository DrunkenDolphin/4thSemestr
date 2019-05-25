package com.example.laba2;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ClickList extends RecyclerView.Adapter<ClickList.ListViewHolder>
{

    private LayoutInflater inflater;
    private Context Context;
    private static ClickListener clickListener;

    public ClickList(Context Context)
    {
        this.inflater = LayoutInflater.from(Context);
        this.Context = Context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        Context mContext = viewGroup.getContext();
        int ListItem = R.layout.list_item;

        View view = inflater.inflate(ListItem, viewGroup, false);

        ListViewHolder viewHolder = new ListViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ClickList.ListViewHolder listViewHolder, int position)
    {
        listViewHolder.textView.setText(List.get(position).getName());

        Picasso.get()
                .load(List.get(position).getGraphic())
                .placeholder(R.drawable.image_failed)
                .into(listViewHolder.imageView);

        if (position % 2 == 1)
            listViewHolder.itemView.setBackgroundColor(Color.parseColor("#f3e5ab"));
        else
            listViewHolder.itemView.setBackgroundColor(Color.parseColor("#ace1af"));

    }

    @Override
    public int getItemCount()
    {
        return List.getSize();
    }

    class ListViewHolder extends RecyclerView.ViewHolder
    {
        private final ImageView imageView;
        private final TextView textView;

        public ListViewHolder(@NonNull View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    clickListener.onItemClick(v, getAdapterPosition());
                }
            });
        }

    }
    public interface ClickListener
    {
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(ClickListener clickListener)
    {
        ClickList.clickListener = clickListener;
    }
}


