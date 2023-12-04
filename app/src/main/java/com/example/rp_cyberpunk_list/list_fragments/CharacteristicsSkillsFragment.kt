package com.example.rp_cyberpunk_list.list_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rp_cyberpunk_list.databinding.FragmentCharacteristicsSkillsBinding


class CharacteristicsSkillsFragment : Fragment() {
    private lateinit var binding: FragmentCharacteristicsSkillsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacteristicsSkillsBinding.inflate(layoutInflater)
        return binding.root
    }
    companion object{
        @JvmStatic
        fun newInstance() = CharacteristicsSkillsFragment()
    }
}