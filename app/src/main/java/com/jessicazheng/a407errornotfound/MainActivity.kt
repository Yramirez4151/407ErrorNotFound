package com.jessicazheng.a407errornotfound


import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlin.reflect.KClass

//import com.google.firebase.auth.FirebaseAuth
//import com.jessicazheng.a407errornotfound.databinding.LoginScreenBinding
//import com.jessicazheng.a407errornotfound.databinding.NavHeaderBinding

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: NavHeaderBinding

    //private lateinit var firebaseAuth: FirebaseAuth

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setContentView(R.layout.items)


        //binding = NavHeaderBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        //firebaseAuth = FirebaseAuth.getInstance()
        //checkUser()


        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)


        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId) {
                R.id.nav_settings -> Toast.makeText(applicationContext, "Place Holder", Toast.LENGTH_SHORT).show()

                else -> Toast.makeText(this, "Place Holder", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    /*
    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser == null){
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        } else {
            val email = firebaseUser.email
        }
    }
     */

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
    fun homeClick(item: MenuItem){
        val intent = Intent(this@MainActivity,HomeActivity::class.java)
        startActivity(intent)
    }
    fun usedClick(item: MenuItem){
        val intent = Intent(this@MainActivity,UsedActivity::class.java)
        startActivity(intent)
    }
    fun clothesClick(item:MenuItem){
        val intent = Intent(this@MainActivity,FeedActivity::class.java)
        startActivity(intent)
    }

}