package com.example.douanetempo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VerificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        String m = MainActivity.MATRICULE;

        Intent recu = getIntent();
        String nom = recu.getStringExtra(Cles.cle(m, "NOM_VOYAGEUR"));
        int naissance = recu.getIntExtra(Cles.cle(m, "ANNEE_NAISSANCE"), 0);
        int destination = recu.getIntExtra(Cles.cle(m, "ANNEE_DESTINATION"), 0);
        String motif = recu.getStringExtra(Cles.cle(m, "MOTIF"));

        int age = destination - naissance;

        TextView tvNom = findViewById(R.id.tv_nom_kh);
        TextView tvAge = findViewById(R.id.tv_age_kh);
        TextView tvMotif = findViewById(R.id.tv_motif_kh);
        Button btnApprouver = findViewById(R.id.btn_approuver_kh);
        Button btnRefuser = findViewById(R.id.btn_refuser_kh);

        tvNom.setText("Nom : " + nom);
        tvAge.setText("Âge temporel : " + age + " ans");
        tvMotif.setText("Motif : " + motif);

        if ("Modification du passé".equals(motif) && estPremier(age)) {
            btnApprouver.setEnabled(false);
        }

        btnApprouver.setOnClickListener(v -> ouvrirVerdict(true, nom));

        btnRefuser.setOnClickListener(v -> ouvrirVerdict(false, nom));
    }

    private void ouvrirVerdict(boolean approuve, String nom) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(Cles.cle(MainActivity.MATRICULE, "VERDICT"), approuve);
        intent.putExtra(Cles.cle(MainActivity.MATRICULE, "NOM_VOYAGEUR"), nom);
        startActivity(intent);
    }

    private boolean estPremier(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}