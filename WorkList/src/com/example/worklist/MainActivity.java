package com.example.worklist;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.*;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity implements OnItemLongClickListener{

	Button btnAdd;
	ListView lv;
	List<ListViewItem> items;
	CustomListViewAdapter adapter;
	OnClickListener oclBut;
	EditText edtTxt;
	
	
	
    @Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		// TODO Auto-generated method stub
    	ListViewItem item = items.get(position);
    	items.remove(item);
    	adapter.notifyDataSetChanged();
		return false;
	}






	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lv = (ListView) findViewById(R.id.listView);
        items = new ArrayList<MainActivity.ListViewItem>();
        edtTxt = (EditText)findViewById(R.id.txtItem1);
        
        adapter = new CustomListViewAdapter(this, items);
        
        lv.setAdapter(adapter);
        
        btnAdd = (Button) findViewById(R.id.button1);
        
        oclBut = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				items.add(new ListViewItem(){
             	{
             		ThumbnailResource = R.drawable.ic_launcher;
             		Title = edtTxt.getText().toString();
             		SubTitle = "Задача";
             	}
             });
        	 adapter.notifyDataSetChanged();
			}
		};
		btnAdd.setOnClickListener(oclBut);
        
        lv.setOnItemLongClickListener(this);
        
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    class ListViewItem
    {
    	public int ThumbnailResource;
    	public String Title;
    	public String SubTitle;
    }
}
