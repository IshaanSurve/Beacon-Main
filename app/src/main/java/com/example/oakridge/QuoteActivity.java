package com.example.oakridge;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.example.oakridge.Quote;

public class QuoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quotes_page);

        TextView quote_text = findViewById(R.id.text_quote);

        ExecutorService executorService = Executors.newSingleThreadExecutor();

       // executorService.execute(new Runnable() {
           // @Override
           // public void run() {
                //Quote quote = JsonReader.convertJSONToObject(QuoteActivity.this);

                //runOnUiThread(new Runnable() {
                   // @Override
                    //public void run() {
                        //quote_text.setText(quote.getQuote());
                    //}
               // });
           // }
     //   });
    }
}