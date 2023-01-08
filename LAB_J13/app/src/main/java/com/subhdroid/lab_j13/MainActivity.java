package com.subhdroid.lab_j13;

//13. Demonstrate Options Menu, Context Menu and Popup Menu in android

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.PopupMenu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton popupMenuBtn = findViewById(R.id.popupMenuBtn);
        TextView contextMenuTxt = findViewById(R.id.contextMenuTxt);
        ll = findViewById(R.id.ll);
        registerForContextMenu(contextMenuTxt);


        popupMenuBtn.setOnClickListener(view -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, popupMenuBtn);
            popupMenu.getMenuInflater().inflate(R.menu.menus_items, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(item -> {
                Toast.makeText(MainActivity.this, item.getTitle() + " clicked",
                        Toast.LENGTH_SHORT).show();
                return true;
            });

            popupMenu.show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.close) {
            Toast.makeText(this, "Close clicked", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.save) {
            Toast.makeText(this, "Save clicked", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.open) {
            Toast.makeText(this, "Open clicked", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Set Background color");
        menu.add(0, v.getId(), 0, "Grey");
        menu.add(0, v.getId(), 0, "Yellow");
        menu.add(0, v.getId(), 0, "Red");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getTitle().equals("Grey")) {
            ll.setBackgroundColor(Color.GRAY);
        }
        if (item.getTitle().equals("Yellow")) {
            ll.setBackgroundColor(Color.YELLOW);
        }
        if (item.getTitle().equals("Red")) {
            ll.setBackgroundColor(Color.RED);
        }
        return true;
    }
}