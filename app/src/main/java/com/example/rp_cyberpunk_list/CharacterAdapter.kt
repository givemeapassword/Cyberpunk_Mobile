package com.example.rp_cyberpunk_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rp_cyberpunk_list.databinding.CardItemBinding

class CharacterAdapter(private val listener: Listener): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characterList = ArrayList<Characters>()

    class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = CardItemBinding.bind(itemView)
        fun bind(characters: Characters, listener: Listener){
            binding.apply {
                cardImage.setImageResource(R.drawable.jhony)
                charactersName.text = characters.name
                charactersClass.text = characters.role

                cardCharacter.setOnClickListener{
                    listener.onClick(characters)
                }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterAdapter.CharacterViewHolder, position: Int) {
        return holder.bind(characterList[position],listener)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    fun addCharacter(characters: Characters){
        characterList.add(characters)
        notifyDataSetChanged()
    }

    interface Listener{
        fun onClick(characters: Characters)
    }
}
