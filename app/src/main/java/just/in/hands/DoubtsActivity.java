package just.in.hands;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wang.avi.AVLoadingIndicatorView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoubtsActivity extends AppCompatActivity
{
    private RecyclerView doubt_view;
    private RecyclerView.Adapter doubtAdapter;
    private RecyclerView.LayoutManager doubtLayoutManager;
    AVLoadingIndicatorView doubt_progress;
    ImageView answer_stat_img;
    Button goto_ask;

    ArrayList<String> question_id = new ArrayList<>();
    ArrayList<String> question_txt = new ArrayList<>();
    ArrayList<String> question_stat = new ArrayList<>();
    ArrayList<String> question_ans = new ArrayList<>();

    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubts);
        doubt_progress = findViewById(R.id.doubts_progress);
        goto_ask = findViewById(R.id.askq);
        question_id.clear();
        question_txt.clear();
        question_stat.clear();
        question_ans.clear();

        Intent doubt_intent = getIntent();
        category = doubt_intent.getStringExtra("Category");
        Toast.makeText(getApplicationContext(),category,Toast.LENGTH_SHORT).show();

        goto_ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ask_intent = new Intent(DoubtsActivity.this,QuestionActivity.class);
                startActivity(ask_intent);
            }
        });

        get_user_doubts();
    }

    public void get_user_doubts()
    {
            String base = getString(R.string.base_url);
            String url=base+"api/test.php";
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            JSONObject userdataObject = new JSONObject();
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                    url, userdataObject,
                    new Response.Listener<JSONObject>()
                    {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                            doubt_progress.hide();
                            try {
                                JSONObject doubt_object = new JSONObject(String.valueOf(response));
                                JSONArray doubt_data = doubt_object.getJSONArray("data");
                                doubt_list(doubt_data);
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
                    error.printStackTrace();
                    Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue.add(jsonObjReq);
    }
    public void doubt_list(JSONArray doubt_data)
    {

        try {
            for (int i = 0; i < doubt_data.length(); i++) {
                JSONObject updates = doubt_data.getJSONObject(i);
                question_id.add(updates.getString("Q_Id"));
                question_txt.add(updates.getString("Q_text"));
                question_stat.add(updates.getString("Q_stat"));
                question_ans.add(updates.getString("Q_Ans"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        doubt_view = findViewById(R.id.doubts_recycle);
        doubtLayoutManager = new LinearLayoutManager(getApplicationContext());
        doubt_view.setLayoutManager(doubtLayoutManager);

        doubtAdapter = new DoubtsRecycler(getApplicationContext(), question_id, question_txt, question_stat,question_ans);
        doubt_view.setAdapter(doubtAdapter);
        doubt_view = findViewById(R.id.doubts_recycle);
        doubtLayoutManager = new LinearLayoutManager(getApplicationContext());
        doubt_view.setLayoutManager(doubtLayoutManager);

        doubtAdapter = new DoubtsRecycler(getApplicationContext(), question_id, question_txt, question_stat,question_ans);
        doubt_view.setAdapter(doubtAdapter);
    }
}
