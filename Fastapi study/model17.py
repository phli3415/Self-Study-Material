from tortoise import fields, models

class Student(models.Model):
    """
    学生模型, 包含基本信息.
    用于演示简单的增删改查操作.
    """
    # Student ID (Primary Key)
    id = fields.IntField(pk=True, description="学生ID,主键")
    
    # Student Name
    name = fields.CharField(max_length=50, description="学生姓名")
    
    # Student Age (Nullable)
    age = fields.IntField(null=True, description="学生年龄,可为空")
    
    # Student Email (Unique and Nullable)
    email = fields.CharField(max_length=100, unique=True,
                             null=True, description="学生邮箱,唯一")

    class Meta:
        # Specifies the database table name
        table = "students"

    def __str__(self):
        # Returns a user-friendly string representation of the object
        return f"Student: {{self.name}}, Age: {{self.age}}, Email: {{self.email}}"