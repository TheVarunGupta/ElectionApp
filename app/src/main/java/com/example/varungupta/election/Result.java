package com.example.varungupta.election;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        tv=(TextView)findViewById(R.id.textView5);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String cname = getIntent().getStringExtra("party");

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


        if (cname.substring(0, 1).equalsIgnoreCase("v")) {
            for (int i = 1; i <= 6; i++) {
                if (("" + i).equalsIgnoreCase(cname.substring(1)))
                    im.setImageResource(vArray[i]);
            }
        }
        if (cname.substring(0, 1).equalsIgnoreCase("b")) {
            for (int i = 1; i <= 5; i++) {
                if (("" + i).equalsIgnoreCase(cname.substring(1)))
                    im.setImageResource(bArray[i]);
            }
        }
        String city;
        int limit;
        if (cname.substring(0, 1).equalsIgnoreCase("v")) {
            city = "vellore";
            limit = 6;

        } else {
            city = "bram";
            limit = 5;

        }

        final int a=limit;
       /* String[] word = new String[50];
        String[] arr = new String[20];
        String cname2=getIntent().getStringExtra("output");
        InputStream is = getResources().openRawResource(R.raw.party);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line= null;
        try {
            line = reader.readLine();
            if(cname2.toLowerCase().charAt(0)=='b')
                line=reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        word = line.split(",", 2);
        arr = word[1].split(",");
        int i = 1;
        StringBuilder builder = new StringBuilder();
        for (String details : arr) {
            builder.append(i + ". " + details + "\n");
            Toast.makeText(Result.this,details,Toast.LENGTH_SHORT);
            i++;
        }
        //tv.append(builder);*/
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(city);
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        StringBuilder sb=new StringBuilder();

                        for(int i=1;i<=a;i++) {

                            String s = (String) dataSnapshot.child(""+i).getValue();
                            sb.append("Team " +i+": " + s+"\n");

                        }
                        //tv=(TextView)findViewById(R.id.textView5);
                        tv.append(sb);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });










    }
}
