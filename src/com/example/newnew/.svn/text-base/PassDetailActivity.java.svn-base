package com.example.newnew;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class PassDetailActivity extends TabActivity implements OnClickListener {
	
	Button btnBack;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pass_detail_main);
		
		btnBack = (Button) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(this);
		
		TabHost tabHost = getTabHost();
		
		TabHost.TabSpec tabSpec;
		
		tabSpec = tabHost.newTabSpec("tag1");
		tabSpec.setIndicator("Основные данные");
		tabSpec.setContent(new Intent(this, PassDetailMainData.class));
		tabHost.addTab(tabSpec);
		
		tabSpec = tabHost.newTabSpec("tag2");
		tabSpec.setIndicator("Дополнительные документы");
		tabSpec.setContent(new Intent(this, PassDetailDopDocData.class));
		tabHost.addTab(tabSpec);
		
		tabSpec = tabHost.newTabSpec("tag3");
		tabSpec.setIndicator("Пассажир");
		tabSpec.setContent(new Intent(this, PassDetailPassData.class));
		tabHost.addTab(tabSpec);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnBack:
			this.onBackPressed();
			break;

		default:
			break;
		}
		// TODO Auto-generated method stub
		
	}

}
