import request from '@/utils/request'


//前台条件分页查询课程
export function queryCByPageOnCondition(current, pageSize, courseVO) {
    return request({
        url: `/edu/courseFrontService/queryCByPageOnCondition?current=${current}&pageSize=${pageSize}`,
        method: 'post',
        data: courseVO
    })
}

//获取一级课程
export function listSubject() {
    return request({
        url: `/edu/subjectService/listSubject`,
        method: 'get'
    })
}

//根据一级课程获取二级课程
export function levelTwoByLevelOne(parentSubjectId) {
    return request({
        url: `/edu/subjectService/levelTwoByLevelOne`,
        method: 'post',
        data: parentSubjectId
    })
}

