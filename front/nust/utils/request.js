import axios from 'axios'
// 创建axios实例
const service = axios.create({
  // baseURL: 'http://192.168.160.4:9001', // api的base_url
  baseURL: 'http://192.168.23.3:9001', // api的base_url

  timeout: 20000 // 请求超时时间
})

service.interceptors.request.use(
  config => {
    if(Cookies.get('token')){
      config.headers['token'] = cookie.get('token');
    }
    return config
  },
  err => {
    return Promise.reject(err);
  }
)

export default service