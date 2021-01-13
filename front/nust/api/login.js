import request from '@/utils/request'


    //登录的方法
export function submitLoginUser(userInfo) {
return request({
    url: `/ucenter/member/loginIn`,
    method: 'post',
    data: userInfo
})
}

//根据token获取用户信息
export function getLoginUserInfo() {
return request({
    url: `/ucenter/member/getInfoByToken`,
    method: 'get'
})
}

