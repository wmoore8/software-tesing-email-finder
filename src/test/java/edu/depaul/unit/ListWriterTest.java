package edu.depaul.unit;

import edu.depaul.email.ListWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

class ListWriterTest {

    @Test
    @DisplayName("Tests constructor")
    void testListWriterConstructor() {
        OutputStream os = mock(OutputStream.class);
        ListWriter l = new ListWriter(os);
        assertNotNull(l);
    }

    @Test
    @DisplayName("Tests strings being added are actually being added and formatted correctly.")
    void testListWriterInput() {
        String s1 = "a", s2 = "b", s3 = "c";

        //"\n" at the end is necessary for test to pass as writeLine is written to add an empty line at the end
        String expected = "a"+"\n"
                            +"b"+"\n"
                            +"c"+"\n";

        ArrayList<String> temp = new ArrayList<>();
        temp.add(s1);
        temp.add(s2);
        temp.add(s3);

        OutputStream os = new ByteArrayOutputStream();
        ListWriter l = new ListWriter(os);

        try {
            l.writeList(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(expected, os.toString());
    }

}
