package ir.bs.tenant_and_landlord.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by : Pourya Bahrami
 * Date : 10/8/21
 * Time : 9:04 PM
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contract")
public class Contract extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "tenant_id", unique = true)
    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "land_lord_id", unique = true)
    private LandLord landLord;

    @ManyToOne
    @JoinColumn(name = "state_id", unique = true)
    private State state;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "starts_at")
    private LocalDateTime startsAt;

    @Column(name = "deposit")
    private double deposit;

    @Column(name = "rent")
    private double rent;
}
