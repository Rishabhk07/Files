package me.rishabhkhanna.datapersist;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    SharedPreferences sharedPreferences;
    public static final String TAG = "MAinActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        sharedPreferences = getSharedPreferences("PREFS",MODE_PRIVATE);
        editText.setText(sharedPreferences.getString("key","not saved"));


        Log.d(TAG, "Data Dir " + Environment.getDataDirectory().getAbsolutePath());
        Log.d(TAG, "Root Dir " + Environment.getRootDirectory().getAbsolutePath());
        Log.d(TAG, "Cache Dir " + Environment.getDownloadCacheDirectory().getAbsolutePath());
        Log.d(TAG, "External Dir " + Environment.getExternalStorageDirectory().getAbsolutePath());
        Log.d(TAG, "External Public Dir " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());

        Log.d(TAG, "onCreate: ------------------------------------------------");
        Log.d(TAG, "File Dir" + getFilesDir());
        Log.d(TAG, "Cache Dir" + getCacheDir());
        Log.d(TAG, "External Dir" + getExternalFilesDir(null));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            File[] file = getExternalFilesDirs(null);
            for( File f : file){
                Log.d(TAG, "External storage " + file);
            }
        }


    }

    @Override
    protected void onStop() {
        super.onStop();
        sharedPreferences.edit().putString("key",editText.getText().toString()).apply();
    }
}
