package np.map.MTM;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "p_id")
    private int projectId;

    @Column(name = "p_name")
    private String projectName;

    @ManyToMany
    @JoinTable(name = "project_assign",
            joinColumns = @JoinColumn(name = "p_id"),
            inverseJoinColumns = @JoinColumn(name = "e_id")
    )
    private List<Employee> employee;

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public Project() {
    }

    public Project(int projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }
}
