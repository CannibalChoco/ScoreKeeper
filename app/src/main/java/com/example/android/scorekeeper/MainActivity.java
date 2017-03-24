package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String nameTeamA, nameTeamB;
    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int totalShotsTeamA = 0;
    int totalShotsTeamB = 0;
    int totalPenaltyTeamA = 0;
    int totalPenaltyTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText teamA = (EditText) findViewById(R.id.team_a_name);
        nameTeamA = teamA.getText().toString();

        EditText teamB = (EditText) findViewById(R.id.team_b_name);
        nameTeamB = teamB.getText().toString();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt("scoreTeamA", scoreTeamA);
        outState.putInt("scoreTeamB", scoreTeamB);
        outState.putInt("totalShotsTeamA", totalShotsTeamA);
        outState.putInt("totalShotsTeamB", totalShotsTeamB);
        outState.putInt("totalPenaltyTeamA", totalPenaltyTeamA);
        outState.putInt("totalPenaltyTeamB", totalPenaltyTeamB);
        outState.putString("nameTeamA", nameTeamA);
        outState.putString("nameTeamB", nameTeamB);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt("scoreTeamA");
        scoreTeamB = savedInstanceState.getInt("scoreTeamB");
        totalShotsTeamA = savedInstanceState.getInt("totalShotsTeamA");
        totalShotsTeamB = savedInstanceState.getInt("totalShotsTeamB");
        totalPenaltyTeamA = savedInstanceState.getInt("totalPenaltyTeamA");
        totalPenaltyTeamB = savedInstanceState.getInt("totalPenaltyTeamB");
        nameTeamA = savedInstanceState.getString("nameTeamA");
        nameTeamB = savedInstanceState.getString("nameTeamB");
    }

    public void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayPenaltyForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_total_penalty_minutes);
        scoreView.setText(String.valueOf(score));
    }

    public void displayPenaltyForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_total_penalty_minutes);
        scoreView.setText(String.valueOf(score));
    }

    public void displayShotsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_total_shots);
        scoreView.setText(String.valueOf(score));
    }

    public void displayShotsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_total_shots);
        scoreView.setText(String.valueOf(score));
    }

    public void goalTeamA (View view) {
        scoreTeamA += 1;
        totalShotsTeamA+= 1;
        displayScoreForTeamA(scoreTeamA);
        displayShotsForTeamA(totalShotsTeamA);
    }

    public void goalTeamB (View view) {
        scoreTeamB += 1;
        totalShotsTeamB += 1;
        displayScoreForTeamB(scoreTeamB);
        displayShotsForTeamB(totalShotsTeamB);
    }

    public void shotTeamA (View view){
        totalShotsTeamA += 1;
        displayShotsForTeamA(totalShotsTeamA);
    }

    public void shotTeamB (View view){
        totalShotsTeamB += 1;
        displayShotsForTeamB(totalShotsTeamB);
    }

    public void twoPenaltyMinutesTeamA (View view) {
        totalPenaltyTeamA += 2;
        displayPenaltyForTeamA(totalPenaltyTeamA);
    }

    public void twoPenaltyMinutesTeamB (View view) {
        totalPenaltyTeamB += 2;
        displayPenaltyForTeamB(totalPenaltyTeamB);
    }

    public void fivePenaltyMinutesTeamA (View view) {
        totalPenaltyTeamA += 5;
        displayPenaltyForTeamA(totalPenaltyTeamA);
    }

    public void fivePenaltyMinutesTeamB (View view) {
        totalPenaltyTeamB += 5;
        displayPenaltyForTeamB(totalPenaltyTeamB);
    }

    public void resetAll(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        totalShotsTeamA = 0;
        totalShotsTeamB = 0;
        totalPenaltyTeamA= 0;
        totalPenaltyTeamB = 0;
        displayScoreForTeamA(scoreTeamA);
        displayScoreForTeamB(scoreTeamB);
        displayShotsForTeamA(totalShotsTeamA);
        displayShotsForTeamB(totalShotsTeamB);
        displayPenaltyForTeamA(totalPenaltyTeamA);
        displayPenaltyForTeamB(totalPenaltyTeamB);

        EditText teamA = (EditText) findViewById(R.id.team_a_name);
        teamA.setText("");

        EditText teamB = (EditText) findViewById(R.id.team_b_name);
        teamB.setText("");
    }
}
