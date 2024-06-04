package com.example.timeflex.User.Bottom_Nav_Fragments_User

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.timeflex.R
import com.example.timeflex.databinding.FragmentInicioUBinding
import com.example.timeflex.databinding.FragmentNotasUBinding

class FragmentNotasU : Fragment() {

    private lateinit var binding: FragmentNotasUBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_notas_u, container, false)
    }

}