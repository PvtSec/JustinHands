package just.in.hands;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Student_Dashboard extends AppCompatActivity
{
    SharedPreferences student;
    TextView student_id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        HideSyS_UI.hideui(getWindow().getDecorView());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__dashboard);
        student_id = findViewById(R.id.student_id_txt);
        student = getSharedPreferences("login", MODE_PRIVATE);
        student_id.setText(student.getString("Student_ID", ""));
    }
}
