package com.example.suite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText n1;
    TextView n2;
    TextView n3;
    EditText n4;
    EditText n5;
    EditText n6;
    Button b1,b2;
    String a;
    int i = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);
        n6 = findViewById(R.id.n6);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);

        b1.setOnClickListener(view -> {
            String phoneNumber = n2.getText().toString();

            if (isOoredoo(phoneNumber)) {
                n2.setText("Votre numéro est Ooredoo");
                n3.setText("Veuillez saisir le code (14 chiffres)");
                n2.setTextColor(getResources().getColor(R.color.black));
                n6.setTextColor(getResources().getColor(R.color.black));
                n5.setTextColor(getResources().getColor(R.color.black));
                a = "0";
            } else if (isOrange(phoneNumber)) {
                n2.setText("Votre numéro est Orange");
                n3.setText("Veuillez saisir le code (14 chiffres)");
                n2.setTextColor(getResources().getColor(R.color.white));
                n6.setTextColor(getResources().getColor(R.color.white));
                n5.setTextColor(getResources().getColor(R.color.white));
                a = "1";
            } else if (isTelecom(phoneNumber)) {
                n2.setText("Votre numéro est Telecom");
                n3.setText("Veuillez saisir le code");
                n2.setTextColor(getResources().getColor(R.color.purple_200));
                n6.setTextColor(getResources().getColor(R.color.purple_200));
                n5.setTextColor(getResources().getColor(R.color.purple_200));
                a = "2";
            } else {
                n2.setText("Veuillez réessayer");
                n3.setText("Réessayez");
                a = "";
            }
        });

        b2.setOnClickListener(view -> {
            String code = n5.getText().toString();

            if (a.equals("0")) {
                if (code.equals("*111#")) {
                    i += 5;
                    showResult(i);
                } else {
                    showError();
                }
            } else if (a.equals("1")) {
                if (code.equals("*100#")) {
                    i += 5;
                    showResult(i);
                } else {
                    showError();
                }
            } else if (a.equals("2")) {
                if (code.equals("*123#")) {
                    i += 5;
                    showResult(i);
                } else {
                    showError();
                }
            }
        });
    }

    private static boolean isOoredoo(String phoneNumber) {
        String ooredooPrefix = "9745";
        return phoneNumber.startsWith(ooredooPrefix);
    }

    private static boolean isOrange(String phoneNumber) {
        String orangePrefix = "9746";
        return phoneNumber.startsWith(orangePrefix);
    }

    private static boolean isTelecom(String phoneNumber) {
        String telecomPrefix = "9747";
        return phoneNumber.startsWith(telecomPrefix);
    }

    private void showResult(int i) {
        // Show the result on screen
        n6.setText(String.valueOf(i));
    }

    private void showError() {
        // Show an error message on screen
        n6.setText("Erreur");
    }
}