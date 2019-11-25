package com.kaream.ehap.quranapp;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kaream.ehap.quranapp.DataBase.DBHelper;
import com.kaream.ehap.quranapp.Model.FavoriteModel;
import com.kaream.ehap.quranapp.Model.QuranModel;
import com.kaream.ehap.quranapp.Model.ReaderData;
import com.kaream.ehap.quranapp.utials.Utilities;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Locale;

public class activity_sour extends AppCompatActivity {

    private String RecitesAYA = "";
    ProgressDialog mProgressDialog;
    private GridView list_item;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    public ArrayList<QuranModel> listSourQuran;
    public static String RecitesName = "";
    public boolean ISDonwloading = false;
    public static int img_drawable = 0;
    Typeface typeface;
    String Soura_name = "";
    CustomAdapterSour adapterSour;
    public static String realNameForReader;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sour_playlist);
        setUpLanguage();
        setUp();
        handleProgress();
        setUpNavigationDrawer();
        setUpList();


    }

    /**
     * this Section For Menu and Search Function and Action
     * /////////////////////////////////////////////////////////////////////////////////*\
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_sour, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search_sour);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        //final Context co=this;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<QuranModel> listrecitestemp = new ArrayList<QuranModel>();
                for (QuranModel listrecitesitem : listSourQuran) {
                    if (listrecitesitem.realName.contains(s)) {
                        listrecitestemp.add(listrecitesitem);
                    }
                }
                list_item.setAdapter(new CustomAdapterSour(listrecitestemp));
                return false;
            }

        });
        return true;

    }
    //////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_back: {
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
    /////////////////////////////////////////////////////////////////////////////////////

    /**
     * the function to setUp Arabic Lanague
     */

    //////////////////////////////////////////////////////////////////////////////////////////
    public void setUpLanguage() {
        Locale locale = new Locale("ar");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }
    /////////////////////////////////////////////////////////////////////////////////////////

    /**
     * the Function to SetUp Reference from view
     */
    public void setUp() {
        list_item = findViewById(R.id.listSour);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        listSourQuran = new ArrayList<>();
        drawerLayout = findViewById(R.id.drawer_layout);

    }
    /////////////////////////////////////////////////////////////////////////////////////////

    /**
     * the function to SetUp Drawer action and view action
     */
    public void setUpNavigationDrawer() {
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        switch (menuItem.getItemId()) {
                            case R.id.listen_quran: {
                                // set item as selected to persist highlight
                                menuItem.setChecked(true);
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                                // close drawer when item is tapped
                                drawerLayout.closeDrawers();
                                break;
                            }
                            case R.id.favoriate: {
                                // set item as selected to persist highlight
                                menuItem.setChecked(true);
                                Intent intent = new Intent(getApplicationContext(), FavoriteActivity.class);
                                startActivity(intent);
                                // close drawer when item is tapped
                                drawerLayout.closeDrawers();
                                break;
                            }
                            case R.id.read_quran: {
                                Intent intent = new Intent(getApplicationContext(), ReadActivity.class);
                                intent.putExtra("testActivity", "test");
                                startActivity(intent);
                                // close drawer when item is tapped
                                drawerLayout.closeDrawers();
                                // set item as selected to persist highlight
                                menuItem.setChecked(true);
                                break;
                            }
                            case R.id.bookMark: {
                                Intent intent = new Intent(getApplicationContext(), ReadActivity.class);
                                intent.putExtra("GO_MARKER", "MARKER");
                                startActivity(intent);
                                // close drawer when item is tapped
                                drawerLayout.closeDrawers();
                                // set item as selected to persist highlight
                                menuItem.setChecked(true);
                                break;
                            }
                            case R.id.doaa: {
                                Intent intent = new Intent(getApplicationContext(), DoaaActivity.class);
                                startActivity(intent);
                                // close drawer when item is tapped
                                drawerLayout.closeDrawers();
                                // set item as selected to persist highlight
                                menuItem.setChecked(true);
                                break;
                            }


                        }

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

    }
    //////////////////////////////////////////////////////////////////////////////////////

    /**
     * the function for set list on view list item
     */
    public void setUpList() {
        ReaderData data = new ReaderData();
        Bundle b = getIntent().getExtras();
        RecitesName = b.getString("RecitesName");
        realNameForReader = b.getString("RealNameObject");
        img_drawable = b.getInt("ImgDrawable");
        listSourQuran.clear();
        listSourQuran = data.GuranAya(RecitesName);
        adapterSour = new CustomAdapterSour(listSourQuran);
        list_item.setAdapter(adapterSour);
    }
    /////////////////////////////////////////////////////////////////////////////////////

    /**
     * the function set data for media for media player and open MediaPlayer Activity
     *
     * @param serverName
     * @param realName
     * @param stateName
     * @param ImgUrl
     */
    public void DisplayAya(String serverName, String realName, String stateName, String ImgUrl) {
        Intent intent = new Intent(this, ActivityMediaPlayer.class);
        intent.putExtra("RecitesName", RecitesName);
        intent.putExtra("RecitesAYA", RecitesAYA);
        intent.putExtra("RealNameForReader", realNameForReader);
        intent.putExtra("RealName", realName);
        intent.putExtra("StateName", stateName);
        intent.putExtra("ImageUrl", ImgUrl);
        intent.putExtra("ServerName", serverName);
        intent.putExtra("ImgDrawable", img_drawable);
        startActivity(intent);
    }
    ////////////////////////////////////////////////////////////////////////////////////////

    /**
     * this function for download sound file for reader
     *
     * @param ImgUrl
     * @param ServerName
     */
    public void startDownload(String ImgUrl, String ServerName) {
        RecitesAYA = ServerName;
        String url = ImgUrl;
        new DownloadFileAsync().execute(url);

    }
    //////////////////////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////////////////////

    /**
     * the function to return state if internet connection
     *
     * @return
     */
    public boolean getNetworkAvailability() {
        return Utilities.isNetworkAvailable(getApplicationContext());
    }
