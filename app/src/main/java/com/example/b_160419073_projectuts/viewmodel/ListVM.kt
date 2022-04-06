package com.example.b_160419073_projectuts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.b_160419073_projectuts.model.Kos

class ListVM:ViewModel() {
    val kosLD = MutableLiveData<List<Kos>>()
    val kosLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        val kos1 = Kos("1","https://pixabay.com/get/g1d8479da1745ab8b5ef6286df01a37929554d63220c18a350ba18c281f9d8587a43e335ed5f11a5523ce69e0a78a6865_1280.jpg","Widodo Kos","This enormous house has a fairytale-like look to it and is in average condition.  The interior is done in colors that remind you of a coral reef.  The yard is large and resembles a meadow.  Also, rumor has it an old witch used to live here.","012345578", "asdasd", "12")
        val kos2 = Kos("2","https://pixabay.com/get/g1d8479da1745ab8b5ef6286df01a37929554d63220c18a350ba18c281f9d8587a43e335ed5f11a5523ce69e0a78a6865_1280.jpg","Widodo Kos","This enormous house has a fairytale-like look to it and is in average condition.  The interior is done in colors that remind you of a coral reef.  The yard is large and resembles a meadow.  Also, rumor has it an old witch used to live here.","012345578", "asdasd", "12")
        val kos3 = Kos("3","https://pixabay.com/get/g1d8479da1745ab8b5ef6286df01a37929554d63220c18a350ba18c281f9d8587a43e335ed5f11a5523ce69e0a78a6865_1280.jpg","Widodo Kos","This enormous house has a fairytale-like look to it and is in average condition.  The interior is done in colors that remind you of a coral reef.  The yard is large and resembles a meadow.  Also, rumor has it an old witch used to live here.","012345578", "asdasd", "12")

        val listKos:ArrayList<Kos> = arrayListOf<Kos>(kos1, kos2, kos3)
        kosLD.value = listKos
        kosLoadErrorLD.value = false
        loadingLD.value = false
    }

}