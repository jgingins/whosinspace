import com.squareup.okhttp.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {
    private MockWebServer mockWebServer = new MockWebServer();
    private HttpClient client;
    // private httpClient emptyClient;
    // private static String JSON_FILE;

    //I was going to read test jsons from the file but it was taking too long
//    static {
//        try {
//            JSON_FILE = new String(requireNonNull(test.class
//                    .getClassLoader()
//                    .getResourceAsStream("test.json"))
//                    .readAllBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    @Before
    public void init() {
        //this.mockWebServer = new MockWebServer();
        //this.emptyClient = new httpClient("/");
        this.client = new HttpClient("http://api.open-notify.org/astros.json");
    }

    @Test
    public void shoulddReturnFirstPersonsName() {
        String result = client.getAstronauts().getPersonsName(0);
        assertEquals("Mark Vande Hei", result);

    }

    @Test
    public void shouldReturnFirstPersonsCraft() {
        String result = client.getAstronauts().getPersonsCraft(0);
        assertEquals("ISS", result);

    }
    @Test
    public void shouldReturnNumber10() {
        int result = client.getAstronauts().getNumber();
        assertEquals(10, result);
    }

    //ran out of time
//    @Test
//    public void shouldReturnDefaultWhenNull() {
//        mockWebServer.enqueue(new MockResponse()
//                .addHeader("Content-Type", "application/json; charset=utf-8")
//                .setResponseCode(500));
//    }


}