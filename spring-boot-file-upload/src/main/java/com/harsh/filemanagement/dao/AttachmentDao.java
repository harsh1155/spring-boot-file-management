package com.harsh.filemanagement.dao;

import com.harsh.filemanagement.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentDao extends JpaRepository<Attachment, String> {

}
