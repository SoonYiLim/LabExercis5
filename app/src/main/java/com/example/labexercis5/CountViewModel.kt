package my.edu.tarc.exercise5

import android.util.Log
import androidx.lifecycle.ViewModel


class CountViewModel: ViewModel() {
    var likeCounts: Int = 0
    var dislikeCounts: Int = 0

    init {
        Log.d("ViewModel", "ViewModel created")
    }

    fun plusLike(){
        likeCounts++
    }

    fun plusDislike() {
        dislikeCounts++
    }

    override fun onCleared() {
        Log.d("ViewModel", "ViewModel destroyed")
        super.onCleared()
    }
}