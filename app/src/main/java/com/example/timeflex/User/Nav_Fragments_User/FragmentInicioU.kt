package com.example.timeflex.User.Nav_Fragments_User

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.timeflex.R
import com.example.timeflex.User.Bottom_Nav_Fragments_User.FragmentAppsU
import com.example.timeflex.User.Bottom_Nav_Fragments_User.FragmentCalendarioU
import com.example.timeflex.User.Bottom_Nav_Fragments_User.FragmentNotasU
import com.example.timeflex.databinding.FragmentInicioUBinding

class FragmentInicioU : Fragment() {

    private lateinit var binding: FragmentInicioUBinding
    private lateinit var mContext : Context

    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentInicioUBinding.inflate(inflater,container, false)

        binding.BottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
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
            true
        }

        replaceFragment(FragmentPerfilU())
        binding.BottomNavigation.selectedItemId = R.id.op_apps

        return binding.root
    }

    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.bottomFragment, fragment)
            .commit()
    }
}