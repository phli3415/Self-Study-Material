from fastapi import FastAPI
from typing import Dict

app=FastAPI()   

# Tortoise-ORM 配置
TORTOISE_ORM: Dict = {
    "connections": {
        # 开发环境使用 SQLite (基于文件, 无需服务器)
        #"default": "sqlite://db.sqlite3",
        # 生产环境示例: PostgreSQL
        # "default": "postgres://user:password@localhost:5432/dbname",
        # 生产环境示例: MySQL
        "default": "mysql://root:mn76wdwv@localhost:3306/fastapi_db",
    },
    "apps": {
        "models": {
            "models": ["model16","aerich.models"],  # 模型模块和 Aerich
            "default_connection": "default",
        },
    },
    # 连接池 (推荐)
    "use_tz": False,  # 是否使用时区
    "timezone": "UTC",  # 默认时区
    "db_pool": {
        "max_size": 10,  # 最大连接数
        "min_size": 1,  # 最小连接数
        "idle_timeout": 30  # 空闲连接超时 (秒)
    }
}

from tortoise.contrib.fastapi import register_tortoise

register_tortoise(app, 
                  config=TORTOISE_ORM, 
                  generate_schemas=True, #开发环境自动生成表结构
                  add_exception_handlers=True)#添加默认异常处理器


'''
terminal 里面运行 aerich init -t practice15.TORTOISE_ORM# 初始化 Aerich 配置文件
aerich init-db # 创建初始迁移并应用, 创建表结构
aerich migrate --name "注释" # 创建新的迁移
aerich upgrade # 应用最新的迁移
'''