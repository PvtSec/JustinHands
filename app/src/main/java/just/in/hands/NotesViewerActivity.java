package just.in.hands;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.downloader.Error;
import com.downloader.OnCancelListener;
import com.downloader.OnDownloadListener;
import com.downloader.OnPauseListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.Progress;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotesViewerActivity extends AppCompatActivity {
    PDFView note_pdf;
    String note_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HideSyS_UI.hideui(getWindow().getDecorView());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_viewer);
        note_pdf = findViewById(R.id.note_view);
        PRDownloader.initialize(getApplicationContext());
        Intent intent = getIntent();
        note_name = intent.getExtras().getString("Subject");
        check_exist();
    }

    public void check_exist() {
        String path = this.getFilesDir().getAbsolutePath() + "/"+note_name+".pdf";
        File files = new File(path);
        if (files.exists()) {
            note_pdf.fromFile(files).load();
        } else {
            check_connection();
        }
    }

    public void check_connection() {
        ConnectivityManager internet = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (internet.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                internet.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            download_pdf();
        } else {
            Toast.makeText(getApplicationContext(), "Check Internet Connection\nAnd Restart the App.", Toast.LENGTH_SHORT).show();
        }
    }
    public void download_pdf()
        {
            String url = "http://neutralizer.ml/"+note_name+".pdf";
            String dirPath = this.getFilesDir().getAbsolutePath();
            String Filename = note_name+".pdf";
            int downloadId = PRDownloader.download(url, dirPath, Filename)
                    .build()
                    .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                        @Override
                        public void onStartOrResume() {

                        }
                    })
                    .setOnPauseListener(new OnPauseListener() {
                        @Override
                        public void onPause() {

                        }
                    })
                    .setOnCancelListener(new OnCancelListener() {
                        @Override
                        public void onCancel() {

                        }
                    })
                    .setOnProgressListener(new OnProgressListener() {
                        @Override
                        public void onProgress(Progress progress) {

                        }
                    })
                    .start(new OnDownloadListener() {
                        @Override
                        public void onDownloadComplete()
                        {
                            check_exist();
                        }

                        @Override
                        public void onError(Error error) {
                        }
                    });
        }
}