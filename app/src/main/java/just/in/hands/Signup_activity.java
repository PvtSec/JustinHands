package just.in.hands;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.HashMap;
import java.util.Map;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class Signup_activity extends AppCompatActivity
{
    TextView signin;
    EditText name,studentId,newPass,confirmPass;
    CircularProgressButton signupBtn;
    String pass_name,pass_studentId,pass_password,pass_course;
    String[] course_list = {"E.C.E","E.E.E","M.E","C.S.E"};
    MaterialBetterSpinner CourseList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        HideSyS_UI.hideui(getWindow().getDecorView());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signin=findViewById(R.id.signin);
        name=findViewById(R.id.name_entry);
        studentId=findViewById(R.id.student_id);
        newPass=findViewById(R.id.new_password);
        confirmPass=findViewById(R.id.confirm_password);
        signupBtn=findViewById(R.id.signup_button);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, course_list);
        CourseList = findViewById(R.id.signup_course);
        CourseList.setAdapter(arrayAdapter);

        studentId.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if((newPass.getText().toString().equals(confirmPass.getText().toString())))
                {
                    signupBtn.startAnimation();
                    pass_name=name.getText().toString();
                    pass_studentId=studentId.getText().toString();
                    pass_password=confirmPass.getText().toString();
                    pass_course = CourseList.getText().toString();
                    sendSignupData();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Passwords do not Match",Toast.LENGTH_SHORT).show();
                }
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try {
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    private void sendSignupData()
    {
        RequestQueue requestQueue;
        StringRequest stringRequest;
        String base = getString(R.string.base_url);
        String url=base+"api/signup.php";
        requestQueue = Volley.newRequestQueue(this);
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                signupBtn.revertAnimation();
                if (response.equals("Signup Success"))
                {
                    try
                    {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("STUDENT_ID", pass_studentId);
                        setResult(Activity.RESULT_OK, resultIntent);
                        finish();
                        Toast.makeText(getApplicationContext(), "Signup Successfull, Login Now", Toast.LENGTH_SHORT).show();

                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
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
                Map<String, String> SignUpData = new HashMap<>();
                SignUpData.put("Name", pass_name);
                SignUpData.put("StudentId", pass_studentId);
                SignUpData.put("Course", pass_course);
                SignUpData.put("Password", pass_password);
                return SignUpData;
            }
        };
        requestQueue.add(stringRequest);
    }





    @Override
    public void onDestroy()
    {
        super.onDestroy();
        signupBtn.dispose(); //to avoid memory leak due to 3rd Party Library
    }
}
