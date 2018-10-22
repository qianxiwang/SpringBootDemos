package com.demos.springbootdemos.Utils;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesUtil {
    private final ResourceBundle resourceBundle;
    private final String fileName;

    /**
     * 构造函数实例化部分对象，获取文件资源对象
     *
     * @param fileName
     */
    public PropertiesUtil(String fileName) {
        this.fileName = fileName;
        Locale locale = new Locale("zh", "CN");
        this.resourceBundle = ResourceBundle.getBundle(this.fileName, locale);
    }


    /**
     * 根据传入的key获取对象的值
     *
     * @param key
     * @return
     */
    public String getValue(String key) {
        String message = this.resourceBundle.getString(key);
        return message;
    }

    /**
     * 获取properties文件内的所有key值
     * @return
     */
    public Enumeration<String> getkeys() {
        return resourceBundle.getKeys();
    }
}
