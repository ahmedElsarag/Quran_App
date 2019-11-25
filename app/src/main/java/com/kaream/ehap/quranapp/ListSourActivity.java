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

import com.bumptech.glide.Glide;
import com.kaream.ehap.quranapp.Model.ImageSliderData;
import com.kaream.ehap.quranapp.Model.ReadQuranModel;

import java.util.ArrayList;
import java.util.Locale;

public class ListSourActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ListView listView ;
    private ArrayList<ReadQuranModel> listItem ;
    public static String POSITION_KEY ="position" ;
    private ImageSliderData data ;
    private ImageView imgSaveIcon ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
        setUpLanguage();
        setUpView();
        setUpNavigationDrawer();
        setUpList();
    }

    public void setUpLanguage() {
        Locale locale = new Locale("ar");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    public void setUpView(){
        listView = findViewById(R.id.index_listView);
        listItem = new ArrayList<>();
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);


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
                ArrayList<ReadQuranModel> listTemp = new ArrayList<>();
                for (ReadQuranModel readQuranModel : listItem){
                    if(readQuranModel.nameItemList.contains(s)){
                        listTemp.add(readQuranModel);
                    }
                }
                listView.setAdapter(new CustomReadSourQuranList(listTemp));
                return false;
            }

        });
        return true;

    }
    public void setUpList(){
       data = new ImageSliderData();
       listItem  = data.getImage_sour_index();
       CustomReadSourQuranList sourQuranList = new CustomReadSourQuranList(listItem);
       listView.setAdapter(sourQuranList);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),ReadActivity.class);
        intent.putExtra("testActivity" ,"test");
        startActivity(intent);
        super.onBackPressed();
    }

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
    private int getMarkerPosition(){
        SharedPreferences settings = getSharedPreferences("PAGE_MARKER", 0);
        int position = settings.getInt("POSITION_MARKER", 0);
        return position;
    }



    class CustomReadSourQuranList extends BaseAdapter{

     public   ArrayList<ReadQuranModel> listSourItem ;
     public   ArrayList<ReadQuranModel> searchResult ;



        public CustomReadSourQuranList(ArrayList<ReadQuranModel> listSourItem ) {
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
            view = inflater.inflate(R.layout.index_item,null);
            TextView txtNumIndexSour = view.findViewById(R.id.index_txt_num);
            TextView txtNameSour = view.findViewById(R.id.txt_name);
            TextView txtNumPositionSour = view.findViewById(R.id.txt_num_page);
            ImageView imgTypeSour = view.findViewById(R.id.img_soura_type);
            imgSaveIcon = view.findViewById(R.id.img_marker);
            final ReadQuranModel model = listSourItem.get(i);
            Typeface typeface = Typeface.createFromAsset(getAssets(),"Fonts/Droid_Sans_Arabic.ttf");
            int index = i+1 ;
            txtNumIndexSour.setText(index+"");
            txtNameSour.setTypeface(typeface);
            txtNameSour.setText(model.nameItemList);
            txtNumPositionSour.setText(model.postion + "");
            Glide.with(getApplicationContext())
                    .load(model.imageSouraType)
                    .into(imgTypeSour);
            //            int actulPosition = getMarkerPosition()+1 ;
//            ArrayList<ReadQuranModel> listSour = new ArrayList<>();
//            listSour = data.getImage_sour_index();
//            for (int j=0 ; i < listSour.size()-1 ;i++){
//                int startBound = listSour.get(j).postion ;
//                int endBound = listSour.get(j+1).postion ;
//                if( actulPosition >= startBound && actulPosition < endBound ){
//                    imgSaveIcon.setVisibility(View.VISIBLE);
//                }else {
//                    imgSaveIcon.setVisibility(View.GONE);
//                }
//            }
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext() ,ReadActivity.class);
                    intent.putExtra(POSITION_KEY,model.postion);
                    intent.putExtra("Uniqid","from_sour");
                    startActivity(intent);
                 }
            });



            return view;
        }


    }
}
