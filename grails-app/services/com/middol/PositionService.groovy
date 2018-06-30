package com.middol

import com.midool.Department
import com.midool.Position
import grails.converters.JSON
import grails.gorm.transactions.Transactional

@Transactional
class PositionService {

    def savePosition(position){
        println position as JSON
        String idStr = position.departId
        println 11111111111111
        Integer id = Integer.parseInt(idStr)
        def position1 = new Position(positionName:position.positionName,depart:Department.findByIdAndIsDelete(id,"0"))
        println position1 as JSON
        position1.save(flush:true)
        if(position1.id){
            return ResultData.getSuccessData(position1)
        }
        return ResultData.getFailureData(null)
    }

    def deletePosition(Integer positionId){
        Position position = Position.get(positionId)
        if(position){
            position.isDelete = "1"
            Position position1 = position.save(flush:true)
            if(position1){
                return ResultData.getSuccessData(position1)
            }
        }
        return ResultData.getFailureData(null)
    }

    def updatePosition(position){
        println position as JSON
        String idStr = position.id
        Integer id = Integer.parseInt(idStr)
        Position position1 = Position.findByIdAndIsDelete(id,"0")
        if(position1){
            position1.properties = position
            Position position2 = position1.save(flush:true)
            if(position2){
                return ResultData.getSuccessData(position2)
            }
        }
        return ResultData.getFailureData(null)
    }

    def queryAllPosition() {
        return ResultData.getSuccessData(Position.findAllByIsDelete("0"))

    }

    def queryByDepartment(department){
        String idStr = department.id
        Integer id = Integer.parseInt(idStr)
        def depart =Department.findByIdAndIsDelete(id,"0")
        return ResultData.getSuccessData(Position.findAllByDepartAndIsDelete(depart,"0"))

    }
}
