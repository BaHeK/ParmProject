package com.example.newnew;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class NewTripActivity extends Activity implements OnClickListener {
	
	Singleton ms;
	SoapConstants servinf;
	Spinner classAuto;
	Spinner typeAuto;
	Spinner modelAuto;
	SharedPreferences sPref;
	EditText numAuto;
	EditText trailerNum;
	TextView textTrip;
	TextView textClassAuto;
	TextView textTypeAuto;
	TextView textModelAuto;
	TextView textTrailerNum;
	Button buttonNumAuto;
	String tripId;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_trip);
		
		sPref = getSharedPreferences("ParmSettings", MODE_PRIVATE);
		ms = Singleton.getInstance();
		
		textTrip = (TextView) findViewById(R.id.textViewTrip);
		buttonNumAuto = (Button) findViewById(R.id.buttonNumAuto);
		numAuto = (EditText) findViewById(R.id.editTextNumAuto);
		
		textTrailerNum = (TextView) findViewById(R.id.textViewTrailerNum);
		trailerNum = (EditText) findViewById(R.id.editTextTrailerNum);
		
		textClassAuto  =(TextView)findViewById(R.id.textViewClasAuto);
		classAuto = (Spinner)findViewById(R.id.spinnerClasAuto);
		
		textTypeAuto  =(TextView)findViewById(R.id.textViewTypeAuto);
		typeAuto = (Spinner)findViewById(R.id.spinnerTypeAuto);
		
		textModelAuto  =(TextView)findViewById(R.id.textViewModelAuto);
		modelAuto = (Spinner)findViewById(R.id.spinnerModelAuto);
		
		ArrayAdapter<String> adapterClassAuto = new ArrayAdapter<String>(this,
				R.layout.sss, ms.getClassAuto()[1]);
		adapterClassAuto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		classAuto.setAdapter(adapterClassAuto);
		classAuto.setPrompt(" Î‡ÒÒ “—");
		
		ArrayAdapter<String> adapterTypeAuto = new ArrayAdapter<String>(this,
				R.layout.sss, ms.getTypeAuto()[1]);
		adapterTypeAuto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		typeAuto.setAdapter(adapterTypeAuto);
		typeAuto.setPrompt("“ËÔ “—");
		
		ArrayAdapter<String> adapterModelAuto = new ArrayAdapter<String>(this,
				R.layout.sss, ms.getModelAuto()[1]);
		adapterModelAuto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		modelAuto.setAdapter(adapterModelAuto);
		modelAuto.setPrompt("ÃÓ‰ÂÎ¸ “—");
		
		
		Intent intent = getIntent();
		tripId = intent.getStringExtra("tripId");		
		
			
		if (!(tripId == "-1"))
		{
			editMode(true);
			textTrip.setText(R.string.EditTrip);
			numAuto.setText(tripId);
			
		}
		else
		{
			editMode(false);
			textTrip.setText(R.string.newTrip);
		}
			

	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	private void editMode(boolean value) {
		classAuto.setEnabled(value);
	}
}
