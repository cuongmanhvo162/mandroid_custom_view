package cvo.com.mandroidcustomview.model;

import java.util.List;

import cvo.com.mandroidcustomview.model.response.FilmData;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("/films")
    Call<List<FilmData>> getFilmsList();
}
