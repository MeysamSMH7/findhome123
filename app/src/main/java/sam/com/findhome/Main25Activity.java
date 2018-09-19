package sam.com.findhome;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main25Activity extends AppCompatActivity {

    ListView listViewEditPage;
    Button button11;

    public static String dataServer23 = "";
    public static String dataServer234 = "";
    JSONObject jsonObject = null;
    JSONArray jsonArray = null;
    JSONArray jsonArrayEDARI = null;
    int ID_send = 0;
    String noe_MELK_android123 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main25);
        

        button11 = (Button) findViewById(R.id.button11);

        listViewEditPage = (ListView) findViewById(R.id.listViewEditPage);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ID_send = extras.getInt("ID_send123");
        }
        Toast.makeText(Main25Activity.this, ID_send + "", Toast.LENGTH_SHORT).show();

        new Connect2("http://padintarh.ir/Android/noemelkfinder.php", ID_send, "").execute();
        new Connect2("http://padintarh.ir/Android/noemelkfinder.php", ID_send, "").execute();

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (noe_MELK_android123 == "") {
                    new Connect2("http://padintarh.ir/Android/noemelkfinder.php", ID_send, "").execute();
                    new Connect2("http://padintarh.ir/Android/noemelkfinder.php", ID_send, "").execute();
                    GetjsonarrayFINDER();

                    Toast.makeText(Main25Activity.this, noe_MELK_android123 + "", Toast.LENGTH_SHORT).show();
                }

                if (noe_MELK_android123 != "") {
                    switch (noe_MELK_android123) {

                        case "مسکونی (خانه)":
                            new Connect4("http://padintarh.ir/Android/show_postMASK.php", ID_send).execute();
                            new Connect4("http://padintarh.ir/Android/show_postMASK.php", ID_send).execute();
                            GetjsonarrayMASKONI();
                            break;

                        case "اداری (دفترکار)":
                            new Connect4("http://padintarh.ir/Android/show_postESARI.php", ID_send).execute();
                            new Connect4("http://padintarh.ir/Android/show_postESARI.php", ID_send).execute();
                            GetjsonarrayEDARI();
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
                            Toast.makeText(Main25Activity.this, "ریدی حاجی", Toast.LENGTH_SHORT).show();

                    }
                }
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
    
    public void GetjsonarrayMASKONI() {
        try {
            String dataServer3 = dataServer234;
            jsonArray = new JSONArray(dataServer3);

            // _more_joziat_melk_edari_tejari_kaf_kaf_check
            ArrayList<product_showpost> product_showpost = new ArrayList<product_showpost>();
            ProductAdapter3 adapter123 = new ProductAdapter3(Main25Activity.this, R.layout.activity_main2, product_showpost);
            listViewEditPage.setAdapter(adapter123);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                int ID = jsonObject1.getInt("ID");
                String content = jsonObject1.getString("post_content");
                String title = jsonObject1.getString("post_title");
                String guid11 = jsonObject1.getString("guid11");
                String _noe_melk_moamele = jsonObject1.getString("_noe_melk_moamele");
                String _noe_melk = jsonObject1.getString("_noe_melk");
                String _moshakhasat_asli_melk_noe_bana = jsonObject1.getString("_moshakhasat_asli_melk_noe_bana");
                String _moshakhasat_asli_melk_masahat_build = jsonObject1.getString("_moshakhasat_asli_melk_masahat_build");
                String _moshakhasat_asli_melk_masahat_zamin = jsonObject1.getString("_moshakhasat_asli_melk_masahat_zamin");
                String _moshakhasat_asli_melk_number_room = jsonObject1.getString("_moshakhasat_asli_melk_number_room");
                String _moshakhasat_asli_melk_number_parking = jsonObject1.getString("_moshakhasat_asli_melk_number_parking");
                String _moshakhasat_asli_melk_sale_build = jsonObject1.getString("_moshakhasat_asli_melk_sale_build");
                String _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio");
                String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_ghabel_sokonat");
                String _price_shrayet_sell_cheng_check_seel_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_check_seel_cheng");
                String _price_shrayet_sell_cheng_max_money = jsonObject1.getString("_price_shrayet_sell_cheng_max_money");
                String _price_shrayet_sell_cheng_money_pish_pay = jsonObject1.getString("_price_shrayet_sell_cheng_money_pish_pay");
                String _price_shrayet_sell_cheng_time_tahvil = jsonObject1.getString("_price_shrayet_sell_cheng_time_tahvil");
                String _price_shrayet_sell_cheng_mizan_anjam_shode = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_anjam_shode");
                String _price_shrayet_sell_cheng_mizan_vam = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_vam");
                String _price_shrayet_sell_cheng_sod_vam = jsonObject1.getString("_price_shrayet_sell_cheng_sod_vam");
                String _price_shrayet_sell_cheng_number_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_number_ghest");
                String _price_shrayet_sell_cheng_price_har_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_price_har_ghest");
                String _price_shrayet_sell_cheng_price_rahn = jsonObject1.getString("_price_shrayet_sell_cheng_price_rahn");
                String _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe");
                String _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe");
                String _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe");
                String _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_all_vahed");
                String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build");
                String _more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari");
                String _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari");
                String _more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon");
                String _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon");
                String _more_joziat_melk_edari_tejari_wc_wc_irani = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_wc_irani");
                String _more_joziat_melk_edari_tejari_wc_wc_us = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_wc_us");
                String _more_joziat_melk_edari_tejari_wc_bath = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_bath");
                String _more_joziat_melk_edari_tejari_kitchen_kitchen_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_kitchen_check");
                String _more_joziat_melk_edari_tejari_kitchen_kitchen_radio = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_kitchen_radio");
                String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_darai_kabinet");
                String _more_joziat_melk_edari_tejari_kitchen_badane_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_badane_kabinet");
                String _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_safhe_kabinet");
                String _more_joziat_melk_edari_tejari_kitchen_roye_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_roye_kabinet");
                String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen");
                String _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen");
                String _more_joziat_melk_edari_tejari_neshiman_neshiman_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_neshiman_neshiman_check");
                String _more_joziat_melk_edari_tejari_neshiman_neshiman_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_neshiman_neshiman_edit");
                String _more_joziat_melk_edari_tejari_shekle_build_radio = jsonObject1.getString("_more_joziat_melk_edari_tejari_shekle_build_radio");
                String _more_joziat_melk_edari_tejari_nama_nama_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_check");
                String _more_joziat_melk_edari_tejari_nama_nama_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_edit");
                String _more_joziat_melk_edari_tejari_eskelet_eskelet_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_eskelet_eskelet_check");
                String _more_joziat_melk_edari_tejari_eskelet_eskelet_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_eskelet_eskelet_edit");
                String _more_joziat_melk_edari_tejari_kaf_kaf_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf_kaf_check");
                String _more_joziat_melk_edari_tejari_kaf_kaf_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf_kaf_edit");
                String _more_joziat_melk_edari_tejari_divar_divar_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar_divar_check");
                String _more_joziat_melk_edari_tejari_divar_divar_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar_divar_edit");
                String _more_joziat_melk_edari_tejari_coldhot_coldhot_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_check");
                String _more_joziat_melk_edari_tejari_coldhot_coldhot_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_edit");
                String _more_joziat_melk_edari_tejari_refahi_refahi_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_check");
                String _more_joziat_melk_edari_tejari_refahi_refahi_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_edit");
                String _more_joziat_melk_edari_tejari_safe_safe_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_check");
                String _more_joziat_melk_edari_tejari_safe_safe_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_edit");
                String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta");
                String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit");
                String _more_joziat_melk_edari_tejari_sport_sport_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_sport_sport_check");
                String _more_joziat_melk_edari_tejari_sport_sport_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_sport_sport_edit");
                String _more_joziat_melk_edari_tejari_view_view_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_view_view_check");
                String _more_joziat_melk_edari_tejari_view_view_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_view_view_edit");
                String _more_joziat_melk_edari_tejari_nor_nor_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_nor_nor_check");
                String _more_joziat_melk_edari_tejari_tasisat_tasisat_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_check");
                String _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");
                String _more_joziat_melk_edari_tejari_safe = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe");
                String _more_joziat_melk_edari_tejari_emkanatBuild = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild");
                String _more_joziat_melk_edari_tejari_divar = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar");
                String _more_joziat_melk_edari_tejari_kaf = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf");
                String _more_joziat_melk_edari_tejari_shekle_build_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_shekle_build_check");
                String _more_joziat_melk_edari_tejari_moghit_build = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build");
                String _price_shrayet = jsonObject1.getString("_price_shrayet");
                String _price_shrayet_sell_cheng_price_all_sell_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_price_all_sell_cheng");


                String _more_joziat_melk_edari_tejari_refahi_refahi_check_edari = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_check_edari");
                String _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari");
                String _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta");
                String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari");
                String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari");
                String _moshakhasat_asli_melk_vaziita_build_rebuild = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_rebuild");
                String _more_joziat_melk_edari_tejari_tozih_about_melk = jsonObject1.getString("_more_joziat_melk_edari_tejari_tozih_about_melk");
                String _moshakhasat_asli_melk_moghiat_build = jsonObject1.getString("_moshakhasat_asli_melk_moghiat_build");

/*
                product_showpost.add(new product_showpost(ID, content, title, guid11
                        , _noe_melk_moamele //  _noe_melk_moamele;
                        , _noe_melk //  _noe_melk;
                        , _moshakhasat_asli_melk_noe_bana //  _moshakhasat_asli_melk_noe_bana;
                        , _moshakhasat_asli_melk_masahat_build //  _moshakhasat_asli_melk_masahat_build;
                        , _moshakhasat_asli_melk_masahat_zamin //  _moshakhasat_asli_melk_masahat_zamin;
                        , _moshakhasat_asli_melk_number_room //  _moshakhasat_asli_melk_number_room;
                        , _moshakhasat_asli_melk_number_parking //  _moshakhasat_asli_melk_number_parking;
                        , _moshakhasat_asli_melk_sale_build //  _moshakhasat_asli_melk_sale_build;
                        , _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio //  _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio;
                        , _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat //  _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat;
                        , _price_shrayet_sell_cheng_check_seel_cheng //  _price_shrayet_sell_cheng_check_seel_cheng;
                        , _price_shrayet_sell_cheng_max_money //  _price_shrayet_sell_cheng_max_money;
                        , _price_shrayet_sell_cheng_money_pish_pay //  _price_shrayet_sell_cheng_money_pish_pay;
                        , _price_shrayet_sell_cheng_time_tahvil //  _price_shrayet_sell_cheng_time_tahvil;
                        , _price_shrayet_sell_cheng_mizan_anjam_shode //  _price_shrayet_sell_cheng_mizan_anjam_shode;
                        , _price_shrayet_sell_cheng_mizan_vam //  _price_shrayet_sell_cheng_mizan_vam;
                        , _price_shrayet_sell_cheng_sod_vam //  _price_shrayet_sell_cheng_sod_vam;
                        , _price_shrayet_sell_cheng_number_ghest //  _price_shrayet_sell_cheng_number_ghest;
                        , _price_shrayet_sell_cheng_price_har_ghest //  _price_shrayet_sell_cheng_price_har_ghest;
                        , _price_shrayet_sell_cheng_price_rahn //  _price_shrayet_sell_cheng_price_rahn;
                        , _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe //  _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe;
                        , _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe //  _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe;
                        , _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe //  _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe;
                        , _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed //  _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed;
                        , _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build //  _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build;
                        , _more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari //  _more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari;
                        , _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari //  _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari;
                        , _more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon //  _more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon;
                        , _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon //  _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon;
                        , _more_joziat_melk_edari_tejari_wc_wc_irani //  _more_joziat_melk_edari_tejari_wc_wc_irani;
                        , _more_joziat_melk_edari_tejari_wc_wc_us //  _more_joziat_melk_edari_tejari_wc_wc_us;
                        , _more_joziat_melk_edari_tejari_wc_bath //  _more_joziat_melk_edari_tejari_wc_bath;
                        , _more_joziat_melk_edari_tejari_kitchen_kitchen_check //  _more_joziat_melk_edari_tejari_kitchen_kitchen_check;
                        , _more_joziat_melk_edari_tejari_kitchen_kitchen_radio //  _more_joziat_melk_edari_tejari_kitchen_kitchen_radio;
                        , _more_joziat_melk_edari_tejari_kitchen_darai_kabinet //  _more_joziat_melk_edari_tejari_kitchen_darai_kabinet;
                        , _more_joziat_melk_edari_tejari_kitchen_badane_kabinet //  _more_joziat_melk_edari_tejari_kitchen_badane_kabinet;
                        , _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet //  _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet;
                        , _more_joziat_melk_edari_tejari_kitchen_roye_kabinet //  _more_joziat_melk_edari_tejari_kitchen_roye_kabinet;
                        , _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen //  _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen;
                        , _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen //  _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen;
                        , _more_joziat_melk_edari_tejari_neshiman_neshiman_check //  _more_joziat_melk_edari_tejari_neshiman_neshiman_check;
                        , _more_joziat_melk_edari_tejari_neshiman_neshiman_edit //  _more_joziat_melk_edari_tejari_neshiman_neshiman_edit;
                        , _more_joziat_melk_edari_tejari_shekle_build_radio //  _more_joziat_melk_edari_tejari_shekle_build_radio;
                        , _more_joziat_melk_edari_tejari_nama_nama_check //  _more_joziat_melk_edari_tejari_nama_nama_check;
                        , _more_joziat_melk_edari_tejari_nama_nama_edit //  _more_joziat_melk_edari_tejari_nama_nama_edit;
                        , _more_joziat_melk_edari_tejari_eskelet_eskelet_check //  _more_joziat_melk_edari_tejari_eskelet_eskelet_check;
                        , _more_joziat_melk_edari_tejari_eskelet_eskelet_edit //  _more_joziat_melk_edari_tejari_eskelet_eskelet_edit;
                        , _more_joziat_melk_edari_tejari_kaf_kaf_check //  _more_joziat_melk_edari_tejari_kaf_kaf_check;
                        , _more_joziat_melk_edari_tejari_kaf_kaf_edit //  _more_joziat_melk_edari_tejari_kaf_kaf_edit;
                        , _more_joziat_melk_edari_tejari_divar_divar_check //  _more_joziat_melk_edari_tejari_divar_divar_check;
                        , _more_joziat_melk_edari_tejari_divar_divar_edit //  _more_joziat_melk_edari_tejari_divar_divar_edit;
                        , _more_joziat_melk_edari_tejari_coldhot_coldhot_check //  _more_joziat_melk_edari_tejari_coldhot_coldhot_check;
                        , _more_joziat_melk_edari_tejari_coldhot_coldhot_edit //  _more_joziat_melk_edari_tejari_coldhot_coldhot_edit;
                        , _more_joziat_melk_edari_tejari_refahi_refahi_check //  _more_joziat_melk_edari_tejari_refahi_refahi_check;
                        , _more_joziat_melk_edari_tejari_refahi_refahi_edit //  _more_joziat_melk_edari_tejari_refahi_refahi_edit;
                        , _more_joziat_melk_edari_tejari_safe_safe_check //  _more_joziat_melk_edari_tejari_safe_safe_check;
                        , _more_joziat_melk_edari_tejari_safe_safe_edit //  _more_joziat_melk_edari_tejari_safe_safe_edit;
                        , _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta //  _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;
                        , _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit //  _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit;
                        , _more_joziat_melk_edari_tejari_sport_sport_check //  _more_joziat_melk_edari_tejari_sport_sport_check;
                        , _more_joziat_melk_edari_tejari_sport_sport_edit //  _more_joziat_melk_edari_tejari_sport_sport_edit;
                        , _more_joziat_melk_edari_tejari_view_view_check //  _more_joziat_melk_edari_tejari_view_view_check;
                        , _more_joziat_melk_edari_tejari_view_view_edit //  _more_joziat_melk_edari_tejari_view_view_edit;
                        , _more_joziat_melk_edari_tejari_nor_nor_check //  _more_joziat_melk_edari_tejari_nor_nor_check;
                        , _more_joziat_melk_edari_tejari_tasisat_tasisat_check //  _more_joziat_melk_edari_tejari_tasisat_tasisat_check;
                        , _more_joziat_melk_edari_tejari_tasisat_tasisat_edit //  _more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat //  _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat //  _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam //  _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;
                        , _more_joziat_melk_edari_tejari_safe //  _more_joziat_melk_edari_tejari_safe;
                        , _more_joziat_melk_edari_tejari_emkanatBuild //  _more_joziat_melk_edari_tejari_emkanatBuild;
                        , _more_joziat_melk_edari_tejari_divar //  _more_joziat_melk_edari_tejari_divar;
                        , _more_joziat_melk_edari_tejari_kaf //  _more_joziat_melk_edari_tejari_kaf;
                        , _more_joziat_melk_edari_tejari_shekle_build_check //  _more_joziat_melk_edari_tejari_shekle_build_check;
                        , _more_joziat_melk_edari_tejari_moghit_build //  _more_joziat_melk_edari_tejari_moghit_build;
                        , _price_shrayet //  _price_shrayet;
                        , _price_shrayet_sell_cheng_price_all_sell_cheng

                        
                        , _more_joziat_melk_edari_tejari_refahi_refahi_check_edari // _more_joziat_melk_edari_tejari_refahi_refahi_check_edari;
                        , _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari // _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari;
                        , _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta // _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta;
                        , _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari // _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari;
                        , _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari // _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari;
                        , _moshakhasat_asli_melk_vaziita_build_rebuild // _moshakhasat_asli_melk_vaziita_build_rebuild;
                        , _more_joziat_melk_edari_tejari_tozih_about_melk // _more_joziat_melk_edari_tejari_tozih_about_melk;
                        , _moshakhasat_asli_melk_moghiat_build // _moshakhasat_asli_melk_moghiat_build;


                ));
                adapter123.notifyDataSetChanged();
//set again adapter!

*/
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    
    public class ProductAdapter3 extends ArrayAdapter {


        private int resourceId;
        private Activity activity;
        private ArrayList<product_showpost> productArrayList;

        public ProductAdapter3(Activity activity, int resourceId, ArrayList<product_showpost> object) {
            super(activity, resourceId, object);
            this.activity = activity;
            this.resourceId = resourceId;
            this.productArrayList = object;
        }

        @Override
        public View getView(final int position, View converView, ViewGroup parent) {
            View view = converView;
            view = this.activity.getLayoutInflater().inflate(this.resourceId, null);


            final product_showpost product_showpost = productArrayList.get(position);

            //-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1 = "";
            String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat2 = "";
            String str1 = product_showpost._moshakhasat_asli_melk_vaziita_build_ghabel_sokonat;
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
                        b = b + "\n" + "سنگ";
                    }
                    Boolean found2 = a.contains("سرامیک");
                    if (found2 == true) {
                        b = b + "\n" + "سرامیک";
                    }
                    Boolean found3 = a.contains("پارکت");
                    if (found3 == true) {
                        b = b + "\n" + "پارکت";
                    }
                    Boolean found4 = a.contains("کفپوش");
                    if (found4 == true) {
                        b = b + "\n" + "کفپوش";
                    }
                    Boolean found5 = a.contains("موکت");
                    if (found5 == true) {
                        b = b + "\n" + "موکت";
                    }
                    Boolean found6 = a.contains("موزاییک");
                    if (found6 == true) {
                        b = b + "\n" + "موزاییک";
                    }
                    Boolean found7 = a.contains("سیمان");
                    if (found7 == true) {
                        b = b + "\n" + "سیمان";
                    }
                    Boolean found8 = a.contains("کف پله دار");
                    if (found8 == true) {
                        b = b + "\n" + "کف پله دار";
                    }
                }
                _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat2 = b;
            } else {
                _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _price_shrayet_sell_cheng_check_seel_cheng1 = "";
            String _price_shrayet_sell_cheng_check_seel_cheng2 = "";
            String str2 = product_showpost._price_shrayet_sell_cheng_check_seel_cheng;
            if (str2 != "ندارد") {
                String[] splited = str2.split("\"");
                for (int i = 1; i < splited.length; i++) {
                    _price_shrayet_sell_cheng_check_seel_cheng1 = _price_shrayet_sell_cheng_check_seel_cheng1 + " " + splited[i];
                }
                String aaa = "";
                splited = _price_shrayet_sell_cheng_check_seel_cheng1.split(",");
                for (int ai = 0; ai < splited.length; ai++) {
                    aaa = aaa + "\n" + splited[ai];
                    aaa = aaa.replace("]", "");
                }
                String b = "شرایط معامله: ", a;
                for (int ai = 0; ai < splited.length; ai++) {
                    a = splited[ai];
                    Boolean found = a.contains("معاوضه");
                    if (found == true) {
                        b = b + "\n" + "معاوضه";
                    }
                    Boolean found2 = a.contains("پیش فروش");
                    if (found2 == true) {
                        b = b + "\n" + "پیش فروش";
                    }
                    Boolean found3 = a.contains("دارای وام");
                    if (found3 == true) {
                        b = b + "\n" + "دارای وام";
                    }
                    Boolean found4 = a.contains("فروش با مستاجر");
                    if (found4 == true) {
                        b = b + "\n" + "فروش با مستاجر";
                    }
                }
                _price_shrayet_sell_cheng_check_seel_cheng2 = b;
            } else {
                _price_shrayet_sell_cheng_check_seel_cheng2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build1 = "";
            String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build2 = "";
            String str3 = product_showpost._more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build;
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
                    }
                }
                _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build2 = b;
            } else {
                _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_kitchen_kitchen_check1 = "";
            String _more_joziat_melk_edari_tejari_kitchen_kitchen_check2 = "";
            String str4 = product_showpost._more_joziat_melk_edari_tejari_kitchen_kitchen_check;
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
                    }
                }
                _more_joziat_melk_edari_tejari_kitchen_kitchen_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_kitchen_kitchen_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet1 = "";
            String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet2 = "";
            String str5 = product_showpost._more_joziat_melk_edari_tejari_kitchen_darai_kabinet;
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
                    }
                }
                _more_joziat_melk_edari_tejari_kitchen_darai_kabinet2 = b;
            } else {
                _more_joziat_melk_edari_tejari_kitchen_darai_kabinet2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen1 = "";
            String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen2 = "";
            String str6 = product_showpost._more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen;
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
                    }
                }
                _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen2 = b;
            } else {
                _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_neshiman_neshiman_check1 = "";
            String _more_joziat_melk_edari_tejari_neshiman_neshiman_check2 = "";
            String str7 = product_showpost._more_joziat_melk_edari_tejari_neshiman_neshiman_check;
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
                        b = b + "\n" + "شومینه";
                    }
                    Boolean found2 = a.contains("سقف بالای 4 متر");
                    if (found2 == true) {
                        b = b + "\n" + "سقف بالای 4 متر";
                    }
                    Boolean found3 = a.contains("مبله");
                    if (found3 == true) {
                        b = b + "\n" + "مبله";
                    }
                }
                _more_joziat_melk_edari_tejari_neshiman_neshiman_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_neshiman_neshiman_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_nama_nama_check1 = "";
            String _more_joziat_melk_edari_tejari_nama_nama_check2 = "";
            String str8 = product_showpost._more_joziat_melk_edari_tejari_nama_nama_check;
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
                        b = b + "\n" + "سنگ";
                    }
                    Boolean found2 = a.contains("آجر");
                    if (found2 == true) {
                        b = b + "\n" + "آجر";
                    }
                    Boolean found3 = a.contains("سیمان");
                    if (found3 == true) {
                        b = b + "\n" + "سیمان";
                    }
                    Boolean found4 = a.contains("شیشه");
                    if (found4 == true) {
                        b = b + "\n" + "شیشه";
                    }
                    Boolean found5 = a.contains("چوب");
                    if (found5 == true) {
                        b = b + "\n" + "چوب";
                    }
                    Boolean found6 = a.contains("کامپوزیت");
                    if (found6 == true) {
                        b = b + "\n" + "کامپوزیت";
                    }
                    Boolean found7 = a.contains("نورپردازی");
                    if (found7 == true) {
                        b = b + "\n" + "نورپردازی";
                    }
                }
                _more_joziat_melk_edari_tejari_nama_nama_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_nama_nama_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_eskelet_eskelet_check1 = "";
            String _more_joziat_melk_edari_tejari_eskelet_eskelet_check2 = "";
            String str9 = product_showpost._more_joziat_melk_edari_tejari_eskelet_eskelet_check;
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
                        b = b + "\n" + "بتنی";
                    }
                    Boolean found2 = a.contains("فلزی");
                    if (found2 == true) {
                        b = b + "\n" + "فلزی";
                    }
                    Boolean found3 = a.contains("آجی");
                    if (found3 == true) {
                        b = b + "\n" + "آجی";
                    }
                    Boolean found4 = a.contains("چوبی");
                    if (found4 == true) {
                        b = b + "\n" + "چوبی";
                    }
                }
                _more_joziat_melk_edari_tejari_eskelet_eskelet_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_eskelet_eskelet_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_kaf_kaf_check1 = "";
            String _more_joziat_melk_edari_tejari_kaf_kaf_check2 = "";
            String str11 = product_showpost._more_joziat_melk_edari_tejari_kaf_kaf_check;
            if (str11 != "ندارد") {
                String[] splited = str11.split("\"");
                for (int i = 1; i < splited.length; i++) {
                    _more_joziat_melk_edari_tejari_kaf_kaf_check1 = _more_joziat_melk_edari_tejari_kaf_kaf_check1 + " " + splited[i];
                }
                String aaa = "";
                splited = _more_joziat_melk_edari_tejari_kaf_kaf_check1.split(",");
                for (int ai = 0; ai < splited.length; ai++) {
                    aaa = aaa + "\n" + splited[ai];
                    aaa = aaa.replace("]", "");
                }
                String b = "کف خانه: ", a;
                for (int ai = 0; ai < splited.length; ai++) {
                    a = splited[ai];
                    Boolean found = a.contains("سنگ");
                    if (found == true) {
                        b = b + "\n" + "سنگ";
                    }
                    Boolean found2 = a.contains("سرامیک");
                    if (found2 == true) {
                        b = b + "\n" + "سرامیک";
                    }
                    Boolean found3 = a.contains("پارکت");
                    if (found3 == true) {
                        b = b + "\n" + "پارکت";
                    }
                    Boolean found4 = a.contains("کفپوش");
                    if (found4 == true) {
                        b = b + "\n" + "کفپوش";
                    }
                    Boolean found5 = a.contains("موکت");
                    if (found5 == true) {
                        b = b + "\n" + "موکت";
                    }
                    Boolean found6 = a.contains("موزاییک");
                    if (found6 == true) {
                        b = b + "\n" + "موزاییک";
                    }
                    Boolean found7 = a.contains("سیمان");
                    if (found7 == true) {
                        b = b + "\n" + "سیمان";
                    }
                    Boolean found8 = a.contains("کف پله دار");
                    if (found8 == true) {
                        b = b + "\n" + "کف پله دار";
                    }
                }
                _more_joziat_melk_edari_tejari_kaf_kaf_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_kaf_kaf_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_divar_divar_check1 = "";
            String _more_joziat_melk_edari_tejari_divar_divar_check2 = "";
            String str12 = product_showpost._more_joziat_melk_edari_tejari_divar_divar_check;
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
                        b = b + "\n" + "سنگ";
                    }
                    Boolean found9 = a.contains("رنگ");
                    if (found9 == true) {
                        b = b + "\n" + "رنگ";
                    }
                    Boolean found2 = a.contains("کاشی/ سرامیک");
                    if (found2 == true) {
                        b = b + "\n" + "کاشی/ سرامیک";
                    }
                    Boolean found3 = a.contains("کاغذ دیواری");
                    if (found3 == true) {
                        b = b + "\n" + "کاغذ دیواری";
                    }
                    Boolean found4 = a.contains("چوب/ دیوارکوب");
                    if (found4 == true) {
                        b = b + "\n" + "چوب/ دیوارکوب";
                    }
                    Boolean found5 = a.contains("سیمان");
                    if (found5 == true) {
                        b = b + "\n" + "سیمان";
                    }
                    Boolean found6 = a.contains("گچ");
                    if (found6 == true) {
                        b = b + "\n" + "گچ";
                    }
                    Boolean found7 = a.contains("آجر");
                    if (found7 == true) {
                        b = b + "\n" + "آجر";
                    }
                }
                _more_joziat_melk_edari_tejari_divar_divar_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_divar_divar_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_coldhot_coldhot_check1 = "";
            String _more_joziat_melk_edari_tejari_coldhot_coldhot_check2 = "";
            String str13 = product_showpost._more_joziat_melk_edari_tejari_coldhot_coldhot_check;
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
                        b = b + "\n" + "کولر";
                    }
                    Boolean found2 = a.contains("کولرگازی/ اسپلیت");
                    if (found2 == true) {
                        b = b + "\n" + "کولرگازی/ اسپلیت";
                    }
                    Boolean found3 = a.contains("بخاری");
                    if (found3 == true) {
                        b = b + "\n" + "بخاری";
                    }
                    Boolean found4 = a.contains("پکیج/ رادیاتور");
                    if (found4 == true) {
                        b = b + "\n" + "پکیج/ رادیاتور";
                    }
                    Boolean found5 = a.contains("دیگ/ رادیاتور");
                    if (found5 == true) {
                        b = b + "\n" + "دیگ/ رادیاتور";
                    }
                    Boolean found6 = a.contains("چیلر/ فن کوئل");
                    if (found6 == true) {
                        b = b + "\n" + "چیلر/ فن کوئل";
                    }
                    Boolean found7 = a.contains("آبگرمکن خورشیدی");
                    if (found7 == true) {
                        b = b + "\n" + "آبگرمکن خورشیدی";
                    }
                    Boolean found79 = a.contains("هواساز");
                    if (found79 == true) {
                        b = b + "\n" + "هواساز";
                    }
                }
                _more_joziat_melk_edari_tejari_coldhot_coldhot_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_coldhot_coldhot_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_refahi_refahi_check1 = "";
            String _more_joziat_melk_edari_tejari_refahi_refahi_check2 = "";
            String str14 = product_showpost._more_joziat_melk_edari_tejari_refahi_refahi_check;
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
                        b = b + "\n" + "آسانسور";
                    }
                    Boolean found2 = a.contains("درب پارکینگ ریموت دار");
                    if (found2 == true) {
                        b = b + "\n" + "درب پارکینگ ریموت دار";
                    }
                    Boolean found3 = a.contains("شوتیگ زباله");
                    if (found3 == true) {
                        b = b + "\n" + "شوتیگ زباله";
                    }
                    Boolean found4 = a.contains("اینترنت پرسرعت");
                    if (found4 == true) {
                        b = b + "\n" + "اینترنت پرسرعت";
                    }
                    Boolean found5 = a.contains("آنتن مزکزی");
                    if (found5 == true) {
                        b = b + "\n" + "آنتن مزکزی";
                    }
                    Boolean found6 = a.contains("شبکه داخلی");
                    if (found6 == true) {
                        b = b + "\n" + "شبکه داخلی";
                    }
                }
                _more_joziat_melk_edari_tejari_refahi_refahi_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_refahi_refahi_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_safe_safe_check1 = "";
            String _more_joziat_melk_edari_tejari_safe_safe_check2 = "";
            String str15 = product_showpost._more_joziat_melk_edari_tejari_safe_safe_check;
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
                        b = b + "\n" + "دزدگیر";
                    }
                    Boolean found2 = a.contains("دوربین مداربسته");
                    if (found2 == true) {
                        b = b + "\n" + "دوربین مداربسته";
                    }
                    Boolean found3 = a.contains("آیفون تصویری");
                    if (found3 == true) {
                        b = b + "\n" + "آیفون تصویری";
                    }
                    Boolean found4 = a.contains("درب ضد سرقت");
                    if (found4 == true) {
                        b = b + "\n" + "درب ضد سرقت";
                    }
                    Boolean found5 = a.contains("سیستم اعلام آتش");
                    if (found5 == true) {
                        b = b + "\n" + "سیستم اعلام آتش";
                    }
                    Boolean found6 = a.contains("سیستم اطفاء حریق");
                    if (found6 == true) {
                        b = b + "\n" + "سیستم اطفاء حریق";
                    }
                }
                _more_joziat_melk_edari_tejari_safe_safe_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_safe_safe_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1 = "";
            String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta2 = "";
            String str16 = product_showpost._more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;
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
                        b = b + "\n" + "حیاط";
                    }
                    Boolean found2 = a.contains("حیاط خلوت");
                    if (found2 == true) {
                        b = b + "\n" + "حیاط خلوت";
                    }
                    Boolean found3 = a.contains("فضای سبز");
                    if (found3 == true) {
                        b = b + "\n" + "فضای سبز";
                    }
                    Boolean found4 = a.contains("سرایداری");
                    if (found4 == true) {
                        b = b + "\n" + "سرایداری";
                    }
                    Boolean found5 = a.contains("نگهبانی");
                    if (found5 == true) {
                        b = b + "\n" + "نگهبانی";
                    }
                    Boolean found6 = a.contains("لابی");
                    if (found6 == true) {
                        b = b + "\n" + "لابی";
                    }
                    Boolean found62 = a.contains("سالن اجتماعات");
                    if (found62 == true) {
                        b = b + "\n" + "سالن اجتماعات";
                    }
                    Boolean found61 = a.contains("باغ");
                    if (found61 == true) {
                        b = b + "\n" + "باغ";
                    }
                    Boolean found60 = a.contains("آلاچیق");
                    if (found60 == true) {
                        b = b + "\n" + "آلاچیق";
                    }
                    Boolean found69 = a.contains("آب نما");
                    if (found69 == true) {
                        b = b + "\n" + "آب نما";
                    }
                    Boolean found68 = a.contains("بام سبز");
                    if (found68 == true) {
                        b = b + "\n" + "بام سبز";
                    }
                    Boolean found67 = a.contains("باربیکیو");
                    if (found67 == true) {
                        b = b + "\n" + "باربیکیو";
                    }
                }
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta2 = b;
            } else {
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_sport_sport_check1 = "";
            String _more_joziat_melk_edari_tejari_sport_sport_check2 = "";
            String str17 = product_showpost._more_joziat_melk_edari_tejari_sport_sport_check;
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
                        b = b + "\n" + "استخر";
                    }
                    Boolean found2 = a.contains("سونا");
                    if (found2 == true) {
                        b = b + "\n" + "سونا";
                    }
                    Boolean found3 = a.contains("جوزی");
                    if (found3 == true) {
                        b = b + "\n" + "جوزی";
                    }
                    Boolean found4 = a.contains("بیلیارد");
                    if (found4 == true) {
                        b = b + "\n" + "بیلیارد";
                    }
                    Boolean found5 = a.contains("فوتبال");
                    if (found5 == true) {
                        b = b + "\n" + "فوتبال";
                    }
                    Boolean found6 = a.contains("بسکتبال");
                    if (found6 == true) {
                        b = b + "\n" + "بسکتبال";
                    }
                    Boolean found61 = a.contains("والیبال");
                    if (found61 == true) {
                        b = b + "\n" + "والیبال";
                    }
                    Boolean found62 = a.contains("تنیس");
                    if (found62 == true) {
                        b = b + "\n" + "تنیس";
                    }
                    Boolean found63 = a.contains("پینگ پنگ");
                    if (found63 == true) {
                        b = b + "\n" + "پینگ پنگ";
                    }
                    Boolean found64 = a.contains("سالن بدن سازی");
                    if (found64 == true) {
                        b = b + "\n" + "سالن بدن سازی";
                    }
                    Boolean found65 = a.contains("زمین بازی کودکان");
                    if (found65 == true) {
                        b = b + "\n" + "زمین بازی کودکان";
                    }
                    Boolean found66 = a.contains("اسکواش");
                    if (found66 == true) {
                        b = b + "\n" + "اسکواش";
                    }
                }
                _more_joziat_melk_edari_tejari_sport_sport_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_sport_sport_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_view_view_check1 = "";
            String _more_joziat_melk_edari_tejari_view_view_check2 = "";
            String str18 = product_showpost._more_joziat_melk_edari_tejari_view_view_check;
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
                        b = b + "\n" + "شهر";
                    }
                    Boolean found2 = a.contains("اتوبان");
                    if (found2 == true) {
                        b = b + "\n" + "اتوبان";
                    }
                    Boolean found3 = a.contains("خیابان");
                    if (found3 == true) {
                        b = b + "\n" + "خیابان";
                    }
                    Boolean found4 = a.contains("کوچه");
                    if (found4 == true) {
                        b = b + "\n" + "کوچه";
                    }
                    Boolean found5 = a.contains("دریا");
                    if (found5 == true) {
                        b = b + "\n" + "دریا";
                    }
                    Boolean found6 = a.contains("جنگل");
                    if (found6 == true) {
                        b = b + "\n" + "جنگل";
                    }
                    Boolean found7 = a.contains("کوه");
                    if (found7 == true) {
                        b = b + "\n" + "کوه";
                    }
                    Boolean found71 = a.contains("باغ");
                    if (found71 == true) {
                        b = b + "\n" + "باغ";
                    }
                }
                _more_joziat_melk_edari_tejari_view_view_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_view_view_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_nor_nor_check1 = "";
            String _more_joziat_melk_edari_tejari_nor_nor_check2 = "";
            String str19 = product_showpost._more_joziat_melk_edari_tejari_nor_nor_check;
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
                        b = b + "\n" + "شمال";
                    }
                    Boolean found2 = a.contains("جنوب");
                    if (found2 == true) {
                        b = b + "\n" + "جنوب";
                    }
                    Boolean found3 = a.contains("شرق");
                    if (found3 == true) {
                        b = b + "\n" + "شرق";
                    }
                    Boolean found4 = a.contains("غرب");
                    if (found4 == true) {
                        b = b + "\n" + "غرب";
                    }
                }
                _more_joziat_melk_edari_tejari_nor_nor_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_nor_nor_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_tasisat_tasisat_check1 = "";
            String _more_joziat_melk_edari_tejari_tasisat_tasisat_check2 = "";
            String str21 = product_showpost._more_joziat_melk_edari_tejari_tasisat_tasisat_check;
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
                        b = b + "\n" + "آب شهری";
                    }
                    Boolean found2 = a.contains("برق");
                    if (found2 == true) {
                        b = b + "\n" + "برق";
                    }
                    Boolean found3 = a.contains("گاز");
                    if (found3 == true) {
                        b = b + "\n" + "گاز";
                    }
                    Boolean found4 = a.contains("ژنراتور برقی");
                    if (found4 == true) {
                        b = b + "\n" + "ژنراتور برقی";
                    }
                }
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 = "";
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam2 = "";
            String str22 = product_showpost._more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;
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
                    }
                }
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam2 = b;
            } else {
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------


            String post_content2 = product_showpost.post_content;
            String post_title2 = product_showpost.post_title;
            String guid112 = product_showpost.guid11;
            String _noe_melk_moamele2 = product_showpost._noe_melk_moamele;
            String _noe_melk2 = product_showpost._noe_melk;
            String _moshakhasat_asli_melk_noe_bana2 = product_showpost._moshakhasat_asli_melk_noe_bana;
            String _moshakhasat_asli_melk_masahat_build2 = product_showpost._moshakhasat_asli_melk_masahat_build;
            String _moshakhasat_asli_melk_masahat_zamin2 = product_showpost._moshakhasat_asli_melk_masahat_zamin;
            String _moshakhasat_asli_melk_number_room2 = product_showpost._moshakhasat_asli_melk_number_room;
            String _moshakhasat_asli_melk_number_parking2 = product_showpost._moshakhasat_asli_melk_number_parking;
            String _moshakhasat_asli_melk_sale_build2 = product_showpost._moshakhasat_asli_melk_sale_build;
            String _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio2 = product_showpost._moshakhasat_asli_melk_vaziita_build_vaziita_build_radio;
            String _price_shrayet_sell_cheng_price_all_sell_cheng2 = product_showpost._price_shrayet_sell_cheng_price_all_sell_cheng;
            String _price_shrayet_sell_cheng_max_money2 = product_showpost._price_shrayet_sell_cheng_max_money;
            String _price_shrayet_sell_cheng_money_pish_pay2 = product_showpost._price_shrayet_sell_cheng_money_pish_pay;
            String _price_shrayet_sell_cheng_time_tahvil2 = product_showpost._price_shrayet_sell_cheng_time_tahvil;
            String _price_shrayet_sell_cheng_mizan_anjam_shode2 = product_showpost._price_shrayet_sell_cheng_mizan_anjam_shode;
            String _price_shrayet_sell_cheng_mizan_vam2 = product_showpost._price_shrayet_sell_cheng_mizan_vam;
            String _price_shrayet_sell_cheng_sod_vam2 = product_showpost._price_shrayet_sell_cheng_sod_vam;
            String _price_shrayet_sell_cheng_number_ghest2 = product_showpost._price_shrayet_sell_cheng_number_ghest;
            String _price_shrayet_sell_cheng_price_har_ghest2 = product_showpost._price_shrayet_sell_cheng_price_har_ghest;
            String _price_shrayet_sell_cheng_price_rahn2 = product_showpost._price_shrayet_sell_cheng_price_rahn;
            String _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe2 = product_showpost._more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe;
            String _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe2 = product_showpost._more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe;
            String _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe2 = product_showpost._more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe;
            String _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed2 = product_showpost._more_joziat_melk_edari_tejari_moghit_build_number_all_vahed;
            String _more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari2 = product_showpost._more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari;
            String _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari2 = product_showpost._more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari;
            String _more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon2 = product_showpost._more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon;
            String _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon2 = product_showpost._more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon;
            String _more_joziat_melk_edari_tejari_wc_wc_irani2 = product_showpost._more_joziat_melk_edari_tejari_wc_wc_irani;
            String _more_joziat_melk_edari_tejari_wc_wc_us2 = product_showpost._more_joziat_melk_edari_tejari_wc_wc_us;
            String _more_joziat_melk_edari_tejari_wc_bath2 = product_showpost._more_joziat_melk_edari_tejari_wc_bath;
            String _more_joziat_melk_edari_tejari_kitchen_kitchen_radio2 = product_showpost._more_joziat_melk_edari_tejari_kitchen_kitchen_radio;
            String _more_joziat_melk_edari_tejari_kitchen_badane_kabinet2 = product_showpost._more_joziat_melk_edari_tejari_kitchen_badane_kabinet;
            String _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet2 = product_showpost._more_joziat_melk_edari_tejari_kitchen_safhe_kabinet;
            String _more_joziat_melk_edari_tejari_kitchen_roye_kabinet2 = product_showpost._more_joziat_melk_edari_tejari_kitchen_roye_kabinet;
            String _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen2 = product_showpost._more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen;
            String _more_joziat_melk_edari_tejari_neshiman_neshiman_edit2 = product_showpost._more_joziat_melk_edari_tejari_neshiman_neshiman_edit;
            String _more_joziat_melk_edari_tejari_shekle_build_radio2 = product_showpost._more_joziat_melk_edari_tejari_shekle_build_radio;
            String _more_joziat_melk_edari_tejari_nama_nama_edit2 = product_showpost._more_joziat_melk_edari_tejari_nama_nama_edit;
            String _more_joziat_melk_edari_tejari_eskelet_eskelet_edit2 = product_showpost._more_joziat_melk_edari_tejari_eskelet_eskelet_edit;
            String _more_joziat_melk_edari_tejari_kaf_kaf_edit2 = product_showpost._more_joziat_melk_edari_tejari_kaf_kaf_edit;
            String _more_joziat_melk_edari_tejari_divar_divar_edit2 = product_showpost._more_joziat_melk_edari_tejari_divar_divar_edit;
            String _more_joziat_melk_edari_tejari_coldhot_coldhot_edit2 = product_showpost._more_joziat_melk_edari_tejari_coldhot_coldhot_edit;
            String _more_joziat_melk_edari_tejari_refahi_refahi_edit2 = product_showpost._more_joziat_melk_edari_tejari_refahi_refahi_edit;
            String _more_joziat_melk_edari_tejari_safe_safe_edit2 = product_showpost._more_joziat_melk_edari_tejari_safe_safe_edit;
            String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit2 = product_showpost._more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit;
            String _more_joziat_melk_edari_tejari_sport_sport_edit2 = product_showpost._more_joziat_melk_edari_tejari_sport_sport_edit;
            String _more_joziat_melk_edari_tejari_view_view_edit2 = product_showpost._more_joziat_melk_edari_tejari_view_view_edit;
            String _more_joziat_melk_edari_tejari_tasisat_tasisat_edit2 = product_showpost._more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat2 = product_showpost._more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat2 = product_showpost._more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
            String _more_joziat_melk_edari_tejari_safe2 = product_showpost._more_joziat_melk_edari_tejari_safe;
            String _more_joziat_melk_edari_tejari_emkanatBuild2 = product_showpost._more_joziat_melk_edari_tejari_emkanatBuild;
            String _more_joziat_melk_edari_tejari_divar2 = product_showpost._more_joziat_melk_edari_tejari_divar;
            String _more_joziat_melk_edari_tejari_kaf2 = product_showpost._more_joziat_melk_edari_tejari_kaf;
            String _more_joziat_melk_edari_tejari_shekle_build_check2 = product_showpost._more_joziat_melk_edari_tejari_shekle_build_check;
            String _more_joziat_melk_edari_tejari_moghit_build2 = product_showpost._more_joziat_melk_edari_tejari_moghit_build;
            String _price_shrayet2 = product_showpost._price_shrayet;
/*
            String _more_joziat_melk_edari_tejari_refahi_refahi_check_edari2 = product_showpost._more_joziat_melk_edari_tejari_refahi_refahi_check_edari;
            String _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari2 = product_showpost._more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari;
            String _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta2 = product_showpost._more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta;
            String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari2 = product_showpost._more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari;
            String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari2 = product_showpost._more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari;
            String _moshakhasat_asli_melk_vaziita_build_rebuild2 = product_showpost._moshakhasat_asli_melk_vaziita_build_rebuild;
            String _more_joziat_melk_edari_tejari_tozih_about_melk2 = product_showpost._more_joziat_melk_edari_tejari_tozih_about_melk;
            String _moshakhasat_asli_melk_moghiat_build2 = product_showpost._moshakhasat_asli_melk_moghiat_build;
*/


            return view;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public void GetjsonarrayEDARI() {
        try {
            String dataServer3 = dataServer234;
            jsonArrayEDARI = new JSONArray(dataServer3);
            ArrayList<product_showpostEDARI> product_showpostEDARI = new ArrayList<product_showpostEDARI>();
            ProductAdapterEDARI adapter123 = new ProductAdapterEDARI(Main25Activity.this, R.layout.activity_main26, product_showpostEDARI);
            listViewEditPage.setAdapter(adapter123);
            for (int i = 0; i < jsonArrayEDARI.length(); i++) {
                JSONObject jsonObject1 = jsonArrayEDARI.getJSONObject(i);

                int ID = jsonObject1.getInt("ID");
                String content = jsonObject1.getString("post_content");
                String title = jsonObject1.getString("post_title");
                String guid11 = jsonObject1.getString("guid11");
                String _noe_melk_moamele = jsonObject1.getString("_noe_melk_moamele");
                String _noe_melk = jsonObject1.getString("_noe_melk");
                String _moshakhasat_asli_melk_noe_bana = jsonObject1.getString("_moshakhasat_asli_melk_noe_bana");
                String _moshakhasat_asli_melk_masahat_build = jsonObject1.getString("_moshakhasat_asli_melk_masahat_build");
                String _moshakhasat_asli_melk_masahat_zamin = jsonObject1.getString("_moshakhasat_asli_melk_masahat_zamin");
                String _moshakhasat_asli_melk_number_room = jsonObject1.getString("_moshakhasat_asli_melk_number_room");
                String _moshakhasat_asli_melk_number_parking = jsonObject1.getString("_moshakhasat_asli_melk_number_parking");
                String _moshakhasat_asli_melk_sale_build = jsonObject1.getString("_moshakhasat_asli_melk_sale_build");
                String _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio");
                //    String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_ghabel_sokonat");
                String _price_shrayet_sell_cheng_check_seel_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_check_seel_cheng");
                String _price_shrayet_sell_cheng_max_money = jsonObject1.getString("_price_shrayet_sell_cheng_max_money");
                String _price_shrayet_sell_cheng_money_pish_pay = jsonObject1.getString("_price_shrayet_sell_cheng_money_pish_pay");
                String _price_shrayet_sell_cheng_time_tahvil = jsonObject1.getString("_price_shrayet_sell_cheng_time_tahvil");
                String _price_shrayet_sell_cheng_mizan_anjam_shode = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_anjam_shode");
                String _price_shrayet_sell_cheng_mizan_vam = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_vam");
                String _price_shrayet_sell_cheng_sod_vam = jsonObject1.getString("_price_shrayet_sell_cheng_sod_vam");
                String _price_shrayet_sell_cheng_number_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_number_ghest");
                String _price_shrayet_sell_cheng_price_har_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_price_har_ghest");
                String _price_shrayet_sell_cheng_price_rahn = jsonObject1.getString("_price_shrayet_sell_cheng_price_rahn");
                String _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe");
                String _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe");
                String _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe");
                String _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_all_vahed");
                String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build");
                //   String _more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari");
                //   String _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari");
                //   String _more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon");
                //   String _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon");
                String _more_joziat_melk_edari_tejari_wc_wc_irani = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_wc_irani");
                String _more_joziat_melk_edari_tejari_wc_wc_us = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_wc_us");
                // String _more_joziat_melk_edari_tejari_wc_bath = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_bath");
                String _more_joziat_melk_edari_tejari_kitchen_kitchen_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_kitchen_check");
                String _more_joziat_melk_edari_tejari_kitchen_kitchen_radio = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_kitchen_radio");
                String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_darai_kabinet");
                String _more_joziat_melk_edari_tejari_kitchen_badane_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_badane_kabinet");
                String _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_safhe_kabinet");
                String _more_joziat_melk_edari_tejari_kitchen_roye_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_roye_kabinet");
                String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen");
                String _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen");
                //    String _more_joziat_melk_edari_tejari_neshiman_neshiman_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_neshiman_neshiman_check");
                //    String _more_joziat_melk_edari_tejari_neshiman_neshiman_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_neshiman_neshiman_edit");
                String _more_joziat_melk_edari_tejari_shekle_build_radio = jsonObject1.getString("_more_joziat_melk_edari_tejari_shekle_build_radio");
                //  String _more_joziat_melk_edari_tejari_nama_nama_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_check");
                String _more_joziat_melk_edari_tejari_nama_nama_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_edit");
                // String _more_joziat_melk_edari_tejari_eskelet_eskelet_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_eskelet_eskelet_check");
                //  String _more_joziat_melk_edari_tejari_eskelet_eskelet_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_eskelet_eskelet_edit");
                //    String _more_joziat_melk_edari_tejari_kaf_kaf_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf_kaf_check");
                //   String _more_joziat_melk_edari_tejari_kaf_kaf_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf_kaf_edit");
                String _more_joziat_melk_edari_tejari_divar_divar_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar_divar_check");
                String _more_joziat_melk_edari_tejari_divar_divar_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar_divar_edit");
                String _more_joziat_melk_edari_tejari_coldhot_coldhot_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_check");
                String _more_joziat_melk_edari_tejari_coldhot_coldhot_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_edit");
                //  String _more_joziat_melk_edari_tejari_refahi_refahi_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_check");
                String _more_joziat_melk_edari_tejari_refahi_refahi_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_edit");
                //  String _more_joziat_melk_edari_tejari_safe_safe_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_check");
                String _more_joziat_melk_edari_tejari_safe_safe_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_edit");
                //   String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta");
                String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit");
                //  String _more_joziat_melk_edari_tejari_sport_sport_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_sport_sport_check");
                //  String _more_joziat_melk_edari_tejari_sport_sport_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_sport_sport_edit");
                String _more_joziat_melk_edari_tejari_view_view_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_view_view_check");
                String _more_joziat_melk_edari_tejari_view_view_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_view_view_edit");
                String _more_joziat_melk_edari_tejari_nor_nor_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_nor_nor_check");
                //  String _more_joziat_melk_edari_tejari_tasisat_tasisat_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_check");
                String _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");
                String _more_joziat_melk_edari_tejari_safe = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe");
                String _more_joziat_melk_edari_tejari_emkanatBuild = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild");
                String _more_joziat_melk_edari_tejari_divar = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar");
                //   String _more_joziat_melk_edari_tejari_kaf = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf");
                String _more_joziat_melk_edari_tejari_shekle_build_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_shekle_build_check");
                String _more_joziat_melk_edari_tejari_moghit_build = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build");
                String _price_shrayet = jsonObject1.getString("_price_shrayet");
                String _price_shrayet_sell_cheng_price_all_sell_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_price_all_sell_cheng");


                String _more_joziat_melk_edari_tejari_refahi_refahi_check_edari = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_check_edari");
                String _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari");
                String _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta");
                String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari");
                // String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari");
                String _moshakhasat_asli_melk_vaziita_build_rebuild = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_rebuild");
                // String _more_joziat_melk_edari_tejari_tozih_about_melk = jsonObject1.getString("_more_joziat_melk_edari_tejari_tozih_about_melk");
                String _moshakhasat_asli_melk_moghiat_build = jsonObject1.getString("_moshakhasat_asli_melk_moghiat_build");


                product_showpostEDARI.add(new product_showpostEDARI(
                        ID,
                        content, title, guid11,
                        _noe_melk_moamele // _noe_melk_moamele;
                        , _noe_melk // _noe_melk;
                        , _moshakhasat_asli_melk_noe_bana // _moshakhasat_asli_melk_noe_bana;
                        , _moshakhasat_asli_melk_masahat_build // _moshakhasat_asli_melk_masahat_build;
                        , _moshakhasat_asli_melk_masahat_zamin // _moshakhasat_asli_melk_masahat_zamin;
                        , _moshakhasat_asli_melk_number_room // _moshakhasat_asli_melk_number_room;
                        , _moshakhasat_asli_melk_number_parking // _moshakhasat_asli_melk_number_parking;
                        , _moshakhasat_asli_melk_sale_build // _moshakhasat_asli_melk_sale_build;
                        , _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio // _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio;
                        //  , _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat // _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat;
                        , _price_shrayet_sell_cheng_check_seel_cheng // _price_shrayet_sell_cheng_check_seel_cheng;
                        , _price_shrayet_sell_cheng_max_money // _price_shrayet_sell_cheng_max_money;
                        , _price_shrayet_sell_cheng_money_pish_pay // _price_shrayet_sell_cheng_money_pish_pay;
                        , _price_shrayet_sell_cheng_time_tahvil // _price_shrayet_sell_cheng_time_tahvil;
                        , _price_shrayet_sell_cheng_mizan_anjam_shode // _price_shrayet_sell_cheng_mizan_anjam_shode;
                        , _price_shrayet_sell_cheng_mizan_vam // _price_shrayet_sell_cheng_mizan_vam;
                        , _price_shrayet_sell_cheng_sod_vam // _price_shrayet_sell_cheng_sod_vam;
                        , _price_shrayet_sell_cheng_number_ghest // _price_shrayet_sell_cheng_number_ghest;
                        , _price_shrayet_sell_cheng_price_har_ghest // _price_shrayet_sell_cheng_price_har_ghest;
                        , _price_shrayet_sell_cheng_price_rahn // _price_shrayet_sell_cheng_price_rahn;
                        , _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe // _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe;
                        , _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe // _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe;
                        , _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe // _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe;
                        , _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed // _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed;
                        , _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build // _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build;
                        //  , _more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari // _more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari;
                        //  , _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari // _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari;
                        // , _more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon // _more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon;
                        //  , _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon // _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon;
                        , _more_joziat_melk_edari_tejari_wc_wc_irani // _more_joziat_melk_edari_tejari_wc_wc_irani;
                        , _more_joziat_melk_edari_tejari_wc_wc_us // _more_joziat_melk_edari_tejari_wc_wc_us;
                        // , _more_joziat_melk_edari_tejari_wc_bath // _more_joziat_melk_edari_tejari_wc_bath;
                        , _more_joziat_melk_edari_tejari_kitchen_kitchen_check // _more_joziat_melk_edari_tejari_kitchen_kitchen_check;
                        , _more_joziat_melk_edari_tejari_kitchen_kitchen_radio // _more_joziat_melk_edari_tejari_kitchen_kitchen_radio;
                        , _more_joziat_melk_edari_tejari_kitchen_darai_kabinet // _more_joziat_melk_edari_tejari_kitchen_darai_kabinet;
                        , _more_joziat_melk_edari_tejari_kitchen_badane_kabinet // _more_joziat_melk_edari_tejari_kitchen_badane_kabinet;
                        , _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet // _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet;
                        , _more_joziat_melk_edari_tejari_kitchen_roye_kabinet // _more_joziat_melk_edari_tejari_kitchen_roye_kabinet;
                        , _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen // _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen;
                        , _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen // _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen;
                        //   , _more_joziat_melk_edari_tejari_neshiman_neshiman_check // _more_joziat_melk_edari_tejari_neshiman_neshiman_check;
                        //   , _more_joziat_melk_edari_tejari_neshiman_neshiman_edit // _more_joziat_melk_edari_tejari_neshiman_neshiman_edit;
                        , _more_joziat_melk_edari_tejari_shekle_build_radio // _more_joziat_melk_edari_tejari_shekle_build_radio;
                        //  , _more_joziat_melk_edari_tejari_nama_nama_check // _more_joziat_melk_edari_tejari_nama_nama_check;
                        , _more_joziat_melk_edari_tejari_nama_nama_edit // _more_joziat_melk_edari_tejari_nama_nama_edit;
                        //   , _more_joziat_melk_edari_tejari_eskelet_eskelet_check // _more_joziat_melk_edari_tejari_eskelet_eskelet_check;
                        //  , _more_joziat_melk_edari_tejari_eskelet_eskelet_edit // _more_joziat_melk_edari_tejari_eskelet_eskelet_edit;
                        //  , _more_joziat_melk_edari_tejari_kaf_kaf_check // _more_joziat_melk_edari_tejari_kaf_kaf_check;
                        //   , _more_joziat_melk_edari_tejari_kaf_kaf_edit // _more_joziat_melk_edari_tejari_kaf_kaf_edit;
                        , _more_joziat_melk_edari_tejari_divar_divar_check // _more_joziat_melk_edari_tejari_divar_divar_check;
                        , _more_joziat_melk_edari_tejari_divar_divar_edit // _more_joziat_melk_edari_tejari_divar_divar_edit;
                        , _more_joziat_melk_edari_tejari_coldhot_coldhot_check // _more_joziat_melk_edari_tejari_coldhot_coldhot_check;
                        , _more_joziat_melk_edari_tejari_coldhot_coldhot_edit // _more_joziat_melk_edari_tejari_coldhot_coldhot_edit;
                        //    , _more_joziat_melk_edari_tejari_refahi_refahi_check // _more_joziat_melk_edari_tejari_refahi_refahi_check;
                        , _more_joziat_melk_edari_tejari_refahi_refahi_edit // _more_joziat_melk_edari_tejari_refahi_refahi_edit;
                        //  , _more_joziat_melk_edari_tejari_safe_safe_check // _more_joziat_melk_edari_tejari_safe_safe_check;
                        , _more_joziat_melk_edari_tejari_safe_safe_edit // _more_joziat_melk_edari_tejari_safe_safe_edit;
                        // , _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta // _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;
                        , _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit // _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit;
                        // , _more_joziat_melk_edari_tejari_sport_sport_check // _more_joziat_melk_edari_tejari_sport_sport_check;
                        //  , _more_joziat_melk_edari_tejari_sport_sport_edit // _more_joziat_melk_edari_tejari_sport_sport_edit;
                        , _more_joziat_melk_edari_tejari_view_view_check // _more_joziat_melk_edari_tejari_view_view_check;
                        , _more_joziat_melk_edari_tejari_view_view_edit // _more_joziat_melk_edari_tejari_view_view_edit;
                        , _more_joziat_melk_edari_tejari_nor_nor_check // _more_joziat_melk_edari_tejari_nor_nor_check;
                        //  , _more_joziat_melk_edari_tejari_tasisat_tasisat_check // _more_joziat_melk_edari_tejari_tasisat_tasisat_check;
                        , _more_joziat_melk_edari_tejari_tasisat_tasisat_edit // _more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat // _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat // _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam // _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;
                        , _more_joziat_melk_edari_tejari_safe // _more_joziat_melk_edari_tejari_safe;
                        , _more_joziat_melk_edari_tejari_emkanatBuild // _more_joziat_melk_edari_tejari_emkanatBuild;
                        , _more_joziat_melk_edari_tejari_divar // _more_joziat_melk_edari_tejari_divar;
                        // , _more_joziat_melk_edari_tejari_kaf // _more_joziat_melk_edari_tejari_kaf;
                        , _more_joziat_melk_edari_tejari_shekle_build_check // _more_joziat_melk_edari_tejari_shekle_build_check;
                        , _more_joziat_melk_edari_tejari_moghit_build // _more_joziat_melk_edari_tejari_moghit_build;
                        , _price_shrayet // _price_shrayet;
                        , _price_shrayet_sell_cheng_price_all_sell_cheng // _price_shrayet_sell_cheng_price_all_sell_cheng;

                        , _more_joziat_melk_edari_tejari_refahi_refahi_check_edari // _more_joziat_melk_edari_tejari_refahi_refahi_check_edari;
                        , _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari // _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari;
                        , _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta // _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta;
                        , _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari // _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari;
                        // , _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari // _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari;
                        , _moshakhasat_asli_melk_vaziita_build_rebuild // _moshakhasat_asli_melk_vaziita_build_rebuild;
                        //   , _more_joziat_melk_edari_tejari_tozih_about_melk // _more_joziat_melk_edari_tejari_tozih_about_melk;
                        , _moshakhasat_asli_melk_moghiat_build // _moshakhasat_asli_melk_moghiat_build;

                ));
                adapter123.notifyDataSetChanged();
//set again adapter!
//-------------------------aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa


//-------------------------aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    
    public class ProductAdapterEDARI extends ArrayAdapter {


        private int resourceId1;
        private Activity activity1;
        private ArrayList<product_showpostEDARI> productArrayList1;

        public ProductAdapterEDARI(Activity activity1, int resourceId1, ArrayList<product_showpostEDARI> object1) {
            super(activity1, resourceId1, object1);
            this.activity1 = activity1;
            this.resourceId1 = resourceId1;
            this.productArrayList1 = object1;
        }

        @Override
        public View getView(final int position1, View converView1, ViewGroup parent1) {
            View view1 = converView1;
            view1 = this.activity1.getLayoutInflater().inflate(this.resourceId1, null);


            final product_showpostEDARI product_showpostEDARI = productArrayList1.get(position1);

            //-------------------------------------------------------------------------------------------------------------------------------------------------------------
/*

            String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat1 = "";
            String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat2 = "";
            String str1 = product_showpostEDARI._moshakhasat_asli_melk_vaziita_build_ghabel_sokonat;
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
                        b = b + "\n" + "سنگ";
                    }
                    Boolean found2 = a.contains("سرامیک");
                    if (found2 == true) {
                        b = b + "\n" + "سرامیک";
                    }
                    Boolean found3 = a.contains("پارکت");
                    if (found3 == true) {
                        b = b + "\n" + "پارکت";
                    }
                    Boolean found4 = a.contains("کفپوش");
                    if (found4 == true) {
                        b = b + "\n" + "کفپوش";
                    }
                    Boolean found5 = a.contains("موکت");
                    if (found5 == true) {
                        b = b + "\n" + "موکت";
                    }
                    Boolean found6 = a.contains("موزاییک");
                    if (found6 == true) {
                        b = b + "\n" + "موزاییک";
                    }
                    Boolean found7 = a.contains("سیمان");
                    if (found7 == true) {
                        b = b + "\n" + "سیمان";
                    }
                    Boolean found8 = a.contains("کف پله دار");
                    if (found8 == true) {
                        b = b + "\n" + "کف پله دار";
                    }
                }
                _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat2 = b;
            } else {
                _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat2 = "ندارد";
            }
*/
            
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _price_shrayet_sell_cheng_check_seel_cheng1 = "";
            String _price_shrayet_sell_cheng_check_seel_cheng2 = "";
            String str2 = product_showpostEDARI._price_shrayet_sell_cheng_check_seel_cheng;
            if (str2 != "ندارد") {
                String[] splited = str2.split("\"");
                for (int i = 1; i < splited.length; i++) {
                    _price_shrayet_sell_cheng_check_seel_cheng1 = _price_shrayet_sell_cheng_check_seel_cheng1 + " " + splited[i];
                }
                String aaa = "";
                splited = _price_shrayet_sell_cheng_check_seel_cheng1.split(",");
                for (int ai = 0; ai < splited.length; ai++) {
                    aaa = aaa + "\n" + splited[ai];
                    aaa = aaa.replace("]", "");
                }
                String b = "شرایط معامله: ", a;
                for (int ai = 0; ai < splited.length; ai++) {
                    a = splited[ai];
                    Boolean found = a.contains("معاوضه");
                    if (found == true) {
                        b = b + "\n" + "معاوضه";
                    }
                    Boolean found2 = a.contains("پیش فروش");
                    if (found2 == true) {
                        b = b + "\n" + "پیش فروش";
                    }
                    Boolean found3 = a.contains("دارای وام");
                    if (found3 == true) {
                        b = b + "\n" + "دارای وام";
                    }
                    Boolean found4 = a.contains("فروش با مستاجر");
                    if (found4 == true) {
                        b = b + "\n" + "فروش با مستاجر";
                    }
                }
                _price_shrayet_sell_cheng_check_seel_cheng2 = b;
            } else {
                _price_shrayet_sell_cheng_check_seel_cheng2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build1 = "";
            String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build2 = "";
            String str3 = product_showpostEDARI._more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build;
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
                    }
                }
                _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build2 = b;
            } else {
                _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
           String _more_joziat_melk_edari_tejari_kitchen_kitchen_check1 = "";
            String _more_joziat_melk_edari_tejari_kitchen_kitchen_check2 = "";
            String str4 = product_showpostEDARI._more_joziat_melk_edari_tejari_kitchen_kitchen_check;
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
                    }
                }
                _more_joziat_melk_edari_tejari_kitchen_kitchen_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_kitchen_kitchen_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet1 = "";
            String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet2 = "";
            String str5 = product_showpostEDARI._more_joziat_melk_edari_tejari_kitchen_darai_kabinet;
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
                    }
                }
                _more_joziat_melk_edari_tejari_kitchen_darai_kabinet2 = b;
            } else {
                _more_joziat_melk_edari_tejari_kitchen_darai_kabinet2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen1 = "";
            String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen2 = "";
            String str6 = product_showpostEDARI._more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen;
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
                    }
                }
                _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen2 = b;
            } else {
                _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
/*
           String _more_joziat_melk_edari_tejari_neshiman_neshiman_check1 = "";
            String _more_joziat_melk_edari_tejari_neshiman_neshiman_check2 = "";
            String str7 = product_showpostEDARI._more_joziat_melk_edari_tejari_neshiman_neshiman_check;
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
                        b = b + "\n" + "شومینه";
                    }
                    Boolean found2 = a.contains("سقف بالای 4 متر");
                    if (found2 == true) {
                        b = b + "\n" + "سقف بالای 4 متر";
                    }
                    Boolean found3 = a.contains("مبله");
                    if (found3 == true) {
                        b = b + "\n" + "مبله";
                    }
                }
                _more_joziat_melk_edari_tejari_neshiman_neshiman_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_neshiman_neshiman_check2 = "ندارد";
            }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------
         String _more_joziat_melk_edari_tejari_nama_nama_check1 = "";
            String _more_joziat_melk_edari_tejari_nama_nama_check2 = "";
            String str8 = product_showpostEDARI._more_joziat_melk_edari_tejari_nama_nama_check;
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
                        b = b + "\n" + "سنگ";
                    }
                    Boolean found2 = a.contains("آجر");
                    if (found2 == true) {
                        b = b + "\n" + "آجر";
                    }
                    Boolean found3 = a.contains("سیمان");
                    if (found3 == true) {
                        b = b + "\n" + "سیمان";
                    }
                    Boolean found4 = a.contains("شیشه");
                    if (found4 == true) {
                        b = b + "\n" + "شیشه";
                    }
                    Boolean found5 = a.contains("چوب");
                    if (found5 == true) {
                        b = b + "\n" + "چوب";
                    }
                    Boolean found6 = a.contains("کامپوزیت");
                    if (found6 == true) {
                        b = b + "\n" + "کامپوزیت";
                    }
                    Boolean found7 = a.contains("نورپردازی");
                    if (found7 == true) {
                        b = b + "\n" + "نورپردازی";
                    }
                }
                _more_joziat_melk_edari_tejari_nama_nama_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_nama_nama_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_eskelet_eskelet_check1 = "";
            String _more_joziat_melk_edari_tejari_eskelet_eskelet_check2 = "";
            String str9 = product_showpostEDARI._more_joziat_melk_edari_tejari_eskelet_eskelet_check;
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
                        b = b + "\n" + "بتنی";
                    }
                    Boolean found2 = a.contains("فلزی");
                    if (found2 == true) {
                        b = b + "\n" + "فلزی";
                    }
                    Boolean found3 = a.contains("آجی");
                    if (found3 == true) {
                        b = b + "\n" + "آجی";
                    }
                    Boolean found4 = a.contains("چوبی");
                    if (found4 == true) {
                        b = b + "\n" + "چوبی";
                    }
                }
                _more_joziat_melk_edari_tejari_eskelet_eskelet_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_eskelet_eskelet_check2 = "ندارد";
            }


//-------------------------------------------------------------------------------------------------------------------------------------------------------------
          String _more_joziat_melk_edari_tejari_kaf_kaf_check1 = "";
            String _more_joziat_melk_edari_tejari_kaf_kaf_check2 = "";
            String str11 = product_showpostEDARI._more_joziat_melk_edari_tejari_kaf_kaf_check;
            if (str11 != "ندارد") {
                String[] splited = str11.split("\"");
                for (int i = 1; i < splited.length; i++) {
                    _more_joziat_melk_edari_tejari_kaf_kaf_check1 = _more_joziat_melk_edari_tejari_kaf_kaf_check1 + " " + splited[i];
                }
                String aaa = "";
                splited = _more_joziat_melk_edari_tejari_kaf_kaf_check1.split(",");
                for (int ai = 0; ai < splited.length; ai++) {
                    aaa = aaa + "\n" + splited[ai];
                    aaa = aaa.replace("]", "");
                }
                String b = "کف خانه: ", a;
                for (int ai = 0; ai < splited.length; ai++) {
                    a = splited[ai];
                    Boolean found = a.contains("سنگ");
                    if (found == true) {
                        b = b + "\n" + "سنگ";
                    }
                    Boolean found2 = a.contains("سرامیک");
                    if (found2 == true) {
                        b = b + "\n" + "سرامیک";
                    }
                    Boolean found3 = a.contains("پارکت");
                    if (found3 == true) {
                        b = b + "\n" + "پارکت";
                    }
                    Boolean found4 = a.contains("کفپوش");
                    if (found4 == true) {
                        b = b + "\n" + "کفپوش";
                    }
                    Boolean found5 = a.contains("موکت");
                    if (found5 == true) {
                        b = b + "\n" + "موکت";
                    }
                    Boolean found6 = a.contains("موزاییک");
                    if (found6 == true) {
                        b = b + "\n" + "موزاییک";
                    }
                    Boolean found7 = a.contains("سیمان");
                    if (found7 == true) {
                        b = b + "\n" + "سیمان";
                    }
                    Boolean found8 = a.contains("کف پله دار");
                    if (found8 == true) {
                        b = b + "\n" + "کف پله دار";
                    }
                }
                _more_joziat_melk_edari_tejari_kaf_kaf_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_kaf_kaf_check2 = "ندارد";
            }

             */
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_divar_divar_check1 = "";
            String _more_joziat_melk_edari_tejari_divar_divar_check2 = "";
            String str12 = product_showpostEDARI._more_joziat_melk_edari_tejari_divar_divar_check;
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
                        b = b + "\n" + "سنگ";
                    }
                    Boolean found9 = a.contains("رنگ");
                    if (found9 == true) {
                        b = b + "\n" + "رنگ";
                    }
                    Boolean found2 = a.contains("کاشی/ سرامیک");
                    if (found2 == true) {
                        b = b + "\n" + "کاشی/ سرامیک";
                    }
                    Boolean found3 = a.contains("کاغذ دیواری");
                    if (found3 == true) {
                        b = b + "\n" + "کاغذ دیواری";
                    }
                    Boolean found4 = a.contains("چوب/ دیوارکوب");
                    if (found4 == true) {
                        b = b + "\n" + "چوب/ دیوارکوب";
                    }
                    Boolean found5 = a.contains("سیمان");
                    if (found5 == true) {
                        b = b + "\n" + "سیمان";
                    }
                    Boolean found6 = a.contains("گچ");
                    if (found6 == true) {
                        b = b + "\n" + "گچ";
                    }
                    Boolean found7 = a.contains("آجر");
                    if (found7 == true) {
                        b = b + "\n" + "آجر";
                    }
                }
                _more_joziat_melk_edari_tejari_divar_divar_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_divar_divar_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_coldhot_coldhot_check1 = "";
            String _more_joziat_melk_edari_tejari_coldhot_coldhot_check2 = "";
            String str13 = product_showpostEDARI._more_joziat_melk_edari_tejari_coldhot_coldhot_check;
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
                        b = b + "\n" + "کولر";
                    }
                    Boolean found2 = a.contains("کولرگازی/ اسپلیت");
                    if (found2 == true) {
                        b = b + "\n" + "کولرگازی/ اسپلیت";
                    }
                    Boolean found3 = a.contains("بخاری");
                    if (found3 == true) {
                        b = b + "\n" + "بخاری";
                    }
                    Boolean found4 = a.contains("پکیج/ رادیاتور");
                    if (found4 == true) {
                        b = b + "\n" + "پکیج/ رادیاتور";
                    }
                    Boolean found5 = a.contains("دیگ/ رادیاتور");
                    if (found5 == true) {
                        b = b + "\n" + "دیگ/ رادیاتور";
                    }
                    Boolean found6 = a.contains("چیلر/ فن کوئل");
                    if (found6 == true) {
                        b = b + "\n" + "چیلر/ فن کوئل";
                    }
                    Boolean found7 = a.contains("آبگرمکن خورشیدی");
                    if (found7 == true) {
                        b = b + "\n" + "آبگرمکن خورشیدی";
                    }
                    Boolean found79 = a.contains("هواساز");
                    if (found79 == true) {
                        b = b + "\n" + "هواساز";
                    }
                }
                _more_joziat_melk_edari_tejari_coldhot_coldhot_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_coldhot_coldhot_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
 /*
          String _more_joziat_melk_edari_tejari_refahi_refahi_check1 = "";
            String _more_joziat_melk_edari_tejari_refahi_refahi_check2 = "";
            String str14 = product_showpostEDARI._more_joziat_melk_edari_tejari_refahi_refahi_check;
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
                        b = b + "\n" + "آسانسور";
                    }
                    Boolean found2 = a.contains("درب پارکینگ ریموت دار");
                    if (found2 == true) {
                        b = b + "\n" + "درب پارکینگ ریموت دار";
                    }
                    Boolean found3 = a.contains("شوتیگ زباله");
                    if (found3 == true) {
                        b = b + "\n" + "شوتیگ زباله";
                    }
                    Boolean found4 = a.contains("اینترنت پرسرعت");
                    if (found4 == true) {
                        b = b + "\n" + "اینترنت پرسرعت";
                    }
                    Boolean found5 = a.contains("آنتن مزکزی");
                    if (found5 == true) {
                        b = b + "\n" + "آنتن مزکزی";
                    }
                    Boolean found6 = a.contains("شبکه داخلی");
                    if (found6 == true) {
                        b = b + "\n" + "شبکه داخلی";
                    }
                }
                _more_joziat_melk_edari_tejari_refahi_refahi_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_refahi_refahi_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_safe_safe_check1 = "";
            String _more_joziat_melk_edari_tejari_safe_safe_check2 = "";
            String str15 = product_showpostEDARI._more_joziat_melk_edari_tejari_safe_safe_check;
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
                        b = b + "\n" + "دزدگیر";
                    }
                    Boolean found2 = a.contains("دوربین مداربسته");
                    if (found2 == true) {
                        b = b + "\n" + "دوربین مداربسته";
                    }
                    Boolean found3 = a.contains("آیفون تصویری");
                    if (found3 == true) {
                        b = b + "\n" + "آیفون تصویری";
                    }
                    Boolean found4 = a.contains("درب ضد سرقت");
                    if (found4 == true) {
                        b = b + "\n" + "درب ضد سرقت";
                    }
                    Boolean found5 = a.contains("سیستم اعلام آتش");
                    if (found5 == true) {
                        b = b + "\n" + "سیستم اعلام آتش";
                    }
                    Boolean found6 = a.contains("سیستم اطفاء حریق");
                    if (found6 == true) {
                        b = b + "\n" + "سیستم اطفاء حریق";
                    }
                }
                _more_joziat_melk_edari_tejari_safe_safe_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_safe_safe_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1 = "";
            String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta2 = "";
            String str16 = product_showpostEDARI._more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;
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
                        b = b + "\n" + "حیاط";
                    }
                    Boolean found2 = a.contains("حیاط خلوت");
                    if (found2 == true) {
                        b = b + "\n" + "حیاط خلوت";
                    }
                    Boolean found3 = a.contains("فضای سبز");
                    if (found3 == true) {
                        b = b + "\n" + "فضای سبز";
                    }
                    Boolean found4 = a.contains("سرایداری");
                    if (found4 == true) {
                        b = b + "\n" + "سرایداری";
                    }
                    Boolean found5 = a.contains("نگهبانی");
                    if (found5 == true) {
                        b = b + "\n" + "نگهبانی";
                    }
                    Boolean found6 = a.contains("لابی");
                    if (found6 == true) {
                        b = b + "\n" + "لابی";
                    }
                    Boolean found62 = a.contains("سالن اجتماعات");
                    if (found62 == true) {
                        b = b + "\n" + "سالن اجتماعات";
                    }
                    Boolean found61 = a.contains("باغ");
                    if (found61 == true) {
                        b = b + "\n" + "باغ";
                    }
                    Boolean found60 = a.contains("آلاچیق");
                    if (found60 == true) {
                        b = b + "\n" + "آلاچیق";
                    }
                    Boolean found69 = a.contains("آب نما");
                    if (found69 == true) {
                        b = b + "\n" + "آب نما";
                    }
                    Boolean found68 = a.contains("بام سبز");
                    if (found68 == true) {
                        b = b + "\n" + "بام سبز";
                    }
                    Boolean found67 = a.contains("باربیکیو");
                    if (found67 == true) {
                        b = b + "\n" + "باربیکیو";
                    }
                }
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta2 = b;
            } else {
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_sport_sport_check1 = "";
            String _more_joziat_melk_edari_tejari_sport_sport_check2 = "";
            String str17 = product_showpostEDARI._more_joziat_melk_edari_tejari_sport_sport_check;
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
                        b = b + "\n" + "استخر";
                    }
                    Boolean found2 = a.contains("سونا");
                    if (found2 == true) {
                        b = b + "\n" + "سونا";
                    }
                    Boolean found3 = a.contains("جوزی");
                    if (found3 == true) {
                        b = b + "\n" + "جوزی";
                    }
                    Boolean found4 = a.contains("بیلیارد");
                    if (found4 == true) {
                        b = b + "\n" + "بیلیارد";
                    }
                    Boolean found5 = a.contains("فوتبال");
                    if (found5 == true) {
                        b = b + "\n" + "فوتبال";
                    }
                    Boolean found6 = a.contains("بسکتبال");
                    if (found6 == true) {
                        b = b + "\n" + "بسکتبال";
                    }
                    Boolean found61 = a.contains("والیبال");
                    if (found61 == true) {
                        b = b + "\n" + "والیبال";
                    }
                    Boolean found62 = a.contains("تنیس");
                    if (found62 == true) {
                        b = b + "\n" + "تنیس";
                    }
                    Boolean found63 = a.contains("پینگ پنگ");
                    if (found63 == true) {
                        b = b + "\n" + "پینگ پنگ";
                    }
                    Boolean found64 = a.contains("سالن بدن سازی");
                    if (found64 == true) {
                        b = b + "\n" + "سالن بدن سازی";
                    }
                    Boolean found65 = a.contains("زمین بازی کودکان");
                    if (found65 == true) {
                        b = b + "\n" + "زمین بازی کودکان";
                    }
                    Boolean found66 = a.contains("اسکواش");
                    if (found66 == true) {
                        b = b + "\n" + "اسکواش";
                    }
                }
                _more_joziat_melk_edari_tejari_sport_sport_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_sport_sport_check2 = "ندارد";
            }
*/
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_view_view_check1 = "";
            String _more_joziat_melk_edari_tejari_view_view_check2 = "";
            String str18 = product_showpostEDARI._more_joziat_melk_edari_tejari_view_view_check;
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
                        b = b + "\n" + "شهر";
                    }
                    Boolean found2 = a.contains("اتوبان");
                    if (found2 == true) {
                        b = b + "\n" + "اتوبان";
                    }
                    Boolean found3 = a.contains("خیابان");
                    if (found3 == true) {
                        b = b + "\n" + "خیابان";
                    }
                    Boolean found4 = a.contains("کوچه");
                    if (found4 == true) {
                        b = b + "\n" + "کوچه";
                    }
                    Boolean found5 = a.contains("دریا");
                    if (found5 == true) {
                        b = b + "\n" + "دریا";
                    }
                    Boolean found6 = a.contains("جنگل");
                    if (found6 == true) {
                        b = b + "\n" + "جنگل";
                    }
                    Boolean found7 = a.contains("کوه");
                    if (found7 == true) {
                        b = b + "\n" + "کوه";
                    }
                    Boolean found71 = a.contains("باغ");
                    if (found71 == true) {
                        b = b + "\n" + "باغ";
                    }
                }
                _more_joziat_melk_edari_tejari_view_view_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_view_view_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_nor_nor_check1 = "";
            String _more_joziat_melk_edari_tejari_nor_nor_check2 = "";
            String str19 = product_showpostEDARI._more_joziat_melk_edari_tejari_nor_nor_check;
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
                        b = b + "\n" + "شمال";
                    }
                    Boolean found2 = a.contains("جنوب");
                    if (found2 == true) {
                        b = b + "\n" + "جنوب";
                    }
                    Boolean found3 = a.contains("شرق");
                    if (found3 == true) {
                        b = b + "\n" + "شرق";
                    }
                    Boolean found4 = a.contains("غرب");
                    if (found4 == true) {
                        b = b + "\n" + "غرب";
                    }
                }
                _more_joziat_melk_edari_tejari_nor_nor_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_nor_nor_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
          String _more_joziat_melk_edari_tejari_tasisat_tasisat_check1 = "";
            String _more_joziat_melk_edari_tejari_tasisat_tasisat_check2 = "";
            String str21 = product_showpostEDARI._more_joziat_melk_edari_tejari_tasisat_tasisat_check;
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
                        b = b + "\n" + "آب شهری";
                    }
                    Boolean found2 = a.contains("برق");
                    if (found2 == true) {
                        b = b + "\n" + "برق";
                    }
                    Boolean found3 = a.contains("گاز");
                    if (found3 == true) {
                        b = b + "\n" + "گاز";
                    }
                    Boolean found4 = a.contains("ژنراتور برقی");
                    if (found4 == true) {
                        b = b + "\n" + "ژنراتور برقی";
                    }
                }
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check2 = b;
            } else {
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam1 = "";
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam2 = "";
            String str22 = product_showpostEDARI._more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;
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
                    }
                }
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam2 = b;
            } else {
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam2 = "ندارد";
            }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------


            String post_content2 = product_showpostEDARI.post_content;
            String post_title2 = product_showpostEDARI.post_title;
            String guid112 = product_showpostEDARI.guid11;
            String _noe_melk_moamele2 = product_showpostEDARI._noe_melk_moamele;
            String _noe_melk2 = product_showpostEDARI._noe_melk;
            String _moshakhasat_asli_melk_noe_bana2 = product_showpostEDARI._moshakhasat_asli_melk_noe_bana;
            String _moshakhasat_asli_melk_masahat_build2 = product_showpostEDARI._moshakhasat_asli_melk_masahat_build;
            String _moshakhasat_asli_melk_masahat_zamin2 = product_showpostEDARI._moshakhasat_asli_melk_masahat_zamin;
            String _moshakhasat_asli_melk_number_room2 = product_showpostEDARI._moshakhasat_asli_melk_number_room;
            String _moshakhasat_asli_melk_number_parking2 = product_showpostEDARI._moshakhasat_asli_melk_number_parking;
            String _moshakhasat_asli_melk_sale_build2 = product_showpostEDARI._moshakhasat_asli_melk_sale_build;
            String _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio2 = product_showpostEDARI._moshakhasat_asli_melk_vaziita_build_vaziita_build_radio;
            String _price_shrayet_sell_cheng_price_all_sell_cheng2 = product_showpostEDARI._price_shrayet_sell_cheng_price_all_sell_cheng;
            String _price_shrayet_sell_cheng_max_money2 = product_showpostEDARI._price_shrayet_sell_cheng_max_money;
            String _price_shrayet_sell_cheng_money_pish_pay2 = product_showpostEDARI._price_shrayet_sell_cheng_money_pish_pay;
            String _price_shrayet_sell_cheng_time_tahvil2 = product_showpostEDARI._price_shrayet_sell_cheng_time_tahvil;
            String _price_shrayet_sell_cheng_mizan_anjam_shode2 = product_showpostEDARI._price_shrayet_sell_cheng_mizan_anjam_shode;
            String _price_shrayet_sell_cheng_mizan_vam2 = product_showpostEDARI._price_shrayet_sell_cheng_mizan_vam;
            String _price_shrayet_sell_cheng_sod_vam2 = product_showpostEDARI._price_shrayet_sell_cheng_sod_vam;
            String _price_shrayet_sell_cheng_number_ghest2 = product_showpostEDARI._price_shrayet_sell_cheng_number_ghest;
            String _price_shrayet_sell_cheng_price_har_ghest2 = product_showpostEDARI._price_shrayet_sell_cheng_price_har_ghest;
            String _price_shrayet_sell_cheng_price_rahn2 = product_showpostEDARI._price_shrayet_sell_cheng_price_rahn;
            String _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe2 = product_showpostEDARI._more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe;
            String _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe2 = product_showpostEDARI._more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe;
            String _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe2 = product_showpostEDARI._more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe;
            String _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed2 = product_showpostEDARI._more_joziat_melk_edari_tejari_moghit_build_number_all_vahed;
            //    String _more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari2 = product_showpostEDARI._more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari;
            // String _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari2 = product_showpostEDARI._more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari;
            // String _more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon2 = product_showpostEDARI._more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon;
            // String _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon2 = product_showpostEDARI._more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon;
            String _more_joziat_melk_edari_tejari_wc_wc_irani2 = product_showpostEDARI._more_joziat_melk_edari_tejari_wc_wc_irani;
            String _more_joziat_melk_edari_tejari_wc_wc_us2 = product_showpostEDARI._more_joziat_melk_edari_tejari_wc_wc_us;
            // String _more_joziat_melk_edari_tejari_wc_bath2 = product_showpostEDARI._more_joziat_melk_edari_tejari_wc_bath;
            String _more_joziat_melk_edari_tejari_kitchen_kitchen_radio2 = product_showpostEDARI._more_joziat_melk_edari_tejari_kitchen_kitchen_radio;
            String _more_joziat_melk_edari_tejari_kitchen_badane_kabinet2 = product_showpostEDARI._more_joziat_melk_edari_tejari_kitchen_badane_kabinet;
            String _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet2 = product_showpostEDARI._more_joziat_melk_edari_tejari_kitchen_safhe_kabinet;
            String _more_joziat_melk_edari_tejari_kitchen_roye_kabinet2 = product_showpostEDARI._more_joziat_melk_edari_tejari_kitchen_roye_kabinet;
            String _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen2 = product_showpostEDARI._more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen;
            // String _more_joziat_melk_edari_tejari_neshiman_neshiman_edit2 = product_showpostEDARI._more_joziat_melk_edari_tejari_neshiman_neshiman_edit;
            String _more_joziat_melk_edari_tejari_shekle_build_radio2 = product_showpostEDARI._more_joziat_melk_edari_tejari_shekle_build_radio;
            String _more_joziat_melk_edari_tejari_nama_nama_edit2 = product_showpostEDARI._more_joziat_melk_edari_tejari_nama_nama_edit;
            //  String _more_joziat_melk_edari_tejari_eskelet_eskelet_edit2 = product_showpostEDARI._more_joziat_melk_edari_tejari_eskelet_eskelet_edit;
            //  String _more_joziat_melk_edari_tejari_kaf_kaf_edit2 = product_showpostEDARI._more_joziat_melk_edari_tejari_kaf_kaf_edit;
            String _more_joziat_melk_edari_tejari_divar_divar_edit2 = product_showpostEDARI._more_joziat_melk_edari_tejari_divar_divar_edit;
            String _more_joziat_melk_edari_tejari_coldhot_coldhot_edit2 = product_showpostEDARI._more_joziat_melk_edari_tejari_coldhot_coldhot_edit;
            String _more_joziat_melk_edari_tejari_refahi_refahi_edit2 = product_showpostEDARI._more_joziat_melk_edari_tejari_refahi_refahi_edit;
            String _more_joziat_melk_edari_tejari_safe_safe_edit2 = product_showpostEDARI._more_joziat_melk_edari_tejari_safe_safe_edit;
            String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit2 = product_showpostEDARI._more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit;
            // String _more_joziat_melk_edari_tejari_sport_sport_edit2 = product_showpostEDARI._more_joziat_melk_edari_tejari_sport_sport_edit;
            String _more_joziat_melk_edari_tejari_view_view_edit2 = product_showpostEDARI._more_joziat_melk_edari_tejari_view_view_edit;
            String _more_joziat_melk_edari_tejari_tasisat_tasisat_edit2 = product_showpostEDARI._more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat2 = product_showpostEDARI._more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat2 = product_showpostEDARI._more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
            String _more_joziat_melk_edari_tejari_safe2 = product_showpostEDARI._more_joziat_melk_edari_tejari_safe;
            String _more_joziat_melk_edari_tejari_emkanatBuild2 = product_showpostEDARI._more_joziat_melk_edari_tejari_emkanatBuild;
            String _more_joziat_melk_edari_tejari_divar2 = product_showpostEDARI._more_joziat_melk_edari_tejari_divar;
            // String _more_joziat_melk_edari_tejari_kaf2 = product_showpostEDARI._more_joziat_melk_edari_tejari_kaf;
            String _more_joziat_melk_edari_tejari_shekle_build_check2 = product_showpostEDARI._more_joziat_melk_edari_tejari_shekle_build_check;
            String _more_joziat_melk_edari_tejari_moghit_build2 = product_showpostEDARI._more_joziat_melk_edari_tejari_moghit_build;
            String _price_shrayet2 = product_showpostEDARI._price_shrayet;

            String _more_joziat_melk_edari_tejari_refahi_refahi_check_edari2 = product_showpostEDARI._more_joziat_melk_edari_tejari_refahi_refahi_check_edari;
            String _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari2 = product_showpostEDARI._more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari;
            String _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta2 = product_showpostEDARI._more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta;
            String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari2 = product_showpostEDARI._more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari;
            //  String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari2 = product_showpostEDARI._more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari;
            String _moshakhasat_asli_melk_vaziita_build_rebuild2 = product_showpostEDARI._moshakhasat_asli_melk_vaziita_build_rebuild;
            //  String _more_joziat_melk_edari_tejari_tozih_about_melk2 = product_showpostEDARI._more_joziat_melk_edari_tejari_tozih_about_melk;
            String _moshakhasat_asli_melk_moghiat_build2 = product_showpostEDARI._moshakhasat_asli_melk_moghiat_build;


            return view1;
        }


    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void GetjsonarrayTEJARI() {
        try {
            String dataServer3 = dataServer234;
            jsonArray = new JSONArray(dataServer3);

            ArrayList<product_showpostTEJARI> product_showpostTEJARI = new ArrayList<product_showpostTEJARI>();
            ProductAdapterTEJARI adapter123 = new ProductAdapterTEJARI(Main25Activity.this, R.layout.activity_main2, product_showpostTEJARI);
            listViewEditPage.setAdapter(adapter123);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                int ID = jsonObject1.getInt("ID");
                String content = jsonObject1.getString("post_content");
                String title = jsonObject1.getString("post_title");
                String guid11 = jsonObject1.getString("guid11");

                String _noe_melk_moamele = jsonObject1.getString("_noe_melk_moamele");
                String _moshakhasat_asli_melk_moghiita_store = jsonObject1.getString("_moshakhasat_asli_melk_moghiita_store");
                String _noe_melk = jsonObject1.getString("_noe_melk");
                String _moshakhasat_asli_melk_masahat_kaf = jsonObject1.getString("_moshakhasat_asli_melk_masahat_kaf");
                String _moshakhasat_asli_melk_masahat_balkon = jsonObject1.getString("_moshakhasat_asli_melk_masahat_balkon");
                String _moshakhasat_asli_melk_nuumber_dahane = jsonObject1.getString("_moshakhasat_asli_melk_nuumber_dahane");
                String _moshakhasat_asli_melk_tol_bar_asli = jsonObject1.getString("_moshakhasat_asli_melk_tol_bar_asli");
                String _moshakhasat_asli_melk_number_bar = jsonObject1.getString("_moshakhasat_asli_melk_number_bar");
                String _moshakhasat_asli_melk_noe_vaghozari = jsonObject1.getString("_moshakhasat_asli_melk_noe_vaghozari");
                String _more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh");
                String _more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh");
                String _more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe");
                String _more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze");
                String _more_joziat_melk_edari_tejari_wc_wc_irani = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_wc_irani");
                String _more_joziat_melk_edari_tejari_wc_wc_us = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_wc_us");
                String _more_joziat_melk_edari_tejari_wc_roshoii = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_roshoii");
                String _more_joziat_melk_edari_tejari_abdarhkane_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_abdarhkane_tejari");
                String _more_joziat_melk_edari_tejari_fazai_asli_fazai_asli = jsonObject1.getString("_more_joziat_melk_edari_tejari_fazai_asli_fazai_asli");
                String _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari");
                String _more_joziat_melk_edari_tejari_kaf_kaf_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf_kaf_check");
                String _more_joziat_melk_edari_tejari_kaf_kaf_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf_kaf_edit");
                String _more_joziat_melk_edari_tejari_coldhot_coldhot_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_check");
                String _more_joziat_melk_edari_tejari_coldhot_coldhot_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_edit");
                String _more_joziat_melk_edari_tejari_refahi_refahi_check_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_check_tejari");
                String _more_joziat_melk_edari_tejari_refahi_refahi_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_edit");
                String _more_joziat_melk_edari_tejari_safe_safe_check_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_check_tejari");
                String _more_joziat_melk_edari_tejari_safe_safe_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_edit");
                String _more_joziat_melk_edari_tejari_dastresi_dastresi_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_dastresi_dastresi_check");
                String _more_joziat_melk_edari_tejari_dastresi_dastres_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_dastresi_dastres_edit");
                String _more_joziat_melk_edari_tejari_ghozar_asli = jsonObject1.getString("_more_joziat_melk_edari_tejari_ghozar_asli");
                String _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");


                product_showpostTEJARI.add(new product_showpostTEJARI(ID, content, title, guid11


                        , _noe_melk_moamele // _noe_melk_moamele;
                        , _moshakhasat_asli_melk_moghiita_store // _moshakhasat_asli_melk_moghiita_store;
                        , _noe_melk // _noe_melk;
                        , _moshakhasat_asli_melk_masahat_kaf // _moshakhasat_asli_melk_masahat_kaf;
                        , _moshakhasat_asli_melk_masahat_balkon // _moshakhasat_asli_melk_masahat_balkon;
                        , _moshakhasat_asli_melk_nuumber_dahane // _moshakhasat_asli_melk_nuumber_dahane;
                        , _moshakhasat_asli_melk_tol_bar_asli // _moshakhasat_asli_melk_tol_bar_asli;
                        , _moshakhasat_asli_melk_number_bar // _moshakhasat_asli_melk_number_bar;
                        , _moshakhasat_asli_melk_noe_vaghozari // _moshakhasat_asli_melk_noe_vaghozari;
                        , _more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh // _more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh;
                        , _more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh // _more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh;
                        , _more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe // _more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe;
                        , _more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze // _more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze;
                        , _more_joziat_melk_edari_tejari_wc_wc_irani // _more_joziat_melk_edari_tejari_wc_wc_irani;
                        , _more_joziat_melk_edari_tejari_wc_wc_us // _more_joziat_melk_edari_tejari_wc_wc_us;
                        , _more_joziat_melk_edari_tejari_wc_roshoii // _more_joziat_melk_edari_tejari_wc_roshoii;
                        , _more_joziat_melk_edari_tejari_abdarhkane_tejari // _more_joziat_melk_edari_tejari_abdarhkane_tejari;
                        , _more_joziat_melk_edari_tejari_fazai_asli_fazai_asli // _more_joziat_melk_edari_tejari_fazai_asli_fazai_asli;
                        , _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari // _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari;
                        , _more_joziat_melk_edari_tejari_kaf_kaf_check // _more_joziat_melk_edari_tejari_kaf_kaf_check;
                        , _more_joziat_melk_edari_tejari_kaf_kaf_edit // _more_joziat_melk_edari_tejari_kaf_kaf_edit;
                        , _more_joziat_melk_edari_tejari_coldhot_coldhot_check // _more_joziat_melk_edari_tejari_coldhot_coldhot_check;
                        , _more_joziat_melk_edari_tejari_coldhot_coldhot_edit // _more_joziat_melk_edari_tejari_coldhot_coldhot_edit;
                        , _more_joziat_melk_edari_tejari_refahi_refahi_check_tejari // _more_joziat_melk_edari_tejari_refahi_refahi_check_tejari;
                        , _more_joziat_melk_edari_tejari_refahi_refahi_edit // _more_joziat_melk_edari_tejari_refahi_refahi_edit;
                        , _more_joziat_melk_edari_tejari_safe_safe_check_tejari // _more_joziat_melk_edari_tejari_safe_safe_check_tejari;
                        , _more_joziat_melk_edari_tejari_safe_safe_edit // _more_joziat_melk_edari_tejari_safe_safe_edit;
                        , _more_joziat_melk_edari_tejari_dastresi_dastresi_check // _more_joziat_melk_edari_tejari_dastresi_dastresi_check;
                        , _more_joziat_melk_edari_tejari_dastresi_dastres_edit // _more_joziat_melk_edari_tejari_dastresi_dastres_edit;
                        , _more_joziat_melk_edari_tejari_ghozar_asli // _more_joziat_melk_edari_tejari_ghozar_asli;
                        , _more_joziat_melk_edari_tejari_tasisat_tasisat_edit // _more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat // _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat // _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam // _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;


                ));
                adapter123.notifyDataSetChanged();
//set again adapter!


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public class ProductAdapterTEJARI extends ArrayAdapter {


        private int resourceId;
        private Activity activity;
        private ArrayList<product_showpostTEJARI> productArrayList;

        public ProductAdapterTEJARI(Activity activity, int resourceId, ArrayList<product_showpostTEJARI> object) {
            super(activity, resourceId, object);
            this.activity = activity;
            this.resourceId = resourceId;
            this.productArrayList = object;
        }

        @Override
        public View getView(final int position, View converView, ViewGroup parent) {
            View view = converView;
            view = this.activity.getLayoutInflater().inflate(this.resourceId, null);


            final product_showpostTEJARI product_showpostTEJARI = productArrayList.get(position);


            String _noe_melk_moamele2 = product_showpostTEJARI._noe_melk_moamele;
            String _moshakhasat_asli_melk_moghiita_store2 = product_showpostTEJARI._moshakhasat_asli_melk_moghiita_store;
            String _noe_melk2 = product_showpostTEJARI._noe_melk;
            String _moshakhasat_asli_melk_masahat_kaf2 = product_showpostTEJARI._moshakhasat_asli_melk_masahat_kaf;
            String _moshakhasat_asli_melk_masahat_balkon2 = product_showpostTEJARI._moshakhasat_asli_melk_masahat_balkon;
            String _moshakhasat_asli_melk_nuumber_dahane2 = product_showpostTEJARI._moshakhasat_asli_melk_nuumber_dahane;
            String _moshakhasat_asli_melk_tol_bar_asli2 = product_showpostTEJARI._moshakhasat_asli_melk_tol_bar_asli;
            String _moshakhasat_asli_melk_number_bar2 = product_showpostTEJARI._moshakhasat_asli_melk_number_bar;
            String _moshakhasat_asli_melk_noe_vaghozari2 = product_showpostTEJARI._moshakhasat_asli_melk_noe_vaghozari;
            String _more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh;
            String _more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh;
            String _more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe;
            String _more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze;
            String _more_joziat_melk_edari_tejari_wc_wc_irani2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_wc_wc_irani;
            String _more_joziat_melk_edari_tejari_wc_wc_us2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_wc_wc_us;
            String _more_joziat_melk_edari_tejari_wc_roshoii2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_wc_roshoii;
            String _more_joziat_melk_edari_tejari_abdarhkane_tejari2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_abdarhkane_tejari;
            String _more_joziat_melk_edari_tejari_fazai_asli_fazai_asli2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_fazai_asli_fazai_asli;
            String _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari;
            String _more_joziat_melk_edari_tejari_kaf_kaf_check2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_kaf_kaf_check;
            String _more_joziat_melk_edari_tejari_kaf_kaf_edit2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_kaf_kaf_edit;
            String _more_joziat_melk_edari_tejari_coldhot_coldhot_check2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_coldhot_coldhot_check;
            String _more_joziat_melk_edari_tejari_coldhot_coldhot_edit2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_coldhot_coldhot_edit;
            String _more_joziat_melk_edari_tejari_refahi_refahi_check_tejari2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_refahi_refahi_check_tejari;
            String _more_joziat_melk_edari_tejari_refahi_refahi_edit2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_refahi_refahi_edit;
            String _more_joziat_melk_edari_tejari_safe_safe_check_tejari2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_safe_safe_check_tejari;
            String _more_joziat_melk_edari_tejari_safe_safe_edit2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_safe_safe_edit;
            String _more_joziat_melk_edari_tejari_dastresi_dastresi_check2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_dastresi_dastresi_check;
            String _more_joziat_melk_edari_tejari_dastresi_dastres_edit2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_dastresi_dastres_edit;
            String _more_joziat_melk_edari_tejari_ghozar_asli2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_ghozar_asli;
            String _more_joziat_melk_edari_tejari_tasisat_tasisat_edit2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam2 = product_showpostTEJARI._more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;


            return view;
        }
    }

    public void GetjsonarrayMOSTA() {
        try {
            String dataServer3 = dataServer234;
            jsonArray = new JSONArray(dataServer3);
            // _more_joziat_melk_edari_tejari_kaf_kaf_check
            ArrayList<product_showpostMOSTA> product_showpostMOSTA = new ArrayList<product_showpostMOSTA>();
            ProductAdapterMOSTA adapter123 = new ProductAdapterMOSTA(Main25Activity.this, R.layout.activity_main2, product_showpostMOSTA);
            listViewEditPage.setAdapter(adapter123);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                int ID = jsonObject1.getInt("ID");
                String content = jsonObject1.getString("post_content");
                String title = jsonObject1.getString("post_title");
                String guid11 = jsonObject1.getString("guid11");

                String _noe_melk_moamele = jsonObject1.getString("_noe_melk_moamele");
                String _noe_melk = jsonObject1.getString("_noe_melk");
                String _moshakhasat_asli_melk_noe_bana_mostagh = jsonObject1.getString("_moshakhasat_asli_melk_noe_bana_mostagh");
                String _moshakhasat_asli_melk_mosahat_kol_banai_build = jsonObject1.getString("_moshakhasat_asli_melk_mosahat_kol_banai_build");
                String _moshakhasat_asli_melk_masahat_zamin = jsonObject1.getString("_moshakhasat_asli_melk_masahat_zamin");
                String _moshakhasat_asli_melk_number_bar = jsonObject1.getString("_moshakhasat_asli_melk_number_bar");
                String _moshakhasat_asli_melk_sale_build = jsonObject1.getString("_moshakhasat_asli_melk_sale_build");
                String _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio");
                String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_ghabel_sokonat");
                String _price_shrayet_sell_cheng_price_all_sell_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_price_all_sell_cheng");
                String _price_shrayet_sell_cheng_check_seel_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_check_seel_cheng");
                String _price_shrayet_sell_cheng_max_money = jsonObject1.getString("_price_shrayet_sell_cheng_max_money");
                String _price_shrayet_sell_cheng_money_pish_pay = jsonObject1.getString("_price_shrayet_sell_cheng_money_pish_pay");
                String _price_shrayet_sell_cheng_time_tahvil = jsonObject1.getString("_price_shrayet_sell_cheng_time_tahvil");
                String _price_shrayet_sell_cheng_mizan_anjam_shode = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_anjam_shode");
                String _price_shrayet_sell_cheng_mizan_vam = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_vam");
                String _price_shrayet_sell_cheng_sod_vam = jsonObject1.getString("_price_shrayet_sell_cheng_sod_vam");
                String _price_shrayet_sell_cheng_number_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_number_ghest");
                String _price_shrayet_sell_cheng_price_har_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_price_har_ghest");
                String _price_shrayet_sell_cheng_price_rahn = jsonObject1.getString("_price_shrayet_sell_cheng_price_rahn");
                String _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check");
                String _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit");
                String _more_joziat_melk_edari_tejari_nama_nama_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_check");
                String _more_joziat_melk_edari_tejari_nama_nama_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_edit");
                String _more_joziat_melk_edari_tejari_eskelet_eskelet_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_eskelet_eskelet_check");
                String _more_joziat_melk_edari_tejari_eskelet_eskelet_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_eskelet_eskelet_edit");
                String _more_joziat_melk_edari_tejari_divar_divar_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar_divar_check");
                String _more_joziat_melk_edari_tejari_divar_divar_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar_divar_edit");
                String _more_joziat_melk_edari_tejari_coldhot_coldhot_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_check");
                String _more_joziat_melk_edari_tejari_coldhot_coldhot_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_edit");
                String _more_joziat_melk_edari_tejari_refahi_refahi_check_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_check_mosta");
                String _more_joziat_melk_edari_tejari_refahi_refahi_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_edit");
                String _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta");
                String _more_joziat_melk_edari_tejari_safe_safe_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_edit");
                String _more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta");
                String _more_joziat_melk_edari_tejari_dastresi_dastres_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_dastresi_dastres_edit");
                String _more_joziat_melk_edari_tejari_ghozar_asli = jsonObject1.getString("_more_joziat_melk_edari_tejari_ghozar_asli");
                String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta");
                String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit");
                String _more_joziat_melk_edari_tejari_sport_sport_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_sport_sport_check");
                String _more_joziat_melk_edari_tejari_sport_sport_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_sport_sport_edit");
                String _more_joziat_melk_edari_tejari_view_view_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_view_view_check");
                String _more_joziat_melk_edari_tejari_view_view_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_view_view_edit");
                String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta");
                String _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");


                product_showpostMOSTA.add(new product_showpostMOSTA(ID, content, title, guid11

                        , _noe_melk_moamele // noe_melk_moamele;
                        , _noe_melk // _noe_melk;
                        , _moshakhasat_asli_melk_noe_bana_mostagh // _moshakhasat_asli_melk_noe_bana_mostagh;
                        , _moshakhasat_asli_melk_mosahat_kol_banai_build // _moshakhasat_asli_melk_mosahat_kol_banai_build;
                        , _moshakhasat_asli_melk_masahat_zamin // _moshakhasat_asli_melk_masahat_zamin;
                        , _moshakhasat_asli_melk_number_bar // _moshakhasat_asli_melk_number_bar;
                        , _moshakhasat_asli_melk_sale_build // _moshakhasat_asli_melk_sale_build;
                        , _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio // _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio;
                        , _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat // _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat;
                        , _price_shrayet_sell_cheng_price_all_sell_cheng // _price_shrayet_sell_cheng_price_all_sell_cheng;
                        , _price_shrayet_sell_cheng_check_seel_cheng // _price_shrayet_sell_cheng_check_seel_cheng;
                        , _price_shrayet_sell_cheng_max_money // _price_shrayet_sell_cheng_max_money;
                        , _price_shrayet_sell_cheng_money_pish_pay // _price_shrayet_sell_cheng_money_pish_pay;
                        , _price_shrayet_sell_cheng_time_tahvil // _price_shrayet_sell_cheng_time_tahvil;
                        , _price_shrayet_sell_cheng_mizan_anjam_shode // _price_shrayet_sell_cheng_mizan_anjam_shode;
                        , _price_shrayet_sell_cheng_mizan_vam // _price_shrayet_sell_cheng_mizan_vam;
                        , _price_shrayet_sell_cheng_sod_vam // _price_shrayet_sell_cheng_sod_vam;
                        , _price_shrayet_sell_cheng_number_ghest // _price_shrayet_sell_cheng_number_ghest;
                        , _price_shrayet_sell_cheng_price_har_ghest // _price_shrayet_sell_cheng_price_har_ghest;
                        , _price_shrayet_sell_cheng_price_rahn // _price_shrayet_sell_cheng_price_rahn;
                        , _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check // _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;
                        , _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit // _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit;
                        , _more_joziat_melk_edari_tejari_nama_nama_check // _more_joziat_melk_edari_tejari_nama_nama_check;
                        , _more_joziat_melk_edari_tejari_nama_nama_edit // _more_joziat_melk_edari_tejari_nama_nama_edit;
                        , _more_joziat_melk_edari_tejari_eskelet_eskelet_check // _more_joziat_melk_edari_tejari_eskelet_eskelet_check;
                        , _more_joziat_melk_edari_tejari_eskelet_eskelet_edit // _more_joziat_melk_edari_tejari_eskelet_eskelet_edit;
                        , _more_joziat_melk_edari_tejari_divar_divar_check // _more_joziat_melk_edari_tejari_divar_divar_check;
                        , _more_joziat_melk_edari_tejari_divar_divar_edit // _more_joziat_melk_edari_tejari_divar_divar_edit;
                        , _more_joziat_melk_edari_tejari_coldhot_coldhot_check // _more_joziat_melk_edari_tejari_coldhot_coldhot_check;
                        , _more_joziat_melk_edari_tejari_coldhot_coldhot_edit // _more_joziat_melk_edari_tejari_coldhot_coldhot_edit;
                        , _more_joziat_melk_edari_tejari_refahi_refahi_check_mosta // _more_joziat_melk_edari_tejari_refahi_refahi_check_mosta;
                        , _more_joziat_melk_edari_tejari_refahi_refahi_edit // _more_joziat_melk_edari_tejari_refahi_refahi_edit;
                        , _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta // _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta;
                        , _more_joziat_melk_edari_tejari_safe_safe_edit // _more_joziat_melk_edari_tejari_safe_safe_edit;
                        , _more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta // _more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta;
                        , _more_joziat_melk_edari_tejari_dastresi_dastres_edit // _more_joziat_melk_edari_tejari_dastresi_dastres_edit;
                        , _more_joziat_melk_edari_tejari_ghozar_asli // _more_joziat_melk_edari_tejari_ghozar_asli;
                        , _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta // _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;
                        , _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit // _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit;
                        , _more_joziat_melk_edari_tejari_sport_sport_check // _more_joziat_melk_edari_tejari_sport_sport_check;
                        , _more_joziat_melk_edari_tejari_sport_sport_edit // _more_joziat_melk_edari_tejari_sport_sport_edit;
                        , _more_joziat_melk_edari_tejari_view_view_check // _more_joziat_melk_edari_tejari_view_view_check;
                        , _more_joziat_melk_edari_tejari_view_view_edit // _more_joziat_melk_edari_tejari_view_view_edit;
                        , _more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta // _more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta;
                        , _more_joziat_melk_edari_tejari_tasisat_tasisat_edit // _more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat // _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat // _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam // _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;


                ));
                adapter123.notifyDataSetChanged();
//set again adapter!


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    
    public class ProductAdapterMOSTA extends ArrayAdapter {


        private int resourceId;
        private Activity activity;
        private ArrayList<product_showpostMOSTA> productArrayList;

        public ProductAdapterMOSTA(Activity activity, int resourceId, ArrayList<product_showpostMOSTA> object) {
            super(activity, resourceId, object);
            this.activity = activity;
            this.resourceId = resourceId;
            this.productArrayList = object;
        }

        @Override
        public View getView(final int position, View converView, ViewGroup parent) {
            View view = converView;
            view = this.activity.getLayoutInflater().inflate(this.resourceId, null);


            final product_showpostMOSTA product_showpostMOSTA = productArrayList.get(position);

            String guid112 = product_showpostMOSTA.guid11;
            String post_title2 = product_showpostMOSTA.post_title;
            String post_content2 = product_showpostMOSTA.post_content;
            String _noe_melk_moamele2 = product_showpostMOSTA._noe_melk_moamele;
            String _noe_melk2 = product_showpostMOSTA._noe_melk;
            String _moshakhasat_asli_melk_noe_bana_mostagh2 = product_showpostMOSTA._moshakhasat_asli_melk_noe_bana_mostagh;
            String _moshakhasat_asli_melk_mosahat_kol_banai_build2 = product_showpostMOSTA._moshakhasat_asli_melk_mosahat_kol_banai_build;
            String _moshakhasat_asli_melk_masahat_zamin2 = product_showpostMOSTA._moshakhasat_asli_melk_masahat_zamin;
            String _moshakhasat_asli_melk_number_bar2 = product_showpostMOSTA._moshakhasat_asli_melk_number_bar;
            String _moshakhasat_asli_melk_sale_build2 = product_showpostMOSTA._moshakhasat_asli_melk_sale_build;
            String _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio2 = product_showpostMOSTA._moshakhasat_asli_melk_vaziita_build_vaziita_build_radio;
            String _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat2 = product_showpostMOSTA._moshakhasat_asli_melk_vaziita_build_ghabel_sokonat;
            String _price_shrayet_sell_cheng_price_all_sell_cheng2 = product_showpostMOSTA._price_shrayet_sell_cheng_price_all_sell_cheng;
            String _price_shrayet_sell_cheng_check_seel_cheng2 = product_showpostMOSTA._price_shrayet_sell_cheng_check_seel_cheng;
            String _price_shrayet_sell_cheng_max_money2 = product_showpostMOSTA._price_shrayet_sell_cheng_max_money;
            String _price_shrayet_sell_cheng_money_pish_pay2 = product_showpostMOSTA._price_shrayet_sell_cheng_money_pish_pay;
            String _price_shrayet_sell_cheng_time_tahvil2 = product_showpostMOSTA._price_shrayet_sell_cheng_time_tahvil;
            String _price_shrayet_sell_cheng_mizan_anjam_shode2 = product_showpostMOSTA._price_shrayet_sell_cheng_mizan_anjam_shode;
            String _price_shrayet_sell_cheng_mizan_vam2 = product_showpostMOSTA._price_shrayet_sell_cheng_mizan_vam;
            String _price_shrayet_sell_cheng_sod_vam2 = product_showpostMOSTA._price_shrayet_sell_cheng_sod_vam;
            String _price_shrayet_sell_cheng_number_ghest2 = product_showpostMOSTA._price_shrayet_sell_cheng_number_ghest;
            String _price_shrayet_sell_cheng_price_har_ghest2 = product_showpostMOSTA._price_shrayet_sell_cheng_price_har_ghest;
            String _price_shrayet_sell_cheng_price_rahn2 = product_showpostMOSTA._price_shrayet_sell_cheng_price_rahn;
            String _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;
            String _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit;
            String _more_joziat_melk_edari_tejari_nama_nama_check2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_nama_nama_check;
            String _more_joziat_melk_edari_tejari_nama_nama_edit2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_nama_nama_edit;
            String _more_joziat_melk_edari_tejari_eskelet_eskelet_check2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_eskelet_eskelet_check;
            String _more_joziat_melk_edari_tejari_eskelet_eskelet_edit2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_eskelet_eskelet_edit;
            String _more_joziat_melk_edari_tejari_divar_divar_check2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_divar_divar_check;
            String _more_joziat_melk_edari_tejari_divar_divar_edit2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_divar_divar_edit;
            String _more_joziat_melk_edari_tejari_coldhot_coldhot_check2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_coldhot_coldhot_check;
            String _more_joziat_melk_edari_tejari_coldhot_coldhot_edit2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_coldhot_coldhot_edit;
            String _more_joziat_melk_edari_tejari_refahi_refahi_check_mosta2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_refahi_refahi_check_mosta;
            String _more_joziat_melk_edari_tejari_refahi_refahi_edit2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_refahi_refahi_edit;
            String _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta;
            String _more_joziat_melk_edari_tejari_safe_safe_edit2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_safe_safe_edit;
            String _more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta;
            String _more_joziat_melk_edari_tejari_dastresi_dastres_edit2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_dastresi_dastres_edit;
            String _more_joziat_melk_edari_tejari_ghozar_asli2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_ghozar_asli;
            String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;
            String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit;
            String _more_joziat_melk_edari_tejari_sport_sport_check2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_sport_sport_check;
            String _more_joziat_melk_edari_tejari_sport_sport_edit2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_sport_sport_edit;
            String _more_joziat_melk_edari_tejari_view_view_check2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_view_view_check;
            String _more_joziat_melk_edari_tejari_view_view_edit2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_view_view_edit;
            String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta;
            String _more_joziat_melk_edari_tejari_tasisat_tasisat_edit2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam2 = product_showpostMOSTA._more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;


            return view;
        }
    }

    public void GetjsonarrayZAMIN() {
        try {
            String dataServer3 = dataServer234;
            jsonArray = new JSONArray(dataServer3);
            // _more_joziat_melk_edari_tejari_kaf_kaf_check
            ArrayList<product_showpostZAMIN> product_showpostZAMIN = new ArrayList<product_showpostZAMIN>();
            ProductAdapterZAMIN adapter123 = new ProductAdapterZAMIN(Main25Activity.this, R.layout.activity_main2, product_showpostZAMIN);
            listViewEditPage.setAdapter(adapter123);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                int ID = jsonObject1.getInt("ID");
                String content = jsonObject1.getString("post_content");
                String title = jsonObject1.getString("post_title");
                String guid11 = jsonObject1.getString("guid11");

                String _noe_melk_moamele = jsonObject1.getString("_noe_melk_moamele");
                String _noe_melk = jsonObject1.getString("_noe_melk");
                String _moshakhasat_asli_melk_karbari_now = jsonObject1.getString("_moshakhasat_asli_melk_karbari_now");
                String _moshakhasat_asli_melk_masahat_zamin_after_eslahie = jsonObject1.getString("_moshakhasat_asli_melk_masahat_zamin_after_eslahie");
                String _moshakhasat_asli_melk_tol_bar_asli = jsonObject1.getString("_moshakhasat_asli_melk_tol_bar_asli");
                String _moshakhasat_asli_melk_number_bar = jsonObject1.getString("_moshakhasat_asli_melk_number_bar");
                String _moshakhasat_asli_melk_vaziita_build_vazita_zamin = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_vazita_zamin");
                String _price_shrayet_sell_cheng_price_all_sell_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_price_all_sell_cheng");
                String _price_shrayet_sell_cheng_check_seel_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_check_seel_cheng");
                String _price_shrayet_sell_cheng_max_money = jsonObject1.getString("_price_shrayet_sell_cheng_max_money");
                String _price_shrayet_sell_cheng_money_pish_pay = jsonObject1.getString("_price_shrayet_sell_cheng_money_pish_pay");
                String _price_shrayet_sell_cheng_time_tahvil = jsonObject1.getString("_price_shrayet_sell_cheng_time_tahvil");
                String _price_shrayet_sell_cheng_mizan_anjam_shode = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_anjam_shode");
                String _price_shrayet_sell_cheng_mizan_vam = jsonObject1.getString("_price_shrayet_sell_cheng_mizan_vam");
                String _price_shrayet_sell_cheng_sod_vam = jsonObject1.getString("_price_shrayet_sell_cheng_sod_vam");
                String _price_shrayet_sell_cheng_number_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_number_ghest");
                String _price_shrayet_sell_cheng_price_har_ghest = jsonObject1.getString("_price_shrayet_sell_cheng_price_har_ghest");
                String _price_shrayet_sell_cheng_price_rahn = jsonObject1.getString("_price_shrayet_sell_cheng_price_rahn");
                String _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check");
                String _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit");
                String _more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin = jsonObject1.getString("_more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin");
                String _more_joziat_melk_edari_tejari_dastresi_dastres_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_dastresi_dastres_edit");
                String _more_joziat_melk_edari_tejari_ghozar_asli = jsonObject1.getString("_more_joziat_melk_edari_tejari_ghozar_asli");
                String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin");
                String _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
                String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");

                product_showpostZAMIN.add(new product_showpostZAMIN(ID, content, title, guid11

                        , _noe_melk_moamele // _noe_melk_moamele ;
                        , _noe_melk // _noe_melk ;
                        , _moshakhasat_asli_melk_karbari_now // _moshakhasat_asli_melk_karbari_now ;
                        , _moshakhasat_asli_melk_masahat_zamin_after_eslahie // _moshakhasat_asli_melk_masahat_zamin_after_eslahie ;
                        , _moshakhasat_asli_melk_tol_bar_asli // _moshakhasat_asli_melk_tol_bar_asli ;
                        , _moshakhasat_asli_melk_number_bar // _moshakhasat_asli_melk_number_bar ;
                        , _moshakhasat_asli_melk_vaziita_build_vazita_zamin // _moshakhasat_asli_melk_vaziita_build_vazita_zamin ;
                        , _price_shrayet_sell_cheng_price_all_sell_cheng // _price_shrayet_sell_cheng_price_all_sell_cheng ;
                        , _price_shrayet_sell_cheng_check_seel_cheng // _price_shrayet_sell_cheng_check_seel_cheng ;
                        , _price_shrayet_sell_cheng_max_money // _price_shrayet_sell_cheng_max_money ;
                        , _price_shrayet_sell_cheng_money_pish_pay // _price_shrayet_sell_cheng_money_pish_pay ;
                        , _price_shrayet_sell_cheng_time_tahvil // _price_shrayet_sell_cheng_time_tahvil ;
                        , _price_shrayet_sell_cheng_mizan_anjam_shode // _price_shrayet_sell_cheng_mizan_anjam_shode ;
                        , _price_shrayet_sell_cheng_mizan_vam // _price_shrayet_sell_cheng_mizan_vam ;
                        , _price_shrayet_sell_cheng_sod_vam // _price_shrayet_sell_cheng_sod_vam ;
                        , _price_shrayet_sell_cheng_number_ghest // _price_shrayet_sell_cheng_number_ghest ;
                        , _price_shrayet_sell_cheng_price_har_ghest // _price_shrayet_sell_cheng_price_har_ghest ;
                        , _price_shrayet_sell_cheng_price_rahn // _price_shrayet_sell_cheng_price_rahn ;
                        , _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check // _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check ;
                        , _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit // _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit ;
                        , _more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin // _more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin ;
                        , _more_joziat_melk_edari_tejari_dastresi_dastres_edit // _more_joziat_melk_edari_tejari_dastresi_dastres_edit ;
                        , _more_joziat_melk_edari_tejari_ghozar_asli // _more_joziat_melk_edari_tejari_ghozar_asli ;
                        , _more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin // _more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin ;
                        , _more_joziat_melk_edari_tejari_tasisat_tasisat_edit // _more_joziat_melk_edari_tejari_tasisat_tasisat_edit ;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat // _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat ;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat // _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat ;
                        , _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam // _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam ;


                ));
                adapter123.notifyDataSetChanged();
//set again adapter!


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    
    public class ProductAdapterZAMIN extends ArrayAdapter {


        private int resourceId;
        private Activity activity;
        private ArrayList<product_showpostZAMIN> productArrayList;

        public ProductAdapterZAMIN(Activity activity, int resourceId, ArrayList<product_showpostZAMIN> object) {
            super(activity, resourceId, object);
            this.activity = activity;
            this.resourceId = resourceId;
            this.productArrayList = object;
        }

        @Override
        public View getView(final int position, View converView, ViewGroup parent) {
            View view = converView;
            view = this.activity.getLayoutInflater().inflate(this.resourceId, null);


            final product_showpostZAMIN product_showpostZAMIN = productArrayList.get(position);


            String guid112 = product_showpostZAMIN.guid11;
            String post_title2 = product_showpostZAMIN.post_title;
            String post_content2 = product_showpostZAMIN.post_content;

            String _noe_melk_moamele2 = product_showpostZAMIN._noe_melk_moamele;
            String _noe_melk2 = product_showpostZAMIN._noe_melk;
            String _moshakhasat_asli_melk_karbari_now2 = product_showpostZAMIN._moshakhasat_asli_melk_karbari_now;
            String _moshakhasat_asli_melk_masahat_zamin_after_eslahie2 = product_showpostZAMIN._moshakhasat_asli_melk_masahat_zamin_after_eslahie;
            String _moshakhasat_asli_melk_tol_bar_asli2 = product_showpostZAMIN._moshakhasat_asli_melk_tol_bar_asli;
            String _moshakhasat_asli_melk_number_bar2 = product_showpostZAMIN._moshakhasat_asli_melk_number_bar;
            String _moshakhasat_asli_melk_vaziita_build_vazita_zamin2 = product_showpostZAMIN._moshakhasat_asli_melk_vaziita_build_vazita_zamin;
            String _price_shrayet_sell_cheng_price_all_sell_cheng2 = product_showpostZAMIN._price_shrayet_sell_cheng_price_all_sell_cheng;
            String _price_shrayet_sell_cheng_check_seel_cheng2 = product_showpostZAMIN._price_shrayet_sell_cheng_check_seel_cheng;
            String _price_shrayet_sell_cheng_max_money2 = product_showpostZAMIN._price_shrayet_sell_cheng_max_money;
            String _price_shrayet_sell_cheng_money_pish_pay2 = product_showpostZAMIN._price_shrayet_sell_cheng_money_pish_pay;
            String _price_shrayet_sell_cheng_time_tahvil2 = product_showpostZAMIN._price_shrayet_sell_cheng_time_tahvil;
            String _price_shrayet_sell_cheng_mizan_anjam_shode2 = product_showpostZAMIN._price_shrayet_sell_cheng_mizan_anjam_shode;
            String _price_shrayet_sell_cheng_mizan_vam2 = product_showpostZAMIN._price_shrayet_sell_cheng_mizan_vam;
            String _price_shrayet_sell_cheng_sod_vam2 = product_showpostZAMIN._price_shrayet_sell_cheng_sod_vam;
            String _price_shrayet_sell_cheng_number_ghest2 = product_showpostZAMIN._price_shrayet_sell_cheng_number_ghest;
            String _price_shrayet_sell_cheng_price_har_ghest2 = product_showpostZAMIN._price_shrayet_sell_cheng_price_har_ghest;
            String _price_shrayet_sell_cheng_price_rahn2 = product_showpostZAMIN._price_shrayet_sell_cheng_price_rahn;
            String _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check2 = product_showpostZAMIN._more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;
            String _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit2 = product_showpostZAMIN._more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit;
            String _more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin2 = product_showpostZAMIN._more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin;
            String _more_joziat_melk_edari_tejari_dastresi_dastres_edit2 = product_showpostZAMIN._more_joziat_melk_edari_tejari_dastresi_dastres_edit;
            String _more_joziat_melk_edari_tejari_ghozar_asli2 = product_showpostZAMIN._more_joziat_melk_edari_tejari_ghozar_asli;
            String _more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin2 = product_showpostZAMIN._more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin;
            String _more_joziat_melk_edari_tejari_tasisat_tasisat_edit2 = product_showpostZAMIN._more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat2 = product_showpostZAMIN._more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat2 = product_showpostZAMIN._more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
            String _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam2 = product_showpostZAMIN._more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;


            return view;
        }
    }


}