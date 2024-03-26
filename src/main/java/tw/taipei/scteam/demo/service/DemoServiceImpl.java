package tw.taipei.scteam.demo.service;

import org.springframework.stereotype.Service;

import tw.taipei.scteam.exception.exception.IdNotFoundException;
import tw.taipei.scteam.exception.exception.InternalServerErrorException;
import tw.taipei.scteam.exception.exception.UnprocessableEntityException;

@Service
// @Transactional(rollbackFor = Exception.class)
public class DemoServiceImpl implements DemoService {

  @Override
  public String method1(Integer number) {

    if (number == 1)
      throw new IdNotFoundException();
    if (number == 2)
      throw new UnprocessableEntityException("名稱重複");
    if (number == 3)
      throw new InternalServerErrorException();

    return "success";
  }

}
