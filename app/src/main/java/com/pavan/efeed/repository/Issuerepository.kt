package com.pavan.efeed.repository
import com.pavan.efeed.Constants.owner
import com.pavan.efeed.Constants.repo
import com.pavan.efeed.Models.Issues
import com.pavan.efeed.server.gitapiresponse
import retrofit2.Response
import retrofit2.http.Query
import javax.inject.Inject

class Issuerepository @Inject constructor(private val gitapiresponse: gitapiresponse): irepository{

     override suspend fun getissues(): Response<List<Issues>> {
        return gitapiresponse.getclosedissues(owner,repo,"closed")
     }


 }