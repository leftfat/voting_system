package tw.taipei.scteam.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.password4j.Argon2Function;
import com.password4j.Password;

@Service
@Transactional(rollbackFor = Exception.class)
public class EncryptServiceImpl implements EncryptService {

  @Autowired
  private Argon2Function argon2;

  @Override
  public String encrypt(String password) {
    return Password.hash(password).addRandomSalt(32).with(argon2).getResult();
  }

  @Override
  public boolean checkPassword(String password, String hash) {
    return Password.check(password, hash).with(argon2);
  }

}
