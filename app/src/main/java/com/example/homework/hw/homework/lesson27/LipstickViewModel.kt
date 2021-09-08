package com.example.homework.hw.homework.lesson27

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework.hw.homework.lesson27.model.Lipstick
import com.example.homework.hw.homework.lesson27.model.LipstickItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LipstickViewModel : ViewModel() {

    private val _lipsticksList = MutableLiveData<List<LipstickItem>>()
    val lipstiksList : LiveData<List<LipstickItem>> = _lipsticksList

    private val _lipstick = MutableLiveData<LipstickItem>()
    val lipstick : LiveData<LipstickItem> = _lipstick

    private val apiLipstick = ApiLipstick.create()

    fun getLipsticksList() {
        apiLipstick.getLipstick().enqueue(object : Callback<Lipstick> {
            override fun onResponse(call: Call<Lipstick>, response: Response<Lipstick>) {
                if (response.isSuccessful) {
                    _lipsticksList.postValue(response.body()?.lipsticks)
                }
            }

            override fun onFailure(call: Call<Lipstick>, t: Throwable) { }
        })
    }
}