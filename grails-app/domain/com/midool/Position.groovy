package com.midool

class Position {
    String positionName
    String isDelete = "0"
    Department depart
    static mapping = {
        version(false)
    }

    static constraints = {
        positionName size: 0..30,blank:false
        isDelete size: 0..1,defaultValue:'0'
        depart nullable: true
    }
}
