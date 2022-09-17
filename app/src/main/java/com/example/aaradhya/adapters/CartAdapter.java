package com.example.aaradhya.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aaradhya.R;
import com.example.aaradhya.models.CartModel;

import java.util.List;

public class CartAdapter   extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private Context context;
    private List<CartModel>list;

    int totalAmount = 0;

    public CartAdapter(Context context, List<CartModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_cart_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {

        holder.name.setText(list.get(position).getProduct_Name());
        holder.price.setText(list.get(position).getProduct_Price() + "₹");
        holder.date.setText(list.get(position).getCurrent_Date());
        holder.time.setText(list.get(position).getCurrent_Time());
        holder.totalPrice.setText((String.valueOf(list.get(position).getTotal_Price()))+"₹");
        holder.totalQuantity.setText(list.get(position).getTotal_Quantity());

        //Total Amount Pass To Cart Activity

        totalAmount = totalAmount + list.get(position).getTotal_Price();
        Intent intent = new Intent("My Total Amount");
        intent.putExtra("totalAmount",totalAmount);

        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,price,date,time,totalQuantity,totalPrice;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);
            date = itemView.findViewById(R.id.current_date);
            time = itemView.findViewById(R.id.current_time);
            totalQuantity = itemView.findViewById(R.id.total_quantity);
            totalPrice = itemView.findViewById(R.id.total_price);

        }
    }
}
