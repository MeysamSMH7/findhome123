package sam.com.findhome;

import android.os.AsyncTask;
import android.text.method.DateTimeKeyListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Objects;


public class Connect extends AsyncTask {

    public String link = "";
    public String post_content = ""; //matn
    public String post_title = "";
    public String post_name = ""; //need transletor
    public Integer IdPost = 0; //need transletor

    public String noe_melk_moamele = "";
    public String noe_melk = "";
    public String moshakhasat_asli_melk_noe_bana = "";
    public String moshakhasat_asli_melk_masahat_build = "";
    public String moshakhasat_asli_melk_masahat_zamin = "";
    public String moshakhasat_asli_melk_number_room = "";
    public String moshakhasat_asli_melk_number_parking = "";
    public String moshakhasat_asli_melk_sale_build = "";
    public String moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = "";
    public String moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = "";
    public String price_shrayet_sell_cheng_price_all_sell_cheng = "";
    public String price_shrayet_sell_cheng_check_seel_cheng = "";
    public String price_shrayet_sell_cheng_max_money = "";
    public String price_shrayet_sell_cheng_money_pish_pay = "";
    public String price_shrayet_sell_cheng_time_tahvil = "";
    public String price_shrayet_sell_cheng_mizan_anjam_shode = "";
    public String price_shrayet_sell_cheng_mizan_vam = "";
    public String price_shrayet_sell_cheng_sod_vam = "";
    public String price_shrayet_sell_cheng_number_ghest = "";
    public String price_shrayet_sell_cheng_price_har_ghest = "";
    public String price_shrayet_sell_cheng_price_rahn = "";
    public String more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = "";
    public String more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = "";
    public String more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = "";
    public String more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = "";
    public String more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = "";
    public String more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari = "";
    public String more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari = "";
    public String more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon = "";
    public String more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon = "";
    public String more_joziat_melk_edari_tejari_wc_wc_irani = "";
    public String more_joziat_melk_edari_tejari_wc_wc_us = "";
    public String more_joziat_melk_edari_tejari_wc_bath = "";
    public String more_joziat_melk_edari_tejari_kitchen_kitchen_check = "";
    public String more_joziat_melk_edari_tejari_kitchen_kitchen_radio = "";
    public String more_joziat_melk_edari_tejari_kitchen_darai_kabinet = "";
    public String more_joziat_melk_edari_tejari_kitchen_badane_kabinet = "";
    public String more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = "";
    public String more_joziat_melk_edari_tejari_kitchen_roye_kabinet = "";
    public String more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen = "";
    public String more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen = "";
    public String more_joziat_melk_edari_tejari_neshiman_neshiman_check = "";
    public String more_joziat_melk_edari_tejari_neshiman_neshiman_edit = "";
    public String more_joziat_melk_edari_tejari_shekle_build_radio = "";
    public String more_joziat_melk_edari_tejari_nama_nama_check = "";
    public String more_joziat_melk_edari_tejari_nama_nama_edit = "";
    public String more_joziat_melk_edari_tejari_eskelet_eskelet_check = "";
    public String more_joziat_melk_edari_tejari_eskelet_eskelet_edit = "";
    public String more_joziat_melk_edari_tejari_kaf_kaf_check = "";
    public String more_joziat_melk_edari_tejari_kaf_kaf_edit = "";
    public String more_joziat_melk_edari_tejari_divar_divar_check = "";
    public String more_joziat_melk_edari_tejari_divar_divar_edit = "";
    public String more_joziat_melk_edari_tejari_coldhot_coldhot_check = "";
    public String more_joziat_melk_edari_tejari_coldhot_coldhot_edit = "";
    public String more_joziat_melk_edari_tejari_refahi_refahi_check = "";
    public String more_joziat_melk_edari_tejari_refahi_refahi_edit = "";
    public String more_joziat_melk_edari_tejari_safe_safe_check = "";
    public String more_joziat_melk_edari_tejari_safe_safe_edit = "";
    public String more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = "";
    public String more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = "";
    public String more_joziat_melk_edari_tejari_sport_sport_check = "";
    public String more_joziat_melk_edari_tejari_sport_sport_edit = "";
    public String more_joziat_melk_edari_tejari_view_view_check = "";
    public String more_joziat_melk_edari_tejari_view_view_edit = "";
    public String more_joziat_melk_edari_tejari_nor_nor_check = "";
    public String more_joziat_melk_edari_tejari_tasisat_tasisat_check = "";
    public String more_joziat_melk_edari_tejari_tasisat_tasisat_edit = "";
    public String more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = "";
    public String more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = "";
    public String more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = "";
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

