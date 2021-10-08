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
@Table(name = "tenant")
public class Tenant extends BaseEntity {

    @OneToMany(mappedBy = "tenant")
    private List<Contract> contracts;
}
