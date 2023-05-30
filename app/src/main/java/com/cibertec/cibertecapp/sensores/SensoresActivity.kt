package com.cibertec.cibertecapp.sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cibertec.cibertecapp.R

class SensoresActivity: AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var sensorLuz: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensores)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorLuz = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        sensorLuz?.also {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }

        obtenerTodosSensores()
    }

    fun obtenerTodosSensores() {
        val deviceSensores: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_ALL)
        val sensorText = StringBuilder()
        for (sensor in deviceSensores) {
            sensorText.append(sensor.name).append(
                System.getProperty("line.separator")
            )
        }
        val sensorTextView = findViewById<TextView>(R.id.textSensores)
        sensorTextView.text = sensorText
    }

    // Los datos que el sensor escuche
    override fun onSensorChanged(value: SensorEvent) {
        val valorSensor = value.values[0]
        Log.v("SENSOR_LUZ", valorSensor.toString())
    }

    // La exactitud del Sensor
    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

}