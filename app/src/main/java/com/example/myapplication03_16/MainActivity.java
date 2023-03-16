package com.example.myapplication03_16;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private int mCount = 0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.textView_1);
    }
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "hello Toast!",
                            Toast.LENGTH_SHORT);
        toast.show();
    }
    public void countUp(View view) {
        mCount = mCount + 1;
        mShowCount.setText(Integer.toString(mCount));
    }
}