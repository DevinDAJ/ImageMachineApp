package com.daj.imagemachine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.daj.imagemachine.code_reader_fragment.CodeReaderFragment;
import com.daj.imagemachine.machine_data_fragment.MachineDataFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navView;
    private TextView welcomeText;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemReselectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.nav_machine_data:
                    initMachineDataFragment();
                    return true;
                case R.id.nav_code_reader:
                    initCodeReaderFragment();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        if(savedInstanceState == null) {
            initMachineDataFragment();
        }
    }

    private void initMachineDataFragment() {
        welcomeText.setVisibility(View.GONE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment machineDataFragment = new MachineDataFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(MachineDataFragment.class.getSimpleName());
        if(!(fragment instanceof MachineDataFragment)) {
            fragmentTransaction.replace(R.id.container, machineDataFragment, MachineDataFragment.class.getSimpleName());
            fragmentTransaction.commit();
        }
    }

    private void initCodeReaderFragment() {
        welcomeText.setVisibility(View.GONE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment codeReaderFragment = new CodeReaderFragment();
        Fragment fragment = fragmentManager.findFragmentByTag(CodeReaderFragment.class.getSimpleName());
        if(!(fragment instanceof CodeReaderFragment)) {
            fragmentTransaction.replace(R.id.container, codeReaderFragment, CodeReaderFragment.class.getSimpleName());
            fragmentTransaction.commit();
        }
    }

    private void initViews() {
        navView = findViewById(R.id.nav_view);
        welcomeText = findViewById(R.id.text_welcome);
    }

    private void initListeners() {
        navView.setOnNavigationItemSelectedListener(onNavigationItemReselectedListener);
    }
}
