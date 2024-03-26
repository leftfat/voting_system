package tw.taipei.scteam.member.domain.bean;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member_detail")
public class MemberDetailBean {
  @Id
  private Long memberId;
  private String memberName;
  private LocalDate birth;
  private Integer gender;
}
