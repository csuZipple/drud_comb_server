package org.csu.drugcombserver.exception;

import org.csu.drugcombserver.core.Msg;
import org.csu.drugcombserver.core.Result;
import org.csu.drugcombserver.entity.Code;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class ParamsValidateException {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Msg handler(Exception ex) {

        ex.printStackTrace();
        StringBuilder errMsg =  new StringBuilder();
        if(ex instanceof ConstraintViolationException){
            ConstraintViolationException e = (ConstraintViolationException) ex;
            Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
            for (ConstraintViolation<?> cvl : constraintViolations) {
                errMsg.append(cvl.getMessage()).append(";");
            }
            return Result.error(Code.BAD_REQUEST,errMsg.toString());
        }else if(ex instanceof BindException){
            BindException c = (BindException) ex;
            List<ObjectError> errors = c.getBindingResult().getAllErrors();
            for (ObjectError error : errors) {
                errMsg.append(error.getDefaultMessage()).append(";");
            }
            return Result.error(Code.BAD_REQUEST,errMsg.toString());
        }
        return Result.error(Code.SERVER_ERROR,"Illegal params");
    }
}
