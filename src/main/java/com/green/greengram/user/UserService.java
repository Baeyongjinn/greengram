package com.green.greengram.user;


import com.green.greengram.user.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper mapper;

    public int putUser(UserInsDto dto) {
        return mapper.insUser(dto);
    }

    //1: 아이디/비번 맞췄음, 2: 아이디 없음, 3: 비밀번호 다름
    public UserSignInVo signIn(UserSignInDto dto) {
        UserSignInVo vo = new UserSignInVo();
        vo.setResult(3);

        UserSignInProcVo procVo = mapper.selUserByUid(dto.getUid());
        if(procVo == null) {
            vo.setResult(2);
        } else if(procVo.getUpw().equals(dto.getUpw())) {
            vo.setResult(1);
            vo.setIuser(procVo.getIuser());
            vo.setNm(procVo.getNm());
            vo.setPic(procVo.getPic());
        }
        return vo;
    }

    public UserProfileInfoVo getUserProfileInfo(int iuser) {
       return mapper.selUserProfileInfo(iuser);
    }
}
