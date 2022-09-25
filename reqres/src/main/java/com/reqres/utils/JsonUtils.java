package com.reqres.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.response.Response;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JsonUtils {

    public static <T> T getJsonAsObject(String json, Class<T> mapClass) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T object;
        try {
            object = mapper.readValue(json, mapClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return object;
    }

    public static String getObjectAsJson(Object object) {
        String json;
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            json = ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    public static void validateObject(Response response, String scheme) {
        try {
            String requestResponse = response.asString();
            JSONObject jsonSchema = new JSONObject(new JSONTokener(new FileInputStream(scheme)));
            JSONObject jsonSubject = new JSONObject(new JSONTokener(requestResponse));
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonSubject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void validateList(String response, String scheme) {
        try {
            JSONObject jsonSchema = new JSONObject(new JSONTokener(new FileInputStream(scheme)));
            JSONArray jsonSubject = new JSONArray(new JSONTokener(response));
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonSubject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void validateResponse(Response response, String scheme) {
        try {
            JSONObject jsonSchema = new JSONObject(new JSONTokener(new FileInputStream(scheme)));
            JSONObject jsonSubject = new JSONObject(new JSONTokener(response.asString()));
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonSubject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
