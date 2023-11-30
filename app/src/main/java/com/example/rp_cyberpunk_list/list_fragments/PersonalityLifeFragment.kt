package com.example.rp_cyberpunk_list.list_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rp_cyberpunk_list.R

class PersonalityLifeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personality_life, container, false)
    }
    companion object{
        @JvmStatic
        fun newInstance() = PersonalityLifeFragment()
    }
}