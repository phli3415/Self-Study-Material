# main04.py > page_limit2
# 查询参数 (Query Parameters)
from fastapi import FastAPI
# (Note: `None` is a built-in Python constant and doesn't need to be imported)

app = FastAPI()

# Endpoint 1: Both 'page' and 'limit' are required query parameters
@app.get("/query1")
def page_limit(page, limit):
    """
    Handles a request expecting two required query parameters: 'page' and 'limit'.
    Example URL: /query1?page=1&limit=10
    """
    return {"page": page, "limit": limit}

# Endpoint 2: 'page' is required (with type hint), 'limit' is optional (with default value None)
@app.get("/query2")
def page_limit2(page: int, limit=None):
    """
    Handles a request where 'page' is required (and expected to be an integer),
    and 'limit' is optional (defaulting to None).

    - Example 1 (required only): /query2?page=5
    - Example 2 (both provided): /query2?page=5&limit=20
    """
    if limit:
        # This branch executes if 'limit' was provided in the query string
        return {"page": page, "limit": limit}
    # This branch executes if 'limit' was NOT provided (it remains None)
    return {"page": page}

@app.get("/query3/{page}")
def page_limit3(page: int, limit=None):
    if limit:
        return {"page": page, "limit": limit}
    return {"page": page}

# Standard way to run the application using uvicorn
if __name__ == '__main__':
    import uvicorn
    uvicorn.run('main04:app', host='127.0.0.1', port=8000, reload=True)