package umc.spring.study.apiPayload.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.study.apiPayload.code.BaseErrorCode;
import umc.spring.study.apiPayload.exception.GeneralException;

@Getter
public class FoodCategoryHandler extends GeneralException {

  private final BaseErrorCode errorCode;

  public FoodCategoryHandler(BaseErrorCode errorCode) {
    super(errorCode);
    this.errorCode = errorCode;
  }
}