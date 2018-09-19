package sam.com.findhome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//import com.squareup.picasso.Picasso;

public class Main24Activity extends AppCompatActivity {

    public static String dataServer23 = "";
    public static String dataServer234 = "";
    JSONObject jsonObject = null;
    JSONArray jsonArray = null;
    JSONArray jsonArrayEDARI = null;
    int ID_send = 0;

    ListView listView_ShowPost;
    Button button;

    String noe_MELK_android123 = "";
    TextView textViewShowPostS;
    String matnInTextView = "matnPishfarz\n";

    int ID = 0; //ID a;

    int _ID;
    String _content;
    String _title;
    String _guid11;

    String _moshakhasat_asli_melk_karbari_now = ""; //_moshakhasat_asli_melk_karbari_now a;
    String _moshakhasat_asli_melk_masahat_zamin_after_eslahie = ""; //_moshakhasat_asli_melk_masahat_zamin_after_eslahie a;
    String _moshakhasat_asli_melk_vaziita_build_vazita_zamin = ""; //_moshakhasat_asli_melk_vaziita_build_vazita_zamin a;
    String _more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin = ""; //_more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin a;
    String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin = ""; //_more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin a;
    String _moshakhasat_asli_melk_noe_bana_mostagh = ""; //_moshakhasat_asli_melk_noe_bana_mostagh");
    String _moshakhasat_asli_melk_mosahat_kol_banai_build = ""; //_moshakhasat_asli_melk_mosahat_kol_banai_build");
    String _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check = ""; //_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check");
    String _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit = ""; //_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit");
    String _more_joziat_melk_edari_tejari_refahi_refahi_check_mosta = ""; //_more_joziat_melk_edari_tejari_refahi_refahi_check_mosta");
    String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta = ""; //_more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta");
    String _moshakhasat_asli_melk_moghiita_store = ""; //_moshakhasat_asli_melk_moghiita_store");
    String _moshakhasat_asli_melk_masahat_kaf = ""; //_moshakhasat_asli_melk_masahat_kaf");
    String _moshakhasat_asli_melk_masahat_balkon = ""; //_moshakhasat_asli_melk_masahat_balkon");
    String _moshakhasat_asli_melk_nuumber_dahane = ""; //_moshakhasat_asli_melk_nuumber_dahane");
    String _moshakhasat_asli_melk_tol_bar_asli = ""; //_moshakhasat_asli_melk_tol_bar_asli");
    String _moshakhasat_asli_melk_number_bar = ""; //_moshakhasat_asli_melk_number_bar");
    String _moshakhasat_asli_melk_noe_vaghozari = ""; //_moshakhasat_asli_melk_noe_vaghozari");
    String _more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh = ""; //_more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh");
    String _more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh = ""; //_more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh");
    String _more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe = ""; //_more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe");
    String _more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze = ""; //_more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze");
    String _more_joziat_melk_edari_tejari_wc_roshoii = ""; //_more_joziat_melk_edari_tejari_wc_roshoii");
    String _more_joziat_melk_edari_tejari_abdarhkane_tejari = ""; //_more_joziat_melk_edari_tejari_abdarhkane_tejari");
    String _more_joziat_melk_edari_tejari_fazai_asli_fazai_asli = ""; //_more_joziat_melk_edari_tejari_fazai_asli_fazai_asli");
    String _more_joziat_melk_edari_tejari_refahi_refahi_check_tejari = ""; //_more_joziat_melk_edari_tejari_refahi_refahi_check_tejari");
    String _more_joziat_melk_edari_tejari_safe_safe_check_tejari = ""; //_more_joziat_melk_edari_tejari_safe_safe_check_tejari");
    String _more_joziat_melk_edari_tejari_dastresi_dastresi_check = ""; //_more_joziat_melk_edari_tejari_dastresi_dastresi_check");
    String _more_joziat_melk_edari_tejari_dastresi_dastres_edit = ""; //_more_joziat_melk_edari_tejari_dastresi_dastres_edit");
    String _more_joziat_melk_edari_tejari_ghozar_asli = ""; //_more_joziat_melk_edari_tejari_ghozar_asli");
    String _more_joziat_melk_edari_tejari_refahi_refahi_check_edari = ""; // _more_joziat_melk_edari_tejari_refahi_refahi_check_edari");
    String _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari = ""; // _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari");
    String _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta = ""; // _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta");
    String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari = ""; // _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari");
    String _moshakhasat_asli_melk_vaziita_build_rebuild = ""; // _moshakhasat_asli_melk_vaziita_build_rebuild");
    String _moshakhasat_asli_melk_moghiat_build = ""; // _moshakhasat_asli_melk_moghiat_build");
    String _noe_melk_moamele = ""; //_noe_melk_moamele");
    String _noe_melk = ""; //_noe_melk");
    String _moshakhasat_asli_melk_noe_bana = ""; //_moshakhasat_asli_melk_noe_bana");
    String _moshakhasat_asli_melk_masahat_build = ""; //_moshakhasat_asli_melk_masahat_build");
    String _moshakhasat_asli_melk_masahat_zamin = ""; //_moshakhasat_asli_melk_masahat_zamin");
    String _moshakhasat_asli_melk_number_room = ""; //_moshakhasat_asli_melk_number_room");
    String _moshakhasat_asli_melk_number_parking = ""; //_moshakhasat_asli_melk_number_parking");
    String _moshakhasat_asli_melk_sale_build = ""; //_moshakhasat_asli_melk_sale_build");
    String _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = ""; //_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio");
    String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = ""; //_moshakhasat_asli_melk_vaziita_build_ghabel_sokonat");
    String _price_shrayet_sell_cheng_check_seel_cheng = ""; //_price_shrayet_sell_cheng_check_seel_cheng");
    String _price_shrayet_sell_cheng_max_money = ""; //_price_shrayet_sell_cheng_max_money");
    String _price_shrayet_sell_cheng_money_pish_pay = ""; //_price_shrayet_sell_cheng_money_pish_pay");
    String _price_shrayet_sell_cheng_time_tahvil = ""; //_price_shrayet_sell_cheng_time_tahvil");
    String _price_shrayet_sell_cheng_mizan_anjam_shode = ""; //_price_shrayet_sell_cheng_mizan_anjam_shode");
    String _price_shrayet_sell_cheng_mizan_vam = ""; //_price_shrayet_sell_cheng_mizan_vam");
    String _price_shrayet_sell_cheng_sod_vam = ""; //_price_shrayet_sell_cheng_sod_vam");
    String _price_shrayet_sell_cheng_number_ghest = ""; //_price_shrayet_sell_cheng_number_ghest");
    String _price_shrayet_sell_cheng_price_har_ghest = ""; //_price_shrayet_sell_cheng_price_har_ghest");
    String _price_shrayet_sell_cheng_price_rahn = ""; //_price_shrayet_sell_cheng_price_rahn");
    String _price_shrayet_rent_price_vadie = ""; //_price_shrayet_rent_price_vadie");
    String _price_shrayet_rent_price_ajare_mohiane = ""; //_price_shrayet_rent_price_ajare_mohiane");
    String _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = ""; //_more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe");
    String _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = ""; //_more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe");
    String _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = ""; //_more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe");
    String _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = ""; //_more_joziat_melk_edari_tejari_moghit_build_number_all_vahed");
    String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = ""; //_more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build");
    String _more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari = ""; //_more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari");
    String _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari = ""; //_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari");
    String _more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon = ""; //_more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon");
    String _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon = ""; //_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon");
    String _more_joziat_melk_edari_tejari_wc_wc_irani = ""; //_more_joziat_melk_edari_tejari_wc_wc_irani");
    String _more_joziat_melk_edari_tejari_wc_wc_us = ""; //_more_joziat_melk_edari_tejari_wc_wc_us");
    String _more_joziat_melk_edari_tejari_wc_bath = ""; //_more_joziat_melk_edari_tejari_wc_bath");
    String _more_joziat_melk_edari_tejari_kitchen_kitchen_check = ""; //_more_joziat_melk_edari_tejari_kitchen_kitchen_check");
    String _more_joziat_melk_edari_tejari_kitchen_kitchen_radio = ""; //_more_joziat_melk_edari_tejari_kitchen_kitchen_radio");
    String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet = ""; //_more_joziat_melk_edari_tejari_kitchen_darai_kabinet");
    String _more_joziat_melk_edari_tejari_kitchen_badane_kabinet = ""; //_more_joziat_melk_edari_tejari_kitchen_badane_kabinet");
    String _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = ""; //_more_joziat_melk_edari_tejari_kitchen_safhe_kabinet");
    String _more_joziat_melk_edari_tejari_kitchen_roye_kabinet = ""; //_more_joziat_melk_edari_tejari_kitchen_roye_kabinet");
    String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen = ""; //_more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen");
    String _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen = ""; //_more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen");
    String _more_joziat_melk_edari_tejari_neshiman_neshiman_check = ""; //_more_joziat_melk_edari_tejari_neshiman_neshiman_check");
    String _more_joziat_melk_edari_tejari_neshiman_neshiman_edit = ""; //_more_joziat_melk_edari_tejari_neshiman_neshiman_edit");
    String _more_joziat_melk_edari_tejari_shekle_build_radio = ""; //_more_joziat_melk_edari_tejari_shekle_build_radio");
    String _more_joziat_melk_edari_tejari_nama_nama_check = ""; //_more_joziat_melk_edari_tejari_nama_nama_check");
    String _more_joziat_melk_edari_tejari_nama_nama_edit = ""; //_more_joziat_melk_edari_tejari_nama_nama_edit");
    String _more_joziat_melk_edari_tejari_eskelet_eskelet_check = ""; //_more_joziat_melk_edari_tejari_eskelet_eskelet_check");
    String _more_joziat_melk_edari_tejari_eskelet_eskelet_edit = ""; //_more_joziat_melk_edari_tejari_eskelet_eskelet_edit");
    String _more_joziat_melk_edari_tejari_kaf_kaf_check = ""; //_more_joziat_melk_edari_tejari_kaf_kaf_check");
    String _more_joziat_melk_edari_tejari_kaf_kaf_edit = ""; //_more_joziat_melk_edari_tejari_kaf_kaf_edit");
    String _more_joziat_melk_edari_tejari_divar_divar_check = ""; //_more_joziat_melk_edari_tejari_divar_divar_check");
    String _more_joziat_melk_edari_tejari_divar_divar_edit = ""; //_more_joziat_melk_edari_tejari_divar_divar_edit");
    String _more_joziat_melk_edari_tejari_coldhot_coldhot_check = ""; //_more_joziat_melk_edari_tejari_coldhot_coldhot_check");
    String _more_joziat_melk_edari_tejari_coldhot_coldhot_edit = ""; //_more_joziat_melk_edari_tejari_coldhot_coldhot_edit");
    String _more_joziat_melk_edari_tejari_refahi_refahi_check = ""; //_more_joziat_melk_edari_tejari_refahi_refahi_check");
    String _more_joziat_melk_edari_tejari_refahi_refahi_edit = ""; //_more_joziat_melk_edari_tejari_refahi_refahi_edit");
    String _more_joziat_melk_edari_tejari_safe_safe_check = ""; //_more_joziat_melk_edari_tejari_safe_safe_check");
    String _more_joziat_melk_edari_tejari_safe_safe_edit = ""; //_more_joziat_melk_edari_tejari_safe_safe_edit");
    String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = ""; //_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta");
    String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = ""; //_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit");
    String _more_joziat_melk_edari_tejari_sport_sport_check = ""; //_more_joziat_melk_edari_tejari_sport_sport_check");
    String _more_joziat_melk_edari_tejari_sport_sport_edit = ""; //_more_joziat_melk_edari_tejari_sport_sport_edit");
    String _more_joziat_melk_edari_tejari_view_view_check = ""; //_more_joziat_melk_edari_tejari_view_view_check");
    String _more_joziat_melk_edari_tejari_view_view_edit = ""; //_more_joziat_melk_edari_tejari_view_view_edit");
    String _more_joziat_melk_edari_tejari_nor_nor_check = ""; //_more_joziat_melk_edari_tejari_nor_nor_check");
    String _more_joziat_melk_edari_tejari_tasisat_tasisat_check = ""; //_more_joziat_melk_edari_tejari_tasisat_tasisat_check");
    String _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = ""; //_more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
    String _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = ""; //_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
    String _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = ""; //_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
    String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = ""; //_more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");
    String _more_joziat_melk_edari_tejari_safe = ""; //_more_joziat_melk_edari_tejari_safe");
    String _more_joziat_melk_edari_tejari_emkanatBuild = ""; //_more_joziat_melk_edari_tejari_emkanatBuild");
    String _more_joziat_melk_edari_tejari_divar = ""; //_more_joziat_melk_edari_tejari_divar");
    String _more_joziat_melk_edari_tejari_kaf = ""; //_more_joziat_melk_edari_tejari_kaf");
    String _more_joziat_melk_edari_tejari_shekle_build_check = ""; //_more_joziat_melk_edari_tejari_shekle_build_check");
    String _more_joziat_melk_edari_tejari_moghit_build = ""; //_more_joziat_melk_edari_tejari_moghit_build");
    String _price_shrayet = ""; //_price_shrayet");
    String _price_shrayet_sell_cheng_price_all_sell_cheng = ""; //_price_shrayet_sell_cheng_price_all_sell_cheng");
    String _more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta = ""; //_more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta");
    String _more_joziat_melk_edari_tejari_kitchen_ghazakhori = ""; //_more_joziat_melk_edari_tejari_kitchen_ghazakhori");
    String _more_joziat_melk_edari_tejari_kitchen_abdarkhane = ""; //_more_joziat_melk_edari_tejari_kitchen_abdarkhane");
    String _more_joziat_melk_edari_tejari_room_asli_room_asli_check = ""; //_more_joziat_melk_edari_tejari_room_asli_room_asli_check");
    String _more_joziat_melk_edari_tejari_room_asli_room_asli_edit = ""; //_more_joziat_melk_edari_tejari_room_asli_room_asli_edit");
    String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari = ""; //_more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari");

    String _content1321 = "";
    String _barchasbEditST = "";

    String _pic_1 = "ندارد";
    String _pic_2 = "ندارد";
    String _pic_3 = "ندارد";
    String _pic_4 = "ندارد";
    String _pic_5 = "ندارد";
    String _pic_6 = "ندارد";
    String _pic_7 = "ندارد";
    String _pic_8 = "ندارد";
    String _pic_9 = "ندارد";
    String _pic_10 = "ندارد";

