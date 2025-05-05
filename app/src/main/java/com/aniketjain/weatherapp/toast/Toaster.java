package com.aniketjain.weatherapp.toast;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aniketjain.weatherapp.R;

public class Toaster {

    public static void showToast(Context context, String msg, int iconResId) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.toast_layout, null); // You must create this layout

        ImageView icon = layout.findViewById(R.id.toast_icon);
        TextView text = layout.findViewById(R.id.toast_text);

        icon.setImageResource(iconResId);
        text.setText(msg);

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.setGravity(Gravity.BOTTOM | Gravity.FILL_HORIZONTAL, 0, 100);
        toast.show();
    }

    public static void successToast(Context context, String msg) {
        showToast(context, msg, R.drawable.ic_baseline_check_24);
    }

    public static void errorToast(Context context, String msg) {
        showToast(context, msg, R.drawable.ic_baseline_error_outline_24);
    }
}
