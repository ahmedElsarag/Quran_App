package com.kaream.ehap.quranapp.utials;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;

public class MarkerDialog extends AppCompatDialogFragment {

    private DialogInterFaceClick listner;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("هل تريد وضع العلامة هنا؟")
                .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listner.onClick();
                    }
                })
                .setNegativeButton("لا", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        return alertDialog.create();


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listner = (DialogInterFaceClick) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "Must implement the DialogInterFaceClick");
        }

    }

    public interface DialogInterFaceClick {
        void onClick();
    }
}
