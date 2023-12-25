package com.pavan.efeed.server

import com.pavan.efeed.Models.Issues
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface gitapiresponse {

    @GET("/repos/{owner}/{repo}/issues")
    suspend fun getclosedissues(
        @Path("owner") owner : String,
        @Path("repo") repo : String,
        @Query("state") state : String
    ):Response<List<Issues>>

    @GET("/repos/{owner}/{repo}/issues")
    suspend fun getqueryissues(
        @Path("owner") owner : String,
        @Path("repo") repo : String,
        @Query("state") state : String,
        @Query("q") query: String
    ) :Response<List<Issues>>
}