package com.example.rp_cyberpunk_list.list_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rp_cyberpunk_list.CharacterisitcSkillFragmentAdapter
import com.example.rp_cyberpunk_list.R
import com.example.rp_cyberpunk_list.databinding.FragmentCharacteristicsSkillsBinding


class CharacteristicsSkillsFragment : Fragment() {
    private lateinit var binding: FragmentCharacteristicsSkillsBinding
    private val adapter = CharacterisitcSkillFragmentAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacteristicsSkillsBinding.inflate(layoutInflater)
        binding.rvCharacteristic.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvCharacteristic.adapter = adapter
        // Inflate the layout for this fragment
        return binding.root
    }
    companion object{
        @JvmStatic
        fun newInstance() = CharacteristicsSkillsFragment()
    }
}