package referenciel;
import banque.Customer;
import java.sql.*;
import java.util.*;
import config.AccessSingleton;
import banque.Customer;
import static config.AccessSingleton.theAccess;

public class CustomerRepository {
    AccessSingleton access = new AccessSingleton();
    public Customer findByName(String name) {
        AccessSingleton theAccess;
        Connection con = access.connecter();
        String requete = "SELECT * FROM `customer` WHERE `nom`=?";
        try {
            PreparedStatement ps = con.prepareStatement(requete);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                String nom = rs.getString(1);
                String adresse = rs.getString(2);
                int nombre_de_carte = rs.getInt(3);
                Customer customer = new Customer(nom ,adresse,nombre_de_carte);
                return customer;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public TreeSet<Customer> findAll() {
        TreeSet<Customer> ts = new TreeSet<>();
        Connection conn = access.connecter();
        String requete = "SELECT * FROM `customer`";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(requete);
            while(rs.next()) {
                String nom = rs.getString("nom");
                String adresse = rs.getString("adresse");
                int nombre_de_carte = rs.getInt(3);
                Customer customer = new Customer(nom,adresse, nombre_de_carte);
                ts.add(customer);
            }
            return ts;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ts;
    }}

