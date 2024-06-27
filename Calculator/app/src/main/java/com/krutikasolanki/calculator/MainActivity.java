package com.krutikasolanki.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    TextView resultView;
    StringBuilder result = new StringBuilder("");
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button id1 = findViewById(R.id.id1);
        Button id2 = findViewById(R.id.id2);
        Button id3 = findViewById(R.id.id3);
        Button id4 = findViewById(R.id.id4);
        Button id5 = findViewById(R.id.id5);
        Button id6 = findViewById(R.id.id6);
        Button id7 = findViewById(R.id.id7);
        Button id8 = findViewById(R.id.id8);
        Button id9 = findViewById(R.id.id9);
        Button id0 = findViewById(R.id.id0);
        Button id00 = findViewById(R.id.id00);
        Button idMin = findViewById(R.id.idMin);
        Button idPlus = findViewById(R.id.idPlus);
        Button idMul = findViewById(R.id.idMul);
        Button idDiv = findViewById(R.id.idDiv);
        Button idPerc = findViewById(R.id.idPerc);
        Button idEq = findViewById(R.id.idEq);
        Button idAC = findViewById(R.id.idAC);
        ImageButton idBack = findViewById(R.id.idBack);
        Button idDot = findViewById(R.id.idDot);
        resultView = findViewById(R.id.resultView);

        id1.setOnClickListener(onClickListener);
        id2.setOnClickListener(onClickListener);
        id3.setOnClickListener(onClickListener);
        id4.setOnClickListener(onClickListener);
        id5.setOnClickListener(onClickListener);
        id6.setOnClickListener(onClickListener);
        id7.setOnClickListener(onClickListener);
        id8.setOnClickListener(onClickListener);
        id9.setOnClickListener(onClickListener);
        id0.setOnClickListener(onClickListener);
        id00.setOnClickListener(onClickListener);
        idMin.setOnClickListener(onClickListener);
        idPlus.setOnClickListener(onClickListener);
        idMul.setOnClickListener(onClickListener);
        idDiv.setOnClickListener(onClickListener);
        idPerc.setOnClickListener(onClickListener);
        idEq.setOnClickListener(onClickListener);
        idAC.setOnClickListener(onClickListener);
        idBack.setOnClickListener(onClickListener);
        idDot.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.id1) {
                Button btn = findViewById(id);
                result.append(btn.getText());
                resultView.setText(result);
            } else if (id == R.id.id2) {
                result.append("2");
                resultView.setText(result);
            } else if (id == R.id.id3) {
                result.append("3");
                resultView.setText(result);
            } else if (id == R.id.id4) {
                result.append("4");
                resultView.setText(result);
            } else if (id == R.id.id5) {
                result.append("5");
                resultView.setText(result);
            } else if (id == R.id.id6) {
                result.append("6");
                resultView.setText(result);
            } else if (id == R.id.id7) {
                result.append("7");
                resultView.setText(result);
            } else if (id == R.id.id8) {
                result.append("8");
                resultView.setText(result);
            } else if (id == R.id.id9) {
                result.append("9");
                resultView.setText(result);
            } else if (id == R.id.id0) {
                result.append("0");
                resultView.setText(result);
            } else if (id == R.id.id00) {
                result.append("00");
                resultView.setText(result);
            } else if (id == R.id.idMul) {
                result.append("x");
                resultView.setText(result);
                operator = "x";
            } else if (id == R.id.idMin) {
                result.append("-");
                resultView.setText(result);
                operator = "-";
            } else if (id == R.id.idPlus) {
                result.append("+");
                resultView.setText(result);
                operator = "+";
            } else if (id == R.id.idDiv) {
                result.append("/");
                resultView.setText(result);
                operator = "/";
            } else if (id == R.id.idPerc) {
                result.append("%");
                resultView.setText(result);
                operator = "%";
            } else if (id == R.id.idDot) {
                result.append(".");
                resultView.setText(result);
            } else if (id == R.id.idAC) {
                result = new StringBuilder("");
                resultView.setText(result);
            } else if (id == R.id.idBack) {
                result = new StringBuilder(result.substring(0, result.length() - 1));
            } else if (id == R.id.idEq) {
                String str = result.toString();
                Log.d(TAG, "onClick: " + operator);
                double num1 = Double.parseDouble(result.substring(0, result.indexOf(operator.toString())));
                double num2 = Double.parseDouble(result.substring(result.indexOf(operator.toString()) + 1));
                Log.d(TAG, "num1: " + num1 + " num2: " + num2);

                double ans = 0;
                switch (operator) {
                    case "+":
                        ans = num1 + num2;
                        break;
                    case "-":
                        ans = num1 - num2;
                        break;
                    case "x":
                        ans = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            ans = num1 / num2;
                        } else {
                            ans = 0000.0;
                        }
                        break;
                    case "%":
                        ans = (num1 / num2) * 100;
                        break;
                }
                result = new StringBuilder("");
                result.append(String.valueOf(ans));
            }
            resultView.setText(result);
        }
    };
}