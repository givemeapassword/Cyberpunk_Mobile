package com.example.rp_cyberpunk_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.app.AlertDialog
import com.example.rp_cyberpunk_list.list_fragments.CharacteristicsSkillsFragment
import com.example.rp_cyberpunk_list.databinding.ListActivityBinding
import com.example.rp_cyberpunk_list.db.MySQLManager
import com.example.rp_cyberpunk_list.list_fragments.ConditionInjuriesFragment
import com.example.rp_cyberpunk_list.list_fragments.CyberImplantFragment
import com.example.rp_cyberpunk_list.list_fragments.CyberdecaFragment
import com.example.rp_cyberpunk_list.list_fragments.EquipmentFragment
import com.example.rp_cyberpunk_list.list_fragments.ImprovementPointsFragment
import com.example.rp_cyberpunk_list.list_fragments.NotesFragment
import com.example.rp_cyberpunk_list.list_fragments.PersonalityLifeFragment
import com.example.rp_cyberpunk_list.list_fragments.WeaponsArmorFragment

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ListActivityBinding
    private val myDbSQLManager = MySQLManager(this)
    private val fragmentList = listOf(
        CharacteristicsSkillsFragment.newInstance(),
        WeaponsArmorFragment.newInstance(),
        ConditionInjuriesFragment.newInstance(),
        CyberImplantFragment.newInstance(),
        EquipmentFragment.newInstance(),
        CyberdecaFragment.newInstance(),
        PersonalityLifeFragment.newInstance(),
        ImprovementPointsFragment.newInstance(),
        NotesFragment.newInstance(),
    )
    private val adapter = VPAdapter(this,fragmentList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            mainImage.setImageResource(intent.getIntExtra("Image_Card",10))
            viewPager2.adapter = adapter

            backButton.setOnClickListener{
                val builder = AlertDialog.Builder(this@ListActivity)
                builder.setTitle("Сохранение")
                builder.setMessage("Хотите сохранить изменения?")
                builder.setPositiveButton("Да"){_,_ ->
                    myDbSQLManager.insertToDb(className.text.toString(),classCharacter.text.toString(),"uri")
                    onBackPressedDispatcher.onBackPressed()
                }
                builder.setNegativeButton("Нет"){_,_ ->
                    onBackPressedDispatcher.onBackPressed()
                }
                val dialog = builder.create()
                dialog.show()

            }

            spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    viewPager2.setCurrentItem(position,true)
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}

            }
            className.setOnClickListener{
                className.requestFocus()
            }
            classCharacter.setOnClickListener{
                classCharacter.requestFocus()
            }

        }


    }
}