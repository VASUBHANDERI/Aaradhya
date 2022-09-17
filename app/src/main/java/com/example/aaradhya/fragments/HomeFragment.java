package com.example.aaradhya.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.aaradhya.R;
import com.example.aaradhya.activities.SeeAllActivity;
import com.example.aaradhya.adapters.CategoryAdapter;
import com.example.aaradhya.adapters.NewProductsAdapter;
import com.example.aaradhya.adapters.PopularAdapter;
import com.example.aaradhya.models.CategoryModel;
import com.example.aaradhya.models.NewProductsModel;
import com.example.aaradhya.models.PopularModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

   TextView catSeeAll,popularSeeAll,newProductsSeeAll;

    LinearLayout linearLayout;
    ProgressDialog progressDialog;
    RecyclerView catRecyclerview,newProductRecyclerview,popularRecyclerview;
    //Category Recyclerview
    CategoryAdapter categoryAdapter;
    List<CategoryModel>categoryModelList;

    //New Product Recyclerview
    NewProductsAdapter newProductsAdapter;
    List<NewProductsModel>newProductsModelList;

    //populara Recyclerview
    PopularAdapter popularAdapter;
    List<PopularModel>popularMoldelList;


    // FireStore
    FirebaseFirestore db ;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        progressDialog = new ProgressDialog(getActivity());
        catRecyclerview = root.findViewById(R.id.rec_category);
        newProductRecyclerview = root.findViewById(R.id.new_product_rec);
        popularRecyclerview = root.findViewById(R.id.popular_rec);

        catSeeAll = root.findViewById(R.id.category_see_all);
        newProductsSeeAll = root.findViewById(R.id.newProducts_see_all);
        popularSeeAll = root.findViewById(R.id.popular_see_all);

        catSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SeeAllActivity.class);
                startActivity(intent);
            }
        });


      newProductsSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SeeAllActivity.class);
                startActivity(intent);
            }
        });


        popularSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SeeAllActivity.class);
                startActivity(intent);
            }
        });

        db = FirebaseFirestore.getInstance();

        linearLayout = root.findViewById(R.id.home_layout);
        linearLayout.setVisibility(View.GONE);
        //image slider
        ImageSlider imageSlider = root.findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.acard,"AARADHYA TRENDS", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner1,"WELCOME", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner2,"GOOD PRODUCTS", ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.banner3,"ENJOY", ScaleTypes.CENTER_CROP));


        imageSlider.setImageList(slideModels);
        progressDialog.setTitle("Welcome to Aaradhya Trends");
        progressDialog.setMessage("Please wait....");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        // Category
        catRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        categoryModelList = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(getContext(),categoryModelList);
        catRecyclerview.setAdapter(categoryAdapter);

        db.collection("Category")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                CategoryModel categoryModel = document.toObject(CategoryModel.class);
                                categoryModelList.add(categoryModel);
                                categoryAdapter.notifyDataSetChanged();
                                linearLayout.setVisibility(View.VISIBLE);
                                progressDialog.dismiss();

                            }
                        } else {

                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        //New Products

        newProductRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        newProductsModelList = new ArrayList<>();
        newProductsAdapter = new NewProductsAdapter(getContext(),newProductsModelList);
        newProductRecyclerview.setAdapter(newProductsAdapter);

        db.collection("NewProducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                NewProductsModel newProductsModel = document.toObject(NewProductsModel.class);
                                newProductsModelList.add(newProductsModel);
                                newProductsAdapter.notifyDataSetChanged();

                            }
                        } else {

                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();
                            
                        }
                    }
                });
        //Popular

        popularRecyclerview.setLayoutManager(new GridLayoutManager(getActivity(),2));
        popularMoldelList = new ArrayList<>();
        popularAdapter = new PopularAdapter(getContext(),popularMoldelList);
        popularRecyclerview.setAdapter(popularAdapter);

        db.collection("PopularProducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                PopularModel popularModel = document.toObject(PopularModel.class);
                                popularMoldelList.add(popularModel);
                                popularAdapter.notifyDataSetChanged();

                            }
                        } else {

                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });


        return root;

    }
}