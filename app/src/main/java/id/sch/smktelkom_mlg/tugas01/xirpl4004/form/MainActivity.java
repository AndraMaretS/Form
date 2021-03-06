package id.sch.smktelkom_mlg.tugas01.xirpl4004.form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText etNis, etNama, etTgl;
    Button buttonOK;
    TextView tvHasil, tvJk, tvHobi, tvData;
    RadioButton rbLk, rbPr;
    Spinner spProvinsi, spKota;
    CheckBox cbOR, cbBaca, cbSeni;
    String[][] arKota = {{"Jakarta Barat", "Jakarta Pusat", "Jakarta Selatan", "Jakarta Timur", "Jakarta Utara"},
            {"Bandung", "Cirebon", "Bekasi"}, {"Semarang", "Surakarta", "Magelang"}, {"Surabaya", "Malang", "Blitar"}, {"Denpasar"}};
    ArrayList<String> listKota = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTitle("Andraid");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNis = (EditText) findViewById(R.id.editTextNis);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etTgl = (EditText) findViewById(R.id.editTextTglLhr);
        spProvinsi = (Spinner) findViewById(R.id.spinnerProvinsi);
        spKota = (Spinner) findViewById(R.id.spinnerKota);
        rbLk = (RadioButton) findViewById(R.id.radioButtonLk);
        rbPr = (RadioButton) findViewById(R.id.radioButtonPr);
        cbOR = (CheckBox) findViewById(R.id.checkBoxOR);
        cbBaca = (CheckBox) findViewById(R.id.checkBoxBaca);
        cbSeni = (CheckBox) findViewById(R.id.checkBoxSeni);
        buttonOK = (Button) findViewById(R.id.buttonOk);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvJk = (TextView) findViewById(R.id.textViewJk);
        tvHobi = (TextView) findViewById(R.id.textViewHobi);
        tvData = (TextView) findViewById(R.id.textViewData);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listKota);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKota.setAdapter(adapter);

        spProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                listKota.clear();
                listKota.addAll(Arrays.asList(arKota[pos]));
                adapter.notifyDataSetChanged();
                spKota.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProses();
            }
        });
    }

    private void doProses() {
        if (isValid()) {
            String nis = etNis.getText().toString();
            String nama = etNama.getText().toString();
            String tgl = etTgl.getText().toString();
            String kota = spKota.getSelectedItem().toString();
            String provinsi = spProvinsi.getSelectedItem().toString();
            tvData.setText("\nData Siswa\n");
            tvHasil.setText("NISN                 : " + nis + "\n" +
                    "Nama               : " + nama + "\n" +
                    "Asal                  : " + kota + ", " + provinsi + "\n" +
                    "Tanggal Lahir  : " + tgl);

            String Jk = null;
            if (rbLk.isChecked()) {
                Jk = rbLk.getText().toString();
            } else if (rbPr.isChecked()) {
                Jk = rbPr.getText().toString();
            }
            if (Jk == null) {
                tvJk.setText("Anda belum memilih Data Jenis Kelamin");
            } else {
                tvJk.setText("Jenis Kelamin : " + Jk);
            }
            String hobi = "";
            int startlen = hobi.length();
            if (cbOR.isChecked()) hobi += cbOR.getText() + ", ";
            if (cbBaca.isChecked()) hobi += cbBaca.getText() + ", ";
            if (cbSeni.isChecked()) hobi += cbSeni.getText();
            if (hobi.length() == startlen) {
                tvHobi.setText("Anda belum memilih hoby\n");
            } else {
                tvHobi.setText("Hoby anda      : " + hobi);
            }
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nis = etNis.getText().toString();
        String nama = etNama.getText().toString();
        String tgl = etTgl.getText().toString();

        if (nis.isEmpty()) {
            etNis.setError("Nisn belum diisi");
            valid = false;
        } else if (nis.length() != 6) {
            etNis.setError("Nisn harus 6 digit");
            valid = false;
        } else {
            etNis.setError(null);
        }

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (tgl.isEmpty()) {
            etTgl.setError("Tanggal Kelahiran belum diisi");
            valid = false;
        } else if (tgl.length() != 8) {
            etTgl.setError("Format Tahun Kelahiran harus ddmmyyyy");
        } else {
            etTgl.setError(null);
        }
        return valid;
    }


}
