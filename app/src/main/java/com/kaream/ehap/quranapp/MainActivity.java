package com.kaream.ehap.quranapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.kaream.ehap.quranapp.Model.ReaderData;
import com.kaream.ehap.quranapp.Model.ReaderModel;
import com.kaream.ehap.quranapp.adapter.CustomArrayAdapterForReader;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private GridView list_item;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ArrayList<ReaderModel> listReader ;
    String RecitesName = "";
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;
    public static int drawable_img ;
    public static String realName ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpLanguage();
        setUp();
        setUpNavigationDrawer();
        setUpList();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

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
                ArrayList<ReaderModel> listrecitestemp = new ArrayList<ReaderModel>();
                for (ReaderModel listrecitesitem : listReader) {
                    if (listrecitesitem.realName.contains(s)) {
                        listrecitestemp.add(listrecitesitem);
                    }
                }
                CustomArrayAdapterForReader adapter  = new CustomArrayAdapterForReader(getApplicationContext(),listrecitestemp,R.layout.layout_card);
                list_item.setAdapter(adapter);
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

    public void setUp() {
        list_item = findViewById(R.id.list_item);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        listReader =new ArrayList<>();

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

                       switch (menuItem.getItemId()){
                           case R.id.listen_quran :{

                               Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                               startActivity(intent);
                               // close drawer when item is tapped
                               drawerLayout.closeDrawers();
                               // set item as selected to persist highlight
                               menuItem.setChecked(true);
                               break;
                           }
                           case R.id.favoriate:{

                               Intent intent = new Intent(getApplicationContext(),FavoriteActivity.class);
                               startActivity(intent);
                               // close drawer when item is tapped
                               drawerLayout.closeDrawers();
                               // set item as selected to persist highlight
                               menuItem.setChecked(true);
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
        ReaderData  data = new ReaderData();
        listReader = data.listReader();
        CustomArrayAdapterForReader adapter  = new CustomArrayAdapterForReader(getApplicationContext(),listReader,R.layout.layout_card);
        list_item.setAdapter(adapter);
        list_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView txt_ReaderName = view.findViewById(R.id.txt_qauraName);
                for (ReaderModel readerModel:listReader) {
                    if(readerModel.realName.equals(txt_ReaderName.getText())){
                         RecitesName = readerModel.serverName;
                         drawable_img = readerModel.imgDrawable;
                         realName = readerModel.realName;
                         displaySour();
                         break;
                    }
                }
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void displaySour() {
        /**
         * check permission for read and use internet for media
         */
        if (Build.VERSION.SDK_INT >= 23) {
            if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED) ||
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                            PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_ASK_PERMISSIONS);

                return;
            }

        }
       // permission checked for sdk > 23
       ListAya();

    }


    public void ListAya(){
        /**
         * move for activity sour and send server name for reader
         */
        try{
            if(RecitesName.length()>1){
                Intent intent = new Intent(this,activity_sour.class);
                intent.putExtra("RecitesName" ,RecitesName);
                intent.putExtra("RealNameObject",realName);
                intent.putExtra("ImgDrawable",drawable_img);
                startActivity(intent);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    ListAya();
                } else {
                    // Permission Denied
                    ListAya();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
