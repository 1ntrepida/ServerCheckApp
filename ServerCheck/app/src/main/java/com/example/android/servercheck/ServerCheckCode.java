package com.example.android.servercheck;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//trying to import jsoup and it's not working
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
                Elements locations = content.getElementsByClass("white");
                Elements speeds = content.getElementsByClass("fa fa-check green");
                for (Element link : locations) {
                    unParsed.add(link.text() +" "+ speeds.text());
                }
            }
            return null;
        }
    }

    public void loadInfo() {
        GetInfo info = new GetInfo();
        info.doInBackground();
    }

    //should take in the location and speed
    //output new textfield
    public String output(String location, String time) {
        String data = "";
        data += "Region: " + location + "\n";
        data += "Response Time : " + location + "\n";
        int speed = Integer.parseInt(time.substring(0,3));
        if(speed >= 80) {
            data += "Servers are running perfectly fine!";
        }
        else {
            data += "Servers are down.";
        }
        return data;
    }
}
