import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraderTest {
    Grader grader;

    @BeforeEach
    void setUp() {
        grader = new Grader();
    }

    ////////////// Mark to test each grade //////////////
    //////////////       Three credit      //////////////
    @Test
    void oneSeventyNineForThreeCreditShouldReturnF() {
        char expected = 'F';
        char actual = grader.letterGrade("3", "179");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void oneEightyForThreeCreditShouldReturnC() {
        char expected = 'C';
        char actual = grader.letterGrade("3", "180");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void twoHundredNineForThreeCreditShouldReturnC() {
        char expected = 'C';
        char actual = grader.letterGrade("3", "209");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void twoHundredTenForThreeCreditShouldReturnB() {
        char expected = 'B';
        char actual = grader.letterGrade("3", "210");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void twoThirtyNineForThreeCreditShouldReturnB() {
        char expected = 'B';
        char actual = grader.letterGrade("3", "239");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void twoFortyForThreeCreditShouldReturnA() {
        char expected = 'A';
        char actual = grader.letterGrade("3", "240");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void fourHundredForThreeCreditShouldReturnA() {
        char expected = 'A';
        char actual = grader.letterGrade("3", "400");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    ////////////// Mark to test each grade //////////////
    //////////////       Four credit       //////////////
    @Test
    void twoThirtyNineForFourCreditShouldReturnF() {
        char expected = 'F';
        char actual = grader.letterGrade("4", "239");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void twoFortyForFourCreditShouldReturnC() {
        char expected = 'C';
        char actual = grader.letterGrade("4", "240");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void twoSeventyNineForFourCreditShouldReturnC() {
        char expected = 'C';
        char actual = grader.letterGrade("4", "279");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void twoEightyForFourCreditShouldReturnB() {
        char expected = 'B';
        char actual = grader.letterGrade("4", "280");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void threeNineteenForFourCreditShouldReturnB() {
        char expected = 'B';
        char actual = grader.letterGrade("4", "319");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void threeTwentyForFourCreditShouldReturnA() {
        char expected = 'A';
        char actual = grader.letterGrade("4", "320");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void fourHundredForFourCreditShouldReturnA() {
        char expected = 'A';
        char actual = grader.letterGrade("4", "400");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    ////////// Boundary values (fractional) for each grade //////////
    //////////////             Three credit            //////////////
    @Test
    void oneSeventyNinePointOneForThreeCreditShouldReturnC() {
        char expected = 'C';
        char actual = grader.letterGrade("3", "179.1");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void twoHundredNinePointOneForThreeCreditShouldReturnB() {
        char expected = 'B';
        char actual = grader.letterGrade("3", "209.1");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void twoThirtyNinePointOneForThreeCreditShouldReturnA() {
        char expected = 'A';
        char actual = grader.letterGrade("3", "239.1");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    ////////// Boundary values (fractional) for each grade //////////
    //////////////             Four credit             //////////////
    @Test
    void twoThirtyNinePointOneForFourCreditShouldReturnC() {
        char expected = 'C';
        char actual = grader.letterGrade("4", "239.1");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void twoSeventyNinePointOneForFourCreditShouldReturnB() {
        char expected = 'B';
        char actual = grader.letterGrade("4", "279.1");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    @Test
    void threeNineteenPointOneForFourCreditShouldReturnA() {
        char expected = 'A';
        char actual = grader.letterGrade("4", "319.1");

        assertEquals(expected, actual, "should have gotten " +
                expected + "\n" + " but instead got " + actual + "\n");

    }

    ////// Invalid numbers that exceed lower and upper bound //////
    //////////////              Credit               //////////////
    @Test
    void anyCreditOtherThanThreeOrFourShouldThrowIllegalArgumentException() {
        try {
            char grade = grader.letterGrade("1", "100");
            fail("should have gotten IllegalArgumentException\n" +
                    " but instead got " + grade + "\n");
        } catch (Exception e) {
            if(!(e instanceof IllegalArgumentException)) {
                fail("should have gotten IllegalArgumentException\n" +
                        " but instead got " + e + "\n");
            }
        }
    }

    ////// Invalid numbers that exceed lower and upper bound //////
    //////////////               Marks                /////////////
    @Test
    void negativeOneForThreeCreditShouldThrowIllegalArgumentException() {
        try {
            char grade = grader.letterGrade("3", "-1");
            fail("should have gotten IllegalArgumentException\n" +
                    " but instead got " + grade + "\n");
        } catch (Exception e) {
            if(!(e instanceof IllegalArgumentException)) {
                fail("should have gotten IllegalArgumentException\n" +
                        " but instead got " + e + "\n");
            }
        }
    }

    @Test
    void negativeOneForFourCreditShouldThrowIllegalArgumentException() {
        try {
            char grade = grader.letterGrade("4", "-1");
            fail("should have gotten IllegalArgumentException\n" +
                    " but instead got " + grade + "\n");
        } catch (Exception e) {
            if(!(e instanceof IllegalArgumentException)) {
                fail("should have gotten IllegalArgumentException\n" +
                        " but instead got " + e + "\n");
            }
        }
    }

    @Test
    void negativeFractionForThreeCreditShouldThrowIllegalArgumentException() {
        try {
            char grade = grader.letterGrade("3", "-0.5");
            fail("should have gotten IllegalArgumentException\n" +
                    " but instead got " + grade + "\n");
        } catch (Exception e) {
            if(!(e instanceof IllegalArgumentException)) {
                fail("should have gotten IllegalArgumentException\n" +
                        " but instead got " + e + "\n");
            }
        }
    }

    @Test
    void negativeFractionForFourCreditShouldThrowIllegalArgumentException() {
        try {
            char grade = grader.letterGrade("4", "-0.5");
            fail("should have gotten IllegalArgumentException\n" +
                    " but instead got " + grade + "\n");
        } catch (Exception e) {
            if(!(e instanceof IllegalArgumentException)) {
                fail("should have gotten IllegalArgumentException\n" +
                        " but instead got " + e + "\n");
            }
        }
    }

    @Test
    void greaterThanFourHundredForThreeCreditShouldThrowIllegalArgumentException() {
        try {
            char grade = grader.letterGrade("3", "401");
            fail("should have gotten IllegalArgumentException\n" +
                    " but instead got " + grade + "\n");
        } catch (Exception e) {
            if(!(e instanceof IllegalArgumentException)) {
                fail("should have gotten IllegalArgumentException\n" +
                        " but instead got " + e + "\n");
            }
        }
    }

    @Test
    void greaterThanFourHundredForFourCreditShouldThrowIllegalArgumentException() {
        try {
            char grade = grader.letterGrade("4", "401");
            fail("should have gotten IllegalArgumentException\n" +
                    " but instead got " + grade + "\n");
        } catch (Exception e) {
            if(!(e instanceof IllegalArgumentException)) {
                fail("should have gotten IllegalArgumentException\n" +
                        " but instead got " + e + "\n");
            }
        }
    }

    @Test
    void fractionGreaterThanFourHundredForThreeCreditShouldThrowIllegalArgumentException() {
        try {
            char grade = grader.letterGrade("3", "400.1");
            fail("should have gotten IllegalArgumentException\n" +
                    " but instead got " + grade + "\n");
        } catch (Exception e) {
            if(!(e instanceof IllegalArgumentException)) {
                fail("should have gotten IllegalArgumentException\n" +
                        " but instead got " + e + "\n");
            }
        }
    }

    @Test
    void fractionGreaterThanFourHundredForFourCreditShouldThrowIllegalArgumentException() {
        try {
            char grade = grader.letterGrade("4", "400.1");
            fail("should have gotten IllegalArgumentException\n" +
                    " but instead got " + grade + "\n");
        } catch (Exception e) {
            if(!(e instanceof IllegalArgumentException)) {
                fail("should have gotten IllegalArgumentException\n" +
                        " but instead got " + e + "\n");
            }
        }
    }

    ////////// Non-number input //////////
    @Test
    void nonNumberValueForCreditShouldThrowIllegalArgumentException() {
        try {
            char grade = grader.letterGrade("a", "400.1");
            fail("should have gotten IllegalArgumentException\n" +
                    " but instead got " + grade + "\n");
        } catch (Exception e) {
            if(!(e instanceof IllegalArgumentException)) {
                fail("should have gotten IllegalArgumentException\n" +
                        " but instead got " + e + "\n");
            }
        }
    }

    @Test
    void nonNumberValueForMarksShouldThrowIllegalArgumentException() {
        try {
            char grade = grader.letterGrade("3", "400.1a");
            fail("should have gotten IllegalArgumentException\n" +
                    " but instead got " + grade + "\n");
        } catch (Exception e) {
            if(!(e instanceof IllegalArgumentException)) {
                fail("should have gotten IllegalArgumentException\n" +
                        " but instead got " + e + "\n");
            }
        }
    }

    @AfterEach
    void tearDown() {
        grader = null;
    }
}