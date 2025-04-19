package com.example.listviewcrud;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText inputField, searchField;
    Button insertButton, deleteButton;
    ListView listView;
    ArrayList<String> itemList;
    ArrayAdapter<String> adapter;
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.inputField);
        searchField = findViewById(R.id.searchField);
        insertButton = findViewById(R.id.insertButton);
        deleteButton = findViewById(R.id.deleteButton);
        listView = findViewById(R.id.listView);

        itemList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listView.setAdapter(adapter);

        // Insert item
        insertButton.setOnClickListener(v -> {
            String text = inputField.getText().toString().trim();
            if (!text.isEmpty()) {
                itemList.add(text);
                adapter.notifyDataSetChanged();
                inputField.setText("");
            } else {
                Toast.makeText(this, "Enter something to add", Toast.LENGTH_SHORT).show();
            }
        });

        // Select item from list
        listView.setOnItemClickListener((parent, view, position, id) -> {
            selectedIndex = position;
            Toast.makeText(this, "Selected: " + itemList.get(position), Toast.LENGTH_SHORT).show();
        });

        // Delete selected item
        deleteButton.setOnClickListener(v -> {
            if (selectedIndex != -1) {
                String removedItem = adapter.getItem(selectedIndex);
                itemList.remove(removedItem);  // Remove by value instead of index
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
                listView.setAdapter(adapter); // Re-attach adapter to reset filtering
                searchField.setText("");      // Clear search field to reset filter
                selectedIndex = -1;
                Toast.makeText(this, "Item Deleted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Select an item to delete", Toast.LENGTH_SHORT).show();
            }
        });

        // Search/filter functionality
        searchField.addTextChangedListener(new android.text.TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }
            public void afterTextChanged(android.text.Editable s) { }
        });
    }
}
