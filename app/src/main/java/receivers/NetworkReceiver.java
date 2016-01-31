package receivers;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.HashMap;

import constants.Constants;
import listeners.NetworkListener;

public class NetworkReceiver extends BroadcastReceiver {

    public static final String RECEIVER_KEY = "com.testapp.assignment.RECEIVER_KEY";
    NetworkListener mListener;

    public NetworkReceiver(){};

    public NetworkReceiver(Context context) {
        super();
        if(context instanceof Activity)
            mListener = (NetworkListener)context;

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        if(intent.getAction() == RECEIVER_KEY){
            try {
                ArrayList<HashMap<String, String>> data = (ArrayList<HashMap<String, String>>) intent.getSerializableExtra(Constants.DATA);
                String title = intent.getStringExtra(Constants.TITLE);
                if(mListener != null)
                    mListener.onInformationReceived(data,title);

            }
            catch(ClassCastException classCastException){
                classCastException.printStackTrace();
            }
        }
        else {
            throw new UnsupportedOperationException();
        }
    }
}
