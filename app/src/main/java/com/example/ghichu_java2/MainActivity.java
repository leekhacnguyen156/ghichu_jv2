package com.example.ghichu_java2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<ghichu> ListGC;
    adapterGC adapter;
    ListView lvghichu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        getProduct();


        lvghichu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                viewEdit(i);
            }
        });

    }
    private void viewEdit(int index){
        ghichu gc = ListGC.get(index);
        String id = gc.getId();
        String tieude = gc.getTieude();
        String noidung = gc.getNoidung();
        String hinhanh = gc.getHinhanh();
        String thoigiantao = gc.getThoigiantao();
        Intent intent = new Intent(MainActivity.this, editghichu.class);
        Bundle bundle = new Bundle();
        bundle.putString("id",id);
        bundle.putString("tieude", tieude);
        bundle.putString("noidung", noidung);
        bundle.putString("hinhanh",hinhanh);
        bundle.putString("thoigiantao",thoigiantao);
        intent.putExtra("data",bundle);
        startActivity(intent);
    }


    private void init(){
        lvghichu = (ListView) findViewById(R.id.lv_ghichu);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("ghichu");
    }

    private void getProduct(){

        //set adapter
        ListGC = new ArrayList<>();
        adapter = new adapterGC(
                MainActivity.this,
                R.layout.activity_dsghichu,
                ListGC);
        lvghichu.setAdapter(adapter);

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ghichu gc = dataSnapshot.getValue(ghichu.class);
                ListGC.add(gc);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) { }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) { }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }
        });
    }

}