package com.example.cardealer.domain.CONSTANTS;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.Timestamp;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public enum Units {
    ;
    public static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();
}
