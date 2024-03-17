package pro.sky.coursecorkcefactoring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursecorkcefactoring.expections.EmployeeAlreadyAddedException;
import pro.sky.coursecorkcefactoring.expections.EmployeeStorageIsFullException;

import java.util.List;

@RestController
public class EmployeeController{
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee/add")
    public Employee addEmployee(@RequestParam("firstName") String fName, @RequestParam("lastName") String lName) {
        return employeeService.addEmployee(fName, lName);
    }

    @GetMapping(path = "/employee/remove")
    public Employee deketeEmployee(@RequestParam("firstName") String fName, @RequestParam("lastName") String lName) {
        return employeeService.deleteEmployee(fName, lName);
    }

    @GetMapping(path = "/employee/find")
    public Employee findEmployee(@RequestParam("firstName") String fName, @RequestParam("lastName") String lName) {
        return employeeService.findEmployee(fName, lName);
    }

    @GetMapping(path = "/employee/getAll")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
}
