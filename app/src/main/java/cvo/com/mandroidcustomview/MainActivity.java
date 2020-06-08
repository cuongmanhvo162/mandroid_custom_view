package cvo.com.mandroidcustomview;

import androidx.appcompat.app.AppCompatActivity;
import cvo.com.mandroidcustomview.activities.FilmsListActivity;
import cvo.com.mandroidcustomview.views.IntentUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mGhibliFilms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGhibliFilms = (Button)findViewById(R.id.activity_main_ghibli_films);
        mGhibliFilms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FilmsListActivity.class);
                intent.setAction(IntentUtils.OPEN_FILMS_LIST);
                startActivity(intent);
            }
        });
    }
}