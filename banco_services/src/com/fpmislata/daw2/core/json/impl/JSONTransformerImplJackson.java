
package com.fpmislata.daw2.core.json.impl;

import com.fpmislata.daw2.core.json.JSONTransformer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONTransformerImplJackson implements JSONTransformer {
    @Override
    public String toJSON(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(obj);
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public <T> T toObject(String json, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, clazz);
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
