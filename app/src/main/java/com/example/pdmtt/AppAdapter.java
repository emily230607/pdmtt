package com.example.pdmtt;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter extends ArrayAdapter<ApplicationInfo> {

    public AppAdapter(@NonNull Context context, int resource, @NonNull List<ApplicationInfo> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.item_lista, parent, false);

        ApplicationInfo appInfo = getItem(position);

        ImageView icon = view.findViewById(R.id.app_icon);
        TextView name = view.findViewById(R.id.app_name);

        icon.setImageDrawable(appInfo.loadIcon(getContext().getPackageManager()));
        name.setText(appInfo.loadLabel(getContext().getPackageManager()));

        return view;
    }
}
