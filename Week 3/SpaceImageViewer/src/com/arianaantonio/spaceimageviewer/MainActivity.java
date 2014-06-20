package com.arianaantonio.spaceimageviewer;

//Ariana Antonio
//Java 1, Week 1, Full Sail University, MDVBS
//06/10/2014



import imageType.ImageType;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import JSON.buildJSON;
import JSON.networkConnectivity;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	//global variables
	
	Context mContext;
	ArrayList<String> arrayForSpinner = new ArrayList<String>();
	ArrayList<String> arrayForGridView = new ArrayList<String>();
	ArrayList<String> arrayForTypeId = new ArrayList<String>();
	
	buildJSON imageJSON = new buildJSON();
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mContext = this;
		//final buildJSON imageJSON = new buildJSON();
		
		//checking network connection
		networkConnectivity networkConnection = new networkConnectivity();
		Boolean networkConn = networkConnection.connectionStatus(mContext);
		if (networkConn) {
			Toast.makeText(mContext, "You are connected", Toast.LENGTH_LONG).show(); 
		} else {
			Toast.makeText(mContext, "You are NOT connected", Toast.LENGTH_LONG).show();
		}
		
		//creating layout
		LinearLayout mainLayout = new LinearLayout(mContext);
		mainLayout.setOrientation(LinearLayout.VERTICAL);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		mainLayout.setLayoutParams(params);
		//getting JSON titles
		for (ImageType types : ImageType.values()) {
			arrayForSpinner.add(types.getTypeTitle());
			arrayForTypeId.add(types.getTypeID());
		}
		
		//creating spinner
		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, arrayForSpinner);
		spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinnerView = new Spinner(mContext);
		spinnerView.setAdapter(spinnerAdapter);
		params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		spinnerView.setLayoutParams(params);
		
		//creating gridview
		final ArrayAdapter<String> gridAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, arrayForGridView);
		GridView gridView = new GridView(mContext);
		params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		gridView.setAdapter(gridAdapter);
		gridView.setLayoutParams(params);
		gridView.setNumColumns(2);
		
		
		//on click for spinner
		spinnerView.setOnItemSelectedListener(new OnItemSelectedListener() {

			
				
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				//get position of selected item
				String typeSelected = arrayForTypeId.get(position);
				Log.v(typeSelected, "What you clicked: " + typeSelected);
				
				//empty gridview so it doesn't append data
				arrayForGridView.removeAll(arrayForGridView);
		
				
				try {
					
					networkConnectivity networkConnection = new networkConnectivity();
					Boolean networkConn = networkConnection.connectionStatus(mContext);
					//check for network when trying to pull data
					if (networkConn) {
						//grab data from type selected and set to gridview array
						JSONArray imageTypeArray = imageJSON.buildsJSONImages(mContext, typeSelected);
						//Log.v(typeSelected, "Image array:" + imageTypeArray.length());
						for (int i = 0; i < imageTypeArray.length(); i++) {
							Log.v(typeSelected, "Image array test:" + imageTypeArray.getJSONObject(i).getString("url_regular"));
							arrayForGridView.add(imageTypeArray.getJSONObject(i).getString("url_regular"));
						} 
					} else {
						//if no network connection
						arrayForGridView.removeAll(arrayForGridView);
						gridAdapter.notifyDataSetChanged();
						Toast.makeText(mContext, "You are NOT connected", Toast.LENGTH_LONG).show();
					}
				} catch (JSONException e) {
					e.printStackTrace();
				
				} 
		
			} 
			 

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			 
		});
		
		
		//adding view to layout
		mainLayout.addView(spinnerView);
		mainLayout.addView(gridView);
		//mainLayout.addView(detailView);
		setContentView(mainLayout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
