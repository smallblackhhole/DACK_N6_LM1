import java.util.regex.Pattern;

public class SignUp {
    String email = "username@domain.com";
    String regexPattent = "^(.+)@(\\S+)$";
    String email1 = "trungthinh1006200333@gmail.com";

    public boolean isSignUp (String Ho, String Ten, String email, String password) throws Exception
    {
        if (Ho.isEmpty() || Ten.isEmpty() || password.isEmpty() || email.isEmpty()){
            return false;
        } if (password.length() >10 || password.length()<5 || Ho.length() >10 || Ho.length()<2 || Ten.length() >10 || Ten.length()<2  )
        {
            return false;
        }


        else return true;
    }
    public boolean TestMailValid(String email) throws Exception{

        return Pattern.compile(regexPattent).matcher(email).matches();
    }
    public boolean TestMailAlready(String email){
        if (email != email1) {
            return false;
        }
        return true;
    }

}
