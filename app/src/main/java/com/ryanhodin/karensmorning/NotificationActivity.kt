package com.ryanhodin.karensmorning

import android.app.AlarmManager
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class NotificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val a = NotificationCompat.Builder(this)
        a.setSmallIcon(R.mipmap.ic_launcher)
        a.setContentTitle("Good Morning")
        a.setContentText("It is now morning.")
        a.setAutoCancel(true)
        val result = Intent(this, MainActivity::class.java)
        a.setContentIntent(PendingIntent.getActivity(this, 0, result, 0))
        (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).notify(0, a.build())
        finish()
    }
}