    ImageView imageViewShowPost_1, imageViewShowPost_2, imageViewShowPost_3, imageViewShowPost_4, imageViewShowPost_5, imageViewShowPost_6, imageViewShowPost_7, imageViewShowPost_8, imageViewShowPost_9, imageViewShowPost_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main24);


        imageViewShowPost_1 = (ImageView) findViewById(R.id.imageViewShowPost_1);
        imageViewShowPost_2 = (ImageView) findViewById(R.id.imageViewShowPost_2);
        imageViewShowPost_3 = (ImageView) findViewById(R.id.imageViewShowPost_3);
        imageViewShowPost_4 = (ImageView) findViewById(R.id.imageViewShowPost_4);
        imageViewShowPost_5 = (ImageView) findViewById(R.id.imageViewShowPost_5);
        imageViewShowPost_6 = (ImageView) findViewById(R.id.imageViewShowPost_6);
        imageViewShowPost_7 = (ImageView) findViewById(R.id.imageViewShowPost_7);
        imageViewShowPost_8 = (ImageView) findViewById(R.id.imageViewShowPost_8);
        imageViewShowPost_9 = (ImageView) findViewById(R.id.imageViewShowPost_9);
        imageViewShowPost_10 = (ImageView) findViewById(R.id.imageViewShowPost_10);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ID_send = extras.getInt("ID_send123");
        }
        Toast.makeText(Main24Activity.this, ID_send + "", Toast.LENGTH_SHORT).show();

        listView_ShowPost = (ListView) findViewById(R.id.listView_ShowPost);
        button = (Button) findViewById(R.id.button);
        textViewShowPostS = (TextView) findViewById(R.id.textViewShowPostS);

        new Connect2("http://padintarh.ir/Android/noemelkfinder.php", ID_send, "").execute();
        new Connect2("http://padintarh.ir/Android/noemelkfinder.php", ID_send, "").execute();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matnInTextView = "";

                if (noe_MELK_android123 == "") {
                    new Connect2("http://padintarh.ir/Android/noemelkfinder.php", ID_send, "").execute();
                    new Connect2("http://padintarh.ir/Android/noemelkfinder.php", ID_send, "").execute();
                    GetjsonarrayFINDER();
                }


                if (noe_MELK_android123 != "") {
                    switch (noe_MELK_android123) {

                        case "مسکونی (خانه)":
                            new Connect4("http://padintarh.ir/Android/show_postMASK.php", ID_send).execute();
                            new Connect4("http://padintarh.ir/Android/show_postMASK.php", ID_send).execute();
                            GetjsonarrayMASKONI2();
                            break;

                        case "اداری (دفترکار)":
                            new Connect4("http://padintarh.ir/Android/show_postESARI.php", ID_send).execute();
                            new Connect4("http://padintarh.ir/Android/show_postESARI.php", ID_send).execute();
                            GetjsonarrayEDARI2();
                            break;

                        case "تجاری (مغازه)":
                            new Connect4("http://padintarh.ir/Android/show_postTEJARI.php", ID_send).execute();
                            new Connect4("http://padintarh.ir/Android/show_postTEJARI.php", ID_send).execute();
                            GetjsonarrayTEJARI();
                            break;

                        case "مستفلات (کل ملک و زمین)":
                            new Connect4("http://padintarh.ir/Android/show_postMOSTA.php", ID_send).execute();
                            new Connect4("http://padintarh.ir/Android/show_postMOSTA.php", ID_send).execute();
                            GetjsonarrayMOSTA();
                            break;

                        case "زمین":
                            new Connect4("http://padintarh.ir/Android/show_postZAMIN.php", ID_send).execute();
                            new Connect4("http://padintarh.ir/Android/show_postZAMIN.php", ID_send).execute();
                            GetjsonarrayZAMIN();
                            break;
                        default:
                            Toast.makeText(Main24Activity.this, "ریدی حاجی", Toast.LENGTH_SHORT).show();

                    }

                }
                // Toast.makeText(Main24Activity.this, dataServer23 + "", Toast.LENGTH_SHORT).show();


                //  textViewShowPostS.setText(dataServer23 + "\n" + dataServer234);


            }
        });
    }

    public void GetjsonarrayFINDER() {
        try {
            String dataServer3 = dataServer23;
            jsonArray = new JSONArray(dataServer3);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                noe_MELK_android123 = jsonObject1.getString("_noe_MELK_android123");
//set again adapter!
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void GetjsonarrayMASKONI2() {

        try {

            //  String dataServer3 = dataServer234;
            JSONArray jsonArrayEDARI1123 = new JSONArray(dataServer234);


            for (int i = 0; i <= jsonArrayEDARI1123.length(); i++) {
                JSONObject jsonObject1 = jsonArrayEDARI1123.getJSONObject(i);

                _ID = jsonObject1.getInt("_ID");
                _content = jsonObject1.getString("_post_content");
                _title = jsonObject1.getString("_post_title");
                _guid11 = jsonObject1.getString("_guid11");
                _noe_melk_moamele = jsonObject1.getString("_noe_melk_moamele");
                _noe_melk = jsonObject1.getString("_noe_melk");
                _moshakhasat_asli_melk_noe_bana = jsonObject1.getString("_moshakhasat_asli_melk_noe_bana");
                _moshakhasat_asli_melk_masahat_build = jsonObject1.getString("_moshakhasat_asli_melk_masahat_build");
                _moshakhasat_asli_melk_masahat_zamin = jsonObject1.getString("_moshakhasat_asli_melk_masahat_zamin");
                _moshakhasat_asli_melk_number_room = jsonObject1.getString("_moshakhasat_asli_melk_number_room");
                _moshakhasat_asli_melk_number_parking = jsonObject1.getString("_moshakhasat_asli_melk_number_parking");
                _moshakhasat_asli_melk_sale_build = jsonObject1.getString("_moshakhasat_asli_melk_sale_build");
                _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio");
                switch (_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio) {
                    case "کلنگی":
                        _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_ghabel_sokonat");
                        break;
                    case "چند سال ساخت":
                        _moshakhasat_asli_melk_vaziita_build_rebuild = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_rebuild");
                        break;
                }
                switch (_noe_melk_moamele) {
                    case "فروش، پیش فروش، معاوضه":
                        _price_shrayet_sell_cheng_price_all_sell_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_price_all_sell_cheng");
                        _price_shrayet_sell_cheng_check_seel_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_check_seel_cheng");
                        _price_shrayet_sell_cheng_max_money = jsonObject1.getString("_price_shrayet_sell_cheng_max_money");
                        _price_shrayet_sell_cheng_money_pish_pay = jsonObject1.getString("_price_shrayet_sell_cheng_money_pish_pay");
                        _price_shrayet_sell_cheng_time_tahvil = jsonObject1.getString("_price_shrayet_sell_cheng_time_tahvil");
                        _price_shrayet_sell_cheng_mizan_anjam_shode = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_anjam_shode");
                        _price_shrayet_sell_cheng_mizan_vam = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_vam");
                        _price_shrayet_sell_cheng_sod_vam = jsonObject1.getString("_price_shrayet_sell_cheng_sod_vam");
                        _price_shrayet_sell_cheng_number_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_number_ghest");
                        _price_shrayet_sell_cheng_price_har_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_price_har_ghest");
                        _price_shrayet_sell_cheng_price_rahn = jsonObject1.getString("_price_shrayet_sell_cheng_price_rahn");
                        break;
                    case "رهن و اجاره":
                        _price_shrayet_rent_price_vadie = jsonObject1.getString("_price_shrayet_rent_price_vadie");
                        _price_shrayet_rent_price_ajare_mohiane = jsonObject1.getString("_price_shrayet_rent_price_ajare_mohiane");
                        break;
                }
                _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe");
                _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe");
                _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe");
                _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_all_vahed");
                _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build");
                _more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari");
                _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari");
                _more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon");
                _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon");
                _more_joziat_melk_edari_tejari_wc_wc_irani = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_wc_irani");
                _more_joziat_melk_edari_tejari_wc_wc_us = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_wc_us");
                _more_joziat_melk_edari_tejari_wc_bath = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_bath");
                _more_joziat_melk_edari_tejari_kitchen_kitchen_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_kitchen_check");
                _more_joziat_melk_edari_tejari_kitchen_kitchen_radio = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_kitchen_radio");
                _more_joziat_melk_edari_tejari_kitchen_darai_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_darai_kabinet");
                _more_joziat_melk_edari_tejari_kitchen_badane_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_badane_kabinet");
                _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_safhe_kabinet");
                _more_joziat_melk_edari_tejari_kitchen_roye_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_roye_kabinet");
                _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen");
                _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen");
                _more_joziat_melk_edari_tejari_neshiman_neshiman_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_neshiman_neshiman_check");
                _more_joziat_melk_edari_tejari_neshiman_neshiman_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_neshiman_neshiman_edit");
                _more_joziat_melk_edari_tejari_shekle_build_radio = jsonObject1.getString("_more_joziat_melk_edari_tejari_shekle_build_radio");
                _more_joziat_melk_edari_tejari_nama_nama_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_check");
                _more_joziat_melk_edari_tejari_nama_nama_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_edit");
                _more_joziat_melk_edari_tejari_eskelet_eskelet_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_eskelet_eskelet_check");
                _more_joziat_melk_edari_tejari_eskelet_eskelet_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_eskelet_eskelet_edit");
                _more_joziat_melk_edari_tejari_kaf_kaf_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf_kaf_check");
                _more_joziat_melk_edari_tejari_kaf_kaf_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf_kaf_edit");
                _more_joziat_melk_edari_tejari_divar_divar_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar_divar_check");
                _more_joziat_melk_edari_tejari_divar_divar_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar_divar_edit");
                _more_joziat_melk_edari_tejari_coldhot_coldhot_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_check");
                _more_joziat_melk_edari_tejari_coldhot_coldhot_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_edit");
                _more_joziat_melk_edari_tejari_refahi_refahi_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_check");
                _more_joziat_melk_edari_tejari_refahi_refahi_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_edit");
                _more_joziat_melk_edari_tejari_safe_safe_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_check");
                _more_joziat_melk_edari_tejari_safe_safe_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_edit");
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta");
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit");
                _more_joziat_melk_edari_tejari_sport_sport_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_sport_sport_check");
                _more_joziat_melk_edari_tejari_sport_sport_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_sport_sport_edit");
                _more_joziat_melk_edari_tejari_view_view_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_view_view_check");
                _more_joziat_melk_edari_tejari_view_view_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_view_view_edit");
                _more_joziat_melk_edari_tejari_nor_nor_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_nor_nor_check");
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_check");
                _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");
                _barchasbEditST = jsonObject1.getString("_barchasbEditST");
                _pic_1 = jsonObject1.getString("_pic_1");
                _pic_2 = jsonObject1.getString("_pic_2");
                _pic_3 = jsonObject1.getString("_pic_3");
                _pic_4 = jsonObject1.getString("_pic_4");
                _pic_5 = jsonObject1.getString("_pic_5");
                _pic_6 = jsonObject1.getString("_pic_6");
                _pic_7 = jsonObject1.getString("_pic_7");
                _pic_8 = jsonObject1.getString("_pic_8");
                _pic_9 = jsonObject1.getString("_pic_9");
                _pic_10 = jsonObject1.getString("_pic_10");

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        matnInTextView = _noe_melk_moamele;
        matnInTextView = matnInTextView + "\n" + _noe_melk;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_noe_bana;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_masahat_build;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_masahat_zamin;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_number_room;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_number_parking;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_sale_build;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio;


        switch (_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio) {
            case "کلنگی":
                String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1 = "";
                String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat2 = "";
                String str2 = _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat;
                if (str2 != "ندارد") {
                    String[] splited = str2.split("\"");
                    for (int i = 1; i < splited.length; i++) {
                        _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1 = _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1 + " " + splited[i];
                    }
                    String aaa = "";
                    splited = _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1.split(",");
                    for (int ai = 0; ai < splited.length; ai++) {
                        aaa = aaa + "\n" + splited[ai];
                        aaa = aaa.replace("[", "");
                    }
                    String b = "کلنگی", a;
                    for (int ai = 0; ai < splited.length; ai++) {
                        a = splited[ai];
                        Boolean found = a.contains("بازسازی شده");
                        if (found == true) {
                            matnInTextView = matnInTextView + "\n" + "بازسازی شده";
                        }
                        Boolean found2 = a.contains("قابل سکونت");
                        if (found2 == true) {
                            matnInTextView = matnInTextView + "\n" + "قابل سکونت";
                        }

                    }
                }

                //   matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat;
                break;
            case "چند سال ساخت":
                String _moshakhasat_asli_melk_vaziita_build_rebuild1 = "";
                String _moshakhasat_asli_melk_vaziita_build_rebuild2 = "";
                String str21 = _moshakhasat_asli_melk_vaziita_build_rebuild;
                if (str21 != "ندارد") {
                    String[] splited = str21.split("\"");
                    for (int i = 1; i < splited.length; i++) {
                        _moshakhasat_asli_melk_vaziita_build_rebuild1 = _moshakhasat_asli_melk_vaziita_build_rebuild1 + " " + splited[i];
                    }
                    String aaa = "";
                    splited = _moshakhasat_asli_melk_vaziita_build_rebuild1.split(",");
                    for (int ai = 0; ai < splited.length; ai++) {
                        aaa = aaa + "\n" + splited[ai];
                        aaa = aaa.replace("[", "");
                    }
                    String b = "چندسال ساخت: ", a;
                    for (int ai = 0; ai < splited.length; ai++) {
                        a = splited[ai];
                        Boolean found = a.contains("بازسازی شده");
                        if (found == true) {
                            matnInTextView = matnInTextView + "\n" + "بازسازی شده";
                        }


                    }
                }

                //  matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_vaziita_build_rebuild;
                break;
        }


        switch (_noe_melk_moamele) {
            case "فروش، پیش فروش، معاوضه":
                matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_all_sell_cheng;

                String _price_shrayet_sell_cheng_check_seel_cheng1 = "";
                String _price_shrayet_sell_cheng_check_seel_cheng2 = "";
                String str2 = _price_shrayet_sell_cheng_check_seel_cheng;
                if (str2 != "ندارد") {
                    String[] splited = str2.split("\"");
                    for (int i = 1; i < splited.length; i++) {
                        _price_shrayet_sell_cheng_check_seel_cheng1 = _price_shrayet_sell_cheng_check_seel_cheng1 + " " + splited[i];
                    }
                    String aaa = "";
                    splited = _price_shrayet_sell_cheng_check_seel_cheng1.split(",");
                    for (int ai = 0; ai < splited.length; ai++) {
                        aaa = aaa + "\n" + splited[ai];
                        aaa = aaa.replace("[", "");
                    }
                    String b = "شرایط معامله: ", a;
                    for (int ai = 0; ai < splited.length; ai++) {
                        a = splited[ai];
                        Boolean found = a.contains("معاوضه");
                        if (found == true) {
                            matnInTextView = matnInTextView + "\n" + "معاوضه دارد";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_max_money;
                        }
                        Boolean found2 = a.contains("پیش فروش");
                        if (found2 == true) {
                            matnInTextView = matnInTextView + "\n" + "پیش فروش";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_money_pish_pay;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_time_tahvil;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_mizan_anjam_shode;
                        }
                        Boolean found3 = a.contains("دارای وام");
                        if (found3 == true) {
                            matnInTextView = matnInTextView + "\n" + "دارای وام";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_mizan_vam;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_sod_vam;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_number_ghest;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_har_ghest;


                        }
                        Boolean found4 = a.contains("فروش با مستاجر");
                        if (found4 == true) {
                            matnInTextView = matnInTextView + "\n" + "فروش با مستاجر";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_rahn;

                        }
                    }
                }
                break;
            case "رهن و اجاره":
                matnInTextView = matnInTextView + "\n" + _price_shrayet_rent_price_vadie;
                matnInTextView = matnInTextView + "\n" + _price_shrayet_rent_price_ajare_mohiane;

                break;
        }


        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed;


        String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build1 = "";
        String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build2 = "";
        String str3 = _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build;
        if (str3 != "ندارد") {
            String[] splited = str3.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build1 = _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("واقع در مجتمع مسکونی");
                if (found == true) {
                    b = "واقع در مجتمع مسکونی";
                    matnInTextView = matnInTextView + "\n" + "واقع در مجتمع مسکونی";
                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_wc_wc_irani;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_wc_wc_us;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_wc_bath;


        String _more_joziat_melk_edari_tejari_kitchen_kitchen_check1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_kitchen_check2 = "";
        String str4 = _more_joziat_melk_edari_tejari_kitchen_kitchen_check;
        if (str4 != "ندارد") {
            String[] splited = str4.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_kitchen_kitchen_check1 = _more_joziat_melk_edari_tejari_kitchen_kitchen_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_kitchen_kitchen_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("دارای آشپزخانه");
                if (found == true) {
                    b = "دارای آشپزخانه";
                    matnInTextView = matnInTextView + "\n" + "دارای آشپزخانه";

                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_kitchen_kitchen_radio;


        String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet2 = "";
        String str5 = _more_joziat_melk_edari_tejari_kitchen_darai_kabinet;
        if (str5 != "ندارد") {
            String[] splited = str5.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_kitchen_darai_kabinet1 = _more_joziat_melk_edari_tejari_kitchen_darai_kabinet1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_kitchen_darai_kabinet1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("دارای کابینت");
                if (found == true) {
                    b = "دارای کابینت";
                    matnInTextView = matnInTextView + "\n" + "دارای کابینت";
                }
            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_kitchen_badane_kabinet;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_kitchen_roye_kabinet;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet;


        String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen2 = "";
        String str6 = _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen;
        if (str6 != "ندارد") {
            String[] splited = str6.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen1 = _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("دارای تجهیزات آشپزخانه");
                if (found == true) {
                    b = "دارای تجهیزات آشپزخانه";
                    matnInTextView = matnInTextView + "\n" + "دارای تجهیزات آشپزخانه";
                }
            }

        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen;

        String _more_joziat_melk_edari_tejari_eskelet_eskelet_check1 = "";
        String _more_joziat_melk_edari_tejari_eskelet_eskelet_check2 = "";
        String str9 = _more_joziat_melk_edari_tejari_eskelet_eskelet_check;
        if (str9 != "ندارد") {
            String[] splited = str9.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_eskelet_eskelet_check1 = _more_joziat_melk_edari_tejari_eskelet_eskelet_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_eskelet_eskelet_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "اسکلت ساختمان: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("بتنی");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "بتنی";
                }
                Boolean found2 = a.contains("فلزی");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "فلزی";
                }
                Boolean found3 = a.contains("آجی");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "آجی";
                }
                Boolean found4 = a.contains("چوبی");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "چوبی";
                }
            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_eskelet_eskelet_edit;


        String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1 = "";
        String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat2 = "";
        String str1 = _more_joziat_melk_edari_tejari_kaf_kaf_check;
        if (str1 != "ندارد") {
            String[] splited = str1.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1 = _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1 + " " + splited[i];
            }
            String aaa = "";
            splited = _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "وضعیت ساختمان: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("سنگ");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "سنگ";
                }
                Boolean found2 = a.contains("سرامیک");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "سرامیک";
                }
                Boolean found3 = a.contains("پارکت");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "پارکت";
                }
                Boolean found4 = a.contains("کفپوش");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "کفپوش";
                }
                Boolean found5 = a.contains("موکت");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "موکت";
                }
                Boolean found6 = a.contains("موزاییک");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "موزاییک";
                }
                Boolean found7 = a.contains("سیمان");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیمان";
                }
                Boolean found8 = a.contains("کف پله دار");
                if (found8 == true) {
                    matnInTextView = matnInTextView + "\n" + "کف پله دار";
                }
            }

        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_kaf_kaf_edit;


        String _more_joziat_melk_edari_tejari_neshiman_neshiman_check1 = "";
        String _more_joziat_melk_edari_tejari_neshiman_neshiman_check2 = "";
        String str7 = _more_joziat_melk_edari_tejari_neshiman_neshiman_check;
        if (str7 != "ندارد") {
            String[] splited = str7.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_neshiman_neshiman_check1 = _more_joziat_melk_edari_tejari_neshiman_neshiman_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_neshiman_neshiman_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "نشیمن: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("شومینه");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "شومینه";
                }
                Boolean found2 = a.contains("سقف بالای 4 متر");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "سقف بالای 4 متر";
                }
                Boolean found3 = a.contains("مبله");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "مبله";
                    matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_neshiman_neshiman_edit;


                }
            }
        }

        String _more_joziat_melk_edari_tejari_nama_nama_check1 = "";
        String _more_joziat_melk_edari_tejari_nama_nama_check2 = "";
        String str8 = _more_joziat_melk_edari_tejari_nama_nama_check;
        if (str8 != "ندارد") {
            String[] splited = str8.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_nama_nama_check1 = _more_joziat_melk_edari_tejari_nama_nama_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_nama_nama_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "نما: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("سنگ");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "سنگ";
                }
                Boolean found2 = a.contains("آجر");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "آجر";
                }
                Boolean found3 = a.contains("سیمان");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیمان";
                }
                Boolean found4 = a.contains("شیشه");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "شیشه";
                }
                Boolean found5 = a.contains("چوب");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "چوب";
                }
                Boolean found6 = a.contains("کامپوزیت");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "کامپوزیت";
                }
                Boolean found7 = a.contains("نورپردازی");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "نورپردازی";
                }
            }
        } else {
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_nama_nama_edit;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_eskelet_eskelet_edit;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_kaf_kaf_edit;

        String _more_joziat_melk_edari_tejari_divar_divar_check1 = "";
        String _more_joziat_melk_edari_tejari_divar_divar_check2 = "";
        String str12 = _more_joziat_melk_edari_tejari_divar_divar_check;
        if (str12 != "ندارد") {
            String[] splited = str12.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_divar_divar_check1 = _more_joziat_melk_edari_tejari_divar_divar_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_divar_divar_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "دیوار: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("سنگ");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "سنگ";
                }
                Boolean found9 = a.contains("رنگ");
                if (found9 == true) {
                    matnInTextView = matnInTextView + "\n" + "رنگ";
                }
                Boolean found2 = a.contains("کاشی/ سرامیک");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "کاشی/ سرامیک";
                }
                Boolean found3 = a.contains("کاغذ دیواری");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "کاغذ دیواری";
                }
                Boolean found4 = a.contains("چوب/ دیوارکوب");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "چوب/ دیوارکوب";
                }
                Boolean found5 = a.contains("سیمان");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیمان";
                }
                Boolean found6 = a.contains("گچ");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "گچ";
                }
                Boolean found7 = a.contains("آجر");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "آجر";
                }
            }

        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_divar_divar_edit;


        String _more_joziat_melk_edari_tejari_coldhot_coldhot_check1 = "";
        String _more_joziat_melk_edari_tejari_coldhot_coldhot_check2 = "";
        String str13 = _more_joziat_melk_edari_tejari_coldhot_coldhot_check;
        if (str13 != "ندارد") {
            String[] splited = str13.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_coldhot_coldhot_check1 = _more_joziat_melk_edari_tejari_coldhot_coldhot_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_coldhot_coldhot_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تجهیزات گرمایشی/سرمایشی: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("کولر");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "کولر";
                }
                Boolean found2 = a.contains("کولرگازی/ اسپلیت");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "کولرگازی/ اسپلیت";
                }
                Boolean found3 = a.contains("بخاری");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "بخاری";
                }
                Boolean found4 = a.contains("پکیج/ رادیاتور");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "پکیج/ رادیاتور";
                }
                Boolean found5 = a.contains("دیگ/ رادیاتور");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "دیگ/ رادیاتور";
                }
                Boolean found6 = a.contains("چیلر/ فن کوئل");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "چیلر/ فن کوئل";
                }
                Boolean found7 = a.contains("آبگرمکن خورشیدی");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "آبگرمکن خورشیدی";
                }
                Boolean found79 = a.contains("هواساز");
                if (found79 == true) {
                    matnInTextView = matnInTextView + "\n" + "هواساز";
                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_coldhot_coldhot_edit;


        String _more_joziat_melk_edari_tejari_refahi_refahi_check1 = "";
        String _more_joziat_melk_edari_tejari_refahi_refahi_check2 = "";
        String str14 = _more_joziat_melk_edari_tejari_refahi_refahi_check;
        if (str14 != "ندارد") {
            String[] splited = str14.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_refahi_refahi_check1 = _more_joziat_melk_edari_tejari_refahi_refahi_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_refahi_refahi_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تجهیزات رفاهی: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("آسانسور");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "آسانسور";
                }
                Boolean found2 = a.contains("درب پارکینگ ریموت دار");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "درب پارکینگ ریموت دار";
                }
                Boolean found3 = a.contains("شوتیگ زباله");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "شوتیگ زباله";
                }
                Boolean found4 = a.contains("اینترنت پرسرعت");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "اینترنت پرسرعت";
                }
                Boolean found5 = a.contains("آنتن مزکزی");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "آنتن مزکزی";
                }
                Boolean found6 = a.contains("شبکه داخلی");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "شبکه داخلی";
                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_refahi_refahi_edit;

        String _more_joziat_melk_edari_tejari_safe_safe_check1 = "";
        String _more_joziat_melk_edari_tejari_safe_safe_check2 = "";
        String str15 = _more_joziat_melk_edari_tejari_safe_safe_check;
        if (str15 != "ندارد") {
            String[] splited = str15.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_safe_safe_check1 = _more_joziat_melk_edari_tejari_safe_safe_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_safe_safe_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تجهیزات ایمنی", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("دزدگیر");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "دزدگیر";
                }
                Boolean found2 = a.contains("دوربین مداربسته");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "دوربین مداربسته";
                }
                Boolean found3 = a.contains("آیفون تصویری");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "آیفون تصویری";
                }
                Boolean found4 = a.contains("درب ضد سرقت");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "درب ضد سرقت";
                }
                Boolean found5 = a.contains("سیستم اعلام آتش");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیستم اعلام آتش";
                }
                Boolean found6 = a.contains("سیستم اطفاء حریق");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیستم اطفاء حریق";
                }
            }
        } else {
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_safe_safe_edit;


        String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1 = "";
        String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta2 = "";
        String str16 = _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;
        if (str16 != "ندارد") {
            String[] splited = str16.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1 = _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "امکانات ساختمان: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("حیاط");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "حیاط";
                }
                Boolean found2 = a.contains("حیاط خلوت");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "حیاط خلوت";
                }
                Boolean found3 = a.contains("فضای سبز");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "فضای سبز";
                }
                Boolean found4 = a.contains("سرایداری");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "سرایداری";
                }
                Boolean found5 = a.contains("نگهبانی");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "نگهبانی";
                }
                Boolean found6 = a.contains("لابی");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "لابی";
                }
                Boolean found62 = a.contains("سالن اجتماعات");
                if (found62 == true) {
                    matnInTextView = matnInTextView + "\n" + "سالن اجتماعات";
                }
                Boolean found61 = a.contains("باغ");
                if (found61 == true) {
                    matnInTextView = matnInTextView + "\n" + "باغ";
                }
                Boolean found60 = a.contains("آلاچیق");
                if (found60 == true) {
                    matnInTextView = matnInTextView + "\n" + "آلاچیق";
                }
                Boolean found69 = a.contains("آب نما");
                if (found69 == true) {
                    matnInTextView = matnInTextView + "\n" + "آب نما";
                }
                Boolean found68 = a.contains("بام سبز");
                if (found68 == true) {
                    matnInTextView = matnInTextView + "\n" + "بام سبز";
                }
                Boolean found67 = a.contains("باربیکیو");
                if (found67 == true) {
                    matnInTextView = matnInTextView + "\n" + "باربیکیو";
                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit;

        String _more_joziat_melk_edari_tejari_sport_sport_check1 = "";
        String _more_joziat_melk_edari_tejari_sport_sport_check2 = "";
        String str17 = _more_joziat_melk_edari_tejari_sport_sport_check;
        if (str17 != "ندارد") {
            String[] splited = str17.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_sport_sport_check1 = _more_joziat_melk_edari_tejari_sport_sport_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_sport_sport_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "وسایل ورزشی: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("استخر");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "استخر";
                }
                Boolean found2 = a.contains("سونا");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "سونا";
                }
                Boolean found3 = a.contains("جوزی");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "جوزی";
                }
                Boolean found4 = a.contains("بیلیارد");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "بیلیارد";
                }
                Boolean found5 = a.contains("فوتبال");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "فوتبال";
                }
                Boolean found6 = a.contains("بسکتبال");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "بسکتبال";
                }
                Boolean found61 = a.contains("والیبال");
                if (found61 == true) {
                    matnInTextView = matnInTextView + "\n" + "والیبال";
                }
                Boolean found62 = a.contains("تنیس");
                if (found62 == true) {
                    matnInTextView = matnInTextView + "\n" + "تنیس";
                }
                Boolean found63 = a.contains("پینگ پنگ");
                if (found63 == true) {
                    matnInTextView = matnInTextView + "\n" + "پینگ پنگ";
                }
                Boolean found64 = a.contains("سالن بدن سازی");
                if (found64 == true) {
                    matnInTextView = matnInTextView + "\n" + "سالن بدن سازی";
                }
                Boolean found65 = a.contains("زمین بازی کودکان");
                if (found65 == true) {
                    matnInTextView = matnInTextView + "\n" + "زمین بازی کودکان";
                }
                Boolean found66 = a.contains("اسکواش");
                if (found66 == true) {
                    matnInTextView = matnInTextView + "\n" + "اسکواش";
                }
            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_sport_sport_edit;


        String _more_joziat_melk_edari_tejari_view_view_check1 = "";
        String _more_joziat_melk_edari_tejari_view_view_check2 = "";
        String str18 = _more_joziat_melk_edari_tejari_view_view_check;
        if (str18 != "ندارد") {
            String[] splited = str18.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_view_view_check1 = _more_joziat_melk_edari_tejari_view_view_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_view_view_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "دید: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("شهر");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "شهر";
                }
                Boolean found2 = a.contains("اتوبان");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "اتوبان";
                }
                Boolean found3 = a.contains("خیابان");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "خیابان";
                }
                Boolean found4 = a.contains("کوچه");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "کوچه";
                }
                Boolean found5 = a.contains("دریا");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "دریا";
                }
                Boolean found6 = a.contains("جنگل");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "جنگل";
                }
                Boolean found7 = a.contains("کوه");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "کوه";
                }
                Boolean found71 = a.contains("باغ");
                if (found71 == true) {
                    matnInTextView = matnInTextView + "\n" + "باغ";
                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_view_view_edit;


        String _more_joziat_melk_edari_tejari_nor_nor_check1 = "";
        String _more_joziat_melk_edari_tejari_nor_nor_check2 = "";
        String str19 = _more_joziat_melk_edari_tejari_nor_nor_check;
        if (str19 != "ندارد") {
            String[] splited = str19.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_nor_nor_check1 = _more_joziat_melk_edari_tejari_nor_nor_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_nor_nor_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "نور: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("شمال");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "شمال";
                }
                Boolean found2 = a.contains("جنوب");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "جنوب";
                }
                Boolean found3 = a.contains("شرق");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "شرق";
                }
                Boolean found4 = a.contains("غرب");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "غرب";
                }
            }
        }

        String _more_joziat_melk_edari_tejari_tasisat_tasisat_check1 = "";
        String _more_joziat_melk_edari_tejari_tasisat_tasisat_check2 = "";
        String str21 = _more_joziat_melk_edari_tejari_tasisat_tasisat_check;
        if (str21 != "ندارد") {
            String[] splited = str21.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check1 = _more_joziat_melk_edari_tejari_tasisat_tasisat_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_tasisat_tasisat_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تاسیسات: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("آب شهری");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "آب شهری";
                }
                Boolean found2 = a.contains("برق");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "برق";
                }
                Boolean found3 = a.contains("گاز");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "گاز";
                }
                Boolean found4 = a.contains("ژنراتور برقی");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "ژنراتور برقی";
                }
            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;


        String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 = "";
        String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam2 = "";
        String str22 = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;
        if (str22 != "ندارد") {
            String[] splited = str22.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found2 = a.contains("سند در دست اقدام");
                if (found2 == true) {
                    b = "سند در دست اقدام";
                    matnInTextView = matnInTextView + "\n" + "سند در دست اقدام";
                }
            }
        }


