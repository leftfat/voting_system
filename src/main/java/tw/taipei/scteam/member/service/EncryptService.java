package tw.taipei.scteam.member.service;

public interface EncryptService {

  /**
   * 加密
   * 
   * @param password : 密碼
   * @return 密文
   */
  String encrypt(String password);

  /**
   * 檢查密碼
   * 
   * @param password : 密碼
   * @param hash     : 密文
   * @return true : 密碼正確, false : 密碼錯誤
   */
  boolean checkPassword(String password, String hash);
}
