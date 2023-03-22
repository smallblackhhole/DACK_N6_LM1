
import org.junit.Test;
import static org.junit.Assert.*;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING
public class TestLogin {
    @Test
    public void testIsLogin() throws Exception{Login pv = new Login();
        boolean isStrong = pv.isLogin("1234567", "merole6441@kaftee.com");
        assertTrue(isStrong);
    }
    @Test
public void testIsPasswordNotStrong() throws Exception{
        Login pv = new Login();
        boolean isStrong = pv.isLogin("","");
        assertFalse(isStrong);
    }

}