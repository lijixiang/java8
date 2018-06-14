import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Collections.*;

import static java.util.Collections.*;


public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("aaa");

        System.out.println(optional.orElse("bbbb"));

        optional.ifPresent(str-> System.out.println(str));// recommendation

        Employee employee1 = new Employee("Tom");
        Employee employee2 = new Employee("Fiona");
        List<Employee> employees = Arrays.asList(employee1,employee2);
        Company company = new Company("CITIC",null);

        Optional<Company> optional1 = Optional.ofNullable(company);

        System.out.println(optional1.map(item->item.getEmployes())// recommendation
                .orElse(emptyList()));






    }
}

class Company{
    private String name;

    @Override
    public String toString() {
        return "Company{" + "name='" + name + '\'' + ", employes=" + employes + '}';
    }

    public Company(String name, List<Employee> employes) {
        this.name = name;
        this.employes = employes;
    }

    public List<Employee> getEmployes() {
        return employes;
    }

    public void setEmployes(List<Employee> employes) {
        this.employes = employes;
    }

    List<Employee> employes;
}

class Employee{
    private String name;

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + '}';
    }

    public Employee(String name) {
        this.name = name;
    }
}
