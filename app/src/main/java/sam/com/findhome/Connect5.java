package sam.com.findhome;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Objects;

public class Connect5 extends AsyncTask {

    public String link = "";
    public String userName = "";


    public Connect5(String link ,String userName ) {
        this.link = link;
        this.userName = userName;

    }

    @Override
    protected Objects doInBackground(Object[] params) {

        try {
            String senddata = URLEncoder.encode("userName", "UTF8") + "=" + URLEncoder.encode(userName, "UTF8");


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
            MainActivity.dataServerlogin= stringBuilder.toString();



        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

