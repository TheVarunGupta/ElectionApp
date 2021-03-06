package com.example.varungupta.election;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Result extends AppCompatActivity {
    TextView tv;
    BufferedReader reader;
    InputStream is;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tv=(TextView)findViewById(R.id.textView5);
        String cname = getIntent().getStringExtra("party");
        char[] carr= cname.toCharArray();

        ImageView im = (ImageView) findViewById(R.id.imageView);
        int[] vArray = new int[10];
        vArray[1] = R.drawable.img0;
        vArray[2] = R.drawable.img1;
        vArray[3] = R.drawable.img2;
        vArray[4] = R.drawable.img3;
        vArray[5] = R.drawable.img4;
        vArray[6] = R.drawable.img5;

        int[] bArray = new int[10];
        bArray[1] = R.drawable.b1;
        bArray[2] = R.drawable.b2;
        bArray[3] = R.drawable.b3;
        bArray[4] = R.drawable.b4;
        bArray[5] = R.drawable.b5;


        if (carr[0]=='v') {
            for (int i = 1; i <= 6; i++) {
                if (("" + i).equalsIgnoreCase(cname.substring(1)))
                    im.setImageResource(vArray[i]);
            }
        }
        if (carr[0]=='b') {
            for (int i = 1; i <= 5; i++) {
                if (("" + i).equalsIgnoreCase(cname.substring(1)))
                    im.setImageResource(bArray[i]);
            }
        }
        String city;
        int limit;
        if (carr[0]=='v') {
            city = "vellore";
            Toast.makeText(getApplicationContext(),"THIS IS VELLORE",Toast.LENGTH_LONG);
            limit = 6;

        } else {
            city = "bram";
            Toast.makeText(getApplicationContext(),"THIS IS BRAM",Toast.LENGTH_LONG);
            limit = 5;

        }

        final int a=limit;
        String[] word = new String[50];
        String[] arr = new String[20];
        is = getResources().openRawResource(R.raw.party);
        reader = new BufferedReader(new InputStreamReader(is));
        String line= null;
        try {
            line = reader.readLine();
            if(city=="vellore")
                word = line.split(",", 2);
            else{
                line=reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        word = line.split(",", 2);
        arr=word[1].split(",");


    final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference(city);
        final String[] finalWord = arr;
        myRef.addValueEventListener(new ValueEventListener() {
            StringBuilder sb= new StringBuilder();
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(int i=1;i<=a;i++)
                {
                    String s= dataSnapshot.child(Integer.toString(i)).getValue().toString();
                    sb.append(finalWord[i-1]+" : "+s+" \n");
                }

                tv.setText(sb);
            }




            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Result.this, "error", Toast.LENGTH_SHORT).show();

            }

        });







    }

    @Override
    public void onBackPressed() {
        Intent in = new Intent(Result.this,loginScreen.class);
        startActivity(in);
        Result.this.overridePendingTransition(R.anim.fadein, R.anim.fadeout);

    }
}
