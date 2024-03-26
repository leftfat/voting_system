package tw.taipei.scteam.member.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.taipei.scteam.exception.exception.IdNotFoundException;
import tw.taipei.scteam.exception.exception.UnprocessableEntityException;
import tw.taipei.scteam.member.domain.bean.MemberBean;
import tw.taipei.scteam.member.domain.info.MemberDetailInfo;
import tw.taipei.scteam.member.domain.result.MemberDetailResult;
import tw.taipei.scteam.member.repository.MemberRepository;

@Service
@Transactional(rollbackFor = SQLException.class)
public class MemberServiceImpl implements MemberService {

  // @Autowired
  // private MemberConverter converter;

  @Autowired
  private MemberRepository repository;

  @Autowired
  private EncryptService encryptService;

  @Autowired
  private MemberDetailService memberDetailService;

  @Override
  public boolean register(String account, String password, MemberDetailInfo memberDetailInfo) {

    if (repository.existsByAccount(account))
      throw new UnprocessableEntityException("帳號已存在");

    // 加密
    password = encryptService.encrypt(password);

    // 新增 Member
    MemberBean bean = MemberBean.builder().account(account).password(password).build();
    repository.save(bean);

    // 新增 MemberDetail
    memberDetailService.create(bean.getMemberId(), memberDetailInfo);
    return true;
  }

  @Override
  public MemberDetailResult login(String account, String password) {

    MemberBean bean = repository.findByAccount(account).orElseThrow(() -> new UnprocessableEntityException("帳號或密碼錯誤"));

    // 登入驗證
    if (encryptService.checkPassword(password, bean.getPassword()))
      return memberDetailService.findById(bean.getMemberId());
    else
      throw new UnprocessableEntityException("帳號或密碼錯誤");
  }

  @Override
  public void changePassword(Long memberId, String oldPassword, String newPassword) {

    // 取得資料
    MemberBean bean = repository.findById(memberId).orElseThrow(() -> new IdNotFoundException());

    // 驗證與更新
    if (encryptService.checkPassword(oldPassword, bean.getPassword())) {
      bean.setPassword(encryptService.encrypt(newPassword));
      repository.save(bean);
    } else {
      throw new UnprocessableEntityException("密碼錯誤");
    }
  }
}
