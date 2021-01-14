import request from '@/utils/request'


//分页查询讲师
export function selectTPage(current, pageSize) {
return request({
    url: `/edu/teacherService/selectTPage/${current}/${pageSize}`,
    method: 'get'
})
}

//根据token获取用户信息
export function queryTById(teacherId) {
return request({
    url: `/edu/teacherFrontService/queryTInfoCInfo?teacherId=${teacherId}`,
    method: 'get'
})
}

