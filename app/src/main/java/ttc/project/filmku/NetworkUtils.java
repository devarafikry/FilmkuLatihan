package ttc.project.filmku;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Fikry-PC on 11/23/2017.
 */

public class NetworkUtils {

    //    COMPLETED (11) buat variable TMDB base url sebagai base URL
    //    COMPLETED (12) buat variable TMDB api key untuk menyimpan api key mu
    //    COMPLETED (13) buat method untuk membangun URL request popular movies
    //    COMPELTED (14) buat URI sesuai dokumentasi TMDB
    //    TODO (15) buat URL dari URI yang telah dibuat
    public static final String BASE_MOVIE_URL = "https://api.themoviedb.org/3/";
    public static final String MOVIE_API_KEY = "b31eb468ed717f4e6cf0337e7b902e9a";
    public static Uri buildPopularMovieUri(){
        //https://api.themoviedb.org/3/movie/popular?api_key=b31eb468ed717f4e6cf0337e7b902e9a
        Uri.Builder popularUriBuilder = new Uri.Builder();
        Uri uri = Uri.parse(BASE_MOVIE_URL).buildUpon()
                .appendPath("movie")
                .appendPath("popular")
                .appendQueryParameter("api_key",MOVIE_API_KEY)
                .build();

        return uri;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
