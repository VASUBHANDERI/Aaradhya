package com.example.aaradhya.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aaradhya.R;
import com.example.aaradhya.adapters.SeeAllAdapter;
import com.example.aaradhya.models.SeeAllModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class SeeAllActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    SeeAllAdapter seeAllAdapter;
    List<SeeAllModel> seeAllModelList;

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);

        toolbar = findViewById(R.id.see_all_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String type = getIntent().getStringExtra("type");

        firestore = FirebaseFirestore.getInstance();

        recyclerView = findViewById(R.id.see_all_rec);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        seeAllModelList = new ArrayList<>();
        seeAllAdapter = new SeeAllAdapter(this,seeAllModelList);
        recyclerView.setAdapter(seeAllAdapter);


        if (type == null || type.isEmpty()){


            firestore.collection("SeeAll")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (DocumentSnapshot doc :task.getResult().getDocuments()) {

                                    SeeAllModel seeAllModel = doc.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();
                                    //linearLayout.setVisibility(View.VISIBLE);
                                    //progressDialog.dismiss();

                                }
                            }
//                        else {
//
//                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();
//
//                        }
                        }
                    });

        }

        if (type != null && type.equalsIgnoreCase("men")){

            firestore.collection("SeeAll").whereEqualTo("type","men")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (DocumentSnapshot doc :task.getResult().getDocuments()) {

                                    SeeAllModel seeAllModel = doc.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();
                                    //linearLayout.setVisibility(View.VISIBLE);
                                    //progressDialog.dismiss();

                                }
                            }
//                        else {
//
//                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();
//
//                        }
                        }
                    });


        }
        if (type != null && type.equalsIgnoreCase("camera")){

            firestore.collection("SeeAll").whereEqualTo("type","camera")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (DocumentSnapshot doc :task.getResult().getDocuments()) {

                                    SeeAllModel seeAllModel = doc.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();
                                    //linearLayout.setVisibility(View.VISIBLE);
                                    //progressDialog.dismiss();

                                }
                            }
//                        else {
//
//                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();
//
//                        }
                        }
                    });


        }
        if (type != null && type.equalsIgnoreCase("watch")){

            firestore.collection("SeeAll").whereEqualTo("type","watch")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (DocumentSnapshot doc :task.getResult().getDocuments()) {

                                    SeeAllModel seeAllModel = doc.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();
                                    //linearLayout.setVisibility(View.VISIBLE);
                                    //progressDialog.dismiss();

                                }
                            }
//                        else {
//
//                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();
//
//                        }
                        }
                    });


        }
        if (type != null && type.equalsIgnoreCase("perfume")){

            firestore.collection("SeeAll").whereEqualTo("type","perfume")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (DocumentSnapshot doc :task.getResult().getDocuments()) {

                                    SeeAllModel seeAllModel = doc.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();
                                    //linearLayout.setVisibility(View.VISIBLE);
                                    //progressDialog.dismiss();

                                }
                            }
//                        else {
//
//                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();
//
//                        }
                        }
                    });


        }
        if (type != null && type.equalsIgnoreCase("shoes")){

            firestore.collection("SeeAll").whereEqualTo("type","shoes")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (DocumentSnapshot doc :task.getResult().getDocuments()) {

                                    SeeAllModel seeAllModel = doc.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();
                                    //linearLayout.setVisibility(View.VISIBLE);
                                    //progressDialog.dismiss();

                                }
                            }
//                        else {
//
//                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();
//
//                        }
                        }
                    });


        }
        if (type != null && type.equalsIgnoreCase("women")){

            firestore.collection("SeeAll").whereEqualTo("type","women")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (DocumentSnapshot doc :task.getResult().getDocuments()) {

                                    SeeAllModel seeAllModel = doc.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();
                                    //linearLayout.setVisibility(View.VISIBLE);
                                    //progressDialog.dismiss();

                                }
                            }
//                        else {
//
//                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();
//
//                        }
                        }
                    });


        }
        if (type != null && type.equalsIgnoreCase("toy")){

            firestore.collection("SeeAll").whereEqualTo("type","toy")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (DocumentSnapshot doc :task.getResult().getDocuments()) {

                                    SeeAllModel seeAllModel = doc.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();
                                    //linearLayout.setVisibility(View.VISIBLE);
                                    //progressDialog.dismiss();

                                }
                            }
//                        else {
//
//                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();
//
//                        }
                        }
                    });


        }
        if (type != null && type.equalsIgnoreCase("kid")){

            firestore.collection("SeeAll").whereEqualTo("type","kid")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (DocumentSnapshot doc :task.getResult().getDocuments()) {

                                    SeeAllModel seeAllModel = doc.toObject(SeeAllModel.class);
                                    seeAllModelList.add(seeAllModel);
                                    seeAllAdapter.notifyDataSetChanged();
                                    //linearLayout.setVisibility(View.VISIBLE);
                                    //progressDialog.dismiss();

                                }
                            }
//                        else {
//
//                            Toast.makeText(getActivity(), ""+task.getException(), Toast.LENGTH_SHORT).show();
//
//                        }
                        }
                    });


        }

    }
}