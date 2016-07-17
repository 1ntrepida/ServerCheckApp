package com.example.android.servercheck;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
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
    }

    public void loadInfo() {

    }

    public void getInfo() {
        Document doc = null;
        File input = new File("/tmp/input.html");
        try {
            doc = Jsoup.parse(input, "UTF-8", "http://www.mmoserverstatus.com/pokemon_go");
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


}
