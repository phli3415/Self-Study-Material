# main03.py > path_args3
# 路径参数
from fastapi import FastAPI

app = FastAPI()

@app.get("/args1/1")
def path_args1():
    return {"message": "id1"}

@app.get("/args2/{id}")
def path_args2(id):
    return {"message": id}

@app.get("/args3/{id}")
def path_args3(id):
    return {"message2": id}

@app.get("/args4/{id}/{name}")
def path_args4(id: int, name):
    return {"message": id, "name": name}