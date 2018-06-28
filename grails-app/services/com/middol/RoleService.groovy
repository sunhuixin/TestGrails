package com.middol

import com.midool.Menu
import com.midool.Role
import grails.gorm.transactions.Transactional

@Transactional
class RoleService {

    def saveRole(Object role){
        def role1 = new Role(role)
        role1.save(flush:true)
        if(role1.id){
            return ResultData.getSuccessData(role1)
        }
        return ResultData.getFailureData(null)

    }

    def deleteRole(Integer roleId){
        Role role = Role.get(roleId)
        if(role) {
            if(!role.users){
                role.isDelete = '1'
                Role role1 = role.save(flush: true)
                if(role1){
                    return ResultData.getSuccessData(role1)
                }
            }
        }
        return ResultData.getFailureData(null)
    }

    def updateRole(role){
        String roleIdStr = role.roleId
        Integer roleId = Integer.parseInt(roleIdStr)
        Role role1 = Role.get(roleId)
        if(role1){
            role1.properties = role
            Role role2 = role1.save(flush:true)
            if(role2){
                return ResultData.getSuccessData(role2)
            }
            return ResultData.getFailureData(null)
        }
    }

    def queryAllRole(){

        return ResultData.getSuccessData(Role.findAllByIsDelete('0'))
    }

    def queryByRoleName(String roleName) {
        return ResultData.getSuccessData(Role.findByRoleName(roleName))
    }

    def updateRoleMenus(Integer roleId,Integer [] menuIds){
        if(!CommonUtil.isNum(roleId)){
            return ResultData.getFailureData(null)
        }
        Role role1 = Role.findByIdAndIsDelete(roleId,"0")
        if(role1){
            def menuList = []
            menuIds.each {
                String idStr = it
                Integer id = Integer.parseInt(idStr)
                menuList.add(Menu.get(id))
            }
            role1.menus = menuList
            Role role2 = role1.save(flush:true)
            if(role2){
                return ResultData.getSuccessData(role2)
            }
        }
        return ResultData.getFailureData(null)

    }

}
