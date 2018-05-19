package com.fb.hacks.server.group;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class GroupController {
    private final GroupService groupService;

    @PostMapping("group")
    ResponseEntity getMatches(@RequestBody GroupSaveDto groupSaveDto) {
        groupService.createGroup(groupSaveDto);
        return new ResponseEntity<>(CREATED);
    }
}
