package org.ulpgc.dacd.control;

import org.ulpgc.dacd.model.Location;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        String apikey = args[0];
        OpenWeatherMapSupplier openWeatherMapSupplier = new OpenWeatherMapSupplier(apikey);
        JmsWeatherStore jmsWeatherStore = new JmsWeatherStore();
        WeatherController weatherController = new WeatherController(openWeatherMapSupplier, jmsWeatherStore);

        Timer timer = new Timer();
        long period = 6 * 60 * 60 * 1000;
        timer.scheduleAtFixedRate(weatherController, 0, period);
    }

    public static Location[] getLocations() {
        return new Location[] {
                new Location(28.29, -16.62, "Tenerife"),
                new Location(27.99, -15.60, "GranCanaria"),
                new Location(29.04, -13.58, "Lanzarote"),
                new Location(28.35, -14.05, "Fuerteventura"),
                new Location(28.61, -17.87, "LaPalma"),
                new Location(28.11, -17.22, "LaGomera"),
                new Location(27.74, -18.01, "ElHierro"),
                new Location(29.23, -13.51, "LaGraciosa")
        };
    }
}