package com.example.k_jay.guess_game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Player2Activity extends AppCompatActivity {
    Button btnCkeck;
    Button btnClearP2;
    TextView txtRange;
    EditText edtGuess;
    int lowR, highR, number, guessnumber, turn = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player2);
        btnCkeck = (Button) findViewById(R.id.btnCheck);
        btnClearP2 = (Button) findViewById(R.id.btnCLearP2);

        txtRange = (TextView) findViewById(R.id.tvRange);
        edtGuess = (EditText) findViewById(R.id.edtGuess);
        Intent intent = getIntent();
        lowR = intent.getIntExtra("LOWRANGE", 0);
        highR = intent.getIntExtra("HIGHRANGE", 0);
        number = intent.getIntExtra("NUMBER", 0);
        txtRange.setText("Range between " + lowR + " ~ " + highR);

        btnCkeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(TextUtils.isEmpty((edtGuess.getText())))
              {
                  Toast.makeText(getApplicationContext(), "Something Wrong! Ckeck Inputs", Toast.LENGTH_SHORT).show();
              }
              else
              {
                  guessnumber =Integer.parseInt(edtGuess.getText().toString());
                  if(turn > 3)
                  {
                      Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_SHORT).show();
                      Intent main = new Intent(Player2Activity.this, MainActivity.class);
                      startActivity(main);
                  }
                  else
                  {
                      if(guessnumber == number)
                      {
                          Toast.makeText(getApplicationContext(), "Congradulation! You Win!", Toast.LENGTH_LONG).show();
                      }
                      else
                      {
                          Toast.makeText(getApplicationContext(), "Try Again!", Toast.LENGTH_LONG).show();
                      }
                      turn++;
                  }
              }
            }
        });
        btnClearP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtGuess.setText("");
            }
        });
    }

}
