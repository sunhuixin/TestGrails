package com.middol

import com.midool.Menu
import grails.gorm.transactions.Transactional

@Transactional
class MenuService {

    def saveMenu(Object menu){
        def menu1 = new Menu(menu)
        menu1.save(flush:true)
        if(menu1.id){
            return ResultData.getSuccessData(menu1)
        }
        return ResultData.getSuccessData(null)
    }

    def deleteMenu(Integer menuId){
        Menu menu1 = Menu.get(menuId)
        if(menu1){
            if(!Menu.findAllByFatherId(menu1.id)){
                menu1.isDelete = "1"
                Menu menu2 = menu1.save(flush:true)
                if(menu2){
                    return ResultData.getSuccessData(menu1)
                }
            }
        }
        return ResultData.getFailureData(null)

    }
    //更新菜单
    def updateMenu(menu){
        String menuIdStr = menu.menuId
        Integer menuId = Integer.parseInt(menuIdStr)
        Menu menu1 = Menu.get(menuId)
        if(menu1){
            menu1.properties = menu
            Menu menu2 = menu1.save(flush:true)
            if(menu2){
                return ResultData.getSuccessData(menu2)
            }
        }
        return ResultData.getFailureData(null)
    }
    //查询所有的菜单
    def queryAllMenu() {
        List<Menu> menus = Menu.findAllByIsDelete("0")
       return ResultData.getSuccessData(getChildren(-1,menus))
    }

    //查询所有的子菜单
    def getChildren = { id ,menuList ->
        def result = []
        menuList.each { menuItem ->
            if (id==menuItem.fatherId){
                def menuTemp = [:]
                menuTemp.id = menuItem.id
                menuTemp.label = menuItem.menuName
                menuTemp.path = menuItem.menuPath
                menuTemp.icon = menuItem.menuIcon
                menuTemp.fatherId = menuItem.fatherId
                menuTemp.children = getChildren(menuItem.id,menuList)
                result.add(menuTemp)
            }
        }
        return result
    }

}
