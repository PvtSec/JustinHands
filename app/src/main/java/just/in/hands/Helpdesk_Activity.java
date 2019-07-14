package just.in.hands;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Helpdesk_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        HideSyS_UI.hideui(getWindow().getDecorView());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpdesk_);
    }
}
