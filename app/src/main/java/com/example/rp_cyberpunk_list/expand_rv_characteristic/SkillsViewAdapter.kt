package com.example.rp_cyberpunk_list.expand_rv_characteristic

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rp_cyberpunk_list.databinding.SkillItemBinding

class SkillsViewAdapter(private val skillList: List<Skills>) :
        RecyclerView.Adapter<SkillsViewAdapter.ChildViewHolder>() {
            private lateinit var binding: SkillItemBinding

        inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
            binding = SkillItemBinding.bind(parent)
            return ChildViewHolder(binding.root)
        }

        override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        }

        override fun getItemCount(): Int {
            return skillList.size
        }
    }
}