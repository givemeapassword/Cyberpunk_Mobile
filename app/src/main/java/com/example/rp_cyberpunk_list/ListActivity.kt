package com.example.rp_cyberpunk_list

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.PopupMenu
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
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
import com.example.rp_cyberpunk_list.viewmodel.SharedViewModel
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class ListActivity : AppCompatActivity() {
    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var binding: ListActivityBinding
    private var imgUri: Uri? = null
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
        CharacteristicsSkillsFragment.newInstance(),
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
                builder.apply {
                    setTitle("Сохранение")
                    setMessage("Хотите сохранить изменения?")
                    setPositiveButton("Да") { _, _ ->
                        val uri = imgUri?.toString() ?: saveJohny(this@ListActivity)
                        myDbSQLManager.insertToDb(className.text.toString(), classCharacter.text.toString(),
                            savePhotoFromExternalToInternal(this@ListActivity, uri.toUri()).toString())
                        onBackPressedDispatcher.onBackPressed()
                    }
                    setNegativeButton("Нет") { _, _ ->
                        onBackPressedDispatcher.onBackPressed()
                    }
                }
                builder.create().show()

            }
            viewPager2.apply {
                offscreenPageLimit = 3
                setCurrentItem(0, false)
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                    override fun onPageSelected(position: Int) {
                        spinner.setSelection(position)
                        if (position == viewPager2.adapter?.itemCount?.minus(1)) {
                            viewPager2.setCurrentItem(0, false)}
                    }
                })
            }
            spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    viewPager2.setCurrentItem(position,true)
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }
            mainImage.setOnClickListener {
                changePhoto.launch(Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI))
            }
            dice.setOnClickListener{
                val popupMenu = PopupMenu(this@ListActivity, dice, Gravity.START)
                popupMenu.menuInflater.inflate(R.menu.dices, popupMenu.menu)
                popupMenu.show()
                popupMenu.setOnMenuItemClickListener { menuItem ->
                    when (menuItem.itemId) {
                        R.id.menu_item1 -> {
                            // Действия при выборе кнопки 1
                            true
                        }
                        R.id.menu_item2 -> {
                            // Действия при выборе кнопки 2
                            true
                        }
                        else -> false
                    }
                }
            }
        }

        sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]
        sharedViewModel.textData.observe(this) { text ->
            binding.className.text = text
        }
        sharedViewModel.classData.observe(this) { text ->
            binding.classCharacter.text = text
        }


    }

    private fun saveJohny(context: Context): String {
        val drawable: Drawable? = ContextCompat.getDrawable(context, R.drawable.jhony)
        val file = File.createTempFile("jhony",
            ".jpg",
            getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        )
        val outputStream: OutputStream = FileOutputStream(file)
        val bitmap: Bitmap = (drawable as BitmapDrawable).bitmap
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        outputStream.close()
        return Uri.fromFile(file).toString()
    }

    private val changePhoto = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if (it.resultCode == Activity.RESULT_OK) {
            val data = it.data
            imgUri = data?.data
            binding.mainImage.setImageURI(imgUri)
        }
    }

    private fun savePhotoFromExternalToInternal(context: Context, uri: Uri): Uri {
        val inputStream = context.contentResolver.openInputStream(uri)
        val outputFile = File.createTempFile("character",
            ".jpg",
            getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        )
        val outputStream = FileOutputStream(outputFile)

        try {
            inputStream?.use { input ->
                outputStream.use { output ->
                    val buffer = ByteArray(4 * 1024) // 4KB buffer size
                    var bytesRead: Int
                    while (input.read(buffer).also { bytesRead = it } != -1) {
                        output.write(buffer, 0, bytesRead)
                    }
                    output.flush()
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            inputStream?.close()
            outputStream.close()
        }

        return Uri.fromFile(outputFile)
    }
}