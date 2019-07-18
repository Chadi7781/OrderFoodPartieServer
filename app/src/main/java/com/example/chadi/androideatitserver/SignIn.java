package com.example.chadi.androideatitserver;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chadi.androideatitserver.Common.Common;
import com.example.chadi.androideatitserver.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {

    EditText edtPhone,edtPassword;
    Button btnSignIn;

    FirebaseDatabase database;
     DatabaseReference users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edtPassword=(MaterialEditText)findViewById(R.id.edtPassword);
        edtPhone=(MaterialEditText)findViewById(R.id.edtPhone);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);

        //init firebase;
         database = FirebaseDatabase.getInstance();
         users = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInUser(edtPhone.getText().toString() , edtPassword.getText().toString());

            }
        });

    }

    private void signInUser( String phone,  String password) {
        final ProgressDialog progressDialog = new ProgressDialog(SignIn.this);
        progressDialog.setMessage("Please waiting...");
        progressDialog.show();
        final String localPhone =phone;
        final String localPassword =password;

        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(localPhone).exists()){

                    progressDialog.dismiss();
                    User user = dataSnapshot.child(localPhone).getValue(User.class);
                    user.setPhone(localPhone);
                    if(Boolean.parseBoolean(user.getIsStaff())){
                        if(user.getPassword().equals(localPassword)){
                            //Login ok
                            Intent intent =new Intent(SignIn.this ,Home.class);
                            Common.currentUser = user;
                            startActivity(intent);
                            finish();
                        }
                        else
                            Toast.makeText(SignIn.this, "Wrong Password", Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(SignIn.this, "Please login with staff account", Toast.LENGTH_LONG).show();

                }
                else {
                    progressDialog.dismiss();
                    Toast.makeText(SignIn.this, "User not exist in database", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
