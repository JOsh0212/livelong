package world.neverdie.livelong.bookreview.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ScoreVaildate implements ConstraintValidator<Score,Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {// 스코어는 0~5점 , null 가능
        if (value == null) { // null 값은 통과
            return true;
        }
        if (value >= 0 && value <= 5) { // 0에서 5 사이의 값은 통과
            return true;
        } else { // 그 외의 값은 에러 처리
            return false;
        }
    }
}
