package com.example.rp_cyberpunk_list.list_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rp_cyberpunk_list.databinding.FragmentCharacteristicsSkillsBinding
import com.example.rp_cyberpunk_list.expand_rv_characteristic.CharacteristicSkillsData
import com.example.rp_cyberpunk_list.expand_rv_characteristic.CharacteristicViewAdapter


class CharacteristicsSkillsFragment : Fragment() {
    private lateinit var binding: FragmentCharacteristicsSkillsBinding
    private val characteristicSkillsData = CharacteristicSkillsData()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacteristicsSkillsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CharacteristicViewAdapter(characteristicSkillsData.prepareData())

        binding.apply {
            parentRecyclerView.setHasFixedSize(true)
            parentRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            parentRecyclerView.adapter = adapter
        }
    }
    companion object{
        @JvmStatic
        fun newInstance() = CharacteristicsSkillsFragment()
    }
}