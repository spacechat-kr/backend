package team.spacechat.spacechatapi.common;

public class ResponseGenerator {

    public static ApiResponse ok(){
        return new ApiResponse("200", "success");
    }

    public static ApiResponse ok(Object data){
        return new ApiResponse("200", data);
    }

    public static ApiResponse err(String errCode){
        return new ApiResponse(errCode, "err");
    }

    public static ApiResponse err(String errCode, Object data){
        return new ApiResponse(errCode, data);
    }

}
