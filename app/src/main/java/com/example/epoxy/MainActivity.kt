package com.example.epoxy

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        findViewById<BottomNavigationView>(R.id.bottomNav)
            .setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            println(destination.displayName)
            if (destination.displayName != "com.example.epoxy:id/homeFragment") {
                findViewById<DrawerLayout>(R.id.drawerLayout).setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            } else {
                findViewById<DrawerLayout>(R.id.drawerLayout).setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            }
        }

        findViewById<NavigationView>(R.id.navView).setupWithNavController(navController)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.bottom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.personFragment -> {
                val toast = Toast.makeText(applicationContext, "Profile fragment", Toast.LENGTH_SHORT)
                toast.show()
                true
            }
            R.id.homeFragment -> {
                val toast = Toast.makeText(applicationContext, "Home fragment", Toast.LENGTH_SHORT)
                toast.show()
                true
            }
            R.id.settingFragment -> {
                val toast = Toast.makeText(applicationContext, "Card fragment", Toast.LENGTH_SHORT)
                toast.show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}