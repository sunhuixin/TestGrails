package com.midool

class Role {

    String roleName //角色名称
    String roleNo //角色编号
    String isDelete = '0'//是否删除,'0'-表示否，'1'-表示是String
    static belongsTo = User //从属用户
    static hasMany = [users : User , menus : Menu]


    static mapping = {
        version(false)
        id column: "role_id"
    }

    static constraints = {
        roleName size: 0..30,unique: true
        roleNo size: 0..30,unique: true
        isDelete size: 0..1,defaultValue:'0'
    }
}
