package priv.cxs.data.hive.controller.vo;

import lombok.Data;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/29 下午4:35
 **/
@Data
public class WebRet<T> {

    private boolean success;
    private int errCode;
    private String errMsg;
    private T data;

    public static <T> WebRet<T> successWithData(T data){
        WebRet<T> webRet = new WebRet<>();
        webRet.setSuccess(true);
        webRet.setErrCode(0);
        webRet.setErrMsg("success");
        webRet.setData(data);
        return webRet;
    }

    public static <T> WebRet<T> fail() {
        WebRet<T> webRet = new WebRet<>();
        webRet.setSuccess(false);
        webRet.setErrCode(500);
        webRet.setErrMsg("fail");
        webRet.setData(null);
        return webRet;
    }

    public static <T> WebRet<T> failWithMsg(String errMsg) {
        WebRet<T> webRet = new WebRet<>();
        webRet.setSuccess(false);
        webRet.setErrCode(500);
        webRet.setErrMsg(errMsg);
        webRet.setData(null);
        return webRet;
    }
}
