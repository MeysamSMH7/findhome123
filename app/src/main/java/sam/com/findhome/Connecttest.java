package sam.com.findhome;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Objects;

public class Connecttest extends AsyncTask {

    public String link = "";
    public String post_matn = "";
    public String post_name = "";

    public Connecttest(String link, String post_matn, String post_name) {
        this.link = link;
        this.post_matn = post_matn;
        this.post_name = post_name;

    }

    @Override
    protected Objects doInBackground(Object[] params) {

        try {
            String senddata = URLEncoder.encode("post_matn", "UTF8") + "=" + URLEncoder.encode(post_matn, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("post_name", "UTF8") + "=" + URLEncoder.encode(post_name, "UTF8");


            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(senddata);
            writer.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //Parch (Nekohi_click-site)
            StringBuilder stringBuilder = new StringBuilder();
            String data = null;

            while ((data = bufferedReader.readLine()) != null) {
                stringBuilder.append(data);
                //read until end
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

