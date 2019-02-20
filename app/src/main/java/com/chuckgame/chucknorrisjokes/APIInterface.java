package com.chuckgame.chucknorrisjokes;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("jokes/random")
    Call<Joke> getJoke(); // getJokes object ENCAPSULATES single request and response.

}