package edu.depaul.unit;

import edu.depaul.email.StorageService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StorageServiceTest {

    @Test
    @DisplayName("Tests constructor")
    void testStorageServiceConstructor() {
        StorageService s = new StorageService();
        assertNotNull(s);
    }


}
