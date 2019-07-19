package just.in.hands;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Notes_Activity extends AppCompatActivity
{
    CardView first_year, third_sem,fourth_sem,fifth_sem,sixth_sem,seventh_sem,eighth_sem;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        HideSyS_UI.hideui(getWindow().getDecorView());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        first_year = findViewById(R.id.First_Year);
        third_sem = findViewById(R.id.Semester_3);
        fourth_sem = findViewById(R.id.Semester_4);
        fifth_sem = findViewById(R.id.Semester_5);
        sixth_sem = findViewById(R.id.Semester_6);
        seventh_sem = findViewById(R.id.Semester_7);
        eighth_sem = findViewById(R.id.Semester_8);
        start_note_clicks();
    }

    public void start_note_clicks()
    {
        first_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Notes_Activity.this, NotesLoader.class));
            }
        });
        third_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        fourth_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        fifth_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        sixth_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        seventh_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        eighth_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
