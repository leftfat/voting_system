package tw.taipei.scteam.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.taipei.scteam.exception.exception.IdNotFoundException;
import tw.taipei.scteam.exception.exception.InternalServerErrorException;
import tw.taipei.scteam.member.common.converter.MemberDetailConverter;
import tw.taipei.scteam.member.domain.bean.MemberDetailBean;
import tw.taipei.scteam.member.domain.info.MemberDetailInfo;
import tw.taipei.scteam.member.domain.result.MemberDetailResult;
import tw.taipei.scteam.member.repository.MemberDetailRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberDetailServiceImpl implements MemberDetailService {

  @Autowired
  private MemberDetailConverter converter;

  @Autowired
  private MemberDetailRepository repository;

  @Override
  public boolean create(long memberId, MemberDetailInfo memberDetailInfo) {

    if (repository.existsById(memberId))
      throw new InternalServerErrorException();

    // 新增
    MemberDetailBean bean = converter.toBean(memberId, memberDetailInfo);
    repository.save(bean);

    return true;
  }

  @Override
  public MemberDetailResult update(long memberId, MemberDetailInfo memberDetailInfo) {

    // 取得資料
    MemberDetailBean bean = repository.findById(memberId).orElseThrow(() -> new IdNotFoundException());

    // 更新
    bean = converter.toBean(memberId, memberDetailInfo);
    repository.save(bean);

    return converter.toResult(bean);
  }

  @Override
  public MemberDetailResult findById(long memberId) {
    return converter.toResult(repository.findById(memberId).orElseThrow(() -> new IdNotFoundException()));
  }
}
