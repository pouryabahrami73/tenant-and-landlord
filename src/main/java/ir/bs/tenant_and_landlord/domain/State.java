package ir.bs.tenant_and_landlord.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by : Pourya Bahrami
 * Date : 10/8/21
 * Time : 9:05 PM
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "states")
public class State extends BaseEntity {

    @OneToMany(mappedBy = "state")
    private List<Bill> bills;

    @OneToMany(mappedBy = "state")
    private List<Contract> contracts;
}
