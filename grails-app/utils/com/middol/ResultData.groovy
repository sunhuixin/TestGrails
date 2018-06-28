package com.middol

class ResultData {

    String code
    String message
    Object data

    static getSuccessData(Object data){
        def resultData = [code:"200",message:"SUCCESS!",data:data]
        return resultData
    }
    static getFailureData(Object data){
        def resultData = [code:"204",message:"FAILURE!",data:data]
        return resultData
    }


}
