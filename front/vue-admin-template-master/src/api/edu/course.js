import request from '@/utils/request'

//添加课程info
export function insertCourseInfo(courseInfo) {
    return request({
        url: `/edu/courseService/addCourseInfo`,
        method: 'post',
        data: courseInfo
        })
}

//根据课程id获取课程信息
export function getCourseInfoById(courseId) {
    return request({
        url: `/edu/courseService/getCourseInfoById?courseId=${courseId}`,
        method: 'get'
        })
}

//根据课程id更新课程信息
export function updateCourseInfoById(courseInfo) {
    return request({
        url: `/edu/courseService/updateCourseInfoById`,
        method: 'post',
        data: courseInfo
        })
}


