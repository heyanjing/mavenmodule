//package com.he.maven.module.exhandle;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.io.IOException;
//
///**
// * Created by heyanjing on 2017/10/27 16:01.
// */
//@ControllerAdvice
//public class ExceptionHandlerBean  extends ResponseEntityExceptionHandler {
//
//    /**
//     * 数据找不到异常
//     * @param ex
//     * @param request
//     * @return
//     * @throws IOException
//     */
//    @ExceptionHandler({DataNotFoundException.class})
//    public ResponseEntity<Object> handleDataNotFoundException(RuntimeException ex, WebRequest request) throws IOException {
//        return getResponseEntity(ex,request,ReturnStatusCode.DataNotFoundException);
//    }
//
//    /**
//     * 根据各种异常构建 ResponseEntity 实体. 服务于以上各种异常
//     * @param ex
//     * @param request
//     * @param specificException
//     * @return
//     */
//    private ResponseEntity<Object> getResponseEntity(RuntimeException ex, WebRequest request, ReturnStatusCode specificException) {
//
//        ReturnTemplate returnTemplate = new ReturnTemplate();
//        returnTemplate.setStatusCode(specificException);
//        returnTemplate.setErrorMsg(ex.getMessage());
//
//        return handleExceptionInternal(ex, returnTemplate,
//                new HttpHeaders(), HttpStatus.OK, request);
//    }
//
//}
