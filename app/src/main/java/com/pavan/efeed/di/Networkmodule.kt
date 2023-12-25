package com.pavan.efeed.di

import com.pavan.efeed.server.gitapiresponse
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
import com.pavan.efeed.Constants.BASEURL
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class Networkmodule {

    @Provides
    @Singleton
    fun getRetrofit() : gitapiresponse{
        return Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(gitapiresponse::class.java)

    }
 }