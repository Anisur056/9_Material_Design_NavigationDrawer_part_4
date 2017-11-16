package com.anisdroid.Material_Design;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.os.*;
import android.view.*;
import android.content.*;

public class About extends ActionBarActivity 
{
	private Toolbar ttt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

		ttt = (Toolbar) findViewById(R.id.app_bar);
		setSupportActionBar(ttt);
		
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

	@Override
	public boolean onCreateOptionsMenu(Menu aaa)
	{
		MenuInflater bbb = getMenuInflater();
		bbb.inflate(R.menu.my_menu,aaa);

		// TODO: Implement this method
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem ccc)
	{
		if(ccc.getItemId() == android.R.id.home){
			startActivity(new Intent(this,MainActivity.class));
		}

		// TODO: Implement this method
		return true;
	}



}
