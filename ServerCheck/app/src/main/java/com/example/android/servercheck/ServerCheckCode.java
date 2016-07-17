package com.example.android.servercheck;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Alexa on 7/16/2016.
 */
public class ServerCheckCode {

    //region to rate
    ArrayList<String> unParsed;
    HashMap<String, String> data;

    public ServerCheckCode() {
        data = new HashMap<String, String>();
        unParsed = new ArrayList<String>();
    }

    private class GetInfo extends AsyncTask<String, Void, Document> {
        @Override
        protected Document doInBackground(String... params) {
            Document doc = null;
            String url = "http://www.mmoserverstatus.com/pokemon_go";
            try {
                doc = Jsoup.connect(url).get();
            } catch (IOException e) {
                System.out.println("Exception thrown :" + e);
            }

            if (doc != null) {
                Element content = doc.addClass("counter");
                Elements links = content.getElementsByClass("white");
                for (Element link : links) {
                    unParsed.add(link.text());
                }
            }
            return null;
        }
    }

    public void loadInfo() {
        GetInfo info = new GetInfo();
        info.doInBackground();
    }


    public String output() {
        String data = "";
        for (String words : unParsed) {
            data += words + "\n";
        }
        return data;
    }
}
