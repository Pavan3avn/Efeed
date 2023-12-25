package com.pavan.efeed.repository

import com.pavan.efeed.Models.Issues
import retrofit2.Response


interface irepository {
    suspend fun getissues():Response<List<Issues>>
}