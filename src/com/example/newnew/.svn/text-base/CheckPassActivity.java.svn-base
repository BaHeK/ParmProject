package com.example.newnew;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.ksoap2.serialization.SoapObject;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CheckPassActivity extends Activity implements OnClickListener {
	TextView textView1;
	TextView textView2;
	TextView textView3;
	TextView textView4;
	TextView textView5;
	TextView textView6;
	TextView textView7;
	
	Intent intent;
	Singleton ms;
	SoapConstants servinf;
	LinearLayout ll1;
	
	
	Button btnCnsl;
	Button btnRegPass;
	Button btnChekPass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkpass);
		
		ms = Singleton.getInstance();
		servinf = SoapConstants.getInstance();

		btnCnsl = (Button) findViewById(R.id.btn6);
		btnRegPass = (Button)findViewById(R.id.btn4);
		btnChekPass = (Button)findViewById(R.id.btn5);
		btnChekPass.setEnabled(false);
		btnRegPass.setOnClickListener(this);
		btnCnsl.setOnClickListener(this);
		
		textView7 = (TextView)findViewById(R.id.textView17);
		ll1 = (LinearLayout)findViewById(R.id.LL1);
		if (ms.getCheckPass().getPropertyCount()>1){
			ll1.setBackgroundColor(Color.parseColor("#ff0000"));
			textView7.setText("НАРУШИТЕЛЬ");
		}
		if (ms.getTripSelected() == null){
			btnRegPass.setEnabled(false);
		}
		
		intent = getIntent();
		textView1 = (TextView) findViewById(R.id.textView11);
		textView1.setText(intent.getStringExtra("fiolat"));
		
		textView2 = (TextView) findViewById(R.id.textView12);
		textView2.setText(intent.getStringExtra("fiorus"));
		
		textView3 = (TextView) findViewById(R.id.textView13);
		textView3.setText(intent.getStringExtra("date"));
		
		textView4 = (TextView) findViewById(R.id.textView15);
		textView4.setText(intent.getStringExtra("docnum"));
		
		textView5 = (TextView) findViewById(R.id.textView14);
		textView5.setText(intent.getStringExtra("citi"));
		
		textView6 = (TextView) findViewById(R.id.textView16);
		textView6.setText(intent.getStringExtra("personalnum"));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn4:

			AsyncClass ac = new AsyncClass();
			ac.execute();
			break;
			
		case R.id.btn6:
			ms.setClearData(false);
			super.onBackPressed();
			break;
			
		default:
			break;
		}

	}
	
	private class AsyncClass extends AsyncTask<Void, Void, SoapObject> {
		ProgressDialog pd;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(CheckPassActivity.this);
			pd.setMessage("Загружается, ждите");
			pd.show();
		}

		@Override
		protected SoapObject doInBackground(Void... params) {
			SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy",Locale.getDefault());
			SimpleDateFormat formater2 = new SimpleDateFormat("yyyyMMdd",Locale.getDefault());
			SimpleDateFormat formater3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS",Locale.getDefault());
			String expireDate = "";
			String bDate = "";
			try {
				bDate = formater2.format(formater.parse(textView3.getText().toString()));
				expireDate = formater3.format(formater.parse(intent.getStringExtra("expiredate")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			SoapObject request = new Requests().getRegPass(textView2.getText().toString(), 
					textView1.getText().toString(), 
					intent.getStringExtra("sex"), 
					bDate, 
					intent.getStringExtra("citicode"), 
					textView4.getText().toString(), 
					textView6.getText().toString(), 
					intent.getStringExtra("pasptype"), 
					expireDate, 
					intent.getStringExtra("citiinout"), 
					intent.getStringExtra("goal"), 
					((SoapObject)ms.getCheckPass().getProperty(0)).getProperty("rid").toString()
					);
			SoapObject resa = new SoapRequest().sendRequest(request, servinf.getURL());
			
			return resa;
		}

		@Override
		protected void onPostExecute(SoapObject result) {
			super.onPostExecute(result);
			pd.cancel();
			ms.setClearData(true);
			CheckPassActivity.super.onBackPressed();

		}
	}

}
