package com.example.varungupta.election;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.*;

public class loginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("users");

        final EditText aadhar = (EditText) findViewById(R.id.editText5);
        final EditText pass = (EditText) findViewById(R.id.editText6);

        Button loginButton = (Button) findViewById(R.id.Submit);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String aadharString = aadhar.getText().toString().trim();
                final String password = pass.getText().toString().trim();

                if(aadharString.length()!= 12)
                {
                    Toast.makeText(loginScreen.this,"Please enter the proper AADHAR Number",Toast.LENGTH_SHORT).show();
                }
                else if(password.length() != 8 )
                {
                    Toast.makeText(loginScreen.this,"Please enter the proper Password",Toast.LENGTH_SHORT).show();
                }
                else {

                    myRef.child(aadharString).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            if (snapshot.exists()) {
                                // TODO: handle the case where the data already exists
                                String pas=snapshot.child("DOB").getValue().toString();
                                if(pas.equalsIgnoreCase(password)) {
                                    Toast.makeText(loginScreen.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(loginScreen.this,selectConstituency.class);
                                    intent.putExtra("AADHAR",aadharString);
                                    Boolean con1=(Boolean)snapshot.child("con1").getValue();
                                    Boolean con2=(Boolean)snapshot.child("con1").getValue();
                                    intent.putExtra("con1",con1);
                                    intent.putExtra("con2",con2);
                                    startActivity(intent);
                                    loginScreen.this.overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                                }
                                else
                                    Toast.makeText(loginScreen.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();


                            } else {
                                // TODO: handle the case where the data does not yet exist
                                Toast.makeText(loginScreen.this, "Does not exits", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError firebaseError) {
                            Toast.makeText(loginScreen.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }

}
