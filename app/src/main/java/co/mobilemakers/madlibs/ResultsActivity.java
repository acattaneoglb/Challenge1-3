package co.mobilemakers.madlibs;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ResultsActivity extends ActionBarActivity {

    final static public String RESULTS_ARRAY = "resultsArray";

    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String[] stringList = getIntent().getStringArrayExtra(RESULTS_ARRAY);

        controlsToVars();

        fillResultText(stringList);

    }

    private void fillResultText(String[] stringList) {
        String stringResult = "";
        stringResult += getResources().getString(R.string.example_part_0);
        stringResult += stringList[0];
        stringResult += getResources().getString(R.string.example_part_1);
        stringResult += stringList[1];
        stringResult += getResources().getString(R.string.example_part_2);
        stringResult += stringList[2];
        stringResult += getResources().getString(R.string.example_part_3);
        stringResult += stringList[3];
        stringResult += getResources().getString(R.string.example_part_4);
        stringResult += stringList[4];
        stringResult += getResources().getString(R.string.example_part_5);
        stringResult += stringList[5];
        stringResult += getResources().getString(R.string.example_part_6);
        stringResult += stringList[6];
        stringResult += getResources().getString(R.string.example_part_7);
        stringResult += stringList[7];
        stringResult += getResources().getString(R.string.example_part_8);
        stringResult += stringList[8];
        stringResult += getResources().getString(R.string.example_part_9);
        stringResult += stringList[9];
        stringResult += getResources().getString(R.string.example_part_10);

        textResult.setText(stringResult);
    }

    private void controlsToVars() {
        textResult = (TextView)findViewById(R.id.text_view_example);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_results, menu);
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
