package course.android.android_lesson5;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class MainActivity extends AppCompatActivity {
    private String[] gsm_arena_urls_from_strings_xml;
    private String[] phones_from_strings_xml;
    private ListView lv;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.languages);
        initResources();
        initLanguagesListView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                openPhoneDisplayActivity(pos);
            }
        });
    }

    private void openPhoneDisplayActivity(int pos) {

        String url = gsm_arena_urls_from_strings_xml[pos];
        Intent intent = new Intent(this, PhoneDisplayActivity.class);

        intent.putExtra("urlToPhoneDescription", url);
        startActivity(intent);
    }

    private void initResources() {
        Resources res = getResources();
        phones_from_strings_xml = res.getStringArray(R.array.phones);
        gsm_arena_urls_from_strings_xml = res.getStringArray(R.array.gsmarena_urls);
    }

    private void initLanguagesListView() {
        lv.setAdapter(new ArrayAdapter<>(getBaseContext(),
                android.R.layout.simple_list_item_1, phones_from_strings_xml));
    }
}