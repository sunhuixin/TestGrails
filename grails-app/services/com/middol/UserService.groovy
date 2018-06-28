package com.middol

import com.midool.Role
import com.midool.User
import grails.gorm.transactions.Transactional



@Transactional
class UserService {
    //保存用户
    def saveUser(Object user) {
        def user1 = new User(user)
        user1.password = CommonUtil.getMD5(user1.password)
        User user2 = user1.save(flush:true)
        if(user2){
            return ResultData.getSuccessData(user1)
        }
        return ResultData.getFailureData(null)
    }
    //删除用户
    def deleteUser(Integer userId){
        User user = User.get(userId)
        if (user){
            def roles = []
            user.roles = roles
            user.isDelete = '1'
            User user1 = user.save(flush:true)
            if(user1){
                return ResultData.getSuccessData(null)
            }
        }
        return ResultData.getFailureData(null)
    }
    //查询所有用户
    def queryAll(){
        return ResultData.getSuccessData(User.findAllByIsDelete("0"))
    }
    //更新用户
    def updateUser(user){
        String userIdStr = user.userId
        Integer userId = Integer.parseInt(userIdStr)
        User user1 = User.findById(userId)
        if(user1){
            user1.properties = user
            User user2 = user1.save(flush:true)
            if(user2){
                return ResultData.getSuccessData(user2)
            }
        }
        return ResultData.getFailureData(null)
    }
    //跟据用户名查询用户
    def queryByUserName(String userName){
        return ResultData.getSuccessData(User.findByUserName(userName))
    }
    //跟据用户名模糊查询用户
    def queryLikeUserName(String userName){
        return ResultData.getSuccessData(User.findAllByUserNameIlike('%'+userName+'%'))
    }
    //更新用户角色信息
    def updateUserRole(Integer userId, Integer [] roleIds){
        if(!CommonUtil.isNum(userId)){
            return ResultData.getFailureData(null)
        }
        User user1 = User.findById(userId)
        if(user1){
            def roleList =[]
            roleIds.each{
                String itStr = it
                Integer id = Integer.parseInt(itStr)
                roleList.add Role.get(id)
            }
            user1.roles = roleList
            User user2 = user1.save(flush:true)
            if(user2){
                return ResultData.getSuccessData(user2)
            }
        }
        return ResultData.getFailureData(null)

    }

    def queryByUserNameAndPassword(String userName,String password){
        return ResultData.getSuccessData(User.findByUserNameAndPasswordAndIsDelete(userName,password,"0"))

    }

}
