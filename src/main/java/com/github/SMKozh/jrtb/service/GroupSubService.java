package com.github.SMKozh.jrtb.service;

import com.github.SMKozh.jrtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.SMKozh.jrtb.repository.entity.GroupSub;

/**
 * Service for manipulating with {@link GroupSub}
 */
public interface GroupSubService {

    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
}
