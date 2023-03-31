package com.schrodingdong.right;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataToObjectMapper<T> implements IDataMapper<T>{
    private Class<T> type;

    public DataToObjectMapper(Class<T> type) {
        this.type = type;
    }

    @Override
    public T map(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        T data = null;
        try {
            data = objectMapper.readValue(jsonString, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
