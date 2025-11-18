from model17 import Student
from tortoise import Tortoise
import asyncio


async def create_student(name: str, age: int = None, email: str = None) -> Student:
    """
    创建一个新的学生记录.
    """
    try:
        student = await Student.create(name=name, age=age, email=email)
        return student
    except Exception as e:
        print(f"创建学生失败: {e}")
        

async def update_student(stu_id: int, name: str = None, age: int = None, email: str = None) -> Student:
    stu = await Student.get(id=stu_id)
    # 判断用户传递了哪个数据, 如果没有传递, 就不更新
    if name:
        stu.name = name
    if age is not None:
        stu.age = age
    if email is not None:
        stu.email = email
    
    # 保存
    await stu.save()
    
    return stu

async def delete_student(stu_id: int) -> None:
    stu = await Student.get(id=stu_id)
    await stu.delete()

async def get_student(stu_id: int) -> Student:
    stu = await Student.get(id=stu_id)
    return stu
# 多条数据

async def get_students(name: str) -> list[Student]:
    # 完成匹配
    # ...
    stus = await Student.filter(name=name)
    return stus

async def get_students2(name: str) -> list[Student]:
    # ...
    # 模糊查询
    stus = await Student.filter(name__contains=name)
    return stus

async def get_students3() -> list[Student]:
    # ...
    # 获取所有数据 (Get all data)
    # ...
    stus = await Student.all()
    return stus


# 1. 直接测试脚本
# 2. 直接应用到接口

async def init():
    await Tortoise.init(
        db_url="mysql://root:mn76wdwv@localhost:3306/fastapi_db",
        modules={"models": ["model17"]}
    )

    #await Tortoise.generate_schemas()

async def main():
    await init()
    # stu1 = await create_student(name="曹操")
    # print(f"创建成功 ID:{stu1.id} Name:{stu1.name} Email:{stu1.email}")
    # stu2 = await create_student(name="刘备", age=30)
    # print(f"创建成功 ID:{stu2.id} Name:{stu2.name} Email:{stu2.email}")
    # stu3 = await create_student(name="张飞", age=30, email="zf@163.com")
    # print(f"创建成功 ID:{stu3.id} Name:{stu3.name} Email:{stu3.email}")
    # stu4 = await create_student(name="关羽", age=30, email="zf@163.com")
    # print(f"创建成功 ID:{stu4.id} Name:{stu4.name} Email:{stu4.email}")


    # await update_student(stu_id=3, age=36)
    # await update_student(stu_id=1, email="cc@qq.com", age=40)
    # await delete_student(stu_id=9)

    stu = await get_student(3)
    print(stu)
    stus1 = await get_students("刘备")
    print(stus1)
    stus2 = await get_students2("曹")
    print(stus2)
    stus3 = await get_students3()
    print(stus3)


#This code clearly shows how to handle the result of `create_student` and use f-strings to log the new student's **ID**, **Name**, and **Email**.

if __name__ == "__main__":
    asyncio.run(main())