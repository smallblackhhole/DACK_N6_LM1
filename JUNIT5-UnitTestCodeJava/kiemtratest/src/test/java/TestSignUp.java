import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING
public class TestSignUp {
    @Test
    public void testIsSignUp() throws Exception{SignUp pv = new SignUp();
        boolean isStrong = pv.isSignUp("luu", "tuan","merole6441@kaftee.com","1234567");
        assertTrue(isStrong);
    }
    @Test
    public void testIsSignUpNotSuccess() throws Exception{
        SignUp pv = new SignUp();
        boolean isStrong = pv.isSignUp("","","","");
        assertFalse(isStrong);
    }
    @Test
    public void testIsPasswordStrong() throws Exception{
        SignUp pv = new SignUp();
        boolean isStrong = pv.isSignUp("luu","tuan","merole6441@kaftee.com","123465678");
        assertTrue(isStrong);
    }
    @Test
    public void testIsPasswordNotStrong() throws Exception{
        SignUp pv = new SignUp();
        boolean isWeak = pv.isSignUp("luu","tuan","merole6441@kaftee.com","1234");
        assertFalse(isWeak);
    }
    @Test
    public void testEmail() throws Exception{
        SignUp pv = new SignUp();
        boolean testmail = pv.TestMailValid("dlashdlad@gmail.com");
        assertTrue(testmail);
    }
    @Test
    public void testEmail2() throws Exception{
        SignUp pv = new SignUp();
        boolean testmail = pv.TestMailAlready("trungthinh1006200333@gmail.com");
        assertTrue(testmail);
    }
}
