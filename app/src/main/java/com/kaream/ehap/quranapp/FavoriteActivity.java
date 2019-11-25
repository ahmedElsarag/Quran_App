package com.kaream.ehap.quranapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
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
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kaream.ehap.quranapp.DataBase.DBHelper;
import com.kaream.ehap.quranapp.Model.FavoriteModel;

import java.util.ArrayList;
import java.util.Locale;

public class FavoriteActivity extends AppCompatActivity {

    private GridView list_favorite ;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ArrayList<FavoriteModel> list_fav_load ;
    FavoriteModel favoriteModel = new FavoriteModel();
    private String RecitesAYA = "";
    private String RecitesName = "";
    private String ReaderName = "";
    private Integer img_Drawable ;
    private String serverName ="";
    private String stateName ="";
    private String ImgUrl = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        setUpLanguage();
        setUp();
        setUpNavigationDrawer();
        setUpList();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_sour, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search_sour);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();
        //final Context co=this;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<FavoriteModel> listrecitestemp = new ArrayList<FavoriteModel>();
                for (FavoriteModel listrecitesitem : list_fav_load) {
                    if (listrecitesitem.realName.contains(s)) {
                        listrecitestemp.add(listrecitesitem);
                    }
                }
                list_favorite.setAdapter(new CustomAdapterForFavorite(getApplicationContext(),listrecitestemp,R.layout.layout_card_favoriate));
                return false;
            }

        });
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_back:{
                Intent intent =new Intent(this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void setUpLanguage() {
        Locale locale = new Locale("ar");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }
    private void setUp(){
        list_favorite = findViewById(R.id.list_item);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        list_fav_load =new ArrayList<>();

    }
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
                        switch (menuItem.getItemId()){
                            case R.id.listen_quran :{
                                // set item as selected to persist highlight
                                menuItem.setChecked(true);
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                                // close drawer when item is tapped
                                drawerLayout.closeDrawers();
                                break;
                            }
                            case R.id.favoriate:{
                                // set item as selected to persist highlight
                                menuItem.setChecked(true);
                                Intent intent = new Intent(getApplicationContext(),FavoriteActivity.class);
                                startActivity(intent);
                                // close drawer when item is tapped
                                drawerLayout.closeDrawers();
                                break;
                            }
                            case R.id.read_quran:{
                                Intent intent = new Intent(getApplicationContext(),ReadActivity.class);
                                intent.putExtra("testActivity","test");
                                startActivity(intent);
                                // close drawer when item is tapped
                                drawerLayout.closeDrawers();
                                // set item as selected to persist highlight
                                menuItem.setChecked(true);
                                break;
                            }
                            case R.id.bookMark :{
                                Intent intent = new Intent(getApplicationContext(),ReadActivity.class);
                                intent.putExtra("GO_MARKER","MARKER");
                                startActivity(intent);
                                // close drawer when item is tapped
                                drawerLayout.closeDrawers();
                                // set item as selected to persist highlight
                                menuItem.setChecked(true);
                                break;
                            }
                            case R.id.doaa : {
                                Intent intent = new Intent(getApplicationContext(),DoaaActivity.class);
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
    public void setUpList(){
         loadData();
         final CustomAdapterForFavorite favorite = new CustomAdapterForFavorite(getApplicationContext(),list_fav_load,R.layout.layout_card_favoriate);
         list_favorite.setAdapter(favorite);
    }
    public void DisplayAya(FavoriteModel favoriteModel) {
        Intent intent = new Intent(this, ActivityMediaPlayer.class);
        intent.putExtra("RecitesName", RecitesName);
        intent.putExtra("RecitesAYA", RecitesAYA);
        intent.putExtra("RealNameForReader",ReaderName);
        intent.putExtra("ImgDrawable",img_Drawable);
        intent.putExtra("ServerName",serverName);
        intent.putExtra("ImageUrl",ImgUrl);
        intent.putExtra("StateName",stateName);
        intent.putExtra("RealName",favoriteModel.realName);
        startActivity(intent);
    }
    private void loadData(){
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        list_fav_load = dbHelper.getAllFavoriate();
        if (list_fav_load == null) {
            list_fav_load = new ArrayList<>();
        }
    }

     class CustomAdapterForFavorite extends ArrayAdapter<FavoriteModel> {
        Context context;
        ArrayList<FavoriteModel> sourModel;
        int layoutResourceId ;
        public LayoutInflater inflater;
        Typeface typeface;

        public CustomAdapterForFavorite(Context context1, ArrayList<FavoriteModel> quranModels, int layoutResourceId) {
            super(context1, layoutResourceId, quranModels);
            this.context = context1;
            this.sourModel = quranModels;
            this.layoutResourceId = layoutResourceId;
            this.inflater=LayoutInflater.from(context1);
        }



        @Override
        public View getView(final int position, final View convertView, ViewGroup parent) {
            View row = convertView;
            RecordHolder holder = null;
            if (row == null) {
                row = inflater.inflate(layoutResourceId, parent, false);
                holder = new RecordHolder();
                holder.txtSourName = row.findViewById(R.id.txtSourName);
                holder.image_qura = row.findViewById(R.id.img_qaura);
                holder.txtStauts = row.findViewById(R.id.txtStauts);
                holder.icon_delete= row.findViewById(R.id.icon_delete);
                row.setTag(holder);
            } else {
                holder = (RecordHolder) row.getTag();
            }
            final FavoriteModel quranModel = sourModel.get(position);
            typeface = Typeface.createFromAsset(context.getAssets(),"Fonts/Droid_Sans_Arabic.ttf");
            holder.txtSourName.setTypeface(typeface);
            holder.txtSourName.setText(quranModel.realName);
            Glide.with(context).load(quranModel.imgDrawable).into(holder.image_qura);
            holder.txtStauts.setText(quranModel.StateName);
            holder.icon_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DBHelper dbHelper = new DBHelper(context);
                    dbHelper.delete(quranModel.realName);
                    Toast.makeText(context,"تمت الازالة بنجاح",Toast.LENGTH_SHORT).show();
                    setUpList();

                }
            });
            holder.image_qura.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FavoriteModel favoriteModel = list_fav_load.get(position);

                    DBHelper dbHelper = new DBHelper(getApplicationContext());
                    RecitesAYA = dbHelper.getRecitesAya(favoriteModel.realName);
                    RecitesName =dbHelper.getRecitesName(favoriteModel.realName);
                    ReaderName = dbHelper.getReaderName(favoriteModel.realName);
                    img_Drawable= dbHelper.getImgDrawable(favoriteModel.realName);
                    serverName = dbHelper.getServerName(favoriteModel.realName);
                    stateName = dbHelper.getStateName(favoriteModel.realName);
                    ImgUrl = dbHelper.getImgUrl(favoriteModel.realName);
                    DisplayAya(favoriteModel);
                }
            });

            holder.txtSourName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FavoriteModel favoriteModel = list_fav_load.get(position);

                    DBHelper dbHelper = new DBHelper(getApplicationContext());
                    RecitesAYA = dbHelper.getRecitesAya(favoriteModel.realName);
                    RecitesName =dbHelper.getRecitesName(favoriteModel.realName);
                    ReaderName = dbHelper.getReaderName(favoriteModel.realName);
                    img_Drawable= dbHelper.getImgDrawable(favoriteModel.realName);
                    serverName = dbHelper.getServerName(favoriteModel.realName);
                    stateName = dbHelper.getStateName(favoriteModel.realName);
                    ImgUrl = dbHelper.getImgUrl(favoriteModel.realName);
                    DisplayAya(favoriteModel);
                }
            });

            return row;
        }
           class RecordHolder {
            TextView txtSourName;
            ImageView image_qura;
            TextView txtStauts ;
            ImageView icon_delete ;

        }
    }

}
