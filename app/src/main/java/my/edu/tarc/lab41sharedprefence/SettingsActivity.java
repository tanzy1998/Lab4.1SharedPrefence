package my.edu.tarc.lab41sharedprefence;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {
    private static final String PREF_FILE = "my.edu.tarc.lab41sharedprefence" ;
    private EditText editTextName;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private ImageView imageViewProfile;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        editTextName = findViewById(R.id.editTextName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        imageViewProfile = findViewById(R.id.imageViewProfile);
        sharedPreferences=getSharedPreferences(PREF_FILE, MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name;
        int gender;//-1 = default, 1=male, 0=female
        name = sharedPreferences.getString(getString(R.string.user_name),getString(R.string.no_name));
        gender = sharedPreferences.getInt(getString(R.string.user_gender),-1);

        editTextName.setText(name);
        if(gender == 1){
            radioButtonMale.setChecked(true);
            imageViewProfile.setImageResource(R.drawable.male);
        }else if(gender == 0){
            radioButtonFemale.setChecked(true);
            imageViewProfile.setImageResource(R.drawable.female);
        }else{
            imageViewProfile.setImageResource(R.drawable.profile);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //1. Create A SharedPref editor
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //2. Edit the SharedPref file
        String name;
        int gender;
        name = editTextName.getText().toString();
        editor.putString("user_name",name);

        gender = radioGroupGender.getCheckedRadioButtonId();
        if(gender == R.id.radioButtonMale){
            editor.putInt("user_gender",1);
        } else if(gender == R.id.radioButtonFemale){
            editor.putInt("user_gender",0);
        }
        editor.commit();

    }
}
