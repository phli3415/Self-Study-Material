# 表单数据 (Form Data)
# 安装 pip install python-multipart==0.0.20
from fastapi import FastAPI, Form
from pydantic import BaseModel

#Form, 和json差不多，淘汰了

app = FastAPI()

# --- Endpoint 1: Explicit Form Data Handling ---
@app.post('/login1')
def login1(username: str = Form(...), password: str = Form(...)):
    return {'username': username, 'password': password}

# --- Pydantic Model for JSON Data ---
class User1(BaseModel):
    username: str
    password: str

# --- Endpoint 2: JSON Data Handling (Request Body) ---
@app.post('/login2')
def login2(user: User1):
    return user


