package itm;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HttpImageStatusCli {
    private static final Pattern num = Pattern.compile("^\\d{3}$");
    public static void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
        String command;
        do {
            command = scanner.nextLine();
            if ( ! num.matcher(command).matches() ) { System.out.println("Please enter valid number"); continue; }
            try {
                HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
                downloader.downloadStatusImage(Integer.parseInt(command));
                System.out.println(downloader.status == HttpURLConnection.HTTP_OK ? "OK" : "Download error, status " + downloader.status);
            }
            catch (IOException | IllegalArgumentException e) {
                System.out.println("There is no image for HTTP status " + command);
            }
        } while ( ! command.equals("exit") );
    }
}
