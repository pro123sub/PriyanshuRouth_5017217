public class CommandImplementor {
}
// Define Command implementations
class AddEmployeeCommand implements Command {
    private Employee employee;
    private EmployeeManagementSystem ems;
    public AddEmployeeCommand(Employee employee, EmployeeManagementSystem ems) {
        this.employee = employee;
        this.ems= ems;
    }


    @Override
    public void execute() {
        ems.addEmployee(employee);
    }
}
class SearchEmployeeCommand implements Command {
    private EmployeeManagementSystem ems;
    private String employeeId;

    public SearchEmployeeCommand(EmployeeManagementSystem ems, String employeeId) {
        this.ems = ems;
        this.employeeId = employeeId;
    }

    @Override
    public void execute() {
        Employee employee = ems.searchEmployee(employeeId);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }
    }
}
class TraverseEmployeesCommand implements Command {
    private EmployeeManagementSystem ems;

    public TraverseEmployeesCommand(EmployeeManagementSystem ems) {
        this.ems = ems;
    }

    @Override
    public void execute() {
        ems.traverseEmployees();
    }
}
class DeleteEmployeeCommand implements Command {
    private EmployeeManagementSystem ems;
    private String employeeId;

    public DeleteEmployeeCommand(EmployeeManagementSystem ems, String employeeId) {
        this.ems = ems;
        this.employeeId = employeeId;
    }

    @Override
    public void execute() {
        boolean isDeleted = ems.deleteEmployee(employeeId);
        if (isDeleted) {
            System.out.println("Employee deleted.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}
