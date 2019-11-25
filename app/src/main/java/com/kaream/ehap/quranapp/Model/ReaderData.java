package com.kaream.ehap.quranapp.Model;

import android.os.Environment;

import com.kaream.ehap.quranapp.R;
import com.kaream.ehap.quranapp.utials.ListBeginEndAya;
import com.kaream.ehap.quranapp.utials.managment;

import java.io.File;
import java.util.ArrayList;

public class ReaderData {

    public ArrayList<ReaderModel> listInfoReader = new ArrayList<>();
    public ArrayList<QuranModel> listQuranAya = new ArrayList<>();
    public ArrayList<QuranModel> ListAyaRanage = new ArrayList<>();

    public ArrayList<ReaderModel> listReader() {
        listInfoReader.clear();
        listInfoReader.add(new ReaderModel("mustafa", "مصطفى إسماعيل", R.raw.mustafa_asmahial));//import 1
        listInfoReader.add(new ReaderModel("shatri", "ابو بكر الشاطري", R.raw.abobakr_alshatery));//import 2
        listInfoReader.add(new ReaderModel("basit_mjwd", "عبدالباسط عبدالصمد", R.raw.abod_albast));// import 3
        listInfoReader.add(new ReaderModel("Aamer", "أحمد عامر", R.raw.ahmed_ahamer));//import 5
        listInfoReader.add(new ReaderModel("ahmad_nu", "أحمد نعينع", R.raw.mahommad));//import 6
        listInfoReader.add(new ReaderModel("ahmad_huth", "أحمد الحذيفي", R.raw.ahamed_alazafey));//import 7
        listInfoReader.add(new ReaderModel("sds", "عبدالرحمن السديس", R.raw.abadalrhman_alsodase));//**import 8
        listInfoReader.add(new ReaderModel("tblawi", "محمد الطبلاوي", R.raw.mohammed_altablay));//import 9
        listInfoReader.add(new ReaderModel("afs", "مشاري العفاسي", R.raw.massher_alfase)); //**import 10
        listInfoReader.add(new ReaderModel("minsh_mjwd", "محمد صديق المنشاوي م", R.raw.mohammed_sedek));//import 12
        listInfoReader.add(new ReaderModel("qht", "خالد القحطاني", R.raw.khalied_alghtany));//import 13
        listInfoReader.add(new ReaderModel("kafi", "خالد عبدالكافي", R.raw.khalid_abd_alkafey));//import 14
        listInfoReader.add(new ReaderModel("huthifi_qalon", "علي الحذيفي", R.raw.ali_thazafy));//import 15
        listInfoReader.add(new ReaderModel("s_gmd", "سعد الغامدي", R.raw.said_althamde_1)); //**import 16
        listInfoReader.add(new ReaderModel("braak", "محمد البراك", R.raw.mohammes_albrak)); //**import 17
        listInfoReader.add(new ReaderModel("jbrl", "محمد جبريل", R.raw.mohammed_gbrel));//import 18
        listInfoReader.add(new ReaderModel("hawashi", "أحمد الحواشي", R.raw.alhasey));//import 19
        listInfoReader.add(new ReaderModel("ajm", "أحمد بن علي العجمي", R.raw.ahamid_ali_alhamdy));//import 20


        //have photo for this reader
        listInfoReader.add(new ReaderModel("trabulsi", "أحمد الطرابلسي", R.raw.ahmed_altrabolsy));
        //have not photo for this reader
        listInfoReader.add(new ReaderModel("trablsi", "أحمد خضر الطرابلسي", R.raw.ahmed_khedr_eltarabolsy));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("saud", "أحمد سعود ", R.raw.ahmed_soad));
        //have not photo for this reader
        listInfoReader.add(new ReaderModel("saber", "أحمد صابر", R.raw.ahmed_saber));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("akil", "أخيل عبدالحي روا ", R.raw.akhel_abd_elhay));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("akrm", "أكرم العلاقمي", R.raw.akram_elalakmy));
        ////put in store
        //have not photo for this reader
        listInfoReader.add(new ReaderModel("akdr", "إبراهيم الأخضر", R.raw.ibrahim_al_akhdar));
        //have not photo for this reader
        listInfoReader.add(new ReaderModel("IbrahemSadan", "إبراهيم السعدان", R.raw.ibrahem_alshadan));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("abkr", "إدريس أبكر", R.raw.edrees_abkar));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("jbreen", "ابراهيم الجبرين", R.raw.ibrahem_elgebreen));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("jormy", "ابراهيم الجرمي", R.raw.ibrahem_elgaramy));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("3siri", "ابراهيم العسيري", R.raw.ibrahem_eloseary));
        //have not photo for this reader
        listInfoReader.add(new ReaderModel("zamri", "استاذ زامري ", R.raw.ostaz_zamery));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("3zazi", "الحسيني العزازي ", R.raw.elhosany_elazazy));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("dokali", "الدوكالي محمد العالم", R.raw.aldokaly_mohamed_al3lem));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("alzain", "الزين محمد أحمد", R.raw.elzeen_mohamed_ahmed));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("omran", "العشري عمران ", R.raw.al3ashry_omran));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("koshi", "العيون الكوشي", R.raw.el3yoon_elkoshy));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("fateh", "الفاتح محمد الزبير", R.raw.elfateh_mohamed_elzobeeer));
        //have no photo for this reader
        listInfoReader.add(new ReaderModel("qari", "القارئ ياسين ", R.raw.alquara_yasien));

        ///new qura
        //have photo for this reader
        listInfoReader.add(new ReaderModel("twfeeq", "توفيق الصايغ", R.raw.tawfeek_elsayegh)); //**
        //have photo for this reader
        listInfoReader.add(new ReaderModel("jamal", "جمال شاكر عبدالله", R.raw.gamal_shaker_abdallah));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("jaman", "جمعان العصيمي", R.raw.gom3an_elosamy));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("hatem", "حاتم فريد الواعر", R.raw.hatem_farid_elwa3er));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("mohna", "خالد المهنا", R.raw.khaled_elmehana));
        //have no photo for this reader
        listInfoReader.add(new ReaderModel("tnjy", "خليفة الطنيجي", R.raw.khalifa_altenhay));
        //have no photo for this reader
        listInfoReader.add(new ReaderModel("hamza", "داود حمزة", R.raw.dawaod_hamza));
        //have photo for this reader
        listInfoReader.add(new ReaderModel("ifrad", "رشيد إفراد", R.raw.rasheed_efrad));
        //have no photoshop photo for this reader
        listInfoReader.add(new ReaderModel("zaki", "زكي داغستاني", R.raw.zaky_dagestan));

        listInfoReader.add(new ReaderModel("sami_dosr", "سامي الدوسري", R.raw.samy_eldosary));

        listInfoReader.add(new ReaderModel("shur", "سعود الشريم", R.raw.s3od_elshoram));  //**
        listInfoReader.add(new ReaderModel("shl", "سهل ياسين", R.raw.sahl_yaseen));
        //have no photo for this reader
        listInfoReader.add(new ReaderModel("sayed", "سيد رمضان", R.raw.said_ramadan));

        listInfoReader.add(new ReaderModel("taher", "شيرزاد عبدالرحمن طاهر", R.raw.shearzad_abdelrohman_taher));
        listInfoReader.add(new ReaderModel("hkm", "صابر عبدالحكم", R.raw.saber_abdelhakam));
        listInfoReader.add(new ReaderModel("sahood", "صالح الصاهود", R.raw.saleh_elsahood));
        listInfoReader.add(new ReaderModel("s_bud", "صلاح البدير", R.raw.salah_elbdear));
        listInfoReader.add(new ReaderModel("salah_hashim_m", "صلاح الهاشم", R.raw.salah_elhashem));
        listInfoReader.add(new ReaderModel("bu_khtr", "صلاح بو خاطر", R.raw.salah_abokhater));//**
        //have no photo for this reader
        listInfoReader.add(new ReaderModel("tareq", "طارق عبدالغني دعوب", R.raw.tarek_abdelgany_daob));

        listInfoReader.add(new ReaderModel("a_klb", "عادل الكلباني", R.raw.adel_elkalbany));
        listInfoReader.add(new ReaderModel("ryan", "عادل ريان", R.raw.adel_ryan));
        listInfoReader.add(new ReaderModel("thubti", "عبدالبارئ الثبيتي", R.raw.abdelbarek_elthebety));
        //have no photo for this reader
        listInfoReader.add(new ReaderModel("bari", "عبدالبارئ محمد", R.raw.abdelbare_mohamed));

        listInfoReader.add(new ReaderModel("bari_molm", "عبدالبارئ محمد م", R.raw.abdelbare_mohamed));
        listInfoReader.add(new ReaderModel("basit", "عبدالباسط عبدالصمد ح", R.raw.abod_albast));
        listInfoReader.add(new ReaderModel("basit_warsh", "عبدالباسط عبدالصمد و", R.raw.abod_albast));//**

        listInfoReader.add(new ReaderModel("sds", "عبدالرحمن السديس", R.raw.abadalrhman_alsodase));//**
        listInfoReader.add(new ReaderModel("soufi_klf", "عبدالرشيد صوفي", R.raw.abdelrasheed_elsofy));
        listInfoReader.add(new ReaderModel("soufi", "عبدالرشيد صوفي س", R.raw.abadalrhman_alsodase));
        listInfoReader.add(new ReaderModel("a_ahmed", "عبدالعزيز الأحمد", R.raw.abdelaziz_alahmed));
        listInfoReader.add(new ReaderModel("brmi", "عبدالله البريمي", R.raw.abdallah_elbramy));
        //no photo
        listInfoReader.add(new ReaderModel("Abdullahk", "عبدالله الكندري", R.raw.abdallah_alkandary));

        listInfoReader.add(new ReaderModel("mtrod", "عبدالله المطرود", R.raw.abdallah_almatrood));
        //no photo
        listInfoReader.add(new ReaderModel("bsfr", "عبدالله بصفر", R.raw.abdallah_basfer));

        listInfoReader.add(new ReaderModel("kyat", "عبدالله خياط", R.raw.abdallah_aikhayat));
        listInfoReader.add(new ReaderModel("jhn", "عبدالله عواد الجهني", R.raw.abdallah_awad_elgahany));
        listInfoReader.add(new ReaderModel("mohsin_harthi", "عبدالمحسن الحارثي", R.raw.abdelmohsen_elharesy));
        listInfoReader.add(new ReaderModel("obk", "عبدالمحسن العبيكان", R.raw.abdelmohsen_al3bekan));
        listInfoReader.add(new ReaderModel("qasm", "عبدالمحسن القاسم", R.raw.abdelmohsen_elkasem));
        listInfoReader.add(new ReaderModel("kanakeri", "عبدالهادي أحمد كناكري", R.raw.abdelhady_ahmed_kenkary));
        listInfoReader.add(new ReaderModel("wdod", "عبدالودود حنيف", R.raw.abdelwadod_hanef));
        listInfoReader.add(new ReaderModel("abo_hashim", "علي أبو هاشم", R.raw.ali_abo_hashem));
        listInfoReader.add(new ReaderModel("ibrahim_dosri_warsh", "ابراهيم  الدوسرى", R.raw.ibrahem_aldosarey));
        listInfoReader.add(new ReaderModel("hthfi", "علي بن عبدالرحمن الحذيفي", R.raw.ali_alhozafy));
        listInfoReader.add(new ReaderModel("a_jbr", "علي جابر", R.raw.ali_gaber));
        listInfoReader.add(new ReaderModel("hajjaj", "علي حجاج السويسي", R.raw.ali_hgag_elsewasy));
        listInfoReader.add(new ReaderModel("hafz", "عماد زهير حافظ", R.raw.emad_zoheer_hafez));
        listInfoReader.add(new ReaderModel("frs_a", "فارس عباد", R.raw.fares_abad));
        listInfoReader.add(new ReaderModel("lafi", "لافي العوني", R.raw.lafy_elawny));
        listInfoReader.add(new ReaderModel("zaml", "ماجد الزامل", R.raw.maged_elzamel));
        listInfoReader.add(new ReaderModel("shaibat", "مالك شيبة الحمد", R.raw.malek_shebah_elhamed));
        listInfoReader.add(new ReaderModel("maher_m", "ماهر المعيقلي", R.raw.maher_elm3aqly));
        listInfoReader.add(new ReaderModel("maher", "ماهر المعيقلي ح", R.raw.maher_elm3aqly));
        listInfoReader.add(new ReaderModel("shaksh", "ماهر شخاشير", R.raw.maher_shakhasher));
        listInfoReader.add(new ReaderModel("ayyub", "محمد أيوب", R.raw.mohamed_ayoob));


        listInfoReader.add(new ReaderModel("mhsny", "محمد المحيسني", R.raw.mohamed_elmehesny));
        listInfoReader.add(new ReaderModel("monshed", "محمد المنشد", R.raw.mohamed_elmonshed));

        listInfoReader.add(new ReaderModel("rashad", "محمد رشاد الشريف", R.raw.mohamed_rashad_elsheref));
        listInfoReader.add(new ReaderModel("shah", "محمد صالح", R.raw.mohamed_saleh));
        listInfoReader.add(new ReaderModel("minsh", "محمد صديق المنشاوي", R.raw.mohammed_sedek));//**

        listInfoReader.add(new ReaderModel("abdullah_dori", "محمد عبدالحكيم", R.raw.mohamed_abd_elhakeem));

        listInfoReader.add(new ReaderModel("mrifai", "محمود الرفاعي", R.raw.mahmoud_elrefa3y));
        listInfoReader.add(new ReaderModel("sheimy", "محمود الشيمي", R.raw.mahmoud_elshemy));
        listInfoReader.add(new ReaderModel("husr", "محمود خليل الحصري", R.raw.mahmoud_khalil_elhosary));
        listInfoReader.add(new ReaderModel("bna_mjwd", "محمود علي البنا", R.raw.mahmoud_ali_elbana));

        listInfoReader.add(new ReaderModel("lahoni", "مصطفى اللاهوني", R.raw.mostafa_ellahony));
        listInfoReader.add(new ReaderModel("ra3ad", "مصطفى رعد العزاوي", R.raw.mostafa_ra3d_elezawy));
        listInfoReader.add(new ReaderModel("muftah_thakwan", "مفتاح السلطني", R.raw.moftah_elsaltany));
        listInfoReader.add(new ReaderModel("bilal", "موسى بلال", R.raw.mousa_belal));
        listInfoReader.add(new ReaderModel("qtm", "ناصر القطامي", R.raw.nasser_elkatamy));
        listInfoReader.add(new ReaderModel("nabil", "نبيل الرفاعي", R.raw.nabil_elrefa3y));
        //no photo
        listInfoReader.add(new ReaderModel("namh", "نعمة الحسان", R.raw.neamah_alhassan));//^^

        listInfoReader.add(new ReaderModel("hani", "هاني الرفاعي", R.raw.hani_elrefa3y));

        listInfoReader.add(new ReaderModel("yasser", "ياسر الدوسري", R.raw.yasser_eldosary));
        listInfoReader.add(new ReaderModel("qurashi", "ياسر القرشي", R.raw.yasser_elkorashy));
        listInfoReader.add(new ReaderModel("mzroyee", "ياسر المزروعي", R.raw.yasser_elmazro3y));
        //no photo
        listInfoReader.add(new ReaderModel("yahya", "يحيى حوا", R.raw.yahya_hawwa));

        listInfoReader.add(new ReaderModel("yousef", "يوسف الشويعي", R.raw.yousef_elshewa3y));
        listInfoReader.add(new ReaderModel("noah", "يوسف بن نوح أحمد", R.raw.yossef_bn_nooh_ahmed));


        return (listInfoReader);
    }

    public String serverNumber(String EnglishName) {
        String ArabicName = "11";
        if (EnglishName.endsWith("shatri"))//import
            ArabicName = "11";
        if (EnglishName.endsWith("ahmad_huth"))//import
            ArabicName = "8";
        if (EnglishName.endsWith("hawashi"))//import
            ArabicName = "11";
        if (EnglishName.endsWith("trabulsi"))
            ArabicName = "10";
        if (EnglishName.endsWith("ajm"))
            ArabicName = "10";
        if (EnglishName.endsWith("trablsi"))
            ArabicName = "10";
        if (EnglishName.endsWith("saud"))
            ArabicName = "11";
        if (EnglishName.endsWith("saber"))
            ArabicName = "8";
        if (EnglishName.endsWith("Aamer"))
            ArabicName = "10";
        if (EnglishName.endsWith("ahmad_nu"))
            ArabicName = "11";
        if (EnglishName.endsWith("akil"))
            ArabicName = "12";
        if (EnglishName.endsWith("akrm"))
            ArabicName = "9";
        if (EnglishName.endsWith("akdr"))
            ArabicName = "6";
        if (EnglishName.endsWith("IbrahemSadan"))
            ArabicName = "10";
        if (EnglishName.endsWith("abkr"))
            ArabicName = "6";
        if (EnglishName.endsWith("jbreen"))
            ArabicName = "6";
        if (EnglishName.endsWith("jormy"))
            ArabicName = "11";
        if (EnglishName.endsWith("ibrahim_dosri_warsh"))
            ArabicName = "10";
        if (EnglishName.endsWith("3siri"))
            ArabicName = "6";
        if (EnglishName.endsWith("zamri"))
            ArabicName = "12";
        if (EnglishName.endsWith("3zazi"))
            ArabicName = "8";
        if (EnglishName.endsWith("dokali"))
            ArabicName = "7";
        if (EnglishName.endsWith("alzain"))
            ArabicName = "9";
        if (EnglishName.endsWith("omran"))
            ArabicName = "9";
        if (EnglishName.endsWith("koshi"))
            ArabicName = "11";
        if (EnglishName.endsWith("fateh"))
            ArabicName = "6";
        if (EnglishName.endsWith("qari"))
            ArabicName = "11";
        if (EnglishName.endsWith("twfeeq"))
            ArabicName = "6";
        if (EnglishName.endsWith("jamal"))
            ArabicName = "6";
        if (EnglishName.endsWith("jaman"))
            ArabicName = "6";
        if (EnglishName.endsWith("hatem"))
            ArabicName = "11";
        if (EnglishName.endsWith("qht"))
            ArabicName = "10";
        if (EnglishName.endsWith("mohna"))
            ArabicName = "11";
        if (EnglishName.endsWith("kafi"))
            ArabicName = "11";
        if (EnglishName.endsWith("tnjy"))
            ArabicName = "12";
        if (EnglishName.endsWith("hamza"))
            ArabicName = "9";
        if (EnglishName.endsWith("ifrad"))
            ArabicName = "12";
        if (EnglishName.endsWith("zaki"))
            ArabicName = "9";
        if (EnglishName.endsWith("sami_dosr"))
            ArabicName = "8";
        if (EnglishName.endsWith("s_gmd"))
            ArabicName = "7";
        if (EnglishName.endsWith("shur"))
            ArabicName = "7";
        if (EnglishName.endsWith("shl"))
            ArabicName = "6";
        if (EnglishName.endsWith("sayed"))
            ArabicName = "12";
        if (EnglishName.endsWith("taher"))
            ArabicName = "12";
        if (EnglishName.endsWith("hkm"))
            ArabicName = "12";
        if (EnglishName.endsWith("sahood"))
            ArabicName = "8";
        if (EnglishName.endsWith("s_bud"))
            ArabicName = "6";
        if (EnglishName.endsWith("salah_hashim_m"))
            ArabicName = "12";
        if (EnglishName.endsWith("bu_khtr"))
            ArabicName = "8";
        if (EnglishName.endsWith("tareq"))
            ArabicName = "10";
        if (EnglishName.endsWith("a_klb"))
            ArabicName = "8";
        if (EnglishName.endsWith("ryan"))
            ArabicName = "8";
        if (EnglishName.endsWith("thubti"))
            ArabicName = "6";
        if (EnglishName.endsWith("bari"))
            ArabicName = "12";
        if (EnglishName.endsWith("bari_molm"))
            ArabicName = "10";
        if (EnglishName.endsWith("basit"))
            ArabicName = "7";
        if (EnglishName.endsWith("basit_warsh"))
            ArabicName = "10";
        if (EnglishName.endsWith("basit_mjwd"))
            ArabicName = "13";
        if (EnglishName.endsWith("sds"))
            ArabicName = "11";
        if (EnglishName.endsWith("soufi_klf"))
            ArabicName = "9";
        if (EnglishName.endsWith("soufi"))
            ArabicName = "9";
        if (EnglishName.endsWith("a_ahmed"))
            ArabicName = "11";
        if (EnglishName.endsWith("brmi"))
            ArabicName = "8";
        if (EnglishName.endsWith("Abdullahk"))
            ArabicName = "10";
        if (EnglishName.endsWith("mtrod"))
            ArabicName = "8";
        if (EnglishName.endsWith("bsfr"))
            ArabicName = "6";
        if (EnglishName.endsWith("kyat"))
            ArabicName = "12";
        if (EnglishName.endsWith("jhn"))
            ArabicName = "13";
        if (EnglishName.endsWith("mohsin_harthi"))
            ArabicName = "6";
        if (EnglishName.endsWith("obk"))
            ArabicName = "12";
        if (EnglishName.endsWith("qasm"))
            ArabicName = "8";
        if (EnglishName.endsWith("kanakeri"))
            ArabicName = "6";
        if (EnglishName.endsWith("wdod"))
            ArabicName = "8";
        if (EnglishName.endsWith("abo_hashim"))
            ArabicName = "9";
        if (EnglishName.endsWith("huthifi_qalon"))
            ArabicName = "9";
        if (EnglishName.endsWith("hthfi"))
            ArabicName = "9";
        if (EnglishName.endsWith("a_jbr"))
            ArabicName = "11";
        if (EnglishName.endsWith("hajjaj"))
            ArabicName = "9";
        if (EnglishName.endsWith("hafz"))
            ArabicName = "6";
        if (EnglishName.endsWith("frs_a"))
            ArabicName = "8";
        if (EnglishName.endsWith("lafi"))
            ArabicName = "6";
        if (EnglishName.endsWith("zaml"))
            ArabicName = "9";
        if (EnglishName.endsWith("shaibat"))
            ArabicName = "9";
        if (EnglishName.endsWith("maher_m"))
            ArabicName = "12";
        if (EnglishName.endsWith("maher"))
            ArabicName = "12";
        if (EnglishName.endsWith("shaksh"))
            ArabicName = "10";
        if (EnglishName.endsWith("ayyub"))
            ArabicName = "8";
        if (EnglishName.endsWith("braak"))
            ArabicName = "13";
        if (EnglishName.endsWith("tblawi"))
            ArabicName = "12";
        if (EnglishName.endsWith("mhsny"))
            ArabicName = "11";
        if (EnglishName.endsWith("monshed"))
            ArabicName = "10";
        if (EnglishName.endsWith("jbrl"))
            ArabicName = "8";
        if (EnglishName.endsWith("rashad"))
            ArabicName = "10";
        if (EnglishName.endsWith("shah"))
            ArabicName = "12";
        if (EnglishName.endsWith("minsh"))
            ArabicName = "10";
        if (EnglishName.endsWith("minsh_mjwd"))
            ArabicName = "11";
        if (EnglishName.endsWith("abdullah_dori"))
            if (EnglishName.endsWith("mrifai"))
                ArabicName = "12";
        if (EnglishName.endsWith("khan"))
            ArabicName = "6";
        ArabicName = "11";
        if (EnglishName.endsWith("sheimy"))
            ArabicName = "10";
        if (EnglishName.endsWith("husr"))
            ArabicName = "13";
        if (EnglishName.endsWith("bna_mjwd"))
            ArabicName = "8";
        if (EnglishName.endsWith("afs"))
            ArabicName = "8";
        if (EnglishName.endsWith("mustafa"))
            ArabicName = "8";
        if (EnglishName.endsWith("lahoni"))
            ArabicName = "6";
        if (EnglishName.endsWith("ra3ad"))
            ArabicName = "8";
        if (EnglishName.endsWith("harthi"))
            ArabicName = "8";
        if (EnglishName.endsWith("muftah_thakwan"))
            ArabicName = "11";
        if (EnglishName.endsWith("bilal"))
            ArabicName = "11";
        if (EnglishName.endsWith("qtm"))
            ArabicName = "6";
        if (EnglishName.endsWith("nabil"))
            ArabicName = "9";
        if (EnglishName.endsWith("namh"))
            ArabicName = "8";
        if (EnglishName.endsWith("hani"))
            ArabicName = "8";
        if (EnglishName.endsWith("waleed"))
            ArabicName = "9";
        if (EnglishName.endsWith("yasser"))
            ArabicName = "11";
        if (EnglishName.endsWith("qurashi"))
            ArabicName = "9";
        if (EnglishName.endsWith("mzroyee"))
            ArabicName = "9";
        if (EnglishName.endsWith("yahya"))
            ArabicName = "12";
        if (EnglishName.endsWith("yousef"))
            ArabicName = "9";
        if (EnglishName.endsWith("noah"))
            ArabicName = "8";
        if (EnglishName.endsWith("shatri"))
            ArabicName = "11";
        if (EnglishName.endsWith("ahmad_huth"))
            ArabicName = "8";
        if (EnglishName.endsWith("hawashi"))
            ArabicName = "11";
        if (EnglishName.endsWith("trabulsi"))
            ArabicName = "10";
        if (EnglishName.endsWith("ajm"))
            ArabicName = "10";
        if (EnglishName.endsWith("trablsi"))
            ArabicName = "10";
        if (EnglishName.endsWith("saud"))
            ArabicName = "11";
        if (EnglishName.endsWith("saber"))
            ArabicName = "8";
        if (EnglishName.endsWith("Aamer"))
            ArabicName = "10";
        if (EnglishName.endsWith("ahmad_nu"))
            ArabicName = "11";
        if (EnglishName.endsWith("akil"))
            ArabicName = "12";
        if (EnglishName.endsWith("akrm"))
            ArabicName = "9";
        if (EnglishName.endsWith("akdr"))
            ArabicName = "6";
        if (EnglishName.endsWith("IbrahemSadan"))
            ArabicName = "10";
        if (EnglishName.endsWith("abkr"))
            ArabicName = "6";
        if (EnglishName.endsWith("jbreen"))
            ArabicName = "6";
        if (EnglishName.endsWith("jormy"))
            ArabicName = "11";
        if (EnglishName.endsWith("ibrahim_dosri_warsh"))
            ArabicName = "10";
        if (EnglishName.endsWith("3siri"))
            ArabicName = "6";
        if (EnglishName.endsWith("zamri"))
            ArabicName = "12";
        if (EnglishName.endsWith("3zazi"))
            ArabicName = "8";
        if (EnglishName.endsWith("dokali"))
            ArabicName = "7";
        if (EnglishName.endsWith("alzain"))
            ArabicName = "9";
        if (EnglishName.endsWith("omran"))
            ArabicName = "9";
        if (EnglishName.endsWith("koshi"))
            ArabicName = "11";
        if (EnglishName.endsWith("fateh"))
            ArabicName = "6";
        if (EnglishName.endsWith("qari"))
            ArabicName = "11";
        if (EnglishName.endsWith("twfeeq"))
            ArabicName = "6";
        if (EnglishName.endsWith("jamal"))
            ArabicName = "6";
        if (EnglishName.endsWith("jaman"))
            ArabicName = "6";
        if (EnglishName.endsWith("hatem"))
            ArabicName = "11";
        if (EnglishName.endsWith("qht"))
            ArabicName = "10";
        if (EnglishName.endsWith("mohna"))
            ArabicName = "11";
        if (EnglishName.endsWith("kafi"))
            ArabicName = "11";
        if (EnglishName.endsWith("tnjy"))
            ArabicName = "12";
        if (EnglishName.endsWith("hamza"))
            ArabicName = "9";
        if (EnglishName.endsWith("ifrad"))
            ArabicName = "12";
        if (EnglishName.endsWith("zaki"))
            ArabicName = "9";
        if (EnglishName.endsWith("sami_dosr"))
            ArabicName = "8";
        if (EnglishName.endsWith("s_gmd"))
            ArabicName = "7";
        if (EnglishName.endsWith("shur"))
            ArabicName = "7";
        if (EnglishName.endsWith("shl"))
            ArabicName = "6";
        if (EnglishName.endsWith("sayed"))
            ArabicName = "12";
        if (EnglishName.endsWith("taher"))
            ArabicName = "12";
        if (EnglishName.endsWith("hkm"))
            ArabicName = "12";
        if (EnglishName.endsWith("sahood"))
            ArabicName = "8";
        if (EnglishName.endsWith("s_bud"))
            ArabicName = "6";
        if (EnglishName.endsWith("salah_hashim_m"))
            ArabicName = "12";
        if (EnglishName.endsWith("bu_khtr"))
            ArabicName = "8";
        if (EnglishName.endsWith("tareq"))
            ArabicName = "10";
        if (EnglishName.endsWith("a_klb"))
            ArabicName = "8";
        if (EnglishName.endsWith("ryan"))
            ArabicName = "8";
        if (EnglishName.endsWith("thubti"))
            ArabicName = "6";
        if (EnglishName.endsWith("bari"))
            ArabicName = "12";
        if (EnglishName.endsWith("bari_molm"))
            ArabicName = "10";
        if (EnglishName.endsWith("basit"))
            ArabicName = "7";
        if (EnglishName.endsWith("basit_warsh"))
            ArabicName = "10";
        if (EnglishName.endsWith("basit_mjwd"))
            ArabicName = "13";
        if (EnglishName.endsWith("sds"))
            ArabicName = "11";
        if (EnglishName.endsWith("soufi_klf"))
            ArabicName = "9";
        if (EnglishName.endsWith("soufi"))
            ArabicName = "9";
        if (EnglishName.endsWith("a_ahmed"))
            ArabicName = "11";
        if (EnglishName.endsWith("brmi"))
            ArabicName = "8";
        if (EnglishName.endsWith("Abdullahk"))
            ArabicName = "10";
        if (EnglishName.endsWith("mtrod"))
            ArabicName = "8";
        if (EnglishName.endsWith("bsfr"))
            ArabicName = "6";
        if (EnglishName.endsWith("kyat"))
            ArabicName = "12";
        if (EnglishName.endsWith("jhn"))
            ArabicName = "13";
        if (EnglishName.endsWith("mohsin_harthi"))
            ArabicName = "6";
        if (EnglishName.endsWith("obk"))
            ArabicName = "12";
        if (EnglishName.endsWith("qasm"))
            ArabicName = "8";
        if (EnglishName.endsWith("kanakeri"))
            ArabicName = "6";
        if (EnglishName.endsWith("wdod"))
            ArabicName = "8";
        if (EnglishName.endsWith("abo_hashim"))
            ArabicName = "9";
        if (EnglishName.endsWith("huthifi_qalon"))
            ArabicName = "9";
        if (EnglishName.endsWith("hthfi"))
            ArabicName = "9";
        if (EnglishName.endsWith("a_jbr"))
            ArabicName = "11";
        if (EnglishName.endsWith("hajjaj"))
            ArabicName = "9";
        if (EnglishName.endsWith("hafz"))
            ArabicName = "6";
        if (EnglishName.endsWith("frs_a"))
            ArabicName = "8";
        if (EnglishName.endsWith("lafi"))
            ArabicName = "6";
        if (EnglishName.endsWith("zaml"))
            ArabicName = "9";
        if (EnglishName.endsWith("shaibat"))
            ArabicName = "9";
        if (EnglishName.endsWith("maher_m"))
            ArabicName = "12";
        if (EnglishName.endsWith("maher"))
            ArabicName = "12";
        if (EnglishName.endsWith("shaksh"))
            ArabicName = "10";
        if (EnglishName.endsWith("ayyub"))
            ArabicName = "8";
        if (EnglishName.endsWith("braak"))
            ArabicName = "13";
        if (EnglishName.endsWith("tblawi"))
            ArabicName = "12";
        if (EnglishName.endsWith("mhsny"))
            ArabicName = "11";
        if (EnglishName.endsWith("monshed"))
            ArabicName = "10";
        if (EnglishName.endsWith("jbrl"))
            ArabicName = "8";
        if (EnglishName.endsWith("rashad"))
            ArabicName = "10";
        if (EnglishName.endsWith("shah"))
            ArabicName = "12";
        if (EnglishName.endsWith("minsh"))
            ArabicName = "10";
        if (EnglishName.endsWith("minsh_mjwd"))
            ArabicName = "11";
        if (EnglishName.endsWith("abdullah_dori"))
            ArabicName = "12";
        if (EnglishName.endsWith("khan"))
            ArabicName = "6";
        if (EnglishName.endsWith("mrifai"))
            ArabicName = "11";
        if (EnglishName.endsWith("sheimy"))
            ArabicName = "10";
        if (EnglishName.endsWith("husr"))
            ArabicName = "13";
        if (EnglishName.endsWith("bna_mjwd"))
            ArabicName = "8";
        if (EnglishName.endsWith("afs"))
            ArabicName = "8";
        if (EnglishName.endsWith("mustafa"))
            ArabicName = "8";
        if (EnglishName.endsWith("lahoni"))
            ArabicName = "6";
        if (EnglishName.endsWith("ra3ad"))
            ArabicName = "8";
        if (EnglishName.endsWith("harthi"))
            ArabicName = "8";
        if (EnglishName.endsWith("muftah_thakwan"))
            ArabicName = "11";
        if (EnglishName.endsWith("bilal"))
            ArabicName = "11";
        if (EnglishName.endsWith("qtm"))
            ArabicName = "6";
        if (EnglishName.endsWith("nabil"))
            ArabicName = "9";
        if (EnglishName.endsWith("namh"))
            ArabicName = "8";
        if (EnglishName.endsWith("hani"))
            ArabicName = "8";
        if (EnglishName.endsWith("waleed"))
            ArabicName = "9";
        if (EnglishName.endsWith("yasser"))
            ArabicName = "11";
        if (EnglishName.endsWith("qurashi"))
            ArabicName = "9";
        if (EnglishName.endsWith("mzroyee"))
            ArabicName = "9";
        if (EnglishName.endsWith("yahya"))
            ArabicName = "12";
        if (EnglishName.endsWith("yousef"))
            ArabicName = "9";
        if (EnglishName.endsWith("noah"))
            ArabicName = "8";
        return ArabicName;


    }

    public ArrayList<QuranModel> GuranAya(String ReciteName) {

        listQuranAya.clear();
        listQuranAya.add(new QuranModel("001", "الفاتحة"));
        listQuranAya.add(new QuranModel("002", "البقرة"));
        listQuranAya.add(new QuranModel("003", "ال عمران "));
        listQuranAya.add(new QuranModel("004", "النساء"));
        listQuranAya.add(new QuranModel("005", "المائدة"));
        listQuranAya.add(new QuranModel("006", "الانعام"));
        listQuranAya.add(new QuranModel("007", "الأعراف"));
        listQuranAya.add(new QuranModel("008", "الأنفال"));
        listQuranAya.add(new QuranModel("009", "التوبة "));
        listQuranAya.add(new QuranModel("010", "يونس"));
        listQuranAya.add(new QuranModel("011", "هود"));
        listQuranAya.add(new QuranModel("012", "يوسف"));
        listQuranAya.add(new QuranModel("013", "الرعد"));
        listQuranAya.add(new QuranModel("014", "إبراهيم"));
        listQuranAya.add(new QuranModel("015", "الحجر"));
        listQuranAya.add(new QuranModel("016", "النحل"));
        listQuranAya.add(new QuranModel("017", "الإسراء"));
        listQuranAya.add(new QuranModel("018", "الكهف"));
        listQuranAya.add(new QuranModel("019", "مريم"));
        listQuranAya.add(new QuranModel("020", "طه"));
        listQuranAya.add(new QuranModel("021", "الأنبياء"));
        listQuranAya.add(new QuranModel("022", "الحج"));
        listQuranAya.add(new QuranModel("023", "المؤمنون"));
        listQuranAya.add(new QuranModel("024", "النّور"));
        listQuranAya.add(new QuranModel("025", "الفرقان "));
        listQuranAya.add(new QuranModel("026", "الشعراء "));
        listQuranAya.add(new QuranModel("027", "النّمل"));
        listQuranAya.add(new QuranModel("028", "القصص"));
        listQuranAya.add(new QuranModel("029", "العنكبوت"));
        listQuranAya.add(new QuranModel("030", "الرّوم"));
        listQuranAya.add(new QuranModel("031", "لقمان"));
        listQuranAya.add(new QuranModel("032", "السجدة"));
        listQuranAya.add(new QuranModel("033", "الأحزاب"));
        listQuranAya.add(new QuranModel("034", "سبأ"));
        listQuranAya.add(new QuranModel("035", "فاطر"));
        listQuranAya.add(new QuranModel("036", "يس"));
        listQuranAya.add(new QuranModel("037", "الصافات"));
        listQuranAya.add(new QuranModel("038", "ص"));
        listQuranAya.add(new QuranModel("039", "الزمر"));
        listQuranAya.add(new QuranModel("040", "غافر"));
        listQuranAya.add(new QuranModel("041", "فصّلت"));
        listQuranAya.add(new QuranModel("042", "الشورى"));
        listQuranAya.add(new QuranModel("043", "الزخرف"));
        listQuranAya.add(new QuranModel("044", "الدّخان"));
        listQuranAya.add(new QuranModel("045", "الجاثية"));
        listQuranAya.add(new QuranModel("046", "الأحقاف"));
        listQuranAya.add(new QuranModel("047", "محمد"));
        listQuranAya.add(new QuranModel("048", "الفتح"));
        listQuranAya.add(new QuranModel("049", "الحجرات"));
        listQuranAya.add(new QuranModel("050", "ق"));
        listQuranAya.add(new QuranModel("051", "الذاريات"));
        listQuranAya.add(new QuranModel("052", "الطور"));
        listQuranAya.add(new QuranModel("053", "النجم"));
        listQuranAya.add(new QuranModel("054", "القمر"));
        listQuranAya.add(new QuranModel("055", "الرحمن"));
        listQuranAya.add(new QuranModel("056", "الواقعة"));
        listQuranAya.add(new QuranModel("057", "الحديد"));
        listQuranAya.add(new QuranModel("058", "المجادلة"));
        listQuranAya.add(new QuranModel("059", "الحشر"));
        listQuranAya.add(new QuranModel("060", "الممتحنة"));
        listQuranAya.add(new QuranModel("061", "الصف"));
        listQuranAya.add(new QuranModel("062", "الجمعة"));
        listQuranAya.add(new QuranModel("063", "المنافقون"));
        listQuranAya.add(new QuranModel("064", "التغابن"));
        listQuranAya.add(new QuranModel("065", "الطلاق"));
        listQuranAya.add(new QuranModel("066", "التحريم"));
        listQuranAya.add(new QuranModel("067", "الملك"));
        listQuranAya.add(new QuranModel("068", "القلم"));
        listQuranAya.add(new QuranModel("069", "الحاقة"));
        listQuranAya.add(new QuranModel("070", "المعارج"));
        listQuranAya.add(new QuranModel("071", "نوح"));
        listQuranAya.add(new QuranModel("072", "الجن"));
        listQuranAya.add(new QuranModel("073", "المزّمّل"));
        listQuranAya.add(new QuranModel("074", "المدّثر"));
        listQuranAya.add(new QuranModel("075", "القيامة"));
        listQuranAya.add(new QuranModel("076", "الإنسان"));
        listQuranAya.add(new QuranModel("077", "المرسلات"));
        listQuranAya.add(new QuranModel("078", "النبأ"));
        listQuranAya.add(new QuranModel("079", "النازعات"));
        listQuranAya.add(new QuranModel("080", "عبس"));
        listQuranAya.add(new QuranModel("081", "التكوير"));
        listQuranAya.add(new QuranModel("082", "الإنفطار"));
        listQuranAya.add(new QuranModel("083", "المطفّفين"));
        listQuranAya.add(new QuranModel("084", "الإنشقاق"));
        listQuranAya.add(new QuranModel("085", "البروج"));
        listQuranAya.add(new QuranModel("086", "الطارق"));
        listQuranAya.add(new QuranModel("087", "الأعلى"));
        listQuranAya.add(new QuranModel("088", "الغاشية"));
        listQuranAya.add(new QuranModel("089", "الفجر"));
        listQuranAya.add(new QuranModel("090", "البلد"));
        listQuranAya.add(new QuranModel("091", "الشمس"));
        listQuranAya.add(new QuranModel("092", "الليل"));
        listQuranAya.add(new QuranModel("093", "الضحى"));
        listQuranAya.add(new QuranModel("094", "الشرح"));
        listQuranAya.add(new QuranModel("095", "التين"));
        listQuranAya.add(new QuranModel("096", "العلق"));
        listQuranAya.add(new QuranModel("097", "القدر"));
        listQuranAya.add(new QuranModel("098", "البينة"));
        listQuranAya.add(new QuranModel("099", "الزلزلة"));
        listQuranAya.add(new QuranModel("100", "العاديات"));
        listQuranAya.add(new QuranModel("101", "القارعة"));
        listQuranAya.add(new QuranModel("102", "التكاثر"));
        listQuranAya.add(new QuranModel("103", "العصر"));
        listQuranAya.add(new QuranModel("104", "الهمزة"));
        listQuranAya.add(new QuranModel("105", "الفيل"));
        listQuranAya.add(new QuranModel("106", "قريش"));
        listQuranAya.add(new QuranModel("107", "الماعون"));
        listQuranAya.add(new QuranModel("108", "الكوثر"));
        listQuranAya.add(new QuranModel("109", "الكافرون"));
        listQuranAya.add(new QuranModel("110", "النصر"));
        listQuranAya.add(new QuranModel("111", "المسد"));
        listQuranAya.add(new QuranModel("112", "الإخلاص"));
        listQuranAya.add(new QuranModel("113", "الفلق"));
        listQuranAya.add(new QuranModel("114", "النّاس"));

        ListBeginEndAya ListRange = new ListBeginEndAya();
        ListRange = managment.autherRanageDetermine(ReciteName);
        ListAyaRanage.clear();
        //IsolatedStorageFile isoStore = IsolatedStorageFile.GetUserStoreForApplication();
        String AYAPAth;

        for (int i = ListRange.beginR; i < ListRange.endread; i++) {
            try {


                QuranModel ac = new QuranModel();
                ac = listQuranAya.get(i);
//                String SDPath = Environment.getExternalStorageDirectory().getPath() + "/";
//
//                AYAPAth = SDPath + ReciteName + ac.serverName + ".mp3";
//
//                //    String[] fmyFilemyFileiles = isoStore.GetFileNames(RealServerFolder + ListAya[i].ServerName + ".mp3");
//                File myFile = new File(AYAPAth);
//                if (myFile.exists())
//                    ListAyaRanage.add(new QuranModel(ac.serverName, ac.realName, avalible(), AYAPAth));
//                else {
//                    AYAPAth = "http://server" + serverNumber(ReciteName) + ".mp3quran.net/" + ReciteName + "/" + ac.serverName + ".mp3";
//
//                    //  AYAPAth = "http://www.quran.alrubaye.com/quran/" + LnaguageClass.RecitesName + "/" + ac.ServerName + ".mp3";
//                    ListAyaRanage.add(new QuranModel(ac.serverName, ac.realName, disavalible(), AYAPAth));
//                }
                String fileName = ReciteName + ac.serverName + ".mp3" ;
                File file =new File( Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC),fileName);
                String path = file.getPath();
                if (file.exists())
                    ListAyaRanage.add(new QuranModel(ac.serverName, ac.realName, avalible(), path, R.drawable.ic_download_checked));
                else {
                    AYAPAth = "http://server" + serverNumber(ReciteName) + ".mp3quran.net/" + ReciteName + "/" + ac.serverName + ".mp3";

                    //  AYAPAth = "http://www.quran.alrubaye.com/quran/" + LnaguageClass.RecitesName + "/" + ac.ServerName + ".mp3";
                    ListAyaRanage.add(new QuranModel(ac.serverName, ac.realName, disavalible(), AYAPAth,R.drawable.ic_download_dark));
                }

            } catch (Exception ex) {
            }


        }

        return (ListAyaRanage);

    }

    private String disavalible() {
        return ("من الانترنت");
    }

    private String avalible() {
        return ("من الهاتف");
    }

}