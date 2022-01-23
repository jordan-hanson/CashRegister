import com.example.main.CashDrawer;
import com.example.main.Main;
import com.example.main.exceptions.CustomEmptyStringException;
import com.example.main.exceptions.InsufficientAmountException;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Main.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeAll
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @BeforeEach
    public void setTestInput() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void runMain_CorrectOutput(){
        runMain();

        String output = outContent.toString();

        // Test the "ready" print is contained in the byteOutputStream
        assertThat(output, containsString("ready"));
//        assertThat(output, containsString("*******Welcome to the CashRegister!*******"));
//        assertThat(output, containsString("Enter a number option 1 or 2"));
    }
    private static void runMain() {
        try {
            Main.main(new String[]{});
        } catch (Exception | InsufficientAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testIsValid_ValidInput(){
        int inputNumber = 2;
        assertTrue(Main.isValid(inputNumber));
    }

    @Test
    public void testIsValid_InvalidInput(){
        int inputNumber = 24;
        assertThrows(IllegalArgumentException.class, () -> {
            Main.isValid(inputNumber);
        });
    }

    @Test
    public void testIsValidHigherRange_ValidInput(){
        int inputNumber = 4;
        assertTrue(Main.isValidHigherRange(inputNumber));
    }

    @Test
    public void testIsValidHigherRange_InvalidInput(){
        int inputNumber = 24;
        assertThrows(IllegalArgumentException.class, () -> {
            Main.isValid(inputNumber);
        });
    }

    @Test
    public void testCustomException(){
        String input = "";
        assertThrows(CustomEmptyStringException.class, ()-> {
            Main.checkForEmptyString(input);
        });
    }

    @Test
    public void testProcessInput_ValidInput(){
        String input = "2";
        assertEquals(2, Main.processInput(input));
    }

    @Test
    public void testProcessInput_InvalidInputLetter(){
        String input = "a";
        assertThrows(NumberFormatException.class, () -> {
            Main.processInput(input);
        });
    }

    @Test
    public void testProcessInput_InvalidInputRange(){
        String input = "3";
        assertThrows(NumberFormatException.class, () -> {
            Main.processInput(input);
        });
    }

    @Test
    public void testVerifyNoNegativeNumbers_ValidInput(){
        int input = 1;
        assertTrue(Main.verifyNoNegativeNumbers(input));
    }

    @Test
    public void testVerifyNoNegativeNumbers_InalidInput(){
        int input = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            Main.verifyNoNegativeNumbers(input);
        });
    }


}
