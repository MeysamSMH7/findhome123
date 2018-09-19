package sam.com.findhome;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Objects;


public class Connect9 extends AsyncTask {

    public String link = "";
    public String post_content = ""; //matn
    public String post_title = "";
    public String post_name = ""; //need transletor
    public String barchasb_zamine = "";
    public Integer IdPost = 0;

    public String noe_melk_moamele = ""; //noe_melk_moamele";
    //// field_5a8fdad301cc8
    public String noe_melk = ""; //noe_melk";
    //// field_5a8fdb67dcf20
    public String moshakhasat_asli_melk_karbari_now = ""; //moshakhasat_asli_melk_karbari_now";
    //// field_5a907006c302c
    public String moshakhasat_asli_melk_masahat_zamin_after_eslahie = ""; //moshakhasat_asli_melk_masahat_zamin_after_eslahie";
    //// field_5a907087c302d
    public String moshakhasat_asli_melk_tol_bar_asli = ""; //moshakhasat_asli_melk_tol_bar_asli";
    //// field_5a906ebb1555a
    public String moshakhasat_asli_melk_number_bar = ""; //moshakhasat_asli_melk_number_bar";
    //// field_5a906e5b15559
    public String moshakhasat_asli_melk_vaziita_build_vazita_zamin = ""; //moshakhasat_asli_melk_vaziita_build_vazita_zamin";
    //// field_5a9072a3b1c10
    public String more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check = ""; //more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check";
    //// field_5a92e486f50ae
    public String more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit = ""; //more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit";
    //// field_5a92e5cdf50af
    public String more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin = ""; //more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin";
    //// field_5a92e661f50b5
    public String more_joziat_melk_edari_tejari_dastresi_dastres_edit = ""; //more_joziat_melk_edari_tejari_dastresi_dastres_edit";
    //// field_5a92dbc8201f8
    public String more_joziat_melk_edari_tejari_ghozar_asli = ""; //more_joziat_melk_edari_tejari_ghozar_asli";
    //// field_5a92dcda201fe
    public String more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin = ""; //more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin";
    //// field_5a92e628f50b3
    public String more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = ""; //more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat";
    //// field_5a91a80fdeca3
    public String more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = ""; //more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat";
    //// field_5a91a897deca4
    public String more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = ""; //more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam";
    //// field_5a91a963deca5
    public String NameFamilyST = "";
    public String MahaleLiveST = "";
    public String EmailST = "";
    public String PhoneNumberST = "";
    public String stIDimage_1 = "";    //     stIDimage_1 advdsa
    public String stIDimage_2 = "";    //     stIDimage_2 advdsa
    public String stIDimage_3 = "";    //     stIDimage_3 advdsa
    public String stIDimage_4 = "";    //     stIDimage_4 advdsa
    public String stIDimage_5 = "";    //     stIDimage_5 advdsa
    public String stIDimage_6 = "";    //     stIDimage_6 advdsa
    public String stIDimage_7 = "";    //     stIDimage_7 advdsa
    public String stIDimage_8 = "";    //     stIDimage_8 advdsa
    public String stIDimage_9 = "";    //     stIDimage_9 advdsa
    public String stIDimage_10 = "";    //     stIDimage_10 advdsa

    public String finalstIDimage_1 = "";    //     finalstIDimage_1 advdsa
    public String finalstIDimage_2 = "";    //     finalstIDimage_2 advdsa
    public String finalstIDimage_3 = "";    //     finalstIDimage_3 advdsa
    public String finalstIDimage_4 = "";    //     finalstIDimage_4 advdsa
    public String finalstIDimage_5 = "";    //     finalstIDimage_5 advdsa
    public String finalstIDimage_6 = "";    //     finalstIDimage_6 advdsa
    public String finalstIDimage_7 = "";    //     finalstIDimage_7 advdsa
    public String finalstIDimage_8 = "";    //     finalstIDimage_8 advdsa
    public String finalstIDimage_9 = "";    //     finalstIDimage_9 advdsa
    public String finalstIDimage_10 = "";    //     finalstIDimage_10 advdsa
    public String barchasbEdit = "";


