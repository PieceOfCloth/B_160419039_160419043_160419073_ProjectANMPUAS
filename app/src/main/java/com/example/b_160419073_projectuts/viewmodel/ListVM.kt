package com.example.b_160419073_projectuts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.b_160419073_projectuts.model.Kos
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListVM(application: Application): AndroidViewModel(application)
 {
    val kosLD = MutableLiveData<List<Kos>>()
    val kosLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
//        val kos1 = Kos("1","https://pixabay.com/get/g1d8479da1745ab8b5ef6286df01a37929554d63220c18a350ba18c281f9d8587a43e335ed5f11a5523ce69e0a78a6865_1280.jpg","Widodo Kos","This enormous house has a fairytale-like look to it and is in average condition.  The interior is done in colors that remind you of a coral reef.  The yard is large and resembles a meadow.  Also, rumor has it an old witch used to live here.","012345578", "asdasd", "12")
//        val kos2 = Kos("2","https://pixabay.com/get/g1d8479da1745ab8b5ef6286df01a37929554d63220c18a350ba18c281f9d8587a43e335ed5f11a5523ce69e0a78a6865_1280.jpg","Widodo Kos","This enormous house has a fairytale-like look to it and is in average condition.  The interior is done in colors that remind you of a coral reef.  The yard is large and resembles a meadow.  Also, rumor has it an old witch used to live here.","012345578", "asdasd", "12")
//        val kos3 = Kos("3","https://pixabay.com/get/g1d8479da1745ab8b5ef6286df01a37929554d63220c18a350ba18c281f9d8587a43e335ed5f11a5523ce69e0a78a6865_1280.jpg","Widodo Kos","This enormous house has a fairytale-like look to it and is in average condition.  The interior is done in colors that remind you of a coral reef.  The yard is large and resembles a meadow.  Also, rumor has it an old witch used to live here.","012345578", "asdasd", "12")
//
//        val listKos:ArrayList<Kos> = arrayListOf<Kos>(kos1, kos2, kos3)
//        kosLD.value = listKos
        kosLoadErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://discoverable-mixtur.000webhostapp.com/json.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Kos>>() { }.type
                val result = Gson().fromJson<List<Kos>>(it, sType)
                kosLD.value = result

                loadingLD.value = false
                Log.d("showvoley", it)
            },
            {
                Log.d("showvoley", it.toString())
                kosLoadErrorLD.value = false
                loadingLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

     override fun onCleared() {
         super.onCleared()
         queue?.cancelAll(TAG)
     }
 }