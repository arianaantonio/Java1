package com.arianaantonio.spaceimageviewer;

//Ariana Antonio
//Java 1, Week 1, Full Sail University, MDVBS
//06/10/2014

import imageDetail.ImageDetail;
import imageType.ImageType;

import java.util.ArrayList;

import org.json.JSONObject;

import JSON.buildJSON;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	//global variables
	Context mContext;
	ArrayList<String> arrayForSpinner = new ArrayList<String>();
	ArrayList<String> arrayForGridView = new ArrayList<String>();
	final TextView detailView = new TextView(this);
	
	static buildJSON imageJSON = new buildJSON();
	static JSONObject imageObj = imageJSON.buildsJSONTypes();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//creating layout
		mContext = this;
		LinearLayout mainLayout = new LinearLayout(mContext);
		mainLayout.setOrientation(LinearLayout.VERTICAL);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		mainLayout.setLayoutParams(params);
		//gtting JSON titles
		for (ImageType types : ImageType.values()) {
			arrayForSpinner.add(types.getTypeTitle());
		}
		//creating spinner
		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, arrayForSpinner);
		spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinnerView = new Spinner(mContext);
		spinnerView.setAdapter(spinnerAdapter);
		params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		spinnerView.setLayoutParams(params);
		//on click for spinner
		spinnerView.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				//Toast.makeText(mContext, "You selected:" + arrayForSpinner[position], Toast.LENGTH_LONG).show();
				//String typeSelected = arrayForSpinner.get(position);
				
				//if (typeSelected.equals(object))
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		//getting image JSON titles
		for (ImageDetail images : ImageDetail.values()) {
			arrayForGridView.add(images.getImageTitle());
		}
		//creating gridview
		ArrayAdapter<String> gridAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, arrayForGridView);
		GridView gridView = new GridView(mContext);
		gridView.setAdapter(gridAdapter);
		gridView.setLayoutParams(params);
		gridView.setNumColumns(2);
		
		detailView.setLayoutParams(params);
		//on click for gridview
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				//Toast.makeText(mContext, "You selected:" + testArray[position], Toast.LENGTH_LONG).show();
				//detailView.setText(text);
				
			}
		});
		
		
		
		//adding view to layout
		mainLayout.addView(spinnerView);
		mainLayout.addView(gridView);
		mainLayout.addView(detailView);
		setContentView(mainLayout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
