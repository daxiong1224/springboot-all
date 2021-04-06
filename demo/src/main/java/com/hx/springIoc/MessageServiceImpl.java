package com.hx.springIoc;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageServiceImpl implements MessageService{
    MsgServiceImpl msgService;
    
    @Override
    public String getMessage() {
        return "HELLO WORLD";
    }

    public MsgServiceImpl getMsgService() {
        return msgService;
    }

    public void setMsgService(MsgServiceImpl msgService) {
        this.msgService = msgService;
    }
}
