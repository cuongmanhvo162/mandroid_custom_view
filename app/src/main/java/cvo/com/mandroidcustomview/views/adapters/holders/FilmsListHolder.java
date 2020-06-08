package cvo.com.mandroidcustomview.views.adapters.holders;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cvo.com.mandroidcustomview.R;
import cvo.com.mandroidcustomview.model.response.FilmData;

public class FilmsListHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    private TextView mTitle;
    private TextView mReleaseDate;
    private TextView mDescription;
    private TextView mDirector;
    private TextView mProducer;
    private TextView mRtScore;

    public FilmsListHolder(Context context, @NonNull View itemView) {
        super(itemView);
        this.mContext = context;
        this.mTitle = (TextView) itemView.findViewById(R.id.adapter_films_list_title);
        this.mReleaseDate = (TextView) itemView.findViewById(R.id.adapter_films_list_release_date);
        this.mDescription = (TextView) itemView.findViewById(R.id.adapter_films_list_description);
        this.mDirector = (TextView) itemView.findViewById(R.id.adapter_films_list_director);
        this.mProducer = (TextView) itemView.findViewById(R.id.adapter_films_list_producer);
        this.mRtScore = (TextView)itemView.findViewById(R.id.adapter_films_list_rt_score);
    }

    public void seData(FilmData filmData) {
        this.mTitle.setText(filmData.getTitle());
        this.mReleaseDate.setText(mContext.getString(R.string.release_date).concat(filmData.getReleaseDate()));
        this.mDescription.setText(filmData.getDescription());
        this.mDirector.setText(mContext.getString(R.string.director).concat(filmData.getDirector()));
        this.mProducer.setText(mContext.getString(R.string.producer).concat(filmData.getProducer()));
        this.mRtScore.setText(mContext.getString(R.string.rotten_tomatoes).concat(filmData.getRottenTomatoesScore()));
    }
}
