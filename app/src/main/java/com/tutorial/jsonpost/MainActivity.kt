package com.tutorial.jsonpost

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val my_url = "https://reqres.in/api/login"
        val requ = object : JsonObjectRequest(Request.Method.POST, my_url, null,
            Response.Listener {
                Toast.makeText(this,"My_token=${it.getString("token")}",Toast.LENGTH_SHORT).show()
            },
            Response.ErrorListener {

                Toast.makeText(this,"Error=${it.message}",Toast.LENGTH_SHORT).show()

            }
        ) {
            override fun getBody(): ByteArray {
                val my_post_string="{\n" +
                        "    \"email\": \"peter@klav\",\n" +
                        "}"
                return my_post_string.toByteArray()
            }

        }
        MySingleton.getInstance(this).addToRequestQueue(requ)
    }
}
