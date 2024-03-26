package tw.taipei.scteam.member.common.enumeration;

import lombok.Getter;

@Getter
public enum GenderEnum {

  MALE(1, "男性"), FEMALE(2, "女性"), OTHER(3, "其他"), SECRET(4, "不願透漏");

  private final Integer code;
  private final String text;

  GenderEnum(Integer code, String text) {
    this.code = code;
    this.text = text;
  }
}
