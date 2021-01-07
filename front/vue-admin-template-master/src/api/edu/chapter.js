import request from '@/utils/request'

//获取章节
export function getChapterList(courseId) {
    return request({
        url: `/edu/chapterService/getChapterList?courseId=${courseId}`,
        method: 'get'
        })
}

//更新章节
export function updateChapter(courseId) {
    return request({
        url: `/edu/chapterService/getChapterList?courseId=${courseId}`,
        method: 'get'
        })
}

//删除章节
export function deleteChapter(courseId) {
    return request({
        url: `/edu/chapterService/getChapterList?courseId=${courseId}`,
        method: 'get'
        })
}

//添加章节
export function addChapter(courseId) {
    return request({
        url: `/edu/chapterService/getChapterList?courseId=${courseId}`,
        method: 'get'
        })
}

//获取章节
export function getChapter(courseId) {
    return request({
        url: `/edu/chapterService/getChapterList?courseId=${courseId}`,
        method: 'get'
        })
}