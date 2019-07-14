package just.in.hands;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class Student_Dashboard extends AppCompatActivity
{
    SharedPreferences student;
    TextView student_id;
    CardView updates,notes,attendance,internals,projects,helpdesk;
    LinearLayout whole;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        HideSyS_UI.hideui(getWindow().getDecorView());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__dashboard);
        student_id = findViewById(R.id.userid_dash);
        updates = findViewById(R.id.updates_card);
        notes = findViewById(R.id.notes_card);
        attendance = findViewById(R.id.attendance_card);
        internals = findViewById(R.id.internals_card);
        projects = findViewById(R.id.projects_card);
        helpdesk = findViewById(R.id.helpdesk_card);

        student = getSharedPreferences("login", MODE_PRIVATE);
        student_id.setText(student.getString("Student_ID", ""));


        start_fetch();
        start_cards();
        }

        public void start_fetch()
        {
        String url="http://yesmsbomber.tk/api/user_data.php";
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response)
                {
                    try
                    {
                        Toast.makeText(getApplicationContext(),"This toast is response inside",Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
                }
            })
            {
                protected Map<String, String> getParams()
                {
                    Map<String, String> SignInData = new HashMap<>();
                    SignInData.put("userid", student_id.getText().toString());
                    return SignInData;
                }
            };
            requestQueue.add(stringRequest);


        }

        public void start_cards()
        {
            updates.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent update =new Intent(Student_Dashboard.this, Updates_Activity.class);
                    View sharedView = findViewById(R.id.bell_icon);
                    String transitionName = getString(R.string.dash_updates);
                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(Student_Dashboard.this, sharedView, transitionName);
                    startActivity(update, transitionActivityOptions.toBundle());
                }
            });
            notes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    startActivity(new Intent(Student_Dashboard.this, Notes_Activity.class));
                }
            });
            attendance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    startActivity(new Intent(Student_Dashboard.this, Attendance_Activity.class));
                }
            });
            internals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    startActivity(new Intent(Student_Dashboard.this, Internals_Activity.class));
                }
            });
            projects.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    startActivity(new Intent(Student_Dashboard.this, Projects_Activity.class));
                }
            });
            helpdesk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    startActivity(new Intent(Student_Dashboard.this, Helpdesk_Activity.class));
                }
            });

        }
}