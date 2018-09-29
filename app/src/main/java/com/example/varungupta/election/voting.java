package com.example.varungupta.election;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class voting extends AppCompatActivity {

    InputStream is;
    TextView t;
    BufferedReader reader;
    EditText vote;
    String cname;
    String aadhar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting);


        cname = getIntent().getStringExtra("data");
        aadhar=getIntent().getStringExtra("aadhar");
        t = (TextView) findViewById(R.id.tv);
        String[] word = new String[50];
        String[] arr = new String[20];
        is = getResources().openRawResource(R.raw.party);
        reader = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                word = line.split(",", 2);

                if ((word[0].toLowerCase()).equals(cname.toLowerCase())) {
                    arr = word[1].split(",");
                    int i = 1;
                    StringBuilder builder = new StringBuilder();
                    for (String details : arr) {
                        builder.append(i + ". " + details + "\n");
                        i++;
                    }
                    t.setText(builder);
                    return;
                } else {
                    t.setText("No parties in your region.");
                }
            }
        } catch (Exception e) {

            t.setText("EXCEPTION CAUGHT.");
        }

        vote = (EditText) findViewById(R.id.editText3);
        Button voteButton = (Button) findViewById(R.id.vote);


    }

    public void Clicked(View v)throws Exception {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();


        EditText voteT=(EditText)findViewById(R.id.editText3);
        final String voteText=voteT.getText().toString().trim();

        if(cname.equalsIgnoreCase("vellore")) {
            final DatabaseReference myRef = database.getReference("vellore");
            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String num = (String) dataSnapshot.child(voteText).getValue();
                    int i = Integer.parseInt(num);
                    i = i + 1;
                    myRef.child(voteText).setValue("" + i);
                    DatabaseReference ref=database.getReference("users");
                    ref.child(aadhar).child("con1").setValue(true);
                    Intent intent=new Intent(voting.this,Result.class);

                    intent.putExtra("party","v"+voteText);
                    intent.putExtra("output",cname);
                    startActivity(intent);
                    voting.this.overridePendingTransition(R.anim.fadein,R.anim.fadeout);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(voting.this, "error", Toast.LENGTH_SHORT).show();

                }
            });
        }
        else
        {
            final DatabaseReference myRef = database.getReference("bram");
            myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String num = (String) dataSnapshot.child(voteText).getValue();
                    int i = Integer.parseInt(num);
                    i = i + 1;
                    myRef.child(voteText).setValue("" + i);
                    DatabaseReference ref=database.getReference("users");
                    ref.child(aadhar).child("con2").setValue(true);
                    Intent intent=new Intent(voting.this,Result.class);
                    intent.putExtra("party","b"+voteText);
                    intent.putExtra("output",cname);
                    startActivity(intent);
                    voting.this.overridePendingTransition(R.anim.fadein,R.anim.fadeout);

                }



                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(voting.this, "error", Toast.LENGTH_SHORT).show();

                }
            });
        }

    }
}
