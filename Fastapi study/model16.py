from tortoise.models import Model
from tortoise.fields import CharField, DatetimeField, BooleanField, TextField, DateField, IntField


class User(Model):
    id = CharField(max_length=32, pk=True)  # 主键, UUID 字符串
    username = CharField(max_length=64, unique=True)  # 用户名, 唯一
    email = CharField(max_length=255, unique=True)  # 邮箱, 唯一
    is_active = BooleanField(default=True)  # 是否激活
    age = IntField(default = 0)  # 年龄

    #创建时间
    created_at = DatetimeField(auto_now_add=True)  # 创建时间
    class Meta:
        table = "t_user"  # table/view:t/v
        unique_together =  [("username", "email")]  # 联合唯一
        oedering = ["-created_at"]  # -降序 默认升序

        #创建索引
        indexes = ['email']
 
    def __str__(self):
        return self.username