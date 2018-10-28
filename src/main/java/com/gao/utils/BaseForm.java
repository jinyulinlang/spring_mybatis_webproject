package com.gao.utils;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BaseForm {
    private Object data;
    /**
     * 被加密過的公鑰 ASE算法的公共密鑰
     */
    private String encryptpublicKey;
    /**
     * 被加密的數據
     */
    private String encryptData;
    /**
     * 授信串
     */
    private String creditions;
    /**
     * 解析data之後存放的數據
     */
    Map<String, Object> bean = null;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getEncryptpublicKey() {
        return encryptpublicKey;
    }

    public void setEncryptpublicKey(String encryptpublicKey) {
        this.encryptpublicKey = encryptpublicKey;
    }

    public String getEncryptData() {
        return encryptData;
    }

    public void setEncryptData(String encryptData) {
        this.encryptData = encryptData;
    }

    public String getCreditions() {
        if (StringUtils.isEmpty(creditions)) {
            creditions = UUID.randomUUID().toString().replace("-", "");
        }
        return creditions;
    }

    public void setCreditions(String creditions) {
        this.creditions = creditions;
    }

    public Map<String, Object> getBean() {
        return bean;
    }
    public  void parseObjectToMap() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Map<String, Object> bean = new HashMap<>();
        Field[] fields = this.data.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!StringUtils.isEmpty(field.getName())) {
                bean.put(field.getName(), getValue(this.data, field.getName()));
            }
        }
        this.bean = bean;
    }

    private Object getValue(Object object, String fieldName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String upperChar = fieldName.substring(0, 1).toUpperCase();
        String getterMethodName = "get".concat(upperChar).concat(fieldName.substring(1));
        Method method = object.getClass().getMethod(getterMethodName, new Class[]{});
        return method.invoke(object, new Object[]{});
    }
}
