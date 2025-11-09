from tortoise.models import Model
from tortoise.fields import CharField, DatetimeField, BooleanField

class User(Model):
    id = CharField(max_length=36, pk=True)  # 主键, UUID 字符串
    username = CharField(max_length=50, unique=True)  # 用户名, 唯一
    email = CharField(max_length=255, unique=True)  # 邮箱, 唯一
    is_active = BooleanField(default=True)  # 是否激活
    created_at = DatetimeField(auto_now_add=True)  # 创建时间
    updated_at = DatetimeField(auto_now=True)  # 更新时间

    class Meta:
        table = "users"  # 自定义表名
        ordering = ["-created_at"]  # 默认按创建时间降序排序

    def __str__(self):
        return self.username
    


# 自定义限制
# from tortoise.validators import Validator

# def validate_credit(value):
#     if value < 0:
#         raise ValueError("信用值不能为负数")

# class User(Model):
#     # Note: 'Model' and 'fields' must be imported for this code to run
#     credit = fields.IntField(validators=[validate_credit])  # 自定义验证函数


# 模型元数据 (Meta 类)

# Meta 类用于定义模型的元数据, 控制表结构和查询行为。常用属性包括:

# * table: 自定义数据库表名 (如 table="users")
# * unique_together: 定义联合唯一约束 (如 unique_together=[("field1", "field2")])
# * indexes: 定义索引 (如 indexes=[("field1", "field2")])
# * ordering: 默认排序规则 (如 ordering=["-created_at", "username"])

# class Event(Model):
#     name = CharField(max_length=100)
#     location = CharField(max_length=200)
#     date = DateField()

#     class Meta:
#         table = "events"
#         unique_together = [("name", "date")]  # 名称和日期联合唯一
#         indexes = [("location",)]  # 为 location 字段创建索引
#         ordering = ["date"]  # 按日期升序排序