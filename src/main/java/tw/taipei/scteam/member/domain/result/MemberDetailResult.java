package tw.taipei.scteam.member.domain.result;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tw.taipei.scteam.member.common.enumeration.GenderEnum;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDetailResult {
  private Long memberId;
  private String memberName;
  private LocalDate birth;
  private GenderEnum gender;
}
