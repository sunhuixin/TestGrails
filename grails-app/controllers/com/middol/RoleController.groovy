package com.middol

import grails.converters.JSON

class RoleController {

    def roleService

    def saveRole(){
        def record = request.JSON ?: params
        println record
        render roleService.saveRole(record) as JSON
    }

    def deleteRole(){
        def record = request.JSON ?: params
        String roleIdStr = record.roleId
        Integer roleId = Integer.parseInt(roleIdStr)
        render roleService.deleteRole(roleId) as JSON
    }
    //跟新角色
    def updateRole(){
        def record = request.JSON ?: params
        println record as JSON
        render roleService.updateRole(record) as JSON
    }
    //查询所有的角色
    def findAllRole(){
        render roleService.queryAllRole() as JSON
    }
    //跟据角色名称查询
    def findByRoleName(){
        String roleName = params.roleName
        render roleService.queryByRoleName(roleName) as JSON
    }
    //配置角色和菜单信息
    def updateRoleMenus(){
        String roleIdStr = request.JSON.roleId
        Integer [] menuIds = request.JSON.menuIds
        if(CommonUtil.isStrEmpty(roleIdStr) || CommonUtil.isArrEmpty(menuIds)){
            render ResultData.getFailureData(null) as JSON
        }
        Integer roleId = Integer.parseInt(roleIdStr)
        render roleService.updateRoleMenus(roleId,menuIds) as JSON
    }
}
