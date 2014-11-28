package com.web.controllers.api;

import com.web.services.HelloString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

/**
 * Created by seokangchun on 14. 11. 28..
 */
@Controller
@Slf4j
@RequestMapping("/api")
public class HelloApiController {

    @Autowired
    private HelloString helloSpring;

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam(value="name", defaultValue="") String name, Locale locale) {
        log.info("locale : {}", locale.getDisplayLanguage());
        return helloSpring.sayHello(name);
    }
}
