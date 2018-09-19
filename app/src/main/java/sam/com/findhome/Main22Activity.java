package sam.com.findhome;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//import com.squareup.picasso.Picasso;

public class Main22Activity extends AppCompatActivity {


    public static String dataServerWating = "";
    JSONArray jsonArray = null;

    ListView listView_waiting;
    ImageView imageView_NothingToShowWating;

    Button edit_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);

        new Connect2("http://padintarh.ir/Android/show_wating.php", 0, "").execute();
        new Connect2("http://padintarh.ir/Android/show_wating.php", 0, "").execute();

        listView_waiting = (ListView) findViewById(R.id.listView_waiting);
        imageView_NothingToShowWating = (ImageView) findViewById(R.id.imageView_NothingToShowWating);

        TextView textView2123123 = (TextView) findViewById(R.id.textView2123123);
        textView2123123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Connect2("http://padintarh.ir/Android/show_wating.php", 0, "").execute();
                new Connect2("http://padintarh.ir/Android/show_wating.php", 0, "").execute();
                Getjsonarray2();
                Toast.makeText(Main22Activity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void Getjsonarray2() {
        try {
            String dataServer2 = dataServerWating;
            jsonArray = new JSONArray(dataServer2);

            ArrayList<product> products = new ArrayList<product>();

            ProductAdapter2 adapter = new ProductAdapter2(Main22Activity.this, R.layout.listview_mainpage, products);
            listView_waiting.setAdapter(adapter);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                int ID = jsonObject1.getInt("ID");
                String title = jsonObject1.getString("post_title");
                String matn = jsonObject1.getString("post_content");
                String image = jsonObject1.getString("image");
                String guid = jsonObject1.getString("guid");
                imageView_NothingToShowWating.setVisibility(View.GONE);
                listView_waiting.setVisibility(View.VISIBLE);
                products.add(new product(ID, title, matn, image, guid));
                adapter.notifyDataSetChanged();

//set again adapter!
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
            edit_list = (Button) view.findViewById(R.id.edit_list);


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


                    Intent intent = new Intent(Main22Activity.this, Main24Activity.class);
                    int ID_send = product.ID;

                    intent.putExtra("ID_send123", ID_send);
                    startActivity(intent);
                }
            });
            Button share_list = (Button) view.findViewById(R.id.share_list);
            share_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, product.guid);
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "عنوان");
                    startActivity(Intent.createChooser(shareIntent, "Share..."));
                }
            });

            edit_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent intent = new Intent(Main22Activity.this, Main2Activity.class);
                    int ID_send = product.ID;

                    intent.putExtra("ID_send123", ID_send);
                    startActivity(intent);

                }
            });


            return view;
        }
    }
}
