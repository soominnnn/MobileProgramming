package com.example.eventhandler20211916;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button buttonClick;
    TextView textViewFirst;
    EditText editText;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClick = (Button) findViewById(R.id.button);
        textViewFirst = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextTextPersonName);
        buttonClick.setOnClickListener(myClickListener);
    }

    View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "익명클래스 리스너 사용",Toast.LENGTH_SHORT).show();
            message = editText.getText().toString();
            textViewFirst.setText(message);
        }
    };
}
