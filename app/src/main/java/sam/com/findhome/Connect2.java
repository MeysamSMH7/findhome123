package sam.com.findhome;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Objects;

public class Connect2 extends AsyncTask {

    public String link = "";
    public String noe_MELK_android123 = "";
    public int ID = 0;

    public Connect2(String link,int ID,String noe_MELK_android123) {
        this.link = link;
        this.ID = ID;
        this.noe_MELK_android123 = noe_MELK_android123;

    }

    @Override
    protected Objects doInBackground(Object[] params) {

        try {
            String senddata = URLEncoder.encode("ID", "UTF8") + "=" + URLEncoder.encode(String.valueOf(ID), "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("noe_MELK_android123", "UTF8") + "=" + URLEncoder.encode(noe_MELK_android123, "UTF8");


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
            Main24Activity.dataServer23 = stringBuilder.toString();
            Main2Activity.dataServer23 = stringBuilder.toString();
            MainActivity.dataServer = stringBuilder.toString();
            Main22Activity.dataServerWating = stringBuilder.toString();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

