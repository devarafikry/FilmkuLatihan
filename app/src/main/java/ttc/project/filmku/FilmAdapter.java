package ttc.project.filmku;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by devar on 11/25/2017.
 */

public class FilmAdapter extends RecyclerView.Adapter<FilmViewHolder>{
    Context mContext;
    ArrayList<String> titles;

    public FilmAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void swapData(ArrayList<String> titles){
        this.titles = titles;
    }

    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_view, parent, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilmViewHolder holder, int position) {
        holder.tv_position.setText(String.valueOf(position));
        holder.tv_film_name.setText(titles.get(position));
    }

    @Override
    public int getItemCount() {
        if (titles == null){
            return 0;
        }
        return titles.size();
    }
}
