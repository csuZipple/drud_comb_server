package org.csu.drugcombserver.core;


import org.csu.drugcombserver.entity.Code;

public abstract  class BaseController  {
    protected Msg success () {
        return Result.success();
    }
    protected Msg success (Object obj) {
        return Result.success(obj);
    }
    protected Msg notFound () {
        return Result.error(Code.NOT_FOUND, "Data not found.");
    }
    protected Msg error () {
        return Result.error(Code.SERVER_ERROR, "Server error");
    }
    protected Msg badRequest (String errMsg) {
        return Result.error(Code.BAD_REQUEST, errMsg);
    }
}
