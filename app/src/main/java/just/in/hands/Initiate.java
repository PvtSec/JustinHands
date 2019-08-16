package just.in.hands;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.onesignal.OneSignal;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class Initiate extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        HideSyS_UI.hideui(getWindow().getDecorView());
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
        setContentView(R.layout.activity_initiate);
        checkconnection();



    }
    public void checkconnection()
    {
        ConnectivityManager internet = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(internet.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                internet.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
        {
            //Toast.makeText(getApplicationContext(),"Internet Connection Success",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Initiate.this, Login_Activity.class));
            finish();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Check Internet Connection\nAnd Restart the App.",Toast.LENGTH_SHORT).show();
        }
    }

}
