package org.merso.mersoshop.result;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;
import java.io.Serializable;
import java.lang.reflect.Method;
/*
自定义生成主键
 */
public class CustomUUIDGenerator extends UUIDGenerator {

     @Override

     public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Object account =  getFieldValueByName("account", object);
        if (account != null) {
            return (Serializable) account;
        }
        return super.generate(session, object);
    }

    private Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            return null;
        }
    }
}
