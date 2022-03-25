package com.ensias.pfa2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import Inspiration
import list
import profile


class Home: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val profile=profile()
        val inspiration=Inspiration()
        val list= list()

        setCurrentFragment(list)
val bottomNavigationView:BottomNavigationView=findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.list->setCurrentFragment(list)
                R.id.inspiration->setCurrentFragment(inspiration)
                R.id.profile->setCurrentFragment(profile)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }

}
