//Author: Ariana Antonio
//Project: Linear Layout
//For: Java 1, Full Sail University, Mobile Development
//June 4, 2014

package com.arianaantonio.linearlayout;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	//declaring view variables and setting them to corresponding view
	final List<Integer> inputArray = new ArrayList<Integer>();
	Button button = (Button) findViewById(R.id.button1);
	final TextView textview = (TextView) findViewById(R.id.textView1);
	Button button2 = (Button) findViewById(R.id.button2);
	Button button3 = (Button) findViewById(R.id.button3);
	final EditText textField = (EditText)findViewById(R.id.editText1);
	final TextView averageView = (TextView) findViewById(R.id.textView2);
	final TextView isOddView = (TextView) findViewById(R.id.textView3);
	
	//onClick event for Click Me button
	button.setOnClickListener(new OnClickListener() {
		
		
		@Override
		public void onClick(View view) {	
			
			//grabbing text from input field and setting adding it to array
			Log.v("Text:", textField.getText().toString());
			String inputString = textField.getText().toString();
			int stringToInt = Integer.parseInt(inputString);
			inputArray.add(stringToInt);
			//System.out.println(inputArray);
			String printString;
			
			//resetting textview to empty before setting input
			textview.setText("");
			
			//loop through input array and add value to textview
			for (int i : inputArray) {
				String textString = "You entered ";
				int enteredInt = i;
				printString = textString + enteredInt + ", ";
				System.out.println(printString);
				
				textview.append(printString);
			}
			//resetting textfield to empty after each input
			textField.setText("");
		}
		
	});
	//onClick event for Done button
	button2.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View view) {
			allDone(inputArray);
		
		}
	});
	//onClick event for Reset button
	button3.setOnClickListener(new OnClickListener(){
		@Override
		public void onClick(View view) {
		//resetting textviews and array to start over
		textview.setText(R.string.textview_text);
		averageView.setText(R.string.average_textview);
		isOddView.setText(R.string.odd_textview);
		inputArray.clear();
		
		
		}
	});	
	
}
	//function to handle inputed values
	public void allDone(List<Integer> inputArray) {
		//initialize local variables
		int arraySum = 0;
		Boolean isOdd = null;
		TextView averageView = (TextView) findViewById(R.id.textView2);
		TextView isOddView = (TextView) findViewById(R.id.textView3);
		
		//loop through array and add values together
		for (int i : inputArray) {
			arraySum+=i;
		}
		//grab the sum and divide it by the array length to get average, then set to textview
		int sumTotal = arraySum;
		int average = sumTotal/inputArray.size();
		System.out.println("Total:" + sumTotal);
		System.out.println("Average:" + average);
		averageView.setText("Average: " + average);
		
		//determine if average value is even or odd
		if (average % 2 == 0) {
			isOdd = false;
		} else if (average %2 != 0) {
			isOdd = true;
		} else {
			isOdd = null;
			System.out.println("Could not get even or odd status");
		}
		//set isOdd status to textview
		System.out.println("Is odd:" + isOdd);
		isOddView.setText("Is it odd = " + isOdd);
	
	
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