    public Connect9(String link,
                    String post_content,
                    String post_title,
                    String post_name
                    ,Integer IdPost

            , String noe_melk_moamele // noe_melk_moamele";
                    //// field_5a8fdad301cc8
            , String noe_melk // noe_melk";
                    //// field_5a8fdb67dcf20
            , String moshakhasat_asli_melk_karbari_now // moshakhasat_asli_melk_karbari_now";
                    //// field_5a907006c302c
            , String moshakhasat_asli_melk_masahat_zamin_after_eslahie // moshakhasat_asli_melk_masahat_zamin_after_eslahie";
                    //// field_5a907087c302d
            , String moshakhasat_asli_melk_tol_bar_asli // moshakhasat_asli_melk_tol_bar_asli";
                    //// field_5a906ebb1555a
            , String moshakhasat_asli_melk_number_bar // moshakhasat_asli_melk_number_bar";
                    //// field_5a906e5b15559
            , String moshakhasat_asli_melk_vaziita_build_vazita_zamin // moshakhasat_asli_melk_vaziita_build_vazita_zamin";
                    //// field_5a9072a3b1c10
            , String more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check // more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check";
                    //// field_5a92e486f50ae
            , String more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit // more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit";
                    //// field_5a92e5cdf50af
            , String more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin // more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin";
                    //// field_5a92e661f50b5
            , String more_joziat_melk_edari_tejari_dastresi_dastres_edit // more_joziat_melk_edari_tejari_dastresi_dastres_edit";
                    //// field_5a92dbc8201f8
            , String more_joziat_melk_edari_tejari_ghozar_asli // more_joziat_melk_edari_tejari_ghozar_asli";
                    //// field_5a92dcda201fe
            , String more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin // more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin";
                    //// field_5a92e628f50b3
            , String more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat";
                    //// field_5a91a80fdeca3
            , String more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat";
                    //// field_5a91a897deca4
            , String more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam // more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam";
                    //// field_5a91a963deca5

            , String NameFamilyST
            , String MahaleLiveST
            , String EmailST
            , String PhoneNumberST
            , String stIDimage_1   ///     stIDimage_1 advdsa
            , String stIDimage_2   ///     stIDimage_2 advdsa
            , String stIDimage_3   ///     stIDimage_3 advdsa
            , String stIDimage_4   ///     stIDimage_4 advdsa
            , String stIDimage_5   ///     stIDimage_5 advdsa
            , String stIDimage_6   ///     stIDimage_6 advdsa
            , String stIDimage_7   ///     stIDimage_7 advdsa
            , String stIDimage_8   ///     stIDimage_8 advdsa
            , String stIDimage_9   ///     stIDimage_9 advdsa
            , String stIDimage_10   ///     stIDimage_10 advdsa

            , String finalstIDimage_1   ///     finalstIDimage_1 advdsa
            , String finalstIDimage_2   ///     finalstIDimage_2 advdsa
            , String finalstIDimage_3   ///     finalstIDimage_3 advdsa
            , String finalstIDimage_4   ///     finalstIDimage_4 advdsa
            , String finalstIDimage_5   ///     finalstIDimage_5 advdsa
            , String finalstIDimage_6   ///     finalstIDimage_6 advdsa
            , String finalstIDimage_7   ///     finalstIDimage_7 advdsa
            , String finalstIDimage_8   ///     finalstIDimage_8 advdsa
            , String finalstIDimage_9   ///     finalstIDimage_9 advdsa
            , String finalstIDimage_10   ///     finalstIDimage_10 advdsa
            , String barchasbEdit
    ) {

        this.link = link;
        this.post_content = post_content;
        this.post_title = post_title;
        this.post_name = post_name;
        this.IdPost = IdPost;

        this.noe_melk_moamele = noe_melk_moamele;
        //// field_5a8fdad301cc8
        this.noe_melk = noe_melk;
        //// field_5a8fdb67dcf20
        this.moshakhasat_asli_melk_karbari_now = moshakhasat_asli_melk_karbari_now;
        //// field_5a907006c302c
        this.moshakhasat_asli_melk_masahat_zamin_after_eslahie = moshakhasat_asli_melk_masahat_zamin_after_eslahie;
        //// field_5a907087c302d
        this.moshakhasat_asli_melk_tol_bar_asli = moshakhasat_asli_melk_tol_bar_asli;
        //// field_5a906ebb1555a
        this.moshakhasat_asli_melk_number_bar = moshakhasat_asli_melk_number_bar;
        //// field_5a906e5b15559
        this.moshakhasat_asli_melk_vaziita_build_vazita_zamin = moshakhasat_asli_melk_vaziita_build_vazita_zamin;
        //// field_5a9072a3b1c10
        this.more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;
        //// field_5a92e486f50ae
        this.more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit;
        //// field_5a92e5cdf50af
        this.more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin = more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin;
        //// field_5a92e661f50b5
        this.more_joziat_melk_edari_tejari_dastresi_dastres_edit = more_joziat_melk_edari_tejari_dastresi_dastres_edit;
        //// field_5a92dbc8201f8
        this.more_joziat_melk_edari_tejari_ghozar_asli = more_joziat_melk_edari_tejari_ghozar_asli;
        //// field_5a92dcda201fe
        this.more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin = more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin;
        //// field_5a92e628f50b3
        this.more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
        //// field_5a91a80fdeca3
        this.more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
        //// field_5a91a897deca4
        this.more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;
        //// field_5a91a963deca5

        this.NameFamilyST = NameFamilyST;
        this.MahaleLiveST = MahaleLiveST;
        this.EmailST = EmailST;
        this.PhoneNumberST = PhoneNumberST;
        this.PhoneNumberST = PhoneNumberST;
        this.stIDimage_1 =stIDimage_1 ;
        this.stIDimage_2 =stIDimage_2 ;
        this.stIDimage_3 =stIDimage_3 ;
        this.stIDimage_4 =stIDimage_4 ;
        this.stIDimage_5 =stIDimage_5 ;
        this.stIDimage_6 =stIDimage_6 ;
        this.stIDimage_7 =stIDimage_7 ;
        this.stIDimage_8 =stIDimage_8 ;
        this.stIDimage_9 =stIDimage_9 ;
        this.stIDimage_10 =stIDimage_10 ;

        this.finalstIDimage_1 =finalstIDimage_1 ;
        this.finalstIDimage_2 =finalstIDimage_2 ;
        this.finalstIDimage_3 =finalstIDimage_3 ;
        this.finalstIDimage_4 =finalstIDimage_4 ;
        this.finalstIDimage_5 =finalstIDimage_5 ;
        this.finalstIDimage_6 =finalstIDimage_6 ;
        this.finalstIDimage_7 =finalstIDimage_7 ;
        this.finalstIDimage_8 =finalstIDimage_8 ;
        this.finalstIDimage_9 =finalstIDimage_9 ;
        this.finalstIDimage_10 =finalstIDimage_10 ;
        this.barchasbEdit = barchasbEdit;

    }


