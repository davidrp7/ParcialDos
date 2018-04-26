package com.example.jonmid.practicaborder;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonmid.practicaborder.Adapters.FoodAdapter;
import com.example.jonmid.practicaborder.Adapters.GameAdapter;
import com.example.jonmid.practicaborder.Http.UrlManager;
import com.example.jonmid.practicaborder.Models.Game;
import com.example.jonmid.practicaborder.Parser.JsonFood;
import com.example.jonmid.practicaborder.Parser.JsonGame;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    RecyclerView recyclerView;

    List<Game> gameList = new ArrayList<>();

    GameAdapter gameAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        button = (Button) findViewById(R.id.id_bt_volver);
        textView = (TextView) findViewById(R.id.id_txv_game_name);
        recyclerView = (RecyclerView) findViewById(R.id.id_rcv_game);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);


    }

    public void showGame(View view) {
        Intent intent = new Intent(GameActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public Boolean isOnLine() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            return true;
        } else {
            return false;
        }
    }

    public void processData() {

    }

    public class GameTask extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {
            String content = null;
            try {
                content = UrlManager.getDataJson(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return  content;


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                gameList = JsonGame.getData(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }


}
