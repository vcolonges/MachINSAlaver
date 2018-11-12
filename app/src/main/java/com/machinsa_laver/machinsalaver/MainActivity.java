package com.machinsa_laver.machinsalaver;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.machinsa_laver.machinsalaver.fragments.HomeFragment;
import com.machinsa_laver.machinsalaver.fragments.ProfilFragment;
import com.machinsa_laver.machinsalaver.fragments.RechargerFragment;
import com.machinsa_laver.machinsalaver.fragments.ResidencesFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        FragmentManager fragmentManager = getSupportFragmentManager();

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction.replace(R.id.fragment_container,new HomeFragment()).commit();
                    return true;
                case R.id.navigation_recharger:
                    fragmentTransaction.replace(R.id.fragment_container,new RechargerFragment()).commit();
                    return true;
                case R.id.navigation_residences:
                    fragmentTransaction.replace(R.id.fragment_container,new ResidencesFragment()).commit();
                    return true;
                case R.id.navigation_profil:
                    fragmentTransaction.replace(R.id.fragment_container,new ProfilFragment()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
    }

}
