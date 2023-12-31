package com.pavan.efeed.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pavan.efeed.Models.Issues
import com.pavan.efeed.repository.Issuerepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class issueviewmodel @Inject constructor(private val issuerepository: Issuerepository):ViewModel() {

     private val _issuelist = MutableLiveData<List<Issues>>()
     val issuelist : LiveData<List<Issues>> get() = _issuelist



    init {
        loaddata()
    }

    private fun loaddata() {
        viewModelScope.launch {
            try {
                val data  = issuerepository.getissues()
                if (data.isSuccessful) {
                    _issuelist.value = data.body()
                } else {
                    Log.e("Viewmodel", "Error: ${data.message()}")
                }
            }catch (e : Exception){
                Log.e("Viewmodel","error occured",e)
            }

        }
    }





}