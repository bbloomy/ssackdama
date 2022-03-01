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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import ssackdama.ssackdama.config.exceptions.*;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {

    private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);


    @ExceptionHandler(AccessDeniedException.class) // 권한으로 접근 거부
    @ResponseStatus(HttpStatus.FORBIDDEN)//403 Forbidden
    public String accessDenied(final Throwable throwable, final Model model) {
        logger.error("handleAccessDeniedException", throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "error/403";
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleBusinessException(HttpServletRequest req,final BusinessException e) {

        logger.error("BusinessException:"+e.getErrorCode());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("pages"+req.getRequestURI());
        mav.addObject("errorMessage", e.getMessage());
        return mav;
    }

    @ExceptionHandler(Exception.class) // 그외 모든 에러
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//500 Internal Server Error
    public String exception(final Throwable throwable, final Model model) {
        logger.error("handleException", throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "error/500";
    }
    /*
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleBusinessException(final BusinessException e) {

        logger.error("BusinessException", e);
        final ErrorCode errorCode = e.getErrorCode();
        final ErrorResponse response = ErrorResponse.of(errorCode);
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatus()));
    }
    */
}