package raditya.labs.albahjah.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import raditya.labs.albahjah.R;
import raditya.labs.albahjah.adapter.HomeAdapter;
import raditya.labs.albahjah.controller.HomeController;

/**
 * Created by raditya on 12/15/2014.
 */
public class HomeFragment extends Fragment {
    //https://github.com/codepath/android_guides/wiki/Creating-and-Using-Fragments

    private String Url = "http://www.radityalabs.net/";
    private ProgressDialog mProgressDialog;
    private HomeAdapter mAdapter;
    private HomeController mController;
    private View rootView = null;

    public HomeFragment(){}

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*mController = new HomeController(this);
        mAdapter = new HomeAdapter(this, mController);*/

        new Execute().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;
    }

    private class Execute extends AsyncTask<Void, Void, Void>{
        String titles;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage("Mohon Menunggu...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document document = Jsoup.connect(Url).get();
                Elements elements = document.select("h4[class=gk_news_show_news_header ta_center]");
                titles = elements.text();
                /*Elements elements = document.select("div[class=biz0ne-welcome] p");
                titles = elements.text();*/

               /* Element burnabyStatus = document.getElementsByClass("gk_news_show_news_header ta_center").first();
                Elements h1 = burnabyStatus.select("h4");
                burnabyStatus = h1.get(0);
                String b_status = burnabyStatus.text();*/
                Log.d("Hello", "Coba: " + titles);
            } catch (IOException ex){
                ex.printStackTrace();;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            TextView title = (TextView)rootView.findViewById(R.id.tv_text_fragment_home);
            title.setText(titles);
            mProgressDialog.dismiss();
        }
    }
}
