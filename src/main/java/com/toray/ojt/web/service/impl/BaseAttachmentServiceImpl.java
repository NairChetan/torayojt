package com.toray.ojt.web.service.impl;

import com.toray.ojt.web.dto.BaseAttachmentInsertDto;
import com.toray.ojt.web.dto.BaseAttachmentSelectDto;
import com.toray.ojt.web.mapper.BaseAttachmentMapper;
import com.toray.ojt.web.service.BaseAttachmentService;
import org.springframework.stereotype.Service;

@Service
public class BaseAttachmentServiceImpl implements BaseAttachmentService {
    private final BaseAttachmentMapper baseAttachmentMapper;
    public BaseAttachmentServiceImpl(BaseAttachmentMapper baseAttachmentMapper){
        this.baseAttachmentMapper = baseAttachmentMapper;
    }
    @Override
    public BaseAttachmentSelectDto getFileDataByClassNumber(Long classNo) {
         return baseAttachmentMapper.getFileData(classNo);
    }
}
