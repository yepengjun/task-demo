# task-demo
动态调度任务支持新增、修改、触发、停止、重启、删除等操作


├── task-dem0
│   ├── com   //启动整个项目的moudle
│         └── example
│              └── demo
│                    ├──aop //个人定义的写的自定义注解
│                    ├──api //swagger API 访问地址：http://localhost:8080/task/swagger-ui.html
│                    ├──config //定时任务的配置
│                    ├──controller //任务控制层
│                    ├──dao //对应mybatis xml的配置文件
│                    ├──entity //实体类
│                    ├──service //业务逻辑层
│                    ├──util //帮助类
│                    ├──需要执行的job //实体类
│                    └──DemoApplication.java //整个项目的启动类
│            └── resources
│            │     ├── application-local.properties  //开发环境
│            │     ├── application-prod.properties //生产环境
│            │     ├── application-test.properties //测试环境
│            │     ├── application.properties  //配置总文件
│            │     ├── quartz.properties  //定时任务配置文件
│            │     ├── mapper //mybatis的配置文件
│            │     ├── sql //建库文件
│   ── test //单元测试
       └── DemoApplicationTests  单元测试


启动说明
项目使用的数据库为MySql，选择table.sql文件初始化数据库信息。
在resources/application.properties文件中替换为自己的数据源。
在resources/quartz.properties文件中替换为自己的数据源。
运行Application main方法，启动项目。
API接口地址：http://localhost:8080/task/swagger-ui.html
DemoApplicationTests文件有单元测试方法