package ir.bs.tenant_and_landlord.domain;

/*
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

*/
/**
 * Created by : Pourya Bahrami
 * Date : 10/8/21
 * Time : 9:06 PM
 *//*


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "land_lords")
public class LandLord extends User {

    @ManyToMany(mappedBy = "landLords")
    private List<Tenant> tenants;

    @OneToMany(mappedBy = "landLord")
    private List<State> states;

    @OneToMany(mappedBy = "landLord")
    private List<Contract> contracts;
}
*/
