package com.anisdroid.Material_Design;

import android.app.*;
import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.content.*;
import android.support.v4.widget.*;
import android.support.design.widget.*;

public class MainActivity extends ActionBarActivity 
{
	private Toolbar ttt;
	DrawerLayout dl;
	ActionBarDrawerToggle abdt;
	FragmentTransaction ft;
	NavigationView nv;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		ttt = (Toolbar) findViewById(R.id.app_bar);
		setSupportActionBar(ttt);
		
		dl = (DrawerLayout) findViewById(R.id.drawer_layout);
		
		abdt = new ActionBarDrawerToggle(this,dl,ttt,R.string.drawer_open,R.string.drawer_close);
		
		dl.setDrawerListener(abdt);
		
		//This code will load the home fragment when
		//the application loaded the first time..
		
		ft = getFragmentManager().beginTransaction();
		ft.add(R.id.frame_container,new HomeFragment());
		ft.commit();
		
		// This code will change the toolbar title...
		
		getSupportActionBar().setTitle("Home");
		
		//Now, to set the click event for navigation
		// drawers menu add the below code.....
		
		nv = (NavigationView) findViewById(R.id.nav_view);
		nv.setNavigationItemSelectedListener(
		
			new NavigationView.OnNavigationItemSelectedListener(){

				@Override
				public boolean onNavigationItemSelected(MenuItem p1)
				{
					
					switch(p1.getItemId()){
						case R.id.home:
							ft = getFragmentManager().beginTransaction();
							ft.replace(R.id.frame_container,new HomeFragment());
							ft.commit();
							getSupportActionBar().setTitle("Home");
							p1.setChecked(true);
							dl.closeDrawers();
							break;
							
						case R.id.account:
							ft = getFragmentManager().beginTransaction();
							ft.replace(R.id.frame_container,new AccountFragment());
							ft.commit();
							getSupportActionBar().setTitle("Account");
							p1.setChecked(true);
							dl.closeDrawers();
							break;
							
						case R.id.setting:
							ft = getFragmentManager().beginTransaction();
							ft.replace(R.id.frame_container,new SettingFragment());
							ft.commit();
							getSupportActionBar().setTitle("Setting");
							p1.setChecked(true);
							dl.closeDrawers();
							break;
							
					}
					
					// TODO: Implement this method
					return false;
				}
				
				
			}
		
		);
    }

	@Override
	protected void onPostCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onPostCreate(savedInstanceState);
		abdt.syncState();
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
		if(ccc.getItemId() == R.id.about){
			startActivity(new Intent(this,About.class));
		}
		
		// TODO: Implement this method
		return true;
	}
	
	
	
}
