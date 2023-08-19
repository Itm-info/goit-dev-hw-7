package itm;

import java.io.IOException;

public class HttpStatusImageDownloader {
    public int status;
    public void downloadStatusImage(int code) throws IOException {
        String urlString = HttpStatusChecker.getStatusImage(code);
        status = HttpWorks.httpDownloadFile(urlString, ".\\" + code + ".jpg");
    }
}
