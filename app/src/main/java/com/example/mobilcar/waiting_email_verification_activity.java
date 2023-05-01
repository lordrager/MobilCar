//package com.example.mobilcar;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.button.MaterialButton;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//
//import java.util.Objects;
//
//public class waiting_email_verification_activity extends AppCompatActivity {
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        FirebaseAuth fAuth;
//        fAuth = FirebaseAuth.getInstance();
//        FirebaseUser user = fAuth.getCurrentUser();
//
//        if(Objects.isNull(user)) {
//                Toast.makeText(waiting_email_verification_activity.this, "User is null.",
//            Toast.LENGTH_SHORT).show();
//            return;
//        }
//        boolean is_Verified = user.isEmailVerified();
//        if(!is_Verified){
//            Toast.makeText(waiting_email_verification_activity.this, "User is not verified." + user.getEmail(),
//                    Toast.LENGTH_SHORT).show();
//            return;
//        }
//        Intent intent = new Intent(waiting_email_verification_activity.this, PersonInfoMainPage.class);
//        startActivity(intent);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_waiting_email_verification);
//        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
//
//
//        loginbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                FirebaseAuth fAuth;
////                fAuth = FirebaseAuth.getInstance();
////                FirebaseUser user = fAuth.getCurrentUser();
////                boolean is_Verified = user.isEmailVerified();
////                if(is_Verified){
////                    Intent intent = new Intent(waiting_email_verification_activity.this, PersonInfoMainPage.class);
////                    startActivity(intent);
////                }
////                else{
////                    Toast.makeText(waiting_email_verification_activity.this, "Please verify.",
////                            Toast.LENGTH_SHORT).show();
////                }
//                    Intent intent = new Intent(waiting_email_verification_activity.this, waiting_email_verification_activity.class);
//                    startActivity(intent);
//            }
//        });
//
//    }
//}
