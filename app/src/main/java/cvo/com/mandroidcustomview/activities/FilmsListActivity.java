package cvo.com.mandroidcustomview.activities;

import android.os.Bundle;
import android.view.View;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import cvo.com.mandroidcustomview.R;
import cvo.com.mandroidcustomview.controller.FilmController;
import cvo.com.mandroidcustomview.model.response.FilmData;
import cvo.com.mandroidcustomview.views.FilmsListView;
import cvo.com.mandroidcustomview.views.MyRecyclerView;
import cvo.com.mandroidcustomview.views.adapters.FilmsListAdapter;

public class FilmsListActivity extends AppCompatActivity implements FilmsListView {
    private MyRecyclerView mFilmsList;
    private FilmController mFilmController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films_list);

        mFilmsList = (MyRecyclerView)findViewById(R.id.activity_films_list_list);
        mFilmsList.getRetry().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFilmController.getFilmsList();
            }
        });

        mFilmController = new FilmController(this, this);
        mFilmController.getFilmsList();
    }

    @Override
    public void displayFilmsList(List<FilmData> list) {
        FilmsListAdapter adapter = new FilmsListAdapter(this, list);
        mFilmsList.setAdapter(adapter);
        mFilmsList.displayData();
    }

    @Override
    public void displayFail() {
        mFilmsList.displayErrorMessage();
    }
}
