package just.in.hands;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

public class Notes_Activity extends AppCompatActivity
{
    CardView first_year, third_sem,fourth_sem,fifth_sem,sixth_sem,seventh_sem,eighth_sem;
    ImageView exit_notes;

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
        exit_notes = findViewById(R.id.go_back);
        exit_notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        start_note_clicks();
    }

    public void start_note_clicks()
    {
        first_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent note_first =new Intent(Notes_Activity.this, NotesLoader.class);
                note_first.putExtra("section","first");
                startActivity(note_first);
            }
        });
        third_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent note_third =new Intent(Notes_Activity.this, NotesLoader.class);
                note_third.putExtra("section","third");
                startActivity(note_third);
            }
        });
        fourth_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent note_fourth =new Intent(Notes_Activity.this, NotesLoader.class);
                note_fourth.putExtra("section","fourth");
                startActivity(note_fourth);
            }
        });
        fifth_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent note_fifth =new Intent(Notes_Activity.this, NotesLoader.class);
                note_fifth.putExtra("section","fifth");
                startActivity(note_fifth);
            }
        });
        sixth_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent note_sixth =new Intent(Notes_Activity.this, NotesLoader.class);
                note_sixth.putExtra("section","sixth");
                startActivity(note_sixth);
            }
        });
        seventh_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent note_seventh =new Intent(Notes_Activity.this, NotesLoader.class);
                note_seventh.putExtra("section","seventh");
                startActivity(note_seventh);
            }
        });
        eighth_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent note_eighth =new Intent(Notes_Activity.this, NotesLoader.class);
                note_eighth.putExtra("section","eighth");
                startActivity(note_eighth);
            }
        });
    }
}
