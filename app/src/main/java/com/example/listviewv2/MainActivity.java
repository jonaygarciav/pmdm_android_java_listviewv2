package com.example.listviewv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv_paises;

    private List<String[]> paises = new LinkedList<String[]>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_paises = findViewById(R.id.lv_paises);

        paises.add(new String[] { "Portugal", "Europa"});
        paises.add(new String[] { "Francia", "Europa"});
        paises.add(new String[] { "Japón", "Asia"});
        paises.add(new String[] { "Brasil", "America"});
        paises.add(new String[] { "Camerun", "África"});
        paises.add(new String[] { "Sudáfrica", "África"});
        paises.add(new String[] { "España", "Europa"});


        ArrayAdapter<String[]> adapter = new ArrayAdapter<String[]>(this, android.R.layout.simple_list_item_2, android.R.id.text1, paises) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View view = super.getView(position, convertView, parent);
                String[] entry = paises.get(position);

                TextView text1 = view.findViewById(android.R.id.text1);
                TextView text2 = view.findViewById(android.R.id.text2);

                text1.setText(entry[0]);
                text2.setText(entry[1]);

                return view;

            }

        };

        lv_paises.setAdapter(adapter);

        lv_paises.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] paisContinente = paises.get(position);
                String pais = paisContinente[0];
                String continente = paisContinente[1];

                Toast.makeText(getApplicationContext(),pais + " - " + continente, Toast.LENGTH_SHORT).show();
            }

        });
    }
}
