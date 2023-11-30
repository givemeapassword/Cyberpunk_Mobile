package com.example.rp_cyberpunk_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedDispatcher
import com.example.rp_cyberpunk_list.list_fragments.CharacteristicsSkillsFragment
import com.example.rp_cyberpunk_list.databinding.ListActivityBinding
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
                onBackPressedDispatcher.onBackPressed()
            }

        }


    }
}