package cr.indianrailways.gov.in.mmis_ver2;


import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import java.util.ArrayList;
import java.util.List;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;



public class MainActivity extends AppCompatActivity
{

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] titles;
    private ListView drawerList;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private int currentPosition = 0;
    private ShareActionProvider shareActionProvider;

    //navigation Drawer
    private class DrawerItemClickListener implements ListView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            selectItem(position);
        }
    }

    private void selectItem(int position)
    {
        currentPosition = position;
        Fragment fragment;

        switch(position)
        {

            case 1:
                fragment = new HomeFragment();
                break;
            case 2:
                fragment = new AFRES_Fragment();
                break;
            case 3:
                fragment = new PRIME_Fragment();
                break;
            case 4:
                fragment = new TrafficFragment();
                break;
            case 5:
                fragment = new ImplemenatationOfMMIS_Fragment();
                break;
            case 6:
                fragment = new FuelAccountingSystem_Fragment();
                break;
            case 7:
                fragment = new WebDesigning_Fragment();
                break;
            case 8:
                fragment = new ExtraFragment();
                break;
            default:
                fragment = new HomeFragment();
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content,fragment,"visible_fragment");
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        //Set the action bar title
        setActionBarTitle(position);
        //Close drawer
        drawerLayout.closeDrawer(drawerList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titles = getResources().getStringArray(R.array.titles);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        //navigation Drawer

        drawerList = (ListView)findViewById(R.id.drawer);
        drawerList.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_activated_1, titles));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        //Display the correct fragment.
        if (savedInstanceState != null)
        {
            currentPosition = savedInstanceState.getInt("position");
            setActionBarTitle(currentPosition);
        }
//        else
//        {
//            selectItem(1);
//        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Create the ActionBarDrawerToggle
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_drawer, R.string.close_drawer)

        {
            //Called when a drawer has settled in a completely closed state
            public void onDrawerClosed(View view)
            {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            //Called when a drawer has settled in a completely open state.
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };




        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener()
                {
                    public void onBackStackChanged()
                    {
                        FragmentManager fragMan = getSupportFragmentManager();
                        Fragment fragment = fragMan.findFragmentByTag("visible_fragment");
                        if (fragment instanceof HomeFragment)
                        {
                            currentPosition = 1;
                        }
                        if (fragment instanceof AFRES_Fragment)
                        {
                            currentPosition = 2;
                        }
                        if (fragment instanceof PRIME_Fragment)
                        {
                            currentPosition = 3;
                        }
                        if (fragment instanceof TrafficFragment)
                        {
                            currentPosition = 4;
                        }
                        if (fragment instanceof ImplemenatationOfMMIS_Fragment)
                        {
                            currentPosition = 5;
                        }
                        if (fragment instanceof FuelAccountingSystem_Fragment)
                        {
                            currentPosition = 6;
                        }
                        if (fragment instanceof WebDesigning_Fragment)
                        {
                            currentPosition = 7;
                        }
                        if (fragment instanceof ExtraFragment)
                        {
                            currentPosition = 8;
                        }

                        setActionBarTitle(currentPosition);
                        drawerList.setItemChecked(currentPosition, true);
                    }
                }
        );
    }


    private void setActionBarTitle(int position)
    {
        String title;

        if (position == 0)
        {
            title = getResources().getString(R.string.app_name);
        }
        else
        {
            title = titles[position];
        }
        if (getSupportActionBar()!=null)
        {
            getSupportActionBar().setTitle(title);
        }
    }



    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        outState.putInt("position", currentPosition);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
         //Code to handle the rest of the action items
        switch (item.getItemId())
        {
            case R.id.action_settings:
           //Code to run when the settings item is clicked
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
     // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        MenuItem menuItem = menu.findItem(R.id.action_share);
//        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
//        setIntent("This is example text");
        return super.onCreateOptionsMenu(menu);
    }

    private void setIntent(String text)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    //Called whenever we call invalidateOptionsMenu()
    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
    // If the drawer is open, hide action items related to the content view
        boolean drawerOpen = drawerLayout.isDrawerOpen(drawerList);
        menu.findItem(R.id.action_share).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }







    // Tabs start from Here.
    private void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new AboutUsFragment(), "About Us");
        adapter.addFrag(new TenderAndSupplierFragment(), "Tender & Supplier Info");
        adapter.addFrag(new NewsAndRecruitmentFragment(), "News & Recruitment");
        adapter.addFrag(new PublicInformationFragment(), "Public Information");
        adapter.addFrag(new PassengerInformationFragment(), "Passenger Information");
        adapter.addFrag(new ContactUsFragment(), "Contact Us");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager)

        {
            super(manager);
        }

        @Override
        public Fragment getItem(int position)
        {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return mFragmentTitleList.get(position);
        }
    }

}
