package com.kaream.ehap.quranapp.Model;

import com.kaream.ehap.quranapp.R;

import java.util.ArrayList;

public class ImageSliderData {


    public ArrayList<ReadQuranModel> image_page_index = new ArrayList<>();
    public ArrayList<ReadQuranModel> image_sour_index = new ArrayList<>();
    public ArrayList<ReadQuranModel> image_Ajza_index = new ArrayList<>();

    /**
     * function to return object form list contain the all image index
     *
     * @return
     */
    public ArrayList<ReadQuranModel> getImage_page_index() {
        int PAG_NUM = 604;
        String strPath;
        image_page_index.clear();

        for (int i = 1; i <= PAG_NUM; i++) {
            strPath = "p" + i + ".png";
            image_page_index.add(new ReadQuranModel(strPath));
        }

        return image_page_index;
    }

    /**
     * function to return sour with index for first image
     *
     * @return
     */
    public ArrayList<ReadQuranModel> getImage_sour_index() {


        image_sour_index.clear();
        image_sour_index.add(new ReadQuranModel("p1.png", 1, "الفاتحة", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p2.png", 2, "البقرة", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p50.png", 50, "ال عمران", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p77.png", 77, "النساء", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p106.png", 106, "المائدة", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p128.png", 128, "الانعام", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p151.png", 151, "الأعراف", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p177.png", 177, "الأنفال", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p187.png", 187, "التوبة", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p208.png", 208, "يونس", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p221.png", 221, "هود", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p235.png", 235, "يوسف", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p249.png", 249, "الرعد", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p255.png", 255, "إبراهيم", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p262.png", 262, "الحجر", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p267.png", 267, "النحل", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p282.png", 282, "الإسراء", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p293.png", 293, "الكهف", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p305.png", 305, "مريم", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p312.png", 312, "طه", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p322.png", 322, "الأنبياء", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p332png", 332, "الحج", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p342.png", 342, "المؤمنون", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p350.png", 350, "النّور", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p359.png", 359, "الفرقان", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p367.png", 367, "الشعراء", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p377.png", 377, "النّمل", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p385.png", 385, "القصص", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p396.png", 396, "العنكبوت", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p404.png", 404, "الرّوم", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p411.png", 411, "لقمان", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p415.png", 415, " السجدة", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p418.png", 418, "الأحزاب", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p428.png", 428, "سبأ", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p434.png", 434, "فاطر", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p440.png", 440, "يس", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p446.png", 446, "الصافات", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p453.png", 353, "ص", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p458.png", 458, "الزمر", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p467.png", 467, "غافر", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p477.png", 477, "فصّلت", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p483.png", 483, "الشورى", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p489.png", 489, "الزخرف", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p496.png", 496, "الدّخان", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p499.png", 499, "الجاثية", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p502.png", 502, "الأحقاف", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p507.png", 507, "محمد", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p511.png", 511, "الفتح", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p515.png", 515, "الحجرات", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p518.png", 518, "ق", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p520.png", 520, "الذاريات", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p523.png", 523, "الطور", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p526.png", 526, "النجم", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p528.png", 528, "القمر", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p531.png", 531, "الرحمن", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p534.png", 534, "الواقعة", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p537.png", 537, "الحديد", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p542.png", 542, "المجادلة", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p545.png", 545, "الحشر", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p549.png", 545, "الممتحنة", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p551.png", 551, "الصف", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p553.png", 553, "الجمعة", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p554.png", 554, "المنافقون", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p556.png", 556, "التغابن", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p558.png", 558, "الطلاق", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p560.png", 560, "التحريم", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p562.png", 562, "الملك", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p564.png", 564, "القلم", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p566.png", 566, "الحاقة", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p568.png", 568, "المعارج", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p570.png", 570, "نوح", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p572.png", 566, "الجن", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p574.png", 574, "المزمل", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p575.png", 575, "المدثر", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p577.png", 577, "القيامه", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p578.png", 578, "الانسان", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p580.png", 580, "المرسلات", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p582.png", 582, "النبأ", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p583.png", 583, "النازعات", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p585.png", 585, "عبس", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p586.png", 586, "التكوير", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p587.png", 587, "الانفطار", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p587.png", 587, "المطففين", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p589.png", 589, "الانشقاق", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p590.png", 590, "البروج", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p591.png", 591, "الطارق", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p591.png", 591, "الاعلى", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p592.png", 592, "الغاشية", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p593.png", 593, "الفجر", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p594.png", 594, "البلد", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p595.png", 595, "الشمس", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p595.png", 595, "الليل", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p596.png", 596, "الضحى", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p596.png", 596, "لشرح", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p597.png", 597, "التين", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p597.png", 597, "العلق", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p598.png", 598, "القدر", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p598.png", 598, "البينة", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p599.png", 599, "الزلزلة", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p599.png", 599, "العاديات", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p600.png", 600, "القارعة", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p600.png", 600, "التكاثر", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p601.png", 601, "العصر", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p601.png", 601, "الهمزة", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p601.png", 601, "الفيل", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p602.png", 602, "قريش", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p602.png", 602, "الماعون", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p602.png", 602, "الكوثر", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p603.png", 603, "الكافرون", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p603.png", 603, "النصر", R.raw.t2));
        image_sour_index.add(new ReadQuranModel("p603.png", 603, "المسد", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p604.png", 604, "الاخلاص", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p604.png", 604, "الفلق", R.raw.t1));
        image_sour_index.add(new ReadQuranModel("p604.png", 604, "الناس", R.raw.t1));
        return image_sour_index;
    }


    public ArrayList<ReadQuranModel> getImage_Ajza_index() {
        image_Ajza_index.add(new
                ReadQuranModel("p1.png", 1, "الجزءالاول"));
        image_Ajza_index.add(new
                ReadQuranModel("p22.png", 22, "الجزءالثانى"));
        image_Ajza_index.add(new
                ReadQuranModel("p42.png", 42, "الجزءالثالث"));
        image_Ajza_index.add(new
                ReadQuranModel("p62.png", 62, "الجزءالرابع"));
        image_Ajza_index.add(new
                ReadQuranModel("p82.png", 82, "الجزءالخامس"));
        image_Ajza_index.add(new
                ReadQuranModel("p102.png", 102, "الجزءالسادس"));
        image_Ajza_index.add(new
                ReadQuranModel("p121.png", 121, "الجزءالسابع"));
        image_Ajza_index.add(new
                ReadQuranModel("p142.png", 142, "الجزءالثامن"));
        image_Ajza_index.add(new
                ReadQuranModel("p162.png", 162, "الجزءالتاسع"));
        image_Ajza_index.add(new
                ReadQuranModel("p182.png", 182, "الجزءالعاشر"));
        image_Ajza_index.add(new
                ReadQuranModel("p201.png", 201, "الجزءالحادى عشر"));
        image_Ajza_index.add(new
                ReadQuranModel("p222.png", 222, "الجزءالثانى عشر"));
        image_Ajza_index.add(new
                ReadQuranModel("p242.png", 242, "الجزءالثالث عشر"));
        image_Ajza_index.add(new
                ReadQuranModel("p262.png", 262, "الجزءالرابع عشر"));
        image_Ajza_index.add(new
                ReadQuranModel("p282.png", 282, "الجزءالخامس عشر"));
        image_Ajza_index.add(new
                ReadQuranModel("p302.png", 302, "الجزءالسادس عشر"));
        image_Ajza_index.add(new
                ReadQuranModel("p322.png", 322, "الجزءالسابع عشر"));
        image_Ajza_index.add(new
                ReadQuranModel("p342.png", 342, "الجزءالثامن عشر"));
        image_Ajza_index.add(new
                ReadQuranModel("p362.png", 362, "الجزءالتاسع عشر"));
        image_Ajza_index.add(new
                ReadQuranModel("p382.png", 382, "الجزءالعشرون"));
        image_Ajza_index.add(new
                ReadQuranModel("p402.png", 402, "الجزءالحادى والعشرون"));
        image_Ajza_index.add(new
                ReadQuranModel("p422.png", 422, "الجزءالثانى والعشرون"));
        image_Ajza_index.add(new
                ReadQuranModel("p442.png", 442, "الجزءالثالث والعشرون"));
        image_Ajza_index.add(new
                ReadQuranModel("p462.png", 462, "الجزءالرابع والعشرون"));
        image_Ajza_index.add(new
                ReadQuranModel("p482.png", 482, "الجزءالخامس والعشرون"));
        image_Ajza_index.add(new
                ReadQuranModel("p502.png", 502, "الجزءالسادس والعشرون"));
        image_Ajza_index.add(new
                ReadQuranModel("p522.png", 522, "الجزءالسابع والعشرون"));
        image_Ajza_index.add(new
                ReadQuranModel("p542.png", 542, "الجزءالثامن والعشرون"));
        image_Ajza_index.add(new
                ReadQuranModel("p562.png", 562, "الجزءالتاسع والعشرون"));
        image_Ajza_index.add(new
                ReadQuranModel("p582.png", 582, "الجزءالثلاثون"));
        return image_Ajza_index;
    }


}
