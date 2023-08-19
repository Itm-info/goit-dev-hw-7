package itm;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpWorks {
    public static int httpGetResponseCode(String url, String method) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod(method);
        return connection.getResponseCode();
    }

    public static int httpDownloadFile(String url, String path) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if( responseCode == HttpURLConnection.HTTP_OK ) {
            connection.getInputStream().transferTo(new FileOutputStream(path));
        }
        return responseCode;
    }
}