    @Override
    protected Objects doInBackground(Object[] params) {

        try {


            String senddata = URLEncoder.encode("post_content", "UTF8") + "=" + URLEncoder.encode(post_content, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("post_title", "UTF8") + "=" + URLEncoder.encode(post_title, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("post_name", "UTF8") + "=" + URLEncoder.encode(post_name, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("IdPost", "UTF8") + "=" + URLEncoder.encode(String.valueOf(IdPost), "UTF8");

            senddata = senddata + "&" + URLEncoder.encode("noe_melk_moamele", "UTF8") + "=" + URLEncoder.encode(noe_melk_moamele, "UTF8");
            //// field_5a8fdad301cc8
            senddata = senddata + "&" + URLEncoder.encode("noe_melk", "UTF8") + "=" + URLEncoder.encode(noe_melk, "UTF8");
            //// field_5a8fdb67dcf20
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_karbari_now", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_karbari_now, "UTF8");
            //// field_5a907006c302c
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_masahat_zamin_after_eslahie", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_masahat_zamin_after_eslahie, "UTF8");
            //// field_5a907087c302d
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_tol_bar_asli", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_tol_bar_asli, "UTF8");
            //// field_5a906ebb1555a
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_number_bar", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_number_bar, "UTF8");
            //// field_5a906e5b15559
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_vaziita_build_vazita_zamin", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_vaziita_build_vazita_zamin, "UTF8");
            //// field_5a9072a3b1c10
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check, "UTF8");
            //// field_5a92e486f50ae
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit, "UTF8");
            //// field_5a92e5cdf50af
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin, "UTF8");
            //// field_5a92e661f50b5
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_dastresi_dastres_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_dastresi_dastres_edit, "UTF8");
            //// field_5a92dbc8201f8
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_ghozar_asli", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_ghozar_asli, "UTF8");
            //// field_5a92dcda201fe
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin, "UTF8");
            //// field_5a92e628f50b3
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat, "UTF8");
            //// field_5a91a80fdeca3
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat, "UTF8");
            //// field_5a91a897deca4
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam, "UTF8");
            //// field_5a91a963deca5

            senddata = senddata + "&" + URLEncoder.encode("NameFamilyST", "UTF8") + "=" + URLEncoder.encode(NameFamilyST, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("MahaleLiveST", "UTF8") + "=" + URLEncoder.encode(MahaleLiveST, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("EmailST", "UTF8") + "=" + URLEncoder.encode(EmailST, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("PhoneNumberST", "UTF8") + "=" + URLEncoder.encode(PhoneNumberST, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_1", "UTF8") + "=" + URLEncoder.encode(stIDimage_1 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_2", "UTF8") + "=" + URLEncoder.encode(stIDimage_2 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_3", "UTF8") + "=" + URLEncoder.encode(stIDimage_3 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_4", "UTF8") + "=" + URLEncoder.encode(stIDimage_4 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_5", "UTF8") + "=" + URLEncoder.encode(stIDimage_5 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_6", "UTF8") + "=" + URLEncoder.encode(stIDimage_6 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_7", "UTF8") + "=" + URLEncoder.encode(stIDimage_7 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_8", "UTF8") + "=" + URLEncoder.encode(stIDimage_8 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_9", "UTF8") + "=" + URLEncoder.encode(stIDimage_9 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_10", "UTF8") + "=" + URLEncoder.encode(stIDimage_10 , "UTF8");

            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_1", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_1 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_2", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_2 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_3", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_3 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_4", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_4 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_5", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_5 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_6", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_6 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_7", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_7 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_8", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_8 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_9", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_9 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_10", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_10 , "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("barchasbEdit", "UTF8") + "=" + URLEncoder.encode(barchasbEdit, "UTF8");


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
            Main2Activity.dataServer = stringBuilder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

}

