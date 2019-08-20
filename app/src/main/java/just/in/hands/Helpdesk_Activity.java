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
                Intent start_academic = new Intent(Helpdesk_Activity.this, DoubtsActivity.class);
                start_academic.putExtra("Category","Academic");
                View academic_doubt = findViewById(R.id.academic_icon);
                String academic_string = getString(R.string.trans_doubts);
                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(Helpdesk_Activity.this, academic_doubt, academic_string);
                startActivity(start_academic,transitionActivityOptions.toBundle());
            }
        });
        tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent start_general = new Intent(Helpdesk_Activity.this, DoubtsActivity.class);
                start_general.putExtra("Category","Tech");
                View tech_doubt = findViewById(R.id.genearl_icon);
                String tech_string = getString(R.string.trans_doubts);
                ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(Helpdesk_Activity.this, tech_doubt, tech_string);
                startActivity(start_general,transitionActivityOptions.toBundle());
            }
        });
    }
}
