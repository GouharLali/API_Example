package com.gouhar.api_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.squareup.moshi.Moshi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(MoshiConverterFactory.create(
            Moshi.Builder().build()
        ))
        .build()

    private val usersApi: UsersApi = retrofit.create()

    private val usersTextView: TextView by lazy { findViewById(R.id.users_text_view)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
          try {
              val users = usersApi.getUsers()
              usersTextView.text = users.joinToString(separator = "\n\n") {it.address.street}
          } catch (e: Exception) {
              e.printStackTrace()
          }
        }
    }
}