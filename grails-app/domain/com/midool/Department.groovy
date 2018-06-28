package com.midool

class Department {
    String departmentName
    String isDelete = "0" //是否删除 '0'-表示否，'1'-表示是
    static hasMany = [positions:Position]
    static mapping = {
        version(false)

    }
    static constraints = {
        departmentName size: 0..30,blank:false
        isDelete size: 0..1,defaultValue:'0'
    }
}
