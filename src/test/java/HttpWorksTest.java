import itm.HttpWorks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.UnknownHostException;

public class HttpWorksTest {
    @Test
    public void testThatHttpGetResponseCodeOnGoogleWorksOk() throws Exception {
        int actual = HttpWorks.httpGetResponseCode("https://google.com");
        int expected = 200;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatHttpGetResponseCodeOnGibberishSubPageWorksOk() throws Exception {
        int actual = HttpWorks.httpGetResponseCode("https://ukr.net/t7Khitbhdtjd5bd");
        int expected = 403;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatHttpGetResponseCodeOnHttpToHttpsRedirectWorksOk() throws Exception {
        int actual = HttpWorks.httpGetResponseCode("http://http.cat/999");
        int expected = 301;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatHttpGetResponseCodeOnUnexistentSiteWorksOk() {
        Assertions.assertThrows(UnknownHostException.class, () -> HttpWorks.httpGetResponseCode("https://vr7ijvg.cat/999"));
    }

    @Test
    public void testThatHttpGetResponseCodeOnGibberishWorksOk() {
        Assertions.assertThrows(MalformedURLException.class, () -> HttpWorks.httpGetResponseCode("cdslkcfghwei"));
    }

    @Test
    public void testThatHttpDownloadFileOnOkDataWorksOk() throws Exception {
        int actual = HttpWorks.httpDownloadFile("https://http.cat/418", ".\\200.jpg");
        int expected = 200;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatHttpDownloadFileOnBadDataWorksOk() {
        Assertions.assertThrows(Exception.class, () -> HttpWorks.httpDownloadFile("https://http.cat/418", "200:\\bhdthjf\\200.jpg"));
    }
}
