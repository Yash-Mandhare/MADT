package com.example.phonegap;

import android.Manifest;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    TextView output;
    String contactToClone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.editName);
        output = findViewById(R.id.outputText);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.WRITE_CONTACTS
        }, 1);

        findViewById(R.id.btnCreate).setOnClickListener(v -> createContact(editName.getText().toString()));
        findViewById(R.id.btnSearch).setOnClickListener(v -> searchContact(editName.getText().toString()));
        findViewById(R.id.btnClone).setOnClickListener(v -> cloneContact(editName.getText().toString()));
        findViewById(R.id.btnDelete).setOnClickListener(v -> deleteContact(editName.getText().toString()));
    }

    void createContact(String name) {
        if (name.isEmpty()) {
            Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show();
            return;
        }

        ArrayList<ContentProviderOperation> ops = new ArrayList<>();
        ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null).build());

        ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                .withValueBackReference(
                        ContactsContract.Data.RAW_CONTACT_ID, 0)
                .withValue(
                        ContactsContract.Data.MIMETYPE,
                        ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                .withValue(
                        ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,
                        name).build());

        try {
            getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
            output.setText("Contact Created: " + name);
        } catch (Exception e) {
            e.printStackTrace();
            output.setText("Failed to create contact");
        }
    }

    void searchContact(String name) {
        if (name.isEmpty()) {
            Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show();
            return;
        }

        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI, null,
                "DISPLAY_NAME = ?", new String[]{name}, null);

        if (cur != null && cur.moveToFirst()) {
            String contactId = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
            contactToClone = name;
            output.setText("Contact found: " + name + " (ID: " + contactId + ")");
            cur.close();
        } else {
            output.setText("Contact not found");
        }
    }

    void cloneContact(String name) {
        if (contactToClone == null) {
            output.setText("Search a contact to clone first.");
            return;
        }

        String clonedName = contactToClone + " (Clone)";
        createContact(clonedName);
    }

    void deleteContact(String name) {
        if (name.isEmpty()) {
            Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show();
            return;
        }

        Uri contactUri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(name));
        Cursor cur = getContentResolver().query(contactUri, null, null, null, null);

        if (cur != null && cur.moveToFirst()) {
            String lookupKey = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.LOOKUP_KEY));
            Uri uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, lookupKey);
            getContentResolver().delete(uri, null, null);
            output.setText("Deleted: " + name);
            cur.close();
        } else {
            output.setText("Contact not found.");
        }
    }
}
