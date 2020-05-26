package edu.depaul.unit;

import edu.depaul.email.EmailFinderException;
import edu.depaul.email.PageFetcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.jsoup.nodes.Document;

import static org.junit.jupiter.api.Assertions.*;

class PageFetcherTest {

    @Test
    @DisplayName("Tests constructor")
    void testPageFetcherConstructor() {
        PageFetcher pf = new PageFetcher();
        assertNotNull(pf);
    }

    @Test
    @DisplayName("Test getString method with good link")
    void testGetString() {
        String url = "http://cdm.depaul.edu/";
        PageFetcher pf = new PageFetcher();

        assertNotNull(pf.getString(url));

    }


    @Test
    @DisplayName("Test getString method with invalid link")
    void testInvalidGetString() {
        String badUrl = "htp://cdm.depaul.edu";
        PageFetcher pf = new PageFetcher();
        assertThrows(EmailFinderException.class, () -> {pf.getString(badUrl);});

    }

    @Test
    @DisplayName("Test getString method with broken link")
    void testBrokenGetString() {
        String badUrl = "http://cdm.depaul.edu/brokenlink/";
        PageFetcher pf = new PageFetcher();
        assertThrows(EmailFinderException.class, () -> {pf.getString(badUrl);});

    }

    @Test
    @DisplayName("Test get method with web link")
    void testGetWeb() {
        String url = "http://cdm.depaul.edu/";
        PageFetcher pf = new PageFetcher();
        Document d = pf.get(url);
        assertNotNull(d);
    }

    @Test
    @DisplayName("Test get method with file link")
    void testGetFile() {
        String path = System.getProperty("user.dir") + "/src/test/resources/localPathTest1.html";
        PageFetcher pf = new PageFetcher();
        Document d = pf.get(path);
        assertNotNull(d);
    }

    @Test
    @DisplayName("Test get method with bad link")
    void testGetBad() {
        String badUrl = "http://cdm.depaul.edu/brokenlink/";
        PageFetcher pf = new PageFetcher();
        assertThrows(EmailFinderException.class, () -> {pf.get(badUrl);});
    }
}

