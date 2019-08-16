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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;



public class Login_Activity extends AppCompatActivity
{
    String user, pass;
    CircularProgressButton loginBtn;
    TextView signup,loginError;
    EditText username,password;
    SharedPreferences UserData;
    private RequestQueue requestQueue;
    private String url="https://neutralizer.ml/api/signin.php";
    String stat;


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

        username.setFilters(new InputFilter[] {new InputFilter.AllCaps()});


        if(UserData.getBoolean("isLogin", false))
        {
            startActivity(new Intent(Login_Activity.this, Student_Dashboard.class));
            finish();
        }


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
            JSONObject signinObject = new JSONObject();
            try {
                signinObject.put("user", user);
                signinObject.put("passwd", pass);
            } catch (Exception e) {
                e.printStackTrace();
            }


            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    url, signinObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                            try {
                                stat = response.getString("Status");
                                loginBtn.revertAnimation();
                                if (stat.equals("Success")) {
                                    UserData.edit().putBoolean("isLogin", true).apply();
                                    UserData.edit().putString("Student_ID", user).apply();
                                    startActivity(new Intent(Login_Activity.this, Student_Dashboard.class));
                                    finish();
                                } else {
                                    loginError.setText(stat);
                                    loginError.setVisibility(View.VISIBLE);
                                }
                            }
                             catch (Exception e)
                            {
                            e.printStackTrace();
                             }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();

                }
            });
            requestQueue.add(jsonObjReq);
        }




    @Override
    public void onDestroy()
    {
        super.onDestroy();
        loginBtn.dispose();
    }
}