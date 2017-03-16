package com.sv.animalchomper;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jinatonic.confetti.CommonConfetti;

public class MainActivity extends AppCompatActivity {

    private ImageButton mouseBTN, catBTN, elephantBTN;
    private ImageView cpuChoice;
    private TextView resultTV, roundTV, playerWinsTV, cpuWinsTV;
    private MediaPlayer mp_button;
    private MediaPlayer mp_button2;
    int round = 0;
    int cpuWins = 0;
    int playerWins = 0;
    MyOnClickListener myOnClickListener = new MyOnClickListener();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mouseBTN = (ImageButton) findViewById(R.id.mouseBTN);
        catBTN = (ImageButton) findViewById(R.id.catBTN);
        elephantBTN = (ImageButton) findViewById(R.id.elephantBTN);

        cpuChoice = (ImageView) findViewById(R.id.cpuChoice);

        resultTV = (TextView) findViewById(R.id.resultTV);
        roundTV = (TextView) findViewById(R.id.roundTV);
        roundTV.setText(String.valueOf(round));

        playerWinsTV = (TextView) findViewById(R.id.playerWinsTV);
        cpuWinsTV = (TextView) findViewById(R.id.cpuWinsTV);

        playerWinsTV.setText(String.valueOf(playerWins));
        cpuWinsTV.setText(String.valueOf(cpuWins));

        mouseBTN.setOnClickListener(myOnClickListener);
        catBTN.setOnClickListener(myOnClickListener);
        elephantBTN.setOnClickListener(myOnClickListener);

        mp_button = MediaPlayer.create(this, R.raw.fire_crackers);
        mp_button2 = MediaPlayer.create(this, R.raw.sad_trombone);
    }


    private class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            final View q = v;

            new CountDownTimer(2000, 500) {
                int count = 0;

                @Override
                public void onTick(long millisUntilFinished) {
                    if (count == 0) {
                        cpuChoice.setImageResource(R.drawable.three);
                        count++;
                    } else if (count == 1) {
                        cpuChoice.setImageResource(R.drawable.two);
                        count++;
                    } else if (count == 2) {
                        cpuChoice.setImageResource(R.drawable.one);
                        count++;
                    }
                }

                public void onFinish() {
                    int rand = (int) (Math.random() * 3 + 1);
                    round++;
                    switch (rand) {
                        /**
                         * rand = 1 means computer is Mouse,
                         * 2 represents Cat,
                         * 3 represents Elephant
                         */
                        case 1:
                            cpuChoice.setImageResource(R.drawable.mouse);  //Computer chooses mouse
                            switch (q.getId()) {
                                case R.id.mouseBTN:   //player chooses mouse
                                    resultTV.setText(R.string.tie);
                                    roundTV.setText(String.valueOf(round));
                                    break;
                                case R.id.catBTN:  //player chooses cat
                                    resultTV.setText(R.string.win);
                                    mp_button.start();
                                    playerWins++;
                                    playerWinsTV.setText(String.valueOf(playerWins));
                                    roundTV.setText(String.valueOf(round));
                                    CommonConfetti.rainingConfetti((ViewGroup) findViewById(android.R.id.content)
                                            , new int[]{Color.RED})
                                            .oneShot();
                                    break;
                                case R.id.elephantBTN:  //player chooses elephant
                                    resultTV.setText(R.string.lose);
                                    mp_button2.start();
                                    cpuWins++;
                                    cpuWinsTV.setText(String.valueOf(cpuWins));
                                    roundTV.setText(String.valueOf(round));
                                    break;
                            }
                            break;

                        case 2:
                            cpuChoice.setImageResource(R.drawable.cat);  //computer chooses cat
                            switch (q.getId()) {
                                case R.id.mouseBTN:
                                    resultTV.setText(R.string.lose);
                                    mp_button2.start();
                                    cpuWins++;
                                    cpuWinsTV.setText(String.valueOf(cpuWins));
                                    roundTV.setText(String.valueOf(round));
                                    break;
                                case R.id.catBTN:
                                    resultTV.setText(R.string.tie);
                                    roundTV.setText(String.valueOf(round));
                                    break;
                                case R.id.elephantBTN:
                                    resultTV.setText(R.string.win);
                                    mp_button.start();
                                    playerWins++;
                                    playerWinsTV.setText(String.valueOf(playerWins));
                                    roundTV.setText(String.valueOf(round));
                                    CommonConfetti.rainingConfetti((ViewGroup) findViewById(android.R.id.content)
                                            , new int[]{Color.RED})
                                            .oneShot();
                                    break;
                            }
                            break;

                        case 3:
                            cpuChoice.setImageResource(R.drawable.elephant);  //computer chooses elephant
                            switch (q.getId()) {
                                case R.id.mouseBTN:
                                    resultTV.setText(R.string.win);
                                    mp_button.start();
                                    playerWins++;
                                    playerWinsTV.setText(String.valueOf(playerWins));
                                    roundTV.setText(String.valueOf(round));
                                    CommonConfetti.rainingConfetti((ViewGroup) findViewById(android.R.id.content)
                                            , new int[]{Color.RED})
                                            .oneShot();
                                    break;
                                case R.id.catBTN:
                                    resultTV.setText(R.string.lose);
                                    mp_button2.start();
                                    cpuWins++;
                                    cpuWinsTV.setText(String.valueOf(cpuWins));
                                    roundTV.setText(String.valueOf(round));
                                    break;
                                case R.id.elephantBTN:
                                    resultTV.setText(R.string.tie);
                                    roundTV.setText(String.valueOf(round));
                                    break;
                            }
                            break;
                    }
                }
            }.start();
        }
    }
}