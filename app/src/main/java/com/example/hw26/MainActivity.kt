package com.example.hw26

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.hw26.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val imageUrls= arrayOf("https://files.masterkrasok.ru/v4/pictures/jkdv6O6Qxbw96MBxSCUl3wll7vaSUYdZNx0vyj4x.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSj1KgsOUjCVBT5-GincbSW2R4FbhhMtrarDQ&usqp=CAU",
        "https://lh3.googleusercontent.com/R54IzIh9wjxWXXS8Du68CAPuIGZqw2dPGpKcY_E8Jmi2eeN-T3XNABLDSlvL74hqfNLj_9_oz4B2qsEoTznxMqOJtFUa4jW00DR3Gc3_Jc4Tflzv_0ZPV9-T8qnyPvactywquNKW",
        "https://cdn-s-static.arzamas.academy/storage/picture/5933/gallery_picture-2fb5bb29-f538-498c-a1c3-71c0aa2d1bb3.jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFSfk0Bf-6sKPmbDqZbB3m9gbiFKsubEGz5g&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVkJ6qHPO4wIozWXsgLymZcP81LH7nLC_BuA&usqp=CAU",
        "https://img.freepik.com/free-vector/spring-landscape-scene_52683-56331.jpg?size=626&ext=jpg",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTbMEVy5XF4foYsShP6PmUSO_z9nNh_7IsNw&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdKxGSSTPSpB-2F4IeqaaVxArsdbjCUbLayg&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGrx51kUcKb_N5BYWf-XZzj3boUh801eHsjQ&usqp=CAU")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        randomUrl()
        submitUrl()
    }

    private fun randomUrl() {
        binding.btnRandom.setOnClickListener{
            val randImage = Random.nextInt(imageUrls.size)
            Glide.with(this).load(imageUrls[randImage]).into(binding.image)
        }
    }

    private fun submitUrl() {
        binding.btnSubmit.setOnClickListener{
            if(binding.etUrl.text.toString().isEmpty()){
                Toast.makeText(this,getString(R.string.etNoText), Toast.LENGTH_SHORT).show()
            }else{
                if( Patterns.WEB_URL.matcher(binding.etUrl.text.toString()).matches()){
                    val url = Uri.parse(binding.etUrl.text.toString())
                    Glide.with(this).load(url).into(binding.image)
                }else{
                    Toast.makeText(this,getString(R.string.uncorrectUrl), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}