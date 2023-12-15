package com.example.baitap1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    EditText name, sophong, dongia, ngay;

    Button sua , back;
    Database database = new Database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_update);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name = findViewById(R.id.edName1);
        sophong = findViewById(R.id.edSoPhong1);
        dongia = findViewById(R.id.edDonGia1);
        ngay = findViewById(R.id.edNgay1);

        sua = findViewById(R.id.btnSua);
        back = findViewById(R.id.btnBack1);

        Intent intent = getIntent();
        String name1 = intent.getStringExtra("name");
        int id1 = intent.getIntExtra("idhoadon", 0);
        int sophong1 = intent.getIntExtra("sophong", 0);
        int ngay1 = intent.getIntExtra("ngay", 0);
        float dongia1 = intent.getFloatExtra("dongia", 0);

        name.setText(name1);
        sophong.setText(String.valueOf(sophong1));
        dongia.setText(String.valueOf(dongia1));
        ngay.setText(String.valueOf(ngay1));

        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.updateHoaDon(id1, String.valueOf(name.getText()), Integer.valueOf(sophong.getText().toString()), Integer.valueOf(ngay.getText().toString()), Float.valueOf(String.valueOf(dongia.getText())));
                Intent it = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(it);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
    }
}