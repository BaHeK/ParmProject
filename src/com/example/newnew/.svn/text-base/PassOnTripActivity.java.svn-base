package com.example.newnew;

import org.ksoap2.serialization.SoapObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class PassOnTripActivity extends Activity implements OnClickListener {
	ListView lvMain;
	Singleton ms;
	Button btnView;
	Button btnCnsl;
	SoapConstants servinf;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pass_on_trip);
		ms = Singleton.getInstance();
		servinf = SoapConstants.getInstance();
		
		btnView = (Button)findViewById(R.id.btn4);
		btnCnsl = (Button)findViewById(R.id.btn5);
		
		btnView.setEnabled(false);
		
		btnCnsl.setOnClickListener(this);
		btnView.setOnClickListener(this);

		lvMain = (ListView) findViewById(R.id.lvMain);
		// устанавливаем режим выбора пунктов списка
		lvMain.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		// Создаем адаптер, используя массив из файла ресурсов

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list, ms.getPassOnTripList()[0]);
		lvMain.setAdapter(adapter);
		lvMain.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				btnView.setEnabled(true);
				
				
			}
			
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn5:
			super.onBackPressed();
			break;

		case R.id.btn4:
			PassDetail pd = new PassDetail();
			pd.execute();
			break;
			
		default:
			break;
		}
		// TODO Auto-generated method stub
	}
	
	private class PassDetail extends AsyncTask<Void, Void, Void> {
		ProgressDialog pd;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = new ProgressDialog(PassOnTripActivity.this);
			pd.setMessage("Загружается, ждите");
			pd.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			String did;
			did = ms.getPassOnTripList()[1][lvMain.getCheckedItemPosition()];
			
			SoapObject request = new Requests().getGetDocSetDataElement(did);
			SoapObject resa = new SoapRequest().sendRequest(request, servinf.getURL2());
			ms.setPassDetailMain((SoapObject)resa.getProperty(0));
			
			request = new Requests().getGetVisesElement(did);
			resa = new SoapRequest().sendRequest(request, servinf.getURL2());
			ms.setPassDetailDopDoc(resa);
			
			request = new Requests().getGetPassangersElement(did);
			resa = new SoapRequest().sendRequest(request, servinf.getURL2());
			ms.setPassDetailPass((SoapObject)resa.getProperty(0));
			
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			pd.cancel();
			Intent intent = new Intent(PassOnTripActivity.this, PassDetailActivity.class);
			startActivity(intent);

		}
	}

}
