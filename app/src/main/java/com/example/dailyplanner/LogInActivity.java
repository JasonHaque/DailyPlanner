package com.example.dailyplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity {

    private Button directToSignup,loginButton;
    private EditText loginMail,loginPassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    public static String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        bindWidgets();
        bindListeners();
        checkUserStatus();
    }
    void bindWidgets(){
        directToSignup=findViewById(R.id.signup_transfer);
        loginMail=findViewById(R.id.login_mail);
        loginPassword=findViewById(R.id.login_password);
        loginButton=findViewById(R.id.login_button);
        progressDialog = new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    void bindListeners(){
        loginMail.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                //If the keyevent is a key-down event on the "enter" button
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    //...
                    // Perform your action on key press here
                    // ...
                    return true;
                }
                return false;
            }
        });

        loginPassword.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent keyevent) {
                //If the keyevent is a key-down event on the "enter" button
                if ((keyevent.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    //...
                    // Perform your action on key press here
                    // ...
                    return true;
                }
                return false;
            }
        });

        directToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInActivity.this,SignUpActivity.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail=loginMail.getText().toString();
                String pass = loginPassword.getText().toString();
                if(TextUtils.isEmpty(mail) || TextUtils.isEmpty(pass)){
                    Toast.makeText(LogInActivity.this,"Fill up Email And Password Properly", Toast.LENGTH_LONG).show();
                    return;
                }
                login(mail,pass);
            }
        });
    }
    private void login(String mail,String pass){
        progressDialog.setTitle("Logging you in");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(mail,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LogInActivity.this,"Success", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
                String[] ID=firebaseAuth.getCurrentUser().getEmail().toString().split("@");
                userID=ID[0];
                startActivity(new Intent(LogInActivity.this,NotesActivity.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LogInActivity.this,"Login Failed", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
                return;
            }
        });
    }
    private void checkUserStatus(){
        if(firebaseAuth.getCurrentUser() != null){
            String[] ID=firebaseAuth.getCurrentUser().getEmail().toString().split("@");
            userID=ID[0];
            startActivity(new Intent(LogInActivity.this,NotesActivity.class));
        }
    }
    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
