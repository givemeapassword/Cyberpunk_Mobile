package com.example.rp_cyberpunk_list.expand_rv_characteristic

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rp_cyberpunk_list.databinding.FragmentCharacteristicsSkillsBinding

class CharacteristicViewAdapter(private val characteristicItemList: List<Characteristics>) :
    RecyclerView.Adapter<CharacteristicViewAdapter.ParentRecyclerViewHolder>() {
        private lateinit var binding: FragmentCharacteristicsSkillsBinding

    inner class ParentRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentRecyclerViewHolder {
        binding = FragmentCharacteristicsSkillsBinding.bind(parent)
        return ParentRecyclerViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ParentRecyclerViewHolder, position: Int) {
        val parentItem = characteristicItemList[position]

    }
    override fun getItemCount(): Int {
        return characteristicItemList.size
    }
}