# main06.py > read_item3
from typing import Union, Optional, List
from fastapi import FastAPI

app = FastAPI()

# 1. Path parameter type-hinted as 'int'
@app.get('/items1/{item_id}')
def read_item1(item_id: int):
    return {'item_id': item_id}

# 2. Path parameter type-hinted as 'str'
@app.get('/items2/{item_id}')
def read_item2(item_id: str):
    return {'item_id': item_id}

# 3. Path parameter type-hinted as 'Union[str, int]'
@app.get('/items3/{item_id}')
def read_item3(item_id: Union[str, int]):
    return {'item_id': item_id}


# 1. Path Parameter with Default Value (Attempted)
@app.get('/items4/{item_id}')
# Path parameters cannot have default values because they are required by the path structure.
# The default value '= 110' here is incorrect for a path parameter.
def read_item4(item_id: Union[str, int] = 110):
    # 'This cannot use default parameters' (referring to path parameters)
    return {'item_id': item_id}

# 2. Query Parameter: Optional, defaults to None
@app.get('/items5')
def read_item5(item_id: Union[int, None] = None):
    return {'item_id': item_id}

# 3. Query Parameter: Optional using Optional[] (Shorthand for Union[T, None])
@app.get('/items6')
def read_item6(item_id: Optional[int] = None):
    # 'This Optional is shorthand for Union[T, None]'
    return {'item_id': item_id}

# 4. Query Parameter: Optional using just a default value (FastAPI infers Optional)
@app.get('/items7')
def read_item7(item_ids = None):
    # If a parameter has a default value, FastAPI automatically treats it as optional.
    # Note: The type hint is missing here, making it a simple optional string/None.
    return {'item_ids': item_ids}

@app.get('/items8')
def read_item7(item_ids: List):
    return {'item_id': item_ids}

if __name__ == '__main__':
    import uvicorn
    uvicorn.run('main06:app', host="127.0.0.1", port=8000, reload=True)