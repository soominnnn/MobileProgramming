package com.example.mobile_20230330_20211916;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewP1,imageViewP2;
    TextView textViewResult,textViewResult2,textViewResult3,textViewResult4;
    ImageButton ImageButton;
    Random random;

    int Count = 0;
    int WinP1 = 0;
    int WinP2 = 0;

    int numP1 = 0;
    int numP2 = 0;
    long Sum_string = 0;
    long Sum_string2 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
        textViewResult2 = findViewById(R.id.textViewResult2);
        textViewResult3 = findViewById(R.id.textViewResult3);
        textViewResult4 = findViewById(R.id.textViewResult4);
        imageViewP1 = findViewById(R.id.imageViewP1);
        imageViewP2 = findViewById(R.id.imageViewP2);
        ImageView win_gif_img = findViewById(R.id.win_gif_img);
        Glide.with(this).load(R.raw.win).into(win_gif_img);
        win_gif_img.setVisibility(View.INVISIBLE);
        ImageView win_gif_img_2 = findViewById(R.id.win_gif_img2);
        Glide.with(this).load(R.raw.win).into(win_gif_img_2);
        win_gif_img_2.setVisibility(View.INVISIBLE);
        ImageView lose_gif_img = findViewById(R.id.lose_gif_img);
        Glide.with(this).load(R.raw.lose).into(lose_gif_img);
        lose_gif_img.setVisibility(View.INVISIBLE);
        ImageView lose_gif_img_2 = findViewById(R.id.lose_gif_img2);
        Glide.with(this).load(R.raw.lose).into(lose_gif_img_2);
        lose_gif_img_2.setVisibility(View.INVISIBLE);
        ImageButton = findViewById(R.id.imageButton);
        random = new Random();



        ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numP1 = random.nextInt(3);
                numP2 = random.nextInt(3);

                Count ++;

                //Count를 통해 textViewResult3에 횟수 보이기
                textViewResult3.setText("총 플레이 횟수 : "+Count);

                //Count가 10 이상, Player 1의 승률이 60 이하인 경우 loop
                while (Count >=10 && Sum_string <= 60){
                    if(numP2 == 0){
                        numP1 = 2;
                        textViewResult2.setText(String.valueOf(Sum_string) + "%");
                        textViewResult4.setText(String.valueOf(Sum_string2) + "%");
                        break;
                    }
                    else if(numP2 == 1){
                        numP1 = 0;
                        textViewResult2.setText(String.valueOf(Sum_string) + "%");
                        textViewResult4.setText(String.valueOf(Sum_string2) + "%");
                        break;
                    }
                    else {
                        numP1 = 1;
                        textViewResult2.setText(String.valueOf(Sum_string) + "%");
                        textViewResult4.setText(String.valueOf(Sum_string2) + "%");
                        break;
                    }
                }
                //이미지 뷰 처리
                if(numP1 == 0){
                    imageViewP1.setImageDrawable(getResources().getDrawable(R.drawable.rock,null));
                }
                else if(numP1 == 1){
                    imageViewP1.setImageDrawable(getResources().getDrawable(R.drawable.scissors,null));
                }
                else{imageViewP1.setImageDrawable(getResources().getDrawable(R.drawable.paper,null));}

                if(numP2 == 0){
                    imageViewP2.setImageDrawable(getResources().getDrawable(R.drawable.rock,null));
                }
                else if(numP2 == 1){
                    imageViewP2.setImageDrawable(getResources().getDrawable(R.drawable.scissors,null));
                }
                else{imageViewP2.setImageDrawable(getResources().getDrawable(R.drawable.paper,null));}

                //승부 판정
                if(numP1 == numP2){
                    textViewResult.setText("무승부");
                    win_gif_img.setVisibility(View.INVISIBLE);
                    lose_gif_img_2.setVisibility(View.INVISIBLE);
                    win_gif_img_2.setVisibility(View.INVISIBLE);
                    lose_gif_img.setVisibility(View.INVISIBLE);
                }
                else if(numP1 == 0 && numP2 == 2|| numP1 == 1 && numP2 ==0 || numP1 == 2 && numP2 == 1){
                    textViewResult.setText("Player2 WIN");
                    WinP2 ++;
                    win_gif_img_2.setVisibility(View.VISIBLE);
                    lose_gif_img.setVisibility(View.VISIBLE);
                    win_gif_img.setVisibility(View.INVISIBLE);
                    lose_gif_img_2.setVisibility(View.INVISIBLE);
                }
                else{
                    textViewResult.setText("Player1 WIN");
                    WinP1 ++;
                    win_gif_img.setVisibility(View.VISIBLE);
                    lose_gif_img_2.setVisibility(View.VISIBLE);
                    win_gif_img_2.setVisibility(View.INVISIBLE);
                    lose_gif_img.setVisibility(View.INVISIBLE);
                }

                //Count가 10의 배수일때마다 승률 출력
                if(Count%10 == 0) {
                    double Sum = (((float) WinP1 / Count) * 100);
                    Sum_string = Math.round(Sum);
                    textViewResult2.setText(String.valueOf(Sum_string) + "%");
                    double Sum2 = (((float) WinP2 / Count) * 100);
                    Sum_string2 = Math.round(Sum2);
                    textViewResult4.setText(String.valueOf(Sum_string2) + "%");
                }

            }
        });
    }
}