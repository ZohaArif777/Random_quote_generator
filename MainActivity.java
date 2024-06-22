package com.example.randomquotegenerator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] quotes;
    private TextView quoteTextView;
    private Button generateButton;
    private Button shareButton;
    private Random random;
    private String currentQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quotes = getResources().getStringArray(R.array.Quotes);

        quoteTextView = findViewById(R.id.quoteTextView);
        generateButton = findViewById(R.id.generateButton);
        shareButton = findViewById(R.id.shareButton);
        random = new Random();

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomQuote();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareQuote();
            }
        });
    }

    private void generateRandomQuote() {
        int index = random.nextInt(quotes.length);
        currentQuote = quotes[index];
        quoteTextView.setText(currentQuote);
    }

    private void shareQuote() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, currentQuote);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}