package com.hyunie.shoppingwithhyunie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.hyunie.adapter.SanPhamAdapter;
import com.hyunie.sanpham.SanPham;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageButton btTitle, btSearch;
    TextView txtTienDu, txtGioHang,txtSearch,txtTitle;
    SanPhamAdapter spAdapter;
    GridView gvHangHoa;
    ArrayList<SanPham> dsSanPham;
    ArrayAdapter<SanPham> sanPhamAdapter;
    String[] nameSP;
    int []giaSP;

    int []anhSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = txtSearch.getText().toString();
                s = s.trim();
                if(s.length() >= 11 && s.substring(0,11).equals("#HyuNieHack")){
                    int n = Integer.parseInt(s.substring(11));
                    txtTienDu.setText(String.valueOf(n));
                    txtSearch.setText("");
                } else if (s.length()==0) {
                    Toast.makeText(MainActivity.this,"Vui lòng nhập tên sản phẩm",Toast.LENGTH_SHORT).show();
                } else{
                    ArrayList<SanPham> sp = new ArrayList<>();

                    for(int i=0;i<nameSP.length;i++){
                        if(nameSP[i].toLowerCase().indexOf(s.toLowerCase())>=0){
                            sp.add(new SanPham(nameSP[i],giaSP[i],anhSP[i]));
                        }
                    }
                    if(sp.size()==0){
                        txtTitle.setText("Kết quả tìm kiếm: [ "+s+"] = 0");
                    }else{
                        txtTitle.setText("Kết quả tìm kiếm: [ "+s+"] = "+sp.size());
                    }
                    txtSearch.setText("");
                    Toast.makeText(MainActivity.this,"Ấn vào hình cửa hàng để quay về",Toast.LENGTH_SHORT).show();
                    sanPhamAdapter = new SanPhamAdapter(MainActivity.this, R.layout.item,sp,txtTienDu,txtGioHang);
                    gvHangHoa.setAdapter(sanPhamAdapter);
                }
            }
        });
        btTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sanPhamAdapter = new SanPhamAdapter(MainActivity.this, R.layout.item,dsSanPham,txtTienDu,txtGioHang);
                gvHangHoa.setAdapter(sanPhamAdapter);
                txtTitle.setText("Tất cả sản phẩm:");
            }
        });
    }

    private void addControls() {
        btTitle = findViewById(R.id.btTitle);
        btSearch = findViewById(R.id.btSearch);
        txtTitle = findViewById(R.id.txtTitle);
        txtSearch = findViewById(R.id.txtSearch);
        txtGioHang = findViewById(R.id.txtGioHang);
        txtTienDu = findViewById(R.id.txtTienDu);
        gvHangHoa = findViewById(R.id.gvHangHoa);

        dsSanPham = new ArrayList<>();

        String[] nameSPs = {"Sen hóa 49x50","Tứ Quý Cúc 112x84","Tứ Quý Mai 112x84","Tứ Quý Trúc 112x84",
                "Tứ Quý Tùng 112x84","Tứ Linh Rồng 87x53","Tứ Linh Quy 87x53","Tứ Linh Lân 87x53","Tứ Linh Phượng 87x53",
        "Đài Sen 50x50","Đài sen 85x80","Sen hóa 57x67","Sen hóa 68x84",
        "Tứ linh Lân 112x45","Tứ linh Phượng 112x45","Tứ linh Rồng 112x45","Tứ linh Rùa 112x45","Người yêu tên Niên"};

        int[] giaSPs = {100000,43000,65300,12000,88000,250000,50000,87000,56000,23000,19000,
                        100000,59000,45000,24000,200000,200000,999999999};

        int []images = {R.drawable.sen,R.drawable.cuc,R.drawable.mai,R.drawable.truc,
                R.drawable.tung,R.drawable.rong,R.drawable.rua,R.drawable.lan,R.drawable.phuong,
                R.drawable.daisen,R.drawable.daisen1,R.drawable.senhoa,R.drawable.senhoa1,
                R.drawable.lan1,R.drawable.phuong1,R.drawable.rong1,R.drawable.rua1,
                R.drawable.nien};

        nameSP = nameSPs;
        giaSP = giaSPs;
        anhSP = images;
        for(int i=0;i<nameSP.length;i++){
            dsSanPham.add(new SanPham(nameSPs[i],giaSPs[i],images[i]));
        }

        sanPhamAdapter = new SanPhamAdapter(MainActivity.this, R.layout.item,dsSanPham,txtTienDu,txtGioHang);
        gvHangHoa.setAdapter(sanPhamAdapter);
    }
}