import com.example.main.CashDrawer;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CashDrawerTest {

    private static final int TEST_ID = 1;
    private static final int TEST_TWENTY = 0;
    private static final int TEST_TEN = 0;
    private static final int TEST_FIVE = 0;
    private static final int TEST_TWO = 0;
    private static final int TEST_ONE = 0;

    @Test
    public void gettersAndSettersTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CashDrawer cashDrawer = new CashDrawer();

        // CashDrawer setters
        Method setTwentyMethod = CashDrawer.class.getMethod("setTwenty", int.class);
        setTwentyMethod.invoke(cashDrawer, TEST_TWENTY);

        Method setTenMethod = CashDrawer.class.getMethod("setTen", int.class);
        setTenMethod.invoke(cashDrawer, TEST_TEN);

        Method setFiveMethod = CashDrawer.class.getMethod("setFive", int.class);
        setFiveMethod.invoke(cashDrawer, TEST_FIVE);

        Method setTwoMethod = CashDrawer.class.getMethod("setTwo", int.class);
        setTwoMethod.invoke(cashDrawer, TEST_TWO);

        Method setOneMethod = CashDrawer.class.getMethod("setOne", int.class);
        setOneMethod.invoke(cashDrawer, TEST_ONE);

        // testing getters
        Method getTwentyMethod = CashDrawer.class.getMethod("getTwenty");
        int twentyValue = (int) getTwentyMethod.invoke(cashDrawer);
        assertEquals(TEST_TWENTY, twentyValue, "Can set/get twenty");

        Method getTenMethod = CashDrawer.class.getMethod("getTen");
        int tenValue = (int) getTenMethod.invoke(cashDrawer);
        assertEquals(TEST_TEN, tenValue, "Can set/get ten");

        Method getFiveMethod = CashDrawer.class.getMethod("getFive");
        int fiveValue = (int) getFiveMethod.invoke(cashDrawer);
        assertEquals(TEST_FIVE, fiveValue, "Can set/get five");

        Method getTwoMethod = CashDrawer.class.getMethod("getTwo");
        int twoValue = (int) getTwoMethod.invoke(cashDrawer);
        assertEquals(TEST_TWO, twoValue, "Can set/get two");

        Method getOneMethod = CashDrawer.class.getMethod("getOne");
        int oneValue = (int) getOneMethod.invoke(cashDrawer);
        assertEquals(TEST_ONE, oneValue, "Can set/get one");


        // testing toString()
        Method toStringMethod = CashDrawer.class.getMethod("toString");
        String stringValue = (String) toStringMethod.invoke(cashDrawer);
        assertTrue(stringValue.contains("$0 0 0 0 0 0"));
        assertTrue(stringValue.contains(String.valueOf(TEST_TWENTY)));
        assertTrue(stringValue.contains(String.valueOf(TEST_TEN)));
        assertTrue(stringValue.contains(String.valueOf(TEST_FIVE)));
        assertTrue(stringValue.contains(String.valueOf(TEST_TWO)));
        assertTrue(stringValue.contains(String.valueOf(TEST_ONE)));

    }

    
}


