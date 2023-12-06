package com.example.rp_cyberpunk_list

import android.content.Intent
import android.os.Bundle
import android.provider.BaseColumns
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rp_cyberpunk_list.databinding.MainActivityBinding
import com.example.rp_cyberpunk_list.db.MySQLManager

class MainActivity:AppCompatActivity(), CharacterAdapter.Listener {

    private lateinit var binding: MainActivityBinding
    private val myDbSQLManager = MySQLManager(this)
    private val adapter = CharacterAdapter(this,this)
    private val cards = ArrayList<Characters>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.apply {
            toolbar.setOnMenuItemClickListener{menuItem ->
                when(menuItem.itemId){
                    R.id.account -> {
                        true
                    }
                    R.id.settings -> {
                        true
                    }
                    else -> false
                }
            }
            mainRv.layoutManager = LinearLayoutManager(this@MainActivity)
            mainRv.adapter = adapter
            getSwapMng().attachToRecyclerView(mainRv)
            cards.addAll(myDbSQLManager.getAllCards())
            adapter.addCards(cards)

            addCharacter.setOnClickListener{
                val characters = Characters(BaseColumns._ID,R.drawable.jhony.toString(),"Jonny","SOLO")
                adapter.addCharacter(characters)
            }

        }

    }
    private fun getSwapMng(): ItemTouchHelper {
        return ItemTouchHelper(object:ItemTouchHelper
        .SimpleCallback(0,ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                                target: RecyclerView.ViewHolder): Boolean { return false }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                adapter.removeCard(viewHolder.adapterPosition,myDbSQLManager)
            }
        })
    }
    override fun onClick(characters: Characters) {
        startActivity(Intent(this@MainActivity,ListActivity::class.java)
            .setAction("Card")
            .putExtra("Image_Card",R.drawable.jhony)
    )
    }
}