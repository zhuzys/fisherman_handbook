package com.example.fish;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ListView list;
    private String[] array , arraySecName;
    private CustomArrayAdapter adapter;
    private int category_index;
    private Toolbar toolbar;
    private List<ListItemClass> listItemMain;
    private ListItemClass listItem;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = (ListView)findViewById(R.id.listView);
        listItemMain = new ArrayList<>();
      //  array = getResources().getStringArray(R.array.fish_array);
      //  adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array)));
        fillArray(R.string.fish, getResources().getStringArray(R.array.fish_array),
                getResources().getStringArray(R.array.fish_array_2), 0);
        adapter = new CustomArrayAdapter(this, R.layout.list_view_item_1, listItemMain, getLayoutInflater());
        list.setAdapter(adapter);





        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("category", category_index);
                intent.putExtra("position", position);

                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.fish);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.fish:
         /*      array = getResources().getStringArray(R.array.fish_array);
                adapter.clear();
                adapter.addAll(array);
                adapter.notifyDataSetChanged();
                category_index =0;
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);*/

               // fillArray(R.string.fish,getResources().getStringArray(R.array.fish_array), getResources().getStringArray(R.array.fish_array_2),0);

                Toast.makeText(this, "Рыба", Toast.LENGTH_SHORT).show();
                break;
            case R.id.na:
               /* array = getResources().getStringArray(R.array.na_array);
                adapter.clear();
                adapter.addAll(array);
                adapter.notifyDataSetChanged();
                category_index =1;
                Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent1);*/
                fillArray(R.string.fish,getResources().getStringArray(R.array.na_array),
                        getResources().getStringArray(R.array.na_array),0);
                Toast.makeText(this, "Рыба", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sna:
               /* array = getResources().getStringArray(R.array.sn_array);
                adapter.clear();
                adapter.addAll(array);
                adapter.notifyDataSetChanged();
                category_index =2;
                Intent intent2 = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent2);*/
                fillArray(R.string.fish,getResources().getStringArray(R.array.sn_array),
                        getResources().getStringArray(R.array.sn_array),0);
                Toast.makeText(this, "Рыба", Toast.LENGTH_SHORT).show();
                break;
            case R.id.story:
               /* array = getResources().getStringArray(R.array.fish_story);
                adapter.clear();
                adapter.addAll(array);
                adapter.notifyDataSetChanged();
                category_index =3;
                Intent intent3 = new Intent(MainActivity.this, MainActivity2.class);*/
                fillArray(R.string.fish,getResources().getStringArray(R.array.fish_story), getResources().getStringArray(R.array.fish_story),0);

                break;
            case R.id.advice:
                /*array = getResources().getStringArray(R.array.useful_advices);
                adapter.clear();
                adapter.addAll(array);
                adapter.notifyDataSetChanged();
                category_index =4;
                Intent intent4 = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent4);*/
                fillArray(R.string.fish,getResources().getStringArray(R.array.useful_advices), getResources().getStringArray(R.array.useful_advices),0);
                break;
            default:
                break;
        }
       DrawerLayout drawer = findViewById(R.id.drawer_layout);
       drawer.closeDrawer(GravityCompat.START);
        return true;

    }
    private void fillArray(int title, String[] nameArray, String[] secName, int index) {
        toolbar.setTitle(title);
        if(adapter != null) adapter.clear();
        for (int i=0; i<nameArray.length; i++) {
            listItem = new ListItemClass();
            listItem.setName(nameArray[i]);
            listItem.setSecond_name(secName[i]);
            listItemMain.add(listItem);
        }
        if(adapter != null) adapter.notifyDataSetChanged();
        category_index = index;
    }
}