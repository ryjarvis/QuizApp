package com.example.android.soccerquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String ANSWER1= "guardiola";
    public static final String ANSWER4= "france";
    public static final String ANSWER6= "mario kempes";
    public static final String ANSWER8= "iniesta";
    public static final String ANSWER10= "kolarov";

    EditText question2_answer;
    // Question 3
    CheckBox question3_opt1;
    CheckBox question2_opt2;
    CheckBox question3_opt3;
    CheckBox question3_opt4;
    // Question 4
    EditText question4_answer;
    // Question 5
    RadioButton question5_opt2;
    // Question 6
    EditText question6_answer;
    // Question 7
    CheckBox question7_opt1;
    CheckBox question7_opt2;
    CheckBox question7_opt3;
    CheckBox question7_opt4;
    // Question 8
    EditText question8_answer;
    // Question 9
    RadioButton question9_opt2;
    // Question 10
    EditText question10_answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  Soccer Quiz");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_soccer_ball);
    }

    public boolean checkEditText(int id,String answer){
        EditText ans = (EditText) this.findViewById(id);
        return  ans.getText().toString().toLowerCase().equals(answer);
    }

    public boolean checkRadioButton(int id){
        return ((RadioButton) this.findViewById(id)).isChecked();
    }

    public boolean checkMultipleCheckBox(List<Integer> list){
        for(int id:list){
            if(!((CheckBox) this.findViewById(id)).isChecked()){
                return false;
            }
        }
        return true;
    }

    public boolean numCheckBoxChosen(List<Integer>list,int ans_count){
        int count=0;
        for(int id:list){
            if(((CheckBox) this.findViewById(id)).isChecked()){
                count++;
            }
        }
        return count==ans_count;
    }


    public void submit(View view) {
        int score=0;
        Boolean ans=false;
        ans=checkEditText(R.id.question1_answer,ANSWER1);
        if (ans) {
            score ++;
        }
        ans=checkRadioButton(R.id.question2_opt2);
        if(ans){
            score ++;
        }

        List<Integer> list=new ArrayList<>();
        list.add(R.id.question3_opt3);
        list.add(R.id.question3_opt4);
        ans=checkMultipleCheckBox(list);

        list.add(R.id.question3_opt1);
        list.add(R.id.question3_opt2);
        if(ans&&numCheckBoxChosen(list,2)){
            score++;
        }
        ans=checkEditText(R.id.question4_answer,ANSWER4);
        if(ans){
            score ++;
        }

        ans=checkRadioButton(R.id.question5_opt1);
        if(ans){
            score ++;
        }

        ans=checkEditText(R.id.question6_answer,ANSWER6);
        if(ans){
            score ++;
        }

        ans=checkRadioButton(R.id.question7_opt1);
        if(ans){
            score ++;
        }

        ans=checkEditText(R.id.question8_answer,ANSWER8);
        if(ans){
            score ++;
        }
        ans=checkRadioButton(R.id.question9_opt1);
        if(ans){
            score ++;
        }

        ans=checkEditText(R.id.question10_answer,ANSWER10);
        if(ans){
            score ++;
        }

        CharSequence message;
        if (score == 10) {
            message = "You Won! You scored 10 out of 10";
        } else {
            message = "Try again. You scored " + score + " out of 10";
        }
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, message, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
