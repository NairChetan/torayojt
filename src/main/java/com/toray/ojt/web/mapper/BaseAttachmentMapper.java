package com.toray.ojt.web.mapper;

import com.toray.ojt.web.dto.BaseAttachmentInsertDto;
import com.toray.ojt.web.dto.BaseAttachmentSelectDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseAttachmentMapper {
    void insertBaseAttachment(BaseAttachmentInsertDto baseAttachmentInsertDto);
    BaseAttachmentSelectDto getFileData(Long classNo);
}
