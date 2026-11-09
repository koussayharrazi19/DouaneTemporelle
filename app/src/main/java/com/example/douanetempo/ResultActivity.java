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

        String m = MainActivity.MATRICULE;

        boolean approuve = getIntent().getBooleanExtra(Cles.cle(m, "VERDICT"), false);
        String nom = getIntent().getStringExtra(Cles.cle(m, "NOM_VOYAGEUR"));

        View racine = findViewById(R.id.layout_racine_kh);
        TextView tvMessage = findViewById(R.id.tv_message_kh);
        Button btnNouveau = findViewById(R.id.btn_nouveau_kh);

        if (approuve) {
            racine.setBackgroundColor(Color.parseColor("#4CAF50")); // أخضر
            tvMessage.setText("Bon voyage " + nom);
        } else {
            racine.setBackgroundColor(Color.parseColor("#F44336")); // أحمر
            tvMessage.setText(nom + " est en état d'arrestation temporelle");
        }

        btnNouveau.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}