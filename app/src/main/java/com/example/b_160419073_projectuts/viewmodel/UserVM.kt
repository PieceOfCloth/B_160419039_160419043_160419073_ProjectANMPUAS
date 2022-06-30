package com.example.b_160419073_projectuts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.b_160419073_projectuts.model.Kos
import com.example.b_160419073_projectuts.model.KosDatabase
import com.example.b_160419073_projectuts.model.User
import com.example.b_160419073_projectuts.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserVM(application: Application):AndroidViewModel(application), CoroutineScope {

    val userLD = MutableLiveData<User>()
    private var job = Job()

    fun refresh(id:Int){
        launch{
            val db = buildDB(getApplication())
            userLD.value = db.userDao().getUser(id)
        }
    }

    fun insertUser(user:User){
        launch{
            val db = buildDB(getApplication())
            db.userDao().insertAll(user)
        }
    }

    fun createData(user:List<User>){
        launch{
            val db =buildDB(getApplication())
            db.userDao().insertAll(*user.toTypedArray())
        }
    }

    fun editUser(id:Int, name:String, gender:String, HP:String){
        launch{
            val db =buildDB(getApplication())
            db.userDao().editUser(id, name, gender, HP)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}