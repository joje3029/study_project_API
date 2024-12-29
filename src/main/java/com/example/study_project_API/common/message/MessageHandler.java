package com.example.study_project_API.common.message;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import com.example.study_project_API.common.JsonResult;
import com.example.study_project_API.common.type.MessageCrudType;

@Component
public class MessageHandler {
    private final MessageSourceAccessor accessor;

    public MessageHandler(@Qualifier("messageSource") MessageSource messageSource) {
        this.accessor = new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
    }

    public JsonResult getCrudMessageResult(boolean isSuccess, MessageCrudType messageCrudType, Object resultData) {
        int resultCode;
        String resultMsg;

        if (isSuccess) {
            resultCode = 200;
            resultMsg = accessor.getMessage("app.msg.crud." + messageCrudType.getValue() + ".success");
        } else {
            resultCode = 500;
            resultMsg = accessor.getMessage("app.msg.crud." + messageCrudType.getValue() + ".failure");
        }

        return new JsonResult(resultCode, resultMsg, resultData);
    }

    public JsonResult getCrudMessageResult(boolean isSuccess, MessageCrudType messageCrudType) {
        return getCrudMessageResult(isSuccess, messageCrudType, null);
    }
}