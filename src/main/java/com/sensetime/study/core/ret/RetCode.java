package com.sensetime.study.core.ret;

public enum RetCode {

   // 成功
   SUCCESS(200),

   // 失败
   FAIL(400),

   // 未认证（签名错误）
   UNAUTHORIZED(401),

   /** 未登录 */
   UNAUTHEN(4401),

   /** 未授权，拒绝访问 */
   UNAUTHZ(4403),

   // 服务器内部错误
   INTERNAL_SERVER_ERROR(500), 
   
   //接口找不到
   NOT_FOUND(201);

   public int code;

   RetCode(int code) {
      this.code = code;
   }
}