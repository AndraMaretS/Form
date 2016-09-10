package id.sch.smktelkom_mlg.tugas01.xirpl4004.form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNis, etNama, etTgl;
    Button buttonOK;
    TextView tvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNis = (EditText) findViewById(R.id.editTextNis);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etTgl = (EditText) findViewById(R.id.editTextTglLhr);
        buttonOK = (Button) findViewById(R.id.buttonOk);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doEditText();
            }
        });
    }

    private void doEditText() {
        String nis = etNis.getText().toString();
        String nama = etNama.getText().toString();
        String tgl = etTgl.getText().toString();
        tvHasil.setText("NIS                    : " + nis + "\n" +
                "Nama                  : " + nama + "\n" +
                "Tanggal Lahi   : " + tgl);
    }


}
