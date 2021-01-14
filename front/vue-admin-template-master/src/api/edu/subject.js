import request from '@/utils/request'

//获取全部课程列表
export function listSubject() {
    return request({
        url: `/edu/subjectService/listSubject`,
        method: 'get'
        })
}


//获取一级课程
export function levelOneSubject(){
    return request({
        url: `/edu/subjectService/levelOneSubject`,
        method: 'get'
    })
}

//根据一级课程获取二级课程
export function levelTwoByLevelOne(id){
    return request({
        url: `/edu/subjectService/levelTwoByLevelOne`,
        method: 'post',
        data : id
    })
}


