package com.middol

import grails.converters.JSON

class DepartmentController {
    def departmentService

    def saveDepartment(){
        def record = request.JSON ?: params
        println record as JSON
        render departmentService.saveDepartment(record) as JSON
    }

    def deleteDepartment(){
        String idStr = params.id
        Integer id = Integer.parseInt(idStr)
        render departmentService.deleteDepartment(id) as JSON
    }

    def updateDepartment(){
        render departmentService.updateDepartment(params) as JSON
    }

    def findAllDepartment(){
        render departmentService.queryAllDepartment() as JSON
    }

    def findByDepartmentName() {
        String departName = params.departName
        render departmentService.queryByDepartmentName(departName) as JSON
    }
}
