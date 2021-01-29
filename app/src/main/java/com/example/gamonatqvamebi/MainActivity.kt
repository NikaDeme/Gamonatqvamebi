package com.example.gamonatqvamebi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class MainActivity : AppCompatActivity() {
    private lateinit var onClicklogin: Button
    private lateinit var email: EditText
    private lateinit var Password: EditText
    private lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onClicklogin = findViewById(R.id.loginbutton)
        email = findViewById(R.id.loginemail)
        Password = findViewById(R.id.loginpass)
        auth = FirebaseAuth.getInstance()


    onClicklogin.setOnClickListener {
        val email: String = email.text.toString()
        val password: String = Password.text.toString()

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please Fill The Gap", Toast.LENGTH_LONG).show()
        } else{
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                this,
                OnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser;
                        val profileUpdates = UserProfileChangeRequest.Builder()
                            .setDisplayName(email).build()

                        user?.updateProfile(profileUpdates)
                            ?.addOnCompleteListener(OnCompleteListener<Void?> { userUpdated ->
                                if (userUpdated.isSuccessful) {
                                    val intent = Intent(this, InformationListView::class.java)
                                    startActivity(intent)
                                    finish()
                                }
                            })
                    }
                })
        }



    }


    }
}

