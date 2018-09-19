package sam.com.findhome;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Objects;

public class Connect4 extends AsyncTask {

    public String link = "";
    public int ID = 0;

    public Connect4(String link, int ID) {
        this.link = link;
        this.ID = ID;

    }

    @Override
    protected Objects doInBackground(Object[] params) {

        try {
            String senddata = URLEncoder.encode("ID", "UTF8") + "=" + URLEncoder.encode(String.valueOf(ID), "UTF8");


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
            Main2Activity.dataServer234 = stringBuilder.toString();
            Main24Activity.dataServer234 = stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

