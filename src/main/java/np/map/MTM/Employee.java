package np.map.MTM;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "e_id")
    private int employeeId;

    @Column(name = "e_name")
    private String employeeName;

    @ManyToMany
    @JoinTable(name = "employee_assign",
            joinColumns = @JoinColumn(name = "e_id"),
            inverseJoinColumns = @JoinColumn(name = "p_id")
    )

    private List<Project> projects;

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Employee() {
    }

    public Employee(int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

}
