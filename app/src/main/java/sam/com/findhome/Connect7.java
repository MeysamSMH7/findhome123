package sam.com.findhome;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Objects;


public class Connect7 extends AsyncTask {

    public String link = "";
    public String post_content = ""; //matn
    public String post_title = "";
    public String post_name = ""; //need transletor
    public Integer IdPost = 0;

    public String noe_melk_moamele = ""; // noe_melk_moamele +
    public String noe_melk = ""; // noe_melk +
    public String moshakhasat_asli_melk_moghiita_store = ""; // moshakhasat_asli_melk_moghiita_store +
    public String moshakhasat_asli_melk_masahat_kaf = ""; // moshakhasat_asli_melk_masahat_kaf +
    public String moshakhasat_asli_melk_masahat_balkon = ""; // moshakhasat_asli_melk_masahat_balkon +
    public String moshakhasat_asli_melk_nuumber_dahane = ""; // moshakhasat_asli_melk_nuumber_dahane +
    public String moshakhasat_asli_melk_tol_bar_asli = ""; // moshakhasat_asli_melk_tol_bar_asli +
    public String moshakhasat_asli_melk_number_bar = ""; // moshakhasat_asli_melk_number_bar +
    public String moshakhasat_asli_melk_noe_vaghozari = ""; // moshakhasat_asli_melk_noe_vaghozari +
    public String more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh = ""; // more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh +
    public String more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh = ""; // more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh +
    public String more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe = ""; // more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe +
    public String more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze = ""; // more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze +
    public String more_joziat_melk_edari_tejari_wc_wc_irani = ""; // more_joziat_melk_edari_tejari_wc_wc_irani +
    public String more_joziat_melk_edari_tejari_wc_wc_us = ""; // more_joziat_melk_edari_tejari_wc_wc_us +
    public String more_joziat_melk_edari_tejari_wc_roshoii = ""; // more_joziat_melk_edari_tejari_wc_roshoii +
    public String more_joziat_melk_edari_tejari_abdarhkane_tejari = ""; // more_joziat_melk_edari_tejari_abdarhkane_tejari +
    public String more_joziat_melk_edari_tejari_fazai_asli_fazai_asli = ""; // more_joziat_melk_edari_tejari_fazai_asli_fazai_asli +
    public String more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari = ""; // more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari +
    public String more_joziat_melk_edari_tejari_kaf_kaf_check = ""; // more_joziat_melk_edari_tejari_kaf_kaf_check +
    public String more_joziat_melk_edari_tejari_kaf_kaf_edit = ""; // more_joziat_melk_edari_tejari_kaf_kaf_edit +
    public String more_joziat_melk_edari_tejari_coldhot_coldhot_check = ""; // more_joziat_melk_edari_tejari_coldhot_coldhot_check +
    public String more_joziat_melk_edari_tejari_coldhot_coldhot_edit = ""; // more_joziat_melk_edari_tejari_coldhot_coldhot_edit +
    public String more_joziat_melk_edari_tejari_refahi_refahi_check_tejari = ""; // more_joziat_melk_edari_tejari_refahi_refahi_check_tejari +
    public String more_joziat_melk_edari_tejari_refahi_refahi_edit = ""; // more_joziat_melk_edari_tejari_refahi_refahi_edit +
    public String more_joziat_melk_edari_tejari_safe_safe_check_tejari = ""; // more_joziat_melk_edari_tejari_safe_safe_check_tejari +
    public String more_joziat_melk_edari_tejari_safe_safe_edit = ""; // more_joziat_melk_edari_tejari_safe_safe_edit +
    public String more_joziat_melk_edari_tejari_dastresi_dastresi_check = ""; // more_joziat_melk_edari_tejari_dastresi_dastresi_check +
    public String more_joziat_melk_edari_tejari_dastresi_dastres_edit = ""; // more_joziat_melk_edari_tejari_dastresi_dastres_edit +
    public String more_joziat_melk_edari_tejari_ghozar_asli = ""; // more_joziat_melk_edari_tejari_ghozar_asli +
    public String more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari = ""; // more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari +
    public String more_joziat_melk_edari_tejari_tasisat_tasisat_edit = ""; // more_joziat_melk_edari_tejari_tasisat_tasisat_edit +
    public String more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = ""; // more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat +
    public String more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = ""; // more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat +
    public String more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = ""; // more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam +
    public String           NameFamilyST= "";
    public String   MahaleLiveST= "";
    public String           EmailST= "";
    public String   PhoneNumberST= "";

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

