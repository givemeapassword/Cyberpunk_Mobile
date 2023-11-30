package com.example.rp_cyberpunk_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rp_cyberpunk_list.databinding.FragmentCharacteristicsSkillsBinding

class CharacterisitcSkillFragmentAdapter: RecyclerView.Adapter<CharacterisitcSkillFragmentAdapter.CharacteristicViewHolder>() {

    class CharacteristicViewHolder(item: View): RecyclerView.ViewHolder(item){
        private lateinit var binding: FragmentCharacteristicsSkillsBinding
        fun bind(){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacteristicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_characteristics__skills,parent,false)
        return CharacteristicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 1

    }

    override fun onBindViewHolder(holder: CharacteristicViewHolder, position: Int) {
        return holder.bind()
    }
}