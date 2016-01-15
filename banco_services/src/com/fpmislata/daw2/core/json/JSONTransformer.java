
package com.fpmislata.daw2.core.json;

public interface JSONTransformer {
    String toJSON(Object obj);
    <T> T toObject(String json, Class<T> clazz);
}
