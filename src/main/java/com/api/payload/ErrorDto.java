package com.api.payload;
// sending the msg to error page form here

import java.util.Date;
public class ErrorDto {
    public String msg;
    public Date date;
    public String uri;

    // Constructor
    public ErrorDto(String msg, Date date, String uri) {
        this.msg = msg;
        this.date = date;
        this.uri = uri;
    }

    // Getter methods
    public String getMsg() {
        return msg;
    }

    public java.util.Date getDate() {
        return date;
    }

    public String getUri() {
        return uri;
    }
}
