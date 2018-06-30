package com.midool

class Menu {
    Integer fatherId //菜单父id，一级菜单id为-1
    String menuName //菜单名称
    String menuPath //菜单路径
    String menuIcon //菜单图标路径
    String component //组件
    String isDelete //是否删除
    static belongsTo = Role //从属角色
    static hasMany = [roles:Role]

    static mapping = {
        version(false)
        id column: "menu_id"

    }

    static constraints = {
        fatherId size: 0..10,defaultValue:-1
        menuName size: 0..50,nullable: false
        menuPath size: 0..50,nullable: false
        menuIcon size: 0..50,nullable: false
        isDelete size: 0..1,defaultValue:"0"
        component size: 0..20


    }
}
