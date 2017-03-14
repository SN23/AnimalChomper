package com.sv.animalchomper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton mouseBTN, catBTN, elephantBTN;
    private ImageView cpuChoice;
    private TextView resultTV, roundTV;
    int count = 0;
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

        mouseBTN.setOnClickListener(myOnClickListener);
        catBTN.setOnClickListener(myOnClickListener);
        elephantBTN.setOnClickListener(myOnClickListener);
    }


    private class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            // get a random number form 1 to 3
            int rand = (int) (Math.random() * 3 + 1);
            count++;//


            switch (rand) {
                /**
                 * rand = 1 means computer is Mouse,
                 * 2 represents Cat,
                 * 3 represents Elephant
                 */
                case 1:
                    cpuChoice.setImageResource(R.drawable.mouse);  //computer choose mouse
                    switch (v.getId()) {
                        case R.id.mouseBTN:   //player choose mouse
                            resultTV.setText(R.string.tie);
                            roundTV.setText(String.valueOf(count));
                            break;
                        case R.id.catBTN:  //player choose cat
                            resultTV.setText(R.string.win);
                            roundTV.setText(String.valueOf(count));
                            break;
                        case R.id.elephantBTN:  //player choose elephant
                            resultTV.setText(R.string.lose);
                            roundTV.setText(String.valueOf(count));
                            break;
                    }
                    break;

                case 2:
                    cpuChoice.setImageResource(R.drawable.cat);  //computer choose cat
                    switch (v.getId()) {
                        case R.id.mouseBTN:
                            resultTV.setText(R.string.lose);
                            roundTV.setText(String.valueOf(count));
                            break;
                        case R.id.catBTN:
                            resultTV.setText(R.string.tie);
                            roundTV.setText(String.valueOf(count));
                            break;
                        case R.id.elephantBTN:
                            resultTV.setText(R.string.win);
                            roundTV.setText(String.valueOf(count));
                            break;
                    }
                    break;

                case 3:
                    cpuChoice.setImageResource(R.drawable.elephant);  //computer choose elephant
                    switch (v.getId()) {
                        case R.id.mouseBTN:
                            resultTV.setText(R.string.win);
                            roundTV.setText(String.valueOf(count));
                            break;
                        case R.id.catBTN:
                            resultTV.setText(R.string.lose);
                            roundTV.setText(String.valueOf(count));
                            break;
                        case R.id.elephantBTN:
                            resultTV.setText(R.string.tie);
                            roundTV.setText(String.valueOf(count));
                            break;
                    }
                    break;
            }
        }
    }
}