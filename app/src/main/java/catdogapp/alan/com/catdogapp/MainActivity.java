package catdogapp.alan.com.catdogapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup canineRadioGroup;
    private RadioButton canineRadioButton;
    private SeekBar seekBar;
    private TextView seekBarTextview;
    private CheckBox cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot;
    private RadioGroup droolRadioGroup;
    private RadioButton droolRadioButton;
    private Button showResultButton;
    private int dogCounter, catCounter;
    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();

    }

    public void setUp() {

        dogCounter = 0;
        catCounter = 0;

        canineRadioGroup = (RadioGroup) findViewById(R.id.radioGroupCanine);
        droolRadioGroup = (RadioGroup) findViewById(R.id.radioGroupDrool);
        seekBarTextview = (TextView) findViewById(R.id.seekBarProgress);

        cutestCheckBoxDog = (CheckBox) findViewById(R.id.checkBoxCutestDog);
        cutestCheckBoxCat = (CheckBox) findViewById(R.id.checkBoxCutestCat);
        cutestCheckBoxParrot = (CheckBox) findViewById(R.id.checkBoxCutestParrot);

        //cutest();
        processDrool(droolRadioGroup);
        processCanines(canineRadioGroup);
        cutest(cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot);

        seekBar = (SeekBar) findViewById(R.id.seekBar_Feline);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                seekBarTextview.setText("Comfortableness: " + progress + "/" + seekBar.getMax());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                if(seekBar.getProgress() != 0){
                    catCounter -= seekBar.getProgress();
                }

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                catCounter += seekBar.getProgress();
            }
        });

        showResultButton = (Button) findViewById(R.id.showResults);
        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("catCounter", catCounter);
                i.putExtra("dogCounter", dogCounter);
                startActivity(i);
            }
        });
    }

    public void cutest(final CheckBox dog, final CheckBox cat, final CheckBox parrot) {

        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dog.isChecked()) {
                    dogCounter += 5;
                } else {
                    dogCounter -= 5;
                }
            }
        });

        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cat.isChecked()) {
                    catCounter += 5;
                } else {
                    catCounter -= 5;
                }
            }
        });

        parrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (parrot.isChecked()) {
                    dogCounter += 0;
                    catCounter += 0;
                }
            }
        });
    }

    public void processDrool(final RadioGroup radioGroup){

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int radioID = radioGroup.getCheckedRadioButtonId();

                droolRadioButton = (RadioButton) findViewById(radioID);

                if(droolRadioButton.getText().equals("Yes")){

                    dogCounter += 5;
                }
            }
        });
    }

    public void processCanines(final RadioGroup radioGroup){

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int radioID = radioGroup.getCheckedRadioButtonId();

                canineRadioButton = (RadioButton) findViewById(radioID);

                if(canineRadioButton.getText().equals("No")){

                    dogCounter += 5;
                }
            }
        });
    }
}
