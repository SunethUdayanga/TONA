package com.tona.li;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.tona.li.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView txtv1,txtv2,txtv3;
    EditText et1,et2;
    Button btn1,btn2;

    private ActivityMainBinding binding;
    private static final int rc_sign_in = 100;
    private GoogleSignInClient googleSignInClient;
    private FirebaseAuth firebaseAuth;
    private static final String Tag = "Google_Signin_Tag";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();



        txtv1 = findViewById(R.id.tv1);
        txtv2 = findViewById(R.id.tv2);
        txtv3 = findViewById(R.id.tv3);
        et1 = findViewById(R.id.ettea1);
        et2 = findViewById(R.id.ettp1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        txtv1.setText("TONA");
        txtv2.setText("Login");

        et1.setText("");
        et1.setHint("E-mail");
        et2.setText("");
        et2.setHint("Password");

        btn1.setText("Login");
        btn2.setText("Google");

        btn1.setOnClickListener(new View.OnClickListener() {

            String email;
            String pass;


            @Override
            public void onClick(View view) {

                email = et1.getText().toString();
                pass = et2.getText().toString();
                txtv3.setText(email+pass);

                if ("com".equals(email) && "1234".equals(pass)) {
                    txtv3.setText(pass+email);

                    startActivity(new Intent(MainActivity.this,Activity_2.class));

                }
                else {
                    //txtv3.setText("error...retry..!");
                }

            }
        });

        //cofig g_signin
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(R.string.default_web_client_id)
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);

        //init firebase
        firebaseAuth = FirebaseAuth.getInstance();

        //button
        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //begin
                Log.d(Tag,"onClick Begin Signin");
                Intent intent = googleSignInClient.getSignInIntent();
                startActivity


            }
        });










    }
}