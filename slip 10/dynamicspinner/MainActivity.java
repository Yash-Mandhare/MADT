package com.example.dynamicspinner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTextItem;
    Button btnAdd, btnRemove;
    Spinner spinner;
    ArrayAdapter<String> adapter;
    ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextItem = findViewById(R.id.editTextItem);
        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);
        spinner = findViewById(R.id.spinner);

        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editTextItem.getText().toString().trim();
                if (!item.isEmpty() && !itemList.contains(item)) {
                    itemList.add(item);
                    adapter.notifyDataSetChanged();
                    editTextItem.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Item is empty or already in the list", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editTextItem.getText().toString().trim();
                if (itemList.contains(item)) {
                    itemList.remove(item);
                    adapter.notifyDataSetChanged();
                    editTextItem.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Item not found in the list", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
