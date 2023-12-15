package com.example.baitap1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Database dataBase = new Database(this);
    private ListView lsv;
    private ArrayList<HoaDon> array;
    private HoaDonAdapter adapter;

    private EditText edTimkiem;

    private FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTimkiem = (EditText)findViewById(R.id.edSearch);
        array = new ArrayList<>();
        lsv = (ListView) findViewById(R.id.listView);
        btnAdd = (FloatingActionButton) findViewById(R.id.btnSua);

        array= (ArrayList<HoaDon>) dataBase.getAll();

        adapter = new HoaDonAdapter(MainActivity.this, R.layout.item_hoadon, array);
        lsv.setAdapter(adapter);

        edTimkiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ArrayList<HoaDon> filteredList = new ArrayList<>();

                float filterValue = 0.0f;
                try {
                    filterValue = Float.parseFloat(edTimkiem.getText().toString());
                } catch (NumberFormatException e) {
                    // Xử lý nếu người dùng nhập không phải là số
                }

                for (HoaDon hoaDon : array) {
                    float tongTien = hoaDon.getDongia() * hoaDon.getNgay();
                    if (tongTien > filterValue) {
                        filteredList.add(hoaDon);
                    }
                }

                adapter.setData(filteredList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(MainActivity.this, AddActivity.class);
                startActivity(it);
            }
        });

        lsv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it =new Intent(MainActivity.this, UpdateActivity.class);

                String name = array.get(position).getName();
                int idhoadon = array.get(position).getId();
                int sophong = array.get(position).getSophong();
                int ngay = array.get(position).getNgay();
                float dongia = array.get(position).getDongia();

                it.putExtra("idhoadon", idhoadon);
                it.putExtra("name", name);
                it.putExtra("sophong", sophong);
                it.putExtra("ngay", ngay);
                it.putExtra("dongia", dongia);

                startActivity(it);
            }
        });
    }
}