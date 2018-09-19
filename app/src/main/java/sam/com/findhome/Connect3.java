package sam.com.findhome;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Objects;

public class Connect3 extends AsyncTask {

    public String link = "";
    public String masahatZamin = "";
    public String asahatBuild = "";
    public String priceABC = "";
    public int editTextMAXPrice_serachST = 0;
    public int editTextMINPrice_serachST = 0;
    public int editTextMAXmasahatZamin_searchST =0;
    public int editTextMINmasahatZamin_searchST =0;
    public int  editTextMAXMasahatBuild_searchST =0;
    public int  editTextMINMasahatBuild_searchST =0;

    public Connect3(String link,
                    int editTextMAXPrice_serachST,
                    int editTextMINPrice_serachST,
                    int editTextMAXmasahatZamin_searchST,
                    int editTextMINmasahatZamin_searchST,
                    int editTextMAXMasahatBuild_searchST,
                    int editTextMINMasahatBuild_searchST,
                    String masahatZamin,
                    String asahatBuild,
                    String priceABC

    ) {
        this.link = link;
        this.editTextMAXPrice_serachST = editTextMAXPrice_serachST;
        this.editTextMINPrice_serachST = editTextMINPrice_serachST;
        this.editTextMAXmasahatZamin_searchST = editTextMAXmasahatZamin_searchST;
        this.editTextMINmasahatZamin_searchST = editTextMINmasahatZamin_searchST;
        this.editTextMAXMasahatBuild_searchST = editTextMAXMasahatBuild_searchST;
        this.editTextMINMasahatBuild_searchST = editTextMINMasahatBuild_searchST;
        this.masahatZamin = masahatZamin;
        this.asahatBuild = asahatBuild;
        this.priceABC = priceABC;


    }

    @Override
    protected Objects doInBackground(Object[] params) {

        try {
            String senddata = URLEncoder.encode("editTextMAXPrice_serachST", "UTF8") + "=" + URLEncoder.encode(String.valueOf(editTextMAXPrice_serachST), "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("editTextMINPrice_serachST", "UTF8") + "=" + URLEncoder.encode(String.valueOf(editTextMINPrice_serachST), "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("editTextMAXmasahatZamin_searchST", "UTF8") + "=" + URLEncoder.encode(String.valueOf(editTextMAXmasahatZamin_searchST), "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("editTextMINmasahatZamin_searchST", "UTF8") + "=" + URLEncoder.encode(String.valueOf(editTextMINmasahatZamin_searchST), "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("editTextMAXMasahatBuild_searchST", "UTF8") + "=" + URLEncoder.encode(String.valueOf(editTextMAXMasahatBuild_searchST), "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("editTextMINMasahatBuild_searchST", "UTF8") + "=" + URLEncoder.encode(String.valueOf(editTextMINMasahatBuild_searchST), "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("masahatZamin", "UTF8") + "=" + URLEncoder.encode(masahatZamin, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("asahatBuild", "UTF8") + "=" + URLEncoder.encode(asahatBuild, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("priceABC", "UTF8") + "=" + URLEncoder.encode(priceABC, "UTF8");

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
            Main23Activity.dataServer123123 = stringBuilder.toString();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

