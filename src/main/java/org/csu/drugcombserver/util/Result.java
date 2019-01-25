package org.csu.drugcombserver.util;

import org.csu.drugcombserver.entity.Msg;

public class Result {
    public static Msg success(Object object){
        return new Msg(object);
    }
    public static Msg success(){
        return success(null);
    }

    public static Msg error(Integer code, String errMsg){
        Msg msg=new Msg();
        msg.setCode(code);
        msg.setMsg(errMsg);
        return msg;
    }
}
