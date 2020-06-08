package cvo.com.mandroidcustomview.views;

import java.util.List;

import cvo.com.mandroidcustomview.model.response.FilmData;

public interface FilmsListView {
    void displayFilmsList(List<FilmData> list);
    void displayFail();
}
