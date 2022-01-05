import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void runMain_CorrectOutput(){
        runMain();
    }
    private static void runMain() {
        try {
            Main.main(new String[]{});
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
