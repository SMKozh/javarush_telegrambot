package com.github.SMKozh.jrtb.service;

import com.github.SMKozh.jrtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.SMKozh.jrtb.repository.entity.GroupSub;

import java.util.Optional;

/**
 * Service for manipulating with {@link GroupSub}
 */
public interface GroupSubService {

    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);

    GroupSub save(GroupSub groupSub);

    Optional<GroupSub> findById(Integer id);
}
