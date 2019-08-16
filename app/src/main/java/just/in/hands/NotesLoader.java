package just.in.hands;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wang.avi.AVLoadingIndicatorView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NotesLoader extends AppCompatActivity
{
    private RecyclerView notes_View;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    AVLoadingIndicatorView note_progress;

    ArrayList<String> course_id = new ArrayList<>();
    ArrayList<String> course_name = new ArrayList<>();

    String sem_year;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_loader);
        note_progress = findViewById(R.id.notes_progress);
        course_id.clear();
        course_name.clear();
        Intent note_intent = getIntent();
        sem_year = note_intent.getStringExtra("section");

        get_notes_list();
    }
    public void get_notes_list()
    {
        {
            String url = "https://neutralizer.ml/api/notes_data.php";
            SharedPreferences student = getSharedPreferences("login", MODE_PRIVATE);
            final String student_id = student.getString("Student_ID", "");
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {
                    note_progress.hide();
                    try
                    {
                        JSONObject notes_object = new JSONObject(response);
                        JSONArray notes_data = notes_object.getJSONArray("data");
                        notes_list(notes_data);
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
                protected Map<String, String> getParams() {
                    Map<String, String> student_data = new HashMap<>();
                    student_data.put("Sem_Year_id", sem_year);
                    return student_data;
                }
            };
            requestQueue.add(stringRequest);
        }
    }
    public void notes_list(JSONArray data_notes)
    {
        try {
            for (int i = 0; i < data_notes.length(); i++) {
                JSONObject updates = data_notes.getJSONObject(i);
                course_id.add(updates.getString("Id"));
                course_name.add(updates.getString("Course"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        notes_View = findViewById(R.id.notes_recycle);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        notes_View.setLayoutManager(mLayoutManager);

        mAdapter = new NotesRecyclerAdapter(getApplicationContext(), course_id, course_name);
        notes_View.setAdapter(mAdapter);
        notes_View = findViewById(R.id.notes_recycle);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        notes_View.setLayoutManager(mLayoutManager);

        mAdapter = new NotesRecyclerAdapter(getApplicationContext(), course_id, course_name);
        notes_View.setAdapter(mAdapter);
    }
}
