package com.blogsystem.model;


import com.blogsystem.common.Constants;
import lombok.Data;

@Data
public class Result<T>{

    private int code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(Constants.RESULT_SUCCESS);
        result.setMessage("success");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(String message) {
        Result<T> result = new Result<>();
        result.setCode(Constants.RESULT_FAIL);
        result.setMessage(message);
        return result;
    }

}
