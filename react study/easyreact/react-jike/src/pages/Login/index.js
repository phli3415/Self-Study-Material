import './index.scss';
import { Card, Form, Input, Button } from 'antd';
import logo from '@/assets/logo.png';

const Login = () => {
  return (
    <div className="login">
      <Card className="login-container">
        <img className="login-logo" src={logo} alt="" />
        {/* 登录表单 */}
        <Form validateTrigger="onBlur">
          {/* validateTrigger="onBlur" 是 antd（Ant Design）表单组件中的一个属性，用于指定表单项何时触发验证。 */}
          <Form.Item
          name="mobile"
          // 后端将接收到的键值对的建
          rules={[
            {
              // rules 数组用于定义表单的规则
              required: true,
              // 表示该字段是必填的。
              message: '请输入手机号!',
            },
          ]}>
            <Input size="large" placeholder="请输入手机号" />
          </Form.Item>
          <Form.Item
          name="code"
          rules={[
            {
              required: true,
              message: '请输入验证码!',
            },
          ]}
          >
            <Input size="large" placeholder="请输入验证码" />
          </Form.Item>
          <Form.Item>
            <Button type="primary" htmlType="submit" size="large" block>
              登录
            </Button>
          </Form.Item>
        </Form>
      </Card>
    </div>
  );
};

export default Login;