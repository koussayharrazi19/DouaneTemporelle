package com.example.douanetempo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

//e5er 4 chiffres men 4 etuduiant
        String m = MainActivity.MATRICULE;

//l code ya9ra l condition w esm l voyageur
        boolean approuve = getIntent().getBooleanExtra(Cles.cle(m, "VERDICT"), false);
        String nom = getIntent().getStringExtra(Cles.cle(m, "NOM_VOYAGEUR"));

//norbtou les éléments bil code
        View racine = findViewById(R.id.layout_racine_kh);
        TextView tvMessage = findViewById(R.id.tv_message_kh);
        Button btnNouveau = findViewById(R.id.btn_nouveau_kh);

//nbdlou l background par rapport lil condition w el message
        if (approuve) {
            racine.setBackgroundColor(Color.parseColor("#4CAF50")); // bil a5ther
            tvMessage.setText("Bon voyage " + nom);
        } else {
            racine.setBackgroundColor(Color.parseColor("#F44336")); // bil a7mer
            tvMessage.setText(nom + " est en état d'arrestation temporelle");
        }

//narj3ou lel activité loula w nsakrou les autres activités
        btnNouveau.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}