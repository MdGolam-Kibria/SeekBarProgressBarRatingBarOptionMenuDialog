package com.example.seekbarprogressbarratingbaroptionmenudialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private ProgressBar progressBar;
    private int progressBarValue;
    private RatingBar ratingBar;
    private TextView textView;
    private Button popup, dialog, customDialog;
    private DrawerLayout drawerLayout;
    private  ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        textView = (TextView) findViewById(R.id.sohowRatingValue);
        popup = (Button) findViewById(R.id.popupmenu);
        dialog = (Button) findViewById(R.id.dialog);
        customDialog = (Button) findViewById(R.id.customDialog);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Toast.makeText(MainActivity.this, "onProgressChanged", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "onStartTrackingTouch", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "onStopTrackingTouch", Toast.LENGTH_LONG).show();
            }
        });


        //progressBar Part


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                work();
            }
        });
        thread.start();
    }

    @SuppressLint("ResourceAsColor")
    private void work() {
        for (progressBarValue = 10; progressBarValue <= 100; progressBarValue += 10) {
            try {
                Thread.sleep(500);
                progressBar.setProgress(progressBarValue);
                progressBar.setBackgroundColor(R.color.colorAccent);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        //ratingBar step


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                textView.setText("value = " + v);
            }
        });


        //popUp Menu part


        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, popup);
                popupMenu.getMenuInflater().inflate(R.menu.meni_item, popupMenu.getMenu());
                popupMenu.show();
            }
        });


        //dialog part


        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("wow its show").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "nice", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "nice working Toast", Toast.LENGTH_SHORT).show();
                    }
                }).setIcon(R.drawable.ic_launcher_background);
                final AlertDialog alertDialog = builder.create();
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();
            }
        });





//        customDialogPart




        customDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view1  = getLayoutInflater().inflate(R.layout.customdiolog,null);
                Button ok = view1.findViewById(R.id.ok);
                Button cancel = view1.findViewById(R.id.cancel);
                builder.setView(view1);
                final AlertDialog alertDialog = builder.create();
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.show();
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "ok you agree with me", Toast.LENGTH_SHORT).show();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
            }
        });


        //navigationDrawer part

//        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.string.open,R.string.close);
//        drawerLayout.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}}
