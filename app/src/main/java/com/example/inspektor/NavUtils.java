package com.example.inspektor;

import android.app.Activity;
import android.content.Intent;

import com.example.inspektor.activity.VehicleDashboardActivity;

public class NavUtils {

    public static void redirectToDashboard(Activity activity) {
        Intent intent = new Intent(activity, VehicleDashboardActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

}
