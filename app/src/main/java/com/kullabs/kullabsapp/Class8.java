package com.kullabs.kullabsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.github.aakira.expandablelayout.Utils;

import java.util.ArrayList;
import java.util.List;

import util.DividerItemDecoration;

/**
 * Created by Ojesh on 2/15/2016.
 */
public class Class8 extends AppCompatActivity {
    private View mContentView;


    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, Class8.class));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        //getSupportActionBar().setTitle(Class8.class.getSimpleName());

        final RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.addItemDecoration(new DividerItemDecoration(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final List<ItemModel> data = new ArrayList<>();
        data.add(new ItemModel(
                "Science",
                R.color.red,

                Utils.createInterpolator(Utils.ACCELERATE_DECELERATE_INTERPOLATOR)));
        recyclerView.setAdapter(new RecyclerViewAdapter(data));


    }



}
