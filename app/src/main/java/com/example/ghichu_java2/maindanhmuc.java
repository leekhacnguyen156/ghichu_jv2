package com.example.ghichu_java2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class maindanhmuc extends AppCompatActivity{

    ArrayList<danhmuc> Listdm = new ArrayList<danhmuc>();
    adapterdanhmuc addanhmuc;
    private TextView tv_tenloai;
    private TextView tv_opdialog;
    private ListView lv_danhmuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhmuc);}}

//        tv_tenloai = (TextView) findViewById(R.id.tenloai);
//        tv_opdialog = (TextView) findViewById(R.id.opdialog);
//        tv_opdialog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                AlertDialog.Builder builder = new AlertDialog.Builder(maindanhmuc.this);
////
////                LayoutInflater inflater = maindanhmuc.this.getLayoutInflater();
////                View xem = inflater.inflate(R.layout.dl_danhmuc, null);
////                EditText editTextTenloai = findViewById(R.id.tenloai);
////
////                builder.setView(view)
////                        .setTitle("Tên Danh Mục")
////                        .setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
////                            @Override
////                            public void onClick(DialogInterface dialogInterface, int i) {
////
////                            }
////                        })
////                        .setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
////                            @Override
////                            public void onClick(DialogInterface dialogInterface, int i) {
////                                String tenloai = editTextTenloai.getText().toString();
////                                danhmuc dm = new danhmuc("0", tenloai,"duydeptrai");
////                                Listdm.add(dm);
////                            }
//                       });
//              AlertDialog alert = builder.create();
//              alert.show();
//            }});
//        addanhmuc = new adapterdanhmuc(maindanhmuc.this, R.layout.itemdanhmuc, Listdm);
//        lv_danhmuc = findViewById(R.id.lv_danhmuc);
//
//        lv_danhmuc.setAdapter(addanhmuc);
//        addanhmuc.notifyDataSetChanged();
//    }
//
//    public void openDialog() {
//        dialogdanhmuc dialogdm = new dialogdanhmuc();
//        dialogdm.show(getSupportFragmentManager(), "danh mục");
//    }
//}