//////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * class adapter for adapt item in list
     */
    class CustomAdapterSour extends BaseAdapter {
        public ArrayList<QuranModel> quranModels;
        public ArrayList<QuranModel> searchResult;

        public CustomAdapterSour(ArrayList<QuranModel> quranModels) {
            this.searchResult = quranModels;
            this.quranModels = new ArrayList<>();
            this.quranModels = quranModels;
        }

        @Override
        public int getCount() {
            return quranModels.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = getLayoutInflater();
            view = inflater.inflate(R.layout.layout_card_sour, null);
            final ImageView img_more = view.findViewById(R.id.img_more);
            final ImageView img_download = view.findViewById(R.id.downloadSour);
            final TextView txt_sourQuran = view.findViewById(R.id.txt_sourName);
            ImageView img_quran = view.findViewById(R.id.img_qaura);
            TextView txt_status = view.findViewById(R.id.txt_from);
            img_more.setImageResource(R.drawable.more);
            QuranModel temp = quranModels.get(i);
            Glide.with(getApplicationContext())
                    .load(img_drawable)
                    .into(img_quran);
            typeface = Typeface.createFromAsset(getAssets(), "Fonts/Droid_Sans_Arabic.ttf");
            txt_sourQuran.setTypeface(typeface);
            txt_sourQuran.setText(temp.realName);
            final QuranModel quranModel = this.quranModels.get(i);
            final String ServerName = quranModel.serverName;
            txt_status.setText(quranModel.StateName);
            img_download.setImageResource(temp.ImgDownload);
            img_download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(ISDonwloading != true){
                        if(getNetworkAvailability()){
                            Soura_name = txt_sourQuran.getText().toString();
                            downloadFile(quranModel.ImgUrl, ServerName);
                            ISDonwloading = false;
                        }else {
                            Toast.makeText(getApplicationContext(), "Please Check Connection To Download", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
            img_more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popupMenu = new PopupMenu(activity_sour.this, img_more);
                    popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            if (menuItem.getItemId() == R.id.download) {
                                if (ISDonwloading != true) {
                                    if (getNetworkAvailability()) {
                                        Soura_name = txt_sourQuran.getText().toString();
                                         downloadFile(quranModel.ImgUrl, ServerName);
                                      //  startDownload(quranModel.ImgUrl, ServerName);
//                                        Intent intent = new Intent(getApplicationContext(), DownloadService.class);
//                                        intent.putExtra("PARSE_URL",quranModel.ImgUrl);
//                                        intent.putExtra("SERVER_NAME",ServerName);
//                                        startService(intent);
                                        // downloadFile(quranModel.ImgUrl,ServerName,RecitesName);
                                        ISDonwloading = false;
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Please Check Connection To Download", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            } else if (menuItem.getItemId() == R.id.add_favorite) {

                                for (int i = 0; i < quranModels.size(); i++) {
                                    if (quranModels.get(i).realName.equals(quranModel.realName)) {
                                        RecitesAYA = String.valueOf(i);// ServerName;
                                        FavoriteModel favoriteModel = new FavoriteModel(quranModel.serverName
                                                , quranModel.realName
                                                , quranModel.StateName
                                                , quranModel.ImgUrl
                                                , img_drawable
                                                , RecitesAYA
                                                , RecitesName
                                                , realNameForReader);
                                        saveData(favoriteModel);

                                        break;
                                    }

                                }


                            }

                            return true;

                        }
                    });
                    popupMenu.show();
                }
            });

            img_quran.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //get aya
                    if (ISDonwloading != true)
                        for (int i = 0; i < quranModels.size(); i++) {
                            if (quranModels.get(i).realName.equals(quranModel.realName)) {
                                RecitesAYA = String.valueOf(i);// ServerName;
                                DisplayAya(quranModel.serverName, quranModel.realName, quranModel.StateName, quranModel.ImgUrl);

                                break;
                            }

                        }
                }
            });
            txt_sourQuran.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //get aya
                    if (ISDonwloading != true)
                        for (int i = 0; i < quranModels.size(); i++) {
                            if (quranModels.get(i).realName.equals(quranModel.realName)) {
                                RecitesAYA = String.valueOf(i);// ServerName;
                                RecitesName = activity_sour.RecitesName;
                                DisplayAya(quranModel.serverName, quranModel.realName, quranModel.StateName, quranModel.ImgUrl);
                                break;
                            }

                        }
                }

            });


            return view;
        }




        private void saveData(FavoriteModel model) {
            DBHelper dbHelper = new DBHelper(getApplicationContext());

            if (dbHelper.addFavoriate(model)) {
                Toast.makeText(getApplicationContext(), "تمت الاضافة بنجاح", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "لم تتم الاضافة", Toast.LENGTH_SHORT).show();

            }

        }

    }

    private void handleProgress() {
        mProgressDialog = new ProgressDialog(activity_sour.this);
        mProgressDialog.setMessage("تنزيل..");
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(true);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////
    // Download function by Download Manager
    private void downloadFile(String ImgUrl, String ServerName){
        RecitesAYA = ServerName;
        String url = ImgUrl;
      try {
          DownloadManager downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
          Uri uri = Uri.parse(url);
          DownloadManager.Request request = new DownloadManager.Request(uri);
          request.setNotificationVisibility(View.VISIBLE);
          request.setDestinationInExternalPublicDir(Environment.DIRECTORY_MUSIC,RecitesName+RecitesAYA+".mp3" );
          Long refrence = downloadManager.enqueue(request);
          setUpList();
      }catch (Exception ex){
          ex.printStackTrace();
      }


    }

    /**
     * class for download file aysenc task and Notification for download
     */
    class DownloadFileAsync extends AsyncTask<String, Integer, String> {

        private PowerManager.WakeLock mWakeLock;

        //      CountDownTimer cdt;
        int id;
//        NotificationManager mNotifyManager;
//        NotificationCompat.Builder mBuilder;
//        // declare the dialog as a member field of your activity
//


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // take CPU lock to prevent CPU from going off if the user
            // presses the power button during download
            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
            mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                    getClass().getName());
            mWakeLock.acquire();
            mProgressDialog.show();
//            progressBar.setVisibility(View.VISIBLE);
//            progressBar.setClickable(false);

            /**
             * Create custom Count Down Timer
             */
//            cdt = new CountDownTimer(100 * 60 * 1000, 500) {
//                public void onTick(long millisUntilFinished) {
//                    mNotifyManager.notify(id, mBuilder.build());
//                }
//
//                public void onFinish() {
//                    mNotifyManager.notify(id, mBuilder.build());
//                }
//            };
            ISDonwloading = true;
        }

        @Override
        protected String doInBackground(String... aurl) {
            int count;

            try {

//                mNotifyManager =
//                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//                mBuilder = new NotificationCompat.Builder(getApplicationContext());
//                mBuilder.setContentTitle("Downloading File")
//                        .setContentText(Soura_name)
//                        .setProgress(0, 100, false)
//                        .setOngoing(true)
//                        .setSmallIcon(R.drawable.ic_download)
//                        .setPriority(Notification.PRIORITY_LOW);

                // Initialize Objects here
                //publishProgress("5");
                //   mNotifyManager.notify(id, mBuilder.build());
                // cdt.start();
                //publishProgress("20");


                URL url = new URL(aurl[0]);
                URLConnection conexion = url.openConnection();
                conexion.connect();

                int lenghtOfFile = conexion.getContentLength();
                //Log.d("ANDRO_ASYNC", "Lenght of file: " + lenghtOfFile);

                InputStream input = new BufferedInputStream(url.openStream());
                String SDPath = Environment.getExternalStorageDirectory().getPath() + "/";
                RecitesName = activity_sour.RecitesName;
                OutputStream output = new FileOutputStream(SDPath + RecitesName + RecitesAYA + ".mp3");

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    publishProgress((int) (total * 100 / lenghtOfFile));
                    output.write(data, 0, count);
                }

                output.flush();
                output.close();
                input.close();
            } catch (Exception e) {
            }
            return "Success";

        }

        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            // if we get here, length is known, now set indeterminate to false
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setMax(100);
            mProgressDialog.setProgress(values[0]);
//            mBuilder.setContentInfo(values[0] + "%")
//                    .setProgress(100, Integer.parseInt(values[0]), false);

        }

        @Override
        protected void onPostExecute(String s) {
            mWakeLock.release();
            mProgressDialog.dismiss();
            if (s != null)
                Toast.makeText(getApplicationContext(), "File downloaded", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "Download error: " + s, Toast.LENGTH_LONG).show();

//            progressBar.setVisibility(View.GONE);
//            String title;
//            if (s.equals("Success")) {
//                title = "Downloaded";
//            } else {
//                title = "Error Occurred";
//            }
//            mBuilder.setContentTitle(title)
//                    .setContentInfo("")
//                    .setSmallIcon(R.drawable.ic_download_checked)
//                    .setOngoing(false)
//                    .setProgress(0, 0, false);
//            cdt.onFinish();
//            cdt.cancel();
            setUpList();
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

}