package sam.com.findhome;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Objects;
public class Connect123 extends AsyncTask {
    public String link = "";
    public String post_content = "";
    public Connect123(String link, String post_content) {
        this.link = link;
        this.post_content = post_content;
    }
    @Override
    protected Objects doInBackground(Object[] params) {
        try {
            String senddata = URLEncoder.encode("post_content", "UTF8") + "=" + URLEncoder.encode(post_content, "UTF8");
            URL url = new URL(link);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(senddata);
            writer.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String data = null;
            while ((data = bufferedReader.readLine()) != null) {
                stringBuilder.append(data);
            }
            Main2Activity.dataServer = stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

