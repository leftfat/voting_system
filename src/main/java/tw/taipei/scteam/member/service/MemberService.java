package tw.taipei.scteam.member.service;

import tw.taipei.scteam.member.domain.info.MemberDetailInfo;
import tw.taipei.scteam.member.domain.result.MemberDetailResult;

public interface MemberService {

  /**
   * 註冊帳號
   * 
   * @param account          : 帳號
   * @param password         : 密碼
   * @param memberDetailInfo : 使用者資訊
   * @return true
   */
  boolean register(String account, String password, MemberDetailInfo memberDetailInfo);

  /**
   * 登入
   * 
   * @param account  : 帳號
   * @param password : 密碼
   * @return 使用者資訊
   */
  MemberDetailResult login(String account, String password);

  /**
   * 修改密碼
   * 
   * @param memberId : id
   * @param password : 密碼
   */
  void changePassword(Long memberId, String oldPassword, String newPassword);

}
