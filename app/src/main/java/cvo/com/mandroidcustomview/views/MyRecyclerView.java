package cvo.com.mandroidcustomview.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cvo.com.mandroidcustomview.R;
import cvo.com.mandroidcustomview.views.bases.BaseLinearLayout;

public class MyRecyclerView extends BaseLinearLayout {

    private Context mContext;

    private RecyclerView mRecyclerView;
    private TextView mTextViewMessage;
    private ImageView mImageView;
    private LinearLayout mLinearLayoutMessageContainer;
    private ProgressBar mProgressBar;
    private Button mButtonRetry;

    public MyRecyclerView(Context context) {
        super(context);
        init(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public MyRecyclerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public void init(Context context) {
        mContext = context;
        View view = inflate(mContext, R.layout.view_recycler_view_with_message, this);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.view_recycle_view_list);
        mRecyclerView.setLayoutManager(createLayoutManager());

        mTextViewMessage = (TextView) view.findViewById(R.id.view_recycle_view_message);

        mImageView = (ImageView) view.findViewById(R.id.view_recycle_view_image);
        mLinearLayoutMessageContainer = (LinearLayout) view.findViewById(R.id.view_recycle_view_message_container);

        mProgressBar = (ProgressBar) view.findViewById(R.id.view_recycle_view_progress);
        displayProgress();

        mButtonRetry = (Button) view.findViewById(R.id.view_recycle_view_retry);

    }

    public void displayProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mLinearLayoutMessageContainer.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.GONE);
    }

    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    public RecyclerView.LayoutManager getLayoutManager() {
        return mRecyclerView.getLayoutManager();
    }

    public RecyclerView.LayoutManager createLayoutManager() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext
                , LinearLayoutManager.VERTICAL
                , false);
        return layoutManager;
    }

    public void setMessage(String message) {
        mTextViewMessage.setText(message);
    }

    public void setMessage(int id) {
        mTextViewMessage.setText(id);
    }

    public void setImage(int imageId) {
        mImageView.setImageResource(imageId);
    }

    public void displayData() {
        hideProgress();
        mLinearLayoutMessageContainer.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    public void displayErrorMessage() {
        hideProgress();
        mLinearLayoutMessageContainer.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
    }

    public RecyclerView getList() {
        return this.mRecyclerView;
    }

    public Button getRetry() {
        return this.mButtonRetry;
    }

    public void setAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        this.mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
