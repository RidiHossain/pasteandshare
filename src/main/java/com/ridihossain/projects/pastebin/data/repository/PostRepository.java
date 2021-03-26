package com.ridihossain.projects.pastebin.data.repository;

import com.ridihossain.projects.pastebin.data.entity.POST;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<POST, String> {


}
