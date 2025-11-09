# main05.py > user
# 请求体 传参数 (Request Body Parameter)
from fastapi import FastAPI
from pydantic import BaseModel
# Note: In Python 3.9+, 'str | None' can be used for optional/nullable types.

app = FastAPI()

# 1. Define the Request Body Structure using Pydantic BaseModel
class User(BaseModel):
    name: str
    age: int
    # Optional field: must be a string or None (null).
    pwd: str | None
    sex: str = "男"

# 2. Define the POST endpoint to receive the request body
@app.post('/users')
def create_user(user: User):
    # FastAPI automatically converts the JSON body into an instance of the 'User' class.
    # The return value is also automatically converted back to JSON.
    return user

@app.post('/users2')
def create_user2(user: User):
    return user

# 3. Standard Uvicorn run command
if __name__ == '__main__':
    import uvicorn
    uvicorn.run('main05:app', host='127.0.0.1', port=8000, reload=True)