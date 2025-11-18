# 关联关系的增删改查
from tortoise import Tortoise, run_async
from model18 import Student, Course, StudentCourse, Grade, StudentProfile




async def init():
    await Tortoise.init(
        db_url="mysql://root:123456@192.168.31.152:3306/fastapi_db4",
        modules={"models": ["model24"]}
    )

async def create_data():
    await init()

    # 1对1 (One-to-One)
    stu1 = await Student.create(name="董卓")
    pro1 = await StudentProfile.create(address="上海", phone="123456")
    stu1.profile = pro1
    #手动更改需要save
    await stu1.save()

    pro2 = await StudentProfile.create(address="北京", phone="123456")
    stu2 = await Student.create(name="刘备", profile=pro2)

    # 1对多 (One-to-Many)
    # 多对多 (Many-to-Many)

    stu3 = await Student.create(name="孙权")
    await Grade.create(score=100, student=stu3)
    await Grade.create(score=90, student=stu3)
    await Grade.create(score=80, student=stu3)

    # 多对多 (Many-to-Many)
    stu4 = await Student.create(name="关羽")
    stu5 = await Student.create(name="张飞")
    cou1 = await Course.create(name="Python")
    cou2 = await Course.create(name="C++")

    await StudentCourse.create(students=stu4, courses=cou1)
    await StudentCourse.create(students=stu4, courses=cou2)
    await StudentCourse.create(students=stu5, courses=cou1)
    await StudentCourse.create(students=stu5, courses=cou2)

async def update_data():
    await init()
    # 1对1 (One-to-One Update/Creation)
    stu = await Student.get(id=1)
    pro = await StudentProfile.create(address="上海", phone="12345678901")
    stu.profile = pro
    await stu.save()

    # 1对多 (One-to-Many Update)
    stu2 = await Student.get(id=1)
    grade1 = await Grade.get(id=1)
    grade1.student = stu2
    await grade1.save()

    await Grade.filter(id=6).update(student=stu2)

async def query_data():
    await init()
    stu = await Student.get(id=1)
    print(stu.name)
    pro = await stu.profile
    print(pro.address)
    print(pro.phone)

    stu3 = await Student.get(id=9).prefetch_related('grades').all()
    for grade in stu3.grades:
     print(grade.score)

async def delete_data():
    await init()

    # grade = await Grade.get(id=9)
    # await grade.delete()

    stu = await Student.get(id=9)
    await stu.delete()

if __name__ == '__main__':
    run_async()