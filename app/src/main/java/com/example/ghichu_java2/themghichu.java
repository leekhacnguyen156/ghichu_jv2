package com.example.ghichu_java2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class themghichu extends AppCompatActivity {
    EditText note;
    EditText tieude;
    ImageView add;
    ImageView bacham;
    DatabaseReference myRef;

    private Date currentTime = Calendar.getInstance().getTime();
    private SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy");
    private String date = sfd.format(currentTime);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themghichu);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        add = (ImageView)findViewById(R.id.checked);
        bacham = (ImageView) findViewById(R.id.more);
        note = (EditText) findViewById(R.id.note);
        tieude = (EditText) findViewById(R.id.tieude);

        bacham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                more();
            }
        });
        add.setOnClickListener(view -> {
            add();
        });
    }

    private void more(){
        Dialog more = new Dialog(this);
        more.requestWindowFeature(Window.FEATURE_NO_TITLE);
        more.setContentView(R.layout.more);
        more.show();
    }

    private void add(){
        String ghichu = note.getText().toString();
        String demuc = tieude.getText().toString();
        ghichu gc = new ghichu("1", demuc, ghichu, "hhhh", date);
        myRef.push().setValue(gc);
    }
}