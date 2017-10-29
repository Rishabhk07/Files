package me.rishabhkhanna.datapersist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FileActivity extends AppCompatActivity {
    EditText etFile;
    Button btnStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        etFile = (EditText) findViewById(R.id.etFile);
        btnStore = (Button) findViewById(R.id.btnStore);
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toBeStored = etFile.getText().toString();
                writeToFile("MYFILE",toBeStored);
            }
        });
    }

    public void writeToFile(String fileName, String text){
        // write code to store text in file
    }
}
