package com.example.audio;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

        private VideoView videoView;
        private Button playAudioButton;

        private MediaPlayer mediaPlayer;
        private boolean isAudioPlaying = false;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                videoView = findViewById(R.id.videoView);
                playAudioButton = findViewById(R.id.playAudioButton);

                // Establecer ruta del video
                String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video_sample
                        ;
                Uri videoUri = Uri.parse(videoPath);
                videoView.setVideoURI(videoUri);

                // Reproducir video
                videoView.start();

                playAudioButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                if (isAudioPlaying) {
                                        // Pausar la reproducción de audio
                                        mediaPlayer.pause();
                                        isAudioPlaying = false;
                                        playAudioButton.setText("Reproducir Audio");
                                } else {
                                        // Iniciar la reproducción de audio
                                        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.audio_sample);
                                        mediaPlayer.start();
                                        isAudioPlaying = true;
                                        playAudioButton.setText("Pausar Audio");
                                }
                        }
                });
        }

        @Override
        protected void onDestroy() {
                super.onDestroy();
                // Liberar recursos del reproductor de audio
                if (mediaPlayer != null) {
                        mediaPlayer.release();
                        mediaPlayer = null;
                }
        }
}

