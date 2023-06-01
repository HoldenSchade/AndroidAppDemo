package com.holden.birdwatcher;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<Bird> birdList = getBirdList();
        Intent intent = getIntent();
        String categoryTag = intent.getStringExtra("categoryTag");

        /* This switch statement will define the information being inserted into the cards - Holden 26/11 */
        switch (categoryTag) {
            case "category1":
                for (int i = 0; i < birdList.size(); i++) {
                    if (birdList.get(i).getSize() != BirdSize.SMALL) {
                        birdList.remove(i);
                        i--;
                    }
                }
                break;
            case "category2":
                for (int i = 0; i < birdList.size(); i++) {
                    if (birdList.get(i).getSize() != BirdSize.MEDIUM) {
                        birdList.remove(i);
                        i--;
                    }
                }
                break;
            case "category3":
                for (int i = 0; i < birdList.size(); i++) {
                    if (birdList.get(i).getSize() != BirdSize.LARGE) {
                        birdList.remove(i);
                        i--;
                    }
                }
                break;
            default:
                /* This isn't supposed to happen, but can be left as an error/fail-safe - Holden 26/11*/
                System.out.println("Category not recognised");
        }

        ListView listView = (ListView) findViewById(R.id.activityList);
        BirdAdapter itemsAdapter = new BirdAdapter(this, R.layout.activity_list_item, birdList);
        listView.setAdapter(itemsAdapter);

    }

    private ArrayList<Bird> getBirdList() {
        ArrayList<Bird> birdList = new ArrayList<Bird>();
        Bird bird1 = new Bird(1, BirdSize.SMALL, "Cockatiel", "Nymphicus hollandicus", ConStatus.LEAST_CONCERN, "icon1");
        Bird bird2 = new Bird(2, BirdSize.SMALL, "Mindanao bleeding-heart", "Gallicolumba crinigera", ConStatus.VULNERABLE, "icon2");
        Bird bird3 = new Bird(3, BirdSize.SMALL, "Mangrove hummingbird", "Amazilia boucardi", ConStatus.ENDANGERED, "icon3");
        Bird bird4 = new Bird(4, BirdSize.SMALL, "House sparrow", "Passer domesticus", ConStatus.LEAST_CONCERN, "icon4");
        Bird bird5 = new Bird(5, BirdSize.SMALL, "Rock dove", "Columba livia", ConStatus.LEAST_CONCERN, "icon5");
        Bird bird6 = new Bird(6, BirdSize.SMALL, "Little gull", "Hydrocoloeus minutus", ConStatus.LEAST_CONCERN, "icon6");
        Bird bird7 = new Bird(7, BirdSize.SMALL, "White-winged flufftail", "Sarothrura ayresi", ConStatus.CRITICALLY_ENDANGERED, "icon7");
        Bird bird8 = new Bird(8, BirdSize.SMALL, "Spix's macaw", "Cyanopsitta spixii", ConStatus.EXTINCT_IN_THE_WILD, "icon8");
        Bird bird9 = new Bird(9, BirdSize.SMALL, "Alaotra grebe", "Tachybaptus rufolavatus", ConStatus.EXTINCT, "icon9");
        Bird bird10 = new Bird(10, BirdSize.SMALL, "Blue-banded kingfisher", "Alcedo euryzona", ConStatus.CRITICALLY_ENDANGERED, "icon10");
        Bird bird11 = new Bird(11, BirdSize.MEDIUM, "Brahminy kite", "Haliastur indus", ConStatus.LEAST_CONCERN, "icon11");
        Bird bird12 = new Bird(12, BirdSize.MEDIUM, "Hawaiian crow", "Corvus hawaiiensis", ConStatus.EXTINCT_IN_THE_WILD, "icon12");
        Bird bird13 = new Bird(13, BirdSize.MEDIUM, "Australasian swamphen", "Porphyrio melanotus", ConStatus.VULNERABLE, "icon13");
        Bird bird14 = new Bird(14, BirdSize.MEDIUM, "North Island brown kiwi", "Apteryx mantelli", ConStatus.VULNERABLE, "icon14");
        Bird bird15 = new Bird(15, BirdSize.MEDIUM, "Indian peafowl", "Pavo cristatus", ConStatus.LEAST_CONCERN, "icon15");
        Bird bird16 = new Bird(16, BirdSize.MEDIUM, "Andean flamingo", "Phoenicoparrus andinus", ConStatus.VULNERABLE, "icon16");
        Bird bird17 = new Bird(17, BirdSize.MEDIUM, "Christmas frigatebird", "Fregata andrewski", ConStatus.CRITICALLY_ENDANGERED, "icon17");
        Bird bird18 = new Bird(18, BirdSize.MEDIUM, "Pink-headed duck", "Rhodonessa caryophyllacea", ConStatus.CRITICALLY_ENDANGERED, "icon18");
        Bird bird19 = new Bird(19, BirdSize.MEDIUM, "Grey crowned crane", "Balearica regulorum", ConStatus.ENDANGERED, "icon19");
        Bird bird20 = new Bird(20, BirdSize.MEDIUM, "Grey-winged trumpeter", "Psophia crepitans", ConStatus.NEAR_THREATENED, "icon20");
        Bird bird21 = new Bird(21, BirdSize.LARGE, "Oriental darter", "Anhinga melanogaster", ConStatus.NEAR_THREATENED, "icon21");
        Bird bird22 = new Bird(22, BirdSize.LARGE, "Emperor penguin", "Aptenodytes forsteri", ConStatus.NEAR_THREATENED, "icon22");
        Bird bird23 = new Bird(23, BirdSize.LARGE, "Tristan albatross", "Diomedea dabbenena", ConStatus.CRITICALLY_ENDANGERED, "icon23");
        Bird bird24 = new Bird(24, BirdSize.LARGE, "South Island giant moa", "Dinornis robustus", ConStatus.EXTINCT, "icon24");
        Bird bird25 = new Bird(25, BirdSize.LARGE, "Common ostrich", "Struthio camelus", ConStatus.LEAST_CONCERN, "icon25");
        Bird bird26 = new Bird(26, BirdSize.LARGE, "Northern cassowary", "Casuarius unappendiculatus", ConStatus.LEAST_CONCERN, "icon26");
        Bird bird27 = new Bird(27, BirdSize.LARGE, "Mute swan", "Cygnus olor", ConStatus.LEAST_CONCERN, "icon27");
        Bird bird28 = new Bird(28, BirdSize.LARGE, "Kori bustard", "Ardeotis kori", ConStatus.NEAR_THREATENED, "icon28");
        Bird bird29 = new Bird(29, BirdSize.LARGE, "Andean condor", "Vultur gryphus", ConStatus.NEAR_THREATENED, "icon29");
        Bird bird30 = new Bird(30, BirdSize.LARGE, "Cinerous vulture", "Aegypius monachus", ConStatus.NEAR_THREATENED, "icon30");
        birdList.add(bird1);
        birdList.add(bird2);
        birdList.add(bird3);
        birdList.add(bird4);
        birdList.add(bird5);
        birdList.add(bird6);
        birdList.add(bird7);
        birdList.add(bird8);
        birdList.add(bird9);
        birdList.add(bird10);
        birdList.add(bird11);
        birdList.add(bird12);
        birdList.add(bird13);
        birdList.add(bird14);
        birdList.add(bird15);
        birdList.add(bird16);
        birdList.add(bird17);
        birdList.add(bird18);
        birdList.add(bird19);
        birdList.add(bird20);
        birdList.add(bird21);
        birdList.add(bird22);
        birdList.add(bird23);
        birdList.add(bird24);
        birdList.add(bird25);
        birdList.add(bird26);
        birdList.add(bird27);
        birdList.add(bird28);
        birdList.add(bird29);
        birdList.add(bird30);
        return birdList;
    }

    public void createDetailsActivity(View view) {
        CardView bird = (CardView) view;
        Intent detailsActivity = new Intent(this, DetailsActivity.class);
        detailsActivity.putExtra("bird", (Parcelable) bird.getTag());
        startActivity(detailsActivity, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}