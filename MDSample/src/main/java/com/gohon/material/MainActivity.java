package com.gohon.material;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.gohon.material.home.activity.HomeActivity;
import com.gohon.material.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public User user = new User("zhangsan", 12);
    private List<String> city = new ArrayList<>();
    private SuggestionsAdapter suggestionsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });


        Intent intent  = getIntent();

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(this,query,Toast.LENGTH_SHORT).show();
        }

        initData();
        suggestionsAdapter = new SuggestionsAdapter(this, null);
    }


    private void initData() {
        city.add("abcdefghilk");
        city.add("abcdefghil");
        city.add("abcdefghi");
        city.add("abcdefgh");
        city.add("abcdefg");
        city.add("abcdef");
        city.add("abcde");
        city.add("abcd");
        city.add("abc");
        city.add("ab");
        city.add("a");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        SearchView mSearchView = (SearchView) searchMenuItem.getActionView();
        mSearchView.setOnQueryTextListener(listener);
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        mSearchView.setSearchableInfo(searchManager.getSearchableInfo(
                new ComponentName(this, SearchableActivity.class)));
        mSearchView.setSuggestionsAdapter(suggestionsAdapter);
        mSearchView.setMaxWidth(1000);


        View searchPlate = mSearchView.findViewById(android.support.v7.appcompat.R.id.search_plate);
        EditText searchSourceText = (EditText)mSearchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);

        ImageView voiceIcon = (ImageView)mSearchView.findViewById(android.support.v7.appcompat.R.id.search_voice_btn);
        voiceIcon.setVisibility(View.GONE);

//        searchPlate.setBackgroundColor(Color.WHITE);
//        searchPlate.setMinimumWidth(10000);
//        searchSourceText.setTextColor(Color.WHITE);
//        searchSourceText.setWidth(10000);
        return true;
    }

    SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            Log.e("onQueryTextSubmit",query);
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            Log.e("onQueryTextChange",newText);
            // newText is text entered by user to SearchView
            MatrixCursor cursor = new MatrixCursor(
                    new String[]{
                            BaseColumns._ID,
                            SearchManager.SUGGEST_COLUMN_TEXT_1
                    }
            );
            for (int i = 0; i < city.size(); i++) {
                if (newText.toLowerCase().contains(city.get(i).toLowerCase()))
                    cursor.addRow(new Object[]{i, city.get(i)});
            }
            suggestionsAdapter.changeCursor(cursor);
            return false;
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            user.setName("lisi");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
