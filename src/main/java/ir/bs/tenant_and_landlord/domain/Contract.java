package ir.bs.tenant_and_landlord.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by : Pourya Bahrami
 * Date : 10/8/21
 * Time : 9:04 PM
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contracts")
public class Contract extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "tenant_id", unique = true)
    private User tenant;

    @ManyToOne
    @JoinColumn(name = "land_lord_id", unique = true)
    private User landLord;

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

    @Column(name = "paide_rents_amounts")
    private int paidRentsByTenantAmounts;

    @Column(name = "sum_of_paid_rents")
    private double sumOfPaidRentsByTenant;

    @OneToMany(mappedBy = "contract")
    private List<Receipt> receipts;

    @Lob
    @Column(name = "file", columnDefinition = "longblob")
    private String file;
}
