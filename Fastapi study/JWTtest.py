import requests

# --- 配置 ---
BASE_URL = "http://127.0.0.1:8000"  # 确保这与您的 FastAPI 应用运行的地址和端口匹配
ID_TOKEN = "YOUR_FIREBASE_ID_TOKEN"  # 在这里粘贴您从 HTML 文件中获取的令牌

def test_register():
    """测试 /register 端点。"""
    headers = {
        "Authorization": f"Bearer {ID_TOKEN}"
    }
    response = requests.post(f"{BASE_URL}/api/v1/users/register", headers=headers)
    
    print("--- Testing /register ---")
    print(f"Status Code: {response.status_code}")
    print(f"Response JSON: {response.json()}")
    print("-------------------------\n")
    return response

def test_get_me(token):
    """测试 /me 端点。"""
    headers = {
        "Authorization": f"Bearer {token}"
    }
    response = requests.get(f"{BASE_URL}/api/v1/users/me", headers=headers)

    print("--- Testing /me ---")
    print(f"Status Code: {response.status_code}")
    print(f"Response JSON: {response.json()}")
    print("---------------------\n")
    return response

if __name__ == "__main__":
    # 1. 运行 FastAPI 应用:
    #    在您的终端中，导航到 BackendApplication 目录并运行:
    #    uvicorn main:app --reload

    # 2. 运行测试脚本:
    #    在另一个终端中，运行这个 Python 脚本。

    # 首先，注册用户
    register_response = test_register()

    # 如果注册成功，使用相同的令牌获取用户信息
    if register_response.status_code == 200:
        test_get_me(ID_TOKEN)
