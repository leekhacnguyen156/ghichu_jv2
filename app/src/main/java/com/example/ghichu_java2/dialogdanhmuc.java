package com.example.ghichu_java2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class dialogdanhmuc extends AppCompatDialogFragment {
    private EditText editTextTenloai;
    private dialogdanhmucListener listener;

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dl_danhmuc, null);

        builder.setView(view)
                .setTitle("Tên Danh Mục")
                .setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String tenloai = editTextTenloai.getText().toString();
                        listener.applyText(tenloai);
                    }
                });

                editTextTenloai = view.findViewById(R.id.tenloai);
                return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (dialogdanhmucListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "gắn cái dialogdanhmucListener");
        }
    }

    public interface dialogdanhmucListener{
        void applyText(String tenloai);
    }
}
