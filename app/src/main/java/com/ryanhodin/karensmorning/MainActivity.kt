package com.ryanhodin.karensmorning

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.AlarmManagerCompat
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, NotificationActivity::class.java)
        val alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0)

        am.cancel(alarmIntent);

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.set(Calendar.HOUR_OF_DAY, 10)
        calendar.set(Calendar.MINUTE, 30)

        am.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
                (1000 * 60 * 60 * 24).toLong(), alarmIntent)
    }
}
