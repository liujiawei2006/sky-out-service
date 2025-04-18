# SkyTakeOut-Springboot
大一新手第一个练手项目
技术栈：Spring Boot 2.7 + MySQL 8.0 + Redis 6 + RabbitMQ 3.9 + Nginx  

  项目亮点  
  - 基于Redis缓存优化菜品查询接口，QPS提升40%  
  - 使用RabbitMQ实现订单超时自动取消，降低数据库压力  
  - Nginx反向代理+负载均衡部署，支持多实例扩展  

  核心功能  
  - 用户端：   
    - 微信登录、购物车、订单支付（模拟）  
  - 管理端：  
    - 菜品管理、订单统计、配送状态推送  

  src/  
  ├── main/  
  │   ├── java/com/skytakeout/  
  │   │   ├── controller   # API接口层  
  │   │   ├── service     # 业务逻辑层  
  │   │   └── config      # Redis/MQ配置类  
  │   └── resources/      # SQL脚本、配置文件  
  └── sql/                # 数据库表结构  
