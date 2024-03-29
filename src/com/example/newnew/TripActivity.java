package com.example.newnew;

import org.ksoap2.serialization.SoapObject;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class TripActivity extends Activity implements OnClickListener{
	TextView textView1;
	TextView textView2;
	TextView textView3;
	TextView textView4;
	TextView textView5;
	TextView textView6;
	Button btnNew;
	Button btnEdit;
	Button btnOk;
	Button btnCancel;
	Button btnViewPass;
	View SelectionItem;

	ListView lvMain;
	
	Singleton ms;
	SoapConstants servinf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trip);
		ms = Singleton.getInstance();
		servinf = SoapConstants.getInstance();
		
		textView1 = (TextView)findViewById(R.id.textView5);
		textView2 = (TextView)findViewById(R.id.textView6);
		textView3 = (TextView)findViewById(R.id.textView7);
		textView4 = (TextView)findViewById(R.id.textView11);
		textView5 = (TextView)findViewById(R.id.textView12);
		textView6 = (TextView)findViewById(R.id.textView14);
		
		btnEdit = (Button)findViewById(R.id.btn5);
		btnNew = (Button)findViewById(R.id.btn4);
		btnOk = (Button)findViewById(R.id.btn6);
		btnCancel =(Button)findViewById(R.id.btn7);
		btnViewPass = (Button)findViewById(R.id.btn8);
		
		btnOk.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
		btnViewPass.setOnClickListener(this);
		btnEdit.setOnClickListener(this);
		btnNew.setOnClickListener(this);
		
		btnEdit.setEnabled(false);
		btnNew.setEnabled(true);
		btnOk.setEnabled(false);
		btnViewPass.setEnabled(false);
		
		lvMain = (ListView) findViewById(R.id.lvMain);
		// ������������� ����� ������ ������� ������
		lvMain.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		// ������� �������, ��������� ������ �� ����� ��������

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list, ms.getTripList()[0]);
		lvMain.setAdapter(adapter);
		lvMain.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				if (SelectionItem!=null) {
					SelectionItem.setBackgroundColor(Color.parseColor("#f5f5dc"));
				}
				arg1.setBackgroundColor(Color.parseColor("#d2b48c"));
				SelectionItem = arg1;
				btnOk.setEnabled(true);
				btnViewPass.setEnabled(true);
				btnEdit.setEnabled(true);
				textView1.setText(((SoapObject)ms.getTrip().getProperty(arg2)).getProperty("amountPassangers").toString());
				textView2.setText(((SoapObject)ms.getTrip().getProperty(arg2)).getProperty("countPass").toString());
				textView3.setText(((SoapObject)ms.getTrip().getProperty(arg2)).getProperty("countPassSend").toString());
				textView4.setText(((SoapObject)ms.getTrip().getProperty(arg2)).getProperty("countViol").toString());
				textView5.setText(((SoapObject)ms.getTrip().getProperty(arg2)).getProperty("countViolSend").toString());
				textView6.setText(((SoapObject)ms.getTrip().getProperty(arg2)).getProperty("CTripState").toString()=="4"?"�����������":"�����������");
				

			}
		});
		
		

	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn4:
			AsyncClass1 NewT = new AsyncClass1();
			NewT.execute();
			break;
			case R.id.btn5:
		//Intent intent =  new Intent(this,NewTrip.class);
		//ms.setTrip((SoapObject)ms.getTrip().getProperty(lvMain.getCheckedItemPosition()));
		//ms.setTripSelected((SoapObject)ms.getTrip().getProperty(lvMain.getCheckedItemPosition()));
		//startActivity(intent);
			AsyncClass1 ac1 = new AsyncClass1();
			ac1.execute();
			break;
		case R.id.btn6:
			ms.setTripSelected((SoapObject)ms.getTrip().getProperty(lvMain.getCheckedItemPosition()));
			super.onBackPressed();
			break;
		case R.id.btn7:
			super.onBackPressed();
			break;
		case R.id.btn8:
			AsyncClass ac = new AsyncClass();
			ac.execute();
            break;
		default:
			break;
		}

	}
	
	private class AsyncClass1 extends AsyncTask<Void, Void, SoapObject> {
		ProgressDialog pd;
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(TripActivity.this);
			pd.setMessage("�����������, �����");
			pd.show();
		}


		@Override
		protected void onPostExecute(SoapObject result) {
			super.onPostExecute(result);
			pd.cancel();
			Intent intent = new Intent(TripActivity.this, NewTripActivity.class);
			String tripId;
			if (lvMain.getCheckedItemPosition() > 0)
			{
				tripId = ((SoapObject)ms.getTrip().getProperty(lvMain.getCheckedItemPosition())).getProperty("tripId").toString();
			}
			else
			{
				tripId = "-1";
			}
			 

				intent.putExtra("tripId", tripId);			  

		
			startActivity(intent);
		}


		@Override
		protected SoapObject doInBackground(Void... params) {
			
			//ms.setTrip((SoapObject)ms.getTrip().getProperty(lvMain.getCheckedItemPosition()));
			return null;
		}

	}
	
	
	private class AsyncClass extends AsyncTask<Void, Void, SoapObject> {
		ProgressDialog pd;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(TripActivity.this);
			pd.setMessage("�����������, �����");
			pd.show();
		}

		@Override
		protected SoapObject doInBackground(Void... params) {
			
			SoapObject request = new Requests().getPassangersOnTrip(((SoapObject)ms.getTrip().getProperty(lvMain.getCheckedItemPosition())).getProperty("tripId").toString());
			SoapObject resa = new SoapRequest().sendRequest(request, servinf.getURL2());
			ms.setPassOnTripList(resa);
			ms.setPassList(resa);
			
			return resa;
		}

		@Override
		protected void onPostExecute(SoapObject result) {
			super.onPostExecute(result);
			pd.cancel();
			Intent intent = new Intent(TripActivity.this, PassOnTripActivity.class);
			startActivity(intent);

		}
	}

}
