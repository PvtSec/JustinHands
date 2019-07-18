package just.in.hands;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Student_Dashboard extends AppCompatActivity
{
    SharedPreferences student;
    TextView student_id,student_name,student_dept,dash_notify;
    CardView updates,notes,attendance,internals,projects,helpdesk;
    LinearLayout whole;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        HideSyS_UI.hideui(getWindow().getDecorView());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__dashboard);
        student_name=findViewById(R.id.username_dash);
        student_id = findViewById(R.id.userid_dash);
        student_dept = findViewById(R.id.dept_dash);
        dash_notify = findViewById(R.id.dash_notification);

        updates = findViewById(R.id.updates_card);
        notes = findViewById(R.id.notes_card);
        attendance = findViewById(R.id.attendance_card);
        internals = findViewById(R.id.internals_card);
        projects = findViewById(R.id.projects_card);
        helpdesk = findViewById(R.id.helpdesk_card);

        student = getSharedPreferences("login", MODE_PRIVATE);
        //student_id.setText(student.getString("Student_ID", ""));


        start_fetch();
        start_cards();
        }

        public void start_fetch()
        {
        String url="http://neutralizer.ml/api/user_data.php";
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response)
                {
                    try
                    {
                        JSONObject dash_objects = new JSONObject(response);
                        JSONArray dash_data = dash_objects.getJSONArray("data");
                        JSONObject dash_updates = dash_data.getJSONObject(0);
                        String dash_status=dash_updates.getString("Status");
                        if(dash_status.equals("Success"))
                        {
                            student_name.setText(dash_updates.getString("Name"));
                            student_id.setText(dash_updates.getString("Unique_ID"));
                            student_dept.setText(dash_updates.getString("Department"));
                            dash_notify.setText(dash_updates.getString("Notification"));
                        }
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
                    SignInData.put("userid", student.getString("Student_ID", ""));
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
                    Intent updates =new Intent(Student_Dashboard.this, Updates_Activity.class);
                    View update_view = findViewById(R.id.updates_icon);
                    String updates_trans = getString(R.string.trans_updates);
                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(Student_Dashboard.this, update_view, updates_trans);
                    startActivity(updates, transitionActivityOptions.toBundle());
                }
            });
            notes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent note =new Intent(Student_Dashboard.this, Notes_Activity.class);
                    View notes_view = findViewById(R.id.notes_icon);
                    String notes_trans = getString(R.string.trans_notes);
                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(Student_Dashboard.this, notes_view, notes_trans);
                    startActivity(note, transitionActivityOptions.toBundle());
                }
            });
            attendance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent attendans =new Intent(Student_Dashboard.this, Attendance_Activity.class);
                    View attendance_view = findViewById(R.id.attendance_icon);
                    String attendance_trans = getString(R.string.trans_attendance);
                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(Student_Dashboard.this, attendance_view, attendance_trans);
                    startActivity(attendans, transitionActivityOptions.toBundle());
                }
            });
            internals.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent internal =new Intent(Student_Dashboard.this, Internals_Activity.class);
                    View internals_view = findViewById(R.id.internals_icon);
                    String internals_trans = getString(R.string.trans_internals);
                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(Student_Dashboard.this, internals_view, internals_trans);
                    startActivity(internal, transitionActivityOptions.toBundle());
                }
            });
            projects.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent project =new Intent(Student_Dashboard.this, Projects_Activity.class);
                    View projects_view = findViewById(R.id.projects_icon);
                    String project_trans = getString(R.string.trans_projects);
                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(Student_Dashboard.this, projects_view, project_trans);
                    startActivity(project, transitionActivityOptions.toBundle());
                }
            });
            helpdesk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Intent helpdesks =new Intent(Student_Dashboard.this, Helpdesk_Activity.class);
                    View helpdesk_view = findViewById(R.id.helpdesk_icon);
                    String helpdesk_trans = getString(R.string.trans_helpdesk);
                    ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(Student_Dashboard.this, helpdesk_view, helpdesk_trans);
                    startActivity(helpdesks, transitionActivityOptions.toBundle());
                }
            });

        }
}