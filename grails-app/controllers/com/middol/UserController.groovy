package com.middol

import grails.converters.JSON

class UserController {
    def userService

    def saveUser(){
        def record = request.JSON ?: params
        println request.JSON
        println params
        render userService.saveUser(record) as JSON

    }

    def deleteUser(){
        def record = request.JSON ?: params
        String id = record.userId
        def userId = Integer.parseInt(id)
        render userService.deleteUser(userId) as JSON
    }

    def findAllUser(){
        render userService.queryAll() as JSON
    }

    def findOne(){
        String userName = params.userName
        render userService.queryByUserName(userName) as JSON
    }

    def updateUser(){
        def record = request.JSON ?: params
        println "params="+(record as JSON)
        render userService.updateUser(record) as JSON
    }

    def findLikeUserName(){
        String userName = params.userName
        render userService.queryLikeUserName(userName) as JSON
    }

    def updateUserRoles(){
        String userIdStr = request.JSON.userId
        Integer [] roleIds = request.JSON.roles
        if(CommonUtil.isStrEmpty(userIdStr) || CommonUtil.isArrEmpty(roleIds)){
            render ResultData.getFailureData(null) as JSON
        }
        Integer userId = Integer.parseInt(userIdStr)
        render userService.updateUserRole(userId,roleIds) as JSON
    }

    def login(){
        def record = request.JSON ?: params
        String userName = record.userName
        String password = record.password
        render userService.queryByUserNameAndPassword(userName,password) as JSON
    }
}
