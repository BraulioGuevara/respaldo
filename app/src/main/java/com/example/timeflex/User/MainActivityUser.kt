package com.example.timeflex.User

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.timeflex.R
import com.example.timeflex.User.Bottom_Nav_Fragments_User.FragmentAppsU
import com.example.timeflex.User.Bottom_Nav_Fragments_User.FragmentCalendarioU
import com.example.timeflex.User.Bottom_Nav_Fragments_User.FragmentNotasU
import com.example.timeflex.User.Nav_Fragments_User.FragmentInicioU
import com.example.timeflex.User.Nav_Fragments_User.FragmentPerfilU
import com.example.timeflex.databinding.ActivityMainUserBinding
import com.google.android.material.navigation.NavigationView

class MainActivityUser : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        binding.navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        )

        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        replaceFragment(FragmentInicioU())
        binding.navigationView.setCheckedItem(R.id.op_inicio)

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.navFragment, fragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.op_inicio -> {
                replaceFragment(FragmentInicioU())
            }
            R.id.op_perfil -> {
                replaceFragment(FragmentPerfilU())
            }
            R.id.op_cerrar_sesion -> {
                Toast.makeText(applicationContext, "Saliste de la app", Toast.LENGTH_SHORT).show()
            }
            R.id.op_apps -> {
                replaceFragment(FragmentAppsU())
            }
            R.id.op_notas -> {
                replaceFragment(FragmentNotasU())
            }
            R.id.op_calendario -> {
                replaceFragment(FragmentCalendarioU())
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}