package zhurylo.alex.weather;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;

import java.io.IOException;
import java.io.Serializable;

public class Weather implements Serializable {

    public float[] test() throws IOException, JSONException {
        OpenWeatherMap owm = new OpenWeatherMap("bfce56f0bcd9fab6ed5f801df7251e82");
        CurrentWeather cwd = owm.currentWeatherByCityName("Kiev");
        String t = String.valueOf(cwd.getWindInstance().getWindSpeed());
        float[] arrayList = new float[4];
        if (cwd.isValid()) {
            arrayList[0] = cwd.getMainInstance().getTemperature();
            arrayList[1] = cwd.getWindInstance().getWindSpeed();
            arrayList[2] = cwd.getMainInstance().getHumidity();
            arrayList[3] = cwd.getMainInstance().getPressure();
        }
        return arrayList;
    }
}