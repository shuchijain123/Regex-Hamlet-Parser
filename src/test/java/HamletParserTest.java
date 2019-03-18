import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;
    String expectedleon;



    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();



    }


    @Test
    public void testChangeHamletToLeon() {

       String expectedleon = hamletParser.ChangeStringInFile("Hamlet", "Leon");
       System.out.println(expectedleon);


        Assert.assertFalse(expectedleon.contains("Hamlet"));



    }

    @Test
    public void testChangeHoratioToTariq() {


        String expected = hamletParser.ChangeStringInFile("Horatio", "Tariq");
        System.out.println(expected);
        Assert.assertFalse(expected.contains("Horatio"));

    }

    @Test
    public void testFindHoratio() {

       String expectedstring= hamletParser.ChangeStringInFile("Horatio", "Tariq");
        Boolean actual = hamletParser.readStringInFile("Horatio");
        Boolean expected=true;
        System.out.println(expectedstring);

        Assert.assertEquals(expected,actual);



    }

    @Test
    public void testFindHamlet() {


        String expectedstring= hamletParser.ChangeStringInFile("Hamlet", "Leon");
        Boolean actual = hamletParser.readStringInFile("Hamlet");
        Boolean expected=true;
        System.out.println(expectedstring);

        Assert.assertEquals(expected,actual);

    }
    @Test
    public void testWriteOutput() {


        String leonfile = hamletParser.ChangeStringInFile("Hamlet", "Leon");
        hamletParser.getHamletData();
        hamletParser.writeToFile(leonfile);
        String Tariqfile = hamletParser.ChangeStringInFile("Horatio", "Tariq");
        hamletParser.writeToFile(Tariqfile);
        System.out.println(Tariqfile);




    }
}