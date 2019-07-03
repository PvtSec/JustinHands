package just.in.hands;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
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

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;



public class Login_Activity extends AppCompatActivity
{
    String user, pass;
    CircularProgressButton loginBtn;
    TextView signup,loginError;
    EditText username,password;
    SharedPreferences UserData;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private String url="http://neutralizer.ml/api/signin.php";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        HideSyS_UI.hideui(getWindow().getDecorView());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        loginBtn=findViewById(R.id.login_button);
        signup=findViewById(R.id.goto_signup);
        username=findViewById(R.id.username_entry);
        password=findViewById(R.id.password_entry);
        loginError=findViewById(R.id.login_error);
        UserData=getSharedPreferences("login",MODE_PRIVATE);


        if(UserData.getBoolean("isLogin", false))
        {
            startActivity(new Intent(Login_Activity.this, Student_Dashboard.class));
            finish();
        }


        username.setFilters(new InputFilter[] {new InputFilter.AllCaps()});

        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    startActivityForResult(new Intent(Login_Activity.this, Signup_activity.class), 5);
                } catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loginBtn.startAnimation();
                user=username.getText().toString();
                pass=password.getText().toString();
                sendLoginData();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode)
        {
            case (5) : {
                if (resultCode == Activity.RESULT_OK) {
                    String newStudentID = data.getStringExtra("STUDENT_ID");
                    username.setText(newStudentID);
                }
                break;
            }
        }
    }

    private void sendLoginData()
    {
        requestQueue = Volley.newRequestQueue(this);
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                loginBtn.revertAnimation();
                if (response.equals("Login Success"))
                {
                    try {
                        UserData.edit().putBoolean("isLogin", true).apply();
                        UserData.edit().putString("Student_ID", user).apply();
                        startActivity(new Intent(Login_Activity.this, Student_Dashboard.class));
                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else
                {
                    loginError.setText(response);
                    loginError.setVisibility(View.VISIBLE);
                    //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                loginBtn.revertAnimation();
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        })
        {
            protected Map<String, String> getParams()
            {
                Map<String, String> SignInData = new HashMap<>();
                SignInData.put("user", user);
                SignInData.put("passwd", pass);
                return SignInData;
            }
        };
        requestQueue.add(stringRequest);
    }




    @Override
    public void onDestroy()
    {
        super.onDestroy();
        loginBtn.dispose();
    }
}