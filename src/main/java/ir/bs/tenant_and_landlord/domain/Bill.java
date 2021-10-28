package ir.bs.tenant_and_landlord.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by : Pourya Bahrami
 * Date : 10/28/21
 * Time : 8:41 PM
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bills")
public class Bill extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
}
