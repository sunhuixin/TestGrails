package com.middol

import org.slf4j.LoggerFactory
import java.sql.Date
import java.util.logging.Logger

 class JWT_TokenUtil {
     private static final  SECRET = "middol"
     private static final EXPIRE_TIME = 60*60*1000
     private static Logger logger = LoggerFactory.getLogger(JWT_TokenUtil.class)

     /**
      * 生成token
      * @param userName,password
      * @return token
      */
     static createToken(String userName,String password){
         Date expireTime = new Date(System.currentTimeMillis() + EXPIRE_TIME)
         def header = [:]
         header.put("typ","JWT")
         header.put("alg","HS256")
     }


 }
