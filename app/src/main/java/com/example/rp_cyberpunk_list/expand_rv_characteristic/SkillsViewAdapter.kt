package com.example.rp_cyberpunk_list.expand_rv_characteristic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rp_cyberpunk_list.R
import com.example.rp_cyberpunk_list.databinding.SkillItemBinding

class SkillsViewAdapter(private val skillList: List<Skills>) :
        RecyclerView.Adapter<SkillsViewAdapter.ChildViewHolder>() {

        inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val binding = SkillItemBinding.bind(itemView)
            fun bind(skills: Skills) {
                binding.cardSkillText.text = skills.name
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.skill_item,parent,false)
            return ChildViewHolder(view)
        }

        override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
            holder.bind(skillList[position])
        }

        override fun getItemCount(): Int {
            return skillList.size
        }
    }