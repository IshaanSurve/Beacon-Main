package com.example.oakridge;

import android.content.Context;

import com.example.oakridge.R;
import com.google.common.reflect.TypeToken;
import com.google.gson.*;

import java.io.IOException;
import java.io.InputStream;

public class JsonReader {

    public static com.example.quotes2.Quote convertJSONToObject(Context context) {
        InputStream inputStream = context.getResources().openRawResource(R.raw.quotes);

        String jsonString = "";
        try {
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();

            jsonString = new String(data, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Gson().fromJson(jsonString, new TypeToken<com.example.quotes2.Quote>(){}.getType());
    }

}
