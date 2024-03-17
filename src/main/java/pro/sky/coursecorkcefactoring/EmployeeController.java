package pro.sky.coursecorkcefactoring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pro.sky.coursecorkcefactoring.expections.EmployeeAlreadyAddedException;
import pro.sky.coursecorkcefactoring.expections.EmployeeStorageIsFullException;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController{
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstName") String fName, @RequestParam("lastName") String lName) {
        return employeeService.addEmployee(fName, lName);
    }

    @GetMapping(path = "/remove")
    public Employee deketeEmployee(@RequestParam("firstName") String fName, @RequestParam("lastName") String lName) {
        return employeeService.deleteEmployee(fName, lName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam("firstName") String fName, @RequestParam("lastName") String lName) {
        return employeeService.findEmployee(fName, lName);
    }

    @GetMapping(path = "/getAll")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
}
