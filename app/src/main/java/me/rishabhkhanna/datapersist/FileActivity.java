package me.rishabhkhanna.datapersist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileActivity extends AppCompatActivity {
    EditText etFile;
    Button btnStore;
    TextView tvRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        etFile = (EditText) findViewById(R.id.etFile);
        btnStore = (Button) findViewById(R.id.btnStore);
        tvRead = (TextView) findViewById(R.id.tvRead);
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toBeStored = etFile.getText().toString();
                writeToFile("MYFILE",toBeStored);
            }
        });

        String read = readFile("MYFILE");
        if(read != null){
            tvRead.setText(read);
        }
    }

    public String readFile(String fileName){
        // write code to read file
        // set text to tvRead
        File path = getFilesDir();
        File toBeRead = new File(path,fileName);
        FileInputStream fileInputStream;
        InputStreamReader inputStreamReader;
        try {
            fileInputStream = new FileInputStream(toBeRead);
            inputStreamReader = new InputStreamReader(fileInputStream);
            char[] data = new char[10];
            Boolean end = false;
            StringBuilder stringBuilder = new StringBuilder();
            while(!end) {

                if (inputStreamReader.read(data) == -1) {
                    end = true;
                    break;
                }
                stringBuilder.append(data);

            }

            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }


    public void writeToFile(String fileName, String text){
        // write code to store text in file
        File path = getFilesDir();
        File fileToBeStored = new File(path,fileName);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileToBeStored);
            fileOutputStream.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
