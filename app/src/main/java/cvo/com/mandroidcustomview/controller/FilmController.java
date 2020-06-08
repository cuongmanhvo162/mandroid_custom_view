package cvo.com.mandroidcustomview.controller;

import android.content.Context;

import java.util.List;

import cvo.com.mandroidcustomview.model.ApiClient;
import cvo.com.mandroidcustomview.model.response.FilmData;
import cvo.com.mandroidcustomview.utils.LogUtils;
import cvo.com.mandroidcustomview.views.FilmsListView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmController {
    private Context mContext;
    private FilmsListView mFilmsListView;

    public FilmController(Context context, FilmsListView filmsListView) {
        this.mContext = context;
        this.mFilmsListView = filmsListView;
    }

    public void getFilmsList() {
        ApiClient apiClient = ApiClient.getInstance();
        apiClient.getApiRequest().getFilmsList().enqueue(new Callback<List<FilmData>>() {
            @Override
            public void onResponse(Call<List<FilmData>> call, Response<List<FilmData>> response) {
                Response<List<FilmData>> res = response;
                List<FilmData> data = res.body();

                mFilmsListView.displayFilmsList(data);

            }

            @Override
            public void onFailure(Call<List<FilmData>> call, Throwable t) {
                LogUtils.logE("FilmController getFilmsList " + t.getMessage());
                mFilmsListView.displayFail();

            }
        });
    }
}
