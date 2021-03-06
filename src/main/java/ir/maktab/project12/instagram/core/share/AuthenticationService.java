package ir.maktab.project12.instagram.core.share;


import ir.maktab.project12.instagram.model.User;

public class AuthenticationService {
    private User loginUser;
    private static AuthenticationService authenticationService = null;

    public static AuthenticationService getInstance() {
        if (authenticationService == null)
            return authenticationService = new AuthenticationService();
        else
            return authenticationService;
    }

    private AuthenticationService() { }

    public void setLoginUser(User user) {
        this.loginUser = user;
    }

    public User getLoginUser() {
        return loginUser;
    }

}
