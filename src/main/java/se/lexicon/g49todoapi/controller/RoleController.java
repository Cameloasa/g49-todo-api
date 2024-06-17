package se.lexicon.g49todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.g49todoapi.domanin.dto.RoleDTOView;
import se.lexicon.g49todoapi.service.RoleService;

import java.util.List;
@RequestMapping("api/v1/roles")
@RestController
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping
    public ResponseEntity<List<RoleDTOView>>doGetAllRoles(){
        List<RoleDTOView> responseBody = roleService.getAll();
        return ResponseEntity.ok(responseBody);

    }
}