package just.in.hands;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

public class Helpdesk_Activity extends AppCompatActivity
{
    ImageView exit_helpdesk;
    CardView academic,tech;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        HideSyS_UI.hideui(getWindow().getDecorView());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpdesk_);
        exit_helpdesk = findViewById(R.id.go_back);
        academic = findViewById(R.id.academic_card);
        tech = findViewById(R.id.general_card);

        exit_helpdesk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        academic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                clicker("Academic");
            }
        });
        tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                clicker("Tech");
            }
        });
    }

    public void clicker(String category)
    {
        Intent start_doubt = new Intent(Helpdesk_Activity.this, DoubtsActivity.class);
        start_doubt.putExtra("Category",category);
        View academic_doubt = findViewById(R.id.academic_icon);
        String academic_string = getString(R.string.trans_doubts);
        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(Helpdesk_Activity.this, academic_doubt, academic_string);
        startActivity(start_doubt,transitionActivityOptions.toBundle());
    }
}
