package ir.bs.tenant_and_landlord.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by : Pourya Bahrami
 * Date : 10/8/21
 * Time : 9:05 PM
 */
@Getter
@Setter
@MappedSuperclass
public class  BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createdAtDateTime;

    @UpdateTimestamp
    private LocalDateTime updatedAtDateTime;

}
