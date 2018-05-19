package com.fb.hacks.server.group;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    void createGroup(GroupSaveDto groupSaveDto) {
        Group insertGroup = Group.builder()
                .id(generateIdFromInterests(groupSaveDto.getInterests()))
                .interests(groupSaveDto.getInterests())
                .members(groupSaveDto.getMembers())
                .build();
        groupRepository.save(insertGroup);
    }

    private String generateIdFromInterests(Set<String> interests) {
        return String.valueOf(interests.hashCode());
    }
}
