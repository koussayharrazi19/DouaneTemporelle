package com.example.douanetempo;

public class Cles {
    //methode bech taaml clé metkawen men les 4 derniers chiffres mta3 carte etudiant
    public static String cle(String matricule, String nom) {
        return matricule + "_" + nom;
    }
}
