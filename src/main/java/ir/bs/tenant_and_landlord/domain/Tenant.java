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
 * Time : 9:05 PM
 *//*


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tenants")
public class Tenant extends User {

    @OneToMany(mappedBy = "tenant")
    private List<Contract> contracts;

    @OneToMany
    private List<State> states;

    @ManyToMany
    @JoinTable(name = "tenant_lord",
            joinColumns = {@JoinColumn(name = "tenant_id")},
            inverseJoinColumns = {@JoinColumn(name = "land_lord_Id")})
    private List<LandLord> landLords;
}
*/
