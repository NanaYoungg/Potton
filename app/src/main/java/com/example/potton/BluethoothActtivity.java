package com.example.potton;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class BluethoothActtivity extends AppCompatActivity {
    private Button btnBluethooth;
    private ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bluetooth);

        btnBluethooth = (Button)findViewById(R.id.bluetooth_btn);
        backBtn = (ImageButton)findViewById(R.id.back_btn);

        btnBluethooth.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //블루투스 설정 화면으로 이동
                Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                startActivityForResult(intent, 0);
            }
        });


        //뒤로 이동
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MenuActivity.class);
                startActivity(intent);

            }
        });





    }



//    @Override
//
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch(requestCode) {
//            case 0 :
//                // 할일 작성
//                break;
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }

}