package com.example.androidjetpack

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest

class MainRepository(var mRequestQueue: RequestQueue) {
var posts = MutableLiveData<ArrayList<Post>>()

    fun getData() : ArrayList<Post>{
        var lst = ArrayList<Post>()
        var post1 = Post(1, 1, "my name", "fred")
        var post2 = Post(2, 2, "gender", "male")
        var post3 = Post(3, 3, "age", "30")
        lst.add(post1)
        lst.add(post2)
        lst.add(post3)
        return lst
    }

    fun fetchOnlineData(){
        val url = "https://jsonplaceholder.typicode.com/posts"
        val onlinePosts = ArrayList<Post>()
        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                for (jsonObject in 0.until(response.length())){
                    onlinePosts.add(
                        Post(
                            response.getJSONObject(jsonObject).getInt("userId"),
                            response.getJSONObject(jsonObject).getInt("id"),
                            response.getJSONObject(jsonObject).getString("title"),
                            response.getJSONObject(jsonObject).getString("body")
                        )
                    )
                }
                posts.value = onlinePosts
            },
            { error ->
                Log.d("Error", error.toString())
            }
        )

         mRequestQueue.add(request)
    }

}