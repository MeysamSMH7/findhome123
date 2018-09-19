package sam.com.findhome;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ViewUtils;
import android.text.method.DateTimeKeyListener;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

//import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {


    AlertDialog login_page;
    String all;
    public static String dataServer = "";
    public static String dataServerlogin = "";

    JSONArray jsonArray = null;

    ImageView imageView_NothingToShow;

    EditText onvan;
    CheckBox entekhab, entekhabdo, entekhabse, entekhabch;
    int a = 0;
    int i = 0;
    int s = 10;
    String Vulue;
    String entekhabST = "", entekhabdoST = "", entekhabseST = "", entekhabchST = "";
    int counter = 0;

    int[] ints;
    ListView listView_get_DATA;
    Button button_get_data;

    Button edit_list;

    ArrayList<Integer> ints2 = new ArrayList<Integer>();

    String passWordLogin = "";
    String userWordLogin = "";
    String optionValue = "";

    ImageView imageView2;
    EditText editText2;
    String picturePath = "";
    File filetakePic = null;
    String filetakePic2;

    TextView textView3;

    int maxBufferSize = 1 * 1024 * 1024;
    int serverResponseCode = 0;
    ProgressDialog dialog = null;
    DataOutputStream dos = null;
    HttpURLConnection conn = null;
    String upLoadServerUri = "http://padintarh.ir/Android/uploadImage.php";
    int witchPic = 0;
    Bitmap thumbnail123123;

    Button takePic_finhome_1, takePic_finhome_2, takePic_finhome_3, takePic_finhome_4, takePic_finhome_5, takePic_finhome_6, takePic_finhome_7, takePic_finhome_8, takePic_finhome_9, takePic_finhome_10;
    ImageView imgTakePic_1, imgTakePic_2, imgTakePic_3, imgTakePic_4, imgTakePic_5, imgTakePic_6, imgTakePic_7, imgTakePic_8, imgTakePic_9, imgTakePic_10;
    String str_1tp, str_2tp, str_3tp, str_4tp, str_5tp, str_6tp, str_7tp, str_8tp, str_9tp, str_10tp;
    String str_1cg, str_2cg, str_3cg, str_4cg, str_5cg, str_6cg, str_7cg, str_8cg, str_9cg, str_10cg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateYM = new SimpleDateFormat("yyyy/MM");
        String STdateYM = dateYM.format(date);


        button_get_data = (Button) findViewById(R.id.button_get_data);


        textView3 = (TextView) findViewById(R.id.textView3);
        Calendar calendar = Calendar.getInstance();

        int thisYear = calendar.get(Calendar.YEAR);
        int thisMonth = calendar.get(Calendar.MONTH);
        int thisDay = calendar.get(Calendar.DAY_OF_MONTH);
        int thisHOUR = calendar.get(Calendar.HOUR);
        int thisMINUTE = calendar.get(Calendar.MINUTE);
        int thisSECOND = calendar.get(Calendar.SECOND);

        all = thisYear + "-" + thisMonth + "-" + thisDay + " " + thisHOUR + ":" + thisMINUTE + ":" + thisSECOND;
        //  textView3.setText(all);


        Button button3123 = (Button) findViewById(R.id.button3123);
        button3123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent2);
                Toast.makeText(MainActivity.this, all+"", Toast.LENGTH_SHORT).show();
            }
        });
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main22Activity.class);
                startActivity(intent);
            }
        });
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main23Activity.class);
                startActivity(intent);
            }
        });


        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder_loGin = new AlertDialog.Builder(MainActivity.this);
                LinearLayout linearLayout_loGin = (LinearLayout) getLayoutInflater().inflate(R.layout.login_page, null, false);
                final EditText userlogin = (EditText) linearLayout_loGin.findViewById(R.id.userlogin);
                final EditText passlogin = (EditText) linearLayout_loGin.findViewById(R.id.passlogin);
                Button btn_dismis = (Button) linearLayout_loGin.findViewById(R.id.btn_dismis);
                Button btn_login = (Button) linearLayout_loGin.findViewById(R.id.btn_login);
                btn_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        passWordLogin = passlogin.getText().toString();
                        userWordLogin = userlogin.getText().toString();

                        new Connect5("http://padintarh.ir/Android/loginAnroid.php", userWordLogin).execute();

                        GetjsonarrayLogin();
                        GetjsonarrayLogin();
                    }
                });
                btn_dismis.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "انصراف", Toast.LENGTH_SHORT).show();
                        login_page.dismiss();
                    }
                });
                builder_loGin.setView(linearLayout_loGin);
                login_page = builder_loGin.create();
                login_page.show();


            }
        });
        onvan = (EditText) findViewById(R.id.onvan);
        //      matn = (EditText) findViewById(R.id.matn);

        entekhab = (CheckBox) findViewById(R.id.entekhab);
        entekhabdo = (CheckBox) findViewById(R.id.entekhabdo);
        entekhabse = (CheckBox) findViewById(R.id.entekhabse);
        entekhabch = (CheckBox) findViewById(R.id.entekhabch);


        entekhab.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (entekhab.isChecked() == true) {
                    counter++;
                    entekhabST = "NotNULL";
                } else {
                    counter--;
                    entekhabST = "";
                }


            }
        });

        entekhabdo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (entekhabdo.isChecked() == true) {
                    counter++;
                    entekhabdoST = "NotNULL";
                } else {
                    counter--;
                    entekhabdoST = "";
                }


            }
        });

        entekhabse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (entekhabse.isChecked() == true) {
                    counter++;
                    entekhabseST = "NotNULL";
                } else {
                    counter--;
                    entekhabseST = "";
                }

            }
        });

        entekhabch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (entekhabch.isChecked() == true) {
                    counter++;
                    entekhabchST = "NotNULL";
                } else {
                    counter--;
                    entekhabchST = "";
                }


            }
        });


        final Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String onvanST = onvan.getText().toString();
                //  String matnST = matn.getText().toString();
                String titleST = onvanST.replaceAll(" ", "-");


                String encodeURL = null;
                try {
                    encodeURL = URLEncoder.encode(onvanST, "UTF-8");
                } catch (UnsupportedEncodingException e) {

                }

                //   textView3.setText(encodeURL);
                onvan.setText(encodeURL);


                Vulue = "a:" + counter + ":{";


                if (entekhabST == "NotNULL" || entekhabdoST == "NotNULL") {


                    if (entekhabST == "NotNULL") {
                        i++;
                        entekhabST = "i:" + i + ";s:" + s + ":" + "\"entekhabST\"" + ";";
                        Vulue = Vulue + entekhabST;
                    }


                }


                i = 0;
                s = 10;


                Vulue = "a:" + counter + ":{i:0;s:8:" + "\"maskoni\"" + ";";


                s = 10;
                //  entekhabST, entekhabdoST, entekhabseST, entekhabchST


                if (entekhabST == "NotNULL") {
                    i++;
                    entekhabST = "i:" + i + ";s:" + s + ":" + "\"entekhabST\"" + ";";
                    Vulue = Vulue + entekhabST;
                }

                if (entekhabdoST == "NotNULL") {
                    i++;
                    entekhabdoST = "i:" + i + ";s:" + s + ":" + "\"entekhabdoST\"" + ";";
                    Vulue = Vulue + entekhabdoST;
                }

                if (entekhabseST == "NotNULL") {
                    i++;
                    entekhabseST = "i:" + i + ";s:" + s + ":" + "\"entekhabseST\"" + ";";
                    Vulue = Vulue + entekhabseST;
                }

                if (entekhabchST == "NotNULL") {
                    i++;
                    entekhabchST = "i:" + i + ";s:" + s + ":" + "\"entekhabch\"" + ";";
                    Vulue = Vulue + entekhabchST;
                }


                Vulue = Vulue + "}";
                //     textView3.setText(counter + "\n" + Vulue);

