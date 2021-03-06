package com.demos.springbootdemos;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
class FastJsonConfiguration extends WebMvcConfigurerAdapter {

    /**
     * 修改自定义消息转换器
     */

    public void configMessageConverters(List<HttpMessageConverter<?>> converters) {
//        调用父类的配置
        super.configureMessageConverters(converters);
//        创建fastjson消息的转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
//        将fastjson添加到视图消息转换器的列表中
        converters.add(fastConverter);
    }
}
