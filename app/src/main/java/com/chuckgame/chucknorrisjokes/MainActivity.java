package com.chuckgame.chucknorrisjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    TextView text;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView_jokes);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.icndb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(APIInterface.class);

    }

    public void getJokes(View view) {

        Call<Joke> call = apiInterface.getJoke();

        call.enqueue(new Callback<Joke>() {
            @Override
            public void onResponse(Call<Joke> call, Response<Joke> response) {
                if (!response.isSuccessful()){
                    text.setText("Code: " + response.code());
                    return;
                }
                Joke joke = response.body(); // Save in joke the whole response body content

                text.setText(joke.getValue().getJoke()); // get the field you need
            }

            @Override
            public void onFailure(Call<Joke> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });

    }

}
