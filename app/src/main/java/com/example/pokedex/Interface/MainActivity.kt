package com.example.pokedex.Interface

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.pokedex.R
import com.example.pokedex.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType")
    private lateinit var navControle: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navigation) as NavHostFragment
        navControle = navHostFragment.navController
        setupActionBarWithNavController(navControle)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navControle.navigateUp() || super.onSupportNavigateUp()
    }

}