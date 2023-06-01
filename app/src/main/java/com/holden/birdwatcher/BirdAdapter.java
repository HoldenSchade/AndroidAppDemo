package com.holden.birdwatcher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BirdAdapter extends ArrayAdapter {

    int mLayoutID;
    ArrayList<Bird> birdList;
    Context mContext;

    public BirdAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Bird> objects) {
        super(context, resource, objects);
        mLayoutID = resource;
        birdList = objects;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentListViewItem = convertView;
        if (currentListViewItem == null) {
            currentListViewItem = LayoutInflater.from(getContext()).inflate(mLayoutID, parent, false);
        }
        Bird currentBird = birdList.get(position);

        ImageView iconImageView = (ImageView) currentListViewItem.findViewById(R.id.icon);
        int i = mContext.getResources().getIdentifier(currentBird.getIconFileName(), "drawable", mContext.getPackageName());

        iconImageView.setImageResource(i);

        TextView birdName = (TextView) currentListViewItem.findViewById(R.id.birdName);
        birdName.setText(currentBird.getName());

        currentListViewItem.setTag(currentBird);

        return currentListViewItem;
    }
}
