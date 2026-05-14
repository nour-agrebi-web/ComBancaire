import banque.Customer;
import config.AccessSingleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import referenciel.CustomerRepository;
import banque.Customer;
public class test {
    public static void main(String[] args) {
        Customer c=new Customer("Mr Radhouane","Rades",3);

    }
}
