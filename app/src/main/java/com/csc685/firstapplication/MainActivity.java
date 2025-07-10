package com.csc685.firstapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonAction();
    }
    private void buttonAction(){
        Button submitButton = findViewById(R.id.buttonSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editTextWeight);
                TextView textView = findViewById(R.id.textView);

                int luggageWeight = Integer.parseInt(editText.getText().toString());

                if (luggageWeight > 50){
                    String assessment = "Your luggage is " + luggageWeight + " lbs. It is overweight.";
                    textView.setText(assessment);
                } else {
                    String assessment = "Your luggage weight is " + luggageWeight + "lbs. It is the allowed limit.";
                    textView.setText(assessment);
                }

            }
        });
    }
}