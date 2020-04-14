package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.provider.Browser;
import android.provider.CallLog;
import android.provider.CallLog.Calls;
import android.widget.Toast;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio.Media;
import android.content.CursorLoader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnshowallcontact, btnaccesscalllog, btnaccessmediastore, btnaccessbookmarks;
    public static final Uri BOOKMARKS_URI = Uri.parse("content://browser/bookmarks/5");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnshowallcontact = findViewById(R.id.btnshowallcontact);
        btnaccesscalllog = findViewById(R.id.btnaccesscalllog);
        btnaccessmediastore = findViewById(R.id.btnaccessmediastore);
        btnaccessbookmarks = findViewById(R.id.btnaccessbookmarks);

        btnshowallcontact.setOnClickListener(this);
        btnaccesscalllog.setOnClickListener(this);
        btnaccessmediastore.setOnClickListener(this);
        btnaccessbookmarks.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        if (v == btnshowallcontact) {
            intent = new Intent(this, ShowAllContactActivity.class);
            startActivity(intent);
        } else if (v == btnaccesscalllog) {
            accessTheCallLog();
        } else if (v == btnaccessmediastore) {
            accessMediaStore();
        } else if (v == btnaccessbookmarks) {
            accessBookmarks();
        }
    }

    /**
     * hàm đọc danh sách Bookmark trong trình duyệt
     */
    private void accessBookmarks() {
        Toast.makeText(this, "API không hỗ trợ", Toast.LENGTH_SHORT).show();
//        String[] projection = {
//                Browser.BookmarkColumns.TITLE,
//                Browser.BookmarkColumns.URL,
//        };
//        Cursor c = getContentResolver()
//                .query(Browser.BOOKMARKS_URI, projection,
//                        null, null, null);
//        c.moveToFirst();
//        String s = "";
//        int titleIndex = c.getColumnIndex
//                (Browser.BookmarkColumns.TITLE);
//        int urlIndex = c.getColumnIndex
//                (Browser.BookmarkColumns.URL);
//        while (!c.isAfterLast()) {
//            s += c.getString(titleIndex) + " - " +
//                    c.getString(urlIndex);
//            c.moveToNext();
//        }
//        c.close();
//        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    /**
     * hàm đọc danh sách các Media trong SD CARD
     */
    private void accessMediaStore() {
        String[] projection = {
                MediaStore.MediaColumns.DISPLAY_NAME,
                MediaStore.MediaColumns.DATE_ADDED,
                MediaStore.MediaColumns.MIME_TYPE
        };
        CursorLoader loader = new CursorLoader
                (this, Media.EXTERNAL_CONTENT_URI,
                        projection, null, null, null);
        Cursor c = loader.loadInBackground();
        c.moveToFirst();
        String s = "";
        while (!c.isAfterLast()) {
            for (int i = 0; i < c.getColumnCount(); i++) {
                s += c.getString(i) + " - ";
            }
            s += "\n";
            c.moveToNext();
        }
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        c.close();
    }

    /**
     * hàm lấy danh sách lịch sử cuộc gọi
     * * với thời gian nhỏ hơn 30 giây và sắp xếp theo ngày gọi
     */
    private void accessTheCallLog() {
        String[] projection = new String[]{
                Calls.DATE,
                Calls.NUMBER,
                Calls.DURATION
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Cursor c = getContentResolver().query(
                Calls.CONTENT_URI,
                projection,
                Calls.DURATION + "<?", new String[]{"30"},
                Calls.DATE + " Asc");
        c.moveToFirst();
        String s = "";
        while (c.isAfterLast() == false) {
            for (int i = 0; i < c.getColumnCount(); i++) {
                s += c.getString(i) + " - ";
            }
            s += "\n";
            c.moveToNext();
        }
        c.close();
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}
