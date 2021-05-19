import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class hclTests {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeTest
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPrintIndividualNumbers1() {
        new PrintTenNumbers().printIndividualNumbers(1);
        Assert.assertTrue(outContent.toString().contains("1") , "Validation of print message failed.");
    }

    @Test
    public void testPrintIndividualNumbers2() {
        new PrintTenNumbers().printIndividualNumbers(2);
        Assert.assertTrue(outContent.toString().trim().contains("2"), "Validation of print message failed.");
    }

    @Test
    public void testPrintIndividualNumbers3() {
        new PrintTenNumbers().printIndividualNumbers(3);
        Assert.assertTrue(outContent.toString().trim().contains( "3"), "Validation of print message failed.");
    }

    @Test
    public void testPrintIndividualNumbers4() {
        new PrintTenNumbers().printIndividualNumbers(4);
        Assert.assertTrue(outContent.toString().trim().contains( "4"), "Validation of print message failed.");
    }

    @Test
    public void testPrintIndividualNumbers5() {
        new PrintTenNumbers().printIndividualNumbers(5);
        Assert.assertTrue(outContent.toString().trim().contains( "5"), "Validation of print message failed.");
    }

    @Test
    public void testPrintIndividualNumbers6() {
        new PrintTenNumbers().printIndividualNumbers(6);
        Assert.assertTrue(outContent.toString().contains("6") , "Validation of print message failed.");
    }

    @Test
    public void testPrintIndividualNumbers7() {
        new PrintTenNumbers().printIndividualNumbers(7);
        Assert.assertTrue(outContent.toString().trim().contains("7"), "Validation of print message failed.");
    }

    @Test
    public void testPrintIndividualNumbers8() {
        new PrintTenNumbers().printIndividualNumbers(8);
        Assert.assertTrue(outContent.toString().trim().contains( "8"), "Validation of print message failed.");
    }

    @Test
    public void testPrintIndividualNumbers9() {
        new PrintTenNumbers().printIndividualNumbers(9);
        Assert.assertTrue(outContent.toString().trim().contains( "9"), "Validation of print message failed.");
    }

    @Test
    public void testPrintIndividualNumbers10() {
        new PrintTenNumbers().printIndividualNumbers(10);
        Assert.assertTrue(outContent.toString().trim().contains( "10"), "Validation of print message failed.");
    }

    @Test
    public void testValidateAreaOfTriangleValidScenario() {
        Float hbValue = 10.0F;
        Float bValue = 15.0F;
        Float actualResult = new AreaOfTriangle().calcAreaOfTriangle(hbValue, bValue);
        Float expecteddResult = ((hbValue * bValue) / 2);
        Assert.assertEquals(expecteddResult, actualResult, "Expected:"+  expecteddResult +" and Actual:"+ actualResult +" values are not matching.");
    }

    @AfterTest
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
