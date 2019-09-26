package com.si.pranishgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2, btnNew;
    private TextView point;
//    final int random1 = new Random().nextInt(100) + 1; // [0, 99] + 1 => [1, 100]
//    final int random2 = new Random().nextInt(100) + 1; // [0, 99] + 1 => [1, 100]

    int random1, random2, total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btnNew = findViewById(R.id.btnNew);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btnNew.setOnClickListener(this);

        Gen_Ran(btn1, btn2);
        point = findViewById(R.id.point);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                Check(btn1, btn2);
                Score();
                break;

            case R.id.btn2:
                Check(btn2, btn1);
                Score();
                break;

            case R.id.btnNew:
                point.setText("");
                total = 0;
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                Gen_Ran(btn1, btn2);
                break;
        }

    }

    public void Gen_Ran(Button b1, Button b2) {
        random1 = new Random().nextInt(100) + 1; // [0, 99] + 1 => [1, 100]
        random2 = new Random().nextInt(100) + 1; // [0, 99] + 1 => [1, 100]
        b1.setText(String.valueOf(random1));
        b2.setText(String.valueOf(random2));
    }

    public void Check(Button b1, Button b2) {
        if (Integer.parseInt(b1.getText().toString()) > Integer.parseInt(b2.getText().toString())) {

            Gen_Ran(btn1, btn2);
            total++;
            point.setText("Point "+(total));
        } else {

            Gen_Ran(btn1, btn2);
            total--;
            point.setText("Point "+total);
        }
    }

    public void Score() {
        if (total == 10) {
            point.setText("You Win");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
//            btnNew.setVisibility(View.VISIBLE);

        } else if (total == -10) {
            point.setText("You Lose");
            btn1.setEnabled(false);
            btn2.setEnabled(false);
//            btnNew.setVisibility(View.VISIBLE);
        }
    }
}

