package com.example.potton;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import me.itangqi.waveloadingview.WaveLoadingView;

public class SoundActivity extends AppCompatActivity {
    private Button myButton;
    private String myText;
    private String myText2;
    private Button myButton2;
    private TextView textView1;
    private TextView textView2;

    private SeekBar seekbar;
    private WaveLoadingView waveLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sound);

        ImageButton backBtn = (ImageButton)findViewById(R.id.back_btn);
        myButton = findViewById(R.id.btn1);
        myButton2 = findViewById(R.id.btn2);
        textView1 = findViewById(R.id.tv1);
        textView2 = findViewById(R.id.tv2);

        textView1.setText("손동작을 따라해 주세요");
        textView2.setText("인식 완료");

        // AudioManager
        final AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int nMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int nCurrentVolumn = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        // SeekBar
        seekbar = (SeekBar)findViewById(R.id.sound);
        seekbar.setMax(nMax);
        seekbar.setProgress(nCurrentVolumn);
        waveLoadingView = (WaveLoadingView)findViewById(R.id.waveLoadingView);
        waveLoadingView.setProgressValue((int)(nCurrentVolumn*6.6));

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            public void onProgressChanged(SeekBar seekBar, int Progress, boolean fromUser){
                //시크바 상태가 변경되었을때  progress = seekbar상태값
                waveLoadingView.setProgressValue((int)(Progress*6.6));
                waveLoadingView.setBottomTitle(String.format("%d%%",(int)(Progress*6.6)));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, Progress, 0);
            }
        });




        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mydialog = new AlertDialog.Builder(SoundActivity.this);
                mydialog.setTitle("한글 15자 내, 영어 30자 내, 음성 10초 내");

                final EditText weightInput = new EditText(SoundActivity.this);
                weightInput.setInputType(InputType.TYPE_CLASS_TEXT);
                mydialog.setView(weightInput);

                mydialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myText = weightInput.getText().toString();
                        Toast.makeText(SoundActivity.this, "수정되었습니다", Toast.LENGTH_LONG).show();
                        textView1.setText(myText);
                    }
                });

                mydialog.setNeutralButton("Voice Record", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                mydialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                mydialog.show();
            }
        });



        myButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mydialog2 = new AlertDialog.Builder(SoundActivity.this);
                mydialog2.setTitle("한글 15자 내, 영어 30자 내, 음성 10초 내");

                final EditText weightInput2 = new EditText(SoundActivity.this);
                weightInput2.setInputType(InputType.TYPE_CLASS_TEXT);
                mydialog2.setView(weightInput2);

                mydialog2.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myText2 = weightInput2.getText().toString();
                        Toast.makeText(SoundActivity.this, "수정되었습니다", Toast.LENGTH_LONG).show();
                        textView2.setText(myText2);
                    }
                });

                mydialog2.setNeutralButton("Voice Record", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                mydialog2.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                mydialog2.show();
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
}
