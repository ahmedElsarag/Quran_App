package com.kaream.ehap.quranapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kaream.ehap.quranapp.Model.ImageSliderData;
import com.kaream.ehap.quranapp.Model.ReadQuranModel;
import com.kaream.ehap.quranapp.utials.DialogPage;
import com.kaream.ehap.quranapp.utials.MarkerDialog;
import com.wajahatkarim3.easyflipviewpager.BookFlipPageTransformer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

import klogi.com.RtlViewPager;

public class ReadActivity extends AppCompatActivity implements DialogPage.DialogInterFace , MarkerDialog.DialogInterFaceClick {


    private PagerAdapter pagerAdapter ;
    private ImageSliderData data ;
    private ArrayList<ReadQuranModel> listQuran ;
    private LinearLayout menuItem , indexSour , indexAjzaaa ,indexPage,saveState;
    private RtlViewPager viewPager;
    private RelativeLayout description ;
    private TextView desc_num , desc_ajzaa , desc_sour ;
    ImageView markerImage ;
    int currentPositionMarker ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readquran);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setUpLanguage();
        setUpView();
        setUpViewPager(getSaveState());
        handleSaveMarker();
        setDescInsilze(viewPager.getCurrentItem());

    }
    private void setDescInsilze(int position){
        int actulPosition = position+1 ;
        desc_num.setText(actulPosition +"");
        ArrayList<ReadQuranModel> listSour = new ArrayList<>();
        listSour = data.getImage_sour_index();

        for (int i=0 ; i < listSour.size()-1 ;i++){
            int startBound = listSour.get(i).postion ;
            int endBound = listSour.get(i+1).postion ;
            if( actulPosition >= startBound && actulPosition < endBound ){
                desc_sour.setText(listSour.get(i).nameItemList);
            }
        }
        ArrayList<ReadQuranModel> listAjzaa =new ArrayList<>();
        listAjzaa = data.getImage_Ajza_index();
        for(int i=0 ; i< listAjzaa.size()-1 ; i++){
            int startBound = listAjzaa.get(i).postion ;
            int endBound = listAjzaa.get(i+1).postion ;
            if( actulPosition >= startBound && actulPosition < endBound ){
                desc_ajzaa.setText(listAjzaa.get(i).nameItemList);
            }
        }
    }

    private void setUpView(){
        pagerAdapter = new PagerAdapter();
        data = new ImageSliderData();
        listQuran = new ArrayList<>();
        viewPager = findViewById(R.id.pager);
        menuItem = findViewById(R.id.menu_linearLayout);
        indexSour= findViewById(R.id.menu_linearLayout_index);
        indexAjzaaa = findViewById(R.id.menu_linearLayout_ajzaa);
        indexPage = findViewById(R.id.menu_linearLayout_pages);
        saveState = findViewById(R.id.menu_linearLayout_saveBookmark);
        description = findViewById(R.id.description_relativeLayout);
        desc_num = findViewById(R.id.description_textView_pageNum);
        desc_ajzaa = findViewById(R.id.description_textView_juz);
        desc_sour = findViewById(R.id.description_textView_sura);
    }

    public void setUpLanguage() {
        Locale locale = new Locale("ar");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }

    private void setUpViewPager(int positionPage){
        listQuran = data.getImage_page_index();
        pagerAdapter = new PagerAdapter(listQuran,getApplicationContext());
        // Create an object of page transformer
        BookFlipPageTransformer bookFlipPageTransformer = new BookFlipPageTransformer();
        // Enable / Disable scaling while flipping. If true, then next page will scale in (zoom in). By default, its true.
        bookFlipPageTransformer.setEnableScale(true);
        // The amount of scale the page will zoom. By default, its 5 percent.
        bookFlipPageTransformer.setScaleAmountPercent(7f);
        viewPager.setPageTransformer(true,bookFlipPageTransformer);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(positionPage);
        Intent intent = this.getIntent();
        Bundle b = getIntent().getExtras();
        if(intent != null) {
            String testIntent = b.getString("testActivity");
            String testMarker = b.getString("GO_MARKER");
            String strdata = b.getString("Uniqid");

            if(testIntent != null){

            }
            if(testMarker != null){
                if(testMarker.equals("MARKER")){
                    viewPager.setCurrentItem(getMarkerPosition());
                }
            }
            if(strdata != null){
                if (strdata.equals("from_sour")) {
                    int position = b.getInt(ListSourActivity.POSITION_KEY);
                    viewPager.setCurrentItem(position - 1);
                }else if(strdata.equals("from_ajzaa")){
                   int position = b.getInt(AjzaActivity.POSITION_KEY);
                   viewPager.setCurrentItem(position - 1);
                }
            }

            }

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {
                   setDescInsilze(viewPager.getCurrentItem());
                }

                @Override
                public void onPageSelected(int i) {

                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });

        indexSour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ListSourActivity.class);
                startActivity(intent);
            }
        });
         indexAjzaaa.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(getApplicationContext(),AjzaActivity.class);
                 startActivity(intent);
             }
         });

         indexPage.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 DialogPage dialogPage = new DialogPage();
                 dialogPage.show(getSupportFragmentManager(),"Dialog");

                  }

         });



    }
     private void handleSaveMarker(){
         saveState.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 MarkerDialog dialogPage = new MarkerDialog();
                 dialogPage.show(getSupportFragmentManager(),"DialogMarker");
              }
         });
     }

    ////////////////////////////////////////////////
     private void saveStateForCurrentPage(int position){
         SharedPreferences settings = getSharedPreferences("PAGE_STATE", 0);
         SharedPreferences.Editor editor = settings.edit();
         editor.putInt("POSITION_STATE",position);
         editor.commit();
     }

     /////////////////////////////////////
    private int getSaveState(){
        SharedPreferences settings = getSharedPreferences("PAGE_STATE", 0);
        int position = settings.getInt("POSITION_STATE", 0);
        return position;
    }

    /**
     * save and assign mark by sharedPrefernces
     */
     private void saveMarker(int position){
         SharedPreferences settings = getSharedPreferences("PAGE_MARKER", 0);
         SharedPreferences.Editor editor = settings.edit();
         editor.putInt("POSITION_MARKER",position);
         editor.commit();
         Toast.makeText(getApplicationContext() ,"تم حفظ العلامة",Toast.LENGTH_SHORT).show();
     }
    private int getMarkerPosition(){
        SharedPreferences settings = getSharedPreferences("PAGE_MARKER", 0);
        int position = settings.getInt("POSITION_MARKER", 0);
        return position;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(menuItem.getVisibility() == View.VISIBLE && description.getVisibility() == View.VISIBLE) {
            menuItem.setVisibility(View.GONE);
            description.setVisibility(View.GONE);
        }
        saveStateForCurrentPage(viewPager.getCurrentItem());
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
     }

    @Override
    protected void onStop() {
        super.onStop();
        if(menuItem.getVisibility() == View.VISIBLE && description.getVisibility() == View.VISIBLE) {
            menuItem.setVisibility(View.GONE);
            description.setVisibility(View.GONE);
        }
        saveStateForCurrentPage(viewPager.getCurrentItem());
     }

    @Override
    public void applyText(String pageNum) {
        int position = Integer.parseInt(pageNum);
        position = position-1 ;
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onClick() {
        saveMarker(viewPager.getCurrentItem());
        if(menuItem.getVisibility() == View.VISIBLE && description.getVisibility() ==View.VISIBLE){
            menuItem.setVisibility(View.GONE);
            description.setVisibility(View.GONE);
        }
       setUpViewPager(viewPager.getCurrentItem());
     }


    public class PagerAdapter extends android.support.v4.view.PagerAdapter {

        ArrayList<ReadQuranModel> readQuranModels ;
        Context context ;
        LayoutInflater inflater ;
        public PagerAdapter(){}

        public PagerAdapter(ArrayList<ReadQuranModel> readQuranModels, Context context) {
            this.readQuranModels = readQuranModels;
            this.context = context;

        }

        @Override
        public int getCount() {
            return readQuranModels.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, final int position) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.page,container ,false);
            ImageView pageImage = view.findViewById(R.id.page_imageView_page);
            markerImage = view.findViewById(R.id.page_imageView_marker);
            try {

                InputStream stream = context.getAssets().open(readQuranModels.get(position).pathImage);
                Drawable drawable = Drawable.createFromStream(stream,null);
                pageImage.setImageDrawable(drawable);

            }catch (IOException e){
                e.printStackTrace();
            }
            pageImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(menuItem.getVisibility() == View.GONE && description.getVisibility() == View.GONE ){
                        menuItem.setVisibility(View.VISIBLE);
                        description.setVisibility(View.VISIBLE);
                    }else {
                        menuItem.setVisibility(View.GONE);
                        description.setVisibility(View.GONE);
                    }


                }
            });



            if(getMarkerPosition() == position){
                markerImage.setVisibility(View.VISIBLE);
            }


            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

}
