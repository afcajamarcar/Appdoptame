package com.appdoptame.appdoptame.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.appdoptame.appdoptame.Auth.Login;
import com.appdoptame.appdoptame.R;
import com.appdoptame.appdoptame.model.Notification;
import com.appdoptame.appdoptame.model.Profile;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

public class NotificationActivity extends Fragment {

    ListView listView;
    private String userName;

    public NotificationActivity() {
        // Required empty public constructor
    }


    public static NotificationActivity newInstance() {
        NotificationActivity fragment = new NotificationActivity();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.activity_notification, container, false);

        listView = (ListView) view.findViewById(R.id.list);
        userName = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();

        // Defined Array values to show in ListView
        Bundle extras = getActivity().getIntent().getExtras();
        Profile profile0 = (Profile)extras.getSerializable("profile0");
        Profile profile1 = (Profile)extras.getSerializable("profile1");

        Log.d("Notification activity",userName);
        Log.d("Notification activity",profile0.toString());
        Log.d("Notification activity",profile1.toString());

        Notification[] notifications = new Notification[2];
        notifications[0] = new Notification(userName, profile0, true, false);
        notifications[1] = new Notification(userName, profile1, true, true);


        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<Notification> adapter = new ArrayAdapter<Notification>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, notifications);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                Notification notification = (Notification) listView.getItemAtPosition(position);

                // Show Alert
                if (!notification.isAnswered())
                    Toast.makeText(getActivity().getApplicationContext(),"Esta petición aún no recibe respuesta" , Toast.LENGTH_LONG).show();

                else {
                    Intent intent = new Intent(getActivity().getApplicationContext(), ChatActivity.class);
                    intent.putExtra("Username", userName);
                    startActivity(intent);
                }
            }

        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



}
