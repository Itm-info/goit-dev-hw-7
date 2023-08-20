import itm.HttpStatusChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HttpStatusCheckerTest {
    @Test
    public void testThatGetStatusImageOn200WorksOk() throws Exception {
        String actual = HttpStatusChecker.getStatusImage(200);
        String expected = "https://http.cat/200.jpg";
        Assertions.assertEquals(expected, actual);
    }

    /*
    @Test
    public void testThatGetStatusImageOn205WorksOk() throws Exception {
        String actual = HttpStatusChecker.getStatusImage(205);
        String expected = "https://http.cat/205.jpg";
        Assertions.assertEquals(expected, actual);
    }
    */

    @Test
    public void testThatGetStatusImageOn404WorksOk() throws Exception {
        String actual = HttpStatusChecker.getStatusImage(404);
        String expected = "https://http.cat/404.jpg";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testThatGetStatusImageOn10000WorksOk() {
        Assertions.assertThrows(Exception.class, () -> HttpStatusChecker.getStatusImage(10000));
    }
}

