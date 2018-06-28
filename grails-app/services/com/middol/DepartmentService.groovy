package com.middol

import com.midool.Department
import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class DepartmentService {
    //保存部门
    def saveDepartment(Object department) {
        Department department1 = new Department(department)
        println department as JSON
        department1.save(flush:true)
        if(department1.id){
            return ResultData.getSuccessData(department1)
        }
        return ResultData.getFailureData(null)
    }
    //删除部门
    def deleteDepartment(Integer departId){
        Department department1 = Department.get(departId)
        if(department1){
            if(!department1.positions.size()){
                department1.isDelete = '1'
                Department department2 = department1.save(flush:true)
                if(department2){
                    return ResultData.getSuccessData(department2)
                }
            }
        }
        return ResultData.getFailureData(null)
    }

    //修改部门信息
    def updateDepartment(department){
        println department as JSON
        String idStr = department.id
        Integer id = Integer.parseInt(idStr)
        Department department1 = Department.get(id)
        if(department1){
            department1.properties = department
            Department department2 = department1.save(flush:true)
            if(department2){
                return ResultData.getSuccessData(department2)
            }
        }
        return ResultData.getFailureData(null)
    }

    def queryAllDepartment(){
        return ResultData.getSuccessData(Department.findAllByIsDelete("0"))
    }

    def queryByDepartmentName(String departmentName){
        return ResultData.getSuccessData(Department.findAllByDepartmentNameAndIsDelete(departmentName,"0"))
    }


}
