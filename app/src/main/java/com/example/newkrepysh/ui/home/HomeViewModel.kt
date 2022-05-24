package com.example.newkrepysh.ui.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.newkrepysh.entities.User
import com.example.newkrepysh.local.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.*
import java.io.IOException
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    contextApp: Context,
    val repository: Repository,
) : ViewModel() {

    private var _list = MutableLiveData<List<User?>>()
    var list: LiveData<List<User?>> = _list

//    fun getKidsFromDb() {
//        viewModelScope.launch(Dispatchers.IO) {
//            _list.postValue(repository.getKidsFromDb().map { it.user }.toList())
//
//        }

//    }

    suspend fun getUserFromApi() {
        repository.putUserToDb()
    }

    fun initUser() {
        viewModelScope.launch(Dispatchers.IO) {
            getUserFromApi()
            val kids = repository.getKidsFromDb()
            val users = kids.map { it.user }
            users.forEach {
                println(it?.media)
            }
            _list.postValue(users)
            withContext(Dispatchers.Main){

            }
        }
    }

}