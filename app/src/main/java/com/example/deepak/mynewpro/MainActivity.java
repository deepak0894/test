package com.example.deepak.mynewpro;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class SensorActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mPressure,mtemp,mhum,mlumin;
    private TextView X,Y,Z;
    private Button btnStart,btnStop;
    private SensorManager sensor;
    private Sensor accelerometer;
    private float x = 0;
    private float y = 0;
    private float z = 0;
    private double u = 0;

    @Override
    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get an instance of the sensor service, and use that to get an instance of
        // a particular sensor.
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mtemp = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mhum = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mlumin = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mSensorManager.registerListener(this,mPressure,SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this,mtemp,SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this,mhum,SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this,mlumin,SensorManager.SENSOR_DELAY_NORMAL);
        X=(TextView)findViewById(R.id.textx);
        Y=(TextView)findViewById(R.id.texty);
        Z=(TextView)findViewById(R.id.textz);
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        x = event.values[0];
        y = event.values[0];
        z = event.values[0];
        u = event.values[0];
        // Do something with this sensor data.
    }

    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
        mSensorManager.registerListener(this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}