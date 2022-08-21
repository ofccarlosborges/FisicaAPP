package com.example.fisicaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class inicial2 extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd;
    private ArrayList arrTemp = new ArrayList();
    private ArrayList array = new ArrayList();
    MyListAdapter myListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        array.add("teste");

        arrTemp.add(array);

        myListAdapter = new MyListAdapter();
        ListView listView = (ListView) findViewById(R.id.listViewMain);
        listView.setAdapter(myListAdapter);

    }


    public void onClick(View view) {
        array.add("teste");
        myListAdapter.notifyDataSetChanged();
    }

    private class MyListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            if (array != null && array.size() != 0) {
                return array.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return array.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            if (convertView == null) {

                holder = new ViewHolder();
                LayoutInflater inflater = inicial2.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.item_edittext, null);

                holder.editText1 = (EditText) convertView.findViewById(R.id.ItemCaption);

                convertView.setTag(holder);

            } else {

                holder = (ViewHolder) convertView.getTag();
            }

            holder.ref = position;

            return convertView;
        }

        private class ViewHolder {
            EditText editText1;
            int ref;
        }
    }
}