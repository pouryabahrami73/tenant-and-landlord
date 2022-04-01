package ir.bs.tenant_and_landlord.domain;

import ir.bs.tenant_and_landlord.domain.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by : Pourya Bahrami
 * Date : 4/1/22
 * Time : 5:29 PM
 */

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserRoleContractJunction extends BaseEntity {

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
}
