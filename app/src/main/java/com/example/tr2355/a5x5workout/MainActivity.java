package com.example.tr2355.a5x5workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<OneSet> oneSets=OneSet.listAll(OneSet.class);

        textView =(TextView)findViewById(R.id.number);
        textView.setText(String.valueOf(oneSets.size()));
        button =(Button)findViewById(R.id.button);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OneSet oneSet= new OneSet(i);
                oneSet.save();
                i++;
                OneSet oneSet1=OneSet.findById(OneSet.class,30);
                List<OneSet> oneSets=OneSet.listAll(OneSet.class);
                textView.setText(String.valueOf(oneSet1.getRecord()));
                Toast.makeText(MainActivity.this, ""+oneSets.size(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
