package com.example.labexercis5


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import my.edu.tarc.exercise5.CountViewModel


class MainActivity : AppCompatActivity() {
    //Module-level variable
    lateinit var countViewModel: CountViewModel
    //Create an instance of the Shared Preferences
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialise the ViewModel
        countViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)

        //Initialise the Shared Preferences
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)


        imageViewLike.setOnClickListener {
            countViewModel.plusLike()
            textViewLike.text = countViewModel.likeCounts.toString()
        }

        imageViewDislike.setOnClickListener {
            countViewModel.plusDislike()
            textViewDislike.text = countViewModel.dislikeCounts.toString()
        }
    }

    override fun onStart() {
        Log.d("MainActivity" , "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity" , "onResume")
        val likes = sharedPreferences.getInt(getString(R.string.like), 0)
        val dislikes = sharedPreferences.getInt(getString(R.string.dislike), 0)

        countViewModel.likeCounts = likes
        countViewModel.dislikeCounts = dislikes

        textViewLike.text = countViewModel.likeCounts.toString()
        textViewDislike.text = countViewModel.dislikeCounts.toString()

        super.onResume()
    }

    override fun onPause() {
        Log.d("MainActivity" , "onPause")
        with(sharedPreferences.edit()){
            putInt(getString(R.string.like), countViewModel.likeCounts)
            putInt(getString(R.string.dislike), countViewModel.dislikeCounts)
            commit()
        }
        super.onPause()

    }

    override fun onStop() {
        Log.d("MainActivity" , "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity" , "onDestroy")
        super.onDestroy()
    }
}
