package Model;

import OpenWheaterMap.Example;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.TimeZone;

public class tempAndTimezone {
    String city;
    String temperature;
    int timezoneOffset;
    Example test;

    public tempAndTimezone(String city) {
        this.city = city;
    }

    public String getTemperature() throws IOException {
        Example a = null;
        a = new Example();
        a = connectionToOpenWheater();

        temperature = a.getList().get(0).getMain().getTemp().toString();

        return temperature;
    }

    public int getTimezoneOffsetInSeconds() throws IOException {
        Example a = null;
        a = new Example();
        a = connectionToOpenWheater();

        TimeZone tz = TimeZone.getDefault();

        timezoneOffset = a.getCity().getTimezone();

        return timezoneOffset;
    }

    private Example connectionToOpenWheater() throws IOException {
        URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?q=" + city + ",at&appid=d134cb284ef6ebbab66ea57a6b83f4f8");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        Scanner s = new Scanner(con.getInputStream());

        StringBuilder sb = new StringBuilder();
        while (s.hasNextLine()) {
            sb.append(s.nextLine());
        }

        Gson gson = new Gson();
        test  = gson.fromJson(sb.toString(), Example.class);
        return test;
    }





}
