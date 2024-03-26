package tw.taipei.scteam.member;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.taipei.scteam.exception.exception.CustomException;
import tw.taipei.scteam.member.common.enumeration.GenderEnum;
import tw.taipei.scteam.member.domain.info.MemberDetailInfo;
import tw.taipei.scteam.member.domain.result.MemberDetailResult;
import tw.taipei.scteam.member.service.MemberDetailService;

@SpringBootTest
public class MemberDetailServiceTests {

  @Autowired
  private MemberDetailService memberDetailService;

  @Test
  public void testUpdate() {

    Long memberId = 6L;

    MemberDetailInfo info = MemberDetailInfo.builder()
        .memberName("User125")
        .gender(GenderEnum.SECRET)
        .birth(LocalDate.of(2000, 2, 1))
        .build();

    try {
      MemberDetailResult result = memberDetailService.update(memberId, info);
      System.err.println(result);
      success();
    } catch (CustomException e) {
      failed(e);
    }
  }

  @Test
  public void testFindById() {

    Long memberId = 6L;

    try {
      MemberDetailResult result = memberDetailService.findById(memberId);
      System.err.println(result);
      success();
    } catch (CustomException e) {
      failed(e);
    }
  }

  private void success() {
    System.err.println("success");
  }

  private void failed(CustomException e) {
    System.err.println(e.getError());
  }
}
