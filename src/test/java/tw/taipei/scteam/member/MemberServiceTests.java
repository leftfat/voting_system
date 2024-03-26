package tw.taipei.scteam.member;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.taipei.scteam.exception.exception.CustomException;
import tw.taipei.scteam.member.common.enumeration.GenderEnum;
import tw.taipei.scteam.member.domain.info.MemberDetailInfo;
import tw.taipei.scteam.member.domain.result.MemberDetailResult;
import tw.taipei.scteam.member.service.MemberService;

@SpringBootTest
public class MemberServiceTests {

  @Autowired
  private MemberService memberService;

  @Test
  public void testregister() {

    String account = "DemoAccount";
    String password = "DemoPassw0rd";

    MemberDetailInfo info = MemberDetailInfo.builder()
        .memberName("User123")
        .gender(GenderEnum.FEMALE)
        .birth(LocalDate.of(2000, 1, 1))
        .build();

    try {
      memberService.register(account, password, info);
      success();
    } catch (CustomException e) {
      failed(e);
    }
  }

  @Test
  public void testLogin() {

    String account = "DemoAccount";
    String password = "DemoPassw0rd";

    try {
      MemberDetailResult result = memberService.login(account, password);
      System.err.println(result);
      success();
    } catch (CustomException e) {
      failed(e);
    }
  }

  @Test
  public void testChangePassword() {

    Long memberId = 7L;
    String oldPassword = "DemoPassw0rd";
    String newPassword = "DemoPassw0rd!";

    try {
      memberService.changePassword(memberId, oldPassword, newPassword);
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
