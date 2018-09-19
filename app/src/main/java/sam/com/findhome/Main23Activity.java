package sam.com.findhome;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//import com.squareup.picasso.Picasso;

public class Main23Activity extends AppCompatActivity {

    private String[] String_noe_malekati = {"انتخاب کنید", "سند رسمی(قطعی)", "قولنامه ای", "وکالتی", "مبایعه نامه ای", "قراردادی", "بنچاق", "صلح نامه", "زمین شهری", "برگه حاک شرع", "اوقاف", "سازمانی", "تعاونی", "بنیاد شهید", "شهرداری", "صنایع دفاع", "نامشخص"};

    RadioButton radioButton;
    EditText editTextMAXmasahatZamin_search, editTextMINmasahatZamin_search, editTextMAXMasahatBuild_search, editTextMINMasahatBuild_search, editTextMAXPrice_serach, editTextMINPrice_serach;
    RadioGroup radioGP_search_1, radioGP_search_2;

    int
            editTextMAXmasahatZamin_searchST = 0,
            editTextMINmasahatZamin_searchST = 0,
            editTextMAXMasahatBuild_searchST = 0,
            editTextMINMasahatBuild_searchST = 0,
            editTextMAXPrice_serachST = 0,
            editTextMINPrice_serachST = 0;

    public static String dataServer123123 = "";

    CheckBox checkBoxABC1, checkBoxABC2, checkBoxABC3,checkBox_moamele, checkBox_melk, checkBox_spinner;

    JSONArray jsonArray = null;
    ListView listView_get_DATA2;
    ImageView imageView_NothingToShow2;

    String masahatZamin = "n", asahatBuild = "n", priceABC = "n";

    String   TEXTcheckBox_moamele,TEXTcheckBox_melk,TEXTcheckBox_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);

        ArrayAdapter arrayAdapter_pish_sell_mizan = new ArrayAdapter(Main23Activity.this, android.R.layout.simple_spinner_item, String_noe_malekati);
        arrayAdapter_pish_sell_mizan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner_search = (Spinner) findViewById(R.id.spinner_search);
        spinner_search.setAdapter(arrayAdapter_pish_sell_mizan);

        //  new Connect3("http://padintarh.ir/Android/show_search.php", 0, 0, 0, 0, 0, 0).execute();
        //  new Connect3("http://padintarh.ir/Android/show_search.php", 0, 0, 0, 0, 0, 0).execute();

        editTextMAXmasahatZamin_search = (EditText) findViewById(R.id.editTextMAXmasahatZamin_search);
        editTextMINmasahatZamin_search = (EditText) findViewById(R.id.editTextMINmasahatZamin_search);
        editTextMAXMasahatBuild_search = (EditText) findViewById(R.id.editTextMAXMasahatBuild_search);
        editTextMINMasahatBuild_search = (EditText) findViewById(R.id.editTextMINMasahatBuild_search);
        editTextMAXPrice_serach = (EditText) findViewById(R.id.editTextMAXPrice_serach);
        editTextMINPrice_serach = (EditText) findViewById(R.id.editTextMINPrice_serach);


        radioGP_search_1 = (RadioGroup) findViewById(R.id.radioGP_search_1);
        radioGP_search_2 = (RadioGroup) findViewById(R.id.radioGP_search_2);


        checkBoxABC1 = (CheckBox) findViewById(R.id.checkBoxABC1);
        checkBoxABC2 = (CheckBox) findViewById(R.id.checkBoxABC2);
        checkBoxABC3 = (CheckBox) findViewById(R.id.checkBoxABC3);
        checkBox_moamele = (CheckBox) findViewById(R.id.checkBox_moamele);
        checkBox_melk = (CheckBox) findViewById(R.id.checkBox_melk);
        checkBox_spinner = (CheckBox) findViewById(R.id.checkBox_spinner);


        checkBox_moamele.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox_moamele.isChecked() == true) {
                    radioGP_search_1.setEnabled(false);
                    TEXTcheckBox_moamele = "n";
                } else {
                    radioGP_search_1.setEnabled(true);
                    TEXTcheckBox_moamele = "y";
                }
            }
        });

        checkBox_melk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox_melk.isChecked() == true) {
                    radioGP_search_1.setEnabled(false);
                    TEXTcheckBox_melk = "n";
                } else {
                    radioGP_search_1.setEnabled(true);
                    TEXTcheckBox_melk = "y";
                }
            }
        });

        checkBox_spinner.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox_spinner.isChecked() == true) {
                    radioGP_search_1.setEnabled(false);
                    TEXTcheckBox_spinner = "n";
                } else {
                    radioGP_search_1.setEnabled(true);
                    TEXTcheckBox_spinner = "y";
                }
            }
        });





        checkBoxABC1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBoxABC1.isChecked() == true) {
                    editTextMAXmasahatZamin_search.setEnabled(false);
                    editTextMINmasahatZamin_search.setEnabled(false);
                    masahatZamin = "n";
                } else {
                    editTextMAXmasahatZamin_search.setEnabled(true);
                    editTextMINmasahatZamin_search.setEnabled(true);
                    masahatZamin = "y";
                }
            }
        });

        checkBoxABC2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBoxABC2.isChecked() == true) {
                    editTextMAXMasahatBuild_search.setEnabled(false);
                    editTextMINMasahatBuild_search.setEnabled(false);
                    asahatBuild = "n";
                } else {
                    editTextMAXMasahatBuild_search.setEnabled(true);
                    editTextMINMasahatBuild_search.setEnabled(true);
                    asahatBuild = "y";
                }
            }
        });

        checkBoxABC3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBoxABC3.isChecked() == true) {
                    editTextMAXPrice_serach.setEnabled(false);
                    editTextMINPrice_serach.setEnabled(false);
                    priceABC = "n";
                } else {
                    editTextMAXPrice_serach.setEnabled(true);
                    editTextMINPrice_serach.setEnabled(true);
                    priceABC = "y";
                }
            }
        });

        Button button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView_NothingToShow2.setVisibility(View.VISIBLE);










                if (checkBoxABC1.isChecked() == false) {
                    editTextMAXmasahatZamin_searchST = Integer.parseInt(editTextMAXmasahatZamin_search.getText().toString());
                    editTextMINmasahatZamin_searchST = Integer.parseInt(editTextMINmasahatZamin_search.getText().toString());
                    masahatZamin = "y";
                }
                if (checkBoxABC2.isChecked() == false) {
                    editTextMAXMasahatBuild_searchST = Integer.parseInt(editTextMAXMasahatBuild_search.getText().toString());
                    editTextMINMasahatBuild_searchST = Integer.parseInt(editTextMINMasahatBuild_search.getText().toString());
                    asahatBuild = "y";
                }
                if (checkBoxABC2.isChecked() == false) {
                    editTextMAXPrice_serachST = Integer.parseInt(editTextMAXPrice_serach.getText().toString());
                    editTextMINPrice_serachST = Integer.parseInt(editTextMINPrice_serach.getText().toString());
                    priceABC = "y";
                }


                new Connect3("http://padintarh.ir/Android/show_search.php",
                        editTextMAXPrice_serachST, editTextMINPrice_serachST,editTextMAXmasahatZamin_searchST,editTextMINmasahatZamin_searchST,
                        editTextMAXMasahatBuild_searchST,editTextMINMasahatBuild_searchST,masahatZamin,asahatBuild,priceABC).execute();


                Toast.makeText(Main23Activity.this, "" + dataServer123123, Toast.LENGTH_SHORT).show();
                Getjsonarray2();






