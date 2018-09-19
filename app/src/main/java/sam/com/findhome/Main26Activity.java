package sam.com.findhome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Random;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Main26Activity extends AppCompatActivity {


    String a = "";

    public static String dataServer23 = "";
    public static String dataServer234 = "";
    private static String sb1;
    JSONArray jsonArray = null;
    JSONArray jsonArrayEDARI = null;
    int ID_send = 0;

    ListView listView_ShowPost;
    Button button12;

    String noe_MELK_android123 = "";

    private String[] String_ = {"انتخاب کنید", ""};
    private String[] String_default = {"انتخاب کنید"};
    private String[] String_deal = {"انتخاب کنید", "فروش، پیش فروش، معاوضه", "رهن و اجاره"};
    private String[] String_melk_W_ground = {"انتخاب کنید", "مسکونی (خانه)", "اداری(دفترکار)", "تجاری(مغازه)", "مستغلات(کل ملک و زمین)", "زمین"};
    private String[] String_melk_WO_ground = {"انتخاب کنید", "مسکونی (خانه)", "اداری(دفترکار)", "تجاری(مغازه)", "مستغلات(کل ملک و زمین)"};
    private String[] String_noe_bana = {"انتخاب کنید", "یک واحد آپارتمانی", "یک طبقه از خانه دو یا سه طبقه", "ویلایی"};
    private String[] String_number = {"انتخاب کنید", "صفر", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "بیشتر از 10"};
    private String[] String_pish_sell_mizan = {"انتخاب کنید", "10درصد", "20درصد", "30درصد", "40درصد", "50درصد", "60درصد", "70درصد", "80درصد", "90درصد"};
    private String[] String_num_WC = {"انتخاب کنید", "ندارد", "1عدد", "2عدد", "3عدد", "4عدد", "5عدد", "6عدد", "بیشتر از6"};
    private String[] String_ketchen_kabinet = {"انتخاب کنید", "ام دی اف", "نئوپان", "پلی وود", "فلزی", "چوبی"};
    private String[] String_ketchen_kabinet_roye = {"انتخاب کنید", "ملامینه", "HPL", "PVC", "فلزی", "کاغذی"};
    private String[] String_phone = {"انتخاب کنید", "ندارد", "1خط", "2خط", "3خط", "4خط", "5خط", "6خط", "بیشتر از 6خط"};
    private String[] String_dong = {"انتخاب کنید", "نیم دانگ", "1دانگ", "1/5دانگ", "2دانگ", "2/5دانگ", "3دانگ", "3/5دانگ", "4دانگ", "4/5دانگ", "5دانگ", "5/5دانگ", "6دانگ"};
    private String[] String_noe_malekati = {"انتخاب کنید", "سند رسمی(قطعی)", "قولنامه ای", "وکالتی", "مبایعه نامه ای", "قراردادی", "بنچاق", "صلح نامه", "زمین شهری", "برگه حاک شرع", "اوقاف", "سازمانی", "تعاونی", "بنیاد شهید", "شهرداری", "صنایع دفاع", "نامشخص"};
    private String[] String_mogheitat_build = {"انتخاب کنید", "ساختمان اداری با موقعیت اداری", "ساختمان اداری با سند اداری"};
    private String[] String_dahane = {"انتخاب کنید", "1دهنه", "2دهنه", "3دهنه", "4دهنه", "5دهنه", "6دهنه", "7دهنه", "8دهنه", "9دهنه", "10دهنه", "بیشتر از 10دهنه"};
    private String[] String_nabsh = {"انتخاب کنید", "1نبش", "2نبش", "3نبش", "4نبش"};
    private String[] String_zamin = {"انتخاب کنید", "مسکونی", "اداری", "تجاری", "صنعتی", "تفریحی - ورزشی", "آموزشی", "توریستی", "دامپروری", "کشاورزی", "باغشهر - مناسب برای شهرک سازی", "خدماتی - رفاهی", "انبار", "پارکینگ", "بایر"};
    private String[] String_tejari_moghiat = {"انتخاب کنید", "مغازه کنار گذر", "مغازه داخل پاساژ یا مرکز خرید"};
    private String[] String_mostaghelat = {"انتخاب کنید", "باغ - باغچه", "کل آپارتمان یا مجتمع مسکونی یکجا", "کل خانه 2 یا 3 طبقه با زمین یکجا", "کل پاساژ یا مرکز خرید", "انبار", "پارکینگ", "سوله", "کارگاه", "کارخانه", "استخر", "سالن ورزشی", "سینما", "تئاتر", "سفره خانه", "رستوران", "پرورش دام", "مرغداری", "پرورش ماهی", "هتل", "مسافرخانه"};

    Spinner
            spinner_noe_dael, spinner_noe_melk, spinner_noe_bana, spinner_num_room, spinner_num_parking, spiner_pish_sell_mizan, spinner_wc_IR, spinner_wc_EN, spinner_wc_bath, spinner_have_kabinet_badane, spinner_have_kabinet_roye, spinner_have_kabinet_safhe, spinner_phone, spinner_dong, spinner_noe_malekati, spinner7;

    ArrayAdapter
            arrayAdapter_default, arrayAdapter_deal, arrayAdapter_W_ground, arrayAdapter_WO_ground, arrayAdapter_noe_bana, arrayAdapter_number, arrayAdapter_pish_sell_mizan, arrayAdapter_wc, arrayAdapter__ketchen_kabinet, arrayAdapter_ketchen_kabinet_roye, arrayAdapter_phone, arrayAdapter_dong, arrayAdapter_noe_malekati, arrayAdapter_mogheitat_build, arrayAdapter_dahane, arrayAdapter_nabsh, arrayAdapter_zamin, arrayAdapter_tejari_moghiat, arrayAdapter_mostaghelat;

    AlertDialog
            pop_up_page, pop_up_page2;

    RadioGroup
            RadioGP, RadioGP2, RadioGP3;

    RadioButton
            radioButton_NewSAZ, radioButton_OldSAz, radioButton_OLD, radioButton_find_home, radioButton_find_home2, radioButton_find_home3, radioButton5, radioButton6, radioButton7;

    CheckBox
            checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox12, checkBox13, checkBox14, checkBox15, checkBox16, checkBox17, checkBox18, checkBox19, checkBox20, checkBox21, checkBox22, checkBox23, checkBox24, checkBox25, checkBox26, checkBox27, checkBox28, checkBox29, checkBox30, checkBox31, checkBox32, checkBox33, checkBox39, checkBox40, checkBox88, checkBox89, checkBox90, checkBox91, checkBox92, checkBox93, checkBox94, checkBox95, Fine_HoMe_checkBox_reBuild, Fine_HoMe_checkBox_ghabel_live, Fine_HoMe_checkBox_moaveze, Fine_HoMe_checkBox_pish_sell, Fine_HoMe_checkBox_vam, Fine_HoMe_checkBox_sell_with_moshtari, Fine_HoMe_checkBox_have_kabinet, Fine_HoMe_checkBox_have_tajhizat_kitchen, Fine_HoMe_checkBox_neshiman_moble, Fine_HoMe_checkBox123, Fine_HoMe_checkBox2, Fine_HoMe_checkBox3, Fine_HoMe_checkBox4, Fine_HoMe_checkBox5, Fine_HoMe_checkBox6, Fine_HoMe_checkBox7, Fine_HoMe_checkBox8, Fine_HoMe_checkBox9, Fine_HoMe_checkBox10, Fine_HoMe_checkBox11, Fine_HoMe_checkBox12, Fine_HoMe_checkBox13, Fine_HoMe_checkBox14, Fine_HoMe_checkBox15, Fine_HoMe_checkBox16, Fine_HoMe_checkBox17, Fine_HoMe_checkBox18, Fine_HoMe_checkBox19, Fine_HoMe_checkBox20, Fine_HoMe_checkBox21, Fine_HoMe_checkBox22, Fine_HoMe_checkBox23, Fine_HoMe_checkBox24, Fine_HoMe_checkBox25, Fine_HoMe_checkBox26, Fine_HoMe_checkBox27, Fine_HoMe_checkBox28, Fine_HoMe_checkBox29, Fine_HoMe_checkBox30, Fine_HoMe_checkBox31, Fine_HoMe_checkBox32, Fine_HoMe_checkBox331, Fine_HoMe_checkBox341, Fine_HoMe_checkBox351, Fine_HoMe_checkBox361, Fine_HoMe_checkBox371, Fine_HoMe_checkBox381, Fine_HoMe_checkBox39, Fine_HoMe_checkBox40, Fine_HoMe_checkBox33, Fine_HoMe_checkBox34, Fine_HoMe_checkBox35, Fine_HoMe_checkBox36, Fine_HoMe_checkBox37, Fine_HoMe_checkBox38, Fine_HoMe_checkBox41, Fine_HoMe_checkBox42, Fine_HoMe_checkBox43, Fine_HoMe_checkBox44, Fine_HoMe_checkBox45, Fine_HoMe_checkBox46, Fine_HoMe_checkBox47, Fine_HoMe_checkBox48, Fine_HoMe_checkBox49, Fine_HoMe_checkBox50, Fine_HoMe_checkBox51, Fine_HoMe_checkBox52, Fine_HoMe_checkBox53, Fine_HoMe_checkBox54, Fine_HoMe_checkBox55, Fine_HoMe_checkBox56, Fine_HoMe_checkBox57, Fine_HoMe_checkBox58, Fine_HoMe_checkBox59, Fine_HoMe_checkBox60, Fine_HoMe_checkBox61, Fine_HoMe_checkBox62, Fine_HoMe_checkBox63, Fine_HoMe_checkBox64, Fine_HoMe_checkBox65, Fine_HoMe_checkBox66, Fine_HoMe_checkBox67, Fine_HoMe_checkBox68, Fine_HoMe_checkBox69, Fine_HoMe_checkBox70, Fine_HoMe_checkBox71, Fine_HoMe_checkBox72, Fine_HoMe_checkBox73, Fine_HoMe_checkBox74, Fine_HoMe_checkBox75, Fine_HoMe_checkBox76, Fine_HoMe_checkBox77, Fine_HoMe_checkBox78, Fine_HoMe_checkBox79, Fine_HoMe_checkBox80, Fine_HoMe_checkBox81, Fine_HoMe_checkBox82, Fine_HoMe_checkBox83, Fine_HoMe_checkBox84, Fine_HoMe_checkBox85, Fine_HoMe_checkBox86, Fine_HoMe_checkBox87;

    LinearLayout
            number_3, number_3_rahn, liner_moaveze, linear_pish_sell, linear_vam, linear_sell_with_moshtari, liner_have_kabinet, liner_have_tajhizat_kitchen, linear_neshiman_mile, liner_mogheitat_build, liner_bath, linear_sport, linear_view, linear_NEWS, liner_1, Liner_3, liner_emkanat, linear_kitchen, linear_2, linear_shekl_building, linear_eskelet_building, linear_wall, liner_ghozar, liner_4, liner_5, liner_6, liner_moghiat, liner_WC, linear_neshiman, linear_cold_hot, linear_refaii, linear_safe, linear_emkanat, liner_phone2, linear_karbari, linear_kaf, linear_dastresi, linear_nma;

    EditText
            editText_onvan, editTex_matn;

    EditText
            editText_rahnVadie, editText_rahnEjare,editText13, editText14, editText22, Find_HoMe_editText_masahat_made, Find_HoMe_editText_masahat_ground, Find_HoMe_editText_year_made, Find_HoMe_editText_price_deal, Find_HoMe_editText_moaveze, Find_HoMe_editText_pish_sell_price, Find_HoMe_editText_pish_sell_time, Find_HoMe_editText_vam_mizan, Find_HoMe_editText_vam_sod, Find_HoMe_editText_vam_num_ghest, Find_HoMe_editText_vam_num_ghest2, Find_HoMe_editText_sell_with_moshtari, Find_HoMe_editText, Find_HoMe_editText2, Find_HoMe_editText3, Find_HoMe_editText4, Find_HoMe_editText5, Find_HoMe_editText6, Find_HoMe_editText7, Find_HoMe_editText8, Find_HoMe_editText9, Find_HoMe_editText10, Find_HoMe_editText11, Find_HoMe_editText12, Find_HoMe_editText13, Find_HoMe_editText14, Find_HoMe_editText151, Find_HoMe_editText15, Find_HoMe_editText16, Find_HoMe_editText17, Find_HoMe_editText18, Find_HoMe_editText19, Find_HoMe_editText20, Find_HoMe_editText21;

    TextView
            txtView, txtView_noe_bana, txtView_masahat, txtView_1, txtView_2, txtView_3, txtView_4, txtView_5, txtView_6, txtView_7, txtView_8, txtView_9, txtView_10, txtView_11, txtView_12, txtView_13, txtView_14, txtView_15, txtView_16, txtView_17;

    Button
            button123123;

    String
            ST_noe_bana = "";

    int
            counter_vaziita_build = 0, counter_check_seel_cheng = 0, counter_neshiman = 0, counter_nma = 0, counter_eskelet = 0, counter_kaf = 0, counter_divar = 0, counter_coldhot = 0, counter_refahi = 0, counter_safe = 0, counter_emkanat = 0, counter_sport = 0, counter_view = 0, counter_nor = 0, counter_tasisat = 0, counter_NoeSarGhofli = 0, counter_KarbariPishnahadi = 0, counter_dastresi = 0, counter_NoeVaghzari = 0;

    int
            Icounter_vaziita_build = 0, Icounter_check_seel_cheng = 0, Icounter_neshiman = 0, Icounter_nma = 0, Icounter_eskelet = 0, Icounter_kaf = 0, Icounter_divar = 0, Icounter_coldhot = 0, Icounter_refahi = 0, Icounter_safe = 0, Icounter_emkanat = 0, Icounter_sport = 0, Icounter_view = 0, Icounter_nor = 0, Icounter_tasisat = 0, Icounter_NoeSarGhofli = 0, Icounter_KarbariPishnahadi = 0, Icounter_dastresi = 0, Icounter_NoeVaghzari = 0;
    ;

    String
            moshakhasat_asli_melk_noe_bana = "", moshakhasat_asli_melk_masahat_build = "", moshakhasat_asli_melk_masahat_zamin = "", moshakhasat_asli_melk_sale_build = "", price_shrayet_sell_cheng_price_all_sell_cheng = "", price_shrayet_sell_cheng_max_money = "", price_shrayet_sell_cheng_money_pish_pay = "", price_shrayet_sell_cheng_time_tahvil = "", price_shrayet_sell_cheng_mizan_vam = "", price_shrayet_sell_cheng_sod_vam = "", price_shrayet_sell_cheng_number_ghest = "", price_shrayet_sell_cheng_price_har_ghest = "", price_shrayet_sell_cheng_price_rahn = "", more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = "", more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = "", more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = "", more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = "", more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari = "", more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari = "", more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon = "", more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon = "", more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen = "", more_joziat_melk_edari_tejari_neshiman_neshiman_edit = "", more_joziat_melk_edari_tejari_room_asli_room_asli_edit = "", more_joziat_melk_edari_tejari_nama_nama_edit = "", more_joziat_melk_edari_tejari_eskelet_eskelet_edit = "", more_joziat_melk_edari_tejari_divar_divar_edit = "", more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = "", more_joziat_melk_edari_tejari_sport_sport_edit = "", more_joziat_melk_edari_tejari_view_view_edit = "", more_joziat_melk_edari_tejari_tozih_about_melk = "", address_address_melk = "", more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = "", moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = "", more_joziat_melk_edari_tejari_kitchen_kitchen_radio = "", Fine_HoMe_checkBox_reBuildST = "", Fine_HoMe_checkBox_ghabel_liveST = "", moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = "", moshakhasat_asli_melk_number_room = "", moshakhasat_asli_melk_number_parking = "", Fine_HoMe_checkBox_moavezeST = "", Fine_HoMe_checkBox_pish_sellST = "", price_shrayet_sell_cheng_check_seel_cheng = "", Fine_HoMe_checkBox_vamST = "", Fine_HoMe_checkBox_sell_with_moshtariST = "", more_joziat_melk_edari_tejari_kitchen_darai_kabinet = "", more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchenST = "", Fine_HoMe_checkBox3ST = "", more_joziat_melk_edari_tejari_neshiman_neshiman_check = "", Fine_HoMe_checkBox4ST = "", Fine_HoMe_checkBox_neshiman_mobleST = "", more_joziat_melk_edari_tejari_nama_nama_check = "", Fine_HoMe_checkBox6ST = "", Fine_HoMe_checkBox7ST = "", Fine_HoMe_checkBox8ST = "", Fine_HoMe_checkBox9ST = "", Fine_HoMe_checkBox10ST = "", Fine_HoMe_checkBox11ST = "", Fine_HoMe_checkBox12ST = "", Fine_HoMe_checkBox13ST = "", more_joziat_melk_edari_tejari_eskelet_eskelet_check = "", Fine_HoMe_checkBox15ST = "", Fine_HoMe_checkBox14ST = "", Fine_HoMe_checkBox16ST = "", Fine_HoMe_checkBox17ST = "", Fine_HoMe_checkBox19ST = "", Fine_HoMe_checkBox20ST = "", Fine_HoMe_checkBox21ST = "", Fine_HoMe_checkBox22ST = "", Fine_HoMe_checkBox23ST = "", Fine_HoMe_checkBox24ST = "", Fine_HoMe_checkBox25ST = "", more_joziat_melk_edari_tejari_divar_divar_check = "", Fine_HoMe_checkBox26ST = "", Fine_HoMe_checkBox27ST = "", Fine_HoMe_checkBox28ST = "", Fine_HoMe_checkBox29ST = "", Fine_HoMe_checkBox30ST = "", Fine_HoMe_checkBox32ST = "", Fine_HoMe_checkBox331ST = "", Fine_HoMe_checkBox341ST = "", Fine_HoMe_checkBox351ST = "", Fine_HoMe_checkBox361ST = "", Fine_HoMe_checkBox371ST = "", Fine_HoMe_checkBox381ST = "", Fine_HoMe_checkBox39ST = "", Fine_HoMe_checkBox40ST = "", more_joziat_melk_edari_tejari_refahi_refahi_check = "", Fine_HoMe_checkBox33ST = "", Fine_HoMe_checkBox34ST = "", Fine_HoMe_checkBox35ST = "", Fine_HoMe_checkBox36ST = "", Fine_HoMe_checkBox37ST = "", Fine_HoMe_checkBox38ST = "", Fine_HoMe_checkBox41ST = "", Fine_HoMe_checkBox42ST = "", Fine_HoMe_checkBox43ST = "", Fine_HoMe_checkBox45ST = "", Fine_HoMe_checkBox46ST = "", Fine_HoMe_checkBox44ST = "", more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = "", Fine_HoMe_checkBox47ST = "", Fine_HoMe_checkBox48ST = "", Fine_HoMe_checkBox49ST = "", Fine_HoMe_checkBox50ST = "", Fine_HoMe_checkBox58ST = "", Fine_HoMe_checkBox51ST = "", Fine_HoMe_checkBox52ST = "", Fine_HoMe_checkBox53ST = "", Fine_HoMe_checkBox54ST = "", Fine_HoMe_checkBox55ST = "", Fine_HoMe_checkBox56ST = "", Fine_HoMe_checkBox57ST = "", Fine_HoMe_checkBox59ST = "", Fine_HoMe_checkBox60ST = "", Fine_HoMe_checkBox61ST = "", Fine_HoMe_checkBox62ST = "", Fine_HoMe_checkBox63ST = "", more_joziat_melk_edari_tejari_sport_sport_check = "", Fine_HoMe_checkBox64ST = "", Fine_HoMe_checkBox65ST = "", Fine_HoMe_checkBox66ST = "", Fine_HoMe_checkBox67ST = "", Fine_HoMe_checkBox68ST = "", Fine_HoMe_checkBox69ST = "", Fine_HoMe_checkBox70ST = "", more_joziat_melk_edari_tejari_view_view_check = "", Fine_HoMe_checkBox71ST = "", Fine_HoMe_checkBox72ST = "", Fine_HoMe_checkBox73ST = "", Fine_HoMe_checkBox74ST = "", Fine_HoMe_checkBox75ST = "", Fine_HoMe_checkBox76ST = "", Fine_HoMe_checkBox77ST = "", Fine_HoMe_checkBox78ST = "", more_joziat_melk_edari_tejari_nor_nor_check = "", Fine_HoMe_checkBox79ST = "", Fine_HoMe_checkBox80ST = "", Fine_HoMe_checkBox81ST = "", Fine_HoMe_checkBox82ST = "", Fine_HoMe_checkBox83ST = "", Fine_HoMe_checkBox84ST = "", Fine_HoMe_checkBox85ST = "", Fine_HoMe_checkBox86ST = "", price_shrayet_sell_cheng_mizan_anjam_shode = "", more_joziat_melk_edari_tejari_wc_bath = "", more_joziat_melk_edari_tejari_kitchen_badane_kabinet = "", more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = "", more_joziat_melk_edari_tejari_kitchen_roye_kabinet = "", more_joziat_melk_edari_tejari_kitchen_kitchen_check = "", more_joziat_melk_edari_tejari_tasisat_tasisat_check = "", more_joziat_melk_edari_tejari_safe_safe_check = "", Fine_HoMe_checkBox18ST = "", more_joziat_melk_edari_tejari_shekle_build_radio = "", Fine_HoMe_checkBox31ST = "", moshakhasat_asli_melk_moghiat_build = "", more_joziat_melk_edari_tejari_kitchen_ghazakhori = "", checkBox9ST = "", checkBox15ST = "", checkBox10ST = "", checkBox14ST = "", checkBox20ST = "", checkBox11ST = "", checkBox12ST = "", checkBox16ST = "", checkBox26ST = "", checkBox27ST = "", checkBox28ST = "", checkBox29ST = "", checkBox30ST = "", checkBox31ST = "", checkBox32ST = "", checkBox39ST = "", checkBox40ST = "", checkBox88ST = "", checkBox89ST = "", checkBox90ST = "", checkBox91ST = "", checkBox21ST = "", checkBox23ST = "", checkBox24ST = "", checkBox25ST = "", checkBox93ST = "", checkBox94ST = "", checkBox22ST = "", checkBox19ST = "", checkBox18ST = "", checkBox17ST = "", checkBox95ST = "", moshakhasat_asli_melk_karbari_now = "", more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin = "", moshakhasat_asli_melk_masahat_zamin_after_eslahie = "", moshakhasat_asli_melk_vaziita_build_vazita_zamin = "", more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin = "", more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta = "", more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check = "", moshakhasat_asli_melk_mosahat_kol_banai_build = "", moshakhasat_asli_melk_noe_bana_mostagh = "", more_joziat_melk_edari_tejari_refahi_refahi_check_mosta = "", more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta = "", more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta = "", more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit = "", more_joziat_melk_edari_tejari_room_asli_room_asli_check = "", noe_melk_moamele = "", noe_melk = "", moshakhasat_asli_melk_moghiita_store = "", moshakhasat_asli_melk_masahat_kaf = "", moshakhasat_asli_melk_masahat_balkon = "", moshakhasat_asli_melk_nuumber_dahane = "", moshakhasat_asli_melk_tol_bar_asli = "", moshakhasat_asli_melk_number_bar = "", moshakhasat_asli_melk_noe_vaghozari = "", more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh = "", more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh = "", more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe = "", more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze = "", more_joziat_melk_edari_tejari_wc_wc_irani = "", more_joziat_melk_edari_tejari_wc_wc_us = "", more_joziat_melk_edari_tejari_wc_roshoii = "", more_joziat_melk_edari_tejari_abdarhkane_tejari = "", more_joziat_melk_edari_tejari_fazai_asli_fazai_asli = "", more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari = "", more_joziat_melk_edari_tejari_kaf_kaf_check = "", more_joziat_melk_edari_tejari_kaf_kaf_edit = "", more_joziat_melk_edari_tejari_coldhot_coldhot_check = "", more_joziat_melk_edari_tejari_coldhot_coldhot_edit = "", more_joziat_melk_edari_tejari_refahi_refahi_check_tejari = "", more_joziat_melk_edari_tejari_refahi_refahi_edit = "", more_joziat_melk_edari_tejari_safe_safe_check_tejari = "", more_joziat_melk_edari_tejari_safe_safe_edit = "", more_joziat_melk_edari_tejari_dastresi_dastresi_check = "", more_joziat_melk_edari_tejari_dastresi_dastres_edit = "", more_joziat_melk_edari_tejari_ghozar_asli = "", more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari = "", more_joziat_melk_edari_tejari_tasisat_tasisat_edit = "", more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = "", more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = "", more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = "", more_joziat_melk_edari_tejari_kitchen_abdarkhane = "";

    String
            Vulue1 = "", Vulue2 = "", Vulue3 = "", Vulue4 = "", Vulue5 = "", Vulue6 = "", Vulue7 = "", Vulue8 = "", Vulue9 = "", Vulue10 = "", Vulue11 = "", Vulue12 = "", Vulue13 = "", Vulue14 = "", Vulue15 = "", Vulue16 = "", Vulue17 = "", Vulue18 = "", Vulue19 = "";

//////////////////////////////////////////////////////////////////////////////// EDITE PAGE

    int ID = 0; //ID a;

    Object _moshakhasat_asli_melk_karbari_now = ""; //_moshakhasat_asli_melk_karbari_now a;
    Object _moshakhasat_asli_melk_masahat_zamin_after_eslahie = ""; //_moshakhasat_asli_melk_masahat_zamin_after_eslahie a;
    Object _moshakhasat_asli_melk_vaziita_build_vazita_zamin = ""; //_moshakhasat_asli_melk_vaziita_build_vazita_zamin a;
    Object _more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin = ""; //_more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin a;
    Object _more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin = ""; //_more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin a;
    Object _moshakhasat_asli_melk_noe_bana_mostagh = ""; //_moshakhasat_asli_melk_noe_bana_mostagh");
    Object _moshakhasat_asli_melk_mosahat_kol_banai_build = ""; //_moshakhasat_asli_melk_mosahat_kol_banai_build");
    Object _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check = ""; //_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check");
    Object _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit = ""; //_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit");
    Object _more_joziat_melk_edari_tejari_refahi_refahi_check_mosta = ""; //_more_joziat_melk_edari_tejari_refahi_refahi_check_mosta");
    Object _more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta = ""; //_more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta");
    Object _moshakhasat_asli_melk_moghiita_store = ""; //_moshakhasat_asli_melk_moghiita_store");
    Object _moshakhasat_asli_melk_masahat_kaf = ""; //_moshakhasat_asli_melk_masahat_kaf");
    Object _moshakhasat_asli_melk_masahat_balkon = ""; //_moshakhasat_asli_melk_masahat_balkon");
    Object _moshakhasat_asli_melk_nuumber_dahane = ""; //_moshakhasat_asli_melk_nuumber_dahane");
    Object _moshakhasat_asli_melk_tol_bar_asli = ""; //_moshakhasat_asli_melk_tol_bar_asli");
    Object _moshakhasat_asli_melk_number_bar = ""; //_moshakhasat_asli_melk_number_bar");
    Object _moshakhasat_asli_melk_noe_vaghozari = ""; //_moshakhasat_asli_melk_noe_vaghozari");
    Object _more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh = ""; //_more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh");
    Object _more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh = ""; //_more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh");
    Object _more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe = ""; //_more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe");
    Object _more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze = ""; //_more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze");
    Object _more_joziat_melk_edari_tejari_wc_roshoii = ""; //_more_joziat_melk_edari_tejari_wc_roshoii");
    Object _more_joziat_melk_edari_tejari_abdarhkane_tejari = ""; //_more_joziat_melk_edari_tejari_abdarhkane_tejari");
    Object _more_joziat_melk_edari_tejari_fazai_asli_fazai_asli = ""; //_more_joziat_melk_edari_tejari_fazai_asli_fazai_asli");
    Object _more_joziat_melk_edari_tejari_refahi_refahi_check_tejari = ""; //_more_joziat_melk_edari_tejari_refahi_refahi_check_tejari");
    Object _more_joziat_melk_edari_tejari_safe_safe_check_tejari = ""; //_more_joziat_melk_edari_tejari_safe_safe_check_tejari");
    Object _more_joziat_melk_edari_tejari_dastresi_dastresi_check = ""; //_more_joziat_melk_edari_tejari_dastresi_dastresi_check");
    Object _more_joziat_melk_edari_tejari_dastresi_dastres_edit = ""; //_more_joziat_melk_edari_tejari_dastresi_dastres_edit");
    Object _more_joziat_melk_edari_tejari_ghozar_asli = ""; //_more_joziat_melk_edari_tejari_ghozar_asli");
    Object _more_joziat_melk_edari_tejari_refahi_refahi_check_edari = ""; // _more_joziat_melk_edari_tejari_refahi_refahi_check_edari");
    Object _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari = ""; // _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari");
    Object _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta = ""; // _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta");
    Object _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari = ""; // _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari");
    Object _moshakhasat_asli_melk_vaziita_build_rebuild = ""; // _moshakhasat_asli_melk_vaziita_build_rebuild");
    Object _moshakhasat_asli_melk_moghiat_build = ""; // _moshakhasat_asli_melk_moghiat_build");
    Object content = ""; //post_content");
    Object title = ""; //post_title");
    Object guid11 = ""; //guid11");
    Object _noe_melk_moamele = ""; //_noe_melk_moamele");
    Object _noe_melk = ""; //_noe_melk");
    Object _moshakhasat_asli_melk_noe_bana = ""; //_moshakhasat_asli_melk_noe_bana");
    Object _moshakhasat_asli_melk_masahat_build = ""; //_moshakhasat_asli_melk_masahat_build");
    Object _moshakhasat_asli_melk_masahat_zamin = ""; //_moshakhasat_asli_melk_masahat_zamin");
    Object _moshakhasat_asli_melk_number_room = ""; //_moshakhasat_asli_melk_number_room");
    Object _moshakhasat_asli_melk_number_parking = ""; //_moshakhasat_asli_melk_number_parking");
    Object _moshakhasat_asli_melk_sale_build = ""; //_moshakhasat_asli_melk_sale_build");
    Object _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = ""; //_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio");
    Object _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = ""; //_moshakhasat_asli_melk_vaziita_build_ghabel_sokonat");
    Object _price_shrayet_sell_cheng_check_seel_cheng = ""; //_price_shrayet_sell_cheng_check_seel_cheng");
    Object _price_shrayet_sell_cheng_max_money = ""; //_price_shrayet_sell_cheng_max_money");
    Object _price_shrayet_sell_cheng_money_pish_pay = ""; //_price_shrayet_sell_cheng_money_pish_pay");
    Object _price_shrayet_sell_cheng_time_tahvil = ""; //_price_shrayet_sell_cheng_time_tahvil");
    Object _price_shrayet_sell_cheng_mizan_anjam_shode = ""; //_price_shrayet_sell_cheng_mizan_anjam_shode");
    Object _price_shrayet_sell_cheng_mizan_vam = ""; //_price_shrayet_sell_cheng_mizan_vam");
    Object _price_shrayet_sell_cheng_sod_vam = ""; //_price_shrayet_sell_cheng_sod_vam");
    Object _price_shrayet_sell_cheng_number_ghest = ""; //_price_shrayet_sell_cheng_number_ghest");
    Object _price_shrayet_sell_cheng_price_har_ghest = ""; //_price_shrayet_sell_cheng_price_har_ghest");
    Object _price_shrayet_sell_cheng_price_rahn = ""; //_price_shrayet_sell_cheng_price_rahn");
    Object _price_shrayet_rent_price_vadie = ""; //_price_shrayet_rent_price_vadie");
    Object _price_shrayet_rent_price_ajare_mohiane = ""; //_price_shrayet_rent_price_ajare_mohiane");
    Object _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = ""; //_more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe");
    Object _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = ""; //_more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe");
    Object _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = ""; //_more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe");
    Object _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = ""; //_more_joziat_melk_edari_tejari_moghit_build_number_all_vahed");
    Object _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = ""; //_more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build");
    Object _more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari = ""; //_more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari");
    Object _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari = ""; //_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari");
    Object _more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon = ""; //_more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon");
    Object _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon = ""; //_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon");
    Object _more_joziat_melk_edari_tejari_wc_wc_irani = ""; //_more_joziat_melk_edari_tejari_wc_wc_irani");
    Object _more_joziat_melk_edari_tejari_wc_wc_us = ""; //_more_joziat_melk_edari_tejari_wc_wc_us");
    Object _more_joziat_melk_edari_tejari_wc_bath = ""; //_more_joziat_melk_edari_tejari_wc_bath");
    Object _more_joziat_melk_edari_tejari_kitchen_kitchen_check = ""; //_more_joziat_melk_edari_tejari_kitchen_kitchen_check");
    Object _more_joziat_melk_edari_tejari_kitchen_kitchen_radio = ""; //_more_joziat_melk_edari_tejari_kitchen_kitchen_radio");
    Object _more_joziat_melk_edari_tejari_kitchen_darai_kabinet = ""; //_more_joziat_melk_edari_tejari_kitchen_darai_kabinet");
    Object _more_joziat_melk_edari_tejari_kitchen_badane_kabinet = ""; //_more_joziat_melk_edari_tejari_kitchen_badane_kabinet");
    Object _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = ""; //_more_joziat_melk_edari_tejari_kitchen_safhe_kabinet");
    Object _more_joziat_melk_edari_tejari_kitchen_roye_kabinet = ""; //_more_joziat_melk_edari_tejari_kitchen_roye_kabinet");
    Object _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen = ""; //_more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen");
    Object _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen = ""; //_more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen");
    Object _more_joziat_melk_edari_tejari_neshiman_neshiman_check = ""; //_more_joziat_melk_edari_tejari_neshiman_neshiman_check");
    Object _more_joziat_melk_edari_tejari_neshiman_neshiman_edit = ""; //_more_joziat_melk_edari_tejari_neshiman_neshiman_edit");
    Object _more_joziat_melk_edari_tejari_shekle_build_radio = ""; //_more_joziat_melk_edari_tejari_shekle_build_radio");
    Object _more_joziat_melk_edari_tejari_nama_nama_check = ""; //_more_joziat_melk_edari_tejari_nama_nama_check");
    Object _more_joziat_melk_edari_tejari_nama_nama_edit = ""; //_more_joziat_melk_edari_tejari_nama_nama_edit");
    Object _more_joziat_melk_edari_tejari_eskelet_eskelet_check = ""; //_more_joziat_melk_edari_tejari_eskelet_eskelet_check");
    Object _more_joziat_melk_edari_tejari_eskelet_eskelet_edit = ""; //_more_joziat_melk_edari_tejari_eskelet_eskelet_edit");
    Object _more_joziat_melk_edari_tejari_kaf_kaf_check = ""; //_more_joziat_melk_edari_tejari_kaf_kaf_check");
    Object _more_joziat_melk_edari_tejari_kaf_kaf_edit = ""; //_more_joziat_melk_edari_tejari_kaf_kaf_edit");
    Object _more_joziat_melk_edari_tejari_divar_divar_check = ""; //_more_joziat_melk_edari_tejari_divar_divar_check");
    Object _more_joziat_melk_edari_tejari_divar_divar_edit = ""; //_more_joziat_melk_edari_tejari_divar_divar_edit");
    Object _more_joziat_melk_edari_tejari_coldhot_coldhot_check = ""; //_more_joziat_melk_edari_tejari_coldhot_coldhot_check");
    Object _more_joziat_melk_edari_tejari_coldhot_coldhot_edit = ""; //_more_joziat_melk_edari_tejari_coldhot_coldhot_edit");
    Object _more_joziat_melk_edari_tejari_refahi_refahi_check = ""; //_more_joziat_melk_edari_tejari_refahi_refahi_check");
    Object _more_joziat_melk_edari_tejari_refahi_refahi_edit = ""; //_more_joziat_melk_edari_tejari_refahi_refahi_edit");
    Object _more_joziat_melk_edari_tejari_safe_safe_check = ""; //_more_joziat_melk_edari_tejari_safe_safe_check");
    Object _more_joziat_melk_edari_tejari_safe_safe_edit = ""; //_more_joziat_melk_edari_tejari_safe_safe_edit");
    Object _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = ""; //_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta");
    Object _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = ""; //_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit");
    Object _more_joziat_melk_edari_tejari_sport_sport_check = ""; //_more_joziat_melk_edari_tejari_sport_sport_check");
    Object _more_joziat_melk_edari_tejari_sport_sport_edit = ""; //_more_joziat_melk_edari_tejari_sport_sport_edit");
    Object _more_joziat_melk_edari_tejari_view_view_check = ""; //_more_joziat_melk_edari_tejari_view_view_check");
    Object _more_joziat_melk_edari_tejari_view_view_edit = ""; //_more_joziat_melk_edari_tejari_view_view_edit");
    Object _more_joziat_melk_edari_tejari_nor_nor_check = ""; //_more_joziat_melk_edari_tejari_nor_nor_check");
    Object _more_joziat_melk_edari_tejari_tasisat_tasisat_check = ""; //_more_joziat_melk_edari_tejari_tasisat_tasisat_check");
    Object _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = ""; //_more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
    Object _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = ""; //_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
    Object _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = ""; //_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
    Object _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = ""; //_more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");
    Object _more_joziat_melk_edari_tejari_safe = ""; //_more_joziat_melk_edari_tejari_safe");
    Object _more_joziat_melk_edari_tejari_emkanatBuild = ""; //_more_joziat_melk_edari_tejari_emkanatBuild");
    Object _more_joziat_melk_edari_tejari_divar = ""; //_more_joziat_melk_edari_tejari_divar");
    Object _more_joziat_melk_edari_tejari_kaf = ""; //_more_joziat_melk_edari_tejari_kaf");
    Object _more_joziat_melk_edari_tejari_shekle_build_check = ""; //_more_joziat_melk_edari_tejari_shekle_build_check");
    Object _more_joziat_melk_edari_tejari_moghit_build = ""; //_more_joziat_melk_edari_tejari_moghit_build");
    Object _price_shrayet = ""; //_price_shrayet");
    Object _price_shrayet_sell_cheng_price_all_sell_cheng = ""; //_price_shrayet_sell_cheng_price_all_sell_cheng");
    Object _more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta = ""; //_more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta");
    Object _more_joziat_melk_edari_tejari_kitchen_ghazakhori = ""; //_more_joziat_melk_edari_tejari_kitchen_ghazakhori");
    Object _more_joziat_melk_edari_tejari_kitchen_abdarkhane = ""; //_more_joziat_melk_edari_tejari_kitchen_abdarkhane");
    Object _more_joziat_melk_edari_tejari_room_asli_room_asli_check = ""; //_more_joziat_melk_edari_tejari_room_asli_room_asli_check");
    Object _more_joziat_melk_edari_tejari_room_asli_room_asli_edit = ""; //_more_joziat_melk_edari_tejari_room_asli_room_asli_edit");
    Object _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari = ""; //_more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari");


    RadioButton
            radioButton_FindHome, radioButton2_FindHome, radioButton3_FindHome, radioButton4_FindHome;

    public static String dataServer = "";
    JSONObject jsonObject = null;

    EditText editText, barchasbEdit;

    ////////////////////////////////////////////////////////////////////////////////////// Pic
    int maxBufferSize = 1 * 645 * 645;
    int serverResponseCode = 0;
    ProgressDialog dialog = null, dialog2 = null, dialog3 = null, dialog4 = null, dialog5 = null, dialog6 = null, dialog7 = null, dialog8 = null, dialog9 = null, dialog10 = null;
    DataOutputStream dos = null;
    HttpURLConnection conn = null;
    String upLoadServerUri = "http://padintarh.ir/Android/uploadImage.php";
    static int witchPic = 0;
    Bitmap thumbnail123123;

    Button
            takePic_finhome_1, takePic_finhome_2, takePic_finhome_3, takePic_finhome_4, takePic_finhome_5, takePic_finhome_6, takePic_finhome_7, takePic_finhome_8, takePic_finhome_9, takePic_finhome_10;

    ImageView
            imgTakePic_1, imgTakePic_2, imgTakePic_3, imgTakePic_4, imgTakePic_5, imgTakePic_6, imgTakePic_7, imgTakePic_8, imgTakePic_9, imgTakePic_10;

    String
            str_1tp, str_2tp, str_3tp, str_4tp, str_5tp, str_6tp, str_7tp, str_8tp, str_9tp, str_10tp;


    int
            imgTakePic_1Width, imgTakePic_2Width, imgTakePic_3Width, imgTakePic_4Width, imgTakePic_5Width, imgTakePic_6Width, imgTakePic_7Width, imgTakePic_8Width, imgTakePic_9Width, imgTakePic_10Width;

    int
            imgTakePic_1Height, imgTakePic_2Height, imgTakePic_3Height, imgTakePic_4Height, imgTakePic_5Height, imgTakePic_6Height, imgTakePic_7Height, imgTakePic_8Height, imgTakePic_9Height, imgTakePic_10Height;

    String
            stIDimage_1, stIDimage_2, stIDimage_3, stIDimage_4, stIDimage_5, stIDimage_6, stIDimage_7, stIDimage_8, stIDimage_9, stIDimage_10;

    String
            finalstIDimage_1, finalstIDimage_2, finalstIDimage_3, finalstIDimage_4, finalstIDimage_5, finalstIDimage_6, finalstIDimage_7, finalstIDimage_8, finalstIDimage_9, finalstIDimage_10;

    static String
            str_1tp_150x150, str_2tp_150x150, str_3tp_150x150, str_4tp_150x150, str_5tp_150x150, str_6tp_150x150, str_7tp_150x150, str_8tp_150x150, str_9tp_150x150, str_10tp_150x150;

    static String
            stIDimage_1_150x150, stIDimage_2_150x150, stIDimage_3_150x150, stIDimage_4_150x150, stIDimage_5_150x150, stIDimage_6_150x150, stIDimage_7_150x150, stIDimage_8_150x150, stIDimage_9_150x150, stIDimage_10_150x150;

    static String
            stIDimage_1_300x300, stIDimage_2_300x300, stIDimage_3_300x300, stIDimage_4_300x300, stIDimage_5_300x300, stIDimage_6_300x300, stIDimage_7_300x300, stIDimage_8_300x300, stIDimage_9_300x300, stIDimage_10_300x300;

    static String
            str_1tp_300x300, str_2tp_300x300, str_3tp_300x300, str_4tp_300x300, str_5tp_300x300, str_6tp_300x300, str_7tp_300x300, str_8tp_300x300, str_9tp_300x300, str_10tp_300x300;

    String
            imagesNotNull_1 = "", imagesNotNull_2 = "", imagesNotNull_3 = "", imagesNotNull_4 = "", imagesNotNull_5 = "", imagesNotNull_6 = "", imagesNotNull_7 = "", imagesNotNull_8 = "", imagesNotNull_9 = "", imagesNotNull_10 = "";


    String STdateYM;
    boolean waitForupload = false;
    int counterImages = 0, counterDailog = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main26);


//---------------------------------------------------------------------teke pic
        takePic_finhome_1 = (Button) findViewById(R.id.takePic_finhome_1);
        takePic_finhome_2 = (Button) findViewById(R.id.takePic_finhome_2);
        takePic_finhome_3 = (Button) findViewById(R.id.takePic_finhome_3);
        takePic_finhome_4 = (Button) findViewById(R.id.takePic_finhome_4);
        takePic_finhome_5 = (Button) findViewById(R.id.takePic_finhome_5);
        takePic_finhome_6 = (Button) findViewById(R.id.takePic_finhome_6);
        takePic_finhome_7 = (Button) findViewById(R.id.takePic_finhome_7);
        takePic_finhome_8 = (Button) findViewById(R.id.takePic_finhome_8);
        takePic_finhome_9 = (Button) findViewById(R.id.takePic_finhome_9);
        takePic_finhome_10 = (Button) findViewById(R.id.takePic_finhome_10);

        imgTakePic_1 = (ImageView) findViewById(R.id.imgTakePic_1);
        imgTakePic_2 = (ImageView) findViewById(R.id.imgTakePic_2);
        imgTakePic_3 = (ImageView) findViewById(R.id.imgTakePic_3);
        imgTakePic_4 = (ImageView) findViewById(R.id.imgTakePic_4);
        imgTakePic_5 = (ImageView) findViewById(R.id.imgTakePic_5);
        imgTakePic_6 = (ImageView) findViewById(R.id.imgTakePic_6);
        imgTakePic_7 = (ImageView) findViewById(R.id.imgTakePic_7);
        imgTakePic_8 = (ImageView) findViewById(R.id.imgTakePic_8);
        imgTakePic_9 = (ImageView) findViewById(R.id.imgTakePic_9);
        imgTakePic_10 = (ImageView) findViewById(R.id.imgTakePic_10);
//---------------------------------------------------------------------En teke pic

        button123123 = (Button) findViewById(R.id.button123123);

        txtView = (TextView) findViewById(R.id.txtView);
        txtView_noe_bana = (TextView) findViewById(R.id.txtView_noe_bana);
        txtView_masahat = (TextView) findViewById(R.id.txtView_masahat);
        txtView_1 = (TextView) findViewById(R.id.txtView_1);
        txtView_2 = (TextView) findViewById(R.id.txtView_2);
        txtView_3 = (TextView) findViewById(R.id.txtView_3);
        txtView_4 = (TextView) findViewById(R.id.txtView_4);
        txtView_5 = (TextView) findViewById(R.id.txtView_5);
        txtView_6 = (TextView) findViewById(R.id.txtView_6);
        txtView_7 = (TextView) findViewById(R.id.txtView_7);
        txtView_8 = (TextView) findViewById(R.id.txtView_8);
        txtView_9 = (TextView) findViewById(R.id.txtView_9);
        txtView_10 = (TextView) findViewById(R.id.txtView_10);
        txtView_11 = (TextView) findViewById(R.id.txtView_11);
        txtView_12 = (TextView) findViewById(R.id.txtView_12);
        txtView_13 = (TextView) findViewById(R.id.txtView_13);
        txtView_14 = (TextView) findViewById(R.id.txtView_14);
        txtView_15 = (TextView) findViewById(R.id.txtView_15);
        txtView_16 = (TextView) findViewById(R.id.txtView_16);
        txtView_17 = (TextView) findViewById(R.id.txtView_17);

        radioButton_FindHome = (RadioButton) findViewById(R.id.radioButton_FindHome);
        radioButton2_FindHome = (RadioButton) findViewById(R.id.radioButton2_FindHome);
        radioButton3_FindHome = (RadioButton) findViewById(R.id.radioButton3_FindHome);
        radioButton4_FindHome = (RadioButton) findViewById(R.id.radioButton4_FindHome);

        RadioGP = (RadioGroup) findViewById(R.id.RadioGP);
        RadioGP2 = (RadioGroup) findViewById(R.id.RadioGP2);
        RadioGP3 = (RadioGroup) findViewById(R.id.RadioGP3);
//----------------------------------------------------------------------------Set arrayAdapter
        arrayAdapter_default = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_default);
        arrayAdapter_deal = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_deal);
        arrayAdapter_W_ground = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_melk_W_ground);
        arrayAdapter_WO_ground = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_melk_WO_ground);
        arrayAdapter_noe_bana = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_noe_bana);
        arrayAdapter_number = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_number);
        arrayAdapter_pish_sell_mizan = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_pish_sell_mizan);
        arrayAdapter_wc = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_num_WC);
        arrayAdapter__ketchen_kabinet = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_ketchen_kabinet);
        arrayAdapter_ketchen_kabinet_roye = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_ketchen_kabinet_roye);
        arrayAdapter_phone = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_phone);
        arrayAdapter_dong = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_dong);
        arrayAdapter_noe_malekati = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_noe_malekati);
        arrayAdapter_mogheitat_build = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_mogheitat_build);
        arrayAdapter_dahane = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_dahane);
        arrayAdapter_nabsh = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_nabsh);
        arrayAdapter_zamin = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_zamin);
        arrayAdapter_tejari_moghiat = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_tejari_moghiat);
        arrayAdapter_mostaghelat = new ArrayAdapter(Main26Activity.this, android.R.layout.simple_spinner_item, String_mostaghelat);

//----------------------------------------------------------------------------Set arrayAdapter to spinner
        arrayAdapter_default.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_deal.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_W_ground.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_WO_ground.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_noe_bana.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_number.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_pish_sell_mizan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_wc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter__ketchen_kabinet.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_ketchen_kabinet_roye.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_phone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_dong.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_noe_malekati.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_mogheitat_build.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_nabsh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_zamin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_tejari_moghiat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_dahane.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter_mostaghelat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//----------------------------------------------------------------------------RadioButton
        radioButton_NewSAZ = (RadioButton) findViewById(R.id.radioButton_NewSAZ);
        radioButton_OldSAz = (RadioButton) findViewById(R.id.radioButton_OldSAz);
        radioButton_OLD = (RadioButton) findViewById(R.id.radioButton_OLD);
        radioButton5 = (RadioButton) findViewById(R.id.radioButton5);
        radioButton6 = (RadioButton) findViewById(R.id.radioButton6);
        radioButton7 = (RadioButton) findViewById(R.id.radioButton7);


//----------------------------------------------------------------------------CheckBox
        checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
        checkBox8 = (CheckBox) findViewById(R.id.checkBox8);
        checkBox9 = (CheckBox) findViewById(R.id.checkBox9);
        checkBox10 = (CheckBox) findViewById(R.id.checkBox10);
        checkBox11 = (CheckBox) findViewById(R.id.checkBox11);
        checkBox12 = (CheckBox) findViewById(R.id.checkBox12);
        checkBox13 = (CheckBox) findViewById(R.id.checkBox13);
        checkBox14 = (CheckBox) findViewById(R.id.checkBox14);
        checkBox15 = (CheckBox) findViewById(R.id.checkBox15);
        checkBox16 = (CheckBox) findViewById(R.id.checkBox16);
        checkBox17 = (CheckBox) findViewById(R.id.checkBox17);
        checkBox18 = (CheckBox) findViewById(R.id.checkBox18);
        checkBox19 = (CheckBox) findViewById(R.id.checkBox19);
        checkBox20 = (CheckBox) findViewById(R.id.checkBox20);
        checkBox21 = (CheckBox) findViewById(R.id.checkBox21);
        checkBox22 = (CheckBox) findViewById(R.id.checkBox22);
        checkBox23 = (CheckBox) findViewById(R.id.checkBox23);
        checkBox24 = (CheckBox) findViewById(R.id.checkBox24);
        checkBox25 = (CheckBox) findViewById(R.id.checkBox25);
        checkBox26 = (CheckBox) findViewById(R.id.checkBox26);
        checkBox27 = (CheckBox) findViewById(R.id.checkBox27);
        checkBox28 = (CheckBox) findViewById(R.id.checkBox28);
        checkBox29 = (CheckBox) findViewById(R.id.checkBox29);
        checkBox30 = (CheckBox) findViewById(R.id.checkBox30);
        checkBox31 = (CheckBox) findViewById(R.id.checkBox31);
        checkBox32 = (CheckBox) findViewById(R.id.checkBox31);
        checkBox33 = (CheckBox) findViewById(R.id.checkBox33);
        checkBox39 = (CheckBox) findViewById(R.id.checkBox39);
        checkBox40 = (CheckBox) findViewById(R.id.checkBox40);
        checkBox88 = (CheckBox) findViewById(R.id.checkBox88);
        checkBox89 = (CheckBox) findViewById(R.id.checkBox89);
        checkBox90 = (CheckBox) findViewById(R.id.checkBox90);
        checkBox91 = (CheckBox) findViewById(R.id.checkBox91);
        checkBox92 = (CheckBox) findViewById(R.id.checkBox92);
        checkBox93 = (CheckBox) findViewById(R.id.checkBox93);
        checkBox94 = (CheckBox) findViewById(R.id.checkBox94);
        checkBox95 = (CheckBox) findViewById(R.id.checkBox95);
        Fine_HoMe_checkBox_reBuild = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox_reBuild);
        Fine_HoMe_checkBox_ghabel_live = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox_ghabel_live);
        Fine_HoMe_checkBox_moaveze = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox_moaveze);
        Fine_HoMe_checkBox_pish_sell = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox_pish_sell);
        Fine_HoMe_checkBox_vam = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox_vam);
        Fine_HoMe_checkBox_sell_with_moshtari = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox_sell_with_moshtari);
        Fine_HoMe_checkBox_have_kabinet = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox_have_kabinet);
        Fine_HoMe_checkBox_have_tajhizat_kitchen = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox_have_tajhizat_kitchen);
        Fine_HoMe_checkBox_neshiman_moble = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox_neshiman_moble);
        Fine_HoMe_checkBox123 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox123);
        Fine_HoMe_checkBox2 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox2);
        Fine_HoMe_checkBox3 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox3);
        Fine_HoMe_checkBox4 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox4);
        Fine_HoMe_checkBox5 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox5);
        Fine_HoMe_checkBox6 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox6);
        Fine_HoMe_checkBox7 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox7);
        Fine_HoMe_checkBox8 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox8);
        Fine_HoMe_checkBox9 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox9);
        Fine_HoMe_checkBox10 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox10);
        Fine_HoMe_checkBox11 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox11);
        Fine_HoMe_checkBox12 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox12);
        Fine_HoMe_checkBox13 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox13);
        Fine_HoMe_checkBox14 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox14);
        Fine_HoMe_checkBox15 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox15);
        Fine_HoMe_checkBox16 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox16);
        Fine_HoMe_checkBox17 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox17);
        Fine_HoMe_checkBox18 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox18);
        Fine_HoMe_checkBox19 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox19);
        Fine_HoMe_checkBox20 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox20);
        Fine_HoMe_checkBox21 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox21);
        Fine_HoMe_checkBox22 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox22);
        Fine_HoMe_checkBox23 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox23);
        Fine_HoMe_checkBox24 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox24);
        Fine_HoMe_checkBox25 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox25);
        Fine_HoMe_checkBox26 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox26);
        Fine_HoMe_checkBox27 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox27);
        Fine_HoMe_checkBox28 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox28);
        Fine_HoMe_checkBox29 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox29);
        Fine_HoMe_checkBox30 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox30);
        Fine_HoMe_checkBox31 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox31);
        Fine_HoMe_checkBox32 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox32);
        Fine_HoMe_checkBox331 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox331);
        Fine_HoMe_checkBox341 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox341);
        Fine_HoMe_checkBox351 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox351);
        Fine_HoMe_checkBox361 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox361);
        Fine_HoMe_checkBox371 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox371);
        Fine_HoMe_checkBox381 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox381);
        Fine_HoMe_checkBox39 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox39);
        Fine_HoMe_checkBox33 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox33);
        Fine_HoMe_checkBox34 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox34);
        Fine_HoMe_checkBox35 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox35);
        Fine_HoMe_checkBox36 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox36);
        Fine_HoMe_checkBox37 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox37);
        Fine_HoMe_checkBox38 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox38);
        Fine_HoMe_checkBox40 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox40);
        Fine_HoMe_checkBox41 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox41);
        Fine_HoMe_checkBox42 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox42);
        Fine_HoMe_checkBox43 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox43);
        Fine_HoMe_checkBox44 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox44);
        Fine_HoMe_checkBox45 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox45);
        Fine_HoMe_checkBox46 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox46);
        Fine_HoMe_checkBox47 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox47);
        Fine_HoMe_checkBox48 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox48);
        Fine_HoMe_checkBox49 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox49);
        Fine_HoMe_checkBox50 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox50);
        Fine_HoMe_checkBox51 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox51);
        Fine_HoMe_checkBox52 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox52);
        Fine_HoMe_checkBox53 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox53);
        Fine_HoMe_checkBox54 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox54);
        Fine_HoMe_checkBox55 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox55);
        Fine_HoMe_checkBox56 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox56);
        Fine_HoMe_checkBox57 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox57);
        Fine_HoMe_checkBox58 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox58);
        Fine_HoMe_checkBox59 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox59);
        Fine_HoMe_checkBox60 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox60);
        Fine_HoMe_checkBox61 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox61);
        Fine_HoMe_checkBox62 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox62);
        Fine_HoMe_checkBox63 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox63);
        Fine_HoMe_checkBox64 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox64);
        Fine_HoMe_checkBox65 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox65);
        Fine_HoMe_checkBox66 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox66);
        Fine_HoMe_checkBox67 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox67);
        Fine_HoMe_checkBox68 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox68);
        Fine_HoMe_checkBox69 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox69);
        Fine_HoMe_checkBox70 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox70);
        Fine_HoMe_checkBox71 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox71);
        Fine_HoMe_checkBox72 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox72);
        Fine_HoMe_checkBox73 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox73);
        Fine_HoMe_checkBox74 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox74);
        Fine_HoMe_checkBox75 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox75);
        Fine_HoMe_checkBox76 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox76);
        Fine_HoMe_checkBox77 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox77);
        Fine_HoMe_checkBox78 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox78);
        Fine_HoMe_checkBox79 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox79);
        Fine_HoMe_checkBox80 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox80);
        Fine_HoMe_checkBox81 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox81);
        Fine_HoMe_checkBox82 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox82);
        Fine_HoMe_checkBox83 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox83);
        Fine_HoMe_checkBox84 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox84);
        Fine_HoMe_checkBox85 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox85);
        Fine_HoMe_checkBox86 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox86);
        Fine_HoMe_checkBox87 = (CheckBox) findViewById(R.id.Fine_HoMe_checkBox87);


//----------------------------------------------------------------------------LinearLayout
        liner_moaveze = (LinearLayout) findViewById(R.id.liner_moaveze);
        linear_pish_sell = (LinearLayout) findViewById(R.id.linear_pish_sell);
        linear_vam = (LinearLayout) findViewById(R.id.linear_vam);
        linear_sell_with_moshtari = (LinearLayout) findViewById(R.id.linear_sell_with_moshtari);
        liner_have_kabinet = (LinearLayout) findViewById(R.id.liner_have_kabinet);
        liner_have_tajhizat_kitchen = (LinearLayout) findViewById(R.id.liner_have_tajhizat_kitchen);
        linear_neshiman_mile = (LinearLayout) findViewById(R.id.linear_neshiman_mile);
        liner_mogheitat_build = (LinearLayout) findViewById(R.id.liner_mogheitat_build);
        liner_bath = (LinearLayout) findViewById(R.id.liner_bath);
        linear_sport = (LinearLayout) findViewById(R.id.linear_sport);
        liner_1 = (LinearLayout) findViewById(R.id.liner_1);
        Liner_3 = (LinearLayout) findViewById(R.id.Liner_3);
        liner_emkanat = (LinearLayout) findViewById(R.id.liner_emkanat);
        linear_kitchen = (LinearLayout) findViewById(R.id.linear_kitchen);
        linear_2 = (LinearLayout) findViewById(R.id.linear_2);
        linear_shekl_building = (LinearLayout) findViewById(R.id.linear_shekl_building);
        linear_eskelet_building = (LinearLayout) findViewById(R.id.linear_eskelet_building);
        linear_wall = (LinearLayout) findViewById(R.id.linear_wall);
        liner_ghozar = (LinearLayout) findViewById(R.id.liner_ghozar);
        linear_view = (LinearLayout) findViewById(R.id.linear_view);
        linear_NEWS = (LinearLayout) findViewById(R.id.linear_NEWS);
        liner_4 = (LinearLayout) findViewById(R.id.liner_4);
        liner_5 = (LinearLayout) findViewById(R.id.liner_5);
        liner_6 = (LinearLayout) findViewById(R.id.liner_6);
        liner_moghiat = (LinearLayout) findViewById(R.id.liner_moghiat);
        liner_WC = (LinearLayout) findViewById(R.id.liner_WC);
        linear_neshiman = (LinearLayout) findViewById(R.id.linear_neshiman);
        linear_cold_hot = (LinearLayout) findViewById(R.id.linear_cold_hot);
        linear_refaii = (LinearLayout) findViewById(R.id.linear_refaii);
        linear_safe = (LinearLayout) findViewById(R.id.linear_safe);
        linear_emkanat = (LinearLayout) findViewById(R.id.linear_emkanat);
        liner_phone2 = (LinearLayout) findViewById(R.id.liner_phone2);
        linear_karbari = (LinearLayout) findViewById(R.id.linear_karbari);
        linear_kaf = (LinearLayout) findViewById(R.id.linear_kaf);
        linear_dastresi = (LinearLayout) findViewById(R.id.linear_dastresi);
        linear_nma = (LinearLayout) findViewById(R.id.linear_nma);
        number_3 = (LinearLayout) findViewById(R.id.number_3);
        number_3_rahn = (LinearLayout) findViewById(R.id.number_3_rahn);
//----------------------------------------------------------------------------EditText
        editText14 = (EditText) findViewById(R.id.editText14);
        editText_rahnVadie = (EditText) findViewById(R.id.editText_rahnVadie);
        editText_rahnEjare = (EditText) findViewById(R.id.editText_rahnEjare);
        editText22 = (EditText) findViewById(R.id.editText22);
        editText13 = (EditText) findViewById(R.id.editText13);
        editText_onvan = (EditText) findViewById(R.id.editText_onvan);
        editTex_matn = (EditText) findViewById(R.id.editTex_matn);
        Find_HoMe_editText_masahat_made = (EditText) findViewById(R.id.Find_HoMe_editText_masahat_made);
        Find_HoMe_editText_masahat_ground = (EditText) findViewById(R.id.Find_HoMe_editText_masahat_ground);
        Find_HoMe_editText_year_made = (EditText) findViewById(R.id.Find_HoMe_editText_year_made);
        Find_HoMe_editText_price_deal = (EditText) findViewById(R.id.Find_HoMe_editText_price_deal);
        Find_HoMe_editText_moaveze = (EditText) findViewById(R.id.Find_HoMe_editText_moaveze);
        Find_HoMe_editText_pish_sell_price = (EditText) findViewById(R.id.Find_HoMe_editText_pish_sell_price);
        Find_HoMe_editText_pish_sell_time = (EditText) findViewById(R.id.Find_HoMe_editText_pish_sell_time);
        Find_HoMe_editText_vam_mizan = (EditText) findViewById(R.id.Find_HoMe_editText_vam_mizan);
        Find_HoMe_editText_vam_sod = (EditText) findViewById(R.id.Find_HoMe_editText_vam_sod);
        Find_HoMe_editText_vam_num_ghest = (EditText) findViewById(R.id.Find_HoMe_editText_vam_num_ghest);
        Find_HoMe_editText_vam_num_ghest2 = (EditText) findViewById(R.id.Find_HoMe_editText_vam_num_ghest2);
        Find_HoMe_editText_sell_with_moshtari = (EditText) findViewById(R.id.Find_HoMe_editText_sell_with_moshtari);
        Find_HoMe_editText = (EditText) findViewById(R.id.Find_HoMe_editText);
        Find_HoMe_editText2 = (EditText) findViewById(R.id.Find_HoMe_editText2);
        Find_HoMe_editText3 = (EditText) findViewById(R.id.Find_HoMe_editText3);
        Find_HoMe_editText4 = (EditText) findViewById(R.id.Find_HoMe_editText4);
        Find_HoMe_editText5 = (EditText) findViewById(R.id.Find_HoMe_editText5);
        Find_HoMe_editText6 = (EditText) findViewById(R.id.Find_HoMe_editText6);
        Find_HoMe_editText7 = (EditText) findViewById(R.id.Find_HoMe_editText7);
        Find_HoMe_editText8 = (EditText) findViewById(R.id.Find_HoMe_editText8);
        Find_HoMe_editText9 = (EditText) findViewById(R.id.Find_HoMe_editText9);
        Find_HoMe_editText10 = (EditText) findViewById(R.id.Find_HoMe_editText10);
        Find_HoMe_editText11 = (EditText) findViewById(R.id.Find_HoMe_editText11);
        Find_HoMe_editText12 = (EditText) findViewById(R.id.Find_HoMe_editText12);
        Find_HoMe_editText13 = (EditText) findViewById(R.id.Find_HoMe_editText13);
        Find_HoMe_editText14 = (EditText) findViewById(R.id.Find_HoMe_editText14);
        Find_HoMe_editText151 = (EditText) findViewById(R.id.Find_HoMe_editText151);
        Find_HoMe_editText15 = (EditText) findViewById(R.id.Find_HoMe_editText15);
        Find_HoMe_editText16 = (EditText) findViewById(R.id.Find_HoMe_editText16);
        Find_HoMe_editText17 = (EditText) findViewById(R.id.Find_HoMe_editText17);
        Find_HoMe_editText18 = (EditText) findViewById(R.id.Find_HoMe_editText18);
        Find_HoMe_editText19 = (EditText) findViewById(R.id.Find_HoMe_editText19);
        Find_HoMe_editText20 = (EditText) findViewById(R.id.Find_HoMe_editText20);
        Find_HoMe_editText21 = (EditText) findViewById(R.id.Find_HoMe_editText21);

//----------------------------------------------------------------------------Spinner
        spinner_noe_dael = (Spinner) findViewById(R.id.spinner_noe_dael);
        spinner_noe_melk = (Spinner) findViewById(R.id.spinner_noe_melk);
        spinner_noe_bana = (Spinner) findViewById(R.id.spinner_noe_bana);
        spinner_num_room = (Spinner) findViewById(R.id.spinner_num_room);
        spinner_num_parking = (Spinner) findViewById(R.id.spinner_num_parking);
        spiner_pish_sell_mizan = (Spinner) findViewById(R.id.spiner_pish_sell_mizan);
        spinner_wc_IR = (Spinner) findViewById(R.id.spinner_wc_IR);
        spinner_wc_EN = (Spinner) findViewById(R.id.spinner_wc_EN);
        spinner_wc_bath = (Spinner) findViewById(R.id.spinner_wc_bath);
        spinner_have_kabinet_badane = (Spinner) findViewById(R.id.spinner_have_kabinet_badane);
        spinner_have_kabinet_roye = (Spinner) findViewById(R.id.spinner_have_kabinet_roye);
        spinner_have_kabinet_safhe = (Spinner) findViewById(R.id.spinner_have_kabinet_safhe);
        spinner_phone = (Spinner) findViewById(R.id.spinner_phone);
        spinner_dong = (Spinner) findViewById(R.id.spinner_dong);
        spinner_noe_malekati = (Spinner) findViewById(R.id.spinner_noe_malekati);
        spinner7 = (Spinner) findViewById(R.id.spinner7);

//----------------------------------------------------------------------------Set spinner to arrayAdapter
        spinner_noe_dael.setAdapter(arrayAdapter_deal);
        //   spinner_noe_melk.setAdapter(arrayAdapter_default);
        spinner_num_parking.setAdapter(arrayAdapter_number);
        spinner_wc_IR.setAdapter(arrayAdapter_wc);
        spinner_wc_EN.setAdapter(arrayAdapter_wc);
        spinner_wc_bath.setAdapter(arrayAdapter_wc);
        spinner_have_kabinet_badane.setAdapter(arrayAdapter__ketchen_kabinet);
        spinner_have_kabinet_roye.setAdapter(arrayAdapter__ketchen_kabinet);
        spinner_have_kabinet_safhe.setAdapter(arrayAdapter_ketchen_kabinet_roye);
        spinner_phone.setAdapter(arrayAdapter_phone);
        spinner_dong.setAdapter(arrayAdapter_dong);
        spinner_noe_malekati.setAdapter(arrayAdapter_noe_malekati);

        //----------------------------------------------------------------------------click spinner
        spinner_noe_dael.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        spinner_noe_melk.setAdapter(arrayAdapter_W_ground);
                        number_3.setVisibility(View.VISIBLE);
                        number_3_rahn.setVisibility(View.GONE);
                        break;
                    case 2:
                        spinner_noe_melk.setAdapter(arrayAdapter_WO_ground);
                        number_3.setVisibility(View.GONE);
                        number_3_rahn.setVisibility(View.VISIBLE);
                        break;
                }
                noe_melk_moamele = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner_noe_melk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                noe_melk = parent.getItemAtPosition(position).toString();

                switch (position) {
                    case 1:
                        Empitier();
                        //    Toast.makeText(Main26Activity.this, "مسکونی", Toast.LENGTH_SHORT).show();
                        ST_noe_bana = "مسکونی";
                        txtView.setText("نشیمن و پذیرایی");
                        txtView_noe_bana.setText("نوع بنا");
                        txtView_masahat.setText("مساحت ساخته شده (مترمربع)");
                        txtView_1.setText("وارد کردن مساحت ساخت (زیربنا) الزامی است");
                        txtView_2.setText("مساحت زمین (متر مربع)");
                        txtView_3.setText("مساحت زیر به متر مربع وارد شود.");
                        txtView_4.setText("موقعیت ساختمان");
                        txtView_5.setText("تعداد اتاق");
                        txtView_6.setText("سال ساخت (هجری شمسی)");
                        txtView_7.setText("سال ساخت ملک باید مشخصص گردد مثال: 1375");
                        txtView_8.setText("ملک واقع در طبقه");
                        txtView_9.setText("تعداد کل طبقات");
                        txtView_10.setText("تعداد واحد در هر طبقه");
                        txtView_11.setText("تعداد کل واحدها");
                        txtView_12.setText("حمام");
                        txtView_13.setText("امکانات ساختمان");
                        txtView_14.setText("توضیحات تکمیلی راجع به امکانات ساختمان");
                        txtView_15.setText("در مورد وسایل و تجهیزاتی مبله توضیح دهید");
                        txtView_16.setText("توضیحات تکمیلی راجع به نوع کف");
                        Fine_HoMe_checkBox_neshiman_moble.setText("مبله");
                        Fine_HoMe_checkBox3.setText("شومینه");
                        Fine_HoMe_checkBox6.setText("نورپردازی");
                        Fine_HoMe_checkBox7.setText("کامپوزیت");
                        Fine_HoMe_checkBox8.setText("شیشه");
                        Fine_HoMe_checkBox9.setText("چوب");
                        Fine_HoMe_checkBox10.setText("سنگ");
                        Fine_HoMe_checkBox11.setText("سیمان");
                        Fine_HoMe_checkBox12.setText("آجر");
                        Fine_HoMe_checkBox17.setText("سنگ");
                        Fine_HoMe_checkBox18.setText("سرامیک");
                        Fine_HoMe_checkBox19.setText("پارکت");
                        Fine_HoMe_checkBox20.setText("کفپوش");
                        Fine_HoMe_checkBox21.setText("موکت");
                        Fine_HoMe_checkBox22.setText("موزاییک");
                        Fine_HoMe_checkBox36.setText(" آنتن مرکزی ");
                        Fine_HoMe_checkBox38.setText(" شبکه داخلی ");
                        Fine_HoMe_checkBox47.setText(" حیاط خلوت ");
                        Fine_HoMe_checkBox48.setText(" سرایداری ");
                        Fine_HoMe_checkBox49.setText(" لابی ");
                        Fine_HoMe_checkBox50.setText(" باغ ");
                        Fine_HoMe_checkBox51.setText(" آب نما ");
                        Fine_HoMe_checkBox52.setText(" باربیکیو ");
                        Fine_HoMe_checkBox86.setText(" ژنراتور برق ");
                        Fine_HoMe_checkBox24.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox23.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox38.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox53.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox54.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox55.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox56.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox57.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox58.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox123.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox3.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox34.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox35.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox36.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox47.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox50.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox51.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox52.setVisibility(View.VISIBLE);
                        checkBox8.setVisibility(View.GONE);
                        checkBox7.setVisibility(View.GONE);
                        checkBox9.setVisibility(View.GONE);
                        checkBox10.setVisibility(View.GONE);
                        checkBox14.setVisibility(View.GONE);
                        checkBox15.setVisibility(View.GONE);
                        checkBox16.setVisibility(View.GONE);
                        checkBox20.setVisibility(View.GONE);
                        checkBox95.setVisibility(View.GONE);
                        liner_1.setVisibility(View.VISIBLE);
                        linear_2.setVisibility(View.GONE);
                        Liner_3.setVisibility(View.GONE);
                        liner_4.setVisibility(View.VISIBLE);
                        liner_5.setVisibility(View.VISIBLE);
                        liner_6.setVisibility(View.GONE);
                        liner_mogheitat_build.setVisibility(View.VISIBLE);
                        liner_mogheitat_build.setVisibility(View.GONE);
                        linear_kaf.setVisibility(View.VISIBLE);
                        linear_dastresi.setVisibility(View.GONE);
                        linear_karbari.setVisibility(View.GONE);
                        liner_moghiat.setVisibility(View.VISIBLE);
                        liner_emkanat.setVisibility(View.VISIBLE);
                        linear_kitchen.setVisibility(View.VISIBLE);
                        linear_neshiman.setVisibility(View.VISIBLE);
                        linear_shekl_building.setVisibility(View.VISIBLE);
                        linear_eskelet_building.setVisibility(View.VISIBLE);
                        linear_wall.setVisibility(View.VISIBLE);
                        linear_cold_hot.setVisibility(View.VISIBLE);
                        linear_refaii.setVisibility(View.VISIBLE);
                        linear_safe.setVisibility(View.VISIBLE);
                        linear_emkanat.setVisibility(View.VISIBLE);
                        linear_view.setVisibility(View.VISIBLE);
                        liner_phone2.setVisibility(View.VISIBLE);
                        liner_bath.setVisibility(View.VISIBLE);
                        linear_sport.setVisibility(View.VISIBLE);
                        liner_ghozar.setVisibility(View.GONE);
                        linear_NEWS.setVisibility(View.VISIBLE);
                        linear_nma.setVisibility(View.VISIBLE);
                        liner_WC.setVisibility(View.VISIBLE);
                        RadioGP2.setVisibility(View.VISIBLE);
                        spinner_noe_bana.setAdapter(arrayAdapter_noe_bana);
                        spinner7.setAdapter(arrayAdapter_mogheitat_build);
                        spinner_num_room.setAdapter(arrayAdapter_number);
                        break;

                    case 2:
                        Empitier();
                        //   Toast.makeText(Main26Activity.this, "اداری", Toast.LENGTH_SHORT).show();
                        ST_noe_bana = "اداری";
                        txtView.setText("اتاق اصلی");
                        checkBox8.setVisibility(View.VISIBLE);
                        checkBox7.setVisibility(View.VISIBLE);
                        checkBox9.setVisibility(View.VISIBLE);
                        checkBox10.setVisibility(View.VISIBLE);
                        checkBox14.setVisibility(View.GONE);
                        checkBox15.setVisibility(View.VISIBLE);
                        checkBox16.setVisibility(View.GONE);
                        checkBox33.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox3.setVisibility(View.GONE);
                        Fine_HoMe_checkBox34.setVisibility(View.GONE);
                        Fine_HoMe_checkBox35.setVisibility(View.GONE);
                        Fine_HoMe_checkBox36.setVisibility(View.GONE);
                        Fine_HoMe_checkBox47.setVisibility(View.GONE);
                        Fine_HoMe_checkBox50.setVisibility(View.GONE);
                        Fine_HoMe_checkBox51.setVisibility(View.GONE);
                        Fine_HoMe_checkBox52.setVisibility(View.GONE);
                        Fine_HoMe_checkBox56.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox57.setVisibility(View.GONE);
                        Fine_HoMe_checkBox58.setVisibility(View.GONE);
                        linear_2.setVisibility(View.GONE);
                        liner_bath.setVisibility(View.GONE);
                        linear_sport.setVisibility(View.GONE);
                        linear_karbari.setVisibility(View.GONE);
                        linear_kaf.setVisibility(View.GONE);
                        linear_dastresi.setVisibility(View.GONE);
                        linear_eskelet_building.setVisibility(View.GONE);
                        liner_mogheitat_build.setVisibility(View.VISIBLE);
                        liner_emkanat.setVisibility(View.GONE);
                        spinner_noe_bana.setAdapter(arrayAdapter_noe_bana);
                        spinner7.setAdapter(arrayAdapter_mogheitat_build);
                        spinner_num_room.setAdapter(arrayAdapter_number);

                        break;

                    case 3:
                        Empitier();
                        //   Toast.makeText(Main26Activity.this, "تجاری", Toast.LENGTH_SHORT).show();
                        ST_noe_bana = "تجاری";
                        txtView_noe_bana.setText("موقعیت مغازه");
                        txtView_masahat.setText(" مساحت کف (متر مربع)");
                        txtView.setText("فضای اصلی");
                        txtView_1.setText("وارد کردن مساحت کف به مترمربع الزامی است");
                        txtView_2.setText("مساحت بالکن (نیم طبقه)");
                        txtView_3.setText("اگر مغازه دارای نیم طبقه بالکن است مساحت آن را به متر مربع در اینجا وارد نمایید.");
                        txtView_4.setText("تعداد دهنه");
                        txtView_5.setText("تعداد بر");
                        txtView_6.setText("طول بر اصلی");
                        txtView_7.setText("طول بر اصلی به متر وارد شود.");
                        txtView_8.setText("مغازه واقع در طبقه");
                        txtView_9.setText("تعداد طبقات پاساژ");
                        txtView_10.setText("تعداد مغازه در هر طبقه");
                        txtView_11.setText("تعداد کل مغازه ها در پاساژ");
                        txtView_12.setText("روشویی");
                        Fine_HoMe_checkBox3.setText("ویترین");
                        Fine_HoMe_checkBox_neshiman_moble.setText(" دکوراسیون داخلی ");
                        Fine_HoMe_checkBox36.setText("پله برقی");
                        Fine_HoMe_checkBox47.setText(" داخل بازار ");
                        Fine_HoMe_checkBox48.setText(" خیابان اصلی ");
                        Fine_HoMe_checkBox49.setText(" خیابان فرعی ");
                        Fine_HoMe_checkBox50.setText("میدان");
                        Fine_HoMe_checkBox51.setText("کوچه");
                        Fine_HoMe_checkBox52.setText("بن بست");
                        txtView_13.setText("دسترسی");
                        txtView_14.setText("توضیحات تکمیلی راجع به دسترسی ملک");
                        txtView_17.setText("عرض بزرگترین گذر یا خیابان به متر");
                        liner_1.setVisibility(View.GONE);
                        linear_2.setVisibility(View.VISIBLE);
                        Liner_3.setVisibility(View.VISIBLE);
                        liner_ghozar.setVisibility(View.VISIBLE);
                        linear_kaf.setVisibility(View.VISIBLE);
                        linear_sport.setVisibility(View.GONE);
                        liner_emkanat.setVisibility(View.GONE);
                        linear_kitchen.setVisibility(View.GONE);
                        linear_shekl_building.setVisibility(View.GONE);
                        linear_eskelet_building.setVisibility(View.GONE);
                        linear_wall.setVisibility(View.GONE);
                        linear_NEWS.setVisibility(View.GONE);
                        linear_view.setVisibility(View.GONE);
                        linear_dastresi.setVisibility(View.GONE);
                        liner_bath.setVisibility(View.VISIBLE);
                        linear_karbari.setVisibility(View.GONE);
                        checkBox9.setVisibility(View.VISIBLE);
                        checkBox10.setVisibility(View.VISIBLE);
                        checkBox14.setVisibility(View.VISIBLE);
                        checkBox20.setVisibility(View.VISIBLE);
                        checkBox15.setVisibility(View.VISIBLE);
                        checkBox16.setVisibility(View.VISIBLE);
                        checkBox33.setVisibility(View.GONE);
                        Fine_HoMe_checkBox3.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox35.setVisibility(View.GONE);
                        Fine_HoMe_checkBox53.setVisibility(View.GONE);
                        Fine_HoMe_checkBox34.setVisibility(View.GONE);
                        Fine_HoMe_checkBox54.setVisibility(View.GONE);
                        Fine_HoMe_checkBox55.setVisibility(View.GONE);
                        Fine_HoMe_checkBox56.setVisibility(View.GONE);
                        Fine_HoMe_checkBox57.setVisibility(View.GONE);
                        Fine_HoMe_checkBox58.setVisibility(View.GONE);
                        Fine_HoMe_checkBox123.setVisibility(View.GONE);
                        Fine_HoMe_checkBox38.setVisibility(View.GONE);
                        RadioGP2.setVisibility(View.GONE);
                        spinner_noe_bana.setAdapter(arrayAdapter_tejari_moghiat);
                        spinner_num_room.setAdapter(arrayAdapter_nabsh);
                        spinner7.setAdapter(arrayAdapter_dahane);
                        break;

                    case 4:
                        Empitier();
                        //  Toast.makeText(Main26Activity.this, "زمین مستغلات", Toast.LENGTH_SHORT).show();
                        ST_noe_bana = "مستغلات";
                        txtView_masahat.setText("مساحت کل بنای ساخته شده (متر مربع)");
                        txtView_1.setText("مساحت کل بنا - برای محاسبه قیمت متری الزامی است");
                        txtView_15.setText("توضیحات اضافی راجع به نوع نما");
                        txtView_16.setText("توضیحات تکمیلی راجع به نوع دیوار");
                        txtView_5.setText("تعداد بر");
                        checkBox16.setVisibility(View.GONE);
                        liner_mogheitat_build.setVisibility(View.GONE);
                        liner_1.setVisibility(View.GONE);
                        linear_2.setVisibility(View.GONE);
                        liner_moghiat.setVisibility(View.GONE);
                        liner_emkanat.setVisibility(View.GONE);
                        liner_WC.setVisibility(View.GONE);
                        linear_kitchen.setVisibility(View.GONE);
                        linear_neshiman.setVisibility(View.GONE);
                        linear_shekl_building.setVisibility(View.GONE);
                        linear_kaf.setVisibility(View.GONE);
                        linear_NEWS.setVisibility(View.GONE);
                        linear_karbari.setVisibility(View.VISIBLE);
                        linear_dastresi.setVisibility(View.VISIBLE);
                        liner_ghozar.setVisibility(View.VISIBLE);
                        checkBox20.setVisibility(View.VISIBLE);
                        checkBox15.setVisibility(View.VISIBLE);
                        checkBox95.setVisibility(View.VISIBLE);
                        spinner_noe_bana.setAdapter(arrayAdapter_mostaghelat);
                        spinner_num_room.setAdapter(arrayAdapter_nabsh);
                        linear_emkanat.setVisibility(View.VISIBLE);
                        linear_sport.setVisibility(View.VISIBLE);
                        linear_view.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox56.setVisibility(View.GONE);

                        break;

                    case 5:
                        Empitier();
                        //  Toast.makeText(Main26Activity.this, "زمین", Toast.LENGTH_SHORT).show();
                        ST_noe_bana = "زمین";
                        txtView_noe_bana.setText("کاربری کنونی زمین");
                        txtView_6.setText("طول بر اصلی");
                        txtView_7.setText("طول بر اصلی به متر وارد شود.");
                        Fine_HoMe_checkBox17.setText(" بزرگراه ");
                        Fine_HoMe_checkBox18.setText(" خیابان اصلی ");
                        Fine_HoMe_checkBox19.setText(" خیابان فرعی ");
                        Fine_HoMe_checkBox20.setText("میدان");
                        Fine_HoMe_checkBox21.setText("کوچه");
                        Fine_HoMe_checkBox22.setText("بن بست");
                        txtView_16.setText("توضیحات تکمیلی راجع به دسترسی ملک");
                        txtView_17.setText("عرض بزرگترین گذر یا خیابان به متر");
                        txtView_4.setText("تعداد بر");
                        txtView_1.setText("مساحت زمین به متر مربع وارد شود.");
                        txtView_masahat.setText("مساحت زمین پس از اصلاحی (متر مربع)");
                        liner_6.setVisibility(View.VISIBLE);
                        liner_4.setVisibility(View.GONE);
                        linear_karbari.setVisibility(View.VISIBLE);
                        liner_1.setVisibility(View.GONE);
                        linear_2.setVisibility(View.GONE);
                        liner_5.setVisibility(View.GONE);
                        liner_moghiat.setVisibility(View.GONE);
                        liner_emkanat.setVisibility(View.GONE);
                        linear_kitchen.setVisibility(View.GONE);
                        linear_neshiman.setVisibility(View.GONE);
                        linear_shekl_building.setVisibility(View.GONE);
                        linear_eskelet_building.setVisibility(View.GONE);
                        linear_wall.setVisibility(View.GONE);
                        linear_cold_hot.setVisibility(View.GONE);
                        linear_refaii.setVisibility(View.GONE);
                        linear_sport.setVisibility(View.GONE);
                        linear_safe.setVisibility(View.GONE);
                        linear_emkanat.setVisibility(View.GONE);
                        linear_view.setVisibility(View.GONE);
                        linear_NEWS.setVisibility(View.GONE);
                        liner_phone2.setVisibility(View.GONE);
                        linear_nma.setVisibility(View.GONE);
                        liner_WC.setVisibility(View.GONE);
                        linear_kaf.setVisibility(View.GONE);
                        linear_dastresi.setVisibility(View.VISIBLE);
                        liner_ghozar.setVisibility(View.VISIBLE);
                        Fine_HoMe_checkBox24.setVisibility(View.GONE);
                        Fine_HoMe_checkBox23.setVisibility(View.GONE);
                        Fine_HoMe_checkBox56.setVisibility(View.GONE);
                        Fine_HoMe_checkBox86.setVisibility(View.GONE);
                        checkBox10.setVisibility(View.GONE);
                        checkBox95.setVisibility(View.VISIBLE);
                        checkBox21.setVisibility(View.GONE);

                        RadioGP2.setVisibility(View.GONE);
                        spinner7.setAdapter(arrayAdapter_nabsh);
                        spinner_noe_bana.setAdapter(arrayAdapter_zamin);

                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner_noe_bana.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                moshakhasat_asli_melk_noe_bana = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });


//bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb


        Fine_HoMe_checkBox123.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (Fine_HoMe_checkBox123.isChecked() == true) {
                    more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = "a:1:{i:0;s:37:\"واقع در مجتمع مسکونی\";}";
                } else {
                    more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = "";
                }
            }
        });


// check vaziita_build
        Fine_HoMe_checkBox_reBuild.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (Fine_HoMe_checkBox_reBuild.isChecked() == true) {
                    counter_vaziita_build++;
                    Fine_HoMe_checkBox_reBuildST = "NotNULL";
                } else {
                    counter_vaziita_build--;
                    Fine_HoMe_checkBox_reBuildST = "";

                }
            }
        });

        Fine_HoMe_checkBox_ghabel_live.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (Fine_HoMe_checkBox_ghabel_live.isChecked() == true) {
                    counter_vaziita_build++;
                    Fine_HoMe_checkBox_ghabel_liveST = "NotNULL";
                } else {
                    counter_vaziita_build--;
                    Fine_HoMe_checkBox_ghabel_liveST = "";


                    Vulue1 = moshakhasat_asli_melk_vaziita_build_ghabel_sokonat;
                }
            }
        });


        spinner_num_room.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                moshakhasat_asli_melk_number_room = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });


        spinner_num_parking.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                moshakhasat_asli_melk_number_parking = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });


        radioButton_NewSAZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//wtf
                if (radioButton_NewSAZ.isChecked() == true) {
                    Fine_HoMe_checkBox_reBuild.setVisibility(View.GONE);
                    Fine_HoMe_checkBox_ghabel_live.setVisibility(View.GONE);
                    Fine_HoMe_checkBox_reBuild.setChecked(false);
                    Fine_HoMe_checkBox_ghabel_live.setChecked(false);
                }
            }
        });
        radioButton_OldSAz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (radioButton_OldSAz.isChecked() == true) {
                    Fine_HoMe_checkBox_reBuild.setVisibility(View.VISIBLE);
                    Fine_HoMe_checkBox_ghabel_live.setVisibility(View.GONE);
                    Fine_HoMe_checkBox_ghabel_live.setChecked(false);
                }

                //wtf
            }
        });
        radioButton_OLD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (radioButton_OLD.isChecked() == true) {
                    Fine_HoMe_checkBox_reBuild.setVisibility(View.VISIBLE);
                    Fine_HoMe_checkBox_ghabel_live.setVisibility(View.VISIBLE);
                }
//wtf
            }
        });

        Fine_HoMe_checkBox_moaveze.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox_moaveze.isChecked() == true) {
                    liner_moaveze.setVisibility(View.VISIBLE);
                    counter_check_seel_cheng++;
                    Fine_HoMe_checkBox_moavezeST = "NotNULL";

                    Vulue2 = price_shrayet_sell_cheng_check_seel_cheng;

                } else {
                    liner_moaveze.setVisibility(View.GONE);
                    Find_HoMe_editText_moaveze.setText("");
                    counter_check_seel_cheng--;
                    Fine_HoMe_checkBox_moavezeST = "";
                }
            }

        });


        Fine_HoMe_checkBox_pish_sell.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox_pish_sell.isChecked() == true) {
                    linear_pish_sell.setVisibility(View.VISIBLE);
                    spiner_pish_sell_mizan.setAdapter(arrayAdapter_pish_sell_mizan);
                    counter_check_seel_cheng++;
                    Fine_HoMe_checkBox_pish_sellST = "NotNULL";

                    Vulue2 = price_shrayet_sell_cheng_check_seel_cheng;

                } else {
                    linear_pish_sell.setVisibility(View.GONE);
                    Find_HoMe_editText_pish_sell_price.setText("");
                    Find_HoMe_editText_pish_sell_time.setText("");
                    counter_check_seel_cheng--;
                    Fine_HoMe_checkBox_pish_sellST = "";
                }
            }
        });
        Fine_HoMe_checkBox_vam.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox_vam.isChecked() == true) {
                    linear_vam.setVisibility(View.VISIBLE);
                    counter_check_seel_cheng++;
                    Fine_HoMe_checkBox_vamST = "NotNULL";
                    Vulue2 = price_shrayet_sell_cheng_check_seel_cheng;
                } else {
                    linear_vam.setVisibility(View.GONE);
                    Find_HoMe_editText_vam_mizan.setText("");
                    Find_HoMe_editText_vam_sod.setText("");
                    Find_HoMe_editText_vam_num_ghest.setText("");
                    Find_HoMe_editText_vam_num_ghest2.setText("");
                    counter_check_seel_cheng--;
                    Fine_HoMe_checkBox_vamST = "";
                }
            }
        });
        Fine_HoMe_checkBox_sell_with_moshtari.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox_sell_with_moshtari.isChecked() == true) {
                    linear_sell_with_moshtari.setVisibility(View.VISIBLE);
                    counter_check_seel_cheng++;
                    Fine_HoMe_checkBox_sell_with_moshtariST = "NotNULL";
                    Vulue2 = price_shrayet_sell_cheng_check_seel_cheng;
                } else {
                    linear_sell_with_moshtari.setVisibility(View.GONE);
                    Find_HoMe_editText_sell_with_moshtari.setText("");
                    counter_check_seel_cheng--;
                    Fine_HoMe_checkBox_sell_with_moshtariST = "";
                }
            }
        });

        Fine_HoMe_checkBox_have_kabinet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox_have_kabinet.isChecked() == true) {
                    liner_have_kabinet.setVisibility(View.VISIBLE);
                    more_joziat_melk_edari_tejari_kitchen_darai_kabinet = "a:1:{i:0;s:23:\"دارای کابینت\";}";
                } else {
                    liner_have_kabinet.setVisibility(View.GONE);
                    more_joziat_melk_edari_tejari_kitchen_darai_kabinet = "";
                }
            }
        });


        Fine_HoMe_checkBox_have_tajhizat_kitchen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox_have_tajhizat_kitchen.isChecked() == true) {
                    liner_have_tajhizat_kitchen.setVisibility(View.VISIBLE);
                    more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchenST = "a:1:{i:0;s:42:\"دارای تجهیزات آشپزخانه\";}";
                } else {
                    liner_have_tajhizat_kitchen.setVisibility(View.GONE);
                    more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchenST = "";
                }
            }
        });


// neshiman

        Fine_HoMe_checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox3.isChecked() == true) {
                    counter_neshiman++;
                    Fine_HoMe_checkBox3ST = "NotNULL";
                } else {
                    counter_neshiman--;
                    Fine_HoMe_checkBox3ST = "";

                    Vulue3 = more_joziat_melk_edari_tejari_neshiman_neshiman_check;

                }
            }
        });

        Fine_HoMe_checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox4.isChecked() == true) {
                    counter_neshiman++;
                    Fine_HoMe_checkBox4ST = "NotNULL";
                } else {
                    counter_neshiman--;
                    Fine_HoMe_checkBox4ST = "";

                    Vulue3 = more_joziat_melk_edari_tejari_neshiman_neshiman_check;

                }
            }
        });

        Fine_HoMe_checkBox_neshiman_moble.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox_neshiman_moble.isChecked() == true) {
                    counter_neshiman++;
                    Fine_HoMe_checkBox_neshiman_mobleST = "NotNULL";
                } else {
                    counter_neshiman--;
                    Fine_HoMe_checkBox_neshiman_mobleST = "";

                    Vulue3 = more_joziat_melk_edari_tejari_neshiman_neshiman_check;

                }


                switch (ST_noe_bana) {
                    case "مسکونی":
                        if (Fine_HoMe_checkBox_neshiman_moble.isChecked() == true) {
                            linear_neshiman_mile.setVisibility(View.VISIBLE);
                        } else {
                            linear_neshiman_mile.setVisibility(View.GONE);
                        }
                        break;
                    case "اداری":
                        if (Fine_HoMe_checkBox_neshiman_moble.isChecked() == true) {
                            linear_neshiman_mile.setVisibility(View.VISIBLE);
                        } else {
                            linear_neshiman_mile.setVisibility(View.GONE);
                        }
                        break;
                }
            }
        });

        checkBox14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox14.isChecked() == true) {
                    counter_neshiman++;
                    checkBox14ST = "NotNULL";
                } else {
                    counter_neshiman--;
                    checkBox14ST = "";
                    Vulue3 = more_joziat_melk_edari_tejari_neshiman_neshiman_check;
                }
            }
        });


// nma

        Fine_HoMe_checkBox6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox6.isChecked() == true) {
                    counter_nma++;
                    Fine_HoMe_checkBox6ST = "NotNULL";
                } else {
                    counter_nma--;
                    Fine_HoMe_checkBox6ST = "";
                    Vulue4 = more_joziat_melk_edari_tejari_nama_nama_check;

                }
            }
        });


        Fine_HoMe_checkBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox7.isChecked() == true) {
                    counter_nma++;
                    Fine_HoMe_checkBox7ST = "NotNULL";
                } else {
                    counter_nma--;
                    Fine_HoMe_checkBox7ST = "";
                    Vulue4 = more_joziat_melk_edari_tejari_nama_nama_check;

                }
            }
        });


        Fine_HoMe_checkBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox8.isChecked() == true) {
                    counter_nma++;
                    Fine_HoMe_checkBox8ST = "NotNULL";
                } else {
                    counter_nma--;
                    Fine_HoMe_checkBox8ST = "";
                    Vulue4 = more_joziat_melk_edari_tejari_nama_nama_check;

                }
            }
        });


        Fine_HoMe_checkBox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox9.isChecked() == true) {
                    counter_nma++;
                    Fine_HoMe_checkBox9ST = "NotNULL";
                } else {
                    counter_nma--;
                    Fine_HoMe_checkBox9ST = "";
                    Vulue4 = more_joziat_melk_edari_tejari_nama_nama_check;

                }
            }
        });


        Fine_HoMe_checkBox10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox10.isChecked() == true) {
                    counter_nma++;
                    Fine_HoMe_checkBox10ST = "NotNULL";
                } else {
                    counter_nma--;
                    Fine_HoMe_checkBox10ST = "";
                    Vulue4 = more_joziat_melk_edari_tejari_nama_nama_check;

                }
            }
        });


        Fine_HoMe_checkBox11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox11.isChecked() == true) {
                    counter_nma++;
                    Fine_HoMe_checkBox11ST = "NotNULL";
                } else {
                    counter_nma--;
                    Fine_HoMe_checkBox11ST = "";
                    Vulue4 = more_joziat_melk_edari_tejari_nama_nama_check;

                }
            }
        });


        Fine_HoMe_checkBox12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox12.isChecked() == true) {
                    counter_nma++;
                    Fine_HoMe_checkBox12ST = "NotNULL";
                } else {
                    counter_nma--;
                    Fine_HoMe_checkBox12ST = "";
                    Vulue4 = more_joziat_melk_edari_tejari_nama_nama_check;

                }
            }
        });


// eskelet

        Fine_HoMe_checkBox13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox13.isChecked() == true) {
                    counter_eskelet++;
                    Fine_HoMe_checkBox13ST = "NotNULL";
                } else {
                    counter_eskelet--;
                    Fine_HoMe_checkBox13ST = "";
                    Vulue5 = more_joziat_melk_edari_tejari_eskelet_eskelet_check;

                }
            }
        });

        Fine_HoMe_checkBox15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox15.isChecked() == true) {
                    counter_eskelet++;
                    Fine_HoMe_checkBox15ST = "NotNULL";
                } else {
                    counter_eskelet--;
                    Fine_HoMe_checkBox15ST = "";
                    Vulue5 = more_joziat_melk_edari_tejari_eskelet_eskelet_check;

                }
            }
        });

        Fine_HoMe_checkBox14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox14.isChecked() == true) {
                    counter_eskelet++;
                    Fine_HoMe_checkBox14ST = "NotNULL";
                } else {
                    counter_eskelet--;
                    Fine_HoMe_checkBox14ST = "";
                    Vulue5 = more_joziat_melk_edari_tejari_eskelet_eskelet_check;

                }
            }
        });

        Fine_HoMe_checkBox16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox16.isChecked() == true) {
                    counter_eskelet++;
                    Fine_HoMe_checkBox16ST = "NotNULL";
                } else {
                    counter_eskelet--;
                    Fine_HoMe_checkBox16ST = "";
                    Vulue5 = more_joziat_melk_edari_tejari_eskelet_eskelet_check;

                }
            }
        });
// kaf

        Fine_HoMe_checkBox17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox17.isChecked() == true) {
                    counter_kaf++;
                    Fine_HoMe_checkBox17ST = "NotNULL";
                } else {
                    counter_kaf--;
                    Fine_HoMe_checkBox17ST = "";
                    Vulue6 = more_joziat_melk_edari_tejari_kaf_kaf_check;

                }
            }
        });

        Fine_HoMe_checkBox18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox18.isChecked() == true) {
                    counter_kaf++;
                    Fine_HoMe_checkBox18ST = "NotNULL";
                } else {
                    counter_kaf--;
                    Fine_HoMe_checkBox18ST = "";
                    Vulue6 = more_joziat_melk_edari_tejari_kaf_kaf_check;

                }
            }
        });

        Fine_HoMe_checkBox19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox19.isChecked() == true) {
                    counter_kaf++;
                    Fine_HoMe_checkBox19ST = "NotNULL";
                } else {
                    counter_kaf--;
                    Fine_HoMe_checkBox19ST = "";
                    Vulue6 = more_joziat_melk_edari_tejari_kaf_kaf_check;

                }
            }
        });

        Fine_HoMe_checkBox20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox20.isChecked() == true) {
                    counter_kaf++;
                    Fine_HoMe_checkBox20ST = "NotNULL";
                } else {
                    counter_kaf--;
                    Fine_HoMe_checkBox20ST = "";
                    Vulue6 = more_joziat_melk_edari_tejari_kaf_kaf_check;

                }
            }
        });

        Fine_HoMe_checkBox21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox21.isChecked() == true) {
                    counter_kaf++;
                    Fine_HoMe_checkBox21ST = "NotNULL";
                } else {
                    counter_kaf--;
                    Fine_HoMe_checkBox21ST = "";
                    Vulue6 = more_joziat_melk_edari_tejari_kaf_kaf_check;

                }
            }
        });

        Fine_HoMe_checkBox22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox22.isChecked() == true) {
                    counter_kaf++;
                    Fine_HoMe_checkBox22ST = "NotNULL";
                } else {
                    counter_kaf--;
                    Fine_HoMe_checkBox22ST = "";
                    Vulue6 = more_joziat_melk_edari_tejari_kaf_kaf_check;

                }
            }
        });

        Fine_HoMe_checkBox23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox23.isChecked() == true) {
                    counter_kaf++;
                    Fine_HoMe_checkBox23ST = "NotNULL";
                } else {
                    counter_kaf--;
                    Fine_HoMe_checkBox23ST = "";
                    Vulue6 = more_joziat_melk_edari_tejari_kaf_kaf_check;

                }
            }
        });

        Fine_HoMe_checkBox24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox24.isChecked() == true) {
                    counter_kaf++;
                    Fine_HoMe_checkBox24ST = "NotNULL";
                } else {
                    counter_kaf--;
                    Fine_HoMe_checkBox24ST = "";
                    Vulue6 = more_joziat_melk_edari_tejari_kaf_kaf_check;

                }
            }
        });

// divar


        Fine_HoMe_checkBox25.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox25.isChecked() == true) {
                    counter_divar++;
                    Fine_HoMe_checkBox25ST = "NotNULL";
                } else {
                    counter_divar--;
                    Fine_HoMe_checkBox25ST = "";
                    Vulue7 = more_joziat_melk_edari_tejari_divar_divar_check;

                }
            }
        });

        Fine_HoMe_checkBox26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox26.isChecked() == true) {
                    counter_divar++;
                    Fine_HoMe_checkBox26ST = "NotNULL";
                } else {
                    counter_divar--;
                    Fine_HoMe_checkBox26ST = "";
                    Vulue7 = more_joziat_melk_edari_tejari_divar_divar_check;

                }
            }
        });

        Fine_HoMe_checkBox27.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox27.isChecked() == true) {
                    counter_divar++;
                    Fine_HoMe_checkBox27ST = "NotNULL";
                } else {
                    counter_divar--;
                    Fine_HoMe_checkBox27ST = "";
                    Vulue7 = more_joziat_melk_edari_tejari_divar_divar_check;

                }
            }
        });

        Fine_HoMe_checkBox28.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox28.isChecked() == true) {
                    counter_divar++;
                    Fine_HoMe_checkBox28ST = "NotNULL";
                } else {
                    counter_divar--;
                    Fine_HoMe_checkBox28ST = "";
                    Vulue7 = more_joziat_melk_edari_tejari_divar_divar_check;

                }
            }
        });

        Fine_HoMe_checkBox29.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox29.isChecked() == true) {
                    counter_divar++;
                    Fine_HoMe_checkBox29ST = "NotNULL";
                } else {
                    counter_divar--;
                    Fine_HoMe_checkBox29ST = "";
                    Vulue7 = more_joziat_melk_edari_tejari_divar_divar_check;

                }
            }
        });

        Fine_HoMe_checkBox30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox30.isChecked() == true) {
                    counter_divar++;
                    Fine_HoMe_checkBox30ST = "NotNULL";
                } else {
                    counter_divar--;
                    Fine_HoMe_checkBox30ST = "";
                    Vulue7 = more_joziat_melk_edari_tejari_divar_divar_check;

                }
            }
        });

        Fine_HoMe_checkBox31.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox31.isChecked() == true) {
                    counter_divar++;
                    Fine_HoMe_checkBox31ST = "NotNULL";
                } else {
                    counter_divar--;
                    Fine_HoMe_checkBox31ST = "";
                    Vulue7 = more_joziat_melk_edari_tejari_divar_divar_check;

                }
            }
        });

        Fine_HoMe_checkBox32.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox32.isChecked() == true) {
                    counter_divar++;
                    Fine_HoMe_checkBox32ST = "NotNULL";

                } else {
                    counter_divar--;
                    Fine_HoMe_checkBox32ST = "";
                    Vulue7 = more_joziat_melk_edari_tejari_divar_divar_check;
                }
            }
        });

// coldhot

        Fine_HoMe_checkBox331.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox331.isChecked() == true) {
                    counter_coldhot++;
                    Fine_HoMe_checkBox331ST = "NotNULL";
                } else {
                    counter_coldhot--;
                    Fine_HoMe_checkBox331ST = "";
                    Vulue8 = more_joziat_melk_edari_tejari_coldhot_coldhot_check;

                }
            }
        });

        Fine_HoMe_checkBox341.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox341.isChecked() == true) {
                    counter_coldhot++;
                    Fine_HoMe_checkBox341ST = "NotNULL";
                } else {
                    counter_coldhot--;
                    Fine_HoMe_checkBox341ST = "";
                    Vulue8 = more_joziat_melk_edari_tejari_coldhot_coldhot_check;

                }
            }
        });

        Fine_HoMe_checkBox351.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox351.isChecked() == true) {
                    counter_coldhot++;
                    Fine_HoMe_checkBox351ST = "NotNULL";
                } else {
                    counter_coldhot--;
                    Fine_HoMe_checkBox351ST = "";
                    Vulue8 = more_joziat_melk_edari_tejari_coldhot_coldhot_check;

                }
            }
        });

        Fine_HoMe_checkBox361.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox361.isChecked() == true) {
                    counter_coldhot++;
                    Fine_HoMe_checkBox361ST = "NotNULL";
                } else {
                    counter_coldhot--;
                    Fine_HoMe_checkBox361ST = "";
                    Vulue8 = more_joziat_melk_edari_tejari_coldhot_coldhot_check;

                }
            }
        });

        Fine_HoMe_checkBox371.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox371.isChecked() == true) {
                    counter_coldhot++;
                    Fine_HoMe_checkBox371ST = "NotNULL";
                } else {
                    counter_coldhot--;
                    Fine_HoMe_checkBox371ST = "";
                    Vulue8 = more_joziat_melk_edari_tejari_coldhot_coldhot_check;

                }
            }
        });

        Fine_HoMe_checkBox381.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox381.isChecked() == true) {
                    counter_coldhot++;
                    Fine_HoMe_checkBox381ST = "NotNULL";
                } else {
                    counter_coldhot--;
                    Fine_HoMe_checkBox381ST = "";
                    Vulue8 = more_joziat_melk_edari_tejari_coldhot_coldhot_check;

                }
            }
        });

        Fine_HoMe_checkBox39.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox39.isChecked() == true) {
                    counter_coldhot++;
                    Fine_HoMe_checkBox39ST = "NotNULL";
                } else {
                    counter_coldhot--;
                    Fine_HoMe_checkBox39ST = "";
                    Vulue8 = more_joziat_melk_edari_tejari_coldhot_coldhot_check;

                }
            }
        });

        Fine_HoMe_checkBox40.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox40.isChecked() == true) {
                    counter_coldhot++;
                    Fine_HoMe_checkBox40ST = "NotNULL";
                } else {
                    counter_coldhot--;
                    Fine_HoMe_checkBox40ST = "";
                    Vulue8 = more_joziat_melk_edari_tejari_coldhot_coldhot_check;

                }
            }
        });


// refahi

        Fine_HoMe_checkBox33.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox33.isChecked() == true) {
                    counter_refahi++;
                    Fine_HoMe_checkBox33ST = "NotNULL";
                } else {
                    counter_refahi--;
                    Fine_HoMe_checkBox33ST = "";
                    Vulue9 = more_joziat_melk_edari_tejari_refahi_refahi_check;

                }
            }
        });

        Fine_HoMe_checkBox34.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox34.isChecked() == true) {
                    counter_refahi++;
                    Fine_HoMe_checkBox34ST = "NotNULL";
                } else {
                    counter_refahi--;
                    Fine_HoMe_checkBox34ST = "";
                    Vulue9 = more_joziat_melk_edari_tejari_refahi_refahi_check;

                }
            }
        });

        Fine_HoMe_checkBox35.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox35.isChecked() == true) {
                    counter_refahi++;
                    Fine_HoMe_checkBox35ST = "NotNULL";
                } else {
                    counter_refahi--;
                    Fine_HoMe_checkBox35ST = "";
                    Vulue9 = more_joziat_melk_edari_tejari_refahi_refahi_check;

                }
            }
        });

        Fine_HoMe_checkBox36.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox36.isChecked() == true) {
                    counter_refahi++;
                    Fine_HoMe_checkBox36ST = "NotNULL";
                } else {
                    counter_refahi--;
                    Fine_HoMe_checkBox36ST = "";
                    Vulue9 = more_joziat_melk_edari_tejari_refahi_refahi_check;

                }
            }
        });


        checkBox20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox20.isChecked() == true) {
                    counter_refahi++;
                    checkBox20ST = "NotNULL";
                } else {
                    counter_refahi--;
                    checkBox20ST = "";
                    Vulue9 = more_joziat_melk_edari_tejari_refahi_refahi_check;

                }
            }
        });


        Fine_HoMe_checkBox37.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox37.isChecked() == true) {
                    counter_refahi++;
                    Fine_HoMe_checkBox37ST = "NotNULL";
                } else {
                    counter_refahi--;
                    Fine_HoMe_checkBox37ST = "";
                    Vulue9 = more_joziat_melk_edari_tejari_refahi_refahi_check;

                }
            }
        });

        Fine_HoMe_checkBox38.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox38.isChecked() == true) {
                    counter_refahi++;
                    Fine_HoMe_checkBox38ST = "NotNULL";
                } else {
                    counter_refahi--;
                    Fine_HoMe_checkBox38ST = "";
                    Vulue9 = more_joziat_melk_edari_tejari_refahi_refahi_check;

                }
            }
        });

// safe

        Fine_HoMe_checkBox41.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox41.isChecked() == true) {
                    counter_safe++;
                    Fine_HoMe_checkBox41ST = "NotNULL";
                } else {
                    counter_safe--;
                    Fine_HoMe_checkBox41ST = "";
                    Vulue10 = more_joziat_melk_edari_tejari_safe_safe_check;

                }
            }
        });

        Fine_HoMe_checkBox42.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox42.isChecked() == true) {
                    counter_safe++;
                    Fine_HoMe_checkBox42ST = "NotNULL";
                } else {
                    counter_safe--;
                    Fine_HoMe_checkBox42ST = "";
                    Vulue10 = more_joziat_melk_edari_tejari_safe_safe_check;

                }
            }
        });

        Fine_HoMe_checkBox43.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox43.isChecked() == true) {
                    counter_safe++;
                    Fine_HoMe_checkBox43ST = "NotNULL";
                } else {
                    counter_safe--;
                    Fine_HoMe_checkBox43ST = "";
                    Vulue10 = more_joziat_melk_edari_tejari_safe_safe_check;

                }
            }
        });

        Fine_HoMe_checkBox45.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox45.isChecked() == true) {
                    counter_safe++;
                    Fine_HoMe_checkBox45ST = "NotNULL";
                } else {
                    counter_safe--;
                    Fine_HoMe_checkBox45ST = "";
                    Vulue10 = more_joziat_melk_edari_tejari_safe_safe_check;

                }
            }
        });

        Fine_HoMe_checkBox46.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox46.isChecked() == true) {
                    counter_safe++;
                    Fine_HoMe_checkBox46ST = "NotNULL";
                } else {
                    counter_safe--;
                    Fine_HoMe_checkBox46ST = "";
                    Vulue10 = more_joziat_melk_edari_tejari_safe_safe_check;

                }
            }
        });


        Fine_HoMe_checkBox44.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox44.isChecked() == true) {
                    counter_safe++;
                    Fine_HoMe_checkBox44ST = "NotNULL";
                } else {
                    counter_safe--;
                    Fine_HoMe_checkBox44ST = "";
                    Vulue10 = more_joziat_melk_edari_tejari_safe_safe_check;

                }
            }
        });


// emkanat


        Fine_HoMe_checkBox47.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox47.isChecked() == true) {
                    counter_emkanat++;
                    Fine_HoMe_checkBox47ST = "NotNULL";
                } else {
                    counter_emkanat--;
                    Fine_HoMe_checkBox47ST = "";
                    Vulue11 = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;

                }
            }
        });

        Fine_HoMe_checkBox48.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox48.isChecked() == true) {
                    counter_emkanat++;
                    Fine_HoMe_checkBox48ST = "NotNULL";
                } else {
                    counter_emkanat--;
                    Fine_HoMe_checkBox48ST = "";
                    Vulue11 = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;

                }
            }
        });

        Fine_HoMe_checkBox49.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox49.isChecked() == true) {
                    counter_emkanat++;
                    Fine_HoMe_checkBox49ST = "NotNULL";
                } else {
                    counter_emkanat--;
                    Fine_HoMe_checkBox49ST = "";
                    Vulue11 = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;

                }
            }
        });

        Fine_HoMe_checkBox50.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox50.isChecked() == true) {
                    counter_emkanat++;
                    Fine_HoMe_checkBox50ST = "NotNULL";
                } else {
                    counter_emkanat--;
                    Fine_HoMe_checkBox50ST = "";
                    Vulue11 = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;

                }
            }
        });

        Fine_HoMe_checkBox58.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox58.isChecked() == true) {
                    counter_emkanat++;
                    Fine_HoMe_checkBox58ST = "NotNULL";
                } else {
                    counter_emkanat--;
                    Fine_HoMe_checkBox58ST = "";
                    Vulue11 = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;

                }
            }
        });

        Fine_HoMe_checkBox51.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox51.isChecked() == true) {
                    counter_emkanat++;
                    Fine_HoMe_checkBox51ST = "NotNULL";
                } else {
                    counter_emkanat--;
                    Fine_HoMe_checkBox51ST = "";
                    Vulue11 = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;

                }
            }
        });

        Fine_HoMe_checkBox52.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox52.isChecked() == true) {
                    counter_emkanat++;
                    Fine_HoMe_checkBox52ST = "NotNULL";
                } else {
                    counter_emkanat--;
                    Fine_HoMe_checkBox52ST = "";
                    Vulue11 = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;

                }
            }
        });

        Fine_HoMe_checkBox53.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox53.isChecked() == true) {
                    counter_emkanat++;
                    Fine_HoMe_checkBox53ST = "NotNULL";
                } else {
                    counter_emkanat--;
                    Fine_HoMe_checkBox53ST = "";
                    Vulue11 = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;

                }
            }
        });

        Fine_HoMe_checkBox54.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox54.isChecked() == true) {
                    counter_emkanat++;
                    Fine_HoMe_checkBox54ST = "NotNULL";
                } else {
                    counter_emkanat--;
                    Fine_HoMe_checkBox54ST = "";
                    Vulue11 = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;

                }
            }
        });

        Fine_HoMe_checkBox55.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox55.isChecked() == true) {
                    counter_emkanat++;
                    Fine_HoMe_checkBox55ST = "NotNULL";
                } else {
                    counter_emkanat--;
                    Fine_HoMe_checkBox55ST = "";
                    Vulue11 = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;

                }
            }
        });

        Fine_HoMe_checkBox56.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox56.isChecked() == true) {
                    counter_emkanat++;
                    Fine_HoMe_checkBox56ST = "NotNULL";
                } else {
                    counter_emkanat--;
                    Fine_HoMe_checkBox56ST = "";
                    Vulue11 = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;

                }
            }
        });

        Fine_HoMe_checkBox57.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox57.isChecked() == true) {
                    counter_emkanat++;
                    Fine_HoMe_checkBox57ST = "NotNULL";
                } else {
                    counter_emkanat--;
                    Fine_HoMe_checkBox57ST = "";
                    Vulue11 = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;

                }
            }
        });

// sport


        Fine_HoMe_checkBox59.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox59.isChecked() == true) {
                    counter_sport++;
                    Fine_HoMe_checkBox59ST = "NotNULL";
                } else {
                    counter_sport--;
                    Fine_HoMe_checkBox59ST = "";
                    Vulue12 = more_joziat_melk_edari_tejari_sport_sport_check;

                }
            }
        });

        Fine_HoMe_checkBox60.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox60.isChecked() == true) {
                    counter_sport++;
                    Fine_HoMe_checkBox60ST = "NotNULL";
                } else {
                    counter_sport--;
                    Fine_HoMe_checkBox60ST = "";
                    Vulue12 = more_joziat_melk_edari_tejari_sport_sport_check;

                }
            }
        });

        Fine_HoMe_checkBox61.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox61.isChecked() == true) {
                    counter_sport++;
                    Fine_HoMe_checkBox61ST = "NotNULL";
                } else {
                    counter_sport--;
                    Fine_HoMe_checkBox61ST = "";
                    Vulue12 = more_joziat_melk_edari_tejari_sport_sport_check;

                }
            }
        });

        Fine_HoMe_checkBox62.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox62.isChecked() == true) {
                    counter_sport++;
                    Fine_HoMe_checkBox62ST = "NotNULL";
                } else {
                    counter_sport--;
                    Fine_HoMe_checkBox62ST = "";
                    Vulue12 = more_joziat_melk_edari_tejari_sport_sport_check;

                }
            }
        });

        Fine_HoMe_checkBox63.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox63.isChecked() == true) {
                    counter_sport++;
                    Fine_HoMe_checkBox63ST = "NotNULL";
                } else {
                    counter_sport--;
                    Fine_HoMe_checkBox63ST = "";
                    Vulue12 = more_joziat_melk_edari_tejari_sport_sport_check;

                }
            }
        });

        Fine_HoMe_checkBox64.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox64.isChecked() == true) {
                    counter_sport++;
                    Fine_HoMe_checkBox64ST = "NotNULL";
                } else {
                    counter_sport--;
                    Fine_HoMe_checkBox64ST = "";
                    Vulue12 = more_joziat_melk_edari_tejari_sport_sport_check;

                }
            }
        });

        Fine_HoMe_checkBox65.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox65.isChecked() == true) {
                    counter_sport++;
                    Fine_HoMe_checkBox65ST = "NotNULL";
                } else {
                    counter_sport--;
                    Fine_HoMe_checkBox65ST = "";
                    Vulue12 = more_joziat_melk_edari_tejari_sport_sport_check;

                }
            }
        });

        Fine_HoMe_checkBox66.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox66.isChecked() == true) {
                    counter_sport++;
                    Fine_HoMe_checkBox66ST = "NotNULL";
                } else {
                    counter_sport--;
                    Fine_HoMe_checkBox66ST = "";
                    Vulue12 = more_joziat_melk_edari_tejari_sport_sport_check;

                }
            }
        });

        Fine_HoMe_checkBox67.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox67.isChecked() == true) {
                    counter_sport++;
                    Fine_HoMe_checkBox67ST = "NotNULL";
                } else {
                    counter_sport--;
                    Fine_HoMe_checkBox67ST = "";
                    Vulue12 = more_joziat_melk_edari_tejari_sport_sport_check;

                }
            }
        });

        Fine_HoMe_checkBox68.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox68.isChecked() == true) {
                    counter_sport++;
                    Fine_HoMe_checkBox68ST = "NotNULL";
                } else {
                    counter_sport--;
                    Fine_HoMe_checkBox68ST = "";
                    Vulue12 = more_joziat_melk_edari_tejari_sport_sport_check;

                }
            }
        });

        Fine_HoMe_checkBox69.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox69.isChecked() == true) {
                    counter_sport++;
                    Fine_HoMe_checkBox69ST = "NotNULL";
                } else {
                    counter_sport--;
                    Fine_HoMe_checkBox69ST = "";
                    Vulue12 = more_joziat_melk_edari_tejari_sport_sport_check;

                }
            }
        });

        Fine_HoMe_checkBox70.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox70.isChecked() == true) {
                    counter_sport++;
                    Fine_HoMe_checkBox70ST = "NotNULL";
                } else {
                    counter_sport--;
                    Fine_HoMe_checkBox70ST = "";
                    Vulue12 = more_joziat_melk_edari_tejari_sport_sport_check;

                }
            }
        });

// view


        Fine_HoMe_checkBox71.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox71.isChecked() == true) {
                    counter_view++;
                    Fine_HoMe_checkBox71ST = "NotNULL";
                } else {
                    counter_view--;
                    Fine_HoMe_checkBox71ST = "";
                    Vulue13 = more_joziat_melk_edari_tejari_view_view_check;

                }
            }
        });

        Fine_HoMe_checkBox72.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox72.isChecked() == true) {
                    counter_view++;
                    Fine_HoMe_checkBox72ST = "NotNULL";
                } else {
                    counter_view--;
                    Fine_HoMe_checkBox72ST = "";
                    Vulue13 = more_joziat_melk_edari_tejari_view_view_check;

                }
            }
        });

        Fine_HoMe_checkBox73.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox73.isChecked() == true) {
                    counter_view++;
                    Fine_HoMe_checkBox73ST = "NotNULL";
                } else {
                    counter_view--;
                    Fine_HoMe_checkBox73ST = "";
                    Vulue13 = more_joziat_melk_edari_tejari_view_view_check;

                }
            }
        });

        Fine_HoMe_checkBox74.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox74.isChecked() == true) {
                    counter_view++;
                    Fine_HoMe_checkBox74ST = "NotNULL";
                } else {
                    counter_view--;
                    Fine_HoMe_checkBox74ST = "";
                    Vulue13 = more_joziat_melk_edari_tejari_view_view_check;

                }
            }
        });

        Fine_HoMe_checkBox75.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox75.isChecked() == true) {
                    counter_view++;
                    Fine_HoMe_checkBox75ST = "NotNULL";
                } else {
                    counter_view--;
                    Fine_HoMe_checkBox75ST = "";
                    Vulue13 = more_joziat_melk_edari_tejari_view_view_check;

                }
            }
        });

        Fine_HoMe_checkBox76.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox76.isChecked() == true) {
                    counter_view++;
                    Fine_HoMe_checkBox76ST = "NotNULL";
                } else {
                    counter_view--;
                    Fine_HoMe_checkBox76ST = "";
                    Vulue13 = more_joziat_melk_edari_tejari_view_view_check;

                }
            }
        });

        Fine_HoMe_checkBox77.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox77.isChecked() == true) {
                    counter_view++;
                    Fine_HoMe_checkBox77ST = "NotNULL";
                } else {
                    counter_view--;
                    Fine_HoMe_checkBox77ST = "";
                    Vulue13 = more_joziat_melk_edari_tejari_view_view_check;

                }
            }
        });

        Fine_HoMe_checkBox78.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox78.isChecked() == true) {
                    counter_view++;
                    Fine_HoMe_checkBox78ST = "NotNULL";
                } else {
                    counter_view--;
                    Fine_HoMe_checkBox78ST = "";
                    Vulue13 = more_joziat_melk_edari_tejari_view_view_check;

                }
            }
        });

// nor


        Fine_HoMe_checkBox79.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox79.isChecked() == true) {
                    counter_nor++;
                    Fine_HoMe_checkBox79ST = "NotNULL";
                } else {
                    counter_nor--;
                    Fine_HoMe_checkBox79ST = "";
                    Vulue14 = more_joziat_melk_edari_tejari_nor_nor_check;

                }
            }
        });

        Fine_HoMe_checkBox80.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox80.isChecked() == true) {
                    counter_nor++;
                    Fine_HoMe_checkBox80ST = "NotNULL";
                } else {
                    counter_nor--;
                    Fine_HoMe_checkBox80ST = "";
                    Vulue14 = more_joziat_melk_edari_tejari_nor_nor_check;

                }
            }
        });

        Fine_HoMe_checkBox81.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox81.isChecked() == true) {
                    counter_nor++;
                    Fine_HoMe_checkBox81ST = "NotNULL";
                } else {
                    counter_nor--;
                    Fine_HoMe_checkBox81ST = "";
                    Vulue14 = more_joziat_melk_edari_tejari_nor_nor_check;

                }
            }
        });

        Fine_HoMe_checkBox82.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox82.isChecked() == true) {
                    counter_nor++;
                    Fine_HoMe_checkBox82ST = "NotNULL";
                } else {
                    counter_nor--;
                    Fine_HoMe_checkBox82ST = "";
                    Vulue14 = more_joziat_melk_edari_tejari_nor_nor_check;

                }
            }
        });
// tasisat


        Fine_HoMe_checkBox83.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox83.isChecked() == true) {
                    counter_tasisat++;
                    Fine_HoMe_checkBox83ST = "NotNULL";
                } else {
                    counter_tasisat--;
                    Fine_HoMe_checkBox83ST = "";
                    Vulue15 = more_joziat_melk_edari_tejari_tasisat_tasisat_check;

                }
            }
        });

        checkBox95.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox95.isChecked() == true) {
                    counter_tasisat++;
                    checkBox95ST = "NotNULL";
                } else {
                    counter_tasisat--;
                    checkBox95ST = "";
                    Vulue15 = more_joziat_melk_edari_tejari_tasisat_tasisat_check;

                }
            }
        });

        Fine_HoMe_checkBox84.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox84.isChecked() == true) {
                    counter_tasisat++;
                    Fine_HoMe_checkBox84ST = "NotNULL";
                } else {
                    counter_tasisat--;
                    Fine_HoMe_checkBox84ST = "";
                    Vulue15 = more_joziat_melk_edari_tejari_tasisat_tasisat_check;

                }
            }
        });

        Fine_HoMe_checkBox85.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox85.isChecked() == true) {
                    counter_tasisat++;
                    Fine_HoMe_checkBox85ST = "NotNULL";
                } else {
                    counter_tasisat--;
                    Fine_HoMe_checkBox85ST = "";
                    Vulue15 = more_joziat_melk_edari_tejari_tasisat_tasisat_check;

                }
            }
        });

        Fine_HoMe_checkBox86.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox86.isChecked() == true) {
                    counter_tasisat++;
                    Fine_HoMe_checkBox86ST = "NotNULL";
                } else {
                    counter_tasisat--;
                    Fine_HoMe_checkBox86ST = "";
                    Vulue15 = more_joziat_melk_edari_tejari_tasisat_tasisat_check;

                }
            }
        });


// aaaaaaaaaaaaaaaaaaaaaa


        spinner_phone.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                more_joziat_melk_edari_tejari_tasisat_tasisat_edit = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });

        spiner_pish_sell_mizan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                price_shrayet_sell_cheng_mizan_anjam_shode = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });
        spinner_wc_IR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                more_joziat_melk_edari_tejari_wc_wc_irani = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner_wc_EN.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                more_joziat_melk_edari_tejari_wc_wc_us = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });


        spinner_wc_bath.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                more_joziat_melk_edari_tejari_wc_bath = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });

        spinner_have_kabinet_badane.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                more_joziat_melk_edari_tejari_kitchen_badane_kabinet = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });

        spinner_have_kabinet_roye.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });


        spinner_have_kabinet_safhe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                more_joziat_melk_edari_tejari_kitchen_roye_kabinet = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });


        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                moshakhasat_asli_melk_moghiat_build = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });
        Fine_HoMe_checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (ST_noe_bana) {
                    case "مسکونی":
                        if (Fine_HoMe_checkBox2.isChecked() == true) {
                            RadioGP.setVisibility(View.VISIBLE);
                            Fine_HoMe_checkBox_have_kabinet.setVisibility(View.VISIBLE);
                            Fine_HoMe_checkBox_have_tajhizat_kitchen.setVisibility(View.VISIBLE);
                            more_joziat_melk_edari_tejari_kitchen_kitchen_check = "a:1:{i:0;s:27:\"دارای آشپزخانه\";}";
                        } else {
                            RadioGP.setVisibility(View.GONE);
                            Fine_HoMe_checkBox_have_kabinet.setVisibility(View.GONE);
                            Fine_HoMe_checkBox_have_tajhizat_kitchen.setVisibility(View.GONE);
                            more_joziat_melk_edari_tejari_kitchen_kitchen_check = "";
                        }
                        break;
                    case "اداری":
                        if (Fine_HoMe_checkBox2.isChecked() == true) {
                            RadioGP.setVisibility(View.VISIBLE);
                            Fine_HoMe_checkBox_have_kabinet.setVisibility(View.VISIBLE);
                            Fine_HoMe_checkBox_have_tajhizat_kitchen.setVisibility(View.VISIBLE);
                        } else {
                            RadioGP.setVisibility(View.GONE);
                            Fine_HoMe_checkBox_have_kabinet.setVisibility(View.GONE);
                            Fine_HoMe_checkBox_have_tajhizat_kitchen.setVisibility(View.GONE);
                        }
                        break;
                }


            }
        });


        //ccccccccccccccccc

        spinner_dong.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });

        spinner_noe_malekati.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        });


        Fine_HoMe_checkBox87.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Fine_HoMe_checkBox87.isChecked() == true) {
                    more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = "a:1:{i:0;s:29:\"سند در دست اقدام\";}";
                } else {
                    more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = "";

                }
            }
        });


        checkBox8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox8.isChecked() == true) {
                    more_joziat_melk_edari_tejari_kitchen_abdarkhane = "a:1:{i:0;s:29:\"دارای آبدارخانه\";}";
                } else {
                    more_joziat_melk_edari_tejari_kitchen_abdarkhane = "";

                }
            }
        });

        checkBox7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox7.isChecked() == true) {
                    more_joziat_melk_edari_tejari_kitchen_ghazakhori = "a:1:{i:0;s:29:\"دارای غذاخوری\";}";
                } else {
                    more_joziat_melk_edari_tejari_kitchen_ghazakhori = "";

                }
            }
        });

        checkBox9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox9.isChecked() == true) {
                    counter_nma++;
                    checkBox9ST = "NotNULL";
                } else {
                    counter_nma--;
                    checkBox9ST = "";
                    Vulue4 = more_joziat_melk_edari_tejari_nama_nama_check;

                }
            }

        });

        checkBox15.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox15.isChecked() == true) {
                    counter_safe++;
                    checkBox15ST = "NotNULL";
                } else {
                    counter_safe--;
                    checkBox15ST = "";
                    Vulue9 = more_joziat_melk_edari_tejari_refahi_refahi_check;

                }
            }
        });

        checkBox16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox16.isChecked() == true) {
                    counter_safe++;
                    checkBox16ST = "NotNULL";
                } else {
                    counter_safe--;
                    checkBox16ST = "";
                    Vulue9 = more_joziat_melk_edari_tejari_refahi_refahi_check;

                }
            }
        });

        checkBox10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox10.isChecked() == true) {
                    counter_tasisat++;
                    checkBox10ST = "NotNULL";
                } else {
                    counter_tasisat--;
                    checkBox10ST = "";
                    Vulue15 = more_joziat_melk_edari_tejari_tasisat_tasisat_check;

                }
            }
        });

        checkBox11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox11.isChecked() == true) {
                    counter_NoeSarGhofli++;
                    checkBox11ST = "NotNULL";
                } else {
                    counter_NoeSarGhofli--;
                    checkBox11ST = "";
                    Vulue16 = "";

                }
            }
        });

        checkBox12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox12.isChecked() == true) {
                    counter_NoeSarGhofli++;
                    checkBox12ST = "NotNULL";
                } else {
                    counter_NoeSarGhofli--;
                    checkBox12ST = "";
                    Vulue16 = "";

                }
            }
        });

        checkBox13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox13.isChecked() == true) {
                    more_joziat_melk_edari_tejari_abdarhkane_tejari = "a:1:{i:0;s:29:\"آبدارخانه\";}";
                } else {
                    more_joziat_melk_edari_tejari_abdarhkane_tejari = "";

                }
            }
        });


        checkBox26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox26.isChecked() == true) {
                    counter_KarbariPishnahadi++;
                    checkBox26ST = "NotNULL";
                } else {
                    counter_KarbariPishnahadi--;
                    checkBox26ST = "";
                    Vulue17 = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;

                }
            }
        });


        checkBox27.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox27.isChecked() == true) {
                    counter_KarbariPishnahadi++;
                    checkBox27ST = "NotNULL";
                } else {
                    counter_KarbariPishnahadi--;
                    checkBox27ST = "";
                    Vulue17 = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;

                }
            }
        });


        checkBox28.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox28.isChecked() == true) {
                    counter_KarbariPishnahadi++;
                    checkBox28ST = "NotNULL";
                } else {
                    counter_KarbariPishnahadi--;
                    checkBox28ST = "";
                    Vulue17 = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;

                }
            }
        });


        checkBox29.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox29.isChecked() == true) {
                    counter_KarbariPishnahadi++;
                    checkBox29ST = "NotNULL";
                } else {
                    counter_KarbariPishnahadi--;
                    checkBox29ST = "";
                    Vulue17 = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;

                }
            }
        });


        checkBox30.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox30.isChecked() == true) {
                    counter_KarbariPishnahadi++;
                    checkBox30ST = "NotNULL";
                } else {
                    counter_KarbariPishnahadi--;
                    checkBox30ST = "";
                    Vulue17 = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;

                }
            }
        });


        checkBox31.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox31.isChecked() == true) {
                    counter_KarbariPishnahadi++;
                    checkBox31ST = "NotNULL";
                } else {
                    counter_KarbariPishnahadi--;
                    checkBox31ST = "";
                    Vulue17 = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;

                }
            }
        });

        checkBox32.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox32.isChecked() == true) {
                    counter_KarbariPishnahadi++;
                    checkBox32ST = "NotNULL";
                } else {
                    counter_KarbariPishnahadi--;
                    checkBox32ST = "";
                    Vulue17 = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;

                }
            }
        });


        checkBox39.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox39.isChecked() == true) {
                    counter_KarbariPishnahadi++;
                    checkBox39ST = "NotNULL";
                } else {
                    counter_KarbariPishnahadi--;
                    checkBox39ST = "";
                    Vulue17 = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;

                }
            }
        });


        checkBox40.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox40.isChecked() == true) {
                    counter_KarbariPishnahadi++;
                    checkBox40ST = "NotNULL";
                } else {
                    counter_KarbariPishnahadi--;
                    checkBox40ST = "";
                    Vulue17 = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;

                }
            }
        });


        checkBox88.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox88.isChecked() == true) {
                    counter_KarbariPishnahadi++;
                    checkBox88ST = "NotNULL";
                } else {
                    counter_KarbariPishnahadi--;
                    checkBox88ST = "";
                    Vulue17 = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;

                }
            }
        });


        checkBox89.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox89.isChecked() == true) {
                    counter_KarbariPishnahadi++;
                    checkBox89ST = "NotNULL";
                } else {
                    counter_KarbariPishnahadi--;
                    checkBox89ST = "";
                    Vulue17 = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;

                }
            }
        });


        checkBox90.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox90.isChecked() == true) {
                    counter_KarbariPishnahadi++;
                    checkBox90ST = "NotNULL";
                } else {
                    counter_KarbariPishnahadi--;
                    checkBox90ST = "";
                    Vulue17 = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;

                }
            }
        });


        checkBox91.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox91.isChecked() == true) {
                    counter_KarbariPishnahadi++;
                    checkBox91ST = "NotNULL";
                } else {
                    counter_KarbariPishnahadi--;
                    checkBox91ST = "";
                    Vulue17 = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;

                }
            }
        });
        checkBox21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox21.isChecked() == true) {
                    counter_dastresi++;
                    checkBox21ST = "NotNULL";
                } else {
                    counter_dastresi--;
                    checkBox21ST = "";
                    Vulue18 = more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta;

                }
            }
        });

        checkBox23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox23.isChecked() == true) {
                    counter_dastresi++;
                    checkBox23ST = "NotNULL";
                } else {
                    counter_dastresi--;
                    checkBox23ST = "";
                    Vulue18 = more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta;

                }
            }
        });

        checkBox24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox24.isChecked() == true) {
                    counter_dastresi++;
                    checkBox24ST = "NotNULL";
                } else {
                    counter_dastresi--;
                    checkBox24ST = "";
                    Vulue18 = more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta;

                }
            }
        });

        checkBox25.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox25.isChecked() == true) {
                    counter_dastresi++;
                    checkBox25ST = "NotNULL";
                } else {
                    counter_dastresi--;
                    checkBox25ST = "";
                    Vulue18 = more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta;

                }
            }
        });

        checkBox93.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox93.isChecked() == true) {
                    counter_dastresi++;
                    checkBox93ST = "NotNULL";
                } else {
                    counter_dastresi--;
                    checkBox93ST = "";
                    Vulue18 = more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta;

                }
            }
        });

        checkBox94.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox94.isChecked() == true) {
                    counter_dastresi++;
                    checkBox94ST = "NotNULL";
                } else {
                    counter_dastresi--;
                    checkBox94ST = "";
                    Vulue18 = more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta;

                }
            }
        });

        checkBox22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox22.isChecked() == true) {
                    counter_dastresi++;
                    checkBox22ST = "NotNULL";
                } else {
                    counter_dastresi--;
                    checkBox22ST = "";
                    Vulue18 = more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta;

                }
            }
        });

        checkBox17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox17.isChecked() == true) {
                    counter_NoeVaghzari++;
                    checkBox17ST = "NotNULL";
                } else {
                    counter_NoeVaghzari--;
                    checkBox17ST = "";
                    Vulue19 = moshakhasat_asli_melk_vaziita_build_vazita_zamin;

                }
            }
        });

        checkBox18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox18.isChecked() == true) {
                    counter_NoeVaghzari++;
                    checkBox18ST = "NotNULL";
                } else {
                    counter_NoeVaghzari--;
                    checkBox18ST = "";
                    Vulue19 = moshakhasat_asli_melk_vaziita_build_vazita_zamin;

                }
            }
        });

        checkBox19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox19.isChecked() == true) {
                    counter_NoeVaghzari++;
                    checkBox19ST = "NotNULL";
                } else {
                    counter_NoeVaghzari--;
                    checkBox19ST = "";
                    Vulue19 = moshakhasat_asli_melk_vaziita_build_vazita_zamin;

                }
            }
        });

//-------------------------------------------------------------------------------------------------------------------------------- send

        editText = (EditText) findViewById(R.id.editText);
        barchasbEdit = (EditText) findViewById(R.id.barchasbEdit);
        final TextView textView4 = (TextView) findViewById(R.id.textView4);


        button123123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String a = barchasbEdit.getText().toString();
                a = a.replace("\n", ",");
                a = a.replace("،", ",");
                barchasbEdit.setText(a + "");


                new Connecttest("http://padintarh.ir/Android/barchasb.php", a,"").execute();


/*
nameOfimage();
                dialog = ProgressDialog.show(Main26Activity.this, "", "Uploading file...", true);
                new Thread(new Runnable() {
                    public void run() {
                        runOnUiThread(new Runnable() {
                            public void run() {

                            }
                        });
                        if (str_1tp != "" && str_1tp != null) {
                            uploadFile(str_1tp);
                            uploadFile(str_1tp_150x150);
                            uploadFile(str_1tp_300x300);
                        }
                        if (str_2tp != "" && str_2tp != null) {
                            uploadFile(str_2tp);
                            uploadFile(str_2tp_150x150);
                            uploadFile(str_2tp_300x300);
                        }
                        if (str_3tp != "" && str_3tp != null) {
                            uploadFile(str_3tp);
                            uploadFile(str_3tp_150x150);
                            uploadFile(str_3tp_300x300);
                        }
                        if (str_4tp != "" && str_4tp != null) {
                            uploadFile(str_4tp);
                            uploadFile(str_4tp_150x150);
                            uploadFile(str_4tp_300x300);
                        }
                        if (str_5tp != "" && str_5tp != null) {
                            uploadFile(str_5tp);
                            uploadFile(str_5tp_150x150);
                            uploadFile(str_5tp_300x300);
                        }
                        if (str_6tp != "" && str_6tp != null) {
                            uploadFile(str_6tp);
                            uploadFile(str_6tp_150x150);
                            uploadFile(str_6tp_300x300);
                        }
                        if (str_7tp != "" && str_7tp != null) {
                            uploadFile(str_7tp);
                            uploadFile(str_7tp_150x150);
                            uploadFile(str_7tp_300x300);
                        }
                        if (str_8tp != "" && str_8tp != null) {
                            uploadFile(str_8tp);
                            uploadFile(str_8tp_150x150);
                            uploadFile(str_8tp_300x300);
                        }
                        if (str_9tp != "" && str_9tp != null) {
                            uploadFile(str_9tp);
                            uploadFile(str_9tp_150x150);
                            uploadFile(str_9tp_300x300);
                        }
                        if (str_10tp != "" && str_10tp != null) {
                            uploadFile(str_10tp);
                            uploadFile(str_10tp_150x150);
                            uploadFile(str_10tp_300x300);
                        }

                    }
                }).start();
*/
/*
                if (ID_send == 0) {
                    switch (ST_noe_bana) {
                        case "مسکونی":
                            swichSendMaskoni();

                            SendNewPostConnectMaskoni();
                            break;
                        case "اداری":
                            swichSendEdari();
                            SendNewPostConnectEdari();
                            break;
                        case "تجاری":
                            swichSendTejari();
                            SendNewPostConnectTejari();
                            break;
                        case "مستغلات":
                            swichSendMostaghelat();
                            SendNewPostConnectMostaghelat();
                            break;
                        case "زمین":
                            swichSendZamin();
                            SendNewPostConnectZamin();
                            break;
                    }

                } else {
                    switch (ST_noe_bana) {
                        case "مسکونی":
                            swichSendMaskoni();
                            EditSendPostConnectMaskoni();
                            break;
                        case "اداری":
                            swichSendEdari();
                            EditSendPostConnectEdari();
                            break;
                        case "تجاری":
                            swichSendTejari();
                            EditSendPostConnectTejari();
                            break;
                        case "مستغلات":
                            swichSendMostaghelat();
                            EditSendPostConnectMostaghelat();
                            break;
                        case "زمین":
                            swichSendZamin();
                            EditSendPostConnectZamin();
                            break;
                    }
                }
*/


            }
        });

//------------------------------------------- take pic

        takePic_finhome_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_1tp = "";
                witchPic = 1;
                AlertDialogTakePic();
            }
        });

        takePic_finhome_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_2tp = "";
                witchPic = 2;
                AlertDialogTakePic();
            }
        });

        takePic_finhome_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_3tp = "";
                witchPic = 3;
                AlertDialogTakePic();
            }
        });

        takePic_finhome_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_4tp = "";
                witchPic = 4;
                AlertDialogTakePic();
            }
        });

        takePic_finhome_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_5tp = "";
                witchPic = 5;
                AlertDialogTakePic();
            }
        });

        takePic_finhome_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_6tp = "";
                witchPic = 6;
                AlertDialogTakePic();
            }
        });

        takePic_finhome_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_7tp = "";
                witchPic = 7;
                AlertDialogTakePic();
            }
        });

        takePic_finhome_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_8tp = "";
                witchPic = 8;
                AlertDialogTakePic();
            }
        });

        takePic_finhome_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_9tp = "";
                witchPic = 9;
                AlertDialogTakePic();
            }
        });

        takePic_finhome_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_10tp = "";
                witchPic = 10;
                AlertDialogTakePic();
            }
        });

        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateYM = new SimpleDateFormat("yyyy/MM");
        STdateYM = dateYM.format(date);


//-------------------------------------------came form mainActivity EDITE_PAGE


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ID_send = extras.getInt("ID_send123");
        }
        Toast.makeText(Main26Activity.this, ID_send + "", Toast.LENGTH_SHORT).show();

        listView_ShowPost = (ListView) findViewById(R.id.listView_ShowPost);
        button12 = (Button) findViewById(R.id.button12);


        new Connect2("http://padintarh.ir/Android/noemelkfinder.php", ID_send, "").execute();
        new Connect2("http://padintarh.ir/Android/noemelkfinder.php", ID_send, "").execute();


        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (noe_MELK_android123 == "") {
                    new Connect2("http://padintarh.ir/Android/noemelkfinder.php", ID_send, "").execute();
                    new Connect2("http://padintarh.ir/Android/noemelkfinder.php", ID_send, "").execute();
                    GetjsonarrayFINDER();

                }

                Toast.makeText(Main26Activity.this, noe_MELK_android123+"aaaa", Toast.LENGTH_SHORT).show();

                if (noe_MELK_android123 != "") {
                    switch (noe_MELK_android123) {

                        case "مسکونی (خانه)":
                            new Connect4("http://padintarh.ir/Android/show_postMASK.php", ID_send).execute();
                            new Connect4("http://padintarh.ir/Android/show_postMASK.php", ID_send).execute();
                            GetjsonarrayMASKONI();
                            Toast.makeText(Main26Activity.this, "مسکونی اجرا میشود", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(Main26Activity.this, "ریدی حاجی", Toast.LENGTH_SHORT).show();

                    }

                }
                // Toast.makeText(Main26Activity.this, dataServer23 + "", Toast.LENGTH_SHORT).show();


            }
        });


        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner_noe_dael.setSelection(1);
            }
        });
//////////////////////////////////////////////////////////////////////////////////////////////// end of onCreat
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


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                ID = jsonObject1.getInt("ID");
                content = jsonObject1.getString("post_content");
                title = jsonObject1.getString("post_title");
                guid11 = jsonObject1.getString("guid11");
                _noe_melk_moamele = jsonObject1.getString("noe_melk_moamele");
                _noe_melk = jsonObject1.getString("noe_melk");
                _moshakhasat_asli_melk_noe_bana = jsonObject1.getString("moshakhasat_asli_melk_noe_bana");
                _moshakhasat_asli_melk_masahat_build = jsonObject1.getString("moshakhasat_asli_melk_masahat_build");
                _moshakhasat_asli_melk_masahat_zamin = jsonObject1.getString("moshakhasat_asli_melk_masahat_zamin");
                _moshakhasat_asli_melk_number_room = jsonObject1.getString("moshakhasat_asli_melk_number_room");
                _moshakhasat_asli_melk_number_parking = jsonObject1.getString("moshakhasat_asli_melk_number_parking");
                _moshakhasat_asli_melk_sale_build = jsonObject1.getString("moshakhasat_asli_melk_sale_build");
                _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = jsonObject1.getString("moshakhasat_asli_melk_vaziita_build_vaziita_build_radio");
                if (_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio.toString() == "کلنگی") {
                    _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = jsonObject1.getString("moshakhasat_asli_melk_vaziita_build_ghabel_sokonat");
                } else if (_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio.toString() == "چند سال ساخت") {
                    _moshakhasat_asli_melk_vaziita_build_rebuild = jsonObject1.getString("moshakhasat_asli_melk_vaziita_build_rebuild");
                }
                if (_noe_melk_moamele.toString() == "فروش، پیش فروش، معاوضه") {
                    _price_shrayet_sell_cheng_price_all_sell_cheng = jsonObject1.getString("price_shrayet_sell_cheng_price_all_sell_cheng");
                    _price_shrayet_sell_cheng_check_seel_cheng = jsonObject1.getString("price_shrayet_sell_cheng_check_seel_cheng");
                    _price_shrayet_sell_cheng_max_money = jsonObject1.getString("price_shrayet_sell_cheng_max_money");
                    _price_shrayet_sell_cheng_money_pish_pay = jsonObject1.getString("price_shrayet_sell_cheng_money_pish_pay");
                    _price_shrayet_sell_cheng_time_tahvil = jsonObject1.getString("price_shrayet_sell_cheng_time_tahvil");
                    _price_shrayet_sell_cheng_mizan_anjam_shode = jsonObject1.getString("price_shrayet_sell_cheng_mizan_anjam_shode");
                    _price_shrayet_sell_cheng_mizan_vam = jsonObject1.getString("price_shrayet_sell_cheng_mizan_vam");
                    _price_shrayet_sell_cheng_sod_vam = jsonObject1.getString("price_shrayet_sell_cheng_sod_vam");
                    _price_shrayet_sell_cheng_number_ghest = jsonObject1.getString("price_shrayet_sell_cheng_number_ghest");
                    _price_shrayet_sell_cheng_price_har_ghest = jsonObject1.getString("price_shrayet_sell_cheng_price_har_ghest");
                    _price_shrayet_sell_cheng_price_rahn = jsonObject1.getString("price_shrayet_sell_cheng_price_rahn");
                } else {
                    _price_shrayet_rent_price_vadie = jsonObject1.getString("price_shrayet_rent_price_vadie");
                    _price_shrayet_rent_price_ajare_mohiane = jsonObject1.getString("price_shrayet_rent_price_ajare_mohiane");
                }
                _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = jsonObject1.getString("more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe");
                _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = jsonObject1.getString("more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe");
                _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = jsonObject1.getString("more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe");
                _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = jsonObject1.getString("more_joziat_melk_edari_tejari_moghit_build_number_all_vahed");
                _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = jsonObject1.getString("more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build");
                _more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari = jsonObject1.getString("more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari");
                _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari = jsonObject1.getString("more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari");
                _more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon = jsonObject1.getString("more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon");
                _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon = jsonObject1.getString("more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon");
                _more_joziat_melk_edari_tejari_wc_wc_irani = jsonObject1.getString("more_joziat_melk_edari_tejari_wc_wc_irani");
                _more_joziat_melk_edari_tejari_wc_wc_us = jsonObject1.getString("more_joziat_melk_edari_tejari_wc_wc_us");
                _more_joziat_melk_edari_tejari_wc_bath = jsonObject1.getString("more_joziat_melk_edari_tejari_wc_bath");
                _more_joziat_melk_edari_tejari_kitchen_kitchen_check = jsonObject1.getString("more_joziat_melk_edari_tejari_kitchen_kitchen_check");
                _more_joziat_melk_edari_tejari_kitchen_kitchen_radio = jsonObject1.getString("more_joziat_melk_edari_tejari_kitchen_kitchen_radio");
                _more_joziat_melk_edari_tejari_kitchen_darai_kabinet = jsonObject1.getString("more_joziat_melk_edari_tejari_kitchen_darai_kabinet");
                _more_joziat_melk_edari_tejari_kitchen_badane_kabinet = jsonObject1.getString("more_joziat_melk_edari_tejari_kitchen_badane_kabinet");
                _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = jsonObject1.getString("more_joziat_melk_edari_tejari_kitchen_safhe_kabinet");
                _more_joziat_melk_edari_tejari_kitchen_roye_kabinet = jsonObject1.getString("more_joziat_melk_edari_tejari_kitchen_roye_kabinet");
                _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen = jsonObject1.getString("more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen");
                _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen = jsonObject1.getString("more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen");
                _more_joziat_melk_edari_tejari_neshiman_neshiman_check = jsonObject1.getString("more_joziat_melk_edari_tejari_neshiman_neshiman_check");
                _more_joziat_melk_edari_tejari_neshiman_neshiman_edit = jsonObject1.getString("more_joziat_melk_edari_tejari_neshiman_neshiman_edit");
                _more_joziat_melk_edari_tejari_shekle_build_radio = jsonObject1.getString("more_joziat_melk_edari_tejari_shekle_build_radio");
                _more_joziat_melk_edari_tejari_nama_nama_check = jsonObject1.getString("more_joziat_melk_edari_tejari_nama_nama_check");
                _more_joziat_melk_edari_tejari_nama_nama_edit = jsonObject1.getString("more_joziat_melk_edari_tejari_nama_nama_edit");
                _more_joziat_melk_edari_tejari_eskelet_eskelet_check = jsonObject1.getString("more_joziat_melk_edari_tejari_eskelet_eskelet_check");
                _more_joziat_melk_edari_tejari_eskelet_eskelet_edit = jsonObject1.getString("more_joziat_melk_edari_tejari_eskelet_eskelet_edit");
                _more_joziat_melk_edari_tejari_kaf_kaf_check = jsonObject1.getString("more_joziat_melk_edari_tejari_kaf_kaf_check");
                _more_joziat_melk_edari_tejari_kaf_kaf_edit = jsonObject1.getString("more_joziat_melk_edari_tejari_kaf_kaf_edit");
                _more_joziat_melk_edari_tejari_divar_divar_check = jsonObject1.getString("more_joziat_melk_edari_tejari_divar_divar_check");
                _more_joziat_melk_edari_tejari_divar_divar_edit = jsonObject1.getString("more_joziat_melk_edari_tejari_divar_divar_edit");
                _more_joziat_melk_edari_tejari_coldhot_coldhot_check = jsonObject1.getString("more_joziat_melk_edari_tejari_coldhot_coldhot_check");
                _more_joziat_melk_edari_tejari_coldhot_coldhot_edit = jsonObject1.getString("more_joziat_melk_edari_tejari_coldhot_coldhot_edit");
                _more_joziat_melk_edari_tejari_refahi_refahi_check = jsonObject1.getString("more_joziat_melk_edari_tejari_refahi_refahi_check");
                _more_joziat_melk_edari_tejari_refahi_refahi_edit = jsonObject1.getString("more_joziat_melk_edari_tejari_refahi_refahi_edit");
                _more_joziat_melk_edari_tejari_safe_safe_check = jsonObject1.getString("more_joziat_melk_edari_tejari_safe_safe_check");
                _more_joziat_melk_edari_tejari_safe_safe_edit = jsonObject1.getString("more_joziat_melk_edari_tejari_safe_safe_edit");
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = jsonObject1.getString("more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta");
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = jsonObject1.getString("more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit");
                _more_joziat_melk_edari_tejari_sport_sport_check = jsonObject1.getString("more_joziat_melk_edari_tejari_sport_sport_check");
                _more_joziat_melk_edari_tejari_sport_sport_edit = jsonObject1.getString("more_joziat_melk_edari_tejari_sport_sport_edit");
                _more_joziat_melk_edari_tejari_view_view_check = jsonObject1.getString("more_joziat_melk_edari_tejari_view_view_check");
                _more_joziat_melk_edari_tejari_view_view_edit = jsonObject1.getString("more_joziat_melk_edari_tejari_view_view_edit");
                _more_joziat_melk_edari_tejari_nor_nor_check = jsonObject1.getString("more_joziat_melk_edari_tejari_nor_nor_check");
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check = jsonObject1.getString("more_joziat_melk_edari_tejari_tasisat_tasisat_check");
                _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = jsonObject1.getString("more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = jsonObject1.getString("more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = jsonObject1.getString("more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = jsonObject1.getString("more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        switch (_noe_melk_moamele.toString()) {
            case "فروش، پیش فروش، معاوضه":
                spinner_noe_dael.setSelection(1);
                break;
            case "رهن و اجاره":
                spinner_noe_dael.setSelection(2);
                break;
        }

        switch (_noe_melk.toString()) {
            case "مسکونی (خانه)":
                spinner_noe_melk.setSelection(1);
                break;
            case "اداری (دفترکار)":
                spinner_noe_melk.setSelection(2);
                break;
            case "تجاری (مغازه)":
                spinner_noe_melk.setSelection(3);
                break;
            case "مستفلات (کل ملک و زمین)":
                spinner_noe_melk.setSelection(4);
                break;
            case "زمین":
                spinner_noe_melk.setSelection(5);
                break;

        }
        switch (_moshakhasat_asli_melk_noe_bana.toString()) {
            case "یک واحد آپارتمانی":
                spinner_noe_bana.setSelection(1);
                break;
            case "یک طبقه از خانه دو یا سه طبقه":
                spinner_noe_bana.setSelection(2);
                break;
            case "ویلایی":
                spinner_noe_bana.setSelection(3);
                break;

        }

        Find_HoMe_editText_masahat_made.setText(_moshakhasat_asli_melk_masahat_build.toString());
        Find_HoMe_editText_masahat_ground.setText(_moshakhasat_asli_melk_masahat_zamin.toString());

        switch (_moshakhasat_asli_melk_number_room.toString()) {
            case "صفر":
                spinner_num_room.setSelection(1);
                break;
            case "1":
                spinner_num_room.setSelection(2);
                break;
            case "2":
                spinner_num_room.setSelection(3);
                break;
            case "3":
                spinner_num_room.setSelection(4);
                break;
            case "4":
                spinner_num_room.setSelection(5);
                break;
            case "5":
                spinner_num_room.setSelection(6);
                break;
            case "6":
                spinner_num_room.setSelection(7);
                break;
            case "7":
                spinner_num_room.setSelection(8);
                break;
            case "8":
                spinner_num_room.setSelection(9);
                break;
            case "9":
                spinner_num_room.setSelection(10);
                break;
            case "10":
                spinner_num_room.setSelection(11);
                break;
            case "بیشتر از10":
                spinner_num_room.setSelection(12);
                break;
        }

        switch (_moshakhasat_asli_melk_number_parking.toString()) {
            case "صفر":
                spinner_num_parking.setSelection(1);
                break;
            case "1":
                spinner_num_parking.setSelection(2);
                break;
            case "2":
                spinner_num_parking.setSelection(3);
                break;
            case "3":
                spinner_num_parking.setSelection(4);
                break;
            case "4":
                spinner_num_parking.setSelection(5);
                break;
            case "5":
                spinner_num_parking.setSelection(6);
                break;
            case "6":
                spinner_num_parking.setSelection(7);
                break;
            case "7":
                spinner_num_parking.setSelection(8);
                break;
            case "8":
                spinner_num_parking.setSelection(9);
                break;
            case "9":
                spinner_num_parking.setSelection(10);
                break;
            case "10":
                spinner_num_parking.setSelection(11);
                break;
            case "بیشتر از10":
                spinner_num_parking.setSelection(12);
                break;
        }

        Find_HoMe_editText_year_made.setText(_moshakhasat_asli_melk_sale_build.toString());

        if (_noe_melk_moamele.toString() == "فروش، پیش فروش، معاوضه") {
            Find_HoMe_editText_price_deal.setText(_price_shrayet_sell_cheng_price_all_sell_cheng.toString());

            String _price_shrayet_sell_cheng_check_seel_cheng1 = "";
            String _price_shrayet_sell_cheng_check_seel_cheng2 = "";
            String str2 = _price_shrayet_sell_cheng_check_seel_cheng.toString();
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
                        b = b + "\n" + "معاوضه";
                        Fine_HoMe_checkBox_moaveze.setChecked(true);
                        Find_HoMe_editText_moaveze.setText(_price_shrayet_sell_cheng_max_money.toString());
                    }
                    Boolean found2 = a.contains("پیش فروش");
                    if (found2 == true) {
                        b = b + "\n" + "پیش فروش";
                        Fine_HoMe_checkBox_pish_sell.setChecked(true);
                        Find_HoMe_editText_pish_sell_price.setText(_price_shrayet_sell_cheng_money_pish_pay.toString());
                        Find_HoMe_editText_pish_sell_time.setText(_price_shrayet_sell_cheng_time_tahvil.toString());

                        switch (_price_shrayet_sell_cheng_mizan_anjam_shode.toString()) {
                            case "10درصد":
                                spiner_pish_sell_mizan.setSelection(1);
                                break;
                            case "20درصد":
                                spiner_pish_sell_mizan.setSelection(2);
                                break;
                            case "30درصد":
                                spiner_pish_sell_mizan.setSelection(3);
                                break;
                            case "40درصد":
                                spiner_pish_sell_mizan.setSelection(4);
                                break;
                            case "50درصد":
                                spiner_pish_sell_mizan.setSelection(5);
                                break;
                            case "60درصد":
                                spiner_pish_sell_mizan.setSelection(6);
                                break;
                            case "70درصد":
                                spiner_pish_sell_mizan.setSelection(7);
                                break;
                            case "80درصد":
                                spiner_pish_sell_mizan.setSelection(8);
                                break;
                            case "90درصد":
                                spiner_pish_sell_mizan.setSelection(9);
                                break;
                        }
                    }
                    Boolean found3 = a.contains("دارای وام");
                    if (found3 == true) {
                        b = b + "\n" + "دارای وام";
                        Fine_HoMe_checkBox_vam.setChecked(true);
                        Find_HoMe_editText_vam_mizan.setText(_price_shrayet_sell_cheng_mizan_vam.toString());
                        Find_HoMe_editText_vam_sod.setText(_price_shrayet_sell_cheng_sod_vam.toString());
                        Find_HoMe_editText_vam_num_ghest.setText(_price_shrayet_sell_cheng_number_ghest.toString());
                        Find_HoMe_editText_vam_num_ghest2.setText(_price_shrayet_sell_cheng_price_har_ghest.toString());
                    }
                    Boolean found4 = a.contains("فروش با مستاجر");
                    if (found4 == true) {
                        b = b + "\n" + "فروش با مستاجر";
                        Fine_HoMe_checkBox_sell_with_moshtari.setChecked(true);
                        Find_HoMe_editText_sell_with_moshtari.setText(_price_shrayet_sell_cheng_price_rahn.toString());
                    }
                }
            }
        } else {
            editText_rahnVadie.setText(_price_shrayet_rent_price_vadie.toString());
            editText_rahnEjare.setText(_price_shrayet_rent_price_ajare_mohiane.toString());
        }


        Find_HoMe_editText.setText(_more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe.toString());
        Find_HoMe_editText2.setText(_more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe.toString());
        Find_HoMe_editText3.setText(_more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe.toString());
        Find_HoMe_editText4.setText(_more_joziat_melk_edari_tejari_moghit_build_number_all_vahed.toString());


        String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build1 = "";
        String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build2 = "";
        String str3 = _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build.toString();
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
                    Fine_HoMe_checkBox123.setChecked(true);
                }
            }
        }


        Find_HoMe_editText5.setText(_more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari.toString());
        Find_HoMe_editText6.setText(_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari.toString());
        Find_HoMe_editText7.setText(_more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon.toString());
        Find_HoMe_editText8.setText(_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon.toString());

        switch (_more_joziat_melk_edari_tejari_wc_wc_irani.toString()) {
            case "ندارد":
                spinner_wc_IR.setSelection(1);
                break;
            case "1عدد":
                spinner_wc_IR.setSelection(2);
                break;
            case "2عدد":
                spinner_wc_IR.setSelection(3);
                break;
            case "3عدد":
                spinner_wc_IR.setSelection(4);
                break;
            case "4عدد":
                spinner_wc_IR.setSelection(5);
                break;
            case "5عدد":
                spinner_wc_IR.setSelection(6);
                break;
            case "6عدد":
                spinner_wc_IR.setSelection(7);
                break;
            case "بیشتر از 6عدد":
                spinner_wc_IR.setSelection(8);
                break;

        }


        switch (_more_joziat_melk_edari_tejari_wc_wc_us.toString()) {
            case "ندارد":
                spinner_wc_EN.setSelection(1);
                break;
            case "1عدد":
                spinner_wc_EN.setSelection(2);
                break;
            case "2عدد":
                spinner_wc_EN.setSelection(3);
                break;
            case "3عدد":
                spinner_wc_EN.setSelection(4);
                break;
            case "4عدد":
                spinner_wc_EN.setSelection(5);
                break;
            case "5عدد":
                spinner_wc_EN.setSelection(6);
                break;
            case "6عدد":
                spinner_wc_EN.setSelection(7);
                break;
            case "بیشتر از 6عدد":
                spinner_wc_EN.setSelection(8);
                break;

        }

        switch (_more_joziat_melk_edari_tejari_wc_bath.toString()) {
            case "ندارد":
                spinner_wc_bath.setSelection(1);
                break;
            case "1عدد":
                spinner_wc_bath.setSelection(2);
                break;
            case "2عدد":
                spinner_wc_bath.setSelection(3);
                break;
            case "3عدد":
                spinner_wc_bath.setSelection(4);
                break;
            case "4عدد":
                spinner_wc_bath.setSelection(5);
                break;
            case "5عدد":
                spinner_wc_bath.setSelection(6);
                break;
            case "6عدد":
                spinner_wc_bath.setSelection(7);
                break;
            case "بیشتر از 6عدد":
                spinner_wc_bath.setSelection(8);
                break;

        }


        String _more_joziat_melk_edari_tejari_kitchen_kitchen_check1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_kitchen_check2 = "";
        String str4 = _more_joziat_melk_edari_tejari_kitchen_kitchen_check.toString();
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
                    Fine_HoMe_checkBox2.setChecked(true);
                }
            }
        }
        switch (_more_joziat_melk_edari_tejari_kitchen_kitchen_radio.toString()) {
            case "اپن":
                radioButton_FindHome.setChecked(true);
                break;
            case "نیمه اپن":
                radioButton2_FindHome.setChecked(true);
                break;
            case "بسته":
                radioButton3_FindHome.setChecked(true);
                break;
            case "مشترک":
                radioButton4_FindHome.setChecked(true);
                break;

        }

        String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet2 = "";
        String str5 = _more_joziat_melk_edari_tejari_kitchen_darai_kabinet.toString();
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
                    Fine_HoMe_checkBox_have_kabinet.setChecked(true);
                }
            }
        }


        switch (_more_joziat_melk_edari_tejari_kitchen_badane_kabinet.toString()) {
            case "ام دی اف":
                spinner_have_kabinet_badane.setSelection(1);
                break;
            case "نئوپان":
                spinner_have_kabinet_badane.setSelection(2);
                break;
            case "پلی وود":
                spinner_have_kabinet_badane.setSelection(3);
                break;
            case "فلزی":
                spinner_have_kabinet_badane.setSelection(4);
                break;
            case "چوبی":
                spinner_have_kabinet_badane.setSelection(5);
                break;


        }

        switch (_more_joziat_melk_edari_tejari_kitchen_roye_kabinet.toString()) {
            case "ام دی اف":
                spinner_have_kabinet_roye.setSelection(1);
                break;
            case "ملامینه":
                spinner_have_kabinet_roye.setSelection(2);
                break;
            case "HPL":
                spinner_have_kabinet_roye.setSelection(3);
                break;
            case "PVC":
                spinner_have_kabinet_roye.setSelection(4);
                break;
            case "فلزی":
                spinner_have_kabinet_roye.setSelection(5);
                break;
            case "کاغذی":
                spinner_have_kabinet_roye.setSelection(6);
                break;


        }

        switch (_more_joziat_melk_edari_tejari_kitchen_safhe_kabinet.toString()) {
            case "ام دی اف":
                spinner_have_kabinet_safhe.setSelection(1);
                break;
            case "نئوپان":
                spinner_have_kabinet_safhe.setSelection(2);
                break;
            case "پلی وود":
                spinner_have_kabinet_safhe.setSelection(3);
                break;
            case "سنگ":
                spinner_have_kabinet_safhe.setSelection(4);
                break;
            case "سنگ مصنوعی":
                spinner_have_kabinet_safhe.setSelection(5);
                break;


        }

        String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen2 = "";
        String str6 = _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen.toString();
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
                    Fine_HoMe_checkBox_have_tajhizat_kitchen.setChecked(true);
                }
            }

        }


        Find_HoMe_editText10.setText(_more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen.toString());


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
                    b = b + "\n" + "بتنی";
                    Fine_HoMe_checkBox13.setChecked(true);
                }
                Boolean found2 = a.contains("فلزی");
                if (found2 == true) {
                    b = b + "\n" + "فلزی";
                    Fine_HoMe_checkBox15.setChecked(true);
                }
                Boolean found3 = a.contains("آجی");
                if (found3 == true) {
                    b = b + "\n" + "آجی";
                    Fine_HoMe_checkBox14.setChecked(true);
                }
                Boolean found4 = a.contains("چوبی");
                if (found4 == true) {
                    b = b + "\n" + "چوبی";
                    Fine_HoMe_checkBox16.setChecked(true);
                }
            }
        }


        Find_HoMe_editText12.setText(_more_joziat_melk_edari_tejari_eskelet_eskelet_edit.toString());


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
                    b = b + "\n" + "سنگ";
                    Fine_HoMe_checkBox17.setChecked(true);
                }
                Boolean found2 = a.contains("سرامیک");
                if (found2 == true) {
                    b = b + "\n" + "سرامیک";
                    Fine_HoMe_checkBox18.setChecked(true);
                }
                Boolean found3 = a.contains("پارکت");
                if (found3 == true) {
                    b = b + "\n" + "پارکت";
                    Fine_HoMe_checkBox19.setChecked(true);
                }
                Boolean found4 = a.contains("کفپوش");
                if (found4 == true) {
                    b = b + "\n" + "کفپوش";
                    Fine_HoMe_checkBox20.setChecked(true);
                }
                Boolean found5 = a.contains("موکت");
                if (found5 == true) {
                    b = b + "\n" + "موکت";
                    Fine_HoMe_checkBox21.setChecked(true);
                }
                Boolean found6 = a.contains("موزاییک");
                if (found6 == true) {
                    b = b + "\n" + "موزاییک";
                    Fine_HoMe_checkBox22.setChecked(true);
                }
                Boolean found7 = a.contains("سیمان");
                if (found7 == true) {
                    b = b + "\n" + "سیمان";
                    Fine_HoMe_checkBox23.setChecked(true);
                }
                Boolean found8 = a.contains("کف پله دار");
                if (found8 == true) {
                    b = b + "\n" + "کف پله دار";
                    Fine_HoMe_checkBox24.setChecked(true);
                }
            }

        }

        Find_HoMe_editText13.setText(_more_joziat_melk_edari_tejari_kaf_kaf_edit.toString());


        String _more_joziat_melk_edari_tejari_neshiman_neshiman_check1 = "";
        String _more_joziat_melk_edari_tejari_neshiman_neshiman_check2 = "";
        String str7 = _more_joziat_melk_edari_tejari_neshiman_neshiman_check.toString();
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
                    Fine_HoMe_checkBox3.setChecked(true);
                }
                Boolean found2 = a.contains("سقف بالای 4 متر");
                if (found2 == true) {
                    b = b + "\n" + "سقف بالای 4 متر";
                    Fine_HoMe_checkBox4.setChecked(true);
                }
                Boolean found3 = a.contains("مبله");
                if (found3 == true) {
                    b = b + "\n" + "مبله";
                    Fine_HoMe_checkBox_neshiman_moble.setChecked(true);
                    Find_HoMe_editText9.setText(_more_joziat_melk_edari_tejari_neshiman_neshiman_edit.toString());


                }
            }
        }

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
                    b = b + "\n" + "سنگ";
                    Fine_HoMe_checkBox10.setChecked(true);

                }
                Boolean found2 = a.contains("آجر");
                if (found2 == true) {
                    b = b + "\n" + "آجر";
                    Fine_HoMe_checkBox12.setChecked(true);

                }
                Boolean found3 = a.contains("سیمان");
                if (found3 == true) {
                    b = b + "\n" + "سیمان";
                    Fine_HoMe_checkBox11.setChecked(true);

                }
                Boolean found4 = a.contains("شیشه");
                if (found4 == true) {
                    b = b + "\n" + "شیشه";
                    Fine_HoMe_checkBox8.setChecked(true);

                }
                Boolean found5 = a.contains("چوب");
                if (found5 == true) {
                    b = b + "\n" + "چوب";
                    Fine_HoMe_checkBox9.setChecked(true);

                }
                Boolean found6 = a.contains("کامپوزیت");
                if (found6 == true) {
                    b = b + "\n" + "کامپوزیت";
                    Fine_HoMe_checkBox7.setChecked(true);

                }
                Boolean found7 = a.contains("نورپردازی");
                if (found7 == true) {
                    b = b + "\n" + "نورپردازی";
                    Fine_HoMe_checkBox6.setChecked(true);

                }
            }
        } else {
        }


        Find_HoMe_editText11.setText(_more_joziat_melk_edari_tejari_nama_nama_edit.toString());

        Find_HoMe_editText12.setText(_more_joziat_melk_edari_tejari_eskelet_eskelet_edit.toString());

        Find_HoMe_editText13.setText(_more_joziat_melk_edari_tejari_kaf_kaf_edit.toString());

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
                    b = b + "\n" + "سنگ";
                    Fine_HoMe_checkBox25.setChecked(true);
                }
                Boolean found9 = a.contains("رنگ");
                if (found9 == true) {
                    b = b + "\n" + "رنگ";
                    Fine_HoMe_checkBox26.setChecked(true);
                }
                Boolean found2 = a.contains("کاشی/ سرامیک");
                if (found2 == true) {
                    b = b + "\n" + "کاشی/ سرامیک";
                    Fine_HoMe_checkBox27.setChecked(true);
                }
                Boolean found3 = a.contains("کاغذ دیواری");
                if (found3 == true) {
                    b = b + "\n" + "کاغذ دیواری";
                    Fine_HoMe_checkBox28.setChecked(true);
                }
                Boolean found4 = a.contains("چوب/ دیوارکوب");
                if (found4 == true) {
                    b = b + "\n" + "چوب/ دیوارکوب";
                    Fine_HoMe_checkBox29.setChecked(true);
                }
                Boolean found5 = a.contains("سیمان");
                if (found5 == true) {
                    b = b + "\n" + "سیمان";
                    Fine_HoMe_checkBox31.setChecked(true);
                }
                Boolean found6 = a.contains("گچ");
                if (found6 == true) {
                    b = b + "\n" + "گچ";
                    Fine_HoMe_checkBox30.setChecked(true);
                }
                Boolean found7 = a.contains("آجر");
                if (found7 == true) {
                    b = b + "\n" + "آجر";
                    Fine_HoMe_checkBox32.setChecked(true);
                }
            }

        }

        Find_HoMe_editText14.setText(_more_joziat_melk_edari_tejari_divar_divar_edit.toString());

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
                    b = b + "\n" + "کولر";
                    Fine_HoMe_checkBox341.setChecked(true);
                }
                Boolean found2 = a.contains("کولرگازی/ اسپلیت");
                if (found2 == true) {
                    b = b + "\n" + "کولرگازی/ اسپلیت";
                    Fine_HoMe_checkBox331.setChecked(true);
                }
                Boolean found3 = a.contains("بخاری");
                if (found3 == true) {
                    b = b + "\n" + "بخاری";
                    Fine_HoMe_checkBox351.setChecked(true);
                }
                Boolean found4 = a.contains("پکیج/ رادیاتور");
                if (found4 == true) {
                    b = b + "\n" + "پکیج/ رادیاتور";
                    Fine_HoMe_checkBox361.setChecked(true);
                }
                Boolean found5 = a.contains("دیگ/ رادیاتور");
                if (found5 == true) {
                    b = b + "\n" + "دیگ/ رادیاتور";
                    Fine_HoMe_checkBox371.setChecked(true);
                }
                Boolean found6 = a.contains("چیلر/ فن کوئل");
                if (found6 == true) {
                    b = b + "\n" + "چیلر/ فن کوئل";
                    Fine_HoMe_checkBox381.setChecked(true);
                }
                Boolean found7 = a.contains("آبگرمکن خورشیدی");
                if (found7 == true) {
                    b = b + "\n" + "آبگرمکن خورشیدی";
                    Fine_HoMe_checkBox39.setChecked(true);
                }
                Boolean found79 = a.contains("هواساز");
                if (found79 == true) {
                    b = b + "\n" + "هواساز";
                    Fine_HoMe_checkBox40.setChecked(true);
                }
            }
        }

        Find_HoMe_editText151.setText(_more_joziat_melk_edari_tejari_coldhot_coldhot_edit.toString());

        String _more_joziat_melk_edari_tejari_refahi_refahi_check1 = "";
        String _more_joziat_melk_edari_tejari_refahi_refahi_check2 = "";
        String str14 = _more_joziat_melk_edari_tejari_refahi_refahi_check.toString();
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
                    Fine_HoMe_checkBox33.setChecked(true);
                }
                Boolean found2 = a.contains("درب پارکینگ ریموت دار");
                if (found2 == true) {
                    b = b + "\n" + "درب پارکینگ ریموت دار";
                    Fine_HoMe_checkBox34.setChecked(true);
                }
                Boolean found3 = a.contains("شوتیگ زباله");
                if (found3 == true) {
                    b = b + "\n" + "شوتیگ زباله";
                    Fine_HoMe_checkBox35.setChecked(true);
                }
                Boolean found4 = a.contains("اینترنت پرسرعت");
                if (found4 == true) {
                    b = b + "\n" + "اینترنت پرسرعت";
                    Fine_HoMe_checkBox37.setChecked(true);
                }
                Boolean found5 = a.contains("آنتن مزکزی");
                if (found5 == true) {
                    b = b + "\n" + "آنتن مزکزی";
                    Fine_HoMe_checkBox36.setChecked(true);
                }
                Boolean found6 = a.contains("شبکه داخلی");
                if (found6 == true) {
                    b = b + "\n" + "شبکه داخلی";
                    Fine_HoMe_checkBox38.setChecked(true);
                }
            }
        }

        Find_HoMe_editText15.setText(_more_joziat_melk_edari_tejari_refahi_refahi_edit.toString());

        String _more_joziat_melk_edari_tejari_safe_safe_check1 = "";
        String _more_joziat_melk_edari_tejari_safe_safe_check2 = "";
        String str15 = _more_joziat_melk_edari_tejari_safe_safe_check.toString();
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
                    Fine_HoMe_checkBox41.setChecked(true);
                }
                Boolean found2 = a.contains("دوربین مداربسته");
                if (found2 == true) {
                    b = b + "\n" + "دوربین مداربسته";
                    Fine_HoMe_checkBox42.setChecked(true);
                }
                Boolean found3 = a.contains("آیفون تصویری");
                if (found3 == true) {
                    b = b + "\n" + "آیفون تصویری";
                    Fine_HoMe_checkBox43.setChecked(true);
                }
                Boolean found4 = a.contains("درب ضد سرقت");
                if (found4 == true) {
                    b = b + "\n" + "درب ضد سرقت";
                    Fine_HoMe_checkBox44.setChecked(true);
                }
                Boolean found5 = a.contains("سیستم اعلام آتش");
                if (found5 == true) {
                    b = b + "\n" + "سیستم اعلام آتش";
                    Fine_HoMe_checkBox45.setChecked(true);
                }
                Boolean found6 = a.contains("سیستم اطفاء حریق");
                if (found6 == true) {
                    b = b + "\n" + "سیستم اطفاء حریق";
                    Fine_HoMe_checkBox46.setChecked(true);
                }
            }
        } else {
        }

        Find_HoMe_editText16.setText(_more_joziat_melk_edari_tejari_safe_safe_edit.toString());

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
                    b = b + "\n" + "حیاط";
                    Fine_HoMe_checkBox53.setChecked(true);
                }
                Boolean found2 = a.contains("حیاط خلوت");
                if (found2 == true) {
                    b = b + "\n" + "حیاط خلوت";
                    Fine_HoMe_checkBox47.setChecked(true);
                }
                Boolean found3 = a.contains("فضای سبز");
                if (found3 == true) {
                    b = b + "\n" + "فضای سبز";
                    Fine_HoMe_checkBox54.setChecked(true);
                }
                Boolean found4 = a.contains("سرایداری");
                if (found4 == true) {
                    b = b + "\n" + "سرایداری";
                    Fine_HoMe_checkBox48.setChecked(true);
                }
                Boolean found5 = a.contains("نگهبانی");
                if (found5 == true) {
                    b = b + "\n" + "نگهبانی";
                    Fine_HoMe_checkBox55.setChecked(true);
                }
                Boolean found6 = a.contains("لابی");
                if (found6 == true) {
                    b = b + "\n" + "لابی";
                    Fine_HoMe_checkBox49.setChecked(true);
                }
                Boolean found62 = a.contains("سالن اجتماعات");
                if (found62 == true) {
                    b = b + "\n" + "سالن اجتماعات";
                    Fine_HoMe_checkBox56.setChecked(true);
                }
                Boolean found61 = a.contains("باغ");
                if (found61 == true) {
                    b = b + "\n" + "باغ";
                    Fine_HoMe_checkBox50.setChecked(true);
                }
                Boolean found60 = a.contains("آلاچیق");
                if (found60 == true) {
                    b = b + "\n" + "آلاچیق";
                    Fine_HoMe_checkBox57.setChecked(true);
                }
                Boolean found69 = a.contains("آب نما");
                if (found69 == true) {
                    b = b + "\n" + "آب نما";
                    Fine_HoMe_checkBox51.setChecked(true);
                }
                Boolean found68 = a.contains("بام سبز");
                if (found68 == true) {
                    b = b + "\n" + "بام سبز";
                    Fine_HoMe_checkBox58.setChecked(true);
                }
                Boolean found67 = a.contains("باربیکیو");
                if (found67 == true) {
                    b = b + "\n" + "باربیکیو";
                    Fine_HoMe_checkBox52.setChecked(true);
                }
            }
        }

        Find_HoMe_editText17.setText(_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit.toString());

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
                    b = b + "\n" + "استخر";
                    Fine_HoMe_checkBox59.setChecked(true);
                }
                Boolean found2 = a.contains("سونا");
                if (found2 == true) {
                    b = b + "\n" + "سونا";
                    Fine_HoMe_checkBox60.setChecked(true);
                }
                Boolean found3 = a.contains("جوزی");
                if (found3 == true) {
                    b = b + "\n" + "جوزی";
                    Fine_HoMe_checkBox61.setChecked(true);
                }
                Boolean found4 = a.contains("بیلیارد");
                if (found4 == true) {
                    b = b + "\n" + "بیلیارد";
                    Fine_HoMe_checkBox62.setChecked(true);
                }
                Boolean found5 = a.contains("فوتبال");
                if (found5 == true) {
                    b = b + "\n" + "فوتبال";
                    Fine_HoMe_checkBox63.setChecked(true);
                }
                Boolean found6 = a.contains("بسکتبال");
                if (found6 == true) {
                    b = b + "\n" + "بسکتبال";
                    Fine_HoMe_checkBox64.setChecked(true);
                }
                Boolean found61 = a.contains("والیبال");
                if (found61 == true) {
                    b = b + "\n" + "والیبال";
                    Fine_HoMe_checkBox65.setChecked(true);
                }
                Boolean found62 = a.contains("تنیس");
                if (found62 == true) {
                    b = b + "\n" + "تنیس";
                    Fine_HoMe_checkBox66.setChecked(true);
                }
                Boolean found63 = a.contains("پینگ پنگ");
                if (found63 == true) {
                    b = b + "\n" + "پینگ پنگ";
                    Fine_HoMe_checkBox67.setChecked(true);
                }
                Boolean found64 = a.contains("سالن بدن سازی");
                if (found64 == true) {
                    b = b + "\n" + "سالن بدن سازی";
                    Fine_HoMe_checkBox68.setChecked(true);
                }
                Boolean found65 = a.contains("زمین بازی کودکان");
                if (found65 == true) {
                    b = b + "\n" + "زمین بازی کودکان";
                    Fine_HoMe_checkBox69.setChecked(true);
                }
                Boolean found66 = a.contains("اسکواش");
                if (found66 == true) {
                    b = b + "\n" + "اسکواش";
                    Fine_HoMe_checkBox70.setChecked(true);
                }
            }
        }


        Find_HoMe_editText18.setText(_more_joziat_melk_edari_tejari_sport_sport_edit.toString());

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
                    b = b + "\n" + "شهر";
                    Fine_HoMe_checkBox71.setChecked(true);
                }
                Boolean found2 = a.contains("اتوبان");
                if (found2 == true) {
                    b = b + "\n" + "اتوبان";
                    Fine_HoMe_checkBox72.setChecked(true);
                }
                Boolean found3 = a.contains("خیابان");
                if (found3 == true) {
                    b = b + "\n" + "خیابان";
                    Fine_HoMe_checkBox73.setChecked(true);
                }
                Boolean found4 = a.contains("کوچه");
                if (found4 == true) {
                    b = b + "\n" + "کوچه";
                    Fine_HoMe_checkBox74.setChecked(true);
                }
                Boolean found5 = a.contains("دریا");
                if (found5 == true) {
                    b = b + "\n" + "دریا";
                    Fine_HoMe_checkBox75.setChecked(true);
                }
                Boolean found6 = a.contains("جنگل");
                if (found6 == true) {
                    b = b + "\n" + "جنگل";
                    Fine_HoMe_checkBox76.setChecked(true);
                }
                Boolean found7 = a.contains("کوه");
                if (found7 == true) {
                    b = b + "\n" + "کوه";
                    Fine_HoMe_checkBox77.setChecked(true);
                }
                Boolean found71 = a.contains("باغ");
                if (found71 == true) {
                    b = b + "\n" + "باغ";
                    Fine_HoMe_checkBox78.setChecked(true);
                }
            }
        }

        Find_HoMe_editText19.setText(_more_joziat_melk_edari_tejari_view_view_edit.toString());

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
                    b = b + "\n" + "شمال";
                    Fine_HoMe_checkBox79.setChecked(true);
                }
                Boolean found2 = a.contains("جنوب");
                if (found2 == true) {
                    b = b + "\n" + "جنوب";
                    Fine_HoMe_checkBox80.setChecked(true);
                }
                Boolean found3 = a.contains("شرق");
                if (found3 == true) {
                    b = b + "\n" + "شرق";
                    Fine_HoMe_checkBox81.setChecked(true);
                }
                Boolean found4 = a.contains("غرب");
                if (found4 == true) {
                    b = b + "\n" + "غرب";
                    Fine_HoMe_checkBox82.setChecked(true);
                }
            }
        }

        String _more_joziat_melk_edari_tejari_tasisat_tasisat_check1 = "";
        String _more_joziat_melk_edari_tejari_tasisat_tasisat_check2 = "";
        String str21 = _more_joziat_melk_edari_tejari_tasisat_tasisat_check.toString();
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
                    Fine_HoMe_checkBox83.setChecked(true);
                }
                Boolean found2 = a.contains("برق");
                if (found2 == true) {
                    b = b + "\n" + "برق";
                    Fine_HoMe_checkBox84.setChecked(true);
                }
                Boolean found3 = a.contains("گاز");
                if (found3 == true) {
                    b = b + "\n" + "گاز";
                    Fine_HoMe_checkBox85.setChecked(true);
                }
                Boolean found4 = a.contains("ژنراتور برقی");
                if (found4 == true) {
                    b = b + "\n" + "ژنراتور برقی";
                    Fine_HoMe_checkBox86.setChecked(true);
                }
            }
        }
        switch (_more_joziat_melk_edari_tejari_tasisat_tasisat_edit.toString()) {
            case "ندارد":
                spinner_phone.setSelection(1);
                break;
            case "1خط":
                spinner_phone.setSelection(2);
                break;
            case "2خط":
                spinner_phone.setSelection(3);
                break;
            case "3خط":
                spinner_phone.setSelection(4);
                break;
            case "4خط":
                spinner_phone.setSelection(5);
                break;
            case "5خط":
                spinner_phone.setSelection(6);
                break;
            case "6خط":
                spinner_phone.setSelection(7);
                break;
            case "بیشتر از6خط":
                spinner_phone.setSelection(8);
                break;

        }

        switch (_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat.toString()) {

            case "نیم دانگ":
                spinner_phone.setSelection(1);
                break;
            case "1 دانگ":
                spinner_phone.setSelection(2);
                break;
            case "1/5 دانگ":
                spinner_phone.setSelection(3);
                break;
            case "2 دانگ":
                spinner_phone.setSelection(4);
                break;
            case "2/5 دانگ":
                spinner_phone.setSelection(5);
                break;
            case "3 دانگ":
                spinner_phone.setSelection(6);
                break;
            case "3/5 دانگ":
                spinner_phone.setSelection(7);
                break;
            case "4 دانگ":
                spinner_phone.setSelection(8);
                break;
            case "4/5 دانگ":
                spinner_phone.setSelection(9);
                break;
            case "5 دانگ":
                spinner_phone.setSelection(10);
                break;
            case "5/5 دانگ":
                spinner_phone.setSelection(11);
                break;
            case "6 دانگ":
                spinner_phone.setSelection(12);
                break;

        }

        switch (_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat.toString()) {

            case "سند رسمی(قطعی)":
                spinner_noe_malekati.setSelection(1);
                break;
            case "قولنامه ای":
                spinner_noe_malekati.setSelection(2);
                break;
            case "وکالتی":
                spinner_noe_malekati.setSelection(3);
                break;
            case "مبایعه نامه ای":
                spinner_noe_malekati.setSelection(4);
                break;
            case "قراردادی":
                spinner_noe_malekati.setSelection(5);
                break;
            case "بنچاق":
                spinner_noe_malekati.setSelection(6);
                break;
            case "صلح نامه":
                spinner_noe_malekati.setSelection(7);
                break;
            case "زمین شهری":
                spinner_noe_malekati.setSelection(8);
                break;
            case "برگه حاک شرع":
                spinner_noe_malekati.setSelection(9);
                break;
            case "اوقاف":
                spinner_noe_malekati.setSelection(10);
                break;
            case "سازمانی":
                spinner_noe_malekati.setSelection(11);
                break;
            case "تعاونی":
                spinner_noe_malekati.setSelection(12);
                break;
            case "بنیاد شهید":
                spinner_noe_malekati.setSelection(13);
                break;
            case "شهرداری":
                spinner_noe_malekati.setSelection(14);
                break;
            case "صنایع دفاع":
                spinner_noe_malekati.setSelection(15);
                break;
            case "نامشخص":
                spinner_noe_malekati.setSelection(16);
                break;

        }


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
                    b = "سند در دست اقدام";
                    Fine_HoMe_checkBox87.setChecked(true);
                }
            }
        }


    }

    public void GetjsonarrayEDARI() {
        try {
            String dataServer3 = dataServer234;
            jsonArrayEDARI = new JSONArray(dataServer3);

            for (int i = 0; i < jsonArrayEDARI.length(); i++) {
                JSONObject jsonObject1 = jsonArrayEDARI.getJSONObject(i);

                ID = jsonObject1.getInt("ID");
                content = jsonObject1.getString("post_content");
                title = jsonObject1.getString("post_title");
                guid11 = jsonObject1.getString("guid11");
                _noe_melk_moamele = jsonObject1.getString("_noe_melk_moamele");
                _noe_melk = jsonObject1.getString("_noe_melk");
                _moshakhasat_asli_melk_noe_bana = jsonObject1.getString("_moshakhasat_asli_melk_noe_bana");
                _moshakhasat_asli_melk_masahat_build = jsonObject1.getString("_moshakhasat_asli_melk_masahat_build");
                _moshakhasat_asli_melk_masahat_zamin = jsonObject1.getString("_moshakhasat_asli_melk_masahat_zamin");
                _moshakhasat_asli_melk_number_room = jsonObject1.getString("_moshakhasat_asli_melk_number_room");
                _moshakhasat_asli_melk_number_parking = jsonObject1.getString("_moshakhasat_asli_melk_number_parking");
                _moshakhasat_asli_melk_sale_build = jsonObject1.getString("_moshakhasat_asli_melk_sale_build");
                _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio");
                //    _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_ghabel_sokonat");
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
                _more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe");
                _more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe");
                _more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe");
                _more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_number_all_vahed");
                _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build");
                //   _more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari");
                //   _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari");
                //   _more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon");
                //   _more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon");
                _more_joziat_melk_edari_tejari_wc_wc_irani = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_wc_irani");
                _more_joziat_melk_edari_tejari_wc_wc_us = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_wc_us");
                // _more_joziat_melk_edari_tejari_wc_bath = jsonObject1.getString("_more_joziat_melk_edari_tejari_wc_bath");
                _more_joziat_melk_edari_tejari_kitchen_kitchen_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_kitchen_check");
                _more_joziat_melk_edari_tejari_kitchen_kitchen_radio = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_kitchen_radio");
                _more_joziat_melk_edari_tejari_kitchen_darai_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_darai_kabinet");
                _more_joziat_melk_edari_tejari_kitchen_badane_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_badane_kabinet");
                _more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_safhe_kabinet");
                _more_joziat_melk_edari_tejari_kitchen_roye_kabinet = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_roye_kabinet");
                _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen");
                _more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen");
                //    _more_joziat_melk_edari_tejari_neshiman_neshiman_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_neshiman_neshiman_check");
                //    _more_joziat_melk_edari_tejari_neshiman_neshiman_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_neshiman_neshiman_edit");
                _more_joziat_melk_edari_tejari_shekle_build_radio = jsonObject1.getString("_more_joziat_melk_edari_tejari_shekle_build_radio");
                //  _more_joziat_melk_edari_tejari_nama_nama_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_check");
                _more_joziat_melk_edari_tejari_nama_nama_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_edit");
                // _more_joziat_melk_edari_tejari_eskelet_eskelet_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_eskelet_eskelet_check");
                //  _more_joziat_melk_edari_tejari_eskelet_eskelet_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_eskelet_eskelet_edit");
                //    _more_joziat_melk_edari_tejari_kaf_kaf_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf_kaf_check");
                //   _more_joziat_melk_edari_tejari_kaf_kaf_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf_kaf_edit");
                _more_joziat_melk_edari_tejari_divar_divar_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar_divar_check");
                _more_joziat_melk_edari_tejari_divar_divar_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar_divar_edit");
                _more_joziat_melk_edari_tejari_coldhot_coldhot_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_check");
                _more_joziat_melk_edari_tejari_coldhot_coldhot_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_coldhot_coldhot_edit");
                //  _more_joziat_melk_edari_tejari_refahi_refahi_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_check");
                _more_joziat_melk_edari_tejari_refahi_refahi_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_edit");
                //  _more_joziat_melk_edari_tejari_safe_safe_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_check");
                _more_joziat_melk_edari_tejari_safe_safe_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_edit");
                //   _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta");
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit");
                //  _more_joziat_melk_edari_tejari_sport_sport_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_sport_sport_check");
                //  _more_joziat_melk_edari_tejari_sport_sport_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_sport_sport_edit");
                _more_joziat_melk_edari_tejari_view_view_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_view_view_check");
                _more_joziat_melk_edari_tejari_view_view_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_view_view_edit");
                _more_joziat_melk_edari_tejari_nor_nor_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_nor_nor_check");
                //  _more_joziat_melk_edari_tejari_tasisat_tasisat_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_check");
                _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = jsonObject1.getString("_more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");
                _more_joziat_melk_edari_tejari_safe = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe");
                _more_joziat_melk_edari_tejari_emkanatBuild = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild");
                _more_joziat_melk_edari_tejari_divar = jsonObject1.getString("_more_joziat_melk_edari_tejari_divar");
                //   _more_joziat_melk_edari_tejari_kaf = jsonObject1.getString("_more_joziat_melk_edari_tejari_kaf");
                _more_joziat_melk_edari_tejari_shekle_build_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_shekle_build_check");
                _more_joziat_melk_edari_tejari_moghit_build = jsonObject1.getString("_more_joziat_melk_edari_tejari_moghit_build");
                _price_shrayet = jsonObject1.getString("_price_shrayet");
                _price_shrayet_sell_cheng_price_all_sell_cheng = jsonObject1.getString("_price_shrayet_sell_cheng_price_all_sell_cheng");


                _more_joziat_melk_edari_tejari_refahi_refahi_check_edari = jsonObject1.getString("_more_joziat_melk_edari_tejari_refahi_refahi_check_edari");
                _more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari");
                _more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta = jsonObject1.getString("_more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta");
                _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari = jsonObject1.getString("_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari");
                // _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari");
                _moshakhasat_asli_melk_vaziita_build_rebuild = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_rebuild");
                // _more_joziat_melk_edari_tejari_tozih_about_melk = jsonObject1.getString("_more_joziat_melk_edari_tejari_tozih_about_melk");
                _moshakhasat_asli_melk_moghiat_build = jsonObject1.getString("_moshakhasat_asli_melk_moghiat_build");
                _more_joziat_melk_edari_tejari_kitchen_abdarkhane = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_abdarkhane");
                _more_joziat_melk_edari_tejari_kitchen_ghazakhori = jsonObject1.getString("_more_joziat_melk_edari_tejari_kitchen_ghazakhori");
                _more_joziat_melk_edari_tejari_room_asli_room_asli_check = jsonObject1.getString("_more_joziat_melk_edari_tejari_room_asli_room_asli_check");
                _more_joziat_melk_edari_tejari_room_asli_room_asli_edit = jsonObject1.getString("_more_joziat_melk_edari_tejari_room_asli_room_asli_edit");
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari = jsonObject1.getString("_more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari");


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        switch (_noe_melk_moamele.toString()) {
            case "فروش، پیش فروش، معاوضه":
                spinner_noe_dael.setSelection(1);
                break;
            case "رهن و اجاره":
                spinner_noe_dael.setSelection(2);
                break;
        }

        switch (_noe_melk.toString()) {
            case "مسکونی (خانه)":
                spinner_noe_melk.setSelection(1);
                break;
            case "اداری (دفترکار)":
                spinner_noe_melk.setSelection(2);
                break;
            case "تجاری (مغازه)":
                spinner_noe_melk.setSelection(3);
                break;
            case "مستفلات (کل ملک و زمین)":
                spinner_noe_melk.setSelection(4);
                break;
            case "زمین":
                spinner_noe_melk.setSelection(5);
                break;

        }
        switch (_moshakhasat_asli_melk_noe_bana.toString()) {
            case "یک واحد آپارتمانی":
                spinner_noe_bana.setSelection(1);
                break;
            case "یک طبقه از خانه دو یا سه طبقه":
                spinner_noe_bana.setSelection(2);
                break;
            case "ویلایی":
                spinner_noe_bana.setSelection(3);
                break;

        }

        Find_HoMe_editText_masahat_made.setText(_moshakhasat_asli_melk_masahat_build.toString());
        Find_HoMe_editText_masahat_ground.setText(_moshakhasat_asli_melk_masahat_zamin.toString());

        switch (_moshakhasat_asli_melk_number_room.toString()) {
            case "صفر":
                spinner_num_room.setSelection(1);
                break;
            case "1":
                spinner_num_room.setSelection(2);
                break;
            case "2":
                spinner_num_room.setSelection(3);
                break;
            case "3":
                spinner_num_room.setSelection(4);
                break;
            case "4":
                spinner_num_room.setSelection(5);
                break;
            case "5":
                spinner_num_room.setSelection(6);
                break;
            case "6":
                spinner_num_room.setSelection(7);
                break;
            case "7":
                spinner_num_room.setSelection(8);
                break;
            case "8":
                spinner_num_room.setSelection(9);
                break;
            case "9":
                spinner_num_room.setSelection(10);
                break;
            case "10":
                spinner_num_room.setSelection(11);
                break;
            case "بیشتر از10":
                spinner_num_room.setSelection(12);
                break;
        }

        switch (_moshakhasat_asli_melk_number_parking.toString()) {
            case "صفر":
                spinner_num_parking.setSelection(1);
                break;
            case "1":
                spinner_num_parking.setSelection(2);
                break;
            case "2":
                spinner_num_parking.setSelection(3);
                break;
            case "3":
                spinner_num_parking.setSelection(4);
                break;
            case "4":
                spinner_num_parking.setSelection(5);
                break;
            case "5":
                spinner_num_parking.setSelection(6);
                break;
            case "6":
                spinner_num_parking.setSelection(7);
                break;
            case "7":
                spinner_num_parking.setSelection(8);
                break;
            case "8":
                spinner_num_parking.setSelection(9);
                break;
            case "9":
                spinner_num_parking.setSelection(10);
                break;
            case "10":
                spinner_num_parking.setSelection(11);
                break;
            case "بیشتر از10":
                spinner_num_parking.setSelection(12);
                break;
        }

        Find_HoMe_editText_year_made.setText(_moshakhasat_asli_melk_sale_build.toString());

        switch (_moshakhasat_asli_melk_moghiat_build.toString()) {
            case "ساختمان اداری با موقعیت اداری":
                spinner7.setSelection(1);
                break;
            case "ساختمان اداری با سند اداری":
                spinner7.setSelection(2);

                break;

        }
        Find_HoMe_editText_year_made.setText(_moshakhasat_asli_melk_sale_build.toString());
        Find_HoMe_editText_price_deal.setText(_price_shrayet_sell_cheng_price_all_sell_cheng.toString());


        if (_noe_melk_moamele.toString() == "فروش، پیش فروش، معاوضه") {
            Find_HoMe_editText_price_deal.setText(_price_shrayet_sell_cheng_price_all_sell_cheng.toString());

            String _price_shrayet_sell_cheng_check_seel_cheng1 = "";
            String _price_shrayet_sell_cheng_check_seel_cheng2 = "";
            String str2 = _price_shrayet_sell_cheng_check_seel_cheng.toString();
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
                        b = b + "\n" + "معاوضه";
                        Fine_HoMe_checkBox_moaveze.setChecked(true);
                        Find_HoMe_editText_moaveze.setText(_price_shrayet_sell_cheng_max_money.toString());
                    }
                    Boolean found2 = a.contains("پیش فروش");
                    if (found2 == true) {
                        b = b + "\n" + "پیش فروش";
                        Fine_HoMe_checkBox_pish_sell.setChecked(true);
                        Find_HoMe_editText_pish_sell_price.setText(_price_shrayet_sell_cheng_money_pish_pay.toString());
                        Find_HoMe_editText_pish_sell_time.setText(_price_shrayet_sell_cheng_time_tahvil.toString());

                        switch (_price_shrayet_sell_cheng_mizan_anjam_shode.toString()) {
                            case "10درصد":
                                spiner_pish_sell_mizan.setSelection(1);
                                break;
                            case "20درصد":
                                spiner_pish_sell_mizan.setSelection(2);
                                break;
                            case "30درصد":
                                spiner_pish_sell_mizan.setSelection(3);
                                break;
                            case "40درصد":
                                spiner_pish_sell_mizan.setSelection(4);
                                break;
                            case "50درصد":
                                spiner_pish_sell_mizan.setSelection(5);
                                break;
                            case "60درصد":
                                spiner_pish_sell_mizan.setSelection(6);
                                break;
                            case "70درصد":
                                spiner_pish_sell_mizan.setSelection(7);
                                break;
                            case "80درصد":
                                spiner_pish_sell_mizan.setSelection(8);
                                break;
                            case "90درصد":
                                spiner_pish_sell_mizan.setSelection(9);
                                break;
                        }
                    }
                    Boolean found3 = a.contains("دارای وام");
                    if (found3 == true) {
                        b = b + "\n" + "دارای وام";
                        Fine_HoMe_checkBox_vam.setChecked(true);
                        Find_HoMe_editText_vam_mizan.setText(_price_shrayet_sell_cheng_mizan_vam.toString());
                        Find_HoMe_editText_vam_sod.setText(_price_shrayet_sell_cheng_sod_vam.toString());
                        Find_HoMe_editText_vam_num_ghest.setText(_price_shrayet_sell_cheng_number_ghest.toString());
                        Find_HoMe_editText_vam_num_ghest2.setText(_price_shrayet_sell_cheng_price_har_ghest.toString());
                    }
                    Boolean found4 = a.contains("فروش با مستاجر");
                    if (found4 == true) {
                        b = b + "\n" + "فروش با مستاجر";
                        Fine_HoMe_checkBox_sell_with_moshtari.setChecked(true);
                        Find_HoMe_editText_sell_with_moshtari.setText(_price_shrayet_sell_cheng_price_rahn.toString());
                    }
                }
            }
        } else {
            editText_rahnVadie.setText(_price_shrayet_rent_price_vadie.toString());
            editText_rahnEjare.setText(_price_shrayet_rent_price_ajare_mohiane.toString());
        }
        Find_HoMe_editText.setText(_more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe.toString());
        Find_HoMe_editText2.setText(_more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe.toString());
        Find_HoMe_editText3.setText(_more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe.toString());
        Find_HoMe_editText4.setText(_more_joziat_melk_edari_tejari_moghit_build_number_all_vahed.toString());


        String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build1 = "";
        String _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build2 = "";
        String str3 = _more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build.toString();
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
                    Fine_HoMe_checkBox123.setChecked(true);
                }
            }
        }


        Find_HoMe_editText5.setText(_more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari.toString());
        Find_HoMe_editText6.setText(_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari.toString());
        Find_HoMe_editText7.setText(_more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon.toString());
        Find_HoMe_editText8.setText(_more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon.toString());

        switch (_more_joziat_melk_edari_tejari_wc_wc_irani.toString()) {
            case "ندارد":
                spinner_wc_IR.setSelection(1);
                break;
            case "1عدد":
                spinner_wc_IR.setSelection(2);
                break;
            case "2عدد":
                spinner_wc_IR.setSelection(3);
                break;
            case "3عدد":
                spinner_wc_IR.setSelection(4);
                break;
            case "4عدد":
                spinner_wc_IR.setSelection(5);
                break;
            case "5عدد":
                spinner_wc_IR.setSelection(6);
                break;
            case "6عدد":
                spinner_wc_IR.setSelection(7);
                break;
            case "بیشتر از 6عدد":
                spinner_wc_IR.setSelection(8);
                break;

        }


        switch (_more_joziat_melk_edari_tejari_wc_wc_us.toString()) {
            case "ندارد":
                spinner_wc_EN.setSelection(1);
                break;
            case "1عدد":
                spinner_wc_EN.setSelection(2);
                break;
            case "2عدد":
                spinner_wc_EN.setSelection(3);
                break;
            case "3عدد":
                spinner_wc_EN.setSelection(4);
                break;
            case "4عدد":
                spinner_wc_EN.setSelection(5);
                break;
            case "5عدد":
                spinner_wc_EN.setSelection(6);
                break;
            case "6عدد":
                spinner_wc_EN.setSelection(7);
                break;
            case "بیشتر از 6عدد":
                spinner_wc_EN.setSelection(8);
                break;

        }

        String _more_joziat_melk_edari_tejari_kitchen_kitchen_check1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_kitchen_check2 = "";
        String str4 = _more_joziat_melk_edari_tejari_kitchen_kitchen_check.toString();
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
                    Fine_HoMe_checkBox2.setChecked(true);
                }
            }
        }
        switch (_more_joziat_melk_edari_tejari_kitchen_kitchen_radio.toString()) {
            case "اپن":
                radioButton_FindHome.setChecked(true);
                break;
            case "نیمه اپن":
                radioButton2_FindHome.setChecked(true);
                break;
            case "بسته":
                radioButton3_FindHome.setChecked(true);
                break;
            case "مشترک":
                radioButton4_FindHome.setChecked(true);
                break;

        }

        String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_darai_kabinet2 = "";
        String str5 = _more_joziat_melk_edari_tejari_kitchen_darai_kabinet.toString();
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
                    Fine_HoMe_checkBox_have_kabinet.setChecked(true);
                }
            }
        }


        switch (_more_joziat_melk_edari_tejari_kitchen_badane_kabinet.toString()) {
            case "ام دی اف":
                spinner_have_kabinet_badane.setSelection(1);
                break;
            case "نئوپان":
                spinner_have_kabinet_badane.setSelection(2);
                break;
            case "پلی وود":
                spinner_have_kabinet_badane.setSelection(3);
                break;
            case "فلزی":
                spinner_have_kabinet_badane.setSelection(4);
                break;
            case "چوبی":
                spinner_have_kabinet_badane.setSelection(5);
                break;


        }

        switch (_more_joziat_melk_edari_tejari_kitchen_roye_kabinet.toString()) {
            case "ام دی اف":
                spinner_have_kabinet_roye.setSelection(1);
                break;
            case "ملامینه":
                spinner_have_kabinet_roye.setSelection(2);
                break;
            case "HPL":
                spinner_have_kabinet_roye.setSelection(3);
                break;
            case "PVC":
                spinner_have_kabinet_roye.setSelection(4);
                break;
            case "فلزی":
                spinner_have_kabinet_roye.setSelection(5);
                break;
            case "کاغذی":
                spinner_have_kabinet_roye.setSelection(6);
                break;


        }

        switch (_more_joziat_melk_edari_tejari_kitchen_safhe_kabinet.toString()) {
            case "ام دی اف":
                spinner_have_kabinet_safhe.setSelection(1);
                break;
            case "نئوپان":
                spinner_have_kabinet_safhe.setSelection(2);
                break;
            case "پلی وود":
                spinner_have_kabinet_safhe.setSelection(3);
                break;
            case "سنگ":
                spinner_have_kabinet_safhe.setSelection(4);
                break;
            case "سنگ مصنوعی":
                spinner_have_kabinet_safhe.setSelection(5);
                break;


        }

        String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen2 = "";
        String str6 = _more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen.toString();
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
                    Fine_HoMe_checkBox_have_tajhizat_kitchen.setChecked(true);
                }
            }

        }


        Find_HoMe_editText10.setText(_more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen.toString());


        String _more_joziat_melk_edari_tejari_kitchen_abdarkhane1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_abdarkhane2 = "";
        String str611 = _more_joziat_melk_edari_tejari_kitchen_abdarkhane.toString();
        if (str611 != "ندارد") {
            String[] splited = str611.split("\"");
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
                    b = "دارای آبدارخانه";
                    checkBox8.setChecked(true);
                }
            }

        }


        String _more_joziat_melk_edari_tejari_kitchen_ghazakhori1 = "";
        String _more_joziat_melk_edari_tejari_kitchen_ghazakhori2 = "";
        String str62 = _more_joziat_melk_edari_tejari_kitchen_ghazakhori.toString();
        if (str62 != "ندارد") {
            String[] splited = str62.split("\"");
            for (int i = 1; i < splited.length; i++) {
                _more_joziat_melk_edari_tejari_kitchen_ghazakhori1 = _more_joziat_melk_edari_tejari_kitchen_ghazakhori1 + " " + splited[i];
            }
            String aaa = "";
            splited = _more_joziat_melk_edari_tejari_kitchen_ghazakhori1.split(",");
            for (int ai = 0; ai < splited.length; ai++) {
                aaa = aaa + "\n" + splited[ai];
                aaa = aaa.replace("]", "");
            }
            String b = null, a;
            for (int ai = 0; ai < splited.length; ai++) {
                a = splited[ai];
                Boolean found = a.contains("دارای غذاخوری");
                if (found == true) {
                    b = "دارای غذاخوری";
                    checkBox7.setChecked(true);
                }
            }

        }


        String _more_joziat_melk_edari_tejari_neshiman_neshiman_check1 = "";
        String _more_joziat_melk_edari_tejari_neshiman_neshiman_check2 = "";
        String str7 = _more_joziat_melk_edari_tejari_room_asli_room_asli_check.toString();
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

                Boolean found2 = a.contains("سقف بالای 4 متر");
                if (found2 == true) {
                    b = b + "\n" + "سقف بالای 4 متر";
                    Fine_HoMe_checkBox4.setChecked(true);
                }
                Boolean found3 = a.contains("مبله");
                if (found3 == true) {
                    b = b + "\n" + "مبله";
                    Fine_HoMe_checkBox_neshiman_moble.setChecked(true);
                    Find_HoMe_editText9.setText(_more_joziat_melk_edari_tejari_room_asli_room_asli_edit.toString());


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
                    b = b + "\n" + "سنگ";
                    Fine_HoMe_checkBox10.setChecked(true);

                }
                Boolean found2 = a.contains("آجر");
                if (found2 == true) {
                    b = b + "\n" + "آجر";
                    Fine_HoMe_checkBox12.setChecked(true);

                }
                Boolean found3 = a.contains("سیمان");
                if (found3 == true) {
                    b = b + "\n" + "سیمان";
                    Fine_HoMe_checkBox11.setChecked(true);

                }
                Boolean found4 = a.contains("شیشه");
                if (found4 == true) {
                    b = b + "\n" + "شیشه";
                    Fine_HoMe_checkBox8.setChecked(true);

                }
                Boolean found5 = a.contains("چوب");
                if (found5 == true) {
                    b = b + "\n" + "چوب";
                    Fine_HoMe_checkBox9.setChecked(true);

                }
                Boolean found6 = a.contains("کامپوزیت");
                if (found6 == true) {
                    b = b + "\n" + "کامپوزیت";
                    Fine_HoMe_checkBox7.setChecked(true);

                }
                Boolean found7 = a.contains("نورپردازی");
                if (found7 == true) {
                    b = b + "\n" + "نورپردازی";
                    Fine_HoMe_checkBox6.setChecked(true);

                }
                Boolean found8 = a.contains("تابلو خور");
                if (found8 == true) {
                    b = b + "\n" + "تابلو خور";
                    checkBox9.setChecked(true);

                }
            }
        }
        Find_HoMe_editText11.setText(_more_joziat_melk_edari_tejari_nama_nama_edit.toString());

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
                    b = b + "\n" + "سنگ";
                    Fine_HoMe_checkBox25.setChecked(true);
                }
                Boolean found9 = a.contains("رنگ");
                if (found9 == true) {
                    b = b + "\n" + "رنگ";
                    Fine_HoMe_checkBox26.setChecked(true);
                }
                Boolean found2 = a.contains("کاشی/ سرامیک");
                if (found2 == true) {
                    b = b + "\n" + "کاشی/ سرامیک";
                    Fine_HoMe_checkBox27.setChecked(true);
                }
                Boolean found3 = a.contains("کاغذ دیواری");
                if (found3 == true) {
                    b = b + "\n" + "کاغذ دیواری";
                    Fine_HoMe_checkBox28.setChecked(true);
                }
                Boolean found4 = a.contains("چوب/ دیوارکوب");
                if (found4 == true) {
                    b = b + "\n" + "چوب/ دیوارکوب";
                    Fine_HoMe_checkBox29.setChecked(true);
                }
                Boolean found5 = a.contains("سیمان");
                if (found5 == true) {
                    b = b + "\n" + "سیمان";
                    Fine_HoMe_checkBox31.setChecked(true);
                }
                Boolean found6 = a.contains("گچ");
                if (found6 == true) {
                    b = b + "\n" + "گچ";
                    Fine_HoMe_checkBox30.setChecked(true);
                }
                Boolean found7 = a.contains("آجر");
                if (found7 == true) {
                    b = b + "\n" + "آجر";
                    Fine_HoMe_checkBox32.setChecked(true);
                }
            }

        }

        Find_HoMe_editText14.setText(_more_joziat_melk_edari_tejari_divar_divar_edit.toString());

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
                    b = b + "\n" + "کولر";
                    Fine_HoMe_checkBox341.setChecked(true);
                }
                Boolean found2 = a.contains("کولرگازی/ اسپلیت");
                if (found2 == true) {
                    b = b + "\n" + "کولرگازی/ اسپلیت";
                    Fine_HoMe_checkBox331.setChecked(true);
                }
                Boolean found3 = a.contains("بخاری");
                if (found3 == true) {
                    b = b + "\n" + "بخاری";
                    Fine_HoMe_checkBox351.setChecked(true);
                }
                Boolean found4 = a.contains("پکیج/ رادیاتور");
                if (found4 == true) {
                    b = b + "\n" + "پکیج/ رادیاتور";
                    Fine_HoMe_checkBox361.setChecked(true);
                }
                Boolean found5 = a.contains("دیگ/ رادیاتور");
                if (found5 == true) {
                    b = b + "\n" + "دیگ/ رادیاتور";
                    Fine_HoMe_checkBox371.setChecked(true);
                }
                Boolean found6 = a.contains("چیلر/ فن کوئل");
                if (found6 == true) {
                    b = b + "\n" + "چیلر/ فن کوئل";
                    Fine_HoMe_checkBox381.setChecked(true);
                }
                Boolean found7 = a.contains("آبگرمکن خورشیدی");
                if (found7 == true) {
                    b = b + "\n" + "آبگرمکن خورشیدی";
                    Fine_HoMe_checkBox39.setChecked(true);
                }
                Boolean found79 = a.contains("هواساز");
                if (found79 == true) {
                    b = b + "\n" + "هواساز";
                    Fine_HoMe_checkBox40.setChecked(true);
                }
            }
        }

        Find_HoMe_editText151.setText(_more_joziat_melk_edari_tejari_coldhot_coldhot_edit.toString());


        String _more_joziat_melk_edari_tejari_refahi_refahi_check_edari1 = "";
        String _more_joziat_melk_edari_tejari_refahi_refahi_check_edari2 = "";
        String str14 = _more_joziat_melk_edari_tejari_refahi_refahi_check_edari.toString();
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
                    b = b + "\n" + "آسانسور";
                    Fine_HoMe_checkBox33.setChecked(true);
                }

                Boolean found4 = a.contains("اینترنت پرسرعت");
                if (found4 == true) {
                    b = b + "\n" + "اینترنت پرسرعت";
                    Fine_HoMe_checkBox37.setChecked(true);
                }

                Boolean found6 = a.contains("شبکه داخلی");
                if (found6 == true) {
                    b = b + "\n" + "شبکه داخلی";
                    Fine_HoMe_checkBox38.setChecked(true);
                }
            }
        }

        Find_HoMe_editText15.setText(_more_joziat_melk_edari_tejari_refahi_refahi_edit.toString());

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
                    b = b + "\n" + "دزدگیر";
                    Fine_HoMe_checkBox41.setChecked(true);
                }
                Boolean found2 = a.contains("دوربین مداربسته");
                if (found2 == true) {
                    b = b + "\n" + "دوربین مداربسته";
                    Fine_HoMe_checkBox42.setChecked(true);
                }
                Boolean found3 = a.contains("آیفون تصویری");
                if (found3 == true) {
                    b = b + "\n" + "آیفون تصویری";
                    Fine_HoMe_checkBox43.setChecked(true);
                }
                Boolean found4 = a.contains("درب ضد سرقت");
                if (found4 == true) {
                    b = b + "\n" + "درب ضد سرقت";
                    Fine_HoMe_checkBox44.setChecked(true);
                }
                Boolean found5 = a.contains("سیستم اعلام آتش");
                if (found5 == true) {
                    b = b + "\n" + "سیستم اعلام آتش";
                    Fine_HoMe_checkBox45.setChecked(true);
                }
                Boolean found6 = a.contains("سیستم اطفاء حریق");
                if (found6 == true) {
                    b = b + "\n" + "سیستم اطفاء حریق";
                    Fine_HoMe_checkBox46.setChecked(true);
                }
                Boolean found7 = a.contains("گاوصندوق");
                if (found7 == true) {
                    b = b + "\n" + "گاوصندوق";
                    checkBox15.setChecked(true);
                }
            }
        }

        Find_HoMe_editText16.setText(_more_joziat_melk_edari_tejari_safe_safe_edit.toString());


        String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta1 = "";
        String _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta2 = "";
        String str16 = _more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_edari.toString();
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
                    Fine_HoMe_checkBox53.setChecked(true);
                }
                Boolean found2 = a.contains("حیاط خلوت");
                if (found2 == true) {
                    b = b + "\n" + "حیاط خلوت";
                    Fine_HoMe_checkBox47.setChecked(true);
                }
                Boolean found3 = a.contains("فضای سبز");
                if (found3 == true) {
                    b = b + "\n" + "فضای سبز";
                    Fine_HoMe_checkBox54.setChecked(true);
                }
                Boolean found4 = a.contains("سرایداری");
                if (found4 == true) {
                    b = b + "\n" + "سرایداری";
                    Fine_HoMe_checkBox48.setChecked(true);
                }
                Boolean found5 = a.contains("نگهبانی");
                if (found5 == true) {
                    b = b + "\n" + "نگهبانی";
                    Fine_HoMe_checkBox55.setChecked(true);
                }
                Boolean found6 = a.contains("لابی");
                if (found6 == true) {
                    b = b + "\n" + "لابی";
                    Fine_HoMe_checkBox49.setChecked(true);
                }
                Boolean found62 = a.contains("سالن اجتماعات");
                if (found62 == true) {
                    b = b + "\n" + "سالن اجتماعات";
                    Fine_HoMe_checkBox56.setChecked(true);
                }

            }
        }

        Find_HoMe_editText17.setText(_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit.toString());


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
                    b = b + "\n" + "شهر";
                    Fine_HoMe_checkBox71.setChecked(true);
                }
                Boolean found2 = a.contains("اتوبان");
                if (found2 == true) {
                    b = b + "\n" + "اتوبان";
                    Fine_HoMe_checkBox72.setChecked(true);
                }
                Boolean found3 = a.contains("خیابان");
                if (found3 == true) {
                    b = b + "\n" + "خیابان";
                    Fine_HoMe_checkBox73.setChecked(true);
                }
                Boolean found4 = a.contains("کوچه");
                if (found4 == true) {
                    b = b + "\n" + "کوچه";
                    Fine_HoMe_checkBox74.setChecked(true);
                }
                Boolean found5 = a.contains("دریا");
                if (found5 == true) {
                    b = b + "\n" + "دریا";
                    Fine_HoMe_checkBox75.setChecked(true);
                }
                Boolean found6 = a.contains("جنگل");
                if (found6 == true) {
                    b = b + "\n" + "جنگل";
                    Fine_HoMe_checkBox76.setChecked(true);
                }
                Boolean found7 = a.contains("کوه");
                if (found7 == true) {
                    b = b + "\n" + "کوه";
                    Fine_HoMe_checkBox77.setChecked(true);
                }
                Boolean found71 = a.contains("باغ");
                if (found71 == true) {
                    b = b + "\n" + "باغ";
                    Fine_HoMe_checkBox78.setChecked(true);
                }
            }
        }

        Find_HoMe_editText19.setText(_more_joziat_melk_edari_tejari_view_view_edit.toString());


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
                    b = b + "\n" + "شمال";
                    Fine_HoMe_checkBox79.setChecked(true);
                }
                Boolean found2 = a.contains("جنوب");
                if (found2 == true) {
                    b = b + "\n" + "جنوب";
                    Fine_HoMe_checkBox80.setChecked(true);
                }
                Boolean found3 = a.contains("شرق");
                if (found3 == true) {
                    b = b + "\n" + "شرق";
                    Fine_HoMe_checkBox81.setChecked(true);
                }
                Boolean found4 = a.contains("غرب");
                if (found4 == true) {
                    b = b + "\n" + "غرب";
                    Fine_HoMe_checkBox82.setChecked(true);
                }
            }
        }


        String _more_joziat_melk_edari_tejari_tasisat_tasisat_check1 = "";
        String _more_joziat_melk_edari_tejari_tasisat_tasisat_check2 = "";
        String str21 = _more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari.toString();
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
                    Fine_HoMe_checkBox83.setChecked(true);
                }
                Boolean found2 = a.contains("برق");
                if (found2 == true) {
                    b = b + "\n" + "برق";
                    Fine_HoMe_checkBox84.setChecked(true);
                }
                Boolean found3 = a.contains("گاز");
                if (found3 == true) {
                    b = b + "\n" + "گاز";
                    Fine_HoMe_checkBox85.setChecked(true);
                }
                Boolean found4 = a.contains("ژنراتور برقی");
                if (found4 == true) {
                    b = b + "\n" + "ژنراتور برقی";
                    Fine_HoMe_checkBox86.setChecked(true);
                }
                Boolean found45 = a.contains("منابع تغذیه برق");
                if (found45 == true) {
                    b = b + "\n" + "منابع تغذیه برق";
                    checkBox10.setChecked(true);
                }
            }
        }

        switch (_more_joziat_melk_edari_tejari_tasisat_tasisat_edit.toString()) {
            case "ندارد":
                spinner_phone.setSelection(1);
                break;
            case "1خط":
                spinner_phone.setSelection(2);
                break;
            case "2خط":
                spinner_phone.setSelection(3);
                break;
            case "3خط":
                spinner_phone.setSelection(4);
                break;
            case "4خط":
                spinner_phone.setSelection(5);
                break;
            case "5خط":
                spinner_phone.setSelection(6);
                break;
            case "6خط":
                spinner_phone.setSelection(7);
                break;
            case "بیشتر از6خط":
                spinner_phone.setSelection(8);
                break;

        }

        switch (_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat.toString()) {

            case "نیم دانگ":
                spinner_phone.setSelection(1);
                break;
            case "1 دانگ":
                spinner_phone.setSelection(2);
                break;
            case "1/5 دانگ":
                spinner_phone.setSelection(3);
                break;
            case "2 دانگ":
                spinner_phone.setSelection(4);
                break;
            case "2/5 دانگ":
                spinner_phone.setSelection(5);
                break;
            case "3 دانگ":
                spinner_phone.setSelection(6);
                break;
            case "3/5 دانگ":
                spinner_phone.setSelection(7);
                break;
            case "4 دانگ":
                spinner_phone.setSelection(8);
                break;
            case "4/5 دانگ":
                spinner_phone.setSelection(9);
                break;
            case "5 دانگ":
                spinner_phone.setSelection(10);
                break;
            case "5/5 دانگ":
                spinner_phone.setSelection(11);
                break;
            case "6 دانگ":
                spinner_phone.setSelection(12);
                break;

        }

        switch (_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat.toString()) {

            case "سند رسمی(قطعی)":
                spinner_noe_malekati.setSelection(1);
                break;
            case "قولنامه ای":
                spinner_noe_malekati.setSelection(2);
                break;
            case "وکالتی":
                spinner_noe_malekati.setSelection(3);
                break;
            case "مبایعه نامه ای":
                spinner_noe_malekati.setSelection(4);
                break;
            case "قراردادی":
                spinner_noe_malekati.setSelection(5);
                break;
            case "بنچاق":
                spinner_noe_malekati.setSelection(6);
                break;
            case "صلح نامه":
                spinner_noe_malekati.setSelection(7);
                break;
            case "زمین شهری":
                spinner_noe_malekati.setSelection(8);
                break;
            case "برگه حاک شرع":
                spinner_noe_malekati.setSelection(9);
                break;
            case "اوقاف":
                spinner_noe_malekati.setSelection(10);
                break;
            case "سازمانی":
                spinner_noe_malekati.setSelection(11);
                break;
            case "تعاونی":
                spinner_noe_malekati.setSelection(12);
                break;
            case "بنیاد شهید":
                spinner_noe_malekati.setSelection(13);
                break;
            case "شهرداری":
                spinner_noe_malekati.setSelection(14);
                break;
            case "صنایع دفاع":
                spinner_noe_malekati.setSelection(15);
                break;
            case "نامشخص":
                spinner_noe_malekati.setSelection(16);
                break;

        }


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
                    b = "سند در دست اقدام";
                    Fine_HoMe_checkBox87.setChecked(true);
                }
            }
        }


    }

    public void GetjsonarrayTEJARI() {
        try {
            String dataServer3 = dataServer234;
            jsonArray = new JSONArray(dataServer3);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                ID = jsonObject1.getInt("ID");
                content = jsonObject1.getString("post_content");
                title = jsonObject1.getString("post_title");
                guid11 = jsonObject1.getString("guid11");

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


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        switch (_noe_melk_moamele.toString()) {
            case "فروش، پیش فروش، معاوضه":
                spinner_noe_dael.setSelection(1);
                break;
            case "رهن و اجاره":
                spinner_noe_dael.setSelection(2);
                break;
        }

        switch (_noe_melk.toString()) {
            case "مسکونی (خانه)":
                spinner_noe_melk.setSelection(1);
                break;
            case "اداری (دفترکار)":
                spinner_noe_melk.setSelection(2);
                break;
            case "تجاری (مغازه)":
                spinner_noe_melk.setSelection(3);
                break;
            case "مستفلات (کل ملک و زمین)":
                spinner_noe_melk.setSelection(4);
                break;
            case "زمین":
                spinner_noe_melk.setSelection(5);
                break;

        }

        switch (_moshakhasat_asli_melk_moghiita_store.toString()) {
            case "مغازه کنار گذر":
                spinner_noe_bana.setSelection(1);
                break;
            case "مغازه داخل پاساژ یا مرکز خرید":
                spinner_noe_bana.setSelection(2);
                break;

        }
        Find_HoMe_editText_masahat_made.setText(_moshakhasat_asli_melk_masahat_kaf.toString());


        Find_HoMe_editText_masahat_ground.setText(_moshakhasat_asli_melk_masahat_balkon.toString());


        switch (_moshakhasat_asli_melk_nuumber_dahane.toString()) {
            case "ندارد":
                spinner7.setSelection(1);
                break;
            case "1دهنه":
                spinner7.setSelection(2);
                break;
            case "2دهنه":
                spinner7.setSelection(3);
                break;
            case "3دهنه":
                spinner7.setSelection(4);
                break;
            case "4دهنه":
                spinner7.setSelection(5);
                break;
            case "5دهنه":
                spinner7.setSelection(6);
                break;
            case "6دهنه":
                spinner7.setSelection(7);
                break;
            case "7عدد":
                spinner7.setSelection(7);
                break;
            case "8عدد":
                spinner7.setSelection(7);
                break;
            case "9عدد":
                spinner7.setSelection(7);
                break;
            case "10عدد":
                spinner7.setSelection(7);
                break;
            case "بیشتر 10دهنه":
                spinner7.setSelection(8);
                break;

        }


        Find_HoMe_editText_year_made.setText(_moshakhasat_asli_melk_tol_bar_asli.toString());


        switch (_moshakhasat_asli_melk_number_bar.toString()) {
            case "1نبش":
                spinner_num_room.setSelection(1);
                break;
            case "2نبش":
                spinner_num_room.setSelection(2);
                break;
            case "3نبش":
                spinner_num_room.setSelection(3);
                break;
            case "4نبش":
                spinner_num_room.setSelection(4);
                break;

        }


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
                    b = b + "\n" + "مالکیت";
                    checkBox11.setChecked(true);
                }
                Boolean found2 = a.contains("سرقفلی");
                if (found2 == true) {
                    b = b + "\n" + "سرقفلی";
                    checkBox12.setChecked(true);
                }
            }
        }

        Find_HoMe_editText_price_deal.setText(_price_shrayet_sell_cheng_price_all_sell_cheng.toString());

        if (_noe_melk_moamele.toString() == "فروش، پیش فروش، معاوضه") {
            Find_HoMe_editText_price_deal.setText(_price_shrayet_sell_cheng_price_all_sell_cheng.toString());

            String _price_shrayet_sell_cheng_check_seel_cheng1 = "";
            String _price_shrayet_sell_cheng_check_seel_cheng2 = "";
            String str2 = _price_shrayet_sell_cheng_check_seel_cheng.toString();
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
                        b = b + "\n" + "معاوضه";
                        Fine_HoMe_checkBox_moaveze.setChecked(true);
                        Find_HoMe_editText_moaveze.setText(_price_shrayet_sell_cheng_max_money.toString());
                    }
                    Boolean found2 = a.contains("پیش فروش");
                    if (found2 == true) {
                        b = b + "\n" + "پیش فروش";
                        Fine_HoMe_checkBox_pish_sell.setChecked(true);
                        Find_HoMe_editText_pish_sell_price.setText(_price_shrayet_sell_cheng_money_pish_pay.toString());
                        Find_HoMe_editText_pish_sell_time.setText(_price_shrayet_sell_cheng_time_tahvil.toString());

                        switch (_price_shrayet_sell_cheng_mizan_anjam_shode.toString()) {
                            case "10درصد":
                                spiner_pish_sell_mizan.setSelection(1);
                                break;
                            case "20درصد":
                                spiner_pish_sell_mizan.setSelection(2);
                                break;
                            case "30درصد":
                                spiner_pish_sell_mizan.setSelection(3);
                                break;
                            case "40درصد":
                                spiner_pish_sell_mizan.setSelection(4);
                                break;
                            case "50درصد":
                                spiner_pish_sell_mizan.setSelection(5);
                                break;
                            case "60درصد":
                                spiner_pish_sell_mizan.setSelection(6);
                                break;
                            case "70درصد":
                                spiner_pish_sell_mizan.setSelection(7);
                                break;
                            case "80درصد":
                                spiner_pish_sell_mizan.setSelection(8);
                                break;
                            case "90درصد":
                                spiner_pish_sell_mizan.setSelection(9);
                                break;
                        }
                    }
                    Boolean found3 = a.contains("دارای وام");
                    if (found3 == true) {
                        b = b + "\n" + "دارای وام";
                        Fine_HoMe_checkBox_vam.setChecked(true);
                        Find_HoMe_editText_vam_mizan.setText(_price_shrayet_sell_cheng_mizan_vam.toString());
                        Find_HoMe_editText_vam_sod.setText(_price_shrayet_sell_cheng_sod_vam.toString());
                        Find_HoMe_editText_vam_num_ghest.setText(_price_shrayet_sell_cheng_number_ghest.toString());
                        Find_HoMe_editText_vam_num_ghest2.setText(_price_shrayet_sell_cheng_price_har_ghest.toString());
                    }
                    Boolean found4 = a.contains("فروش با مستاجر");
                    if (found4 == true) {
                        b = b + "\n" + "فروش با مستاجر";
                        Fine_HoMe_checkBox_sell_with_moshtari.setChecked(true);
                        Find_HoMe_editText_sell_with_moshtari.setText(_price_shrayet_sell_cheng_price_rahn.toString());
                    }
                }
            }
        } else {
            editText_rahnVadie.setText(_price_shrayet_rent_price_vadie.toString());
            editText_rahnEjare.setText(_price_shrayet_rent_price_ajare_mohiane.toString());
        }


        Find_HoMe_editText.setText(_more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh.toString());
        Find_HoMe_editText2.setText(_more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh.toString());
        Find_HoMe_editText3.setText(_more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe.toString());
        Find_HoMe_editText4.setText(_more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze.toString());

        switch (_more_joziat_melk_edari_tejari_wc_wc_irani.toString()) {
            case "ندارد":
                spinner_wc_IR.setSelection(1);
                break;
            case "1عدد":
                spinner_wc_IR.setSelection(2);
                break;
            case "2عدد":
                spinner_wc_IR.setSelection(3);
                break;
            case "3عدد":
                spinner_wc_IR.setSelection(4);
                break;
            case "4عدد":
                spinner_wc_IR.setSelection(5);
                break;
            case "5عدد":
                spinner_wc_IR.setSelection(6);
                break;
            case "6عدد":
                spinner_wc_IR.setSelection(7);
                break;
            case "بیشتر از 6عدد":
                spinner_wc_IR.setSelection(8);
                break;

        }


        switch (_more_joziat_melk_edari_tejari_wc_wc_irani.toString()) {
            case "ندارد":
                spinner_wc_EN.setSelection(1);
                break;
            case "1عدد":
                spinner_wc_EN.setSelection(2);
                break;
            case "2عدد":
                spinner_wc_EN.setSelection(3);
                break;
            case "3عدد":
                spinner_wc_EN.setSelection(4);
                break;
            case "4عدد":
                spinner_wc_EN.setSelection(5);
                break;
            case "5عدد":
                spinner_wc_EN.setSelection(6);
                break;
            case "6عدد":
                spinner_wc_EN.setSelection(7);
                break;
            case "بیشتر از 6عدد":
                spinner_wc_EN.setSelection(8);
                break;

        }


        switch (_more_joziat_melk_edari_tejari_wc_roshoii.toString()) {
            case "ندارد":
                spinner_wc_bath.setSelection(1);
                break;
            case "1عدد":
                spinner_wc_bath.setSelection(2);
                break;
            case "2عدد":
                spinner_wc_bath.setSelection(3);
                break;
            case "3عدد":
                spinner_wc_bath.setSelection(4);
                break;
            case "4عدد":
                spinner_wc_bath.setSelection(5);
                break;
            case "5عدد":
                spinner_wc_bath.setSelection(6);
                break;
            case "6عدد":
                spinner_wc_bath.setSelection(7);
                break;
            case "بیشتر از 6عدد":
                spinner_wc_bath.setSelection(8);
                break;

        }


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
                    b = "آبدارخانه";
                    checkBox13.setChecked(true);
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
                    b = b + "\n" + "ویترین";
                    Fine_HoMe_checkBox3.setChecked(true);
                }
                Boolean found2 = a.contains("سقف بالای 4 متر");
                if (found2 == true) {
                    b = b + "\n" + "سقف بالای 4 متر";
                    Fine_HoMe_checkBox4.setChecked(true);
                }
                Boolean found3 = a.contains("دکوراسیون داخلی");
                if (found3 == true) {
                    b = b + "\n" + "دکوراسیون داخلی";
                    Fine_HoMe_checkBox_neshiman_moble.setChecked(true);
                }
                Boolean found31 = a.contains("قفسه بندی");
                if (found31 == true) {
                    b = b + "\n" + "قفسه بندی";
                    checkBox14.setChecked(true);
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
                    b = b + "\n" + "سنگ";
                    Fine_HoMe_checkBox10.setChecked(true);

                }
                Boolean found2 = a.contains("آجر");
                if (found2 == true) {
                    b = b + "\n" + "آجر";
                    Fine_HoMe_checkBox12.setChecked(true);

                }
                Boolean found3 = a.contains("سیمان");
                if (found3 == true) {
                    b = b + "\n" + "سیمان";
                    Fine_HoMe_checkBox11.setChecked(true);

                }
                Boolean found4 = a.contains("شیشه");
                if (found4 == true) {
                    b = b + "\n" + "شیشه";
                    Fine_HoMe_checkBox8.setChecked(true);

                }
                Boolean found5 = a.contains("چوب");
                if (found5 == true) {
                    b = b + "\n" + "چوب";
                    Fine_HoMe_checkBox9.setChecked(true);

                }
                Boolean found6 = a.contains("کامپوزیت");
                if (found6 == true) {
                    b = b + "\n" + "کامپوزیت";
                    Fine_HoMe_checkBox7.setChecked(true);

                }
                Boolean found7 = a.contains("نورپردازی");
                if (found7 == true) {
                    b = b + "\n" + "نورپردازی";
                    Fine_HoMe_checkBox6.setChecked(true);

                }
                Boolean found8 = a.contains("تابلو خور");
                if (found8 == true) {
                    b = b + "\n" + "تابلو خور";
                    checkBox9.setChecked(true);

                }
            }
        }
        Find_HoMe_editText11.setText(_more_joziat_melk_edari_tejari_nama_nama_edit.toString());

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
                    b = b + "\n" + "سنگ";
                    Fine_HoMe_checkBox17.setChecked(true);
                }
                Boolean found2 = a.contains("سرامیک");
                if (found2 == true) {
                    b = b + "\n" + "سرامیک";
                    Fine_HoMe_checkBox18.setChecked(true);
                }
                Boolean found3 = a.contains("پارکت");
                if (found3 == true) {
                    b = b + "\n" + "پارکت";
                    Fine_HoMe_checkBox19.setChecked(true);
                }
                Boolean found4 = a.contains("کفپوش");
                if (found4 == true) {
                    b = b + "\n" + "کفپوش";
                    Fine_HoMe_checkBox20.setChecked(true);
                }
                Boolean found5 = a.contains("موکت");
                if (found5 == true) {
                    b = b + "\n" + "موکت";
                    Fine_HoMe_checkBox21.setChecked(true);
                }
                Boolean found6 = a.contains("موزاییک");
                if (found6 == true) {
                    b = b + "\n" + "موزاییک";
                    Fine_HoMe_checkBox22.setChecked(true);
                }
                Boolean found7 = a.contains("سیمان");
                if (found7 == true) {
                    b = b + "\n" + "سیمان";
                    Fine_HoMe_checkBox23.setChecked(true);
                }
                Boolean found8 = a.contains("کف پله دار");
                if (found8 == true) {
                    b = b + "\n" + "کف پله دار";
                    Fine_HoMe_checkBox24.setChecked(true);
                }
            }

        }

        Find_HoMe_editText13.setText(_more_joziat_melk_edari_tejari_kaf_kaf_edit.toString());


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
                    b = b + "\n" + "کولر";
                    Fine_HoMe_checkBox341.setChecked(true);
                }
                Boolean found2 = a.contains("کولرگازی/ اسپلیت");
                if (found2 == true) {
                    b = b + "\n" + "کولرگازی/ اسپلیت";
                    Fine_HoMe_checkBox331.setChecked(true);
                }
                Boolean found3 = a.contains("بخاری");
                if (found3 == true) {
                    b = b + "\n" + "بخاری";
                    Fine_HoMe_checkBox351.setChecked(true);
                }
                Boolean found4 = a.contains("پکیج/ رادیاتور");
                if (found4 == true) {
                    b = b + "\n" + "پکیج/ رادیاتور";
                    Fine_HoMe_checkBox361.setChecked(true);
                }
                Boolean found5 = a.contains("دیگ/ رادیاتور");
                if (found5 == true) {
                    b = b + "\n" + "دیگ/ رادیاتور";
                    Fine_HoMe_checkBox371.setChecked(true);
                }
                Boolean found6 = a.contains("چیلر/ فن کوئل");
                if (found6 == true) {
                    b = b + "\n" + "چیلر/ فن کوئل";
                    Fine_HoMe_checkBox381.setChecked(true);
                }
                Boolean found7 = a.contains("آبگرمکن خورشیدی");
                if (found7 == true) {
                    b = b + "\n" + "آبگرمکن خورشیدی";
                    Fine_HoMe_checkBox39.setChecked(true);
                }
                Boolean found79 = a.contains("هواساز");
                if (found79 == true) {
                    b = b + "\n" + "هواساز";
                    Fine_HoMe_checkBox40.setChecked(true);
                }
            }
        }

        Find_HoMe_editText151.setText(_more_joziat_melk_edari_tejari_coldhot_coldhot_edit.toString());


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
                    b = b + "\n" + "آسانسور";
                    Fine_HoMe_checkBox33.setChecked(true);
                }

                Boolean found4 = a.contains("اینترنت پرسرعت");
                if (found4 == true) {
                    b = b + "\n" + "اینترنت پرسرعت";
                    Fine_HoMe_checkBox37.setChecked(true);
                }

                Boolean found6 = a.contains("شبکه داخلی");
                if (found6 == true) {
                    b = b + "\n" + "شبکه داخلی";
                    Fine_HoMe_checkBox38.setChecked(true);
                }
                Boolean found61 = a.contains("پله برقی");
                if (found61 == true) {
                    b = b + "\n" + "پله برقی";
                    Fine_HoMe_checkBox36.setChecked(true);
                }
                Boolean found612 = a.contains("آسانسور حمل بار");
                if (found612 == true) {
                    b = b + "\n" + "آسانسور حمل بار";
                    checkBox20.setChecked(true);
                }
            }
        }

        Find_HoMe_editText15.setText(_more_joziat_melk_edari_tejari_refahi_refahi_edit.toString());


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
                    b = b + "\n" + "دزدگیر";
                    Fine_HoMe_checkBox41.setChecked(true);
                }
                Boolean found2 = a.contains("دوربین مداربسته");
                if (found2 == true) {
                    b = b + "\n" + "دوربین مداربسته";
                    Fine_HoMe_checkBox42.setChecked(true);
                }
                Boolean found3 = a.contains("آیفون تصویری");
                if (found3 == true) {
                    b = b + "\n" + "آیفون تصویری";
                    Fine_HoMe_checkBox43.setChecked(true);
                }
                Boolean found4 = a.contains("درب ضد سرقت");
                if (found4 == true) {
                    b = b + "\n" + "درب ضد سرقت";
                    Fine_HoMe_checkBox44.setChecked(true);
                }
                Boolean found5 = a.contains("سیستم اعلام آتش");
                if (found5 == true) {
                    b = b + "\n" + "سیستم اعلام آتش";
                    Fine_HoMe_checkBox45.setChecked(true);
                }
                Boolean found6 = a.contains("سیستم اطفاء حریق");
                if (found6 == true) {
                    b = b + "\n" + "سیستم اطفاء حریق";
                    Fine_HoMe_checkBox46.setChecked(true);
                }
                Boolean found7 = a.contains("گاوصندوق");
                if (found7 == true) {
                    b = b + "\n" + "گاوصندوق";
                    checkBox15.setChecked(true);
                }
                Boolean found71 = a.contains("شیشه نشکن");
                if (found71 == true) {
                    b = b + "\n" + "شیشه نشکن";
                    checkBox16.setChecked(true);
                }
            }
        }

        Find_HoMe_editText16.setText(_more_joziat_melk_edari_tejari_safe_safe_edit.toString());


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
                    b = b + "\n" + "داخل بازار";
                    Fine_HoMe_checkBox47.setChecked(true);
                }
                Boolean found2 = a.contains("خیابان اصلی");
                if (found2 == true) {
                    b = b + "\n" + "خیابان اصلی";
                    Fine_HoMe_checkBox48.setChecked(true);
                }
                Boolean found3 = a.contains("خیابان فرعی");
                if (found3 == true) {
                    b = b + "\n" + "خیابان فرعی";
                    Fine_HoMe_checkBox49.setChecked(true);
                }
                Boolean found4 = a.contains("میدان");
                if (found4 == true) {
                    b = b + "\n" + "میدان";
                    Fine_HoMe_checkBox50.setChecked(true);
                }
                Boolean found5 = a.contains("کوچه");
                if (found5 == true) {
                    b = b + "\n" + "کوچه";
                    Fine_HoMe_checkBox51.setChecked(true);
                }
                Boolean found6 = a.contains("بن بست");
                if (found6 == true) {
                    b = b + "\n" + "بن بست";
                    Fine_HoMe_checkBox52.setChecked(true);
                }

            }
        }


        Find_HoMe_editText17.setText(_more_joziat_melk_edari_tejari_dastresi_dastres_edit.toString());


        // گذر اصلی
        editText13.setText(_more_joziat_melk_edari_tejari_ghozar_asli.toString());


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
                    b = b + "\n" + "آب شهری";
                    Fine_HoMe_checkBox83.setChecked(true);
                }
                Boolean found2 = a.contains("برق");
                if (found2 == true) {
                    b = b + "\n" + "برق";
                    Fine_HoMe_checkBox84.setChecked(true);
                }
                Boolean found3 = a.contains("گاز");
                if (found3 == true) {
                    b = b + "\n" + "گاز";
                    Fine_HoMe_checkBox85.setChecked(true);
                }
                Boolean found4 = a.contains("ژنراتور برقی");
                if (found4 == true) {
                    b = b + "\n" + "ژنراتور برقی";
                    Fine_HoMe_checkBox86.setChecked(true);
                }
                Boolean found45 = a.contains("منابع تغذیه برق");
                if (found45 == true) {
                    b = b + "\n" + "منابع تغذیه برق";
                    checkBox10.setChecked(true);
                }
            }
        }
        switch (_more_joziat_melk_edari_tejari_tasisat_tasisat_edit.toString()) {
            case "ندارد":
                spinner_phone.setSelection(1);
                break;
            case "1خط":
                spinner_phone.setSelection(2);
                break;
            case "2خط":
                spinner_phone.setSelection(3);
                break;
            case "3خط":
                spinner_phone.setSelection(4);
                break;
            case "4خط":
                spinner_phone.setSelection(5);
                break;
            case "5خط":
                spinner_phone.setSelection(6);
                break;
            case "6خط":
                spinner_phone.setSelection(7);
                break;
            case "بیشتر از6خط":
                spinner_phone.setSelection(8);
                break;

        }

        switch (_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat.toString()) {

            case "نیم دانگ":
                spinner_dong.setSelection(1);
                break;
            case "1 دانگ":
                spinner_dong.setSelection(2);
                break;
            case "1/5 دانگ":
                spinner_dong.setSelection(3);
                break;
            case "2 دانگ":
                spinner_dong.setSelection(4);
                break;
            case "2/5 دانگ":
                spinner_dong.setSelection(5);
                break;
            case "3 دانگ":
                spinner_dong.setSelection(6);
                break;
            case "3/5 دانگ":
                spinner_dong.setSelection(7);
                break;
            case "4 دانگ":
                spinner_dong.setSelection(8);
                break;
            case "4/5 دانگ":
                spinner_dong.setSelection(9);
                break;
            case "5 دانگ":
                spinner_dong.setSelection(10);
                break;
            case "5/5 دانگ":
                spinner_dong.setSelection(11);
                break;
            case "6 دانگ":
                spinner_dong.setSelection(12);
                break;

        }

        switch (_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat.toString()) {

            case "سند رسمی(قطعی)":
                spinner_noe_malekati.setSelection(1);
                break;
            case "قولنامه ای":
                spinner_noe_malekati.setSelection(2);
                break;
            case "وکالتی":
                spinner_noe_malekati.setSelection(3);
                break;
            case "مبایعه نامه ای":
                spinner_noe_malekati.setSelection(4);
                break;
            case "قراردادی":
                spinner_noe_malekati.setSelection(5);
                break;
            case "بنچاق":
                spinner_noe_malekati.setSelection(6);
                break;
            case "صلح نامه":
                spinner_noe_malekati.setSelection(7);
                break;
            case "زمین شهری":
                spinner_noe_malekati.setSelection(8);
                break;
            case "برگه حاک شرع":
                spinner_noe_malekati.setSelection(9);
                break;
            case "اوقاف":
                spinner_noe_malekati.setSelection(10);
                break;
            case "سازمانی":
                spinner_noe_malekati.setSelection(11);
                break;
            case "تعاونی":
                spinner_noe_malekati.setSelection(12);
                break;
            case "بنیاد شهید":
                spinner_noe_malekati.setSelection(13);
                break;
            case "شهرداری":
                spinner_noe_malekati.setSelection(14);
                break;
            case "صنایع دفاع":
                spinner_noe_malekati.setSelection(15);
                break;
            case "نامشخص":
                spinner_noe_malekati.setSelection(16);
                break;

        }


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
                    b = "سند در دست اقدام";
                    Fine_HoMe_checkBox87.setChecked(true);
                }
            }
        }

    }

    public void GetjsonarrayMOSTA() {
        try {
            String dataServer3 = dataServer234;
            jsonArray = new JSONArray(dataServer3);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                ID = jsonObject1.getInt("ID");
                content = jsonObject1.getString("post_content");
                title = jsonObject1.getString("post_title");
                guid11 = jsonObject1.getString("guid11");

                _noe_melk_moamele = jsonObject1.getString("_noe_melk_moamele");
                _noe_melk = jsonObject1.getString("_noe_melk");
                _moshakhasat_asli_melk_noe_bana_mostagh = jsonObject1.getString("_moshakhasat_asli_melk_noe_bana_mostagh");
                _moshakhasat_asli_melk_mosahat_kol_banai_build = jsonObject1.getString("_moshakhasat_asli_melk_mosahat_kol_banai_build");
                _moshakhasat_asli_melk_masahat_zamin = jsonObject1.getString("_moshakhasat_asli_melk_masahat_zamin");
                _moshakhasat_asli_melk_number_bar = jsonObject1.getString("_moshakhasat_asli_melk_number_bar");
                _moshakhasat_asli_melk_sale_build = jsonObject1.getString("_moshakhasat_asli_melk_sale_build");
                _moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_vaziita_build_radio");
                _moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = jsonObject1.getString("_moshakhasat_asli_melk_vaziita_build_ghabel_sokonat");
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


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        switch (_noe_melk_moamele.toString()) {
            case "فروش، پیش فروش، معاوضه":
                spinner_noe_dael.setSelection(1);
                break;
            case "رهن و اجاره":
                spinner_noe_dael.setSelection(2);
                break;
        }

        switch (_noe_melk.toString()) {
            case "مسکونی (خانه)":
                spinner_noe_melk.setSelection(1);
                break;
            case "اداری (دفترکار)":
                spinner_noe_melk.setSelection(2);
                break;
            case "تجاری (مغازه)":
                spinner_noe_melk.setSelection(3);
                break;
            case "مستفلات (کل ملک و زمین)":
                spinner_noe_melk.setSelection(4);
                break;
            case "زمین":
                spinner_noe_melk.setSelection(5);
                break;

        }


        switch (_moshakhasat_asli_melk_noe_bana_mostagh.toString()) {
            case "باغ - باغچه":
                spinner_noe_bana.setSelection(1);
                break;
            case "کل آپارتمان یا مجتمع مسکونی یکجا":
                spinner_noe_bana.setSelection(2);
                break;
            case "کل خانه 2 یا 3 طبقه با زمین یکجا":
                spinner_noe_bana.setSelection(3);
                break;
            case "کل پاساژ یا مرکز خرید":
                spinner_noe_bana.setSelection(4);
                break;
            case "انبار":
                spinner_noe_bana.setSelection(5);
                break;
            case "پارکینگ":
                spinner_noe_bana.setSelection(6);
                break;
            case "سوله":
                spinner_noe_bana.setSelection(7);
                break;
            case "کارگاه":
                spinner_noe_bana.setSelection(8);
                break;
            case "کارخانه":
                spinner_noe_bana.setSelection(9);
                break;
            case "استخر":
                spinner_noe_bana.setSelection(10);
                break;
            case "سالن ورزشی":
                spinner_noe_bana.setSelection(11);
                break;
            case "سینما":
                spinner_noe_bana.setSelection(12);
                break;
            case "تئاتر":
                spinner_noe_bana.setSelection(13);
                break;
            case "سفره خانه":
                spinner_noe_bana.setSelection(14);
                break;
            case "رستوران":
                spinner_noe_bana.setSelection(15);
                break;
            case "پرورش دام":
                spinner_noe_bana.setSelection(16);
                break;
            case "مرغداری":
                spinner_noe_bana.setSelection(17);
                break;
            case "پرورش ماهی":
                spinner_noe_bana.setSelection(18);
                break;
            case "هتل":
                spinner_noe_bana.setSelection(19);
                break;
            case "مسافرخانه":
                spinner_noe_bana.setSelection(20);
                break;

        }


        Find_HoMe_editText_masahat_made.setText(_moshakhasat_asli_melk_mosahat_kol_banai_build.toString());
        Find_HoMe_editText_masahat_ground.setText(_moshakhasat_asli_melk_masahat_zamin.toString());

        switch (_moshakhasat_asli_melk_number_bar.toString()) {
            case "1نبش":
                spinner_num_room.setSelection(1);
                break;
            case "2نبش":
                spinner_num_room.setSelection(2);
                break;
            case "3نبش":
                spinner_num_room.setSelection(3);
                break;
            case "4نبش":
                spinner_num_room.setSelection(4);
                break;

        }


        Find_HoMe_editText_year_made.setText(_moshakhasat_asli_melk_sale_build.toString());

        Find_HoMe_editText_price_deal.setText(_price_shrayet_sell_cheng_price_all_sell_cheng.toString());

        if (_noe_melk_moamele.toString() == "فروش، پیش فروش، معاوضه") {
            Find_HoMe_editText_price_deal.setText(_price_shrayet_sell_cheng_price_all_sell_cheng.toString());

            String _price_shrayet_sell_cheng_check_seel_cheng1 = "";
            String _price_shrayet_sell_cheng_check_seel_cheng2 = "";
            String str2 = _price_shrayet_sell_cheng_check_seel_cheng.toString();
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
                        b = b + "\n" + "معاوضه";
                        Fine_HoMe_checkBox_moaveze.setChecked(true);
                        Find_HoMe_editText_moaveze.setText(_price_shrayet_sell_cheng_max_money.toString());
                    }
                    Boolean found2 = a.contains("پیش فروش");
                    if (found2 == true) {
                        b = b + "\n" + "پیش فروش";
                        Fine_HoMe_checkBox_pish_sell.setChecked(true);
                        Find_HoMe_editText_pish_sell_price.setText(_price_shrayet_sell_cheng_money_pish_pay.toString());
                        Find_HoMe_editText_pish_sell_time.setText(_price_shrayet_sell_cheng_time_tahvil.toString());

                        switch (_price_shrayet_sell_cheng_mizan_anjam_shode.toString()) {
                            case "10درصد":
                                spiner_pish_sell_mizan.setSelection(1);
                                break;
                            case "20درصد":
                                spiner_pish_sell_mizan.setSelection(2);
                                break;
                            case "30درصد":
                                spiner_pish_sell_mizan.setSelection(3);
                                break;
                            case "40درصد":
                                spiner_pish_sell_mizan.setSelection(4);
                                break;
                            case "50درصد":
                                spiner_pish_sell_mizan.setSelection(5);
                                break;
                            case "60درصد":
                                spiner_pish_sell_mizan.setSelection(6);
                                break;
                            case "70درصد":
                                spiner_pish_sell_mizan.setSelection(7);
                                break;
                            case "80درصد":
                                spiner_pish_sell_mizan.setSelection(8);
                                break;
                            case "90درصد":
                                spiner_pish_sell_mizan.setSelection(9);
                                break;
                        }
                    }
                    Boolean found3 = a.contains("دارای وام");
                    if (found3 == true) {
                        b = b + "\n" + "دارای وام";
                        Fine_HoMe_checkBox_vam.setChecked(true);
                        Find_HoMe_editText_vam_mizan.setText(_price_shrayet_sell_cheng_mizan_vam.toString());
                        Find_HoMe_editText_vam_sod.setText(_price_shrayet_sell_cheng_sod_vam.toString());
                        Find_HoMe_editText_vam_num_ghest.setText(_price_shrayet_sell_cheng_number_ghest.toString());
                        Find_HoMe_editText_vam_num_ghest2.setText(_price_shrayet_sell_cheng_price_har_ghest.toString());
                    }
                    Boolean found4 = a.contains("فروش با مستاجر");
                    if (found4 == true) {
                        b = b + "\n" + "فروش با مستاجر";
                        Fine_HoMe_checkBox_sell_with_moshtari.setChecked(true);
                        Find_HoMe_editText_sell_with_moshtari.setText(_price_shrayet_sell_cheng_price_rahn.toString());
                    }
                }
            }
        } else {
            editText_rahnVadie.setText(_price_shrayet_rent_price_vadie.toString());
            editText_rahnEjare.setText(_price_shrayet_rent_price_ajare_mohiane.toString());
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
                    b = "مسکونی";
                    checkBox26.setChecked(true);
                }

                Boolean found21 = a.contains("اداری");
                if (found21 == true) {
                    b = "اداری";
                    checkBox27.setChecked(true);
                }

                Boolean found22 = a.contains("تجاری");
                if (found22 == true) {
                    b = "تجاری";
                    checkBox28.setChecked(true);
                }

                Boolean found23 = a.contains("صعنتی");
                if (found23 == true) {
                    b = "صعنتی";
                    checkBox29.setChecked(true);
                }

                Boolean found24 = a.contains("تفریحی - ورزشی");
                if (found24 == true) {
                    b = "تفریحی - ورزشی";
                    checkBox30.setChecked(true);
                }

                Boolean found25 = a.contains("آموزشی");
                if (found25 == true) {
                    b = "آموزشی";
                    checkBox31.setChecked(true);
                }

                Boolean found26 = a.contains("توریستی");
                if (found26 == true) {
                    b = "توریستی";
                    checkBox32.setChecked(true);
                }

                Boolean found27 = a.contains("دامپروری");
                if (found27 == true) {
                    b = "دامپروری";
                    checkBox39.setChecked(true);
                }

                Boolean found28 = a.contains("کشاورزی");
                if (found28 == true) {
                    b = "کشاورزی";
                    checkBox40.setChecked(true);
                }

                Boolean found29 = a.contains("باغشهر - شهرک سازی");
                if (found29 == true) {
                    b = "باغشهر - شهرک سازی";
                    checkBox88.setChecked(true);
                }

                Boolean found20 = a.contains("خدماتی رفاهی");
                if (found20 == true) {
                    b = "خدماتی رفاهی";
                    checkBox89.setChecked(true);
                }

                Boolean found211 = a.contains("انبار");
                if (found211 == true) {
                    b = "انبار";
                    checkBox90.setChecked(true);
                }

                Boolean found212 = a.contains("پارکینگ");
                if (found212 == true) {
                    b = "پارکینگ";
                    checkBox91.setChecked(true);
                }

            }
        }

        editText14.setText(_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit.toString());

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
                    b = b + "\n" + "سنگ";
                    Fine_HoMe_checkBox10.setChecked(true);

                }
                Boolean found2 = a.contains("آجر");
                if (found2 == true) {
                    b = b + "\n" + "آجر";
                    Fine_HoMe_checkBox12.setChecked(true);

                }
                Boolean found3 = a.contains("سیمان");
                if (found3 == true) {
                    b = b + "\n" + "سیمان";
                    Fine_HoMe_checkBox11.setChecked(true);

                }
                Boolean found4 = a.contains("شیشه");
                if (found4 == true) {
                    b = b + "\n" + "شیشه";
                    Fine_HoMe_checkBox8.setChecked(true);

                }
                Boolean found5 = a.contains("چوب");
                if (found5 == true) {
                    b = b + "\n" + "چوب";
                    Fine_HoMe_checkBox9.setChecked(true);

                }
                Boolean found6 = a.contains("کامپوزیت");
                if (found6 == true) {
                    b = b + "\n" + "کامپوزیت";
                    Fine_HoMe_checkBox7.setChecked(true);

                }
                Boolean found7 = a.contains("نورپردازی");
                if (found7 == true) {
                    b = b + "\n" + "نورپردازی";
                    Fine_HoMe_checkBox6.setChecked(true);

                }
            }
        }


        Find_HoMe_editText11.setText(_more_joziat_melk_edari_tejari_nama_nama_edit.toString());


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
                    b = b + "\n" + "بتنی";
                    Fine_HoMe_checkBox13.setChecked(true);
                }
                Boolean found2 = a.contains("فلزی");
                if (found2 == true) {
                    b = b + "\n" + "فلزی";
                    Fine_HoMe_checkBox15.setChecked(true);
                }
                Boolean found3 = a.contains("آجی");
                if (found3 == true) {
                    b = b + "\n" + "آجی";
                    Fine_HoMe_checkBox14.setChecked(true);
                }
                Boolean found4 = a.contains("چوبی");
                if (found4 == true) {
                    b = b + "\n" + "چوبی";
                    Fine_HoMe_checkBox16.setChecked(true);
                }
            }
        }


        Find_HoMe_editText12.setText(_more_joziat_melk_edari_tejari_eskelet_eskelet_edit.toString());


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
                    b = b + "\n" + "سنگ";
                    Fine_HoMe_checkBox25.setChecked(true);
                }
                Boolean found9 = a.contains("رنگ");
                if (found9 == true) {
                    b = b + "\n" + "رنگ";
                    Fine_HoMe_checkBox26.setChecked(true);
                }
                Boolean found2 = a.contains("کاشی/ سرامیک");
                if (found2 == true) {
                    b = b + "\n" + "کاشی/ سرامیک";
                    Fine_HoMe_checkBox27.setChecked(true);
                }
                Boolean found3 = a.contains("کاغذ دیواری");
                if (found3 == true) {
                    b = b + "\n" + "کاغذ دیواری";
                    Fine_HoMe_checkBox28.setChecked(true);
                }
                Boolean found4 = a.contains("چوب/ دیوارکوب");
                if (found4 == true) {
                    b = b + "\n" + "چوب/ دیوارکوب";
                    Fine_HoMe_checkBox29.setChecked(true);
                }
                Boolean found5 = a.contains("سیمان");
                if (found5 == true) {
                    b = b + "\n" + "سیمان";
                    Fine_HoMe_checkBox31.setChecked(true);
                }
                Boolean found6 = a.contains("گچ");
                if (found6 == true) {
                    b = b + "\n" + "گچ";
                    Fine_HoMe_checkBox30.setChecked(true);
                }
                Boolean found7 = a.contains("آجر");
                if (found7 == true) {
                    b = b + "\n" + "آجر";
                    Fine_HoMe_checkBox32.setChecked(true);
                }
            }

        }

        Find_HoMe_editText14.setText(_more_joziat_melk_edari_tejari_divar_divar_edit.toString());


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
                    b = b + "\n" + "کولر";
                    Fine_HoMe_checkBox341.setChecked(true);
                }
                Boolean found2 = a.contains("کولرگازی/ اسپلیت");
                if (found2 == true) {
                    b = b + "\n" + "کولرگازی/ اسپلیت";
                    Fine_HoMe_checkBox331.setChecked(true);
                }
                Boolean found3 = a.contains("بخاری");
                if (found3 == true) {
                    b = b + "\n" + "بخاری";
                    Fine_HoMe_checkBox351.setChecked(true);
                }
                Boolean found4 = a.contains("پکیج/ رادیاتور");
                if (found4 == true) {
                    b = b + "\n" + "پکیج/ رادیاتور";
                    Fine_HoMe_checkBox361.setChecked(true);
                }
                Boolean found5 = a.contains("دیگ/ رادیاتور");
                if (found5 == true) {
                    b = b + "\n" + "دیگ/ رادیاتور";
                    Fine_HoMe_checkBox371.setChecked(true);
                }
                Boolean found6 = a.contains("چیلر/ فن کوئل");
                if (found6 == true) {
                    b = b + "\n" + "چیلر/ فن کوئل";
                    Fine_HoMe_checkBox381.setChecked(true);
                }
                Boolean found7 = a.contains("آبگرمکن خورشیدی");
                if (found7 == true) {
                    b = b + "\n" + "آبگرمکن خورشیدی";
                    Fine_HoMe_checkBox39.setChecked(true);
                }
                Boolean found79 = a.contains("هواساز");
                if (found79 == true) {
                    b = b + "\n" + "هواساز";
                    Fine_HoMe_checkBox40.setChecked(true);
                }
            }
        }

        Find_HoMe_editText151.setText(_more_joziat_melk_edari_tejari_coldhot_coldhot_edit.toString());


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
                    b = b + "\n" + "آسانسور";
                    Fine_HoMe_checkBox33.setChecked(true);
                }
                Boolean found1 = a.contains("آسانسور حمل بار");
                if (found1 == true) {
                    b = b + "\n" + "آسانسور حمل بار";
                    checkBox20.setChecked(true);
                }

                Boolean found2 = a.contains("اینترنت پرسرعت");
                if (found2 == true) {
                    b = b + "\n" + "اینترنت پرسرعت";
                    Fine_HoMe_checkBox37.setChecked(true);
                }

                Boolean found3 = a.contains("شبکه داخلی");
                if (found3 == true) {
                    b = b + "\n" + "شبکه داخلی";
                    Fine_HoMe_checkBox38.setChecked(true);
                }

                Boolean found31 = a.contains("درب پارکنیگ ریموت دار");
                if (found31 == true) {
                    b = b + "\n" + "درب پارکنیگ ریموت دار";
                    Fine_HoMe_checkBox34.setChecked(true);
                }

                Boolean found32 = a.contains("شوتینگ زباله");
                if (found32 == true) {
                    b = b + "\n" + "شوتینگ زباله";
                    Fine_HoMe_checkBox35.setChecked(true);
                }

                Boolean found33 = a.contains("آنتن مرکزی");
                if (found33 == true) {
                    b = b + "\n" + "آنتن مرکزی";
                    Fine_HoMe_checkBox36.setChecked(true);
                }

            }
        }

        Find_HoMe_editText15.setText(_more_joziat_melk_edari_tejari_refahi_refahi_edit.toString());


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
                    b = b + "\n" + "دزدگیر";
                    Fine_HoMe_checkBox41.setChecked(true);
                }
                Boolean found2 = a.contains("دوربین مداربسته");
                if (found2 == true) {
                    b = b + "\n" + "دوربین مداربسته";
                    Fine_HoMe_checkBox42.setChecked(true);
                }
                Boolean found3 = a.contains("آیفون تصویری");
                if (found3 == true) {
                    b = b + "\n" + "آیفون تصویری";
                    Fine_HoMe_checkBox43.setChecked(true);
                }
                Boolean found4 = a.contains("درب ضد سرقت");
                if (found4 == true) {
                    b = b + "\n" + "درب ضد سرقت";
                    Fine_HoMe_checkBox44.setChecked(true);
                }
                Boolean found5 = a.contains("سیستم اعلام آتش");
                if (found5 == true) {
                    b = b + "\n" + "سیستم اعلام آتش";
                    Fine_HoMe_checkBox45.setChecked(true);
                }
                Boolean found6 = a.contains("سیستم اطفاء حریق");
                if (found6 == true) {
                    b = b + "\n" + "سیستم اطفاء حریق";
                    Fine_HoMe_checkBox46.setChecked(true);
                }
                Boolean found7 = a.contains("گاوصندوق");
                if (found7 == true) {
                    b = b + "\n" + "گاوصندوق";
                    checkBox15.setChecked(true);
                }
            }
        }

        Find_HoMe_editText16.setText(_more_joziat_melk_edari_tejari_safe_safe_edit.toString());

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
                    b = b + "\n" + "داخل بازار";
                    checkBox21.setChecked(true);
                }
                Boolean found2 = a.contains("خیابان اصلی");
                if (found2 == true) {
                    b = b + "\n" + "خیابان اصلی";
                    checkBox23.setChecked(true);
                }
                Boolean found3 = a.contains("خیابان فرعی");
                if (found3 == true) {
                    b = b + "\n" + "خیابان فرعی";
                    checkBox24.setChecked(true);
                }
                Boolean found4 = a.contains("میدان");
                if (found4 == true) {
                    b = b + "\n" + "میدان";
                    checkBox25.setChecked(true);
                }
                Boolean found5 = a.contains("کوچه");
                if (found5 == true) {
                    b = b + "\n" + "کوچه";
                    checkBox93.setChecked(true);
                }
                Boolean found6 = a.contains("بن بست");
                if (found6 == true) {
                    b = b + "\n" + "بن بست";
                    checkBox94.setChecked(true);
                }
            }
        }
        Find_HoMe_editText17.setText(_more_joziat_melk_edari_tejari_dastresi_dastres_edit.toString());

        // گذر اصلی
        editText13.setText(_more_joziat_melk_edari_tejari_ghozar_asli.toString());

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
                    b = b + "\n" + "حیاط";
                    Fine_HoMe_checkBox53.setChecked(true);
                }
                Boolean found2 = a.contains("حیاط خلوت");
                if (found2 == true) {
                    b = b + "\n" + "حیاط خلوت";
                    Fine_HoMe_checkBox47.setChecked(true);
                }
                Boolean found3 = a.contains("فضای سبز");
                if (found3 == true) {
                    b = b + "\n" + "فضای سبز";
                    Fine_HoMe_checkBox54.setChecked(true);
                }
                Boolean found4 = a.contains("سرایداری");
                if (found4 == true) {
                    b = b + "\n" + "سرایداری";
                    Fine_HoMe_checkBox48.setChecked(true);
                }
                Boolean found5 = a.contains("نگهبانی");
                if (found5 == true) {
                    b = b + "\n" + "نگهبانی";
                    Fine_HoMe_checkBox55.setChecked(true);
                }
                Boolean found6 = a.contains("لابی");
                if (found6 == true) {
                    b = b + "\n" + "لابی";
                    Fine_HoMe_checkBox49.setChecked(true);
                }
                Boolean found62 = a.contains("سالن اجتماعات");
                if (found62 == true) {
                    b = b + "\n" + "سالن اجتماعات";
                    Fine_HoMe_checkBox56.setChecked(true);
                }
                Boolean found611 = a.contains("باغ");
                if (found611 == true) {
                    b = b + "\n" + "باغ";
                    Fine_HoMe_checkBox50.setChecked(true);
                }
                Boolean found612 = a.contains("آلاچیق");
                if (found612 == true) {
                    b = b + "\n" + "آلاچیق";
                    Fine_HoMe_checkBox57.setChecked(true);
                }
                Boolean found613 = a.contains("آب نما");
                if (found613 == true) {
                    b = b + "\n" + "آب نما";
                    Fine_HoMe_checkBox51.setChecked(true);
                }
                Boolean found614 = a.contains("بام سبز");
                if (found614 == true) {
                    b = b + "\n" + "بام سبز";
                    Fine_HoMe_checkBox58.setChecked(true);
                }
                Boolean found615 = a.contains("باربیکیو");
                if (found615 == true) {
                    b = b + "\n" + "باربیکیو";
                    Fine_HoMe_checkBox52.setChecked(true);
                }

            }
        }

        Find_HoMe_editText17.setText(_more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit.toString());

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
                    b = b + "\n" + "استخر";
                    Fine_HoMe_checkBox59.setChecked(true);
                }
                Boolean found2 = a.contains("سونا");
                if (found2 == true) {
                    b = b + "\n" + "سونا";
                    Fine_HoMe_checkBox60.setChecked(true);
                }
                Boolean found3 = a.contains("جوزی");
                if (found3 == true) {
                    b = b + "\n" + "جوزی";
                    Fine_HoMe_checkBox61.setChecked(true);
                }
                Boolean found4 = a.contains("بیلیارد");
                if (found4 == true) {
                    b = b + "\n" + "بیلیارد";
                    Fine_HoMe_checkBox62.setChecked(true);
                }
                Boolean found5 = a.contains("فوتبال");
                if (found5 == true) {
                    b = b + "\n" + "فوتبال";
                    Fine_HoMe_checkBox63.setChecked(true);
                }
                Boolean found6 = a.contains("بسکتبال");
                if (found6 == true) {
                    b = b + "\n" + "بسکتبال";
                    Fine_HoMe_checkBox64.setChecked(true);
                }
                Boolean found61 = a.contains("والیبال");
                if (found61 == true) {
                    b = b + "\n" + "والیبال";
                    Fine_HoMe_checkBox65.setChecked(true);
                }
                Boolean found62 = a.contains("تنیس");
                if (found62 == true) {
                    b = b + "\n" + "تنیس";
                    Fine_HoMe_checkBox66.setChecked(true);
                }
                Boolean found63 = a.contains("پینگ پنگ");
                if (found63 == true) {
                    b = b + "\n" + "پینگ پنگ";
                    Fine_HoMe_checkBox67.setChecked(true);
                }
                Boolean found64 = a.contains("سالن بدن سازی");
                if (found64 == true) {
                    b = b + "\n" + "سالن بدن سازی";
                    Fine_HoMe_checkBox68.setChecked(true);
                }
                Boolean found65 = a.contains("زمین بازی کودکان");
                if (found65 == true) {
                    b = b + "\n" + "زمین بازی کودکان";
                    Fine_HoMe_checkBox69.setChecked(true);
                }
                Boolean found66 = a.contains("اسکواش");
                if (found66 == true) {
                    b = b + "\n" + "اسکواش";
                    Fine_HoMe_checkBox70.setChecked(true);
                }
            }
        }


        Find_HoMe_editText18.setText(_more_joziat_melk_edari_tejari_sport_sport_edit.toString());

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
                    b = b + "\n" + "شهر";
                    Fine_HoMe_checkBox71.setChecked(true);
                }
                Boolean found2 = a.contains("اتوبان");
                if (found2 == true) {
                    b = b + "\n" + "اتوبان";
                    Fine_HoMe_checkBox72.setChecked(true);
                }
                Boolean found3 = a.contains("خیابان");
                if (found3 == true) {
                    b = b + "\n" + "خیابان";
                    Fine_HoMe_checkBox73.setChecked(true);
                }
                Boolean found4 = a.contains("کوچه");
                if (found4 == true) {
                    b = b + "\n" + "کوچه";
                    Fine_HoMe_checkBox74.setChecked(true);
                }
                Boolean found5 = a.contains("دریا");
                if (found5 == true) {
                    b = b + "\n" + "دریا";
                    Fine_HoMe_checkBox75.setChecked(true);
                }
                Boolean found6 = a.contains("جنگل");
                if (found6 == true) {
                    b = b + "\n" + "جنگل";
                    Fine_HoMe_checkBox76.setChecked(true);
                }
                Boolean found7 = a.contains("کوه");
                if (found7 == true) {
                    b = b + "\n" + "کوه";
                    Fine_HoMe_checkBox77.setChecked(true);
                }
                Boolean found71 = a.contains("باغ");
                if (found71 == true) {
                    b = b + "\n" + "باغ";
                    Fine_HoMe_checkBox78.setChecked(true);
                }
            }
        }

        Find_HoMe_editText19.setText(_more_joziat_melk_edari_tejari_view_view_edit.toString());


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
                    b = b + "\n" + "آب شهری";
                    Fine_HoMe_checkBox83.setChecked(true);
                }
                Boolean found46 = a.contains("آب چاه");
                if (found46 == true) {
                    b = b + "\n" + "آب چاه";
                    checkBox95.setChecked(true);
                }

                Boolean found2 = a.contains("برق");
                if (found2 == true) {
                    b = b + "\n" + "برق";
                    Fine_HoMe_checkBox84.setChecked(true);
                }
                Boolean found3 = a.contains("گاز");
                if (found3 == true) {
                    b = b + "\n" + "گاز";
                    Fine_HoMe_checkBox85.setChecked(true);
                }
                Boolean found4 = a.contains("ژنراتور برقی");
                if (found4 == true) {
                    b = b + "\n" + "ژنراتور برقی";
                    Fine_HoMe_checkBox86.setChecked(true);
                }
                Boolean found45 = a.contains("منابع تغذیه برق");
                if (found45 == true) {
                    b = b + "\n" + "منابع تغذیه برق";
                    checkBox10.setChecked(true);
                }
            }
        }

        switch (_more_joziat_melk_edari_tejari_tasisat_tasisat_edit.toString()) {
            case "ندارد":
                spinner_phone.setSelection(1);
                break;
            case "1خط":
                spinner_phone.setSelection(2);
                break;
            case "2خط":
                spinner_phone.setSelection(3);
                break;
            case "3خط":
                spinner_phone.setSelection(4);
                break;
            case "4خط":
                spinner_phone.setSelection(5);
                break;
            case "5خط":
                spinner_phone.setSelection(6);
                break;
            case "6خط":
                spinner_phone.setSelection(7);
                break;
            case "بیشتر از6خط":
                spinner_phone.setSelection(8);
                break;

        }

        switch (_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat.toString()) {

            case "نیم دانگ":
                spinner_phone.setSelection(1);
                break;
            case "1 دانگ":
                spinner_phone.setSelection(2);
                break;
            case "1/5 دانگ":
                spinner_phone.setSelection(3);
                break;
            case "2 دانگ":
                spinner_phone.setSelection(4);
                break;
            case "2/5 دانگ":
                spinner_phone.setSelection(5);
                break;
            case "3 دانگ":
                spinner_phone.setSelection(6);
                break;
            case "3/5 دانگ":
                spinner_phone.setSelection(7);
                break;
            case "4 دانگ":
                spinner_phone.setSelection(8);
                break;
            case "4/5 دانگ":
                spinner_phone.setSelection(9);
                break;
            case "5 دانگ":
                spinner_phone.setSelection(10);
                break;
            case "5/5 دانگ":
                spinner_phone.setSelection(11);
                break;
            case "6 دانگ":
                spinner_phone.setSelection(12);
                break;

        }

        switch (_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat.toString()) {

            case "سند رسمی(قطعی)":
                spinner_noe_malekati.setSelection(1);
                break;
            case "قولنامه ای":
                spinner_noe_malekati.setSelection(2);
                break;
            case "وکالتی":
                spinner_noe_malekati.setSelection(3);
                break;
            case "مبایعه نامه ای":
                spinner_noe_malekati.setSelection(4);
                break;
            case "قراردادی":
                spinner_noe_malekati.setSelection(5);
                break;
            case "بنچاق":
                spinner_noe_malekati.setSelection(6);
                break;
            case "صلح نامه":
                spinner_noe_malekati.setSelection(7);
                break;
            case "زمین شهری":
                spinner_noe_malekati.setSelection(8);
                break;
            case "برگه حاک شرع":
                spinner_noe_malekati.setSelection(9);
                break;
            case "اوقاف":
                spinner_noe_malekati.setSelection(10);
                break;
            case "سازمانی":
                spinner_noe_malekati.setSelection(11);
                break;
            case "تعاونی":
                spinner_noe_malekati.setSelection(12);
                break;
            case "بنیاد شهید":
                spinner_noe_malekati.setSelection(13);
                break;
            case "شهرداری":
                spinner_noe_malekati.setSelection(14);
                break;
            case "صنایع دفاع":
                spinner_noe_malekati.setSelection(15);
                break;
            case "نامشخص":
                spinner_noe_malekati.setSelection(16);
                break;

        }


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
                    b = "سند در دست اقدام";
                    Fine_HoMe_checkBox87.setChecked(true);
                }
            }
        }


    }

    public void GetjsonarrayZAMIN() {
        try {
            String dataServer3 = dataServer234;
            jsonArray = new JSONArray(dataServer3);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                ID = jsonObject1.getInt("ID");
                content = jsonObject1.get("post_content");
                title = jsonObject1.get("post_title");
                guid11 = jsonObject1.get("guid11");

                _noe_melk_moamele = jsonObject1.get("_noe_melk_moamele");
                _noe_melk = jsonObject1.get("_noe_melk");
                _moshakhasat_asli_melk_karbari_now = jsonObject1.get("_moshakhasat_asli_melk_karbari_now");
                _moshakhasat_asli_melk_masahat_zamin_after_eslahie = jsonObject1.get("_moshakhasat_asli_melk_masahat_zamin_after_eslahie");
                _moshakhasat_asli_melk_tol_bar_asli = jsonObject1.get("_moshakhasat_asli_melk_tol_bar_asli");
                _moshakhasat_asli_melk_number_bar = jsonObject1.get("_moshakhasat_asli_melk_number_bar");
                _moshakhasat_asli_melk_vaziita_build_vazita_zamin = jsonObject1.get("_moshakhasat_asli_melk_vaziita_build_vazita_zamin");
                _price_shrayet_sell_cheng_price_all_sell_cheng = jsonObject1.get("_price_shrayet_sell_cheng_price_all_sell_cheng");
                _price_shrayet_sell_cheng_check_seel_cheng = jsonObject1.get("_price_shrayet_sell_cheng_check_seel_cheng");
                _price_shrayet_sell_cheng_max_money = jsonObject1.get("_price_shrayet_sell_cheng_max_money");
                _price_shrayet_sell_cheng_money_pish_pay = jsonObject1.get("_price_shrayet_sell_cheng_money_pish_pay");
                _price_shrayet_sell_cheng_time_tahvil = jsonObject1.get("_price_shrayet_sell_cheng_time_tahvil");
                _price_shrayet_sell_cheng_mizan_anjam_shode = jsonObject1.get("_price_shrayet_sell_cheng_mizan_anjam_shode");
                _price_shrayet_sell_cheng_mizan_vam = jsonObject1.get("_price_shrayet_sell_cheng_mizan_vam");
                _price_shrayet_sell_cheng_sod_vam = jsonObject1.get("_price_shrayet_sell_cheng_sod_vam");
                _price_shrayet_sell_cheng_number_ghest = jsonObject1.get("_price_shrayet_sell_cheng_number_ghest");
                _price_shrayet_sell_cheng_price_har_ghest = jsonObject1.get("_price_shrayet_sell_cheng_price_har_ghest");
                _price_shrayet_sell_cheng_price_rahn = jsonObject1.get("_price_shrayet_sell_cheng_price_rahn");
                _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check = jsonObject1.get("_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check");
                _more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit = jsonObject1.get("_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit");
                _more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin = jsonObject1.get("_more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin");
                _more_joziat_melk_edari_tejari_dastresi_dastres_edit = jsonObject1.get("_more_joziat_melk_edari_tejari_dastresi_dastres_edit");
                _more_joziat_melk_edari_tejari_ghozar_asli = jsonObject1.get("_more_joziat_melk_edari_tejari_ghozar_asli");
                _more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin = jsonObject1.get("_more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin");
                _more_joziat_melk_edari_tejari_tasisat_tasisat_edit = jsonObject1.get("_more_joziat_melk_edari_tejari_tasisat_tasisat_edit");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = jsonObject1.get("_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = jsonObject1.get("_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat");
                _more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = jsonObject1.get("_more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam");


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        switch (_noe_melk_moamele.toString()) {
            case "فروش، پیش فروش، معاوضه":
                spinner_noe_dael.setSelection(1);
                break;
            case "رهن و اجاره":
                spinner_noe_dael.setSelection(2);
                break;
        }

        switch (_noe_melk.toString()) {
            case "مسکونی (خانه)":
                spinner_noe_melk.setSelection(1);
                break;
            case "اداری (دفترکار)":
                spinner_noe_melk.setSelection(2);
                break;
            case "تجاری (مغازه)":
                spinner_noe_melk.setSelection(3);
                break;
            case "مستفلات (کل ملک و زمین)":
                spinner_noe_melk.setSelection(4);
                break;
            case "زمین":
                spinner_noe_melk.setSelection(5);
                break;

        }

        switch (_moshakhasat_asli_melk_karbari_now.toString()) {

            case "مسکونی":
                spinner_noe_bana.setSelection(1);
                break;
            case "اداری":
                spinner_noe_bana.setSelection(2);
                break;
            case "تجاری":
                spinner_noe_bana.setSelection(3);
                break;
            case "صنعتی":
                spinner_noe_bana.setSelection(4);
                break;
            case "تفریحی - ورزشی":
                spinner_noe_bana.setSelection(5);
                break;
            case "آموزشی":
                spinner_noe_bana.setSelection(6);
                break;
            case "توریستی":
                spinner_noe_bana.setSelection(7);
                break;
            case "دامپروری":
                spinner_noe_bana.setSelection(8);
                break;
            case "کشاورزی":
                spinner_noe_bana.setSelection(9);
                break;
            case "باغشهر - مناسب برای شهرک سازی":
                spinner_noe_bana.setSelection(10);
                break;
            case "خدماتی - رفاهی":
                spinner_noe_bana.setSelection(11);
                break;
            case "انبار":
                spinner_noe_bana.setSelection(12);
                break;
            case "پارکینگ":
                spinner_noe_bana.setSelection(13);
                break;
            case "بایر":
                spinner_noe_bana.setSelection(14);
                break;

        }

        Find_HoMe_editText_masahat_made.setText(_moshakhasat_asli_melk_masahat_zamin_after_eslahie.toString());
        Find_HoMe_editText_year_made.setText(_moshakhasat_asli_melk_tol_bar_asli.toString());

        switch (_moshakhasat_asli_melk_number_bar.toString()) {
            case "1نبش":
                spinner_num_room.setSelection(1);
                break;
            case "2نبش":
                spinner_num_room.setSelection(2);
                break;
            case "3نبش":
                spinner_num_room.setSelection(3);
                break;
            case "4نبش":
                spinner_num_room.setSelection(4);
                break;

        }


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
                    b = "دارای جواز ساخت";
                    checkBox17.setChecked(true);
                }
                Boolean found22 = a.contains("قابل تجمیع");
                if (found22 == true) {
                    b = "قابل تجمیع";
                    checkBox18.setChecked(true);
                }
                Boolean found21 = a.contains("قابل تفکیک");
                if (found21 == true) {
                    b = "قابل تفکیک";
                    checkBox19.setChecked(true);
                }

            }
        }
        Find_HoMe_editText_price_deal.setText(_price_shrayet_sell_cheng_price_all_sell_cheng.toString());

        if (_noe_melk_moamele.toString() == "فروش، پیش فروش، معاوضه") {
            Find_HoMe_editText_price_deal.setText(_price_shrayet_sell_cheng_price_all_sell_cheng.toString());

            String _price_shrayet_sell_cheng_check_seel_cheng1 = "";
            String _price_shrayet_sell_cheng_check_seel_cheng2 = "";
            String str2 = _price_shrayet_sell_cheng_check_seel_cheng.toString();
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
                        b = b + "\n" + "معاوضه";
                        Fine_HoMe_checkBox_moaveze.setChecked(true);
                        Find_HoMe_editText_moaveze.setText(_price_shrayet_sell_cheng_max_money.toString());
                    }
                    Boolean found2 = a.contains("پیش فروش");
                    if (found2 == true) {
                        b = b + "\n" + "پیش فروش";
                        Fine_HoMe_checkBox_pish_sell.setChecked(true);
                        Find_HoMe_editText_pish_sell_price.setText(_price_shrayet_sell_cheng_money_pish_pay.toString());
                        Find_HoMe_editText_pish_sell_time.setText(_price_shrayet_sell_cheng_time_tahvil.toString());

                        switch (_price_shrayet_sell_cheng_mizan_anjam_shode.toString()) {
                            case "10درصد":
                                spiner_pish_sell_mizan.setSelection(1);
                                break;
                            case "20درصد":
                                spiner_pish_sell_mizan.setSelection(2);
                                break;
                            case "30درصد":
                                spiner_pish_sell_mizan.setSelection(3);
                                break;
                            case "40درصد":
                                spiner_pish_sell_mizan.setSelection(4);
                                break;
                            case "50درصد":
                                spiner_pish_sell_mizan.setSelection(5);
                                break;
                            case "60درصد":
                                spiner_pish_sell_mizan.setSelection(6);
                                break;
                            case "70درصد":
                                spiner_pish_sell_mizan.setSelection(7);
                                break;
                            case "80درصد":
                                spiner_pish_sell_mizan.setSelection(8);
                                break;
                            case "90درصد":
                                spiner_pish_sell_mizan.setSelection(9);
                                break;
                        }
                    }
                    Boolean found3 = a.contains("دارای وام");
                    if (found3 == true) {
                        b = b + "\n" + "دارای وام";
                        Fine_HoMe_checkBox_vam.setChecked(true);
                        Find_HoMe_editText_vam_mizan.setText(_price_shrayet_sell_cheng_mizan_vam.toString());
                        Find_HoMe_editText_vam_sod.setText(_price_shrayet_sell_cheng_sod_vam.toString());
                        Find_HoMe_editText_vam_num_ghest.setText(_price_shrayet_sell_cheng_number_ghest.toString());
                        Find_HoMe_editText_vam_num_ghest2.setText(_price_shrayet_sell_cheng_price_har_ghest.toString());
                    }
                    Boolean found4 = a.contains("فروش با مستاجر");
                    if (found4 == true) {
                        b = b + "\n" + "فروش با مستاجر";
                        Fine_HoMe_checkBox_sell_with_moshtari.setChecked(true);
                        Find_HoMe_editText_sell_with_moshtari.setText(_price_shrayet_sell_cheng_price_rahn.toString());
                    }
                }
            }
        } else {
            editText_rahnVadie.setText(_price_shrayet_rent_price_vadie.toString());
            editText_rahnEjare.setText(_price_shrayet_rent_price_ajare_mohiane.toString());
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
                    b = "مسکونی";
                    checkBox26.setChecked(true);
                }

                Boolean found21 = a.contains("اداری");
                if (found21 == true) {
                    b = "اداری";
                    checkBox27.setChecked(true);
                }

                Boolean found22 = a.contains("تجاری");
                if (found22 == true) {
                    b = "تجاری";
                    checkBox28.setChecked(true);
                }

                Boolean found23 = a.contains("صعنتی");
                if (found23 == true) {
                    b = "صعنتی";
                    checkBox29.setChecked(true);
                }

                Boolean found24 = a.contains("تفریحی - ورزشی");
                if (found24 == true) {
                    b = "تفریحی - ورزشی";
                    checkBox30.setChecked(true);
                }

                Boolean found25 = a.contains("آموزشی");
                if (found25 == true) {
                    b = "آموزشی";
                    checkBox31.setChecked(true);
                }

                Boolean found26 = a.contains("توریستی");
                if (found26 == true) {
                    b = "توریستی";
                    checkBox32.setChecked(true);
                }

                Boolean found27 = a.contains("دامپروری");
                if (found27 == true) {
                    b = "دامپروری";
                    checkBox39.setChecked(true);
                }

                Boolean found28 = a.contains("کشاورزی");
                if (found28 == true) {
                    b = "کشاورزی";
                    checkBox40.setChecked(true);
                }

                Boolean found29 = a.contains("باغشهر - شهرک سازی");
                if (found29 == true) {
                    b = "باغشهر - شهرک سازی";
                    checkBox88.setChecked(true);
                }

                Boolean found20 = a.contains("خدماتی رفاهی");
                if (found20 == true) {
                    b = "خدماتی رفاهی";
                    checkBox89.setChecked(true);
                }

                Boolean found211 = a.contains("انبار");
                if (found211 == true) {
                    b = "انبار";
                    checkBox90.setChecked(true);
                }

                Boolean found212 = a.contains("پارکینگ");
                if (found212 == true) {
                    b = "پارکینگ";
                    checkBox91.setChecked(true);
                }

            }
        }

        editText14.setText(_more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit.toString());


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
                    b = b + "\n" + "داخل بازار";
                    Fine_HoMe_checkBox47.setChecked(true);
                }
                Boolean found2 = a.contains("خیابان اصلی");
                if (found2 == true) {
                    b = b + "\n" + "خیابان اصلی";
                    Fine_HoMe_checkBox18.setChecked(true);
                }
                Boolean found3 = a.contains("خیابان فرعی");
                if (found3 == true) {
                    b = b + "\n" + "خیابان فرعی";
                    Fine_HoMe_checkBox19.setChecked(true);
                }
                Boolean found4 = a.contains("میدان");
                if (found4 == true) {
                    b = b + "\n" + "میدان";
                    Fine_HoMe_checkBox20.setChecked(true);
                }
                Boolean found5 = a.contains("کوچه");
                if (found5 == true) {
                    b = b + "\n" + "کوچه";
                    Fine_HoMe_checkBox21.setChecked(true);
                }
                Boolean found6 = a.contains("بن بست");
                if (found6 == true) {
                    b = b + "\n" + "بن بست";
                    Fine_HoMe_checkBox22.setChecked(true);
                }

            }
        }

        // گذر اصلی
        editText13.setText(_more_joziat_melk_edari_tejari_ghozar_asli.toString());

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
                    b = b + "\n" + "آب شهری";
                    Fine_HoMe_checkBox83.setChecked(true);
                }
                Boolean found1 = a.contains("آب چاه");
                if (found1 == true) {
                    b = b + "\n" + "آب چاه";
                    checkBox95.setChecked(true);
                }

                Boolean found2 = a.contains("برق");
                if (found2 == true) {
                    b = b + "\n" + "برق";
                    Fine_HoMe_checkBox84.setChecked(true);
                }
                Boolean found3 = a.contains("گاز");
                if (found3 == true) {
                    b = b + "\n" + "گاز";
                    Fine_HoMe_checkBox85.setChecked(true);
                }

            }
        }


        switch (_more_joziat_melk_edari_tejari_tasisat_tasisat_edit.toString()) {
            case "ندارد":
                spinner_phone.setSelection(1);
                break;
            case "1خط":
                spinner_phone.setSelection(2);
                break;
            case "2خط":
                spinner_phone.setSelection(3);
                break;
            case "3خط":
                spinner_phone.setSelection(4);
                break;
            case "4خط":
                spinner_phone.setSelection(5);
                break;
            case "5خط":
                spinner_phone.setSelection(6);
                break;
            case "6خط":
                spinner_phone.setSelection(7);
                break;
            case "بیشتر از6خط":
                spinner_phone.setSelection(8);
                break;

        }

        switch (_more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat.toString()) {

            case "نیم دانگ":
                spinner_phone.setSelection(1);
                break;
            case "1 دانگ":
                spinner_phone.setSelection(2);
                break;
            case "1/5 دانگ":
                spinner_phone.setSelection(3);
                break;
            case "2 دانگ":
                spinner_phone.setSelection(4);
                break;
            case "2/5 دانگ":
                spinner_phone.setSelection(5);
                break;
            case "3 دانگ":
                spinner_phone.setSelection(6);
                break;
            case "3/5 دانگ":
                spinner_phone.setSelection(7);
                break;
            case "4 دانگ":
                spinner_phone.setSelection(8);
                break;
            case "4/5 دانگ":
                spinner_phone.setSelection(9);
                break;
            case "5 دانگ":
                spinner_phone.setSelection(10);
                break;
            case "5/5 دانگ":
                spinner_phone.setSelection(11);
                break;
            case "6 دانگ":
                spinner_phone.setSelection(12);
                break;

        }

        switch (_more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat.toString()) {

            case "سند رسمی(قطعی)":
                spinner_phone.setSelection(1);
                break;
            case "قولنامه ای":
                spinner_phone.setSelection(2);
                break;
            case "وکالتی":
                spinner_phone.setSelection(3);
                break;
            case "مبایعه نامه ای":
                spinner_phone.setSelection(4);
                break;
            case "قراردادی":
                spinner_phone.setSelection(5);
                break;
            case "بنچاق":
                spinner_phone.setSelection(6);
                break;
            case "صلح نامه":
                spinner_phone.setSelection(7);
                break;
            case "زمین شهری":
                spinner_phone.setSelection(8);
                break;
            case "برگه حاک شرع":
                spinner_phone.setSelection(9);
                break;
            case "اوقاف":
                spinner_phone.setSelection(10);
                break;
            case "سازمانی":
                spinner_phone.setSelection(11);
                break;
            case "تعاونی":
                spinner_phone.setSelection(12);
                break;
            case "بنیاد شهید":
                spinner_phone.setSelection(13);
                break;
            case "شهرداری":
                spinner_phone.setSelection(14);
                break;
            case "صنایع دفاع":
                spinner_phone.setSelection(15);
                break;
            case "نامشخص":
                spinner_phone.setSelection(16);
                break;

        }


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
                    b = "سند در دست اقدام";
                    Fine_HoMe_checkBox87.setChecked(true);
                }
            }
        }


    }

    public void Empitier() {
        checkBox7.setChecked(false);
        checkBox8.setChecked(false);
        checkBox9.setChecked(false);
        checkBox10.setChecked(false);
        checkBox11.setChecked(false);
        checkBox12.setChecked(false);
        checkBox13.setChecked(false);
        checkBox14.setChecked(false);
        checkBox15.setChecked(false);
        checkBox16.setChecked(false);
        checkBox17.setChecked(false);
        checkBox18.setChecked(false);
        checkBox19.setChecked(false);
        checkBox20.setChecked(false);
        checkBox21.setChecked(false);
        checkBox22.setChecked(false);
        checkBox23.setChecked(false);
        checkBox24.setChecked(false);
        checkBox25.setChecked(false);
        checkBox26.setChecked(false);
        checkBox27.setChecked(false);
        checkBox28.setChecked(false);
        checkBox29.setChecked(false);
        checkBox30.setChecked(false);
        checkBox31.setChecked(false);
        checkBox32.setChecked(false);
        checkBox33.setChecked(false);
        checkBox39.setChecked(false);
        checkBox40.setChecked(false);
        checkBox88.setChecked(false);
        checkBox89.setChecked(false);
        checkBox90.setChecked(false);
        checkBox91.setChecked(false);
        checkBox92.setChecked(false);
        checkBox93.setChecked(false);
        checkBox94.setChecked(false);
        checkBox95.setChecked(false);
        Fine_HoMe_checkBox_reBuild.setChecked(false);
        Fine_HoMe_checkBox_ghabel_live.setChecked(false);
        Fine_HoMe_checkBox_moaveze.setChecked(false);
        Fine_HoMe_checkBox_pish_sell.setChecked(false);
        Fine_HoMe_checkBox_vam.setChecked(false);
        Fine_HoMe_checkBox_sell_with_moshtari.setChecked(false);
        Fine_HoMe_checkBox_have_kabinet.setChecked(false);
        Fine_HoMe_checkBox_have_tajhizat_kitchen.setChecked(false);
        Fine_HoMe_checkBox_neshiman_moble.setChecked(false);
        Fine_HoMe_checkBox123.setChecked(false);
        Fine_HoMe_checkBox2.setChecked(false);
        Fine_HoMe_checkBox3.setChecked(false);
        Fine_HoMe_checkBox4.setChecked(false);
        Fine_HoMe_checkBox5.setChecked(false);
        Fine_HoMe_checkBox6.setChecked(false);
        Fine_HoMe_checkBox7.setChecked(false);
        Fine_HoMe_checkBox8.setChecked(false);
        Fine_HoMe_checkBox9.setChecked(false);
        Fine_HoMe_checkBox10.setChecked(false);
        Fine_HoMe_checkBox11.setChecked(false);
        Fine_HoMe_checkBox12.setChecked(false);
        Fine_HoMe_checkBox13.setChecked(false);
        Fine_HoMe_checkBox14.setChecked(false);
        Fine_HoMe_checkBox15.setChecked(false);
        Fine_HoMe_checkBox16.setChecked(false);
        Fine_HoMe_checkBox17.setChecked(false);
        Fine_HoMe_checkBox18.setChecked(false);
        Fine_HoMe_checkBox19.setChecked(false);
        Fine_HoMe_checkBox20.setChecked(false);
        Fine_HoMe_checkBox21.setChecked(false);
        Fine_HoMe_checkBox22.setChecked(false);
        Fine_HoMe_checkBox23.setChecked(false);
        Fine_HoMe_checkBox24.setChecked(false);
        Fine_HoMe_checkBox25.setChecked(false);
        Fine_HoMe_checkBox26.setChecked(false);
        Fine_HoMe_checkBox27.setChecked(false);
        Fine_HoMe_checkBox28.setChecked(false);
        Fine_HoMe_checkBox29.setChecked(false);
        Fine_HoMe_checkBox30.setChecked(false);
        Fine_HoMe_checkBox31.setChecked(false);
        Fine_HoMe_checkBox32.setChecked(false);
        Fine_HoMe_checkBox331.setChecked(false);
        Fine_HoMe_checkBox341.setChecked(false);
        Fine_HoMe_checkBox351.setChecked(false);
        Fine_HoMe_checkBox361.setChecked(false);
        Fine_HoMe_checkBox371.setChecked(false);
        Fine_HoMe_checkBox381.setChecked(false);
        Fine_HoMe_checkBox39.setChecked(false);
        Fine_HoMe_checkBox40.setChecked(false);
        Fine_HoMe_checkBox33.setChecked(false);
        Fine_HoMe_checkBox34.setChecked(false);
        Fine_HoMe_checkBox35.setChecked(false);
        Fine_HoMe_checkBox36.setChecked(false);
        Fine_HoMe_checkBox37.setChecked(false);
        Fine_HoMe_checkBox38.setChecked(false);
        Fine_HoMe_checkBox41.setChecked(false);
        Fine_HoMe_checkBox42.setChecked(false);
        Fine_HoMe_checkBox43.setChecked(false);
        Fine_HoMe_checkBox44.setChecked(false);
        Fine_HoMe_checkBox45.setChecked(false);
        Fine_HoMe_checkBox46.setChecked(false);
        Fine_HoMe_checkBox47.setChecked(false);
        Fine_HoMe_checkBox48.setChecked(false);
        Fine_HoMe_checkBox49.setChecked(false);
        Fine_HoMe_checkBox50.setChecked(false);
        Fine_HoMe_checkBox51.setChecked(false);
        Fine_HoMe_checkBox52.setChecked(false);
        Fine_HoMe_checkBox53.setChecked(false);
        Fine_HoMe_checkBox54.setChecked(false);
        Fine_HoMe_checkBox55.setChecked(false);
        Fine_HoMe_checkBox56.setChecked(false);
        Fine_HoMe_checkBox57.setChecked(false);
        Fine_HoMe_checkBox58.setChecked(false);
        Fine_HoMe_checkBox59.setChecked(false);
        Fine_HoMe_checkBox60.setChecked(false);
        Fine_HoMe_checkBox61.setChecked(false);
        Fine_HoMe_checkBox62.setChecked(false);
        Fine_HoMe_checkBox63.setChecked(false);
        Fine_HoMe_checkBox64.setChecked(false);
        Fine_HoMe_checkBox65.setChecked(false);
        Fine_HoMe_checkBox66.setChecked(false);
        Fine_HoMe_checkBox67.setChecked(false);
        Fine_HoMe_checkBox68.setChecked(false);
        Fine_HoMe_checkBox69.setChecked(false);
        Fine_HoMe_checkBox70.setChecked(false);
        Fine_HoMe_checkBox71.setChecked(false);
        Fine_HoMe_checkBox72.setChecked(false);
        Fine_HoMe_checkBox73.setChecked(false);
        Fine_HoMe_checkBox74.setChecked(false);
        Fine_HoMe_checkBox75.setChecked(false);
        Fine_HoMe_checkBox76.setChecked(false);
        Fine_HoMe_checkBox77.setChecked(false);
        Fine_HoMe_checkBox78.setChecked(false);
        Fine_HoMe_checkBox79.setChecked(false);
        Fine_HoMe_checkBox80.setChecked(false);
        Fine_HoMe_checkBox81.setChecked(false);
        Fine_HoMe_checkBox82.setChecked(false);
        Fine_HoMe_checkBox83.setChecked(false);
        Fine_HoMe_checkBox84.setChecked(false);
        Fine_HoMe_checkBox85.setChecked(false);
        Fine_HoMe_checkBox86.setChecked(false);
        Fine_HoMe_checkBox87.setChecked(false);
        editText14.setText("");
        editText22.setText("");
        editText13.setText("");
        Find_HoMe_editText_masahat_made.setText("");
        Find_HoMe_editText_masahat_ground.setText("");
        Find_HoMe_editText_year_made.setText("");
        Find_HoMe_editText_price_deal.setText("");
        Find_HoMe_editText_moaveze.setText("");
        Find_HoMe_editText_pish_sell_price.setText("");
        Find_HoMe_editText_pish_sell_time.setText("");
        Find_HoMe_editText_vam_mizan.setText("");
        Find_HoMe_editText_vam_sod.setText("");
        Find_HoMe_editText_vam_num_ghest.setText("");
        Find_HoMe_editText_vam_num_ghest2.setText("");
        Find_HoMe_editText_sell_with_moshtari.setText("");
        Find_HoMe_editText.setText("");
        Find_HoMe_editText2.setText("");
        Find_HoMe_editText3.setText("");
        Find_HoMe_editText4.setText("");
        Find_HoMe_editText5.setText("");
        Find_HoMe_editText6.setText("");
        Find_HoMe_editText7.setText("");
        Find_HoMe_editText8.setText("");
        Find_HoMe_editText9.setText("");
        Find_HoMe_editText10.setText("");
        Find_HoMe_editText11.setText("");
        Find_HoMe_editText12.setText("");
        Find_HoMe_editText13.setText("");
        Find_HoMe_editText14.setText("");
        Find_HoMe_editText151.setText("");
        Find_HoMe_editText15.setText("");
        Find_HoMe_editText16.setText("");
        Find_HoMe_editText17.setText("");
        Find_HoMe_editText18.setText("");
        Find_HoMe_editText19.setText("");
        Find_HoMe_editText20.setText("");
        Find_HoMe_editText21.setText("");

    }

    public void Empitier2() {

        moshakhasat_asli_melk_noe_bana = "";
        moshakhasat_asli_melk_masahat_build = "";
        moshakhasat_asli_melk_masahat_zamin = "";
        moshakhasat_asli_melk_sale_build = "";
        price_shrayet_sell_cheng_price_all_sell_cheng = "";
        price_shrayet_sell_cheng_max_money = "";
        price_shrayet_sell_cheng_money_pish_pay = "";
        price_shrayet_sell_cheng_time_tahvil = "";
        price_shrayet_sell_cheng_mizan_vam = "";
        price_shrayet_sell_cheng_sod_vam = "";
        price_shrayet_sell_cheng_number_ghest = "";
        price_shrayet_sell_cheng_price_har_ghest = "";
        price_shrayet_sell_cheng_price_rahn = "";
        more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = "";
        more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = "";
        more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = "";
        more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = "";
        more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari = "";
        more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari = "";
        more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon = "";
        more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon = "";
        more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen = "";
        more_joziat_melk_edari_tejari_neshiman_neshiman_edit = "";
        more_joziat_melk_edari_tejari_nama_nama_edit = "";
        more_joziat_melk_edari_tejari_eskelet_eskelet_edit = "";
        more_joziat_melk_edari_tejari_kaf_kaf_edit = "";
        more_joziat_melk_edari_tejari_divar_divar_edit = "";
        more_joziat_melk_edari_tejari_coldhot_coldhot_edit = "";
        more_joziat_melk_edari_tejari_refahi_refahi_edit = "";
        more_joziat_melk_edari_tejari_safe_safe_edit = "";
        more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = "";
        more_joziat_melk_edari_tejari_sport_sport_edit = "";
        more_joziat_melk_edari_tejari_view_view_edit = "";
        more_joziat_melk_edari_tejari_tozih_about_melk = "";
        address_address_melk = "";
        more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = "";
        moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = "";
        more_joziat_melk_edari_tejari_kitchen_kitchen_radio = "";
        Fine_HoMe_checkBox_reBuildST = "";
        Fine_HoMe_checkBox_ghabel_liveST = "";
        moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = "";
        moshakhasat_asli_melk_number_room = "";
        moshakhasat_asli_melk_number_parking = "";
        Fine_HoMe_checkBox_moavezeST = "";
        Fine_HoMe_checkBox_pish_sellST = "";
        price_shrayet_sell_cheng_check_seel_cheng = "";
        Fine_HoMe_checkBox_vamST = "";
        Fine_HoMe_checkBox_sell_with_moshtariST = "";
        more_joziat_melk_edari_tejari_kitchen_darai_kabinet = "";
        more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchenST = "";
        Fine_HoMe_checkBox3ST = "";
        more_joziat_melk_edari_tejari_neshiman_neshiman_check = "";
        Fine_HoMe_checkBox4ST = "";
        Fine_HoMe_checkBox_neshiman_mobleST = "";
        more_joziat_melk_edari_tejari_nama_nama_check = "";
        Fine_HoMe_checkBox6ST = "";
        Fine_HoMe_checkBox7ST = "";
        Fine_HoMe_checkBox8ST = "";
        Fine_HoMe_checkBox9ST = "";
        Fine_HoMe_checkBox10ST = "";
        Fine_HoMe_checkBox11ST = "";
        Fine_HoMe_checkBox12ST = "";
        Fine_HoMe_checkBox13ST = "";
        more_joziat_melk_edari_tejari_eskelet_eskelet_check = "";
        Fine_HoMe_checkBox15ST = "";
        Fine_HoMe_checkBox14ST = "";
        Fine_HoMe_checkBox16ST = "";
        Fine_HoMe_checkBox17ST = "";
        more_joziat_melk_edari_tejari_kaf_kaf_check = "";
        Fine_HoMe_checkBox19ST = "";
        Fine_HoMe_checkBox20ST = "";
        Fine_HoMe_checkBox21ST = "";
        Fine_HoMe_checkBox22ST = "";
        Fine_HoMe_checkBox23ST = "";
        Fine_HoMe_checkBox24ST = "";
        Fine_HoMe_checkBox25ST = "";
        more_joziat_melk_edari_tejari_divar_divar_check = "";
        Fine_HoMe_checkBox26ST = "";
        Fine_HoMe_checkBox27ST = "";
        Fine_HoMe_checkBox28ST = "";
        Fine_HoMe_checkBox29ST = "";
        Fine_HoMe_checkBox30ST = "";
        Fine_HoMe_checkBox32ST = "";
        Fine_HoMe_checkBox331ST = "";
        more_joziat_melk_edari_tejari_coldhot_coldhot_check = "";
        Fine_HoMe_checkBox341ST = "";
        Fine_HoMe_checkBox351ST = "";
        Fine_HoMe_checkBox361ST = "";
        Fine_HoMe_checkBox371ST = "";
        Fine_HoMe_checkBox381ST = "";
        Fine_HoMe_checkBox39ST = "";
        Fine_HoMe_checkBox40ST = "";
        more_joziat_melk_edari_tejari_refahi_refahi_check = "";
        Fine_HoMe_checkBox33ST = "";
        Fine_HoMe_checkBox34ST = "";
        Fine_HoMe_checkBox35ST = "";
        Fine_HoMe_checkBox36ST = "";
        Fine_HoMe_checkBox37ST = "";
        Fine_HoMe_checkBox38ST = "";
        Fine_HoMe_checkBox41ST = "";
        Fine_HoMe_checkBox42ST = "";
        Fine_HoMe_checkBox45ST = "";
        Fine_HoMe_checkBox46ST = "";
        Fine_HoMe_checkBox44ST = "";
        more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = "";
        Fine_HoMe_checkBox47ST = "";
        Fine_HoMe_checkBox48ST = "";
        Fine_HoMe_checkBox49ST = "";
        Fine_HoMe_checkBox50ST = "";
        Fine_HoMe_checkBox58ST = "";
        Fine_HoMe_checkBox51ST = "";
        Fine_HoMe_checkBox52ST = "";
        Fine_HoMe_checkBox53ST = "";
        Fine_HoMe_checkBox54ST = "";
        Fine_HoMe_checkBox55ST = "";
        Fine_HoMe_checkBox56ST = "";
        Fine_HoMe_checkBox57ST = "";
        Fine_HoMe_checkBox59ST = "";
        Fine_HoMe_checkBox60ST = "";
        Fine_HoMe_checkBox61ST = "";
        Fine_HoMe_checkBox62ST = "";
        Fine_HoMe_checkBox63ST = "";
        more_joziat_melk_edari_tejari_sport_sport_check = "";
        Fine_HoMe_checkBox64ST = "";
        Fine_HoMe_checkBox65ST = "";
        Fine_HoMe_checkBox66ST = "";
        Fine_HoMe_checkBox67ST = "";
        Fine_HoMe_checkBox68ST = "";
        Fine_HoMe_checkBox69ST = "";
        Fine_HoMe_checkBox70ST = "";
        more_joziat_melk_edari_tejari_view_view_check = "";
        Fine_HoMe_checkBox71ST = "";
        Fine_HoMe_checkBox72ST = "";
        Fine_HoMe_checkBox73ST = "";
        Fine_HoMe_checkBox74ST = "";
        Fine_HoMe_checkBox75ST = "";
        Fine_HoMe_checkBox76ST = "";
        Fine_HoMe_checkBox77ST = "";
        Fine_HoMe_checkBox78ST = "";
        more_joziat_melk_edari_tejari_nor_nor_check = "";
        Fine_HoMe_checkBox79ST = "";
        Fine_HoMe_checkBox80ST = "";
        Fine_HoMe_checkBox81ST = "";
        Fine_HoMe_checkBox82ST = "";
        Fine_HoMe_checkBox83ST = "";
        Fine_HoMe_checkBox84ST = "";
        Fine_HoMe_checkBox85ST = "";
        Fine_HoMe_checkBox86ST = "";
        more_joziat_melk_edari_tejari_tasisat_tasisat_edit = "";
        price_shrayet_sell_cheng_mizan_anjam_shode = "";
        more_joziat_melk_edari_tejari_wc_wc_irani = "";
        more_joziat_melk_edari_tejari_wc_wc_us = "";
        more_joziat_melk_edari_tejari_wc_bath = "";
        more_joziat_melk_edari_tejari_kitchen_badane_kabinet = "";
        more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = "";
        more_joziat_melk_edari_tejari_kitchen_roye_kabinet = "";
        more_joziat_melk_edari_tejari_kitchen_kitchen_check = "";
        more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = "";
        more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = "";
        more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = "";
        more_joziat_melk_edari_tejari_tasisat_tasisat_check = "";
        more_joziat_melk_edari_tejari_safe_safe_check = "";
        Fine_HoMe_checkBox18ST = "";
        noe_melk_moamele = "";
        noe_melk = "";
        Fine_HoMe_checkBox31ST = "";
    }

    public void swichSendMaskoni() {
        //----------------------------------------------------------------------- start send maskoni

// neshiman

        if (Fine_HoMe_checkBox3ST == "NotNULL" || Fine_HoMe_checkBox4ST == "NotNULL" || Fine_HoMe_checkBox_neshiman_mobleST == "NotNULL") {

            Vulue3 = "a:" + counter_neshiman + ":{";
            Icounter_neshiman = 0;

            if (Fine_HoMe_checkBox3ST == "NotNULL") {
                if (Icounter_neshiman == 0) {
                    Fine_HoMe_checkBox3ST = "i:" + Icounter_neshiman + ";s:" + "12" + ":" + "\"شومینه\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox3ST;
                    Icounter_neshiman++;
                } else {
                    Fine_HoMe_checkBox3ST = "i:" + Icounter_neshiman + ";s:" + "12" + ":" + "\"شومینه\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox3ST;
                    Icounter_neshiman++;
                }
            }

            if (Fine_HoMe_checkBox4ST == "NotNULL") {
                if (Icounter_neshiman == 0) {
                    Fine_HoMe_checkBox4ST = "i:" + Icounter_neshiman + ";s:" + "26" + ":" + "\"سقف بالای 4 متر\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox4ST;
                } else {
                    Fine_HoMe_checkBox4ST = "i:" + Icounter_neshiman + ";s:" + "26" + ":" + "\"سقف بالای 4 متر\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox4ST;
                    Icounter_neshiman++;
                }
            }

            if (Fine_HoMe_checkBox_neshiman_mobleST == "NotNULL") {
                if (Icounter_neshiman == 0) {
                    Fine_HoMe_checkBox_neshiman_mobleST = "i:" + Icounter_neshiman + ";s:" + "8" + ":" + "\"مبله\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox_neshiman_mobleST;
                } else {
                    Fine_HoMe_checkBox_neshiman_mobleST = "i:" + Icounter_neshiman + ";s:" + "8" + ":" + "\"مبله\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox_neshiman_mobleST;
                    Icounter_neshiman++;
                }
            }

            Vulue3 = Vulue3 + "}";
            more_joziat_melk_edari_tejari_neshiman_neshiman_check = Vulue3;
        }
// -neshiman

// nma

        if (
                Fine_HoMe_checkBox6ST == "NotNULL" ||
                        Fine_HoMe_checkBox7ST == "NotNULL" ||
                        Fine_HoMe_checkBox8ST == "NotNULL" ||
                        Fine_HoMe_checkBox9ST == "NotNULL" ||
                        Fine_HoMe_checkBox10ST == "NotNULL" ||
                        Fine_HoMe_checkBox11ST == "NotNULL" ||
                        Fine_HoMe_checkBox12ST == "NotNULL"

                ) {

            Vulue4 = "a:" + counter_nma + ":{";
            Icounter_nma = 0;

            if (Fine_HoMe_checkBox6ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox6ST = "i:" + Icounter_nma + ";s:" + "18" + ":" + "\"نورپردازی\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox6ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox6ST = "i:" + Icounter_nma + ";s:" + "18" + ":" + "\"نورپردازی\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox6ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox7ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox7ST = "i:" + Icounter_nma + ";s:" + "16" + ":" + "\"کامپوزیت\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox7ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox7ST = "i:" + Icounter_nma + ";s:" + "16" + ":" + "\"کامپوزیت\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox7ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox8ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox8ST = "i:" + Icounter_nma + ";s:" + "8" + ":" + "\"شیشه\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox8ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox8ST = "i:" + Icounter_nma + ";s:" + "8" + ":" + "\"شیشه\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox8ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox9ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox9ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"چوب\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox9ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox9ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"چوب\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox9ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox10ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox10ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox10ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox10ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox10ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox11ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox11ST = "i:" + Icounter_nma + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox11ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox11ST = "i:" + Icounter_nma + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox11ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox12ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox12ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"آجر\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox12ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox12ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"آجر\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox12ST;
                    Icounter_nma++;
                }
            }

            Vulue4 = Vulue4 + "}";
            more_joziat_melk_edari_tejari_nama_nama_check = Vulue4;
        }


// -nma
// eskelet

        if (
                Fine_HoMe_checkBox13ST == "NotNULL" ||
                        Fine_HoMe_checkBox14ST == "NotNULL" ||
                        Fine_HoMe_checkBox15ST == "NotNULL" ||
                        Fine_HoMe_checkBox16ST == "NotNULL"
                ) {

            Vulue5 = "a:" + counter_eskelet + ":{";
            Icounter_eskelet = 0;

            if (Fine_HoMe_checkBox13ST == "NotNULL") {
                if (Icounter_eskelet == 0) {
                    Fine_HoMe_checkBox13ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"بتنی\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox13ST;
                    Icounter_eskelet++;
                } else {
                    Fine_HoMe_checkBox13ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"بتنی\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox13ST;
                    Icounter_eskelet++;
                }
            }

            if (Fine_HoMe_checkBox14ST == "NotNULL") {
                if (Icounter_eskelet == 0) {
                    Fine_HoMe_checkBox14ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"آجری\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox14ST;
                    Icounter_eskelet++;
                } else {
                    Fine_HoMe_checkBox14ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"آجری\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox14ST;
                    Icounter_eskelet++;
                }
            }

            if (Fine_HoMe_checkBox15ST == "NotNULL") {
                if (Icounter_eskelet == 0) {
                    Fine_HoMe_checkBox15ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"فلزی\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox15ST;
                    Icounter_eskelet++;
                } else {
                    Fine_HoMe_checkBox15ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"فلزی\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox15ST;
                    Icounter_eskelet++;
                }
            }

            if (Fine_HoMe_checkBox16ST == "NotNULL") {
                if (Icounter_eskelet == 0) {
                    Fine_HoMe_checkBox16ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"چوبی\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox16ST;
                    Icounter_eskelet++;
                } else {
                    Fine_HoMe_checkBox16ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"چوبی\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox16ST;
                    Icounter_eskelet++;
                }
            }

            Vulue5 = Vulue5 + "}";
            more_joziat_melk_edari_tejari_eskelet_eskelet_check = Vulue5;
        }

// -eskelet
// kaf

        if (
                Fine_HoMe_checkBox17ST == "NotNULL" ||
                        Fine_HoMe_checkBox18ST == "NotNULL" ||
                        Fine_HoMe_checkBox19ST == "NotNULL" ||
                        Fine_HoMe_checkBox20ST == "NotNULL" ||
                        Fine_HoMe_checkBox21ST == "NotNULL" ||
                        Fine_HoMe_checkBox22ST == "NotNULL" ||
                        Fine_HoMe_checkBox23ST == "NotNULL" ||
                        Fine_HoMe_checkBox24ST == "NotNULL"
                ) {

            Vulue6 = "a:" + counter_kaf + ":{";
            Icounter_kaf = 0;

            if (Fine_HoMe_checkBox17ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox17ST = "i:" + Icounter_kaf + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox17ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox17ST = "i:" + Icounter_kaf + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox17ST;
                    Icounter_kaf++;
                }
            }

            if (Fine_HoMe_checkBox18ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox18ST = "i:" + Icounter_kaf + ";s:" + "12" + ":" + "\"سرامیک\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox18ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox18ST = "i:" + Icounter_kaf + ";s:" + "12" + ":" + "\"سرامیک\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox18ST;
                    Icounter_kaf++;
                }
            }

            if (Fine_HoMe_checkBox19ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox19ST = "i:" + Icounter_kaf + ";s:" + "10" + ":" + "\"پارکت\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox19ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox19ST = "i:" + Icounter_kaf + ";s:" + "10" + ":" + "\"پارکت\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox19ST;
                    Icounter_kaf++;
                }
            }

            if (Fine_HoMe_checkBox20ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox20ST = "i:" + Icounter_kaf + ";s:" + "10" + ":" + "\"کفپوش\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox20ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox20ST = "i:" + Icounter_kaf + ";s:" + "10" + ":" + "\"کفپوش\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox20ST;
                    Icounter_kaf++;
                }
            }

            if (Fine_HoMe_checkBox21ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox21ST = "i:" + Icounter_kaf + ";s:" + "8" + ":" + "\"موکت\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox21ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox21ST = "i:" + Icounter_kaf + ";s:" + "8" + ":" + "\"موکت\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox21ST;
                    Icounter_kaf++;
                }
            }

            if (Fine_HoMe_checkBox22ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox22ST = "i:" + Icounter_kaf + ";s:" + "14" + ":" + "\"موزاییک\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox22ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox22ST = "i:" + Icounter_kaf + ";s:" + "14" + ":" + "\"موزاییک\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox22ST;
                    Icounter_kaf++;
                }
            }

            if (Fine_HoMe_checkBox23ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox23ST = "i:" + Icounter_kaf + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox23ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox23ST = "i:" + Icounter_kaf + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox23ST;
                    Icounter_kaf++;
                }
            }

            if (Fine_HoMe_checkBox24ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox24ST = "i:" + Icounter_kaf + ";s:" + "18" + ":" + "\"کف پله دار\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox24ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox24ST = "i:" + Icounter_kaf + ";s:" + "18" + ":" + "\"کف پله دار\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox24ST;
                    Icounter_kaf++;
                }
            }
            Vulue6 = Vulue6 + "}";
            more_joziat_melk_edari_tejari_kaf_kaf_check = Vulue6;
        }

// -kaf
// divar


        if (

                Fine_HoMe_checkBox25ST == "NotNULL" ||
                        Fine_HoMe_checkBox26ST == "NotNULL" ||
                        Fine_HoMe_checkBox27ST == "NotNULL" ||
                        Fine_HoMe_checkBox28ST == "NotNULL" ||
                        Fine_HoMe_checkBox29ST == "NotNULL" ||
                        Fine_HoMe_checkBox30ST == "NotNULL" ||
                        Fine_HoMe_checkBox31ST == "NotNULL" ||
                        Fine_HoMe_checkBox32ST == "NotNULL"

                ) {
            Vulue7 = "a:" + counter_divar + ":{";
            Icounter_divar = 0;

            if (Fine_HoMe_checkBox25ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox25ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox25ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox25ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox25ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox26ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox26ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"رنگ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox26ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox26ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"رنگ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox26ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox27ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox27ST = "i:" + Icounter_divar + ";s:" + "22" + ":" + "\"کاشی / سرامیک\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox27ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox27ST = "i:" + Icounter_divar + ";s:" + "22" + ":" + "\"کاشی / سرامیک\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox27ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox28ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox28ST = "i:" + Icounter_divar + ";s:" + "21" + ":" + "\"کاغذ دیواری\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox28ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox28ST = "i:" + Icounter_divar + ";s:" + "21" + ":" + "\"کاغذ دیواری\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox28ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox29ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox29ST = "i:" + Icounter_divar + ";s:" + "24" + ":" + "\"چوب/ دیوارکوب\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox29ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox29ST = "i:" + Icounter_divar + ";s:" + "24" + ":" + "\"چوب/ دیوارکوب\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox29ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox30ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox30ST = "i:" + Icounter_divar + ";s:" + "4" + ":" + "\"گچ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox30ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox30ST = "i:" + Icounter_divar + ";s:" + "4" + ":" + "\"گچ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox30ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox31ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox31ST = "i:" + Icounter_divar + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox31ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox31ST = "i:" + Icounter_divar + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox31ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox32ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox32ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"آجر\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox32ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox32ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"آجر\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox32ST;
                    Icounter_divar++;
                }
            }
            Vulue7 = Vulue7 + "}";
            more_joziat_melk_edari_tejari_divar_divar_check = Vulue7;
        }


// -divar

// coldhot

        if (
                Fine_HoMe_checkBox331ST == "NotNULL" ||
                        Fine_HoMe_checkBox341ST == "NotNULL" ||
                        Fine_HoMe_checkBox351ST == "NotNULL" ||
                        Fine_HoMe_checkBox361ST == "NotNULL" ||
                        Fine_HoMe_checkBox371ST == "NotNULL" ||
                        Fine_HoMe_checkBox381ST == "NotNULL" ||
                        Fine_HoMe_checkBox39ST == "NotNULL" ||
                        Fine_HoMe_checkBox40ST == "NotNULL"
                ) {

            Vulue8 = "a:" + counter_coldhot + ":{";
            Icounter_coldhot = 0;

            if (Fine_HoMe_checkBox341ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox341ST = "i:" + Icounter_coldhot + ";s:" + "8" + ":" + "\"کولر\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox341ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox341ST = "i:" + Icounter_coldhot + ";s:" + "8" + ":" + "\"کولر\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox341ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox331ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox331ST = "i:" + Icounter_coldhot + ";s:" + "30" + ":" + "\"کولرگازی/ اسپلیت\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox331ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox331ST = "i:" + Icounter_coldhot + ";s:" + "30" + ":" + "\"کولرگازی/ اسپلیت\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox331ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox351ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox351ST = "i:" + Icounter_coldhot + ";s:" + "10" + ":" + "\"بخاری\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox351ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox351ST = "i:" + Icounter_coldhot + ";s:" + "10" + ":" + "\"بخاری\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox351ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox361ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox361ST = "i:" + Icounter_coldhot + ";s:" + "26" + ":" + "\"پکیج/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox361ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox361ST = "i:" + Icounter_coldhot + ";s:" + "26" + ":" + "\"پکیج/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox361ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox371ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox371ST = "i:" + Icounter_coldhot + ";s:" + "24" + ":" + "\"دیگ/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox371ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox371ST = "i:" + Icounter_coldhot + ";s:" + "24" + ":" + "\"دیگ/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox371ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox381ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox381ST = "i:" + Icounter_coldhot + ";s:" + "23" + ":" + "\"چیلر/ فن کوئل\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox381ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox381ST = "i:" + Icounter_coldhot + ";s:" + "23" + ":" + "\"چیلر/ فن کوئل\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox381ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox39ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox39ST = "i:" + Icounter_coldhot + ";s:" + "29" + ":" + "\"آبگرمکن خورشیدی\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox39ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox39ST = "i:" + Icounter_coldhot + ";s:" + "29" + ":" + "\"آبگرمکن خورشیدی\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox39ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox40ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox40ST = "i:" + Icounter_coldhot + ";s:" + "12" + ":" + "\"هواساز\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox40ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox40ST = "i:" + Icounter_coldhot + ";s:" + "12" + ":" + "\"هواساز\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox40ST;
                    Icounter_coldhot++;
                }
            }
            Vulue8 = Vulue8 + "}";
            more_joziat_melk_edari_tejari_coldhot_coldhot_check = Vulue8;
        }


// -coldhot

// refahi

        Vulue9 = "a:" + counter_refahi + ":{";
        Icounter_refahi = 0;
        if (
                Fine_HoMe_checkBox33ST == "NotNULL" ||
                        Fine_HoMe_checkBox34ST == "NotNULL" ||
                        Fine_HoMe_checkBox35ST == "NotNULL" ||
                        Fine_HoMe_checkBox36ST == "NotNULL" ||
                        Fine_HoMe_checkBox37ST == "NotNULL" ||
                        Fine_HoMe_checkBox38ST == "NotNULL"
                ) {

            if (Fine_HoMe_checkBox33ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox33ST = "i:" + Icounter_refahi + ";s:" + "14" + ":" + "\"آسانسور\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox33ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox33ST = "i:" + Icounter_refahi + ";s:" + "14" + ":" + "\"آسانسور\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox33ST;
                    Icounter_refahi++;
                }
            }

            if (Fine_HoMe_checkBox34ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox34ST = "i:" + Icounter_refahi + ";s:" + "39" + ":" + "\"درب پارکینگ ریموت دار\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox34ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox34ST = "i:" + Icounter_refahi + ";s:" + "39" + ":" + "\"درب پارکینگ ریموت دار\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox34ST;
                    Icounter_refahi++;
                }
            }

            if (Fine_HoMe_checkBox35ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox35ST = "i:" + Icounter_refahi + ";s:" + "21" + ":" + "\"شوتیگ زباله\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox35ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox35ST = "i:" + Icounter_refahi + ";s:" + "21" + ":" + "\"شوتیگ زباله\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox35ST;
                    Icounter_refahi++;
                }
            }

            if (Fine_HoMe_checkBox36ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox36ST = "i:" + Icounter_refahi + ";s:" + "19" + ":" + "\"آنتن مرکزی\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox36ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox36ST = "i:" + Icounter_refahi + ";s:" + "19" + ":" + "\"آنتن مرکزی\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox36ST;
                    Icounter_refahi++;
                }
            }

            if (Fine_HoMe_checkBox37ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox37ST = "i:" + Icounter_refahi + ";s:" + "27" + ":" + "\"اینترنت پرسرعت\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox37ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox37ST = "i:" + Icounter_refahi + ";s:" + "27" + ":" + "\"اینترنت پرسرعت\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox37ST;
                    Icounter_refahi++;
                }
            }

            if (Fine_HoMe_checkBox38ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox38ST = "i:" + Icounter_refahi + ";s:" + "19" + ":" + "\"شبکه داخلی\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox38ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox38ST = "i:" + Icounter_refahi + ";s:" + "19" + ":" + "\"شبکه داخلی\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox38ST;
                    Icounter_refahi++;
                }
            }
            Vulue9 = Vulue9 + "}";
            more_joziat_melk_edari_tejari_refahi_refahi_check = Vulue9;
        }

// -refahi

// safe

        if (
                Fine_HoMe_checkBox41ST == "NotNULL" ||
                        Fine_HoMe_checkBox42ST == "NotNULL" ||
                        Fine_HoMe_checkBox43ST == "NotNULL" ||
                        Fine_HoMe_checkBox44ST == "NotNULL" ||
                        Fine_HoMe_checkBox45ST == "NotNULL" ||
                        Fine_HoMe_checkBox46ST == "NotNULL"
                ) {

            Vulue10 = "a:" + counter_safe + ":{";
            Icounter_safe = 0;

            if (Fine_HoMe_checkBox41ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox41ST = "i:" + Icounter_safe + ";s:" + "12" + ":" + "\"دزدگیر\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox41ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox41ST = "i:" + Icounter_safe + ";s:" + "12" + ":" + "\"دزدگیر\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox41ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox42ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox42ST = "i:" + Icounter_safe + ";s:" + "29" + ":" + "\"دوربین مداربسته\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox42ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox42ST = "i:" + Icounter_safe + ";s:" + "29" + ":" + "\"دوربین مداربسته\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox42ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox43ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox43ST = "i:" + Icounter_safe + ";s:" + "23" + ":" + "\"آیفون تصویری\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox43ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox43ST = "i:" + Icounter_safe + ";s:" + "23" + ":" + "\"آیفون تصویری\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox43ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox44ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox44ST = "i:" + Icounter_safe + ";s:" + "20" + ":" + "\"درب ضد سرقت\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox44ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox44ST = "i:" + Icounter_safe + ";s:" + "20" + ":" + "\"درب ضد سرقت\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox44ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox45ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox45ST = "i:" + Icounter_safe + ";s:" + "28" + ":" + "\"سیستم اعلام آتش\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox45ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox45ST = "i:" + Icounter_safe + ";s:" + "28" + ":" + "\"سیستم اعلام آتش\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox45ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox46ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox46ST = "i:" + Icounter_safe + ";s:" + "30" + ":" + "\"سیستم اطفاء حریق\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox46ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox46ST = "i:" + Icounter_safe + ";s:" + "30" + ":" + "\"سیستم اطفاء حریق\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox46ST;
                    Icounter_safe++;
                }
            }


            Vulue10 = Vulue10 + "}";
            more_joziat_melk_edari_tejari_safe_safe_check = Vulue10;

        }

// -safe
// emkanat

        if (
                Fine_HoMe_checkBox47ST == "NotNULL" ||
                        Fine_HoMe_checkBox48ST == "NotNULL" ||
                        Fine_HoMe_checkBox49ST == "NotNULL" ||
                        Fine_HoMe_checkBox50ST == "NotNULL" ||
                        Fine_HoMe_checkBox51ST == "NotNULL" ||
                        Fine_HoMe_checkBox52ST == "NotNULL" ||
                        Fine_HoMe_checkBox53ST == "NotNULL" ||
                        Fine_HoMe_checkBox54ST == "NotNULL" ||
                        Fine_HoMe_checkBox55ST == "NotNULL" ||
                        Fine_HoMe_checkBox56ST == "NotNULL" ||
                        Fine_HoMe_checkBox57ST == "NotNULL" ||
                        Fine_HoMe_checkBox58ST == "NotNULL"
                ) {

            Vulue11 = "a:" + counter_emkanat + ":{";
            Icounter_emkanat = 0;

            if (Fine_HoMe_checkBox47ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox47ST = "i:" + Icounter_emkanat + ";s:" + "17" + ":" + "\"حیاط خلوت\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox47ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox47ST = "i:" + Icounter_emkanat + ";s:" + "17" + ":" + "\"حیاط خلوت\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox47ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox48ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox48ST = "i:" + Icounter_emkanat + ";s:" + "16" + ":" + "\"سرایداری\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox48ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox48ST = "i:" + Icounter_emkanat + ";s:" + "16" + ":" + "\"سرایداری\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox48ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox49ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox49ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"لابی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox49ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox49ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"لابی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox49ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox50ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox50ST = "i:" + Icounter_emkanat + ";s:" + "6" + ":" + "\"باغ\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox50ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox50ST = "i:" + Icounter_emkanat + ";s:" + "6" + ":" + "\"باغ\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox50ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox51ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox51ST = "i:" + Icounter_emkanat + ";s:" + "11" + ":" + "\"آب نما\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox51ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox51ST = "i:" + Icounter_emkanat + ";s:" + "11" + ":" + "\"آب نما\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox51ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox52ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox52ST = "i:" + Icounter_emkanat + ";s:" + "16" + ":" + "\"باربیکیو\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox52ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox52ST = "i:" + Icounter_emkanat + ";s:" + "16" + ":" + "\"باربیکیو\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox52ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox53ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox53ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"حیاط\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox53ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox53ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"حیاط\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox53ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox54ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox54ST = "i:" + Icounter_emkanat + ";s:" + "15" + ":" + "\"فضای سبز\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox54ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox54ST = "i:" + Icounter_emkanat + ";s:" + "15" + ":" + "\"فضای سبز\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox54ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox55ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox55ST = "i:" + Icounter_emkanat + ";s:" + "14" + ":" + "\"نگهبانی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox55ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox55ST = "i:" + Icounter_emkanat + ";s:" + "14" + ":" + "\"نگهبانی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox55ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox56ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox56ST = "i:" + Icounter_emkanat + ";s:" + "25" + ":" + "\"سالن اجتماعات\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox56ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox56ST = "i:" + Icounter_emkanat + ";s:" + "25" + ":" + "\"سالن اجتماعات\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox56ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox57ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox57ST = "i:" + Icounter_emkanat + ";s:" + "12" + ":" + "\"آلاچیق\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox57ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox57ST = "i:" + Icounter_emkanat + ";s:" + "12" + ":" + "\"آلاچیق\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox57ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox58ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox58ST = "i:" + Icounter_emkanat + ";s:" + "13" + ":" + "\"بام سبز\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox58ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox58ST = "i:" + Icounter_emkanat + ";s:" + "13" + ":" + "\"بام سبز\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox58ST;
                    Icounter_emkanat++;
                }
            }
            Vulue11 = Vulue11 + "}";
            more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = Vulue11;

        }


// -emkanat
// sport

        if (

                Fine_HoMe_checkBox59ST == "NotNULL" ||
                        Fine_HoMe_checkBox60ST == "NotNULL" ||
                        Fine_HoMe_checkBox61ST == "NotNULL" ||
                        Fine_HoMe_checkBox62ST == "NotNULL" ||
                        Fine_HoMe_checkBox63ST == "NotNULL" ||
                        Fine_HoMe_checkBox64ST == "NotNULL" ||
                        Fine_HoMe_checkBox65ST == "NotNULL" ||
                        Fine_HoMe_checkBox66ST == "NotNULL" ||
                        Fine_HoMe_checkBox67ST == "NotNULL" ||
                        Fine_HoMe_checkBox68ST == "NotNULL" ||
                        Fine_HoMe_checkBox69ST == "NotNULL" ||
                        Fine_HoMe_checkBox70ST == "NotNULL"
                ) {

            Vulue12 = "a:" + counter_sport + ":{";
            Icounter_sport = 0;

            if (Fine_HoMe_checkBox59ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox59ST = "i:" + Icounter_sport + ";s:" + "10" + ":" + "\"استخر\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox59ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox59ST = "i:" + Icounter_sport + ";s:" + "10" + ":" + "\"استخر\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox59ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox60ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox60ST = "i:" + Icounter_sport + ";s:" + "8" + ":" + "\"سونا\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox60ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox60ST = "i:" + Icounter_sport + ";s:" + "8" + ":" + "\"سونا\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox60ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox61ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox61ST = "i:" + Icounter_sport + ";s:" + "10" + ":" + "\"جکوزی\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox61ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox61ST = "i:" + Icounter_sport + ";s:" + "10" + ":" + "\"جکوزی\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox61ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox62ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox62ST = "i:" + Icounter_sport + ";s:" + "14" + ":" + "\"بیلیارد\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox62ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox62ST = "i:" + Icounter_sport + ";s:" + "14" + ":" + "\"بیلیارد\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox62ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox63ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox63ST = "i:" + Icounter_sport + ";s:" + "12" + ":" + "\"فوتبال\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox63ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox63ST = "i:" + Icounter_sport + ";s:" + "12" + ":" + "\"فوتبال\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox63ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox64ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox64ST = "i:" + Icounter_sport + ";s:" + "14" + ":" + "\"بسکتبال\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox64ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox64ST = "i:" + Icounter_sport + ";s:" + "14" + ":" + "\"بسکتبال\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox64ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox65ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox65ST = "i:" + Icounter_sport + ";s:" + "14" + ":" + "\"والیبال\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox65ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox65ST = "i:" + Icounter_sport + ";s:" + "14" + ":" + "\"والیبال\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox65ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox66ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox66ST = "i:" + Icounter_sport + ";s:" + "8" + ":" + "\"تنیس\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox66ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox66ST = "i:" + Icounter_sport + ";s:" + "8" + ":" + "\"تنیس\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox66ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox67ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox67ST = "i:" + Icounter_sport + ";s:" + "15" + ":" + "\"پینگ پنگ\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox67ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox67ST = "i:" + Icounter_sport + ";s:" + "15" + ":" + "\"پینگ پنگ\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox67ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox68ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox68ST = "i:" + Icounter_sport + ";s:" + "24" + ":" + "\"سالن بدن سازی\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox68ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox68ST = "i:" + Icounter_sport + ";s:" + "24" + ":" + "\"سالن بدن سازی\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox68ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox69ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox69ST = "i:" + Icounter_sport + ";s:" + "30" + ":" + "\"زمین بازی کودکان\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox69ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox69ST = "i:" + Icounter_sport + ";s:" + "30" + ":" + "\"زمین بازی کودکان\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox69ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox70ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox70ST = "i:" + Icounter_sport + ";s:" + "12" + ":" + "\"اسکواش\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox70ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox70ST = "i:" + Icounter_sport + ";s:" + "12" + ":" + "\"اسکواش\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox70ST;
                    Icounter_sport++;
                }
            }
            Vulue12 = Vulue12 + "}";
            more_joziat_melk_edari_tejari_sport_sport_check = Vulue12;
        }


// -sport
// view

        if (

                Fine_HoMe_checkBox71ST == "NotNULL" ||
                        Fine_HoMe_checkBox72ST == "NotNULL" ||
                        Fine_HoMe_checkBox73ST == "NotNULL" ||
                        Fine_HoMe_checkBox74ST == "NotNULL" ||
                        Fine_HoMe_checkBox75ST == "NotNULL" ||
                        Fine_HoMe_checkBox76ST == "NotNULL" ||
                        Fine_HoMe_checkBox77ST == "NotNULL" ||
                        Fine_HoMe_checkBox78ST == "NotNULL"
                ) {

            Vulue13 = "a:" + counter_view + ":{";
            Icounter_view = 0;

            if (Fine_HoMe_checkBox71ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox71ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"شهر\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox71ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox71ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"شهر\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox71ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox72ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox72ST = "i:" + Icounter_view + ";s:" + "12" + ":" + "\"اتوبان\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox72ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox72ST = "i:" + Icounter_view + ";s:" + "12" + ":" + "\"اتوبان\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox72ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox73ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox73ST = "i:" + Icounter_view + ";s:" + "12" + ":" + "\"خیابان\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox73ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox73ST = "i:" + Icounter_view + ";s:" + "12" + ":" + "\"خیابان\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox73ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox74ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox74ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"کوچه\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox74ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox74ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"کوچه\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox74ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox75ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox75ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"دریا\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox75ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox75ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"دریا\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox75ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox76ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox76ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"جنگل\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox76ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox76ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"جنگل\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox76ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox77ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox77ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"کوه\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox77ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox77ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"کوه\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox77ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox78ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox78ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"باغ\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox78ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox78ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"باغ\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox78ST;
                    Icounter_view++;
                }
            }
            Vulue13 = Vulue13 + "}";
            more_joziat_melk_edari_tejari_view_view_check = Vulue13;
        }


// -view
// nor

        Vulue14 = "a:" + counter_nor + ":{";
        Icounter_nor = 0;
        if (

                Fine_HoMe_checkBox79ST == "NotNULL" ||
                        Fine_HoMe_checkBox80ST == "NotNULL" ||
                        Fine_HoMe_checkBox81ST == "NotNULL" ||
                        Fine_HoMe_checkBox82ST == "NotNULL"
                ) {

            if (Fine_HoMe_checkBox79ST == "NotNULL") {
                if (Icounter_nor == 0) {
                    Fine_HoMe_checkBox79ST = "i:" + Icounter_nor + ";s:" + "8" + ":" + "\"شمال\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox79ST;
                    Icounter_nor++;
                } else {
                    Fine_HoMe_checkBox79ST = "i:" + Icounter_nor + ";s:" + "8" + ":" + "\"شمال\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox79ST;
                    Icounter_nor++;
                }
            }

            if (Fine_HoMe_checkBox80ST == "NotNULL") {
                if (Icounter_nor == 0) {
                    Fine_HoMe_checkBox80ST = "i:" + Icounter_nor + ";s:" + "8" + ":" + "\"جنوب\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox80ST;
                    Icounter_nor++;
                } else {
                    Fine_HoMe_checkBox80ST = "i:" + Icounter_nor + ";s:" + "8" + ":" + "\"جنوب\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox80ST;
                    Icounter_nor++;
                }
            }

            if (Fine_HoMe_checkBox81ST == "NotNULL") {
                if (Icounter_nor == 0) {
                    Fine_HoMe_checkBox81ST = "i:" + Icounter_nor + ";s:" + "6" + ":" + "\"شرق\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox81ST;
                    Icounter_nor++;
                } else {
                    Fine_HoMe_checkBox81ST = "i:" + Icounter_nor + ";s:" + "6" + ":" + "\"شرق\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox81ST;
                    Icounter_nor++;
                }
            }

            if (Fine_HoMe_checkBox82ST == "NotNULL") {
                if (Icounter_nor == 0) {
                    Fine_HoMe_checkBox82ST = "i:" + Icounter_nor + ";s:" + "6" + ":" + "\"غرب\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox82ST;
                    Icounter_nor++;
                } else {
                    Fine_HoMe_checkBox82ST = "i:" + Icounter_nor + ";s:" + "6" + ":" + "\"غرب\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox82ST;
                    Icounter_nor++;
                }
            }
            Vulue14 = Vulue14 + "}";
            more_joziat_melk_edari_tejari_nor_nor_check = Vulue14;
        }


// -nor
// tasisat


        if (

                Fine_HoMe_checkBox83ST == "NotNULL" ||
                        Fine_HoMe_checkBox84ST == "NotNULL" ||
                        Fine_HoMe_checkBox85ST == "NotNULL" ||
                        Fine_HoMe_checkBox86ST == "NotNULL"
                ) {

            Vulue15 = "a:" + counter_tasisat + ":{";
            Icounter_tasisat = 0;

            if (Fine_HoMe_checkBox83ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox83ST = "i:" + Icounter_tasisat + ";s:" + "13" + ":" + "\"آب شهری\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox83ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox83ST = "i:" + Icounter_tasisat + ";s:" + "13" + ":" + "\"آب شهری\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox83ST;
                    Icounter_tasisat++;
                }
            }

            if (Fine_HoMe_checkBox84ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox84ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox84ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox84ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox84ST;
                    Icounter_tasisat++;
                }
            }

            if (Fine_HoMe_checkBox85ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox85ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"گاز\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox85ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox85ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"گاز\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox85ST;
                    Icounter_tasisat++;
                }
            }

            if (Fine_HoMe_checkBox86ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox86ST = "i:" + Icounter_tasisat + ";s:" + "21" + ":" + "\"ژنراتور برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox86ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox86ST = "i:" + Icounter_tasisat + ";s:" + "21" + ":" + "\"ژنراتور برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox86ST;
                    Icounter_tasisat++;
                }
            }
            Vulue15 = Vulue15 + "}";
            more_joziat_melk_edari_tejari_tasisat_tasisat_check = Vulue15;
        }


// -tasisat
// Vulue2

        if (

                Fine_HoMe_checkBox_moavezeST == "NotNULL" ||
                        Fine_HoMe_checkBox_pish_sellST == "NotNULL" ||
                        Fine_HoMe_checkBox_vamST == "NotNULL" ||
                        Fine_HoMe_checkBox_sell_with_moshtariST == "NotNULL"

                ) {

            Vulue2 = "a:" + counter_check_seel_cheng + ":{";
            Icounter_check_seel_cheng = 0;

            if (Fine_HoMe_checkBox_moavezeST == "NotNULL") {
                if (Icounter_check_seel_cheng == 0) {
                    Fine_HoMe_checkBox_moavezeST = "i:" + Icounter_check_seel_cheng + ";s:" + "12" + ":" + "\"معاوضه\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_moavezeST;
                    Icounter_check_seel_cheng++;
                } else {
                    Fine_HoMe_checkBox_moavezeST = "i:" + Icounter_check_seel_cheng + ";s:" + "12" + ":" + "\"معاوضه\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_moavezeST;
                    Icounter_check_seel_cheng++;
                }
            }

            if (Fine_HoMe_checkBox_pish_sellST == "NotNULL") {
                if (Icounter_check_seel_cheng == 0) {
                    Fine_HoMe_checkBox_pish_sellST = "i:" + Icounter_check_seel_cheng + ";s:" + "15" + ":" + "\"پیش فروش\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_pish_sellST;
                    Icounter_check_seel_cheng++;
                } else {
                    Fine_HoMe_checkBox_pish_sellST = "i:" + Icounter_check_seel_cheng + ";s:" + "15" + ":" + "\"پیش فروش\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_pish_sellST;
                    Icounter_check_seel_cheng++;
                }
            }

            if (Fine_HoMe_checkBox_vamST == "NotNULL") {
                if (Icounter_check_seel_cheng == 0) {
                    Fine_HoMe_checkBox_vamST = "i:" + Icounter_check_seel_cheng + ";s:" + "17" + ":" + "\"دارای وام\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_vamST;
                    Icounter_check_seel_cheng++;
                } else {
                    Fine_HoMe_checkBox_vamST = "i:" + Icounter_check_seel_cheng + ";s:" + "17" + ":" + "\"دارای وام\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_vamST;
                    Icounter_check_seel_cheng++;
                }
            }

            if (Fine_HoMe_checkBox_sell_with_moshtariST == "NotNULL") {
                if (Icounter_check_seel_cheng == 0) {
                    Fine_HoMe_checkBox_sell_with_moshtariST = "i:" + Icounter_check_seel_cheng + ";s:" + "26" + ":" + "\"فروش با مستاجر\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_sell_with_moshtariST;
                    Icounter_check_seel_cheng++;
                } else {
                    Fine_HoMe_checkBox_sell_with_moshtariST = "i:" + Icounter_check_seel_cheng + ";s:" + "26" + ":" + "\"فروش با مستاجر\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_sell_with_moshtariST;
                    Icounter_check_seel_cheng++;
                }
            }
            Vulue2 = Vulue2 + "}";
            price_shrayet_sell_cheng_check_seel_cheng = Vulue2;
        }


// -Vulue2
// Vulue1

        if (
                Fine_HoMe_checkBox_reBuildST == "NotNULL" ||
                        Fine_HoMe_checkBox_ghabel_liveST == "NotNULL"
                ) {

            Vulue1 = "a:" + counter_vaziita_build + ":{";
            Icounter_vaziita_build = 0;

            if (Fine_HoMe_checkBox_reBuildST == "NotNULL") {
                if (Icounter_vaziita_build == 0) {
                    Fine_HoMe_checkBox_reBuildST = "i:" + Icounter_vaziita_build + ";s:" + "21" + ":" + "\"بازسازی شده\"" + ";";
                    Vulue1 = Vulue1 + Fine_HoMe_checkBox_reBuildST;
                    Icounter_vaziita_build++;
                } else {
                    Fine_HoMe_checkBox_reBuildST = "i:" + Icounter_vaziita_build + ";s:" + "21" + ":" + "\"بازسازی شده\"" + ";";
                    Vulue1 = Vulue1 + Fine_HoMe_checkBox_reBuildST;
                    Icounter_vaziita_build++;
                }
            }

            if (Fine_HoMe_checkBox_ghabel_liveST == "NotNULL") {
                if (Icounter_vaziita_build == 0) {
                    Fine_HoMe_checkBox_ghabel_liveST = "i:" + Icounter_vaziita_build + ";s:" + "19" + ":" + "\"قابل سکونت\"" + ";";
                    Vulue1 = Vulue1 + Fine_HoMe_checkBox_ghabel_liveST;
                    Icounter_vaziita_build++;
                } else {
                    Fine_HoMe_checkBox_ghabel_liveST = "i:" + Icounter_vaziita_build + ";s:" + "19" + ":" + "\"قابل سکونت\"" + ";";
                    Vulue1 = Vulue1 + Fine_HoMe_checkBox_ghabel_liveST;
                    Icounter_vaziita_build++;
                }
            }

            Vulue1 = Vulue1 + "}";
            moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = Vulue1;
        }


// -Vulue1
// radio

        int selectedId = RadioGP2.getCheckedRadioButtonId();
        radioButton_find_home = (RadioButton) findViewById(selectedId);
        moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = (String) radioButton_find_home.getText();


        int selectedId2 = RadioGP.getCheckedRadioButtonId();
        radioButton_find_home2 = (RadioButton) findViewById(selectedId2);
        more_joziat_melk_edari_tejari_kitchen_kitchen_radio = (String) radioButton_find_home2.getText();

        int selectedId3 = RadioGP3.getCheckedRadioButtonId();
        radioButton_find_home3 = (RadioButton) findViewById(selectedId3);
        more_joziat_melk_edari_tejari_shekle_build_radio = (String) radioButton_find_home3.getText();


// -radio
// edit


        moshakhasat_asli_melk_masahat_build = Find_HoMe_editText_masahat_made.getText().toString();
        moshakhasat_asli_melk_masahat_zamin = Find_HoMe_editText_masahat_ground.getText().toString();

        moshakhasat_asli_melk_sale_build = Find_HoMe_editText_year_made.getText().toString();
        price_shrayet_sell_cheng_price_all_sell_cheng = Find_HoMe_editText_price_deal.getText().toString();
        price_shrayet_sell_cheng_max_money = Find_HoMe_editText_moaveze.getText().toString();
        price_shrayet_sell_cheng_money_pish_pay = Find_HoMe_editText_pish_sell_price.getText().toString();
        price_shrayet_sell_cheng_time_tahvil = Find_HoMe_editText_pish_sell_time.getText().toString();
        price_shrayet_sell_cheng_mizan_vam = Find_HoMe_editText_vam_mizan.getText().toString();
        price_shrayet_sell_cheng_sod_vam = Find_HoMe_editText_vam_sod.getText().toString();
        price_shrayet_sell_cheng_number_ghest = Find_HoMe_editText_vam_num_ghest.getText().toString();
        price_shrayet_sell_cheng_price_har_ghest = Find_HoMe_editText_vam_num_ghest2.getText().toString();
        price_shrayet_sell_cheng_price_rahn = Find_HoMe_editText_sell_with_moshtari.getText().toString();
        more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = Find_HoMe_editText.getText().toString();
        more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = Find_HoMe_editText2.getText().toString();
        more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = Find_HoMe_editText3.getText().toString();
        more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = Find_HoMe_editText4.getText().toString();
        more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari = Find_HoMe_editText5.getText().toString();
        more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari = Find_HoMe_editText6.getText().toString();
        more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon = Find_HoMe_editText7.getText().toString();
        more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon = Find_HoMe_editText8.getText().toString();
        more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen = Find_HoMe_editText10.getText().toString();
        more_joziat_melk_edari_tejari_neshiman_neshiman_edit = Find_HoMe_editText9.getText().toString();
        more_joziat_melk_edari_tejari_nama_nama_edit = Find_HoMe_editText11.getText().toString();
        more_joziat_melk_edari_tejari_eskelet_eskelet_edit = Find_HoMe_editText12.getText().toString();
        more_joziat_melk_edari_tejari_kaf_kaf_edit = Find_HoMe_editText13.getText().toString();
        more_joziat_melk_edari_tejari_divar_divar_edit = Find_HoMe_editText14.getText().toString();
        more_joziat_melk_edari_tejari_coldhot_coldhot_edit = Find_HoMe_editText151.getText().toString();
        more_joziat_melk_edari_tejari_refahi_refahi_edit = Find_HoMe_editText15.getText().toString();
        more_joziat_melk_edari_tejari_safe_safe_edit = Find_HoMe_editText16.getText().toString();
        more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = Find_HoMe_editText17.getText().toString();
        more_joziat_melk_edari_tejari_sport_sport_edit = Find_HoMe_editText18.getText().toString();
        more_joziat_melk_edari_tejari_view_view_edit = Find_HoMe_editText19.getText().toString();
        more_joziat_melk_edari_tejari_tozih_about_melk = Find_HoMe_editText20.getText().toString();
        address_address_melk = Find_HoMe_editText21.getText().toString();
        more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = Find_HoMe_editText2.getText().toString();
// -edit
// emkanat

        Vulue11 = "a:" + counter_emkanat + ":{";
        Icounter_emkanat = 0;
        if (
                Fine_HoMe_checkBox47ST == "NotNULL" ||
                        Fine_HoMe_checkBox48ST == "NotNULL" ||
                        Fine_HoMe_checkBox49ST == "NotNULL" ||
                        Fine_HoMe_checkBox50ST == "NotNULL" ||
                        Fine_HoMe_checkBox51ST == "NotNULL" ||
                        Fine_HoMe_checkBox52ST == "NotNULL" ||
                        Fine_HoMe_checkBox53ST == "NotNULL" ||
                        Fine_HoMe_checkBox54ST == "NotNULL" ||
                        Fine_HoMe_checkBox55ST == "NotNULL" ||
                        Fine_HoMe_checkBox56ST == "NotNULL" ||
                        Fine_HoMe_checkBox57ST == "NotNULL" ||
                        Fine_HoMe_checkBox58ST == "NotNULL"
                ) {

            if (Fine_HoMe_checkBox47ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox47ST = "i:" + Icounter_emkanat + ";s:" + "17" + ":" + "\"حیاط خلوت\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox47ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox47ST = "i:" + Icounter_emkanat + ";s:" + "17" + ":" + "\"حیاط خلوت\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox47ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox48ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox48ST = "i:" + Icounter_emkanat + ";s:" + "16" + ":" + "\"سرایداری\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox48ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox48ST = "i:" + Icounter_emkanat + ";s:" + "16" + ":" + "\"سرایداری\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox48ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox49ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox49ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"لابی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox49ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox49ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"لابی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox49ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox50ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox50ST = "i:" + Icounter_emkanat + ";s:" + "6" + ":" + "\"باغ\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox50ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox50ST = "i:" + Icounter_emkanat + ";s:" + "6" + ":" + "\"باغ\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox50ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox51ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox51ST = "i:" + Icounter_emkanat + ";s:" + "11" + ":" + "\"آب نما\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox51ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox51ST = "i:" + Icounter_emkanat + ";s:" + "11" + ":" + "\"آب نما\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox51ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox52ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox52ST = "i:" + Icounter_emkanat + ";s:" + "16" + ":" + "\"باربیکیو\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox52ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox52ST = "i:" + Icounter_emkanat + ";s:" + "16" + ":" + "\"باربیکیو\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox52ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox53ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox53ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"حیاط\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox53ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox53ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"حیاط\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox53ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox54ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox54ST = "i:" + Icounter_emkanat + ";s:" + "15" + ":" + "\"فضای سبز\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox54ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox54ST = "i:" + Icounter_emkanat + ";s:" + "15" + ":" + "\"فضای سبز\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox54ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox55ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox55ST = "i:" + Icounter_emkanat + ";s:" + "14" + ":" + "\"نگهبانی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox55ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox55ST = "i:" + Icounter_emkanat + ";s:" + "14" + ":" + "\"نگهبانی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox55ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox56ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox56ST = "i:" + Icounter_emkanat + ";s:" + "25" + ":" + "\"سالن اجتماعات\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox56ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox56ST = "i:" + Icounter_emkanat + ";s:" + "25" + ":" + "\"سالن اجتماعات\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox56ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox57ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox57ST = "i:" + Icounter_emkanat + ";s:" + "12" + ":" + "\"آلاچیق\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox57ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox57ST = "i:" + Icounter_emkanat + ";s:" + "12" + ":" + "\"آلاچیق\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox57ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox58ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox58ST = "i:" + Icounter_emkanat + ";s:" + "13" + ":" + "\"بام سبز\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox58ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox58ST = "i:" + Icounter_emkanat + ";s:" + "13" + ":" + "\"بام سبز\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox58ST;
                    Icounter_emkanat++;
                }
            }


        }
        Vulue11 = Vulue11 + "}";
        more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = Vulue11;

// -emkanat

        editText.setText(

                "noe_melk_moamele = " + noe_melk_moamele
                        + "\n noe_melk = " + noe_melk
                        + "\n moshakhasat_asli_melk_noe_bana = " + moshakhasat_asli_melk_noe_bana
                        + "\n moshakhasat_asli_melk_masahat_build = " + moshakhasat_asli_melk_masahat_build
                        + "\n moshakhasat_asli_melk_masahat_zamin = " + moshakhasat_asli_melk_masahat_zamin
                        + "\n moshakhasat_asli_melk_number_room = " + moshakhasat_asli_melk_number_room
                        + "\n moshakhasat_asli_melk_number_parking = " + moshakhasat_asli_melk_number_parking
                        + "\n moshakhasat_asli_melk_sale_build = " + moshakhasat_asli_melk_sale_build
                        + "\n moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = " + moshakhasat_asli_melk_vaziita_build_vaziita_build_radio
                        + "\n moshakhasat_asli_melk_vaziita_build_ghabel_sokonat = " + moshakhasat_asli_melk_vaziita_build_ghabel_sokonat
                        + "\n price_shrayet_sell_cheng_price_all_sell_cheng = " + price_shrayet_sell_cheng_price_all_sell_cheng
                        + "\n price_shrayet_sell_cheng_check_seel_cheng = " + price_shrayet_sell_cheng_check_seel_cheng
                        + "\n price_shrayet_sell_cheng_max_money = " + price_shrayet_sell_cheng_max_money
                        + "\n price_shrayet_sell_cheng_money_pish_pay = " + price_shrayet_sell_cheng_money_pish_pay
                        + "\n price_shrayet_sell_cheng_time_tahvil = " + price_shrayet_sell_cheng_time_tahvil
                        + "\n price_shrayet_sell_cheng_mizan_anjam_shode = " + price_shrayet_sell_cheng_mizan_anjam_shode
                        + "\n price_shrayet_sell_cheng_mizan_vam = " + price_shrayet_sell_cheng_mizan_vam
                        + "\n price_shrayet_sell_cheng_sod_vam = " + price_shrayet_sell_cheng_sod_vam
                        + "\n price_shrayet_sell_cheng_number_ghest = " + price_shrayet_sell_cheng_number_ghest
                        + "\n price_shrayet_sell_cheng_price_har_ghest = " + price_shrayet_sell_cheng_price_har_ghest
                        + "\n price_shrayet_sell_cheng_price_rahn = " + price_shrayet_sell_cheng_price_rahn
                        + "\n more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = " + more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe
                        + "\n more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = " + more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe
                        + "\n more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = " + more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe
                        + "\n more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = " + more_joziat_melk_edari_tejari_moghit_build_number_all_vahed
                        + "\n more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = " + more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build
                        + "\n more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari = " + more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari
                        + "\n more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari = " + more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari
                        + "\n more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon = " + more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon
                        + "\n more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon = " + more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon
                        + "\n more_joziat_melk_edari_tejari_wc_wc_irani = " + more_joziat_melk_edari_tejari_wc_wc_irani
                        + "\n more_joziat_melk_edari_tejari_wc_wc_us = " + more_joziat_melk_edari_tejari_wc_wc_us
                        + "\n more_joziat_melk_edari_tejari_wc_bath = " + more_joziat_melk_edari_tejari_wc_bath
                        + "\n more_joziat_melk_edari_tejari_kitchen_kitchen_check = " + more_joziat_melk_edari_tejari_kitchen_kitchen_check
                        + "\n more_joziat_melk_edari_tejari_kitchen_kitchen_radio = " + more_joziat_melk_edari_tejari_kitchen_kitchen_radio
                        + "\n more_joziat_melk_edari_tejari_kitchen_darai_kabinet = " + more_joziat_melk_edari_tejari_kitchen_darai_kabinet
                        + "\n more_joziat_melk_edari_tejari_kitchen_badane_kabinet = " + more_joziat_melk_edari_tejari_kitchen_badane_kabinet
                        + "\n more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = " + more_joziat_melk_edari_tejari_kitchen_safhe_kabinet
                        + "\n more_joziat_melk_edari_tejari_kitchen_roye_kabinet = " + more_joziat_melk_edari_tejari_kitchen_roye_kabinet
                        + "\n more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen = " + more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchenST
                        + "\n more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen = " + more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen
                        + "\n more_joziat_melk_edari_tejari_neshiman_neshiman_check = " + more_joziat_melk_edari_tejari_neshiman_neshiman_check
                        + "\n more_joziat_melk_edari_tejari_neshiman_neshiman_edit = " + more_joziat_melk_edari_tejari_neshiman_neshiman_edit
                        + "\n more_joziat_melk_edari_tejari_shekle_build_radio = " + more_joziat_melk_edari_tejari_shekle_build_radio
                        + "\n more_joziat_melk_edari_tejari_nama_nama_check = " + more_joziat_melk_edari_tejari_nama_nama_check
                        + "\n more_joziat_melk_edari_tejari_nama_nama_edit = " + more_joziat_melk_edari_tejari_nama_nama_edit
                        + "\n more_joziat_melk_edari_tejari_eskelet_eskelet_check = " + more_joziat_melk_edari_tejari_eskelet_eskelet_check
                        + "\n more_joziat_melk_edari_tejari_eskelet_eskelet_edit = " + more_joziat_melk_edari_tejari_eskelet_eskelet_edit
                        + "\n more_joziat_melk_edari_tejari_kaf_kaf_check = " + more_joziat_melk_edari_tejari_kaf_kaf_check
                        + "\n more_joziat_melk_edari_tejari_kaf_kaf_edit = " + more_joziat_melk_edari_tejari_kaf_kaf_edit
                        + "\n more_joziat_melk_edari_tejari_divar_divar_check = " + more_joziat_melk_edari_tejari_divar_divar_check
                        + "\n more_joziat_melk_edari_tejari_divar_divar_edit = " + more_joziat_melk_edari_tejari_divar_divar_edit
                        + "\n more_joziat_melk_edari_tejari_coldhot_coldhot_check = " + more_joziat_melk_edari_tejari_coldhot_coldhot_check
                        + "\n more_joziat_melk_edari_tejari_coldhot_coldhot_edit = " + more_joziat_melk_edari_tejari_coldhot_coldhot_edit
                        + "\n more_joziat_melk_edari_tejari_refahi_refahi_check = " + more_joziat_melk_edari_tejari_refahi_refahi_check
                        + "\n more_joziat_melk_edari_tejari_refahi_refahi_edit = " + more_joziat_melk_edari_tejari_refahi_refahi_edit
                        + "\n more_joziat_melk_edari_tejari_safe_safe_check = " + more_joziat_melk_edari_tejari_safe_safe_check
                        + "\n more_joziat_melk_edari_tejari_safe_safe_edit = " + more_joziat_melk_edari_tejari_safe_safe_edit
                        + "\n more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = " + more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta
                        + "\n more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = " + more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit
                        + "\n more_joziat_melk_edari_tejari_sport_sport_check = " + more_joziat_melk_edari_tejari_sport_sport_check
                        + "\n more_joziat_melk_edari_tejari_sport_sport_edit = " + more_joziat_melk_edari_tejari_sport_sport_edit
                        + "\n more_joziat_melk_edari_tejari_view_view_check = " + more_joziat_melk_edari_tejari_view_view_check
                        + "\n more_joziat_melk_edari_tejari_view_view_edit = " + more_joziat_melk_edari_tejari_view_view_edit
                        + "\n more_joziat_melk_edari_tejari_nor_nor_check = " + more_joziat_melk_edari_tejari_nor_nor_check
                        + "\n more_joziat_melk_edari_tejari_tasisat_tasisat_check = " + more_joziat_melk_edari_tejari_tasisat_tasisat_check
                        + "\n more_joziat_melk_edari_tejari_tasisat_tasisat_edit = " + more_joziat_melk_edari_tejari_tasisat_tasisat_edit
                        + "\n more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = " + more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat
                        + "\n more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = " + more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat
                        + "\n more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = " + more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam


        );


//------------------------------------------------------end of send maskoni
    }

    public void swichSendEdari() {

//------------------------------------------------------ start of send edari
// Vulue2

        if (

                Fine_HoMe_checkBox_moavezeST == "NotNULL" ||
                        Fine_HoMe_checkBox_pish_sellST == "NotNULL" ||
                        Fine_HoMe_checkBox_vamST == "NotNULL" ||
                        Fine_HoMe_checkBox_sell_with_moshtariST == "NotNULL"

                ) {

            Vulue2 = "a:" + counter_check_seel_cheng + ":{";
            Icounter_check_seel_cheng = 0;

            if (Fine_HoMe_checkBox_moavezeST == "NotNULL") {
                if (Icounter_check_seel_cheng == 0) {
                    Fine_HoMe_checkBox_moavezeST = "i:" + Icounter_check_seel_cheng + ";s:" + "12" + ":" + "\"معاوضه\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_moavezeST;
                    Icounter_check_seel_cheng++;
                } else {
                    Fine_HoMe_checkBox_moavezeST = "i:" + Icounter_check_seel_cheng + ";s:" + "12" + ":" + "\"معاوضه\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_moavezeST;
                    Icounter_check_seel_cheng++;
                }
            }

            if (Fine_HoMe_checkBox_pish_sellST == "NotNULL") {
                if (Icounter_check_seel_cheng == 0) {
                    Fine_HoMe_checkBox_pish_sellST = "i:" + Icounter_check_seel_cheng + ";s:" + "15" + ":" + "\"پیش فروش\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_pish_sellST;
                    Icounter_check_seel_cheng++;
                } else {
                    Fine_HoMe_checkBox_pish_sellST = "i:" + Icounter_check_seel_cheng + ";s:" + "15" + ":" + "\"پیش فروش\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_pish_sellST;
                    Icounter_check_seel_cheng++;
                }
            }

            if (Fine_HoMe_checkBox_vamST == "NotNULL") {
                if (Icounter_check_seel_cheng == 0) {
                    Fine_HoMe_checkBox_vamST = "i:" + Icounter_check_seel_cheng + ";s:" + "17" + ":" + "\"دارای وام\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_vamST;
                    Icounter_check_seel_cheng++;
                } else {
                    Fine_HoMe_checkBox_vamST = "i:" + Icounter_check_seel_cheng + ";s:" + "17" + ":" + "\"دارای وام\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_vamST;
                    Icounter_check_seel_cheng++;
                }
            }

            if (Fine_HoMe_checkBox_sell_with_moshtariST == "NotNULL") {
                if (Icounter_check_seel_cheng == 0) {
                    Fine_HoMe_checkBox_sell_with_moshtariST = "i:" + Icounter_check_seel_cheng + ";s:" + "26" + ":" + "\"فروش با مستاجر\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_sell_with_moshtariST;
                    Icounter_check_seel_cheng++;
                } else {
                    Fine_HoMe_checkBox_sell_with_moshtariST = "i:" + Icounter_check_seel_cheng + ";s:" + "26" + ":" + "\"فروش با مستاجر\"" + ";";
                    Vulue2 = Vulue2 + Fine_HoMe_checkBox_sell_with_moshtariST;
                    Icounter_check_seel_cheng++;
                }
            }
            Vulue2 = Vulue2 + "}";
            price_shrayet_sell_cheng_check_seel_cheng = Vulue2;
        }


// -Vulue2
// room asli

        if (Fine_HoMe_checkBox4ST == "NotNULL" || Fine_HoMe_checkBox_neshiman_mobleST == "NotNULL") {

            Vulue3 = "a:" + counter_neshiman + ":{";
            Icounter_neshiman = 0;

            if (Fine_HoMe_checkBox4ST == "NotNULL") {
                if (Icounter_neshiman == 0) {
                    Fine_HoMe_checkBox4ST = "i:" + Icounter_neshiman + ";s:" + "26" + ":" + "\"سقف بالای 4 متر\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox4ST;
                } else {
                    Fine_HoMe_checkBox4ST = "i:" + Icounter_neshiman + ";s:" + "26" + ":" + "\"سقف بالای 4 متر\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox4ST;
                    Icounter_neshiman++;
                }
            }

            if (Fine_HoMe_checkBox_neshiman_mobleST == "NotNULL") {
                if (Icounter_neshiman == 0) {
                    Fine_HoMe_checkBox_neshiman_mobleST = "i:" + Icounter_neshiman + ";s:" + "8" + ":" + "\"مبله\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox_neshiman_mobleST;
                } else {
                    Fine_HoMe_checkBox_neshiman_mobleST = "i:" + Icounter_neshiman + ";s:" + "8" + ":" + "\"مبله\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox_neshiman_mobleST;
                    Icounter_neshiman++;
                }
            }

            Vulue3 = Vulue3 + "}";
            more_joziat_melk_edari_tejari_room_asli_room_asli_check = Vulue3;
        }
// -romeasli
// nma

        if (
                Fine_HoMe_checkBox6ST == "NotNULL" ||
                        Fine_HoMe_checkBox7ST == "NotNULL" ||
                        Fine_HoMe_checkBox8ST == "NotNULL" ||
                        Fine_HoMe_checkBox9ST == "NotNULL" ||
                        checkBox9ST == "NotNULL" ||
                        Fine_HoMe_checkBox10ST == "NotNULL" ||
                        Fine_HoMe_checkBox11ST == "NotNULL" ||
                        Fine_HoMe_checkBox12ST == "NotNULL"

                ) {

            Vulue4 = "a:" + counter_nma + ":{";
            Icounter_nma = 0;

            if (Fine_HoMe_checkBox6ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox6ST = "i:" + Icounter_nma + ";s:" + "18" + ":" + "\"نورپردازی\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox6ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox6ST = "i:" + Icounter_nma + ";s:" + "18" + ":" + "\"نورپردازی\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox6ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox7ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox7ST = "i:" + Icounter_nma + ";s:" + "16" + ":" + "\"کامپوزیت\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox7ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox7ST = "i:" + Icounter_nma + ";s:" + "16" + ":" + "\"کامپوزیت\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox7ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox8ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox8ST = "i:" + Icounter_nma + ";s:" + "8" + ":" + "\"شیشه\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox8ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox8ST = "i:" + Icounter_nma + ";s:" + "8" + ":" + "\"شیشه\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox8ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox9ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox9ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"چوب\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox9ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox9ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"چوب\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox9ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox10ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox10ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox10ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox10ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox10ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox11ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox11ST = "i:" + Icounter_nma + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox11ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox11ST = "i:" + Icounter_nma + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox11ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox12ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox12ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"آجر\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox12ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox12ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"آجر\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox12ST;
                    Icounter_nma++;
                }
            }
            if (checkBox9ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    checkBox9ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"تابلو خور\"" + ";";
                    Vulue4 = Vulue4 + checkBox9ST;
                    Icounter_nma++;
                } else {
                    checkBox9ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"تابلو خور\"" + ";";
                    Vulue4 = Vulue4 + checkBox9ST;
                    Icounter_nma++;
                }
            }

            Vulue4 = Vulue4 + "}";
            more_joziat_melk_edari_tejari_nama_nama_check = Vulue4;
        }


// -nma

// divar


        if (

                Fine_HoMe_checkBox25ST == "NotNULL" ||
                        Fine_HoMe_checkBox26ST == "NotNULL" ||
                        Fine_HoMe_checkBox27ST == "NotNULL" ||
                        Fine_HoMe_checkBox28ST == "NotNULL" ||
                        Fine_HoMe_checkBox29ST == "NotNULL" ||
                        Fine_HoMe_checkBox30ST == "NotNULL" ||
                        Fine_HoMe_checkBox31ST == "NotNULL" ||
                        Fine_HoMe_checkBox32ST == "NotNULL"

                ) {
            Vulue7 = "a:" + counter_divar + ":{";
            Icounter_divar = 0;

            if (Fine_HoMe_checkBox25ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox25ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox25ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox25ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox25ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox26ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox26ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"رنگ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox26ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox26ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"رنگ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox26ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox27ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox27ST = "i:" + Icounter_divar + ";s:" + "22" + ":" + "\"کاشی / سرامیک\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox27ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox27ST = "i:" + Icounter_divar + ";s:" + "22" + ":" + "\"کاشی / سرامیک\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox27ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox28ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox28ST = "i:" + Icounter_divar + ";s:" + "21" + ":" + "\"کاغذ دیواری\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox28ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox28ST = "i:" + Icounter_divar + ";s:" + "21" + ":" + "\"کاغذ دیواری\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox28ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox29ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox29ST = "i:" + Icounter_divar + ";s:" + "24" + ":" + "\"چوب/ دیوارکوب\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox29ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox29ST = "i:" + Icounter_divar + ";s:" + "24" + ":" + "\"چوب/ دیوارکوب\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox29ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox30ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox30ST = "i:" + Icounter_divar + ";s:" + "4" + ":" + "\"گچ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox30ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox30ST = "i:" + Icounter_divar + ";s:" + "4" + ":" + "\"گچ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox30ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox31ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox31ST = "i:" + Icounter_divar + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox31ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox31ST = "i:" + Icounter_divar + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox31ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox32ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox32ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"آجر\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox32ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox32ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"آجر\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox32ST;
                    Icounter_divar++;
                }
            }
            Vulue7 = Vulue7 + "}";
            more_joziat_melk_edari_tejari_divar_divar_check = Vulue7;

        }


// -divar


// coldhot

        if (
                Fine_HoMe_checkBox331ST == "NotNULL" ||
                        Fine_HoMe_checkBox341ST == "NotNULL" ||
                        Fine_HoMe_checkBox351ST == "NotNULL" ||
                        Fine_HoMe_checkBox361ST == "NotNULL" ||
                        Fine_HoMe_checkBox371ST == "NotNULL" ||
                        Fine_HoMe_checkBox381ST == "NotNULL" ||
                        Fine_HoMe_checkBox39ST == "NotNULL" ||
                        Fine_HoMe_checkBox40ST == "NotNULL"
                ) {

            Vulue8 = "a:" + counter_coldhot + ":{";
            Icounter_coldhot = 0;

            if (Fine_HoMe_checkBox341ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox341ST = "i:" + Icounter_coldhot + ";s:" + "8" + ":" + "\"کولر\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox341ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox341ST = "i:" + Icounter_coldhot + ";s:" + "8" + ":" + "\"کولر\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox341ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox331ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox331ST = "i:" + Icounter_coldhot + ";s:" + "30" + ":" + "\"کولرگازی/ اسپلیت\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox331ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox331ST = "i:" + Icounter_coldhot + ";s:" + "30" + ":" + "\"کولرگازی/ اسپلیت\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox331ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox351ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox351ST = "i:" + Icounter_coldhot + ";s:" + "10" + ":" + "\"بخاری\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox351ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox351ST = "i:" + Icounter_coldhot + ";s:" + "10" + ":" + "\"بخاری\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox351ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox361ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox361ST = "i:" + Icounter_coldhot + ";s:" + "26" + ":" + "\"پکیج/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox361ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox361ST = "i:" + Icounter_coldhot + ";s:" + "26" + ":" + "\"پکیج/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox361ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox371ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox371ST = "i:" + Icounter_coldhot + ";s:" + "24" + ":" + "\"دیگ/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox371ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox371ST = "i:" + Icounter_coldhot + ";s:" + "24" + ":" + "\"دیگ/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox371ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox381ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox381ST = "i:" + Icounter_coldhot + ";s:" + "23" + ":" + "\"چیلر/ فن کوئل\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox381ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox381ST = "i:" + Icounter_coldhot + ";s:" + "23" + ":" + "\"چیلر/ فن کوئل\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox381ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox39ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox39ST = "i:" + Icounter_coldhot + ";s:" + "29" + ":" + "\"آبگرمکن خورشیدی\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox39ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox39ST = "i:" + Icounter_coldhot + ";s:" + "29" + ":" + "\"آبگرمکن خورشیدی\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox39ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox40ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox40ST = "i:" + Icounter_coldhot + ";s:" + "12" + ":" + "\"هواساز\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox40ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox40ST = "i:" + Icounter_coldhot + ";s:" + "12" + ":" + "\"هواساز\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox40ST;
                    Icounter_coldhot++;
                }
            }
            Vulue8 = Vulue8 + "}";
            more_joziat_melk_edari_tejari_coldhot_coldhot_check = Vulue8;
        }


// -coldhot
// refahi
        Vulue9 = "a:" + counter_refahi + ":{";
        Icounter_refahi = 0;
        if (
                Fine_HoMe_checkBox33ST == "NotNULL" ||
                        Fine_HoMe_checkBox37ST == "NotNULL" ||
                        checkBox15ST == "NotNULL"
                ) {

            if (Fine_HoMe_checkBox33ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox33ST = "i:" + Icounter_refahi + ";s:" + "14" + ":" + "\"آسانسور\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox33ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox33ST = "i:" + Icounter_refahi + ";s:" + "14" + ":" + "\"آسانسور\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox33ST;
                    Icounter_refahi++;
                }
            }


            if (Fine_HoMe_checkBox37ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox37ST = "i:" + Icounter_refahi + ";s:" + "27" + ":" + "\"اینترنت پرسرعت\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox37ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox37ST = "i:" + Icounter_refahi + ";s:" + "27" + ":" + "\"اینترنت پرسرعت\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox37ST;
                    Icounter_refahi++;
                }
            }

            if (Fine_HoMe_checkBox38ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox38ST = "i:" + Icounter_refahi + ";s:" + "19" + ":" + "\"شبکه داخلی\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox38ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox38ST = "i:" + Icounter_refahi + ";s:" + "19" + ":" + "\"شبکه داخلی\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox38ST;
                    Icounter_refahi++;
                }
            }
            Vulue9 = Vulue9 + "}";
            more_joziat_melk_edari_tejari_refahi_refahi_check = Vulue9;
        }
// -refahi

// safe

        if (
                Fine_HoMe_checkBox41ST == "NotNULL" ||
                        Fine_HoMe_checkBox42ST == "NotNULL" ||
                        Fine_HoMe_checkBox43ST == "NotNULL" ||
                        Fine_HoMe_checkBox44ST == "NotNULL" ||
                        Fine_HoMe_checkBox45ST == "NotNULL" ||
                        Fine_HoMe_checkBox46ST == "NotNULL"
                ) {

            Vulue10 = "a:" + counter_safe + ":{";
            Icounter_safe = 0;

            if (Fine_HoMe_checkBox41ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox41ST = "i:" + Icounter_safe + ";s:" + "12" + ":" + "\"دزدگیر\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox41ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox41ST = "i:" + Icounter_safe + ";s:" + "12" + ":" + "\"دزدگیر\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox41ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox42ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox42ST = "i:" + Icounter_safe + ";s:" + "29" + ":" + "\"دوربین مداربسته\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox42ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox42ST = "i:" + Icounter_safe + ";s:" + "29" + ":" + "\"دوربین مداربسته\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox42ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox43ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox43ST = "i:" + Icounter_safe + ";s:" + "23" + ":" + "\"آیفون تصویری\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox43ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox43ST = "i:" + Icounter_safe + ";s:" + "23" + ":" + "\"آیفون تصویری\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox43ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox44ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox44ST = "i:" + Icounter_safe + ";s:" + "20" + ":" + "\"درب ضد سرقت\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox44ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox44ST = "i:" + Icounter_safe + ";s:" + "20" + ":" + "\"درب ضد سرقت\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox44ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox45ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox45ST = "i:" + Icounter_safe + ";s:" + "28" + ":" + "\"سیستم اعلام آتش\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox45ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox45ST = "i:" + Icounter_safe + ";s:" + "28" + ":" + "\"سیستم اعلام آتش\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox45ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox46ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox46ST = "i:" + Icounter_safe + ";s:" + "30" + ":" + "\"سیستم اطفاء حریق\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox46ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox46ST = "i:" + Icounter_safe + ";s:" + "30" + ":" + "\"سیستم اطفاء حریق\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox46ST;
                    Icounter_safe++;
                }
            }

            if (checkBox15ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    checkBox15ST = "i:" + Icounter_safe + ";s:" + "16" + ":" + "\"گاوصندوق\"" + ";";
                    Vulue10 = Vulue10 + checkBox15ST;
                    Icounter_safe++;
                } else {
                    checkBox15ST = "i:" + Icounter_safe + ";s:" + "16" + ":" + "\"گاوصندوق\"" + ";";
                    Vulue10 = Vulue10 + checkBox15ST;
                    Icounter_safe++;
                }
            }


            Vulue10 = Vulue10 + "}";
            more_joziat_melk_edari_tejari_safe_safe_check = Vulue10;

        }

// -safe
        // view

        if (

                Fine_HoMe_checkBox71ST == "NotNULL" ||
                        Fine_HoMe_checkBox72ST == "NotNULL" ||
                        Fine_HoMe_checkBox73ST == "NotNULL" ||
                        Fine_HoMe_checkBox74ST == "NotNULL" ||
                        Fine_HoMe_checkBox75ST == "NotNULL" ||
                        Fine_HoMe_checkBox76ST == "NotNULL" ||
                        Fine_HoMe_checkBox77ST == "NotNULL" ||
                        Fine_HoMe_checkBox78ST == "NotNULL"
                ) {

            Vulue13 = "a:" + counter_view + ":{";
            Icounter_view = 0;

            if (Fine_HoMe_checkBox71ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox71ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"شهر\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox71ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox71ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"شهر\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox71ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox72ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox72ST = "i:" + Icounter_view + ";s:" + "12" + ":" + "\"اتوبان\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox72ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox72ST = "i:" + Icounter_view + ";s:" + "12" + ":" + "\"اتوبان\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox72ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox73ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox73ST = "i:" + Icounter_view + ";s:" + "12" + ":" + "\"خیابان\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox73ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox73ST = "i:" + Icounter_view + ";s:" + "12" + ":" + "\"خیابان\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox73ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox74ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox74ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"کوچه\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox74ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox74ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"کوچه\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox74ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox75ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox75ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"دریا\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox75ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox75ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"دریا\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox75ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox76ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox76ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"جنگل\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox76ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox76ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"جنگل\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox76ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox77ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox77ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"کوه\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox77ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox77ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"کوه\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox77ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox78ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox78ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"باغ\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox78ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox78ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"باغ\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox78ST;
                    Icounter_view++;
                }
            }
            Vulue13 = Vulue13 + "}";
            more_joziat_melk_edari_tejari_view_view_check = Vulue13;
        }


// -view
// nor

        Vulue14 = "a:" + counter_nor + ":{";
        Icounter_nor = 0;
        if (

                Fine_HoMe_checkBox79ST == "NotNULL" ||
                        Fine_HoMe_checkBox80ST == "NotNULL" ||
                        Fine_HoMe_checkBox81ST == "NotNULL" ||
                        Fine_HoMe_checkBox82ST == "NotNULL"
                ) {

            if (Fine_HoMe_checkBox79ST == "NotNULL") {
                if (Icounter_nor == 0) {
                    Fine_HoMe_checkBox79ST = "i:" + Icounter_nor + ";s:" + "8" + ":" + "\"شمال\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox79ST;
                    Icounter_nor++;
                } else {
                    Fine_HoMe_checkBox79ST = "i:" + Icounter_nor + ";s:" + "8" + ":" + "\"شمال\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox79ST;
                    Icounter_nor++;
                }
            }

            if (Fine_HoMe_checkBox80ST == "NotNULL") {
                if (Icounter_nor == 0) {
                    Fine_HoMe_checkBox80ST = "i:" + Icounter_nor + ";s:" + "8" + ":" + "\"جنوب\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox80ST;
                    Icounter_nor++;
                } else {
                    Fine_HoMe_checkBox80ST = "i:" + Icounter_nor + ";s:" + "8" + ":" + "\"جنوب\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox80ST;
                    Icounter_nor++;
                }
            }

            if (Fine_HoMe_checkBox81ST == "NotNULL") {
                if (Icounter_nor == 0) {
                    Fine_HoMe_checkBox81ST = "i:" + Icounter_nor + ";s:" + "6" + ":" + "\"شرق\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox81ST;
                    Icounter_nor++;
                } else {
                    Fine_HoMe_checkBox81ST = "i:" + Icounter_nor + ";s:" + "6" + ":" + "\"شرق\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox81ST;
                    Icounter_nor++;
                }
            }

            if (Fine_HoMe_checkBox82ST == "NotNULL") {
                if (Icounter_nor == 0) {
                    Fine_HoMe_checkBox82ST = "i:" + Icounter_nor + ";s:" + "6" + ":" + "\"غرب\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox82ST;
                    Icounter_nor++;
                } else {
                    Fine_HoMe_checkBox82ST = "i:" + Icounter_nor + ";s:" + "6" + ":" + "\"غرب\"" + ";";
                    Vulue14 = Vulue14 + Fine_HoMe_checkBox82ST;
                    Icounter_nor++;
                }
            }
            Vulue14 = Vulue14 + "}";
            more_joziat_melk_edari_tejari_nor_nor_check = Vulue14;
        }


// -nor
// tasisat


        if (

                Fine_HoMe_checkBox83ST == "NotNULL" ||
                        Fine_HoMe_checkBox84ST == "NotNULL" ||
                        Fine_HoMe_checkBox85ST == "NotNULL" ||
                        Fine_HoMe_checkBox86ST == "NotNULL"
                ) {

            Vulue15 = "a:" + counter_tasisat + ":{";
            Icounter_tasisat = 0;

            if (Fine_HoMe_checkBox83ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox83ST = "i:" + Icounter_tasisat + ";s:" + "13" + ":" + "\"آب شهری\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox83ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox83ST = "i:" + Icounter_tasisat + ";s:" + "13" + ":" + "\"آب شهری\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox83ST;
                    Icounter_tasisat++;
                }
            }

            if (Fine_HoMe_checkBox84ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox84ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox84ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox84ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox84ST;
                    Icounter_tasisat++;
                }
            }

            if (Fine_HoMe_checkBox85ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox85ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"گاز\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox85ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox85ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"گاز\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox85ST;
                    Icounter_tasisat++;
                }
            }

            if (Fine_HoMe_checkBox86ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox86ST = "i:" + Icounter_tasisat + ";s:" + "21" + ":" + "\"ژنراتور برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox86ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox86ST = "i:" + Icounter_tasisat + ";s:" + "21" + ":" + "\"ژنراتور برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox86ST;
                    Icounter_tasisat++;
                }
            }

            if (checkBox10ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    checkBox10ST = "i:" + Icounter_tasisat + ";s:" + "21" + ":" + "\"منابع تغذیه برق\"" + ";";
                    Vulue15 = Vulue15 + checkBox10ST;
                    Icounter_tasisat++;
                } else {
                    checkBox10ST = "i:" + Icounter_tasisat + ";s:" + "21" + ":" + "\"منابع تغذیه برق\"" + ";";
                    Vulue15 = Vulue15 + checkBox10ST;
                    Icounter_tasisat++;
                }
            }


            Vulue15 = Vulue15 + "}";
            more_joziat_melk_edari_tejari_tasisat_tasisat_check = Vulue15;
        }


// -tasisat
        // emkanat

        if (
                Fine_HoMe_checkBox48ST == "NotNULL" ||
                        Fine_HoMe_checkBox49ST == "NotNULL" ||
                        Fine_HoMe_checkBox53ST == "NotNULL" ||
                        Fine_HoMe_checkBox54ST == "NotNULL" ||
                        Fine_HoMe_checkBox55ST == "NotNULL" ||
                        Fine_HoMe_checkBox56ST == "NotNULL"
                ) {

            Vulue11 = "a:" + counter_emkanat + ":{";
            Icounter_emkanat = 0;

            if (Fine_HoMe_checkBox48ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox48ST = "i:" + Icounter_emkanat + ";s:" + "16" + ":" + "\"سرایداری\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox48ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox48ST = "i:" + Icounter_emkanat + ";s:" + "16" + ":" + "\"سرایداری\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox48ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox49ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox49ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"لابی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox49ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox49ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"لابی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox49ST;
                    Icounter_emkanat++;
                }
            }


            if (Fine_HoMe_checkBox53ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox53ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"حیاط\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox53ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox53ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"حیاط\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox53ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox54ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox54ST = "i:" + Icounter_emkanat + ";s:" + "15" + ":" + "\"فضای سبز\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox54ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox54ST = "i:" + Icounter_emkanat + ";s:" + "15" + ":" + "\"فضای سبز\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox54ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox55ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox55ST = "i:" + Icounter_emkanat + ";s:" + "14" + ":" + "\"نگهبانی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox55ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox55ST = "i:" + Icounter_emkanat + ";s:" + "14" + ":" + "\"نگهبانی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox55ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox56ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox56ST = "i:" + Icounter_emkanat + ";s:" + "25" + ":" + "\"سالن اجتماعات\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox56ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox56ST = "i:" + Icounter_emkanat + ";s:" + "25" + ":" + "\"سالن اجتماعات\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox56ST;
                    Icounter_emkanat++;
                }
            }

            Vulue11 = Vulue11 + "}";
            more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = Vulue11;

        }


// -emkanat
        moshakhasat_asli_melk_masahat_build = Find_HoMe_editText_masahat_made.getText().toString();
        moshakhasat_asli_melk_masahat_zamin = Find_HoMe_editText_masahat_ground.getText().toString();

        price_shrayet_sell_cheng_price_all_sell_cheng = Find_HoMe_editText_price_deal.getText().toString();
        price_shrayet_sell_cheng_max_money = Find_HoMe_editText_moaveze.getText().toString();
        price_shrayet_sell_cheng_money_pish_pay = Find_HoMe_editText_pish_sell_price.getText().toString();
        price_shrayet_sell_cheng_time_tahvil = Find_HoMe_editText_pish_sell_time.getText().toString();
        price_shrayet_sell_cheng_mizan_vam = Find_HoMe_editText_vam_mizan.getText().toString();
        price_shrayet_sell_cheng_sod_vam = Find_HoMe_editText_vam_sod.getText().toString();
        price_shrayet_sell_cheng_number_ghest = Find_HoMe_editText_vam_num_ghest.getText().toString();
        price_shrayet_sell_cheng_price_har_ghest = Find_HoMe_editText_vam_num_ghest2.getText().toString();
        price_shrayet_sell_cheng_price_rahn = Find_HoMe_editText_sell_with_moshtari.getText().toString();
        more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = Find_HoMe_editText.getText().toString();
        more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = Find_HoMe_editText2.getText().toString();
        more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = Find_HoMe_editText3.getText().toString();
        more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = Find_HoMe_editText4.getText().toString();
        more_joziat_melk_edari_tejari_room_asli_room_asli_edit = Find_HoMe_editText9.getText().toString();
        more_joziat_melk_edari_tejari_nama_nama_edit = Find_HoMe_editText11.getText().toString();
        more_joziat_melk_edari_tejari_divar_divar_edit = Find_HoMe_editText14.getText().toString();
        more_joziat_melk_edari_tejari_coldhot_coldhot_edit = Find_HoMe_editText151.getText().toString();
        more_joziat_melk_edari_tejari_refahi_refahi_edit = Find_HoMe_editText15.getText().toString();
        more_joziat_melk_edari_tejari_safe_safe_edit = Find_HoMe_editText16.getText().toString();
        more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = Find_HoMe_editText17.getText().toString();
        more_joziat_melk_edari_tejari_view_view_edit = Find_HoMe_editText19.getText().toString();
// radio

        int selectedId1 = RadioGP2.getCheckedRadioButtonId();
        radioButton_find_home = (RadioButton) findViewById(selectedId1);
        moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = (String) radioButton_find_home.getText();


        int selectedId22 = RadioGP.getCheckedRadioButtonId();
        radioButton_find_home2 = (RadioButton) findViewById(selectedId22);
        more_joziat_melk_edari_tejari_kitchen_kitchen_radio = (String) radioButton_find_home2.getText();

        int selectedId33 = RadioGP3.getCheckedRadioButtonId();
        radioButton_find_home3 = (RadioButton) findViewById(selectedId33);
        more_joziat_melk_edari_tejari_shekle_build_radio = (String) radioButton_find_home3.getText();


// -radio

        editText.setText(

                "noe_melk_moamele = " + noe_melk_moamele
                        + "\n noe_melk = " + noe_melk
                        + "\n moshakhasat_asli_melk_noe_bana = " + moshakhasat_asli_melk_noe_bana
                        + "\n moshakhasat_asli_melk_masahat_build = " + moshakhasat_asli_melk_masahat_build
                        + "\n moshakhasat_asli_melk_masahat_zamin = " + moshakhasat_asli_melk_masahat_zamin
                        + "\n moshakhasat_asli_melk_number_room = " + moshakhasat_asli_melk_number_room
                        + "\n moshakhasat_asli_melk_number_parking = " + moshakhasat_asli_melk_number_parking
                        + "\n moshakhasat_asli_melk_moghiat_build = " + moshakhasat_asli_melk_moghiat_build
                        + "\n price_shrayet_sell_cheng_price_all_sell_cheng = " + price_shrayet_sell_cheng_price_all_sell_cheng
                        + "\n price_shrayet_sell_cheng_check_seel_cheng = " + price_shrayet_sell_cheng_check_seel_cheng
                        + "\n price_shrayet_sell_cheng_max_money = " + price_shrayet_sell_cheng_max_money
                        + "\n price_shrayet_sell_cheng_money_pish_pay = " + price_shrayet_sell_cheng_money_pish_pay
                        + "\n price_shrayet_sell_cheng_time_tahvil = " + price_shrayet_sell_cheng_time_tahvil
                        + "\n price_shrayet_sell_cheng_mizan_anjam_shode = " + price_shrayet_sell_cheng_mizan_anjam_shode
                        + "\n price_shrayet_sell_cheng_mizan_vam = " + price_shrayet_sell_cheng_mizan_vam
                        + "\n price_shrayet_sell_cheng_sod_vam = " + price_shrayet_sell_cheng_sod_vam
                        + "\n price_shrayet_sell_cheng_number_ghest = " + price_shrayet_sell_cheng_number_ghest
                        + "\n price_shrayet_sell_cheng_price_har_ghest = " + price_shrayet_sell_cheng_price_har_ghest
                        + "\n price_shrayet_sell_cheng_price_rahn = " + price_shrayet_sell_cheng_price_rahn
                        + "\n more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe = " + more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe
                        + "\n more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe = " + more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe
                        + "\n more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe = " + more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe
                        + "\n more_joziat_melk_edari_tejari_moghit_build_number_all_vahed = " + more_joziat_melk_edari_tejari_moghit_build_number_all_vahed
                        + "\n more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build = " + more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build
                        + "\n more_joziat_melk_edari_tejari_wc_wc_irani = " + more_joziat_melk_edari_tejari_wc_wc_irani
                        + "\n more_joziat_melk_edari_tejari_wc_wc_us = " + more_joziat_melk_edari_tejari_wc_wc_us
                        + "\n more_joziat_melk_edari_tejari_kitchen_abdarkhane = " + more_joziat_melk_edari_tejari_kitchen_abdarkhane
                        + "\n more_joziat_melk_edari_tejari_kitchen_ghazakhori = " + more_joziat_melk_edari_tejari_kitchen_ghazakhori
                        + "\n more_joziat_melk_edari_tejari_room_asli_room_asli_edit = " + more_joziat_melk_edari_tejari_room_asli_room_asli_edit
                        + "\n more_joziat_melk_edari_tejari_nama_nama_check = " + more_joziat_melk_edari_tejari_nama_nama_check
                        + "\n more_joziat_melk_edari_tejari_nama_nama_edit = " + more_joziat_melk_edari_tejari_nama_nama_edit
                        + "\n more_joziat_melk_edari_tejari_divar_divar_check = " + more_joziat_melk_edari_tejari_divar_divar_check
                        + "\n more_joziat_melk_edari_tejari_divar_divar_edit = " + more_joziat_melk_edari_tejari_divar_divar_edit
                        + "\n more_joziat_melk_edari_tejari_coldhot_coldhot_check = " + more_joziat_melk_edari_tejari_coldhot_coldhot_check
                        + "\n more_joziat_melk_edari_tejari_coldhot_coldhot_edit = " + more_joziat_melk_edari_tejari_coldhot_coldhot_edit
                        + "\n more_joziat_melk_edari_tejari_refahi_refahi_check = " + more_joziat_melk_edari_tejari_refahi_refahi_check
                        + "\n more_joziat_melk_edari_tejari_refahi_refahi_edit = " + more_joziat_melk_edari_tejari_refahi_refahi_edit
                        + "\n more_joziat_melk_edari_tejari_safe_safe_check = " + more_joziat_melk_edari_tejari_safe_safe_check
                        + "\n more_joziat_melk_edari_tejari_safe_safe_edit = " + more_joziat_melk_edari_tejari_safe_safe_edit
                        + "\n more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = " + more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta
                        + "\n more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = " + more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit
                        + "\n more_joziat_melk_edari_tejari_view_view_check = " + more_joziat_melk_edari_tejari_view_view_check
                        + "\n more_joziat_melk_edari_tejari_view_view_edit = " + more_joziat_melk_edari_tejari_view_view_edit
                        + "\n more_joziat_melk_edari_tejari_nor_nor_check = " + more_joziat_melk_edari_tejari_nor_nor_check
                        + "\n more_joziat_melk_edari_tejari_tasisat_tasisat_check = " + more_joziat_melk_edari_tejari_tasisat_tasisat_check
                        + "\n more_joziat_melk_edari_tejari_tasisat_tasisat_edit = " + more_joziat_melk_edari_tejari_tasisat_tasisat_edit
                        + "\n more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = " + more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat
                        + "\n more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = " + more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat
                        + "\n more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = " + more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam
                        + "\n more_joziat_melk_edari_tejari_kitchen_badane_kabinet = " + more_joziat_melk_edari_tejari_kitchen_badane_kabinet
                        + "\n more_joziat_melk_edari_tejari_kitchen_safhe_kabinet = " + more_joziat_melk_edari_tejari_kitchen_safhe_kabinet
                        + "\n more_joziat_melk_edari_tejari_kitchen_roye_kabinet = " + more_joziat_melk_edari_tejari_kitchen_roye_kabinet
                        + "\n more_joziat_melk_edari_tejari_room_asli_room_asli_check = " + more_joziat_melk_edari_tejari_room_asli_room_asli_check
                        + "\n moshakhasat_asli_melk_vaziita_build_vaziita_build_radio = " + moshakhasat_asli_melk_vaziita_build_vaziita_build_radio
                        + "\n more_joziat_melk_edari_tejari_kitchen_kitchen_radio = " + more_joziat_melk_edari_tejari_kitchen_kitchen_radio
                        + "\n more_joziat_melk_edari_tejari_shekle_build_radio = " + more_joziat_melk_edari_tejari_shekle_build_radio
        );


//------------------------------------------------------end of send edari
    }

    public void swichSendTejari() {

//------------------------------------------------------start of send tejari


// neshiman

        if (checkBox11ST == "NotNULL" ||
                checkBox12ST == "NotNULL") {

            Vulue16 = "a:" + counter_neshiman + ":{";
            Icounter_NoeSarGhofli = 0;

            if (checkBox11ST == "NotNULL") {
                if (Icounter_NoeSarGhofli == 0) {
                    checkBox11ST = "i:" + Icounter_NoeSarGhofli + ";s:" + "12" + ":" + "\"مالکیت\"" + ";";
                    Vulue16 = Vulue16 + checkBox11ST;
                    Icounter_NoeSarGhofli++;
                } else {
                    checkBox11ST = "i:" + Icounter_NoeSarGhofli + ";s:" + "12" + ":" + "\"مالکیت\"" + ";";
                    Vulue16 = Vulue16 + checkBox11ST;
                    Icounter_NoeSarGhofli++;
                }
            }


            if (checkBox12ST == "NotNULL") {
                if (Icounter_NoeSarGhofli == 0) {
                    checkBox12ST = "i:" + Icounter_NoeSarGhofli + ";s:" + "12" + ":" + "\"سرقفلی\"" + ";";
                    Vulue16 = Vulue16 + checkBox12ST;
                } else {
                    checkBox12ST = "i:" + Icounter_NoeSarGhofli + ";s:" + "12" + ":" + "\"سرقفلی\"" + ";";
                    Vulue16 = Vulue16 + checkBox12ST;
                    Icounter_NoeSarGhofli++;
                }
            }

            Vulue16 = Vulue16 + "}";
            moshakhasat_asli_melk_noe_vaghozari = Vulue16;
        }
// -neshiman
        if (
                Fine_HoMe_checkBox3ST == "NotNULL" ||
                        Fine_HoMe_checkBox4ST == "NotNULL" ||
                        checkBox14ST == "NotNULL" ||
                        Fine_HoMe_checkBox_neshiman_mobleST == "NotNULL") {

            Vulue3 = "a:" + counter_neshiman + ":{";
            Icounter_neshiman = 0;

            if (Fine_HoMe_checkBox3ST == "NotNULL") {
                if (Icounter_neshiman == 0) {
                    Fine_HoMe_checkBox3ST = "i:" + Icounter_neshiman + ";s:" + "12" + ":" + "\"ویترین\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox3ST;
                } else {
                    Fine_HoMe_checkBox3ST = "i:" + Icounter_neshiman + ";s:" + "12" + ":" + "\"ویترین\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox3ST;
                    Icounter_neshiman++;
                }
            }
            if (Fine_HoMe_checkBox4ST == "NotNULL") {
                if (Icounter_neshiman == 0) {
                    Fine_HoMe_checkBox4ST = "i:" + Icounter_neshiman + ";s:" + "26" + ":" + "\"سقف بالای 4 متر\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox4ST;
                } else {
                    Fine_HoMe_checkBox4ST = "i:" + Icounter_neshiman + ";s:" + "26" + ":" + "\"سقف بالای 4 متر\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox4ST;
                    Icounter_neshiman++;
                }
            }

            if (Fine_HoMe_checkBox_neshiman_mobleST == "NotNULL") {
                if (Icounter_neshiman == 0) {
                    Fine_HoMe_checkBox_neshiman_mobleST = "i:" + Icounter_neshiman + ";s:" + "29" + ":" + "\"دکوراسیون داخلی\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox_neshiman_mobleST;
                } else {
                    Fine_HoMe_checkBox_neshiman_mobleST = "i:" + Icounter_neshiman + ";s:" + "29" + ":" + "\"دکوراسیون داخلی\"" + ";";
                    Vulue3 = Vulue3 + Fine_HoMe_checkBox_neshiman_mobleST;
                    Icounter_neshiman++;
                }
            }

            if (checkBox14ST == "NotNULL") {
                if (Icounter_neshiman == 0) {
                    checkBox14ST = "i:" + Icounter_neshiman + ";s:" + "17" + ":" + "\"قفسه بندی\"" + ";";
                    Vulue3 = Vulue3 + checkBox14ST;
                } else {
                    checkBox14ST = "i:" + Icounter_neshiman + ";s:" + "17" + ":" + "\"قفسه بندی\"" + ";";
                    Vulue3 = Vulue3 + checkBox14ST;
                    Icounter_neshiman++;
                }
            }

            Vulue3 = Vulue3 + "}";
            more_joziat_melk_edari_tejari_room_asli_room_asli_check = Vulue3;
        }
// -fazaeasli
// nma
        if (
                Fine_HoMe_checkBox6ST == "NotNULL" ||
                        Fine_HoMe_checkBox7ST == "NotNULL" ||
                        Fine_HoMe_checkBox8ST == "NotNULL" ||
                        Fine_HoMe_checkBox9ST == "NotNULL" ||
                        checkBox9ST == "NotNULL" ||
                        Fine_HoMe_checkBox10ST == "NotNULL" ||
                        Fine_HoMe_checkBox11ST == "NotNULL" ||
                        Fine_HoMe_checkBox12ST == "NotNULL"

                ) {

            Vulue4 = "a:" + counter_nma + ":{";
            Icounter_nma = 0;

            if (Fine_HoMe_checkBox6ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox6ST = "i:" + Icounter_nma + ";s:" + "18" + ":" + "\"نورپردازی\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox6ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox6ST = "i:" + Icounter_nma + ";s:" + "18" + ":" + "\"نورپردازی\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox6ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox7ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox7ST = "i:" + Icounter_nma + ";s:" + "16" + ":" + "\"کامپوزیت\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox7ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox7ST = "i:" + Icounter_nma + ";s:" + "16" + ":" + "\"کامپوزیت\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox7ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox8ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox8ST = "i:" + Icounter_nma + ";s:" + "8" + ":" + "\"شیشه\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox8ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox8ST = "i:" + Icounter_nma + ";s:" + "8" + ":" + "\"شیشه\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox8ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox9ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox9ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"چوب\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox9ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox9ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"چوب\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox9ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox10ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox10ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox10ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox10ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox10ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox11ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox11ST = "i:" + Icounter_nma + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox11ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox11ST = "i:" + Icounter_nma + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox11ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox12ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox12ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"آجر\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox12ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox12ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"آجر\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox12ST;
                    Icounter_nma++;
                }
            }
            if (checkBox9ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    checkBox9ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"تابلو خور\"" + ";";
                    Vulue4 = Vulue4 + checkBox9ST;
                    Icounter_nma++;
                } else {
                    checkBox9ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"تابلو خور\"" + ";";
                    Vulue4 = Vulue4 + checkBox9ST;
                    Icounter_nma++;
                }
            }

            Vulue4 = Vulue4 + "}";
            more_joziat_melk_edari_tejari_nama_nama_check = Vulue4;
        }


// -nma

// kaf

        if (
                Fine_HoMe_checkBox17ST == "NotNULL" ||
                        Fine_HoMe_checkBox18ST == "NotNULL" ||
                        Fine_HoMe_checkBox19ST == "NotNULL" ||
                        Fine_HoMe_checkBox20ST == "NotNULL" ||
                        Fine_HoMe_checkBox21ST == "NotNULL" ||
                        Fine_HoMe_checkBox22ST == "NotNULL" ||
                        Fine_HoMe_checkBox23ST == "NotNULL" ||
                        Fine_HoMe_checkBox24ST == "NotNULL"
                ) {

            Vulue6 = "a:" + counter_kaf + ":{";
            Icounter_kaf = 0;

            if (Fine_HoMe_checkBox17ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox17ST = "i:" + Icounter_kaf + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox17ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox17ST = "i:" + Icounter_kaf + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox17ST;
                    Icounter_kaf++;
                }
            }

            if (Fine_HoMe_checkBox18ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox18ST = "i:" + Icounter_kaf + ";s:" + "12" + ":" + "\"سرامیک\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox18ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox18ST = "i:" + Icounter_kaf + ";s:" + "12" + ":" + "\"سرامیک\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox18ST;
                    Icounter_kaf++;
                }
            }

            if (Fine_HoMe_checkBox19ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox19ST = "i:" + Icounter_kaf + ";s:" + "10" + ":" + "\"پارکت\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox19ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox19ST = "i:" + Icounter_kaf + ";s:" + "10" + ":" + "\"پارکت\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox19ST;
                    Icounter_kaf++;
                }
            }

            if (Fine_HoMe_checkBox20ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox20ST = "i:" + Icounter_kaf + ";s:" + "10" + ":" + "\"کفپوش\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox20ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox20ST = "i:" + Icounter_kaf + ";s:" + "10" + ":" + "\"کفپوش\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox20ST;
                    Icounter_kaf++;
                }
            }

            if (Fine_HoMe_checkBox21ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox21ST = "i:" + Icounter_kaf + ";s:" + "8" + ":" + "\"موکت\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox21ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox21ST = "i:" + Icounter_kaf + ";s:" + "8" + ":" + "\"موکت\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox21ST;
                    Icounter_kaf++;
                }
            }

            if (Fine_HoMe_checkBox22ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox22ST = "i:" + Icounter_kaf + ";s:" + "14" + ":" + "\"موزاییک\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox22ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox22ST = "i:" + Icounter_kaf + ";s:" + "14" + ":" + "\"موزاییک\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox22ST;
                    Icounter_kaf++;
                }
            }

            if (Fine_HoMe_checkBox23ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox23ST = "i:" + Icounter_kaf + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox23ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox23ST = "i:" + Icounter_kaf + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox23ST;
                    Icounter_kaf++;
                }
            }

            if (Fine_HoMe_checkBox24ST == "NotNULL") {
                if (Icounter_kaf == 0) {
                    Fine_HoMe_checkBox24ST = "i:" + Icounter_kaf + ";s:" + "18" + ":" + "\"کف پله دار\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox24ST;
                    Icounter_kaf++;
                } else {
                    Fine_HoMe_checkBox24ST = "i:" + Icounter_kaf + ";s:" + "18" + ":" + "\"کف پله دار\"" + ";";
                    Vulue6 = Vulue6 + Fine_HoMe_checkBox24ST;
                    Icounter_kaf++;
                }
            }
            Vulue6 = Vulue6 + "}";
            more_joziat_melk_edari_tejari_kaf_kaf_check = Vulue6;
        }

// -kaf

// coldhot

        if (
                Fine_HoMe_checkBox331ST == "NotNULL" ||
                        Fine_HoMe_checkBox341ST == "NotNULL" ||
                        Fine_HoMe_checkBox351ST == "NotNULL" ||
                        Fine_HoMe_checkBox361ST == "NotNULL" ||
                        Fine_HoMe_checkBox371ST == "NotNULL" ||
                        Fine_HoMe_checkBox381ST == "NotNULL" ||
                        Fine_HoMe_checkBox39ST == "NotNULL" ||
                        Fine_HoMe_checkBox40ST == "NotNULL"
                ) {

            Vulue8 = "a:" + counter_coldhot + ":{";
            Icounter_coldhot = 0;

            if (Fine_HoMe_checkBox341ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox341ST = "i:" + Icounter_coldhot + ";s:" + "8" + ":" + "\"کولر\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox341ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox341ST = "i:" + Icounter_coldhot + ";s:" + "8" + ":" + "\"کولر\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox341ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox331ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox331ST = "i:" + Icounter_coldhot + ";s:" + "30" + ":" + "\"کولرگازی/ اسپلیت\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox331ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox331ST = "i:" + Icounter_coldhot + ";s:" + "30" + ":" + "\"کولرگازی/ اسپلیت\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox331ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox351ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox351ST = "i:" + Icounter_coldhot + ";s:" + "10" + ":" + "\"بخاری\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox351ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox351ST = "i:" + Icounter_coldhot + ";s:" + "10" + ":" + "\"بخاری\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox351ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox361ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox361ST = "i:" + Icounter_coldhot + ";s:" + "26" + ":" + "\"پکیج/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox361ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox361ST = "i:" + Icounter_coldhot + ";s:" + "26" + ":" + "\"پکیج/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox361ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox371ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox371ST = "i:" + Icounter_coldhot + ";s:" + "24" + ":" + "\"دیگ/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox371ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox371ST = "i:" + Icounter_coldhot + ";s:" + "24" + ":" + "\"دیگ/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox371ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox381ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox381ST = "i:" + Icounter_coldhot + ";s:" + "23" + ":" + "\"چیلر/ فن کوئل\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox381ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox381ST = "i:" + Icounter_coldhot + ";s:" + "23" + ":" + "\"چیلر/ فن کوئل\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox381ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox39ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox39ST = "i:" + Icounter_coldhot + ";s:" + "29" + ":" + "\"آبگرمکن خورشیدی\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox39ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox39ST = "i:" + Icounter_coldhot + ";s:" + "29" + ":" + "\"آبگرمکن خورشیدی\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox39ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox40ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox40ST = "i:" + Icounter_coldhot + ";s:" + "12" + ":" + "\"هواساز\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox40ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox40ST = "i:" + Icounter_coldhot + ";s:" + "12" + ":" + "\"هواساز\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox40ST;
                    Icounter_coldhot++;
                }
            }
            Vulue8 = Vulue8 + "}";
            more_joziat_melk_edari_tejari_coldhot_coldhot_check = Vulue8;
        }


// -coldhot
// refahi
        Vulue9 = "a:" + counter_refahi + ":{";
        Icounter_refahi = 0;
        if (

                Fine_HoMe_checkBox33ST == "NotNULL" ||
                        Fine_HoMe_checkBox37ST == "NotNULL" ||
                        Fine_HoMe_checkBox38ST == "NotNULL" ||
                        Fine_HoMe_checkBox36ST == "NotNULL" ||
                        checkBox20ST == "NotNULL"
                ) {

            if (Fine_HoMe_checkBox33ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox33ST = "i:" + Icounter_refahi + ";s:" + "14" + ":" + "\"آسانسور\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox33ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox33ST = "i:" + Icounter_refahi + ";s:" + "14" + ":" + "\"آسانسور\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox33ST;
                    Icounter_refahi++;
                }
            }


            if (Fine_HoMe_checkBox37ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox37ST = "i:" + Icounter_refahi + ";s:" + "27" + ":" + "\"اینترنت پرسرعت\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox37ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox37ST = "i:" + Icounter_refahi + ";s:" + "27" + ":" + "\"اینترنت پرسرعت\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox37ST;
                    Icounter_refahi++;
                }
            }

            if (Fine_HoMe_checkBox38ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox38ST = "i:" + Icounter_refahi + ";s:" + "19" + ":" + "\"شبکه داخلی\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox38ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox38ST = "i:" + Icounter_refahi + ";s:" + "19" + ":" + "\"شبکه داخلی\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox38ST;
                    Icounter_refahi++;
                }
            }

            if (Fine_HoMe_checkBox38ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox38ST = "i:" + Icounter_refahi + ";s:" + "15" + ":" + "\"پله برقی\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox38ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox38ST = "i:" + Icounter_refahi + ";s:" + "15" + ":" + "\"پله برقی\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox38ST;
                    Icounter_refahi++;
                }
            }

            if (checkBox20ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    checkBox20ST = "i:" + Icounter_refahi + ";s:" + "28" + ":" + "\"آسانسور حمل بار\"" + ";";
                    Vulue9 = Vulue9 + checkBox20ST;
                    Icounter_refahi++;
                } else {
                    checkBox20ST = "i:" + Icounter_refahi + ";s:" + "28" + ":" + "\"آسانسور حمل بار\"" + ";";
                    Vulue9 = Vulue9 + checkBox20ST;
                    Icounter_refahi++;
                }
            }


            Vulue9 = Vulue9 + "}";
            more_joziat_melk_edari_tejari_refahi_refahi_check = Vulue9;
        }
// -refahi

// safe

        if (
                Fine_HoMe_checkBox41ST == "NotNULL" ||
                        Fine_HoMe_checkBox42ST == "NotNULL" ||
                        Fine_HoMe_checkBox43ST == "NotNULL" ||
                        Fine_HoMe_checkBox44ST == "NotNULL" ||
                        Fine_HoMe_checkBox45ST == "NotNULL" ||
                        Fine_HoMe_checkBox46ST == "NotNULL"
                ) {

            Vulue10 = "a:" + counter_safe + ":{";
            Icounter_safe = 0;

            if (Fine_HoMe_checkBox41ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox41ST = "i:" + Icounter_safe + ";s:" + "12" + ":" + "\"دزدگیر\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox41ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox41ST = "i:" + Icounter_safe + ";s:" + "12" + ":" + "\"دزدگیر\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox41ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox42ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox42ST = "i:" + Icounter_safe + ";s:" + "29" + ":" + "\"دوربین مداربسته\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox42ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox42ST = "i:" + Icounter_safe + ";s:" + "29" + ":" + "\"دوربین مداربسته\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox42ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox43ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox43ST = "i:" + Icounter_safe + ";s:" + "23" + ":" + "\"آیفون تصویری\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox43ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox43ST = "i:" + Icounter_safe + ";s:" + "23" + ":" + "\"آیفون تصویری\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox43ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox44ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox44ST = "i:" + Icounter_safe + ";s:" + "20" + ":" + "\"درب ضد سرقت\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox44ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox44ST = "i:" + Icounter_safe + ";s:" + "20" + ":" + "\"درب ضد سرقت\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox44ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox45ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox45ST = "i:" + Icounter_safe + ";s:" + "28" + ":" + "\"سیستم اعلام آتش\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox45ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox45ST = "i:" + Icounter_safe + ";s:" + "28" + ":" + "\"سیستم اعلام آتش\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox45ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox46ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox46ST = "i:" + Icounter_safe + ";s:" + "30" + ":" + "\"سیستم اطفاء حریق\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox46ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox46ST = "i:" + Icounter_safe + ";s:" + "30" + ":" + "\"سیستم اطفاء حریق\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox46ST;
                    Icounter_safe++;
                }
            }

            if (checkBox15ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    checkBox15ST = "i:" + Icounter_safe + ";s:" + "16" + ":" + "\"گاوصندوق\"" + ";";
                    Vulue10 = Vulue10 + checkBox15ST;
                    Icounter_safe++;
                } else {
                    checkBox15ST = "i:" + Icounter_safe + ";s:" + "16" + ":" + "\"گاوصندوق\"" + ";";
                    Vulue10 = Vulue10 + checkBox15ST;
                    Icounter_safe++;
                }
            }


            if (checkBox16ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    checkBox16ST = "i:" + Icounter_safe + ";s:" + "17" + ":" + "\"شیشه نشکن\"" + ";";
                    Vulue10 = Vulue10 + checkBox16ST;
                    Icounter_safe++;
                } else {
                    checkBox16ST = "i:" + Icounter_safe + ";s:" + "17" + ":" + "\"شیشه نشکن\"" + ";";
                    Vulue10 = Vulue10 + checkBox16ST;
                    Icounter_safe++;
                }
            }


            Vulue10 = Vulue10 + "}";
            more_joziat_melk_edari_tejari_safe_safe_check = Vulue10;

        }

// -safe
// dastresi

        Vulue11 = "a:" + counter_emkanat + ":{";
        Icounter_emkanat = 0;
        if (
                Fine_HoMe_checkBox47ST == "NotNULL" ||
                        Fine_HoMe_checkBox48ST == "NotNULL" ||
                        Fine_HoMe_checkBox49ST == "NotNULL" ||
                        Fine_HoMe_checkBox50ST == "NotNULL" ||
                        Fine_HoMe_checkBox51ST == "NotNULL" ||
                        Fine_HoMe_checkBox52ST == "NotNULL"
                ) {

            if (Fine_HoMe_checkBox47ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox47ST = "i:" + Icounter_emkanat + ";s:" + "19" + ":" + "\"داخل بازار\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox47ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox47ST = "i:" + Icounter_emkanat + ";s:" + "19" + ":" + "\"داخل بازار\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox47ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox48ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox48ST = "i:" + Icounter_emkanat + ";s:" + "21" + ":" + "\"خیابان اصلی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox48ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox48ST = "i:" + Icounter_emkanat + ";s:" + "21" + ":" + "\"خیابان اصلی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox48ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox49ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox49ST = "i:" + Icounter_emkanat + ";s:" + "21" + ":" + "\"خیابان فرعی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox49ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox49ST = "i:" + Icounter_emkanat + ";s:" + "21" + ":" + "\"خیابان فرعی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox49ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox50ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox50ST = "i:" + Icounter_emkanat + ";s:" + "10" + ":" + "\"میدان\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox50ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox50ST = "i:" + Icounter_emkanat + ";s:" + "10" + ":" + "\"میدان\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox50ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox51ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox51ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"کوچه\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox51ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox51ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"کوچه\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox51ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox52ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox52ST = "i:" + Icounter_emkanat + ";s:" + "11" + ":" + "\"بن بست\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox52ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox52ST = "i:" + Icounter_emkanat + ";s:" + "11" + ":" + "\"بن بست\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox52ST;
                    Icounter_emkanat++;
                }
            }


        }
        Vulue11 = Vulue11 + "}";
        more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = Vulue11;

// -dastresi
// tasisat


        if (

                Fine_HoMe_checkBox83ST == "NotNULL" ||
                        Fine_HoMe_checkBox84ST == "NotNULL" ||
                        Fine_HoMe_checkBox85ST == "NotNULL" ||
                        Fine_HoMe_checkBox86ST == "NotNULL"
                ) {

            Vulue15 = "a:" + counter_tasisat + ":{";
            Icounter_tasisat = 0;

            if (Fine_HoMe_checkBox83ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox83ST = "i:" + Icounter_tasisat + ";s:" + "13" + ":" + "\"آب شهری\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox83ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox83ST = "i:" + Icounter_tasisat + ";s:" + "13" + ":" + "\"آب شهری\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox83ST;
                    Icounter_tasisat++;
                }
            }

            if (Fine_HoMe_checkBox84ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox84ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox84ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox84ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox84ST;
                    Icounter_tasisat++;
                }
            }

            if (Fine_HoMe_checkBox85ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox85ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"گاز\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox85ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox85ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"گاز\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox85ST;
                    Icounter_tasisat++;
                }
            }

            if (Fine_HoMe_checkBox86ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox86ST = "i:" + Icounter_tasisat + ";s:" + "21" + ":" + "\"ژنراتور برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox86ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox86ST = "i:" + Icounter_tasisat + ";s:" + "21" + ":" + "\"ژنراتور برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox86ST;
                    Icounter_tasisat++;
                }
            }

            if (checkBox10ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    checkBox10ST = "i:" + Icounter_tasisat + ";s:" + "21" + ":" + "\"منابع تغذیه برق\"" + ";";
                    Vulue15 = Vulue15 + checkBox10ST;
                    Icounter_tasisat++;
                } else {
                    checkBox10ST = "i:" + Icounter_tasisat + ";s:" + "21" + ":" + "\"منابع تغذیه برق\"" + ";";
                    Vulue15 = Vulue15 + checkBox10ST;
                    Icounter_tasisat++;
                }
            }


            Vulue15 = Vulue15 + "}";
            more_joziat_melk_edari_tejari_tasisat_tasisat_check = Vulue15;
        }


// -tasisat
        moshakhasat_asli_melk_moghiita_store = moshakhasat_asli_melk_noe_bana;
        moshakhasat_asli_melk_masahat_kaf = Find_HoMe_editText_masahat_made.getText().toString();
        moshakhasat_asli_melk_masahat_balkon = Find_HoMe_editText_masahat_ground.getText().toString();
        moshakhasat_asli_melk_nuumber_dahane = moshakhasat_asli_melk_moghiat_build;
        moshakhasat_asli_melk_tol_bar_asli = Find_HoMe_editText_year_made.getText().toString();
        moshakhasat_asli_melk_number_bar = moshakhasat_asli_melk_number_room;
        moshakhasat_asli_melk_noe_vaghozari = moshakhasat_asli_melk_noe_vaghozari;
        more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh = Find_HoMe_editText.getText().toString();
        more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh = Find_HoMe_editText2.getText().toString();
        more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe = Find_HoMe_editText3.getText().toString();
        more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze = Find_HoMe_editText4.getText().toString();
        more_joziat_melk_edari_tejari_wc_wc_irani = more_joziat_melk_edari_tejari_wc_wc_irani;
        more_joziat_melk_edari_tejari_wc_wc_us = more_joziat_melk_edari_tejari_wc_wc_us;
        more_joziat_melk_edari_tejari_wc_roshoii = more_joziat_melk_edari_tejari_wc_bath;
        more_joziat_melk_edari_tejari_abdarhkane_tejari = more_joziat_melk_edari_tejari_abdarhkane_tejari;
        more_joziat_melk_edari_tejari_fazai_asli_fazai_asli = more_joziat_melk_edari_tejari_room_asli_room_asli_check;
        more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari = more_joziat_melk_edari_tejari_nama_nama_check;
        more_joziat_melk_edari_tejari_nama_nama_edit = Find_HoMe_editText11.getText().toString();
        more_joziat_melk_edari_tejari_kaf_kaf_check = more_joziat_melk_edari_tejari_kaf_kaf_check;
        more_joziat_melk_edari_tejari_kaf_kaf_edit = Find_HoMe_editText13.getText().toString();
        more_joziat_melk_edari_tejari_coldhot_coldhot_check = more_joziat_melk_edari_tejari_coldhot_coldhot_check;
        more_joziat_melk_edari_tejari_coldhot_coldhot_edit = Find_HoMe_editText151.getText().toString();
        more_joziat_melk_edari_tejari_refahi_refahi_check_tejari = more_joziat_melk_edari_tejari_refahi_refahi_check;
        more_joziat_melk_edari_tejari_refahi_refahi_edit = Find_HoMe_editText15.getText().toString();
        more_joziat_melk_edari_tejari_safe_safe_check_tejari = more_joziat_melk_edari_tejari_safe_safe_check;
        more_joziat_melk_edari_tejari_safe_safe_edit = Find_HoMe_editText16.getText().toString();
        more_joziat_melk_edari_tejari_dastresi_dastresi_check = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;
        more_joziat_melk_edari_tejari_dastresi_dastres_edit = Find_HoMe_editText17.getText().toString();
        more_joziat_melk_edari_tejari_ghozar_asli = editText13.getText().toString();
        more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari = more_joziat_melk_edari_tejari_tasisat_tasisat_check;
        more_joziat_melk_edari_tejari_tasisat_tasisat_edit = more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
        more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
        more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
        more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;


        editText.setText(


                " \n noe_melk_moamele = " + noe_melk_moamele +
                        " \n noe_melk = " + noe_melk +
                        " \n moshakhasat_asli_melk_moghiita_store = " + moshakhasat_asli_melk_moghiita_store +
                        " \n moshakhasat_asli_melk_masahat_kaf = " + moshakhasat_asli_melk_masahat_kaf +
                        " \n moshakhasat_asli_melk_masahat_balkon = " + moshakhasat_asli_melk_masahat_balkon +
                        " \n moshakhasat_asli_melk_nuumber_dahane = " + moshakhasat_asli_melk_nuumber_dahane +
                        " \n moshakhasat_asli_melk_tol_bar_asli = " + moshakhasat_asli_melk_tol_bar_asli +
                        " \n moshakhasat_asli_melk_number_bar = " + moshakhasat_asli_melk_number_bar +
                        " \n moshakhasat_asli_melk_noe_vaghozari = " + moshakhasat_asli_melk_noe_vaghozari +
                        " \n more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh = " + more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh +
                        " \n more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh = " + more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh +
                        " \n more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe = " + more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe +
                        " \n more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze = " + more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze +
                        " \n more_joziat_melk_edari_tejari_wc_wc_irani = " + more_joziat_melk_edari_tejari_wc_wc_irani +
                        " \n more_joziat_melk_edari_tejari_wc_wc_us = " + more_joziat_melk_edari_tejari_wc_wc_us +
                        " \n more_joziat_melk_edari_tejari_wc_roshoii = " + more_joziat_melk_edari_tejari_wc_roshoii +
                        " \n more_joziat_melk_edari_tejari_abdarhkane_tejari = " + more_joziat_melk_edari_tejari_abdarhkane_tejari +
                        " \n more_joziat_melk_edari_tejari_fazai_asli_fazai_asli = " + more_joziat_melk_edari_tejari_fazai_asli_fazai_asli +
                        " \n more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari = " + more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari +
                        " \n more_joziat_melk_edari_tejari_nama_nama_edit = " + more_joziat_melk_edari_tejari_nama_nama_edit +
                        " \n more_joziat_melk_edari_tejari_kaf_kaf_check = " + more_joziat_melk_edari_tejari_kaf_kaf_check +
                        " \n more_joziat_melk_edari_tejari_kaf_kaf_edit = " + more_joziat_melk_edari_tejari_kaf_kaf_edit +
                        " \n more_joziat_melk_edari_tejari_coldhot_coldhot_check = " + more_joziat_melk_edari_tejari_coldhot_coldhot_check +
                        " \n more_joziat_melk_edari_tejari_coldhot_coldhot_edit = " + more_joziat_melk_edari_tejari_coldhot_coldhot_edit +
                        " \n more_joziat_melk_edari_tejari_refahi_refahi_check_tejari = " + more_joziat_melk_edari_tejari_refahi_refahi_check_tejari +
                        " \n more_joziat_melk_edari_tejari_refahi_refahi_edit = " + more_joziat_melk_edari_tejari_refahi_refahi_edit +
                        " \n more_joziat_melk_edari_tejari_safe_safe_check_tejari = " + more_joziat_melk_edari_tejari_safe_safe_check_tejari +
                        " \n more_joziat_melk_edari_tejari_safe_safe_edit = " + more_joziat_melk_edari_tejari_safe_safe_edit +
                        " \n more_joziat_melk_edari_tejari_dastresi_dastresi_check = " + more_joziat_melk_edari_tejari_dastresi_dastresi_check +
                        " \n more_joziat_melk_edari_tejari_dastresi_dastres_edit = " + more_joziat_melk_edari_tejari_dastresi_dastres_edit +
                        " \n more_joziat_melk_edari_tejari_ghozar_asli = " + more_joziat_melk_edari_tejari_ghozar_asli +
                        " \n more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari = " + more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari +
                        " \n more_joziat_melk_edari_tejari_tasisat_tasisat_edit = " + more_joziat_melk_edari_tejari_tasisat_tasisat_edit +
                        " \n more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = " + more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat +
                        " \n more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = " + more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat +
                        " \n more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = " + more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam
        );


//------------------------------------------------------end of send tejari
    }

    public void swichSendMostaghelat() {

// karbariePishnahadi
        Vulue17 = "a:" + counter_KarbariPishnahadi + ":{";
        Icounter_refahi = 0;
        if (


                checkBox26ST == "NotNULL" ||
                        checkBox27ST == "NotNULL" ||
                        checkBox28ST == "NotNULL" ||
                        checkBox29ST == "NotNULL" ||
                        checkBox30ST == "NotNULL" ||
                        checkBox31ST == "NotNULL" ||
                        checkBox32ST == "NotNULL" ||
                        checkBox39ST == "NotNULL" ||
                        checkBox40ST == "NotNULL" ||
                        checkBox88ST == "NotNULL" ||
                        checkBox89ST == "NotNULL" ||
                        checkBox90ST == "NotNULL" ||
                        checkBox91ST == "NotNULL"
                ) {

            if (checkBox26ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox26ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "12" + ":" + "\"مسکونی\"" + ";";
                    Vulue17 = Vulue17 + checkBox26ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox26ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "12" + ":" + "\"مسکونی\"" + ";";
                    Vulue17 = Vulue17 + checkBox26ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox27ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox27ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"اداری\"" + ";";
                    Vulue17 = Vulue17 + checkBox27ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox27ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"اداری\"" + ";";
                    Vulue17 = Vulue17 + checkBox27ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox28ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox28ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"تجاری\"" + ";";
                    Vulue17 = Vulue17 + checkBox28ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox28ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"تجاری\"" + ";";
                    Vulue17 = Vulue17 + checkBox28ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox29ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox29ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"صعنتی\"" + ";";
                    Vulue17 = Vulue17 + checkBox29ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox29ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"صعنتی\"" + ";";
                    Vulue17 = Vulue17 + checkBox29ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox30ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox30ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "25" + ":" + "\"تفریحی - ورزشی\"" + ";";
                    Vulue17 = Vulue17 + checkBox30ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox30ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "25" + ":" + "\"تفریحی - ورزشی\"" + ";";
                    Vulue17 = Vulue17 + checkBox30ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox31ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox31ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "12" + ":" + "\"آموزشی\"" + ";";
                    Vulue17 = Vulue17 + checkBox31ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox31ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "12" + ":" + "\"آموزشی\"" + ";";
                    Vulue17 = Vulue17 + checkBox31ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox32ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox32ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "14" + ":" + "\"توریستی\"" + ";";
                    Vulue17 = Vulue17 + checkBox32ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox32ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "14" + ":" + "\"توریستی\"" + ";";
                    Vulue17 = Vulue17 + checkBox32ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox39ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox39ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "16" + ":" + "\"دامپروری\"" + ";";
                    Vulue17 = Vulue17 + checkBox39ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox39ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "16" + ":" + "\"دامپروری\"" + ";";
                    Vulue17 = Vulue17 + checkBox39ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox40ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox40ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "14" + ":" + "\"کشاورزی\"" + ";";
                    Vulue17 = Vulue17 + checkBox40ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox40ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "14" + ":" + "\"کشاورزی\"" + ";";
                    Vulue17 = Vulue17 + checkBox40ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox88ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox88ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "32" + ":" + "\"باغشهر - شهرک سازی\"" + ";";
                    Vulue17 = Vulue17 + checkBox88ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox88ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "32" + ":" + "\"باغشهر - شهرک سازی\"" + ";";
                    Vulue17 = Vulue17 + checkBox88ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox89ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox89ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "23" + ":" + "\"خدماتی رفاهی\"" + ";";
                    Vulue17 = Vulue17 + checkBox89ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox89ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "23" + ":" + "\"خدماتی رفاهی\"" + ";";
                    Vulue17 = Vulue17 + checkBox89ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox90ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox90ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"انبار\"" + ";";
                    Vulue17 = Vulue17 + checkBox90ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox90ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"انبار\"" + ";";
                    Vulue17 = Vulue17 + checkBox90ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox91ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox91ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "14" + ":" + "\"پارکینگ\"" + ";";
                    Vulue17 = Vulue17 + checkBox91ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox91ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "14" + ":" + "\"پارکینگ\"" + ";";
                    Vulue17 = Vulue17 + checkBox91ST;
                    Icounter_KarbariPishnahadi++;
                }
            }


            Vulue17 = Vulue17 + "}";
            more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check = Vulue17;
        }
// -karbariPishnahadi

// nma

        if (
                Fine_HoMe_checkBox6ST == "NotNULL" ||
                        Fine_HoMe_checkBox7ST == "NotNULL" ||
                        Fine_HoMe_checkBox8ST == "NotNULL" ||
                        Fine_HoMe_checkBox9ST == "NotNULL" ||
                        Fine_HoMe_checkBox10ST == "NotNULL" ||
                        Fine_HoMe_checkBox11ST == "NotNULL" ||
                        Fine_HoMe_checkBox12ST == "NotNULL"

                ) {

            Vulue4 = "a:" + counter_nma + ":{";
            Icounter_nma = 0;

            if (Fine_HoMe_checkBox6ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox6ST = "i:" + Icounter_nma + ";s:" + "18" + ":" + "\"نورپردازی\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox6ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox6ST = "i:" + Icounter_nma + ";s:" + "18" + ":" + "\"نورپردازی\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox6ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox7ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox7ST = "i:" + Icounter_nma + ";s:" + "16" + ":" + "\"کامپوزیت\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox7ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox7ST = "i:" + Icounter_nma + ";s:" + "16" + ":" + "\"کامپوزیت\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox7ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox8ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox8ST = "i:" + Icounter_nma + ";s:" + "8" + ":" + "\"شیشه\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox8ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox8ST = "i:" + Icounter_nma + ";s:" + "8" + ":" + "\"شیشه\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox8ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox9ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox9ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"چوب\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox9ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox9ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"چوب\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox9ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox10ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox10ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox10ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox10ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox10ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox11ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox11ST = "i:" + Icounter_nma + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox11ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox11ST = "i:" + Icounter_nma + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox11ST;
                    Icounter_nma++;
                }
            }

            if (Fine_HoMe_checkBox12ST == "NotNULL") {
                if (Icounter_nma == 0) {
                    Fine_HoMe_checkBox12ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"آجر\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox12ST;
                    Icounter_nma++;
                } else {
                    Fine_HoMe_checkBox12ST = "i:" + Icounter_nma + ";s:" + "6" + ":" + "\"آجر\"" + ";";
                    Vulue4 = Vulue4 + Fine_HoMe_checkBox12ST;
                    Icounter_nma++;
                }
            }

            Vulue4 = Vulue4 + "}";
            more_joziat_melk_edari_tejari_nama_nama_check = Vulue4;
        }

// -nma

// eskelet

        if (
                Fine_HoMe_checkBox13ST == "NotNULL" ||
                        Fine_HoMe_checkBox14ST == "NotNULL" ||
                        Fine_HoMe_checkBox15ST == "NotNULL" ||
                        Fine_HoMe_checkBox16ST == "NotNULL"
                ) {

            Vulue5 = "a:" + counter_eskelet + ":{";
            Icounter_eskelet = 0;

            if (Fine_HoMe_checkBox13ST == "NotNULL") {
                if (Icounter_eskelet == 0) {
                    Fine_HoMe_checkBox13ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"بتنی\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox13ST;
                    Icounter_eskelet++;
                } else {
                    Fine_HoMe_checkBox13ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"بتنی\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox13ST;
                    Icounter_eskelet++;
                }
            }

            if (Fine_HoMe_checkBox14ST == "NotNULL") {
                if (Icounter_eskelet == 0) {
                    Fine_HoMe_checkBox14ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"آجری\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox14ST;
                    Icounter_eskelet++;
                } else {
                    Fine_HoMe_checkBox14ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"آجری\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox14ST;
                    Icounter_eskelet++;
                }
            }

            if (Fine_HoMe_checkBox15ST == "NotNULL") {
                if (Icounter_eskelet == 0) {
                    Fine_HoMe_checkBox15ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"فلزی\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox15ST;
                    Icounter_eskelet++;
                } else {
                    Fine_HoMe_checkBox15ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"فلزی\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox15ST;
                    Icounter_eskelet++;
                }
            }

            if (Fine_HoMe_checkBox16ST == "NotNULL") {
                if (Icounter_eskelet == 0) {
                    Fine_HoMe_checkBox16ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"چوبی\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox16ST;
                    Icounter_eskelet++;
                } else {
                    Fine_HoMe_checkBox16ST = "i:" + Icounter_eskelet + ";s:" + "8" + ":" + "\"چوبی\"" + ";";
                    Vulue5 = Vulue5 + Fine_HoMe_checkBox16ST;
                    Icounter_eskelet++;
                }
            }

            Vulue5 = Vulue5 + "}";
            more_joziat_melk_edari_tejari_eskelet_eskelet_check = Vulue5;
        }

// -eskelet

// divar


        if (

                Fine_HoMe_checkBox25ST == "NotNULL" ||
                        Fine_HoMe_checkBox26ST == "NotNULL" ||
                        Fine_HoMe_checkBox27ST == "NotNULL" ||
                        Fine_HoMe_checkBox28ST == "NotNULL" ||
                        Fine_HoMe_checkBox29ST == "NotNULL" ||
                        Fine_HoMe_checkBox30ST == "NotNULL" ||
                        Fine_HoMe_checkBox31ST == "NotNULL" ||
                        Fine_HoMe_checkBox32ST == "NotNULL"

                ) {
            Vulue7 = "a:" + counter_divar + ":{";
            Icounter_divar = 0;

            if (Fine_HoMe_checkBox25ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox25ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox25ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox25ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"سنگ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox25ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox26ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox26ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"رنگ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox26ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox26ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"رنگ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox26ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox27ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox27ST = "i:" + Icounter_divar + ";s:" + "22" + ":" + "\"کاشی / سرامیک\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox27ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox27ST = "i:" + Icounter_divar + ";s:" + "22" + ":" + "\"کاشی / سرامیک\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox27ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox28ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox28ST = "i:" + Icounter_divar + ";s:" + "21" + ":" + "\"کاغذ دیواری\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox28ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox28ST = "i:" + Icounter_divar + ";s:" + "21" + ":" + "\"کاغذ دیواری\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox28ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox29ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox29ST = "i:" + Icounter_divar + ";s:" + "24" + ":" + "\"چوب/ دیوارکوب\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox29ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox29ST = "i:" + Icounter_divar + ";s:" + "24" + ":" + "\"چوب/ دیوارکوب\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox29ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox30ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox30ST = "i:" + Icounter_divar + ";s:" + "4" + ":" + "\"گچ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox30ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox30ST = "i:" + Icounter_divar + ";s:" + "4" + ":" + "\"گچ\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox30ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox31ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox31ST = "i:" + Icounter_divar + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox31ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox31ST = "i:" + Icounter_divar + ";s:" + "10" + ":" + "\"سیمان\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox31ST;
                    Icounter_divar++;
                }
            }

            if (Fine_HoMe_checkBox32ST == "NotNULL") {
                if (Icounter_divar == 0) {
                    Fine_HoMe_checkBox32ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"آجر\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox32ST;
                    Icounter_divar++;
                } else {
                    Fine_HoMe_checkBox32ST = "i:" + Icounter_divar + ";s:" + "6" + ":" + "\"آجر\"" + ";";
                    Vulue7 = Vulue7 + Fine_HoMe_checkBox32ST;
                    Icounter_divar++;
                }
            }
            Vulue7 = Vulue7 + "}";
            more_joziat_melk_edari_tejari_divar_divar_check = Vulue7;

        }


// -divar

// coldhot

        if (
                Fine_HoMe_checkBox331ST == "NotNULL" ||
                        Fine_HoMe_checkBox341ST == "NotNULL" ||
                        Fine_HoMe_checkBox351ST == "NotNULL" ||
                        Fine_HoMe_checkBox361ST == "NotNULL" ||
                        Fine_HoMe_checkBox371ST == "NotNULL" ||
                        Fine_HoMe_checkBox381ST == "NotNULL" ||
                        Fine_HoMe_checkBox39ST == "NotNULL" ||
                        Fine_HoMe_checkBox40ST == "NotNULL"
                ) {

            Vulue8 = "a:" + counter_coldhot + ":{";
            Icounter_coldhot = 0;

            if (Fine_HoMe_checkBox341ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox341ST = "i:" + Icounter_coldhot + ";s:" + "8" + ":" + "\"کولر\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox341ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox341ST = "i:" + Icounter_coldhot + ";s:" + "8" + ":" + "\"کولر\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox341ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox331ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox331ST = "i:" + Icounter_coldhot + ";s:" + "30" + ":" + "\"کولرگازی/ اسپلیت\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox331ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox331ST = "i:" + Icounter_coldhot + ";s:" + "30" + ":" + "\"کولرگازی/ اسپلیت\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox331ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox351ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox351ST = "i:" + Icounter_coldhot + ";s:" + "10" + ":" + "\"بخاری\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox351ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox351ST = "i:" + Icounter_coldhot + ";s:" + "10" + ":" + "\"بخاری\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox351ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox361ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox361ST = "i:" + Icounter_coldhot + ";s:" + "26" + ":" + "\"پکیج/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox361ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox361ST = "i:" + Icounter_coldhot + ";s:" + "26" + ":" + "\"پکیج/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox361ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox371ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox371ST = "i:" + Icounter_coldhot + ";s:" + "24" + ":" + "\"دیگ/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox371ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox371ST = "i:" + Icounter_coldhot + ";s:" + "24" + ":" + "\"دیگ/ رادیاتور\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox371ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox381ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox381ST = "i:" + Icounter_coldhot + ";s:" + "23" + ":" + "\"چیلر/ فن کوئل\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox381ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox381ST = "i:" + Icounter_coldhot + ";s:" + "23" + ":" + "\"چیلر/ فن کوئل\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox381ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox39ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox39ST = "i:" + Icounter_coldhot + ";s:" + "29" + ":" + "\"آبگرمکن خورشیدی\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox39ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox39ST = "i:" + Icounter_coldhot + ";s:" + "29" + ":" + "\"آبگرمکن خورشیدی\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox39ST;
                    Icounter_coldhot++;
                }
            }

            if (Fine_HoMe_checkBox40ST == "NotNULL") {
                if (Icounter_coldhot == 0) {
                    Fine_HoMe_checkBox40ST = "i:" + Icounter_coldhot + ";s:" + "12" + ":" + "\"هواساز\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox40ST;
                    Icounter_coldhot++;
                } else {
                    Fine_HoMe_checkBox40ST = "i:" + Icounter_coldhot + ";s:" + "12" + ":" + "\"هواساز\"" + ";";
                    Vulue8 = Vulue8 + Fine_HoMe_checkBox40ST;
                    Icounter_coldhot++;
                }
            }
            Vulue8 = Vulue8 + "}";
            more_joziat_melk_edari_tejari_coldhot_coldhot_check = Vulue8;
        }


// -coldhot
// refahi

        Vulue9 = "a:" + counter_refahi + ":{";
        Icounter_refahi = 0;
        if (
                Fine_HoMe_checkBox33ST == "NotNULL" ||
                        Fine_HoMe_checkBox34ST == "NotNULL" ||
                        Fine_HoMe_checkBox35ST == "NotNULL" ||
                        Fine_HoMe_checkBox36ST == "NotNULL" ||
                        Fine_HoMe_checkBox37ST == "NotNULL" ||
                        Fine_HoMe_checkBox38ST == "NotNULL"
                ) {

            if (Fine_HoMe_checkBox33ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox33ST = "i:" + Icounter_refahi + ";s:" + "14" + ":" + "\"آسانسور\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox33ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox33ST = "i:" + Icounter_refahi + ";s:" + "14" + ":" + "\"آسانسور\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox33ST;
                    Icounter_refahi++;
                }
            }

            if (Fine_HoMe_checkBox34ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox34ST = "i:" + Icounter_refahi + ";s:" + "39" + ":" + "\"درب پارکینگ ریموت دار\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox34ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox34ST = "i:" + Icounter_refahi + ";s:" + "39" + ":" + "\"درب پارکینگ ریموت دار\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox34ST;
                    Icounter_refahi++;
                }
            }

            if (Fine_HoMe_checkBox35ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox35ST = "i:" + Icounter_refahi + ";s:" + "21" + ":" + "\"شوتیگ زباله\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox35ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox35ST = "i:" + Icounter_refahi + ";s:" + "21" + ":" + "\"شوتیگ زباله\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox35ST;
                    Icounter_refahi++;
                }
            }

            if (Fine_HoMe_checkBox36ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox36ST = "i:" + Icounter_refahi + ";s:" + "19" + ":" + "\"آنتن مرکزی\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox36ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox36ST = "i:" + Icounter_refahi + ";s:" + "19" + ":" + "\"آنتن مرکزی\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox36ST;
                    Icounter_refahi++;
                }
            }

            if (Fine_HoMe_checkBox37ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox37ST = "i:" + Icounter_refahi + ";s:" + "27" + ":" + "\"اینترنت پرسرعت\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox37ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox37ST = "i:" + Icounter_refahi + ";s:" + "27" + ":" + "\"اینترنت پرسرعت\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox37ST;
                    Icounter_refahi++;
                }
            }

            if (Fine_HoMe_checkBox38ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    Fine_HoMe_checkBox38ST = "i:" + Icounter_refahi + ";s:" + "19" + ":" + "\"شبکه داخلی\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox38ST;
                    Icounter_refahi++;
                } else {
                    Fine_HoMe_checkBox38ST = "i:" + Icounter_refahi + ";s:" + "19" + ":" + "\"شبکه داخلی\"" + ";";
                    Vulue9 = Vulue9 + Fine_HoMe_checkBox38ST;
                    Icounter_refahi++;
                }
            }
            if (checkBox20ST == "NotNULL") {
                if (Icounter_refahi == 0) {
                    checkBox20ST = "i:" + Icounter_refahi + ";s:" + "28" + ":" + "\"آسانسور حمل بار\"" + ";";
                    Vulue9 = Vulue9 + checkBox20ST;
                    Icounter_refahi++;
                } else {
                    checkBox20ST = "i:" + Icounter_refahi + ";s:" + "28" + ":" + "\"آسانسور حمل بار\"" + ";";
                    Vulue9 = Vulue9 + checkBox20ST;
                    Icounter_refahi++;
                }
            }

            Vulue9 = Vulue9 + "}";
            more_joziat_melk_edari_tejari_refahi_refahi_check = Vulue9;
        }

// -refahi
        // safe

        if (
                Fine_HoMe_checkBox41ST == "NotNULL" ||
                        Fine_HoMe_checkBox42ST == "NotNULL" ||
                        Fine_HoMe_checkBox43ST == "NotNULL" ||
                        Fine_HoMe_checkBox44ST == "NotNULL" ||
                        Fine_HoMe_checkBox45ST == "NotNULL" ||
                        Fine_HoMe_checkBox46ST == "NotNULL"
                ) {

            Vulue10 = "a:" + counter_safe + ":{";
            Icounter_safe = 0;

            if (Fine_HoMe_checkBox41ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox41ST = "i:" + Icounter_safe + ";s:" + "12" + ":" + "\"دزدگیر\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox41ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox41ST = "i:" + Icounter_safe + ";s:" + "12" + ":" + "\"دزدگیر\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox41ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox42ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox42ST = "i:" + Icounter_safe + ";s:" + "29" + ":" + "\"دوربین مداربسته\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox42ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox42ST = "i:" + Icounter_safe + ";s:" + "29" + ":" + "\"دوربین مداربسته\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox42ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox43ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox43ST = "i:" + Icounter_safe + ";s:" + "23" + ":" + "\"آیفون تصویری\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox43ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox43ST = "i:" + Icounter_safe + ";s:" + "23" + ":" + "\"آیفون تصویری\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox43ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox44ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox44ST = "i:" + Icounter_safe + ";s:" + "20" + ":" + "\"درب ضد سرقت\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox44ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox44ST = "i:" + Icounter_safe + ";s:" + "20" + ":" + "\"درب ضد سرقت\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox44ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox45ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox45ST = "i:" + Icounter_safe + ";s:" + "28" + ":" + "\"سیستم اعلام آتش\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox45ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox45ST = "i:" + Icounter_safe + ";s:" + "28" + ":" + "\"سیستم اعلام آتش\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox45ST;
                    Icounter_safe++;
                }
            }

            if (Fine_HoMe_checkBox46ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    Fine_HoMe_checkBox46ST = "i:" + Icounter_safe + ";s:" + "30" + ":" + "\"سیستم اطفاء حریق\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox46ST;
                    Icounter_safe++;
                } else {
                    Fine_HoMe_checkBox46ST = "i:" + Icounter_safe + ";s:" + "30" + ":" + "\"سیستم اطفاء حریق\"" + ";";
                    Vulue10 = Vulue10 + Fine_HoMe_checkBox46ST;
                    Icounter_safe++;
                }
            }

            if (checkBox15ST == "NotNULL") {
                if (Icounter_safe == 0) {
                    checkBox15ST = "i:" + Icounter_safe + ";s:" + "16" + ":" + "\"گاوصندوق\"" + ";";
                    Vulue10 = Vulue10 + checkBox15ST;
                    Icounter_safe++;
                } else {
                    checkBox15ST = "i:" + Icounter_safe + ";s:" + "16" + ":" + "\"گاوصندوق\"" + ";";
                    Vulue10 = Vulue10 + checkBox15ST;
                    Icounter_safe++;
                }
            }


            Vulue10 = Vulue10 + "}";
            more_joziat_melk_edari_tejari_safe_safe_check = Vulue10;

        }

// -safe
// dastresi mosta

        if (


                checkBox21ST == "NotNULL" ||
                        checkBox23ST == "NotNULL" ||
                        checkBox24ST == "NotNULL" ||
                        checkBox25ST == "NotNULL" ||
                        checkBox93ST == "NotNULL" ||
                        checkBox22ST == "NotNULL" ||
                        checkBox94ST == "NotNULL"
                ) {


            Vulue18 = "a:" + counter_dastresi + ":{";
            Icounter_dastresi = 0;

            if (checkBox21ST == "NotNULL") {
                if (Icounter_dastresi == 0) {
                    checkBox21ST = "i:" + Icounter_dastresi + ";s:" + "19" + ":" + "\"داخل بازار\"" + ";";
                    Vulue18 = Vulue18 + checkBox21ST;
                    Icounter_dastresi++;
                } else {
                    checkBox21ST = "i:" + Icounter_dastresi + ";s:" + "19" + ":" + "\"داخل بازار\"" + ";";
                    Vulue18 = Vulue18 + checkBox21ST;
                    Icounter_dastresi++;
                }
            }

            if (checkBox23ST == "NotNULL") {
                if (Icounter_dastresi == 0) {
                    checkBox23ST = "i:" + Icounter_dastresi + ";s:" + "21" + ":" + "\"خیابان اصلی\"" + ";";
                    Vulue18 = Vulue18 + checkBox23ST;
                    Icounter_dastresi++;
                } else {
                    checkBox23ST = "i:" + Icounter_dastresi + ";s:" + "21" + ":" + "\"خیابان اصلی\"" + ";";
                    Vulue18 = Vulue18 + checkBox23ST;
                    Icounter_dastresi++;
                }
            }

            if (checkBox24ST == "NotNULL") {
                if (Icounter_dastresi == 0) {
                    checkBox24ST = "i:" + Icounter_dastresi + ";s:" + "21" + ":" + "\"خیابان فرعی\"" + ";";
                    Vulue18 = Vulue18 + checkBox24ST;
                    Icounter_dastresi++;
                } else {
                    checkBox24ST = "i:" + Icounter_dastresi + ";s:" + "21" + ":" + "\"خیابان فرعی\"" + ";";
                    Vulue18 = Vulue18 + checkBox24ST;
                    Icounter_dastresi++;
                }
            }

            if (checkBox25ST == "NotNULL") {
                if (Icounter_dastresi == 0) {
                    checkBox25ST = "i:" + Icounter_dastresi + ";s:" + "10" + ":" + "\"میدان\"" + ";";
                    Vulue18 = Vulue18 + checkBox25ST;
                    Icounter_dastresi++;
                } else {
                    checkBox25ST = "i:" + Icounter_dastresi + ";s:" + "10" + ":" + "\"میدان\"" + ";";
                    Vulue18 = Vulue18 + checkBox25ST;
                    Icounter_dastresi++;
                }
            }

            if (checkBox93ST == "NotNULL") {
                if (Icounter_dastresi == 0) {
                    checkBox93ST = "i:" + Icounter_dastresi + ";s:" + "8" + ":" + "\"کوچه\"" + ";";
                    Vulue18 = Vulue18 + checkBox93ST;
                    Icounter_dastresi++;
                } else {
                    checkBox93ST = "i:" + Icounter_dastresi + ";s:" + "8" + ":" + "\"کوچه\"" + ";";
                    Vulue18 = Vulue18 + checkBox93ST;
                    Icounter_dastresi++;
                }
            }

            if (checkBox94ST == "NotNULL") {
                if (Icounter_dastresi == 0) {
                    checkBox94ST = "i:" + Icounter_dastresi + ";s:" + "11" + ":" + "\"بن بست\"" + ";";
                    Vulue18 = Vulue18 + checkBox94ST;
                    Icounter_dastresi++;
                } else {
                    checkBox94ST = "i:" + Icounter_dastresi + ";s:" + "11" + ":" + "\"بن بست\"" + ";";
                    Vulue18 = Vulue18 + checkBox94ST;
                    Icounter_dastresi++;
                }
            }

            if (checkBox22ST == "NotNULL") {
                if (Icounter_dastresi == 0) {
                    checkBox22ST = "i:" + Icounter_dastresi + ";s:" + "14" + ":" + "\"بزرگراه\"" + ";";
                    Vulue18 = Vulue18 + checkBox22ST;
                    Icounter_dastresi++;
                } else {
                    checkBox22ST = "i:" + Icounter_dastresi + ";s:" + "14" + ":" + "\"بزرگراه\"" + ";";
                    Vulue18 = Vulue18 + checkBox22ST;
                    Icounter_dastresi++;
                }
            }

            Vulue18 = Vulue18 + "}";
            more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta = Vulue18;

        }
// -dastresi mosta
// emkanat

        if (
                Fine_HoMe_checkBox47ST == "NotNULL" ||
                        Fine_HoMe_checkBox48ST == "NotNULL" ||
                        Fine_HoMe_checkBox49ST == "NotNULL" ||
                        Fine_HoMe_checkBox50ST == "NotNULL" ||
                        Fine_HoMe_checkBox51ST == "NotNULL" ||
                        Fine_HoMe_checkBox52ST == "NotNULL" ||
                        Fine_HoMe_checkBox53ST == "NotNULL" ||
                        Fine_HoMe_checkBox54ST == "NotNULL" ||
                        Fine_HoMe_checkBox55ST == "NotNULL" ||
                        Fine_HoMe_checkBox56ST == "NotNULL" ||
                        Fine_HoMe_checkBox57ST == "NotNULL" ||
                        Fine_HoMe_checkBox58ST == "NotNULL"
                ) {

            Vulue11 = "a:" + counter_emkanat + ":{";
            Icounter_emkanat = 0;

            if (Fine_HoMe_checkBox47ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox47ST = "i:" + Icounter_emkanat + ";s:" + "17" + ":" + "\"حیاط خلوت\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox47ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox47ST = "i:" + Icounter_emkanat + ";s:" + "17" + ":" + "\"حیاط خلوت\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox47ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox48ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox48ST = "i:" + Icounter_emkanat + ";s:" + "16" + ":" + "\"سرایداری\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox48ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox48ST = "i:" + Icounter_emkanat + ";s:" + "16" + ":" + "\"سرایداری\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox48ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox49ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox49ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"لابی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox49ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox49ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"لابی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox49ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox50ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox50ST = "i:" + Icounter_emkanat + ";s:" + "6" + ":" + "\"باغ\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox50ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox50ST = "i:" + Icounter_emkanat + ";s:" + "6" + ":" + "\"باغ\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox50ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox51ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox51ST = "i:" + Icounter_emkanat + ";s:" + "11" + ":" + "\"آب نما\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox51ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox51ST = "i:" + Icounter_emkanat + ";s:" + "11" + ":" + "\"آب نما\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox51ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox52ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox52ST = "i:" + Icounter_emkanat + ";s:" + "16" + ":" + "\"باربیکیو\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox52ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox52ST = "i:" + Icounter_emkanat + ";s:" + "16" + ":" + "\"باربیکیو\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox52ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox53ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox53ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"حیاط\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox53ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox53ST = "i:" + Icounter_emkanat + ";s:" + "8" + ":" + "\"حیاط\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox53ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox54ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox54ST = "i:" + Icounter_emkanat + ";s:" + "15" + ":" + "\"فضای سبز\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox54ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox54ST = "i:" + Icounter_emkanat + ";s:" + "15" + ":" + "\"فضای سبز\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox54ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox55ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox55ST = "i:" + Icounter_emkanat + ";s:" + "14" + ":" + "\"نگهبانی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox55ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox55ST = "i:" + Icounter_emkanat + ";s:" + "14" + ":" + "\"نگهبانی\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox55ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox57ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox57ST = "i:" + Icounter_emkanat + ";s:" + "12" + ":" + "\"آلاچیق\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox57ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox57ST = "i:" + Icounter_emkanat + ";s:" + "12" + ":" + "\"آلاچیق\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox57ST;
                    Icounter_emkanat++;
                }
            }

            if (Fine_HoMe_checkBox58ST == "NotNULL") {
                if (Icounter_emkanat == 0) {
                    Fine_HoMe_checkBox58ST = "i:" + Icounter_emkanat + ";s:" + "13" + ":" + "\"بام سبز\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox58ST;
                    Icounter_emkanat++;
                } else {
                    Fine_HoMe_checkBox58ST = "i:" + Icounter_emkanat + ";s:" + "13" + ":" + "\"بام سبز\"" + ";";
                    Vulue11 = Vulue11 + Fine_HoMe_checkBox58ST;
                    Icounter_emkanat++;
                }
            }
            Vulue11 = Vulue11 + "}";
            more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = Vulue11;

        }


// -emkanat
// sport

        if (

                Fine_HoMe_checkBox59ST == "NotNULL" ||
                        Fine_HoMe_checkBox60ST == "NotNULL" ||
                        Fine_HoMe_checkBox61ST == "NotNULL" ||
                        Fine_HoMe_checkBox62ST == "NotNULL" ||
                        Fine_HoMe_checkBox63ST == "NotNULL" ||
                        Fine_HoMe_checkBox64ST == "NotNULL" ||
                        Fine_HoMe_checkBox65ST == "NotNULL" ||
                        Fine_HoMe_checkBox66ST == "NotNULL" ||
                        Fine_HoMe_checkBox67ST == "NotNULL" ||
                        Fine_HoMe_checkBox68ST == "NotNULL" ||
                        Fine_HoMe_checkBox69ST == "NotNULL" ||
                        Fine_HoMe_checkBox70ST == "NotNULL"
                ) {

            Vulue12 = "a:" + counter_sport + ":{";
            Icounter_sport = 0;

            if (Fine_HoMe_checkBox59ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox59ST = "i:" + Icounter_sport + ";s:" + "10" + ":" + "\"استخر\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox59ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox59ST = "i:" + Icounter_sport + ";s:" + "10" + ":" + "\"استخر\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox59ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox60ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox60ST = "i:" + Icounter_sport + ";s:" + "8" + ":" + "\"سونا\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox60ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox60ST = "i:" + Icounter_sport + ";s:" + "8" + ":" + "\"سونا\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox60ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox61ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox61ST = "i:" + Icounter_sport + ";s:" + "10" + ":" + "\"جکوزی\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox61ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox61ST = "i:" + Icounter_sport + ";s:" + "10" + ":" + "\"جکوزی\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox61ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox62ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox62ST = "i:" + Icounter_sport + ";s:" + "14" + ":" + "\"بیلیارد\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox62ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox62ST = "i:" + Icounter_sport + ";s:" + "14" + ":" + "\"بیلیارد\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox62ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox63ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox63ST = "i:" + Icounter_sport + ";s:" + "12" + ":" + "\"فوتبال\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox63ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox63ST = "i:" + Icounter_sport + ";s:" + "12" + ":" + "\"فوتبال\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox63ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox64ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox64ST = "i:" + Icounter_sport + ";s:" + "14" + ":" + "\"بسکتبال\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox64ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox64ST = "i:" + Icounter_sport + ";s:" + "14" + ":" + "\"بسکتبال\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox64ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox65ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox65ST = "i:" + Icounter_sport + ";s:" + "14" + ":" + "\"والیبال\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox65ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox65ST = "i:" + Icounter_sport + ";s:" + "14" + ":" + "\"والیبال\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox65ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox66ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox66ST = "i:" + Icounter_sport + ";s:" + "8" + ":" + "\"تنیس\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox66ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox66ST = "i:" + Icounter_sport + ";s:" + "8" + ":" + "\"تنیس\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox66ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox67ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox67ST = "i:" + Icounter_sport + ";s:" + "15" + ":" + "\"پینگ پنگ\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox67ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox67ST = "i:" + Icounter_sport + ";s:" + "15" + ":" + "\"پینگ پنگ\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox67ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox68ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox68ST = "i:" + Icounter_sport + ";s:" + "24" + ":" + "\"سالن بدن سازی\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox68ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox68ST = "i:" + Icounter_sport + ";s:" + "24" + ":" + "\"سالن بدن سازی\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox68ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox69ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox69ST = "i:" + Icounter_sport + ";s:" + "30" + ":" + "\"زمین بازی کودکان\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox69ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox69ST = "i:" + Icounter_sport + ";s:" + "30" + ":" + "\"زمین بازی کودکان\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox69ST;
                    Icounter_sport++;
                }
            }

            if (Fine_HoMe_checkBox70ST == "NotNULL") {
                if (Icounter_sport == 0) {
                    Fine_HoMe_checkBox70ST = "i:" + Icounter_sport + ";s:" + "12" + ":" + "\"اسکواش\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox70ST;
                    Icounter_sport++;
                } else {
                    Fine_HoMe_checkBox70ST = "i:" + Icounter_sport + ";s:" + "12" + ":" + "\"اسکواش\"" + ";";
                    Vulue12 = Vulue12 + Fine_HoMe_checkBox70ST;
                    Icounter_sport++;
                }
            }
            Vulue12 = Vulue12 + "}";
            more_joziat_melk_edari_tejari_sport_sport_check = Vulue12;
        }


// -sport
        // view

        if (

                Fine_HoMe_checkBox71ST == "NotNULL" ||
                        Fine_HoMe_checkBox72ST == "NotNULL" ||
                        Fine_HoMe_checkBox73ST == "NotNULL" ||
                        Fine_HoMe_checkBox74ST == "NotNULL" ||
                        Fine_HoMe_checkBox75ST == "NotNULL" ||
                        Fine_HoMe_checkBox76ST == "NotNULL" ||
                        Fine_HoMe_checkBox77ST == "NotNULL" ||
                        Fine_HoMe_checkBox78ST == "NotNULL"
                ) {

            Vulue13 = "a:" + counter_view + ":{";
            Icounter_view = 0;

            if (Fine_HoMe_checkBox71ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox71ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"شهر\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox71ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox71ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"شهر\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox71ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox72ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox72ST = "i:" + Icounter_view + ";s:" + "12" + ":" + "\"اتوبان\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox72ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox72ST = "i:" + Icounter_view + ";s:" + "12" + ":" + "\"اتوبان\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox72ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox73ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox73ST = "i:" + Icounter_view + ";s:" + "12" + ":" + "\"خیابان\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox73ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox73ST = "i:" + Icounter_view + ";s:" + "12" + ":" + "\"خیابان\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox73ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox74ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox74ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"کوچه\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox74ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox74ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"کوچه\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox74ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox75ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox75ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"دریا\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox75ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox75ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"دریا\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox75ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox76ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox76ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"جنگل\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox76ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox76ST = "i:" + Icounter_view + ";s:" + "8" + ":" + "\"جنگل\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox76ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox77ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox77ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"کوه\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox77ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox77ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"کوه\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox77ST;
                    Icounter_view++;
                }
            }
            if (Fine_HoMe_checkBox78ST == "NotNULL") {
                if (Icounter_view == 0) {
                    Fine_HoMe_checkBox78ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"باغ\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox78ST;
                    Icounter_view++;
                } else {
                    Fine_HoMe_checkBox78ST = "i:" + Icounter_view + ";s:" + "6" + ":" + "\"باغ\"" + ";";
                    Vulue13 = Vulue13 + Fine_HoMe_checkBox78ST;
                    Icounter_view++;
                }
            }
            Vulue13 = Vulue13 + "}";
            more_joziat_melk_edari_tejari_view_view_check = Vulue13;
        }


// -view

        // tasisat


        if (

                Fine_HoMe_checkBox83ST == "NotNULL" ||
                        Fine_HoMe_checkBox84ST == "NotNULL" ||
                        Fine_HoMe_checkBox85ST == "NotNULL" ||
                        Fine_HoMe_checkBox86ST == "NotNULL"
                ) {

            Vulue15 = "a:" + counter_tasisat + ":{";
            Icounter_tasisat = 0;

            if (Fine_HoMe_checkBox83ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox83ST = "i:" + Icounter_tasisat + ";s:" + "13" + ":" + "\"آب شهری\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox83ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox83ST = "i:" + Icounter_tasisat + ";s:" + "13" + ":" + "\"آب شهری\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox83ST;
                    Icounter_tasisat++;
                }
            }

            if (Fine_HoMe_checkBox84ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox84ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox84ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox84ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox84ST;
                    Icounter_tasisat++;
                }
            }

            if (Fine_HoMe_checkBox85ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox85ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"گاز\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox85ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox85ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"گاز\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox85ST;
                    Icounter_tasisat++;
                }
            }

            if (Fine_HoMe_checkBox86ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox86ST = "i:" + Icounter_tasisat + ";s:" + "21" + ":" + "\"ژنراتور برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox86ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox86ST = "i:" + Icounter_tasisat + ";s:" + "21" + ":" + "\"ژنراتور برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox86ST;
                    Icounter_tasisat++;
                }
            }

            if (checkBox10ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    checkBox10ST = "i:" + Icounter_tasisat + ";s:" + "21" + ":" + "\"منابع تغذیه برق\"" + ";";
                    Vulue15 = Vulue15 + checkBox10ST;
                    Icounter_tasisat++;
                } else {
                    checkBox10ST = "i:" + Icounter_tasisat + ";s:" + "21" + ":" + "\"منابع تغذیه برق\"" + ";";
                    Vulue15 = Vulue15 + checkBox10ST;
                    Icounter_tasisat++;
                }
            }


            Vulue15 = Vulue15 + "}";
            more_joziat_melk_edari_tejari_tasisat_tasisat_check = Vulue15;
        }


// -tasisat
        moshakhasat_asli_melk_noe_bana_mostagh = moshakhasat_asli_melk_noe_bana;
// field_5a9072eb2df3d
        moshakhasat_asli_melk_mosahat_kol_banai_build = Find_HoMe_editText_masahat_made.getText().toString();
// field_5a9073862df3e
        moshakhasat_asli_melk_masahat_zamin = Find_HoMe_editText_masahat_ground.getText().toString();
// field_5a90678dd68d5
        moshakhasat_asli_melk_number_bar = moshakhasat_asli_melk_number_room;
// field_5a906e5b15559
        moshakhasat_asli_melk_sale_build = Find_HoMe_editText_year_made.getText().toString();
// field_5a9067f5d68d8
        more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;
// field_5a92e486f50ae
        more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit = editText14.getText().toString();
// field_5a92e5cdf50af
        more_joziat_melk_edari_tejari_nama_nama_check = more_joziat_melk_edari_tejari_nama_nama_check;
// field_5a9193a0c6335
        more_joziat_melk_edari_tejari_nama_nama_edit = Find_HoMe_editText11.getText().toString();
// field_5a9193e4c6336
        more_joziat_melk_edari_tejari_eskelet_eskelet_check = more_joziat_melk_edari_tejari_eskelet_eskelet_check;
// field_5a919761be9be
        more_joziat_melk_edari_tejari_eskelet_eskelet_edit = Find_HoMe_editText12.getText().toString();
// field_5a919761be9bf
        more_joziat_melk_edari_tejari_divar_divar_check = more_joziat_melk_edari_tejari_divar_divar_check;
// field_5a9199ef39a1f
        more_joziat_melk_edari_tejari_divar_divar_edit = Find_HoMe_editText14.getText().toString();
// field_5a9199ef39a20
        more_joziat_melk_edari_tejari_coldhot_coldhot_check = more_joziat_melk_edari_tejari_coldhot_coldhot_check;
// field_5a919a803066c
        more_joziat_melk_edari_tejari_coldhot_coldhot_edit = Find_HoMe_editText151.getText().toString();
// field_5a919a803066d
        more_joziat_melk_edari_tejari_refahi_refahi_check_mosta = more_joziat_melk_edari_tejari_refahi_refahi_check;
// field_5a92e7d261b5c
        more_joziat_melk_edari_tejari_refahi_refahi_edit = Find_HoMe_editText15.getText().toString();
// field_5a919bc32e871
        more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta = more_joziat_melk_edari_tejari_safe_safe_check;
// field_5a92d6911ad6d
        more_joziat_melk_edari_tejari_safe_safe_edit = Find_HoMe_editText16.getText().toString();
// field_5a91a3e6fb835
        more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta = more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta;
// field_5a92ea1f61b6a
        more_joziat_melk_edari_tejari_dastresi_dastres_edit = Find_HoMe_editText17.getText().toString();
// field_5a92dbc8201f8
        more_joziat_melk_edari_tejari_ghozar_asli = editText13.getText().toString();
// field_5a92dcda201fe
        more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta = more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;
// field_5a91a4b71b42b
        more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit = Find_HoMe_editText17.getText().toString();
// field_5a91a4b81b42c
        more_joziat_melk_edari_tejari_sport_sport_check = more_joziat_melk_edari_tejari_sport_sport_check;
// field_5a91a53c1b42e
        more_joziat_melk_edari_tejari_sport_sport_edit = Find_HoMe_editText18.getText().toString();
// field_5a91a53d1b42f
        more_joziat_melk_edari_tejari_view_view_check = more_joziat_melk_edari_tejari_view_view_check;
// field_5a91a5cd934cd
        more_joziat_melk_edari_tejari_view_view_edit = Find_HoMe_editText19.getText().toString();
// field_5a91a5cd934ce
        more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta = more_joziat_melk_edari_tejari_tasisat_tasisat_check;
// field_5a92ea5861b6c
        more_joziat_melk_edari_tejari_tasisat_tasisat_edit = more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
// field_5a91a6af934d5
        more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
// field_5a91a80fdeca3
        more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
// field_5a91a897deca4
        more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;
// field_5a91a963deca5


        editText.setText(


                " \n noe_melk_moamele  = " + noe_melk_moamele +
//// field_5a8fdad301cc8
                        " \n noe_melk  = " + noe_melk +
//// field_5a8fdb67dcf20
                        " \n moshakhasat_asli_melk_noe_bana_mostagh  = " + moshakhasat_asli_melk_noe_bana_mostagh +
//// field_5a9072eb2df3d
                        " \n moshakhasat_asli_melk_mosahat_kol_banai_build  = " + moshakhasat_asli_melk_mosahat_kol_banai_build +
//// field_5a9073862df3e
                        " \n moshakhasat_asli_melk_masahat_zamin  = " + moshakhasat_asli_melk_masahat_zamin +
//// field_5a90678dd68d5
                        " \n moshakhasat_asli_melk_number_bar  = " + moshakhasat_asli_melk_number_bar +
//// field_5a906e5b15559
                        " \n moshakhasat_asli_melk_sale_build  = " + moshakhasat_asli_melk_sale_build +
//// field_5a9067f5d68d8
                        " \n more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check  = " + more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check +
//// field_5a92e486f50ae
                        " \n more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit  = " + more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit +
//// field_5a92e5cdf50af
                        " \n more_joziat_melk_edari_tejari_nama_nama_check  = " + more_joziat_melk_edari_tejari_nama_nama_check +
//// field_5a9193a0c6335
                        " \n more_joziat_melk_edari_tejari_nama_nama_edit  = " + more_joziat_melk_edari_tejari_nama_nama_edit +
//// field_5a9193e4c6336
                        " \n more_joziat_melk_edari_tejari_eskelet_eskelet_check  = " + more_joziat_melk_edari_tejari_eskelet_eskelet_check +
//// field_5a919761be9be
                        " \n more_joziat_melk_edari_tejari_eskelet_eskelet_edit  = " + more_joziat_melk_edari_tejari_eskelet_eskelet_edit +
//// field_5a919761be9bf
                        " \n more_joziat_melk_edari_tejari_divar_divar_check  = " + more_joziat_melk_edari_tejari_divar_divar_check +
//// field_5a9199ef39a1f
                        " \n more_joziat_melk_edari_tejari_divar_divar_edit  = " + more_joziat_melk_edari_tejari_divar_divar_edit +
//// field_5a9199ef39a20
                        " \n more_joziat_melk_edari_tejari_coldhot_coldhot_check  = " + more_joziat_melk_edari_tejari_coldhot_coldhot_check +
//// field_5a919a803066c
                        " \n more_joziat_melk_edari_tejari_coldhot_coldhot_edit  = " + more_joziat_melk_edari_tejari_coldhot_coldhot_edit +
//// field_5a919a803066d
                        " \n more_joziat_melk_edari_tejari_refahi_refahi_check_mosta  = " + more_joziat_melk_edari_tejari_refahi_refahi_check_mosta +
//// field_5a92e7d261b5c
                        " \n more_joziat_melk_edari_tejari_refahi_refahi_edit  = " + more_joziat_melk_edari_tejari_refahi_refahi_edit +
//// field_5a919bc32e871
                        " \n more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta  = " + more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta +
//// field_5a92d6911ad6d
                        " \n more_joziat_melk_edari_tejari_safe_safe_edit  = " + more_joziat_melk_edari_tejari_safe_safe_edit +
//// field_5a91a3e6fb835
                        " \n more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta  = " + more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta +
//// field_5a92ea1f61b6a
                        " \n more_joziat_melk_edari_tejari_dastresi_dastres_edit  = " + more_joziat_melk_edari_tejari_dastresi_dastres_edit +
//// field_5a92dbc8201f8
                        " \n more_joziat_melk_edari_tejari_ghozar_asli  = " + more_joziat_melk_edari_tejari_ghozar_asli +
//// field_5a92dcda201fe
                        " \n more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta  = " + more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta +
//// field_5a91a4b71b42b
                        " \n more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit  = " + more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit +
//// field_5a91a4b81b42c
                        " \n more_joziat_melk_edari_tejari_sport_sport_check  = " + more_joziat_melk_edari_tejari_sport_sport_check +
//// field_5a91a53c1b42e
                        " \n more_joziat_melk_edari_tejari_sport_sport_edit  = " + more_joziat_melk_edari_tejari_sport_sport_edit +
//// field_5a91a53d1b42f
                        " \n more_joziat_melk_edari_tejari_view_view_check  = " + more_joziat_melk_edari_tejari_view_view_check +
//// field_5a91a5cd934cd
                        " \n more_joziat_melk_edari_tejari_view_view_edit  = " + more_joziat_melk_edari_tejari_view_view_edit +
//// field_5a91a5cd934ce
                        " \n more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta  = " + more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta +
//// field_5a92ea5861b6c
                        " \n more_joziat_melk_edari_tejari_tasisat_tasisat_edit  = " + more_joziat_melk_edari_tejari_tasisat_tasisat_edit +
//// field_5a91a6af934d5
                        " \n more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat  = " + more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat +
//// field_5a91a80fdeca3
                        " \n more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat  = " + more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat +
//// field_5a91a897deca4
                        " \n more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam  = " + more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam
//// field_5a91a963deca5


        );


    }

    public void swichSendZamin() {

// VaziteZamin
        if (

                checkBox17ST == "NotNULL" ||
                        checkBox18ST == "NotNULL" ||
                        checkBox19ST == "NotNULL"
                ) {

            Vulue19 = "a:" + counter_NoeVaghzari + ":{";
            Icounter_NoeVaghzari = 0;

            if (checkBox17ST == "NotNULL") {
                if (Icounter_NoeVaghzari == 0) {
                    checkBox17ST = "i:" + Icounter_NoeVaghzari + ";s:" + "28" + ":" + "\"دارای جواز ساخت\"" + ";";
                    Vulue19 = Vulue19 + checkBox17ST;
                    Icounter_NoeVaghzari++;
                } else {
                    checkBox17ST = "i:" + Icounter_NoeVaghzari + ";s:" + "28" + ":" + "\"دارای جواز ساخت\"" + ";";
                    Vulue19 = Vulue19 + checkBox17ST;
                    Icounter_NoeVaghzari++;
                }
            }
            if (checkBox18ST == "NotNULL") {
                if (Icounter_NoeVaghzari == 0) {
                    checkBox18ST = "i:" + Icounter_NoeVaghzari + ";s:" + "19" + ":" + "\"قابل تجمیع\"" + ";";
                    Vulue19 = Vulue19 + checkBox18ST;
                    Icounter_NoeVaghzari++;
                } else {
                    checkBox18ST = "i:" + Icounter_NoeVaghzari + ";s:" + "19" + ":" + "\"قابل تجمیع\"" + ";";
                    Vulue19 = Vulue19 + checkBox18ST;
                    Icounter_NoeVaghzari++;
                }
            }

            if (checkBox19ST == "NotNULL") {
                if (Icounter_NoeVaghzari == 0) {
                    checkBox19ST = "i:" + Icounter_NoeVaghzari + ";s:" + "19" + ":" + "\"\"قابل تفکیک\"" + ";";
                    Vulue19 = Vulue19 + checkBox19ST;
                    Icounter_NoeVaghzari++;
                } else {
                    checkBox19ST = "i:" + Icounter_NoeVaghzari + ";s:" + "19" + ":" + "\"\"قابل تفکیک\"" + ";";
                    Vulue19 = Vulue19 + checkBox19ST;
                    Icounter_NoeVaghzari++;
                }
            }


            Vulue19 = Vulue19 + "}";
            moshakhasat_asli_melk_vaziita_build_vazita_zamin = Vulue19;
        }

// -VaziteZamin

// karbariePishnahadi
        Vulue17 = "a:" + counter_KarbariPishnahadi + ":{";
        Icounter_refahi = 0;
        if (


                checkBox26ST == "NotNULL" ||
                        checkBox27ST == "NotNULL" ||
                        checkBox28ST == "NotNULL" ||
                        checkBox29ST == "NotNULL" ||
                        checkBox30ST == "NotNULL" ||
                        checkBox31ST == "NotNULL" ||
                        checkBox32ST == "NotNULL" ||
                        checkBox39ST == "NotNULL" ||
                        checkBox40ST == "NotNULL" ||
                        checkBox88ST == "NotNULL" ||
                        checkBox89ST == "NotNULL" ||
                        checkBox90ST == "NotNULL" ||
                        checkBox91ST == "NotNULL"
                ) {

            if (checkBox26ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox26ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "12" + ":" + "\"مسکونی\"" + ";";
                    Vulue17 = Vulue17 + checkBox26ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox26ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "12" + ":" + "\"مسکونی\"" + ";";
                    Vulue17 = Vulue17 + checkBox26ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox27ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox27ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"اداری\"" + ";";
                    Vulue17 = Vulue17 + checkBox27ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox27ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"اداری\"" + ";";
                    Vulue17 = Vulue17 + checkBox27ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox28ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox28ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"تجاری\"" + ";";
                    Vulue17 = Vulue17 + checkBox28ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox28ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"تجاری\"" + ";";
                    Vulue17 = Vulue17 + checkBox28ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox29ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox29ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"صعنتی\"" + ";";
                    Vulue17 = Vulue17 + checkBox29ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox29ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"صعنتی\"" + ";";
                    Vulue17 = Vulue17 + checkBox29ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox30ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox30ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "25" + ":" + "\"تفریحی - ورزشی\"" + ";";
                    Vulue17 = Vulue17 + checkBox30ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox30ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "25" + ":" + "\"تفریحی - ورزشی\"" + ";";
                    Vulue17 = Vulue17 + checkBox30ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox31ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox31ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "12" + ":" + "\"آموزشی\"" + ";";
                    Vulue17 = Vulue17 + checkBox31ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox31ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "12" + ":" + "\"آموزشی\"" + ";";
                    Vulue17 = Vulue17 + checkBox31ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox32ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox32ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "14" + ":" + "\"توریستی\"" + ";";
                    Vulue17 = Vulue17 + checkBox32ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox32ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "14" + ":" + "\"توریستی\"" + ";";
                    Vulue17 = Vulue17 + checkBox32ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox39ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox39ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "16" + ":" + "\"دامپروری\"" + ";";
                    Vulue17 = Vulue17 + checkBox39ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox39ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "16" + ":" + "\"دامپروری\"" + ";";
                    Vulue17 = Vulue17 + checkBox39ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox40ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox40ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "14" + ":" + "\"کشاورزی\"" + ";";
                    Vulue17 = Vulue17 + checkBox40ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox40ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "14" + ":" + "\"کشاورزی\"" + ";";
                    Vulue17 = Vulue17 + checkBox40ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox88ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox88ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "32" + ":" + "\"باغشهر - شهرک سازی\"" + ";";
                    Vulue17 = Vulue17 + checkBox88ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox88ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "32" + ":" + "\"باغشهر - شهرک سازی\"" + ";";
                    Vulue17 = Vulue17 + checkBox88ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox89ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox89ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "23" + ":" + "\"خدماتی رفاهی\"" + ";";
                    Vulue17 = Vulue17 + checkBox89ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox89ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "23" + ":" + "\"خدماتی رفاهی\"" + ";";
                    Vulue17 = Vulue17 + checkBox89ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox90ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox90ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"انبار\"" + ";";
                    Vulue17 = Vulue17 + checkBox90ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox90ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "10" + ":" + "\"انبار\"" + ";";
                    Vulue17 = Vulue17 + checkBox90ST;
                    Icounter_KarbariPishnahadi++;
                }
            }

            if (checkBox91ST == "NotNULL") {
                if (Icounter_KarbariPishnahadi == 0) {
                    checkBox91ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "14" + ":" + "\"پارکینگ\"" + ";";
                    Vulue17 = Vulue17 + checkBox91ST;
                    Icounter_KarbariPishnahadi++;
                } else {
                    checkBox91ST = "i:" + Icounter_KarbariPishnahadi + ";s:" + "14" + ":" + "\"پارکینگ\"" + ";";
                    Vulue17 = Vulue17 + checkBox91ST;
                    Icounter_KarbariPishnahadi++;
                }
            }


            Vulue17 = Vulue17 + "}";
            more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check = Vulue17;
        }
// -karbariPishnahadi
// dastresi mosta

        if (


                checkBox21ST == "NotNULL" ||
                        checkBox23ST == "NotNULL" ||
                        checkBox24ST == "NotNULL" ||
                        checkBox25ST == "NotNULL" ||
                        checkBox93ST == "NotNULL" ||
                        checkBox22ST == "NotNULL" ||
                        checkBox94ST == "NotNULL"
                ) {


            Vulue18 = "a:" + counter_dastresi + ":{";
            Icounter_dastresi = 0;

            if (checkBox22ST == "NotNULL") {
                if (Icounter_dastresi == 0) {
                    checkBox22ST = "i:" + Icounter_dastresi + ";s:" + "14" + ":" + "\"بزرگراه\"" + ";";
                    Vulue18 = Vulue18 + checkBox22ST;
                    Icounter_dastresi++;
                } else {
                    checkBox22ST = "i:" + Icounter_dastresi + ";s:" + "14" + ":" + "\"بزرگراه\"" + ";";
                    Vulue18 = Vulue18 + checkBox22ST;
                    Icounter_dastresi++;
                }
            }

            if (checkBox21ST == "NotNULL") {
                if (Icounter_dastresi == 0) {
                    checkBox21ST = "i:" + Icounter_dastresi + ";s:" + "19" + ":" + "\"داخل بازار\"" + ";";
                    Vulue18 = Vulue18 + checkBox21ST;
                    Icounter_dastresi++;
                } else {
                    checkBox21ST = "i:" + Icounter_dastresi + ";s:" + "19" + ":" + "\"داخل بازار\"" + ";";
                    Vulue18 = Vulue18 + checkBox21ST;
                    Icounter_dastresi++;
                }
            }

            if (checkBox23ST == "NotNULL") {
                if (Icounter_dastresi == 0) {
                    checkBox23ST = "i:" + Icounter_dastresi + ";s:" + "21" + ":" + "\"خیابان اصلی\"" + ";";
                    Vulue18 = Vulue18 + checkBox23ST;
                    Icounter_dastresi++;
                } else {
                    checkBox23ST = "i:" + Icounter_dastresi + ";s:" + "21" + ":" + "\"خیابان اصلی\"" + ";";
                    Vulue18 = Vulue18 + checkBox23ST;
                    Icounter_dastresi++;
                }
            }

            if (checkBox24ST == "NotNULL") {
                if (Icounter_dastresi == 0) {
                    checkBox24ST = "i:" + Icounter_dastresi + ";s:" + "21" + ":" + "\"خیابان فرعی\"" + ";";
                    Vulue18 = Vulue18 + checkBox24ST;
                    Icounter_dastresi++;
                } else {
                    checkBox24ST = "i:" + Icounter_dastresi + ";s:" + "21" + ":" + "\"خیابان فرعی\"" + ";";
                    Vulue18 = Vulue18 + checkBox24ST;
                    Icounter_dastresi++;
                }
            }

            if (checkBox25ST == "NotNULL") {
                if (Icounter_dastresi == 0) {
                    checkBox25ST = "i:" + Icounter_dastresi + ";s:" + "10" + ":" + "\"میدان\"" + ";";
                    Vulue18 = Vulue18 + checkBox25ST;
                    Icounter_dastresi++;
                } else {
                    checkBox25ST = "i:" + Icounter_dastresi + ";s:" + "10" + ":" + "\"میدان\"" + ";";
                    Vulue18 = Vulue18 + checkBox25ST;
                    Icounter_dastresi++;
                }
            }

            if (checkBox93ST == "NotNULL") {
                if (Icounter_dastresi == 0) {
                    checkBox93ST = "i:" + Icounter_dastresi + ";s:" + "8" + ":" + "\"کوچه\"" + ";";
                    Vulue18 = Vulue18 + checkBox93ST;
                    Icounter_dastresi++;
                } else {
                    checkBox93ST = "i:" + Icounter_dastresi + ";s:" + "8" + ":" + "\"کوچه\"" + ";";
                    Vulue18 = Vulue18 + checkBox93ST;
                    Icounter_dastresi++;
                }
            }

            if (checkBox94ST == "NotNULL") {
                if (Icounter_dastresi == 0) {
                    checkBox94ST = "i:" + Icounter_dastresi + ";s:" + "11" + ":" + "\"بن بست\"" + ";";
                    Vulue18 = Vulue18 + checkBox94ST;
                    Icounter_dastresi++;
                } else {
                    checkBox94ST = "i:" + Icounter_dastresi + ";s:" + "11" + ":" + "\"بن بست\"" + ";";
                    Vulue18 = Vulue18 + checkBox94ST;
                    Icounter_dastresi++;
                }
            }

            Vulue18 = Vulue18 + "}";
            more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta = Vulue18;

        }
// -dastresi mista
        // tasisat


        if (

                Fine_HoMe_checkBox83ST == "NotNULL" ||
                        Fine_HoMe_checkBox84ST == "NotNULL" ||
                        Fine_HoMe_checkBox85ST == "NotNULL" ||
                        checkBox95ST == "NotNULL"
                ) {

            Vulue15 = "a:" + counter_tasisat + ":{";
            Icounter_tasisat = 0;

            if (Fine_HoMe_checkBox83ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox83ST = "i:" + Icounter_tasisat + ";s:" + "13" + ":" + "\"آب شهری\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox83ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox83ST = "i:" + Icounter_tasisat + ";s:" + "13" + ":" + "\"آب شهری\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox83ST;
                    Icounter_tasisat++;
                }
            }

            if (Fine_HoMe_checkBox84ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox84ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox84ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox84ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"برق\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox84ST;
                    Icounter_tasisat++;
                }
            }

            if (Fine_HoMe_checkBox85ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    Fine_HoMe_checkBox85ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"گاز\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox85ST;
                    Icounter_tasisat++;
                } else {
                    Fine_HoMe_checkBox85ST = "i:" + Icounter_tasisat + ";s:" + "6" + ":" + "\"گاز\"" + ";";
                    Vulue15 = Vulue15 + Fine_HoMe_checkBox85ST;
                    Icounter_tasisat++;
                }
            }

            if (checkBox95ST == "NotNULL") {
                if (Icounter_tasisat == 0) {
                    checkBox95ST = "i:" + Icounter_tasisat + ";s:" + "11" + ":" + "\"آب چاه\"" + ";";
                    Vulue15 = Vulue15 + checkBox95ST;
                    Icounter_tasisat++;
                } else {
                    checkBox95ST = "i:" + Icounter_tasisat + ";s:" + "11" + ":" + "\"آب چاه\"" + ";";
                    Vulue15 = Vulue15 + checkBox95ST;
                    Icounter_tasisat++;
                }
            }
            Vulue15 = Vulue15 + "}";
            more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin = Vulue15;
        }


// -tasisat
        moshakhasat_asli_melk_karbari_now = moshakhasat_asli_melk_noe_bana;
//// field_5a907006c302c
        moshakhasat_asli_melk_masahat_zamin_after_eslahie = Find_HoMe_editText_masahat_made.getText().toString();
//// field_5a907087c302d
        moshakhasat_asli_melk_tol_bar_asli = Find_HoMe_editText_year_made.getText().toString();
//// field_5a906ebb1555a
        moshakhasat_asli_melk_number_bar = moshakhasat_asli_melk_number_room;
//// field_5a906e5b15559
        moshakhasat_asli_melk_vaziita_build_vazita_zamin = moshakhasat_asli_melk_vaziita_build_vazita_zamin;
//// field_5a9072a3b1c10
        more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check = more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;
//// field_5a92e486f50ae
        more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit = editText14.getText().toString();
//// field_5a92e5cdf50af
        more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin = more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta;
//// field_5a92e661f50b5
        more_joziat_melk_edari_tejari_dastresi_dastres_edit = Find_HoMe_editText17.getText().toString();
//// field_5a92dbc8201f8
        more_joziat_melk_edari_tejari_ghozar_asli = editText13.getText().toString();
//// field_5a92dcda201fe
        more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin = more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin;
//// field_5a92e628f50b3
        more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat = more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
//// field_5a91a80fdeca3
        more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat = more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
//// field_5a91a897deca4
        more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam = more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;
////        field_5a91a963deca5


    }
/*
    // send new post
    public void SendNewPostConnectMaskoni() {


        new Connect(
                "http://padintarh.ir/Android/insertMASKO.php"
                , editText_onvan.getText().toString()  //matn
                , editTex_matn.getText().toString()
                , editTex_matn.getText().toString()
                , "barchasb_zamine", ID_send
                , noe_melk_moamele // noe_melk_moamele;
                , noe_melk // noe_melk;
                , moshakhasat_asli_melk_noe_bana // moshakhasat_asli_melk_noe_bana;
                , moshakhasat_asli_melk_masahat_build // moshakhasat_asli_melk_masahat_build;
                , moshakhasat_asli_melk_masahat_zamin // moshakhasat_asli_melk_masahat_zamin;
                , moshakhasat_asli_melk_number_room // moshakhasat_asli_melk_number_room;
                , moshakhasat_asli_melk_number_parking // moshakhasat_asli_melk_number_parking;
                , moshakhasat_asli_melk_sale_build // moshakhasat_asli_melk_sale_build;
                , moshakhasat_asli_melk_vaziita_build_vaziita_build_radio // moshakhasat_asli_melk_vaziita_build_vaziita_build_radio;
                , moshakhasat_asli_melk_vaziita_build_ghabel_sokonat // moshakhasat_asli_melk_vaziita_build_ghabel_sokonat;
                , price_shrayet_sell_cheng_price_all_sell_cheng // price_shrayet_sell_cheng_price_all_sell_cheng;
                , price_shrayet_sell_cheng_check_seel_cheng // price_shrayet_sell_cheng_check_seel_cheng;
                , price_shrayet_sell_cheng_max_money // price_shrayet_sell_cheng_max_money;
                , price_shrayet_sell_cheng_money_pish_pay // price_shrayet_sell_cheng_money_pish_pay;
                , price_shrayet_sell_cheng_time_tahvil // price_shrayet_sell_cheng_time_tahvil;
                , price_shrayet_sell_cheng_mizan_anjam_shode // price_shrayet_sell_cheng_mizan_anjam_shode;
                , price_shrayet_sell_cheng_mizan_vam // price_shrayet_sell_cheng_mizan_vam;
                , price_shrayet_sell_cheng_sod_vam // price_shrayet_sell_cheng_sod_vam;
                , price_shrayet_sell_cheng_number_ghest // price_shrayet_sell_cheng_number_ghest;
                , price_shrayet_sell_cheng_price_har_ghest // price_shrayet_sell_cheng_price_har_ghest;
                , price_shrayet_sell_cheng_price_rahn // price_shrayet_sell_cheng_price_rahn;
                , more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe // more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe;
                , more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe // more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe;
                , more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe // more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe;
                , more_joziat_melk_edari_tejari_moghit_build_number_all_vahed // more_joziat_melk_edari_tejari_moghit_build_number_all_vahed;
                , more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build // more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build;
                , more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari // more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari;
                , more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari // more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari;
                , more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon // more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon;
                , more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon // more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon;
                , more_joziat_melk_edari_tejari_wc_wc_irani // more_joziat_melk_edari_tejari_wc_wc_irani;
                , more_joziat_melk_edari_tejari_wc_wc_us // more_joziat_melk_edari_tejari_wc_wc_us;
                , more_joziat_melk_edari_tejari_wc_bath // more_joziat_melk_edari_tejari_wc_bath;
                , more_joziat_melk_edari_tejari_kitchen_kitchen_check // more_joziat_melk_edari_tejari_kitchen_kitchen_check;
                , more_joziat_melk_edari_tejari_kitchen_kitchen_radio // more_joziat_melk_edari_tejari_kitchen_kitchen_radio;
                , more_joziat_melk_edari_tejari_kitchen_darai_kabinet // more_joziat_melk_edari_tejari_kitchen_darai_kabinet;
                , more_joziat_melk_edari_tejari_kitchen_badane_kabinet // more_joziat_melk_edari_tejari_kitchen_badane_kabinet;
                , more_joziat_melk_edari_tejari_kitchen_safhe_kabinet // more_joziat_melk_edari_tejari_kitchen_safhe_kabinet;
                , more_joziat_melk_edari_tejari_kitchen_roye_kabinet // more_joziat_melk_edari_tejari_kitchen_roye_kabinet;
                , more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchenST // more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen;
                , more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen // more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen;
                , more_joziat_melk_edari_tejari_neshiman_neshiman_check // more_joziat_melk_edari_tejari_neshiman_neshiman_check;
                , more_joziat_melk_edari_tejari_neshiman_neshiman_edit // more_joziat_melk_edari_tejari_neshiman_neshiman_edit;
                , more_joziat_melk_edari_tejari_shekle_build_radio // more_joziat_melk_edari_tejari_shekle_build_radio;
                , more_joziat_melk_edari_tejari_nama_nama_check // more_joziat_melk_edari_tejari_nama_nama_check;
                , more_joziat_melk_edari_tejari_nama_nama_edit // more_joziat_melk_edari_tejari_nama_nama_edit;
                , more_joziat_melk_edari_tejari_eskelet_eskelet_check // more_joziat_melk_edari_tejari_eskelet_eskelet_check;
                , more_joziat_melk_edari_tejari_eskelet_eskelet_edit // more_joziat_melk_edari_tejari_eskelet_eskelet_edit;
                , more_joziat_melk_edari_tejari_kaf_kaf_check // more_joziat_melk_edari_tejari_kaf_kaf_check;
                , more_joziat_melk_edari_tejari_kaf_kaf_edit // more_joziat_melk_edari_tejari_kaf_kaf_edit;
                , more_joziat_melk_edari_tejari_divar_divar_check // more_joziat_melk_edari_tejari_divar_divar_check;
                , more_joziat_melk_edari_tejari_divar_divar_edit // more_joziat_melk_edari_tejari_divar_divar_edit;
                , more_joziat_melk_edari_tejari_coldhot_coldhot_check // more_joziat_melk_edari_tejari_coldhot_coldhot_check;
                , more_joziat_melk_edari_tejari_coldhot_coldhot_edit // more_joziat_melk_edari_tejari_coldhot_coldhot_edit;
                , more_joziat_melk_edari_tejari_refahi_refahi_check // more_joziat_melk_edari_tejari_refahi_refahi_check;
                , more_joziat_melk_edari_tejari_refahi_refahi_edit // more_joziat_melk_edari_tejari_refahi_refahi_edit;
                , more_joziat_melk_edari_tejari_safe_safe_check // more_joziat_melk_edari_tejari_safe_safe_check;
                , more_joziat_melk_edari_tejari_safe_safe_edit // more_joziat_melk_edari_tejari_safe_safe_edit;
                , more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta // more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;
                , more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit // more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit;
                , more_joziat_melk_edari_tejari_sport_sport_check // more_joziat_melk_edari_tejari_sport_sport_check;
                , more_joziat_melk_edari_tejari_sport_sport_edit // more_joziat_melk_edari_tejari_sport_sport_edit;
                , more_joziat_melk_edari_tejari_view_view_check // more_joziat_melk_edari_tejari_view_view_check;
                , more_joziat_melk_edari_tejari_view_view_edit // more_joziat_melk_edari_tejari_view_view_edit;
                , more_joziat_melk_edari_tejari_nor_nor_check // more_joziat_melk_edari_tejari_nor_nor_check;
                , more_joziat_melk_edari_tejari_tasisat_tasisat_check // more_joziat_melk_edari_tejari_tasisat_tasisat_check;
                , more_joziat_melk_edari_tejari_tasisat_tasisat_edit // more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam // more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;
                , finalstIDimage_1
        ).execute();
        try {
            jsonObject = new JSONObject(dataServer);
        } catch (JSONException e) {
        }

    }

    public void SendNewPostConnectEdari() {

        new Connect6("http://padintarh.ir/Android/insertEDARI.php"
                , editText_onvan.getText().toString()  //matn
                , editTex_matn.getText().toString()
                , editTex_matn.getText().toString()
                , "barchasb_zamine", 0

                , noe_melk_moamele //  "noe_melk_moamele";
                , noe_melk //  "noe_melk";
                , moshakhasat_asli_melk_noe_bana //  "moshakhasat_asli_melk_noe_bana";
                , moshakhasat_asli_melk_masahat_build //  "moshakhasat_asli_melk_masahat_build";
                , moshakhasat_asli_melk_masahat_zamin //  "moshakhasat_asli_melk_masahat_zamin";
                , moshakhasat_asli_melk_number_room //  "moshakhasat_asli_melk_number_room";
                , moshakhasat_asli_melk_number_parking //  "moshakhasat_asli_melk_number_parking";
                , moshakhasat_asli_melk_moghiat_build //  "moshakhasat_asli_melk_moghiat_build";
                , price_shrayet_sell_cheng_price_all_sell_cheng //  "price_shrayet_sell_cheng_price_all_sell_cheng";
                , price_shrayet_sell_cheng_check_seel_cheng //  "price_shrayet_sell_cheng_check_seel_cheng";
                , price_shrayet_sell_cheng_max_money //  "price_shrayet_sell_cheng_max_money";
                , price_shrayet_sell_cheng_money_pish_pay //  "price_shrayet_sell_cheng_money_pish_pay";
                , price_shrayet_sell_cheng_time_tahvil //  "price_shrayet_sell_cheng_time_tahvil";
                , price_shrayet_sell_cheng_mizan_anjam_shode //  "price_shrayet_sell_cheng_mizan_anjam_shode";
                , price_shrayet_sell_cheng_mizan_vam //  "price_shrayet_sell_cheng_mizan_vam";
                , price_shrayet_sell_cheng_sod_vam //  "price_shrayet_sell_cheng_sod_vam";
                , price_shrayet_sell_cheng_number_ghest //  "price_shrayet_sell_cheng_number_ghest";
                , price_shrayet_sell_cheng_price_har_ghest //  "price_shrayet_sell_cheng_price_har_ghest";
                , price_shrayet_sell_cheng_price_rahn //  "price_shrayet_sell_cheng_price_rahn";
                , more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe //  "more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe";
                , more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe //  "more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe";
                , more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe //  "more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe";
                , more_joziat_melk_edari_tejari_moghit_build_number_all_vahed //  "more_joziat_melk_edari_tejari_moghit_build_number_all_vahed";
                , more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build //  "more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build";
                , more_joziat_melk_edari_tejari_wc_wc_irani //  "more_joziat_melk_edari_tejari_wc_wc_irani";
                , more_joziat_melk_edari_tejari_wc_wc_us //  "more_joziat_melk_edari_tejari_wc_wc_us";
                , more_joziat_melk_edari_tejari_kitchen_abdarkhane //  "more_joziat_melk_edari_tejari_kitchen_abdarkhane";
                , more_joziat_melk_edari_tejari_kitchen_ghazakhori //  "more_joziat_melk_edari_tejari_kitchen_ghazakhori";
                , more_joziat_melk_edari_tejari_room_asli_room_asli_edit //  "more_joziat_melk_edari_tejari_room_asli_room_asli_edit";
                , more_joziat_melk_edari_tejari_nama_nama_check //  "more_joziat_melk_edari_tejari_nama_nama_check";
                , more_joziat_melk_edari_tejari_nama_nama_edit //  "more_joziat_melk_edari_tejari_nama_nama_edit";
                , more_joziat_melk_edari_tejari_divar_divar_check //  "more_joziat_melk_edari_tejari_divar_divar_check";
                , more_joziat_melk_edari_tejari_divar_divar_edit //  "more_joziat_melk_edari_tejari_divar_divar_edit";
                , more_joziat_melk_edari_tejari_coldhot_coldhot_check //  "more_joziat_melk_edari_tejari_coldhot_coldhot_check";
                , more_joziat_melk_edari_tejari_coldhot_coldhot_edit //  "more_joziat_melk_edari_tejari_coldhot_coldhot_edit";
                , more_joziat_melk_edari_tejari_refahi_refahi_check //  "more_joziat_melk_edari_tejari_refahi_refahi_check";
                , more_joziat_melk_edari_tejari_refahi_refahi_edit //  "more_joziat_melk_edari_tejari_refahi_refahi_edit";
                , more_joziat_melk_edari_tejari_safe_safe_check //  "more_joziat_melk_edari_tejari_safe_safe_check";
                , more_joziat_melk_edari_tejari_safe_safe_edit //  "more_joziat_melk_edari_tejari_safe_safe_edit";
                , more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta //  "more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta";
                , more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit //  "more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit";
                , more_joziat_melk_edari_tejari_view_view_check //  "more_joziat_melk_edari_tejari_view_view_check";
                , more_joziat_melk_edari_tejari_view_view_edit //  "more_joziat_melk_edari_tejari_view_view_edit";
                , more_joziat_melk_edari_tejari_nor_nor_check //  "more_joziat_melk_edari_tejari_nor_nor_check";
                , more_joziat_melk_edari_tejari_tasisat_tasisat_check //  "more_joziat_melk_edari_tejari_tasisat_tasisat_check";
                , more_joziat_melk_edari_tejari_tasisat_tasisat_edit //  "more_joziat_melk_edari_tejari_tasisat_tasisat_edit";
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat //  "more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat";
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat //  "more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat";
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam //  "more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam";
                , more_joziat_melk_edari_tejari_kitchen_badane_kabinet //  "more_joziat_melk_edari_tejari_kitchen_badane_kabinet";
                , more_joziat_melk_edari_tejari_kitchen_safhe_kabinet//  "more_joziat_melk_edari_tejari_kitchen_safhe_kabinet";
                , more_joziat_melk_edari_tejari_kitchen_roye_kabinet //  "more_joziat_melk_edari_tejari_kitchen_roye_kabinet";
                , more_joziat_melk_edari_tejari_room_asli_room_asli_check //  "more_joziat_melk_edari_tejari_kitchen_roye_kabinet";
                , moshakhasat_asli_melk_vaziita_build_vaziita_build_radio
                , more_joziat_melk_edari_tejari_kitchen_kitchen_radio
                , more_joziat_melk_edari_tejari_shekle_build_radio
        ).execute();

        try {
            jsonObject = new JSONObject(dataServer);
        } catch (JSONException e) {
        }


    }

    public void SendNewPostConnectTejari() {
        new Connect7(
                "http://padintarh.ir/Android/insertTEJARI.php"
                , editText_onvan.getText().toString()  //matn
                , editTex_matn.getText().toString()
                , editTex_matn.getText().toString()
                , "meta_keyAPP"
                , 0
                , noe_melk_moamele  // noe_melk_moamele +
                , noe_melk  // noe_melk +
                , moshakhasat_asli_melk_moghiita_store  // moshakhasat_asli_melk_moghiita_store +
                , moshakhasat_asli_melk_masahat_kaf  // moshakhasat_asli_melk_masahat_kaf +
                , moshakhasat_asli_melk_masahat_balkon  // moshakhasat_asli_melk_masahat_balkon +
                , moshakhasat_asli_melk_nuumber_dahane  // moshakhasat_asli_melk_nuumber_dahane +
                , moshakhasat_asli_melk_tol_bar_asli  // moshakhasat_asli_melk_tol_bar_asli +
                , moshakhasat_asli_melk_number_bar  // moshakhasat_asli_melk_number_bar +
                , moshakhasat_asli_melk_noe_vaghozari  // moshakhasat_asli_melk_noe_vaghozari +
                , more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh  // more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh +
                , more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh  // more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh +
                , more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe  // more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe +
                , more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze  // more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze +
                , more_joziat_melk_edari_tejari_wc_wc_irani  // more_joziat_melk_edari_tejari_wc_wc_irani +
                , more_joziat_melk_edari_tejari_wc_wc_us  // more_joziat_melk_edari_tejari_wc_wc_us +
                , more_joziat_melk_edari_tejari_wc_roshoii  // more_joziat_melk_edari_tejari_wc_roshoii +
                , more_joziat_melk_edari_tejari_abdarhkane_tejari  // more_joziat_melk_edari_tejari_abdarhkane_tejari +
                , more_joziat_melk_edari_tejari_fazai_asli_fazai_asli  // more_joziat_melk_edari_tejari_fazai_asli_fazai_asli +
                , more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari  // more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari +
                , more_joziat_melk_edari_tejari_kaf_kaf_check  // more_joziat_melk_edari_tejari_kaf_kaf_check +
                , more_joziat_melk_edari_tejari_kaf_kaf_edit  // more_joziat_melk_edari_tejari_kaf_kaf_edit +
                , more_joziat_melk_edari_tejari_coldhot_coldhot_check  // more_joziat_melk_edari_tejari_coldhot_coldhot_check +
                , more_joziat_melk_edari_tejari_coldhot_coldhot_edit  // more_joziat_melk_edari_tejari_coldhot_coldhot_edit +
                , more_joziat_melk_edari_tejari_refahi_refahi_check_tejari  // more_joziat_melk_edari_tejari_refahi_refahi_check_tejari +
                , more_joziat_melk_edari_tejari_refahi_refahi_edit  // more_joziat_melk_edari_tejari_refahi_refahi_edit +
                , more_joziat_melk_edari_tejari_safe_safe_check_tejari  // more_joziat_melk_edari_tejari_safe_safe_check_tejari +
                , more_joziat_melk_edari_tejari_safe_safe_edit  // more_joziat_melk_edari_tejari_safe_safe_edit +
                , more_joziat_melk_edari_tejari_dastresi_dastresi_check  // more_joziat_melk_edari_tejari_dastresi_dastresi_check +
                , more_joziat_melk_edari_tejari_dastresi_dastres_edit  // more_joziat_melk_edari_tejari_dastresi_dastres_edit +
                , more_joziat_melk_edari_tejari_ghozar_asli  // more_joziat_melk_edari_tejari_ghozar_asli +
                , more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari  // more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari +
                , more_joziat_melk_edari_tejari_tasisat_tasisat_edit  // more_joziat_melk_edari_tejari_tasisat_tasisat_edit +
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat  // more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat +
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat  // more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat +
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam  // more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam +

        ).execute();
    }

    public void SendNewPostConnectMostaghelat() {
        new Connect8(
                "http://padintarh.ir/Android/insertMOSTA.php"
                , editText_onvan.getText().toString()  //matn
                , editTex_matn.getText().toString()
                , editTex_matn.getText().toString()
                , 0
                , "meta_keyAPP"
                , noe_melk_moamele // noe_melk_moamele";
// field_5a8fdad301cc8
                , noe_melk // noe_melk";
// field_5a8fdb67dcf20
                , moshakhasat_asli_melk_noe_bana_mostagh // moshakhasat_asli_melk_noe_bana_mostagh";
// field_5a9072eb2df3d
                , moshakhasat_asli_melk_mosahat_kol_banai_build // moshakhasat_asli_melk_mosahat_kol_banai_build";
// field_5a9073862df3e
                , moshakhasat_asli_melk_masahat_zamin // moshakhasat_asli_melk_masahat_zamin";
// field_5a90678dd68d5
                , moshakhasat_asli_melk_number_bar // moshakhasat_asli_melk_number_bar";
// field_5a906e5b15559
                , moshakhasat_asli_melk_sale_build // moshakhasat_asli_melk_sale_build";
// field_5a9067f5d68d8
                , more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check // more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check";
// field_5a92e486f50ae
                , more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit // more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit";
// field_5a92e5cdf50af
                , more_joziat_melk_edari_tejari_nama_nama_check // more_joziat_melk_edari_tejari_nama_nama_check";
// field_5a9193a0c6335
                , more_joziat_melk_edari_tejari_nama_nama_edit // more_joziat_melk_edari_tejari_nama_nama_edit";
// field_5a9193e4c6336
                , more_joziat_melk_edari_tejari_eskelet_eskelet_check // more_joziat_melk_edari_tejari_eskelet_eskelet_check";
// field_5a919761be9be
                , more_joziat_melk_edari_tejari_eskelet_eskelet_edit // more_joziat_melk_edari_tejari_eskelet_eskelet_edit";
// field_5a919761be9bf
                , more_joziat_melk_edari_tejari_divar_divar_check // more_joziat_melk_edari_tejari_divar_divar_check";
// field_5a9199ef39a1f
                , more_joziat_melk_edari_tejari_divar_divar_edit // more_joziat_melk_edari_tejari_divar_divar_edit";
// field_5a9199ef39a20
                , more_joziat_melk_edari_tejari_coldhot_coldhot_check // more_joziat_melk_edari_tejari_coldhot_coldhot_check";
// field_5a919a803066c
                , more_joziat_melk_edari_tejari_coldhot_coldhot_edit // more_joziat_melk_edari_tejari_coldhot_coldhot_edit";
// field_5a919a803066d
                , more_joziat_melk_edari_tejari_refahi_refahi_check_mosta // more_joziat_melk_edari_tejari_refahi_refahi_check_mosta";
// field_5a92e7d261b5c
                , more_joziat_melk_edari_tejari_refahi_refahi_edit // more_joziat_melk_edari_tejari_refahi_refahi_edit";
// field_5a919bc32e871
                , more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta // more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta";
// field_5a92d6911ad6d
                , more_joziat_melk_edari_tejari_safe_safe_edit // more_joziat_melk_edari_tejari_safe_safe_edit";
// field_5a91a3e6fb835
                , more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta // more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta";
// field_5a92ea1f61b6a
                , more_joziat_melk_edari_tejari_dastresi_dastres_edit // more_joziat_melk_edari_tejari_dastresi_dastres_edit";
// field_5a92dbc8201f8
                , more_joziat_melk_edari_tejari_ghozar_asli // more_joziat_melk_edari_tejari_ghozar_asli";
// field_5a92dcda201fe
                , more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta // more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta";
// field_5a91a4b71b42b
                , more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit // more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit";
// field_5a91a4b81b42c
                , more_joziat_melk_edari_tejari_sport_sport_check // more_joziat_melk_edari_tejari_sport_sport_check";
// field_5a91a53c1b42e
                , more_joziat_melk_edari_tejari_sport_sport_edit // more_joziat_melk_edari_tejari_sport_sport_edit";
// field_5a91a53d1b42f
                , more_joziat_melk_edari_tejari_view_view_check // more_joziat_melk_edari_tejari_view_view_check";
// field_5a91a5cd934cd
                , more_joziat_melk_edari_tejari_view_view_edit // more_joziat_melk_edari_tejari_view_view_edit";
// field_5a91a5cd934ce
                , more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta // more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta";
// field_5a92ea5861b6c
                , more_joziat_melk_edari_tejari_tasisat_tasisat_edit // more_joziat_melk_edari_tejari_tasisat_tasisat_edit";
// field_5a91a6af934d5
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat";
// field_5a91a80fdeca3
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat";
// field_5a91a897deca4
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam // more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam";
// field_5a91a963deca5
        ).execute();

    }

    public void SendNewPostConnectZamin() {

        new Connect9(
                "http://padintarh.ir/Android/insertZAMIN.php"
                , editText_onvan.getText().toString()  //matn
                , editTex_matn.getText().toString()
                , editTex_matn.getText().toString()
                , "meta_keyAPP"
                , 0
                , noe_melk_moamele // noe_melk_moamele;
                //// field_5a8fdad301cc8
                , noe_melk // noe_melk;
                //// field_5a8fdb67dcf20
                , moshakhasat_asli_melk_karbari_now // moshakhasat_asli_melk_karbari_now;
                //// field_5a907006c302c
                , moshakhasat_asli_melk_masahat_zamin_after_eslahie // moshakhasat_asli_melk_masahat_zamin_after_eslahie;
                //// field_5a907087c302d
                , moshakhasat_asli_melk_tol_bar_asli // moshakhasat_asli_melk_tol_bar_asli;
                //// field_5a906ebb1555a
                , moshakhasat_asli_melk_number_bar // moshakhasat_asli_melk_number_bar;
                //// field_5a906e5b15559
                , moshakhasat_asli_melk_vaziita_build_vazita_zamin // moshakhasat_asli_melk_vaziita_build_vazita_zamin;
                //// field_5a9072a3b1c10
                , more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check // more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;
                //// field_5a92e486f50ae
                , more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit // more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit;
                //// field_5a92e5cdf50af
                , more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin // more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin;
                //// field_5a92e661f50b5
                , more_joziat_melk_edari_tejari_dastresi_dastres_edit // more_joziat_melk_edari_tejari_dastresi_dastres_edit;
                //// field_5a92dbc8201f8
                , more_joziat_melk_edari_tejari_ghozar_asli // more_joziat_melk_edari_tejari_ghozar_asli;
                //// field_5a92dcda201fe
                , more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin // more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin;
                //// field_5a92e628f50b3
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
                //// field_5a91a80fdeca3
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
                //// field_5a91a897deca4
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam // more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;
                //// field_5a91a963deca5
        ).execute();

    }

    // edit Post
    public void EditSendPostConnectMaskoni() {


        new Connect(
                "http://padintarh.ir/Android/insertMASKO.php"
                , editText_onvan.getText().toString()  //matn
                , editTex_matn.getText().toString()
                , editTex_matn.getText().toString()
                , "barchasb_zamine", ID_send
                , noe_melk_moamele // noe_melk_moamele;
                , noe_melk // noe_melk;
                , moshakhasat_asli_melk_noe_bana // moshakhasat_asli_melk_noe_bana;
                , moshakhasat_asli_melk_masahat_build // moshakhasat_asli_melk_masahat_build;
                , moshakhasat_asli_melk_masahat_zamin // moshakhasat_asli_melk_masahat_zamin;
                , moshakhasat_asli_melk_number_room // moshakhasat_asli_melk_number_room;
                , moshakhasat_asli_melk_number_parking // moshakhasat_asli_melk_number_parking;
                , moshakhasat_asli_melk_sale_build // moshakhasat_asli_melk_sale_build;
                , moshakhasat_asli_melk_vaziita_build_vaziita_build_radio // moshakhasat_asli_melk_vaziita_build_vaziita_build_radio;
                , moshakhasat_asli_melk_vaziita_build_ghabel_sokonat // moshakhasat_asli_melk_vaziita_build_ghabel_sokonat;
                , price_shrayet_sell_cheng_price_all_sell_cheng // price_shrayet_sell_cheng_price_all_sell_cheng;
                , price_shrayet_sell_cheng_check_seel_cheng // price_shrayet_sell_cheng_check_seel_cheng;
                , price_shrayet_sell_cheng_max_money // price_shrayet_sell_cheng_max_money;
                , price_shrayet_sell_cheng_money_pish_pay // price_shrayet_sell_cheng_money_pish_pay;
                , price_shrayet_sell_cheng_time_tahvil // price_shrayet_sell_cheng_time_tahvil;
                , price_shrayet_sell_cheng_mizan_anjam_shode // price_shrayet_sell_cheng_mizan_anjam_shode;
                , price_shrayet_sell_cheng_mizan_vam // price_shrayet_sell_cheng_mizan_vam;
                , price_shrayet_sell_cheng_sod_vam // price_shrayet_sell_cheng_sod_vam;
                , price_shrayet_sell_cheng_number_ghest // price_shrayet_sell_cheng_number_ghest;
                , price_shrayet_sell_cheng_price_har_ghest // price_shrayet_sell_cheng_price_har_ghest;
                , price_shrayet_sell_cheng_price_rahn // price_shrayet_sell_cheng_price_rahn;
                , more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe // more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe;
                , more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe // more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe;
                , more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe // more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe;
                , more_joziat_melk_edari_tejari_moghit_build_number_all_vahed // more_joziat_melk_edari_tejari_moghit_build_number_all_vahed;
                , more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build // more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build;
                , more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari // more_joziat_melk_edari_tejari_emkanat_vahed_number_anbari;
                , more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari // more_joziat_melk_edari_tejari_emkanat_vahed_masahat_anbari;
                , more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon // more_joziat_melk_edari_tejari_emkanat_vahed_number_balkon;
                , more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon // more_joziat_melk_edari_tejari_emkanat_vahed_masahat_kol_balkon;
                , more_joziat_melk_edari_tejari_wc_wc_irani // more_joziat_melk_edari_tejari_wc_wc_irani;
                , more_joziat_melk_edari_tejari_wc_wc_us // more_joziat_melk_edari_tejari_wc_wc_us;
                , more_joziat_melk_edari_tejari_wc_bath // more_joziat_melk_edari_tejari_wc_bath;
                , more_joziat_melk_edari_tejari_kitchen_kitchen_check // more_joziat_melk_edari_tejari_kitchen_kitchen_check;
                , more_joziat_melk_edari_tejari_kitchen_kitchen_radio // more_joziat_melk_edari_tejari_kitchen_kitchen_radio;
                , more_joziat_melk_edari_tejari_kitchen_darai_kabinet // more_joziat_melk_edari_tejari_kitchen_darai_kabinet;
                , more_joziat_melk_edari_tejari_kitchen_badane_kabinet // more_joziat_melk_edari_tejari_kitchen_badane_kabinet;
                , more_joziat_melk_edari_tejari_kitchen_safhe_kabinet // more_joziat_melk_edari_tejari_kitchen_safhe_kabinet;
                , more_joziat_melk_edari_tejari_kitchen_roye_kabinet // more_joziat_melk_edari_tejari_kitchen_roye_kabinet;
                , more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchenST // more_joziat_melk_edari_tejari_kitchen_tajhizat_kitchen;
                , more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen // more_joziat_melk_edari_tejari_kitchen_edit_tozih_kitchen;
                , more_joziat_melk_edari_tejari_neshiman_neshiman_check // more_joziat_melk_edari_tejari_neshiman_neshiman_check;
                , more_joziat_melk_edari_tejari_neshiman_neshiman_edit // more_joziat_melk_edari_tejari_neshiman_neshiman_edit;
                , more_joziat_melk_edari_tejari_shekle_build_radio // more_joziat_melk_edari_tejari_shekle_build_radio;
                , more_joziat_melk_edari_tejari_nama_nama_check // more_joziat_melk_edari_tejari_nama_nama_check;
                , more_joziat_melk_edari_tejari_nama_nama_edit // more_joziat_melk_edari_tejari_nama_nama_edit;
                , more_joziat_melk_edari_tejari_eskelet_eskelet_check // more_joziat_melk_edari_tejari_eskelet_eskelet_check;
                , more_joziat_melk_edari_tejari_eskelet_eskelet_edit // more_joziat_melk_edari_tejari_eskelet_eskelet_edit;
                , more_joziat_melk_edari_tejari_kaf_kaf_check // more_joziat_melk_edari_tejari_kaf_kaf_check;
                , more_joziat_melk_edari_tejari_kaf_kaf_edit // more_joziat_melk_edari_tejari_kaf_kaf_edit;
                , more_joziat_melk_edari_tejari_divar_divar_check // more_joziat_melk_edari_tejari_divar_divar_check;
                , more_joziat_melk_edari_tejari_divar_divar_edit // more_joziat_melk_edari_tejari_divar_divar_edit;
                , more_joziat_melk_edari_tejari_coldhot_coldhot_check // more_joziat_melk_edari_tejari_coldhot_coldhot_check;
                , more_joziat_melk_edari_tejari_coldhot_coldhot_edit // more_joziat_melk_edari_tejari_coldhot_coldhot_edit;
                , more_joziat_melk_edari_tejari_refahi_refahi_check // more_joziat_melk_edari_tejari_refahi_refahi_check;
                , more_joziat_melk_edari_tejari_refahi_refahi_edit // more_joziat_melk_edari_tejari_refahi_refahi_edit;
                , more_joziat_melk_edari_tejari_safe_safe_check // more_joziat_melk_edari_tejari_safe_safe_check;
                , more_joziat_melk_edari_tejari_safe_safe_edit // more_joziat_melk_edari_tejari_safe_safe_edit;
                , more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta // more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta;
                , more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit // more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit;
                , more_joziat_melk_edari_tejari_sport_sport_check // more_joziat_melk_edari_tejari_sport_sport_check;
                , more_joziat_melk_edari_tejari_sport_sport_edit // more_joziat_melk_edari_tejari_sport_sport_edit;
                , more_joziat_melk_edari_tejari_view_view_check // more_joziat_melk_edari_tejari_view_view_check;
                , more_joziat_melk_edari_tejari_view_view_edit // more_joziat_melk_edari_tejari_view_view_edit;
                , more_joziat_melk_edari_tejari_nor_nor_check // more_joziat_melk_edari_tejari_nor_nor_check;
                , more_joziat_melk_edari_tejari_tasisat_tasisat_check // more_joziat_melk_edari_tejari_tasisat_tasisat_check;
                , more_joziat_melk_edari_tejari_tasisat_tasisat_edit // more_joziat_melk_edari_tejari_tasisat_tasisat_edit;
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam // more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;
                , finalstIDimage_1).execute();

        try {
            jsonObject = new JSONObject(dataServer);
        } catch (JSONException e) {
        }

    }

    public void EditSendPostConnectEdari() {

        new Connect6("http://padintarh.ir/Android/insertEDARI.php"
                , editText_onvan.getText().toString()  //matn
                , editTex_matn.getText().toString()
                , editTex_matn.getText().toString()
                , "barchasb_zamine", ID_send

                , noe_melk_moamele //  "noe_melk_moamele";
                , noe_melk //  "noe_melk";
                , moshakhasat_asli_melk_noe_bana //  "moshakhasat_asli_melk_noe_bana";
                , moshakhasat_asli_melk_masahat_build //  "moshakhasat_asli_melk_masahat_build";
                , moshakhasat_asli_melk_masahat_zamin //  "moshakhasat_asli_melk_masahat_zamin";
                , moshakhasat_asli_melk_number_room //  "moshakhasat_asli_melk_number_room";
                , moshakhasat_asli_melk_number_parking //  "moshakhasat_asli_melk_number_parking";
                , moshakhasat_asli_melk_moghiat_build //  "moshakhasat_asli_melk_moghiat_build";
                , price_shrayet_sell_cheng_price_all_sell_cheng //  "price_shrayet_sell_cheng_price_all_sell_cheng";
                , price_shrayet_sell_cheng_check_seel_cheng //  "price_shrayet_sell_cheng_check_seel_cheng";
                , price_shrayet_sell_cheng_max_money //  "price_shrayet_sell_cheng_max_money";
                , price_shrayet_sell_cheng_money_pish_pay //  "price_shrayet_sell_cheng_money_pish_pay";
                , price_shrayet_sell_cheng_time_tahvil //  "price_shrayet_sell_cheng_time_tahvil";
                , price_shrayet_sell_cheng_mizan_anjam_shode //  "price_shrayet_sell_cheng_mizan_anjam_shode";
                , price_shrayet_sell_cheng_mizan_vam //  "price_shrayet_sell_cheng_mizan_vam";
                , price_shrayet_sell_cheng_sod_vam //  "price_shrayet_sell_cheng_sod_vam";
                , price_shrayet_sell_cheng_number_ghest //  "price_shrayet_sell_cheng_number_ghest";
                , price_shrayet_sell_cheng_price_har_ghest //  "price_shrayet_sell_cheng_price_har_ghest";
                , price_shrayet_sell_cheng_price_rahn //  "price_shrayet_sell_cheng_price_rahn";
                , more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe //  "more_joziat_melk_edari_tejari_moghit_build_melk_dar_tabaghe";
                , more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe //  "more_joziat_melk_edari_tejari_moghit_build_number_all_tabaghe";
                , more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe //  "more_joziat_melk_edari_tejari_moghit_build_number_vahed_dar_tabaghe";
                , more_joziat_melk_edari_tejari_moghit_build_number_all_vahed //  "more_joziat_melk_edari_tejari_moghit_build_number_all_vahed";
                , more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build //  "more_joziat_melk_edari_tejari_moghit_build_vaghe_dar_build";
                , more_joziat_melk_edari_tejari_wc_wc_irani //  "more_joziat_melk_edari_tejari_wc_wc_irani";
                , more_joziat_melk_edari_tejari_wc_wc_us //  "more_joziat_melk_edari_tejari_wc_wc_us";
                , more_joziat_melk_edari_tejari_kitchen_abdarkhane //  "more_joziat_melk_edari_tejari_kitchen_abdarkhane";
                , more_joziat_melk_edari_tejari_kitchen_ghazakhori //  "more_joziat_melk_edari_tejari_kitchen_ghazakhori";
                , more_joziat_melk_edari_tejari_room_asli_room_asli_edit //  "more_joziat_melk_edari_tejari_room_asli_room_asli_edit";
                , more_joziat_melk_edari_tejari_nama_nama_check //  "more_joziat_melk_edari_tejari_nama_nama_check";
                , more_joziat_melk_edari_tejari_nama_nama_edit //  "more_joziat_melk_edari_tejari_nama_nama_edit";
                , more_joziat_melk_edari_tejari_divar_divar_check //  "more_joziat_melk_edari_tejari_divar_divar_check";
                , more_joziat_melk_edari_tejari_divar_divar_edit //  "more_joziat_melk_edari_tejari_divar_divar_edit";
                , more_joziat_melk_edari_tejari_coldhot_coldhot_check //  "more_joziat_melk_edari_tejari_coldhot_coldhot_check";
                , more_joziat_melk_edari_tejari_coldhot_coldhot_edit //  "more_joziat_melk_edari_tejari_coldhot_coldhot_edit";
                , more_joziat_melk_edari_tejari_refahi_refahi_check //  "more_joziat_melk_edari_tejari_refahi_refahi_check";
                , more_joziat_melk_edari_tejari_refahi_refahi_edit //  "more_joziat_melk_edari_tejari_refahi_refahi_edit";
                , more_joziat_melk_edari_tejari_safe_safe_check //  "more_joziat_melk_edari_tejari_safe_safe_check";
                , more_joziat_melk_edari_tejari_safe_safe_edit //  "more_joziat_melk_edari_tejari_safe_safe_edit";
                , more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta //  "more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta";
                , more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit //  "more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit";
                , more_joziat_melk_edari_tejari_view_view_check //  "more_joziat_melk_edari_tejari_view_view_check";
                , more_joziat_melk_edari_tejari_view_view_edit //  "more_joziat_melk_edari_tejari_view_view_edit";
                , more_joziat_melk_edari_tejari_nor_nor_check //  "more_joziat_melk_edari_tejari_nor_nor_check";
                , more_joziat_melk_edari_tejari_tasisat_tasisat_check //  "more_joziat_melk_edari_tejari_tasisat_tasisat_check";
                , more_joziat_melk_edari_tejari_tasisat_tasisat_edit //  "more_joziat_melk_edari_tejari_tasisat_tasisat_edit";
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat //  "more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat";
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat //  "more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat";
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam //  "more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam";
                , more_joziat_melk_edari_tejari_kitchen_badane_kabinet //  "more_joziat_melk_edari_tejari_kitchen_badane_kabinet";
                , more_joziat_melk_edari_tejari_kitchen_safhe_kabinet//  "more_joziat_melk_edari_tejari_kitchen_safhe_kabinet";
                , more_joziat_melk_edari_tejari_kitchen_roye_kabinet //  "more_joziat_melk_edari_tejari_kitchen_roye_kabinet";
                , more_joziat_melk_edari_tejari_room_asli_room_asli_check //  "more_joziat_melk_edari_tejari_kitchen_roye_kabinet";
                , moshakhasat_asli_melk_vaziita_build_vaziita_build_radio
                , more_joziat_melk_edari_tejari_kitchen_kitchen_radio
                , more_joziat_melk_edari_tejari_shekle_build_radio
        ).execute();

        try {
            jsonObject = new JSONObject(dataServer);
        } catch (JSONException e) {
        }


    }

    public void EditSendPostConnectTejari() {
        new Connect7(
                "http://padintarh.ir/Android/insertTEJARI.php"
                , editText_onvan.getText().toString()  //matn
                , editTex_matn.getText().toString()
                , editTex_matn.getText().toString()
                , "barchasb_zamine"
                , ID_send
                , noe_melk_moamele  // noe_melk_moamele +
                , noe_melk  // noe_melk +
                , moshakhasat_asli_melk_moghiita_store  // moshakhasat_asli_melk_moghiita_store +
                , moshakhasat_asli_melk_masahat_kaf  // moshakhasat_asli_melk_masahat_kaf +
                , moshakhasat_asli_melk_masahat_balkon  // moshakhasat_asli_melk_masahat_balkon +
                , moshakhasat_asli_melk_nuumber_dahane  // moshakhasat_asli_melk_nuumber_dahane +
                , moshakhasat_asli_melk_tol_bar_asli  // moshakhasat_asli_melk_tol_bar_asli +
                , moshakhasat_asli_melk_number_bar  // moshakhasat_asli_melk_number_bar +
                , moshakhasat_asli_melk_noe_vaghozari  // moshakhasat_asli_melk_noe_vaghozari +
                , more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh  // more_joziat_melk_edari_tejari_moghit_build_melk_dar_pasazh +
                , more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh  // more_joziat_melk_edari_tejari_moghit_build_number_all_pashazh +
                , more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe  // more_joziat_melk_edari_tejari_moghit_build_number_maghaze_dar_tabaghe +
                , more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze  // more_joziat_melk_edari_tejari_moghit_build_number_all_maghaze +
                , more_joziat_melk_edari_tejari_wc_wc_irani  // more_joziat_melk_edari_tejari_wc_wc_irani +
                , more_joziat_melk_edari_tejari_wc_wc_us  // more_joziat_melk_edari_tejari_wc_wc_us +
                , more_joziat_melk_edari_tejari_wc_roshoii  // more_joziat_melk_edari_tejari_wc_roshoii +
                , more_joziat_melk_edari_tejari_abdarhkane_tejari  // more_joziat_melk_edari_tejari_abdarhkane_tejari +
                , more_joziat_melk_edari_tejari_fazai_asli_fazai_asli  // more_joziat_melk_edari_tejari_fazai_asli_fazai_asli +
                , more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari  // more_joziat_melk_edari_tejari_nama_nama_check_edari_tejari +
                , more_joziat_melk_edari_tejari_kaf_kaf_check  // more_joziat_melk_edari_tejari_kaf_kaf_check +
                , more_joziat_melk_edari_tejari_kaf_kaf_edit  // more_joziat_melk_edari_tejari_kaf_kaf_edit +
                , more_joziat_melk_edari_tejari_coldhot_coldhot_check  // more_joziat_melk_edari_tejari_coldhot_coldhot_check +
                , more_joziat_melk_edari_tejari_coldhot_coldhot_edit  // more_joziat_melk_edari_tejari_coldhot_coldhot_edit +
                , more_joziat_melk_edari_tejari_refahi_refahi_check_tejari  // more_joziat_melk_edari_tejari_refahi_refahi_check_tejari +
                , more_joziat_melk_edari_tejari_refahi_refahi_edit  // more_joziat_melk_edari_tejari_refahi_refahi_edit +
                , more_joziat_melk_edari_tejari_safe_safe_check_tejari  // more_joziat_melk_edari_tejari_safe_safe_check_tejari +
                , more_joziat_melk_edari_tejari_safe_safe_edit  // more_joziat_melk_edari_tejari_safe_safe_edit +
                , more_joziat_melk_edari_tejari_dastresi_dastresi_check  // more_joziat_melk_edari_tejari_dastresi_dastresi_check +
                , more_joziat_melk_edari_tejari_dastresi_dastres_edit  // more_joziat_melk_edari_tejari_dastresi_dastres_edit +
                , more_joziat_melk_edari_tejari_ghozar_asli  // more_joziat_melk_edari_tejari_ghozar_asli +
                , more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari  // more_joziat_melk_edari_tejari_tasisat_tasisat_check_edari_tejari +
                , more_joziat_melk_edari_tejari_tasisat_tasisat_edit  // more_joziat_melk_edari_tejari_tasisat_tasisat_edit +
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat  // more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat +
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat  // more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat +
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam  // more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam +

        ).execute();
    }

    public void EditSendPostConnectMostaghelat() {
        new Connect8(
                "http://padintarh.ir/Android/insertMOSTA.php"
                , editText_onvan.getText().toString()  //matn
                , editTex_matn.getText().toString()
                , editTex_matn.getText().toString()
                , ID_send
                , "barchasb_zamine"
                , noe_melk_moamele // noe_melk_moamele";
// field_5a8fdad301cc8
                , noe_melk // noe_melk";
// field_5a8fdb67dcf20
                , moshakhasat_asli_melk_noe_bana_mostagh // moshakhasat_asli_melk_noe_bana_mostagh";
// field_5a9072eb2df3d
                , moshakhasat_asli_melk_mosahat_kol_banai_build // moshakhasat_asli_melk_mosahat_kol_banai_build";
// field_5a9073862df3e
                , moshakhasat_asli_melk_masahat_zamin // moshakhasat_asli_melk_masahat_zamin";
// field_5a90678dd68d5
                , moshakhasat_asli_melk_number_bar // moshakhasat_asli_melk_number_bar";
// field_5a906e5b15559
                , moshakhasat_asli_melk_sale_build // moshakhasat_asli_melk_sale_build";
// field_5a9067f5d68d8
                , more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check // more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check";
// field_5a92e486f50ae
                , more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit // more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit";
// field_5a92e5cdf50af
                , more_joziat_melk_edari_tejari_nama_nama_check // more_joziat_melk_edari_tejari_nama_nama_check";
// field_5a9193a0c6335
                , more_joziat_melk_edari_tejari_nama_nama_edit // more_joziat_melk_edari_tejari_nama_nama_edit";
// field_5a9193e4c6336
                , more_joziat_melk_edari_tejari_eskelet_eskelet_check // more_joziat_melk_edari_tejari_eskelet_eskelet_check";
// field_5a919761be9be
                , more_joziat_melk_edari_tejari_eskelet_eskelet_edit // more_joziat_melk_edari_tejari_eskelet_eskelet_edit";
// field_5a919761be9bf
                , more_joziat_melk_edari_tejari_divar_divar_check // more_joziat_melk_edari_tejari_divar_divar_check";
// field_5a9199ef39a1f
                , more_joziat_melk_edari_tejari_divar_divar_edit // more_joziat_melk_edari_tejari_divar_divar_edit";
// field_5a9199ef39a20
                , more_joziat_melk_edari_tejari_coldhot_coldhot_check // more_joziat_melk_edari_tejari_coldhot_coldhot_check";
// field_5a919a803066c
                , more_joziat_melk_edari_tejari_coldhot_coldhot_edit // more_joziat_melk_edari_tejari_coldhot_coldhot_edit";
// field_5a919a803066d
                , more_joziat_melk_edari_tejari_refahi_refahi_check_mosta // more_joziat_melk_edari_tejari_refahi_refahi_check_mosta";
// field_5a92e7d261b5c
                , more_joziat_melk_edari_tejari_refahi_refahi_edit // more_joziat_melk_edari_tejari_refahi_refahi_edit";
// field_5a919bc32e871
                , more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta // more_joziat_melk_edari_tejari_safe_safe_check_edari_mosta";
// field_5a92d6911ad6d
                , more_joziat_melk_edari_tejari_safe_safe_edit // more_joziat_melk_edari_tejari_safe_safe_edit";
// field_5a91a3e6fb835
                , more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta // more_joziat_melk_edari_tejari_dastresi_dastresi_check_mosta";
// field_5a92ea1f61b6a
                , more_joziat_melk_edari_tejari_dastresi_dastres_edit // more_joziat_melk_edari_tejari_dastresi_dastres_edit";
// field_5a92dbc8201f8
                , more_joziat_melk_edari_tejari_ghozar_asli // more_joziat_melk_edari_tejari_ghozar_asli";
// field_5a92dcda201fe
                , more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta // more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_check_mosta";
// field_5a91a4b71b42b
                , more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit // more_joziat_melk_edari_tejari_emkanatBuild_emkanatBuild_edit";
// field_5a91a4b81b42c
                , more_joziat_melk_edari_tejari_sport_sport_check // more_joziat_melk_edari_tejari_sport_sport_check";
// field_5a91a53c1b42e
                , more_joziat_melk_edari_tejari_sport_sport_edit // more_joziat_melk_edari_tejari_sport_sport_edit";
// field_5a91a53d1b42f
                , more_joziat_melk_edari_tejari_view_view_check // more_joziat_melk_edari_tejari_view_view_check";
// field_5a91a5cd934cd
                , more_joziat_melk_edari_tejari_view_view_edit // more_joziat_melk_edari_tejari_view_view_edit";
// field_5a91a5cd934ce
                , more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta // more_joziat_melk_edari_tejari_tasisat_tasisat_check_mosta";
// field_5a92ea5861b6c
                , more_joziat_melk_edari_tejari_tasisat_tasisat_edit // more_joziat_melk_edari_tejari_tasisat_tasisat_edit";
// field_5a91a6af934d5
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat";
// field_5a91a80fdeca3
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat";
// field_5a91a897deca4
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam // more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam";
// field_5a91a963deca5
        ).execute();

    }

    public void EditSendPostConnectZamin() {

        new Connect9(
                "http://padintarh.ir/Android/insertZAMIN.php"
                , editText_onvan.getText().toString()  //matn
                , editTex_matn.getText().toString()
                , editTex_matn.getText().toString()
                , "barchasb_zamine"
                , ID_send
                , noe_melk_moamele // noe_melk_moamele;
                //// field_5a8fdad301cc8
                , noe_melk // noe_melk;
                //// field_5a8fdb67dcf20
                , moshakhasat_asli_melk_karbari_now // moshakhasat_asli_melk_karbari_now;
                //// field_5a907006c302c
                , moshakhasat_asli_melk_masahat_zamin_after_eslahie // moshakhasat_asli_melk_masahat_zamin_after_eslahie;
                //// field_5a907087c302d
                , moshakhasat_asli_melk_tol_bar_asli // moshakhasat_asli_melk_tol_bar_asli;
                //// field_5a906ebb1555a
                , moshakhasat_asli_melk_number_bar // moshakhasat_asli_melk_number_bar;
                //// field_5a906e5b15559
                , moshakhasat_asli_melk_vaziita_build_vazita_zamin // moshakhasat_asli_melk_vaziita_build_vazita_zamin;
                //// field_5a9072a3b1c10
                , more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check // more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_check;
                //// field_5a92e486f50ae
                , more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit // more_joziat_melk_edari_tejari_karbari_pishnahadi_karbari_pishnahadi_edit;
                //// field_5a92e5cdf50af
                , more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin // more_joziat_melk_edari_tejari_dastresi_dastresi_check_zamin;
                //// field_5a92e661f50b5
                , more_joziat_melk_edari_tejari_dastresi_dastres_edit // more_joziat_melk_edari_tejari_dastresi_dastres_edit;
                //// field_5a92dbc8201f8
                , more_joziat_melk_edari_tejari_ghozar_asli // more_joziat_melk_edari_tejari_ghozar_asli;
                //// field_5a92dcda201fe
                , more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin // more_joziat_melk_edari_tejari_tasisat_tasisat_check_zamin;
                //// field_5a92e628f50b3
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_malekiat;
                //// field_5a91a80fdeca3
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat // more_joziat_melk_edari_tejari_moshakhasat_sanad_noe_malekiat;
                //// field_5a91a897deca4
                , more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam // more_joziat_melk_edari_tejari_moshakhasat_sanad_sanad_dar_dast_eghdam;
                //// field_5a91a963deca5
        ).execute();

    }
*/
    // Pic

    public int uploadFile(String sourceFileUri) {

        String fileName = sourceFileUri;
        HttpURLConnection conn = null;
        DataOutputStream dos = null;
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";
        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1 * 645 * 645;
        File sourceFile = new File(sourceFileUri);

        if (!sourceFile.isFile()) {

            dialog.dismiss();

            Log.e("uploadFile", "Source File not exist :" + sourceFileUri);

            runOnUiThread(new Runnable() {
                public void run() {
                    //   textView3.setText("Source File not exist :" + sourceFileUri);
                }
            });

            return 0;

        } else {
            try {

                // open a URL connection to the Servlet
                FileInputStream fileInputStream = new FileInputStream(sourceFile);
                URL url = new URL(upLoadServerUri);
                // Open a HTTP  connection to  the URL
                conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true); // Allow Inputs
                conn.setDoOutput(true); // Allow Outputs
                conn.setUseCaches(false); // Don't use a Cached Copy
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Connection", "Keep-Alive");
                conn.setRequestProperty("ENCTYPE", "multipart/form-data");
                conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
                conn.setRequestProperty("uploaded_file", fileName);

                dos = new DataOutputStream(conn.getOutputStream());
                dos.writeBytes(twoHyphens + boundary + lineEnd);
                dos.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\";filename=\"" + fileName + "\"" + lineEnd);
                dos.writeBytes(lineEnd);
                // create a buffer of  maximum size
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                buffer = new byte[bufferSize];
                // read file and write it into form...
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
                while (bytesRead > 0) {
                    dos.write(buffer, 0, bufferSize);
                    bytesAvailable = fileInputStream.available();
                    bufferSize = Math.min(bytesAvailable, maxBufferSize);
                    bytesRead = fileInputStream.read(buffer, 0, bufferSize);
                }
                // send multipart form data necesssary after file data...
                dos.writeBytes(lineEnd);
                dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
                // Responses from the server (code and message)
                serverResponseCode = conn.getResponseCode();
                String serverResponseMessage = conn.getResponseMessage();

                Log.i("uploadFile", "HTTP Response is : " + serverResponseMessage + ": " + serverResponseCode);
                if (serverResponseCode == 200) {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(Main26Activity.this, "File Upload Complete.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                //close the streams //
                fileInputStream.close();
                dos.flush();
                dos.close();
            } catch (MalformedURLException ex) {
                dialog.dismiss();
                ex.printStackTrace();
                runOnUiThread(new Runnable() {
                    public void run() {
                        // textView3.setText("MalformedURLException Exception : check script url.");
                        Toast.makeText(Main26Activity.this, "MalformedURLException", Toast.LENGTH_SHORT).show();
                    }
                });
                Log.e("Upload file to server", "error: " + ex.getMessage(), ex);
            } catch (Exception e) {
                dialog.dismiss();
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    public void run() {
                        //  textView3.setText("Got Exception : see logcat ");
                        Toast.makeText(Main26Activity.this, "Got Exception : see logcat ", Toast.LENGTH_SHORT).show();
                    }
                });
                Log.e("Upload file to server Exception", "Exception : " + e.getMessage(), e);
            }

            dialog.dismiss();
            return serverResponseCode;

        }// End else block
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {

                Uri selectedImage = data.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
/*
                filetakePic2 = c.getString(columnIndex);
                imageView2.setImageBitmap(thumbnail);
                decodeFile(filetakePic2, 860, 645);
*/
                switch (witchPic) {
                    case 1:
                        str_1tp = c.getString(columnIndex);
                        decodeFile(str_1tp, 860, 645);
                        Bitmap abc_1 = (BitmapFactory.decodeFile(str_1tp));
                        scaleDown_150x150(abc_1, 150, true);
                        scaleDown_300x300(abc_1, 150, true);
                        imagesNotNull_1 = "NotNull";
                        imgTakePic_1.setImageBitmap(abc_1);
                        break;
                    case 2:
                        str_2tp = c.getString(columnIndex);
                        decodeFile(str_2tp, 860, 645);
                        Bitmap abc_2 = (BitmapFactory.decodeFile(str_2tp));
                        scaleDown_150x150(abc_2, 150, true);
                        scaleDown_300x300(abc_2, 150, true);
                        imagesNotNull_2 = "NotNull";
                        imgTakePic_2.setImageBitmap(abc_2);
                        break;
                    case 3:
                        str_3tp = c.getString(columnIndex);
                        decodeFile(str_3tp, 860, 645);
                        Bitmap abc_3 = (BitmapFactory.decodeFile(str_3tp));
                        scaleDown_150x150(abc_3, 150, true);
                        scaleDown_300x300(abc_3, 150, true);
                        imagesNotNull_3 = "NotNull";
                        imgTakePic_3.setImageBitmap(abc_3);
                        break;
                    case 4:
                        str_4tp = c.getString(columnIndex);
                        decodeFile(str_4tp, 860, 645);
                        Bitmap abc_4 = (BitmapFactory.decodeFile(str_4tp));
                        scaleDown_150x150(abc_4, 150, true);
                        scaleDown_300x300(abc_4, 150, true);
                        imagesNotNull_4 = "NotNull";
                        imgTakePic_4.setImageBitmap(abc_4);
                        break;
                    case 5:
                        str_5tp = c.getString(columnIndex);
                        decodeFile(str_5tp, 860, 645);
                        Bitmap abc_5 = (BitmapFactory.decodeFile(str_5tp));
                        scaleDown_150x150(abc_5, 150, true);
                        scaleDown_300x300(abc_5, 150, true);
                        imagesNotNull_5 = "NotNull";
                        imgTakePic_5.setImageBitmap(abc_5);
                        break;
                    case 6:
                        str_6tp = c.getString(columnIndex);
                        decodeFile(str_6tp, 860, 645);
                        Bitmap abc_6 = (BitmapFactory.decodeFile(str_6tp));
                        scaleDown_150x150(abc_6, 150, true);
                        scaleDown_300x300(abc_6, 150, true);
                        imagesNotNull_6 = "NotNull";
                        imgTakePic_6.setImageBitmap(abc_6);
                        break;
                    case 7:
                        str_7tp = c.getString(columnIndex);
                        decodeFile(str_7tp, 860, 645);
                        Bitmap abc_7 = (BitmapFactory.decodeFile(str_7tp));
                        scaleDown_150x150(abc_7, 150, true);
                        scaleDown_300x300(abc_7, 150, true);
                        imagesNotNull_7 = "NotNull";
                        imgTakePic_7.setImageBitmap(abc_7);
                        break;
                    case 8:
                        str_8tp = c.getString(columnIndex);
                        decodeFile(str_8tp, 860, 645);
                        Bitmap abc_8 = (BitmapFactory.decodeFile(str_8tp));
                        scaleDown_150x150(abc_8, 150, true);
                        scaleDown_300x300(abc_8, 150, true);
                        imagesNotNull_8 = "NotNull";
                        imgTakePic_8.setImageBitmap(abc_8);
                        break;
                    case 9:
                        str_9tp = c.getString(columnIndex);
                        decodeFile(str_9tp, 860, 645);
                        Bitmap abc_9 = (BitmapFactory.decodeFile(str_9tp));
                        scaleDown_150x150(abc_9, 150, true);
                        scaleDown_300x300(abc_9, 150, true);
                        imagesNotNull_9 = "NotNull";
                        imgTakePic_9.setImageBitmap(abc_9);
                        break;
                    case 10:
                        str_10tp = c.getString(columnIndex);
                        decodeFile(str_10tp, 1500, 900);
                        Bitmap abc_10 = (BitmapFactory.decodeFile(str_10tp));
                        scaleDown_150x150(abc_10, 150, true);
                        scaleDown_300x300(abc_10, 150, true);
                        imagesNotNull_10 = "NotNull";
                        imgTakePic_10.setImageBitmap(abc_10);
                        break;
                }
                c.close();


         /*
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                filetakePic = new File(Environment.getExternalStorageDirectory() + File.separator + "image.jpg");
                 try {
                    filetakePic.createNewFile();
                    FileOutputStream fo = new FileOutputStream(filetakePic);
                    fo.write(bytes.toByteArray());
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                filetakePic = new File(Environment.getExternalStorageDirectory().toString());
                for (File temp : filetakePic.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        filetakePic = temp;
                        break;
                    }
                }
                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(filetakePic.getAbsolutePath(), bitmapOptions);
                    imageView2.setImageBitmap(bitmap);
                    String path = android.os.Environment.getExternalStorageDirectory() + File.separator + "Phoenix" + File.separator + "default";
                  //  filetakePic.delete();
                    OutputStream outFile = null;
                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
                    try {
                        outFile = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
                        outFile.flush();
                        outFile.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                editText2.setText(filetakePic + "");

            */
            } else if (requestCode == 2) {
                Uri selectedImage = data.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
/*
                picturePath = c.getString(columnIndex);
                thumbnail123123 = (BitmapFactory.decodeFile(picturePath));
                decodeFile(picturePath, 860, 645);
                imageView2.setImageBitmap(thumbnail123123);
*/
                switch (witchPic) {
                    case 1:
                        str_1tp = c.getString(columnIndex);
                        decodeFile(str_1tp, 860, 645);
                        Bitmap abc_1 = (BitmapFactory.decodeFile(str_1tp));
                        scaleDown_150x150(abc_1, 150, true);
                        scaleDown_300x300(abc_1, 150, true);
                        imagesNotNull_1 = "NotNull";
                        imgTakePic_1.setImageBitmap(abc_1);
                        break;
                    case 2:
                        str_2tp = c.getString(columnIndex);
                        decodeFile(str_2tp, 860, 645);
                        Bitmap abc_2 = (BitmapFactory.decodeFile(str_2tp));
                        scaleDown_150x150(abc_2, 150, true);
                        scaleDown_300x300(abc_2, 150, true);
                        imagesNotNull_2 = "NotNull";
                        imgTakePic_2.setImageBitmap(abc_2);
                        break;
                    case 3:
                        str_3tp = c.getString(columnIndex);
                        decodeFile(str_3tp, 860, 645);
                        Bitmap abc_3 = (BitmapFactory.decodeFile(str_3tp));
                        scaleDown_150x150(abc_3, 150, true);
                        scaleDown_300x300(abc_3, 150, true);
                        imagesNotNull_3 = "NotNull";
                        imgTakePic_3.setImageBitmap(abc_3);
                        break;
                    case 4:
                        str_4tp = c.getString(columnIndex);
                        decodeFile(str_4tp, 860, 645);
                        Bitmap abc_4 = (BitmapFactory.decodeFile(str_4tp));
                        scaleDown_150x150(abc_4, 150, true);
                        scaleDown_300x300(abc_4, 150, true);
                        imagesNotNull_4 = "NotNull";
                        imgTakePic_4.setImageBitmap(abc_4);
                        break;
                    case 5:
                        str_5tp = c.getString(columnIndex);
                        decodeFile(str_5tp, 860, 645);
                        Bitmap abc_5 = (BitmapFactory.decodeFile(str_5tp));
                        scaleDown_150x150(abc_5, 150, true);
                        scaleDown_300x300(abc_5, 150, true);
                        imagesNotNull_5 = "NotNull";
                        imgTakePic_5.setImageBitmap(abc_5);
                        break;
                    case 6:
                        str_6tp = c.getString(columnIndex);
                        decodeFile(str_6tp, 860, 645);
                        Bitmap abc_6 = (BitmapFactory.decodeFile(str_6tp));
                        scaleDown_150x150(abc_6, 150, true);
                        scaleDown_300x300(abc_6, 150, true);
                        imagesNotNull_6 = "NotNull";
                        imgTakePic_6.setImageBitmap(abc_6);
                        break;
                    case 7:
                        str_7tp = c.getString(columnIndex);
                        decodeFile(str_7tp, 860, 645);
                        Bitmap abc_7 = (BitmapFactory.decodeFile(str_7tp));
                        scaleDown_150x150(abc_7, 150, true);
                        scaleDown_300x300(abc_7, 150, true);
                        imagesNotNull_7 = "NotNull";
                        imgTakePic_7.setImageBitmap(abc_7);
                        break;
                    case 8:
                        str_8tp = c.getString(columnIndex);
                        decodeFile(str_8tp, 860, 645);
                        Bitmap abc_8 = (BitmapFactory.decodeFile(str_8tp));
                        scaleDown_150x150(abc_8, 150, true);
                        scaleDown_300x300(abc_8, 150, true);
                        imagesNotNull_8 = "NotNull";
                        imgTakePic_8.setImageBitmap(abc_8);
                        break;
                    case 9:
                        str_9tp = c.getString(columnIndex);
                        decodeFile(str_9tp, 860, 645);
                        Bitmap abc_9 = (BitmapFactory.decodeFile(str_9tp));
                        scaleDown_150x150(abc_9, 150, true);
                        scaleDown_300x300(abc_9, 150, true);
                        imagesNotNull_9 = "NotNull";
                        imgTakePic_9.setImageBitmap(abc_9);
                        break;
                    case 10:
                        str_10tp = c.getString(columnIndex);
                        decodeFile(str_10tp, 1500, 900);
                        Bitmap abc_10 = (BitmapFactory.decodeFile(str_10tp));
                        scaleDown_150x150(abc_10, 150, true);
                        scaleDown_300x300(abc_10, 150, true);
                        imagesNotNull_10 = "NotNull";
                        imgTakePic_10.setImageBitmap(abc_10);
                        break;
                }
                c.close();
            }
        }
    }

    public void AlertDialogTakePic() {

        final CharSequence[] options = {"عکس گرفتن", "انتخاب از گالری", "بستن"};
        AlertDialog.Builder builder = new AlertDialog.Builder(Main26Activity.this);
        builder.setTitle("انتخاب کنید");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("عکس گرفتن")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 1);
                } else if (options[item].equals("انتخاب از گالری")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);
                } else if (options[item].equals("بستن")) {
                    dialog.dismiss();
                }
            }
        });

        builder.show();
    }

    private String decodeFile(String path, int DESIREDWIDTH, int DESIREDHEIGHT) {

        String strMyImagePath = null;
        Bitmap scaledBitmap = null;

        try {
            // Part 1: Decode image
            Bitmap unscaledBitmap = ScalingUtilities.decodeFile(path, DESIREDWIDTH, DESIREDHEIGHT, ScalingUtilities.ScalingLogic.FIT);

            if (!(unscaledBitmap.getWidth() <= DESIREDWIDTH && unscaledBitmap.getHeight() <= DESIREDHEIGHT)) {
                // Part 2: Scale image
                scaledBitmap = ScalingUtilities.createScaledBitmap(unscaledBitmap, DESIREDWIDTH, DESIREDHEIGHT, ScalingUtilities.ScalingLogic.FIT);
            } else {
                unscaledBitmap.recycle();
                return path;
            }

            // Store to tmp file

            String extr = Environment.getExternalStorageDirectory().toString();
            File mFolder = new File(extr + "/FindHome");
            if (!mFolder.exists()) {
                mFolder.mkdir();
            }

            int namePic = 20;
            char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < namePic; i++) {
                char c = chars[random.nextInt(chars.length)];
                sb.append(c);
            }
            sb1 = "a" + sb;
            String s = sb1 + ".png";

            switch (witchPic) {
                case 1:
                    stIDimage_1 = s;
                    break;
                case 2:
                    stIDimage_2 = s;
                    break;
                case 3:
                    stIDimage_3 = s;
                    break;
                case 4:
                    stIDimage_4 = s;
                    break;
                case 5:
                    stIDimage_5 = s;
                    break;
                case 6:
                    stIDimage_6 = s;
                    break;
                case 7:
                    stIDimage_7 = s;
                    break;
                case 8:
                    stIDimage_8 = s;
                    break;
                case 9:
                    stIDimage_9 = s;
                    break;
                case 10:
                    stIDimage_10 = s;
                    break;

            }
            File f = new File(mFolder.getAbsolutePath(), s);
            strMyImagePath = f.getAbsolutePath();

            switch (witchPic) {
                case 1:
                    str_1tp = strMyImagePath;
                    break;
                case 2:
                    str_2tp = strMyImagePath;
                    break;
                case 3:
                    str_3tp = strMyImagePath;
                    break;
                case 4:
                    str_4tp = strMyImagePath;
                    break;
                case 5:
                    str_5tp = strMyImagePath;
                    break;
                case 6:
                    str_6tp = strMyImagePath;
                    break;
                case 7:
                    str_7tp = strMyImagePath;
                    break;
                case 8:
                    str_8tp = strMyImagePath;
                    break;
                case 9:
                    str_9tp = strMyImagePath;
                    break;
                case 10:
                    str_10tp = strMyImagePath;
                    break;

            }

            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(f);
                scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 75, fos);
                fos.flush();
                fos.close();
            } catch (FileNotFoundException e) {

                e.printStackTrace();
            } catch (Exception e) {

                e.printStackTrace();
            }

            scaledBitmap.recycle();
        } catch (Throwable e) {
        }

        if (strMyImagePath == null) {
            return path;
        }
        return strMyImagePath;

    }

    public static Bitmap scaleDown_150x150(Bitmap realImage, float maxImageSize, boolean filter) {

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, 150, 150, filter);
        SaveImage_150x150(newBitmap);
        return newBitmap;
    }

    private static void SaveImage_150x150(Bitmap finalBitmap) {

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/findhome/150x150");
        myDir.mkdirs();

        String s = sb1 + "-150x150" + ".png";
        switch (witchPic) {
            case 1:
                stIDimage_1_150x150 = s;

                break;
            case 2:
                stIDimage_2_150x150 = s;
                break;
            case 3:
                stIDimage_3_150x150 = s;
                break;
            case 4:
                stIDimage_4_150x150 = s;
                break;
            case 5:
                stIDimage_5_150x150 = s;
                break;
            case 6:
                stIDimage_6_150x150 = s;
                break;
            case 7:
                stIDimage_7_150x150 = s;
                break;
            case 8:
                stIDimage_8_150x150 = s;
                break;
            case 9:
                stIDimage_9_150x150 = s;
                break;
            case 10:
                stIDimage_10_150x150 = s;
                break;

        }


        File file = new File(myDir, s);
        String strMyImagePath = file.getAbsolutePath();

        switch (witchPic) {
            case 1:
                str_1tp_150x150 = strMyImagePath;
                break;
            case 2:
                str_2tp_150x150 = strMyImagePath;
                break;
            case 3:
                str_3tp_150x150 = strMyImagePath;
                break;
            case 4:
                str_4tp_150x150 = strMyImagePath;
                break;
            case 5:
                str_5tp_150x150 = strMyImagePath;
                break;
            case 6:
                str_6tp_150x150 = strMyImagePath;
                break;
            case 7:
                str_7tp_150x150 = strMyImagePath;
                break;
            case 8:
                str_8tp_150x150 = strMyImagePath;
                break;
            case 9:
                str_9tp_150x150 = strMyImagePath;
                break;
            case 10:
                str_10tp_150x150 = strMyImagePath;
                break;

        }

        if (file.exists()) file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Bitmap scaleDown_300x300(Bitmap realImage, float maxImageSize, boolean filter) {

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, 300, 300, filter);
        SaveImage_300x300(newBitmap);
        return newBitmap;
    }

    private static void SaveImage_300x300(Bitmap finalBitmap) {

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/findhome/300x300");
        myDir.mkdirs();

        String s = sb1 + "-300x300" + ".png";
        switch (witchPic) {
            case 1:
                stIDimage_1_300x300 = s;
                break;
            case 2:
                stIDimage_2_300x300 = s;
                break;
            case 3:
                stIDimage_3_300x300 = s;
                break;
            case 4:
                stIDimage_4_300x300 = s;
                break;
            case 5:
                stIDimage_5_300x300 = s;
                break;
            case 6:
                stIDimage_6_300x300 = s;
                break;
            case 7:
                stIDimage_7_300x300 = s;
                break;
            case 8:
                stIDimage_8_300x300 = s;
                break;
            case 9:
                stIDimage_9_300x300 = s;
                break;
            case 10:
                stIDimage_10_300x300 = s;
                break;

        }


        File file = new File(myDir, s);
        String strMyImagePath = file.getAbsolutePath();

        switch (witchPic) {
            case 1:
                str_1tp_300x300 = strMyImagePath;
                break;
            case 2:
                str_2tp_300x300 = strMyImagePath;
                break;
            case 3:
                str_3tp_300x300 = strMyImagePath;
                break;
            case 4:
                str_4tp_300x300 = strMyImagePath;
                break;
            case 5:
                str_5tp_300x300 = strMyImagePath;
                break;
            case 6:
                str_6tp_300x300 = strMyImagePath;
                break;
            case 7:
                str_7tp_300x300 = strMyImagePath;
                break;
            case 8:
                str_8tp_300x300 = strMyImagePath;
                break;
            case 9:
                str_9tp_300x300 = strMyImagePath;
                break;
            case 10:
                str_10tp_300x300 = strMyImagePath;
                break;

        }

        if (file.exists()) file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nameOfimage() {


        if (imagesNotNull_1 == "NotNull") {
            counterImages++;
            finalstIDimage_1 = "a:5:{s:5:\"width\";i:1919;s:6:\"height\";i:940;s:4:\"file\";s:33:\"" + STdateYM + "/" + stIDimage_1
                    + "\";s:5:\"sizes\";a:5:{s:9:\"thumbnail\";a:4:{s:4:\"file\";s:33:\"" + stIDimage_1_150x150 +
                    "\";s:5:\"width\";i:150;s:6:\"height\";i:150;s:9:\"mime-type\";s:9:\"image/png\";}s:32:\"twentyseventeen-thumbnail-avatar\";a:4:{s:4:\"file\";s:33:\""
                    + stIDimage_1_300x300 + "\";s:5:\"width\";i:300;s:6:\"height\";i:300;s:9:\"mime-type\";s:9:\"image/png\";}}s:10:\"image_meta\";a:12:{s:8:\"aperture\";s:1:\"0\";s:6:\"credit\";s:0:\"\";s:6:\"camera\";s:0:\"\";s:7:\"caption\";s:0:\"\";s:17:\"created_timestamp\";s:1:\"0\";s:9:\"copyright\";s:0:\"\";s:12:\"focal_length\";s:1:\"0\";s:3:\"iso\";s:1:\"0\";s:13:\"shutter_speed\";s:1:\"0\";s:5:\"title\";s:0:\"\";s:11:\"orientation\";s:1:\"0\";s:8:\"keywords\";a:0:{}}}";
        }
        if (imagesNotNull_2 == "NotNull") {
            counterImages++;
            finalstIDimage_2 = "a:5:{s:5:\"width\";i:1919;s:6:\"height\";i:940;s:4:\"file\";s:33:\"" + STdateYM + "/" + stIDimage_2
                    + "\";s:5:\"sizes\";a:5:{s:9:\"thumbnail\";a:4:{s:4:\"file\";s:33:\"" + stIDimage_2_150x150 +
                    "\";s:5:\"width\";i:150;s:6:\"height\";i:150;s:9:\"mime-type\";s:9:\"image/png\";}s:32:\"twentyseventeen-thumbnail-avatar\";a:4:{s:4:\"file\";s:33:\""
                    + stIDimage_2_300x300 + "\";s:5:\"width\";i:300;s:6:\"height\";i:300;s:9:\"mime-type\";s:9:\"image/png\";}}s:10:\"image_meta\";a:12:{s:8:\"aperture\";s:1:\"0\";s:6:\"credit\";s:0:\"\";s:6:\"camera\";s:0:\"\";s:7:\"caption\";s:0:\"\";s:17:\"created_timestamp\";s:1:\"0\";s:9:\"copyright\";s:0:\"\";s:12:\"focal_length\";s:1:\"0\";s:3:\"iso\";s:1:\"0\";s:13:\"shutter_speed\";s:1:\"0\";s:5:\"title\";s:0:\"\";s:11:\"orientation\";s:1:\"0\";s:8:\"keywords\";a:0:{}}}";
        }
        if (imagesNotNull_3 == "NotNull") {
            counterImages++;
            finalstIDimage_3 = "a:5:{s:5:\"width\";i:1919;s:6:\"height\";i:940;s:4:\"file\";s:33:\"" + STdateYM + "/" + stIDimage_3
                    + "\";s:5:\"sizes\";a:5:{s:9:\"thumbnail\";a:4:{s:4:\"file\";s:33:\"" + stIDimage_3_150x150 +
                    "\";s:5:\"width\";i:150;s:6:\"height\";i:150;s:9:\"mime-type\";s:9:\"image/png\";}s:32:\"twentyseventeen-thumbnail-avatar\";a:4:{s:4:\"file\";s:33:\""
                    + stIDimage_3_300x300 + "\";s:5:\"width\";i:300;s:6:\"height\";i:300;s:9:\"mime-type\";s:9:\"image/png\";}}s:10:\"image_meta\";a:12:{s:8:\"aperture\";s:1:\"0\";s:6:\"credit\";s:0:\"\";s:6:\"camera\";s:0:\"\";s:7:\"caption\";s:0:\"\";s:17:\"created_timestamp\";s:1:\"0\";s:9:\"copyright\";s:0:\"\";s:12:\"focal_length\";s:1:\"0\";s:3:\"iso\";s:1:\"0\";s:13:\"shutter_speed\";s:1:\"0\";s:5:\"title\";s:0:\"\";s:11:\"orientation\";s:1:\"0\";s:8:\"keywords\";a:0:{}}}";
        }
        if (imagesNotNull_4 == "NotNull") {
            counterImages++;
            finalstIDimage_4 = "a:5:{s:5:\"width\";i:1919;s:6:\"height\";i:940;s:4:\"file\";s:33:\"" + STdateYM + "/" + stIDimage_4
                    + "\";s:5:\"sizes\";a:5:{s:9:\"thumbnail\";a:4:{s:4:\"file\";s:33:\"" + stIDimage_4_150x150 +
                    "\";s:5:\"width\";i:150;s:6:\"height\";i:150;s:9:\"mime-type\";s:9:\"image/png\";}s:32:\"twentyseventeen-thumbnail-avatar\";a:4:{s:4:\"file\";s:33:\""
                    + stIDimage_4_300x300 + "\";s:5:\"width\";i:300;s:6:\"height\";i:300;s:9:\"mime-type\";s:9:\"image/png\";}}s:10:\"image_meta\";a:12:{s:8:\"aperture\";s:1:\"0\";s:6:\"credit\";s:0:\"\";s:6:\"camera\";s:0:\"\";s:7:\"caption\";s:0:\"\";s:17:\"created_timestamp\";s:1:\"0\";s:9:\"copyright\";s:0:\"\";s:12:\"focal_length\";s:1:\"0\";s:3:\"iso\";s:1:\"0\";s:13:\"shutter_speed\";s:1:\"0\";s:5:\"title\";s:0:\"\";s:11:\"orientation\";s:1:\"0\";s:8:\"keywords\";a:0:{}}}";
        }
        if (imagesNotNull_5 == "NotNull") {
            counterImages++;
            finalstIDimage_5 = "a:5:{s:5:\"width\";i:1919;s:6:\"height\";i:940;s:4:\"file\";s:33:\"" + STdateYM + "/" + stIDimage_5
                    + "\";s:5:\"sizes\";a:5:{s:9:\"thumbnail\";a:4:{s:4:\"file\";s:33:\"" + stIDimage_5_150x150 +
                    "\";s:5:\"width\";i:150;s:6:\"height\";i:150;s:9:\"mime-type\";s:9:\"image/png\";}s:32:\"twentyseventeen-thumbnail-avatar\";a:4:{s:4:\"file\";s:33:\""
                    + stIDimage_5_300x300 + "\";s:5:\"width\";i:300;s:6:\"height\";i:300;s:9:\"mime-type\";s:9:\"image/png\";}}s:10:\"image_meta\";a:12:{s:8:\"aperture\";s:1:\"0\";s:6:\"credit\";s:0:\"\";s:6:\"camera\";s:0:\"\";s:7:\"caption\";s:0:\"\";s:17:\"created_timestamp\";s:1:\"0\";s:9:\"copyright\";s:0:\"\";s:12:\"focal_length\";s:1:\"0\";s:3:\"iso\";s:1:\"0\";s:13:\"shutter_speed\";s:1:\"0\";s:5:\"title\";s:0:\"\";s:11:\"orientation\";s:1:\"0\";s:8:\"keywords\";a:0:{}}}";
        }
        if (imagesNotNull_6 == "NotNull") {
            counterImages++;
            finalstIDimage_6 = "a:5:{s:5:\"width\";i:1919;s:6:\"height\";i:940;s:4:\"file\";s:33:\"" + STdateYM + "/" + stIDimage_6
                    + "\";s:5:\"sizes\";a:5:{s:9:\"thumbnail\";a:4:{s:4:\"file\";s:33:\"" + stIDimage_6_150x150 +
                    "\";s:5:\"width\";i:150;s:6:\"height\";i:150;s:9:\"mime-type\";s:9:\"image/png\";}s:32:\"twentyseventeen-thumbnail-avatar\";a:4:{s:4:\"file\";s:33:\""
                    + stIDimage_6_300x300 + "\";s:5:\"width\";i:300;s:6:\"height\";i:300;s:9:\"mime-type\";s:9:\"image/png\";}}s:10:\"image_meta\";a:12:{s:8:\"aperture\";s:1:\"0\";s:6:\"credit\";s:0:\"\";s:6:\"camera\";s:0:\"\";s:7:\"caption\";s:0:\"\";s:17:\"created_timestamp\";s:1:\"0\";s:9:\"copyright\";s:0:\"\";s:12:\"focal_length\";s:1:\"0\";s:3:\"iso\";s:1:\"0\";s:13:\"shutter_speed\";s:1:\"0\";s:5:\"title\";s:0:\"\";s:11:\"orientation\";s:1:\"0\";s:8:\"keywords\";a:0:{}}}";
        }
        if (imagesNotNull_7 == "NotNull") {
            counterImages++;
            finalstIDimage_7 = "a:5:{s:5:\"width\";i:1919;s:6:\"height\";i:940;s:4:\"file\";s:33:\"" + STdateYM + "/" + stIDimage_7
                    + "\";s:5:\"sizes\";a:5:{s:9:\"thumbnail\";a:4:{s:4:\"file\";s:33:\"" + stIDimage_7_150x150 +
                    "\";s:5:\"width\";i:150;s:6:\"height\";i:150;s:9:\"mime-type\";s:9:\"image/png\";}s:32:\"twentyseventeen-thumbnail-avatar\";a:4:{s:4:\"file\";s:33:\""
                    + stIDimage_7_300x300 + "\";s:5:\"width\";i:300;s:6:\"height\";i:300;s:9:\"mime-type\";s:9:\"image/png\";}}s:10:\"image_meta\";a:12:{s:8:\"aperture\";s:1:\"0\";s:6:\"credit\";s:0:\"\";s:6:\"camera\";s:0:\"\";s:7:\"caption\";s:0:\"\";s:17:\"created_timestamp\";s:1:\"0\";s:9:\"copyright\";s:0:\"\";s:12:\"focal_length\";s:1:\"0\";s:3:\"iso\";s:1:\"0\";s:13:\"shutter_speed\";s:1:\"0\";s:5:\"title\";s:0:\"\";s:11:\"orientation\";s:1:\"0\";s:8:\"keywords\";a:0:{}}}";
        }
        if (imagesNotNull_8 == "NotNull") {
            counterImages++;
            finalstIDimage_8 = "a:5:{s:5:\"width\";i:1919;s:6:\"height\";i:940;s:4:\"file\";s:33:\"" + STdateYM + "/" + stIDimage_8
                    + "\";s:5:\"sizes\";a:5:{s:9:\"thumbnail\";a:4:{s:4:\"file\";s:33:\"" + stIDimage_8_150x150 +
                    "\";s:5:\"width\";i:150;s:6:\"height\";i:150;s:9:\"mime-type\";s:9:\"image/png\";}s:32:\"twentyseventeen-thumbnail-avatar\";a:4:{s:4:\"file\";s:33:\""
                    + stIDimage_8_300x300 + "\";s:5:\"width\";i:300;s:6:\"height\";i:300;s:9:\"mime-type\";s:9:\"image/png\";}}s:10:\"image_meta\";a:12:{s:8:\"aperture\";s:1:\"0\";s:6:\"credit\";s:0:\"\";s:6:\"camera\";s:0:\"\";s:7:\"caption\";s:0:\"\";s:17:\"created_timestamp\";s:1:\"0\";s:9:\"copyright\";s:0:\"\";s:12:\"focal_length\";s:1:\"0\";s:3:\"iso\";s:1:\"0\";s:13:\"shutter_speed\";s:1:\"0\";s:5:\"title\";s:0:\"\";s:11:\"orientation\";s:1:\"0\";s:8:\"keywords\";a:0:{}}}";
        }
        if (imagesNotNull_9 == "NotNull") {
            counterImages++;
            finalstIDimage_9 = "a:5:{s:5:\"width\";i:1919;s:6:\"height\";i:940;s:4:\"file\";s:33:\"" + STdateYM + "/" + stIDimage_9
                    + "\";s:5:\"sizes\";a:5:{s:9:\"thumbnail\";a:4:{s:4:\"file\";s:33:\"" + stIDimage_9_150x150 +
                    "\";s:5:\"width\";i:150;s:6:\"height\";i:150;s:9:\"mime-type\";s:9:\"image/png\";}s:32:\"twentyseventeen-thumbnail-avatar\";a:4:{s:4:\"file\";s:33:\""
                    + stIDimage_9_300x300 + "\";s:5:\"width\";i:300;s:6:\"height\";i:300;s:9:\"mime-type\";s:9:\"image/png\";}}s:10:\"image_meta\";a:12:{s:8:\"aperture\";s:1:\"0\";s:6:\"credit\";s:0:\"\";s:6:\"camera\";s:0:\"\";s:7:\"caption\";s:0:\"\";s:17:\"created_timestamp\";s:1:\"0\";s:9:\"copyright\";s:0:\"\";s:12:\"focal_length\";s:1:\"0\";s:3:\"iso\";s:1:\"0\";s:13:\"shutter_speed\";s:1:\"0\";s:5:\"title\";s:0:\"\";s:11:\"orientation\";s:1:\"0\";s:8:\"keywords\";a:0:{}}}";
        }
        if (imagesNotNull_10 == "NotNull") {
            counterImages++;
            finalstIDimage_10 = "a:5:{s:5:\"width\";i:1919;s:6:\"height\";i:940;s:4:\"file\";s:33:\"" + STdateYM + "/" + stIDimage_10
                    + "\";s:5:\"sizes\";a:5:{s:9:\"thumbnail\";a:4:{s:4:\"file\";s:33:\"" + stIDimage_10_150x150 +
                    "\";s:5:\"width\";i:150;s:6:\"height\";i:150;s:9:\"mime-type\";s:9:\"image/png\";}s:32:\"twentyseventeen-thumbnail-avatar\";a:4:{s:4:\"file\";s:33:\""
                    + stIDimage_10_300x300 + "\";s:5:\"width\";i:300;s:6:\"height\";i:300;s:9:\"mime-type\";s:9:\"image/png\";}}s:10:\"image_meta\";a:12:{s:8:\"aperture\";s:1:\"0\";s:6:\"credit\";s:0:\"\";s:6:\"camera\";s:0:\"\";s:7:\"caption\";s:0:\"\";s:17:\"created_timestamp\";s:1:\"0\";s:9:\"copyright\";s:0:\"\";s:12:\"focal_length\";s:1:\"0\";s:3:\"iso\";s:1:\"0\";s:13:\"shutter_speed\";s:1:\"0\";s:5:\"title\";s:0:\"\";s:11:\"orientation\";s:1:\"0\";s:8:\"keywords\";a:0:{}}}";
        }
        counterImages = counterImages * 3;

        //   finalstIDimage_1 = "a:5:{s:5:\"width\";i:602;s:6:\"height\";i:600;s:4:\"file\";s:24:\""+STdateYM + "/" +stIDimage_1
        //         +"\";s:5:\"sizes\";a:3:{s:9:\"thumbnail\";a:4:{s:4:\"file\";s:24:\""+stIDimage_1+
        //         "-150x150.png\";s:5:\"width\";i:150;s:6:\"height\";i:150;s:9:\"mime-type\";s:9:\"image/png\";}s:6:\"medium\";a:4:{s:4:\"file\";s:24:\""+stIDimage_1+
        //       "-300x300.png\";s:5:\"width\";i:300;s:6:\"height\";i:300;s:9:\"mime-type\";s:9:\"image/png\";}s:32:\"twentyseventeen-thumbnail-avatar\";}s:10:\"image_meta\";a:12:{s:8:\"aperture\";s:1:\"0\";s:6:\"credit\";s:0:\"\";s:6:\"camera\";s:0:\"\";s:7:\"caption\";s:0:\"\";s:17:\"created_timestamp\";s:1:\"0\";s:9:\"copyright\";s:0:\"\";s:12:\"focal_length\";s:1:\"0\";s:3:\"iso\";s:1:\"0\";s:13:\"shutter_speed\";s:1:\"0\";s:5:\"title\";s:0:\"\";s:11:\"orientation\";s:1:\"0\";s:8:\"keywords\";a:0:{}}}";

    }



/*
                        AlertDialog.Builder builder_popUp = new AlertDialog.Builder(Main26Activity.this);
                        LinearLayout linearLayout_popUp = (LinearLayout) getLayoutInflater().inflate(R.layout.pop_up_page, null, false);

                        builder_popUp.setView(linearLayout_popUp);
                        pop_up_page = builder_popUp.create();
                        pop_up_page.show();
----------------------------------------------------------------------------------------------




 */



}