package co.mobilemakers.madlibs;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    EditText[] mEdits;
    Button mButtonShowMe;

    protected class TextListener implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            boolean oneEmpty = false;
            int pos = 0;

            while (!oneEmpty && pos < 10) {
                oneEmpty = mEdits[pos].getText().toString().isEmpty();
                pos++;
            }
            mButtonShowMe.setEnabled(!oneEmpty);
        }
    }

    protected class ShowMeListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent resultsIntent = new Intent(MainActivity.this, ResultsActivity.class);
            String[] resultStrings = new String[10];
            for (int counter = 0; counter < 10; counter++) {
                resultStrings[counter] = mEdits[counter].getText().toString();
            }
            resultsIntent.putExtra(ResultsActivity.RESULTS_ARRAY, resultStrings);
            startActivity(resultsIntent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controlsToVars();

        setListeners();

    }

    private void setListeners() {
        for (int counter = 0; counter < 10; counter++) {
            mEdits[counter].addTextChangedListener(new TextListener());
        }

        mButtonShowMe.setOnClickListener(new ShowMeListener());
    }

    private void controlsToVars() {
        mEdits = new EditText[10];
        mEdits[0] = (EditText)findViewById(R.id.edit_text_1);
        mEdits[1] = (EditText)findViewById(R.id.edit_text_2);
        mEdits[2] = (EditText)findViewById(R.id.edit_text_3);
        mEdits[3] = (EditText)findViewById(R.id.edit_text_4);
        mEdits[4] = (EditText)findViewById(R.id.edit_text_5);
        mEdits[5] = (EditText)findViewById(R.id.edit_text_6);
        mEdits[6] = (EditText)findViewById(R.id.edit_text_7);
        mEdits[7] = (EditText)findViewById(R.id.edit_text_8);
        mEdits[8] = (EditText)findViewById(R.id.edit_text_9);
        mEdits[9] = (EditText)findViewById(R.id.edit_text_10);

        mButtonShowMe = (Button)findViewById(R.id.button_show_me);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
