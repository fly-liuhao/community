package cn.edu.tit.community.dto;

import cn.edu.tit.community.enums.ICustomizeErrorCodeEnum;
import cn.edu.tit.community.exception.CustomizeException;
import lombok.Data;

/**
 * 用于封装请求的返回状态以及携带的信息(使用单例模式)
 */
@Data
public class ResponseDTO {
    private Integer code;
    private String message;
    private static ResponseDTO responseDTO = new ResponseDTO();

    private ResponseDTO() {
    }

    /**
     * 获取请求响应结果的实体
     *
     * @param code    错误码
     * @param message 携带的信息
     * @return 响应结果的实体
     */
    public static ResponseDTO errorOf(Integer code, String message) {
        responseDTO.code = code;
        responseDTO.message = message;
        return responseDTO;
    }

    public static ResponseDTO errorOf(CustomizeException customizeException) {
        responseDTO.code = customizeException.getCode();
        responseDTO.message = customizeException.getMessage();
        return responseDTO;
    }
}
