package com.example.rp_cyberpunk_list.expand_rv_characteristic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rp_cyberpunk_list.R
import com.example.rp_cyberpunk_list.databinding.CharacterisiticItemBinding

class CharacteristicViewAdapter(private val characteristicItemList: List<Characteristics>) :
    RecyclerView.Adapter<CharacteristicViewAdapter.ParentRecyclerViewHolder>() {

    inner class ParentRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = CharacterisiticItemBinding.bind(itemView)
        fun bind(characteristicsItem: Characteristics){
            binding.apply {
                parentTitleTv.text = characteristicsItem.name
                childRecyclerView.setHasFixedSize(true)
                childRecyclerView.layoutManager = LinearLayoutManager(itemView.context)
            }
            val adapter = SkillsViewAdapter(characteristicsItem.skillItemList)
            binding.childRecyclerView.adapter = adapter

            val isExpandable = characteristicsItem.expandable
            binding.childRecyclerView.visibility = if(isExpandable) View.VISIBLE else View.GONE
            binding.constraintLayout.setOnClickListener {
                characteristicsItem.expandable = !characteristicsItem.expandable
                notifyItemChanged(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.characterisitic_item,parent,false)
        return ParentRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParentRecyclerViewHolder, position: Int) {
        holder.bind(characteristicItemList[position])
    }
    override fun getItemCount(): Int {
        return characteristicItemList.size
    }
}