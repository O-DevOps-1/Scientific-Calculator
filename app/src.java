package com.example.scientificcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText num1EditText, num2EditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1EditText = findViewById(R.id.num1EditText);
        num2EditText = findViewById(R.id.num2EditText);
        resultTextView = findViewById(R.id.resultTextView);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation('+');
            }
        });

        Button subtractButton = findViewById(R.id.subtractButton);
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation('-');
            }
        });

        Button multiplyButton = findViewById(R.id.multiplyButton);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation('*');
            }
        });

        Button divideButton = findViewById(R.id.divideButton);
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation('/');
            }
        });

        Button sqrtButton = findViewById(R.id.sqrtButton);
        sqrtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSquareRoot();
            }
        });

        Button sinButton = findViewById(R.id.sinButton);
        sinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSine();
            }
        });

        Button cosButton = findViewById(R.id.cosButton);
        cosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCosine();
            }
        });

        Button tanButton = findViewById(R.id.tanButton);
        tanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTangent();
            }
        });

        Button logButton = findViewById(R.id.logButton);
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateLogarithm();
            }
        });

        Button expButton = findViewById(R.id.expButton);
        expButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateExponential();
            }
        });
    }

    private void performCalculation(char operator) {
        String num1Str = num1EditText.getText().toString();
        String num2Str = num2EditText.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(num1Str);
        double num2 = Double.parseDouble(num2Str);

        double result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                } break;
        }

        DecimalFormat df = new DecimalFormat("#.00");
        resultTextView.setText(df.format(result));
    }

    private void calculateSquareRoot() {
        String numStr = num1EditText.getText().toString();

        if (numStr.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        double num = Double.parseDouble(numStr);

        if (num < 0) {
            Toast.makeText(this, "Cannot calculate square root of negative number", Toast.LENGTH_SHORT).show();
            return;
        }

        double result = Math.sqrt(num);


        DecimalFormat df = new DecimalFormat("#.00");
        resultTextView.setText(df.format(result)); }

    private void calculateSine() {
        String numStr = num1EditText.getText().toString();

        if (numStr.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        double num = Double.parseDouble(numStr);

        double result = Math.sin(num);

        DecimalFormat df = new DecimalFormat("#.00");
        resultTextView.setText(df.format(result));
    }

    private void calculateCosine() {
        String numStr = num1EditText.getText().toString();

        if (numStr.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        double num = Double.parseDouble(numStr);

        double result = Math.cos(num);

        DecimalFormat df = new DecimalFormat("#.00");
        resultTextView.setText(df.format(result));
    }

    private void calculateTangent() {
        String numStr = num1EditText.getText().toString();

        if (numStr.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        double num = Double.parseDouble(numStr);

        double result = Math.tan(num);

        DecimalFormat df = new DecimalFormat("#.00");
        resultTextView.setText(df.format(result));
    }

    private void calculateLogarithm() {
        String numStr = num1EditText.getText().toString();

        if (numStr.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        double num = Double.parseDouble(numStr);

        if (num <= 0) {
            Toast.makeText(this, "Cannot calculate logarithm of non-positive number", Toast.LENGTH_SHORT).show();
            return;
        }

        double result = Math.log(num);

        DecimalFormat df = new DecimalFormat("#.00");
        resultTextView.setText(df.format(result)); }

    private void calculateExponential() {
        String numStr = num1EditText.getText().toString();

        if (numStr.isEmpty()) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        double num = Double.parseDouble(numStr);

        double result = Math.exp(num);

        DecimalFormat df = new DecimalFormat("#.00");
        resultTextView.setText(df.format(result)); }}
