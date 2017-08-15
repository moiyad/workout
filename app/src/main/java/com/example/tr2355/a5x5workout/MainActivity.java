package com.example.tr2355.a5x5workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    TextView squatL, squatR, deadLifL, deadLifR, benchPressL, benchPressR, overHeadPressL, overHeadPressR, barBellRowL, barBellRowR;
    Button button,newPlan;
    View workout1, workout2;
    OneSet deadLiftO,squatO,benchPressO,overHeadPressO,barBellRowO;
    List<OneSet> Sets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Sets = OneSet.listAll(OneSet.class);
        workout1 = findViewById(R.id.workout1);
        workout2 = findViewById(R.id.workout2);
        squatL = (TextView) findViewById(R.id.squatL);
        squatR = (TextView) findViewById(R.id.squatR);
        deadLifL = (TextView) findViewById(R.id.deadLiftL);
        deadLifR = (TextView) findViewById(R.id.deadLiftR);
        benchPressL = (TextView) findViewById(R.id.benchPressL);
        benchPressR = (TextView) findViewById(R.id.benchPressR);
        overHeadPressL = (TextView) findViewById(R.id.overHeadPressL);
        overHeadPressR = (TextView) findViewById(R.id.overHeadPressR);
        barBellRowL = (TextView) findViewById(R.id.barBellRowL);
        barBellRowR = (TextView) findViewById(R.id.barBellRowR);
        button = (Button) findViewById(R.id.submitB);
        newPlan =(Button)findViewById(R.id.new_PlanB);



        if (Sets.isEmpty()){
            resetTheData();

        }else{
           extractFromDAtaBase();
        }

        workout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Workout Recorded Successfully", Toast.LENGTH_SHORT).show();
                Sets = OneSet.listAll(OneSet.class);
                squatO = Sets.get(0);
                benchPressO = Sets.get(1);
                barBellRowO = Sets.get(2);

                squatO.record+=2.5;
                squatO.save();

                benchPressO.record+=2.5;
                benchPressO.save();

                barBellRowO.record+=2.5;
                barBellRowO.save();

                fillTheGUI(squatO.record,benchPressO.record,barBellRowO.record,Sets.get(3).record,Sets.get(4).record);





            }
        });


        workout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Workout Recorded Successfully", Toast.LENGTH_SHORT).show();
                Sets = OneSet.listAll(OneSet.class);
                squatO = Sets.get(0);
                overHeadPressO = Sets.get(3);
                deadLiftO = Sets.get(4);

                squatO.record+=2.5;
                squatO.save();

                overHeadPressO.record+=2.5;
                overHeadPressO.save();

                deadLiftO.record+=5;
                deadLiftO.save();

                fillTheGUI(squatO.record,Sets.get(1).record,Sets.get(2).record,overHeadPressO.record,deadLiftO.record);


            }
        });

        newPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTheData();
            }
        });
    }



    public void resetTheData(){

        OneSet.deleteAll(OneSet.class);

        squatO = new OneSet(0);
        squatO.save();

        benchPressO = new OneSet(0);
        benchPressO.save();

        barBellRowO = new OneSet(0);
        barBellRowO.save();

        overHeadPressO = new OneSet(0);
        overHeadPressO.save();

        deadLiftO = new OneSet(0);
        deadLiftO.save();



        fillTheGUI(0.0,0.0,0.0,0.0,0.0);
    }

    public void extractFromDAtaBase(){
        Sets=OneSet.listAll(OneSet.class);
        squatO = Sets.get(0);
        benchPressO = Sets.get(1);
        barBellRowO = Sets.get(2);
        overHeadPressO = Sets.get(3);
        deadLiftO = Sets.get(4);

        fillTheGUI(squatO.record,benchPressO.record,barBellRowO.record,overHeadPressO.record,deadLiftO.record);
    }

    public void fillTheGUI(Double squat,Double benchPress,Double barBellRow,Double overHeadPress,Double deadLift){

        squatL.setText(String.valueOf(squat));
        squatR.setText(String.valueOf(squat));

        benchPressL.setText(String.valueOf(benchPress));
        benchPressR.setText(String.valueOf(benchPress));

        barBellRowL.setText(String.valueOf(barBellRow));
        barBellRowR.setText(String.valueOf(barBellRow));

        overHeadPressL.setText(String.valueOf(overHeadPress));
        overHeadPressR.setText(String.valueOf(overHeadPress));

        deadLifL.setText(String.valueOf(deadLift));
        deadLifR.setText(String.valueOf(deadLift));
    }

}
