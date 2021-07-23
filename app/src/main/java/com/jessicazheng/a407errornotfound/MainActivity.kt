package com.jessicazheng.a407errornotfound

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.lifecycle.lifecycleOwner
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId) {
                R.id.nav_settings -> {
                }
                R.id.nav_help -> {
                    MaterialDialog(this).show {
                        title(R.string.help_title)
                        message(R.string.help_message) {
                            html()
                        }
                        positiveButton(R.string.dismiss)
                        lifecycleOwner()
                        cornerRadius(16f)
                    }
                    true
                }
                R.id.nav_about -> {
                    MaterialDialog(this).show {
                        title(R.string.about_title)
                        message(R.string.about_message) {
                            html()
                        }
                        positiveButton(R.string.dismiss)
                        lifecycleOwner()
                        cornerRadius(16f)
                    }
                    true
                }
                else -> Toast.makeText(this, "Place Holder", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}