package com.ryanhodin.karensmorning;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NotificationActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		NotificationCompat.Builder a=new NotificationCompat.Builder(this);
		a.setSmallIcon(R.mipmap.ic_launcher);
		a.setContentTitle("Good Morning");
		a.setContentText("It is now morning.");
		a.setAutoCancel(true);
		Intent result=new Intent(this, MainActivity.class);
		a.setContentIntent(PendingIntent.getActivity(this, 0, result, 0));
		((NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE)).notify(0, a.build());
	}
}
