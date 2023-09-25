package com.funix.lab7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtLink;
    private ProgressBar progressBar;
    private int size = 0;
    private Button btOpen;
    private String savePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        progressBar = findViewById(R.id.progress_bar);
        edtLink = findViewById(R.id.edt_link);
        findViewById(R.id.bt_download).setOnClickListener(this);
        btOpen = findViewById(R.id.bt_open);
        //btOpen.setEnabled(false);
        btOpen.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!checkPermission()) return;
        if (v.getId() == R.id.bt_download) {
            downloadFile(edtLink.getText().toString());
        } else if (v.getId() == R.id.bt_open) {
            openFile();
        }

    }

    private boolean checkPermission() {
        boolean isAllow = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        if (!isAllow) {
            requestPermissions(new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 101);
        }
        return isAllow;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 101) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Quyền đã được cấp, thực hiện các hành động sau khi có quyền
                downloadFile(edtLink.getText().toString());
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openFile() {
        if (savePath == null || savePath.isEmpty()){ return;}
        File file = new File(savePath);
        Uri uri = FileProvider.getUriForFile(this, getPackageName() + ".provider", file);
        String mime = getContentResolver().getType(uri);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, mime);
        //FRAG_GRANT_READ_URI_PERMISSION là để khai báo thêm cờ báo hiệu đã được sự đồng ý để
        //đọc dữ liệu của đường dẫn uri
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(intent);
    }

    private void downloadFile(String link) {
        new Thread(() -> {
            DownloadManager.Request request=new DownloadManager.Request(Uri.parse(link));
            request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE|DownloadManager.Request.NETWORK_WIFI);
            request.setTitle("Download");
            request.setDescription("Download File");
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            savePath = getExternalFilesDir(null).getPath() + "/" + new File(link).getName();
            request.setDestinationInExternalFilesDir(MainActivity.this, Environment.DIRECTORY_DOWNLOADS,savePath);
            DownloadManager downloadManager=(DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            if (downloadManager != null) {
                long downloadId = downloadManager.enqueue(request);

                // Kiểm tra tiến trình tải xuống
                boolean downloading = true;
                while (downloading) {
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(downloadId);
                    Cursor cursor = downloadManager.query(query);
                    if (cursor != null && cursor.moveToFirst()) {
                        @SuppressLint("Range") int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
                        @SuppressLint("Range") int progress = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
                        @SuppressLint("Range") int totalSize = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));

                        // Cập nhật tiến trình tải xuống trên ProgressBar
                        runOnUiThread(() -> {
                            progressBar.setMax(totalSize);
                            progressBar.setProgress(progress);
                        });

                        if (status == DownloadManager.STATUS_SUCCESSFUL) {
                            downloading = false;
                        }
                    }

                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }

            // Tải xuống hoàn thành, ẩn ProgressBar
            runOnUiThread(() -> progressBar.setVisibility(View.GONE));
        }).start();
       }
}