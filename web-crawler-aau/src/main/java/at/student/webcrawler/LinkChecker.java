package at.aau.student.webcrawler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class LinkChecker {

    public boolean isBrokenLink(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return responseCode >= 400;
        } catch (IOException e) {
            return true; // Bei einem Fehler wird der Link als defekt betrachtet
        }
    }
}