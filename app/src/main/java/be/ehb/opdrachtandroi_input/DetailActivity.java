package be.ehb.opdrachtandroi_input;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView titel;
    private TextView omschrijving;
    private TextView datum;
    private Reminder reminderSaved;
   

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        titel = findViewById(R.id.tv_titel);
        omschrijving = findViewById(R.id.tv_omschrijving);
        datum = findViewById(R.id.tv_datum);

        reminderSaved = (Reminder) getIntent().getSerializableExtra("reminder");

        titel.setText(reminderSaved.getTitel());
        omschrijving.setText(reminderSaved.getOmschrijving());
        datum.setText(reminderSaved.getDatum().getTime().toString());

    }
}


