package umc.spring.study.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto<T> {
    private boolean isSuccess;
    private String code;
    private String message;
    private T data;

    public static <T> ResponseDto<T> onSuccess(T data, String code) {
        return new ResponseDto<>(true, code, "Success", data);
    }

    public static <T> ResponseDto<T> onFailure(String code, String message) {
        return new ResponseDto<>(false, code, message, null);
    }
}
