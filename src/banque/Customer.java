package banque;

public class Customer {
    public String nom;
    public String adresse;
    private int nombre_de_carte;
    public Customer(String nom, String adresse, int nombre_de_carte){
        this.nom = nom;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public int getNombre_de_carte() {
        return nombre_de_carte;
    }
    public void setNombre_de_carte(int nombre_de_carte) {
        this.nombre_de_carte = nombre_de_carte;
    }

    @Override
    public String toString() {

        if (nom.equals(this.nom)){
            return null;
        }

        return nom + " " + adresse + " " + nombre_de_carte;



}}
