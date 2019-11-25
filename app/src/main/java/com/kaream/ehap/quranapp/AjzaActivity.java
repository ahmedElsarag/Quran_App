package com.kaream.ehap.quranapp;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.kaream.ehap.quranapp.Model.ImageSliderData;
import com.kaream.ehap.quranapp.Model.ReadQuranModel;

import java.util.ArrayList;
import java.util.Locale;

public class AjzaActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ListView listView ;
    private ArrayList<ReadQuranModel> listItem ;
    public static String POSITION_KEY ="position" ;
    private boolean[] visiablityForMarker ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajzaa);
         setUpLanguage();
         setUpView();
         setUPNavigation();
         setUpList();

    }
    //////////////////////////////////

    /**
     * fun to setUp Lanague rtl
     */
    public void setUpLanguage() {
        Locale locale = new Locale("ar");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    /**
     * function to setUp the findview for item of view in layout
     */
    //////////////////////////////
    public void setUpView(){
        listView = findViewById(R.id.ajza_listView);
        listItem = new ArrayList<>();
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
    }
    ////////////////////////////////////////////////////////////

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
                ArrayList<ReadQuranModel> listTemp = new ArrayList<>();
                for (ReadQuranModel readQuranModel : listItem){
                    if(readQuranModel.nameItemList.contains(s)){
                        listTemp.add(readQuranModel);
                    }
                }
                listView.setAdapter(new CustomAdapterForAjzaa(listTemp));

                return false;
            }

        });
        return true;

    }
    ///////////////////////////////

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),ReadActivity.class);
        intent.putExtra("testActivity" ,"test");
        startActivity(intent);
        super.onBackPressed();
    }

    ///////////////////////////////////////
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_back:{
                Intent intent =new Intent(this,ReadActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("testActivity" ,"test");
                startActivity(intent);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
    ///////////////////////////////////////////////

    /**
     * to Setup open Drawaer for list Side Menu
     */
    ///////////////////////////
    public void setUPNavigation(){
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
    private int getMarkerPosition(){
        SharedPreferences settings = getSharedPreferences("PAGE_MARKER", 0);
        int position = settings.getInt("POSITION_MARKER", 0);
        return position;
    }
    ////////////////////////////////
    public void setUpList(){
        ImageSliderData data = new ImageSliderData();
        listItem = data.getImage_Ajza_index();
//        visiablityForMarker = new boolean[listItem.size()];
//        for (int i=0 ; i<= visiablityForMarker.length -1 ; i++){
//            if(getMarkerPosition() == i){
//                visiablityForMarker[i] = true ;
//            }else {
//                visiablityForMarker[i] = false;
//            }
//        }
        CustomAdapterForAjzaa  adapterForAjzaa = new CustomAdapterForAjzaa(listItem);
        listView.setAdapter(adapterForAjzaa);
    }
    /////////////////////////////////////////////////////

    /**
     * the class for handle list item
     */
    class CustomAdapterForAjzaa extends BaseAdapter{

        public   ArrayList<ReadQuranModel> listSourItem ;
        public   ArrayList<ReadQuranModel> searchResult ;

        public CustomAdapterForAjzaa(ArrayList<ReadQuranModel> listSourItem) {
            this.listSourItem = listSourItem;
            listSourItem = new ArrayList<>();
            this.searchResult = listSourItem;

        }

        @Override
        public int getCount() {
            return listSourItem.size();
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
             view = inflater.inflate(R.layout.ajzaa_item,null);

             TextView txtNumIndex = view.findViewById(R.id.ajzaa_textView_num);
             TextView txtNameAjzaa = view.findViewById(R.id.ajzaa_imageView_name);
             ImageView imgMarker = view.findViewById(R.id.ajzaa_imageView_marker);
             TextView txtPageNum = view.findViewById(R.id.ajzaa_textView_page);
             final ReadQuranModel model =  listItem.get(i);
             int index = i+1 ;
             txtNumIndex.setText(index +"");
             Typeface typeface = Typeface.createFromAsset(getAssets(),"Fonts/Droid_Sans_Arabic.ttf");
             txtNameAjzaa.setTypeface(typeface);
             txtNameAjzaa.setText(model.nameItemList);
             txtPageNum.setText(model.postion +"");
//            if(mVisibilityList[i] == true){
//                imgMarker.setVisibility(View.VISIBLE);
//            }else {
//                imgMarker.setVisibility(View.GONE);
//            }
             view.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Intent intent = new Intent(getApplicationContext() ,ReadActivity.class);
                     intent.putExtra(POSITION_KEY,model.postion);
                     intent.putExtra("Uniqid","from_ajzaa");
                     startActivity(intent);
                 }
             });

            return view;
        }
    }
}
