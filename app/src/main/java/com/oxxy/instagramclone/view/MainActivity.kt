package com.oxxy.instagramclone.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.oxxy.instagramclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        auth = Firebase.auth

        val currentUser = auth.currentUser

        if (currentUser!= null){
            val intent = Intent(this@MainActivity, FeedActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun signIn (view: View){
        val email = binding.emailInput.text.toString()
        val password = binding.PasswordInput.text.toString()

        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this@MainActivity, "Enter your email and password",Toast.LENGTH_LONG).show()
        } else{
            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener {
                val intent = Intent(this@MainActivity, FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this@MainActivity,it.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }

    }

    fun signUp (view: View){
        val email = binding.emailInput.text.toString()
        val password = binding.PasswordInput.text.toString()

        if(email.isEmpty() || password.isEmpty()) {

            Toast.makeText(this, "Enter your email and password.", Toast.LENGTH_LONG).show()

        }
        else {
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {

                val intent  = Intent(this@MainActivity, FeedActivity::class.java)
                startActivity(intent)
                finish()

            }.addOnFailureListener{
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }
    }
}