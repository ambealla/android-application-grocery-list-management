package com.ensias.pfa2021

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.ensias.pfa2021.R.layout.activity_login_activity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Login_activity : AppCompatActivity() {

    var login: FirebaseAuth = Firebase.auth
    lateinit var tabLayout: TabLayout
    lateinit var viewpager: ViewPager
    lateinit var btn_facebook: FloatingActionButton
    lateinit var btn_google: FloatingActionButton
    lateinit var btn_twiter: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_login_activity)

        val user = Firebase.auth.currentUser
        if (user == null){




        tabLayout = findViewById(R.id.tabLayout)
        viewpager = findViewById(R.id.viewpager)
        btn_facebook = findViewById(R.id.f_facebook)
        btn_google = findViewById(R.id.f_google)
        btn_twiter = findViewById(R.id.f_twiter)




        tabLayout.addTab(tabLayout.newTab().setText("الدخول"))
        tabLayout.addTab(tabLayout.newTab().setText("التسجيل"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter(this, supportFragmentManager,
            tabLayout.tabCount)
        viewpager.adapter = adapter
        viewpager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewpager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })




        btn_facebook!!.setOnClickListener(View.OnClickListener({

            intent = Intent(this, Facebook::class.java)
            Toast.makeText(this@Login_activity, "جاري تحميل صفحة الفيسبوك...",
                Toast.LENGTH_LONG).show()

            startActivity(intent)


        }


        ))

        btn_google!!.setOnClickListener(View.OnClickListener({

            intent = Intent(this, Google::class.java)
            Toast.makeText(this@Login_activity, "جاري تحميل صفحة غوغل...",
                Toast.LENGTH_LONG).show()

            startActivity(intent)


        }


        ))

        btn_twiter!!.setOnClickListener(View.OnClickListener({

            intent = Intent(this, Twiter::class.java)
            Toast.makeText(this@Login_activity, "جاري تحميل صفحة تويتر...",
                Toast.LENGTH_LONG).show()

            startActivity(intent)


        }


        ))



}
        else{
            val intentprincipale = Intent(this, Home::class.java)
            startActivity(intentprincipale)
        }
}}

