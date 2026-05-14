package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccessSingleton {
    public static String user;
    public static String pass;
    private static Connection con;
    public static AccessSingleton theAccess;
    public AccessSingleton() {
        this.user = user;
        this.pass = pass;
        Connection con = null;
    }
    public static Connection connecter() {
        if (con == null || theAccess == null) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
        } catch (ClassNotFoundException e) {
            System.out.println("driver not charge");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }}
        return con;
    }
    public Connection getCon() {
        return con;
    }
    public void setCon(Connection con) {
        this.con = con;
    }
    public AccessSingleton getTheAccess() {
        return theAccess;
    }
    public void setTheAccess(AccessSingleton theAccess) {
        this.theAccess = theAccess;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}
