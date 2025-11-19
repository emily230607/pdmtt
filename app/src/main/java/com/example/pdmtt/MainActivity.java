package com.example.pdmtt;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    PackageManager packageManager;
    List<ApplicationInfo> appList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview_apps);
        packageManager = getPackageManager();


        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        appList = packageManager.queryIntentActivities(intent, 0)
                .stream()
                .map(resolveInfo -> resolveInfo.activityInfo.applicationInfo)
                .toList();

        // Define o adaptador personalizado
        AppAdapter appAdapter = new AppAdapter(
                this,
                R.layout.item_lista,
                appList
        );

        listView.setAdapter(appAdapter);


        listView.setOnItemClickListener((parent, view, position, id) -> {
            ApplicationInfo appInfo = appList.get(position);
            String packageName = appInfo.packageName;

            Intent launchIntent = packageManager.getLaunchIntentForPackage(packageName);

            if (launchIntent != null) {
                startActivity(launchIntent);
            } else {
                Toast.makeText(MainActivity.this,
                        "Não foi possível abrir o aplicativo",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
