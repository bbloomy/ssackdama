package ssackdama.ssackdama.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorController {

    private static Logger logger = LoggerFactory.getLogger(ErrorController.class);


    @ExceptionHandler(AccessDeniedException.class) // 권한으로 접근 거부
    @ResponseStatus(HttpStatus.FORBIDDEN)//403 Forbidden
    public String accessDenied(final Throwable throwable, final Model model) {
        logger.error("handleAccessDeniedException", throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        return "pages/error";
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