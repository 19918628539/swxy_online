package com.swxy_online.service.base.handler;

import com.swxy_online.common.base.result.R;
import com.swxy_online.common.base.result.ResultCodeEnum;
import com.swxy_online.common.base.util.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
     public R error(Exception e){
        log.error(ExceptionUtils.getMessage(e));
        return R.error();
     }
     @ExceptionHandler(BadSqlGrammarException.class)
     @ResponseBody
     public R error(BadSqlGrammarException  e){
         log.error(ExceptionUtils.getMessage(e));
         return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
     }
     @ExceptionHandler(HttpMessageNotReadableException.class)
     @ResponseBody
     public R error(HttpMessageNotReadableException e){
         log.error(ExceptionUtils.getMessage(e));
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
     }
}
