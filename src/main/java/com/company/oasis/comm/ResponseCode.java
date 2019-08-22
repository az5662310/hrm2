package com.company.oasis.comm;

public enum ResponseCode {
    SUCCESS(0, "SUCCESS"),
    ERROR(1, "ERROR"),
    ILLEGAL_ARGUMENT(2, "LLEGAL_ARGUMENT"),
    NEED_LOGIN(20, "   NEED_LOGIN");

    //信息码及描述
    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}

