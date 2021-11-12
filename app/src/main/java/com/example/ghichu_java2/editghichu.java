package com.example.ghichu_java2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class editghichu extends AppCompatActivity {
    String tieude = null;
    String noidung = null;
    FirebaseDatabase database;
    DatabaseReference ref;
    EditText edttieude;
    EditText edtnoidung;
    String id;
    String thoigiantao;
    String hinhanh;
    ImageView btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editghichu);

        edttieude = (EditText) findViewById(R.id.tieude);
        edtnoidung = (EditText) findViewById(R.id.note);
        btnSave = (ImageView) findViewById(R.id.checked);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference("ghichu");
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        if(bundle != null){
            id = bundle.getString("id");
            tieude = bundle.getString("tieude");
            noidung = bundle.getString("noidung");
            hinhanh = bundle.getString("hinhanh");
            thoigiantao = bundle.getString("thoigiantao");
            edttieude.setText(tieude);
            edtnoidung.setText(noidung);
        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tieude != null){
                    Query query = ref.orderByChild("tieude").equalTo(tieude);
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot note : dataSnapshot.getChildren()){
                                String tieude = edttieude.getText().toString();
                                String noidung = edtnoidung.getText().toString();
                                ghichu gc = new ghichu(id,tieude,noidung,hinhanh,thoigiantao);
                                note.getRef().setValue(gc);
                            }
                            close();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });

    }

    private void close(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}