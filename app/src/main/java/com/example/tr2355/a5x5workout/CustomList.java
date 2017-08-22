package com.example.tr2355.a5x5workout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

/**
 * Created by tr2355 on 8/17/2017.
 */

public class CustomList extends AppCompatActivity {

    CheckBox squat,benchPress,barBellRow,overHeadPress,deadLift;
    Button done ;
    int count =0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        squat = (CheckBox)findViewById(R.id.squatCL);
        benchPress = (CheckBox)findViewById(R.id.benchPressCL);
        barBellRow = (CheckBox)findViewById(R.id.barBellRowCL);
        overHeadPress = (CheckBox)findViewById(R.id.overHeadPressCL);
        deadLift = (CheckBox)findViewById(R.id.deadLiftCL);
        done = (Button)findViewById(R.id.doneB);

        final List<OneSet> ListSet =OneSet.listAll(OneSet.class);



        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(squat.isChecked())
                {
                    OneSet oneSet = ListSet.get(0);
                    oneSet.record+=2.5;
                    oneSet.save();
                    count ++;
                }
                if(benchPress.isChecked())
                {
                    OneSet oneSet = ListSet.get(1);
                    oneSet.record+=2.5;
                    oneSet.save();
                    count ++;

                }
                if(barBellRow.isChecked())
                {
                    OneSet oneSet = ListSet.get(2);
                    oneSet.record+=2.5;
                    oneSet.save();
                    count ++;

                }
                if(overHeadPress.isChecked())
                {
                    OneSet oneSet = ListSet.get(3);
                    oneSet.record+=2.5;
                    oneSet.save();
                    count ++;

                }
                if(deadLift.isChecked())
                {
                    OneSet oneSet = ListSet.get(4);
                    oneSet.record+=5;
                    oneSet.save();
                    count ++;

                }

                if (count !=0){
                    Intent intent = new Intent(CustomList.this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(CustomList.this, "Custom Workout Recorded Successfully ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(CustomList.this, "No item been selected", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
