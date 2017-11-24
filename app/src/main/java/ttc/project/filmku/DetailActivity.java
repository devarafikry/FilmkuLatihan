package ttc.project.filmku;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public final static String TITLE_KEY_INTENT = "title";

    TextView tv_name;
    Button btn_search;

    String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tv_name = (TextView) findViewById(R.id.tv_name);
        btn_search = (Button) findViewById(R.id.btn_search);

        Intent intent = getIntent();
        if(intent!=null){
            if(intent.getStringExtra(TITLE_KEY_INTENT) != null){
                title = intent.getStringExtra(TITLE_KEY_INTENT);
            }
        }

        if(title!= null){
            tv_name.setText(title);
            btn_search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, title);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            });
        }
    }
}
