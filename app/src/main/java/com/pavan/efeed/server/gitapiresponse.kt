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

    @GET("/search/issues?q=is:issue%20repo:{owner}/{repo}")
    suspend fun getqueryissues(
        @Query("q") query: String,
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("is") issueQualifie : String,
        @Query("is") closedQualifier: String,
    ) :Response<List<Issues>>
}