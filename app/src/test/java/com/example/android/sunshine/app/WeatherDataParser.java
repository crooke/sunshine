package com.example.android.sunshine.app;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ecrook on 9/1/16.
 */

public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */

    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        // TODO: add parsing code here
        //create a JSON object from the JSON string
        JSONObject weatherObject = new JSONObject(weatherJsonStr);
        //create a JSON array of the list of days from the weatherJSON object
        JSONArray days = weatherObject.getJSONArray("list");
        //find the day in the weatherJSON list array that corresponds to dayIndex
        JSONObject dayInfo = days.getJSONObject(dayIndex);
        //find temperature info for that day
        JSONObject tempInfo = dayInfo.getJSONObject("temp");
        //return the max temp
        return tempInfo.getDouble("max");

    }
}
