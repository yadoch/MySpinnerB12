package tw.com.abc.myspinnerb12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTxtR;
    private Button mBtnOK;
    private EditText mEdtAge;
    private Spinner mSpnSex;
    private  String msSex;
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpnSex=(Spinner) findViewById(R.id.spnSex);
        mSpnSex.setOnItemSelectedListener(spSexOnItemSelected);

        mEdtAge = (EditText) findViewById(R.id.edtAge);
        mBtnOK = (Button) findViewById(R.id.btnOK);
        mTxtR = (TextView) findViewById(R.id.txtR);

        mBtnOK.setOnClickListener(btnOKOnClick);

    }
    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
           //String strSex = mEdtSex.getText().toString();
            int iAge = Integer.parseInt(mEdtAge.getText().toString());

            String strSug = getString(R.string.suggestion);
            if (msSex.equals(getString(R.string.sex_male)))
                if (iAge < 28) {
                    strSug += getString(R.string.sug_not_hurry);
                    Log.d("MarriSug", "man, don't hurry");
                } else if (iAge > 33) {
                    strSug += getString(R.string.sug_get_married);
                    Log.d("MarriSug", "man, hurry to get married!");
                } else {
                    strSug += getString(R.string.sug_find_couple);
                    Log.d("MarriSug", "man, start to find girlfriend!");
                }
            else
            if (iAge < 25) {
                strSug += getString(R.string.sug_not_hurry);
                Log.d("MarriSug", "woman, don't hurry!");
            } else if (iAge > 30) {
                strSug += getString(R.string.sug_get_married);
                Log.d("MarriSug", "woman, hurry to get married!");
            } else {
                strSug += getString(R.string.sug_find_couple);
                Log.d("MarriSug", "woman, start to find boyfriend!");
            }

            mTxtR.setText(strSug);
        }
    };

    private AdapterView.OnItemSelectedListener spSexOnItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            // 書上範例的adapterView 是 parent
            msSex=parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            
        }
    };
}
