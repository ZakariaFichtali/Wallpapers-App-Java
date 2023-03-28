package com.sanfor01.applicationa;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.sanfor01.applicationa.model.CategoryModel;
import com.sanfor01.applicationa.utils.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppHelper extends MultiDexApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    RequestQueue queue;
    @Override
    public void onCreate() {
        super.onCreate();

        queue = Volley.newRequestQueue(this);
        getData();
    }
   private void getData() {

       JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, Constants.remote_url, null, new Response.Listener<JSONObject>() {
           @Override
           public void onResponse(JSONObject response) {
                try {
                    JSONObject ads = response.getJSONObject("ads");

                    JSONArray categories = response.getJSONArray("categories");
                    for (int i = 0; i < categories.length(); i++) {
                        JSONObject item = categories.getJSONObject(i);
                        CategoryModel categoryModel = new CategoryModel();
                        categoryModel.setId(item.getInt("id"));
                        categoryModel.setName(item.getString("name"));
                        categoryModel.setImage(item.getString("image"));
                        categoryModel.setLocked(item.getBoolean("locked"));

                        Constants.categoryModelList.add(categoryModel);
                    }

                    Constants.loadingStatus = 1;
                }
                catch (JSONException e) {
                    e.printStackTrace();
                    Constants.loadingStatus = 2;
                }
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Constants.loadingStatus = 2;
           }
       });
       request.setShouldCache(false);
       queue.add(request);

   }
}
