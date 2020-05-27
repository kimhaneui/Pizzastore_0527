package com.example.pizzastore_0527;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pizzastore_0527.databinding.ActivityDetailBinding;
import com.example.pizzastore_0527.datas.PizzaStore;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

public class DetailActivity extends BaseActivity {

    ActivityDetailBinding binding;
    PizzaStore mStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PermissionListener pl = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {

                        String phoneNum = binding.phoneNum.getText().toString();
                        Uri myuri = Uri.parse(String.format("tel:%s",phoneNum));
                        Intent myintent  = new Intent(Intent.ACTION_CALL,myuri);

                        startActivity(myintent);

                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {

                        Toast.makeText(mContext,"권한이 거부되어 통화가 불가능합니다",Toast.LENGTH_SHORT).show();

                    }
                };

                TedPermission
                        .with(mContext)
                        .setPermissionListener(pl).
                        setDeniedMessage("거부하면 통화가 불가능함.")
                        .setPermissions(Manifest.permission.CALL_PHONE).check();
            }
        });


    }

    @Override
    public void setValues() {
        mStore = (PizzaStore) getIntent().getSerializableExtra("store");

        binding.storeName.setText(mStore.getName());
        binding.phoneNum.setText(mStore.getPhoneNum());

        Glide.with(mContext).load(mStore.getLogoImgUri()).into(binding.profileId);
    }
}