    public Connect(String link, String post_content, String post_title, String post_name,


                   Integer IdPost,
                   String noe_melk_moamele,
                   String noe_melk,
                   String moshakhasat_asli_melk_noe_bana,
                   String moshakhasat_asli_melk_masahat_build,
                   String moshakhasat_asli_melk_masahat_zamin,
                   String moshakhasat_asli_melk_number_room,
                   String moshakhasat_asli_melk_number_parking,
                   String moshakhasat_asli_melk_sale_build,
                   String moshakhasat_asli_melk_vaziita_build_vaziita_build_radio,
                   String moshakhasat_asli_melk_vaziita_build_ghabel_sokonat,
                   String price_shrayet_sell_cheng_price_all_sell_cheng,
                   String price_shrayet_sell_cheng_check_seel_cheng,
                   String price_shrayet_sell_cheng_max_money,
                   String price_shrayet_sell_cheng_money_pish_pay,
                   String price_shrayet_sell_cheng_time_tahvil,
                   String price_shrayet_sell_cheng_mizan_anjam_shode,
                   String price_shrayet_sell_cheng_mizan_vam,
                   String price_shrayet_sell_cheng_sod_vam,
                   String price_shrayet_sell_cheng_number_ghest,
                   String price_shrayet_sell_cheng_price_har_ghest,
                   String price_shrayet_sell_cheng_price_rahn,
                   String more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe,
                   String more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe,
                   String more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe,
                   String more_joziat_melk_edari_tejari_moghit_build_number_all_vahed,
                   String more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build,
                   String more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari,
                   String more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari,
                   String more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon,
                   String more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon,
                   String more_joziat_melk_edari_tejari_wc_wc_irani,
                   String more_joziat_melk_edari_tejari_wc_wc_us,
                   String more_joziat_melk_edari_tejari_wc_bath,
                   String more_joziat_melk_edari_tejari_kitchen_kitchen_check,
                   String more_joziat_melk_edari_tejari_kitchen_kitchen_radio,
                   String more_joziat_melk_edari_tejari_kitchen_darai_kabinet,
                   String more_joziat_melk_edari_tejari_kitchen_badane_kabinet,
                   String more_joziat_melk_edari_tejari_kitchen_safhe_kabinet,
                   String more_joziat_melk_edari_tejari_kitchen_roye_kabinet,
                   String more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen,
                   String more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen,
                   String more_joziat_melk_edari_tejari_neshiman_neshiman_check,
                   String more_joziat_melk_edari_tejari_neshiman_neshiman_edit,
                   String more_joziat_melk_edari_tejari_shekle_build_radio,
                   String more_joziat_melk_edari_tejari_nama_nama_check,
                   String more_joziat_melk_edari_tejari_nama_nama_edit,
                   String more_joziat_melk_edari_tejari_eskelet_eskelet_check,
                   String more_joziat_melk_edari_tejari_eskelet_eskelet_edit,
                   String more_joziat_melk_edari_tejari_kaf_kaf_check,
                   String more_joziat_melk_edari_tejari_kaf_kaf_edit,
                   String more_joziat_melk_edari_tejari_divar_divar_check,
                   String more_joziat_melk_edari_tejari_divar_divar_edit,
                   String more_joziat_melk_edari_tejari_coldhot_coldhot_check,
                   String more_joziat_melk_edari_tejari_coldhot_coldhot_edit,
                   String more_joziat_melk_edari_tejari_refahi_refahi_check,
                   String more_joziat_melk_edari_tejari_refahi_refahi_edit,
                   String more_joziat_melk_edari_tejari_safe_safe_check,
                   String more_joziat_melk_edari_tejari_safe_safe_edit,
                   String more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta,
                   String more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit,
                   String more_joziat_melk_edari_tejari_sport_sport_check,
                   String more_joziat_melk_edari_tejari_sport_sport_edit,
                   String more_joziat_melk_edari_tejari_view_view_check,
                   String more_joziat_melk_edari_tejari_view_view_edit,
                   String more_joziat_melk_edari_tejari_nor_nor_check,
                   String more_joziat_melk_edari_tejari_tasisat_tasisat_check,
                   String more_joziat_melk_edari_tejari_tasisat_tasisat_edit,
                   String more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat,
                   String more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat,
                   String more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam
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
        this.noe_melk = noe_melk;
        this.moshakhasat_asli_melk_noe_bana = moshakhasat_asli_melk_noe_bana;
        this.moshakhasat_asli_melk_masahat_build = moshakhasat_asli_melk_masahat_build;
        this.moshakhasat_asli_melk_masahat_zamin = moshakhasat_asli_melk_masahat_zamin;
        this.moshakhasat_asli_melk_number_room = moshakhasat_asli_melk_number_room;
        this.moshakhasat_asli_melk_number_parking = moshakhasat_asli_melk_number_parking;
        this.moshakhasat_asli_melk_sale_build = moshakhasat_asli_melk_sale_build;
        this.moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = moshakhasat_asli_melk_vaziita_build_vaziita_build_radio;
        this.moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = moshakhasat_asli_melk_vaziita_build_ghabel_sokonat;
        this.price_shrayet_sell_cheng_price_all_sell_cheng = price_shrayet_sell_cheng_price_all_sell_cheng;
        this.price_shrayet_sell_cheng_check_seel_cheng = price_shrayet_sell_cheng_check_seel_cheng;
        this.price_shrayet_sell_cheng_max_money = price_shrayet_sell_cheng_max_money;
        this.price_shrayet_sell_cheng_money_pish_pay = price_shrayet_sell_cheng_money_pish_pay;
        this.price_shrayet_sell_cheng_time_tahvil = price_shrayet_sell_cheng_time_tahvil;
        this.price_shrayet_sell_cheng_mizan_anjam_shode = price_shrayet_sell_cheng_mizan_anjam_shode;
        this.price_shrayet_sell_cheng_mizan_vam = price_shrayet_sell_cheng_mizan_vam;
        this.price_shrayet_sell_cheng_sod_vam = price_shrayet_sell_cheng_sod_vam;
        this.price_shrayet_sell_cheng_number_ghest = price_shrayet_sell_cheng_number_ghest;
        this.price_shrayet_sell_cheng_price_har_ghest = price_shrayet_sell_cheng_price_har_ghest;
        this.price_shrayet_sell_cheng_price_rahn = price_shrayet_sell_cheng_price_rahn;
        this.more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe;
        this.more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe;
        this.more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe;
        this.more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = more_joziat_melk_edari_tejari_moghit_build_number_all_vahed;
        this.more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build;
        this.more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari = more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari;
        this.more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari = more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari;
        this.more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon = more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon;
        this.more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon = more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon;
        this.more_joziat_melk_edari_tejari_wc_wc_irani = more_joziat_melk_edari_tejari_wc_wc_irani;
        this.more_joziat_melk_edari_tejari_wc_wc_us = more_joziat_melk_edari_tejari_wc_wc_us;
        this.more_joziat_melk_edari_tejari_wc_bath = more_joziat_melk_edari_tejari_wc_bath;
        this.more_joziat_melk_edari_tejari_kitchen_kitchen_check = more_joziat_melk_edari_tejari_kitchen_kitchen_check;
        this.more_joziat_melk_edari_tejari_kitchen_kitchen_radio = more_joziat_melk_edari_tejari_kitchen_kitchen_radio;
        this.more_joziat_melk_edari_tejari_kitchen_darai_kabinet = more_joziat_melk_edari_tejari_kitchen_darai_kabinet;
        this.more_joziat_melk_edari_tejari_kitchen_badane_kabinet = more_joziat_melk_edari_tejari_kitchen_badane_kabinet;
        this.more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = more_joziat_melk_edari_tejari_kitchen_safhe_kabinet;
        this.more_joziat_melk_edari_tejari_kitchen_roye_kabinet = more_joziat_melk_edari_tejari_kitchen_roye_kabinet;
        this.more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen = more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen;
        this.more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen = more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen;
        this.more_joziat_melk_edari_tejari_neshiman_neshiman_check = more_joziat_melk_edari_tejari_neshiman_neshiman_check;
        this.more_joziat_melk_edari_tejari_neshiman_neshiman_edit = more_joziat_melk_edari_tejari_neshiman_neshiman_edit;
        this.more_joziat_melk_edari_tejari_shekle_build_radio = more_joziat_melk_edari_tejari_shekle_build_radio;
        this.more_joziat_melk_edari_tejari_nama_nama_check = more_joziat_melk_edari_tejari_nama_nama_check;
        this.more_joziat_melk_edari_tejari_nama_nama_edit = more_joziat_melk_edari_tejari_nama_nama_edit;
        this.more_joziat_melk_edari_tejari_eskelet_eskelet_check = more_joziat_melk_edari_tejari_eskelet_eskelet_check;
        this.more_joziat_melk_edari_tejari_eskelet_eskelet_edit = more_joziat_melk_edari_tejari_eskelet_eskelet_edit;
        this.more_joziat_melk_edari_tejari_kaf_kaf_check = more_joziat_melk_edari_tejari_kaf_kaf_check;
        this.more_joziat_melk_edari_tejari_kaf_kaf_edit = more_joziat_melk_edari_tejari_kaf_kaf_edit;
        this.more_joziat_melk_edari_tejari_divar_divar_check = more_joziat_melk_edari_tejari_divar_divar_check;
        this.more_joziat_melk_edari_tejari_divar_divar_edit = more_joziat_melk_edari_tejari_divar_divar_edit;
        this.more_joziat_melk_edari_tejari_coldhot_coldhot_check = more_joziat_melk_edari_tejari_coldhot_coldhot_check;
        this.more_joziat_melk_edari_tejari_coldhot_coldhot_edit = more_joziat_melk_edari_tejari_coldhot_coldhot_edit;
        this.more_joziat_melk_edari_tejari_refahi_refahi_check = more_joziat_melk_edari_tejari_refahi_refahi_check;
        this.more_joziat_melk_edari_tejari_refahi_refahi_edit = more_joziat_melk_edari_tejari_refahi_refahi_edit;
        this.more_joziat_melk_edari_tejari_safe_safe_check = more_joziat_melk_edari_tejari_safe_safe_check;
        this.more_joziat_melk_edari_tejari_safe_safe_edit = more_joziat_melk_edari_tejari_safe_safe_edit;
        this.more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;
        this.more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit;
        this.more_joziat_melk_edari_tejari_sport_sport_check = more_joziat_melk_edari_tejari_sport_sport_check;
        this.more_joziat_melk_edari_tejari_sport_sport_edit = more_joziat_melk_edari_tejari_sport_sport_edit;
        this.more_joziat_melk_edari_tejari_view_view_check = more_joziat_melk_edari_tejari_view_view_check;
        this.more_joziat_melk_edari_tejari_view_view_edit = more_joziat_melk_edari_tejari_view_view_edit;
        this.more_joziat_melk_edari_tejari_nor_nor_check = more_joziat_melk_edari_tejari_nor_nor_check;
        this.more_joziat_melk_edari_tejari_tasisat_tasisat_check = more_joziat_melk_edari_tejari_tasisat_tasisat_check;
        this.more_joziat_melk_edari_tejari_tasisat_tasisat_edit = more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
        this.more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
        this.more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
        this.more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;
        this.NameFamilyST = NameFamilyST;
        this.MahaleLiveST = MahaleLiveST;
        this.EmailST = EmailST;
        this.PhoneNumberST = PhoneNumberST;
        this.stIDimage_1 = stIDimage_1;
        this.stIDimage_2 = stIDimage_2;
        this.stIDimage_3 = stIDimage_3;
        this.stIDimage_4 = stIDimage_4;
        this.stIDimage_5 = stIDimage_5;
        this.stIDimage_6 = stIDimage_6;
        this.stIDimage_7 = stIDimage_7;
        this.stIDimage_8 = stIDimage_8;
        this.stIDimage_9 = stIDimage_9;
        this.stIDimage_10 = stIDimage_10;

        this.finalstIDimage_1 = finalstIDimage_1;
        this.finalstIDimage_2 = finalstIDimage_2;
        this.finalstIDimage_3 = finalstIDimage_3;
        this.finalstIDimage_4 = finalstIDimage_4;
        this.finalstIDimage_5 = finalstIDimage_5;
        this.finalstIDimage_6 = finalstIDimage_6;
        this.finalstIDimage_7 = finalstIDimage_7;
        this.finalstIDimage_8 = finalstIDimage_8;
        this.finalstIDimage_9 = finalstIDimage_9;
        this.finalstIDimage_10 = finalstIDimage_10;
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
            senddata = senddata + "&" + URLEncoder.encode("noe_melk ", "UTF8") + "=" + URLEncoder.encode(noe_melk, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_noe_bana", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_noe_bana, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_masahat_build", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_masahat_build, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_masahat_zamin", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_masahat_zamin, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_number_room", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_number_room, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_number_parking", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_number_parking, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_sale_build", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_sale_build, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_vaziita_build_vaziita_build_radio", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_vaziita_build_vaziita_build_radio, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("moshakhasat_asli_melk_vaziita_build_ghabel_sokonat", "UTF8") + "=" + URLEncoder.encode(moshakhasat_asli_melk_vaziita_build_ghabel_sokonat, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("price_shrayet_sell_cheng_price_all_sell_cheng", "UTF8") + "=" + URLEncoder.encode(price_shrayet_sell_cheng_price_all_sell_cheng, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("price_shrayet_sell_cheng_check_seel_cheng", "UTF8") + "=" + URLEncoder.encode(price_shrayet_sell_cheng_check_seel_cheng, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("price_shrayet_sell_cheng_max_money", "UTF8") + "=" + URLEncoder.encode(price_shrayet_sell_cheng_max_money, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("price_shrayet_sell_cheng_money_pish_pay", "UTF8") + "=" + URLEncoder.encode(price_shrayet_sell_cheng_money_pish_pay, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("price_shrayet_sell_cheng_time_tahvil", "UTF8") + "=" + URLEncoder.encode(price_shrayet_sell_cheng_time_tahvil, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("price_shrayet_sell_cheng_mizan_anjam_shode", "UTF8") + "=" + URLEncoder.encode(price_shrayet_sell_cheng_mizan_anjam_shode, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("price_shrayet_sell_cheng_mizan_vam", "UTF8") + "=" + URLEncoder.encode(price_shrayet_sell_cheng_mizan_vam, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("price_shrayet_sell_cheng_sod_vam", "UTF8") + "=" + URLEncoder.encode(price_shrayet_sell_cheng_sod_vam, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("price_shrayet_sell_cheng_number_ghest", "UTF8") + "=" + URLEncoder.encode(price_shrayet_sell_cheng_number_ghest, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("price_shrayet_sell_cheng_price_har_ghest", "UTF8") + "=" + URLEncoder.encode(price_shrayet_sell_cheng_price_har_ghest, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("price_shrayet_sell_cheng_price_rahn", "UTF8") + "=" + URLEncoder.encode(price_shrayet_sell_cheng_price_rahn, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moghit_build_number_all_vahed", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moghit_build_number_all_vahed, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_wc_wc_irani", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_wc_wc_irani, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_wc_wc_us", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_wc_wc_us, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_wc_bath", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_wc_bath, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_kitchen_kitchen_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_kitchen_kitchen_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_kitchen_kitchen_radio", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_kitchen_kitchen_radio, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_kitchen_darai_kabinet", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_kitchen_darai_kabinet, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_kitchen_badane_kabinet", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_kitchen_badane_kabinet, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_kitchen_safhe_kabinet", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_kitchen_safhe_kabinet, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_kitchen_roye_kabinet", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_kitchen_roye_kabinet, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_neshiman_neshiman_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_neshiman_neshiman_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_neshiman_neshiman_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_neshiman_neshiman_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_shekle_build_radio", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_shekle_build_radio, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_nama_nama_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_nama_nama_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_nama_nama_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_nama_nama_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_eskelet_eskelet_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_eskelet_eskelet_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_eskelet_eskelet_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_eskelet_eskelet_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_kaf_kaf_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_kaf_kaf_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_kaf_kaf_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_kaf_kaf_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_divar_divar_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_divar_divar_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_divar_divar_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_divar_divar_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_coldhot_coldhot_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_coldhot_coldhot_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_coldhot_coldhot_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_coldhot_coldhot_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_refahi_refahi_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_refahi_refahi_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_refahi_refahi_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_refahi_refahi_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_safe_safe_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_safe_safe_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_safe_safe_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_safe_safe_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_sport_sport_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_sport_sport_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_sport_sport_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_sport_sport_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_view_view_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_view_view_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_view_view_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_view_view_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_nor_nor_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_nor_nor_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_tasisat_tasisat_check", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_tasisat_tasisat_check, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_tasisat_tasisat_edit", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_tasisat_tasisat_edit, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam", "UTF8") + "=" + URLEncoder.encode(more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam, "UTF8");

            senddata = senddata + "&" + URLEncoder.encode("NameFamilyST", "UTF8") + "=" + URLEncoder.encode(NameFamilyST, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("MahaleLiveST", "UTF8") + "=" + URLEncoder.encode(MahaleLiveST, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("EmailST", "UTF8") + "=" + URLEncoder.encode(EmailST, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("PhoneNumberST", "UTF8") + "=" + URLEncoder.encode(PhoneNumberST, "UTF8");

            senddata = senddata + "&" + URLEncoder.encode("stIDimage_1", "UTF8") + "=" + URLEncoder.encode(stIDimage_1, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_2", "UTF8") + "=" + URLEncoder.encode(stIDimage_2, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_3", "UTF8") + "=" + URLEncoder.encode(stIDimage_3, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_4", "UTF8") + "=" + URLEncoder.encode(stIDimage_4, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_5", "UTF8") + "=" + URLEncoder.encode(stIDimage_5, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_6", "UTF8") + "=" + URLEncoder.encode(stIDimage_6, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_7", "UTF8") + "=" + URLEncoder.encode(stIDimage_7, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_8", "UTF8") + "=" + URLEncoder.encode(stIDimage_8, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_9", "UTF8") + "=" + URLEncoder.encode(stIDimage_9, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("stIDimage_10", "UTF8") + "=" + URLEncoder.encode(stIDimage_10, "UTF8");

            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_1", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_1, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_2", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_2, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_3", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_3, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_4", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_4, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_5", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_5, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_6", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_6, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_7", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_7, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_8", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_8, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_9", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_9, "UTF8");
            senddata = senddata + "&" + URLEncoder.encode("finalstIDimage_10", "UTF8") + "=" + URLEncoder.encode(finalstIDimage_10, "UTF8");
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

