package com.example.slidablemenu

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drlFirst=findViewById<androidx.drawerlayout.widget.DrawerLayout>(R.id.drawerLayout)
        val nvFirst=findViewById<com.google.android.material.navigation.NavigationView>(R.id.navView)
        toggle= ActionBarDrawerToggle(this,drlFirst,R.string.open,R.string.close)
        drlFirst.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nvFirst.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miItem1->Toast.makeText(applicationContext,
                    "Clicked Item 1",Toast.LENGTH_SHORT).show()

                R.id.miItem2->Toast.makeText(applicationContext,
                    "Clicked Item 2",Toast.LENGTH_SHORT).show()

                R.id.miItem3->Toast.makeText(applicationContext,
                    "Clicked Item 3",Toast.LENGTH_SHORT).show()
            }
            true


        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}