import com.example.demo.Main;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = Main.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainTest {

//    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;
//
//    @BeforeAll
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//    }
//
//    @AfterAll
//    public void restoreStreams() {
//        System.setOut(originalOut);
//    }
//
//    @BeforeEach
//    public void setTestInput() {
//        outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//    }
//
//    @Test
//    public void runMain_CorrectOutput(){
//        runMain();
//
//        String output = outContent.toString();
//
//        // Test the "ready" print is contained in the byteOutputStream
//        assertThat(output, containsString("ready"));
//
//    }
//    private static void runMain() {
//        try {
//            com.example.demo.Main.main(new String[]{});
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