/*
                new Connect("http://padintarh.ir/Android/insert_to_wp_post.php", matnST, onvanST, titleST, "barchasb_zamine", Vulue).execute();

                try {
                    jsonObject = new JSONObject(dataServer);
                } catch (JSONException e) {
                }

*/


                /*
 اینجا حتما باید یه الردیالوگ باشه
یکی از گزینه ها آیا میخوای ارسال کنی
یکی دیگه لغو
کنسل کردن هم فقط باید لغو رو بزنه
یعنی ست کنسلش باید فعال باشه
وقتی روی لغو زد کل والیو پاک بشه
تا به ارور نخوره
اگر ارسال رو هم زد که ارسال بشه و
 بعدش همه چیز خالی بشه
                 */


                Toast.makeText(MainActivity.this, "sent", Toast.LENGTH_SHORT).show();
            }
        });


        new Connect2("http://padintarh.ir/Android/show.php", 0, "").execute();
        new Connect2("http://padintarh.ir/Android/show.php", 0, "").execute();
        imageView_NothingToShow = (ImageView) findViewById(R.id.imageView_NothingToShow);


        listView_get_DATA = (ListView) findViewById(R.id.listView_get_DATA);

        /*
        listView_get_DATA.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == ints2.get(position)) {
                    int add;
                    add = ints[position];
                    Toast.makeText(MainActivity.this, add+"", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
*/

        button_get_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = "Hello I'm";
                String[] splited = str.split("\\s+");
                Toast.makeText(MainActivity.this, str.length() + "", Toast.LENGTH_SHORT).show();
                textView3.setText(splited[1] + "");
                String abc123 = "";
                for (int i = 0; i < 2; i++) {
                    abc123 = abc123 + " " + splited[i];
                }


                new Connect2("http://padintarh.ir/Android/show.php", 0, "").execute();
                new Connect2("http://padintarh.ir/Android/show.php", 0, "").execute();

                // Getjsonarray();
                Getjsonarray2();

            }
        });

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


        //    ImageView imgTakePic_1, imgTakePic_2, imgTakePic_3, imgTakePic_4, imgTakePic_5, imgTakePic_6, imgTakePic_7, imgTakePic_8, imgTakePic_9, imgTakePic_10;
        //   String str_1tp, str_2tp, str_3tp, str_4tp, str_5tp, str_6tp, str_7tp, str_8tp, str_9tp, str_10tp;
        //     String str_1cg, str_2cg, str_3cg, str_4cg, str_5cg, str_6cg, str_7cg, str_8cg, str_9cg, str_10cg;


        imageView2 = (ImageView) findViewById(R.id.imageView2);
        Button button14 = (Button) findViewById(R.id.button14);
        Button button15 = (Button) findViewById(R.id.button15);
        editText2 = (EditText) findViewById(R.id.editText2);

        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_1tp = "";
                str_1cg = "";
                AlertDialogTakePic();
            }
        });

