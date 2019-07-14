package just.in.hands;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        HideSyS_UI.hideui(getWindow().getDecorView());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__dashboard);
        student_id = findViewById(R.id.userid_dash);

        student = getSharedPreferences("login", MODE_PRIVATE);
        student_id.setText(student.getString("Student_ID", ""));
        start_fetch();
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
    }