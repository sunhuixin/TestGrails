package com.middol

import grails.converters.JSON

class MenuController {

    def menuService

    def saveMenu() {
        def record = request.JSON ?: params
        println record as JSON
        render menuService.saveMenu(record) as JSON
    }

    def deleteMenu(){
        def record = request.JSON ?: params
        String menuIdStr = record.menuId
        Integer menuId = Integer.parseInt(menuIdStr)
        render menuService.deleteMenu(menuId) as JSON
    }

    def updateMenu(){
        def record = request.JSON ?: params
        println record as JSON
        render menuService.updateMenu(record) as JSON
    }

    def findAllMenu(){
        render menuService.queryAllMenu() as JSON
    }


}