/*

        takePic_finhome_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_1tp = "";
                str_1cg = "";
                AlertDialogTakePic();
            }
        });

        takePic_finhome_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_2tp = "";
                str_2cg = "";
                AlertDialogTakePic();
            }
        });

        takePic_finhome_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_3tp = "";
                str_3cg = "";
                AlertDialogTakePic();
            }
        });

        takePic_finhome_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_4tp = "";
                str_4cg = "";
                AlertDialogTakePic();
            }
        });

        takePic_finhome_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_5tp = "";
                str_5cg = "";
                AlertDialogTakePic();
            }
        });

        takePic_finhome_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_6tp = "";
                str_6cg = "";
                AlertDialogTakePic();
            }
        });

        takePic_finhome_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_7tp = "";
                str_7cg = "";
                AlertDialogTakePic();
            }
        });

        takePic_finhome_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_8tp = "";
                str_8cg = "";
                AlertDialogTakePic();
            }
        });

        takePic_finhome_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_9tp = "";
                str_9cg = "";
                AlertDialogTakePic();
            }
        });

        takePic_finhome_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_10tp = "";
                str_10cg = "";
                AlertDialogTakePic();
            }
        });


*/


        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (filetakePic2 != null) {


                    //  Toast.makeText(MainActivity.this, "اپلود عکس از دوربین", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, filetakePic2 + "", Toast.LENGTH_SHORT).show();

                    dialog = ProgressDialog.show(MainActivity.this, "", "Uploading file...", true);
                    new Thread(new Runnable() {
                        public void run() {
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    textView3.setText("uploading started.....");
                                }
                            });
                            uploadFile(filetakePic2);
                        }
                    }).start();


                } else if (picturePath != "") {
                    //   Toast.makeText(MainActivity.this, "اپلود عکس از گالری", Toast.LENGTH_SHORT).show();

                    dialog = ProgressDialog.show(MainActivity.this, "", "Uploading file...", true);
                    new Thread(new Runnable() {
                        public void run() {
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    textView3.setText("uploading started.....");
                                }
                            });
                            uploadFile(picturePath);
                        }
                    }).start();
                } else {
                    Toast.makeText(MainActivity.this, "هیچی", Toast.LENGTH_SHORT).show();
                }


            }
        });


        Button button13 = (Button) findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                String a = editText2.getText().toString();

                String b = a.replace("\n", ",");

                editText2.setText(b + "");


                Toast.makeText(MainActivity.this, "a", Toast.LENGTH_SHORT).show();


            }
        });


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
            String sb1 = "a" + sb;
            String s = sb1 + ".png";
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

    public int uploadFile(final String sourceFileUri) {

        String fileName = sourceFileUri;
        HttpURLConnection conn = null;
        DataOutputStream dos = null;
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";
        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1 * 1024 * 1024;
        File sourceFile = new File(sourceFileUri);

        if (!sourceFile.isFile()) {

            dialog.dismiss();

            Log.e("uploadFile", "Source File not exist :"
                    + sourceFileUri);

            runOnUiThread(new Runnable() {
                public void run() {
                    textView3.setText("Source File not exist :" + sourceFileUri);
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
                            String msg = "File Upload Completed.";
                            textView3.setText(msg);
                            Toast.makeText(MainActivity.this, "File Upload Complete.", Toast.LENGTH_SHORT).show();
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
                        textView3.setText("MalformedURLException Exception : check script url.");
                        Toast.makeText(MainActivity.this, "MalformedURLException",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                Log.e("Upload file to server", "error: " + ex.getMessage(), ex);
            } catch (Exception e) {
                dialog.dismiss();
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    public void run() {
                        textView3.setText("Got Exception : see logcat ");
                        Toast.makeText(MainActivity.this, "Got Exception : see logcat ", Toast.LENGTH_SHORT).show();
                    }
                });
                Log.e("Upload file to server Exception", "Exception : " + e.getMessage(), e);
            }
            dialog.dismiss();
            return serverResponseCode;

        } // End else block
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

                filetakePic2 = c.getString(columnIndex);
                imageView2.setImageBitmap(thumbnail);
                decodeFile(filetakePic2, 860, 1024);

                switch (witchPic) {
                    case 1:
                        imgTakePic_1.setImageBitmap(thumbnail);
                        str_1tp = c.getString(columnIndex);
                        decodeFile(str_1tp, 860, 1024);
                        break;
                    case 2:
                        imgTakePic_2.setImageBitmap(thumbnail);
                        str_2tp = c.getString(columnIndex);
                        decodeFile(str_2tp, 860, 1024);
                        break;
                    case 3:
                        imgTakePic_3.setImageBitmap(thumbnail);
                        str_3tp = c.getString(columnIndex);
                        decodeFile(str_3tp, 860, 1024);
                        break;
                    case 4:
                        imgTakePic_4.setImageBitmap(thumbnail);
                        str_4tp = c.getString(columnIndex);
                        decodeFile(str_4tp, 860, 1024);
                        break;
                    case 5:
                        imgTakePic_5.setImageBitmap(thumbnail);
                        str_5tp = c.getString(columnIndex);
                        decodeFile(str_5tp, 860, 1024);
                        break;
                    case 6:
                        imgTakePic_6.setImageBitmap(thumbnail);
                        str_6tp = c.getString(columnIndex);
                        decodeFile(str_6tp, 860, 1024);
                        break;
                    case 7:
                        imgTakePic_7.setImageBitmap(thumbnail);
                        str_7tp = c.getString(columnIndex);
                        decodeFile(str_7tp, 860, 1024);
                        break;
                    case 8:
                        imgTakePic_8.setImageBitmap(thumbnail);
                        str_8tp = c.getString(columnIndex);
                        decodeFile(str_8tp, 860, 1024);
                        break;
                    case 9:
                        imgTakePic_9.setImageBitmap(thumbnail);
                        str_9tp = c.getString(columnIndex);
                        decodeFile(str_9tp, 860, 1024);
                        break;
                    case 10:
                        imgTakePic_10.setImageBitmap(thumbnail);
                        str_10tp = c.getString(columnIndex);
                        decodeFile(str_10tp, 860, 1024);
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

                picturePath = c.getString(columnIndex);
                thumbnail123123 = (BitmapFactory.decodeFile(picturePath));
                decodeFile(picturePath, 860, 1024);
                imageView2.setImageBitmap(thumbnail123123);

                switch (witchPic) {
                    case 1:
                        str_1cg = c.getString(columnIndex);
                        thumbnail123123 = (BitmapFactory.decodeFile(str_1cg));
                        decodeFile(str_1cg, 860, 1024);
                        imgTakePic_1.setImageBitmap(thumbnail123123);
                        break;
                    case 2:
                        str_2cg = c.getString(columnIndex);
                        thumbnail123123 = (BitmapFactory.decodeFile(str_2cg));
                        decodeFile(str_2cg, 860, 1024);
                        imgTakePic_2.setImageBitmap(thumbnail123123);
                        break;
                    case 3:
                        str_3cg = c.getString(columnIndex);
                        thumbnail123123 = (BitmapFactory.decodeFile(str_3cg));
                        decodeFile(str_3cg, 860, 1024);
                        imgTakePic_3.setImageBitmap(thumbnail123123);
                        break;
                    case 4:
                        str_4cg = c.getString(columnIndex);
                        thumbnail123123 = (BitmapFactory.decodeFile(str_4cg));
                        decodeFile(str_4cg, 860, 1024);
                        imgTakePic_4.setImageBitmap(thumbnail123123);
                        break;
                    case 5:
                        str_5cg = c.getString(columnIndex);
                        thumbnail123123 = (BitmapFactory.decodeFile(str_5cg));
                        decodeFile(str_5cg, 860, 1024);
                        imgTakePic_5.setImageBitmap(thumbnail123123);
                        break;
                    case 6:
                        str_6cg = c.getString(columnIndex);
                        thumbnail123123 = (BitmapFactory.decodeFile(str_6cg));
                        decodeFile(str_6cg, 860, 1024);
                        imgTakePic_6.setImageBitmap(thumbnail123123);
                        break;
                    case 7:
                        str_7cg = c.getString(columnIndex);
                        thumbnail123123 = (BitmapFactory.decodeFile(str_7cg));
                        decodeFile(str_7cg, 860, 1024);
                        imgTakePic_7.setImageBitmap(thumbnail123123);
                        break;
                    case 8:
                        str_8cg = c.getString(columnIndex);
                        thumbnail123123 = (BitmapFactory.decodeFile(str_8cg));
                        decodeFile(str_8cg, 860, 1024);
                        imgTakePic_8.setImageBitmap(thumbnail123123);
                        break;
                    case 9:
                        str_9cg = c.getString(columnIndex);
                        thumbnail123123 = (BitmapFactory.decodeFile(str_9cg));
                        decodeFile(str_9cg, 860, 1024);
                        imgTakePic_9.setImageBitmap(thumbnail123123);
                        break;
                    case 10:
                        str_10cg = c.getString(columnIndex);
                        thumbnail123123 = (BitmapFactory.decodeFile(str_10cg));
                        decodeFile(str_10cg, 860, 1024);
                        imgTakePic_10.setImageBitmap(thumbnail123123);
                        break;
                }
                c.close();
            }
        }
    }

    public void AlertDialogTakePic() {

        final CharSequence[] options = {"عکس گرفتن", "انتخاب از گالری", "بستن"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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


    public void GetjsonarrayLogin() {
        try {
            String dataServer2 = dataServerlogin;
            jsonArray = new JSONArray(dataServer2);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                optionValue = jsonObject1.getString("userName");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        if (optionValue.compareTo(passWordLogin) == 0) {
            Toast.makeText(MainActivity.this, "Hello " + userWordLogin + "!", Toast.LENGTH_SHORT).show();
            login_page.dismiss();
        } else {
            Toast.makeText(MainActivity.this, "Try again", Toast.LENGTH_SHORT).show();
        }


    }

    public void Getjsonarray2() {
        try {
            String dataServer2 = dataServer;
            jsonArray = new JSONArray(dataServer2);

            ArrayList<product> products = new ArrayList<product>();

            ProductAdapter2 adapter = new ProductAdapter2(MainActivity.this, R.layout.listview_mainpage, products);
            listView_get_DATA.setAdapter(adapter);

            for (int i = 0; i <= jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                int ID = jsonObject1.getInt("ID");
                ints2.add(ID);
                String title = jsonObject1.getString("post_title");
                String matn = jsonObject1.getString("post_content");
                String image = jsonObject1.getString("image");
                String guid = jsonObject1.getString("guid");
                imageView_NothingToShow.setVisibility(View.GONE);
                listView_get_DATA.setVisibility(View.VISIBLE);
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
        /*
        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        TextView textView1 = (TextView) view.findViewById(R.id.textView1);
        TextView textView2 = (TextView) view.findViewById(R.id.textView2);
        TextView textView3 = (TextView) view.findViewById(R.id.textView3);
*/
            TextView onvan_list = (TextView) view.findViewById(R.id.onvan_list);
            TextView matn_list = (TextView) view.findViewById(R.id.matn_list);
            final TextView codMelk_list = (TextView) view.findViewById(R.id.codMelk_list);
            TextView textViewABCD = (TextView) view.findViewById(R.id.textViewABCD);
            ImageView image_list = (ImageView) view.findViewById(R.id.image_list);
            edit_list = (Button) view.findViewById(R.id.edit_list);
            Button buttonDelete_list = (Button) view.findViewById(R.id.buttonDelete_list);


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


                    Intent intent = new Intent(MainActivity.this, Main24Activity.class);
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


                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    int ID_send = product.ID;

                    intent.putExtra("ID_send123", ID_send);
                    startActivity(intent);

                }
            });

            buttonDelete_list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int a = product.ID;
                    new Connect4("http://padintarh.ir/Android/trash.php", a).execute();
                    Getjsonarray2();
                }
            });
            return view;
        }


    }

}
    /*
        public void Getjsonarray() {
            try {
                String dataServer2 = dataServer;
                jsonArray = new JSONArray(dataServer2);

                ArrayList<product> products = new ArrayList<product>();

                listView_get_DATA.setAdapter(adapter);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    int ID = jsonObject1.getInt("ID");
                    ints2.add(ID);
                    String title = jsonObject1.getString("post_title");
                    String matn = jsonObject1.getString("post_content");
                    String image = jsonObject1.getString("image");
                    imageView_NothingToShow.setVisibility(View.GONE);
                    listView_get_DATA.setVisibility(View.VISIBLE);
                    products.add(new product(ID, title, matn, image));
                    adapter.notifyDataSetChanged();

    //set again adapter!
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    */
/*
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        mImageView.setImageBitmap(imageBitmap);
 */