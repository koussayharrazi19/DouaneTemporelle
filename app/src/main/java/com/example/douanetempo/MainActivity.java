package com.example.douanetempo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // e5er 4 ar9am men bita9at taleb
    public static final String MATRICULE = "2226";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // bech norbtou les elements bel code
        EditText etNom = findViewById(R.id.et_nom_kh);
        EditText etNaissance = findViewById(R.id.et_naissance_kh);
        EditText etDestination = findViewById(R.id.et_destination_kh);
        Spinner spMotif = findViewById(R.id.sp_motif_kh);
        Button btnInspecter = findViewById(R.id.btn_inspecter_kh);

        // n3amrou liste mta3 l cause mta3 l voyageur
        String[] motifs = {"Tourisme", "Modification du passé", "Fuite"};
        spMotif.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, motifs));

        // ki nenzlou 3al bouton
        btnInspecter.setOnClickListener(v -> {
            String nom = etNom.getText().toString().trim();
            String sNaiss = etNaissance.getText().toString().trim();
            String sDest = etDestination.getText().toString().trim();
            // bech net2akdou ken les cases vides wlla

            if (nom.isEmpty() || sNaiss.isEmpty() || sDest.isEmpty()) {
                Toast.makeText(this, "Remplis tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }

            int naissance = Integer.parseInt(sNaiss);
            int destination = Integer.parseInt(sDest);
            String motif = spMotif.getSelectedItem().toString();

            Intent intent = new Intent(this, VerificationActivity.class);
            intent.putExtra(Cles.cle(MATRICULE, "NOM_VOYAGEUR"), nom);
            intent.putExtra(Cles.cle(MATRICULE, "ANNEE_NAISSANCE"), naissance);
            intent.putExtra(Cles.cle(MATRICULE, "ANNEE_DESTINATION"), destination);
            intent.putExtra(Cles.cle(MATRICULE, "MOTIF"), motif);
            startActivity(intent);
        });
    }
}