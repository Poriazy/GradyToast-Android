package com.poriazed.samplegrady;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.poriazed.gradytoast.GradyDuration;
import com.poriazed.gradytoast.GradyToast;
import com.poriazed.gradytoast.GradyType;

public class MainActivity extends AppCompatActivity {

    Button btnPrimary;
    Button btnSuccess;
    Button btnError;
    Button btnWarning;
    Button btnInfo;
    Button btnLight;
    Button btnDark;
    Button btnCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize buttons
        initButtons();

        // create object of GradyToast
        final GradyToast myToast = new GradyToast(MainActivity.this);

        btnPrimary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myToast
                        .setText(getString(R.string.message_primary))
                        .setType(GradyType.PRIMARY)
                        .show();
            }
        });

        btnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myToast
                        .setText(getString(R.string.message_success))
                        .setDuration(GradyDuration.SHORT)
                        .setType(GradyType.SUCCESS)
                        .show();


            }
        });

        btnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myToast
                        .setText(getString(R.string.message_error))
                        .setDuration(GradyDuration.SHORT)
                        .setType(GradyType.ERROR)
                        .show();

            }
        });

        btnWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myToast
                        .setText(getString(R.string.message_warning))
                        .setDuration(GradyDuration.SHORT)
                        .setType(GradyType.WARNING)
                        .show();

            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myToast
                        .setText(getString(R.string.btn_info))
                        .setDuration(GradyDuration.SHORT)
                        .setType(GradyType.INFO)
                        .show();

            }
        });

        btnLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myToast
                        .setText(getString(R.string.message_light))
                        .setDuration(GradyDuration.SHORT)
                        .setType(GradyType.LIGHT)
                        .show();

            }
        });

        btnDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myToast
                        .setText(getString(R.string.message_dark))
                        .setDuration(GradyDuration.SHORT)
                        .setType(GradyType.DARK)
                        .show();

            }
        });

        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myToast
                        .setText(getString(R.string.message_custom))
                        .setDuration(GradyDuration.LONG)
                        .setType(GradyType.CUSTOM)
                        .setTextColor("#bdc3c7")
                        .setCustomColors("#FF0099", "#493240", "#000000" )
                        .setGradyStrokeSize(3)
                        .show();

            }
        });




    }


    private void initButtons() {
        btnPrimary  = findViewById(R.id.btn_primary);
        btnSuccess  = findViewById(R.id.btn_success);
        btnError    = findViewById(R.id.btn_error);
        btnWarning  = findViewById(R.id.btn_warning);
        btnInfo     = findViewById(R.id.btn_info);
        btnLight    = findViewById(R.id.btn_light);
        btnDark     = findViewById(R.id.btn_dark);
        btnCustom   = findViewById(R.id.btn_custom);
    }
}
