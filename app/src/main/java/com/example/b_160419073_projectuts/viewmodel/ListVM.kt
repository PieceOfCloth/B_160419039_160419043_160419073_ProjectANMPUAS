package com.example.b_160419073_projectuts.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.b_160419073_projectuts.model.Kos
import com.example.b_160419073_projectuts.model.KosDatabase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ListVM(application: Application): AndroidViewModel(application), CoroutineScope
 {
    val kosLD = MutableLiveData<List<Kos>>()
    val kosLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
     private var job = Job()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        loadingLD.value = true
        kosLoadErrorLD.value = false
        launch{
            val db = Room.databaseBuilder(
                getApplication(),
                KosDatabase::class.java, "newkosdb").build()
            kosLD.value = db.kosDao().selectAllKos()
        }
    }

     fun createData(kos:List<Kos>){
         launch{
             val db = Room.databaseBuilder(
                 getApplication(),
                 KosDatabase::class.java, "newkosdb").build()
             db.kosDao().insertAll(*kos.toTypedArray())
         }
     }

     override fun onCleared() {
         super.onCleared()
         queue?.cancelAll(TAG)
     }

     override val coroutineContext: CoroutineContext
         get() = job + Dispatchers.Main
 }