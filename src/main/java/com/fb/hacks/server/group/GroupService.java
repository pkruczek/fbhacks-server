package com.fb.hacks.server.group;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    void createGroup(GroupSaveDto groupSaveDto) {
        Group insertGroup = new Group(generateIdFromInterests(groupSaveDto.getInterests()), groupSaveDto.getInterests(), groupSaveDto.getMembers());
        groupRepository.save(insertGroup);
    }

    private String generateIdFromInterests(Set<String> interests) {
        return String.valueOf(interests.hashCode());
    }
}
