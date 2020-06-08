package cvo.com.mandroidcustomview.views.adapters;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cvo.com.mandroidcustomview.R;
import cvo.com.mandroidcustomview.controller.FilmController;
import cvo.com.mandroidcustomview.model.response.FilmData;
import cvo.com.mandroidcustomview.views.adapters.holders.FilmsListHolder;

public class FilmsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<FilmData> mList;

    public FilmsListAdapter(Context context, List<FilmData> list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.adapter_films_list, parent, false);

        FilmsListHolder holder = new FilmsListHolder(mContext, view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FilmData data = mList.get(position);
        FilmsListHolder filmsListHolder = (FilmsListHolder) holder;
        filmsListHolder.seData(data);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
