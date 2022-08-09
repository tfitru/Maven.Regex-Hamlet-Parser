import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() throws IOException {
        StringBuffer buffer = hamletParser.changeHamletToLeon();
        String s = buffer.toString();
        Pattern p = Pattern.compile("Leon", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(hamletParser.toString());

        if(s.contains("Hamlet") || s.contains("HAMLET")){
            assertTrue(m.find());
        } else {
            assertFalse(m.find());
        }

    }


    @Test
    public void testChangeHoratioToTariq() throws IOException {
        StringBuffer buffer = hamletParser.changeHoratioToTariq();
        String s = buffer.toString();
        Pattern p = Pattern.compile("Tariq", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(hamletParser.toString());

        if(s.contains("Horatio") || s.contains("HORATIO")){
            assertTrue(m.find());
        } else {
            assertFalse(m.find());
        }

    }

    @Test
    public void testFindHoratio() throws IOException {
        assertTrue(hamletParser.findHoratio().find());
    }

    @Test
    public void testFindHamlet() throws IOException {
        assertTrue(hamletParser.findHamlet().find());
    }
}