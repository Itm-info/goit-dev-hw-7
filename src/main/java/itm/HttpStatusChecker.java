package itm;

import java.io.IOException;

public class HttpStatusChecker {
    public static String getStatusImage(int code) throws IOException {
        String url = "https://http.cat/" + code;
        int responseCode = HttpWorks.httpGetResponseCode(url);
        if( responseCode != 404 ) return url + ".jpg";
        else throw new IllegalArgumentException();
    }
}
