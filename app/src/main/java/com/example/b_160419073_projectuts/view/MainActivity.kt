package com.example.b_160419073_projectuts.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.b_160419073_projectuts.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController1: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController1 = (supportFragmentManager.findFragmentById(R.id.mainFragment) as NavHostFragment).navController

        NavigationUI.setupActionBarWithNavController(this, navController1, drawerLayout)
        NavigationUI.setupWithNavController(navViewMain, navController1)

        bottomNav.setupWithNavController(navController1)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController1, drawerLayout) || super.onSupportNavigateUp()

    }
}