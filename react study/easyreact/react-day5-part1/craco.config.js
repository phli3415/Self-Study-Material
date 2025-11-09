const path = require('path');

module.exports = {
  webpack: {
    alias: {
      '@': path.resolve(__dirname, 'src'),
      // 如果需要添加更多别名，请在此处添加
    },
  },
};