package com.kaream.ehap.quranapp.utials;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kaream.ehap.quranapp.R;

public class DialogPage extends AppCompatDialogFragment {

    private EditText pageNum;
    private DialogInterFace listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog, null);
        alertDialog.setView(view)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String input = pageNum.getText().toString();
                        if (input.isEmpty() && input.equals("")) {
                            Toast.makeText(getActivity(), "Please Fill Data", Toast.LENGTH_SHORT).show();
                        } else {
                            listener.applyText(input);
                        }
                    }
                });

        pageNum = view.findViewById(R.id.pageSubmitNum);
        return alertDialog.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (DialogInterFace) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "Must implement the DialogInterFace");
        }

    }

    public interface DialogInterFace {
        void applyText(String pageNum);
    }
}
