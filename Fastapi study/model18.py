# 关联关系建立1对1 (Establish 1-to-1 relationship)
from tortoise import fields, models,Tortoise, run_async

class Student(models.Model):
    id = fields.IntField(pk=True)
    name = fields.CharField(max_length=50)
    profile = fields.OneToOneField(
        "models.StudentProfile", on_delete=fields.CASCADE, related_name="student", null=True
    ) 

# ----------------------------------
# 概念数据表 (Conceptual Data Tables)
# ----------------------------------

# 学生表 (Student Table)
# id | name | profile_id | score_ids | score_id1 | score_id2 ...
# 1  | 张三 | 1          | 1-2-3-5-8-6-7 | 1         | 2
# 2  | 李四 | 2          | 4             |           |

# 成绩表 (Grade Table)
# id | score | stu_id
# 1  | 90    | 1
# 2  | 80    | 1
# 3  | 70    | 1
# 4  | 60    | 2
# 5  | 50    | 1
# ...

# ----------------------------------
# 模型定义 (Model Definitions)
# ----------------------------------

from tortoise import fields, models

class StudentProfile(models.Model):
    id = fields.IntField(pk=True)
    address = fields.CharField(max_length=100)
    phone = fields.CharField(max_length=20)

class Grade(models.Model):
    id = fields.IntField(pk=True)
    score = fields.FloatField()
    student = fields.ForeignKeyField(
        "models.Student", related_name="grades", on_delete=fields.CASCADE
    )


#多对多需要中间表链接
class Course(models.Model):
    id = fields.IntField(pk=True)
    name = fields.CharField(max_length=50)
    # students = fields.ManyToManyField(
    #     "models.Student", related_name="courses", through="student_course"
    # )

class StudentCourse(models.Model):
    students = fields.ForeignKeyField("models.Student", related_name="courses")
    courses = fields.ForeignKeyField("models.Course", related_name="students")

    class Meta:
        unique_together = ("students", "courses")

async def init():
    await Tortoise.init(
        db_url="mysql://root:123456@192.168.31.152:3306/fastapi_db",
        modules={"models": ["model18"]},
    )
    await Tortoise.generate_schemas()

if __name__ == "__main__":
    run_async(init())