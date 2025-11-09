from fastapi import FastAPI, Query, Path
from typing import Annotated
from pydantic import BeforeValidator
app = FastAPI()

@app.get('/items1/{item_id}')
def read_item1(item_id: int):
    return {'item_id': item_id}

@app.get('/items2/{item_id}')
def read_item2(item_id: int = Path(...)):
    return {'item_id': item_id}

@app.get('/items3/{item_id}')
def read_item3(item_id: int = Path(..., lt=100, gt=18)):
    return {'item_id': item_id}

@app.get('/items4/{item_id}')
def read_item4(item_id: str = Path(..., pattern=r'^a\d{2}$')):
    """
    regex or pattern
    """
    return {'item_id': item_id}


class ModelName(str, Enum):
    alexnet = 'alexnet'
    resnet = 'resnet'
    lenet = 'lenet'


@app.get('/items5/{model}')
def read_item5(model: ModelName):
    return {'model': model}

def validate(value):
    # The Chinese comment translates to: "Must start with 'P-'"
    if not value.startswith('P-'):
        raise ValueError('必须以P-开头')
    return value

# 创建带验证的类型别名
# Create a type alias with validation
Item = Annotated[str, BeforeValidator(validate)]

@app.get('/items6/{item_id}')
def read_item6(item_id: Item):
    return {'item_id': item_id}