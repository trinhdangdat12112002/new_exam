package com.example.baitap1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText name, sophong, dongia, ngay;

    Button them , back;
    Database database = new Database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name = findViewById(R.id.edName1);
        sophong = findViewById(R.id.edSoPhong1);
        dongia = findViewById(R.id.edDonGia1);
        ngay = findViewById(R.id.edNgay1);

        them = findViewById(R.id.btnSua);
        back = findViewById(R.id.btnBack1);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.addHoaDon(new HoaDon(name.getText().toString(), Integer.valueOf(sophong.getText().toString()), Float.valueOf(sophong.getText().toString()), Integer.valueOf(sophong.getText().toString())));
                Toast.makeText(AddActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(AddActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
    }
}