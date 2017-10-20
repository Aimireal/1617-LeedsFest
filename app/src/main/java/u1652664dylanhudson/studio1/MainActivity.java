package u1652664dylanhudson.studio1;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.ncapdevi.fragnav.FragNavController;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Button btn;

    private BottomBar mBottomBar;
    private FragNavController fragNavController;

    //indices to fragments
    private final int TAB_FIRST = FragNavController.TAB1;
    private final int TAB_SECOND = FragNavController.TAB2;
    private final int TAB_THIRD = FragNavController.TAB3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn_information);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent informationintent = new Intent(MainActivity.this,
                        InformationActivity.class);
                startActivity(informationintent);
            }
        });

        btn = (Button) findViewById(R.id.btn_performances);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent performancesintent = new Intent(MainActivity.this,
                        PerformanceActivity.class);
                startActivity(performancesintent);
            }
        });

        btn = (Button) findViewById(R.id.btn_map);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapintent = new Intent(MainActivity.this,
                        MapActivity.class);
                startActivity(mapintent);
            }
        });

        btn = (Button) findViewById(R.id.btn_tickets);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ticketsintent = new Intent(MainActivity.this,
                        PaymentActivity.class);
                startActivity(ticketsintent);
            }
        });

        btn = (Button) findViewById(R.id.btn_camping);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent campingintent = new Intent(MainActivity.this,
                        CampingActivity.class);
                startActivity(campingintent);
            }
        });

        btn = (Button) findViewById(R.id.btn_signin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinintent = new Intent(MainActivity.this,
                        LoginActivity.class);
                startActivity(signinintent);
            }
        });

        //list of fragments
        List<Fragment> fragments = new ArrayList<>(3);

        //add fragments to list
        fragments.add(FirstFragment.newInstance(0));
        fragments.add(SecondFragment.newInstance(0));
        fragments.add(ThirdFragment.newInstance(0));

        //link fragments to container
        fragNavController = new FragNavController(getSupportFragmentManager(),R.id.container,fragments);
        //End of FragNav

        //BottomBar menu
        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItems(R.menu.bottombar_menu);
        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                //switch between tabs
                switch (menuItemId) {
                    case R.id.bottomBarItemOne:
                        fragNavController.switchTab(TAB_FIRST);
                        break;
                    case R.id.bottomBarItemSecond:
                        fragNavController.switchTab(TAB_SECOND);
                        break;
                    case R.id.bottomBarItemThird:
                        fragNavController.switchTab(TAB_THIRD);
                        break;
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottomBarItemOne) {
                    fragNavController.clearStack();
                }
            }
        });

        //End of BottomBar menu

        //Navigation drawer
        new DrawerBuilder().withActivity(this).build();

        //primary items
        PrimaryDrawerItem home = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withName(R.string.drawer_item_home)
                .withIcon(R.drawable.ic_home_white_24dp);
        PrimaryDrawerItem primary_item1 = new PrimaryDrawerItem()
                .withIdentifier(2)
                .withName(R.string.drawer_item_information)
                .withIcon(R.drawable.ic_info_white_24dp);
        PrimaryDrawerItem primary_item2 = new PrimaryDrawerItem()
                .withIdentifier(3)
                .withName(R.string.drawer_item_map)
                .withIcon(R.drawable.ic_directions_white_24dp);


        //secondary items
        SecondaryDrawerItem secondary_item1 = new SecondaryDrawerItem()
                .withIdentifier(11)
                .withName(R.string.drawer_item_payment)
                .withIcon(R.drawable.ic_payment_white_24dp);
        SecondaryDrawerItem secondary_item2 = new SecondaryDrawerItem()
                .withIdentifier(12)
                .withName(R.string.drawer_item_performances)
                .withIcon(R.drawable.ic_mic_white_24dp);
        SecondaryDrawerItem secondary_item3 = new SecondaryDrawerItem()
                .withIdentifier(13)
                .withName(R.string.drawer_item_login)
                .withIcon(R.drawable.ic_account_circle_white_24dp);


        //settings, help, contact items
        SecondaryDrawerItem settings = new SecondaryDrawerItem()
                .withIdentifier(97)
                .withName(R.string.drawer_item_settings)
                .withIcon(R.drawable.ic_settings_white_24dp);
        SecondaryDrawerItem help = new SecondaryDrawerItem()
                .withIdentifier(98)
                .withName(R.string.drawer_item_help)
                .withIcon(R.drawable.ic_help_white_24dp);
        SecondaryDrawerItem contact = new SecondaryDrawerItem()
                .withIdentifier(99)
                .withName(R.string.drawer_item_contact)
                .withIcon(R.drawable.ic_contacts_white_24dp);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);

        new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .withTranslucentStatusBar(false)
                .withFullscreen(true)
                .withSavedInstance(savedInstanceState)
                .addDrawerItems(
                        home,
                        primary_item1,
                        primary_item2,
                        new SectionDrawerItem().withName("Other Information"),
                        secondary_item1,
                        secondary_item2,
                        secondary_item3,
                        new DividerDrawerItem(),
                        settings,
                        help,
                        contact

                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            Intent intent = null;
                            if (drawerItem.getIdentifier() == 1) {
                                intent = new Intent(MainActivity.this, MainActivity.class);
                            } else if (drawerItem.getIdentifier() == 2) {
                                intent = new Intent(MainActivity.this, InformationActivity.class);
                            } else if (drawerItem.getIdentifier() == 3) {
                                intent = new Intent(MainActivity.this, MapActivity.class);
                            } else if (drawerItem.getIdentifier() == 11) {
                                intent = new Intent(MainActivity.this, PaymentActivity.class);
                            } else if (drawerItem.getIdentifier() == 12) {
                                intent = new Intent(MainActivity.this, PerformanceActivity.class);
                            } else if (drawerItem.getIdentifier() == 13) {
                                intent = new Intent(MainActivity.this, LoginActivity.class);
                            } else if (drawerItem.getIdentifier() == 97) {
                                intent = new Intent(MainActivity.this, Settings.class);
                            } else if (drawerItem.getIdentifier() == 98) {
                                intent = new Intent(MainActivity.this, Help.class);
                            } else if (drawerItem.getIdentifier() == 99) {
                                intent = new Intent(MainActivity.this, Contact.class);
                            }
                            if (intent != null) {
                                MainActivity.this.startActivity(intent);
                            }
                        }

                        return false;
                    }
                })
                .build();
        //End of Navigation drawer

    }
    @Override
    public void onBackPressed() {
        if (fragNavController.getCurrentStack().size() > 1) {
            fragNavController.pop();
        } else {
            super.onBackPressed();
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }

}

