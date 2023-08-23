package com.het.todolist.Filters;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.het.todolist.Entity.User;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserGetMappingFilter {

    public MappingJacksonValue filter(User user){
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName");
        FilterProvider filters = new SimpleFilterProvider().addFilter("userGetMappingFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }
    public MappingJacksonValue filter(List<User> user){
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName");
        FilterProvider filters = new SimpleFilterProvider().addFilter("userGetMappingFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

}
