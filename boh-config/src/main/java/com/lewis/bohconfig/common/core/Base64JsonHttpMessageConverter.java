package com.lewis.bohconfig.common.core;


import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public class Base64JsonHttpMessageConverter extends MappingJacksonHttpMessageConverter {
    public Base64JsonHttpMessageConverter(){
        super();
       /* ObjectMapper mapper = getObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
                .configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false)
                .configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false).getSerializationConfig()
                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        Set<String> fliterSet = new HashSet<String>();
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("filter",
                SimpleBeanPropertyFilter.serializeAllExcept(fliterSet));
        mapper.setFilters(filterProvider);*/
    }

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        byte[] bytes = getObjectMapper().writeValueAsBytes(object);
        FileCopyUtils.copy(Base64.encodeBase64(bytes),outputMessage.getBody());
    }
}
