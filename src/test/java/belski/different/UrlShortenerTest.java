package belski.different;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class UrlShortenerTest {

    private final UrlShortener urlShortener = new UrlShortener();

    @Test
    public void shouldGetIdFromShortUrl() {
        final int actualId = urlShortener.shortURLtoID("hon3");
        assertEquals( 345233, actualId);
    }

    @Test
    public void shouldGetShortUrlFromId() {
        final String actualShortUrl = urlShortener.idToShortURL(345233);
        assertEquals("hon3", actualShortUrl);
    }
}
