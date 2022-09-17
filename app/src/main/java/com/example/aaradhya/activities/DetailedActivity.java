package com.example.aaradhya.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.aaradhya.R;
import com.example.aaradhya.models.NewProductsModel;
import com.example.aaradhya.models.PopularModel;
import com.example.aaradhya.models.SeeAllModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class DetailedActivity extends AppCompatActivity {

    ImageView detailedImg,addItems,removeItems;
    TextView rating,name,description,price,quantity;
    Button addToCart,buyNow;
    Toolbar toolbar;

    int totalQuantity = 1;
    int totalPrice = 0;

    //New Products
    NewProductsModel newProductsModel = null;

    //Popular
    PopularModel popularModel = null;

    //See All
    SeeAllModel seeAllModel = null;


    FirebaseAuth auth;

    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        toolbar = findViewById(R.id.detailed_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        final Object obj = getIntent().getSerializableExtra("detailed");

        if (obj instanceof NewProductsModel) {

             newProductsModel = (NewProductsModel) obj;

        }else if (obj instanceof PopularModel) {

            popularModel = (PopularModel) obj;

        }else if (obj instanceof SeeAllModel) {

            seeAllModel = (SeeAllModel) obj;

        }

        detailedImg = findViewById(R.id.detailed_img);
        name = findViewById(R.id.detailed_name);
        quantity = findViewById(R.id.quantity);
        rating = findViewById(R.id.rating);
        description = findViewById(R.id.detailed_desc);
        addItems = findViewById(R.id.add_item);
        removeItems = findViewById(R.id.remove_item);
        price = findViewById(R.id.detailed_price);
        addToCart = findViewById(R.id.add_to_cart);
        buyNow = findViewById(R.id.buy_now);


        //New Products
        if (newProductsModel != null){

            Glide.with(getApplicationContext()).load(newProductsModel.getImg_url()).into(detailedImg);
            name.setText(newProductsModel.getName());
            rating.setText(newProductsModel.getRating());
            description.setText(newProductsModel.getDescription());
            price.setText(String.valueOf(newProductsModel.getPrice()));

            totalPrice = Integer.valueOf(newProductsModel.getPrice()) * totalQuantity;
        }
        // Popular
        else if (popularModel != null){

            Glide.with(getApplicationContext()).load(popularModel.getImg_url()).into(detailedImg);
            name.setText(popularModel.getName());
            rating.setText(popularModel.getRating());
            description.setText(popularModel.getDescription());
            price.setText(String.valueOf(popularModel.getPrice()));
            totalPrice = Integer.valueOf(popularModel.getPrice()) * totalQuantity;
        }
        //See All
        else if (seeAllModel != null){

            Glide.with(getApplicationContext()).load(seeAllModel.getImg_url()).into(detailedImg);
            name.setText(seeAllModel.getName());
            rating.setText(seeAllModel.getRating());
            description.setText(seeAllModel.getDescription());
            price.setText(String.valueOf(seeAllModel.getPrice()));

            totalPrice = Integer.valueOf(seeAllModel.getPrice()) * totalQuantity;

        }

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToCart();
            }
        });
        addItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (totalQuantity<100) {
                    totalQuantity++;
                    quantity.setText(String.valueOf(totalQuantity));
                }
                if (newProductsModel != null) {
                    totalPrice = Integer.valueOf(newProductsModel.getPrice()) * totalQuantity;
                }
                if (popularModel != null) {
                    totalPrice = Integer.valueOf(popularModel.getPrice()) * totalQuantity;
                }
                if (seeAllModel != null) {
                    totalPrice = Integer.valueOf(seeAllModel.getPrice()) * totalQuantity;
                }


            }
        });
        removeItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (totalQuantity>1) {
                    totalQuantity--;
                    quantity.setText(String.valueOf(totalQuantity));
                }
                if (newProductsModel != null) {
                    totalPrice = Integer.valueOf(newProductsModel.getPrice()) * totalQuantity;
                }
                if (popularModel != null) {
                    totalPrice = Integer.valueOf(popularModel.getPrice()) * totalQuantity;
                }
                if (seeAllModel != null) {
                    totalPrice = Integer.valueOf(seeAllModel.getPrice()) * totalQuantity;
                }

            }
        });

    }

    private void addToCart() {

        String saveCurrentTime,saveCurrentDate;

        Calendar calForDate = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        saveCurrentDate = currentDate.format(calForDate.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calForDate.getTime());

        final HashMap<String,Object> cartMap = new HashMap<>();


        cartMap.put("Product_Name",name.getText().toString());
        cartMap.put("Product_Price",price.getText().toString());
        cartMap.put("Current_Time",saveCurrentTime);
        cartMap.put("Current_Date",saveCurrentDate);
        cartMap.put("Total_Quantity",quantity.getText().toString());
        cartMap.put("Total_Price",totalPrice);

        firestore.collection("AddToCart").document(auth.getCurrentUser().getUid())
                .collection("User").add(cartMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                Toast.makeText(DetailedActivity.this, "Added to Cart", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}