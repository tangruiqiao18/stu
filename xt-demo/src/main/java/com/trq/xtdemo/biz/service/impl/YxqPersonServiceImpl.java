package com.trq.xtdemo.biz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trq.xtdemo.biz.dto.YxqPersonDTO;
import com.trq.xtdemo.biz.dto.req.YxqPersonListReq;
import com.trq.xtdemo.biz.dto.resp.YxqPersonListResp;
import com.trq.xtdemo.biz.mapper.YxqPersonMapper;
import com.trq.xtdemo.biz.service.YxqPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author trq
 * @version 1.0
 * @since 2022/5/21 18:32
 */
@Service
@Slf4j
public class YxqPersonServiceImpl implements YxqPersonService {

    @Resource
    private YxqPersonMapper yxqPersonMapper;

    @Override
    public int updateByPersonId(YxqPersonDTO dto) {
        return yxqPersonMapper.updateByPersonId(dto);
    }

    @Override
    public YxqPersonListResp queryYxqPersonList(YxqPersonListReq req) {
        PageHelper.startPage(req.getPageNum(), req.getPageSize());

        List<YxqPersonDTO> personDTOList = yxqPersonMapper.queryYxqPersonList(req);
        PageInfo<YxqPersonDTO> pageInfo = new PageInfo<>(personDTOList);

        YxqPersonListResp resp = new YxqPersonListResp();
        resp.setList(personDTOList);
        resp.setTotal(pageInfo.getTotal());

        return resp;
    }
}
