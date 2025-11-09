# main.py

from fastapi import FastAPI
from fastapi.responses import HTMLResponse, RedirectResponse, StaticFiles

app = FastAPI()

@app.get('/string1')
async def get_string1():
    return "Hello World" # Content-Type: text/plain

@app.get('/string2')
async def get_string2():
    return '<h1>Hello</h1>'

#html渲染
@app.get('/string3', response_class=HTMLResponse)
async def get_string3():
    return '<h1>Hello</h1>'

@app.get('/redirect1')
async def get_redirect1():
    return RedirectResponse(url='/string1')

@app.get('/items')
async def get_items(name: str):
    return {'name': name}

@app.get('/redirect2')
async def get_redirect2():
    return RedirectResponse(url='/items?name=Jack')

# 挂载在HTML目录 (Mount HTML Directory)
app.mount('/html', StaticFiles(directory='templates', html=True))

# Example: If templates/page.html exists, 
# it's accessible at http://server/html/page.html.

app.mount('/static', StaticFiles(directory='static'))

if __name__ == '__main__':
    import uvicorn
    uvicorn.run(app='main:app', host='127.0.0.1', port=8000, reload=True)