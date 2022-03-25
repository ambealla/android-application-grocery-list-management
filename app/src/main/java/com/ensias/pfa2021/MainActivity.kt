package com.ensias.pfa2021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.os.Handler as Handler1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       android.os.Handler().postDelayed({
           val intent= Intent(this@MainActivity,Login_activity::class.java)//bax doz la page dyal login
           startActivity(intent)
           finish()//bax matrja3
       }, 3000)
    }


}