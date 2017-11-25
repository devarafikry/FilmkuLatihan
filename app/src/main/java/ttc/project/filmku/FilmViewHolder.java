package ttc.project.filmku;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by devar on 11/25/2017.
 */

public class FilmViewHolder extends RecyclerView.ViewHolder{

    public TextView tv_position;
    public TextView tv_film_name;
    public FilmViewHolder(View itemView) {
        super(itemView);
        tv_position = (TextView) itemView.findViewById(R.id.tv_position);
        tv_film_name = (TextView) itemView.findViewById(R.id.tv_film_name);
    }
}
