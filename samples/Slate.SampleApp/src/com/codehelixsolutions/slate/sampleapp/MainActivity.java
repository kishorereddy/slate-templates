package com.codehelixsolutions.slate.sampleapp;

import com.codehelixsolutions.slate.sampleapp.lib.ActivityBase;
import com.slate.templates.templating.TemplateView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends ActivityBase implements OnClickListener {

	private TemplateView _templateView;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		configureActionBar();
		
		// 1. Load the slate template "slate_template1.txt" into the container.
		TemplateView view = inflateTemplateInto("slate_sample2.txt", true, R.id.pageMainContainer, R.id.pageMainErrorMessage);
		
		if(view != null)
		{
			// 2. Now register callback events
			view.setOnClickListener("icPhone", this);
			view.setOnClickListener("icChat", this);
			view.setOnClickListener("icShare", this);
		}
		// 3. Store reference to templated view.
		_templateView = view;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	@Override
	public void onClick(View view) {
		if(view.getTag().toString().equals("action_phone"))
		{
			_templateView.setText("message", "phone icon clicked", null);
		}
		else if(view.getTag().toString().equals("action_chat"))
		{
			_templateView.setText("message", "chat icon clicked", null);
		}
		else if(view.getTag().toString().equals("action_share"))
		{
			_templateView.setText("message", "share icon clicked", null);
		}
	}

}
