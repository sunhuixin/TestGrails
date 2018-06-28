package com.midool

class User {

    String userName //用户名
    String realName //真实姓名
    String password //密码
    String email //邮箱
    Department department //部门
    Position position //职位
    String isDelete = "0" //是否删除，'0'-表示否，'1'-表示是
    static hasMany = [roles:Role]



    static mapping = {
        version(false)
        id column: "user_id"
    }
    static constraints = {
        userName size: 0..50,blank: false,unique: true,nullable: true
        realName size: 0..20,blank:false,nullable: true
        password size: 0..50,blank:false,nullable: true
        email size: 0..30,blank:false,nullable: true
        isDelete size: 0..1, defaultValue: '0'
        department nullable: true
        position nullable: true

    }
}
