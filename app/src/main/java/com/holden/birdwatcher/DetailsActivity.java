package com.holden.birdwatcher;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Bird bird = intent.getParcelableExtra("bird");

        ImageView birdImage = (ImageView) findViewById(R.id.birdImage);
        int i = getResources().getIdentifier(bird.getIconFileName(), "drawable", getPackageName());
        birdImage.setImageResource(i);

        TextView birdName = (TextView) findViewById(R.id.birdName);
        birdName.setText(bird.getName());

        TextView category = (TextView) findViewById(R.id.category);
        String categoryString = bird.getSize().toString();
        categoryString = categoryString.substring(0, 1) + categoryString.substring(1).toLowerCase();
        category.setText(categoryString);

        TextView sciName = (TextView) findViewById(R.id.sciName);
        sciName.setText(bird.getSciName());

        TextView conStatus = (TextView) findViewById(R.id.conStatus);
        ConStatus currentBirdConStatus = bird.getConStatus();
        String conStatusString = currentBirdConStatus.toString();
        conStatusString = conStatusString.toLowerCase();

        String[] words = conStatusString.split("_");
        String conStatusFormatted = "";

        for (i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            conStatusFormatted = conStatusFormatted + words[i] + " ";
        }

        conStatusFormatted = conStatusFormatted.trim();
        conStatus.setText(conStatusFormatted);

        switch (currentBirdConStatus) {
            case EXTINCT:
                conStatus.setTextColor(Color.parseColor("#2B0000"));
                break;
            case EXTINCT_IN_THE_WILD:
                conStatus.setTextColor(Color.parseColor("#802200"));
                break;
            case CRITICALLY_ENDANGERED:
                conStatus.setTextColor(Color.parseColor("#FFAA00"));
                break;
            case ENDANGERED:
                conStatus.setTextColor(Color.parseColor("#FFFF00"));
                break;
            case VULNERABLE:
                conStatus.setTextColor(Color.parseColor("#AAFF00"));
                break;
            case NEAR_THREATENED:
                conStatus.setTextColor(Color.parseColor("#55FF00"));
                break;
            case LEAST_CONCERN:
                conStatus.setTextColor(Color.parseColor("#00FF00"));
                break;
            default:
                /* This isn't supposed to happen, but can be left as an error/fail-safe - Holden 28/11*/
                System.out.println("Category not recognised");
        }
    }

    public ArrayList<LinearLayout> getRows() {
        LinearLayout nameRow = (LinearLayout) findViewById(R.id.nameRow);
        LinearLayout categoryRow = (LinearLayout) findViewById(R.id.categoryRow);
        LinearLayout sciNameRow = (LinearLayout) findViewById(R.id.sciNameRow);
        LinearLayout conStatusRow = (LinearLayout) findViewById(R.id.conStatusRow);

        ArrayList<LinearLayout> rows = new ArrayList<>();

        rows.add(nameRow);
        rows.add(categoryRow);
        rows.add(sciNameRow);
        rows.add(conStatusRow);

        return rows;
    }

    public void toggleDetailsFocus(View view) {
        ArrayList<LinearLayout> rows = getRows();
        LinearLayout.LayoutParams categoryRowParams = (LinearLayout.LayoutParams) rows.get(1).getLayoutParams();
        if (categoryRowParams.height == 0) {
            categoryRowParams.height = categoryRowParams.WRAP_CONTENT;
        } else {
            categoryRowParams.height = 0;
        }
        for (int i = 1; i < rows.size(); i++) {
            rows.get(i).setLayoutParams(categoryRowParams);
        }
    }
}
