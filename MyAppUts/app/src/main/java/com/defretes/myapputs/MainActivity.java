package com.defretes.myapputs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView mView;
    FilemAdapter adapter;
    List<Result> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView = (RecyclerView)findViewById(R.id.filemView);
        mView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));

        filemLoad();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sort_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    private void filemLoad() {
        IntApi intApi = API.getRetorfit().create(IntApi.class);
        Call<Filem> call = intApi.getNp();
        call.enqueue(new Callback<Filem>() {
            @Override
            public void onResponse(Call<Filem> call, Response<Filem> response) {
                Filem filem = response.body();
                adapter = new FilemAdapter(results);
                adapter.setResults(filem.getResults());
                mView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Filem> call, Throwable t) {

            }
        });
    }
}
