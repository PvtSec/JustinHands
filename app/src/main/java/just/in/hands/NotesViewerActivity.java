package just.in.hands;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;
import com.downloader.PRDownloader;
import com.github.barteksc.pdfviewer.PDFView;
import com.wang.avi.AVLoadingIndicatorView;

import java.io.File;
import java.io.FileOutputStream;

public class NotesViewerActivity extends AppCompatActivity {
    PDFView note_pdf;
    String note_name;
    TextView not_found;
    AVLoadingIndicatorView loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HideSyS_UI.hideui(getWindow().getDecorView());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_viewer);
        note_pdf = findViewById(R.id.note_view);
        not_found = findViewById(R.id.note_404);
        loader = findViewById(R.id.notes_loader);
        loader.show();
        PRDownloader.initialize(getApplicationContext());
        Intent intent = getIntent();
        note_name = intent.getExtras().getString("Subject");
        check_exist();
    }

    public void check_exist() {
        String path = this.getFilesDir().getAbsolutePath() + "/"+note_name+".pdf";
        File files = new File(path);
        if (files.exists()) {
            loader.hide();
            note_pdf.setVisibility(View.VISIBLE);
            note_pdf.fromFile(files).load();
        } else {
            check_connection();
        }
    }

    public void check_connection() {
        ConnectivityManager internet = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (internet.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                internet.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            get_pdf();
        } else {
            loader.hide();
            Toast.makeText(getApplicationContext(), "Check Internet Connection\nAnd Restart the App.", Toast.LENGTH_SHORT).show();
        }
    }

    private void get_pdf()
    {
        String url = "https://neutralizer.ml/"+note_name+".pdf";
        String dirPath = this.getFilesDir().getAbsolutePath();
        Pdf_Stream getPdf = new Pdf_Stream(Request.Method.GET, url, new Response.Listener<byte[]>() {
                    @Override
                    public void onResponse(byte[] response) {
                        try {
                            if (response!=null) {
                                File dir = new File (getApplicationContext().getFilesDir().getAbsolutePath());
                                dir.mkdirs();
                                File pdfFile = new File(getApplicationContext().getFilesDir().getAbsolutePath()+"/"+note_name+".pdf");
                                FileOutputStream stream = new FileOutputStream(pdfFile);
                                try {
                                    stream.write(response);
                                } finally
                                {
                                    stream.close();
                                }
                                loader.hide();
                                check_exist();
                            }
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                } ,new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                loader.hide();
                not_found.setVisibility(View.VISIBLE);
            }
        }, null);
        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext(), new HurlStack());
        mRequestQueue.add(getPdf);
    }
}