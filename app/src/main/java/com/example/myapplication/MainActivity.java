package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
String api ="https://fakestoreapi.com/products";
ArrayList<userModel> allUserlist;
RecyclerView rcvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       rcvMain = findViewById(R.id.rcvMain);
       rcvMain.setLayoutManager(new LinearLayoutManager(this));
        getData();
        allUserlist = new ArrayList<>();
    }

    private void getData() {

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, api,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0;i<array.length();i++){
                                JSONObject singleobject = array.getJSONObject(i);
                                userModel singleModel = new userModel(
                                        singleobject.getInt("id"),
                                        singleobject.getString("title"),
                                        singleobject.getInt("price"),
                                        singleobject.getString("description"),
                                        singleobject.getString("rating"),
                                        singleobject.getString("rate"),
                                        singleobject.getString("count")
                                );
                                allUserlist.add(singleModel);

                            }
                            rcvMain.setAdapter(new userAdapter(MainActivity.this,allUserlist));
                            Log.e("api", "onResponse: "+allUserlist.size());
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("api", "onResponse: "+e.getMessage() );
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("api", "onErrorResponse: "+error.getLocalizedMessage() );
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }}

