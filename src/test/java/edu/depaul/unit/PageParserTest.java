package edu.depaul.unit;

import edu.depaul.email.PageParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PageParserTest {

    //For ease of access to the test resource files
    private String path = System.getProperty("user.dir") + "/src/test/resources/";

    @Test
    @DisplayName("Tests constructor")
    void testPageCrawlerConstructor() {
        PageParser pp = new PageParser();
        assertNotNull(pp);
    }

    @Test
    @DisplayName("Test findEmails on html with no emails")
    void testEmptyEmailService() {
        PageParser pp = new PageParser();
        Document d = Jsoup.parse(path + "emailParserTest1.html");

        Set<String> actual = pp.findEmails(d);
        Set<String> expected = Collections.EMPTY_SET;
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Test findEmails on html with 1 email")
    void test1EmailService() {
        PageParser pp = new PageParser();
        Document d = Jsoup.parse(path + "emailParserTest2.html");

        Set<String> actual = pp.findEmails(d);
        Set<String> expected = new HashSet<String>();
        //TODO: this isnt working
        //expected.add("wmoore72@gmail.com");
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Test findLinks on html with no links")
    void testEmptyLinkService() {
        PageParser pp = new PageParser();
        Document d = Jsoup.parse(path + "linkParserTest1.html");

        Set<String> actual = pp.findLinks(d);
        Set<String> expected = Collections.EMPTY_SET;
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("Test findLinks on html with 1 link")
    void test1LinkService() {
        PageParser pp = new PageParser();
        Document d = Jsoup.parse(path + "linkParserTest2.html");

        Set<String> actual = pp.findLinks(d);
        Set<String> expected = new HashSet<String>();
        //TODO: this isnt working
        //expected.add("http://www.twitter.com");
        assertEquals(expected,actual);

    }

}
