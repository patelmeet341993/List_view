package friendlyitsolution.com.list_view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<String> mydata;
    EditText ettxt;
    Button btnadd;
    TextView tv;
    FloatingActionButton fab;
    ListView lv;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        ettxt = findViewById(R.id.ettxt);
        btnadd = findViewById(R.id.btnadd);
        tv = findViewById(R.id.tv);
        fab = findViewById(R.id.fab);


        mydata = new ArrayList<>();
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, mydata);
        lv.setAdapter(adapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!ettxt.getText().toString().trim().isEmpty()) {
                    addData();
                } else {
                    ettxt.setError("Please enter any string..");
                }

            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String d = mydata.get(i);
                tv.setText(d);
                fab.setVisibility(View.VISIBLE);

            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeData();
            }
        });


    }

    void addData() {
        String d = ettxt.getText().toString();
        mydata.add(d);
        adapter.notifyDataSetChanged();
        ettxt.setText("");
    }

    @SuppressLint("RestrictedApi")
    void removeData() {
        String d = tv.getText().toString();
        mydata.remove(d);
        adapter.notifyDataSetChanged();
        tv.setText("");
        fab.setVisibility(View.INVISIBLE);

    }


}
