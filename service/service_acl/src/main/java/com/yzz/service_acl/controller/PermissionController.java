package com.yzz.service_acl.controller;


import com.yzz.service_acl.entity.Permission;
import com.yzz.service_acl.service.PermissionService;
import com.yzz.commonutils.vo.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 权限 菜单管理
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@Api(tags = "admin_acl_permission服务")
@RestController
@RequestMapping("/admin/acl/permission")
//@CrossOrigin
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    //获取全部菜单
    @ApiOperation(value = "查询所有菜单")
    @GetMapping
    public ResultData indexAllPermission() {
        List<Permission> list =  permissionService.queryAllMenuGuli();
        return ResultData.success().data("children",list);
    }

    @ApiOperation(value = "递归删除菜单")
    @DeleteMapping("remove/{id}")
    public ResultData remove(@PathVariable String id) {
        permissionService.removeChildByIdGuli(id);
        return ResultData.success();
    }

    @ApiOperation(value = "给角色分配权限")
    @PostMapping("/doAssign")
    public ResultData doAssign(String roleId,String[] permissionId) {
        permissionService.saveRolePermissionRealtionShipGuli(roleId,permissionId);
        return ResultData.success();
    }

    @ApiOperation(value = "根据角色获取菜单")
    @GetMapping("toAssign/{roleId}")
    public ResultData toAssign(@PathVariable String roleId) {
        List<Permission> list = permissionService.selectAllMenu(roleId);
        return ResultData.success().data("children", list);
    }



    @ApiOperation(value = "新增菜单")
    @PostMapping("save")
    public ResultData save(@RequestBody Permission permission) {
        permissionService.save(permission);
        return ResultData.success();
    }

    @ApiOperation(value = "修改菜单")
    @PutMapping("update")
    public ResultData updateById(@RequestBody Permission permission) {
        permissionService.updateById(permission);
        return ResultData.success();
    }

}

