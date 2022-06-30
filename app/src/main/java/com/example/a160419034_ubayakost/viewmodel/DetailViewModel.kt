package com.example.a160419034_ubayakost.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160419034_ubayakost.model.Kost
import com.example.a160419034_ubayakost.model.Pesan
import com.example.a160419034_ubayakost.model.User
import com.example.a160419034_ubayakost.util.buildDb
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    private var job = Job()
    val kostLD = MutableLiveData<Kost>()
    val UserLD = MutableLiveData<User>()

    var result=""

    fun addKost(kostList: List<Kost>) {
        launch {
            val db = buildDb(getApplication())
            db.kostDao().insertAll(*kostList.toTypedArray())
        }
    }

    fun update(kost: Kost) {
        launch {
            val db = buildDb(getApplication())
            db.kostDao().update(kost)
        }
    }

    fun delete(kost: Kost) {
        launch {
            val db = buildDb(getApplication())
            db.kostDao().deleteKost(kost)
        }
    }

    fun addUser(userList: List<User>) {
        launch {
            val db = buildDb(getApplication())
            db.userDao().insertAll(*userList.toTypedArray())
        }
    }

    fun login(username: String, password:String) {
        launch {
            val db = buildDb(getApplication())
            if (username==""&&password=="") {
                result="EMPTY"
                Log.d("Global", "Please fill username or password!")
            }
            else if (username != UserLD.value?.username&&password!=UserLD.value?.password) {
                result="WRONG"
                Log.d("Global", "Username or Password is wrong")
            } else {
                result="SUCCESS"
                Log.d("Global", "Login Success")
            }
            UserLD.value=db.userDao().selectLogin(username, password)
        }
    }

    fun fetch(uuid:Int) {
        launch {
            val db = buildDb(getApplication())
            kostLD.value = db.kostDao().selectKost(uuid)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

//    val KostLiveData= MutableLiveData<Kost>()
//    val MessageLiveData= MutableLiveData<Pesan>()
//    val TAG = "volleyTag"
//    private var queue: RequestQueue? = null

//    fun fetch(kostId : String) {
//
//        queue = Volley.newRequestQueue(getApplication())
//        val url = "https://ubaya.fun/hybrid/160419034/160419034_ANMP/kost.php?id=$kostId"
//
//        val stringRequest = StringRequest(
//            Request.Method.GET,url,
//            {
//                val result = Gson().fromJson<Kost>(it, Kost::class.java)
//                KostLiveData.value = result
//                Log.d("showvolley", it)
//            },
//            {
//                Log.d("errorvolley",it.toString())
//            }
//        ).apply {
//            tag = "TAG"
//        }
//        queue?.add(stringRequest)
//    }
//
//    fun fetchMessage(messageId : String) {
//
//        queue = Volley.newRequestQueue(getApplication())
//        val url = "https://ubaya.fun/hybrid/160419034/160419034_ANMP/message.php?id=$messageId"
//
//        val stringRequest = StringRequest(
//            Request.Method.GET,url,
//            {
//                val result = Gson().fromJson<Pesan>(it, Pesan::class.java)
//                MessageLiveData.value = result
//                Log.d("showvolley", it)
//            },
//            {
//                Log.d("errorvolley",it.toString())
//            }
//        ).apply {
//            tag = "TAG"
//        }
//        queue?.add(stringRequest)
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        queue?.cancelAll(TAG)
//    }
}