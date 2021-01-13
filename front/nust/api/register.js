import request from '@/utils/request'


    //根据手机号发验证码
export function  sendCode(phone) {
    return request({
      url: `/msm/MsmService/sendMsg?phoneNo=${phone}`,
      method: 'post'
    })
  }

  //注册的方法
export function  registerMember(formItem) {
    return request({
      url: `/ucenter/member/register`,
      method: 'post',
      data: formItem
    })
  }

