package com.example.k_jay.guess_game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnPlayer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlayer1 = (Button)findViewById(R.id.btnPlayer1);

        btnPlayer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent PLAYER1  = new Intent(MainActivity.this, Player1Activity.class);
                startActivity(PLAYER1);
            }
        });
    }
}
