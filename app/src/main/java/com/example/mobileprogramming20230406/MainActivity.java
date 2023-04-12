package com.example.mobileprogramming20230406;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView ImageViewP1Num1,ImageViewP1Num2,ImageViewP2Num1, ImageViewP2Num2;
    ImageButton imageButton;

    TextView winner, percentageP1, percentageP2 ;

    int[] clover = {R.drawable.clover1,R.drawable.clover2,R.drawable.clover3,
            R.drawable.clover4,R.drawable.clover5,R.drawable.clover6,R.drawable.clover7,
            R.drawable.clover8,R.drawable.clover9,R.drawable.clover10,R.drawable.clover11,
            R.drawable.clover12,R.drawable.clover13};
    int[] heart = {R.drawable.heart1,R.drawable.heart2,R.drawable.heart3,
            R.drawable.heart4,R.drawable.heart5,R.drawable.heart6,R.drawable.heart7,
            R.drawable.heart8,R.drawable.heart9,R.drawable.heart10,R.drawable.heart11,
            R.drawable.heart12,R.drawable.heart13};
    int[] spade = {R.drawable.spade1,R.drawable.spade2,R.drawable.spade3,
            R.drawable.spade4,R.drawable.spade5,R.drawable.spade6,R.drawable.spade7,
            R.drawable.spade8,R.drawable.spade9,R.drawable.spade10,R.drawable.spade11,
            R.drawable.spade12,R.drawable.spade13};

    int[] daia = {R.drawable.daia1,R.drawable.daia2,R.drawable.daia3,
            R.drawable.daia4,R.drawable.daia5,R.drawable.daia6,R.drawable.daia7,
            R.drawable.daia8,R.drawable.daia9,R.drawable.daia10,R.drawable.daia11,
            R.drawable.daia12,R.drawable.daia13};

    int WinP1 = 0;
    int WinP2 = 0;
    int Count = 0;

    long Sum_string = 0;
    long Sum_string2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageViewP1Num1 = findViewById(R.id.imageViewP1Num1);
        ImageViewP1Num2 = findViewById(R.id.imageViewP1Num2);
        ImageViewP2Num1 = findViewById(R.id.imageViewP2Num1);
        ImageViewP2Num2 = findViewById(R.id.imageViewP2Num2);

        imageButton = findViewById(R.id.imageButton);

        winner = findViewById(R.id.winnerPlayer);
        percentageP1 = findViewById(R.id.percentageP1);
        percentageP2 = findViewById(R.id.percentageP2);

        ImageView[] imageViews = {ImageViewP1Num1,ImageViewP1Num2,
                                  ImageViewP2Num1,ImageViewP2Num2 };

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Count++;
                Random random = new Random();
                int randomP1 = random.nextInt(13);
                int randomP2 = random.nextInt(13);
                int randomP12 = random.nextInt(13);
                int randomP22 = random.nextInt(13);
                imageViews[0].setImageResource(heart[randomP1]);
                imageViews[1].setImageResource(clover[randomP12]);
                imageViews[2].setImageResource(spade[randomP2]);
                imageViews[3].setImageResource(daia[randomP22]);

                if(randomP1 + randomP12 > randomP2 + randomP22){
                    winner.setText("Player1 WIN!");
                    WinP1++;
                }
                else if(randomP1 + randomP12 == randomP2 + randomP22){
                    winner.setText("무승부!");
                }
                else{
                    winner.setText("Player2 WIN!");
                    WinP2++;
                }
                double Sum = (((float) WinP1 / Count) * 100);
                Sum_string = Math.round(Sum);
                percentageP1.setText(String.valueOf(Sum_string) + "%");
                double Sum2 = (((float) WinP2 / Count) * 100);
                Sum_string2 = Math.round(Sum2);
                percentageP2.setText(String.valueOf(Sum_string2) + "%");
            }
        });
    }
}
