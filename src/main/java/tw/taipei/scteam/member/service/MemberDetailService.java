package tw.taipei.scteam.member.service;

import tw.taipei.scteam.member.domain.info.MemberDetailInfo;
import tw.taipei.scteam.member.domain.result.MemberDetailResult;

public interface MemberDetailService {

  /**
   * 新增使用者資訊(供其他service呼叫用)
   */
  boolean create(long memberId, MemberDetailInfo memberDetailInfo);

  /**
   * 修改使用者資訊
   */
  MemberDetailResult update(long memberId, MemberDetailInfo memberDetailInfo);

  /**
   * 查詢使用者資訊
   */
  MemberDetailResult findById(long memberId);
}