//        if (_pic_1 != "ندارد") {
//            imageViewShowPost_1.setVisibility(View.VISIBLE);
//            Picasso.with(Main24Activity.this).load(_pic_1).resize(120, 140).into(imageViewShowPost_1);
//        }
//
//        if (_pic_2 != "ندارد") {
//            imageViewShowPost_2.setVisibility(View.VISIBLE);
//            Picasso.with(Main24Activity.this).load(_pic_2).resize(120, 140).into(imageViewShowPost_2);
//        }
//
//        if (_pic_3 != "ندارد") {
//            imageViewShowPost_3.setVisibility(View.VISIBLE);
//            Picasso.with(Main24Activity.this).load(_pic_3).resize(120, 140).into(imageViewShowPost_3);
//        }
//
//        if (_pic_4 != "ندارد") {
//            imageViewShowPost_4.setVisibility(View.VISIBLE);
//            Picasso.with(Main24Activity.this).load(_pic_4).resize(120, 140).into(imageViewShowPost_4);
//        }
//
//        if (_pic_5 != "ندارد") {
//            imageViewShowPost_5.setVisibility(View.VISIBLE);
//            Picasso.with(Main24Activity.this).load(_pic_5).resize(120, 140).into(imageViewShowPost_5);
//        }
//
//        if (_pic_6 != "ندارد") {
//            imageViewShowPost_6.setVisibility(View.VISIBLE);
//            Picasso.with(Main24Activity.this).load(_pic_6).resize(120, 140).into(imageViewShowPost_6);
//        }
//
//        if (_pic_7 != "ندارد") {
//            imageViewShowPost_7.setVisibility(View.VISIBLE);
//            Picasso.with(Main24Activity.this).load(_pic_7).resize(120, 140).into(imageViewShowPost_7);
//        }
//
//        if (_pic_8 != "ندارد") {
//            imageViewShowPost_8.setVisibility(View.VISIBLE);
//            Picasso.with(Main24Activity.this).load(_pic_8).resize(120, 140).into(imageViewShowPost_8);
//        }
//
//        if (_pic_9 != "ندارد") {
//            imageViewShowPost_9.setVisibility(View.VISIBLE);
//            Picasso.with(Main24Activity.this).load(_pic_9).resize(120, 140).into(imageViewShowPost_9);
//        }
//
//        if (_pic_10 != "ندارد") {
//            imageViewShowPost_10.setVisibility(View.VISIBLE);
//            Picasso.with(Main24Activity.this).load(_pic_10).resize(120, 140).into(imageViewShowPost_10);
//        }


        textViewShowPostS.setText(matnInTextView);

    }

    public void GetjsonarrayEDARI2() {

        try {

            //  String dataServer3 = dataServer234;
            JSONArray jsonArrayEDARIaaaa = new JSONArray(dataServer234);


            for (int i = 0; i <= jsonArrayEDARIaaaa.length(); i++) {
                JSONObject jsonObject1 = jsonArrayEDARIaaaa.getJSONObject(i);

                _moshakhasat_asli_melk_noe_bana = jsonObject1.getString("_moshakhasat_asli_melk_noe_bana");
// field_5a9066e8d68d1
                _moshakhasat_asli_melk_masahat_build = jsonObject1.getString("_moshakhasat_asli_melk_masahat_build");
// field_5a906759d68d4
                _moshakhasat_asli_melk_masahat_zamin = jsonObject1.getString("_moshakhasat_asli_melk_masahat_zamin");
// field_5a90678dd68d5
                _moshakhasat_asli_melk_moghiat_build = jsonObject1.getString("_moshakhasat_asli_melk_moghiat_build");
// field_5a9069584f4bd
                _moshakhasat_asli_melk_number_room = jsonObject1.getString("_moshakhasat_asli_melk_number_room");
// field_5a9067a5d68d6
                _moshakhasat_asli_melk_number_parking = jsonObject1.getString("_moshakhasat_asli_melk_number_parking");
// field_5a9067c6d68d7
                _moshakhasat_asli_melk_sale_build = jsonObject1.getString("_moshakhasat_asli_melk_sale_build");
// field_5a9067f5d68d8
                _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio");
// field_5a9069f40f95f
                switch (_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio) {
                    case "کلنگی":
                        _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_ghabel_sokonat");
                        break;
                    case "چند سال ساخت":
                        _moshakhasat_asli_melk_vaziita_build_rebuild = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_rebuild");
                        break;
                }

                switch (_noe_melk_moamele) {
                    case "فروش، پیش فروش، معاوضه":
                        _price_shrayet_sell_cheng_price_all_sell_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_price_all_sell_cheng");
                        _price_shrayet_sell_cheng_check_seel_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_check_seel_cheng");
                        _price_shrayet_sell_cheng_max_money = jsonObject1.getString("_price_shrayet_sell_cheng_max_money");
                        _price_shrayet_sell_cheng_money_pish_pay = jsonObject1.getString("_price_shrayet_sell_cheng_money_pish_pay");
                        _price_shrayet_sell_cheng_time_tahvil = jsonObject1.getString("_price_shrayet_sell_cheng_time_tahvil");
                        _price_shrayet_sell_cheng_mizan_anjam_shode = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_anjam_shode");
                        _price_shrayet_sell_cheng_mizan_vam = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_vam");
                        _price_shrayet_sell_cheng_sod_vam = jsonObject1.getString("_price_shrayet_sell_cheng_sod_vam");
                        _price_shrayet_sell_cheng_number_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_number_ghest");
                        _price_shrayet_sell_cheng_price_har_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_price_har_ghest");
                        _price_shrayet_sell_cheng_price_rahn = jsonObject1.getString("_price_shrayet_sell_cheng_price_rahn");
                        break;
                    case "رهن و اجاره":
                        _price_shrayet_rent_price_vadie = jsonObject1.getString("_price_shrayet_rent_price_vadie");
                        _price_shrayet_rent_price_ajare_mohiane = jsonObject1.getString("_price_shrayet_rent_price_ajare_mohiane");
                        break;
                }
                _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe");
// field_5a931aac66970
                _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe");
// field_5a931af766972
                _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe");
// field_5a931b0666973
                _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_all_vahed");
// field_5a931b2866974
                _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build");
// field_5a931b3866975
// a:1:{i:0;s:37:"واقع در مجتمع مسکونی";
                _more_joziat_melk_edari_tejari_wc_wc_irani = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_wc_irani");
// field_5a917d8605617
                _more_joziat_melk_edari_tejari_wc_wc_us = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_wc_us");
// field_5a917e1a05618
                _more_joziat_melk_edari_tejari_kitchen_kitchen_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_kitchen_check");
// field_5a917ec885dc2
//a:1:{i:0;s:27:"دارای آشپزخانه";
                _more_joziat_melk_edari_tejari_kitchen_kitchen_radio = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_kitchen_radio");
// field_5a917fd7ee0ba
                _more_joziat_melk_edari_tejari_kitchen_darai_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_darai_kabinet");
// field_5a9180fdfc7de
//a:1:{i:0;s:23:"دارای کابینت";
                _more_joziat_melk_edari_tejari_kitchen_badane_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_badane_kabinet");
// field_5a91825312805
                _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_safhe_kabinet");
// field_5a9182c112806
                _more_joziat_melk_edari_tejari_kitchen_roye_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_roye_kabinet");
// field_5a91832912807
                _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen");
// field_5a91836b12808
//a:1:{i:0;s:42:"دارای تجهیزات آشپزخانه";
                _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen");
// field_5a9183d86a1ca
                _more_joziat_melk_edari_tejari_kitchen_abdarkhane = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_abdarkhane");
// field_5a92d33af11d7
//a:1:{i:0;s:29:"دارای آبدارخانه";
                _more_joziat_melk_edari_tejari_kitchen_ghazakhori = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_ghazakhori");
// field_5a92d3ddf11d8
//a:1:{i:0;s:25:"دارای غذاخوری";
                _more_joziat_melk_edari_tejari_room_asli_room_asli_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_room_asli_room_asli_check");
// field_5a93d25bebc70
//2
                _more_joziat_melk_edari_tejari_room_asli_room_asli_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_room_asli_room_asli_edit");
// field_5a93d25bebc71

                _more_joziat_melk_edari_tejari_shekle_build_radio = jsonObject1.getString("_more_joziat_melk_edari_tejari_shekle_build_radio");
// field_5a9187ad2c565
                _more_joziat_melk_edari_tejari_shekle_build_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_shekle_build_check");
// field_5a9189795fb82
//a:1:{i:0;s:15:"پنت هاوس";
                _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari");
// field_5a92d451f11d9
//8
                _more_joziat_melk_edari_tejari_nama_nama_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_edit");
// field_5a9193e4c6336
                _more_joziat_melk_edari_tejari_divar_divar_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar_divar_check");
// field_5a9199ef39a1f
//8
                _more_joziat_melk_edari_tejari_divar_divar_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar_divar_edit");
// field_5a9199ef39a20
                _more_joziat_melk_edari_tejari_coldhot_coldhot_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_check");
// field_5a919a803066c
//8
                _more_joziat_melk_edari_tejari_coldhot_coldhot_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_edit");
// field_5a919a803066d
                _more_joziat_melk_edari_tejari_refahi_refahi_check_edari = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_check_edari");
// field_5a92d51bf11db
//3
                _more_joziat_melk_edari_tejari_refahi_refahi_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_edit");
// field_5a919bc32e871
                _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta");
// field_5a92d6911ad6d
//7
                _more_joziat_melk_edari_tejari_safe_safe_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_edit");
// field_5a91a3e6fb835
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari");
// field_5a92d6e91ad6e
//6
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit");
// field_5a91a4b81b42c
                _more_joziat_melk_edari_tejari_view_view_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_view_view_check");
// field_5a91a5cd934cd
//8
                _more_joziat_melk_edari_tejari_view_view_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_view_view_edit");
// field_5a91a5cd934ce
                _more_joziat_melk_edari_tejari_nor_nor_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_nor_nor_check");
// field_5a91a680934d2
//4
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari");
// field_5a92d7981ad70
//5
                _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
// field_5a91a6af934d5
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
// field_5a91a80fdeca3
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
// field_5a91a897deca4
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");
// field_5a91a963deca5
// 1

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        matnInTextView = _noe_melk_moamele;
        matnInTextView = matnInTextView + "\n" + _noe_melk;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_noe_bana;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_masahat_build;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_masahat_zamin;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_number_room;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_number_parking;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_sale_build;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio;


        switch (_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio) {
            case "کلنگی":
                String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1 = "";
                String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat2 = "";
                String str2 = _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat;
                if (str2 != "ندارد") {
                    String[] splited = str2.split("\"");
                    for (int i = 1; i < splited.length; i++) {
                        _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1 = _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1 + " " + splited[i];
                    }
                    String aaa = "";
                    splited = _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1.split(",");
                    for (int ai = 0; ai < splited.length; ai++) {
                        aaa = aaa + "\n" + splited[ai];
                        aaa = aaa.replace("[", "");
                    }
                    String b = "کلنگی", a;
                    for (int ai = 0; ai < splited.length; ai++) {
                        a = splited[ai];
                        Boolean found = a.contains("بازسازی شده");
                        if (found == true) {
                            matnInTextView = matnInTextView + "\n" + "بازسازی شده";
                        }
                        Boolean found2 = a.contains("قابل سکونت");
                        if (found2 == true) {
                            matnInTextView = matnInTextView + "\n" + "قابل سکونت";
                        }

                    }
                }

                //   matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat;
                break;
            case "چند سال ساخت":
                String _moshakhasat_asli_melk_vaziita_build_rebuild1 = "";
                String _moshakhasat_asli_melk_vaziita_build_rebuild2 = "";
                String str21 = _moshakhasat_asli_melk_vaziita_build_rebuild;
                if (str21 != "ندارد") {
                    String[] splited = str21.split("\"");
                    for (int i = 1; i < splited.length; i++) {
                        _moshakhasat_asli_melk_vaziita_build_rebuild1 = _moshakhasat_asli_melk_vaziita_build_rebuild1 + " " + splited[i];
                    }
                    String aaa = "";
                    splited = _moshakhasat_asli_melk_vaziita_build_rebuild1.split(",");
                    for (int ai = 0; ai < splited.length; ai++) {
                        aaa = aaa + "\n" + splited[ai];
                        aaa = aaa.replace("[", "");
                    }
                    String b = "چندسال ساخت: ", a;
                    for (int ai = 0; ai < splited.length; ai++) {
                        a = splited[ai];
                        Boolean found = a.contains("بازسازی شده");
                        if (found == true) {
                            matnInTextView = matnInTextView + "\n" + "بازسازی شده";
                        }


                    }
                }

                //  matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_vaziita_build_rebuild;
                break;
        }


        switch (_noe_melk_moamele) {
            case "فروش، پیش فروش، معاوضه":
                matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_all_sell_cheng;

                String _price_shrayet_sell_cheng_check_seel_cheng1 = "";
                String _price_shrayet_sell_cheng_check_seel_cheng2 = "";
                String str2 = _price_shrayet_sell_cheng_check_seel_cheng;
                if (str2 != "ندارد") {
                    String[] splited = str2.split("\"");
                    for (int i = 1; i < splited.length; i++) {
                        _price_shrayet_sell_cheng_check_seel_cheng1 = _price_shrayet_sell_cheng_check_seel_cheng1 + " " + splited[i];
                    }
                    String aaa = "";
                    splited = _price_shrayet_sell_cheng_check_seel_cheng1.split(",");
                    for (int ai = 0; ai < splited.length; ai++) {
                        aaa = aaa + "\n" + splited[ai];
                        aaa = aaa.replace("[", "");
                    }
                    String b = "شرایط معامله: ", a;
                    for (int ai = 0; ai < splited.length; ai++) {
                        a = splited[ai];
                        Boolean found = a.contains("معاوضه");
                        if (found == true) {
                            matnInTextView = matnInTextView + "\n" + "معاوضه دارد";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_max_money;
                        }
                        Boolean found2 = a.contains("پیش فروش");
                        if (found2 == true) {
                            matnInTextView = matnInTextView + "\n" + "پیش فروش";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_money_pish_pay;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_time_tahvil;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_mizan_anjam_shode;
                        }
                        Boolean found3 = a.contains("دارای وام");
                        if (found3 == true) {
                            matnInTextView = matnInTextView + "\n" + "دارای وام";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_mizan_vam;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_sod_vam;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_number_ghest;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_har_ghest;


                        }
                        Boolean found4 = a.contains("فروش با مستاجر");
                        if (found4 == true) {
                            matnInTextView = matnInTextView + "\n" + "فروش با مستاجر";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_rahn;

                        }
                    }
                }
                break;
            case "رهن و اجاره":
                matnInTextView = matnInTextView + "\n" + _price_shrayet_rent_price_vadie;
                matnInTextView = matnInTextView + "\n" + _price_shrayet_rent_price_ajare_mohiane;

                break;
        }


        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed;


        String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build1 = "";
        String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build2 = "";
        String str3 = _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build;
        if (str3 != "ندارد") {
            String[] splited = str3.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build1 = _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("واقع در مجتمع مسکونی");
                if (found == true) {
                    b = "واقع در مجتمع مسکونی";
                    matnInTextView = matnInTextView + "\n" + "واقع در مجتمع مسکونی";
                }
            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_wc_wc_irani;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_wc_wc_us;


        String _more_joziat_melk_edari_tejari_kitchen_kitchen_check1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_kitchen_check2 = "";
        String str4 = _more_joziat_melk_edari_tejari_kitchen_kitchen_check;
        if (str4 != "ندارد") {
            String[] splited = str4.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_kitchen_kitchen_check1 = _more_joziat_melk_edari_tejari_kitchen_kitchen_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_kitchen_kitchen_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("دارای آشپزخانه");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "دارای آشپزخانه";
                }
            }
        } else {
        }


        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_kitchen_kitchen_radio;

        String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet2 = "";
        String str5 = _more_joziat_melk_edari_tejari_kitchen_darai_kabinet;
        if (str5 != "ندارد") {
            String[] splited = str5.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_kitchen_darai_kabinet1 = _more_joziat_melk_edari_tejari_kitchen_darai_kabinet1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_kitchen_darai_kabinet1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("دارای کابینت");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "دارای کابینت";
                }
            }
        } else {
        }


        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_kitchen_badane_kabinet;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_kitchen_roye_kabinet;


        String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen2 = "";
        String str6 = _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen;
        if (str6 != "ندارد") {
            String[] splited = str6.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen1 = _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("دارای تجهیزات آشپزخانه");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "دارای تجهیزات آشپزخانه";
                }
            }
        } else {
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen;


        String _more_joziat_melk_edari_tejari_kitchen_abdarkhane1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_abdarkhane2 = "";
        String str61 = _more_joziat_melk_edari_tejari_kitchen_abdarkhane;
        if (str61 != "ندارد") {
            String[] splited = str61.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_kitchen_abdarkhane1 = _more_joziat_melk_edari_tejari_kitchen_abdarkhane1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_kitchen_abdarkhane1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("دارای آبدارخانه");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "دارای آبدارخانه";
                }
            }
        } else {
        }


        String _more_joziat_melk_edari_tejari_kitchen_ghazakhori1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_ghazakhori2 = "";
        String str612 = _more_joziat_melk_edari_tejari_kitchen_ghazakhori;
        if (str612 != "ندارد") {
            String[] splited = str612.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_kitchen_ghazakhori1 = _more_joziat_melk_edari_tejari_kitchen_ghazakhori1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_kitchen_abdarkhane1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("دارای غذاخوری");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "دارای غذاخوری";
                }
            }
        } else {
        }


        String _more_joziat_melk_edari_tejari_room_asli_room_asli_check1 = "";
        String _more_joziat_melk_edari_tejari_room_asli_room_asli_check2 = "";
        String str7 = _more_joziat_melk_edari_tejari_room_asli_room_asli_check;
        if (str7 != "ندارد") {
            String[] splited = str7.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_room_asli_room_asli_check1 = _more_joziat_melk_edari_tejari_room_asli_room_asli_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_room_asli_room_asli_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "نشیمن: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];

                Boolean found2 = a.contains("سقف بالای 4 متر");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "سقف بالای 4 متر";
                }
                Boolean found3 = a.contains("مبله");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "مبله";
                }
            }
        } else {
        }


        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_room_asli_room_asli_edit;


        String _more_joziat_melk_edari_tejari_shekle_build_check1 = "";
        String _more_joziat_melk_edari_tejari_shekle_build_check2 = "";
        String str71 = _more_joziat_melk_edari_tejari_shekle_build_check;
        if (str71 != "ندارد") {
            String[] splited = str71.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_room_asli_room_asli_check1 = _more_joziat_melk_edari_tejari_room_asli_room_asli_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_room_asli_room_asli_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "نشیمن: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                matnInTextView = matnInTextView + "\n" + a;

            }
        } else {
        }


        String _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari1 = "";
        String _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari2 = "";
        String str8 = _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari;
        if (str8 != "ندارد") {
            String[] splited = str8.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari1 = _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "نما: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("سنگ");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "سنگ";
                }
                Boolean found2 = a.contains("آجر");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "آجر";
                }
                Boolean found3 = a.contains("سیمان");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیمان";
                }
                Boolean found4 = a.contains("شیشه");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "شیشه";

                }
                Boolean found5 = a.contains("چوب");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "چوب";

                }
                Boolean found6 = a.contains("کامپوزیت");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "کامپوزیت";

                }
                Boolean found7 = a.contains("نورپردازی");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "نورپردازی";

                }
                Boolean found8 = a.contains("تابلو خور");
                if (found8 == true) {
                    matnInTextView = matnInTextView + "\n" + "تابلو خور";

                }
            }
        }


        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_nama_nama_edit;


        String _more_joziat_melk_edari_tejari_divar_divar_check1 = "";
        String _more_joziat_melk_edari_tejari_divar_divar_check2 = "";
        String str12 = _more_joziat_melk_edari_tejari_divar_divar_check;
        if (str12 != "ندارد") {
            String[] splited = str12.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_divar_divar_check1 = _more_joziat_melk_edari_tejari_divar_divar_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_divar_divar_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "دیوار: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("سنگ");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "سنگ";
                }
                Boolean found9 = a.contains("رنگ");
                if (found9 == true) {
                    matnInTextView = matnInTextView + "\n" + "رنگ";
                }
                Boolean found2 = a.contains("کاشی/ سرامیک");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "کاشی/ سرامیک";
                }
                Boolean found3 = a.contains("کاغذ دیواری");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "کاغذ دیواری";
                }
                Boolean found4 = a.contains("چوب/ دیوارکوب");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "چوب/ دیوارکوب";
                }
                Boolean found5 = a.contains("سیمان");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیمان";
                }
                Boolean found6 = a.contains("گچ");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "گچ";
                }
                Boolean found7 = a.contains("آجر");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "آجر";
                }
            }

        }


        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_divar_divar_edit;


        String _more_joziat_melk_edari_tejari_coldhot_coldhot_check1 = "";
        String _more_joziat_melk_edari_tejari_coldhot_coldhot_check2 = "";
        String str13 = _more_joziat_melk_edari_tejari_coldhot_coldhot_check;
        if (str13 != "ندارد") {
            String[] splited = str13.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_coldhot_coldhot_check1 = _more_joziat_melk_edari_tejari_coldhot_coldhot_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_coldhot_coldhot_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تجهیزات گرمایشی/سرمایشی: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("کولر");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "کولر";
                }
                Boolean found2 = a.contains("کولرگازی/ اسپلیت");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "کولرگازی/ اسپلیت";
                }
                Boolean found3 = a.contains("بخاری");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "بخاری";
                }
                Boolean found4 = a.contains("پکیج/ رادیاتور");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "پکیج/ رادیاتور";
                }
                Boolean found5 = a.contains("دیگ/ رادیاتور");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "دیگ/ رادیاتور";
                }
                Boolean found6 = a.contains("چیلر/ فن کوئل");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "چیلر/ فن کوئل";
                }
                Boolean found7 = a.contains("آبگرمکن خورشیدی");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "آبگرمکن خورشیدی";
                }
                Boolean found79 = a.contains("هواساز");
                if (found79 == true) {
                    matnInTextView = matnInTextView + "\n" + "هواساز";
                }
            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_coldhot_coldhot_edit;


        String _more_joziat_melk_edari_tejari_refahi_refahi_check_edari1 = "";
        String _more_joziat_melk_edari_tejari_refahi_refahi_check_edari2 = "";
        String str14 = _more_joziat_melk_edari_tejari_refahi_refahi_check_edari;
        if (str14 != "ندارد") {
            String[] splited = str14.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_refahi_refahi_check_edari1 = _more_joziat_melk_edari_tejari_refahi_refahi_check_edari1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_refahi_refahi_check_edari1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تجهیزات رفاهی: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("آسانسور");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "آسانسور";
                }

                Boolean found4 = a.contains("اینترنت پرسرعت");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "اینترنت پرسرعت";
                }

                Boolean found6 = a.contains("شبکه داخلی");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "شبکه داخلی";
                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_refahi_refahi_edit;


        String _more_joziat_melk_edari_tejari_safe_safe_check1 = "";
        String _more_joziat_melk_edari_tejari_safe_safe_check2 = "";
        String str15 = _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta;
        if (str15 != "ندارد") {
            String[] splited = str15.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_safe_safe_check1 = _more_joziat_melk_edari_tejari_safe_safe_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_safe_safe_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تجهیزات ایمنی", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("دزدگیر");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "دزدگیر";
                }
                Boolean found2 = a.contains("دوربین مداربسته");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "دوربین مداربسته";
                }
                Boolean found3 = a.contains("آیفون تصویری");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "آیفون تصویری";
                }
                Boolean found4 = a.contains("درب ضد سرقت");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "درب ضد سرقت";
                }
                Boolean found5 = a.contains("سیستم اعلام آتش");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیستم اعلام آتش";
                }
                Boolean found6 = a.contains("سیستم اطفاء حریق");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیستم اطفاء حریق";
                }
                Boolean found7 = a.contains("گاوصندوق");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "گاوصندوق";
                }
            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_safe_safe_edit;


        String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1 = "";
        String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta2 = "";
        String str16 = _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari;
        if (str16 != "ندارد") {
            String[] splited = str16.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1 = _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "امکانات ساختمان: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("حیاط");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "حیاط";
                }
                Boolean found2 = a.contains("حیاط خلوت");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "حیاط خلوت";
                }
                Boolean found3 = a.contains("فضای سبز");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "فضای سبز";
                }
                Boolean found4 = a.contains("سرایداری");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "سرایداری";
                }
                Boolean found5 = a.contains("نگهبانی");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "نگهبانی";
                }
                Boolean found6 = a.contains("لابی");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "لابی";
                }
                Boolean found62 = a.contains("سالن اجتماعات");
                if (found62 == true) {
                    matnInTextView = matnInTextView + "\n" + "سالن اجتماعات";
                }

            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit;


        String _more_joziat_melk_edari_tejari_view_view_check1 = "";
        String _more_joziat_melk_edari_tejari_view_view_check2 = "";
        String str18 = _more_joziat_melk_edari_tejari_view_view_check;
        if (str18 != "ندارد") {
            String[] splited = str18.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_view_view_check1 = _more_joziat_melk_edari_tejari_view_view_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_view_view_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "دید: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("شهر");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "شهر";
                }
                Boolean found2 = a.contains("اتوبان");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "اتوبان";
                }
                Boolean found3 = a.contains("خیابان");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "خیابان";
                }
                Boolean found4 = a.contains("کوچه");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "کوچه";
                }
                Boolean found5 = a.contains("دریا");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "دریا";
                }
                Boolean found6 = a.contains("جنگل");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "جنگل";
                }
                Boolean found7 = a.contains("کوه");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "کوه";
                }
                Boolean found71 = a.contains("باغ");
                if (found71 == true) {
                    matnInTextView = matnInTextView + "\n" + "باغ";
                }
            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_view_view_edit;


        String _more_joziat_melk_edari_tejari_nor_nor_check1 = "";
        String _more_joziat_melk_edari_tejari_nor_nor_check2 = "";
        String str19 = _more_joziat_melk_edari_tejari_nor_nor_check.toString();
        if (str19 != "ندارد") {
            String[] splited = str19.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_nor_nor_check1 = _more_joziat_melk_edari_tejari_nor_nor_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_nor_nor_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "نور: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("شمال");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "شمال";
                }
                Boolean found2 = a.contains("جنوب");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "جنوب";
                }
                Boolean found3 = a.contains("شرق");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "شرق";
                }
                Boolean found4 = a.contains("غرب");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "غرب";
                }
            }
        }


        String _more_joziat_melk_edari_tejari_tasisat_tasisat_check1 = "";
        String _more_joziat_melk_edari_tejari_tasisat_tasisat_check2 = "";
        String str21 = _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari;
        if (str21 != "ندارد") {
            String[] splited = str21.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check1 = _more_joziat_melk_edari_tejari_tasisat_tasisat_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_tasisat_tasisat_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تاسیسات: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("آب شهری");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "آب شهری";
                }
                Boolean found2 = a.contains("برق");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "برق";
                }
                Boolean found3 = a.contains("گاز");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "گاز";
                }
                Boolean found4 = a.contains("ژنراتور برقی");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "ژنراتور برقی";
                }
                Boolean found45 = a.contains("منابع تغذیه برق");
                if (found45 == true) {
                    matnInTextView = matnInTextView + "\n" + "منابع تغذیه برق";
                }
            }
        }


        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;


        String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 = "";
        String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam2 = "";
        String str22 = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;
        if (str22 != "ندارد") {
            String[] splited = str22.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found2 = a.contains("سند در دست اقدام");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "سند در دست اقدام";
                }
            }
        }

        textViewShowPostS.setText(matnInTextView);

    }

    public void GetjsonarrayTEJARI() {
        try {
            String dataServer3 = dataServer234;
            jsonArray = new JSONArray(dataServer3);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                _ID = jsonObject1.getInt("_ID");
                _content = jsonObject1.getString("_post_content");
                _title = jsonObject1.getString("_post_title");
                _guid11 = jsonObject1.getString("_guid11");

                _noe_melk_moamele = jsonObject1.getString("_noe_melk_moamele");
                _moshakhasat_asli_melk_moghiita_store = jsonObject1.getString("_moshakhasat_asli_melk_moghiita_store");
                _noe_melk = jsonObject1.getString("_noe_melk");
                _moshakhasat_asli_melk_masahat_kaf = jsonObject1.getString("_moshakhasat_asli_melk_masahat_kaf");
                _moshakhasat_asli_melk_masahat_balkon = jsonObject1.getString("_moshakhasat_asli_melk_masahat_balkon");
                _moshakhasat_asli_melk_nuumber_dahane = jsonObject1.getString("_moshakhasat_asli_melk_nuumber_dahane");
                _moshakhasat_asli_melk_tol_bar_asli = jsonObject1.getString("_moshakhasat_asli_melk_tol_bar_asli");
                _moshakhasat_asli_melk_number_bar = jsonObject1.getString("_moshakhasat_asli_melk_number_bar");
                _moshakhasat_asli_melk_noe_vaghozari = jsonObject1.getString("_moshakhasat_asli_melk_noe_vaghozari");
                _more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh");
                _more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh");
                _more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe");
                _more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze");
                _more_joziat_melk_edari_tejari_wc_wc_irani = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_wc_irani");
                _more_joziat_melk_edari_tejari_wc_wc_us = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_wc_us");
                _more_joziat_melk_edari_tejari_wc_roshoii = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_roshoii");
                _more_joziat_melk_edari_tejari_abdarhkane_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_abdarhkane_tejari");
                _more_joziat_melk_edari_tejari_fazai_asli_fazai_asli = jsonObject1.getString("_more_joziat_melk_edari_tejari_fazai_asli_fazai_asli");
                _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari");
                _more_joziat_melk_edari_tejari_kaf_kaf_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf_kaf_check");
                _more_joziat_melk_edari_tejari_kaf_kaf_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf_kaf_edit");
                _more_joziat_melk_edari_tejari_coldhot_coldhot_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_check");
                _more_joziat_melk_edari_tejari_coldhot_coldhot_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_edit");
                _more_joziat_melk_edari_tejari_refahi_refahi_check_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_check_tejari");
                _more_joziat_melk_edari_tejari_refahi_refahi_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_edit");
                _more_joziat_melk_edari_tejari_safe_safe_check_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_check_tejari");
                _more_joziat_melk_edari_tejari_safe_safe_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_edit");
                _more_joziat_melk_edari_tejari_dastresi_dastresi_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_dastresi_dastresi_check");
                _more_joziat_melk_edari_tejari_dastresi_dastres_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_dastresi_dastres_edit");
                _more_joziat_melk_edari_tejari_ghozar_asli = jsonObject1.getString("_more_joziat_melk_edari_tejari_ghozar_asli");
                _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");
                switch (_noe_melk_moamele) {
                    case "فروش، پیش فروش، معاوضه":
                        _price_shrayet_sell_cheng_price_all_sell_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_price_all_sell_cheng");
                        _price_shrayet_sell_cheng_check_seel_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_check_seel_cheng");
                        _price_shrayet_sell_cheng_max_money = jsonObject1.getString("_price_shrayet_sell_cheng_max_money");
                        _price_shrayet_sell_cheng_money_pish_pay = jsonObject1.getString("_price_shrayet_sell_cheng_money_pish_pay");
                        _price_shrayet_sell_cheng_time_tahvil = jsonObject1.getString("_price_shrayet_sell_cheng_time_tahvil");
                        _price_shrayet_sell_cheng_mizan_anjam_shode = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_anjam_shode");
                        _price_shrayet_sell_cheng_mizan_vam = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_vam");
                        _price_shrayet_sell_cheng_sod_vam = jsonObject1.getString("_price_shrayet_sell_cheng_sod_vam");
                        _price_shrayet_sell_cheng_number_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_number_ghest");
                        _price_shrayet_sell_cheng_price_har_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_price_har_ghest");
                        _price_shrayet_sell_cheng_price_rahn = jsonObject1.getString("_price_shrayet_sell_cheng_price_rahn");
                        break;
                    case "رهن و اجاره":
                        _price_shrayet_rent_price_vadie = jsonObject1.getString("_price_shrayet_rent_price_vadie");
                        _price_shrayet_rent_price_ajare_mohiane = jsonObject1.getString("_price_shrayet_rent_price_ajare_mohiane");
                        break;
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        matnInTextView = matnInTextView + "\n" + _noe_melk_moamele;
        matnInTextView = matnInTextView + "\n" + _noe_melk;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_moghiita_store;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_masahat_kaf;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_masahat_balkon;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_nuumber_dahane;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_tol_bar_asli;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_number_bar;


        String _moshakhasat_asli_melk_noe_vaghozari1 = "";
        String _moshakhasat_asli_melk_noe_vaghozari2 = "";
        String str21 = _moshakhasat_asli_melk_noe_vaghozari.toString();
        if (str21 != "ندارد") {
            String[] splited = str21.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _moshakhasat_asli_melk_noe_vaghozari1 = _moshakhasat_asli_melk_noe_vaghozari1 + " " + splited[i];
            }
            String aaa = "";
            splited = _moshakhasat_asli_melk_noe_vaghozari1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "نوع واگذاری: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("مالکیت");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "مالکیت";
                }
                Boolean found2 = a.contains("سرقفلی");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "سرقفلی";
                }
            }
        }


        switch (_noe_melk_moamele) {
            case "فروش، پیش فروش، معاوضه":
                matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_all_sell_cheng;

                String _price_shrayet_sell_cheng_check_seel_cheng1 = "";
                String _price_shrayet_sell_cheng_check_seel_cheng2 = "";
                String str2 = _price_shrayet_sell_cheng_check_seel_cheng;
                if (str2 != "ندارد") {
                    String[] splited = str2.split("\"");
                    for (int i = 1; i < splited.length; i++) {
                        _price_shrayet_sell_cheng_check_seel_cheng1 = _price_shrayet_sell_cheng_check_seel_cheng1 + " " + splited[i];
                    }
                    String aaa = "";
                    splited = _price_shrayet_sell_cheng_check_seel_cheng1.split(",");
                    for (int ai = 0; ai < splited.length; ai++) {
                        aaa = aaa + "\n" + splited[ai];
                        aaa = aaa.replace("[", "");
                    }
                    String b = "شرایط معامله: ", a;
                    for (int ai = 0; ai < splited.length; ai++) {
                        a = splited[ai];
                        Boolean found = a.contains("معاوضه");
                        if (found == true) {
                            matnInTextView = matnInTextView + "\n" + "معاوضه دارد";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_max_money;
                        }
                        Boolean found2 = a.contains("پیش فروش");
                        if (found2 == true) {
                            matnInTextView = matnInTextView + "\n" + "پیش فروش";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_money_pish_pay;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_time_tahvil;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_mizan_anjam_shode;
                        }
                        Boolean found3 = a.contains("دارای وام");
                        if (found3 == true) {
                            matnInTextView = matnInTextView + "\n" + "دارای وام";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_mizan_vam;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_sod_vam;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_number_ghest;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_har_ghest;


                        }
                        Boolean found4 = a.contains("فروش با مستاجر");
                        if (found4 == true) {
                            matnInTextView = matnInTextView + "\n" + "فروش با مستاجر";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_rahn;

                        }
                    }
                }
                break;
            case "رهن و اجاره":
                matnInTextView = matnInTextView + "\n" + _price_shrayet_rent_price_vadie;
                matnInTextView = matnInTextView + "\n" + _price_shrayet_rent_price_ajare_mohiane;

                break;
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_wc_wc_irani;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_wc_bath;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_wc_roshoii;


        String _more_joziat_melk_edari_tejari_abdarhkane_tejari1 = "";
        String _more_joziat_melk_edari_tejari_abdarhkane_tejari2 = "";
        String str3 = _more_joziat_melk_edari_tejari_abdarhkane_tejari.toString();
        if (str3 != "ندارد") {
            String[] splited = str3.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_abdarhkane_tejari1 = _more_joziat_melk_edari_tejari_abdarhkane_tejari1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_abdarhkane_tejari1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("آبدارخانه");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "آبدارخانه";
                }
            }
        }

        String _more_joziat_melk_edari_tejari_fazai_asli_fazai_asli1 = "";
        String _more_joziat_melk_edari_tejari_fazai_asli_fazai_asli2 = "";
        String str7 = _more_joziat_melk_edari_tejari_fazai_asli_fazai_asli.toString();
        if (str7 != "ندارد") {
            String[] splited = str7.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_fazai_asli_fazai_asli1 = _more_joziat_melk_edari_tejari_fazai_asli_fazai_asli1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_fazai_asli_fazai_asli1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "نشیمن: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("ویترین");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "ویترین";
                }
                Boolean found2 = a.contains("سقف بالای 4 متر");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "سقف بالای 4 متر";
                }
                Boolean found3 = a.contains("دکوراسیون داخلی");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "دکوراسیون داخلی";
                }
                Boolean found31 = a.contains("قفسه بندی");
                if (found31 == true) {
                    matnInTextView = matnInTextView + "\n" + "قفسه بندی";
                }
            }
        }


        String _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari1 = "";
        String _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari2 = "";
        String str8 = _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari.toString();
        if (str8 != "ندارد") {
            String[] splited = str8.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari1 = _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "نما: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("سنگ");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "سنگ";

                }
                Boolean found2 = a.contains("آجر");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "آجر";

                }
                Boolean found3 = a.contains("سیمان");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیمان";

                }
                Boolean found4 = a.contains("شیشه");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "شیشه";

                }
                Boolean found5 = a.contains("چوب");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "چوب";

                }
                Boolean found6 = a.contains("کامپوزیت");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "کامپوزیت";

                }
                Boolean found7 = a.contains("نورپردازی");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "نورپردازی";

                }
                Boolean found8 = a.contains("تابلو خور");
                if (found8 == true) {
                    matnInTextView = matnInTextView + "\n" + "تابلو خور";

                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_nama_nama_edit;

        String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1 = "";
        String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat2 = "";
        String str1 = _more_joziat_melk_edari_tejari_kaf_kaf_check.toString();
        if (str1 != "ندارد") {
            String[] splited = str1.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1 = _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1 + " " + splited[i];
            }
            String aaa = "";
            splited = _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "وضعیت ساختمان: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("سنگ");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "سنگ";
                }
                Boolean found2 = a.contains("سرامیک");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "سرامیک";
                }
                Boolean found3 = a.contains("پارکت");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "پارکت";
                }
                Boolean found4 = a.contains("کفپوش");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "کفپوش";
                }
                Boolean found5 = a.contains("موکت");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "موکت";
                }
                Boolean found6 = a.contains("موزاییک");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "موزاییک";
                }
                Boolean found7 = a.contains("سیمان");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیمان";
                }
                Boolean found8 = a.contains("کف پله دار");
                if (found8 == true) {
                    matnInTextView = matnInTextView + "\n" + "کف پله دار";
                }
            }

        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_kaf_kaf_edit;


        String _more_joziat_melk_edari_tejari_coldhot_coldhot_check1 = "";
        String _more_joziat_melk_edari_tejari_coldhot_coldhot_check2 = "";
        String str13 = _more_joziat_melk_edari_tejari_coldhot_coldhot_check.toString();
        if (str13 != "ندارد") {
            String[] splited = str13.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_coldhot_coldhot_check1 = _more_joziat_melk_edari_tejari_coldhot_coldhot_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_coldhot_coldhot_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تجهیزات گرمایشی/سرمایشی: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("کولر");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "کولر";
                }
                Boolean found2 = a.contains("کولرگازی/ اسپلیت");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "کولرگازی/ اسپلیت";
                }
                Boolean found3 = a.contains("بخاری");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "بخاری";
                }
                Boolean found4 = a.contains("پکیج/ رادیاتور");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "پکیج/ رادیاتور";
                }
                Boolean found5 = a.contains("دیگ/ رادیاتور");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "دیگ/ رادیاتور";
                }
                Boolean found6 = a.contains("چیلر/ فن کوئل");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "چیلر/ فن کوئل";
                }
                Boolean found7 = a.contains("آبگرمکن خورشیدی");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "آبگرمکن خورشیدی";
                }
                Boolean found79 = a.contains("هواساز");
                if (found79 == true) {
                    matnInTextView = matnInTextView + "\n" + "هواساز";
                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_coldhot_coldhot_edit;


        String _more_joziat_melk_edari_tejari_refahi_refahi_check_tejari1 = "";
        String _more_joziat_melk_edari_tejari_refahi_refahi_check_tejari2 = "";
        String str14 = _more_joziat_melk_edari_tejari_refahi_refahi_check_tejari.toString();
        if (str14 != "ندارد") {
            String[] splited = str14.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_refahi_refahi_check_tejari1 = _more_joziat_melk_edari_tejari_refahi_refahi_check_tejari1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_refahi_refahi_check_tejari1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تجهیزات رفاهی: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("آسانسور");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "آسانسور";
                }

                Boolean found4 = a.contains("اینترنت پرسرعت");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "اینترنت پرسرعت";
                }

                Boolean found6 = a.contains("شبکه داخلی");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "شبکه داخلی";
                }
                Boolean found61 = a.contains("پله برقی");
                if (found61 == true) {
                    matnInTextView = matnInTextView + "\n" + "پله برقی";
                }
                Boolean found612 = a.contains("آسانسور حمل بار");
                if (found612 == true) {
                    matnInTextView = matnInTextView + "\n" + "آسانسور حمل بار";
                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_refahi_refahi_edit;


        String _more_joziat_melk_edari_tejari_safe_safe_check_tejari1 = "";
        String _more_joziat_melk_edari_tejari_safe_safe_check_tejari2 = "";
        String str15 = _more_joziat_melk_edari_tejari_safe_safe_check_tejari.toString();
        if (str15 != "ندارد") {
            String[] splited = str15.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_safe_safe_check_tejari1 = _more_joziat_melk_edari_tejari_safe_safe_check_tejari1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_safe_safe_check_tejari1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تجهیزات ایمنی", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("دزدگیر");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "دزدگیر";
                }
                Boolean found2 = a.contains("دوربین مداربسته");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "دوربین مداربسته";
                }
                Boolean found3 = a.contains("آیفون تصویری");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "آیفون تصویری";
                }
                Boolean found4 = a.contains("درب ضد سرقت");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "درب ضد سرقت";
                }
                Boolean found5 = a.contains("سیستم اعلام آتش");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیستم اعلام آتش";
                }
                Boolean found6 = a.contains("سیستم اطفاء حریق");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیستم اطفاء حریق";
                }
                Boolean found7 = a.contains("گاوصندوق");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "گاوصندوق";
                }
                Boolean found71 = a.contains("شیشه نشکن");
                if (found71 == true) {
                    matnInTextView = matnInTextView + "\n" + "شیشه نشکن";
                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_safe_safe_edit;


        String _more_joziat_melk_edari_tejari_dastresi_dastresi_check1 = "";
        String _more_joziat_melk_edari_tejari_dastresi_dastresi_check2 = "";
        String str151 = _more_joziat_melk_edari_tejari_dastresi_dastresi_check.toString();
        if (str151 != "ندارد") {
            String[] splited = str151.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_dastresi_dastresi_check1 = _more_joziat_melk_edari_tejari_dastresi_dastresi_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_dastresi_dastresi_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "دسترسی", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("داخل بازار");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "داخل بازار";
                }
                Boolean found2 = a.contains("خیابان اصلی");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "خیابان اصلی";
                }
                Boolean found3 = a.contains("خیابان فرعی");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "خیابان فرعی";
                }
                Boolean found4 = a.contains("میدان");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "میدان";
                }
                Boolean found5 = a.contains("کوچه");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "کوچه";
                }
                Boolean found6 = a.contains("بن بست");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "بن بست";
                }

            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_dastresi_dastres_edit;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_ghozar_asli;


        // گذر اصلی


        String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari1 = "";
        String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari2 = "";
        String str211 = _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari.toString();
        if (str211 != "ندارد") {
            String[] splited = str211.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari1 = _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تاسیسات: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("آب شهری");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "آب شهری";
                }
                Boolean found2 = a.contains("برق");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "برق";
                }
                Boolean found3 = a.contains("گاز");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "گاز";
                }
                Boolean found4 = a.contains("ژنراتور برقی");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "ژنراتور برقی";
                }
                Boolean found45 = a.contains("منابع تغذیه برق");
                if (found45 == true) {
                    matnInTextView = matnInTextView + "\n" + "منابع تغذیه برق";
                }
            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;


        String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 = "";
        String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam2 = "";
        String str22 = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam.toString();
        if (str22 != "ندارد") {
            String[] splited = str22.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found2 = a.contains("سند در دست اقدام");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "سند در دست اقدام";
                }
            }
        }
        textViewShowPostS.setText(matnInTextView);
    }

    public void GetjsonarrayMOSTA() {
        try {
            String dataServer3 = dataServer234;
            jsonArray = new JSONArray(dataServer3);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                _ID = jsonObject1.getInt("_ID");
                _content = jsonObject1.getString("_post_content");
                _title = jsonObject1.getString("_post_title");
                _guid11 = jsonObject1.getString("_guid11");

                _noe_melk_moamele = jsonObject1.getString("_noe_melk_moamele");
                _noe_melk = jsonObject1.getString("_noe_melk");
                _moshakhasat_asli_melk_noe_bana_mostagh = jsonObject1.getString("_moshakhasat_asli_melk_noe_bana_mostagh");
                _moshakhasat_asli_melk_mosahat_kol_banai_build = jsonObject1.getString("_moshakhasat_asli_melk_mosahat_kol_banai_build");
                _moshakhasat_asli_melk_masahat_zamin = jsonObject1.getString("_moshakhasat_asli_melk_masahat_zamin");
                _moshakhasat_asli_melk_number_bar = jsonObject1.getString("_moshakhasat_asli_melk_number_bar");
                _moshakhasat_asli_melk_sale_build = jsonObject1.getString("_moshakhasat_asli_melk_sale_build");
                _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio");
                _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_ghabel_sokonat");
                _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check");
                _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit");
                _more_joziat_melk_edari_tejari_nama_nama_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_check");
                _more_joziat_melk_edari_tejari_nama_nama_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_edit");
                _more_joziat_melk_edari_tejari_eskelet_eskelet_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_eskelet_eskelet_check");
                _more_joziat_melk_edari_tejari_eskelet_eskelet_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_eskelet_eskelet_edit");
                _more_joziat_melk_edari_tejari_divar_divar_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar_divar_check");
                _more_joziat_melk_edari_tejari_divar_divar_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar_divar_edit");
                _more_joziat_melk_edari_tejari_coldhot_coldhot_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_check");
                _more_joziat_melk_edari_tejari_coldhot_coldhot_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_edit");
                _more_joziat_melk_edari_tejari_refahi_refahi_check_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_check_mosta");
                _more_joziat_melk_edari_tejari_refahi_refahi_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_edit");
                _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta");
                _more_joziat_melk_edari_tejari_safe_safe_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_edit");
                _more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta");
                _more_joziat_melk_edari_tejari_dastresi_dastres_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_dastresi_dastres_edit");
                _more_joziat_melk_edari_tejari_ghozar_asli = jsonObject1.getString("_more_joziat_melk_edari_tejari_ghozar_asli");
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta");
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit");
                _more_joziat_melk_edari_tejari_sport_sport_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_sport_sport_check");
                _more_joziat_melk_edari_tejari_sport_sport_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_sport_sport_edit");
                _more_joziat_melk_edari_tejari_view_view_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_view_view_check");
                _more_joziat_melk_edari_tejari_view_view_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_view_view_edit");
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta");
                _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");
                switch (_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio) {
                    case "کلنگی":
                        _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_ghabel_sokonat");
                        break;
                    case "چند سال ساخت":
                        _moshakhasat_asli_melk_vaziita_build_rebuild = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_rebuild");
                        break;
                }

                switch (_noe_melk_moamele) {
                    case "فروش، پیش فروش، معاوضه":
                        _price_shrayet_sell_cheng_price_all_sell_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_price_all_sell_cheng");
                        _price_shrayet_sell_cheng_check_seel_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_check_seel_cheng");
                        _price_shrayet_sell_cheng_max_money = jsonObject1.getString("_price_shrayet_sell_cheng_max_money");
                        _price_shrayet_sell_cheng_money_pish_pay = jsonObject1.getString("_price_shrayet_sell_cheng_money_pish_pay");
                        _price_shrayet_sell_cheng_time_tahvil = jsonObject1.getString("_price_shrayet_sell_cheng_time_tahvil");
                        _price_shrayet_sell_cheng_mizan_anjam_shode = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_anjam_shode");
                        _price_shrayet_sell_cheng_mizan_vam = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_vam");
                        _price_shrayet_sell_cheng_sod_vam = jsonObject1.getString("_price_shrayet_sell_cheng_sod_vam");
                        _price_shrayet_sell_cheng_number_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_number_ghest");
                        _price_shrayet_sell_cheng_price_har_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_price_har_ghest");
                        _price_shrayet_sell_cheng_price_rahn = jsonObject1.getString("_price_shrayet_sell_cheng_price_rahn");
                        break;
                    case "رهن و اجاره":
                        _price_shrayet_rent_price_vadie = jsonObject1.getString("_price_shrayet_rent_price_vadie");
                        _price_shrayet_rent_price_ajare_mohiane = jsonObject1.getString("_price_shrayet_rent_price_ajare_mohiane");
                        break;
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        matnInTextView = matnInTextView + "\n" + _noe_melk_moamele;
        matnInTextView = matnInTextView + "\n" + _noe_melk;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_noe_bana_mostagh;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_mosahat_kol_banai_build;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_masahat_zamin;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_number_bar;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_sale_build;
        matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_all_sell_cheng;


        switch (_noe_melk_moamele) {
            case "فروش، پیش فروش، معاوضه":
                matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_all_sell_cheng;

                String _price_shrayet_sell_cheng_check_seel_cheng1 = "";
                String _price_shrayet_sell_cheng_check_seel_cheng2 = "";
                String str2 = _price_shrayet_sell_cheng_check_seel_cheng;
                if (str2 != "ندارد") {
                    String[] splited = str2.split("\"");
                    for (int i = 1; i < splited.length; i++) {
                        _price_shrayet_sell_cheng_check_seel_cheng1 = _price_shrayet_sell_cheng_check_seel_cheng1 + " " + splited[i];
                    }
                    String aaa = "";
                    splited = _price_shrayet_sell_cheng_check_seel_cheng1.split(",");
                    for (int ai = 0; ai < splited.length; ai++) {
                        aaa = aaa + "\n" + splited[ai];
                        aaa = aaa.replace("[", "");
                    }
                    String b = "شرایط معامله: ", a;
                    for (int ai = 0; ai < splited.length; ai++) {
                        a = splited[ai];
                        Boolean found = a.contains("معاوضه");
                        if (found == true) {
                            matnInTextView = matnInTextView + "\n" + "معاوضه دارد";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_max_money;
                        }
                        Boolean found2 = a.contains("پیش فروش");
                        if (found2 == true) {
                            matnInTextView = matnInTextView + "\n" + "پیش فروش";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_money_pish_pay;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_time_tahvil;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_mizan_anjam_shode;
                        }
                        Boolean found3 = a.contains("دارای وام");
                        if (found3 == true) {
                            matnInTextView = matnInTextView + "\n" + "دارای وام";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_mizan_vam;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_sod_vam;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_number_ghest;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_har_ghest;


                        }
                        Boolean found4 = a.contains("فروش با مستاجر");
                        if (found4 == true) {
                            matnInTextView = matnInTextView + "\n" + "فروش با مستاجر";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_rahn;

                        }
                    }
                }
                break;
            case "رهن و اجاره":
                matnInTextView = matnInTextView + "\n" + _price_shrayet_rent_price_vadie;
                matnInTextView = matnInTextView + "\n" + _price_shrayet_rent_price_ajare_mohiane;

                break;
        }

        String _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check1 = "";
        String _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check2 = "";
        String str22 = _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check.toString();
        if (str22 != "ندارد") {
            String[] splited = str22.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check1 = _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];

                Boolean found2 = a.contains("مسکونی");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "مسکونی";
                }

                Boolean found21 = a.contains("اداری");
                if (found21 == true) {
                    matnInTextView = matnInTextView + "\n" + "اداری";
                }

                Boolean found22 = a.contains("تجاری");
                if (found22 == true) {
                    matnInTextView = matnInTextView + "\n" + "تجاری";
                }

                Boolean found23 = a.contains("صعنتی");
                if (found23 == true) {
                    matnInTextView = matnInTextView + "\n" + "صعنتی";
                }

                Boolean found24 = a.contains("تفریحی - ورزشی");
                if (found24 == true) {
                    matnInTextView = matnInTextView + "\n" + "تفریحی - ورزشی";
                }

                Boolean found25 = a.contains("آموزشی");
                if (found25 == true) {
                    matnInTextView = matnInTextView + "\n" + "آموزشی";
                }

                Boolean found26 = a.contains("توریستی");
                if (found26 == true) {
                    matnInTextView = matnInTextView + "\n" + "توریستی";
                }

                Boolean found27 = a.contains("دامپروری");
                if (found27 == true) {
                    matnInTextView = matnInTextView + "\n" + "دامپروری";
                }

                Boolean found28 = a.contains("کشاورزی");
                if (found28 == true) {
                    matnInTextView = matnInTextView + "\n" + "کشاورزی";
                }

                Boolean found29 = a.contains("باغشهر - شهرک سازی");
                if (found29 == true) {
                    matnInTextView = matnInTextView + "\n" + "باغشهر - شهرک سازی";
                }

                Boolean found20 = a.contains("خدماتی رفاهی");
                if (found20 == true) {
                    matnInTextView = matnInTextView + "\n" + "خدماتی رفاهی";
                }

                Boolean found211 = a.contains("انبار");
                if (found211 == true) {
                    matnInTextView = matnInTextView + "\n" + "انبار";
                }

                Boolean found212 = a.contains("پارکینگ");
                if (found212 == true) {
                    matnInTextView = matnInTextView + "\n" + "پارکینگ";
                }

            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit;

        String _more_joziat_melk_edari_tejari_nama_nama_check1 = "";
        String _more_joziat_melk_edari_tejari_nama_nama_check2 = "";
        String str8 = _more_joziat_melk_edari_tejari_nama_nama_check.toString();
        if (str8 != "ندارد") {
            String[] splited = str8.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_nama_nama_check1 = _more_joziat_melk_edari_tejari_nama_nama_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_nama_nama_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "نما: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("سنگ");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "سنگ";

                }
                Boolean found2 = a.contains("آجر");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "آجر";

                }
                Boolean found3 = a.contains("سیمان");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیمان";

                }
                Boolean found4 = a.contains("شیشه");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "شیشه";

                }
                Boolean found5 = a.contains("چوب");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "چوب";

                }
                Boolean found6 = a.contains("کامپوزیت");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "کامپوزیت";

                }
                Boolean found7 = a.contains("نورپردازی");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "نورپردازی";

                }
            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_nama_nama_edit;


        String _more_joziat_melk_edari_tejari_eskelet_eskelet_check1 = "";
        String _more_joziat_melk_edari_tejari_eskelet_eskelet_check2 = "";
        String str9 = _more_joziat_melk_edari_tejari_eskelet_eskelet_check.toString();
        if (str9 != "ندارد") {
            String[] splited = str9.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_eskelet_eskelet_check1 = _more_joziat_melk_edari_tejari_eskelet_eskelet_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_eskelet_eskelet_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "اسکلت ساختمان: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("بتنی");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "بتنی";
                }
                Boolean found2 = a.contains("فلزی");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "فلزی";
                }
                Boolean found3 = a.contains("آجی");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "آجی";
                }
                Boolean found4 = a.contains("چوبی");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "چوبی";
                }
            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_eskelet_eskelet_edit;


        String _more_joziat_melk_edari_tejari_divar_divar_check1 = "";
        String _more_joziat_melk_edari_tejari_divar_divar_check2 = "";
        String str12 = _more_joziat_melk_edari_tejari_divar_divar_check.toString();
        if (str12 != "ندارد") {
            String[] splited = str12.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_divar_divar_check1 = _more_joziat_melk_edari_tejari_divar_divar_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_divar_divar_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "دیوار: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("سنگ");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "سنگ";
                }
                Boolean found9 = a.contains("رنگ");
                if (found9 == true) {
                    matnInTextView = matnInTextView + "\n" + "رنگ";
                }
                Boolean found2 = a.contains("کاشی/ سرامیک");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "کاشی/ سرامیک";
                }
                Boolean found3 = a.contains("کاغذ دیواری");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "کاغذ دیواری";
                }
                Boolean found4 = a.contains("چوب/ دیوارکوب");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "چوب/ دیوارکوب";
                }
                Boolean found5 = a.contains("سیمان");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیمان";
                }
                Boolean found6 = a.contains("گچ");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "گچ";
                }
                Boolean found7 = a.contains("آجر");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "آجر";
                }
            }

        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_divar_divar_edit;


        String _more_joziat_melk_edari_tejari_coldhot_coldhot_check1 = "";
        String _more_joziat_melk_edari_tejari_coldhot_coldhot_check2 = "";
        String str13 = _more_joziat_melk_edari_tejari_coldhot_coldhot_check.toString();
        if (str13 != "ندارد") {
            String[] splited = str13.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_coldhot_coldhot_check1 = _more_joziat_melk_edari_tejari_coldhot_coldhot_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_coldhot_coldhot_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تجهیزات گرمایشی/سرمایشی: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("کولر");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "کولر";
                }
                Boolean found2 = a.contains("کولرگازی/ اسپلیت");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "کولرگازی/ اسپلیت";
                }
                Boolean found3 = a.contains("بخاری");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "بخاری";
                }
                Boolean found4 = a.contains("پکیج/ رادیاتور");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "پکیج/ رادیاتور";
                }
                Boolean found5 = a.contains("دیگ/ رادیاتور");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "دیگ/ رادیاتور";
                }
                Boolean found6 = a.contains("چیلر/ فن کوئل");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "چیلر/ فن کوئل";
                }
                Boolean found7 = a.contains("آبگرمکن خورشیدی");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "آبگرمکن خورشیدی";
                }
                Boolean found79 = a.contains("هواساز");
                if (found79 == true) {
                    matnInTextView = matnInTextView + "\n" + "هواساز";
                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_coldhot_coldhot_edit;


        String _more_joziat_melk_edari_tejari_refahi_refahi_check_mosta1 = "";
        String _more_joziat_melk_edari_tejari_refahi_refahi_check_mosta2 = "";
        String str14 = _more_joziat_melk_edari_tejari_refahi_refahi_check_mosta.toString();
        if (str14 != "ندارد") {
            String[] splited = str14.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_refahi_refahi_check_mosta1 = _more_joziat_melk_edari_tejari_refahi_refahi_check_mosta1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_refahi_refahi_check_mosta1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تجهیزات رفاهی: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("آسانسور");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "آسانسور";
                }
                Boolean found1 = a.contains("آسانسور حمل بار");
                if (found1 == true) {
                    matnInTextView = matnInTextView + "\n" + "آسانسور حمل بار";
                }

                Boolean found2 = a.contains("اینترنت پرسرعت");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "اینترنت پرسرعت";
                }

                Boolean found3 = a.contains("شبکه داخلی");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "شبکه داخلی";
                }

                Boolean found31 = a.contains("درب پارکنیگ ریموت دار");
                if (found31 == true) {
                    matnInTextView = matnInTextView + "\n" + "درب پارکنیگ ریموت دار";
                }

                Boolean found32 = a.contains("شوتینگ زباله");
                if (found32 == true) {
                    matnInTextView = matnInTextView + "\n" + "شوتینگ زباله";
                }

                Boolean found33 = a.contains("آنتن مرکزی");
                if (found33 == true) {
                    matnInTextView = matnInTextView + "\n" + "آنتن مرکزی";
                }

            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_refahi_refahi_edit;


        String _more_joziat_melk_edari_tejari_safe_safe_check1 = "";
        String _more_joziat_melk_edari_tejari_safe_safe_check2 = "";
        String str15 = _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta.toString();
        if (str15 != "ندارد") {
            String[] splited = str15.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_safe_safe_check1 = _more_joziat_melk_edari_tejari_safe_safe_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_safe_safe_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تجهیزات ایمنی", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("دزدگیر");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "دزدگیر";
                }
                Boolean found2 = a.contains("دوربین مداربسته");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "دوربین مداربسته";
                }
                Boolean found3 = a.contains("آیفون تصویری");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "آیفون تصویری";
                }
                Boolean found4 = a.contains("درب ضد سرقت");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "درب ضد سرقت";
                }
                Boolean found5 = a.contains("سیستم اعلام آتش");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیستم اعلام آتش";
                }
                Boolean found6 = a.contains("سیستم اطفاء حریق");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "سیستم اطفاء حریق";
                }
                Boolean found7 = a.contains("گاوصندوق");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "گاوصندوق";
                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_safe_safe_edit;


        String _more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta1 = "";
        String _more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta2 = "";
        String str151 = _more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta.toString();
        if (str151 != "ندارد") {
            String[] splited = str151.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta1 = _more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "دسترسی", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("داخل بازار");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "داخل بازار";
                }
                Boolean found2 = a.contains("خیابان اصلی");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "خیابان اصلی";
                }
                Boolean found3 = a.contains("خیابان فرعی");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "خیابان فرعی";
                }
                Boolean found4 = a.contains("میدان");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "میدان";
                }
                Boolean found5 = a.contains("کوچه");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "کوچه";
                }
                Boolean found6 = a.contains("بن بست");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "بن بست";
                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_dastresi_dastres_edit;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_ghozar_asli;


        // گذر اصلی

        String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1 = "";
        String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta2 = "";
        String str16 = _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta.toString();
        if (str16 != "ندارد") {
            String[] splited = str16.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1 = _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "امکانات ساختمان: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("حیاط");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "حیاط";
                }
                Boolean found2 = a.contains("حیاط خلوت");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "حیاط خلوت";
                }
                Boolean found3 = a.contains("فضای سبز");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "فضای سبز";
                }
                Boolean found4 = a.contains("سرایداری");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "سرایداری";
                }
                Boolean found5 = a.contains("نگهبانی");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "نگهبانی";
                }
                Boolean found6 = a.contains("لابی");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "لابی";
                }
                Boolean found62 = a.contains("سالن اجتماعات");
                if (found62 == true) {
                    matnInTextView = matnInTextView + "\n" + "سالن اجتماعات";
                }
                Boolean found611 = a.contains("باغ");
                if (found611 == true) {
                    matnInTextView = matnInTextView + "\n" + "باغ";
                }
                Boolean found612 = a.contains("آلاچیق");
                if (found612 == true) {
                    matnInTextView = matnInTextView + "\n" + "آلاچیق";
                }
                Boolean found613 = a.contains("آب نما");
                if (found613 == true) {
                    matnInTextView = matnInTextView + "\n" + "آب نما";
                }
                Boolean found614 = a.contains("بام سبز");
                if (found614 == true) {
                    matnInTextView = matnInTextView + "\n" + "بام سبز";
                }
                Boolean found615 = a.contains("باربیکیو");
                if (found615 == true) {
                    matnInTextView = matnInTextView + "\n" + "باربیکیو";
                }

            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit;


        String _more_joziat_melk_edari_tejari_sport_sport_check1 = "";
        String _more_joziat_melk_edari_tejari_sport_sport_check2 = "";
        String str17 = _more_joziat_melk_edari_tejari_sport_sport_check.toString();
        if (str17 != "ندارد") {
            String[] splited = str17.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_sport_sport_check1 = _more_joziat_melk_edari_tejari_sport_sport_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_sport_sport_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "وسایل ورزشی: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("استخر");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "استخر";
                }
                Boolean found2 = a.contains("سونا");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "سونا";
                }
                Boolean found3 = a.contains("جوزی");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "جوزی";
                }
                Boolean found4 = a.contains("بیلیارد");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "بیلیارد";
                }
                Boolean found5 = a.contains("فوتبال");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "فوتبال";
                }
                Boolean found6 = a.contains("بسکتبال");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "بسکتبال";
                }
                Boolean found61 = a.contains("والیبال");
                if (found61 == true) {
                    matnInTextView = matnInTextView + "\n" + "والیبال";
                }
                Boolean found62 = a.contains("تنیس");
                if (found62 == true) {
                    matnInTextView = matnInTextView + "\n" + "تنیس";
                }
                Boolean found63 = a.contains("پینگ پنگ");
                if (found63 == true) {
                    matnInTextView = matnInTextView + "\n" + "پینگ پنگ";
                }
                Boolean found64 = a.contains("سالن بدن سازی");
                if (found64 == true) {
                    matnInTextView = matnInTextView + "\n" + "سالن بدن سازی";
                }
                Boolean found65 = a.contains("زمین بازی کودکان");
                if (found65 == true) {
                    matnInTextView = matnInTextView + "\n" + "زمین بازی کودکان";
                }
                Boolean found66 = a.contains("اسکواش");
                if (found66 == true) {
                    matnInTextView = matnInTextView + "\n" + "اسکواش";
                }
            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_sport_sport_edit;


        String _more_joziat_melk_edari_tejari_view_view_check1 = "";
        String _more_joziat_melk_edari_tejari_view_view_check2 = "";
        String str18 = _more_joziat_melk_edari_tejari_view_view_check.toString();
        if (str18 != "ندارد") {
            String[] splited = str18.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_view_view_check1 = _more_joziat_melk_edari_tejari_view_view_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_view_view_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "دید: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("شهر");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "شهر";
                }
                Boolean found2 = a.contains("اتوبان");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "اتوبان";
                }
                Boolean found3 = a.contains("خیابان");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "خیابان";
                }
                Boolean found4 = a.contains("کوچه");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "کوچه";
                }
                Boolean found5 = a.contains("دریا");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "دریا";
                }
                Boolean found6 = a.contains("جنگل");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "جنگل";
                }
                Boolean found7 = a.contains("کوه");
                if (found7 == true) {
                    matnInTextView = matnInTextView + "\n" + "کوه";
                }
                Boolean found71 = a.contains("باغ");
                if (found71 == true) {
                    matnInTextView = matnInTextView + "\n" + "باغ";
                }
            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_view_view_edit;


        String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta1 = "";
        String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta2 = "";
        String str21 = _more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta.toString();
        if (str21 != "ندارد") {
            String[] splited = str21.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta1 = _more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تاسیسات: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("آب شهری");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "آب شهری";
                }
                Boolean found46 = a.contains("آب چاه");
                if (found46 == true) {
                    matnInTextView = matnInTextView + "\n" + "آب چاه";
                }

                Boolean found2 = a.contains("برق");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "برق";
                }
                Boolean found3 = a.contains("گاز");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "گاز";
                }
                Boolean found4 = a.contains("ژنراتور برقی");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "ژنراتور برقی";
                }
                Boolean found45 = a.contains("منابع تغذیه برق");
                if (found45 == true) {
                    matnInTextView = matnInTextView + "\n" + "منابع تغذیه برق";
                }
            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;


        String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 = "";
        String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam2 = "";
        String str221 = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam.toString();
        if (str221 != "ندارد") {
            String[] splited = str221.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found2 = a.contains("سند در دست اقدام");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "سند در دست اقدام";
                }
            }
        }

        textViewShowPostS.setText(matnInTextView);
    }

    public void GetjsonarrayZAMIN() {
        try {
            String dataServer3 = dataServer234;
            jsonArray = new JSONArray(dataServer3);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                _ID = jsonObject1.getInt("_ID");
                _content = jsonObject1.getString("_post_content");
                _title = jsonObject1.getString("_post_title");
                _guid11 = jsonObject1.getString("_guid11");

                _noe_melk_moamele = jsonObject1.getString("_noe_melk_moamele");
                _noe_melk = jsonObject1.getString("_noe_melk");
                _moshakhasat_asli_melk_karbari_now = jsonObject1.getString("_moshakhasat_asli_melk_karbari_now");
                _moshakhasat_asli_melk_masahat_zamin_after_eslahie = jsonObject1.getString("_moshakhasat_asli_melk_masahat_zamin_after_eslahie");
                _moshakhasat_asli_melk_tol_bar_asli = jsonObject1.getString("_moshakhasat_asli_melk_tol_bar_asli");
                _moshakhasat_asli_melk_number_bar = jsonObject1.getString("_moshakhasat_asli_melk_number_bar");
                _moshakhasat_asli_melk_vaziita_build_vazita_zamin = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_vazita_zamin");
                _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check");
                _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit");
                _more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin = jsonObject1.getString("_more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin");
                _more_joziat_melk_edari_tejari_dastresi_dastres_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_dastresi_dastres_edit");
                _more_joziat_melk_edari_tejari_ghozar_asli = jsonObject1.getString("_more_joziat_melk_edari_tejari_ghozar_asli");
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin");
                _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");
                switch (_noe_melk_moamele) {
                    case "فروش، پیش فروش، معاوضه":
                        _price_shrayet_sell_cheng_price_all_sell_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_price_all_sell_cheng");
                        _price_shrayet_sell_cheng_check_seel_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_check_seel_cheng");
                        _price_shrayet_sell_cheng_max_money = jsonObject1.getString("_price_shrayet_sell_cheng_max_money");
                        _price_shrayet_sell_cheng_money_pish_pay = jsonObject1.getString("_price_shrayet_sell_cheng_money_pish_pay");
                        _price_shrayet_sell_cheng_time_tahvil = jsonObject1.getString("_price_shrayet_sell_cheng_time_tahvil");
                        _price_shrayet_sell_cheng_mizan_anjam_shode = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_anjam_shode");
                        _price_shrayet_sell_cheng_mizan_vam = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_vam");
                        _price_shrayet_sell_cheng_sod_vam = jsonObject1.getString("_price_shrayet_sell_cheng_sod_vam");
                        _price_shrayet_sell_cheng_number_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_number_ghest");
                        _price_shrayet_sell_cheng_price_har_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_price_har_ghest");
                        _price_shrayet_sell_cheng_price_rahn = jsonObject1.getString("_price_shrayet_sell_cheng_price_rahn");
                        break;
                    case "رهن و اجاره":
                        _price_shrayet_rent_price_vadie = jsonObject1.getString("_price_shrayet_rent_price_vadie");
                        _price_shrayet_rent_price_ajare_mohiane = jsonObject1.getString("_price_shrayet_rent_price_ajare_mohiane");
                        break;
                }

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        matnInTextView = matnInTextView + "\n" + _noe_melk_moamele;
        matnInTextView = matnInTextView + "\n" + _noe_melk;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_karbari_now;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_masahat_zamin_after_eslahie;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_tol_bar_asli;
        matnInTextView = matnInTextView + "\n" + _moshakhasat_asli_melk_number_bar;


        String _moshakhasat_asli_melk_vaziita_build_vazita_zamin1 = "";
        String _moshakhasat_asli_melk_vaziita_build_vazita_zamin2 = "";
        String str22 = _moshakhasat_asli_melk_vaziita_build_vazita_zamin.toString();
        if (str22 != "ندارد") {
            String[] splited = str22.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _moshakhasat_asli_melk_vaziita_build_vazita_zamin1 = _moshakhasat_asli_melk_vaziita_build_vazita_zamin1 + " " + splited[i];
            }
            String aaa = "";
            splited = _moshakhasat_asli_melk_vaziita_build_vazita_zamin1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found2 = a.contains("دارای جواز ساخت");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "دارای جواز ساخت";
                }
                Boolean found22 = a.contains("قابل تجمیع");
                if (found22 == true) {
                    matnInTextView = matnInTextView + "\n" + "قابل تجمیع";
                }
                Boolean found21 = a.contains("قابل تفکیک");
                if (found21 == true) {
                    matnInTextView = matnInTextView + "\n" + "قابل تفکیک";
                }

            }
        }
        matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_all_sell_cheng;


        switch (_noe_melk_moamele) {
            case "فروش، پیش فروش، معاوضه":
                matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_all_sell_cheng;

                String _price_shrayet_sell_cheng_check_seel_cheng1 = "";
                String _price_shrayet_sell_cheng_check_seel_cheng2 = "";
                String str2 = _price_shrayet_sell_cheng_check_seel_cheng;
                if (str2 != "ندارد") {
                    String[] splited = str2.split("\"");
                    for (int i = 1; i < splited.length; i++) {
                        _price_shrayet_sell_cheng_check_seel_cheng1 = _price_shrayet_sell_cheng_check_seel_cheng1 + " " + splited[i];
                    }
                    String aaa = "";
                    splited = _price_shrayet_sell_cheng_check_seel_cheng1.split(",");
                    for (int ai = 0; ai < splited.length; ai++) {
                        aaa = aaa + "\n" + splited[ai];
                        aaa = aaa.replace("[", "");
                    }
                    String b = "شرایط معامله: ", a;
                    for (int ai = 0; ai < splited.length; ai++) {
                        a = splited[ai];
                        Boolean found = a.contains("معاوضه");
                        if (found == true) {
                            matnInTextView = matnInTextView + "\n" + "معاوضه دارد";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_max_money;
                        }
                        Boolean found2 = a.contains("پیش فروش");
                        if (found2 == true) {
                            matnInTextView = matnInTextView + "\n" + "پیش فروش";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_money_pish_pay;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_time_tahvil;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_mizan_anjam_shode;
                        }
                        Boolean found3 = a.contains("دارای وام");
                        if (found3 == true) {
                            matnInTextView = matnInTextView + "\n" + "دارای وام";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_mizan_vam;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_sod_vam;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_number_ghest;
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_har_ghest;


                        }
                        Boolean found4 = a.contains("فروش با مستاجر");
                        if (found4 == true) {
                            matnInTextView = matnInTextView + "\n" + "فروش با مستاجر";
                            matnInTextView = matnInTextView + "\n" + _price_shrayet_sell_cheng_price_rahn;

                        }
                    }
                }
                break;
            case "رهن و اجاره":
                matnInTextView = matnInTextView + "\n" + _price_shrayet_rent_price_vadie;
                matnInTextView = matnInTextView + "\n" + _price_shrayet_rent_price_ajare_mohiane;

                break;
        }


        String _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check1 = "";
        String _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check2 = "";
        String str221 = _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check.toString();
        if (str221 != "ندارد") {
            String[] splited = str221.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check1 = _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];

                Boolean found2 = a.contains("مسکونی");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "مسکونی";
                }

                Boolean found21 = a.contains("اداری");
                if (found21 == true) {
                    matnInTextView = matnInTextView + "\n" + "اداری";
                }

                Boolean found22 = a.contains("تجاری");
                if (found22 == true) {
                    matnInTextView = matnInTextView + "\n" + "تجاری";
                }

                Boolean found23 = a.contains("صعنتی");
                if (found23 == true) {
                    matnInTextView = matnInTextView + "\n" + "صعنتی";
                }

                Boolean found24 = a.contains("تفریحی - ورزشی");
                if (found24 == true) {
                    matnInTextView = matnInTextView + "\n" + "تفریحی - ورزشی";
                }

                Boolean found25 = a.contains("آموزشی");
                if (found25 == true) {
                    matnInTextView = matnInTextView + "\n" + "آموزشی";
                }

                Boolean found26 = a.contains("توریستی");
                if (found26 == true) {
                    matnInTextView = matnInTextView + "\n" + "توریستی";
                }

                Boolean found27 = a.contains("دامپروری");
                if (found27 == true) {
                    matnInTextView = matnInTextView + "\n" + "دامپروری";
                }

                Boolean found28 = a.contains("کشاورزی");
                if (found28 == true) {
                    matnInTextView = matnInTextView + "\n" + "کشاورزی";
                }

                Boolean found29 = a.contains("باغشهر - شهرک سازی");
                if (found29 == true) {
                    matnInTextView = matnInTextView + "\n" + "باغشهر - شهرک سازی";
                }

                Boolean found20 = a.contains("خدماتی رفاهی");
                if (found20 == true) {
                    matnInTextView = matnInTextView + "\n" + "خدماتی رفاهی";
                }

                Boolean found211 = a.contains("انبار");
                if (found211 == true) {
                    matnInTextView = matnInTextView + "\n" + "انبار";
                }

                Boolean found212 = a.contains("پارکینگ");
                if (found212 == true) {
                    matnInTextView = matnInTextView + "\n" + "پارکینگ";
                }

            }
        }
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit;


        String _more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin1 = "";
        String _more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin2 = "";
        String str15 = _more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin.toString();
        if (str15 != "ندارد") {
            String[] splited = str15.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin1 = _more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "دسترسی", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("داخل بازار");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "داخل بازار";
                }
                Boolean found2 = a.contains("خیابان اصلی");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "خیابان اصلی";
                }
                Boolean found3 = a.contains("خیابان فرعی");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "خیابان فرعی";
                }
                Boolean found4 = a.contains("میدان");
                if (found4 == true) {
                    matnInTextView = matnInTextView + "\n" + "میدان";
                }
                Boolean found5 = a.contains("کوچه");
                if (found5 == true) {
                    matnInTextView = matnInTextView + "\n" + "کوچه";
                }
                Boolean found6 = a.contains("بن بست");
                if (found6 == true) {
                    matnInTextView = matnInTextView + "\n" + "بن بست";
                }

            }
        }

        // گذر اصلی
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_ghozar_asli;

        String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin1 = "";
        String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin2 = "";
        String str21 = _more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin.toString();
        if (str21 != "ندارد") {
            String[] splited = str21.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin1 = _more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = "تاسیسات: ", a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("آب شهری");
                if (found == true) {
                    matnInTextView = matnInTextView + "\n" + "آب شهری";
                }
                Boolean found1 = a.contains("آب چاه");
                if (found1 == true) {
                    matnInTextView = matnInTextView + "\n" + "آب چاه";
                }

                Boolean found2 = a.contains("برق");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "برق";
                }
                Boolean found3 = a.contains("گاز");
                if (found3 == true) {
                    matnInTextView = matnInTextView + "\n" + "گاز";
                }

            }
        }

        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
        matnInTextView = matnInTextView + "\n" + _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;


        String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 = "";
        String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam2 = "";
        String str225 = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam.toString();
        if (str225 != "ندارد") {
            String[] splited = str225.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found2 = a.contains("سند در دست اقدام");
                if (found2 == true) {
                    matnInTextView = matnInTextView + "\n" + "سند در دست اقدام";
                }
            }
        }

        textViewShowPostS.setText(matnInTextView);
    }


}


