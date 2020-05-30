package com.tradeit.tradeitinman.exceptionhandler;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

//controller annotation (instead of rest ctrl) that the /error page returns the html page intest of the string
@Controller
public class ExceptionHandler implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "errorhandling/404";
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "errorhandling/500";
            } else if(statusCode == HttpStatus.TEMPORARY_REDIRECT.value()){
                return "errorhandling/302";
            } else if(statusCode == HttpStatus.METHOD_NOT_ALLOWED.value()){
                return "errorhandling/405";
            }
        }
        return "errorhandling/error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
