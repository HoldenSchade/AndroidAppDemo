package com.holden.birdwatcher;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createListActivity(View view) {
        CardView category = (CardView) view;
        Intent listActivity = new Intent(this, ListActivity.class);
        listActivity.putExtra("categoryTag", category.getTag().toString());
        startActivity(listActivity, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}