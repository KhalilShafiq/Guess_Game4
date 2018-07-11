package com.example.k_jay.guess_game;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Player1Activity extends AppCompatActivity {

    EditText edtLowR, edtHighR, edtNumber;
    Button btnOK, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player1);

        edtHighR = (EditText) findViewById(R.id.edtHighR);
        edtLowR = (EditText) findViewById(R.id.edtLowR);
        edtNumber = (EditText) findViewById(R.id.edtNumber);
        btnOK = (Button) findViewById(R.id.btnOK);
        btnClear = (Button) findViewById(R.id.btnClear);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(edtHighR.getText()) || TextUtils.isEmpty(edtLowR.getText()) || TextUtils.isEmpty(edtNumber.getText()))
                {
                    Toast.makeText(getApplicationContext(), "Something Wrong", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent PLAYER2 = new Intent(Player1Activity.this, Player2Activity.class);
                    int lowR = Integer.parseInt(edtLowR.getText().toString());
                    int highR = Integer.parseInt(edtHighR.getText().toString());
                    int number = Integer.parseInt(edtNumber.getText().toString());
                    PLAYER2.putExtra("LOWRANGE", lowR);
                    PLAYER2.putExtra("HIGHRANGE", highR);
                    PLAYER2.putExtra("NUMBER", number);
                    startActivity(PLAYER2);
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            edtHighR.setText("");
            edtLowR.setText("");
            edtNumber.setText("");
            }
        });
    }
}
