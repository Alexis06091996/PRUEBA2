package com.example.tomarfoto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ImageView imagen;
    ImageButton boton;
    String rutaImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = findViewById(R.id.imageView);
        boton = findViewById(R.id.imageButton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrircamara();
            }
        });
    }
    //metodo para habilitar la camara
    private void abrircamara(){
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File imagenarchivo=null;
        try {
            imagenarchivo=crearimagen();
        }catch(IOException ex){
            Log.e("error", ex.toString());

        }
        if (imagenarchivo!=null){
            Uri fotouri= FileProvider.getUriForFile(this, "com.example.tomarfoto.fileProvider", imagenarchivo);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fotouri);
            startActivityForResult(intent, 1);
        }

    }

    //metodo para visualizar la imagen capturada en el imageview

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bitmap imageBitmap = BitmapFactory.decodeFile(rutaImagen);
            imagen.setImageBitmap(imageBitmap);
        }

    }

    //metodo para crear el archivo temporal de la foto que sera de tipo jpg

    private File crearimagen()throws IOException{
        String nombreimagen="foto_ ";
        File directorio=getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imagen2=File.createTempFile(nombreimagen, ".jpg", directorio);
        rutaImagen=imagen2.getAbsolutePath();
        return imagen2;
    }

}