package io.visualjava.common.util;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author CaptHua
 */
public class ReflectionUtils {

    private static final Field[] EMPTY_FIELD_ARRAY = new Field[0];
    private static final Map<Class<?>, Field[]> declaredFieldsCache = new ConcurrentHashMap<>(256);

    public static Object getFieldValue(Class<?> clazz,String fieldName,Object obj){
        Field field= ReflectionUtils.getDeclaredField(clazz,fieldName);
        if(field==null) return null;
        field.setAccessible(true);
        Object value=null;
        try{
            value=field.get(obj);
        }catch (Exception ignored){
            throw new RuntimeException(ignored);
        }
        return value;
    }

    public static Field getDeclaredField(Class<?> clazz,String fieldName) {
        Field field=null;
        for(Field f:getDeclaredFields(clazz)){
            if(f.getName().equals(fieldName)){
                field=f;
                break;
            }
        }
        return field;
    }

    public static Field[] getDeclaredFields(Class<?> clazz) {
        Field[] fields = declaredFieldsCache.get(clazz);
        if (fields == null) {
            try {
                fields = clazz.getDeclaredFields();
                declaredFieldsCache.put(clazz, (fields.length == 0 ? EMPTY_FIELD_ARRAY : fields));
            } catch (Throwable ex) {
                throw new IllegalStateException("Failed to introspect Class [" + clazz.getName() +
                        "] from ClassLoader [" + clazz.getClassLoader() + "]", ex);
            }
        }
        return fields;
    }

}
