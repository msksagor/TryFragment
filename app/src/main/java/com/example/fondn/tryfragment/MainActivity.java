package com.example.fondn.tryfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,CommunicatorInterface{

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] names = {"One","Two"};
        listView = (ListView) findViewById(R.id.listviewID);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Fragment fragment;
        if(position==0){
            fragment = new One();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentID,fragment);
            fragmentTransaction.commit();



            Toast.makeText(this, "You Clicked : "+position, Toast.LENGTH_SHORT).show();
        }else  if(position==1){
            fragment = new Two();
            FragmentManager fragmentManager =getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentID,fragment);
            fragmentTransaction.commit();

        }

    }

    @Override
    public void respond(String data) {


        FragmentManager manager = getFragmentManager();
        Two two = (Two) manager.findFragmentById(R.id.fragmentID);
        two.changeText(data);
        /*Tangail tangail = (Tangail) manager.findFragmentById(R.id.fragment2);
        tangail.changeText(data);*/
    }
}
