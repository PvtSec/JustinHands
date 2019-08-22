package just.in.hands;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.wang.avi.AVLoadingIndicatorView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Updates_Activity extends AppCompatActivity
{
    ImageView exit_updates;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    AVLoadingIndicatorView progress;

    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        HideSyS_UI.hideui(getWindow().getDecorView());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates);
        progress = findViewById(R.id.update_progress);
        exit_updates = findViewById(R.id.go_back);
        exit_updates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        id.clear();
        title.clear();
        description.clear();
        get_update_list();
    }

    public void get_update_list()
    {
        {
			String base = getString(R.string.base_url);
            String url = base+"api/updates.php";
            SharedPreferences student = getSharedPreferences("login", MODE_PRIVATE);
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {
                    progress.hide();
                        try
                        {
                            JSONObject updates_object = new JSONObject(response);
                            JSONArray updates_data = updates_object.getJSONArray("data");
                            update_list(updates_data);
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
            });
            requestQueue.add(stringRequest);
        }
    }

    public void update_list(JSONArray data)
    {
        try {
            for (int i = 0; i < data.length(); i++) {
                JSONObject updates = data.getJSONObject(i);
                id.add(updates.getString("Id"));
                title.add(updates.getString("Title"));
                description.add(updates.getString("Description"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        recyclerView = findViewById(R.id.updates_recycle);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerAdapter(getApplicationContext(), id, title, description);
        recyclerView.setAdapter(mAdapter);recyclerView = findViewById(R.id.updates_recycle);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerAdapter(getApplicationContext(), id, title, description);
        recyclerView.setAdapter(mAdapter);
    }
}