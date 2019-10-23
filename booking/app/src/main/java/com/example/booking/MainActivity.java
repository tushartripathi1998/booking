package com.example.booking;

import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

//import com.example.booking.helpers.FetchUrl;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {
    GoogleMap map;
    Button btnGetDirection;
    MarkerOptions place1, place2;
    Polyline currentPolyline;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        mToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try{SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFrag);
        mapFragment.getMapAsync(this);}catch (Exception e){
//            Log.e("test - ",e); }
        Toast.makeText(this,"eghhhhhhhhhhhhh",Toast.LENGTH_SHORT).show();}
//        place1 = new MarkerOptions().position(new LatLng(27.658143,85.3199503));
//        place2 = new MarkerOptions().position(new LatLng(27.667491, 85.3208583));

//        String url = getUrl(place1.getPosition(), place2.getPosition(),"driving");

//        (MainActivity.this).execute(url,"driving");

    }

    public String getUrl(LatLng origin, LatLng dest, String mode)
    {
        String str_orig = "origin="+origin.latitude+","+origin.longitude;
        String str_dest = "destination="+dest.latitude+","+dest.longitude;
        String drivingMode = "mode="+mode;

        String params = str_orig+str_dest+drivingMode;

        String output = "json";

        String url = "https://maps.googleapis.com/maps/api/directions"+output+"?"+params+"&key="+getString(R.string.api_key);

        return url;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,item.getItemId(),Toast.LENGTH_SHORT).show();
        if (mToggle.onOptionsItemSelected(item)){
//            Toast.makeText(this,item.getItemId(),Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.db:
                Toast.makeText(this,"the id is"+menuItem.getItemId(),Toast.LENGTH_SHORT).show();
//                getSupportFragmentManager().beginTransaction().replace(R.id.map_activity,new )
                break;
//                drawerLayout.closeDrawer();
        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
    }
}
