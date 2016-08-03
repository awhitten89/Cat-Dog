package catdogapp.alan.com.catdogapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView result;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = (TextView) findViewById(R.id.Result_textView);
        imageView = (ImageView) findViewById(R.id.Result_image);

        Bundle extras = getIntent().getExtras();

        if(extras != null){

            int catResult = extras.getInt("catCounter");
            int dogResult = extras.getInt("dogCounter");

            if(catResult > dogResult){

                result.setText("Cat Person!!");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.kitty));

            } else if(dogResult > catResult){

                result.setText("Dog Person!!");
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dog));

            } else {

                result.setText("Neither!!");
            }
        }
    }
}
