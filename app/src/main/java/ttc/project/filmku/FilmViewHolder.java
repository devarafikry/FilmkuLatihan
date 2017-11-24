package ttc.project.filmku;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Fikry-PC on 11/24/2017.
 */

public class FilmViewHolder extends RecyclerView.ViewHolder {
    TextView tv_film_name;
    public FilmViewHolder(View itemView) {
        super(itemView);
        tv_film_name = itemView.findViewById(R.id.film_name);
    }
}
