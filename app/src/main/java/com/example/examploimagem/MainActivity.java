package com.example.examploimagem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btTiraFoto;
    ImageView imgSuaImagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retiraFoto();
    }
    private void retiraFoto(){
        btTiraFoto=(Button)findViewById(R.id.btnTiraFoto);
        imgSuaImagem=(ImageView)findViewById(R.id.suaImagem);
        btTiraFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreCamera= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(abreCamera, 0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        if (data!=null){
            Bitmap bitmap = (Bitmap)bundle.get("data");
            imgSuaImagem.setImageBitmap(bitmap);
        }
    }

}
