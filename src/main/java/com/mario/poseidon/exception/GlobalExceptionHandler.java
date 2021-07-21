package com.mario.poseidon.exception;

import com.mario.poseidon.utils.R;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.BindException;
import java.util.List;

/**
 * @author mario on 2021/7/19.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public R<?> businessException(BusinessException e) {
        return R.fail(e.getMessage());
    }

    @ExceptionHandler(value = UnAuthorizedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public R<?> unAuthorizedException(UnAuthorizedException e) {
        return R.authFail(e.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    @ResponseBody
    public R<?> bodyValidExceptionHandler(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        return R.fail(fieldErrors.get(0).getDefaultMessage());
    }

    @ExceptionHandler(value = SizeLimitExceededException.class)
    @ResponseBody
    public R<?> sizeLimitExceededException(SizeLimitExceededException exception) {
        return R.fail("上传文件大小超限");
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R<?> exception(Exception exception) {
        return R.fail("系统异常");
    }
}
