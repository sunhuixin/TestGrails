package com.middol

import grails.converters.JSON

class PositionController{

    def positionService

    def savePosition(){

        def record = request.JSON ?: params
        render positionService.savePosition(record) as JSON
    }

    def deletePosition() {
        String idStr = params.id
        Integer id = Integer.parseInt(idStr)
        render positionService.deletePosition(id) as JSON
    }

    def updatePosition(){
        def record = request.JSON ?: params
        render positionService.updatePosition(record) as JSON
    }

    def findAllPosition(){
        render positionService.queryAllPosition() as JSON
    }

    def findByDepartment(){
        def record = request.JSON ?: JSON
        println record as JSON
        render positionService.queryByDepartment(record) as JSON
    }

}
