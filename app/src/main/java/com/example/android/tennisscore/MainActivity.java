package com.example.android.tennisscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.tennisscore.R.id.games;

public class MainActivity extends AppCompatActivity {

    int     pointsForA = 0,
            pointsForB = 0,
            gamesForA = 0,
            gamesForB = 0,
            setsForA = 0,
            setsForB = 0;

    TextView pointATextView,
             pointBTextView,
             gameATextView,
             gameBTextView,
             setATextView,
             setBTextView;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.

        savedInstanceState.putInt("PointsForA", pointsForA);
        savedInstanceState.putInt("PointsForB" , pointsForB);
        savedInstanceState.putInt("GamesForA", gamesForA);
        savedInstanceState.putInt("GamesForB", gamesForB);
        savedInstanceState.putInt("SetsForA", setsForA);
        savedInstanceState.putInt("SetsForA", setsForB);

        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pointATextView = (TextView) findViewById(R.id.point_for_a);
        pointBTextView = (TextView) findViewById(R.id.point_for_b);
        gameATextView = (TextView) findViewById(R.id.game_for_a);
        gameBTextView = (TextView) findViewById(R.id.game_for_b);
        setATextView = (TextView) findViewById(R.id.set_for_a);
        setBTextView = (TextView) findViewById(R.id.set_for_b);

    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.

        pointsForA = savedInstanceState.getInt("PointsForA");
        pointsForB = savedInstanceState.getInt("PointsForB");
        gamesForA = savedInstanceState.getInt("GamesForA");
        gamesForB = savedInstanceState.getInt("GamesForB");
        setsForA = savedInstanceState.getInt("SetsForA");
        setsForB = savedInstanceState.getInt("SetsForB");

        displayPointScore(pointATextView,pointsForA);
        displayPointScore(pointBTextView,pointsForB);
        displayPointScore(gameATextView, gamesForA);
        displayPointScore(gameBTextView, gamesForB);
        displayPointScore(setATextView, setsForA);
        displayPointScore(setBTextView, setsForB);
    }


    public void scorePlayerA(View view){
       if (pointsForA < 30)
            pointsForA += 15;
        else pointsForA += 10;

        if ((pointsForA > 40)&&(pointsForB <= 30)){
            pointsForA = 0;
            pointsForB = 0;
            gamesForA ++;
        }

        if((pointATextView.getText() == "AD") && (pointsForB == 40)) {
            pointsForA = 0;
            pointsForB = 0;
            gamesForA++;
        }

        if((pointsForA > 40) && (pointBTextView.getText() == "AD")) {
            pointsForA = 40;
            pointsForB = 40;
        }

        if((gamesForA > 5) && (gamesForB < 5)){
            pointsForA = 0;
            pointsForB = 0;
            gamesForA = 0;
            gamesForB = 0;
            setsForA ++;
        }

        if((gamesForA == 7) && ((gamesForB == 5) || (gamesForB == 6))){
            pointsForA = 0;
            pointsForB = 0;
            gamesForA = 0;
            gamesForB = 0;
            setsForA ++;
        }

        if((setsForA == 2) && (pointsForA == 15)){
            pointsForA = 0;
            pointsForB = 0;
            gamesForA = 0;
            gamesForB = 0;
            setsForA = 0;
            setsForB = 0;
        }
        if((pointsForA > 40) && (pointsForB == 40))
            displayPointScore(pointATextView);
        else
            displayPointScore(pointATextView,pointsForA);

        displayPointScore(pointBTextView,pointsForB);
        displayPointScore(gameATextView, gamesForA);
        displayPointScore(gameBTextView, gamesForB);
        displayPointScore(setATextView, setsForA);
        displayPointScore(setBTextView, setsForB);

    }

    public void scorePlayerB(View view){
        if(pointsForB < 30)
            pointsForB +=15;
        else pointsForB += 10;

        if ((pointsForB > 40) && (pointsForA <= 30)){
            pointsForA = 0;
            pointsForB = 0;
            gamesForB ++;
        }

        if((pointBTextView.getText() == "AD") && (pointsForA == 40)) {
            pointsForA = 0;
            pointsForB = 0;
            gamesForB++;
        }

        if((pointATextView.getText() == "AD") && (pointsForB > 40)) {
            pointsForA = 40;
            pointsForB = 40;
        }
        if((gamesForB > 5) && (gamesForA < 5)){
            pointsForA = 0;
            pointsForB = 0;
            gamesForA = 0;
            gamesForB = 0;
            setsForB ++;
        }

        if((gamesForB == 7) && ((gamesForA == 5) || (gamesForA == 6))){
            pointsForA = 0;
            pointsForB = 0;
            gamesForA = 0;
            gamesForB = 0;
            setsForB ++;
        }

        if(setsForB == 2){
            pointsForA = 0;
            pointsForB = 0;
            gamesForA = 0;
            gamesForB = 0;
            setsForA = 0;
            setsForB = 0;
        }
        if((pointsForB > 40) && (pointsForA == 40))
            displayPointScore(pointBTextView);
        else
            displayPointScore(pointBTextView,pointsForB);
        displayPointScore(pointATextView,pointsForA);
        displayPointScore(gameATextView, gamesForA);
        displayPointScore(gameBTextView, gamesForB);
        displayPointScore(setBTextView, setsForA);
        displayPointScore(setBTextView, setsForB);
    }

    public void resetScore(View view){
        pointsForA = 0;
        pointsForB = 0;
        gamesForA = 0;
        gamesForB = 0;
        setsForA = 0;
        setsForB = 0;

        displayPointScore(pointATextView,pointsForA);
        displayPointScore(pointBTextView, pointsForB);
        displayPointScore(gameATextView, gamesForA);
        displayPointScore(gameBTextView, gamesForB);
        displayPointScore(setBTextView, setsForA);
        displayPointScore(setBTextView, setsForB);
    }
    public void displayPointScore(TextView text, int number){

        text.setText("" + number);
    }

    public void displayPointScore(TextView text){
        text.setText("AD");
    }
}
