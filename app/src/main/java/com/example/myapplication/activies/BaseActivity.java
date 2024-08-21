package com.example.myapplication.activies;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.utilities.Constants;
import com.example.myapplication.utilities.PreferenceManager;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.Console;

public class BaseActivity extends AppCompatActivity {

    private DocumentReference documentReference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager preferenceManager = new PreferenceManager(getApplicationContext());
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        documentReference = database.collection(Constants.KEY_COLLECTION_USER)
                .document(preferenceManager.getString(Constants.KEY_USER_ID));
    }

    @Override
    protected void onPause() {
        super.onPause();
        documentReference.update(Constants.KEY_AVAILABILITY,0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        documentReference.update(Constants.KEY_AVAILABILITY,1);
    }
}
