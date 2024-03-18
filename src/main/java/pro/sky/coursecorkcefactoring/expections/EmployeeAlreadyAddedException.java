package pro.sky.coursecorkcefactoring.expections;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT)
public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException() {
        super("Сотрудник уже был добавлен");
    }
}
