package com.example.oakridge;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView quote_text = findViewById(R.id.text_quote);

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                com.example.quotes2.Quote quote = com.example.quotes2.JsonReader.convertJSONToObject(QuoteActivity.this);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        quote_text.setText(quote.getQuote());
                    }
                });
            }
        });
    }
}