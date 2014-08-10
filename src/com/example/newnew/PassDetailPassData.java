package com.example.newnew;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PassDetailPassData extends Activity {
	Singleton ms;

	TextView textView3;
	TextView textView5;
	TextView textView7;
	TextView textView9;
	TextView textView10;
	TextView textView12;
	TextView textView14;
	TextView textView16;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pass_detail_pass_data);
		ms = Singleton.getInstance();
		SimpleDateFormat formater1 = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
		SimpleDateFormat formater2 = new SimpleDateFormat("dd.MM.yyyy",
				Locale.getDefault());
		SimpleDateFormat formater3 = new SimpleDateFormat("HH:mm",
				Locale.getDefault());
		
		textView3 = (TextView) findViewById(R.id.textViewTrip);
		textView5 = (TextView) findViewById(R.id.textView5);
		textView7 = (TextView) findViewById(R.id.textView7);
		textView9 = (TextView) findViewById(R.id.textView9);
		textView10 = (TextView) findViewById(R.id.textView10);
		textView12 = (TextView) findViewById(R.id.textView12);
		textView14 = (TextView) findViewById(R.id.textView14);
		textView16 = (TextView) findViewById(R.id.textView16);
		
		try {
			textView3.setText(formater2.format(formater1.parse(ms.getPassDetailPass().getProperty("regDate").toString())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			textView5.setText(formater3.format(formater1.parse(ms.getPassDetailPass().getProperty("regDate").toString())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		textView7.setText(ms.getVector()[1][ms.codeToPosition(ms.getVector(), ms.getPassDetailPass().getProperty("CDirection").toString())]);
		textView9.setText(ms.getCountry()[2][ms.codeToPosition(ms.getCountry(), ms.getPassDetailPass().getProperty("CCountry").toString())]);
		textView10.setText(ms.getCountry()[1][ms.codeToPosition(ms.getCountry(), ms.getPassDetailPass().getProperty("CCountry").toString())]);
		textView12.setText(ms.getTarget()[1][ms.codeToPosition(ms.getTarget(), ms.getPassDetailPass().getProperty("CGoalTrip").toString())]);
		textView14.setText(ms.getStatus()[1][ms.codeToPosition(ms.getStatus(), ms.getPassDetailPass().getProperty("CStatus").toString())]);
		textView16.setText(ms.getPassDetailPass().getProperty("userName").toString());
	}

}
