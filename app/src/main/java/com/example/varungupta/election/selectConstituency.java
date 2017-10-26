package com.example.varungupta.election;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectConstituency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_contituency);


        Button vellore = (Button) findViewById(R.id.csub);
        Button bharampura = (Button) findViewById(R.id.csub2);
        Intent intent = getIntent();
        final String aadhar = intent.getStringExtra("AADHAR");
        Boolean s1 = (Boolean) intent.getBooleanExtra("con1", false);
        Boolean s2 = (Boolean) intent.getBooleanExtra("con1", false);
        if (s1 || s2) {
            vellore.setEnabled(false);
            bharampura.setEnabled(false);
        }
        vellore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(selectConstituency.this, voting.class);
                i.putExtra("data", "Vellore");
                i.putExtra("aadhar", aadhar);
                startActivity(i);
                selectConstituency.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }
        });
        bharampura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(selectConstituency.this, voting.class);
                i.putExtra("data", "Brahmapura");
                i.putExtra("aadhar", aadhar);
                startActivity(i);
                selectConstituency.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);

            }

        });
    }
}