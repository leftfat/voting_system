package tw.taipei.scteam.member.common.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tw.taipei.scteam.member.domain.bean.MemberBean;
import tw.taipei.scteam.member.domain.info.MemberInfo;
import tw.taipei.scteam.member.domain.result.MemberResult;

@Mapper(componentModel = "spring")
public interface MemberConverter {

  @Mapping(target = "memberId", ignore = true)
  MemberBean toBean(MemberInfo info);

  MemberBean toBean(long memberId, MemberInfo info);

  MemberResult toResult(MemberBean bean);

}