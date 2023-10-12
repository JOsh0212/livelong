package world.neverdie.livelong.bookreview.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=ScoreVaildate.class)
@Documented
public @interface Score {
    String message() default "잘못된 별점입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
