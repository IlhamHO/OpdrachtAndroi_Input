package be.ehb.opdrachtandroi_input;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public RadioGroup rgReminder;
    public EditText etTitel;
    public EditText etOmschrijving;
    public Calendar datum;
    public Button btnSave, btnDatum;


    private View.OnClickListener datumListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            toonKalenderDialoog();
        }
    };

    private void toonKalenderDialoog() {


        DatePickerDialog geboorteDatumPicker = new DatePickerDialog(this, null, datum.get(Calendar.YEAR), datum.get(Calendar.MONTH), datum.get(Calendar.DAY_OF_MONTH));
        geboorteDatumPicker.show();

        DatePickerDialog.OnDateSetListener datumListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                datum.set(Calendar.YEAR, year);
                datum.set(Calendar.MONTH, month);
                datum.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            }
        };

    }

    private View.OnClickListener saveListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Log.i("TEST", etTitel.getText().toString());
            Log.i("TEST", etOmschrijving.getText().toString());
            Log.i("TEST", datum.getTime().toString());

            switch (rgReminder.getCheckedRadioButtonId()) {
                case R.id.rb_normaal:
                    Log.i("TEST", "Normaal");
                    break;
                case R.id.rb_hoog:
                    Log.i("TEST", "Hoog");
                    break;
                case R.id.rb_laag:
                    Log.i("TEST", "Laag");
                    break;
                default:
                    Log.i("TEST", "Niks gekozen");
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

            String datumAlsTekst = sdf.format(datum.getTime());
            btnDatum.setText(datumAlsTekst);


            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            Reminder toPass = new Reminder();
//TODO reminder opvullen
            toPass.setDatum(datum);
            toPass.setTitel(etTitel.getText().toString());
            toPass.setOmschrijving(etOmschrijving.getText().toString());

            intent.putExtra("reminder", toPass);
            startActivity(intent);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datum = Calendar.getInstance();

        etTitel = findViewById(R.id.et_titel);
        etOmschrijving = findViewById(R.id.et_omschrijving);
        btnDatum = findViewById(R.id.btn_datum);
        btnSave = findViewById(R.id.btn_save);
rgReminder =findViewById(R.id.radioGroup);
        btnSave.setOnClickListener(saveListener);
        btnDatum.setOnClickListener(datumListener);

    }


}
