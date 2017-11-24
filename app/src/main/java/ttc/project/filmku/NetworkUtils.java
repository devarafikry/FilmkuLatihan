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

    //    TODO (11) buat variable TMDB base url sebagai base URL
    //    TODO (12) buat variable TMDB api key untuk menyimpan api key mu
    //    TODO (13) buat method untuk membangun URL request popular movies
    //    TODO (14) buat URI sesuai dokumentasi TMDB
    //    TODO (15) buat URL dari URI yang telah dibuat

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
