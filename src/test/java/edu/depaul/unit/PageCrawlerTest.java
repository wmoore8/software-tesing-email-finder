package edu.depaul.unit;

import edu.depaul.email.PageCrawler;
import edu.depaul.email.StorageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PageCrawlerTest {

    @Test
    @DisplayName("Tests constructor")
    void testPageCrawlerConstructor() {
        StorageService s = new StorageService();
        PageCrawler pc = new PageCrawler(s);
        assertNotNull(pc);
    }

}
