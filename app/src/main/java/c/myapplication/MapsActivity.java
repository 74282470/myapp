package c.myapplication;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;



import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    String google_maps_key = "AIzaSyBtdDsFlvMdxofySaum765Wm0DAapvKAwQ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front);
        //BUTTON
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GETS FROM
                EditText editText = (EditText)findViewById(R.id.editText);
                String from_input = editText.getText().toString();
                //GETS IN
                EditText editText2 = (EditText)findViewById(R.id.editText2);
                String to_input = editText2.getText().toString();
                String link = "http://maps.googleapis.com/maps/api/directions/origin=";
                String from_replaced = from_input.split(' ').join('+');
                String to_replaced = to_input.split(' ').join('+');
                String requestURL = String.format(link, Uri.encode(from_replaced), "&destination=", Uri.encode(to_replaced), "&key=AIzaSyBtdDsFlvMdxofySaum765Wm0DAapvKAwQ");



            }

            }
        });

    //SWITCH
    Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            int count = 0;
            boolean on_off = false;
            public void onClick(View v) {
                count++;
                if (count%2 == 1) {
                    on_off = true;
                    System.out.println("ON");
                }
                else {
                    on_off = false;
                    System.out.println("OFF");
                }

                //SHIT WITH SWITCH HERE



            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //System.out.println("Enter starting Location: ");
        LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
