from fastapi import FastAPI
from pydantic import BaseModel
from typing import Union, TypeVar, Generic

app = FastAPI()

class Item(BaseModel):
    id: int
    name: str
    tags: list[str] = []

@app.get('/items/dict')
async def get_items_dict():
    return {"name": "张三", "age": 18}

@app.get('/items/model')
async def get_items_model():
    return Item(id=2, name="iPhone")

@app.get('/items/model2', response_model=Item, response_model_exclude_unset=True)
async def get_items_model2():
    return Item(id=2, name="iPhone")


# 定义泛型模型 (Define Generic Model)
T = TypeVar('T')

class SuccessResponse(BaseModel, Generic[T]):
    status: str = 'success'
    data: T

class ErrorResponse(BaseModel):
    status: str = 'error'
    message: str
    code: int

@app.get('/items/{item_id}', response_model=Union[SuccessResponse[Item], ErrorResponse])
async def get_items_model3(item_id: int):
    if item_id == 1:
        item = Item(id=1, name="iPhone", tags=["red", "black"])
        return SuccessResponse[Item](data=item)
    else:
        # "Item没有找到" means "Item not found"
        return ErrorResponse(message="Item没有找到", code=404)

if __name__ == '__main__':
    import uvicorn
    uvicorn.run(app='main15:app', host='127.0.0.1', port=8000, reload=True)