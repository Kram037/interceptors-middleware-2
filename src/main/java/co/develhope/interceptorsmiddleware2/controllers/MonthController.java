package co.develhope.interceptorsmiddleware2.controllers;

import co.develhope.interceptorsmiddleware2.entities.Month;
import co.develhope.interceptorsmiddleware2.interceptors.MonthInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthController {

    @GetMapping
    public Month getMonth(@RequestHeader(value = "monthNumber", required = true) Integer monthNumber) throws Exception {
        if (monthNumber == null) {
            throw new Exception("monthNumber header is missing");
        }
        return MonthInterceptor.getMonthByNumber(monthNumber);
    }
}