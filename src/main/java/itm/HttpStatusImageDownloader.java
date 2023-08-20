package itm;

public class HttpStatusImageDownloader {
    public int status;
    public void downloadStatusImage(int code) throws Exception {
        String urlString = HttpStatusChecker.getStatusImage(code);
        status = HttpWorks.httpDownloadFile(urlString, ".\\" + code + ".jpg");
    }
}
