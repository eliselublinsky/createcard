package com.example.createcard;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout main;
    ImageButton btnpic1, btnpic2;
    EditText txtname, txtbio;
    RadioGroup radioGroup;
    RadioButton radbtn1, radbtn2, radbtn3;
    Switch dark;
    ImageView blankpfp, imageView;
    Button changescreen;
    TextView textView;

    int selectedPic = R.drawable.newpfp2;
    int selectedFontStyle = Typeface.NORMAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = findViewById(R.id.main);
        btnpic1 = findViewById(R.id.btnpic1);
        btnpic2 = findViewById(R.id.btnpic2);
        txtname = findViewById(R.id.txtname);
        txtbio = findViewById(R.id.txtbio);
        radioGroup = findViewById(R.id.radiogroup);
        radbtn1 = findViewById(R.id.radbtn1);
        radbtn2 = findViewById(R.id.radbtn2);
        radbtn3 = findViewById(R.id.radbtn3);
        dark = findViewById(R.id.dark);
        blankpfp = findViewById(R.id.blankpfp);
        imageView = findViewById(R.id.imageView);
        changescreen = findViewById(R.id.changescreen);
        textView = findViewById(R.id.textView);

        showOnly(blankpfp);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radbtn1) {
                    selectedFontStyle = Typeface.BOLD;
                } else if (checkedId == R.id.radbtn2) {
                    selectedFontStyle = Typeface.ITALIC;
                } else {
                    selectedFontStyle = Typeface.NORMAL;
                }
                applyFontStyle(selectedFontStyle);
            }
        });

        dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dark.isChecked()) {
                    int blackColor = ContextCompat.getColor(MainActivity.this, R.color.black);
                    main.setBackgroundColor(blackColor);
                    txtname.setTextColor(Color.WHITE);
                    txtname.setHintTextColor(Color.LTGRAY);
                    txtbio.setTextColor(Color.WHITE);
                    txtbio.setHintTextColor(Color.LTGRAY);
                    textView.setTextColor(Color.WHITE);
                    radbtn1.setTextColor(Color.WHITE);
                    radbtn2.setTextColor(Color.WHITE);
                    radbtn3.setTextColor(Color.WHITE);
                } else {
                    main.setBackgroundColor(Color.WHITE);
                    txtname.setTextColor(Color.BLACK);
                    txtname.setHintTextColor(Color.GRAY);
                    txtbio.setTextColor(Color.BLACK);
                    txtbio.setHintTextColor(Color.GRAY);
                    textView.setTextColor(Color.BLACK);
                    radbtn1.setTextColor(Color.BLACK);
                    radbtn2.setTextColor(Color.BLACK);
                    radbtn3.setTextColor(Color.BLACK);
                }
            }
        });
    }

    private void applyFontStyle(int style) {
        txtname.setTypeface(null, style);
        txtbio.setTypeface(null, style);
        textView.setTypeface(null, style);
        radbtn1.setTypeface(null, style);
        radbtn2.setTypeface(null, style);
        radbtn3.setTypeface(null, style);
        changescreen.setTypeface(null, style);
    }

    private void showOnly(ImageView selected) {
        blankpfp.setVisibility(View.INVISIBLE);
        imageView.setVisibility(View.INVISIBLE);
        selected.setVisibility(View.VISIBLE);
    }

    public void changebuttonpic(View v) {
        showOnly(blankpfp);
        selectedPic = R.drawable.newpfp2;
    }

    public void changebuttonpic2(View v) {
        showOnly(imageView);
        selectedPic = R.drawable.toy;
    }

    public void changebutton(View v) {
        Intent si = new Intent(MainActivity.this, MainActivity2.class);
        si.putExtra("txtname", txtname.getText().toString());
        si.putExtra("txtbio", txtbio.getText().toString());
        si.putExtra("selectedPic", selectedPic);
        si.putExtra("fontStyle", selectedFontStyle);

        startActivity(si);
    }
}