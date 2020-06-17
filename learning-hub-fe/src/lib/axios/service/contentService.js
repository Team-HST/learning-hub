import http from '../http';

/**
 * 컨텐츠 관련 API 서비스
 */
export default {
  // 컨텐츠 페이징 목록 조회
  searchContentPageList: (pagable, title, jobClass) => {
    const pageNumReq = pagable.pageNum ? (pagable.pageNum - 1) : 0
    const titleReq = title ? title : ''
    const jobClassReq = jobClass ? jobClass : ''

    return http.get(`/api/contents/search?page=${pageNumReq}&title=${titleReq}&jobClass=${jobClassReq}&size=${pagable.size}`)
  },

  // 컨텐츠 상세 정보 조회
  searchContentDetail: (srno) => {
    return http.get(`/api/contents/${srno}`);
  },

  // 컨텐츠 등록
  createContent: (content) => {
    return http.post('/api/contents', content);
  }
}