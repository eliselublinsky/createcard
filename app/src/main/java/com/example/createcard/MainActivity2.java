package com.example.createcard;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    ImageView imageView3;
    TextView btnname, btnbio;
    ToggleButton switch1;
    ImageButton btnEdit;
    LinearLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        main = findViewById(R.id.main);
        imageView3 = findViewById(R.id.imageView3);
        btnname = findViewById(R.id.btnname);
        btnbio = findViewById(R.id.btnbio);
        switch1 = findViewById(R.id.switch1);
        btnEdit = findViewById(R.id.btnedit);

        Intent intent = getIntent();
        String name = intent.getStringExtra("txtname");
        String bio = intent.getStringExtra("txtbio");
        int picRes = intent.getIntExtra("selectedPic", R.drawable.newpfp2);

        if (name != null && !name.isEmpty()) {
            btnname.setText(name);
        }
        if (bio != null && !bio.isEmpty()) {
            btnbio.setText(bio);
        }
        imageView3.setImageResource(picRes);
        int fontStyle = intent.getIntExtra("fontStyle", android.graphics.Typeface.NORMAL);
        btnname.setTypeface(null, fontStyle);
        btnbio.setTypeface(null, fontStyle);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}