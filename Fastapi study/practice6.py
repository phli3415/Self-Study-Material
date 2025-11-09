from fastapi import FastAPI, Query

app = FastAPI()


@app.get("/items1")
def read_item1(item_id: str = Query("123")):
    return {"item_id": item_id}

# 2. Required Query Parameter using Ellipsis (...)
@app.get("/items2")
def read_item2(item_id: str = Query(...)):
    # """必须传递 (Must be passed)"""
    return {"item_id": item_id}

# 3. Required Query Parameter with validation constraints
@app.get("/items3")
def read_item3(item_id: str = Query(..., min_length=3, max_length=6)):
    # """必须传递, 限制内容长度 (Must be passed, restrict content length)"""
    return {"item_id": item_id}

# 1. Numeric Validation (Greater Than, Less Than)
@app.get("/items4")
def read_item4(item_id: int = Query(..., gt=0, lt=100)):
    # """必须传递, 限制内容大小 (Must be passed, restrict content size)"""
    return {"item_id": item_id}

# 2. Field Alias (Mapping a function parameter name to a different query parameter name)
@app.get("/items5")
def read_item5(item_id: int = Query(..., alias='id')):
    # """必须传递, 修改名称 (Must be passed, modify name)"""
    return {"item_id": item_id}

# 3. Adding a Description for Documentation
@app.get("/items6")
def read_item6(item_id: int = Query(..., description="这个字段是来筛选产品的ID")):
    # """必须传递, 说明 (Must be passed, description)"""
    return {"item_id": item_id}