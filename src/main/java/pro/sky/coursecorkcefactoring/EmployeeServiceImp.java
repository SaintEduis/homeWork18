package pro.sky.coursecorkcefactoring;
import org.springframework.stereotype.Service;
import pro.sky.coursecorkcefactoring.expections.EmployeeAlreadyAddedException;
import pro.sky.coursecorkcefactoring.expections.EmployeeNotFoundException;
import pro.sky.coursecorkcefactoring.expections.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private List<Employee> employeeBook = new ArrayList<>(List.of());
    private final int maxEmployeeNumb = 50;

    public List<Employee> getEmployeeBook() {
        return employeeBook;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employeeBook.isEmpty()) {
            Employee employee = new Employee(firstName, lastName);
            employeeBook.add(employee);
            return employee;
        }
        else if (employeeBook.size() < maxEmployeeNumb) {
            for (int i = 0; i < employeeBook.size(); i++) {
                if (employeeBook.get(i).getFirstNameOfWorker().equals(firstName)
                        && employeeBook.get(i).getLastNameOfWorker().equals(lastName)) {
                    throw new EmployeeAlreadyAddedException();
                }
            }
            Employee employee = new Employee(firstName, lastName);
            employeeBook.add(employee);
            return employee;
        } else {
            throw new EmployeeStorageIsFullException();
        }
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {

        for (int i = 0; i < employeeBook.size(); i++) {
            if (employeeBook.get(i).getFirstNameOfWorker().equals(firstName)
                    && employeeBook.get(i).getLastNameOfWorker().equals(lastName)) {
                Employee employee = new Employee(employeeBook.get(i).getFirstNameOfWorker(), employeeBook.get(i).getLastNameOfWorker());
                employeeBook.remove(i);
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (int i = 0; i < employeeBook.size(); i++) {
            if (employeeBook.get(i).getFirstNameOfWorker().equals(firstName)
                    && employeeBook.get(i).getLastNameOfWorker().equals(lastName)) {
                return employeeBook.get(i);
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeBook;
    }
}