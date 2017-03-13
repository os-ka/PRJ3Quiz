package com.example.android.prj3quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int rightAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     *
     * This method is called when Submit Answers button is clicked
     */
    public void submitAnswers(View view){
        //Set the right answers to 0 before calculation
        rightAnswers = 0;

        //Store user input for first question in variable
        EditText firstAnswer = (EditText) findViewById(R.id.question1_edit_text);
        String firstAnswerString = firstAnswer.getText().toString();

        //Store Question 2 checkbox values in 3 different booleans
        CheckBox pineCheckBox = (CheckBox) findViewById(R.id.check_box_1_question2);
        boolean pineIsChecked = pineCheckBox.isChecked();
        CheckBox birchCheckBox = (CheckBox) findViewById(R.id.check_box_2_question2);
        boolean birchIsChecked = birchCheckBox.isChecked();
        CheckBox spruceCheckBox = (CheckBox) findViewById(R.id.check_box_3_question2);
        boolean spruceIsChecked = spruceCheckBox.isChecked();

        // Stores Question 3 single radio button value
        RadioButton coastRedwood = (RadioButton) findViewById(R.id.radio_button_1_question3);
        boolean coastIsChecked = coastRedwood.isChecked();

        //Store question 4 checkbox values in 3 different booleans
        CheckBox waterCheckBox = (CheckBox) findViewById(R.id.check_box_1_question4);
        boolean waterIsChecked = waterCheckBox.isChecked();
        CheckBox co2CheckBox = (CheckBox) findViewById(R.id.check_box_2_question4);
        boolean co2IsChecked = co2CheckBox.isChecked();
        CheckBox sunlightCheckBox = (CheckBox) findViewById(R.id.check_box_3_question4);
        boolean sunlightIsChecked = sunlightCheckBox.isChecked();

        //Store question 5 single radio button value
        RadioButton treesPerPeson = (RadioButton) findViewById(R.id.radio_button_2_question5);
        boolean sevenToEight = treesPerPeson.isChecked();

        // Calling method for each answer to check if it's correct.
        // If question is answered correct then variable rightAnswers is increased by 1
        checkFirst(firstAnswerString);
        checkSecond(pineIsChecked, birchIsChecked, spruceIsChecked);
        checkThirdandFifth(coastIsChecked);
        checkFourth(waterIsChecked, co2IsChecked, sunlightIsChecked);
        checkThirdandFifth(sevenToEight);

        // Making toast message to show amount of right answers
        Toast.makeText(this, rightAnswers + " " + getString(R.string.toast_message), Toast.LENGTH_SHORT).show();
    }


    /**
     * This method checks if the first question answer equals "oak" or "Oak"
     * @param answer is first question answer that user typed.
     */
    private void checkFirst(String answer){
        if (answer.equals(getString(R.string.question_1a))){
            rightAnswers += 1;
        }
        if (answer.equals(getString(R.string.question_1b))){
            rightAnswers += 1;
        }

    }

    /**
     * This method checks if second question answers are "Pine" and "Spruce" but not "Birch"
     * @param pineCheckBox
     * @param birchCheckBox
     * @param spruceCheckBox
     */
    private void checkSecond(boolean pineCheckBox, boolean birchCheckBox, boolean spruceCheckBox){
        if (birchCheckBox){
            return;
        }
        if(!pineCheckBox){
            return;
        }
        if(!spruceCheckBox){
            return;
        }
        else{
            rightAnswers += 1;
        }
    }

    /**
     * If radioButton is checked then add 1 to rightAnswers
     * @param radioButton
     */
    private void checkThirdandFifth(boolean radioButton){
        if (radioButton){
            rightAnswers  += 1;
        }
    }

    /**
     * This method checks if fourth question all answers are checked.
     * @param waterCheckBox
     * @param co2CheckBox
     * @param sunlightCheckBox
     */
    private void checkFourth(boolean waterCheckBox, boolean co2CheckBox, boolean sunlightCheckBox){
        if (!waterCheckBox || !co2CheckBox || !sunlightCheckBox){
            return;
        }
        else{
            rightAnswers += 1;
        }
    }



}
