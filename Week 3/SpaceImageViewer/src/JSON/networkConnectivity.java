package JSON;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

//Ariana Antonio
//Java 1, Week 1, Full Sail University, MDVBS
//06/10/2014

public class networkConnectivity {

	static String TAG = "NETWORK DATA - NETWORK CONNECTIVITY";
	static Context context;
	


	
	
	public Boolean connectionStatus (Context context) {
		Boolean comm = false;
		ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo network = manager.getActiveNetworkInfo();
		
		//check for network connection
		if (network !=null) {
			if (network.isConnected()) {
				Log.i(TAG, "Type of connection:" + network.getTypeName());
				comm = true;
			}
		}

		return comm;
	}


}
