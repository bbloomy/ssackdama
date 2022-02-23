package ssackdama.ssackdama.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ssackdama.ssackdama.config.exceptions.BusinessException;
import ssackdama.ssackdama.config.exceptions.EmailDuplicateException;
import ssackdama.ssackdama.config.exceptions.ErrorCode;
import ssackdama.ssackdama.config.exceptions.ErrorResponse;

@ControllerAdvice
public class ExceptionController {

    private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);


    @ExceptionHandler(AccessDeniedException.class) // 권한으로 접근 거부
    @ResponseStatus(HttpStatus.FORBIDDEN)//403 Forbidden
    public String accessDenied(final Throwable throwable, final Model model) {
        logger.error("handleAccessDeniedException", throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "pages/error";
    }
    // 동작 안하는 중 .. 없는 페이지
    /*@ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)//404
    public String no_page(final NoHandlerFoundException throwable, final Model model) {
        logger.error("noHandlerFoundException", throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "pages/error";
    }*/


    @ExceptionHandler(EmailDuplicateException.class)
    public String handleEmailDuplicateException(final EmailDuplicateException e){
        logger.error("EmailDuplicateException",e);
        return "redirect:/signup?error";
    }
    @ExceptionHandler(BusinessException.class)//의미 없음
    public ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException e) {
        logger.error("BusinessException", e);
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }

    @ExceptionHandler(Exception.class) // 그외 모든 에러
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//500 Internal Server Error
    public String exception(final Throwable throwable, final Model model) {
        logger.error("handleException", throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "pages/error";
    }
}