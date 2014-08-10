package com.example.newnew;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PassDetailMainData extends Activity {
	Singleton ms;

	TextView textView3;
	TextView textView20;
	TextView textView6;
	TextView textView8;
	TextView textView10;
	TextView textView13;
	TextView textView15;
	TextView textView17;
	TextView textView19;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pass_detail_main_data);
		ms = Singleton.getInstance();
		SimpleDateFormat formater1 = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
		SimpleDateFormat formater2 = new SimpleDateFormat("yyyyMMdd",
				Locale.getDefault());
		SimpleDateFormat formater3 = new SimpleDateFormat("dd.MM.yyyy",
				Locale.getDefault());

		textView3 = (TextView) findViewById(R.id.textViewTrip);
		textView20 = (TextView) findViewById(R.id.textView20);
		textView6 = (TextView) findViewById(R.id.textView6);
		textView8 = (TextView) findViewById(R.id.textView8);
		textView10 = (TextView) findViewById(R.id.textView10);
		textView13 = (TextView) findViewById(R.id.textView13);
		textView15 = (TextView) findViewById(R.id.textView15);
		textView17 = (TextView) findViewById(R.id.textView17);
		textView19 = (TextView) findViewById(R.id.textView19);

		textView3.setText(ms.getPassDetailMain().getProperty("latName")
				.toString());
		textView20.setText(ms.getPassDetailMain().getProperty("name")
				.toString());
		textView6.setText(ms.getSex()[Integer.valueOf(ms.getPassDetailMain()
				.getProperty("sex").toString())]);
		
		if (!ms.getPassDetailMain().getProperty("bdate").toString()
				.equals("anyType{}")) {

			try {
				textView8.setText(formater3.format(formater2.parse(ms.getPassDetailMain().getProperty("bdate").toString())));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		textView10
				.setText(ms.getCountry()[1][ms.codeToPosition(ms.getCountry(),
						ms.getPassDetailMain().getProperty("CCitizenship")
								.toString())]);
		textView13.setText(ms.getMainDocument()[1][ms.codeToPosition(
				ms.getMainDocument(),
				ms.getPassDetailMain().getProperty("CPaspType").toString())]);
		
		if (!ms.getPassDetailMain().getProperty("paspExpireDate")
				.toString().equals("anyType{}")){
		try {
			textView15.setText(formater3.format(formater1.parse(ms.getPassDetailMain().getProperty("paspExpireDate").toString())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		textView17.setText(ms.getPassDetailMain().getProperty("paspNum")
				.toString());
		textView19.setText(ms.getPassDetailMain().getProperty("identif")
				.toString().equals("anyType{}")?"":ms.getPassDetailMain().getProperty("identif")
						.toString());
	}

}
