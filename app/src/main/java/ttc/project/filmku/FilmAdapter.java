package ttc.project.filmku;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Fikry-PC on 11/24/2017.
 */

public class FilmAdapter extends RecyclerView.Adapter<FilmViewHolder> {
    ArrayList<String> data;
    Context mContext;

    public FilmAdapter(Context context) {
        this.mContext = context;
    }

    public void swapData(ArrayList<String> data){
        this.data = data;
    }

    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.film_item, parent, false);
        FilmViewHolder filmViewHolder = new FilmViewHolder(view);
        return filmViewHolder;
    }

    @Override
    public void onBindViewHolder(FilmViewHolder holder, final int position) {
        if(data != null){
            holder.tv_film_name.setText(data.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra(DetailActivity.TITLE_KEY_INTENT, data.get(position));
                    mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(data != null){
            return data.size();
        } else return 0;
    }
}
