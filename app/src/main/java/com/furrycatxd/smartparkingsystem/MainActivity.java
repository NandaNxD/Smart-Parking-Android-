package com.furrycatxd.smartparkingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;


public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db;
    TextView tv;
    Date getDateFromTimeStamp(Long timestamp){
        return new Date(timestamp);
    }

    public void showParkingSlot(View view){
        db.collection("car").document("1").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){

                }
                else{
                    tv.setText("No Internet");
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db= FirebaseFirestore.getInstance();
        tv=findViewById(R.id.slotID);
    }
}