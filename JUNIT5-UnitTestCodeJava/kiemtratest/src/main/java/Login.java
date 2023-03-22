public class Login {
    public boolean isLogin (String password, String email) throws Exception
    {
        if (password.isEmpty() || email.isEmpty()){
            return false;
        }
        else return true;
    }
}
