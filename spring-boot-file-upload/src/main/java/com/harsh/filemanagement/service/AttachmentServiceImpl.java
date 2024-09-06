package com.harsh.filemanagement.service;

import com.harsh.filemanagement.dao.AttachmentDao;
import com.harsh.filemanagement.entity.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    private AttachmentDao attachmentDao;
    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains("..")){
                throw new Exception("File name contains invalid path sequence " + fileName);
            }
            Attachment attachment = new Attachment(fileName,file.getContentType(),file.getBytes());
            return attachmentDao.save(attachment);
        }catch (Exception e){
                 throw new Exception("Could not save file " +fileName);
        }


    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        return  attachmentDao.findById(fileId).orElseThrow(()-> new Exception("file not found with Id "+ fileId))
                ;

    }
}