    public Connect7(String link, String post_content, String post_title, String post_name
            , Integer IdPost

            , String noe_melk_moamele // noe_melk_moamele +
            , String noe_melk // noe_melk +
            , String moshakhasat_asli_melk_moghiita_store // moshakhasat_asli_melk_moghiita_store +
            , String moshakhasat_asli_melk_masahat_kaf // moshakhasat_asli_melk_masahat_kaf +
            , String moshakhasat_asli_melk_masahat_balkon // moshakhasat_asli_melk_masahat_balkon +
            , String moshakhasat_asli_melk_nuumber_dahane // moshakhasat_asli_melk_nuumber_dahane +
            , String moshakhasat_asli_melk_tol_bar_asli // moshakhasat_asli_melk_tol_bar_asli +
            , String moshakhasat_asli_melk_number_bar // moshakhasat_asli_melk_number_bar +
            , String moshakhasat_asli_melk_noe_vaghozari // moshakhasat_asli_melk_noe_vaghozari +
            , String more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh // more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh +
            , String more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh // more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh +
            , String more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe // more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe +
            , String more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze // more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze +
            , String more_joziat_melk_edari_tejari_wc_wc_irani // more_joziat_melk_edari_tejari_wc_wc_irani +
            , String more_joziat_melk_edari_tejari_wc_wc_us // more_joziat_melk_edari_tejari_wc_wc_us +
            , String more_joziat_melk_edari_tejari_wc_roshoii // more_joziat_melk_edari_tejari_wc_roshoii +
            , String more_joziat_melk_edari_tejari_abdarhkane_tejari // more_joziat_melk_edari_tejari_abdarhkane_tejari +
            , String more_joziat_melk_edari_tejari_fazai_asli_fazai_asli // more_joziat_melk_edari_tejari_fazai_asli_fazai_asli +
            , String more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari // more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari +
            , String more_joziat_melk_edari_tejari_kaf_kaf_check // more_joziat_melk_edari_tejari_kaf_kaf_check +
            , String more_joziat_melk_edari_tejari_kaf_kaf_edit // more_joziat_melk_edari_tejari_kaf_kaf_edit +
            , String more_joziat_melk_edari_tejari_coldhot_coldhot_check // more_joziat_melk_edari_tejari_coldhot_coldhot_check +
            , String more_joziat_melk_edari_tejari_coldhot_coldhot_edit // more_joziat_melk_edari_tejari_coldhot_coldhot_edit +
            , String more_joziat_melk_edari_tejari_refahi_refahi_check_tejari // more_joziat_melk_edari_tejari_refahi_refahi_check_tejari +
            , String more_joziat_melk_edari_tejari_refahi_refahi_edit // more_joziat_melk_edari_tejari_refahi_refahi_edit +
            , String more_joziat_melk_edari_tejari_safe_safe_check_tejari // more_joziat_melk_edari_tejari_safe_safe_check_tejari +
            , String more_joziat_melk_edari_tejari_safe_safe_edit // more_joziat_melk_edari_tejari_safe_safe_edit +
            , String more_joziat_melk_edari_tejari_dastresi_dastresi_check // more_joziat_melk_edari_tejari_dastresi_dastresi_check +
            , String more_joziat_melk_edari_tejari_dastresi_dastres_edit // more_joziat_melk_edari_tejari_dastresi_dastres_edit +
            , String more_joziat_melk_edari_tejari_ghozar_asli // more_joziat_melk_edari_tejari_ghozar_asli +
            , String more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari // more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari +
            , String more_joziat_melk_edari_tejari_tasisat_tasisat_edit // more_joziat_melk_edari_tejari_tasisat_tasisat_edit +
            , String more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat +
            , String more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat +
            , String more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam // more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam +
            , String   NameFamilyST
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


        this.noe_melk_moamele = noe_melk_moamele ;
        this.noe_melk = noe_melk ;
        this.moshakhasat_asli_melk_moghiita_store = moshakhasat_asli_melk_moghiita_store ;
        this.moshakhasat_asli_melk_masahat_kaf = moshakhasat_asli_melk_masahat_kaf ;
        this.moshakhasat_asli_melk_masahat_balkon = moshakhasat_asli_melk_masahat_balkon ;
        this.moshakhasat_asli_melk_nuumber_dahane = moshakhasat_asli_melk_nuumber_dahane ;
        this.moshakhasat_asli_melk_tol_bar_asli = moshakhasat_asli_melk_tol_bar_asli ;
        this.moshakhasat_asli_melk_number_bar = moshakhasat_asli_melk_number_bar ;
        this.moshakhasat_asli_melk_noe_vaghozari = moshakhasat_asli_melk_noe_vaghozari ;
        this.more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh = more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh ;
        this.more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh = more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh ;
        this.more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe = more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe ;
        this.more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze = more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze ;
        this.more_joziat_melk_edari_tejari_wc_wc_irani = more_joziat_melk_edari_tejari_wc_wc_irani ;
        this.more_joziat_melk_edari_tejari_wc_wc_us = more_joziat_melk_edari_tejari_wc_wc_us ;
        this.more_joziat_melk_edari_tejari_wc_roshoii = more_joziat_melk_edari_tejari_wc_roshoii ;
        this.more_joziat_melk_edari_tejari_abdarhkane_tejari = more_joziat_melk_edari_tejari_abdarhkane_tejari ;
        this.more_joziat_melk_edari_tejari_fazai_asli_fazai_asli = more_joziat_melk_edari_tejari_fazai_asli_fazai_asli ;
        this.more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari = more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari ;
        this.more_joziat_melk_edari_tejari_kaf_kaf_check = more_joziat_melk_edari_tejari_kaf_kaf_check ;
        this.more_joziat_melk_edari_tejari_kaf_kaf_edit = more_joziat_melk_edari_tejari_kaf_kaf_edit ;
        this.more_joziat_melk_edari_tejari_coldhot_coldhot_check = more_joziat_melk_edari_tejari_coldhot_coldhot_check ;
        this.more_joziat_melk_edari_tejari_coldhot_coldhot_edit = more_joziat_melk_edari_tejari_coldhot_coldhot_edit ;
        this.more_joziat_melk_edari_tejari_refahi_refahi_check_tejari = more_joziat_melk_edari_tejari_refahi_refahi_check_tejari ;
        this.more_joziat_melk_edari_tejari_refahi_refahi_edit = more_joziat_melk_edari_tejari_refahi_refahi_edit ;
        this.more_joziat_melk_edari_tejari_safe_safe_check_tejari = more_joziat_melk_edari_tejari_safe_safe_check_tejari ;
        this.more_joziat_melk_edari_tejari_safe_safe_edit = more_joziat_melk_edari_tejari_safe_safe_edit ;
        this.more_joziat_melk_edari_tejari_dastresi_dastresi_check = more_joziat_melk_edari_tejari_dastresi_dastresi_check ;
        this.more_joziat_melk_edari_tejari_dastresi_dastres_edit = more_joziat_melk_edari_tejari_dastresi_dastres_edit ;
        this.more_joziat_melk_edari_tejari_ghozar_asli = more_joziat_melk_edari_tejari_ghozar_asli ;
        this.more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari = more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari ;
        this.more_joziat_melk_edari_tejari_tasisat_tasisat_edit = more_joziat_melk_edari_tejari_tasisat_tasisat_edit ;
        this.more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat ;
        this.more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat ;
        this.more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam ;
        this.NameFamilyST = NameFamilyST;
        this.MahaleLiveST=MahaleLiveST;
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
            senddata = senddata + "&" + URLEncoder.encode("IdPost", "UTF8") + "=" + URLEncoder.encode(String.valueOf(IdPost), "UTF8");

            senddata = senddata + "&" + URLEncoder.encode("noe_melk_moamele", "UTF8") + "=" + URLEncoder.encode(noe_melk_moamele, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("noe_melk", "UTF8") + "=" + URLEncoder.encode(noe_melk, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_moghiita_store", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_moghiita_store, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_masahat_kaf", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_masahat_kaf, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_masahat_balkon", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_masahat_balkon, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_nuumber_dahane", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_nuumber_dahane, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_tol_bar_asli", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_tol_bar_asli, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_number_bar", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_number_bar, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_noe_vaghozari", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_noe_vaghozari, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_wc_wc_irani", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_wc_wc_irani, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_wc_wc_us", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_wc_wc_us, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_wc_roshoii", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_wc_roshoii, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_abdarhkane_tejari", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_abdarhkane_tejari, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_fazai_asli_fazai_asli", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_fazai_asli_fazai_asli, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_kaf_kaf_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_kaf_kaf_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_kaf_kaf_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_kaf_kaf_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_coldhot_coldhot_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_coldhot_coldhot_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_coldhot_coldhot_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_coldhot_coldhot_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_refahi_refahi_check_tejari", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_refahi_refahi_check_tejari, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_refahi_refahi_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_refahi_refahi_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_safe_safe_check_tejari", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_safe_safe_check_tejari, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_safe_safe_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_safe_safe_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_dastresi_dastresi_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_dastresi_dastresi_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_dastresi_dastres_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_dastresi_dastres_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_ghozar_asli", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_ghozar_asli, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_tasisat_tasisat_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_tasisat_tasisat_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam, "UTF8");
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

