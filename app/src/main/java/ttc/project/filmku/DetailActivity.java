package ttc.project.filmku;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView tv_name_detail;
    Button btn_search;
    String movie_title = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        getSupportActionBar().setTitle("DETAILL");
        tv_name_detail = (TextView) findViewById(R.id.tv_name_detail);
        btn_search = (Button) findViewById(R.id.btn_search);

        Intent intent = getIntent();
        if (intent != null){
            if(intent.getStringExtra("film_title") != null){
                String title = intent.getStringExtra("film_title");
                movie_title = title;
                tv_name_detail.setText(title);
            }
        }

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, movie_title);
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }

        });

    }
}
