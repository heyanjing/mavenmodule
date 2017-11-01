package com.he.maven.module.exhandle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 // MEINFO:2017/10/28 10:58  这只是个样例并不起作用
/**
 * Created by heyanjing on 2017/10/27 15:56.
 *
 * Spring MVC 异常处理顺序：
 ExceptionHandlerExceptionResolver ：被@ExceptionHandler注解标记的异常
 ->
 ResponseStatusExceptionResolver ：被@ResponseStatus注解标记的异常
 ->
 DefaultHandlerExceptionResolver ：Spring的标准异常处理
 ->
 自定义的Resolver

 标准异常处理 DefaultHandlerExceptionResolver
 引用
 BindException 400 (Bad Request)
 ConversionNotSupportedException 500 (Internal Server Error)
 HttpMediaTypeNotAcceptableException 406 (Not Acceptable)
 HttpMediaTypeNotSupportedException 415 (Unsupported Media Type)
 HttpMessageNotReadableException 400 (Bad Request)
 HttpMessageNotWritableException 500 (Internal Server Error)
 HttpRequestMethodNotSupportedException 405 (Method Not Allowed)
 MethodArgumentNotValidException 400 (Bad Request)
 MissingPathVariableException 500 (Internal Server Error)
 MissingServletRequestParameterException 400 (Bad Request)
 MissingServletRequestPartException 400 (Bad Request)
 NoHandlerFoundException 404 (Not Found)
 NoSuchRequestHandlingMethodException 404 (Not Found)
 TypeMismatchException 400 (Bad Request)
 */
@ControllerAdvice
public class GlobalExceptionHandler extends GlobalExceptionHandlerBase {

    //比如404的异常就会被这个方法捕获
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handle404Error(HttpServletRequest req, HttpServletResponse rsp, Exception e) throws Exception {
        return handleError(req, rsp, e, "error-front", HttpStatus.NOT_FOUND);
    }

    //500的异常会被这个方法捕获
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleError(HttpServletRequest req, HttpServletResponse rsp, Exception e) throws Exception {
        return handleError(req, rsp, e, "error-front", HttpStatus.INTERNAL_SERVER_ERROR);
    }



}