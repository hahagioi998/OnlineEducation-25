import request from '@/utils/request'

export function getHotCourse(){
    return request({
        url: `/edu/IndexController/queryHotCourse`,
        method: 'get'
    })
}

export function getHotTeacher(){
    return request({
        url: `/edu/IndexController/queryHotTeacher`,
        method: 'get'
    })
}