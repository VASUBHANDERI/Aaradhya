package com.example.aaradhya.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.aaradhya.R;
import com.example.aaradhya.activities.DetailedActivity;
import com.example.aaradhya.models.SeeAllModel;

import java.util.List;

public class SeeAllAdapter   extends RecyclerView.Adapter<SeeAllAdapter.ViewHolder> {

    private Context context;
    private List<SeeAllModel> list;
    public SeeAllAdapter(Context context, List<SeeAllModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SeeAllAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.see_all_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SeeAllAdapter.ViewHolder holder, int position) {

        Glide.with(context).load(list.get(position).getImg_url()).into(holder.mItemImage);
        holder.mName.setText(list.get(position).getName());
        holder.mCost.setText(String.valueOf(list.get(position).getPrice()));
        holder.mRating.setText(list.get(position).getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtra("detailed",list.get(position));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mItemImage;
        private TextView mCost;
        private TextView mName;
        private TextView mRating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mItemImage = itemView.findViewById(R.id.item_image);
            mCost = itemView.findViewById(R.id.item_cost);
            mName = itemView.findViewById(R.id.item_nam);
            mRating = itemView.findViewById(R.id.item_rating);

        }
    }
}
