import request from '@/utils/request'

//添加课程info
export function insertCourseInfo(courseInfo) {
    return request({
        url: `/edu/courseService/addCourseInfo`,
        method: 'post',
        data: courseInfo
        })
}


