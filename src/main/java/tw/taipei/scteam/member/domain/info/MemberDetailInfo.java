package tw.taipei.scteam.member.domain.info;

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
public class MemberDetailInfo {
  private String memberName;
  private LocalDate birth;
  private GenderEnum gender;
}
