package com.example.newnew;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.ksoap2.serialization.SoapObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainFormActivity extends Activity implements OnClickListener {
	Button btnSettings;
	Button btnClear;
	Button btnTrip;
	Button btnState;
	Button btnChkPass;
	Button btnSearch;

	EditText editText1;
	EditText editText2;
	EditText editText3;
	EditText editText4;
	EditText editText5;
	EditText editText6;

	Singleton ms;
	SoapConstants servinf;
	//String[] data = { "�������", "�������", "" };
	SharedPreferences sPref;

	Spinner spinner;
	Spinner spinner2;
	Spinner spinner3;
	Spinner spinner4;
	Spinner spinner5;
	Spinner spinner6;
	Spinner spinner7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mainform);
		Intent intent = new Intent(this, ActivitiSettings.class);
		startActivity(intent);

		btnSettings = (Button) findViewById(R.id.btn6);
		btnSettings.setOnClickListener(this);
		btnClear = (Button) findViewById(R.id.btn7);
		btnClear.setOnClickListener(this);
		btnTrip = (Button) findViewById(R.id.btn4);
		btnTrip.setOnClickListener(this);
		btnState = (Button) findViewById(R.id.btn5);
		btnState.setEnabled(false);
		btnChkPass = (Button) findViewById(R.id.btn8);
		btnChkPass.setOnClickListener(this);
		btnSearch = (Button) findViewById(R.id.btn3);
		btnSearch.setOnClickListener(this);

		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		editText3 = (EditText) findViewById(R.id.editText3);
		editText4 = (EditText) findViewById(R.id.editText4);
		editText5 = (EditText) findViewById(R.id.editText5);
		editText6 = (EditText) findViewById(R.id.editText6);

		ms = Singleton.getInstance();
		servinf = SoapConstants.getInstance();
		sPref = getSharedPreferences("ParmSettings", MODE_PRIVATE);
		// �������
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.sss, ms.getSex());
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setAdapter(adapter);
		spinner.setSelection(0);
		spinner.setPrompt("���");

		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				R.layout.sss, ms.getCountry()[2]);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		spinner2.setAdapter(adapter2);
		spinner2.setSelection(sPref.getInt("CITIZENSHIP", 0));
		spinner2.setPrompt("�����������");
		spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				spinner3.setSelection(arg2);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
				R.layout.sss, ms.getCountry()[1]);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		spinner3.setAdapter(adapter3);
		spinner3.setSelection(sPref.getInt("CITIZENSHIP", 0));
		spinner3.setPrompt("�����������");
		spinner3.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				spinner2.setSelection(arg2);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
				R.layout.sss, ms.getMainDocument()[1]);
		adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner4 = (Spinner) findViewById(R.id.spinner4);
		spinner4.setAdapter(adapter4);
		spinner4.setSelection(sPref.getInt("MAIN_DOCUMENT", 0));
		spinner4.setPrompt("��� ���������");

		ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,
				R.layout.sss, ms.getCountry()[2]);
		adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner5 = (Spinner) findViewById(R.id.spinner5);
		spinner5.setAdapter(adapter5);
		spinner5.setSelection(sPref.getInt("COUNTRY", 0));
		spinner5.setPrompt("������ ������/������");
		spinner5.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				spinner6.setSelection(arg2);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this,
				R.layout.sss, ms.getCountry()[1]);
		adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner6 = (Spinner) findViewById(R.id.spinner6);
		spinner6.setAdapter(adapter6);
		spinner6.setSelection(sPref.getInt("COUNTRY", 0));
		spinner6.setPrompt("������ ������/������");
		spinner6.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				spinner5.setSelection(arg2);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this,
				R.layout.sss, ms.getTarget()[1]);
		adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner7 = (Spinner) findViewById(R.id.spinner7);
		spinner7.setAdapter(adapter7);
		spinner7.setSelection(sPref.getInt("TARGET", 0));
		spinner7.setPrompt("���� �������");

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn6:
			Intent intent = new Intent(this, ActivitiSettings.class);
			startActivity(intent);
			break;
		case R.id.btn7:
			ClearData();
			break;
		case R.id.btn4:
			AsyncClass ac = new AsyncClass();
			ac.execute();

			break;
		case R.id.btn8:
			if (editText1.getText().toString().equals("")
					||editText2.getText().toString().equals("")
					||editText3.getText().toString().equals("")
					||editText4.getText().toString().equals("")
					||editText5.getText().toString().equals("")
					||editText6.getText().toString().equals("")){
				Toast.makeText(MainFormActivity.this, "��������� ��� ����", Toast.LENGTH_LONG).show();
			}else{
			AsyncClass3 ac3 = new AsyncClass3();
			ac3.execute();
			}
			break;
		case R.id.btn3:
			if (editText3.getText().toString().equals("")) {
				Toast.makeText(MainFormActivity.this,
						"������� ����� ���������", Toast.LENGTH_LONG).show();
			} else {
				if (editText6.getText().toString().equals("")) {
					android.content.DialogInterface.OnClickListener myClickListener = new android.content.DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							switch (which) {
							// ������������� ������
							case Dialog.BUTTON_POSITIVE:
								editText6.setText("00000000");
								AsyncClass2 ac2 = new AsyncClass2();
								ac2.execute();
								break;

							case Dialog.BUTTON_NEGATIVE:

								break;
							}
						}
					};
					AlertDialog.Builder dialog = new AlertDialog.Builder(
							MainFormActivity.this);
					dialog.setIcon(android.R.drawable.ic_dialog_info);
					dialog.setMessage("�� ������� ���� ������� ������� ���� ��������.���������� ����� ��� ����� ���� ��������?");
					dialog.setPositiveButton("��", myClickListener);
					dialog.setNegativeButton("���", myClickListener);
					dialog.create().show();
				} else {
					AsyncClass2 ac2 = new AsyncClass2();
					ac2.execute();
				}

			}
			break;

		default:
			break;
		}

	}

	private void ClearData(){
		spinner.setSelection(0);
		spinner2.setSelection(sPref.getInt("CITIZENSHIP", 0));
		spinner3.setSelection(sPref.getInt("CITIZENSHIP", 0));
		spinner4.setSelection(sPref.getInt("MAIN_DOCUMENT", 0));
		spinner5.setSelection(sPref.getInt("COUNTRY", 0));
		spinner6.setSelection(sPref.getInt("COUNTRY", 0));
		spinner7.setSelection(sPref.getInt("TARGET", 0));

		editText1.setText("");
		editText1.setSelectAllOnFocus(true);
		editText2.setText("");
		editText3.setText("");
		editText4.setText("");
		editText5.setText("");
		editText6.setText("");	
	}
	
	@Override
	public void onBackPressed() {

		android.content.DialogInterface.OnClickListener myClickListener = new android.content.DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
				// ������������� ������
				case Dialog.BUTTON_POSITIVE:
					MainFormActivity.super.onBackPressed();
					break;
				}
			}
		};
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
		dialog.setIcon(android.R.drawable.ic_dialog_info);
		dialog.setTitle("�����");
		dialog.setMessage("��������� ����������?");
		dialog.setPositiveButton("��", myClickListener);
		dialog.setNegativeButton("���", null);
		dialog.create().show();
	}

	private class AsyncClass extends AsyncTask<Void, Void, SoapObject> {
		ProgressDialog pd;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(MainFormActivity.this);
			pd.setMessage("�����������, �����");
			pd.show();
		}

		@Override
		protected SoapObject doInBackground(Void... params) {
			SoapObject request = new Requests().getTripList(ms.getName(),
					ms.getPass(), ms.getKPP(),
					ms.getTypeAuto()[0][sPref.getInt("TYPE_AUTO", 0)],
					ms.getVector()[0][sPref.getInt("VECTOR", 0)]);
			SoapObject resa = new SoapRequest().sendRequest(request,
					servinf.getURL2());
			try {
				ms.setTripList(resa);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ms.setTrip(resa);
			return resa;
		}

		@Override
		protected void onPostExecute(SoapObject result) {
			super.onPostExecute(result);
			pd.cancel();
			Intent intent2 = new Intent(MainFormActivity.this,
					TripActivity.class);
			startActivity(intent2);

		}
	}

	private class AsyncClass2 extends AsyncTask<Void, Void, SoapObject> {
		ProgressDialog pd;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(MainFormActivity.this);
			pd.setMessage("�����������, �����");
			pd.show();
		}

		@Override
		protected SoapObject doInBackground(Void... params) {
			SoapObject request = new Requests().getGetPassInfo(editText3
					.getText().toString(), editText6.getText().toString());
			SoapObject resa = new SoapRequest().sendRequest(request,
					servinf.getURL2());
			return resa;
		}

		@Override
		protected void onPostExecute(SoapObject result) {
			super.onPostExecute(result);
			pd.cancel();
			if (result.getPropertyCount() == 0) {
				Toast.makeText(MainFormActivity.this,
						"���� � ������ ������� ��������� � ���� �� �������",
						Toast.LENGTH_LONG).show();
			} else {
				SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy",Locale.getDefault());
				SimpleDateFormat formater3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS",Locale.getDefault());
				
				String expireDate = "";
				
				try {
					expireDate = formater.format(formater3.parse(((SoapObject) result.getProperty(0))
							.getProperty("actualDate").toString()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				editText1.setText(((SoapObject) result.getProperty(0))
						.getProperty("latName").toString());
				editText2.setText(((SoapObject) result.getProperty(0))
						.getProperty("name").toString());
				editText6.setText(((SoapObject) result.getProperty(0))
						.getProperty("bdate").toString());
				spinner.setSelection(Integer.valueOf(((SoapObject) result
						.getProperty(0)).getProperty("sex").toString()));
				spinner2.setSelection(ms.codeToPosition(
						ms.getCountry(),
						((SoapObject) result.getProperty(0)).getProperty(
								"CCitizenship").toString()));
				editText4.setText(((SoapObject) result.getProperty(0))
						.getProperty("identif").toString());
				editText5.setText(expireDate);
				spinner4.setSelection(ms.codeToPosition(ms.getMainDocument(), ((SoapObject) result.getProperty(0))
						.getProperty("CPaspType").toString()));

			}
		}
	}
	
	private class AsyncClass3 extends AsyncTask<Void, Void, SoapObject> {
		ProgressDialog pd;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(MainFormActivity.this);
			pd.setMessage("�����������, �����");
			pd.show();
		}

		@Override
		protected SoapObject doInBackground(Void... params) {

			SoapObject request = new Requests().getCheckPass(ms.getCountry()[0][spinner2.getSelectedItemPosition()], 
					editText3.getText().toString(), 
					(ms.getTripSelected() == null)?"-1":ms.getTripSelected().getProperty("tripId").toString());
			SoapObject resa = new SoapRequest().sendRequest(request, servinf.getURL());
			
			if (((SoapObject)resa.getProperty(0)).getProperty("paramValue").toString().equals("0")){
			
			SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy",Locale.getDefault());
			SimpleDateFormat formater2 = new SimpleDateFormat("yyyyMMdd",Locale.getDefault());
			
			String bDate = "";
			
			try {
				bDate = formater2.format(formater.parse(editText6.getText().toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request = new Requests().getCheckAllLst(editText1.getText().toString(),
					editText2.getText().toString(), 
					String.valueOf(spinner.getSelectedItemPosition()), 
					bDate, 
					ms.getCountry()[0][spinner2.getSelectedItemPosition()], 
					editText3.getText().toString(), 
					editText4.getText().toString(), 
					ms.getVector()[0][sPref.getInt("VECTOR", 0)], 
					((SoapObject)ms.getUser().getProperty(0)).getProperty("paramValue").toString());
			resa = new SoapRequest().sendRequest(request, servinf.getURL());
			ms.setCheckPass(resa);
			return null;
			}else{
				return resa;
			}
		}

		@Override
		protected void onPostExecute(SoapObject result) {
			super.onPostExecute(result);
			pd.cancel();
			if (result == null){
				Intent intent2 = new Intent(MainFormActivity.this, CheckPassActivity.class);
				intent2.putExtra("fiolat", editText1.getText().toString());
				intent2.putExtra("fiorus", editText2.getText().toString());
				intent2.putExtra("date", editText6.getText().toString());
				intent2.putExtra("docnum", editText3.getText().toString());
				intent2.putExtra("citi",
						ms.getCountry()[2][spinner2.getSelectedItemPosition()]);
				intent2.putExtra("personalnum", editText4.getText().toString());
				intent2.putExtra("sex", String.valueOf(spinner.getSelectedItemPosition()));
				intent2.putExtra("pasptype", ms.getMainDocument()[0][spinner4.getSelectedItemPosition()]);
				intent2.putExtra("expiredate", editText5.getText().toString());
				intent2.putExtra("citiinout", ms.getCountry()[0][spinner5.getSelectedItemPosition()]);
				intent2.putExtra("goal", ms.getTarget()[0][spinner7.getSelectedItemPosition()]);
				intent2.putExtra("citicode", ms.getCountry()[0][spinner2.getSelectedItemPosition()]);
				startActivity(intent2);
			}else{
			
				Toast.makeText(MainFormActivity.this, ((SoapObject)result.getProperty(0)).getProperty("paramName").toString(), Toast.LENGTH_SHORT).show();
			}
		}
	}

	@Override
	protected void onResume(){
		super.onResume();
		if (ms.getClearData()) ClearData();
	}
}
