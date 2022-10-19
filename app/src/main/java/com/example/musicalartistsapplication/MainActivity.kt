package com.example.musicalartistsapplication

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.example.musicalartistsapp.GetSearchResultQuery
import com.example.musicalartistsapplication.common.data.datasource.remote.impl.ArtistsListRemoteDataSourceImpl
import com.example.musicalartistsapplication.core.extension.d

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        lifecycleScope.launchWhenResumed {
//
//            val response = apolloClient.query(
//                GetSearchResultQuery(
//                    "Jackson",
//                    first = Optional.present(10),
//                    after = Optional.present(null)
//                )
//            ).execute()
//
//            Log.e("LaunchList", "Success ${response.data}")
//
//        }


        d {
            "onCreate: MainActivity!"
        }
    }

//    val apolloClient = ApolloClient.Builder()
//        .serverUrl("https://graphbrainz.herokuapp.com/")
//        .build()

}