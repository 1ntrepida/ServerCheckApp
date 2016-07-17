package com.example.android.servercheck;

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

    public void loadInfo() {

    }

    public void getInfo() {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.mmoserverstatus.com/pokemon_go").get();
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
    }

    public String output() {
        String data = "";
        for (String words : unParsed) {
            data += data + "\n";
        }
        return data;
    }
}