/*
                int selectedId = radioGP_search_1.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
*/

                //       Toast.makeText(Main23Activity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();


            }
        });

        imageView_NothingToShow2 = (ImageView) findViewById(R.id.imageView_NothingToShow2);


        listView_get_DATA2 = (ListView) findViewById(R.id.listView_get_DATA2);
    }

    public void Getjsonarray2() {
        try {
            String dataServer1232 = dataServer123123;
            jsonArray = new JSONArray(dataServer1232);
            ArrayList<product> products = new ArrayList<product>();
            ProductAdapter2 adapter = new ProductAdapter2(Main23Activity.this, R.layout.listview_mainpage, products);
            listView_get_DATA2.setAdapter(adapter);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                int ID = jsonObject1.getInt("ID");
                String title = jsonObject1.getString("post_title");
                String matn = jsonObject1.getString("post_content");
                String image = jsonObject1.getString("image");
                String guid = jsonObject1.getString("guid");
                imageView_NothingToShow2.setVisibility(View.GONE);
                listView_get_DATA2.setVisibility(View.VISIBLE);
                products.add(new product(ID, title, matn, image,guid));
                adapter.notifyDataSetChanged();

//set again adapter!
            }

            if (jsonArray.length() == 0) {
                imageView_NothingToShow2.setVisibility(View.VISIBLE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public class ProductAdapter2 extends ArrayAdapter {


        private int resourceId;
        private Activity activity;
        private ArrayList<product> productArrayList;

        public ProductAdapter2(Activity activity, int resourceId, ArrayList<product> object) {
            super(activity, resourceId, object);
            this.activity = activity;
            this.resourceId = resourceId;
            this.productArrayList = object;
        }

        @Override
        public View getView(final int position, View converView, ViewGroup parent) {
            View view = converView;
            view = this.activity.getLayoutInflater().inflate(this.resourceId, null);

            TextView onvan_list = (TextView) view.findViewById(R.id.onvan_list);
            TextView matn_list = (TextView) view.findViewById(R.id.matn_list);
            final TextView codMelk_list = (TextView) view.findViewById(R.id.codMelk_list);
            TextView textViewABCD = (TextView) view.findViewById(R.id.textViewABCD);
            ImageView image_list = (ImageView) view.findViewById(R.id.image_list);
            final product product = productArrayList.get(position);

            String str = product.matn;
            String[] splited = str.split("\\s+");
            String abc123 = "";
            for (int i = 0; i < 1; i++) {
                abc123 = abc123 + " " + splited[i];
            }

            codMelk_list.setText("کد ملک: " + product.ID);
            onvan_list.setText(product.title);
            matn_list.setText(abc123 + "...");
            textViewABCD.setText(product.ID + "");
            String abc = product.image;
//            Picasso.with(getContext()).load(abc).resize(120, 140).into(image_list);


            Button showpost_list = (Button) view.findViewById(R.id.showpost_list);
            showpost_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent intent = new Intent(Main23Activity.this, Main24Activity.class);
                    int ID_send = product.ID;
                    intent.putExtra("ID_send123", ID_send);
                    startActivity(intent);
                }
            });




            return view;
        }


    }


}

