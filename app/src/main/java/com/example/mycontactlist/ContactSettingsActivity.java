package com.example.mycontactlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.Context;
import android.widget.ScrollView;

public class ContactSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_settings);

        ScrollView scrollView = new ScrollView (this);

        initListButton();
        initMapButton();
        initSettingsButton();
        initSortByClick();
        initSortOrderClick();
        initSettings();
        initBackgroundColorClick();

        scrollView.setBackgroundResource(R.color.redBackground);



    }


    private void initListButton() {
        ImageButton ibList = (ImageButton) findViewById(R.id.imageButtonList);
        ibList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ContactSettingsActivity.this, ContactListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initMapButton() {
        ImageButton ibList = (ImageButton) findViewById(R.id.imageButtonMap);
        ibList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ContactSettingsActivity.this, ContactMapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initSettingsButton() {
        ImageButton ibSettings = (ImageButton) findViewById(R.id.imageButtonSettings);
        ibSettings.setEnabled(false);
    }

    private void initSettings() {
        String sortBy = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).getString("sortfield","contactname");
        String sortOrder = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).getString("sortorder","ASC");
        String backgroundColor = getSharedPreferences("MyContactListPreferences", Context.MODE_PRIVATE).getString("background","redBackground");



        RadioButton rbName = (RadioButton) findViewById(R.id.radioName);
        RadioButton rbCity = (RadioButton) findViewById(R.id.radioCity);
        RadioButton rbBirthDay = (RadioButton) findViewById(R.id.radioBirthday);

        if (sortBy.equalsIgnoreCase("contactname")) {
            rbName.setChecked(true);
        }
        else if (sortBy.equalsIgnoreCase("city")) {
            rbCity.setChecked(true);
        }
        else {
            rbBirthDay.setChecked(true);
        }

        RadioButton rbAscending = (RadioButton) findViewById(R.id.radioAscending);
        RadioButton rbDescending = (RadioButton) findViewById(R.id.radioDescending);

        if (sortOrder.equalsIgnoreCase("ASC")) {
            rbAscending.setChecked(true);
        }
        else {
            rbDescending.setChecked(true);
        }

       // ScrollView scrollView = new ScrollView(this);
        RadioButton rbRed = (RadioButton) findViewById(R.id.radioRed);
        RadioButton rbOffWhite = (RadioButton) findViewById(R.id.radioOffWhite);
        RadioButton rbBlack = (RadioButton) findViewById(R.id.radioBlack);
        RadioButton rbWhite = (RadioButton) findViewById(R.id.radioWhite);

        if (backgroundColor.equalsIgnoreCase("whiteBackground")){
            rbWhite.setChecked(true);
            //scrollView.setBackgroundResource(R.color.whiteBackground);
        }

        else if (backgroundColor.equalsIgnoreCase("offWhiteBackground")){
            rbOffWhite.setChecked(true);
         //   scrollView.setBackgroundResource(R.color.offWhiteBackground);
        }

        else if (backgroundColor.equalsIgnoreCase("blackBackground")){
            rbBlack.setChecked(true);
           // scrollView.setBackgroundResource(R.color.blackBackground);
        }
        else {
            rbRed.setChecked(true);
           // scrollView.setBackgroundResource(R.color.redBackground);
        }


    }

    private void initSortByClick() {
        RadioGroup rgSortBy = (RadioGroup) findViewById(R.id.radioGroupSortBy);
        rgSortBy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                RadioButton rbName = (RadioButton) findViewById(R.id.radioName);
                RadioButton rbCity = (RadioButton) findViewById(R.id.radioCity);
                if (rbName.isChecked()) {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit() .putString("sortfield", "contactname").commit();
                }
                else if (rbCity.isChecked()) {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit().putString("sortfield", "city").commit();
                }
                else {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit().putString("sortfield", "birthday").commit();
                }
            }
        });
    }

    private void initSortOrderClick() {
        RadioGroup rgSortOrder = (RadioGroup) findViewById(R.id.radioGroupSortOrder);
        rgSortOrder.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                RadioButton rbAscending = (RadioButton) findViewById(R.id.radioAscending);
                if (rbAscending.isChecked()) {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit().putString("sortorder", "ASC").commit();
                }
                else {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit().putString("sortorder", "DESC").commit();
                }
            }
        });
    }



    private void initBackgroundColorClick() {
        RadioGroup rgSetBackgroundColor = (RadioGroup) findViewById(R.id.radioGroupBackgroundColor);
        rgSetBackgroundColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup arg0, int arg1) {
                RadioButton rbRed = (RadioButton) findViewById(R.id.radioRed);
                RadioButton rbOffWhite = (RadioButton) findViewById(R.id.radioOffWhite);
                RadioButton rbBlack = (RadioButton) findViewById(R.id.radioBlack);
                RadioButton rbWhite = (RadioButton) findViewById(R.id.radioWhite);
                ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);

                if (rbWhite.isChecked())
                {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit() .putString("background", "whiteBackground").commit();
                    scrollView.setBackgroundResource(R.color.whiteBackground);
                }
                else if (rbOffWhite.isChecked())
                {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit().putString("background", "offWhiteBackground").commit();
                    scrollView.setBackgroundResource(R.color.offWhiteBackground);
                }
                else if (rbBlack.isChecked())
                {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit().putString("background", "blackBackground").commit();
                    scrollView.setBackgroundResource(R.color.blackBackground);
                }
                else
                    {
                    getSharedPreferences("MyContactListPreferences",
                            Context.MODE_PRIVATE).edit().putString("background", "redBackground").commit();
                    scrollView.setBackgroundResource(R.color.redBackground);
                }
            }
        });


    }
}
