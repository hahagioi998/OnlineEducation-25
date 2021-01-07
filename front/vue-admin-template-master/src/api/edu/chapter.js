import request from '@/utils/request'

//获取章节
export function getChapterList(courseId) {
    return request({
        url: `/edu/chapterService/getChapterList?courseId=${courseId}`,
        method: 'get'
        })
}

//更新章节
export function updateChapter(chapter) {
    return request({
        url: `/edu/chapterService/updateChapter`,
        method: 'post',
        data: chapter
        })
}

//删除章节
export function deleteChapter(chapterId) {
    return request({
        url: `/edu/chapterService/deleteChapter?chapterId=${chapterId}`,
        method: 'delete'
        })
}

//添加章节
export function addChapter(chapter) {
    return request({
        url: `/edu/chapterService/addChapter`,
        method: 'post',
        data: chapter
        })
}

//获取章节
export function getChapter(chapterId) {
    return request({
        url: `/edu/chapterService/getChapter?chapterId=${chapterId}`,
        method: 'get'
        })
}