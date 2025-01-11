//package model.utils.login;
//
//import data.UserDAO;
//import models.User;
//import model.utils.ErrorHandler;
//import java.sql.SQLException;
//
//public class Login {
//    private static final UserDAO USER_DAO = UserDAO.getInstance();
//    public static Login instance = null;
//    public User user;
//
//    public Login() {
//        instance = this;
//    }
//
//    public static Login getInstance() {
//        if (instance == null) {
//            instance = new Login();
//        }
//        return instance;
//    }
//    public boolean signIn(String username, String password) {
//        try {
//            boolean valid = USER_DAO.authUser(username, password);
//
//            if (valid) {
//                this.user = USER_DAO.fetchUser(username);
//                return true; // Successfully signed in
//            }
//        } catch (Exception e) {
//            ErrorHandler.handle(e, "An error occurred during sign-in");
//        }
//
//        return false; // Sign-in failed
//    }
//
//    public boolean signUp(String username, String email, String fullname, String password) {
//        User user = new User(username, fullname, email,password);
//        try {
//            if (!USER_DAO.addUser(user))
//                return false;
//            this.user = USER_DAO.fetchUser(username);
//        } catch (SQLException e) {
//            // Handle or log the exception here
//            ErrorHandler.handle(e, "An error occurred while fetching user information.");
//            return false;
//        }
//
//        return true;
//    }
//
//    public void logout() {
//        this.user = null;
//    }
//
//    public User getUser() {
//        return user;
//    }
//}
