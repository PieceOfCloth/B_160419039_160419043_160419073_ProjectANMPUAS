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
import okhttp3.Dispatcher
import java.util.ArrayList
import kotlin.coroutines.CoroutineContext

class DetilVM(application: Application): AndroidViewModel(application), CoroutineScope {
    val detailLD = MutableLiveData<Kos>()
    private val job = Job()
    val TAG = "volleyTag"
    private var queue: RequestQueue?=null

    fun detail2(id:Int){
        launch{
            val db = Room.databaseBuilder(
                getApplication(),
                KosDatabase::class.java,
                "newkosdb"
            ).build()
            detailLD.value = db.kosDao().selectKos(id)
        }
    }

    fun detail(id:Int){
        queue = Volley.newRequestQueue(getApplication())
        val url = "https://discoverable-mixtur.000webhostapp.com/json.php"

        val strRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                val sType = object : TypeToken<List<Kos>>() { }.type
//                val result = Gson().fromJson<List<Kos>>(it, sType)
                val result = Gson().fromJson<ArrayList<Kos>>( response, sType)

                for(x in result){
                    if(x.id == id){
                        detailLD.value = x
                    }
                }

//                Log.d("showvoley", it)
                Log.d("showvoley", response.toString())
            }, {
                Log.d("errorvoley", it.toString())
            })
        strRequest.tag = TAG
        queue?.add(strRequest)
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}