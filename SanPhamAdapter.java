package com.hyunie.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hyunie.sanpham.SanPham;
import com.hyunie.shoppingwithhyunie.MainActivity;
import com.hyunie.shoppingwithhyunie.R;

import java.util.List;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
//    public static Object changeData;
    @NonNull Activity context;
    int resource;
    @NonNull List<SanPham> objects;
    TextView txtTienDu,txtGioHang;
    public SanPhamAdapter(@NonNull Activity context, int resource,
                          @NonNull List<SanPham> objects,TextView txtTienDu, TextView txtGioHang) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;
        this.txtTienDu = txtTienDu;
        this.txtGioHang = txtGioHang;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource,null);

        TextView txtNameAdapter = row.findViewById(R.id.txtNameAdapter);
        TextView txtGiaAdapter = row.findViewById(R.id.txtGiaAdapter);
        ImageButton btBuyAdapter = row.findViewById(R.id.btBuyAdapter);
        ImageView imgAnhAdapter = row.findViewById(R.id.imgAnhAdapter);

        SanPham sanPham = this.objects.get(position);

        txtNameAdapter.setText(sanPham.getName());
        txtGiaAdapter.setText(String.valueOf(sanPham.getGia())+" VND");
        imgAnhAdapter.setImageResource(sanPham.getAnh());

        btBuyAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tienDuInt = Integer.parseInt(txtTienDu.getText().toString()) - sanPham.getGia();
                if(tienDuInt<0){
                    Toast.makeText(context,"Số dư không đủ, Vui lòng nạp thêm tiền",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(context,"Chúc mừng! Bạn đã mua thành công",Toast.LENGTH_SHORT).show();
                    txtTienDu.setText(String.valueOf(tienDuInt));
                    txtGioHang.setText(String.valueOf(Integer.parseInt(txtGioHang.getText().toString())+1));
                }
            }
        });

        return row;
    }
    public void changeData(List<SanPham> newData){
        this.objects = newData;
        notifyDataSetChanged();
    }
}
