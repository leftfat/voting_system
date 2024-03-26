package tw.taipei.scteam.member.common.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tw.taipei.scteam.member.common.enumeration.GenderEnum;
import tw.taipei.scteam.member.domain.bean.MemberDetailBean;
import tw.taipei.scteam.member.domain.info.MemberDetailInfo;
import tw.taipei.scteam.member.domain.result.MemberDetailResult;

@Mapper(componentModel = "spring")
public interface MemberDetailConverter {
  
  @Mapping(target = "memberId", ignore = true)
  MemberDetailBean toBean(MemberDetailInfo info);

  MemberDetailBean toBean(long memberId, MemberDetailInfo info);

  MemberDetailResult toResult(MemberDetailBean bean);

  default Integer toInteger(GenderEnum genderEnum) {
    return genderEnum == null ? null : genderEnum.getCode();
  }

  default GenderEnum toGenderEnum(Integer integer) {

    if (integer == null)
      return null;

    for (GenderEnum genderEnum : GenderEnum.values()) {
      if (genderEnum.getCode().equals(integer))
        return genderEnum;
    }

    return null;

  }

  default String toString(GenderEnum genderEnum) {
    return genderEnum == null ? null : genderEnum.getText();
  }

  default GenderEnum toGenderEnum(String string) {

    if (string == null)
      return null;

    for (GenderEnum genderEnum : GenderEnum.values()) {
      if (genderEnum.getText().equals(string))
        return genderEnum;
    }

    return null;

  }

}
