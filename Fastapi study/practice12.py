from fastapi import FastAPI, Query
from pydantic import BaseModel
from typing import List, Optional


app = FastAPI()

class Item(BaseModel):
    id: int
    name: str
    price: float
    category: str

class Item(BaseModel):
    id: int
    name: str
    price: float
    category: str

class Pagination(BaseModel):
    total: int
    page: int
    page_size: int
    total_pages: int

class ListResponse(BaseModel):
    status: str = "success"
    data: List[Item]
    pagination: Pagination

DB = [Item(id=i, name=f'Apple {i}', price=100.0*i, category='ipad' if i%
           2 == 0 else 'iphone') for i in range(1, 100)]

@app.get('/items1')
async def get_items1():
    return ["Apple1", "Apple2", "Apple3"]

@app.get('/items2')
async def get_items2():
    return DB

@app.get('/items3')
async def get_items3(category: Optional[str] = Query(None, description="分类")):
    filtered_items = DB
    if category:
        filtered_items = [item for item in DB if item.category == category]
    return filtered_items


@app.get('/items4')
async def get_items4(
    page: int = Query(1, ge=1, description="页码"),
    page_size: int = Query(10, ge=1, le=100, description="数量"),
    category: Optional[str] = Query(None, description="分类")
):
    # 对数据进行过滤 (Filter the data)
    filtered_items = DB
    if category:
        filtered_items = [item for item in DB if item.category == category]
    
    # 对数据进行分页 (Paginate the data)
    total = len(filtered_items)
    
    # 计算总页数 (Calculate total pages) - Note: Integer division is often used here.
    # The image shows floating point division, which works if you round up later.
    # In Python, we often use math.ceil for correct total page calculation.
    total_pages = (total + page_size - 1) // page_size 
    
    start = (page - 1) * page_size
    end = start + page_size
    
    # Return a slice of the filtered list
    return filtered_items[start:end]

    # ... (Lines 46-49 are incomplete/commented, suggesting alternative calculations)
    # total//page_size = count
    # total%page_size = remain if remain > 0 count+1
    # ...

@app.get('/items5')
async def get_items5(
    page: int = Query(1, ge=1, description="页码"),
    page_size: int = Query(10, ge=1, le=100, description="数量"),
    category: Optional[str] = Query(None, description="分类")
):
    # 对数据进行过滤 (Filter the data)
    filtered_items = DB
    if category:
        filtered_items = [item for item in DB if item.category == category]
    
    # 对数据进行分页 (Paginate the data)
    total = len(filtered_items)
    
    # 计算总页数 (Calculate total pages)
    # Using integer division to correctly calculate total pages (rounding up)
    total_pages = (total + page_size - 1) // page_size
    
    start = (page - 1) * page_size
    end = start + page_size
    
    # Return the structured ListResponse model
    return ListResponse(
        data=filtered_items[start:end],
        pagination=Pagination(
            total=total,
            page=page,
            page_size=page_size,
            total_pages=total_pages
        )
    )


if __name__ == '__main__':
    import uvicorn
    uvicorn.run(app='main16:app', host='127.0.0.1', port=8000, reload=True)