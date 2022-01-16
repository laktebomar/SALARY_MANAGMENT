import java.util.*;

public class Salaire {
    public static void main(String args[]){

        Personnel p = new Personnel();
        p.ajouterEmploye(new Vendeur("LAKTEB", "Omar", "12/03/2020", 18, 1000));
        p.afficherSalaire();
    } 


}

abstract class  Employe  {
    private String nom, prenom, date_entre;
    private int age;


    public Employe(String nom, String prenom, String date_entre, int age){
        this.nom =  nom; this.prenom= prenom; this.date_entre = date_entre; this.age=age;
    }

    public abstract double calculSalaire();
    public abstract String getTitre();
    public String getNom(){
        return getTitre() + nom+", "+ prenom;
    }
}

abstract class Commercial extends Employe{
    private double chaiffreAff;
    public Commercial(String nom, String prenom, String date_entre, int age, double chaiffreAff) {
        super(nom, prenom, date_entre, age);
        this.chaiffreAff =chaiffreAff;
    }

    public double getChaiffre(){
        return chaiffreAff;
    }
}

class Vendeur extends Commercial{
    private final int bonus=200;
    public Vendeur(String nom, String prenom, String date_entre, int age, double chaiffreAff) {
        super(nom, prenom, date_entre, age, chaiffreAff);
    }

    public double calculSalaire(){
        return bonus + (getChaiffre()*0.2);
    }

    public String getTitre(){
        return "Vendeur ";
    }
}


class Represantant extends Commercial{
    public Represantant(String nom, String prenom, String date_entre, int age, double chaiffreAff) {
        super(nom, prenom, date_entre, age, chaiffreAff);
        
    }

   
    public double calculSalaire(){
        return bonus + (getChaiffre()*0.2);
    }

    public String getTitre(){
        return "Representant ";
    }
    private final int bonus=800;
}


class Production extends Employe{
    private int nbr_unite;
    public Production(String nom, String prenom, String date_entre, int age, int nbr_unite) {
        super(nom, prenom, date_entre, age);
        this.nbr_unite = nbr_unite;
        
    }

   
    public double calculSalaire(){
        return nbr_unite*5;
    }

    public String getTitre(){
        return "Production ";
    }
}


class Manu extends Employe{
    private int nbr_heure;
    public Manu(String nom, String prenom, String date_entre, int age, int nbr_heure) {
        super(nom, prenom, date_entre, age);
        this.nbr_heure = nbr_heure;
        
    }

   
    public double calculSalaire(){
        return nbr_heure*65;
    }

    public String getTitre(){
        return "Manu ";
    }
}

class ProdArisque extends Production implements Arisque{

    public ProdArisque(String nom, String prenom, String date_entre, int age, int nbr_unite) {
        super(nom, prenom, date_entre, age, nbr_unite);
    }

    public double calculSalaire(){
        return super.calculSalaire() + bonus;
    }

}

class ManuArisque extends Manu implements Arisque{

    public ManuArisque(String nom, String prenom, String date_entre, int age, int nbr_heure) {
        super(nom, prenom, date_entre, age, nbr_heure);
    }

    public double calculSalaire(){
        return super.calculSalaire() + bonus;
     }

}


class Personnel {
    public Personnel() {
    Perso = new Employe[maxEmploye];
    nbrEmploye = 0;   
    }


    public void ajouterEmploye(Employe e){
        ++nbrEmploye;
        if(nbrEmploye<=maxEmploye)
            Perso[nbrEmploye-1] = e;
        else 
            System.out.println("perso est plein");
    }

    public double salaireMoyenne(){
        double s = 0;
        for (int i=0; i<nbrEmploye;i++){
            s += Perso[i].calculSalaire();
        }
        double moy = s/nbrEmploye;
        return moy;
    }

    public void afficherSalaire(){
        for (int i=0; i<nbrEmploye;i++){
            System.out.println( Perso[i].getNom()+ " gange " +Perso[i].calculSalaire() + " ¢");
        }
    }
    private Employe[] Perso;
    private int nbrEmploye;
    private final int maxEmploye = 200;
}


interface Arisque{
    int bonus  = 200;
}