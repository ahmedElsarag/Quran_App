package com.kaream.ehap.quranapp.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kaream.ehap.quranapp.Model.ReaderModel;
import com.kaream.ehap.quranapp.R;

import java.util.ArrayList;

public class CustomArrayAdapterForReader extends ArrayAdapter<ReaderModel> {


    Context context;
    ArrayList<ReaderModel> readerModels;
    int layoutResourceId;
    public LayoutInflater inflater;
    Typeface typeface;

    public CustomArrayAdapterForReader(Context context1, ArrayList<ReaderModel> readerModels, int layoutResourceId) {
        super(context1, layoutResourceId, readerModels);
        this.context = context1;
        this.readerModels = readerModels;
        this.layoutResourceId = layoutResourceId;
        this.inflater = LayoutInflater.from(context1);
    }

//    public static int calculateInSampleSize(
//            BitmapFactory.Options options, int reqWidth, int reqHeight) {
//        // Raw height and width of image
//        final int height = options.outHeight;
//        final int width = options.outWidth;
//        int inSampleSize = 1;
//
//        if (height > reqHeight || width > reqWidth) {
//
//            final int halfHeight = height / 2;
//            final int halfWidth = width / 2;
//
//            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
//            // height and width larger than the requested height and width.
//            while ((halfHeight / inSampleSize) > reqHeight
//                    && (halfWidth / inSampleSize) > reqWidth) {
//                inSampleSize *= 2;
//            }
//        }
//
//        return inSampleSize;
//    }
//
//    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
//                                                         int reqWidth, int reqHeight) {
//
//        // First decode with inJustDecodeBounds=true to check dimensions
//        final BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeResource(res, resId, options);
//
//        // Calculate inSampleSize
//        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
//
//        // Decode bitmap with inSampleSize set
//        options.inJustDecodeBounds = false;
//        return BitmapFactory.decodeResource(res, resId, options);
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;
        if (row == null) {
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new RecordHolder();
            holder.txtRecitesName = row.findViewById(R.id.txt_qauraName);
            holder.image_qura = row.findViewById(R.id.img_qaura);
           // holder.frameLayout = row.findViewById(R.id.frame_background);
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }
        ReaderModel temp = readerModels.get(position);
        typeface = Typeface.createFromAsset(context.getAssets(), "Fonts/Droid_Sans_Arabic.ttf");
        holder.txtRecitesName.setTypeface(typeface);
        holder.txtRecitesName.setText(temp.realName);
        Glide.with(context)
                .load(temp.imgDrawable)
                .into(holder.image_qura);
        return row;
    }


    static class RecordHolder {
        TextView txtRecitesName;
        ImageView image_qura;
        FrameLayout frameLayout;
    }
}
