package com.example.eko8757.footballclubmatchschedule.main

//import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.FragmentManager
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.eko8757.footballclubmatchschedule.match.NextMatch
import com.example.eko8757.footballclubmatchschedule.match.PreviousMatch
import com.example.eko8757.footballclubmatchschedule.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var fragment: Fragment
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.inflateMenu(R.menu.bottom_navigation_menu)
        fragmentManager = getSupportFragmentManager()

        fragmentManager.beginTransaction().replace(R.id.mainContainer, PreviousMatch()).commit()

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            val id = item.getItemId()
            when (id) {
                R.id.previous -> fragment = PreviousMatch()
                R.id.next -> fragment = NextMatch()
            }

            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.mainContainer, fragment).commit()
            true
        }
    }
}
