package com.example.jlgarcia.mapsgt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        String serial = null;

        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            Method get = c.getMethod("get", String.class);
            serial = (String) get.invoke(c, "ro.serialno");
        } catch (Exception ignored) {
        }

        Toast.makeText(this, "S/N: "+serial, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "imei: "+obtenerImei(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            //Toast.makeText(getApplicationContext(), "Hola mundo!!!", Toast.LENGTH_SHORT).show();
            //String uri = "waze://?ll=40.761043, -73.980545&navigate=yes";
            //String uri = "waze://?ll=40.761043, -73.980545&z=10";
//            startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));
//            startActivity( intent );


//            LatLng location= new LatLng(34,118); // just for example
//
//            String urlWaze = "https://waze.com/ul?ll="+location.latitude+","+location.longitude;
//            Intent intentWaze = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWaze));
//            intentWaze.setPackage("com.waze");
//
//            String uriGoogle = "google.navigation:q=" + location.latitude + "," + location.longitude;
//            Intent intentGoogleNav = new Intent(Intent.ACTION_VIEW, Uri.parse(uriGoogle));
//            intentGoogleNav.setPackage("com.google.android.apps.maps");


//            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                    Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
//            startActivity(intent);
//            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                    Uri.parse("geo:0,0?q=37.423156,-122.084917 "));
//            startActivity(intent);

            double sourceLatitude = 14.6244978; double sourceLongitude = -90.5662548;
            double destinationLatitude = 14.6214466; double destinationLongitude = -90.5442971;
            String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?saddr=%f,%f(%s)&daddr=%f,%f (%s)", sourceLatitude, sourceLongitude, "Home Sweet Home", destinationLatitude, destinationLongitude, "Where the party is at");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);

        } else if (id == R.id.nav_gallery) {
//            double latitude=14.6244978;
//            double longitude = -90.5662548;
//            final String url = String.format("waze://?ll=%f,%f&navigate=yes", latitude, longitude);
//            final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//            startActivity(intent);

            //String uri = "waze://?ll=14.6244978, -90.5662548&navigate=yes";
            //String uri = "waze://?ll=14.6244978, -90.5662548&z=10";
            //startActivity(new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri)));

            double latitude=14.6244978;
            double longitude = -90.5662548;
            //LatLng location= new LatLng(34,118); // just for example https://waze.com/ul?ll=14.6244978, -90.5662548

            String urlWaze = "https://waze.com/ul?ll=14.6244978,-90.5662548&navigate=yes"; //+latitude+","+longitude;
//            Intent intentWaze = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWaze));
//            intentWaze.setPackage("com.waze");

            //String uri = "geo: latitude,longtitude";
            startActivity(new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse(urlWaze)));


//            String uriGoogle = "google.navigation:q=" + latitude + "," + longitude;
//            Intent intentGoogleNav = new Intent(Intent.ACTION_VIEW, Uri.parse(uriGoogle));
//            intentGoogleNav.setPackage("com.google.android.apps.maps");


        } else if (id == R.id.nav_slideshow) {
            Intent c = new Intent(MainActivity.this, Escuelas.class);
            startActivity(c);
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private String obtenerImei() {
        //StringBuilder builder = new StringBuilder();
        //.append()
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        String imei =tm.getDeviceId(); // Obtiene el imei  or  "352319065579474";
        return imei;
        //TelephonyManager mngr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        //mngr.getDeviceId();
    }

    private void rutas() {
//        LatLng location= new LatLng(34,118); // just for example
//
//        String urlWaze = "https://waze.com/ul?ll="+location.latitude+","+location.longitude;
//        Intent intentWaze = new Intent(Intent.ACTION_VIEW, Uri.parse(urlWaze));
//        intentWaze.setPackage("com.waze");
//
//        String uriGoogle = "google.navigation:q=" + location.latitude + "," + location.longitude;
//        Intent intentGoogleNav = new Intent(Intent.ACTION_VIEW, Uri.parse(uriGoogle));
//        intentGoogleNav.setPackage("com.google.android.apps.maps");

    }

}
