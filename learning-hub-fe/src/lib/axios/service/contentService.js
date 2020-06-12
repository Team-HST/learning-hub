import http from '../http';

/**
 * 컨텐츠 관련 API 서비스
 */
export default {
  /**
   * 컨텐츠 페이징 목록 조회
   */
  searchContentPageList: (pageNum, title, jobClass, size=6) => {
    const pageNumReq = pageNum ? (pageNum-1) : 0
    const titleReq = title ? title : ''
    const jobClassReq = jobClass ? jobClass : ''

    return http.get(`/api/contents/search?page=${pageNumReq}&title=${titleReq}&jobClass=${jobClassReq}&size=${size}`)
  }
}