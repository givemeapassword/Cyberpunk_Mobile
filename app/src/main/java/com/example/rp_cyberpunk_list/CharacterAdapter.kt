package com.example.rp_cyberpunk_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rp_cyberpunk_list.databinding.CardItemBinding
import com.example.rp_cyberpunk_list.db.MySQLManager

class CharacterAdapter(private val listener: Listener, val context: Context):
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        return holder.bind(characterList[position],listener)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    fun addCharacter(characters: Characters){
        characterList.add(characters)
        notifyDataSetChanged()
    }

    fun addCards(cardData: ArrayList<Characters>){
        characterList.clear()
        characterList.addAll(cardData)
    }

    fun removeCard(position: Int,dbManager: MySQLManager){
        dbManager.deleteFromDb(characterList[position].id)
        characterList.removeAt(position)
        notifyItemRangeChanged(0,characterList.size)
        notifyItemRemoved(position)
    }


    interface Listener{
        fun onClick(characters: Characters)
    }
}
