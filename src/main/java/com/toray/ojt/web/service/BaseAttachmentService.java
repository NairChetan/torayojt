package com.toray.ojt.web.service;

import com.toray.ojt.web.dto.BaseAttachmentInsertDto;
import com.toray.ojt.web.dto.BaseAttachmentSelectDto;

public interface BaseAttachmentService {
    BaseAttachmentSelectDto getFileDataByClassNumber(Long classNo);
}
