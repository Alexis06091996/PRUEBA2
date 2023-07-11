package com.example.reproductor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView vv1;

    private Button play;
    private Button pausaz;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.btn_play);
        pausaz = findViewById(R.id.btn_pausa);



        vv1 = findViewById(R.id.vv1);
        vv1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.himno));
        MediaController mc = new MediaController(this);
        vv1.setMediaController(mc);
        mc.setAnchorView(vv1);

        play.setOnClickListener(new View.OnClickListener() {

                                    @Override
                                    public void onClick(View v) {
                                        vv1.start();
                                    }});


          pausaz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vv1.pause();
                }
            }  );


}
}
