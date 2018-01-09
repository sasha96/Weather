package zhurylo.alex.weather;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;

import java.io.IOException;
import java.io.Serializable;

/*
 Class Weather determines the weather in the city
of Kiev using the framework OWM JAPIs
 */
public class Weather implements Serializable {
    /*
     The onlineWeather () method determines the weather
     conditions in the city of Kyiv at the moment and
     writes them to the float array [] arrayList
    */
    public float[] onlineWeather() {
        OpenWeatherMap owm = new OpenWeatherMap("bfce56f0bcd9fab6ed5f801df7251e82");
        CurrentWeather cwd = null;
        try {
            cwd = owm.currentWeatherByCityName("Kiev");
        } catch (IOException e) {
            e.printStackTrace();
        }
        float[] arrayList = new float[4];
        if (cwd != null && cwd.isValid()) {
            arrayList[0] = cwd.getMainInstance().getTemperature();
            arrayList[1] = cwd.getWindInstance().getWindSpeed();
            arrayList[2] = cwd.getMainInstance().getHumidity();
            arrayList[3] = cwd.getMainInstance().getPressure();
        }
        return arrayList;
    }
}